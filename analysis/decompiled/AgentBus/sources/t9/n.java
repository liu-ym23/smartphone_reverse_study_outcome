package t9;

import d7.e0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q7.w;
import q7.x;
import z8.f0;
import z8.r0;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9824j;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9825a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f9826b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f9827c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.e f9828d;

    /* renamed from: e, reason: collision with root package name */
    public final u9.e f9829e;

    /* renamed from: f, reason: collision with root package name */
    public final b0.e f9830f;

    /* renamed from: g, reason: collision with root package name */
    public final u9.i f9831g;

    /* renamed from: h, reason: collision with root package name */
    public final u9.i f9832h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f9833i;

    static {
        x xVar = w.f8821a;
        f9824j = new w7.t[]{xVar.f(new q7.p(xVar.b(n.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), xVar.f(new q7.p(xVar.b(n.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
    }

    public n(o oVar, List list, List list2, List list3) {
        q7.k.e(list, "functionList");
        q7.k.e(list2, "propertyList");
        q7.k.e(list3, "typeAliasList");
        this.f9833i = oVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            e9.f fVarY = nb.i.y((b9.f) oVar.f9835b.f9071g, ((z8.x) ((f9.a) obj)).f12448k);
            Object arrayList = linkedHashMap.get(fVarY);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(fVarY, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f9825a = a(linkedHashMap);
        o oVar2 = this.f9833i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : list2) {
            e9.f fVarY2 = nb.i.y((b9.f) oVar2.f9835b.f9071g, ((f0) ((f9.a) obj2)).f12137k);
            Object arrayList2 = linkedHashMap2.get(fVarY2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(fVarY2, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        this.f9826b = a(linkedHashMap2);
        ((r9.i) this.f9833i.f9835b.f9070f).f9049c.getClass();
        o oVar3 = this.f9833i;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj3 : list3) {
            e9.f fVarY3 = nb.i.y((b9.f) oVar3.f9835b.f9071g, ((r0) ((f9.a) obj3)).f12345j);
            Object arrayList3 = linkedHashMap3.get(fVarY3);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap3.put(fVarY3, arrayList3);
            }
            ((List) arrayList3).add(obj3);
        }
        this.f9827c = a(linkedHashMap3);
        this.f9828d = ((r9.i) this.f9833i.f9835b.f9070f).f9047a.b(new m(this, 0));
        this.f9829e = ((r9.i) this.f9833i.f9835b.f9070f).f9047a.b(new m(this, 1));
        this.f9830f = ((r9.i) this.f9833i.f9835b.f9070f).f9047a.c(new m(this, 2));
        o oVar4 = this.f9833i;
        u9.k kVar = ((r9.i) oVar4.f9835b.f9070f).f9047a;
        l lVar = new l(this, oVar4, 0);
        kVar.getClass();
        this.f9831g = new u9.i(kVar, lVar);
        o oVar5 = this.f9833i;
        u9.k kVar2 = ((r9.i) oVar5.f9835b.f9070f).f9047a;
        l lVar2 = new l(this, oVar5, 1);
        kVar2.getClass();
        this.f9832h = new u9.i(kVar2, lVar2);
    }

    public static LinkedHashMap a(LinkedHashMap linkedHashMap) throws IOException {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e0.S(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<f9.a> iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
            for (f9.a aVar : iterable) {
                int iA = aVar.a();
                int iF = f9.f.f(iA) + iA;
                if (iF > 4096) {
                    iF = 4096;
                }
                f9.f fVarJ = f9.f.j(byteArrayOutputStream, iF);
                fVarJ.v(iA);
                aVar.d(fVarJ);
                fVarJ.i();
                arrayList.add(c7.r.f1986a);
            }
            linkedHashMap2.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap2;
    }
}
