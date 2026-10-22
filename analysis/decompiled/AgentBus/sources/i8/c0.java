package i8;

/* loaded from: classes.dex */
public abstract class c0 extends n implements f8.e0 {

    /* renamed from: j, reason: collision with root package name */
    public final e9.c f4758j;

    /* renamed from: k, reason: collision with root package name */
    public final String f4759k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(f8.z zVar, e9.c cVar) {
        super(zVar, g8.h.f3888a, cVar.g(), f8.n0.f3487b);
        q7.k.e(zVar, "module");
        q7.k.e(cVar, "fqName");
        this.f4758j = cVar;
        this.f4759k = "package " + cVar + " of " + zVar;
    }

    @Override // i8.n, f8.j
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public final f8.z p() {
        f8.j jVarP = super.p();
        q7.k.c(jVarP, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (f8.z) jVarP;
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return lVar.l(this, obj);
    }

    @Override // i8.n, f8.k
    public f8.n0 q() {
        return f8.n0.f3487b;
    }

    @Override // i8.m
    public String toString() {
        return this.f4759k;
    }
}
