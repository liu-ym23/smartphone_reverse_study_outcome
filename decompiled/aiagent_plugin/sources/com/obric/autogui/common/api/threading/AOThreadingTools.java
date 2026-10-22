package com.obric.autogui.common.api.threading;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.br;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AOThreadingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOThreadingTools {
    public static final AOThreadingTools INSTANCE = null;
    private static final am mIOScope = null;
    private static final am mUIScope = null;
    private static final boolean settingConfigWatchDog = false;

    /* JADX INFO: compiled from: AOThreadingTools.kt */
    public interface AOThreadLauncher {
        am getCoroutineScope();

        LaunchedJob launch(b<? super d<? super x>, ? extends Object> r1);

        void shutdown();
    }

    /* JADX INFO: compiled from: AOThreadingTools.kt */
    public static final class CoroutineScopeWrapper implements AOThreadLauncher {
        public static final Companion Companion = null;
        private static final String TAG = "CSWrapper";
        private final am scope;

        /* JADX INFO: compiled from: AOThreadingTools.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public CoroutineScopeWrapper(am r3) {
            am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
            o.e(r4, "scope");
            this.scope = r4;
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public am getCoroutineScope() {
            return this.scope;
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public LaunchedJob launch(b<? super d<? super x>, ? extends Object> r9) {
            b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
            o.e(r10, "block");
            return (LaunchedJob) ZeusTransformUtils.preCheckCast(new LaunchedJobWrapper(i.a(getCoroutineScope(), null, null, (m) ZeusTransformUtils.preCheckCast(new AOThreadingTools$CoroutineScopeWrapper$launch$job$1(r10, null), m.class, "com.obric.aiagent.plugin"), 3, null)), LaunchedJob.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public void shutdown() {
            n.a r0 = n.f38560a;     // Catch: Throwable -> L4
            an.a(((CoroutineScopeWrapper) ZeusTransformUtils.preCheckCast(this, CoroutineScopeWrapper.class, "com.obric.aiagent.plugin")).getCoroutineScope(), null, 1, null);     // Catch: Throwable -> L4
            Object r1 = n.f(x.f38692a);     // Catch: Throwable -> L4
        L6:
            Throwable r2 = n.c(r1);
            if (r2 == null) goto L12;
            Loog.INSTANCE.e(TAG, " - [threading] failed to cancel coroutineScope: " + getCoroutineScope(), r2);
            return;
        L12:
            return;
        L4:
            th = move-exception;
            n.a r3 = n.f38560a;
            r1 = n.f(d.o.a(th));
            goto L6
        }
    }

    /* JADX INFO: compiled from: AOThreadingTools.kt */
    public interface LaunchedJob {
        void cancel();

        ca getJob();
    }

    /* JADX INFO: compiled from: AOThreadingTools.kt */
    public static final class LaunchedJobWrapper implements LaunchedJob {
        private final ca job;

        public LaunchedJobWrapper(ca r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
            o.e(r4, "job");
            this.job = r4;
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.LaunchedJob
        public ca getJob() {
            return this.job;
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.LaunchedJob
        public void cancel() {
            ca.a.a(getJob(), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: AOThreadingTools.kt */
    public static final class SingleThreadCoroutineScopeWrapper implements AOThreadLauncher {
        public static final Companion Companion = null;
        private static final String TAG = "SingleTh-CSWrapper";
        private final CoroutineScopeWrapper mCoroutineScope;
        private ThreadPoolExecutor mExecutor;
        private final String name;
        private volatile Thread underlyingThread;
        private final WorkingThreadWatchdog watchdog;

        /* JADX INFO: compiled from: AOThreadingTools.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public static /* synthetic */ CharSequence lambda$7GtS8RXMnj6ddSTkuLswvK16AAM(StackTraceElement r0) {
            return captureThreadDiagnosticsOneLine$lambda$7(r0);
        }

        public static /* synthetic */ Thread lambda$NWHtN9TE78lR6dSK4nzc_qX1qCM(SingleThreadCoroutineScopeWrapper r0, Runnable r1) {
            return _init_$lambda$0(r0, r1);
        }

        public SingleThreadCoroutineScopeWrapper(String r12, boolean r13) {
            o.e(r12, "name");
            this.name = r12;
            if (r13 == true) goto L5;
        L9:
            WorkingThreadWatchdog r14 = null;
        L10:
            this.watchdog = r14;
            ThreadPoolExecutor r8 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), new $$Lambda$AOThreadingTools$SingleThreadCoroutineScopeWrapper$NWHtN9TE78lR6dSK4nzc_qX1qCM(this));
            this.mExecutor = r8;
            Loog.INSTANCE.d(TAG, " - [threading] created executor `" + r12 + '`');
            this.mCoroutineScope = new CoroutineScopeWrapper(an.a((g) ZeusTransformUtils.preCheckCast(br.a((ExecutorService) ZeusTransformUtils.preCheckCast(r8, ExecutorService.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")));
            if (r14 == null) goto L14;
            r14.start();
            return;
        L14:
            return;
        L5:
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L7;
        L8:
            r14 = new WorkingThreadWatchdog(this, 0, 0, 0, 0, 30, null);
            goto L10
        L7:
            if (AOThreadingTools.access$getSettingConfigWatchDog$p() == false) goto L9;
            goto L8
        }

        public /* synthetic */ SingleThreadCoroutineScopeWrapper(String r1, boolean r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = false;
        L5:
            this(r1, r2);
        }

        public final String getName() {
            return this.name;
        }

        public final Thread getUnderlyingThread() {
            return this.underlyingThread;
        }

        public final WorkingThreadWatchdog getWatchdog() {
            return this.watchdog;
        }

        private static final Thread _init_$lambda$0(SingleThreadCoroutineScopeWrapper r3, Runnable r4) {
            Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"), r3.name);
            r3.underlyingThread = r0;
            Loog.INSTANCE.d(TAG, " - [threading] creating thread `" + r3.name + "`... tId=" + r0.getId());
            return r0;
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public am getCoroutineScope() {
            return this.mCoroutineScope.getCoroutineScope();
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public LaunchedJob launch(b<? super d<? super x>, ? extends Object> r3) {
            b<? super d<? super x>, ? extends Object> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "block");
            return this.mCoroutineScope.launch(r4);
        }

        @Override // com.obric.autogui.common.api.threading.AOThreadingTools.AOThreadLauncher
        public void shutdown() {
            WorkingThreadWatchdog r0 = this.watchdog;
            if (r0 == null) goto L5;
            r0.stop();
        L5:
            this.mCoroutineScope.shutdown();
            ThreadPoolExecutor r1 = this.mExecutor;
            if (r1 == null) goto L8;
            r1.shutdown();
        L8:
            this.underlyingThread = null;
            Loog.INSTANCE.d(TAG, " - [threading] destroyed executor `" + this.name + '`');
        }

        public final void forceShutdown(String r14) {
            o.e(r14, "reason");
            Thread r2 = this.underlyingThread;
            ThreadPoolExecutor r3 = this.mExecutor;
            Loog.INSTANCE.w(TAG, " - [threading] force shutdown begin `" + this.name + "`, reason=" + r14 + ", stateBefore={" + describeState() + '}');
            WorkingThreadWatchdog r4 = this.watchdog;
            if (r4 == null) goto L51;
            r4.stop();
        L51:
            n.a r5 = n.f38560a;     // Catch: Throwable -> L7
            SingleThreadCoroutineScopeWrapper r6 = (SingleThreadCoroutineScopeWrapper) ZeusTransformUtils.preCheckCast(this, SingleThreadCoroutineScopeWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            an.a(r6.getCoroutineScope(), new CancellationException("force shutdown `" + r6.name + "`: " + r14));     // Catch: Throwable -> L7
            Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r8 = n.c(r7);
            if (r8 == null) goto L53;
            Loog.INSTANCE.e(TAG, " - [threading] failed to force cancel `" + this.name + '`', r8);
        L53:
            n.a r9 = n.f38560a;     // Catch: Throwable -> L21
            SingleThreadCoroutineScopeWrapper r10 = (SingleThreadCoroutineScopeWrapper) ZeusTransformUtils.preCheckCast(this, SingleThreadCoroutineScopeWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            if (r3 == null) goto L18;
            List<Runnable> r11 = r3.shutdownNow();     // Catch: Throwable -> L21
            if (r11 == null) goto L18;
            Integer r12 = Integer.valueOf(r11.size());     // Catch: Throwable -> L21
        L19:
            Object r13 = n.f(r12);     // Catch: Throwable -> L21
        L23:
            Throwable r15 = n.c(r13);
            if (r15 == null) goto L27;
            Loog.INSTANCE.e(TAG, " - [threading] failed to shutdownNow `" + this.name + '`', r15);
        L27:
            if (n.b(r13) == false) goto L29;
            r13 = null;
        L29:
            Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.aiagent.plugin");
            n.a r17 = n.f38560a;     // Catch: Throwable -> L36
            SingleThreadCoroutineScopeWrapper r0 = (SingleThreadCoroutineScopeWrapper) ZeusTransformUtils.preCheckCast(this, SingleThreadCoroutineScopeWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            if (r2 == null) goto L33;
            r2.interrupt();     // Catch: Throwable -> L36
            x r1 = x.f38692a;     // Catch: Throwable -> L36
        L34:
            Object r18 = n.f(r1);     // Catch: Throwable -> L36
        L38:
            Throwable r19 = n.c(r18);
            if (r19 == null) goto L41;
            Loog.INSTANCE.e(TAG, " - [threading] failed to interrupt `" + this.name + '`', r19);
        L41:
            Loog r20 = Loog.INSTANCE;
            StringBuilder r110 = new StringBuilder().append(" - [threading] force shutdown end `").append(this.name).append("`, reason=").append(r14).append(", droppedTasks=").append(r16).append(", aliveAfter=");
            if (r2 == null) goto L44;
            Boolean r21 = Boolean.valueOf(r2.isAlive());
        L45:
            StringBuilder r111 = r110.append(r21).append(", stateAfter=");
            if (r2 == null) goto L48;
            Thread.State r22 = r2.getState();
        L49:
            r20.w(TAG, r111.append(r22).append(", stateAfterFull={").append(describeState()).append('}').toString());
            this.underlyingThread = null;
            return;
        L48:
            r22 = null;
            goto L49
        L44:
            r21 = null;
            goto L45
        L33:
            r1 = null;
        L36:
            th = move-exception;
            n.a r23 = n.f38560a;
            r18 = n.f(d.o.a(th));
        L18:
            r12 = null;
        L21:
            th = move-exception;
            n.a r24 = n.f38560a;
            r13 = n.f(d.o.a(th));
        L7:
            th = move-exception;
            n.a r25 = n.f38560a;
            r7 = n.f(d.o.a(th));
            goto L9
        }

        public final String describeState() {
            Thread r0 = this.underlyingThread;
            ThreadPoolExecutor r1 = this.mExecutor;
            StringBuilder r2 = new StringBuilder();
            StringBuilder r3 = r2.append("name=").append(this.name).append(", thread=");
            String r4 = null;
            if (r0 == null) goto L5;
            String r5 = r0.getName();
        L6:
            StringBuilder r6 = r3.append(r5).append(", tId=");
            if (r0 == null) goto L9;
            Long r7 = Long.valueOf(r0.getId());
        L10:
            StringBuilder r8 = r6.append(r7).append(", state=");
            if (r0 == null) goto L13;
            Thread.State r9 = r0.getState();
        L14:
            StringBuilder r10 = r8.append(r9).append(", alive=");
            if (r0 == null) goto L17;
            Boolean r11 = Boolean.valueOf(r0.isAlive());
        L18:
            StringBuilder r12 = r10.append(r11).append(", executorShutdown=");
            if (r1 == null) goto L21;
            Boolean r13 = Boolean.valueOf(r1.isShutdown());
        L22:
            StringBuilder r14 = r12.append(r13).append(", executorTerminated=");
            if (r1 == null) goto L25;
            Boolean r15 = Boolean.valueOf(r1.isTerminated());
        L26:
            StringBuilder r16 = r14.append(r15).append(", queueSize=");
            if (r1 == null) goto L31;
            BlockingQueue<Runnable> r17 = r1.getQueue();
            if (r17 == null) goto L31;
            Integer r18 = Integer.valueOf(r17.size());
        L32:
            StringBuilder r19 = r16.append(r18).append(", activeCount=");
            if (r1 == null) goto L35;
            Integer r20 = Integer.valueOf(r1.getActiveCount());
        L36:
            StringBuilder r21 = r19.append(r20).append(", taskCount=");
            if (r1 == null) goto L39;
            Long r22 = Long.valueOf(r1.getTaskCount());
        L40:
            StringBuilder r23 = r21.append(r22).append(", completedTaskCount=");
            if (r1 == null) goto L43;
            Long r24 = Long.valueOf(r1.getCompletedTaskCount());
        L44:
            r23.append(r24).append(", watchdogEnabled=");
            if (this.watchdog == null) goto L47;
            boolean r25 = true;
        L48:
            StringBuilder r26 = r2.append(r25).append(", watchdog={");
            WorkingThreadWatchdog r27 = this.watchdog;
            if (r27 == null) goto L51;
            r4 = r27.describeState();
        L51:
            r26.append(r4).append('}');
            return r2.toString();
        L47:
            r25 = false;
            goto L48
        L43:
            r24 = null;
            goto L44
        L39:
            r22 = null;
            goto L40
        L35:
            r20 = null;
        L31:
            r18 = null;
            goto L32
        L25:
            r15 = null;
            goto L26
        L21:
            r13 = null;
            goto L22
        L17:
            r11 = null;
            goto L18
        L13:
            r9 = null;
            goto L14
        L9:
            r7 = null;
            goto L10
        L5:
            r5 = null;
            goto L6
        }

        public static /* synthetic */ String captureThreadDiagnosticsOneLine$default(SingleThreadCoroutineScopeWrapper r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = 32;
        L6:
            return r0.captureThreadDiagnosticsOneLine(r1);
        }

        public final String captureThreadDiagnosticsOneLine(int r13) {
            Thread r12 = this.underlyingThread;
            if (r12 != null) goto L6;
            return null;
        L6:
            StackTraceElement[] r0 = r12.getStackTrace();
            o.c(r0, "getStackTrace(...)");
            return "thread=" + r12.getName() + ", tId=" + r12.getId() + ", state=" + r12.getState() + ", stack=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.i.c((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.aiagent.plugin"), r13), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" <- ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$AOThreadingTools$SingleThreadCoroutineScopeWrapper$7GtS8RXMnj6ddSTkuLswvK16AAM.INSTANCE, 30, null);
        }

        private static final CharSequence captureThreadDiagnosticsOneLine$lambda$7(StackTraceElement r2) {
            String r3 = r2.toString();
            o.c(r3, "toString(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.AOThreadingTools$launchIO$1, reason: invalid class name */
    /* JADX INFO: compiled from: AOThreadingTools.kt */
    @f(b = "AOThreadingTools.kt", c = {210}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$launchIO$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ m<am, d<? super T>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(m<? super am, ? super d<? super T>, ? extends Object> r3, d<? super AnonymousClass1> r4) {
            m<am, d<? super T>, Object> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$block = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$block, r5);
            r0.L$0 = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.obric.autogui.common.api.threading.AOThreadingTools$launchIO$1 for r4v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            java.lang.Object r0 = d.c.a.b.a();
            int r1 = r4.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r5);
        L11:
            d.x r4 = d.x.f38692a;
            return r4;
        L6:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r4;
        L8:
            d.o.a(r5);
            java.lang.Object r5 = r4.L$0;
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.am r5 = (kotlinx.coroutines.am) r5;
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, java.lang.Object> r1 = r4.$block;
            r4.label = 1;
            java.lang.Object r4 = (d.c.d<? super T>) r4;
            java.lang.Object r4 = r1.invoke(r5, r4);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.AOThreadingTools$launchUI$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOThreadingTools.kt */
    @f(b = "AOThreadingTools.kt", c = {229}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$launchUI$1")
    static final class C11461 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ m<am, d<? super T>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        C11461(m<? super am, ? super d<? super T>, ? extends Object> r3, d<? super C11461> r4) {
            m<am, d<? super T>, Object> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$block = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            C11461 r0 = new C11461(this.$block, r5);
            r0.L$0 = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11461) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11461.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.obric.autogui.common.api.threading.AOThreadingTools$launchUI$1 for r4v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            java.lang.Object r0 = d.c.a.b.a();
            int r1 = r4.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r5);
        L11:
            d.x r4 = d.x.f38692a;
            return r4;
        L6:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r4;
        L8:
            d.o.a(r5);
            java.lang.Object r5 = r4.L$0;
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.am r5 = (kotlinx.coroutines.am) r5;
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, java.lang.Object> r1 = r4.$block;
            r4.label = 1;
            java.lang.Object r4 = (d.c.d<? super T>) r4;
            java.lang.Object r4 = r1.invoke(r5, r4);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.AOThreadingTools$launchUIDelayed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOThreadingTools.kt */
    @f(b = "AOThreadingTools.kt", c = {236, 237}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$launchUIDelayed$1")
    static final class C11471 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ m<am, d<? super T>, Object> $block;
        final /* synthetic */ long $delayMillis;
        private /* synthetic */ Object L$0;
        int label;

        C11471(long r3, m<? super am, ? super d<? super T>, ? extends Object> r5, d<? super C11471> r6) {
            m<am, d<? super T>, Object> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$delayMillis = r3;
            this.$block = r7;
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r5, d<?> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            C11471 r0 = new C11471(this.$delayMillis, this.$block, r7);
            r0.L$0 = r5;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11471) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11471.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.obric.autogui.common.api.threading.AOThreadingTools$launchUIDelayed$1 for r8v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            java.lang.Object r0 = d.c.a.b.a();
            int r1 = r8.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            d.o.a(r9);
        L16:
            d.x r8 = d.x.f38692a;
            return r8;
        L7:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r8;
        L9:
            java.lang.Object r1 = r8.L$0;
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.am r1 = (kotlinx.coroutines.am) r1;
            d.o.a(r9);
        L13:
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, java.lang.Object> r9 = r8.$block;
            r8.L$0 = null;
            r8.label = 2;
            java.lang.Object r8 = (d.c.d<? super T>) r8;
            java.lang.Object r8 = r9.invoke(r1, r8);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            d.o.a(r9);
            java.lang.Object r9 = r8.L$0;
            java.lang.Object r9 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r9, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            r1 = (kotlinx.coroutines.am) r9;
            com.obric.autogui.common.api.threading.AOThreadingTools r9 = com.obric.autogui.common.api.threading.AOThreadingTools.INSTANCE;
            long r5 = r8.$delayMillis;
            java.lang.Object r4 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r4 = (d.c.d) r4;
            r8.L$0 = r1;
            r8.label = 1;
            java.lang.Object r9 = r9.delayForMillis(r5, r4);
            if (r9 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.AOThreadingTools$runUntilReturn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOThreadingTools.kt */
    @f(b = "AOThreadingTools.kt", c = {243}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingTools$runUntilReturn$1")
    static final class C11481 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ b<d<? super x>, Object> $block;
        int label;

        C11481(b<? super d<? super x>, ? extends Object> r3, d<? super C11481> r4) {
            b<d<? super x>, Object> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$block = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11481(this.$block, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11481) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11481.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r4);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r4);
            b<d<? super x>, Object> r5 = this.$block;
            this.label = 1;
            if (r5.invoke(this) != r0) goto L12;
            return r0;
        }
    }

    private AOThreadingTools() {
    }

    public static final /* synthetic */ boolean access$getSettingConfigWatchDog$p() {
        return settingConfigWatchDog;
    }

    static {
        INSTANCE = new AOThreadingTools();
        settingConfigWatchDog = AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_watch_dog", false);
        mIOScope = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
        mUIScope = an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ SingleThreadCoroutineScopeWrapper createSingleThreadCoroutineScope$default(AOThreadingTools r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.createSingleThreadCoroutineScope(r1, r2);
    }

    public final SingleThreadCoroutineScopeWrapper createSingleThreadCoroutineScope(String r1, boolean r2) {
        o.e(r1, "name");
        return new SingleThreadCoroutineScopeWrapper(r1, r2);
    }

    public final Object delayForMillis(long r2, d<? super x> r4) {
        Object r1 = ax.a(r2, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
        if (r1 != d.c.a.b.a()) goto L6;
        return r1;
    L6:
        return x.f38692a;
    }

    public final <T> Object runIO(m<? super am, ? super d<? super T>, ? extends Object> r3, d<? super T> r4) {
        m r2 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), r2, r5);
    }

    public final <T> Object runIn(AOThreadLauncher r2, m<? super am, ? super d<? super T>, ? extends Object> r3, d<? super T> r4) {
        AOThreadLauncher r1 = (AOThreadLauncher) ZeusTransformUtils.wrapperContextForParams(r2, AOThreadLauncher.class, "com.obric.aiagent.plugin");
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return i.a(r1.getCoroutineScope().a(), r5, r6);
    }

    public final <T> void launchIO(m<? super am, ? super d<? super T>, ? extends Object> r8) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        o.e(r7, "block");
        i.a(mIOScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final LaunchedJob launchIOJob(m<? super am, ? super d<? super x>, ? extends Object> r8) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        o.e(r7, "block");
        return (LaunchedJob) ZeusTransformUtils.preCheckCast(new LaunchedJobWrapper(i.a(mIOScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AOThreadingTools$launchIOJob$job$1(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null)), LaunchedJob.class, "com.obric.aiagent.plugin");
    }

    public final <T> void launchUI(m<? super am, ? super d<? super T>, ? extends Object> r8) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        o.e(r7, "block");
        i.a(mUIScope, null, null, (m) ZeusTransformUtils.preCheckCast(new C11461(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final <T> void launchUIDelayed(long r8, m<? super am, ? super d<? super T>, ? extends Object> r10) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r10, m.class, "com.obric.aiagent.plugin");
        o.e(r7, "block");
        i.a(mUIScope, null, null, (m) ZeusTransformUtils.preCheckCast(new C11471(r8, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void runUntilReturn(b<? super d<? super x>, ? extends Object> r3) {
        b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r2, "block");
        i.a(null, (m) ZeusTransformUtils.preCheckCast(new C11481(r2, null), m.class, "com.obric.aiagent.plugin"), 1, null);
    }
}
