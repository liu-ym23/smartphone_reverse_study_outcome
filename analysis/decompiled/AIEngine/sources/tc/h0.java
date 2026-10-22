package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h0 extends u0<Long, long[], g0> {

    /* renamed from: c, reason: collision with root package name */
    public static final h0 f12988c = new h0(i0.f12992a);

    @Override // tc.a
    public final int h(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.g.f(jArr, "<this>");
        return jArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        g0 builder = (g0) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        long jW = bVar.w(this.f13058b, i10);
        builder.b(builder.d() + 1);
        long[] jArr = builder.f12983a;
        int i11 = builder.f12984b;
        builder.f12984b = i11 + 1;
        jArr[i11] = jW;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.g.f(jArr, "<this>");
        g0 g0Var = new g0();
        g0Var.f12983a = jArr;
        g0Var.f12984b = jArr.length;
        g0Var.b(10);
        return g0Var;
    }

    @Override // tc.u0
    public final long[] n() {
        return new long[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, long[] jArr, int i10) {
        long[] content = jArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.y(this.f13058b, i11, content[i11]);
        }
    }
}
