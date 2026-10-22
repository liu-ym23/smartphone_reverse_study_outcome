package com.obric.aiagent;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaConstants;
import com.bytedance.keva.KevaImpl;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.util.InitContext;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.privacy.IPrivacyService;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: InitPeriodWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AgentInitPeriodWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16091b;

    /* JADX INFO: renamed from: com.obric.aiagent.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InitPeriodWrapper.kt */
    public static final class ThreadFactoryC0323a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f16092a;

        ThreadFactoryC0323a() {
            this.f16092a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            o.e(r5, DownloadFileUtils.MODE_READ);
            return new Thread(r5, "_a_init_" + this.f16092a.getAndIncrement());
        }
    }

    /* JADX INFO: compiled from: InitPeriodWrapper.kt */
    public static final class b extends KevaMonitor {
        b() {
        }

        @Override // com.bytedance.keva.KevaMonitor
        public void reportThrowable(int r3, String r4, String r5, Object r6, Throwable r7) {
            o.e(r7, "throwable");
            ISecureLogDepend.Companion.e(KevaConstants.TAG, "action: [" + r3 + "], repo: [" + r4 + "], key: [" + r5 + "], value: [" + r6 + "], msg: " + r7.getMessage(), r7);
        }

        @Override // com.bytedance.keva.KevaMonitor
        public void reportWarning(int r3, String r4, String r5, Object r6, String r7) {
            ISecureLogDepend.Companion.w(KevaConstants.TAG, "action: [" + r3 + "], repo: [" + r4 + "], key: [" + r5 + "], value: [" + r6 + "], msg: " + r7);
        }
    }

    static {
        f16090a = new a();
    }

    public static /* synthetic */ void lambda$30GPKmom3HD_iVHKyUoF3ztTcxE() {
        h();
    }

    /* JADX INFO: renamed from: lambda$8goVdrCV6LuQeKPlX-Ujjf-slZA, reason: not valid java name */
    public static /* synthetic */ void m113lambda$8goVdrCV6LuQeKPlXUjjfslZA(Thread.UncaughtExceptionHandler r0, Thread r1, Throwable r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$aMp9H76dQXqHH0wQWCGUtCfnvwc() {
        return g();
    }

    public static /* synthetic */ x lambda$vJIS5xm4iK_vNPU8jIoZhRFDLwQ(d.h.a.a r0, Context r1) {
        return a(r0, r1);
    }

    private a() {
    }

    public final void a(Context r10, Application r11) {
        final Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        Application r13 = (Application) ZeusTransformUtils.wrapperContextForParams(r11, Application.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r13, "applicationInstance");
        InitContext.setCommonParams("application", r13);
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        f16091b = r14;
        long r3 = System.currentTimeMillis();
        TaskConfig r15 = new TaskConfig.Builder(r12, IRuntimeContext.Companion.isMainProcess(), IRuntimeContext.Companion.getProcessName()).isDebug(f16091b).setTimeOut(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD).enableCatchException(true ^ f16091b).setThreadFactory((ThreadFactory) ZeusTransformUtils.preCheckCast(new ThreadFactoryC0323a(), ThreadFactory.class, "com.obric.aiagent.plugin")).setCoreThreadNum(Runtime.getRuntime().availableProcessors() * 2).setExecutorService(com.obric.aiagent.b.f16389a.a()).setApplicationStartTime(r3).agreePrivacyPopupWindow(false).build();
        InitContext.setCommonParams("config", r15);
        ILogDepend.Companion.i(TAG, "init. mainProcess=" + r15.isMainProcess() + ", name=" + r15.getProcessName() + " pid = " + Process.myPid());
        ISysLogDepend.Companion.i(TAG, "init(syslog). mainProcess=" + r15.isMainProcess() + ", name=" + r15.getProcessName());
        InitScheduler.config(r15);
        InitScheduler.initTasks();
        InitScheduler.initPeriodTask();
        ILogDepend.Companion.i(TAG, "init end, cost=" + (System.currentTimeMillis() - r3));
        ISysLogDepend.Companion.i(TAG, "init end(syslog), cost=" + (System.currentTimeMillis() - r3));
        if (f() == true) goto L15;
        ISysLogDepend.Companion.i(TAG, "init(syslog). privacy not agreed");
        ILogDepend.Companion.i(TAG, "init. privacy not agreed");
        final $$Lambda$a$aMp9H76dQXqHH0wQWCGUtCfnvwc r9 = $$Lambda$a$aMp9H76dQXqHH0wQWCGUtCfnvwc.INSTANCE;
        IPrivacyService r16 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L16;
        r16.registerAgreeListener(new $$Lambda$a$vJIS5xm4iK_vNPU8jIoZhRFDLwQ(r9, r12));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r14 = false;
        goto L9
    }

    private static final x g() {
        a r0 = f16090a;
        r0.a();
        r0.b();
        r0.c();
        r0.d();
        return x.f38692a;
    }

    private static final x a(d.h.a.a r4, Context r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        ISysLogDepend.Companion.i(TAG, "onAgree(syslog)");
        ILogDepend.Companion.i(TAG, "onAgree");
        r6.invoke();
        IPrivacyService r0 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.unregisterAgreeListener(r6);
    L5:
        f16090a.b(r7);
        return x.f38692a;
    }

    public final void a() {
        if (f() == false) goto L6;
        long r0 = System.currentTimeMillis();
        InitScheduler.onPeriodStart(InitPeriod.APP_ATTACHBASE2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.APP_ATTACHBASE2SUPER);
        ILogDepend.Companion.i(TAG, "beforeApplicationAttach end, cost=" + (System.currentTimeMillis() - r0));
        return;
    }

    public final void b() {
        if (f() == false) goto L6;
        long r0 = System.currentTimeMillis();
        InitScheduler.onPeriodStart(InitPeriod.APP_SUPER2ATTACHBASEEND);
        InitScheduler.onPeriodEnd(InitPeriod.APP_SUPER2ATTACHBASEEND);
        ISysLogDepend.Companion.i(TAG, "afterApplicationAttach end, cost=" + (System.currentTimeMillis() - r0));
        return;
    }

    public final void c() {
        if (f() == false) goto L16;
        long r0 = System.currentTimeMillis();
        InitScheduler.onPeriodStart(InitPeriod.APP_ONCREATE2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.APP_ONCREATE2SUPER);
        ILogDepend.Companion.i(TAG, "beforeApplicationCreate end, cost=" + (System.currentTimeMillis() - r0));
        Object r5 = InitContext.getCommonParams("config");
        if (ZeusTransformUtils.instanceOf(r5, TaskConfig.class) == false) goto L7;
        TaskConfig r6 = (TaskConfig) ZeusTransformUtils.preCheckCast(r5, TaskConfig.class, "com.obric.aiagent.plugin");
    L8:
        if (r6 != null) goto L11;
        return;
    L11:
        if (o.a(r6.getProcessName(), "com.larus.nova:interactor") == false) goto L17;
        ThreadPoolExecutor r7 = r6.getTaskExecutor();
        if (r7 == null) goto L18;
        r7.submit($$Lambda$a$30GPKmom3HD_iVHKyUoF3ztTcxE.INSTANCE);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r6 = null;
        goto L8
    }

    private static final void h() {
        ILogDepend.Companion.i(TAG, "run applog&ttnet for interactor");
    }

    public final void d() {
        if (f() == false) goto L5;
        long r0 = System.currentTimeMillis();
        InitScheduler.onPeriodStart(InitPeriod.APP_SUPER2ONCREATEEND);
        InitScheduler.onPeriodEnd(InitPeriod.APP_SUPER2ONCREATEEND);
        ILogDepend.Companion.i(TAG, "afterApplicationCreate end, cost=" + (System.currentTimeMillis() - r0));
        InitScheduler.startDispatchDelayTask();
        InitScheduler.startDispatchIdleTask();
    L5:
        e();
    }

    private final void e() {
        final Thread.UncaughtExceptionHandler r1 = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new $$Lambda$a$8goVdrCV6LuQeKPlXUjjfslZA(r1));
    }

    private static final void a(Thread.UncaughtExceptionHandler r5, Thread r6, Throwable r7) {
        Thread.UncaughtExceptionHandler r8 = (Thread.UncaughtExceptionHandler) ZeusTransformUtils.wrapperContextForParams(r5, Thread.UncaughtExceptionHandler.class, "com.obric.aiagent.plugin");
        IIntentTraceService r0 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        m[] r1 = new m[3];
        r1[0] = s.a("exception_type", r7.getClass().getSimpleName());
        String r3 = r7.getMessage();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r1[1] = s.a("exception_msg", r3);
        r1[2] = s.a("thread_name", r6.getName());
        r0.onProcessDead("crash", ao.a(r1));
    L8:
        if (r8 == null) goto L11;
        r8.uncaughtException(r6, r7);
        return;
    }

    public final void a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "base");
        KevaBuilder.getInstance().setContext(r2).setMonitor((KevaMonitor) ZeusTransformUtils.preCheckCast(new b(), KevaMonitor.class, "com.obric.aiagent.plugin"));
    }

    private final boolean f() {
        IPrivacyService r2 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.isAgreed() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final void b(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Object r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity");
        o.a(r8, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r8, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses().iterator();
    L4:
        if (r9.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r1 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");
        if (o.a(r1.processName, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName() + ":interactor") == false) goto L4;
        ILogDepend.Companion.i(TAG, "kill interactor process, pid=" + r1.pid);
        Process.killProcess(r1.pid);
        return;
    }
}
