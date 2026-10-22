package b0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class r1 implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1329f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1330g;

    public /* synthetic */ r1(int i2, Object obj) {
        this.f1329f = i2;
        this.f1330g = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p7.a
    public final Object c() {
        int i2 = this.f1329f;
        Object obj = this.f1330g;
        switch (i2) {
            case 0:
                ArrayList arrayList = ((s1) obj).f1340a;
                k.a0 a0Var = new k.a0(arrayList.size());
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    v0 v0Var = (v0) arrayList.get(i10);
                    Object obj2 = v0Var.f1381b;
                    int i11 = v0Var.f1380a;
                    Object u0Var = obj2 != null ? new u0(Integer.valueOf(i11), v0Var.f1381b) : Integer.valueOf(i11);
                    int iF = a0Var.f(u0Var);
                    boolean z4 = iF < 0;
                    Object obj3 = z4 ? null : a0Var.f5448c[iF];
                    if (obj3 != null) {
                        if (obj3 instanceof k.z) {
                            k.z zVar = (k.z) obj3;
                            zVar.a(v0Var);
                            v0Var = zVar;
                        } else {
                            Object[] objArr = k.f0.f5487a;
                            k.z zVar2 = new k.z(2);
                            zVar2.a(obj3);
                            zVar2.a(v0Var);
                            v0Var = zVar2;
                        }
                    }
                    if (z4) {
                        int i12 = ~iF;
                        a0Var.f5447b[i12] = u0Var;
                        a0Var.f5448c[i12] = v0Var;
                    } else {
                        a0Var.f5448c[iF] = v0Var;
                    }
                }
                return new d0.a(a0Var);
            case 1:
                StringBuilder sb2 = new StringBuilder("Scope for type parameter ");
                hb.k kVar = (hb.k) obj;
                sb2.append(((e9.f) kVar.f4298g).b());
                return n7.o.g(sb2.toString(), ((i8.h) kVar.f4299h).getUpperBounds());
            case 2:
                i8.q qVar = (i8.q) obj;
                HashSet hashSet = new HashSet();
                for (e9.f fVar : (Set) qVar.f4839e.f4843n.c()) {
                    if (fVar == null) {
                        i8.q.h(5);
                        throw null;
                    }
                    hashSet.addAll((Collection) qVar.f4836b.invoke(fVar));
                    hashSet.addAll((Collection) qVar.f4837c.invoke(fVar));
                }
                return hashSet;
            default:
                return (List) obj;
        }
    }
}
