package com.obric.autogui.session.functions;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.l;
import d.h.b.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.session.functions.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.session.a f30983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autogui.session.functions.a f30984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<c> f30985c;

    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    private final class a<T extends com.obric.autogui.session.functions.a> extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f30986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m<T, d.c.d<? super x>, Object> f30987b;

        /* JADX INFO: renamed from: com.obric.autogui.session.functions.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
        @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {99}, d = "prepareForRunning", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager$AttachmentJob")
        static final class C0845a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f30988a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f30989b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a<T> f30990c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f30991d;

            C0845a(a<T> r3, d.c.d<? super C0845a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30990c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f30989b = r3;
                this.f30991d |= Integer.MIN_VALUE;
                return this.f30990c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.session.functions.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
        @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {134, 138}, d = "runJob", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager$AttachmentJob")
        static final class C0846b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f30992a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f30993b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f30994c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a<T> f30995d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f30996e;

            C0846b(a<T> r3, d.c.d<? super C0846b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30995d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f30994c = r3;
                this.f30996e |= Integer.MIN_VALUE;
                return this.f30995d.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public a(b r9, Class<T> r10, m<? super T, ? super d.c.d<? super x>, ? extends Object> r11) {
            m<T, d.c.d<? super x>, Object> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
            o.e(r10, "functionType");
            this.f30986a = r9;
            super(r10, 0, null, 6, null);
            this.f30987b = r12;
        }

        public /* synthetic */ a(b r2, Class r3, m r4, int r5, h r6) {
            m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L5;
            r7 = null;
        L5:
            this(r2, r3, r7);
        }

        @Override // com.obric.autogui.session.functions.b.c
        public boolean a() {
            com.obric.autogui.session.functions.a r0 = b.b(this.f30986a);
            if (r0 == null) goto L5;
            Class<?> r1 = r0.getClass();
        L7:
            return !o.a(r1, b());
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.obric.autogui.session.functions.b.c
        public Object a(d.c.d<? super com.obric.autogui.common.e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, C0845a.class) == false) goto L7;
            C0845a r0 = (C0845a) ZeusTransformUtils.preCheckCast(r9, C0845a.class, "com.obric.aiagent.plugin");
            if ((r0.f30991d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f30991d -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f30989b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f30991d;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.f30988a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
        L19:
            com.obric.autogui.session.functions.a r11 = (com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(this.b().newInstance(), com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin");
            r11.b(b.c(this.f30986a));
            com.obric.autogui.common.e r1 = r11.c();
            if (r1.g() == true) goto L23;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot start function: (" + this.b() + ") at this time (" + r1 + ").`");
            return r1;
        L23:
            this.a(r11);
            return com.obric.autogui.common.e.f29014b.a();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r10);
            if (b.b(this.f30986a) == null) goto L19;
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "stop ongoing function (during attachment) (" + b.b(this.f30986a) + ").");
            b r12 = this.f30986a;
            r0.f30988a = this;
            r0.f30991d = 1;
            if (b.a(r12, r0) != r2) goto L19;
            return r2;
        L7:
            r0 = new C0845a(this, r9);
            goto L8
        }

        @Override // com.obric.autogui.session.functions.b.c
        public Object b(d.c.d<? super com.obric.autogui.common.e> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, C0846b.class) == false) goto L7;
            C0846b r1 = (C0846b) ZeusTransformUtils.preCheckCast(r11, C0846b.class, "com.obric.aiagent.plugin");
            if ((r1.f30996e & Integer.MIN_VALUE) == 0) goto L7;
            r1.f30996e -= Integer.MIN_VALUE;
        L8:
            Object r12 = r1.f30994c;
            Object r3 = d.c.a.b.a();
            int r4 = r1.f30996e;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            com.obric.autogui.session.functions.a r9 = (com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(r1.f30993b, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin");
            a<T> r0 = (a) ZeusTransformUtils.preCheckCast(r1.f30992a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L32:
            com.obric.autogui.common.e r13 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r13.g() == true) goto L36;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r0), "failed to start function: " + r13);
            return r13;
        L36:
            b.a(r0.f30986a, r9);
            return com.obric.autogui.common.e.f29014b.a();
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            com.obric.autogui.session.functions.a r14 = (com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(r1.f30993b, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin");
            a<T> r2 = (a) ZeusTransformUtils.preCheckCast(r1.f30992a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
            com.obric.autogui.session.functions.a r15 = r14;
            a<T> this = r2;
        L28:
            com.obric.autogui.session.functions.a r8 = r15;
            a<T> r16 = this;
            r9 = r8;
            r1.f30992a = r16;
            r1.f30993b = r9;
            r1.f30996e = 2;
            Object r5 = r9.a(r1);
            if (r5 != r3) goto L31;
            return r3;
        L31:
            r0 = r16;
            r12 = r5;
            goto L32
        L16:
            d.o.a(r12);
            r15 = c();
            if (r15 != null) goto L20;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot start function: (" + b() + ") at this time (null).`");
            return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
        L20:
            if (r15 != null) goto L23;
            Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "during attachment: " + r15 + " is not a " + b());
            return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
        L23:
            m<T, d.c.d<? super x>, Object> r6 = this.f30987b;
            if (r6 == null) goto L28;
            r1.f30992a = this;
            r1.f30993b = r15;
            r1.f30996e = 1;
            if (r6.invoke((T) r15, r1) != r3) goto L28;
            return r3;
        L7:
            r1 = new C0846b(this, r11);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    private final class C0847b<T extends com.obric.autogui.session.functions.a> extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f30997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m<T, d.c.d<? super x>, Object> f30998b;

        /* JADX INFO: renamed from: com.obric.autogui.session.functions.b$b$a */
        /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
        @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {219, 222}, d = "runJob", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager$DetachmentJob")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f30999a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f31000b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ C0847b<T> f31001c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f31002d;

            a(C0847b<T> r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31001c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f31000b = r3;
                this.f31002d |= Integer.MIN_VALUE;
                return this.f31001c.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        @Override // com.obric.autogui.session.functions.b.c
        public boolean a() {
            return true;
        }

        public C0847b(b r9, Class<T> r10, m<? super T, ? super d.c.d<? super x>, ? extends Object> r11) {
            m<T, d.c.d<? super x>, Object> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
            o.e(r10, "functionType");
            this.f30997a = r9;
            super(r10, 0, null, 6, null);
            this.f30998b = r12;
        }

        public /* synthetic */ C0847b(b r2, Class r3, m r4, int r5, h r6) {
            m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L5;
            r7 = null;
        L5:
            this(r2, r3, r7);
        }

        @Override // com.obric.autogui.session.functions.b.c
        public Object a(d.c.d<? super com.obric.autogui.common.e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            if (b.b(this.f30997a) == null) goto L13;
            com.obric.autogui.session.functions.a r7 = b.b(this.f30997a);
            if (r7 == null) goto L7;
            Class<?> r8 = r7.getClass();
        L9:
            if (o.a(r8, b()) == false) goto L13;
            return com.obric.autogui.common.e.f29014b.a();
        L7:
            r8 = null;
        L13:
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot detach function: (" + b.b(this.f30997a) + ", " + b() + ") at this time (not running).");
            return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
        }

        @Override // com.obric.autogui.session.functions.b.c
        public Object b(d.c.d<? super com.obric.autogui.common.e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if ((r0.f31002d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f31002d -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.f31000b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f31002d;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            d.o.a(r10);
        L30:
            return com.obric.autogui.common.e.f29014b.a();
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            C0847b<T> this = (C0847b) ZeusTransformUtils.preCheckCast(r0.f30999a, C0847b.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
        L26:
            b r7 = this.f30997a;
            r0.f30999a = null;
            r0.f31002d = 2;
            if (b.a(r7, r0) != r2) goto L30;
            return r2;
        L16:
            d.o.a(r10);
            com.obric.autogui.session.functions.a r11 = b.b(this.f30997a);
            if (r11 == null) goto L26;
            if (r11 != null) goto L21;
            Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "during detachment: " + r11 + " is not a " + b());
            return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
        L21:
            m<T, d.c.d<? super x>, Object> r1 = this.f30998b;
            if (r1 == null) goto L26;
            r0.f30999a = this;
            r0.f31002d = 1;
            if (r1.invoke((T) r11, r0) != r2) goto L26;
            return r2;
        L7:
            r0 = new a(this, r9);
            goto L8
        }
    }

    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<? extends com.obric.autogui.session.functions.a> f31003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f31004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.obric.autogui.session.functions.a f31005c;

        public abstract Object a(d.c.d<? super com.obric.autogui.common.e> r1);

        public abstract boolean a();

        public abstract Object b(d.c.d<? super com.obric.autogui.common.e> r1);

        public c(Class<? extends com.obric.autogui.session.functions.a> r2, long r3, com.obric.autogui.session.functions.a r5) {
            o.e(r2, "functionType");
            this.f31003a = r2;
            this.f31004b = r3;
            this.f31005c = r5;
        }

        public final Class<? extends com.obric.autogui.session.functions.a> b() {
            return this.f31003a;
        }

        public /* synthetic */ c(Class r1, long r2, com.obric.autogui.session.functions.a r4, int r5, h r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = AOSystemTools.INSTANCE.nowTimeMillis();
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r1, r2, r4);
        }

        public final void a(com.obric.autogui.session.functions.a r1) {
            this.f31005c = r1;
        }

        public final com.obric.autogui.session.functions.a c() {
            return this.f31005c;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    /* synthetic */ class d<T> extends l implements m<T, d.c.d<? super x>, Object> {
        d(Object r8) {
            super(2, r8, o.a.class, "suspendConversion0", "attachFunction$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/obric/autogui/session/functions/AOSessionFunction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* JADX WARN: Incorrect types in method signature: (TT;Ld/c/d<-Ld/x;>;)Ljava/lang/Object; */
        public final Object a(com.obric.autogui.session.functions.a r3, d.c.d r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return b.a((d.h.a.b) ZeusTransformUtils.preCheckCast(this.receiver, d.h.a.b.class, "com.obric.aiagent.plugin"), r3, r5);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super x> r4) {
            return a((com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {57}, d = "runJobAsync", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31010e;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31009d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31008c = r3;
            this.f31010e |= Integer.MIN_VALUE;
            return b.a(this.f31009d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {69}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager$runJobAsync$2")
    static final class f extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f31011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f31013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f31014d;

        f(b r3, c r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31013c = r3;
            this.f31014d = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f31013c, this.f31014d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31012b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.f31011a;
            d.o.a(r10);
        L12:
            com.obric.autogui.common.e r11 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r11.g() == true) goto L15;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this.f31013c), "function job (" + this.f31014d.b() + ") failed: " + r11 + ".`");
        L15:
            Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this.f31013c), " - function job (" + this.f31014d.b() + ") finished (elapsed=" + (AOSystemTools.INSTANCE.nowTimeMillis() - r2) + ").");
            b.a(this.f31013c).set(null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            long r5 = AOSystemTools.INSTANCE.nowTimeMillis();
            Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this.f31013c), " - started function job (" + this.f31014d.b() + ").");
            c r12 = this.f31014d;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31011a = r5;
            this.f31012b = 1;
            r10 = r12.b(r3);
            if (r10 != r0) goto L11;
            return r0;
        L11:
            r2 = r5;
            goto L12
        }
    }

    /* JADX INFO: compiled from: AOSessionSingletonFunctionManager.kt */
    @d.c.b.a.f(b = "AOSessionSingletonFunctionManager.kt", c = {267}, d = "stopOngoingFunction", e = "com.obric.autogui.session.functions.AOSessionSingletonFunctionManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31019e;

        g(b r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31018d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31017c = r3;
            this.f31019e |= Integer.MIN_VALUE;
            return b.a(this.f31018d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public b(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        this.f30983a = r2;
        this.f30985c = new AtomicReference(null);
    }

    public static final /* synthetic */ Object a(b r2, c r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d.h.a.b r2, com.obric.autogui.session.functions.a r3, d.c.d r4) {
        return b((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin"), r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicReference a(b r0) {
        return r0.f30985c;
    }

    public static final /* synthetic */ void a(b r0, com.obric.autogui.session.functions.a r1) {
        r0.f30984b = r1;
    }

    public static final /* synthetic */ com.obric.autogui.session.functions.a b(b r0) {
        return r0.f30984b;
    }

    public static final /* synthetic */ com.obric.autogui.session.a c(b r0) {
        return r0.f30983a;
    }

    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper a() {
        return this.f30983a.m().a();
    }

    private final Object a(c r8, d.c.d<? super com.obric.autogui.common.e> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin");
        if ((r0.f31010e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31010e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f31008c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31010e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (c) ZeusTransformUtils.preCheckCast(r0.f31007b, c.class, "com.obric.aiagent.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f31006a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L25:
        com.obric.autogui.common.e r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r12.g() == true) goto L29;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "function job (" + r8 + ") not runnable (" + r12 + ").`");
        this.f30985c.set(null);
        return r12;
    L29:
        this.a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this, r8, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        if (this.f30985c.compareAndSet(null, r8) == true) goto L19;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "cannot run function job: (" + r8.b() + ") at this time (busy-for(" + ((c) ZeusTransformUtils.preCheckCast(this.f30985c.get(), c.class, "com.obric.aiagent.plugin")) + ")).`");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_function_attachment_is_in_progress, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_function_attachment_is_in_progress"), null, 2, null);
    L19:
        if (r8.a() == true) goto L22;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "function job (" + r8.b() + ") is not needed.`");
        this.f30985c.set(null);
        return com.obric.autogui.common.e.f29014b.a();
    L22:
        r0.f31006a = this;
        r0.f31007b = r8;
        r0.f31010e = 1;
        r11 = r8.a(r0);
        if (r11 != r2) goto L25;
        return r2;
    L7:
        r0 = new e(this, r10);
        goto L8
    }

    @Override // com.obric.autogui.session.functions.c
    public Object a(Class<? extends com.obric.autogui.session.functions.a> r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        d.c.d<? super com.obric.autogui.common.e> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return a((c) ZeusTransformUtils.preCheckCast(new a(this, r9, null, 2, null), c.class, "com.obric.aiagent.plugin"), r11);
    }

    @Override // com.obric.autogui.session.functions.c
    public <T extends com.obric.autogui.session.functions.a> Object a(Class<T> r4, d.h.a.b<? super T, x> r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a((c) ZeusTransformUtils.preCheckCast(new a(this, r4, (m) ZeusTransformUtils.preCheckCast(new d(r7), m.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin"), r8);
    }

    private static final /* synthetic */ Object b(d.h.a.b r2, com.obric.autogui.session.functions.a r3, d.c.d r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        r5.invoke(r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.c
    public <T extends com.obric.autogui.session.functions.a> T a(Class<T> r6) {
        o.e(r6, "functionType");
        T r0 = (T) this.f30984b;
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getting function: there's no attached (" + r6 + ") function.");
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, r0) == false) goto L9;
        return r0;
    L9:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "getting function: attached function is not (" + r6 + "); got " + r0 + '.');
        return null;
    }

    @Override // com.obric.autogui.session.functions.c
    public boolean b(Class<? extends com.obric.autogui.session.functions.a> r2) {
        o.e(r2, "functionType");
        return ZeusTransformUtils.instanceOf(r2, this.f30984b);
    }

    @Override // com.obric.autogui.session.functions.c
    public Object a(d.c.d<? super x> r12) {
        d.c.d<? super com.obric.autogui.common.e> r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.functions.a r0 = this.f30984b;
        if (r0 != null) goto L6;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "no function to detach.");
        return x.f38692a;
    L6:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "detach all function, ongoing = " + r0);
        Object r11 = a((c) ZeusTransformUtils.preCheckCast(new C0847b(this, r0.getClass(), null, 2, null), c.class, "com.obric.aiagent.plugin"), r13);
        if (r11 != d.c.a.b.a()) goto L10;
        return r11;
    L10:
        return x.f38692a;
    }

    @Override // com.obric.autogui.session.functions.c
    public Object b(Class<? extends com.obric.autogui.session.functions.a> r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        d.c.d<? super com.obric.autogui.common.e> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        C0847b r0 = new C0847b(this, r9, null, 2, null);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "detach function, ongoing = " + this.f30984b);
        return a((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin"), r11);
    }

    @Override // com.obric.autogui.session.functions.c
    public <T extends com.obric.autogui.session.functions.a> Object a(Class<T> r3, m<? super T, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return a((c) ZeusTransformUtils.preCheckCast(new C0847b(this, r3, r6), c.class, "com.obric.aiagent.plugin"), r7);
    }

    private final Object b(d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin");
        if ((r0.f31019e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31019e -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f31017c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31019e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.obric.autogui.session.functions.a r6 = (com.obric.autogui.session.functions.a) ZeusTransformUtils.preCheckCast(r0.f31016b, com.obric.autogui.session.functions.a.class, "com.obric.aiagent.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.f31015a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
        com.obric.autogui.session.functions.a r10 = r6;
        b this = r1;
        Object r4 = r9;
    L19:
        com.obric.autogui.common.e r5 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r5.g() == true) goto L23;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "failed to stop function: " + r10 + "; " + r5);
        return x.f38692a;
    L23:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "stopped function: " + r10 + " (ok)");
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r10 = this.f30984b;
        if (r10 == null) goto L25;
        this.f30984b = null;
        r0.f31015a = this;
        r0.f31016b = r10;
        r0.f31019e = 1;
        r4 = r10.b(r0);
        if (r4 != r2) goto L19;
        return r2;
    L7:
        r0 = new g(this, r8);
        goto L8
    }
}
