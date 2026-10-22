package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterable<kotlinx.coroutines.b.h<T>> f38914d;

    /* JADX INFO: compiled from: Merge.kt */
    @d.c.b.a.f(b = "Merge.kt", c = {92}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.h<T> f38916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x<T> f38917c;

        a(kotlinx.coroutines.b.h<? extends T> r3, x<T> r4, d.c.d<? super a> r5) {
            kotlinx.coroutines.b.h<T> r6 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38916b = r6;
            this.f38917c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f38916b, this.f38917c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38915a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h<T> r7 = this.f38916b;
            kotlinx.coroutines.b.i<? super T> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f38917c, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38915a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ j(Iterable r2, d.c.g r3, int r4, kotlinx.coroutines.a.a r5, int r6, d.h.b.h r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = kotlinx.coroutines.a.a.f38771a;
    L11:
        this(r8, r9, r4, r5);
    }

    public j(Iterable<? extends kotlinx.coroutines.b.h<? extends T>> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        Iterable<kotlinx.coroutines.b.h<T>> r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin"), r5, r6);
        this.f38914d = r7;
    }

    @Override // kotlinx.coroutines.b.a.e
    public e<T> a(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return (e) ZeusTransformUtils.preCheckCast(new j(this.f38914d, r6, r4, r5), e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.a.s<T> a(am r3) {
        return kotlinx.coroutines.a.o.a((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), this.f38882a, this.f38883b, c());
    }

    @Override // kotlinx.coroutines.b.a.e
    public Object a(kotlinx.coroutines.a.q<? super T> r10, d.c.d<? super d.x> r11) {
        kotlinx.coroutines.a.q r12 = (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        x r14 = new x((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"));
        Iterator<kotlinx.coroutines.b.h<T>> r9 = this.f38914d.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        kotlinx.coroutines.b.h r0 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r9.next(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(r12, am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r0, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L4
    L7:
        return d.x.f38692a;
    }
}
