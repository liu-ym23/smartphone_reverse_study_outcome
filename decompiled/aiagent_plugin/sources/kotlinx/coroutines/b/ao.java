package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ao<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<T> f39003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.m<i<? super T>, d.c.d<? super d.x>, Object> f39004b;

    /* JADX INFO: compiled from: Share.kt */
    @d.c.b.a.f(b = "Share.kt", c = {415, 419}, d = "onSubscription", e = "kotlinx.coroutines.flow.SubscribedFlowCollector")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f39005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f39007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ao<T> f39008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f39009e;

        a(ao<T> r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39008d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f39007c = r3;
            this.f39009e |= Integer.MIN_VALUE;
            return this.f39008d.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f39003a.emit(r3, r5);
    }

    public final Object a(d.c.d<? super d.x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if ((r1.f39009e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f39009e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.f39007c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f39009e;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d.o.a(r12);
    L31:
        return d.x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.b.a.u r9 = (kotlinx.coroutines.b.a.u) ZeusTransformUtils.preCheckCast(r1.f39006b, kotlinx.coroutines.b.a.u.class, "com.obric.aiagent.plugin");
        ao<T> r5 = (ao) ZeusTransformUtils.preCheckCast(r1.f39005a, ao.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L18
    L25:
        r9.releaseIntercepted();
        if (ZeusTransformUtils.instanceOf(r5.f39003a, ao.class) == false) goto L33;
        ao r13 = (ao) ZeusTransformUtils.preCheckCast(r5.f39003a, ao.class, "com.obric.aiagent.plugin");
        r1.f39005a = null;
        r1.f39006b = null;
        r1.f39009e = 2;
        if (r13.a(r1) != r3) goto L31;
        return r3;
    L33:
        return d.x.f38692a;
    L18:
        Throwable th = th;
    L36:
        r9.releaseIntercepted();
        throw th;
    L20:
        d.o.a(r12);
        kotlinx.coroutines.b.a.u r14 = new kotlinx.coroutines.b.a.u(this.f39003a, r1.getContext());
        d.h.a.m<i<? super T>, d.c.d<? super d.x>, Object> r6 = this.f39004b;     // Catch: Throwable -> L34
        r1.f39005a = this;     // Catch: Throwable -> L34
        r1.f39006b = r14;     // Catch: Throwable -> L34
        r1.f39009e = 1;     // Catch: Throwable -> L34
        if (r6.invoke(r14, r1) != r3) goto L24;
        return r3;
    L24:
        r5 = this;
        r9 = r14;
    L34:
        th = move-exception;
        th = th;
        r9 = r14;
    L7:
        r1 = new a(this, r11);
        goto L8
    }
}
