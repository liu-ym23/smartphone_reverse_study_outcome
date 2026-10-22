package t9;

import java.util.Collection;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9792g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f9793h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(f fVar, int i2) {
        super(0);
        this.f9792g = i2;
        this.f9793h = fVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9792g) {
            case 0:
                o9.f fVar = o9.f.f7910m;
                o9.n.f7934a.getClass();
                return this.f9793h.i(fVar, o9.k.f7927h);
            default:
                f fVar2 = this.f9793h;
                w9.g gVar = fVar2.f9794g;
                i iVar = fVar2.f9797j;
                gVar.getClass();
                q7.k.e(iVar, "classDescriptor");
                Collection collectionD = ((v9.f) iVar.h()).d();
                q7.k.d(collectionD, "classDescriptor.typeConstructor.supertypes");
                return collectionD;
        }
    }
}
