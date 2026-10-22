package d.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.h;
import d.c.b.a.j;
import d.c.g;
import d.h.a.m;
import d.h.b.ae;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class c {

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f38401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f38402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38403c;

        public a(d.c.d r3, m r4, Object r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38401a = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            this.f38402b = r5;
            o.a(r6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            super(r6);
        }

        @Override // d.c.b.a.a
        public Object invokeSuspend(Object r5) {
            int r0 = this.f38403c;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            this.f38403c = 2;
            d.o.a(r5);
            return r5;
        L7:
            throw new IllegalStateException("This coroutine had already completed".toString());
        L8:
            this.f38403c = 1;
            d.o.a(r5);
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            o.a(this.f38401a, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
            return ((m) ZeusTransformUtils.preCheckCast(ae.b(this.f38401a, 2), m.class, "com.obric.aiagent.plugin")).invoke(this.f38402b, r6);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f38404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f38405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38406c;

        public b(d.c.d r3, g r4, m r5, Object r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
            this.f38404a = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
            this.f38405b = r6;
            o.a(r7, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            super(r7, r8);
        }

        @Override // d.c.b.a.a
        public Object invokeSuspend(Object r5) {
            int r0 = this.f38406c;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            this.f38406c = 2;
            d.o.a(r5);
            return r5;
        L7:
            throw new IllegalStateException("This coroutine had already completed".toString());
        L8:
            this.f38406c = 1;
            d.o.a(r5);
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            o.a(this.f38404a, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
            return ((m) ZeusTransformUtils.preCheckCast(ae.b(this.f38404a, 2), m.class, "com.obric.aiagent.plugin")).invoke(this.f38405b, r6);
        }
    }

    /* JADX INFO: renamed from: d.c.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class C1035c extends j {
        C1035c(d.c.d<? super T> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            o.a(r4, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            super(r4);
        }

        @Override // d.c.b.a.a
        public Object invokeSuspend(Object r1) {
            d.o.a(r1);
            return r1;
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class d extends d.c.b.a.d {
        d(d.c.d<? super T> r3, g r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
            o.a(r5, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            super(r5, r6);
        }

        @Override // d.c.b.a.a
        public Object invokeSuspend(Object r1) {
            d.o.a(r1);
            return r1;
        }
    }

    public static final <R, T> Object a(m<? super R, ? super d.c.d<? super T>, ? extends Object> r2, R r3, d.c.d<? super T> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r6, "completion");
        d.c.d r7 = b(h.a(r6));
        return ((m) ZeusTransformUtils.preCheckCast(ae.b(r5, 2), m.class, "com.obric.aiagent.plugin")).invoke(r3, r7);
    }

    public static final <R, T> d.c.d<x> b(m<? super R, ? super d.c.d<? super T>, ? extends Object> r3, R r4, d.c.d<? super T> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        o.e(r7, "completion");
        d.c.d<?> r8 = h.a(r7);
        if (ZeusTransformUtils.instanceOf(r6, d.c.b.a.a.class) == true) goto L10;
        g r0 = r8.getContext();
        if (r0 != d.c.h.f38423a) goto L9;
        return (d.c.d) ZeusTransformUtils.preCheckCast(new a(r8, r6, r4), d.c.d.class, "com.obric.aiagent.plugin");
    L9:
        return (d.c.d) ZeusTransformUtils.preCheckCast(new b(r8, r0, r6, r4), d.c.d.class, "com.obric.aiagent.plugin");
    L10:
        return ((d.c.b.a.a) ZeusTransformUtils.preCheckCast(r6, d.c.b.a.a.class, "com.obric.aiagent.plugin")).create(r4, r8);
    }

    public static final <T> d.c.d<T> a(d.c.d<? super T> r2) {
        d.c.d<T> r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, d.c.b.a.d.class) == false) goto L5;
        d.c.b.a.d r0 = (d.c.b.a.d) ZeusTransformUtils.preCheckCast(r3, d.c.b.a.d.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L12;
        d.c.d<T> r1 = (d.c.d<T>) r0.intercepted();
        if (r1 != null) goto L11;
        return r3;
    L11:
        return r1;
    L12:
        return r3;
    L5:
        r0 = null;
        goto L6
    }

    private static final <T> d.c.d<T> b(d.c.d<? super T> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        g r0 = r4.getContext();
        if (r0 != d.c.h.f38423a) goto L6;
        return (d.c.d) ZeusTransformUtils.preCheckCast(new C1035c(r4), d.c.d.class, "com.obric.aiagent.plugin");
    L6:
        return (d.c.d) ZeusTransformUtils.preCheckCast(new d(r4, r0), d.c.d.class, "com.obric.aiagent.plugin");
    }
}
