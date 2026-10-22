package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class a extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.retrofit2.e f9589a;

        a(com.bytedance.retrofit2.e r3) {
            this.f9589a = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f9589a.b();
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.retrofit2.e f9590a;

        b(com.bytedance.retrofit2.e r3) {
            this.f9590a = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f9590a.b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class c<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f9591a;

        c(kotlinx.coroutines.n r3) {
            this.f9591a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r5, ak<T> r6) {
            com.bytedance.retrofit2.e r7 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "call");
            d.h.b.o.e(r6, "response");
            if (r6.e() == false) goto L8;
            T r8 = r6.f();
            if (r8 != null) goto L7;
            Object r9 = r7.e().a(s.class);
            d.h.b.o.a(r9);
            Method r10 = ((s) ZeusTransformUtils.preCheckCast(r9, s.class, "com.obric.aiagent.plugin")).a();
            StringBuilder r0 = new StringBuilder().append("Response from ");
            d.h.b.o.c(r10, "method");
            Class<?> r2 = r10.getDeclaringClass();
            d.h.b.o.c(r2, "method.declaringClass");
            d.e r11 = new d.e(r0.append(r2.getName()).append('.').append(r10.getName()).append(" was null but response body type was declared as non-null").toString());
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9591a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r12 = d.n.f38560a;
            r4.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"))));
            return;
        L7:
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9591a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r14 = d.n.f38560a;
            r13.resumeWith(d.n.f(r8));
            return;
        L8:
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9591a, d.c.d.class, "com.obric.aiagent.plugin");
            Throwable r16 = (Throwable) ZeusTransformUtils.preCheckCast(new o(r6), Throwable.class, "com.obric.aiagent.plugin");
            d.n.a r17 = d.n.f38560a;
            r15.resumeWith(d.n.f(d.o.a(r16)));
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r3, Throwable r4) {
            d.h.b.o.e((com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), "call");
            d.h.b.o.e(r4, "t");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9591a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a(r4)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class d<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f9592a;

        d(kotlinx.coroutines.n r3) {
            this.f9592a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r3, ak<T> r4) {
            d.h.b.o.e((com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), "call");
            d.h.b.o.e(r4, "response");
            if (r4.e() == false) goto L5;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9592a, d.c.d.class, "com.obric.aiagent.plugin");
            T r5 = r4.f();
            d.n.a r6 = d.n.f38560a;
            r2.resumeWith(d.n.f(r5));
            return;
        L5:
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9592a, d.c.d.class, "com.obric.aiagent.plugin");
            Throwable r8 = (Throwable) ZeusTransformUtils.preCheckCast(new o(r4), Throwable.class, "com.obric.aiagent.plugin");
            d.n.a r9 = d.n.f38560a;
            r7.resumeWith(d.n.f(d.o.a(r8)));
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r3, Throwable r4) {
            d.h.b.o.e((com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), "call");
            d.h.b.o.e(r4, "t");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9592a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a(r4)));
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class e extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.retrofit2.e f9593a;

        e(com.bytedance.retrofit2.e r3) {
            this.f9593a = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Throwable r1) {
            this.f9593a.b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    public static final class f<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f9594a;

        f(kotlinx.coroutines.n r3) {
            this.f9594a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r3, ak<T> r4) {
            d.h.b.o.e((com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), "call");
            d.h.b.o.e(r4, "response");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9594a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r2.resumeWith(d.n.f(r4));
        }

        @Override // com.bytedance.retrofit2.h
        public void a(com.bytedance.retrofit2.e<T> r3, Throwable r4) {
            d.h.b.o.e((com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), "call");
            d.h.b.o.e(r4, "t");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f9594a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a(r4)));
        }
    }

    /* JADX INFO: compiled from: KotlinExtensions.kt */
    static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d f9595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f9596b;

        g(d.c.d r3, Exception r4) {
            this.f9595a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f9596b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.c.d r0 = d.c.a.b.a(this.f9595a);
            Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.f9596b, Throwable.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r0.resumeWith(d.n.f(d.o.a(r3)));
        }
    }

    public static final Object a(Exception r4, d.c.d<?> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        bd.a().a(r6.getContext(), (Runnable) ZeusTransformUtils.preCheckCast(new g(r6, r4), Runnable.class, "com.obric.aiagent.plugin"));
        Object r7 = d.c.a.b.a();
        if (r7 != d.c.a.b.a()) goto L6;
        d.c.b.a.h.c(r6);
    L6:
        if (r7 != d.c.a.b.a()) goto L9;
        return r7;
    L9:
        return d.x.f38692a;
    }

    public static final <T> Object a(com.bytedance.retrofit2.e<T> r5, d.c.d<? super T> r6) {
        com.bytedance.retrofit2.e r7 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r8), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r2.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r7.a((h) ZeusTransformUtils.preCheckCast(new c(r2), h.class, "com.obric.aiagent.plugin"));
        Object r9 = r0.h();
        if (r9 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r9;
    }

    public static final <T> Object b(com.bytedance.retrofit2.e<T> r5, d.c.d<? super T> r6) {
        com.bytedance.retrofit2.e r7 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r8), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r2.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r7.a((h) ZeusTransformUtils.preCheckCast(new d(r2), h.class, "com.obric.aiagent.plugin"));
        Object r9 = r0.h();
        if (r9 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r9;
    }

    public static final <T> Object c(com.bytedance.retrofit2.e<T> r5, d.c.d<? super ak<T>> r6) {
        com.bytedance.retrofit2.e r7 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r8), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r2.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r7.a((h) ZeusTransformUtils.preCheckCast(new f(r2), h.class, "com.obric.aiagent.plugin"));
        Object r9 = r0.h();
        if (r9 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r9;
    }
}
