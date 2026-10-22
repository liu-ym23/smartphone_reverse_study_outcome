package com.obric.autoaction.d.b.a;

import android.os.Bundle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.autogui.common.api.agent.AutoActionAgent;
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

/* JADX INFO: compiled from: AIAgentStartUsecaseImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: AIAgentStartUsecaseImpl.kt */
    @d.c.b.a.f(b = "AIAgentStartUsecaseImpl.kt", c = {19, 25}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStartUsecaseImpl$invoke$1")
    static final class a extends l implements m<i<? super n<? extends com.obric.autogui.common.e>>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.d.a.a f24667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24668c;

        /* JADX INFO: renamed from: com.obric.autoaction.d.b.a.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AIAgentStartUsecaseImpl.kt */
        @d.c.b.a.f(b = "AIAgentStartUsecaseImpl.kt", c = {20}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStartUsecaseImpl$invoke$1$statusMessage$1")
        static final class C0570a extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.d.a.a f24670b;

            C0570a(com.obric.autoaction.d.a.a r3, d.c.d<? super C0570a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24670b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return ((C0570a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0570a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0570a(this.f24670b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24669a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r9);
            L11:
                return r9;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r9);
                AutoActionAgent r2 = AutoActionAgent.INSTANCE;
                String r10 = this.f24670b.a();
                boolean r3 = this.f24670b.b();
                int r5 = this.f24670b.c();
                Bundle r4 = this.f24670b.d();
                d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24669a = 1;
                r9 = r2.postUserQuery(r10, r3, r4, r5, r6);
                if (r9 != r0) goto L11;
                return r0;
            }
        }

        a(com.obric.autoaction.d.a.a r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24667b = r3;
            super(2, r5);
        }

        public final Object a(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f24667b, r5);
            r0.f24668c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24666a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r9);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f24668c, i.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L13:
            com.obric.autogui.common.e r10 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            n.a r4 = n.f38560a;
            n r11 = n.g(n.f(r10));
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24668c = null;
            this.f24666a = 2;
            if (r2.emit(r11, r5) != r0) goto L17;
            return r0;
        L10:
            o.a(r9);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f24668c, i.class, "com.obric.aiagent.plugin");
            d.c.g r12 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin");
            m r6 = (m) ZeusTransformUtils.preCheckCast(new C0570a(this.f24667b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24668c = r2;
            this.f24666a = 1;
            r9 = kotlinx.coroutines.i.a(r12, r6, r7);
            if (r9 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentStartUsecaseImpl.kt */
    @d.c.b.a.f(b = "AIAgentStartUsecaseImpl.kt", c = {27}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentStartUsecaseImpl$invoke$2")
    static final class b extends l implements q<i<? super n<? extends com.obric.autogui.common.e>>, Throwable, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24673c;

        b(d.c.d<? super b> r3) {
            super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(i<? super n<? extends com.obric.autogui.common.e>> r2, Throwable r3, d.c.d<? super x> r4) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            b r5 = new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            r5.f24673c = r1;
            r5.f24672b = r3;
            return r5.invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(i<? super n<? extends com.obric.autogui.common.e>> r3, Throwable r4, d.c.d<? super x> r5) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24671a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            i r7 = (i) ZeusTransformUtils.preCheckCast(this.f24673c, i.class, "com.obric.aiagent.plugin");
            Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.f24672b, Throwable.class, "com.obric.aiagent.plugin");
            n.a r4 = n.f38560a;
            n r3 = n.g(n.f(o.a(r2)));
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24673c = null;
            this.f24671a = 1;
            if (r7.emit(r3, r5) != r0) goto L12;
            return r0;
        }
    }

    public f() {
    }

    public h<n<com.obric.autogui.common.e>> a(com.obric.autoaction.d.a.a r3) {
        d.h.b.o.e(r3, AutoTestConstant.PARAM);
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new a(r3, null), m.class, "com.obric.aiagent.plugin")), (q) ZeusTransformUtils.preCheckCast(new b(null), q.class, "com.obric.aiagent.plugin"));
    }
}
