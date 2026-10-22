package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v extends u0<Float, float[], u> {

    /* renamed from: c, reason: collision with root package name */
    public static final v f13059c = new v(w.f13062a);

    @Override // tc.a
    public final int h(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.g.f(fArr, "<this>");
        return fArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        u builder = (u) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        float fD = bVar.d(this.f13058b, i10);
        builder.b(builder.d() + 1);
        float[] fArr = builder.f13056a;
        int i11 = builder.f13057b;
        builder.f13057b = i11 + 1;
        fArr[i11] = fD;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.g.f(fArr, "<this>");
        u uVar = new u();
        uVar.f13056a = fArr;
        uVar.f13057b = fArr.length;
        uVar.b(10);
        return uVar;
    }

    @Override // tc.u0
    public final float[] n() {
        return new float[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, float[] fArr, int i10) {
        float[] content = fArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.n(this.f13058b, i11, content[i11]);
        }
    }
}
