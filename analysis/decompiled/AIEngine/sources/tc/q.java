package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends u0<Double, double[], p> {

    /* renamed from: c, reason: collision with root package name */
    public static final q f13033c = new q(r.f13036a);

    @Override // tc.a
    public final int h(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.g.f(dArr, "<this>");
        return dArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        p builder = (p) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        double dY = bVar.y(this.f13058b, i10);
        builder.b(builder.d() + 1);
        double[] dArr = builder.f13028a;
        int i11 = builder.f13029b;
        builder.f13029b = i11 + 1;
        dArr[i11] = dY;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.g.f(dArr, "<this>");
        p pVar = new p();
        pVar.f13028a = dArr;
        pVar.f13029b = dArr.length;
        pVar.b(10);
        return pVar;
    }

    @Override // tc.u0
    public final double[] n() {
        return new double[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, double[] dArr, int i10) {
        double[] content = dArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.h(this.f13058b, i11, content[i11]);
        }
    }
}
