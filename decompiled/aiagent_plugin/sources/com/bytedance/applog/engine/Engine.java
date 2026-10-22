package com.bytedance.applog.engine;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.collector.NavigatorHelper;
import com.bytedance.applog.e.f;
import com.bytedance.applog.k;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.p;
import com.bytedance.applog.q;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.g;
import com.bytedance.applog.store.h;
import com.bytedance.applog.task.TeaThread;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.applog.util.m;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.as;
import com.bytedance.bdinstall.n;
import com.bytedance.bdinstall.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Engine implements Handler.Callback, Comparator<com.bytedance.applog.store.a> {
    private static final int INTERVAL_PROCESS = 5;
    private static final int MSG_BG_SESSION_TASK = 22;
    private static final int MSG_BG_SESSION_TASK_LIFECYCLE = 23;
    private static final int MSG_CHECK_AB_CONFIG = 13;
    private static final int MSG_CHECK_STATE_READY = 2;
    private static final int MSG_CHECK_WORKER = 6;
    private static final int MSG_CLEAR_ABD_SET_ENV = 21;
    private static final int MSG_CLEAR_WHEN_SWITCH_CHILD_MODE = 18;
    private static final int MSG_DO_APPLOG_MIGRATE = 24;
    private static final int MSG_PROCESS = 4;
    private static final int MSG_PROCESS_CACHE = 10;
    private static final int MSG_RESET_AND_REINSTALL = 20;
    private static final int MSG_RESET_WHEN_SWITCH_CHILD_MODE = 19;
    private static final int MSG_SAVE_REAL_TIME = 8;
    private static final int MSG_SEND_IMMEDIATELY = 14;
    private static final int MSG_SET_UUID = 12;
    private static final int MSG_START_BDINSTALL_SERVICE = 1;
    private static final int MSG_START_NEW_MONITOR = 25;
    private static final int MSG_START_WORK = 3;
    private static final int MSG_TERM = 7;
    private static final int MSG_UPDATE_PACK_SEND_RESULT = 16;
    private static final int MSG_UPDATE_SENDER_WORK = 17;
    private static final long REAL_FAIL_INTERVAL = 60000;
    private static final int STATE_BDINSTALL_ON_LOAD = 2;
    private static final int STATE_BDINSTALL_ON_UPDATE = 4;
    private static final int STATE_DEVICE_HEADER_READY = 8;
    private static final int STATE_START_BDINSTALL_SERVICE = 1;
    private static final int STATE_START_NET_WORK = 16;
    private static final long TERMINATE_IMMEDIATELY_DELAY = 500;
    private static final List<String> logTags = null;
    private final com.bytedance.applog.j.a appLogCache;
    private volatile com.bytedance.applog.task.c bgTaskPresenter;
    private final com.bytedance.applog.e.d handlerEventFilter;
    private final com.bytedance.applog.c mAppLogInst;
    private final com.bytedance.applog.b.d mBDInstallService;
    private final com.bytedance.applog.j.b mConfig;
    private com.bytedance.applog.engine.b mConfiger;
    private final ArrayList<com.bytedance.applog.store.a> mDataList;
    private volatile DbStore mDbStore;
    private final com.bytedance.applog.j.c mDevice;
    private volatile int mEngineState;
    private volatile com.bytedance.applog.e.a mEventFilter;
    private volatile p.a mIpcDataChecker;
    private volatile long mLastFlushTime;
    private volatile Handler mNetHandler;
    private final Looper mNtLooper;
    private long mRealFailTs;
    private List<com.bytedance.applog.engine.a> mSenderList;
    private final e mSession;
    private volatile boolean mStarted;
    private q mUriConfig;
    volatile boolean mUuidChanged;
    private final Handler mWorkHandler;
    private final ArrayList<com.bytedance.applog.engine.a> mWorkers;
    private NavigatorHelper navigatorHelper;
    private volatile f samplingFilter;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        as f5594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CountDownLatch f5596d;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<g> f5597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<g> f5598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5599c;

        public b() {
            this.f5597a = new ArrayList();
            this.f5598b = new ArrayList();
            this.f5599c = false;
        }
    }

    static /* synthetic */ int access$000(Engine r0) {
        return r0.mEngineState;
    }

    static /* synthetic */ int access$002(Engine r0, int r1) {
        r0.mEngineState = r1;
        return r1;
    }

    static /* synthetic */ void access$100(Engine r0, JSONObject r1) {
        r0.onGotHeader(r1);
    }

    static /* synthetic */ List access$200() {
        return logTags;
    }

    static /* synthetic */ com.bytedance.applog.c access$300(Engine r0) {
        return r0.mAppLogInst;
    }

    static /* synthetic */ com.bytedance.applog.j.b access$400(Engine r0) {
        return r0.mConfig;
    }

    static /* synthetic */ void access$500(Engine r2, List r3, com.bytedance.applog.priority.b r4, String[] r5) {
        r2.handleRealTimeEvents((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(com.bytedance.applog.store.a r3, com.bytedance.applog.store.a r4) {
        return compare2((com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin"), (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        logTags = Collections.singletonList("Engine");
    }

    public com.bytedance.applog.c getAppLog() {
        return this.mAppLogInst;
    }

    public e getSession() {
        return this.mSession;
    }

    public String getSessionId() {
        return this.mSession.b();
    }

    public void destroy() {
        if (this.mNetHandler == null) goto L5;
        this.mNetHandler.removeCallbacksAndMessages(null);
        this.mNetHandler.getLooper().quit();
    L5:
        Handler r0 = this.mWorkHandler;
        if (r0 == null) goto L12;
        r0.removeCallbacksAndMessages(null);
        this.mWorkHandler.getLooper().quit();
    L12:
        Thread.sleep(100);     // Catch: InterruptedException -> L11
        return;
    }

    public Engine(com.bytedance.applog.c r4, com.bytedance.applog.j.b r5, com.bytedance.applog.j.c r6, com.bytedance.applog.b.d r7, com.bytedance.applog.d r8, com.bytedance.applog.j.a r9) {
        com.bytedance.applog.b.d r10 = (com.bytedance.applog.b.d) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.applog.b.d.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.d r11 = (com.bytedance.applog.d) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.applog.d.class, "com.obric.aiagent.plugin");
        this.mDataList = new ArrayList(32);
        this.mWorkers = new ArrayList(4);
        this.mEngineState = 0;
        this.mAppLogInst = r4;
        this.mConfig = r5;
        r5.a(this);
        this.mDevice = r6;
        this.appLogCache = r9;
        this.mSession = new e(this);
        this.mBDInstallService = r10;
        this.handlerEventFilter = new com.bytedance.applog.e.d(r4);
        String r12 = getAppLog().b();
        HandlerThread r13 = new HandlerThread("bd_tracker_w:" + r12);
        r13.start();
        Handler r0 = new Handler(r13.getLooper(), this);
        this.mWorkHandler = r0;
        HandlerThread r14 = new HandlerThread("bd_tracker_n:" + r12);
        r14.start();
        Looper r15 = r14.getLooper();
        this.mNtLooper = r15;
        r10.a(r5, getUriConfig().b(), r15, r11);
        this.navigatorHelper = new NavigatorHelper(r4, r15);
        if (r4.aj() <= 0) goto L6;
        this.samplingFilter = f.a(this, com.bytedance.applog.b.a(r4, "sampling_list"));
    L6:
        if (r5.b() == false) goto L8;
        this.mStarted = true;
        r0.sendEmptyMessage(1);
        r0.sendEmptyMessageDelayed(2, 200);
    L8:
        r0.sendEmptyMessage(25);
        r0.sendEmptyMessage(10);
        if (r5.c().K() == null) goto L14;
        if (r5.q() == true) goto L14;
        this.mIpcDataChecker = r5.c().K();
    L14:
        if (getAppLog().ab() == true) goto L16;
        return;
    L16:
        if (com.bytedance.applog.b.a(getAppLog()) == false) goto L20;
        r0.sendEmptyMessageDelayed(24, 10000);
        return;
    }

    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getAppLog().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public DbStore getDbStore() {
        if (this.mDbStore != null) goto L15;
        monitor-enter(this);
        DbStore r0 = this.mDbStore;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new DbStore(this, getConfig().c().E());     // Catch: Throwable -> L11
    L8:
        this.mDbStore = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.mDbStore;
    }

    public long getBackgroundSessionKeepMills() {
        if (getAppLog().ac() == false) goto L6;
        return 500;
    L6:
        return getConfig().r();
    }

    public void onBgSessionTaskResume() {
        Handler r2 = this.mWorkHandler;
        if (r2 == null) goto L6;
        r2.obtainMessage(22, true).sendToTarget();
        return;
    }

    public void onBgSessionTaskPause() {
        Handler r2 = this.mWorkHandler;
        if (r2 == null) goto L6;
        r2.obtainMessage(22, false).sendToTarget();
        return;
    }

    public com.bytedance.applog.j.c getDm() {
        return this.mDevice;
    }

    public void setLanguageAndRegion(String r5, String r6) {
        this.mBDInstallService.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, r6);
        workImmediately(this.mConfiger, 0);
    }

    public void setUriConfig(q r1) {
        this.mUriConfig = r1;
        this.mBDInstallService.a(r1.b());
    }

    public q getUriConfig() {
        if (this.mUriConfig != null) goto L8;
        q r0 = getConfig().c().l();
        this.mUriConfig = r0;
        if (r0 != null) goto L8;
        this.mUriConfig = o.a(0);
    L8:
        return this.mUriConfig;
    }

    public void start() {
        if (this.mStarted == true) goto L6;
        this.mStarted = true;
        this.mWorkHandler.sendEmptyMessage(1);
        this.mWorkHandler.sendEmptyMessageDelayed(2, 200);
        return;
    }

    public int clearDataListIfCacheTooLarge() {
        ArrayList<com.bytedance.applog.store.a> r0 = this.mDataList;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mDataList.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return 0;
    L8:
        long r3 = 0;
        Iterator<com.bytedance.applog.store.a> r1 = this.mDataList.iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L13;
        r3 = r3 + ((com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin")).i();     // Catch: Throwable -> L19
        goto L10
    L13:
        if (r3 >= 1048576) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return 0;
    L16:
        int r2 = this.mDataList.size();     // Catch: Throwable -> L19
        getAppLog().Z().a(logTags, "force clear data list with state={} and mDataList={} size={} and stack: ", new Throwable(), new Object[]{Integer.valueOf(this.mEngineState), Integer.valueOf(r2), Long.valueOf(r3)});     // Catch: Throwable -> L19
        getAppLog().N().sendError("force clear engine data list", new Throwable("state=" + this.mEngineState + ", len=" + r2 + ", totalSize=" + r3));     // Catch: Throwable -> L19
        this.mDataList.clear();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (r10.what == 1) goto L6;
        BlockHelper.tryBlock();
    L6:
        switch(r10.what) {
            case 1: goto L92;
            case 2: goto L79;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L7;
            case 6: goto L54;
            case 7: goto L46;
            case 8: goto L39;
            case 9: goto L7;
            case 10: goto L31;
            case 11: goto L7;
            case 12: goto L30;
            case 13: goto L7;
            case 14: goto L29;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L28;
            case 18: goto L25;
            case 19: goto L22;
            case 20: goto L19;
            case 21: goto L16;
            case 22: goto L14;
            case 23: goto L11;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L7;
        };
    L7:
        getAppLog().Z().c(logTags, "Not support message type", new Object[0]);
    L96:
        return true;
    L8:
        initNewMonitor();
        goto L96
    L9:
        com.bytedance.applog.adaptor.a.a(getAppLog(), getDbStore());
        com.bytedance.applog.adaptor.a.b(getAppLog(), getDbStore());
        com.bytedance.applog.adaptor.a.c(getAppLog(), getDbStore());
        goto L96
    L16:
        a r11 = (a) ZeusTransformUtils.preCheckCast(r10.obj, a.class, "com.obric.aiagent.plugin");
        doClearAndSetEnv();
        if (r11.f5596d == null) goto L96;
        r11.f5596d.countDown();
        goto L96
    L19:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r10.obj, a.class, "com.obric.aiagent.plugin");
        doResetAndReInstall(r12.f5595c, r12.f5594b);
        if (r12.f5596d == null) goto L96;
        r12.f5596d.countDown();
        goto L96
    L22:
        a r13 = (a) ZeusTransformUtils.preCheckCast(r10.obj, a.class, "com.obric.aiagent.plugin");
        doResetWhenSwitchChildMode(r13.f5593a, r13.f5595c, r13.f5594b);
        if (r13.f5596d == null) goto L96;
        r13.f5596d.countDown();
        goto L96
    L25:
        a r14 = (a) ZeusTransformUtils.preCheckCast(r10.obj, a.class, "com.obric.aiagent.plugin");
        doClearWhenSwitchChildMode(r14.f5593a);
        if (r14.f5596d == null) goto L96;
        r14.f5596d.countDown();
        goto L96
    L28:
        getAppLog().Z().a(logTags, "Start to update sender workers...", new Object[0]);
        this.mWorkers.removeAll(this.mSenderList);
        List<com.bytedance.applog.engine.a> r15 = getSenderList();
        this.mSenderList = r15;
        this.mWorkers.addAll(0, r15);
        goto L96
    L29:
        process(null, true);
        goto L96
    L30:
        Object[] r16 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r10.obj, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
        switchSessionAndSetUuid((String) ZeusTransformUtils.preCheckCast(r16[0], String.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.preCheckCast(r16[1], h.class, "com.obric.aiagent.plugin"));
        goto L96
    L31:
        ArrayList<com.bytedance.applog.store.a> r0 = this.mDataList;
        monitor-enter(r0);
        int r17 = this.appLogCache.a(this.mDataList);     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        getAppLog().Z().b(logTags, "dump cache data count: {}", new Object[]{Integer.valueOf(r17)});
        process(this.appLogCache.a(), false);
    L36:
        th = move-exception;
        throw th;
    L39:
        ArrayList<com.bytedance.applog.store.a> r18 = (ArrayList) ZeusTransformUtils.preCheckCast(r10.obj, ArrayList.class, "com.obric.aiagent.plugin");
        Iterator<com.bytedance.applog.store.a> r1 = r18.iterator();
    L41:
        if (r1.hasNext() == false) goto L45;
        com.bytedance.applog.store.a r2 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r2.o() != 0) goto L41;
        r2.a(-1);
        goto L41
    L45:
        getDbStore().a(r18);
        goto L96
    L46:
        getAppLog().Z().b(logTags, "Terminate created", new Object[0]);
        ArrayList<com.bytedance.applog.store.a> r3 = this.mDataList;
        monitor-enter(r3);
        this.mDataList.add(e.i());     // Catch: Throwable -> L51
        monitor-exit(r3);     // Catch: Throwable -> L51
        process(null, false);
    L51:
        th = move-exception;
        throw th;
    L54:
        this.mNetHandler.removeMessages(6);
        getAppLog().Z().b(logTags, "start to check worker to do...", new Object[0]);
        long r5 = this.mConfig.s();
        if (this.mConfig.c().A() == true) goto L57;
    L58:
        long r6 = Long.MAX_VALUE;
        Iterator<com.bytedance.applog.engine.a> r4 = this.mWorkers.iterator();
    L60:
        if (r4.hasNext() == false) goto L66;
        com.bytedance.applog.engine.a r7 = (com.bytedance.applog.engine.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.engine.a.class, "com.obric.aiagent.plugin");
        if (r7.a() == true) goto L60;
        long r8 = r7.a(r10.arg1);
        if (r8 >= r6) goto L60;
        r6 = r8;
        goto L60
    L66:
        r5 = r6 - System.currentTimeMillis();
    L67:
        Message r19 = this.mNetHandler.obtainMessage(6);
        r19.arg1 = 2;
        this.mNetHandler.sendMessageDelayed(r19, Math.max(r5, 100));
        goto L96
    L57:
        if (this.mSession.f() == false) goto L67;
    L68:
        process((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r10.obj, String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin"), false);
        goto L96
    L69:
        this.mEngineState |= 16;
        if (getAppLog().M() == false) goto L72;
        com.bytedance.applog.d.a.a().a(new AnonymousClass2(this));
    L72:
        this.mConfig.a();
        if (TextUtils.isEmpty(getUriConfig().e()) == true) goto L75;
        com.bytedance.applog.engine.b r110 = new com.bytedance.applog.engine.b(this);
        this.mConfiger = r110;
        this.mWorkers.add(r110);
    L75:
        List<com.bytedance.applog.engine.a> r111 = getSenderList();
        this.mSenderList = r111;
        this.mWorkers.addAll(r111);
        getAppLog().Z().b(logTags, "{} workers prepared", new Object[]{Integer.valueOf(this.mWorkers.size())});
        checkAppUpdate();
        initPriority3();
        this.mNetHandler.removeMessages(6);
        this.mNetHandler.sendEmptyMessage(6);
        if (l.a() == true) goto L96;
        l.a("start_end", new AnonymousClass3(this));
        goto L96
    L92:
        this.mEngineState |= 1;
        if (this.mConfig.q() == false) goto L95;
        this.mBDInstallService.g();
        this.mBDInstallService.a(new AnonymousClass1(this));
    L95:
        com.bytedance.applog.log.f r112 = getAppLog().Z();
        List<String> r9 = logTags;
        r112.a(r9, "start bdinstall service begin", new Object[0]);
        this.mBDInstallService.a();
        getAppLog().Z().a(r9, "start bdinstall service end", new Object[0]);
        goto L96
    L11:
        if (ZeusTransformUtils.instanceOf(r10.obj, h.class) == false) goto L96;
        handleBgSessionTaskPage((h) ZeusTransformUtils.preCheckCast(r10.obj, h.class, "com.obric.aiagent.plugin"));
        goto L96
    L14:
        if (ZeusTransformUtils.instanceOf(r10.obj, Boolean.class) == false) goto L96;
        handleBgSessionTask(((Boolean) ZeusTransformUtils.preCheckCast(r10.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L96
    L79:
        if (this.mConfig.q() == false) goto L96;
        if (this.mDevice.i() == false) goto L86;
        this.mEngineState |= 8;
        this.mNetHandler = new Handler(this.mNtLooper, this);
        this.mNetHandler.sendEmptyMessage(3);
        if (this.mDataList.size() <= 0) goto L85;
        this.mWorkHandler.removeMessages(4);
        this.mWorkHandler.sendEmptyMessageDelayed(4, 1000);
    L85:
        getAppLog().Z().a(logTags, "net handler start work", new Object[0]);
        goto L96
    L86:
        this.mWorkHandler.removeMessages(2);
        JSONObject r113 = new JSONObject();
        if (this.mBDInstallService.a(r113) == true) goto L89;
    L91:
        this.mWorkHandler.sendEmptyMessageDelayed(2, 1000);
        goto L96
    L89:
        if (this.mDevice.a(r113) == false) goto L91;
        this.mDevice.b(r113);
        this.mWorkHandler.sendEmptyMessage(2);
        goto L96
    }

    public com.bytedance.applog.task.c getBgTaskPresenter() {
        if (this.bgTaskPresenter != null) goto L15;
        monitor-enter(this);
        com.bytedance.applog.task.c r0 = this.bgTaskPresenter;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new com.bytedance.applog.task.c(getAppLog(), getDbStore(), this.mDevice);     // Catch: Throwable -> L11
    L8:
        this.bgTaskPresenter = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.bgTaskPresenter;
    }

    private void handleBgSessionTask(boolean r4) {
        if (getAppLog().E() == true) goto L6;
        getAppLog().Z().a(logTags, "[Task] Background session task is not enabled, isResume = {} will not work!", new Object[]{Boolean.valueOf(r4)});
        return;
    L6:
        com.bytedance.applog.task.c r3 = getBgTaskPresenter();
        if (r4 == false) goto L9;
        r3.a();
        return;
    L9:
        r3.b();
    }

    private void handleBgSessionTaskPage(h r3) {
        if (getAppLog().E() == true) goto L5;
        return;
    L5:
        com.bytedance.applog.task.c r2 = getBgTaskPresenter();
        if (r3.r() == false) goto L8;
        r2.a(r3.f5992b, r3.f5994d);
        return;
    L8:
        r2.b(r3.f5992b, r3.f5994d);
    }

    private void onGotHeader(JSONObject r2) {
        this.mDevice.b(r2);
        if ((this.mEngineState & 8) != 0) goto L6;
        this.mWorkHandler.removeMessages(2);
        this.mWorkHandler.sendEmptyMessage(2);
        return;
    }

    private List<com.bytedance.applog.engine.a> getSenderList() {
        ArrayList r0 = new ArrayList();
        com.bytedance.applog.priority.a r1 = this.mConfig.x();
        if (r1 != null) goto L5;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L18;
        r0.add(new d(this));
    L18:
        com.bytedance.applog.f.a r3 = this.mConfig.D();
        if (r3 != null) goto L21;
    L23:
        return r0;
    L21:
        if (r3.g() == false) goto L23;
        r0.add(new c(this, r3));
        goto L23
    L5:
        if (r1.d() == false) goto L15;
        Iterator<com.bytedance.applog.priority.b> r4 = r1.e().values().iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        com.bytedance.applog.priority.b r5 = (com.bytedance.applog.priority.b) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.priority.b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        if (r5.a() == 0) goto L8;
        r0.add(new d(this, r5));
        goto L8
    L14:
        r2 = true;
        goto L16
    }

    public void process(String[] r10, boolean r11) {
        ArrayList<com.bytedance.applog.store.a> r0 = this.mDataList;
        monitor-enter(r0);
        ArrayList<com.bytedance.applog.store.a> r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.mDataList.clone(), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L76
        this.mDataList.clear();     // Catch: Throwable -> L76
        monitor-exit(r0);     // Catch: Throwable -> L76
        Iterator<com.bytedance.applog.store.a> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.applog.store.a r3 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r3.s <= 0) goto L8;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.j, r3);
        goto L8
    L13:
        if (r10 == null) goto L28;
        r1.ensureCapacity(r1.size() + r10.length);
        int r4 = r10.length;
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L28;
        com.bytedance.applog.store.a r6 = com.bytedance.applog.store.a.b(r10[r5]);
        if (r6 == null) goto L27;
        if (com.bytedance.applog.util.p.a(r6.b()) == true) goto L22;
    L24:
        r1.add(r6);
        if (r6.s <= 0) goto L27;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.j, r6);
        goto L27
    L22:
        if (com.bytedance.applog.util.p.a(getAppLog().b(), r6.b()) == true) goto L24;
    L27:
        r5 = r5 + 1;
    L28:
        notifyEventObserverBeforeProcess(r1);
        if (this.mAppLogInst.x() == true) goto L31;
    L39:
        filterEvent(r1);
        filterEventParams(r1);
        Iterator<com.bytedance.applog.store.a> r12 = r1.iterator();
    L41:
        if (r12.hasNext() == false) goto L46;
        com.bytedance.applog.store.a r7 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r7.s <= 0) goto L41;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.q, r7);
        goto L41
    L46:
        if (r1.isEmpty() == false) goto L48;
    L64:
        if (r11 == true) goto L66;
        return;
    L66:
        if (this.mConfig.q() == true) goto L68;
        return;
    L68:
        if (this.mConfig.i() == false) goto L106;
        long r13 = System.currentTimeMillis();
        if (Math.abs(r13 - this.mLastFlushTime) <= 10000) goto L73;
        this.mLastFlushTime = r13;
        workImmediately(this.mSenderList, 4);
    L73:
        if (getAppLog().ar() == null) goto L107;
        getAppLog().ar().b();
        return;
    L107:
        return;
    L106:
        return;
    L48:
        if (this.mConfig.q() == false) goto L50;
        saveAndSend(r1);
        goto L64
    L50:
        Intent r14 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Collector.class);
        int r8 = r1.size();
        String[] r9 = new String[r8];
        int r15 = 0;
        int r16 = 0;
    L51:
        if (r15 >= r8) goto L53;
        r9[r15] = ((com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r1.get(r15), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin")).j().toString();
        r16 = r16 + r9[r15].length();
        r15 = r15 + 1;
        goto L51
    L53:
        boolean r17 = true;
        if (r16 >= 307200) goto L56;
    L62:
        if (r17 == false) goto L64;
        r14.putExtra("K_DATA", r9);
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).sendBroadcast(r14);
        goto L64
    L56:
        if (this.mIpcDataChecker == null) goto L62;
        r17 = this.mIpcDataChecker.a(r9);     // Catch: Throwable -> L59
    L61:
        getAppLog().Z().d(logTags, "IPC over 300k", new Object[0]);
    L59:
        th = move-exception;
        getAppLog().Z().c(logTags, "check ipc data", new Object[]{th});
        goto L61
    L31:
        if (this.mAppLogInst.y() == true) goto L39;
        getAppLog().Z().a(logTags, "not process events in tourist mode.", new Object[0]);
        Iterator<com.bytedance.applog.store.a> r18 = r1.iterator();
    L34:
        if (r18.hasNext() == false) goto L38;
        com.bytedance.applog.store.a r19 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r18.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r19.s <= 0) goto L34;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.k, r19);
        goto L34
    L38:
        return;
    L76:
        th = move-exception;
        throw th;
    }

    private void notifyEventObserverBeforeProcess(List<com.bytedance.applog.store.a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if (getAppLog().S().a(2) == false) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L21;
        com.bytedance.applog.store.a r0 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.store.b.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.store.d.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.store.c.class) == false) goto L7;
        com.bytedance.applog.store.c r1 = (com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        getAppLog().S().b(2, r1.r(), r1.n());     // Catch: Throwable -> L19
        goto L7
    L14:
        com.bytedance.applog.store.d r2 = (com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        getAppLog().S().a(2, r2.s(), r2.n());     // Catch: Throwable -> L19
        goto L7
    L11:
        com.bytedance.applog.store.b r3 = (com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        getAppLog().S().a(2, r3.u, r3.v, r3.w, r3.y, r3.z, r3.x);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        getAppLog().Z().a(4, "notify event observer before process failed", th, new Object[0]);
        getAppLog().N().sendError("notify event observer before process failed", th);
        goto L7
    }

    private void saveAndSend(ArrayList<com.bytedance.applog.store.a> r15) {
        Iterator<com.bytedance.applog.store.a> r0 = r15.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.bytedance.applog.store.a r1 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r1.s <= 0) goto L8;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.r, r1);
    L8:
        com.bytedance.applog.monitor.c.a(r1);
        goto L4
    L9:
        Collections.sort(r15, this);
        ArrayList<com.bytedance.applog.store.a> r2 = new ArrayList(r15.size());
        com.bytedance.applog.priority.a r3 = this.mConfig.x();
        Iterator<com.bytedance.applog.store.a> r4 = r15.iterator();
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
    L10:
        int r10 = 1;
        if (r4.hasNext() == false) goto L38;
        com.bytedance.applog.store.a r9 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        boolean r11 = this.mSession.a(r9, r2);
        boolean r12 = e.a(r9);
        if (r11 == false) goto L17;
        if (r12 == false) goto L17;
        r7 = true;
    L17:
        if (ZeusTransformUtils.instanceOf(r9, h.class) == false) goto L23;
        if (getAppLog().E() == false) goto L21;
        this.mWorkHandler.obtainMessage(23, r9).sendToTarget();
    L21:
        r5 = true;
        r6 = r12;
    L34:
        if (r9.s <= 0) goto L10;
        if (com.bytedance.applog.monitor.c.b(getAppLog().N(), r9) == true) goto L10;
        r9.s = 0;
        goto L10
    L23:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.applog.store.d.class) == false) goto L26;
        com.bytedance.applog.store.d r13 = (com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r9, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin");
        r13.a(r3);
        handleEventForward(r13, r2);
        getAppLog().N().increaseStats(j.f5828e);
        goto L34
    L26:
        if (ZeusTransformUtils.instanceOf(r9, e.a.class) == false) goto L29;
        r8 = true;
        goto L34
    L29:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.applog.store.b.class) == false) goto L31;
    L32:
        getAppLog().N().increaseStats(j.f5828e);
        goto L34
    L31:
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.applog.store.c.class) == false) goto L34;
    L38:
        bypassToEventSender(r2);
        Iterator<com.bytedance.applog.store.a> r16 = r15.iterator();
    L40:
        if (r16.hasNext() == false) goto L45;
        com.bytedance.applog.store.a r14 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r16.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r14.s <= 0) goto L40;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.s, r14);
        goto L40
    L45:
        if (getAppLog().ar() == null) goto L53;
        Iterator<com.bytedance.applog.store.a> r17 = r2.iterator();
    L48:
        if (r17.hasNext() == false) goto L53;
        com.bytedance.applog.store.a r18 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        boolean r19 = getAppLog().ar().a(com.bytedance.applog.util.p.a(r18).a(), r18.k());
        if (r19 == false) goto L52;
        r17.remove();
    L52:
        getAppLog().Z().b(4, "event: {} is saved: {} into priority core.", new Object[]{r18.toString(), Boolean.valueOf(r19)});
    L53:
        filterRealEvent(r2);
        getDbStore().a(r2);
        if (r5 == true) goto L56;
    L59:
        if (r7 == true) goto L65;
        if (r8 == true) goto L65;
        if (this.mNetHandler == null) goto L94;
        this.mNetHandler.removeMessages(6);
        Message r110 = this.mNetHandler.obtainMessage(6);
        r110.arg1 = 2;
        this.mNetHandler.sendMessage(r110);
        return;
    L94:
        return;
    L65:
        if (r7 == true) goto L68;
        r10 = 3;
    L68:
        workImmediately(this.mSenderList, r10);
        List<com.bytedance.applog.engine.a> r111 = this.mSenderList;
        if (r111 != null) goto L71;
        return;
    L71:
        if (r111.isEmpty() == false) goto L73;
        return;
    L73:
        if ((this.mEngineState & 2) != 0) goto L98;
        getAppLog().Z().d(logTags, "bdinstall lost header callback", new Object[0]);
        Bundle r112 = new Bundle();
        r112.putInt("engine_state", this.mEngineState);
        this.mAppLogInst.a("bdinstall_lost_callback", r112);
        return;
    L98:
        return;
    L56:
        if (r6 == false) goto L58;
        this.mWorkHandler.removeMessages(7);
        goto L59
    L58:
        this.mWorkHandler.sendEmptyMessageDelayed(7, getBackgroundSessionKeepMills());
        goto L59
    }

    private void handleEventForward(com.bytedance.applog.store.d r5, ArrayList<com.bytedance.applog.store.a> r6) {
        if (this.mConfig.D() != null) goto L5;
        return;
    L5:
        if (this.mConfig.D().g() == false) goto L11;
        com.bytedance.applog.f.a r0 = this.mConfig.D();
        String r1 = r5.s();
        if (r0.d(r1) == false) goto L12;
        getAppLog().Z().b(4, "Event: {} is match forward...", new Object[]{r1});
        r6.add(com.bytedance.applog.store.e.a(r5));
        return;
    L12:
        return;
    }

    private void filterRealEvent(List<com.bytedance.applog.store.a> r8) {
        List<com.bytedance.applog.store.a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (com.bytedance.applog.a.b.g == true) goto L10;
        if ((System.currentTimeMillis() - this.mRealFailTs) >= REAL_FAIL_INTERVAL) goto L10;
        r2 = false;
    L10:
        if (this.mDevice.i() == false) goto L23;
        if (r2 == false) goto L23;
        final ArrayList<com.bytedance.applog.store.a> r10 = this.mConfig.a(r9);
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.isEmpty() == true) goto L40;
        Iterator<com.bytedance.applog.store.a> r0 = r10.iterator();
    L18:
        if (r0.hasNext() == false) goto L22;
        com.bytedance.applog.store.a r3 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r3.s <= 0) goto L18;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.t, r3);
        goto L18
    L22:
        TeaThread.getInst().post(new AnonymousClass4(this, r10));
        getAppLog().N().increaseStats(j.p, r10.size());
        return;
    L40:
        return;
    L23:
        Iterator<com.bytedance.applog.store.a> r7 = r9.iterator();
    L25:
        if (r7.hasNext() == false) goto L42;
        com.bytedance.applog.store.a r11 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r11.o() != 0) goto L25;
        r11.a(-1);
        goto L25
    }

    private void workImmediately(com.bytedance.applog.engine.a r3, int r4) {
        if (this.mNetHandler == null) goto L12;
        if (r3 == null) goto L13;
        r3.g();
        if (Looper.myLooper() == this.mNetHandler.getLooper()) goto L8;
        this.mNetHandler.removeMessages(6);
        Message r5 = this.mNetHandler.obtainMessage(6);
        r5.arg1 = r4;
        this.mNetHandler.sendMessage(r5);
        return;
    L8:
        if (r3.a() == true) goto L14;
        r3.a(r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void workImmediately(List<? extends com.bytedance.applog.engine.a> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L12;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        workImmediately((com.bytedance.applog.engine.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.engine.a.class, "com.obric.aiagent.plugin"), r5);
        goto L8
    L13:
        return;
    }

    public void receive(com.bytedance.applog.store.a r7) {
        if (r7.f5992b != 0) goto L5;
        getAppLog().Z().d(logTags, "receive zero ts", new Object[0]);
    L5:
        ArrayList<com.bytedance.applog.store.a> r0 = this.mDataList;
        monitor-enter(r0);
        int r1 = this.mDataList.size();     // Catch: Throwable -> L37
        this.mDataList.add(r7);     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        if (r7.s <= 0) goto L12;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.h, r7);
    L12:
        boolean r2 = ZeusTransformUtils.instanceOf(r7, h.class);
        if (getAppLog().M() == false) goto L23;
        if (r2 == false) goto L16;
    L21:
        this.mWorkHandler.removeMessages(4);
        this.mWorkHandler.sendEmptyMessage(4);
    L32:
        if (r7.s <= 0) goto L34;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.i, r7);
    L34:
        if (r2 == false) goto L42;
        this.navigatorHelper.onPageReceived((h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin"));
        return;
    L42:
        return;
    L16:
        if (((r1 + 1) % getAppLog().O()) == 0) goto L21;
        if (this.mWorkHandler.hasMessages(4) == true) goto L32;
        this.mWorkHandler.sendEmptyMessageDelayed(4, getAppLog().P());
        goto L32
    L23:
        if ((r1 % 5) == 0) goto L25;
        if (r2 == false) goto L32;
    L25:
        this.mWorkHandler.removeMessages(4);
        if (r1 != 0) goto L30;
        if (r2 == true) goto L30;
        this.mWorkHandler.sendEmptyMessageDelayed(4, 200);
    L30:
        this.mWorkHandler.sendEmptyMessage(4);
    L37:
        th = move-exception;
        throw th;
    }

    public void receive(String[] r3) {
        this.mWorkHandler.removeMessages(4);
        this.mWorkHandler.obtainMessage(4, r3).sendToTarget();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(com.bytedance.applog.store.a r3, com.bytedance.applog.store.a r4) {
        long r2 = r3.f5992b - r4.f5992b;
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        if (r2 <= 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    public com.bytedance.applog.j.b getConfig() {
        return this.mConfig;
    }

    private void bypassToEventSender(ArrayList<com.bytedance.applog.store.a> r4) {
        if (com.bytedance.applog.util.h.a(this.mAppLogInst.b()) == false) goto L13;
        Iterator<com.bytedance.applog.store.a> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L21;
        com.bytedance.applog.store.a r0 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.store.e.class) == true) goto L6;
        String r1 = com.bytedance.applog.util.h.getType(r0);
        if (r1 == null) goto L6;
        JSONArray r2 = new JSONArray();
        r2.put(r0.k());
        com.bytedance.applog.util.h.a(this.mAppLogInst.b(), r1, r2);
        goto L6
    L21:
        return;
    }

    public void setUserUniqueId(String r3) {
        String r0 = this.mDevice.d();
        if (TextUtils.isEmpty(r3) == false) goto L7;
        if (TextUtils.isEmpty(r0) == true) goto L7;
    L10:
        doSetUuid(r3);
    L11:
        this.mDevice.a(r3);
        return;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (TextUtils.equals(r3, r0) == true) goto L11;
        goto L10
    }

    public boolean isEventAndParamsHitStickySamplingDrop(String r2, JSONObject r3) {
        if (this.samplingFilter != null) goto L5;
        return false;
    L5:
        if (getAppLog().aj() != 0) goto L8;
        return false;
    L8:
        return this.samplingFilter.a(r2, r3);
    }

    private void switchSessionAndSetUuid(String r11, h r12) {
        workImmediately(this.mSenderList, 10);
        if (r12 != null) goto L7;
        r12 = getAppLog().W();
        if (r12 == null) goto L7;
        r12 = (h) ZeusTransformUtils.preCheckCast(r12.l(), h.class, "com.obric.aiagent.plugin");
    L7:
        ArrayList<com.bytedance.applog.store.a> r2 = new ArrayList();
        long r3 = System.currentTimeMillis();
        if (r12 == null) goto L14;
        long r5 = r3 - r12.f5992b;
        r12.a(r3);
        if (r5 >= 0) goto L13;
        r5 = 0;
    L13:
        r12.u = r5;
        r12.y = this.mSession.c();
        this.mSession.b(r12);
        r2.add(r12);
    L14:
        doSetUuid(r11);
        if (r12 == null) goto L21;
        h r13 = (h) ZeusTransformUtils.preCheckCast(r12.l(), h.class, "com.obric.aiagent.plugin");
        r13.a(r3 + 1);
        r13.u = -1;
        com.bytedance.applog.store.f r14 = this.mSession.a(r13, r2, true);
        if (r14 == null) goto L19;
        r14.x = this.mSession.c();
    L19:
        this.mSession.b(r13);
        r2.add(r13);
    L21:
        if (r2.isEmpty() == true) goto L23;
        getDbStore().a(r2);
    L23:
        workImmediately(this.mSenderList, 10);
    }

    private void doSetUuid(String r4) {
        this.mBDInstallService.a((Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r4);
    }

    public void setEventFilter(com.bytedance.applog.e.a r1) {
        this.mEventFilter = r1;
    }

    public void sendImmediately() {
        this.mWorkHandler.removeMessages(14);
        this.mWorkHandler.sendEmptyMessage(14);
    }

    private void filterEvent(ArrayList<com.bytedance.applog.store.a> r3) {
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        filterByAbsEventFilter(r3, this.handlerEventFilter, com.bytedance.applog.monitor.v3.a.n);
        com.bytedance.applog.e.a r0 = getAppLog().t();
        if (r0 == null) goto L9;
        filterByAbsEventFilter(r3, r0, com.bytedance.applog.monitor.v3.a.l);
    L9:
        if (getConfig().c().J() == false) goto L14;
        if (this.mEventFilter == null) goto L14;
        filterByAbsEventFilter(r3, this.mEventFilter, com.bytedance.applog.monitor.v3.a.l);
    L14:
        if (this.samplingFilter != null) goto L16;
    L18:
        this.mConfig.a(r3);
        return;
    L16:
        if (getAppLog().aj() <= 0) goto L18;
        filterByAbsEventFilter(r3, this.samplingFilter, com.bytedance.applog.monitor.v3.a.o);
        goto L18
    }

    private void filterByAbsEventFilter(ArrayList<com.bytedance.applog.store.a> r11, com.bytedance.applog.e.e r12, com.bytedance.applog.monitor.v3.a r13) {
        com.bytedance.applog.e.e r14 = (com.bytedance.applog.e.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.applog.e.e.class, "com.obric.aiagent.plugin");
        if (r14.a() == false) goto L5;
        return;
    L5:
        Iterator<com.bytedance.applog.store.a> r15 = r11.iterator();
    L7:
        if (r15.hasNext() == false) goto L17;
        com.bytedance.applog.store.a r3 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r15.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.store.d.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.store.b.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.store.c.class) == false) goto L7;
        com.bytedance.applog.store.c r0 = (com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin");
        tryFilterEvent(r3, r15, r14, com.bytedance.applog.monitor.b.f5760d, r13, "log_data", r0.n());
        goto L7
    L13:
        com.bytedance.applog.store.b r1 = (com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin");
        tryFilterEvent(r3, r15, r14, com.bytedance.applog.monitor.b.f5758b, r13, r1.v, r1.x);
        goto L7
    L10:
        com.bytedance.applog.store.d r2 = (com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin");
        String r8 = r2.s();
        String r9 = r2.n();
        tryFilterEvent(r3, r15, r14, com.bytedance.applog.monitor.b.f5759c, r13, r8, r9);
        goto L7
    }

    private void tryFilterEvent(com.bytedance.applog.store.a r3, Iterator<com.bytedance.applog.store.a> r4, com.bytedance.applog.e.e r5, com.bytedance.applog.monitor.b r6, com.bytedance.applog.monitor.v3.a r7, String r8, String r9) {
        Iterator r10 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.e.e r11 = (com.bytedance.applog.e.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.applog.e.e.class, "com.obric.aiagent.plugin");
        if (r11.a(r6, r8, r9) == false) goto L13;
        r10.remove();
        if (r3.s <= 0) goto L7;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), r7, r3);
    L7:
        getAppLog().N().increaseStats(j.n);
        if (ZeusTransformUtils.instanceOf(r11, f.class) == false) goto L10;
        getAppLog().N().increaseStats(j.o);
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.a.e.f5748e, r3.m());
    L11:
        getAppLog().Z().b(logTags, "event:{} is match filter:{} drop!", new Object[]{r8, r11});
        return;
    L10:
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.a.e.f5747d, r3.m());
        goto L11
    }

    private void filterEventParams(List<com.bytedance.applog.store.a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if (getAppLog().ap() == true) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L34;
        com.bytedance.applog.store.a r0 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.store.d.class) == false) goto L7;
        String r2 = ((com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin")).s();
        if (this.mConfig.b(r2) == false) goto L7;
        String r3 = ((com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin")).n();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        JSONObject r7 = new JSONObject(r3);     // Catch: Throwable -> L32
        Iterator<String> r4 = r7.keys();     // Catch: Throwable -> L32
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L32
    L19:
        if (r4.hasNext() == false) goto L24;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (this.mConfig.a(r2, r9) == true) goto L19;
        r8.add(r9);     // Catch: Throwable -> L32
        goto L19
    L24:
        if (r8.isEmpty() == true) goto L7;
        Iterator r5 = r8.iterator();     // Catch: Throwable -> L32
    L28:
        if (r5.hasNext() == false) goto L30;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        r7.remove(r10);     // Catch: Throwable -> L32
        getAppLog().Z().b(logTags, "event v3:{}, param:{} has been removed for server control", new Object[]{r2, r10});     // Catch: Throwable -> L32
        goto L28
    L30:
        getAppLog().N().increaseStats(j.T, r8.size());     // Catch: Throwable -> L32
        ((com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin")).c(r7.toString());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        getAppLog().Z().b(logTags, "parse event v3:{} params to json failed ", new Object[]{r2, th});
        goto L7
    }

    private void checkAppUpdate() {
        if (this.mDevice.g() == this.mDevice.b()) goto L5;
    L10:
        com.bytedance.applog.engine.b r0 = this.mConfiger;
        if (r0 == null) goto L14;
        r0.g();
    L14:
        if (getConfig().c().J() == false) goto L19;
        setEventFilter(com.bytedance.applog.e.a.a(getAppLog(), com.bytedance.applog.b.a(getAppLog(), "sp_filter_name"), null));
        return;
    L19:
        return;
    L5:
        if (TextUtils.equals(this.mConfig.n(), this.mConfig.m()) == false) goto L10;
        if (getConfig().c().J() == false) goto L17;
        setEventFilter(com.bytedance.applog.e.a.a(getAppLog(), com.bytedance.applog.b.a(getAppLog(), "sp_filter_name")));
        return;
    }

    public f getEventSampling() {
        return this.samplingFilter;
    }

    public void setEventSampling(f r1) {
        this.samplingFilter = r1;
    }

    public void tryUpdateSenders() {
        if (this.mNetHandler == null) goto L6;
        this.mNetHandler.sendEmptyMessage(17);
        return;
    }

    public void tryUpdateCongestionMaxRequestFrequency(com.bytedance.applog.priority.b r4, int r5) {
        List<com.bytedance.applog.engine.a> r0 = this.mSenderList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L18;
        Iterator<com.bytedance.applog.engine.a> r3 = this.mSenderList.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        com.bytedance.applog.engine.a r1 = (com.bytedance.applog.engine.a) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.engine.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L8;
        ((d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L8
    L19:
        return;
    }

    public void clearWhenSwitchChildMode(boolean r7) {
        clearOrResetWhenSwitchChildMode(r7, 18, 0, null);
    }

    public void resetDidWhenSwitchChildMode(boolean r7, long r8, as r10) {
        clearOrResetWhenSwitchChildMode(r7, 19, r8, (as) ZeusTransformUtils.wrapperContextForParams(r10, as.class, "com.obric.aiagent.plugin"));
    }

    public void clearAndSetEnv() {
        clearOrResetWhenSwitchChildMode(false, 21, 0, null);
    }

    public void resetAndReInstall(long r7, as r9) {
        clearOrResetWhenSwitchChildMode(false, 20, r7, (as) ZeusTransformUtils.wrapperContextForParams(r9, as.class, "com.obric.aiagent.plugin"));
    }

    public void forceTimeoutReportSync(long r16) {
        if (this.mSenderList != null) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis();
        Iterator<com.bytedance.applog.engine.a> r4 = this.mSenderList.iterator();
        long r5 = r16;
    L7:
        if (r4.hasNext() == false) goto L22;
        com.bytedance.applog.engine.a r0 = (com.bytedance.applog.engine.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.engine.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if (r5 <= 0) goto L23;
        r7.a(r5);
    L23:
        r7.b(12);     // Catch: Throwable -> L16
    L18:
        r7.a(0);
        if (r16 <= 0) goto L7;
        r5 = r16 - (System.currentTimeMillis() - r2);
        if (r5 > 0) goto L7;
        return;
    L16:
        th = move-exception;
        getAppLog().Z().d(logTags, "force report by sender:{} failed", new Object[]{r7.f(), th});
        goto L18
    }

    private void initPriority3() {
        if (getAppLog().ar() == null) goto L6;
        getAppLog().ar().a();
        return;
    }

    private void clearOrResetWhenSwitchChildMode(boolean r4, int r5, long r6, as r8) {
        as r9 = (as) ZeusTransformUtils.wrapperContextForParams(r8, as.class, "com.obric.aiagent.plugin");
        CountDownLatch r0 = new CountDownLatch(1);
        Message r7 = this.mWorkHandler.obtainMessage(r5);
        a r1 = new a(null);
        r1.f5593a = r4;
        r1.f5594b = r9;
        r1.f5595c = r6;
        r1.f5596d = r0;
        r7.obj = r1;
        this.mWorkHandler.sendMessage(r7);
        r0.await();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        getAppLog().Z().a(logTags, "clearOrResetWhenSwitchChildMode interrupted", e, new Object[0]);
    }

    private void doClearWhenSwitchChildMode(boolean r5) {
        u r0 = getUriConfig().b();
        u r1 = new u(r0.a(), r0.b(), r0.c(), r5);
        this.mBDInstallService.b(r1);
        getDbStore().g();
        ArrayList<com.bytedance.applog.store.a> r6 = new ArrayList();
        h r2 = getAppLog().W();
        if (r2 == null) goto L5;
        r2 = (h) ZeusTransformUtils.preCheckCast(r2.l(), h.class, "com.obric.aiagent.plugin");
    L5:
        if (r2 == null) goto L7;
        r2.a(System.currentTimeMillis());
        r2.u = -1;
        this.mSession.a(r2, r6, true);
        this.mSession.b(r2);
        r6.add(r2);
    L9:
        if (r6.isEmpty() == true) goto L12;
        getDbStore().a(r6);
        return;
    L12:
        return;
    L7:
        this.mSession.a(null, r6, false);
        goto L9
    }

    private void doResetWhenSwitchChildMode(boolean r9, long r10, as r12) {
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r12, as.class, "com.obric.aiagent.plugin");
        u r13 = getUriConfig().b();
        u r4 = new u(r13.a(), r13.b(), r13.c(), r9);
        this.mBDInstallService.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r10, r7);
    }

    private void doClearAndSetEnv() {
        u r0 = getUriConfig().b();
        u r1 = new u(r0.a(), r0.b(), r0.c(), r0.d());
        this.mBDInstallService.c(r1);
    }

    private void doResetAndReInstall(long r9, as r11) {
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r11, as.class, "com.obric.aiagent.plugin");
        u r12 = getUriConfig().b();
        u r4 = new u(r12.a(), r12.b(), r12.c(), r12.d());
        this.mBDInstallService.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r9, r7);
    }

    private void handleRealTimeEvents(List<com.bytedance.applog.store.a> r3, com.bytedance.applog.priority.b r4, String[] r5) {
        trySendRealTimeEvents(r5, r4, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), getUriConfig().g());
    }

    private void trySendRealTimeEvents(String[] r3, com.bytedance.applog.priority.b r4, List<com.bytedance.applog.store.a> r5, Map<String, String> r6) {
        List<com.bytedance.applog.store.a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (sendRealTime(r3, r4, r7, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")) == true) goto L11;
        Iterator<com.bytedance.applog.store.a> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        com.bytedance.applog.store.a r9 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r9.s <= 0) goto L6;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.u, r9);
        goto L6
    L10:
        this.mWorkHandler.obtainMessage(8, r7).sendToTarget();
        return;
    L11:
        Iterator<com.bytedance.applog.store.a> r10 = r7.iterator();
    L13:
        if (r10.hasNext() == false) goto L17;
        com.bytedance.applog.store.a r11 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (r11.s <= 0) goto L13;
        com.bytedance.applog.monitor.c.a(getAppLog().N(), com.bytedance.applog.monitor.v3.a.I, r11);
        goto L13
    L17:
        getAppLog().N().increaseStats(j.f, r7.size());
        getDbStore().a(r7);
    }

    private boolean sendRealTime(String[] r12, com.bytedance.applog.priority.b r13, List<com.bytedance.applog.store.a> r14, Map<String, String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        JSONObject r17 = m.a(this.mDevice.a());
        if (r12.length <= 0) goto L42;
        k r0 = getAppLog().s();
        if (r0 != null) goto L45;
    L10:
        g r18 = g.a(this.mAppLogInst, r16, r17, r13);
        if (com.bytedance.applog.a.b.g == true) goto L21;
        com.bytedance.applog.m.a r1 = null;
        if (r13 == null) goto L15;
        r1 = r13.d();
    L15:
        if (r1 == null) goto L21;
        if (r1.a(8) == false) goto L21;
        getAppLog().N().increaseStats(j.D);
        return false;
    L21:
        if (r18.u != null) goto L23;
    L41:
        return false;
    L23:
        if (r18.u.length <= 0) goto L41;
        int r19 = getAppLog().V().a(r12, r18.u, this, r18.s(), r18.G, r18.H, r7, true);
        r18.w = r19;
        if (r19 != 200) goto L28;
        this.mRealFailTs = 0;
        boolean r110 = true;
    L34:
        MonitorV3Helper r111 = getAppLog().N();
        if (r110 == false) goto L37;
        j r2 = j.Q;
    L38:
        r111.increaseStats(r2, r16.size());
        if (l.a() == true) goto L43;
        d.a(getAppLog().b(), r18.t(), r110);
    L43:
        getAppLog().Z().b(logTags, "sendRealTime: {}", new Object[]{Boolean.valueOf(r110)});
        return r110;
    L37:
        r2 = j.R;
        goto L38
    L28:
        if (com.bytedance.applog.k.a.a(r19) == false) goto L30;
        this.mRealFailTs = System.currentTimeMillis();
    L30:
        if (r13 == null) goto L32;
        r13.a(r19);
    L32:
        r110 = false;
        goto L34
    L45:
        r0.a(r17);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        getAppLog().N().increaseStats(j.f5823J);
        getAppLog().Z().a(logTags, "header custom callback updateHeader error", th, new Object[0]);
        getAppLog().N().sendError("Realtime send IHeaderCustomTimelyCallback updateHeader failed", th);
        goto L10
    L42:
        r110 = false;
        goto L43
    }

    private void initNewMonitor() {
        if (getAppLog().an() == true) goto L5;
    L9:
        getAppLog().N().init(new com.bytedance.applog.monitor.v3.e.a().a());
        return;
    L5:
        if (getAppLog().N().isEnabled() == false) goto L9;
        if (TextUtils.isEmpty(getUriConfig().f()) == true) goto L9;
        getAppLog().N().increaseStats(j.q, getDbStore().a());
        getAppLog().N().increaseStats(j.r, getDbStore().b());
        getAppLog().N().increaseStats(j.s, getDbStore().c());
        getAppLog().N().increaseStats(j.t, getDbStore().d());
        getAppLog().N().increaseStats(j.u, getDbStore().e());
        getAppLog().N().init(new com.bytedance.applog.monitor.v3.e.a().a(new com.bytedance.applog.monitor.v3.d.a().a(getConfig().l()).b(getConfig().m()).d(getConfig().c().r()).c(getConfig().t()).a(getConfig().c().w()).e("5.7.8-bugfix.1").a(getConfig().c().O()).f(n.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"))).e(!l.a()).c(getConfig().c().D()).d(getConfig().c().J()).b(getConfig().c().u()).a()).a(com.bytedance.applog.c.a.b()).a(getConfig().s()).a(getAppLog().q()).a(getUriConfig().f()).a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(new AnonymousClass5(this)).a());
    }
}
