package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
final class b<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> f39011d;

    /* JADX INFO: compiled from: Builders.kt */
    @d.c.b.a.f(b = "Builders.kt", c = {330}, d = "collectTo", e = "kotlinx.coroutines.flow.CallbackFlowBuilder")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b<T> f39014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f39015d;

        a(b<T> r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39014c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f39013b = r3;
            this.f39015d |= Integer.MIN_VALUE;
            return this.f39014c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public /* synthetic */ b(d.h.a.m r2, d.c.g r3, int r4, kotlinx.coroutines.a.a r5, int r6, d.h.b.h r7) {
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
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

    public b(d.h.a.m<? super kotlinx.coroutines.a.q<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        super(r7, (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin"), r5, r6);
        this.f39011d = r7;
    }

    @Override // kotlinx.coroutines.b.e, kotlinx.coroutines.b.a.e
    public Object a(kotlinx.coroutines.a.q<? super T> r6, d.c.d<? super d.x> r7) {
        kotlinx.coroutines.a.q<? super T> r8 = (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r0.f39015d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39015d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f39013b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39015d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (kotlinx.coroutines.a.q) ZeusTransformUtils.preCheckCast(r0.f39012a, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L18:
        if (r8.l() == false) goto L22;
        return d.x.f38692a;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r0.f39012a = r8;
        r0.f39015d = 1;
        if (super.a(r8, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new a(this, r9);
        goto L8
    }

    @Override // kotlinx.coroutines.b.e, kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.b.a.e<T> a(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return (kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(new b(this.f39011d, r6, r4, r5), kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin");
    }
}
