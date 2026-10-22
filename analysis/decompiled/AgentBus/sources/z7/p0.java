package z7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class p0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11931g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f11932h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(q0 q0Var, int i2) {
        super(0);
        this.f11931g = i2;
        this.f11932h = q0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Iterable] */
    @Override // p7.a
    public final Object c() throws f9.r {
        ?? S;
        switch (this.f11931g) {
            case 0:
                q1 q1Var = this.f11932h.f11937c;
                w7.t tVar = q0.f11936g[0];
                k8.c cVar = (k8.c) q1Var.c();
                if (cVar != null) {
                    gb.h hVar = cVar.f5653b;
                    String[] strArr = (String[]) hVar.f4055e;
                    String[] strArr2 = (String[]) hVar.f4057g;
                    if (strArr != null && strArr2 != null) {
                        c7.j jVarH = d9.h.h(strArr, strArr2);
                        return new c7.p((d9.g) jVarH.f1973f, (z8.b0) jVarH.f1974g, (d9.f) hVar.f4054d);
                    }
                }
                return null;
            default:
                q0 q0Var = this.f11932h;
                q1 q1Var2 = q0Var.f11937c;
                w7.t tVar2 = q0.f11936g[0];
                k8.c cVar2 = (k8.c) q1Var2.c();
                if (cVar2 == null) {
                    return o9.m.f7933b;
                }
                q1 q1Var3 = q0Var.f11855a;
                w7.t tVar3 = c0.f11854b[0];
                Object objC = q1Var3.c();
                q7.k.d(objC, "<get-moduleData>(...)");
                i5.l lVar = ((k8.f) objC).f5658b;
                x8.d dVar = (x8.d) lVar.f4687g;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) lVar.f4689i;
                Class cls = cVar2.f5652a;
                e9.b bVarA = l8.d.a(cls);
                Object obj = concurrentHashMap.get(bVarA);
                if (obj == null) {
                    e9.c cVarG = l8.d.a(cls).g();
                    q7.k.d(cVarG, "fileClass.classId.packageFqName");
                    gb.h hVar2 = cVar2.f5653b;
                    y8.a aVar = (y8.a) hVar2.f4053c;
                    y8.a aVar2 = y8.a.MULTIFILE_CLASS;
                    if (aVar == aVar2) {
                        String[] strArr3 = (String[]) hVar2.f4055e;
                        if (aVar != aVar2) {
                            strArr3 = null;
                        }
                        List listS = strArr3 != null ? d7.n.S(strArr3) : null;
                        if (listS == null) {
                            listS = d7.z.f2978f;
                        }
                        S = new ArrayList();
                        Iterator it = listS.iterator();
                        while (it.hasNext()) {
                            e9.b bVarJ = e9.b.j(new e9.c(m9.b.d((String) it.next()).f6454a.replace('/', '.')));
                            k8.b bVar = (k8.b) lVar.f4688h;
                            q7.k.e(dVar.c().f9049c, "<this>");
                            k8.c cVarH = n7.b.h(bVar, bVarJ, d9.f.f3008g);
                            if (cVarH != null) {
                                S.add(cVarH);
                            }
                        }
                    } else {
                        S = a.a.S(cVar2);
                    }
                    e8.k kVar = new e8.k(dVar.c().f9048b, cVarG, 1);
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = S.iterator();
                    while (it2.hasNext()) {
                        t9.p pVarA = dVar.a(kVar, (k8.c) it2.next());
                        if (pVarA != null) {
                            arrayList.add(pVarA);
                        }
                    }
                    o9.n nVarE = n7.b.e("package " + cVarG + " (" + cVar2 + ')', d7.r.m1(arrayList));
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(bVarA, nVarE);
                    obj = objPutIfAbsent == null ? nVarE : objPutIfAbsent;
                }
                q7.k.d(obj, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
                return (o9.n) obj;
        }
    }
}
