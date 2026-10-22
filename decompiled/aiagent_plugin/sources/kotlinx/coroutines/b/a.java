package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> implements c<T>, h<T> {

    /* JADX INFO: renamed from: kotlinx.coroutines.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Flow.kt */
    @d.c.b.a.f(b = "Flow.kt", c = {226}, d = "collect", e = "kotlinx.coroutines.flow.AbstractFlow")
    static final class C1046a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f38867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<T> f38868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f38869d;

        C1046a(a<T> r3, d.c.d<? super C1046a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38868c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f38867b = r3;
            this.f38869d |= Integer.MIN_VALUE;
            return this.f38868c.collect(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public abstract Object a(i<? super T> r1, d.c.d<? super d.x> r2);

    public a() {
    }

    @Override // kotlinx.coroutines.b.h
    public final Object collect(i<? super T> r6, d.c.d<? super d.x> r7) {
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C1046a.class) == false) goto L7;
        C1046a r0 = (C1046a) ZeusTransformUtils.preCheckCast(r9, C1046a.class, "com.obric.aiagent.plugin");
        if ((r0.f38869d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f38869d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f38867b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f38869d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        kotlinx.coroutines.b.a.u r5 = (kotlinx.coroutines.b.a.u) ZeusTransformUtils.preCheckCast(r0.f38866a, kotlinx.coroutines.b.a.u.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Throwable -> L14
    L23:
        r5.releaseIntercepted();
        return d.x.f38692a;
    L14:
        th = th;
    L27:
        r5.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r10);
        kotlinx.coroutines.b.a.u r11 = new kotlinx.coroutines.b.a.u(r8, r0.getContext());
        i<? super T> r12 = (i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r0.f38866a = r11;     // Catch: Throwable -> L25
        r0.f38869d = 1;     // Catch: Throwable -> L25
        if (a(r12, r0) != r2) goto L22;
        return r2;
    L22:
        r5 = r11;
    L25:
        th = th;
        r5 = r11;
    L7:
        r0 = new C1046a(this, r9);
        goto L8
    }
}
