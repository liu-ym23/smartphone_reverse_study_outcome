package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m1 extends u0<lb.l, lb.m, l1> {

    /* renamed from: c, reason: collision with root package name */
    public static final m1 f13015c = new m1(n1.f13020a);

    @Override // tc.a
    public final int h(Object obj) {
        short[] collectionSize = ((lb.m) obj).f10410a;
        kotlin.jvm.internal.g.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        l1 builder = (l1) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        short sL = bVar.k(this.f13058b, i10).l();
        builder.b(builder.d() + 1);
        short[] sArr = builder.f13010a;
        int i11 = builder.f13011b;
        builder.f13011b = i11 + 1;
        sArr[i11] = sL;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        short[] toBuilder = ((lb.m) obj).f10410a;
        kotlin.jvm.internal.g.f(toBuilder, "$this$toBuilder");
        l1 l1Var = new l1();
        l1Var.f13010a = toBuilder;
        l1Var.f13011b = toBuilder.length;
        l1Var.b(10);
        return l1Var;
    }

    @Override // tc.u0
    public final lb.m n() {
        return new lb.m(new short[0]);
    }

    @Override // tc.u0
    public final void o(sc.c encoder, lb.m mVar, int i10) {
        short[] sArr = mVar.f10410a;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.v(this.f13058b, i11).m(sArr[i11]);
        }
    }
}
