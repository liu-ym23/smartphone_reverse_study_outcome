package i8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class w extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4893g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x f4894h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(x xVar, int i2) {
        super(0);
        this.f4893g = i2;
        this.f4894h = xVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f4893g) {
            case 0:
                x xVar = this.f4894h;
                a0 a0Var = xVar.f4896h;
                a0Var.F0();
                return Boolean.valueOf(f8.v.h((l) a0Var.f4746p.getValue(), xVar.f4897i));
            case 1:
                x xVar2 = this.f4894h;
                a0 a0Var2 = xVar2.f4896h;
                a0Var2.F0();
                return f8.v.i((l) a0Var2.f4746p.getValue(), xVar2.f4897i);
            default:
                x xVar3 = this.f4894h;
                u9.i iVar = xVar3.f4899k;
                w7.t[] tVarArr = x.f4895m;
                boolean zBooleanValue = ((Boolean) n7.b.q(iVar, tVarArr[1])).booleanValue();
                e9.c cVar = xVar3.f4897i;
                a0 a0Var3 = xVar3.f4896h;
                if (zBooleanValue) {
                    return o9.m.f7933b;
                }
                List list = (List) n7.b.q(xVar3.f4898j, tVarArr[0]);
                ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((f8.e0) it.next()).v0());
                }
                return n7.b.e("package view scope for " + cVar + " in " + a0Var3.getName(), d7.r.d1(arrayList, new m0(a0Var3, cVar)));
        }
    }
}
