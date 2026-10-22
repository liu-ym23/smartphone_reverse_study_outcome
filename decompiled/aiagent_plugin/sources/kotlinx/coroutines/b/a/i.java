package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i<T, R> extends g<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.q<kotlinx.coroutines.b.i<? super R>, T, d.c.d<? super d.x>, Object> f38896e;

    /* JADX INFO: compiled from: Merge.kt */
    @d.c.b.a.f(b = "Merge.kt", c = {23}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i<T, R> f38898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.i<R> f38899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f38900d;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.a.i$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Merge.kt */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.f<ca> f38901a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ am f38902b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T, R> f38903c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.i<R> f38904d;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.a.i$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Merge.kt */
            @d.c.b.a.f(b = "Merge.kt", c = {30}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2")
            static final class C10471 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f38905a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ i<T, R> f38906b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i<R> f38907c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ T f38908d;

                C10471(i<T, R> r3, kotlinx.coroutines.b.i<? super R> r4, T r5, d.c.d<? super C10471> r6) {
                    kotlinx.coroutines.b.i<R> r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f38906b = r3;
                    this.f38907c = r7;
                    this.f38908d = r5;
                    super(2, r8);
                }

                public final Object a(am r3, d.c.d<? super d.x> r4) {
                    return ((C10471) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C10471.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C10471(this.f38906b, this.f38907c, this.f38908d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r5) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f38905a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    d.o.a(r5);
                L12:
                    return d.x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    d.o.a(r5);
                    d.h.a.q r6 = i.a(this.f38906b);
                    kotlinx.coroutines.b.i<R> r2 = this.f38907c;
                    T r3 = this.f38908d;
                    this.f38905a = 1;
                    if (r6.invoke(r2, r3, this) != r0) goto L12;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: kotlinx.coroutines.b.a.i$a$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Merge.kt */
            @d.c.b.a.f(b = "Merge.kt", c = {26}, d = "emit", e = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1")
            static final class C1048a extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f38909a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f38910b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                Object f38911c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f38912d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1<T> f38913e;
                int f;

                /* JADX WARN: Multi-variable type inference failed */
                C1048a(AnonymousClass1<? super T> r3, d.c.d<? super C1048a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f38913e = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f38912d = r3;
                    this.f |= Integer.MIN_VALUE;
                    return this.f38913e.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            AnonymousClass1(d.h.b.z.f<ca> r3, am r4, i<T, R> r5, kotlinx.coroutines.b.i<? super R> r6) {
                am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.aiagent.plugin");
                kotlinx.coroutines.b.i<R> r8 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                this.f38901a = r3;
                this.f38902b = r7;
                this.f38903c = r5;
                this.f38904d = r8;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r10, d.c.d<? super d.x> r11) {
                d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r12, C1048a.class) == false) goto L7;
                C1048a r0 = (C1048a) ZeusTransformUtils.preCheckCast(r12, C1048a.class, "com.obric.aiagent.plugin");
                if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
                r0.f -= Integer.MIN_VALUE;
            L8:
                Object r13 = r0.f38912d;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ca r9 = (ca) ZeusTransformUtils.preCheckCast(r0.f38911c, ca.class, "com.obric.aiagent.plugin");
                Object r14 = r0.f38910b;
                AnonymousClass1<T> r15 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.f38909a, AnonymousClass1.class, "com.obric.aiagent.plugin");
                d.o.a(r13);
                r10 = (T) r14;
                AnonymousClass1<T> this = r15;
            L19:
                this.f38901a.f38504a = (T) kotlinx.coroutines.i.a(this.f38902b, null, ao.f38854d, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C10471(this.f38903c, this.f38904d, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
                return d.x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                d.o.a(r13);
                ca r16 = (ca) ZeusTransformUtils.preCheckCast(this.f38901a.f38504a, ca.class, "com.obric.aiagent.plugin");
                if (r16 == null) goto L19;
                r16.a((CancellationException) ZeusTransformUtils.preCheckCast(new k(), CancellationException.class, "com.obric.aiagent.plugin"));
                r0.f38909a = this;
                r0.f38910b = r10;
                r0.f38911c = r16;
                r0.f = 1;
                if (r16.b(r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new C1048a(this, r12);
                goto L8
            }
        }

        a(i<T, R> r3, kotlinx.coroutines.b.i<? super R> r4, d.c.d<? super a> r5) {
            kotlinx.coroutines.b.i<R> r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38898b = r3;
            this.f38899c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f38898b, this.f38899c, r6);
            r0.f38900d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38897a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r9);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.f38900d, am.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r2 = new d.h.b.z.f();
            kotlinx.coroutines.b.h<S> r4 = this.f38898b.f38892d;
            kotlinx.coroutines.b.i r11 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r10, this.f38898b, this.f38899c), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38897a = 1;
            if (r4.collect((kotlinx.coroutines.b.i<? super S>) r11, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final /* synthetic */ d.h.a.q a(i r0) {
        return r0.f38896e;
    }

    public /* synthetic */ i(d.h.a.q r4, kotlinx.coroutines.b.h r5, d.c.g r6, int r7, kotlinx.coroutines.a.a r8, int r9, d.h.b.h r10) {
        d.h.a.q r11 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.q.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.h r12 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.c.g r13 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r9 & 4) == 0) goto L5;
        r13 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L5:
        d.c.g r0 = r13;
        if ((r9 & 8) == 0) goto L8;
        r7 = -2;
    L8:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L11;
        r8 = kotlinx.coroutines.a.a.f38771a;
    L11:
        this(r11, r12, r0, r1, r8);
    }

    public i(d.h.a.q<? super kotlinx.coroutines.b.i<? super R>, ? super T, ? super d.c.d<? super d.x>, ? extends Object> r3, kotlinx.coroutines.b.h<? extends T> r4, d.c.g r5, int r6, kotlinx.coroutines.a.a r7) {
        d.h.a.q<kotlinx.coroutines.b.i<? super R>, T, d.c.d<? super d.x>, Object> r8 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin");
        super((kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin"), r6, r7);
        this.f38896e = r8;
    }

    @Override // kotlinx.coroutines.b.a.e
    public e<R> a(d.c.g r9, int r10, kotlinx.coroutines.a.a r11) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r9, d.c.g.class, "com.obric.aiagent.plugin");
        return (e) ZeusTransformUtils.preCheckCast(new i(this.f38896e, this.f38892d, r5, r10, r11), e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.g
    public Object a(kotlinx.coroutines.b.i<? super R> r4, d.c.d<? super d.x> r5) {
        kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (aq.a() == true) goto L5;
    L9:
        Object r3 = an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r3 != d.c.a.b.a()) goto L13;
        return r3;
    L13:
        return d.x.f38692a;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, x.class) == true) goto L9;
        throw new AssertionError();
    }
}
