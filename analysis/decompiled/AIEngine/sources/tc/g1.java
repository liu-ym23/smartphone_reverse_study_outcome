package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g1 extends u0<lb.g, lb.h, f1> {

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f12985c = new g1(h1.f12989a);

    @Override // tc.a
    public final int h(Object obj) {
        int[] collectionSize = ((lb.h) obj).f10401a;
        kotlin.jvm.internal.g.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        f1 builder = (f1) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        int iH = bVar.k(this.f13058b, i10).h();
        builder.b(builder.d() + 1);
        int[] iArr = builder.f12979a;
        int i11 = builder.f12980b;
        builder.f12980b = i11 + 1;
        iArr[i11] = iH;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        int[] toBuilder = ((lb.h) obj).f10401a;
        kotlin.jvm.internal.g.f(toBuilder, "$this$toBuilder");
        f1 f1Var = new f1();
        f1Var.f12979a = toBuilder;
        f1Var.f12980b = toBuilder.length;
        f1Var.b(10);
        return f1Var;
    }

    @Override // tc.u0
    public final lb.h n() {
        return new lb.h(new int[0]);
    }

    @Override // tc.u0
    public final void o(sc.c encoder, lb.h hVar, int i10) {
        int[] iArr = hVar.f10401a;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.v(this.f13058b, i11).w(iArr[i11]);
        }
    }
}
