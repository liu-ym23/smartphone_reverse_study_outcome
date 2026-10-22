package x4;

import c7.r;
import ia.d0;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11158f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f11159g;

    public /* synthetic */ a(i iVar, int i2) {
        this.f11158f = i2;
        this.f11159g = iVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11158f) {
            case 0:
                i iVar = this.f11159g;
                d0.s(iVar.f11187g, null, null, new d(0, null, iVar), 3);
                break;
            case 1:
                i iVar2 = this.f11159g;
                if (iVar2.f11188h.get()) {
                    d0.s(iVar2.f11187g, null, null, new e(0, null, iVar2), 3);
                }
                break;
            default:
                i iVar3 = this.f11159g;
                if (iVar3.f11188h.get()) {
                    d0.s(iVar3.f11187g, null, null, new e(1, null, iVar3), 3);
                }
                break;
        }
        return r.f1986a;
    }
}
