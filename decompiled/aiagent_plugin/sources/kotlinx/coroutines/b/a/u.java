package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u<T> extends d.c.b.a.d implements d.c.b.a.e, kotlinx.coroutines.b.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.b.i<T> f38941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.c.g f38942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.g f38944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.d<? super d.x> f38945e;

    /* JADX INFO: compiled from: SafeCollector.kt */
    static final class a extends d.h.b.p implements d.h.a.m<Integer, d.c.g.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38946a = null;

        static {
            f38946a = new a();
        }

        a() {
            super(2);
        }

        public final Integer a(int r2, d.c.g.b r3) {
            d.c.g.b r1 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.b.class, "com.obric.aiagent.plugin");
            return Integer.valueOf(r2 + 1);
        }

        @Override // d.h.a.m
        public /* synthetic */ Integer invoke(Integer r3, d.c.g.b r4) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // d.c.b.a.a, d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public u(kotlinx.coroutines.b.i<? super T> r5, d.c.g r6) {
        kotlinx.coroutines.b.i<T> r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
        super((d.c.d) ZeusTransformUtils.preCheckCast(r.f38935a, d.c.d.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin"));
        this.f38941a = r7;
        this.f38942b = r8;
        this.f38943c = ((Number) ZeusTransformUtils.preCheckCast(r8.fold(0, (d.h.a.m) ZeusTransformUtils.preCheckCast(a.f38946a, d.h.a.m.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // d.c.b.a.a, d.c.b.a.e
    public d.c.b.a.e getCallerFrame() {
        d.c.d<? super d.x> r2 = this.f38945e;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.b.a.d, d.c.d
    public d.c.g getContext() {
        d.c.g r2 = this.f38944d;
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.b.a.a
    public Object invokeSuspend(Object r4) {
        Throwable r0 = d.n.c(r4);
        if (r0 == null) goto L5;
        this.f38944d = (d.c.g) ZeusTransformUtils.preCheckCast(new m(r0, getContext()), d.c.g.class, "com.obric.aiagent.plugin");
    L5:
        d.c.d<? super d.x> r3 = this.f38945e;
        if (r3 == null) goto L9;
        r3.resumeWith(r4);
    L9:
        return d.c.a.b.a();
    }

    @Override // d.c.b.a.d, d.c.b.a.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    @Override // kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = a(r5, r3);     // Catch: Throwable -> L12
        if (r2 != d.c.a.b.a()) goto L8;
        d.c.b.a.h.c(r5);
    L8:
        if (r2 != d.c.a.b.a()) goto L11;
        return r2;
    L11:
        return d.x.f38692a;
    L12:
        th = move-exception;
        this.f38944d = (d.c.g) ZeusTransformUtils.preCheckCast(new m(th, r5.getContext()), d.c.g.class, "com.obric.aiagent.plugin");
        throw th;
    }

    private final Object a(d.c.d<? super d.x> r4, T r5) {
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r0 = r6.getContext();
        ce.b(r0);
        d.c.g r2 = this.f38944d;
        if (r2 == r0) goto L5;
        a(r0, r2, r5);
        this.f38944d = r0;
    L5:
        this.f38945e = r6;
        d.h.a.q r7 = v.a();
        kotlinx.coroutines.b.i<T> r1 = this.f38941a;
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        d.h.b.o.a(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object r8 = r7.invoke(r1, r5, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(r8, d.c.a.b.a()) == true) goto L8;
        this.f38945e = null;
    L8:
        return r8;
    }

    private final void a(d.c.g r3, d.c.g r4, T r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, m.class) == false) goto L5;
        a((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin"), r5);
    L5:
        w.a(this, r6);
    }

    private final void a(m r3, Object r4) {
        throw new IllegalStateException(d.o.o.a("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + r3.f38933a + ", but then emission attempt of value '" + r4 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }
}
