package c8;

import d7.t;
import f8.h0;
import i8.a0;
import i8.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2020g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f2021h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(a0 a0Var, int i2) {
        super(0);
        this.f2020g = i2;
        this.f2021h = a0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f2020g) {
            case 0:
                return ((x) this.f2021h.z(n.f2063h)).f4900l;
            case 1:
                return new e8.h(this.f2021h);
            default:
                a0 a0Var = this.f2021h;
                b9.g gVar = a0Var.f4742l;
                if (gVar == null) {
                    StringBuilder sb2 = new StringBuilder("Dependencies of module ");
                    String str = a0Var.getName().f3197f;
                    q7.k.d(str, "name.toString()");
                    sb2.append(str);
                    sb2.append(" were not set before querying module content");
                    throw new AssertionError(sb2.toString());
                }
                List list = gVar.f1584a;
                a0Var.F0();
                list.contains(a0Var);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a0) it.next()).getClass();
                }
                ArrayList arrayList = new ArrayList(t.A0(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    h0 h0Var = ((a0) it2.next()).f4743m;
                    q7.k.b(h0Var);
                    arrayList.add(h0Var);
                }
                return new i8.l(arrayList, "CompositeProvider@ModuleDescriptor for " + a0Var.getName());
        }
    }
}
