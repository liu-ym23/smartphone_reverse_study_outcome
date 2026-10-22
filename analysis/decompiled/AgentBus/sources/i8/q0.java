package i8;

/* loaded from: classes.dex */
public final class q0 extends r0 {

    /* renamed from: q, reason: collision with root package name */
    public final c7.o f4840q;

    public q0(f8.b bVar, r0 r0Var, int i2, g8.j jVar, e9.f fVar, v9.v vVar, boolean z4, boolean z10, boolean z11, v9.v vVar2, f8.n0 n0Var, p7.a aVar) {
        super(bVar, r0Var, i2, jVar, fVar, vVar, z4, z10, z11, vVar2, n0Var);
        this.f4840q = s7.a.H(aVar);
    }

    @Override // i8.r0
    public final r0 G0(d8.g gVar, e9.f fVar, int i2) {
        g8.j annotations = getAnnotations();
        q7.k.d(annotations, "annotations");
        v9.v type = getType();
        q7.k.d(type, "type");
        return new q0(gVar, null, i2, annotations, fVar, type, H0(), this.f4847m, this.f4848n, this.f4849o, f8.n0.f3487b, new a8.c(12, this));
    }
}
