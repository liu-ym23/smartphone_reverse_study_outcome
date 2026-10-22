package j1;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class j1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5207g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f5208h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5209i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Serializable f5210j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(r9.r rVar, boolean z4, z8.f0 f0Var) {
        super(0);
        this.f5209i = rVar;
        this.f5208h = z4;
        this.f5210j = f0Var;
    }

    @Override // p7.a
    public final Object c() {
        List listM1;
        switch (this.f5207g) {
            case 0:
                if (this.f5208h) {
                    q6.b bVar = (q6.b) this.f5209i;
                    String str = (String) this.f5210j;
                    bVar.getClass();
                    k3.a aVar = (k3.a) bVar.f8788h;
                    synchronized (aVar.f5583c) {
                    }
                }
                return c7.r.f1986a;
            default:
                r9.r rVar = (r9.r) this.f5209i;
                r9.k kVar = rVar.f9100a;
                r9.i iVar = (r9.i) kVar.f9070f;
                a4.e eVarA = rVar.a((f8.j) kVar.f9072h);
                if (eVarA != null) {
                    boolean z4 = this.f5208h;
                    z8.f0 f0Var = (z8.f0) this.f5210j;
                    listM1 = z4 ? d7.r.m1(iVar.f9051e.c(eVarA, f0Var)) : d7.r.m1(iVar.f9051e.d(eVarA, f0Var));
                } else {
                    listM1 = null;
                }
                return listM1 == null ? d7.z.f2978f : listM1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(boolean z4, q6.b bVar, String str) {
        super(0);
        this.f5208h = z4;
        this.f5209i = bVar;
        this.f5210j = str;
    }
}
