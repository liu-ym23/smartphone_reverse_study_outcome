package com.obric.autoaction.d.b.a;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AIAgentExitUserClarifyUsecaseImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: compiled from: AIAgentExitUserClarifyUsecaseImpl.kt */
    @d.c.b.a.f(b = "AIAgentExitUserClarifyUsecaseImpl.kt", c = {19, 22, 24}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentExitUserClarifyUsecaseImpl$invoke$1")
    static final class a extends l implements m<i<? super n<? extends com.obric.autogui.common.e>>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f24659d;

        /* JADX INFO: renamed from: com.obric.autoaction.d.b.a.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AIAgentExitUserClarifyUsecaseImpl.kt */
        @d.c.b.a.f(b = "AIAgentExitUserClarifyUsecaseImpl.kt", c = {20}, d = "invokeSuspend", e = "com.obric.autoaction.domain.usecase.impl.AIAgentExitUserClarifyUsecaseImpl$invoke$1$statusMessage$1")
        static final class C0568a extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24660a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f24661b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f24662c;

            C0568a(String r3, String r4, d.c.d<? super C0568a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24661b = r3;
                this.f24662c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return ((C0568a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0568a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0568a(this.f24661b, this.f24662c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24660a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r7);
                AutoActionAgent r8 = AutoActionAgent.INSTANCE;
                String r2 = this.f24661b;
                String r3 = this.f24662c;
                d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24660a = 1;
                r7 = r8.exitUserClarify(r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        a(String r3, String r4, d.c.d<? super a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24657b = r3;
            this.f24658c = r4;
            super(2, r6);
        }

        public final Object a(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f24657b, this.f24658c, r6);
            r0.f24659d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super n<? extends com.obric.autogui.common.e>> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.b.i] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: int
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:59)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:32)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:508)
        	at jadx.core.dex.nodes.utils.TypeUtils.getClassTypeVars(TypeUtils.java:53)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:175)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            ?? r1 = this.f24656a;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r11);
        L28:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f24659d, i.class, "com.obric.aiagent.plugin");
            o.a(r11);     // Catch: Exception -> L23
            goto L28
        L13:
            i r3 = (i) ZeusTransformUtils.preCheckCast(this.f24659d, i.class, "com.obric.aiagent.plugin");
            o.a(r11);     // Catch: Exception -> L23
        L20:
            com.obric.autogui.common.e r12 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
            n.a r5 = n.f38560a;     // Catch: Exception -> L23
            n r13 = n.g(n.f(r12));     // Catch: Exception -> L23
            d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
            this.f24659d = r3;     // Catch: Exception -> L23
            this.f24656a = 2;     // Catch: Exception -> L23
            if (r3.emit(r13, r6) != r0) goto L28;
            return r0;
        L16:
            o.a(r11);
            r3 = (i) ZeusTransformUtils.preCheckCast(this.f24659d, i.class, "com.obric.aiagent.plugin");
            d.c.g r14 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
            m r7 = (m) ZeusTransformUtils.preCheckCast(new C0568a(this.f24657b, this.f24658c, null), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
            this.f24659d = r3;     // Catch: Exception -> L23
            this.f24656a = 1;     // Catch: Exception -> L23
            r11 = kotlinx.coroutines.i.a(r14, r7, r8);     // Catch: Exception -> L23
            if (r11 != r0) goto L20;
            return r0;
        L23:
            e = move-exception;
            n.a r4 = n.f38560a;
            n r15 = n.g(n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"))));
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24659d = null;
            this.f24656a = 3;
            if (r1.emit(r15, r9) != r0) goto L28;
            return r0;
        }
    }

    public d() {
    }

    public h<n<com.obric.autogui.common.e>> a(String r2, String r3) {
        return j.a((m) ZeusTransformUtils.preCheckCast(new a(r2, r3, null), m.class, "com.obric.aiagent.plugin"));
    }
}
