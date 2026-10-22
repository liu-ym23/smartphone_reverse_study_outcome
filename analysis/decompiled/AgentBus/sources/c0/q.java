package c0;

import b0.l2;
import b0.s2;
import b0.z1;
import i1.a1;

/* loaded from: classes.dex */
public final class q extends b9.d {

    /* renamed from: e, reason: collision with root package name */
    public static final q f1754e;

    /* renamed from: f, reason: collision with root package name */
    public static final q f1755f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f1756g;

    /* renamed from: h, reason: collision with root package name */
    public static final q f1757h;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1758d;

    static {
        int i2 = 1;
        f1754e = new q(i2, 2, 0);
        int i10 = 1;
        f1755f = new q(i10, i10, 1);
        f1756g = new q(i2, 2, 2);
        int i11 = 1;
        f1757h = new q(i11, i11, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(int i2, int i10, int i11) {
        super(i2, i10, 1, (byte) 0);
        this.f1758d = i11;
    }

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        switch (this.f1758d) {
            case 0:
                Object objC = ((p7.a) kVar.c(0)).c();
                b0.a aVar = (b0.a) kVar.c(1);
                int iB = kVar.b(0);
                aVar.getClass();
                s2Var.R(s2Var.c(aVar), objC);
                cVar.e(iB, objC);
                cVar.c(objC);
                break;
            case 1:
                b0.a aVar2 = (b0.a) kVar.c(0);
                int iB2 = kVar.b(0);
                cVar.j();
                aVar2.getClass();
                cVar.a(iB2, s2Var.A(s2Var.c(aVar2)));
                break;
            case 2:
                Object objC2 = kVar.c(0);
                b0.a aVar3 = (b0.a) kVar.c(1);
                int iB3 = kVar.b(0);
                if (objC2 instanceof l2) {
                    l2 l2Var = (l2) objC2;
                    a1Var.f4397c.b(l2Var);
                    ((k.b0) a1Var.f4401g).a(l2Var);
                }
                Object objH = s2Var.H(s2Var.c(aVar3), iB3, objC2);
                if (!(objH instanceof l2)) {
                    if (objH instanceof z1) {
                        ((z1) objH).d();
                        break;
                    }
                } else {
                    a1Var.g((l2) objH);
                    break;
                }
                break;
            default:
                Object objC3 = kVar.c(0);
                int iB4 = kVar.b(0);
                if (objC3 instanceof l2) {
                    l2 l2Var2 = (l2) objC3;
                    a1Var.f4397c.b(l2Var2);
                    ((k.b0) a1Var.f4401g).a(l2Var2);
                }
                Object objH2 = s2Var.H(s2Var.f1365t, iB4, objC3);
                if (!(objH2 instanceof l2)) {
                    if (objH2 instanceof z1) {
                        ((z1) objH2).d();
                        break;
                    }
                } else {
                    a1Var.g((l2) objH2);
                    break;
                }
                break;
        }
    }

    @Override // b9.d
    public b0.a d(androidx.datastore.preferences.protobuf.k kVar) {
        switch (this.f1758d) {
            case 0:
                return (b0.a) kVar.c(1);
            case 1:
                return (b0.a) kVar.c(0);
            default:
                return super.d(kVar);
        }
    }
}
