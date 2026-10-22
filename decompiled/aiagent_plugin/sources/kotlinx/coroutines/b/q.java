package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f39048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.q f39049b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.q$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @d.c.b.a.f(b = "Errors.kt", c = {112, 113}, d = "collect", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1")
        public static final class AnonymousClass1 extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f39050a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f39051b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f39052c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f39053d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f39054e;

            public AnonymousClass1(a r3, d.c.d r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39052c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f39050a = r3;
                this.f39051b |= Integer.MIN_VALUE;
                return this.f39052c.collect(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i<? super T> r7, d.c.d<? super d.x> r8) {
            i r9 = (i) ZeusTransformUtils.wrapperContextForParams(r7, i.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
            if ((r0.f39051b & Integer.MIN_VALUE) == 0) goto L7;
            r0.f39051b -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f39050a;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f39051b;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            d.o.a(r11);
        L25:
            return d.x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r9 = (i) ZeusTransformUtils.preCheckCast(r0.f39054e, i.class, "com.obric.aiagent.plugin");
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.f39053d, a.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
        L19:
            Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L25;
            d.h.a.q r6 = this.f39049b;
            r0.f39053d = null;
            r0.f39054e = null;
            r0.f39051b = 2;
            d.h.b.m.a(6);
            Object r13 = r6.invoke(r9, r12, r0);
            d.h.b.m.a(7);
            if (r13 != r2) goto L25;
            return r2;
        L16:
            d.o.a(r11);
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            h r15 = this.f39048a;
            r0.f39053d = this;
            r0.f39054e = r9;
            r0.f39051b = 1;
            r11 = j.a(r15, r9, r0);
            if (r11 != r2) goto L19;
            return r2;
        L7:
            r0 = new AnonymousClass1(this, r10);
            goto L8
        }

        public a(h r3, d.h.a.q r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d.h.a.q r6 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.q.class, "com.obric.aiagent.plugin");
            this.f39048a = r5;
            this.f39049b = r6;
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @d.c.b.a.f(b = "Errors.kt", c = {152}, d = "catchImpl", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt")
    static final class b<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f39057c;

        b(d.c.d<? super b> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39056b = r2;
            this.f39057c |= Integer.MIN_VALUE;
            return j.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    static final class c<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f39058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<Throwable> f39059b;

        /* JADX INFO: compiled from: Errors.kt */
        @d.c.b.a.f(b = "Errors.kt", c = {154}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f39060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f39061b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c<T> f39062c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f39063d;

            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39062c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f39061b = r3;
                this.f39063d |= Integer.MIN_VALUE;
                return this.f39062c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        c(i<? super T> r3, d.h.b.z.f<Throwable> r4) {
            this.f39058a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            this.f39059b = r4;
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Throwable] */
        @Override // kotlinx.coroutines.b.i
        public final Object emit(T r6, d.c.d<? super d.x> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if ((r0.f39063d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f39063d -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.f39061b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f39063d;
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            c r5 = (c) ZeusTransformUtils.preCheckCast(r0.f39060a, c.class, "com.obric.aiagent.plugin");
            d.o.a(r9);     // Catch: Throwable -> L22
        L20:
            c<T> this = (c<T>) d.x.f38692a;
            return this;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            d.o.a(r9);
            i<T> r10 = this.f39058a;     // Catch: Throwable -> L22
            r0.f39060a = this;     // Catch: Throwable -> L22
            r0.f39063d = 1;     // Catch: Throwable -> L22
            if (r10.emit(r6, r0) != r2) goto L20;
            return r2;
        L22:
            th = move-exception;
            r6 = (T) th;
            this.f39059b.f38504a = r6;
            throw r6;
        L7:
            r0 = new a(this, r8);
            goto L8
        }
    }

    public static final <T> Object a(h<? extends T> r5, i<? super T> r6, d.c.d<? super Throwable> r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        i r9 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r0.f39057c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39057c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f39056b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39057c;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        d.h.b.z.f r12 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r0.f39055a, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.o.a(r11);     // Catch: Throwable -> L14
        return null;
    L14:
        th = th;
    L26:
        Throwable r13 = (Throwable) ZeusTransformUtils.preCheckCast(r12.f38504a, Throwable.class, "com.obric.aiagent.plugin");
        if (a(th, r13) == false) goto L29;
    L38:
        throw th;
    L29:
        if (a(th, r0.getContext()) == true) goto L38;
        if (r13 != null) goto L33;
        return th;
    L33:
        if (ZeusTransformUtils.instanceOf(th, CancellationException.class) == false) goto L36;
        d.a.a(r13, th);
        throw r13;
    L36:
        d.a.a(th, r13);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r11);
        d.h.b.z.f r14 = new d.h.b.z.f();
        i<? super T> r15 = (i) ZeusTransformUtils.preCheckCast(new c(r9, r14), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        r0.f39055a = r14;     // Catch: Throwable -> L24
        r0.f39057c = 1;     // Catch: Throwable -> L24
        if (r8.collect(r15, r0) != r2) goto L22;
        return r2;
    L22:
        return null;
    L24:
        th = th;
        r12 = r14;
    L7:
        r0 = new b(r10);
        goto L8
    }

    private static final boolean a(Throwable r3, d.c.g r4) {
        ca r5 = (ca) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.j() == true) goto L8;
        return false;
    L8:
        return a(r3, (Throwable) ZeusTransformUtils.preCheckCast(r5.k(), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> h<T> a(h<? extends T> r2, d.h.a.q<? super i<? super T>, ? super Throwable, ? super d.c.d<? super d.x>, ? extends Object> r3) {
        return (h) ZeusTransformUtils.preCheckCast(new a((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    private static final boolean a(Throwable r1, Throwable r2) {
        if (r2 != null) goto L4;
    L14:
        return false;
    L4:
        if (aq.c() == false) goto L8;
        r2 = kotlinx.coroutines.internal.ak.b(r2);
    L8:
        if (aq.c() == false) goto L12;
        r1 = kotlinx.coroutines.internal.ak.b(r1);
    L12:
        if (d.h.b.o.a(r2, r1) == false) goto L14;
        return true;
    }
}
