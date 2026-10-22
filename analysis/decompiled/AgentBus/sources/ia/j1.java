package ia;

import o4.b3;
import o4.t2;

/* loaded from: classes.dex */
public final /* synthetic */ class j1 extends q7.i implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f4964n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j1(int i2, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(i2, obj, cls, str, str2, i10);
        this.f4964n = i11;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f4964n) {
            case 0:
                ((k1) this.f8801g).l((Throwable) obj);
                break;
            case 1:
                String str = (String) obj;
                q7.k.e(str, "p0");
                t2 t2Var = (t2) this.f8801g;
                t2Var.getClass();
                t2Var.d(0, str);
                break;
            case 2:
                c5.b bVar = (c5.b) obj;
                q7.k.e(bVar, "p0");
                b3 b3Var = (b3) this.f8801g;
                b3Var.getClass();
                b3Var.f7297n.M(bVar);
                break;
            default:
                ((s0.s) this.f8801g).getClass();
                i1.j jVar = ((s0.q) obj).f6797f;
                i1.s1 s1Var = jVar instanceof i1.s1 ? (i1.s1) jVar : null;
                if (s1Var != null) {
                    i1.l.n(s1Var);
                }
                break;
        }
        return c7.r.f1986a;
    }
}
