package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d1 extends u0<lb.e, lb.f, c1> {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f12971c = new d1(e1.f12975a);

    @Override // tc.a
    public final int h(Object obj) {
        byte[] collectionSize = ((lb.f) obj).f10397a;
        kotlin.jvm.internal.g.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        c1 builder = (c1) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        byte bA = bVar.k(this.f13058b, i10).A();
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f12968a;
        int i11 = builder.f12969b;
        builder.f12969b = i11 + 1;
        bArr[i11] = bA;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        byte[] toBuilder = ((lb.f) obj).f10397a;
        kotlin.jvm.internal.g.f(toBuilder, "$this$toBuilder");
        c1 c1Var = new c1();
        c1Var.f12968a = toBuilder;
        c1Var.f12969b = toBuilder.length;
        c1Var.b(10);
        return c1Var;
    }

    @Override // tc.u0
    public final lb.f n() {
        return new lb.f(new byte[0]);
    }

    @Override // tc.u0
    public final void o(sc.c encoder, lb.f fVar, int i10) {
        byte[] bArr = fVar.f10397a;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.v(this.f13058b, i11).d(bArr[i11]);
        }
    }
}
