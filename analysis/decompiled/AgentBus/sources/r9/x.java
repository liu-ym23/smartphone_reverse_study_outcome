package r9;

import z8.p0;

/* loaded from: classes.dex */
public final class x extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9109g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a7.g f9110h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(a7.g gVar, int i2) {
        super(1);
        this.f9109g = i2;
        this.f9110h = gVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f9109g) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                k kVar = (k) this.f9110h.f418g;
                b9.f fVar = (b9.f) kVar.f9071g;
                i iVar = (i) kVar.f9070f;
                e9.b bVarS = nb.i.s(fVar, iIntValue);
                return bVarS.f3186c ? iVar.b(bVarS) : f8.v.e(iVar.f9048b, bVarS);
            case 1:
                int iIntValue2 = ((Number) obj).intValue();
                k kVar2 = (k) this.f9110h.f418g;
                e9.b bVarS2 = nb.i.s((b9.f) kVar2.f9071g, iIntValue2);
                if (!bVarS2.f3186c) {
                    f8.z zVar = ((i) kVar2.f9070f).f9048b;
                    q7.k.e(zVar, "<this>");
                    f8.g gVarE = f8.v.e(zVar, bVarS2);
                    if (gVarE instanceof t9.s) {
                        return (t9.s) gVarE;
                    }
                }
                return null;
            default:
                p0 p0Var = (p0) obj;
                q7.k.e(p0Var, "it");
                return a.a.Z(p0Var, (b9.g) ((k) this.f9110h.f418g).f9073i);
        }
    }
}
