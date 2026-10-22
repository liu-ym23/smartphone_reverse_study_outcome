package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f f39069a;

        public a(d.h.b.z.f r1) {
            this.f39069a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public Object emit(T r3, d.c.d<? super d.x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39069a.f38504a = r3;
            throw new kotlinx.coroutines.b.a.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class b<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.m f39070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f f39071b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.s$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: Limit.kt */
        @d.c.b.a.f(b = "Reduce.kt", c = {139}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2")
        public static final class AnonymousClass1 extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f39072a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f39073b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f39074c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f39075d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f39076e;

            public AnonymousClass1(b r3, d.c.d r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39075d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f39073b = r3;
                this.f39074c |= Integer.MIN_VALUE;
                return this.f39075d.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public b(d.h.a.m r3, d.h.b.z.f r4) {
            this.f39070a = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            this.f39071b = r4;
        }

        @Override // kotlinx.coroutines.b.i
        public Object emit(T r6, d.c.d<? super d.x> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.aiagent.plugin");
            if ((r0.f39074c & Integer.MIN_VALUE) == 0) goto L7;
            r0.f39074c -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.f39073b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f39074c;
            boolean r4 = true;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r6 = (T) r0.f39076e;
            b<T> this = (b) ZeusTransformUtils.preCheckCast(r0.f39072a, b.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L20;
            this.f39071b.f38504a = r6;
            r4 = false;
        L20:
            if (r4 == false) goto L24;
            return d.x.f38692a;
        L24:
            throw new kotlinx.coroutines.b.a.a(this);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r9);
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            d.h.a.m r11 = this.f39070a;
            r0.f39072a = this;
            r0.f39076e = r6;
            r0.f39074c = 1;
            d.h.b.m.a(6);
            r9 = r11.invoke(r6, r0);
            d.h.b.m.a(7);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new AnonymousClass1(this, r8);
            goto L8
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @d.c.b.a.f(b = "Reduce.kt", c = {179}, d = "first", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
    static final class c<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f39079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f39080d;

        c(d.c.d<? super c> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39079c = r2;
            this.f39080d |= Integer.MIN_VALUE;
            return j.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @d.c.b.a.f(b = "Reduce.kt", c = {179}, d = "first", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
    static final class d<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f39083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f39084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f39085e;

        d(d.c.d<? super d> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39084d = r2;
            this.f39085e |= Integer.MIN_VALUE;
            return j.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class e<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f f39086a;

        public e(d.h.b.z.f r1) {
            this.f39086a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public Object emit(T r3, d.c.d<? super d.x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39086a.f38504a = r3;
            throw new kotlinx.coroutines.b.a.a(this);
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @d.c.b.a.f(b = "Reduce.kt", c = {179}, d = "firstOrNull", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt")
    static final class f<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f39089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f39090d;

        f(d.c.d<? super f> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f39089c = r2;
            this.f39090d |= Integer.MIN_VALUE;
            return j.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final <T> Object a(h<? extends T> r6, d.c.d<? super T> r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f39080d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39080d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f39079c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39080d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r0.f39078b, a.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r1 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r0.f39077a, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: kotlinx.coroutines.b.a.a -> L14
    L27:
        if (r1.f38504a == kotlinx.coroutines.b.a.t.f38938a) goto L31;
        return r1.f38504a;
    L31:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        kotlinx.coroutines.b.a.a e2 = e;
    L25:
        kotlinx.coroutines.b.a.p.a(e2, r11);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r10);
        d.h.b.z.f r12 = new d.h.b.z.f();
        r12.f38504a = (T) kotlinx.coroutines.b.a.t.f38938a;
        a r4 = new a(r12);
        i<? super T> r5 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin");     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39077a = r12;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39078b = r4;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39080d = 1;     // Catch: kotlinx.coroutines.b.a.a -> L23
        if (r8.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r12;
    L23:
        e = move-exception;
        r1 = r12;
        e2 = e;
        r11 = r4;
    L7:
        r0 = new c(r9);
        goto L8
    }

    public static final <T> Object a(h<? extends T> r6, d.h.a.m<? super T, ? super d.c.d<? super Boolean>, ? extends Object> r7, d.c.d<? super T> r8) {
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.aiagent.plugin");
        d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f39085e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39085e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f39084d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39085e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        b r13 = (b) ZeusTransformUtils.preCheckCast(r0.f39083c, b.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r14 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r0.f39082b, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0.f39081a, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: kotlinx.coroutines.b.a.a -> L14
    L27:
        if (r14.f38504a == kotlinx.coroutines.b.a.t.f38938a) goto L31;
        return r14.f38504a;
    L31:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r1);
    L14:
        kotlinx.coroutines.b.a.a e2 = e;
    L25:
        kotlinx.coroutines.b.a.p.a(e2, r13);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r12);
        d.h.b.z.f r15 = new d.h.b.z.f();
        r15.f38504a = (T) kotlinx.coroutines.b.a.t.f38938a;
        b r4 = new b(r10, r15);
        i<? super T> r5 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin");     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39081a = r10;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39082b = r15;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39083c = r4;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39085e = 1;     // Catch: kotlinx.coroutines.b.a.a -> L23
        if (r9.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r10;
        r14 = r15;
    L23:
        e = move-exception;
        r1 = r10;
        r14 = r15;
        e2 = e;
        r13 = r4;
    L7:
        r0 = new d(r11);
        goto L8
    }

    public static final <T> Object b(h<? extends T> r6, d.c.d<? super T> r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.aiagent.plugin");
        if ((r0.f39090d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39090d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f39089c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39090d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        e r11 = (e) ZeusTransformUtils.preCheckCast(r0.f39088b, e.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r1 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r0.f39087a, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: kotlinx.coroutines.b.a.a -> L14
    L27:
        return r1.f38504a;
    L14:
        kotlinx.coroutines.b.a.a e2 = e;
    L25:
        kotlinx.coroutines.b.a.p.a(e2, r11);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r10);
        d.h.b.z.f r12 = new d.h.b.z.f();
        e r4 = new e(r12);
        i<? super T> r5 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin");     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39087a = r12;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39088b = r4;     // Catch: kotlinx.coroutines.b.a.a -> L23
        r0.f39090d = 1;     // Catch: kotlinx.coroutines.b.a.a -> L23
        if (r8.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r12;
    L23:
        e = move-exception;
        r1 = r12;
        e2 = e;
        r11 = r4;
    L7:
        r0 = new f(r9);
        goto L8
    }
}
