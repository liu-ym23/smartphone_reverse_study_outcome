package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z0 extends u0<Short, short[], y0> {

    /* renamed from: c, reason: collision with root package name */
    public static final z0 f13072c = new z0(a1.f12961a);

    @Override // tc.a
    public final int h(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.g.f(sArr, "<this>");
        return sArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        y0 builder = (y0) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        short s8 = bVar.s(this.f13058b, i10);
        builder.b(builder.d() + 1);
        short[] sArr = builder.f13069a;
        int i11 = builder.f13070b;
        builder.f13070b = i11 + 1;
        sArr[i11] = s8;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.g.f(sArr, "<this>");
        y0 y0Var = new y0();
        y0Var.f13069a = sArr;
        y0Var.f13070b = sArr.length;
        y0Var.b(10);
        return y0Var;
    }

    @Override // tc.u0
    public final short[] n() {
        return new short[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, short[] sArr, int i10) {
        short[] content = sArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.j(this.f13058b, i11, content[i11]);
        }
    }
}
