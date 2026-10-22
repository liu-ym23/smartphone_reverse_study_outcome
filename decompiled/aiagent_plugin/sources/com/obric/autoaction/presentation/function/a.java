package com.obric.autoaction.presentation.function;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.b.h;
import d.o;
import d.x;

/* JADX INFO: compiled from: AgentFunctionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0580a f24904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f24907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f24908e;
    private long f;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.function.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentFunctionController.kt */
    public static final class C0580a {
        public /* synthetic */ C0580a(h r1) {
            this();
        }

        private C0580a() {
        }
    }

    /* JADX INFO: compiled from: AgentFunctionController.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f24909a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f24910b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f24911c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f24912d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f24913e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f24909a, f24910b, f24911c, f24912d};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f24909a = new b("Inactive", 0);
            f24910b = new b("Starting", 1);
            f24911c = new b("Started", 2);
            f24912d = new b("Stopping", 3);
            b[] r0 = a();
            f24913e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f24913e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AgentFunctionController.kt */
    @d.c.b.a.f(b = "AgentFunctionController.kt", c = {ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.AgentFunctionController$onFunctionStarted$1")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24915b;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24915b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24915b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24914a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autoaction.presentation.c r8 = com.obric.autoaction.presentation.c.f24841a;
            String r2 = a.a(this.f24915b);
            com.obric.autoaction.presentation.b.d r3 = com.obric.autoaction.presentation.b.d.f24818a;
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24914a = 1;
            if (r8.a(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentFunctionController.kt */
    @d.c.b.a.f(b = "AgentFunctionController.kt", c = {102}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.AgentFunctionController$onFunctionStopped$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24917b;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24917b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24917b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24916a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autoaction.presentation.c r8 = com.obric.autoaction.presentation.c.f24841a;
            String r2 = a.a(this.f24917b);
            com.obric.autoaction.presentation.b.d r3 = com.obric.autoaction.presentation.b.d.f24819b;
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24916a = 1;
            if (r8.a(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentFunctionController.kt */
    @d.c.b.a.f(b = "AgentFunctionController.kt", c = {57}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.AgentFunctionController$startFunction$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24919b;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24919b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24919b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24918a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            com.obric.autogui.common.e r7 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r7.g() == true) goto L15;
            a.a(this.f24919b, b.f24909a);
            Loog.INSTANCE.w(a.b(this.f24919b), "not started ManualOp mode: " + r7.h());
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            AutoActionAgent r8 = AutoActionAgent.INSTANCE;
            String r2 = a.a(this.f24919b);
            d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24918a = 1;
            r6 = r8.startFunction(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentFunctionController.kt */
    @d.c.b.a.f(b = "AgentFunctionController.kt", c = {86}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.AgentFunctionController$stopFunction$1")
    static final class f extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24921b;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24921b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f24921b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24920a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            com.obric.autogui.common.e r7 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r7.g() == true) goto L15;
            a.a(this.f24921b, b.f24909a);
            Loog.INSTANCE.w(a.b(this.f24921b), "stop ManualOp mode failed: " + r7.h() + ". setting its status to Inactive.");
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            AutoActionAgent r8 = AutoActionAgent.INSTANCE;
            String r2 = a.a(this.f24921b);
            d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24920a = 1;
            r6 = r8.stopFunction(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        f24904a = new C0580a(null);
    }

    public a(String r3) {
        d.h.b.o.e(r3, "functionName");
        this.f24905b = r3;
        this.f24906c = "AgentFuncCtrl-" + r3;
        this.f24907d = new Object();
        this.f24908e = b.f24909a;
    }

    public static final /* synthetic */ String a(a r0) {
        return r0.f24905b;
    }

    public static final /* synthetic */ void a(a r0, b r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ String b(a r0) {
        return r0.f24906c;
    }

    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper g() {
        return com.obric.autoaction.e.d.f24682a.a();
    }

    public final b a() {
        return this.f24908e;
    }

    public final long b() {
        return this.f;
    }

    private final void a(b r4) {
        Object r0 = this.f24907d;
        monitor-enter(r0);
        this.f24908e = r4;     // Catch: Throwable -> L7
        this.f = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L7
        x r3 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        if (this.f24908e == b.f24909a) goto L6;
        Loog.INSTANCE.d(this.f24906c, "only Inactive function is startable. status=" + this.f24908e);
        return;
    L6:
        a(b.f24910b);
        g().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public void d() {
        Loog.INSTANCE.d(this.f24906c, "[AgentFunc] started " + this.f24905b);
        a(b.f24911c);
        g().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void e() {
        if (this.f24908e == b.f24911c) goto L6;
        Loog.INSTANCE.d(this.f24906c, "only Started function is stoppable. [" + this.f24905b + "] status=" + this.f24908e);
        return;
    L6:
        a(b.f24912d);
        g().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public void f() {
        Loog.INSTANCE.d(this.f24906c, "[AgentFunc] stopped " + this.f24905b);
        a(b.f24909a);
        g().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }
}
