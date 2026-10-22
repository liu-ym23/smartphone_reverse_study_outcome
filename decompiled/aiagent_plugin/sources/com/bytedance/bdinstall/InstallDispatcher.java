package com.bytedance.bdinstall;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class InstallDispatcher implements Handler.Callback, com.bytedance.bdinstall.a.d {
    private static final int MSG_BG_START = 1234;
    private static final int MSG_WORK_ONE = 1235;
    private static final com.bytedance.bdinstall.j.r<a> mObservers = null;
    private final AtomicBoolean isTicketInit;
    private c mActivator;
    private final AtomicBoolean mActive;
    private final com.bytedance.bdinstall.appstate.a mAppStateListener;
    private com.bytedance.bdinstall.a.b mCallbackCenter;
    private final an mConfig;
    private final com.bytedance.bdinstall.d.m mDeviceManager;
    private u mEnv;
    private long mFetchActiveTime;
    private x mGWorker;
    private final Handler mHandler;
    private ax mRegisterWorker;
    private bb mVerifyWorker;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.InstallDispatcher$5, reason: invalid class name */
    class AnonymousClass5 implements com.bytedance.bdinstall.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ax f6077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InstallDispatcher f6078b;

        AnonymousClass5(InstallDispatcher r1, ax r2) {
            this.f6078b = r1;
            this.f6077a = r2;
        }

        @Override // com.bytedance.bdinstall.i.c
        public void a(boolean r2) {
            if (r2 == false) goto L4;
            InstallDispatcher.access$600(this.f6078b).set(true);
            InstallDispatcher.access$500(this.f6078b).q().a(new AnonymousClass1(this));
            InstallDispatcher.access$800(this.f6078b, this.f6077a);
            InstallDispatcher.access$902(this.f6078b, this.f6077a);
            return;
        L4:
            InstallDispatcher.access$800(this.f6078b, this.f6077a);
            InstallDispatcher.access$902(this.f6078b, this.f6077a);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<WeakReference<InterfaceC0143a>> f6086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f6087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f6088c;

        /* JADX INFO: renamed from: com.bytedance.bdinstall.InstallDispatcher$a$a, reason: collision with other inner class name */
        interface InterfaceC0143a {
            void a();
        }

        static /* synthetic */ Context a(a r0) {
            return r0.f6088c;
        }

        static /* synthetic */ void b(a r0) {
            r0.b();
        }

        static /* synthetic */ Set c(a r0) {
            return r0.f6086a;
        }

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f6086a = Collections.synchronizedSet(new HashSet());
            this.f6087b = new AtomicBoolean(false);
            this.f6088c = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        public synchronized void a(InterfaceC0143a r3) {
            monitor-enter(this);
            InterfaceC0143a r4 = (InterfaceC0143a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0143a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            this.f6086a.add(new WeakReference(r4));     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void a() {
            if (this.f6087b.compareAndSet(false, true) == false) goto L12;
            PluginBroadcastReceiver r0 = new AnonymousClass1(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            ZeusTransformUtils.registerReceiver(this.f6088c, r0, r1, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        private synchronized void b() {
            monitor-enter(this);
            w.a(new AnonymousClass2(this));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void b(InterfaceC0143a r5) {
            monitor-enter(this);
            InterfaceC0143a r6 = (InterfaceC0143a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0143a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            Iterator<WeakReference<InterfaceC0143a>> r0 = this.f6086a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (((InterfaceC0143a) ZeusTransformUtils.preCheckCast(r1.get(), InterfaceC0143a.class, "com.obric.aiagent.plugin")) != r6) goto L5;
            r0.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ AtomicBoolean access$000(InstallDispatcher r0) {
        return r0.mActive;
    }

    static /* synthetic */ an access$100(InstallDispatcher r0) {
        return r0.mConfig;
    }

    static /* synthetic */ com.bytedance.bdinstall.j.r access$1000() {
        return mObservers;
    }

    static /* synthetic */ void access$1100(InstallDispatcher r0, k.a r1, k r2) {
        r0.doEventTrack(r1, r2);
    }

    static /* synthetic */ Handler access$1200(InstallDispatcher r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1600(InstallDispatcher r0, x r1) {
        r0.gWokerImmediately(r1);
    }

    static /* synthetic */ u access$200(InstallDispatcher r0) {
        return r0.mEnv;
    }

    static /* synthetic */ void access$300(InstallDispatcher r0, c r1) {
        r0.activeImmediately(r1);
    }

    static /* synthetic */ com.bytedance.bdinstall.appstate.a access$400(InstallDispatcher r0) {
        return r0.mAppStateListener;
    }

    static /* synthetic */ com.bytedance.bdinstall.d.m access$500(InstallDispatcher r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ AtomicBoolean access$600(InstallDispatcher r0) {
        return r0.isTicketInit;
    }

    static /* synthetic */ void access$700(InstallDispatcher r0, bb r1) {
        r0.verifyImmediately(r1);
    }

    static /* synthetic */ void access$800(InstallDispatcher r0, k r1) {
        r0.workAndPostAgain(r1);
    }

    static /* synthetic */ ax access$902(InstallDispatcher r0, ax r1) {
        r0.mRegisterWorker = r1;
        return r1;
    }

    static {
        mObservers = new AnonymousClass1();
    }

    InstallDispatcher(an r3, com.bytedance.bdinstall.d.m r4, com.bytedance.bdinstall.appstate.a r5, u r6) {
        com.bytedance.bdinstall.appstate.a r7 = (com.bytedance.bdinstall.appstate.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdinstall.appstate.a.class, "com.obric.aiagent.plugin");
        this.mActive = new AtomicBoolean(false);
        this.isTicketInit = new AtomicBoolean(false);
        this.mConfig = r3;
        this.mDeviceManager = r4;
        this.mAppStateListener = r7;
        this.mHandler = new Handler(w.a(r3.b()), this);
        this.mEnv = r6;
    }

    void start(boolean r2) {
        register(this.mEnv, r2);
        active();
    }

    public void setCallbackCenter(com.bytedance.bdinstall.a.b r1) {
        this.mCallbackCenter = r1;
    }

    boolean changeEnv(u r2, boolean r3) {
        if (this.mEnv.equals(r2) == false) goto L6;
        return false;
    L6:
        this.mEnv = r2;
        this.mDeviceManager.a(r2, r3);
        return true;
    }

    boolean reStart(u r4, boolean r5, boolean r6) {
        if (changeEnv(r4, r6) == true) goto L7;
        if (r5 == true) goto L7;
        t.c("the env is the same with before,ignore." + r4);
        return false;
    L7:
        this.mHandler.removeMessages(MSG_WORK_ONE);
        if (this.mHandler.hasMessages(MSG_BG_START) == false) goto L10;
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(MSG_BG_START, true));
    L15:
        return true;
    L10:
        ax r7 = new ax(this.mConfig, this.mDeviceManager, r4, this.mAppStateListener);
        workImmediately(r7);
        this.mRegisterWorker = r7;
        if (this.mConfig.D() == false) goto L15;
        if (this.mActive.get() == false) goto L15;
        activeImmediately(new c(this.mConfig, r4));
        goto L15
    }

    void activeManually() {
        t.a("dispatcher#activeManually");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.mFetchActiveTime) >= 900000) goto L5;
        return;
    L5:
        if (com.bytedance.bdinstall.j.l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mConfig.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L10;
        this.mFetchActiveTime = r0;
        activeImmediately(new c(this.mConfig, this.mEnv));
        return;
    }

    private void active() {
        if (this.mConfig.D() == true) goto L5;
        return;
    L5:
        final Runnable r0 = new AnonymousClass2(this);
        this.mAppStateListener.setOnResumeListener(new AnonymousClass3(this, r0));
        if (this.mConfig.J() == false) goto L9;
        t.a("dispatcher#active isActive");
        r0.run();
        return;
    L9:
        if (this.mAppStateListener.isActive() == false) goto L13;
        t.a("dispatcher#active isActive");
        r0.run();
        return;
    }

    private void register(u r5, boolean r6) {
        w.a(String.valueOf(this.mConfig.a()), new AnonymousClass4(this));
        if (this.mDeviceManager.e() == false) goto L20;
        ax r0 = new ax(this.mConfig, this.mDeviceManager, r5, this.mAppStateListener);
        com.bytedance.bdinstall.a.b r7 = this.mCallbackCenter;
        if (r7 == null) goto L7;
        r7.b(new com.bytedance.bdinstall.a.a.a(this.mDeviceManager.d()));
    L7:
        if (r6 == false) goto L9;
    L14:
        r0.l();
    L16:
        if (handleTicket(r0) == false) goto L19;
        t.a("TicketGuard# handle ticket success");
        return;
    L19:
        workAndPostAgain(r0);
        this.mRegisterWorker = r0;
        return;
    L9:
        if (this.mDeviceManager.j() == true) goto L14;
        if (this.mDeviceManager.m() == true) goto L14;
        if (this.mDeviceManager.n() == false) goto L16;
    L20:
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r4 = this.mHandler;
        r4.sendMessageDelayed(r4.obtainMessage(MSG_BG_START, Boolean.valueOf(r6)), 1000);
    }

    private boolean handleTicket(ax r4) {
        if (i.f().c() == true) goto L5;
    L18:
        return false;
    L5:
        if (this.mDeviceManager.d().has("device_id") == true) goto L7;
    L17:
        t.a("TicketGuard#  sp has no did and iid, skip ticket init.");
        goto L18
    L7:
        if (this.mDeviceManager.d().has("install_id") == false) goto L17;
        AnonymousClass5 r0 = new AnonymousClass5(this, r4);     // Catch: Exception -> L14
        if (this.isTicketInit.get() == false) goto L12;
        r0.a(true);     // Catch: Exception -> L14
    L13:
        return true;
    L12:
        this.mDeviceManager.q().a(this.mConfig, r0);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        t.b("TicketGuard# ", e);
        return false;
    }

    private void workAndPostAgain(final k r3) {
        w.a(String.valueOf(this.mConfig.a()), new AnonymousClass6(this, r3));
    }

    private void doEventTrack(k.a r2, k r3) {
        if (r3 != null) goto L4;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r2.f6363b != 4) goto L13;
        r3.a(r2.f6365d);
        r3.a(r2.f6362a);
        r3.g();
        return;
    L13:
        return;
    L4:
        if (r2.f6362a == false) goto L6;
        r3.a(r2.f6365d);
        r3.a(r2.f6362a);
        r3.g();
    }

    private void activeImmediately(c r4) {
        t.a("dispatcher#activeImmediately");
        this.mActive.set(true);
        c r0 = this.mActivator;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.h();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mActivator);
    L6:
        this.mActivator = r4;
        workImmediately(r4);
    }

    private void verifyImmediately(bb r4) {
        t.a("dispatcher# verifyTicketWorker");
        bb r0 = this.mVerifyWorker;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.h();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mVerifyWorker);
    L6:
        this.mVerifyWorker = r4;
        workImmediately(r4);
    }

    private void gWokerImmediately(x r4) {
        t.a("dispatcher# verifyTicketWorker");
        x r0 = this.mGWorker;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.h();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mGWorker);
    L6:
        this.mGWorker = r4;
        workImmediately(r4);
    }

    private void workImmediately(k r2) {
        workImmediately(r2, false);
    }

    private void workImmediately(k r3, boolean r4) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L12;
        if (r3 == null) goto L13;
        r0.removeMessages(MSG_WORK_ONE, r3);
        Message r5 = this.mHandler.obtainMessage(MSG_WORK_ONE, r3.l());
        if (r4 == true) goto L8;
    L10:
        this.mHandler.sendMessage(r5);
        return;
    L8:
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L10;
        handleMessage(r5);
        return;
    L13:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        int r0 = r4.what;
        if (r0 != MSG_BG_START) goto L5;
        register(this.mEnv, ((Boolean) ZeusTransformUtils.preCheckCast(r4.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return false;
    L5:
        if (r0 != MSG_WORK_ONE) goto L18;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r4.obj, k.class, "com.obric.aiagent.plugin");
        if (checkSilenceBg(r5) == false) goto L11;
        return false;
    L11:
        if (r5.i() == true) goto L16;
        workAndPostAgain(r5);
        return false;
    L16:
        return false;
    L18:
        return false;
    }

    private boolean checkSilenceBg(k r4) {
        if (this.mConfig.y() == true) goto L5;
        return false;
    L5:
        if (this.mAppStateListener.isForeground() == false) goto L7;
        return false;
    L7:
        if (t.a() == false) goto L9;
        t.a("skip work " + r4 + " cause user set silent in bg.");
    L9:
        Handler r3 = this.mHandler;
        r3.sendMessageDelayed(r3.obtainMessage(MSG_WORK_ONE, r4), r4.j());
        return true;
    }

    void redoRegister() {
        ax r0 = this.mRegisterWorker;
        if (r0 == null) goto L6;
        workImmediately(r0, true);
        return;
    }

    @Override // com.bytedance.bdinstall.a.d
    public void onEgdiFailed() {
        this.mHandler.postDelayed(new AnonymousClass7(this), i.f().e());
    }
}
