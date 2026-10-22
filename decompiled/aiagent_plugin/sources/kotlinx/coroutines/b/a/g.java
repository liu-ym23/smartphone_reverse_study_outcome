package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ah;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final kotlinx.coroutines.b.h<S> f38892d;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @d.c.b.a.f(b = "ChannelFlow.kt", c = {148}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.b.i<? super T>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f38894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g<S, T> f38895c;

        a(g<S, T> r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38895c = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.b.i<? super T> r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f38895c, r5);
            r0.f38894b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38893a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.i<? super T> r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f38894b, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            g<S, T> r2 = this.f38895c;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38893a = 1;
            if (r2.a(r7, r3) != r0) goto L12;
            return r0;
        }
    }

    @Override // kotlinx.coroutines.b.a.e
    public Object a(kotlinx.coroutines.a.q<? super T> r3, d.c.d<? super d.x> r4) {
        return a(this, (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object a(kotlinx.coroutines.b.i<? super T> r1, d.c.d<? super d.x> r2);

    @Override // kotlinx.coroutines.b.a.e, kotlinx.coroutines.b.h
    public Object collect(kotlinx.coroutines.b.i<? super T> r3, d.c.d<? super d.x> r4) {
        return a(this, (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public g(kotlinx.coroutines.b.h<? extends S> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        kotlinx.coroutines.b.h<S> r7 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin"), r5, r6);
        this.f38892d = r7;
    }

    private final Object a(kotlinx.coroutines.b.i<? super T> r10, d.c.g r11, d.c.d<? super d.x> r12) {
        kotlinx.coroutines.b.i r13 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.g r2 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r11, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return f.a(r2, f.a(r13, r6.getContext()), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6, 4, null);
    }

    static /* synthetic */ <S, T> Object a(g<S, T> r3, kotlinx.coroutines.a.q<? super T> r4, d.c.d<? super d.x> r5) {
        kotlinx.coroutines.a.q r6 = (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = r3.a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new x((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return d.x.f38692a;
    }

    static /* synthetic */ <S, T> Object a(g<S, T> r6, kotlinx.coroutines.b.i<? super T> r7, d.c.d<? super d.x> r8) {
        kotlinx.coroutines.b.i<? super T> r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (r6.f38883b != (-3)) goto L18;
        d.c.g r0 = r10.getContext();
        d.c.g r2 = ah.a(r0, r6.f38882a);
        if (d.h.b.o.a(r2, r0) == false) goto L12;
        Object r11 = r6.a(r9, r10);
        if (r11 != d.c.a.b.a()) goto L10;
        return r11;
    L10:
        return d.x.f38692a;
    L12:
        if (d.h.b.o.a(r2.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")), r0.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        Object r12 = r6.a(r9, r2, r10);
        if (r12 != d.c.a.b.a()) goto L17;
        return r12;
    L17:
        return d.x.f38692a;
    L18:
        Object r13 = super.collect(r9, r10);
        if (r13 != d.c.a.b.a()) goto L22;
        return r13;
    L22:
        return d.x.f38692a;
    }

    @Override // kotlinx.coroutines.b.a.e
    public String toString() {
        return this.f38892d + " -> " + super.toString();
    }
}
