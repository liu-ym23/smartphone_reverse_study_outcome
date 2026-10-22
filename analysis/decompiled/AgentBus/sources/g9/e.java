package g9;

import java.io.IOException;
import m.x;
import v9.p0;
import v9.v;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3932g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f3933h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(g gVar, int i2) {
        super(1);
        this.f3932g = i2;
        this.f3933h = gVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) throws IOException {
        switch (this.f3932g) {
            case 0:
                p0 p0Var = (p0) obj;
                q7.k.e(p0Var, "it");
                if (p0Var.c()) {
                    return "*";
                }
                v vVarB = p0Var.b();
                q7.k.d(vVarB, "it.type");
                String strZ = this.f3933h.Z(vVarB);
                if (p0Var.a() == 1) {
                    return strZ;
                }
                return x.z(p0Var.a()) + ' ' + strZ;
            case 1:
                j9.g gVar = (j9.g) obj;
                q7.k.e(gVar, "it");
                return this.f3933h.C(gVar);
            default:
                v vVar = (v) obj;
                q7.k.d(vVar, "it");
                return this.f3933h.Z(vVar);
        }
    }
}
