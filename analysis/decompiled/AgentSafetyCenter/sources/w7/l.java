package w7;

import b8.b0;
import com.fasterxml.jackson.databind.JsonNode;
import java.lang.invoke.VarHandle;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements s {

    /* renamed from: l, reason: collision with root package name */
    public static final long f15323l = 8;

    /* renamed from: m, reason: collision with root package name */
    public static final e2.d f15324m = new e2.d(4);

    /* renamed from: a, reason: collision with root package name */
    public final String f15325a;

    /* renamed from: b, reason: collision with root package name */
    public List f15326b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15327c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15328d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15329e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15330f;

    /* renamed from: g, reason: collision with root package name */
    public final JsonNode f15331g;

    /* renamed from: h, reason: collision with root package name */
    public final l f15332h;
    public final n i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.room.q f15333j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f15334k;

    public l(androidx.room.q qVar, n nVar, JsonNode jsonNode, l lVar, boolean z10) {
        n nVarE;
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        ConcurrentMap concurrentMap = (ConcurrentMap) qVar.f1603f;
        String strTextValue = null;
        this.f15326b = null;
        this.f15327c = false;
        this.f15328d = false;
        this.f15329e = false;
        this.f15330f = false;
        this.f15333j = qVar;
        y7.a aVar = (y7.a) qVar.f1600c;
        JsonNode jsonNode4 = jsonNode.get(aVar.f15930b);
        String strTextValue2 = jsonNode4 == null ? null : jsonNode4.textValue();
        if (strTextValue2 != null) {
            int iIndexOf = strTextValue2.indexOf(35);
            String strSubstring = (iIndexOf == -1 || iIndexOf + 1 >= strTextValue2.length()) ? strTextValue2 : strTextValue2.substring(0, iIndexOf);
            nVarE = !"".equals(strSubstring) ? nVar.e(strSubstring) : nVar;
            ((o) qVar.f1601d).f15349g.getClass();
            if ((nVar.f15339a != null && !nVar.toString().startsWith("#")) || (!strTextValue2.startsWith("#") && !strTextValue2.startsWith("/"))) {
                a aVar2 = nVarE.f15339a;
                if (aVar2 != null) {
                    String str = aVar2.f15287a;
                    if (str.contains(":")) {
                        try {
                            new URI(str);
                        } catch (URISyntaxException unused) {
                        }
                    }
                }
                n nVarB = nVar.b(aVar.f15930b);
                b bVar = new b();
                String str2 = b0.f1936y.f1938c;
                bVar.i = str2;
                bVar.f15290a = str2;
                bVar.f15293d = nVarB.f15340b;
                bVar.f15294e = new Object[]{strTextValue2, aVar.f15930b, nVarB};
                bVar.f15292c = nVarB;
                b.b bVar2 = new b.b(10);
                bVar2.f1685f = qVar;
                VarHandle.storeStoreFence();
                bVar.f15297h = bVar2;
                throw new h(bVar.a());
            }
        } else {
            nVarE = nVar;
        }
        this.i = nVarE;
        this.f15331g = jsonNode;
        this.f15332h = lVar;
        this.f15334k = z10;
        JsonNode jsonNode5 = jsonNode.get(aVar.f15930b);
        String strTextValue3 = jsonNode5 == null ? null : jsonNode5.textValue();
        if (strTextValue3 != null) {
            n nVarE2 = strTextValue3.indexOf(35) != -1 ? nVar.e(strTextValue3) : nVarE;
            c8.a aVar3 = nVarE.f15340b;
            if (aVar3 == null || (aVar3.f2224f == null && aVar3.getNameCount() == 0)) {
                this.f15325a = strTextValue3;
            } else {
                this.f15325a = null;
            }
            concurrentMap.putIfAbsent(nVarE2 != null ? nVarE2.toString() : strTextValue3, this);
        } else {
            c8.a aVar4 = nVarE.f15340b;
            if (aVar4 == null || (aVar4.f2224f == null && aVar4.getNameCount() == 0)) {
                a aVar5 = nVar.f15339a;
                this.f15325a = aVar5 != null ? aVar5.f15287a : "";
                concurrentMap.putIfAbsent(nVar.toString(), this);
            } else {
                this.f15325a = null;
            }
        }
        String strTextValue4 = (!aVar.f15931c.containsKey("$anchor") || (jsonNode3 = jsonNode.get("$anchor")) == null) ? null : jsonNode3.textValue();
        if (strTextValue4 != null) {
            a aVar6 = nVarE.f15339a;
            concurrentMap.putIfAbsent((aVar6 != null ? aVar6.f15287a : "") + "#" + strTextValue4, this);
        }
        if (aVar.f15931c.containsKey("$dynamicAnchor") && (jsonNode2 = jsonNode.get("$dynamicAnchor")) != null) {
            strTextValue = jsonNode2.textValue();
        }
        if (strTextValue != null) {
            a aVar7 = nVarE.f15339a;
            String str3 = aVar7 != null ? aVar7.f15287a : "";
            ((ConcurrentMap) qVar.f1604g).putIfAbsent(str3 + "#" + strTextValue, this);
        }
        g();
    }

    @Override // w7.s
    public final void a(f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        List<b8.a> listG = g();
        ArrayDeque arrayDeque = fVar.f15312g;
        ArrayDeque arrayDeque2 = fVar.f15313h;
        arrayDeque.addLast(this);
        boolean z11 = fVar.f15314j;
        boolean z12 = fVar.f15315k;
        boolean z13 = this.f15327c;
        if (z13) {
            fVar.f15314j = z13;
        }
        boolean z14 = this.f15328d;
        if (z14) {
            fVar.f15315k = z14;
        }
        try {
            int size = fVar.f15309d.size();
            for (b8.a aVar2 : listG) {
                try {
                    fVar.f().getClass();
                    aVar2.getClass();
                    fVar.c(aVar2.e());
                    arrayDeque2.addLast(aVar2.e());
                    try {
                        aVar2.a(fVar, jsonNode, jsonNode2, aVar, z10);
                        fVar.d();
                        arrayDeque2.removeLast();
                        fVar.f().getClass();
                        List list = fVar.f15309d;
                        list.subList(size, list.size());
                    } finally {
                    }
                } catch (Throwable th) {
                    fVar.f().getClass();
                    aVar2.getClass();
                    List list2 = fVar.f15309d;
                    list2.subList(size, list2.size());
                    throw th;
                }
            }
        } finally {
            arrayDeque.removeLast();
            fVar.f15314j = z11;
            fVar.f15315k = z12;
        }
    }

    @Override // w7.s
    public final void b(f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        List<x7.a> list;
        List<b8.a> listG = g();
        ArrayDeque arrayDeque = fVar.f15312g;
        ArrayDeque arrayDeque2 = fVar.f15313h;
        arrayDeque.addLast(this);
        boolean z10 = fVar.f15314j;
        boolean z11 = fVar.f15315k;
        boolean z12 = this.f15327c;
        if (z12) {
            fVar.f15314j = z12;
        }
        boolean z13 = this.f15328d;
        if (z13) {
            fVar.f15315k = z13;
        }
        try {
            int size = fVar.f15309d.size();
            for (b8.a aVar2 : listG) {
                fVar.c(aVar2.e());
                arrayDeque2.addLast(aVar2.e());
                try {
                    aVar2.b(fVar, jsonNode, jsonNode2, aVar);
                    fVar.d();
                    arrayDeque2.removeLast();
                } catch (Throwable th) {
                    fVar.d();
                    arrayDeque2.removeLast();
                    throw th;
                }
            }
            if (fVar.f15309d.size() > size && (list = (List) fVar.e().f1627b.get(aVar)) != null) {
                for (x7.a aVar3 : list) {
                    if (aVar3.f15587d.e(fVar.f15311f)) {
                        aVar3.f15589f = false;
                    }
                }
            }
            arrayDeque.removeLast();
            fVar.f15314j = z10;
            fVar.f15315k = z11;
        } catch (Throwable th2) {
            arrayDeque.removeLast();
            fVar.f15314j = z10;
            fVar.f15315k = z11;
            throw th2;
        }
    }

    public final c8.a c() {
        o oVar = (o) this.f15333j.f1601d;
        oVar.f15349g.getClass();
        c8.e eVar = c8.e.JSON_POINTER;
        if (eVar.equals(eVar)) {
            return k.f15321b;
        }
        oVar.f15349g.getClass();
        if (eVar.equals(c8.e.LEGACY)) {
            return k.f15322c;
        }
        oVar.f15349g.getClass();
        if (eVar.equals(c8.e.JSON_PATH)) {
            return k.f15320a;
        }
        oVar.f15349g.getClass();
        return new c8.a(eVar);
    }

    public final l d() {
        while (true) {
            String str = this.f15325a;
            l lVar = this.f15332h;
            boolean zEquals = true;
            if (str == null && lVar != null) {
                zEquals = true ^ Objects.equals(this.i.f15339a, lVar.i.f15339a);
            }
            if (zEquals) {
                return this;
            }
            this = lVar;
        }
    }

    public final l e(c8.a aVar) {
        if (c8.e.JSON_POINTER.equals(aVar.f2223c)) {
            return f(aVar);
        }
        a aVar2 = this.i.f15339a;
        String str = (aVar2 != null ? aVar2.f15287a : "") + "#" + aVar;
        androidx.room.q qVar = this.f15333j;
        l lVar = (l) ((ConcurrentMap) qVar.f1603f).get(str);
        if (lVar == null) {
            lVar = (l) ((ConcurrentMap) qVar.f1604g).get(str);
        }
        if (lVar != null) {
            return lVar;
        }
        throw new m("Unable to find anchor ".concat(str));
    }

    public final l f(c8.a aVar) {
        l lVarF;
        JsonNode jsonNode;
        JsonNode jsonNode2;
        l lVarD = d();
        JsonNode jsonNode3 = lVarD.f15331g;
        n nVar = lVarD.i;
        int nameCount = aVar.getNameCount();
        int i = 0;
        l lVar = lVarD;
        l lVarD2 = null;
        while (true) {
            androidx.room.q qVar = lVar.f15333j;
            if (i >= nameCount) {
                return lVarD2;
            }
            Object objD = aVar.d(i);
            boolean z10 = objD instanceof Number;
            JsonNode jsonNode4 = (z10 && jsonNode3.isArray()) ? jsonNode3.get(((Number) objD).intValue()) : jsonNode3.get(objD.toString());
            if (jsonNode4 == null) {
                l lVarD3 = lVarD.d();
                if (lVarD3.f15334k || (jsonNode2 = (jsonNode = lVarD3.f15331g).get("id")) == null || jsonNode2.equals(jsonNode.get("$schema")) || jsonNode2.textValue() == null) {
                    lVarF = null;
                } else {
                    n nVarC = n.c(jsonNode2.textValue());
                    o oVar = (o) this.f15333j.f1601d;
                    l lVarE = oVar.e(nVarC);
                    oVar.f15349g.getClass();
                    try {
                        lVarE.h();
                    } catch (Exception unused) {
                    }
                    lVarF = lVarE;
                }
                if (lVarF != null) {
                    lVarF = lVarF.f(aVar);
                }
                if (lVarF != null) {
                    return lVarF;
                }
                b bVar = new b();
                bVar.f15290a = b0.Y.f1938c;
                bVar.i = "internal.unresolvedRef";
                bVar.f15296g = "Reference {0} cannot be resolved";
                bVar.f15293d = nVar.f15340b;
                bVar.f15292c = nVar;
                bVar.f15291b = null;
                bVar.f15294e = new Object[]{aVar};
                throw new i(bVar.a());
            }
            n nVarA = (z10 && jsonNode3.isArray()) ? nVar.a(((Number) objD).intValue()) : nVar.b(objD.toString());
            JsonNode jsonNode5 = jsonNode4.get(((y7.a) qVar.f1600c).f15930b);
            if ((jsonNode5 == null ? null : jsonNode5.textValue()) != null || i == nameCount - 1) {
                lVarD2 = qVar.d(nVarA, jsonNode4, lVar);
                nVarA = lVarD2.i;
                lVar = lVarD2;
            }
            nVar = nVarA;
            i++;
            jsonNode3 = jsonNode4;
        }
    }

    public final List g() {
        ArrayList arrayList;
        if (this.f15326b == null) {
            JsonNode jsonNode = this.f15331g;
            boolean zIsBoolean = jsonNode.isBoolean();
            n nVar = this.i;
            androidx.room.q qVar = this.f15333j;
            if (zIsBoolean) {
                arrayList = new ArrayList(1);
                if (jsonNode.booleanValue()) {
                    arrayList.add(qVar.e(nVar.b("true"), "true", jsonNode, this));
                } else {
                    arrayList.add(qVar.e(nVar.b("false"), "false", jsonNode, this));
                }
            } else {
                Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                ArrayList arrayList2 = new ArrayList(jsonNode.size());
                b8.a aVar = null;
                while (itFields.hasNext()) {
                    Map.Entry<String, JsonNode> next = itFields.next();
                    String key = next.getKey();
                    JsonNode value = next.getValue();
                    n nVarB = nVar.b(key);
                    if ("$recursiveAnchor".equals(key)) {
                        if (!value.isBoolean()) {
                            b bVar = new b();
                            bVar.f15290a = "$recursiveAnchor";
                            bVar.i = "internal.invalidRecursiveAnchor";
                            bVar.f15296g = "The value of a $recursiveAnchor must be a Boolean literal but is {0}";
                            bVar.f15293d = null;
                            bVar.f15291b = null;
                            bVar.f15292c = nVarB;
                            bVar.f15294e = new Object[]{value.getNodeType().toString()};
                            throw new m(bVar.a());
                        }
                        this.f15330f = value.booleanValue();
                    }
                    b8.a aVarE = qVar.e(nVarB, key, value, this);
                    if (aVarE != null) {
                        arrayList2.add(aVarE);
                        if ("unevaluatedProperties".equals(key)) {
                            this.f15327c = true;
                        } else if ("unevaluatedItems".equals(key)) {
                            this.f15328d = true;
                        }
                        if ("$ref".equals(key)) {
                            aVar = aVarE;
                        }
                    }
                }
                if (aVar != null && ((y7.a) qVar.f1600c).f15933e.f15356c < f15323l) {
                    arrayList2.clear();
                    arrayList2.add(aVar);
                }
                arrayList = arrayList2;
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, f15324m);
            }
            this.f15326b = Collections.unmodifiableList(arrayList);
        }
        return this.f15326b;
    }

    public final void h() {
        if (this.f15329e) {
            return;
        }
        this.f15329e = true;
        try {
            Iterator it = g().iterator();
            while (it.hasNext()) {
                ((b8.a) it.next()).i();
            }
        } catch (RuntimeException e10) {
            this.f15329e = false;
            throw e10;
        }
    }

    public final List i(JsonNode jsonNode) {
        u9.d dVar = ((o) this.f15333j.f1601d).f15349g;
        Locale locale = Locale.ROOT;
        dVar.getClass();
        Locale locale2 = Locale.getDefault();
        if (locale2 == null) {
            locale2 = Locale.getDefault();
        }
        l3.d dVar2 = new l3.d();
        dVar2.f7721f = locale2;
        dVar2.f7720c = false;
        VarHandle.storeStoreFence();
        f fVar = new f();
        fVar.f15307b = null;
        fVar.f15308c = null;
        fVar.f15309d = new ArrayList();
        fVar.f15310e = new HashMap();
        fVar.f15312g = new ArrayDeque(64);
        fVar.f15313h = new ArrayDeque(64);
        fVar.i = null;
        fVar.f15314j = false;
        fVar.f15315k = false;
        fVar.f15306a = dVar2;
        VarHandle.storeStoreFence();
        if (locale2 == null) {
            locale2 = Locale.getDefault();
        }
        l3.d dVar3 = new l3.d();
        dVar3.f7721f = locale2;
        dVar3.f7720c = false;
        VarHandle.storeStoreFence();
        fVar.f15306a = dVar3;
        try {
            fVar.f15311f = c();
            b(fVar, jsonNode, jsonNode, c());
        } catch (g e10) {
            fVar.f15309d = Collections.singletonList(e10.f15316c);
        }
        return fVar.f15309d;
    }

    public final String toString() {
        return this.f15331g.toString();
    }
}
