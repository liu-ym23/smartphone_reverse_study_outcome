package com.obric.autogui.util;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Debounce.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: Debounce.kt */
    @d.c.b.a.f(b = "Debounce.kt", c = {33}, d = "invokeSuspend", e = "com.obric.autogui.util.DebounceKt$debounceLeadingTrailing$1$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f31540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<T> f31541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.f<ca> f31542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<T, x> f31543e;
        final /* synthetic */ z.e f;

        a(long r3, z.f<T> r5, z.f<ca> r6, d.h.a.b<? super T, x> r7, z.e r8, d.c.d<? super a> r9) {
            d.h.a.b<T, x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31540b = r3;
            this.f31541c = r5;
            this.f31542d = r6;
            this.f31543e = r10;
            this.f = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f31540b, this.f31541c, this.f31542d, this.f31543e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
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
            int r1 = this.f31539a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            T r7 = this.f31541c.f38504a;
            if (r7 == 0) goto L14;
            d.h.a.b<T, x> r2 = this.f31543e;
            z.e r3 = this.f;
            r2.invoke(r7);
            r3.f38503a = SystemClock.elapsedRealtime();
        L14:
            this.f31541c.f38504a = null;
            this.f31542d.f38504a = null;
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            long r4 = this.f31540b;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31539a = 1;
            if (ax.a(r4, r8) != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ x lambda$AoWNFaOUfAYc9rXD16eAfGQ56qI(z.e r0, long r1, z.f r3, z.f r4, d.h.a.b r5, am r6, Object r7) {
        return a(r0, r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ x lambda$S6A4NUZqhYIYlttwQVA6xfJ8JEU(z.e r0, long r1, d.h.a.b r3, Object r4) {
        return a(r0, r1, r3, r4);
    }

    public static final <T> d.h.a.b<T, x> a(final long r10, am r12, d.h.a.b<? super T, x> r13) {
        final am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r12, am.class, "com.obric.aiagent.plugin");
        final d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "scope");
        d.h.b.o.e(r8, "action");
        final z.f r6 = new z.f();
        final z.f r7 = new z.f();
        final z.e r3 = new z.e();
        return new $$Lambda$e$AoWNFaOUfAYc9rXD16eAfGQ56qI(r3, r10, r6, r7, r8, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, kotlinx.coroutines.ca] */
    private static final x a(z.e r16, long r17, z.f r19, z.f r20, d.h.a.b r21, am r22, Object r23) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        am r10 = (am) ZeusTransformUtils.wrapperContextForParams(r22, am.class, "com.obric.aiagent.plugin");
        long r1 = SystemClock.elapsedRealtime();
        if ((r1 - r16.f38503a) < r17) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L12;
        ca r6 = (ca) ZeusTransformUtils.preCheckCast(r19.f38504a, ca.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        ca.a.a(r6, null, 1, null);
    L11:
        r19.f38504a = null;
        r20.f38504a = null;
        r5.invoke(r23);
        r16.f38503a = r1;
    L17:
        return x.f38692a;
    L12:
        r20.f38504a = r23;
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(r19.f38504a, ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
        ca.a.a(r0, null, 1, null);
    L15:
        r19.f38504a = kotlinx.coroutines.i.a(r10, null, null, (m) ZeusTransformUtils.preCheckCast(new a(r17, r20, r19, r5, r16, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L17
    L5:
        r4 = false;
        goto L7
    }

    public static final <T> d.h.a.b<T, x> a(final long r2, d.h.a.b<? super T, x> r4) {
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "action");
        final z.e r0 = new z.e();
        return new $$Lambda$e$S6A4NUZqhYIYlttwQVA6xfJ8JEU(r0, r2, r5);
    }

    private static final x a(z.e r4, long r5, d.h.a.b r7, Object r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - r4.f38503a) < r5) goto L6;
        r4.f38503a = r0;
        r9.invoke(r8);
    L6:
        return x.f38692a;
    }
}
