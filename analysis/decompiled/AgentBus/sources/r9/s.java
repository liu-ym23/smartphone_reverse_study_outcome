package r9;

import f8.n0;

/* loaded from: classes.dex */
public final class s extends a4.e {

    /* renamed from: e, reason: collision with root package name */
    public final z8.i f9102e;

    /* renamed from: f, reason: collision with root package name */
    public final s f9103f;

    /* renamed from: g, reason: collision with root package name */
    public final e9.b f9104g;

    /* renamed from: h, reason: collision with root package name */
    public final z8.h f9105h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9106i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(z8.i iVar, b9.f fVar, b9.g gVar, n0 n0Var, s sVar) {
        super(fVar, gVar, n0Var);
        q7.k.e(iVar, "classProto");
        q7.k.e(fVar, "nameResolver");
        this.f9102e = iVar;
        this.f9103f = sVar;
        this.f9104g = nb.i.s(fVar, iVar.f12189j);
        z8.h hVar = (z8.h) b9.e.f1563f.e(iVar.f12188i);
        this.f9105h = hVar == null ? z8.h.CLASS : hVar;
        this.f9106i = b9.e.f1564g.e(iVar.f12188i).booleanValue();
    }

    @Override // a4.e
    public final e9.c c() {
        return this.f9104g.b();
    }
}
