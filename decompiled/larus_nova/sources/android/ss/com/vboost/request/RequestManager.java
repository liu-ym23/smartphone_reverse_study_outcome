package android.ss.com.vboost.request;

import android.content.Context;
import android.ss.com.vboost.CapabilityScheduler;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomRequest;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.VboostListener;
import android.ss.com.vboost.utils.LogUtil;
import android.util.SparseBooleanArray;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RequestManager {
    private static final long KEEP_RELEASE_TIMEOUT = 30000;
    private static final long SHORTEST_TIMEOUT = 50;
    private static final String TAG = "RequestManager";
    private static volatile android.ss.com.vboost.utils.c<Boolean> enableVboostLazy;
    private static android.ss.com.vboost.utils.c<Boolean> registeredLazy;
    private static final boolean useScheduleThread = false;
    private android.ss.com.vboost.utils.c<SparseBooleanArray> allowedScenesLazy;
    private final Condition available;
    private Map<CapabilityType, android.ss.com.vboost.request.d> currentRequests;
    private ConcurrentHashMap<android.ss.com.vboost.request.d, CustomRequest> customRequests;
    private ScheduledExecutorService executor;
    private final transient ReentrantLock lock;
    private android.ss.com.vboost.utils.a.b mApplogListener;
    private android.ss.com.vboost.utils.c<WeakReference<VboostListener.VboostApplogListener>> mVboostApplogListenerLazy;
    private Map<CapabilityType, TreeSet<android.ss.com.vboost.request.d>> requests;
    private ConcurrentHashMap<CustomRequest, android.ss.com.vboost.request.d> restoreRequests;
    private h scheduleThread;

    public class a extends android.ss.com.vboost.utils.c<SparseBooleanArray> {
        public a(RequestManager r100) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public SparseBooleanArray initialValue() {
            SparseBooleanArray r100 = new SparseBooleanArray();
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
        L10:
            return r100;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getAllowedScenes() == null) goto L10;
            Iterator<Integer> r101 = CapabilityScheduler.getInitialConfigProvider().getAllowedScenes().iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            r100.append(r101.next().intValue(), true);
            goto L8
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ SparseBooleanArray initialValue() {
            return initialValue();
        }
    }

    public static class b extends android.ss.com.vboost.utils.c<Boolean> {
        public b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Boolean initialValue() {
            if (android.ss.com.vboost.i.c.d() == null) goto L7;
            return Boolean.TRUE;
        L7:
            return Boolean.FALSE;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Boolean initialValue() {
            return initialValue();
        }
    }

    public static class c extends android.ss.com.vboost.utils.c<Boolean> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.ss.com.vboost.utils.c
        public Boolean initialValue() {
            if (CapabilityScheduler.getInitialConfigProvider() == null) goto L9;
            if (CapabilityScheduler.getInitialConfigProvider().getSwitch() == null) goto L9;
            return CapabilityScheduler.getInitialConfigProvider().getSwitch();
        L9:
            return Boolean.TRUE;
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ Boolean initialValue() {
            return initialValue();
        }
    }

    public class d extends android.ss.com.vboost.utils.c<WeakReference<VboostListener.VboostApplogListener>> {
        public d(RequestManager r100) {
        }

        @Override // android.ss.com.vboost.utils.c
        public /* bridge */ /* synthetic */ WeakReference<VboostListener.VboostApplogListener> initialValue() {
            return initialValue2();
        }

        @Override // android.ss.com.vboost.utils.c
        /* JADX INFO: renamed from: initialValue, reason: avoid collision after fix types in other method */
        public WeakReference<VboostListener.VboostApplogListener> initialValue2() {
            if (CapabilityScheduler.getInitialConfigProvider() != null) goto L5;
            return null;
        L5:
            if (CapabilityScheduler.getInitialConfigProvider().getApplogListener() != null) goto L7;
            return null;
        L7:
            return new WeakReference(CapabilityScheduler.getInitialConfigProvider().getApplogListener());
        }
    }

    public class e implements android.ss.com.vboost.utils.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestManager f4727a;

        public e(RequestManager r100) {
            this.f4727a = r100;
        }

        @Override // android.ss.com.vboost.utils.a.b
        public void onInternalEventV3(String r100, JSONObject r101, String r110, String r111, String r112) {
            if (RequestManager.access$200(this.f4727a).get() != null) goto L5;
            return;
        L5:
            if (((WeakReference) RequestManager.access$200(this.f4727a).get()).get() == null) goto L9;
            ((VboostListener.VboostApplogListener) ((WeakReference) RequestManager.access$200(this.f4727a).get()).get()).onInternalEventV3(r100, r101, r110, r111, r112);
            return;
        }
    }

    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4728a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4729b = null;

        static {
            int[] r100 = new int[i.values().length];
            f4729b = r100;
            r100[i.f4772d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L68:
            f4729b[i.f4771c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L56:
            f4729b[i.f4769a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L66:
            f4729b[i.f4770b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L10:
            int[] r101 = new int[CapabilityType.values().length];
            f4728a = r101;
            r101[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L50:
            f4728a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L74:
            f4728a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L82:
            f4728a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L48:
            f4728a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L72:
            f4728a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L86:
            f4728a[CapabilityType.UFS_FREQ_MAX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L54:
            f4728a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L76:
            f4728a[CapabilityType.CPU_AFFINITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L80:
            f4728a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L64:
            f4728a[CapabilityType.NETWORK_ENHANCE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L70:
            f4728a[CapabilityType.TASK_PRIORITY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L58:
            f4728a[CapabilityType.CPU_CORE_MAX.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
        L60:
            f4728a[CapabilityType.CPU_CORE_MIN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L45
        L84:
            f4728a[CapabilityType.PRESET_SCENE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L46
        L52:
            f4728a[CapabilityType.THUMB_FETCH.ordinal()] = 16;     // Catch: NoSuchFieldError -> L47
            return;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final RequestManager f4730a = null;

        static {
            f4730a = new RequestManager(null);
        }

        public static /* synthetic */ RequestManager a() {
            return f4730a;
        }
    }

    public class h extends PthreadThreadV2 {
    }

    static {
        registeredLazy = new b();
        enableVboostLazy = new c();
    }

    private RequestManager() {
        this.requests = new HashMap();
        ReentrantLock r100 = new ReentrantLock();
        this.lock = r100;
        this.available = r100.newCondition();
        this.currentRequests = new HashMap();
        this.executor = null;
        this.customRequests = new ConcurrentHashMap();
        this.restoreRequests = new ConcurrentHashMap();
        this.allowedScenesLazy = new a(this);
        this.mVboostApplogListenerLazy = new d(this);
        this.mApplogListener = new e(this);
        this.executor = new PThreadScheduledThreadPoolExecutor(2, new DefaultThreadFactory("equestManager"));
    }

    public /* synthetic */ RequestManager(a r100) {
        this();
    }

    public static /* synthetic */ ScheduledExecutorService access$1000(RequestManager r100) {
        return r100.executor;
    }

    public static /* synthetic */ android.ss.com.vboost.utils.c access$200(RequestManager r100) {
        return r100.mVboostApplogListenerLazy;
    }

    public static /* synthetic */ ReentrantLock access$300(RequestManager r100) {
        return r100.lock;
    }

    public static /* synthetic */ Map access$400(RequestManager r100) {
        return r100.requests;
    }

    public static /* synthetic */ Condition access$500(RequestManager r100) {
        return r100.available;
    }

    public static /* synthetic */ Map access$600(RequestManager r100) {
        return r100.currentRequests;
    }

    public static /* synthetic */ boolean access$700(RequestManager r100, android.ss.com.vboost.request.d r101) {
        return r100.shouldSetTimeoutTask(r101);
    }

    public static /* synthetic */ void access$800(RequestManager r100, android.ss.com.vboost.request.d r101) {
        r100.setTimeoutTask(r101);
    }

    public static /* synthetic */ String access$900() {
        return TAG;
    }

    private void cancelRequest(android.ss.com.vboost.request.d r100) {
        this.lock.lock();
        TreeSet<android.ss.com.vboost.request.d> r101 = this.requests.get(r100.f4738a);     // Catch: Throwable -> L18
        if (r101 == null) goto L11;
        if (r101.contains(r100) == false) goto L11;
        r101.remove(r100);     // Catch: Throwable -> L18
        android.ss.com.vboost.request.h r102 = r100.c();     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        r102.a().cancel(true);     // Catch: Throwable -> L18
    L11:
        if (this.currentRequests.get(r100.f4738a) == null) goto L16;
        LogUtil.debug(TAG, "cancel current executing request!");     // Catch: Throwable -> L18
        android.ss.com.vboost.request.h r103 = this.currentRequests.get(r100.f4738a).c();     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        r103.a().cancel(true);     // Catch: Throwable -> L18
    L15:
        this.executor.submit(new android.ss.com.vboost.request.f(r100));     // Catch: Throwable -> L18
        this.customRequests.remove(this.currentRequests.get(r100.f4738a));     // Catch: Throwable -> L18
        this.currentRequests.remove(r100.f4738a);     // Catch: Throwable -> L18
    L16:
        this.lock.unlock();
        return;
    L18:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    private android.ss.com.vboost.request.d checkAndTranslate(CustomRequest r110) {
        if (r110.type >= CapabilityType.TYPE_MIN.getIndex()) goto L5;
    L101:
        LogUtil.error(TAG, "capability out of range, must give a boost type for a request!!! request:" + r110.type);
        return null;
    L5:
        if (r110.type > CapabilityType.TYPE_MAX.getIndex()) goto L101;
        if (isSupportCapability(CapabilityType.valueOf(r110.type)) == true) goto L11;
        LogUtil.warn(TAG, "not support this capability!");
        return null;
    L11:
        android.ss.com.vboost.request.d r100 = this.restoreRequests.remove(r110);
        if (r100 != null) goto L14;
        r100 = new android.ss.com.vboost.request.d(CapabilityType.valueOf(r110.type));
        r100.f4756s = r110;
    L14:
        android.ss.com.vboost.request.c r101 = android.ss.com.vboost.request.c.f4735b;
        r100.f4750m = r101;
        switch(f.f4728a[CapabilityType.valueOf(r110.type).ordinal()]) {
            case 1: goto L81;
            case 2: goto L81;
            case 3: goto L81;
            case 4: goto L81;
            case 5: goto L81;
            case 6: goto L81;
            case 7: goto L81;
            case 8: goto L81;
            case 9: goto L64;
            case 10: goto L61;
            case 11: goto L57;
            case 12: goto L42;
            case 13: goto L98;
            case 14: goto L98;
            case 15: goto L17;
            case 16: goto L80;
            default: goto L98;
        };
    L17:
        android.ss.com.vboost.utils.c<SparseBooleanArray> r102 = this.allowedScenesLazy;
        monitor-enter(r102);
    L38:
        th = move-exception;
        throw th;
    L20:
        if (this.allowedScenesLazy.get().get(r110.scene.getId()) == true) goto L22;
    L35:
        LogUtil.warn(TAG, "scene " + r110.scene.getDesc() + " is forbidden or invalid!!!");     // Catch: Throwable -> L38
        monitor-exit(r102);     // Catch: Throwable -> L38
        return null;
    L22:
        if (CustomScene.isValidId(r110.scene.getId()) == false) goto L35;
        monitor-exit(r102);     // Catch: Throwable -> L38
        String r103 = TAG;
        LogUtil.debug(r103, "request preset_scene " + r110.scene.getDesc());
        r100.f4744g = r110.scene;
        r100.f4750m = r101;
        if (r110.restore == false) goto L30;
        LogUtil.debug(r103, "restore scene " + r100.f4744g.getDesc());
        r100.f4747j = true;
        r100.f4748k = false;
        r100.f4750m = android.ss.com.vboost.request.c.f4734a;
        r100.a(android.ss.com.vboost.request.g.f4764d);
        android.ss.com.vboost.request.h r104 = r100.c();
        if (r104 == null) goto L98;
        r104.a().cancel(true);
        goto L98
    L30:
        long r105 = r110.timeout;
        r100.f4747j = false;
        if (r105 <= 0) goto L33;
        r100.f4740c = r105;
        r100.f4748k = false;
    L34:
        r100.a(android.ss.com.vboost.request.g.f4762b);
        goto L98
    L33:
        r100.f4748k = true;
        r100.f4740c = 30000;
        goto L34
    L64:
        int r106 = r110.tid;
        if (r106 > 1) goto L68;
        LogUtil.warn(TAG, "your request tid is error");
        return null;
    L68:
        r100.f4741d = r106;
        r100.f4747j = r110.restore;
        r100.f4748k = true;
        int r107 = r110.cluster;
        CoreCluster r108 = CoreCluster.SUPER;
        if (r107 <= r108.getIndex()) goto L71;
    L74:
        String r109 = TAG;
        StringBuilder r111 = new StringBuilder("your request cluster is out of range:[");
        CoreCluster r112 = CoreCluster.SILVER;
        r111.append(r112.getIndex());
        r111.append(",");
        r111.append(r108.getIndex());
        r111.append("]");
        LogUtil.warn(r109, r111.toString());
        if (r110.cluster <= r108.getIndex()) goto L78;
        r100.f4743f = r108;
    L78:
        if (r110.cluster >= r112.getIndex()) goto L80;
        r100.f4743f = r112;
        goto L80
    L71:
        if (r110.cluster < CoreCluster.SILVER.getIndex()) goto L74;
        r100.f4743f = CoreCluster.valueOf(r110.cluster);
    L80:
        r100.f4750m = android.ss.com.vboost.request.c.f4734a;
        goto L98
    L81:
        int r113 = r110.level;
        FrequencyLevel r114 = FrequencyLevel.LEVEL_9;
        if (r113 <= r114.ordinal()) goto L84;
    L87:
        String r115 = TAG;
        StringBuilder r116 = new StringBuilder("your request level is out of range:[");
        FrequencyLevel r117 = FrequencyLevel.LEVEL_0;
        r116.append(r117.ordinal());
        r116.append(",");
        r116.append(r114.ordinal());
        r116.append("]");
        LogUtil.warn(r115, r116.toString());
        if (r110.level <= r114.ordinal()) goto L91;
        r100.f4739b = r114;
    L91:
        if (r110.level >= r117.ordinal()) goto L93;
        r100.f4739b = r117;
    L93:
        long r118 = r110.timeout;
        if (r118 >= 50) goto L96;
        LogUtil.warn(TAG, "timeout must more than 50");
        r100.f4740c = 50;
        goto L98
    L96:
        r100.f4740c = r118;
        goto L98
    L84:
        if (r110.level < FrequencyLevel.LEVEL_0.ordinal()) goto L87;
        r100.f4739b = FrequencyLevel.valueOf(r110.level);
        goto L93
    L42:
        if (r110.tid > 1) goto L45;
        LogUtil.warn(TAG, "your request tid is error");
        return null;
    L45:
        int r119 = r110.priority;
        FrequencyLevel r120 = FrequencyLevel.LEVEL_9;
        if (r119 <= r120.ordinal()) goto L48;
    L49:
        String r121 = TAG;
        StringBuilder r122 = new StringBuilder("your request level is out of range:[");
        FrequencyLevel r123 = FrequencyLevel.LEVEL_0;
        r122.append(r123.ordinal());
        r122.append(",");
        r122.append(r120.ordinal());
        r122.append("]");
        LogUtil.warn(r121, r122.toString());
        if (r110.level <= r120.ordinal()) goto L53;
        r100.f4739b = r120;
    L53:
        if (r110.level >= r123.ordinal()) goto L55;
        r100.f4739b = r123;
    L55:
        r100.f4741d = r110.tid;
        int r124 = r110.priority;
        r100.f4742e = r124;
        r100.f4739b = FrequencyLevel.valueOf(r124);
        r100.f4747j = r110.restore;
        r100.f4748k = true;
        goto L80
    L48:
        if (r110.priority >= FrequencyLevel.LEVEL_0.ordinal()) goto L55;
    L57:
        if (r110.bundle != null) goto L59;
        return null;
    L59:
        r100.f4746i = new android.ss.com.vboost.b();
        r110.bundle.getString("scene_type");
        r100.f4746i.f4599a = r110.bundle.getString("exception_type");
        r100.f4746i.f4600b = r110.bundle.getString("exception_reason");
        r100.f4746i.f4601c = r110.bundle.getString("behavior_type");
        r100.f4746i.f4602d = r110.bundle.getString("stallState");
        r100.f4746i.f4603e = r110.bundle.getString("reportEnabled");
        goto L98
    L61:
        if (r110.bundle != null) goto L63;
        return null;
    L63:
        android.ss.com.vboost.d r125 = new android.ss.com.vboost.d();
        r100.f4745h = r125;
        r125.f4604a = r110.bundle.getInt("scene_type");
        r100.f4745h.f4605b = r110.bundle.getFloat("intensity");
        r100.f4745h.f4606c = r110.bundle.getFloat("sharpness");
        r100.f4745h.f4607d = r110.bundle.getFloat("duration");
        r100.f4745h.f4608e = r110.bundle.getString("jsonFilePath");
    L98:
        if (r110.bundle == null) goto L100;
        r100.f4753p = new android.ss.com.vboost.request.e();
    L100:
        return r100;
    }

    private Object commitRequestLock(android.ss.com.vboost.request.d r100) {
        String r101 = TAG;
        LogUtil.debug(r101, "commit request lock");
        this.lock.lock();
    L17:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (r100.f4750m != android.ss.com.vboost.request.c.f4735b) goto L15;
        TreeSet<android.ss.com.vboost.request.d> r102 = this.requests.get(r100.f4738a);     // Catch: Throwable -> L17
        if (r102 != null) goto L8;
        r102 = new TreeSet();     // Catch: Throwable -> L17
        this.requests.put(r100.f4738a, r102);     // Catch: Throwable -> L17
    L8:
        boolean r103 = r102.add(r100);     // Catch: Throwable -> L17
        LogUtil.debug(r101, r102.toString());     // Catch: Throwable -> L17
        Object r104 = r100;
        if (r103 == false) goto L13;
        boolean r105 = shouldNotifyProvider(r100);     // Catch: Throwable -> L17
        r104 = r100;
        if (r105 == false) goto L13;
        doRequest(r100.f4738a);     // Catch: Throwable -> L17
        r104 = r100;
    L13:
        this.lock.unlock();
        return r104;
    L15:
        this.currentRequests.put(r100.f4738a, r100);     // Catch: Throwable -> L17
        r104 = android.ss.com.vboost.request.a.a(r100);     // Catch: Throwable -> L17
        goto L13
    }

    private void doRequest(CapabilityType r100) {
        String r101 = TAG;
        LogUtil.debug(r101, "do request");
        TreeSet<android.ss.com.vboost.request.d> r102 = this.requests.get(r100);
        StringBuilder r103 = new StringBuilder("doRequest:");
        if (r102 != null) goto L5;
        String r104 = "null";
    L6:
        r103.append(r104);
        LogUtil.debug(r101, r103.toString());
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isEmpty() == true) goto L24;
        android.ss.com.vboost.request.d r105 = r102.pollFirst();
        r105.a(System.currentTimeMillis());
        if (shouldSetTimeoutTask(r105) == false) goto L14;
        setTimeoutTask(r105);
        r105.f4740c = r105.a();
    L14:
        if (shouldNotifyProvider(r105) == true) goto L16;
        return;
    L16:
        if (r105.b() == android.ss.com.vboost.request.g.f4762b) goto L18;
    L21:
        LogUtil.debug(r101, "Async notify provider");
        this.executor.submit(new android.ss.com.vboost.request.b(r105));
        this.currentRequests.put(r105.f4738a, r105);
        return;
    L18:
        if (r105.a() > 50) goto L21;
        doRequest(r105.f4738a);
        return;
    L24:
        return;
    L5:
        r104 = r102.toString();
        goto L6
    }

    public static RequestManager getInstance() {
        return g.a();
    }

    public static void setEnableVboost(boolean r100) {
        enableVboostLazy.set(Boolean.valueOf(r100));
    }

    private void setTimeoutTask(android.ss.com.vboost.request.d r100) {
        LogUtil.debug(TAG, "set timeout task");
        android.ss.com.vboost.request.h r101 = new android.ss.com.vboost.request.h(r100);
        r101.a(this.executor.schedule(r101, r100.a(), TimeUnit.MILLISECONDS));
        r100.a(r101);
    }

    private boolean shouldNotifyProvider(android.ss.com.vboost.request.d r100) {
        android.ss.com.vboost.request.d r101 = this.currentRequests.get(r100.f4738a);
        boolean r102 = true;
        if (this.currentRequests == null) goto L34;
        if (r101 == null) goto L34;
        int r103 = f.f4729b[r100.d().ordinal()];
        if (r103 != 1) goto L9;
        FrequencyLevel r104 = r100.f4739b;
        if (r104 != null) goto L21;
    L25:
        r102 = false;
    L27:
        if (r100.b() == android.ss.com.vboost.request.g.f4762b) goto L31;
        if (r100.b() == android.ss.com.vboost.request.g.f4761a) goto L31;
    L33:
        LogUtil.debug(TAG, "Should notify provider:" + r102);
    L31:
        if (r100.a() > 50) goto L33;
        return false;
    L21:
        if (r101.f4739b == null) goto L25;
        if (r104.ordinal() <= r101.f4739b.ordinal()) goto L25;
    L9:
        if (r103 == 2) goto L16;
        if (r103 == 3) goto L25;
        if (r103 == 4) goto L27;
    L16:
        if (r100.f4739b.ordinal() >= r101.f4739b.ordinal()) goto L25;
    L34:
        return r102;
    }

    private boolean shouldSetTimeoutTask(android.ss.com.vboost.request.d r100) {
        if (r100.b() == android.ss.com.vboost.request.g.f4762b) goto L5;
    L7:
        boolean r101 = false;
    L8:
        LogUtil.debug(TAG, "Should set timeout task:" + r101);
        return r101;
    L5:
        if (r100.a() <= 50) goto L7;
        r101 = true;
        goto L8
    }

    public void cancelRequest(CapabilityType r100) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.debug(TAG, "cancelRequest registerApplication must be called before!!!");
        return;
    L8:
        LogUtil.debug(TAG, "cancel request by type");
        this.lock.lock();
        TreeSet<android.ss.com.vboost.request.d> r101 = this.requests.get(r100);     // Catch: Throwable -> L25
        if (r101 == null) goto L18;
        Iterator<android.ss.com.vboost.request.d> r102 = r101.iterator();     // Catch: Throwable -> L25
    L13:
        if (r102.hasNext() == false) goto L18;
        android.ss.com.vboost.request.d r103 = r102.next();     // Catch: Throwable -> L25
        android.ss.com.vboost.request.h r104 = r103.c();     // Catch: Throwable -> L25
        if (r104 == null) goto L17;
        r104.a().cancel(true);     // Catch: Throwable -> L25
    L17:
        r102.remove();     // Catch: Throwable -> L25
        this.customRequests.remove(r103);     // Catch: Throwable -> L25
    L18:
        android.ss.com.vboost.request.d r105 = this.currentRequests.get(r100);     // Catch: Throwable -> L25
        if (r105 == null) goto L24;
        android.ss.com.vboost.request.h r106 = r105.c();     // Catch: Throwable -> L25
        if (r106 == null) goto L23;
        r106.a().cancel(true);     // Catch: Throwable -> L25
    L23:
        this.executor.submit(new android.ss.com.vboost.request.f(this.currentRequests.get(r100)));     // Catch: Throwable -> L25
        this.customRequests.remove(r105);     // Catch: Throwable -> L25
        this.currentRequests.remove(r100);     // Catch: Throwable -> L25
    L24:
        this.lock.unlock();
        return;
    L25:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void cancelRequest(CustomRequest r100) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.debug(TAG, "cancelRequest registerApplication must be called before!!!");
        return;
    L8:
        LogUtil.debug(TAG, "cancel custom request " + this.customRequests.size());
        Iterator<Map.Entry<android.ss.com.vboost.request.d, CustomRequest>> r101 = this.customRequests.entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L27;
        Map.Entry<android.ss.com.vboost.request.d, CustomRequest> r102 = r101.next();
        if (r102.getValue() != r100) goto L10;
        android.ss.com.vboost.request.d r103 = r102.getKey();
        r103.f4747j = true;
        cancelRequest(r103);
        android.ss.com.vboost.request.g r104 = r103.b();
        if (r104 == android.ss.com.vboost.request.g.f4761a) goto L18;
        if (r104 == android.ss.com.vboost.request.g.f4763c) goto L18;
    L21:
        this.customRequests.remove(r102.getKey());
        return;
    L18:
        if (r103.f4750m != android.ss.com.vboost.request.c.f4734a) goto L20;
        android.ss.com.vboost.request.a.a(r103);
        goto L21
    L20:
        this.executor.submit(new android.ss.com.vboost.request.f(r103));
        goto L21
    }

    public Object commitRequest(CustomRequest r100) {
        Object r101 = null;
        if (enableVboostLazy.get().booleanValue() == true) goto L8;
        String r102 = TAG;
        String r103 = "vboost not enable!";
    L5:
        LogUtil.debug(r102, r103);
        return null;
    L8:
        if (registeredLazy.get().booleanValue() == true) goto L10;
        r102 = TAG;
        r103 = "commitRequest registerApplication must be called before!!!";
        goto L5
    L10:
        android.ss.com.vboost.request.d r104 = checkAndTranslate(r100);
        if (r104 == null) goto L15;
        r101 = commitRequestLock(r104);
        this.customRequests.put(r104, r100);
        if (r104.f4748k == false) goto L15;
        this.restoreRequests.put(r100, r104);
    L15:
        return r101;
    }

    public void completeDirectRequest(android.ss.com.vboost.request.d r100) {
        LogUtil.debug(TAG, "completeDirectRequest to schedule next request.");
        this.lock.lock();
        this.customRequests.remove(r100);     // Catch: Throwable -> L6
        this.currentRequests.remove(r100.f4738a);     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void completeRequest(android.ss.com.vboost.request.d r100, boolean r101) {
        LogUtil.debug(TAG, "completeTimeoutRequest to schedule next request.");
        this.lock.lock();
        if (r101 == false) goto L6;
        this.restoreRequests.remove(r100.f4756s);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L6:
        if (r100.c() == null) goto L8;
        if (r101 == true) goto L8;
    L13:
        this.lock.unlock();
        return;
    L8:
        this.customRequests.remove(r100);     // Catch: Throwable -> L15
        this.currentRequests.remove(r100.f4738a);     // Catch: Throwable -> L15
        TreeSet<android.ss.com.vboost.request.d> r102 = this.requests.get(r100.f4738a);     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        doRequest(r100.f4738a);     // Catch: Throwable -> L15
        goto L13
    }

    public android.ss.com.vboost.utils.a.b getApplogListener() {
        return this.mApplogListener;
    }

    public Set<CapabilityType> getSupportCapabilities() {
        if (registeredLazy.get().booleanValue() == true) goto L7;
        LogUtil.debug(TAG, "getSupportCapabilities registerApplication must be called before!!!");
        return null;
    L7:
        return android.ss.com.vboost.i.c.e().a();
    }

    public boolean isSupportCapability(CapabilityType r100) {
        if (registeredLazy.get().booleanValue() == true) goto L7;
        LogUtil.debug(TAG, "isSupportCapability registerApplication must be called before!!!");
        return false;
    L7:
        return android.ss.com.vboost.i.c.e().a(r100);
    }

    public void register(Context r100) {
        if (enableVboostLazy.get().booleanValue() == true) goto L5;
        LogUtil.info(TAG, "vboost not enable, do not register");
        return;
    L5:
        if (registeredLazy.get().booleanValue() == true) goto L8;
        LogUtil.info(TAG, "register context.");
        android.ss.com.vboost.i.c.a(r100);
        registeredLazy.set(Boolean.TRUE);
    L8:
        if (android.ss.com.vboost.i.c.e() == null) goto L12;
        android.ss.com.vboost.i.c.e().b();
        return;
    }

    public void registerApplog(VboostListener.VboostApplogListener r100) {
        this.mVboostApplogListenerLazy.set(new WeakReference(r100));
        android.ss.com.vboost.utils.a.a(this.mApplogListener);
    }

    public void registerSystemListener(VboostListener.SystemListener r100) {
        android.ss.com.vboost.i.c.e().a(r100);
    }

    public void setAllowedScenes(HashSet<Integer> r100) {
        Iterator<Integer> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Integer r102 = r101.next();
        android.ss.com.vboost.utils.c<SparseBooleanArray> r103 = this.allowedScenesLazy;
        monitor-enter(r103);
        this.allowedScenesLazy.get().append(r102.intValue(), true);     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void unregisterSystemListener(VboostListener.SystemListener r100) {
        android.ss.com.vboost.i.c.e().b(r100);
    }
}
