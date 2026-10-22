package b0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w0 implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1388f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1389g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1390h;

    public /* synthetic */ w0(int i2, Object obj, Object obj2) {
        this.f1388f = i2;
        this.f1389g = obj;
        this.f1390h = obj2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long j2;
        switch (this.f1388f) {
            case 0:
                x0 x0Var = (x0) this.f1389g;
                Object obj2 = x0Var.f1416c;
                ia.m mVar = (ia.m) this.f1390h;
                synchronized (obj2) {
                    ((ArrayList) x0Var.f1414a).remove(mVar);
                }
                return c7.r.f1986a;
            case 1:
                f8.c cVar = (f8.c) obj;
                h9.m mVar2 = (h9.m) this.f1389g;
                f8.c cVar2 = (f8.c) this.f1390h;
                q7.k.e(cVar, "second");
                mVar2.d(cVar2, cVar);
                return c7.r.f1986a;
            default:
                l0.k kVar = (l0.k) obj;
                synchronized (l0.m.f5774c) {
                    j2 = l0.m.f5776e;
                    l0.m.f5776e = 1 + j2;
                }
                return new l0.b(j2, kVar, (p7.k) this.f1389g, (p7.k) this.f1390h);
        }
    }
}
