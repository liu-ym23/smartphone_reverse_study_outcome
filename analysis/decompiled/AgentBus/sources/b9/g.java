package b9;

import a4.u;
import d7.s;
import d7.t;
import java.util.ArrayList;
import java.util.List;
import q7.k;
import z8.o0;
import z8.p0;
import z8.v0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final List f1584a;

    public g(v0 v0Var) {
        k.e(v0Var, "typeTable");
        List list = v0Var.f12417h;
        if ((v0Var.f12416g & 1) == 1) {
            int i2 = v0Var.f12418i;
            k.d(list, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(t.A0(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    s.z0();
                    throw null;
                }
                p0 p0VarE = (p0) obj;
                if (i10 >= i2) {
                    p0VarE.getClass();
                    o0 o0VarP = p0.p(p0VarE);
                    o0VarP.f12278i |= 2;
                    o0VarP.f12280k = true;
                    p0VarE = o0VarP.e();
                    if (!p0VarE.isInitialized()) {
                        throw new u(4);
                    }
                }
                arrayList.add(p0VarE);
                i10 = i11;
            }
            list = arrayList;
        }
        k.d(list, "run {\n        val origin… else originalTypes\n    }");
        this.f1584a = list;
    }

    public p0 a(int i2) {
        return (p0) this.f1584a.get(i2);
    }

    public g(List list) {
        this.f1584a = list;
    }
}
