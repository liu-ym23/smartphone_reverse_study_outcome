package ad;

import android.text.Layout;
import d2.l0;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements d2.s {

    /* renamed from: a, reason: collision with root package name */
    public Object f631a;

    /* renamed from: b, reason: collision with root package name */
    public Object f632b;

    /* renamed from: c, reason: collision with root package name */
    public Object f633c;

    /* renamed from: d, reason: collision with root package name */
    public Object f634d;

    /* renamed from: e, reason: collision with root package name */
    public Object f635e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.util.List] */
    public y(d2.g gVar, l0 l0Var, List list, o2.c cVar, g2.d dVar) {
        int i;
        int i3;
        String str;
        List list2;
        d2.g gVar2 = gVar;
        l0 l0Var2 = l0Var;
        this.f631a = gVar2;
        this.f632b = list;
        jb.e eVar = jb.e.f6757f;
        d2.p pVar = new d2.p(0);
        pVar.f3158f = this;
        VarHandle.storeStoreFence();
        this.f633c = h5.t.G(eVar, pVar);
        int i10 = 1;
        d2.p pVar2 = new d2.p(i10);
        pVar2.f3158f = this;
        VarHandle.storeStoreFence();
        this.f634d = h5.t.G(eVar, pVar2);
        d2.t tVar = l0Var2.f3141b;
        int i11 = d2.h.f3105a;
        ArrayList arrayList = gVar2.f3103h;
        String str2 = gVar2.f3101f;
        kb.s sVar = kb.s.f7404c;
        List listI0 = arrayList != null ? kb.l.I0(arrayList, new d2.f(i10)) : sVar;
        ArrayList arrayList2 = new ArrayList();
        kb.j jVar = new kb.j();
        int size = listI0.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            d2.e eVar2 = (d2.e) listI0.get(i12);
            d2.t tVarA = tVar.a((d2.t) eVar2.f3077a);
            int i14 = i10;
            int i15 = eVar2.f3078b;
            int i16 = eVar2.f3079c;
            if (i15 > i16) {
                i2.a.a("Reversed range is not supported");
            }
            while (i13 < i15 && !jVar.isEmpty()) {
                d2.e eVar3 = (d2.e) jVar.last();
                List list3 = listI0;
                int i17 = eVar3.f3079c;
                kb.s sVar2 = sVar;
                Object obj = eVar3.f3077a;
                if (i15 < i17) {
                    arrayList2.add(new d2.e(i13, i15, obj));
                    i13 = i15;
                    listI0 = list3;
                    sVar = sVar2;
                } else {
                    int i18 = size;
                    arrayList2.add(new d2.e(i13, i17, obj));
                    i13 = eVar3.f3079c;
                    while (!jVar.isEmpty() && i13 == ((d2.e) jVar.last()).f3079c) {
                        jVar.removeLast();
                    }
                    listI0 = list3;
                    sVar = sVar2;
                    size = i18;
                }
            }
            List list4 = listI0;
            kb.s sVar3 = sVar;
            int i19 = size;
            if (i13 < i15) {
                arrayList2.add(new d2.e(i13, i15, tVar));
                i13 = i15;
            }
            d2.e eVar4 = (d2.e) (jVar.isEmpty() ? null : jVar.f7401f[jVar.h((jVar.a() - 1) + jVar.f7400c)]);
            if (eVar4 != null) {
                int i20 = eVar4.f3079c;
                Object obj2 = eVar4.f3077a;
                int i21 = eVar4.f3078b;
                if (i21 == i15 && i20 == i16) {
                    jVar.removeLast();
                    jVar.addLast(new d2.e(i15, i16, ((d2.t) obj2).a(tVarA)));
                } else if (i21 == i20) {
                    arrayList2.add(new d2.e(i21, i20, obj2));
                    jVar.removeLast();
                    jVar.addLast(new d2.e(i15, i16, tVarA));
                } else {
                    if (i20 < i16) {
                        od.f.b();
                        throw null;
                    }
                    jVar.addLast(new d2.e(i15, i16, ((d2.t) obj2).a(tVarA)));
                }
            } else {
                jVar.addLast(new d2.e(i15, i16, tVarA));
            }
            i12++;
            i10 = i14;
            listI0 = list4;
            sVar = sVar3;
            size = i19;
        }
        kb.s sVar4 = sVar;
        while (i13 <= str2.length() && !jVar.isEmpty()) {
            d2.e eVar5 = (d2.e) jVar.last();
            Object obj3 = eVar5.f3077a;
            int i22 = eVar5.f3079c;
            arrayList2.add(new d2.e(i13, i22, obj3));
            while (!jVar.isEmpty() && i22 == ((d2.e) jVar.last()).f3079c) {
                jVar.removeLast();
            }
            i13 = i22;
        }
        if (i13 < str2.length()) {
            arrayList2.add(new d2.e(i13, str2.length(), tVar));
        }
        if (arrayList2.isEmpty()) {
            i = 0;
            arrayList2.add(new d2.e(0, 0, tVar));
        } else {
            i = 0;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        int i23 = i;
        while (i23 < size2) {
            d2.e eVar6 = (d2.e) arrayList2.get(i23);
            int i24 = eVar6.f3078b;
            int i25 = eVar6.f3079c;
            String strSubstring = i24 != i25 ? str2.substring(i24, i25) : "";
            List listA = d2.h.a(gVar2, i24, i25, new a9.d(14));
            d2.g gVar3 = new d2.g(strSubstring, listA == null ? sVar4 : listA);
            d2.t tVar2 = (d2.t) eVar6.f3077a;
            if (tVar2.f3170b == Integer.MIN_VALUE) {
                i3 = size2;
                str = str2;
                tVar2 = new d2.t(tVar2.f3169a, tVar.f3170b, tVar2.f3171c, tVar2.f3172d, tVar2.f3173e, tVar2.f3174f, tVar2.f3175g, tVar2.f3176h, tVar2.i);
            } else {
                i3 = size2;
                str = str2;
            }
            l0 l0Var3 = new l0(l0Var2.f3140a, tVar.a(tVar2));
            ?? r52 = gVar3.f3100c;
            kb.s sVar5 = r52 == 0 ? sVar4 : r52;
            List list5 = (List) this.f632b;
            ArrayList arrayList4 = new ArrayList(list5.size());
            int size3 = list5.size();
            int i26 = 0;
            while (i26 < size3) {
                d2.e eVar7 = (d2.e) list5.get(i26);
                int i27 = eVar7.f3078b;
                d2.t tVar3 = tVar;
                int i28 = eVar7.f3079c;
                if (d2.h.b(i24, i25, i27, i28)) {
                    if (i24 > i27 || i28 > i25) {
                        i2.a.a("placeholder can not overlap with paragraph.");
                    }
                    list2 = list5;
                    arrayList4.add(new d2.e(i27 - i24, i28 - i24, eVar7.f3077a));
                } else {
                    list2 = list5;
                }
                i26++;
                list5 = list2;
                tVar = tVar3;
            }
            k2.d dVar2 = new k2.d(strSubstring, l0Var3, sVar5, arrayList4, dVar, cVar);
            d2.r rVar = new d2.r();
            rVar.f3166a = dVar2;
            rVar.f3167b = i24;
            rVar.f3168c = i25;
            VarHandle.storeStoreFence();
            arrayList3.add(rVar);
            i23++;
            gVar2 = gVar;
            l0Var2 = l0Var;
            size2 = i3;
            str2 = str;
        }
        this.f635e = arrayList3;
    }

    @Override // d2.s
    public boolean a() {
        ArrayList arrayList = (ArrayList) this.f635e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((d2.r) arrayList.get(i)).f3166a.a()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, jb.d] */
    @Override // d2.s
    public float b() {
        return ((Number) this.f634d.getValue()).floatValue();
    }

    public void c(b6.a aVar, Class cls) {
        ((ArrayList) this.f632b).add(new jb.g(aVar, cls));
    }

    public void d(y5.f fVar, Class cls) {
        ((ArrayList) this.f634d).add(new jb.g(fVar, cls));
    }

    public z e() {
        Object objUnmodifiableMap;
        q qVar = (q) this.f631a;
        if (qVar == null) {
            od.f.e("url == null");
            return null;
        }
        String str = (String) this.f632b;
        n nVarD = ((ne.b) this.f633c).d();
        c0 c0Var = (c0) this.f634d;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f635e;
        byte[] bArr = bd.b.f2074a;
        linkedHashMap.getClass();
        if (linkedHashMap.isEmpty()) {
            objUnmodifiableMap = kb.t.f7405c;
        } else {
            objUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            objUnmodifiableMap.getClass();
        }
        str.getClass();
        z zVar = new z(0);
        zVar.f637b = qVar;
        zVar.f638c = str;
        zVar.f639d = nVarD;
        zVar.f640e = c0Var;
        zVar.f641f = objUnmodifiableMap;
        VarHandle.storeStoreFence();
        return zVar;
    }

    public t5.b f() {
        return new t5.b(ac.a.g0((ArrayList) this.f631a), ac.a.g0((ArrayList) this.f632b), ac.a.g0((ArrayList) this.f633c), ac.a.g0((ArrayList) this.f634d), ac.a.g0((ArrayList) this.f635e));
    }

    public void g(c cVar) {
        cVar.getClass();
        String string = cVar.toString();
        if (string.length() == 0) {
            ((ne.b) this.f633c).h(HttpHeaders.CACHE_CONTROL);
        } else {
            j(HttpHeaders.CACHE_CONTROL, string);
        }
    }

    public float h(int i, boolean z10) {
        Layout layout = (Layout) this.f631a;
        int lineEnd = layout.getLineEnd(layout.getLineForOffset(i));
        if (i > lineEnd) {
            i = lineEnd;
        }
        return z10 ? layout.getPrimaryHorizontal(i) : layout.getSecondaryHorizontal(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float i(int r29, boolean r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.y.i(int, boolean, boolean):float");
    }

    public void j(String str, String str2) {
        str2.getClass();
        ne.b bVar = (ne.b) this.f633c;
        bVar.getClass();
        id.c.h(str);
        id.c.i(str2, str);
        bVar.h(str);
        bVar.b(str, str2);
    }

    public int k(int i, int i3) {
        while (i > i3) {
            char cCharAt = ((Layout) this.f631a).getText().charAt(i - 1);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != 5760 && ((yb.k.b(cCharAt, 8192) < 0 || yb.k.b(cCharAt, 8202) > 0 || cCharAt == 8199) && cCharAt != 8287 && cCharAt != 12288)) {
                return i;
            }
            i--;
        }
        return i;
    }

    public void l(String str, c0 c0Var) {
        str.getClass();
        if (str.length() <= 0) {
            g5.f.s("method.isEmpty() == true");
            return;
        }
        if (c0Var == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                od.f.c(k0.a.C("method ", str, " must have a request body."));
                return;
            }
        } else if (!h5.t.J(str)) {
            od.f.c(k0.a.C("method ", str, " must not have a request body."));
            return;
        }
        this.f632b = str;
        this.f634d = c0Var;
    }

    public void m(Object obj, String str) {
        pc.t tVar = oc.c.f9367b;
        str.getClass();
        ((LinkedHashMap) this.f635e).put(str, obj);
        t0 t0Var = (t0) ((LinkedHashMap) this.f632b).get(str);
        if (t0Var != null) {
            t0Var.g(null, obj == null ? tVar : obj);
        }
        t0 t0Var2 = (t0) ((LinkedHashMap) this.f633c).get(str);
        if (t0Var2 != null) {
            if (obj == null) {
                obj = tVar;
            }
            t0Var2.g(null, obj);
        }
    }

    public void n(Class cls, Object obj) {
        cls.getClass();
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f635e;
        if (obj == null) {
            linkedHashMap.remove(cls);
            return;
        }
        if (linkedHashMap.isEmpty()) {
            this.f635e = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) this.f635e;
        Object objCast = cls.cast(obj);
        objCast.getClass();
        linkedHashMap2.put(cls, objCast);
    }

    public void o(String str) {
        str.getClass();
        if (hc.o.U(str, "ws:", true)) {
            str = "http:".concat(str.substring(3));
        } else if (hc.o.U(str, "wss:", true)) {
            str = "https:".concat(str.substring(4));
        }
        p pVar = new p();
        pVar.c(null, str);
        this.f631a = pVar.a();
    }

    public y(Map map) {
        map.getClass();
        this.f635e = new LinkedHashMap(map);
        this.f631a = new LinkedHashMap();
        this.f632b = new LinkedHashMap();
        this.f633c = new LinkedHashMap();
        androidx.activity.f fVar = new androidx.activity.f(1);
        fVar.f672b = this;
        VarHandle.storeStoreFence();
        this.f634d = fVar;
    }

    public y() {
        this.f635e = new LinkedHashMap();
        this.f632b = "GET";
        this.f633c = new ne.b();
    }
}
