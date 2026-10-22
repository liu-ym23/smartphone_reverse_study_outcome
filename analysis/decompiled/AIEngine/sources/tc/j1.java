package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j1 extends u0<lb.i, lb.j, i1> {

    /* renamed from: c, reason: collision with root package name */
    public static final j1 f13000c = new j1(k1.f13003a);

    @Override // tc.a
    public final int h(Object obj) {
        long[] collectionSize = ((lb.j) obj).f10405a;
        kotlin.jvm.internal.g.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // tc.o, tc.a
    public final void j(sc.b bVar, int i10, Object obj) {
        i1 builder = (i1) obj;
        kotlin.jvm.internal.g.f(builder, "builder");
        long j10 = bVar.k(this.f13058b, i10).j();
        builder.b(builder.d() + 1);
        long[] jArr = builder.f12994a;
        int i11 = builder.f12995b;
        builder.f12995b = i11 + 1;
        jArr[i11] = j10;
    }

    @Override // tc.a
    public final Object k(Object obj) {
        long[] toBuilder = ((lb.j) obj).f10405a;
        kotlin.jvm.internal.g.f(toBuilder, "$this$toBuilder");
        i1 i1Var = new i1();
        i1Var.f12994a = toBuilder;
        i1Var.f12995b = toBuilder.length;
        i1Var.b(10);
        return i1Var;
    }

    @Override // tc.u0
    public final lb.j n() {
        return new lb.j(new long[0]);
    }

    @Override // tc.u0
    public final void o(sc.c encoder, lb.j jVar, int i10) {
        long[] jArr = jVar.f10405a;
        kotlin.jvm.internal.g.f(encoder, "encoder");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.v(this.f13058b, i11).i(jArr[i11]);
        }
    }
}
