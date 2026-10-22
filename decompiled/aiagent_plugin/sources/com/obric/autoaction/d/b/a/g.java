package com.obric.autoaction.d.b.a;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.a.q;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AIAgentStopUsecaseImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: compiled from: AIAgentStopUsecaseImpl.kt */
    @d.c.b.a.f(b = "AIAgentStopUsecaseImpl.kt", c = {19, 22}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStopUsecaseImpl$invoke$1")
    static final class a extends l implements m<i<? super n<? extends com.obric.autogui.common.e>>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24675b;

        /* JADX INFO: renamed from: com.obric.autoaction.d.b.a.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AIAgentStopUsecaseImpl.kt */
        @d.c.b.a.f(b = "AIAgentStopUsecaseImpl.kt", c = {20}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStopUsecaseImpl$invoke$1$statusMessage$1")
        static final class C0571a extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24676a;

            C0571a(d.c.d<? super C0571a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return ((C0571a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0571a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0571a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24676a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r5);
                IAutoActionAgentApi r6 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24676a = 1;
                r5 = IAutoActionAgentApi.DefaultImpls.userTerminateQuery$default(r6, null, r2, 1, null);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            a r4 = new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f24675b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24674a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r9);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f24675b, i.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L13:
            com.obric.autogui.common.e r10 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            n.a r4 = n.f38560a;
            n r11 = n.g(n.f(r10));
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24675b = null;
            this.f24674a = 2;
            if (r2.emit(r11, r5) != r0) goto L17;
            return r0;
        L10:
            o.a(r9);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f24675b, i.class, "com.obric.aiagent.plugin");
            d.c.g r12 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin");
            m r6 = (m) ZeusTransformUtils.preCheckCast(new C0571a(null), m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24675b = r2;
            this.f24674a = 1;
            r9 = kotlinx.coroutines.i.a(r12, r6, r7);
            if (r9 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentStopUsecaseImpl.kt */
    @d.c.b.a.f(b = "AIAgentStopUsecaseImpl.kt", c = {24}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStopUsecaseImpl$invoke$2")
    static final class b extends l implements q<i<? super n<? extends com.obric.autogui.common.e>>, Throwable, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24679c;

        b(d.c.d<? super b> r3) {
            super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(i<? super n<? extends com.obric.autogui.common.e>> r2, Throwable r3, d.c.d<? super x> r4) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            b r5 = new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            r5.f24679c = r1;
            r5.f24678b = r3;
            return r5.invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(i<? super n<? extends com.obric.autogui.common.e>> r3, Throwable r4, d.c.d<? super x> r5) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24677a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            i r7 = (i) ZeusTransformUtils.preCheckCast(this.f24679c, i.class, "com.obric.aiagent.plugin");
            Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.f24678b, Throwable.class, "com.obric.aiagent.plugin");
            n.a r4 = n.f38560a;
            n r3 = n.g(n.f(o.a(r2)));
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24679c = null;
            this.f24677a = 1;
            if (r7.emit(r3, r5) != r0) goto L12;
            return r0;
        }
    }

    public g() {
    }

    public h<n<com.obric.autogui.common.e>> a() {
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin")), (q) ZeusTransformUtils.preCheckCast(new b(null), q.class, "com.obric.aiagent.plugin"));
    }
}
