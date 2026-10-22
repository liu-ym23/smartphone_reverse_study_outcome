package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 extends u0<Integer, int[], a0> {

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f12963c = new b0(c0.f12966a);

    @Override // tc.a
    public final int h(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.g.f(iArr, "<this>");
        return iArr.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        a0 builder = (a0) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        int iT = bVar.t(this.f13058b, i10);
        builder.b(builder.d() + 1);
        int[] iArr = builder.f12959a;
        int i11 = builder.f12960b;
        builder.f12960b = i11 + 1;
        iArr[i11] = iT;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.g.f(iArr, "<this>");
        a0 a0Var = new a0();
        a0Var.f12959a = iArr;
        a0Var.f12960b = iArr.length;
        a0Var.b(10);
        return a0Var;
    }

    @Override // tc.u0
    public final int[] n() {
        return new int[0];
    }

    @Override // tc.u0
    public final void o(sc.c encoder, int[] iArr, int i10) {
        int[] content = iArr;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        kotlin.jvm.internal.g.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.f(this.f13058b, i11, content[i11]);
        }
    }
}
