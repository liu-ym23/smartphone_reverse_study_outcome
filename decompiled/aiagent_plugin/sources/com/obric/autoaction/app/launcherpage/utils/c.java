package com.obric.autoaction.app.launcherpage.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: FlowExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: compiled from: FlowExt.kt */
    @d.c.b.a.f(b = "FlowExt.kt", c = {11}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.utils.FlowExtKt$collectIn$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.h<T> f24470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.i<T> f24471c;

        a(kotlinx.coroutines.b.h<? extends T> r3, kotlinx.coroutines.b.i<? super T> r4, d.c.d<? super a> r5) {
            kotlinx.coroutines.b.h<T> r6 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i<T> r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24470b = r6;
            this.f24471c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24470b, this.f24471c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24469a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h<T> r7 = this.f24470b;
            Object r2 = this.f24471c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24469a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final <T> void a(kotlinx.coroutines.b.h<? extends T> r8, am r9, kotlinx.coroutines.b.i<? super T> r10) {
        kotlinx.coroutines.b.h r11 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        am r2 = (am) ZeusTransformUtils.wrapperContextForParams(r9, am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.i r12 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "<this>");
        d.h.b.o.e(r2, "lifecycleScope");
        d.h.b.o.e(r12, "collector");
        kotlinx.coroutines.i.a(r2, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
