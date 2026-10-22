package l0;

import k0.b2;
import k0.i2;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends i0 {

    /* renamed from: d, reason: collision with root package name */
    public static final r f7700d;

    /* renamed from: e, reason: collision with root package name */
    public static final r f7701e;

    /* renamed from: f, reason: collision with root package name */
    public static final r f7702f;

    /* renamed from: g, reason: collision with root package name */
    public static final r f7703g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7704c;

    static {
        int i = 1;
        f7700d = new r(i, 2, 0);
        int i3 = 1;
        f7701e = new r(i3, i3, 1);
        f7702f = new r(i, 2, 2);
        int i10 = 1;
        f7703g = new r(i10, i10, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i, int i3, int i10) {
        super(i, i3);
        this.f7704c = i10;
    }

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        switch (this.f7704c) {
            case 0:
                Object objInvoke = ((xb.a) jVar.e(0)).invoke();
                k0.b bVar = (k0.b) jVar.e(1);
                int iD = jVar.d(0);
                bVar.getClass();
                i2Var.T(i2Var.c(bVar), objInvoke);
                dVar.j(iD, objInvoke);
                dVar.d(objInvoke);
                break;
            case 1:
                k0.b bVar2 = (k0.b) jVar.e(0);
                int iD2 = jVar.d(0);
                dVar.i();
                bVar2.getClass();
                dVar.c(iD2, i2Var.C(i2Var.c(bVar2)));
                break;
            case 2:
                Object objE = jVar.e(0);
                k0.b bVar3 = (k0.b) jVar.e(1);
                int iD3 = jVar.d(0);
                if (objE instanceof b2) {
                    b2 b2Var = (b2) objE;
                    iVar.f11188e.b(b2Var);
                    iVar.f11187d.a(b2Var);
                }
                Object objJ = i2Var.J(i2Var.c(bVar3), iD3, objE);
                if (!(objJ instanceof b2)) {
                    if (objJ instanceof v1) {
                        ((v1) objJ).c();
                        break;
                    }
                } else {
                    iVar.d((b2) objJ);
                    break;
                }
                break;
            default:
                Object objE2 = jVar.e(0);
                int iD4 = jVar.d(0);
                if (objE2 instanceof b2) {
                    b2 b2Var2 = (b2) objE2;
                    iVar.f11188e.b(b2Var2);
                    iVar.f11187d.a(b2Var2);
                }
                Object objJ2 = i2Var.J(i2Var.f6956t, iD4, objE2);
                if (!(objJ2 instanceof b2)) {
                    if (objJ2 instanceof v1) {
                        ((v1) objJ2).c();
                        break;
                    }
                } else {
                    iVar.d((b2) objJ2);
                    break;
                }
                break;
        }
    }

    @Override // l0.i0
    public k0.b b(androidx.datastore.preferences.protobuf.j jVar) {
        switch (this.f7704c) {
            case 0:
                return (k0.b) jVar.e(1);
            case 1:
                return (k0.b) jVar.e(0);
            default:
                return super.b(jVar);
        }
    }
}
