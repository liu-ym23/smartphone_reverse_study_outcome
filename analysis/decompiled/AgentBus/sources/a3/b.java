package a3;

import a7.g;
import android.content.Context;
import android.text.Layout;
import c6.d;
import d5.e;
import d5.l;
import d5.m;
import d5.q;
import d5.t;
import d7.a0;
import d7.e0;
import d7.r;
import d7.z;
import e9.f;
import fi.iki.elonen.NanoHTTPD;
import g8.c;
import i5.u;
import ia.b0;
import ia.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import k5.h;
import k5.s;
import la.f0;
import la.k0;
import la.u0;
import m5.j;
import nb.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q7.w;
import s1.h0;
import s1.n;
import s1.o;
import s1.p;
import x8.k;

/* loaded from: classes.dex */
public final class b implements o, k, y4.a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f162f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f163g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f164h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f165i;

    /* renamed from: j, reason: collision with root package name */
    public Object f166j;

    public b() {
        this.f162f = new int[10];
        this.f163g = new int[10];
        this.f164h = new int[10];
        this.f165i = new int[10];
        this.f166j = new int[10];
    }

    @Override // y4.a
    public void a() {
        ArrayList arrayList = (ArrayList) this.f166j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            s4.b bVar = (s4.b) it.next();
            d0.s((b0) this.f163g, null, null, new s4.a(bVar, null, 1), 3);
            ((l) this.f164h).h(bVar.f9486a);
        }
        arrayList.clear();
    }

    @Override // x8.k
    public void b() {
        ((g) this.f163g).b();
        g gVar = (g) this.f164h;
        ((HashMap) gVar.f419h).put((f) this.f165i, new j9.a((c) r.f1((ArrayList) this.f166j)));
    }

    @Override // s1.o
    public boolean c() {
        ArrayList arrayList = (ArrayList) this.f166j;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((n) arrayList.get(i2)).f9290a.c()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // s1.o
    public float d() {
        return ((Number) this.f165i.getValue()).floatValue();
    }

    @Override // x8.k
    public void e(f fVar, Object obj) {
        ((g) this.f162f).e(fVar, obj);
    }

    public String f() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (e eVar : (Iterable) ((l) this.f162f).f2891e.f5918f.getValue()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", eVar.getId());
            jSONObject.put("role", eVar.f().name());
            String strG = eVar.g();
            if (strG != null) {
                jSONObject.put("vendor", strG);
            }
            t tVarC = eVar.c();
            if (tVarC != null) {
                jSONObject.put("deployment", tVarC.name());
            }
            jSONObject.put("state", w.f8821a.b(eVar.h().getValue().getClass()).t());
            jSONArray.put(jSONObject);
        }
        String string = jSONArray.toString(2);
        q7.k.d(string, "toString(...)");
        return string;
    }

    @Override // x8.k
    public void g(f fVar, e9.b bVar, f fVar2) {
        ((g) this.f162f).g(fVar, bVar, fVar2);
    }

    public String h(String str) {
        q7.k.e(str, "cap");
        for (Map.Entry entry : ((ConcurrentHashMap) this.f163g).entrySet()) {
            String str2 = (String) entry.getKey();
            if (((Set) entry.getValue()).contains(str)) {
                return str2;
            }
        }
        return null;
    }

    public float i(int i2, boolean z4) {
        Layout layout = (Layout) this.f162f;
        int lineEnd = layout.getLineEnd(layout.getLineForOffset(i2));
        if (i2 > lineEnd) {
            i2 = lineEnd;
        }
        return z4 ? layout.getPrimaryHorizontal(i2) : layout.getSecondaryHorizontal(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float j(int r29, boolean r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.b.j(int, boolean, boolean):float");
    }

    @Override // x8.k
    public void k(f fVar, j9.f fVar2) {
        ((g) this.f162f).k(fVar, fVar2);
    }

    @Override // x8.k
    public x8.l l(f fVar) {
        return ((g) this.f162f).l(fVar);
    }

    public String m() throws JSONException {
        boolean z4;
        boolean z10;
        List<e> list = (List) ((l) this.f162f).f2891e.f5918f.getValue();
        boolean z11 = true;
        if (list == null || !list.isEmpty()) {
            for (e eVar : list) {
                if (eVar.f() == m.GATEWAY && (eVar.h().getValue() instanceof q)) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        } else {
            z4 = false;
        }
        if (list == null || !list.isEmpty()) {
            for (e eVar2 : list) {
                if (eVar2.f() == m.NODE && (eVar2.h().getValue() instanceof q)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (list == null || !list.isEmpty()) {
            for (e eVar3 : list) {
                if (eVar3.f() == m.CHANNEL && (eVar3.h().getValue() instanceof q)) {
                    break;
                }
            }
            z11 = false;
        } else {
            z11 = false;
        }
        String str = (z4 && (z10 || z11)) ? "healthy" : (z4 || z10 || z11) ? "degraded" : "unhealthy";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", str);
        jSONObject.put("uptime_ms", System.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        for (e eVar4 : list) {
            jSONObject2.put(eVar4.getId(), w.f8821a.b(eVar4.h().getValue().getClass()).t());
        }
        jSONObject.put("connections", jSONObject2);
        jSONObject.put("inflight_invocations", ((h5.g) this.f163g).f4206f.size());
        jSONObject.put("memory_rss_kb", Runtime.getRuntime().totalMemory() / NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        String string = jSONObject.toString(2);
        q7.k.d(string, "toString(...)");
        return string;
    }

    public int n(int i2, int i10) {
        while (i2 > i10) {
            char cCharAt = ((Layout) this.f162f).getText().charAt(i2 - 1);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != 5760 && ((q7.k.f(cCharAt, NanoHTTPD.HTTPSession.BUFSIZE) < 0 || q7.k.f(cCharAt, 8202) > 0 || cCharAt == 8199) && cCharAt != 8287 && cCharAt != 12288)) {
                return i2;
            }
            i2--;
        }
        return i2;
    }

    public String o() throws JSONException {
        m5.q qVarP = ((i5.l) this.f165i).P();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("counters", new JSONObject(qVarP.f6443b));
        jSONObject.put("gauges", new JSONObject(qVarP.f6444c));
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry : qVarP.f6445d.entrySet()) {
            String str = (String) entry.getKey();
            m5.l lVar = (m5.l) entry.getValue();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("count", lVar.f6428a);
            jSONObject3.put("sum", lVar.f6429b);
            jSONObject3.put("min", lVar.f6430c);
            jSONObject3.put("max", lVar.f6431d);
            jSONObject3.put("p50", lVar.f6432e);
            jSONObject3.put("p90", lVar.f6433f);
            jSONObject3.put("p99", lVar.f6434g);
            jSONObject2.put(str, jSONObject3);
        }
        jSONObject.put("histograms", jSONObject2);
        String string = jSONObject.toString(2);
        q7.k.d(string, "toString(...)");
        return string;
    }

    @Override // x8.k
    public k p(e9.b bVar, f fVar) {
        return ((g) this.f162f).p(bVar, fVar);
    }

    public void q() {
        u0 u0Var = (u0) this.f165i;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f163g;
        LinkedHashMap linkedHashMap = new LinkedHashMap(e0.S(concurrentHashMap.size()));
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), r.q1((Iterable) entry.getValue()));
        }
        u0Var.getClass();
        u0Var.g(null, linkedHashMap);
    }

    public List r(String str, List list) {
        q7.k.e(str, "nodeId");
        boolean zIsEmpty = list.isEmpty();
        z zVar = z.f2978f;
        if (zIsEmpty) {
            return zVar;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String strH = h(str2);
            if (strH == null || strH.equals(str)) {
                arrayList2.add(str2);
            } else {
                arrayList.add(str2);
            }
        }
        if (!arrayList2.isEmpty()) {
            Object objComputeIfAbsent = ((ConcurrentHashMap) this.f163g).computeIfAbsent(str, new g5.a(new d(16), 0));
            q7.k.d(objComputeIfAbsent, "computeIfAbsent(...)");
            Set set = (Set) objComputeIfAbsent;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (set.add((String) next)) {
                    arrayList3.add(next);
                }
            }
            if (!arrayList3.isEmpty()) {
                ((AtomicLong) this.f164h).incrementAndGet();
                q();
                ((a7.d) this.f162f).C(new h(str, arrayList3, zVar));
            }
        }
        return arrayList;
    }

    public String s(String str) {
        String str2 = null;
        int length = -1;
        for (Map.Entry entry : ((ConcurrentHashMap) this.f163g).entrySet()) {
            String str3 = (String) entry.getKey();
            for (String str4 : (Set) entry.getValue()) {
                if (q7.k.a(str4, str)) {
                    return str3;
                }
                if (ga.r.Z(str4, ".*", false)) {
                    String strM0 = ga.k.m0(str4);
                    if (ga.r.g0(str, strM0.concat("."), false) && strM0.length() > length) {
                        length = strM0.length();
                        str2 = str3;
                    }
                }
            }
        }
        return str2;
    }

    @Override // y4.a
    public void start() {
        s4.b bVar = new s4.b((Context) this.f162f, (k5.t) this.f165i);
        d0.s(bVar.f9491f, null, null, new s4.a(bVar, null, 0), 3);
        bVar.f9496k.a();
        ((l) this.f164h).f(bVar);
        ((ArrayList) this.f166j).add(bVar);
        s.info$default((k5.t) this.f165i, "ZeroClawGatewayVendor", "zeroclaw virtual connection registered to pool", null, 4, null);
    }

    public void t(Object obj, String str) {
        q7.k.e(str, "key");
        ((LinkedHashMap) this.f162f).put(str, obj);
        la.d0 d0Var = (la.d0) ((LinkedHashMap) this.f164h).get(str);
        if (d0Var != null) {
            ((u0) d0Var).f(obj);
        }
        la.d0 d0Var2 = (la.d0) ((LinkedHashMap) this.f165i).get(str);
        if (d0Var2 != null) {
            ((u0) d0Var2).f(obj);
        }
    }

    public LinkedHashMap u() {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f163g;
        LinkedHashMap linkedHashMap = new LinkedHashMap(e0.S(concurrentHashMap.size()));
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), r.q1((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    public void v(String str) {
        q7.k.e(str, "nodeId");
        Set set = (Set) ((ConcurrentHashMap) this.f163g).remove(str);
        if (set == null || set.isEmpty()) {
            return;
        }
        ((AtomicLong) this.f164h).incrementAndGet();
        q();
        ((a7.d) this.f162f).C(new h(str, z.f2978f, r.m1(set)));
    }

    public b(Context context, na.d dVar, l lVar, k5.g gVar) {
        q7.k.e(context, "context");
        q7.k.e(dVar, "scope");
        q7.k.e(lVar, "pool");
        q7.k.e(gVar, "logger");
        this.f162f = context;
        this.f163g = dVar;
        this.f164h = lVar;
        this.f165i = gVar;
        this.f166j = new ArrayList();
    }

    public b(l lVar, h5.g gVar, u uVar, i5.l lVar2, j jVar, k5.t tVar) {
        q7.k.e(lVar, "pool");
        q7.k.e(gVar, "invocationMapper");
        q7.k.e(tVar, "logger");
        this.f162f = lVar;
        this.f163g = gVar;
        this.f164h = uVar;
        this.f165i = lVar2;
        this.f166j = jVar;
    }

    public b(a7.d dVar) {
        this.f162f = dVar;
        this.f163g = new ConcurrentHashMap();
        this.f164h = new AtomicLong(0L);
        u0 u0VarC = k0.c(a0.f2944f);
        this.f165i = u0VarC;
        this.f166j = new f0(u0VarC);
    }

    public b(Map map) {
        q7.k.e(map, "initialState");
        this.f162f = e0.b0(map);
        this.f163g = new LinkedHashMap();
        this.f164h = new LinkedHashMap();
        this.f165i = new LinkedHashMap();
        this.f166j = new a(0, this);
    }

    public b(String str, long j2, long j4, c6.m mVar, k5.a aVar, k5.t tVar) {
        q7.k.e(str, "url");
        q7.k.e(mVar, "kind");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f162f = str;
        this.f163g = mVar;
        this.f164h = aVar;
        this.f165i = tVar;
        ab.s sVar = new ab.s();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sVar.a(j2, timeUnit);
        sVar.b(j4, timeUnit);
        sVar.d(j4, timeUnit);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        q7.k.e(timeUnit2, "unit");
        sVar.f625y = bb.b.b("interval", 30L, timeUnit2);
        this.f166j = new ab.t(sVar);
    }

    public b(Layout layout) {
        this.f162f = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iQ0 = ga.k.q0(((Layout) this.f162f).getText(), '\n', length, 4);
            length = iQ0 < 0 ? ((Layout) this.f162f).getText().length() : iQ0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < ((Layout) this.f162f).getText().length());
        this.f163g = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(null);
        }
        this.f164h = arrayList2;
        this.f165i = new boolean[((ArrayList) this.f163g).size()];
        ((ArrayList) this.f163g).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.ArrayList] */
    public b(s1.e eVar, h0 h0Var, List list, d2.c cVar, v1.d dVar) {
        int i2;
        String strSubstring;
        List list2;
        ArrayList arrayList;
        ?? arrayList2;
        int i10;
        String str;
        int i11;
        int i12;
        z zVar;
        List list3;
        s1.e eVar2 = eVar;
        this.f162f = eVar2;
        this.f163g = list;
        c7.h hVar = c7.h.f1971g;
        final int i13 = 0;
        this.f164h = s7.a.G(hVar, new p7.a(this) { // from class: s1.l

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ a3.b f9282g;

            {
                this.f9282g = this;
            }

            @Override // p7.a
            public final Object c() {
                Object obj;
                Object obj2;
                switch (i13) {
                    case 0:
                        ArrayList arrayList3 = (ArrayList) this.f9282g.f166j;
                        if (arrayList3.isEmpty()) {
                            obj = null;
                        } else {
                            Object obj3 = arrayList3.get(0);
                            float fA = ((n) obj3).f9290a.a();
                            int iT0 = d7.s.t0(arrayList3);
                            int i14 = 1;
                            if (1 <= iT0) {
                                while (true) {
                                    Object obj4 = arrayList3.get(i14);
                                    float fA2 = ((n) obj4).f9290a.a();
                                    if (Float.compare(fA, fA2) < 0) {
                                        obj3 = obj4;
                                        fA = fA2;
                                    }
                                    if (i14 != iT0) {
                                        i14++;
                                    }
                                }
                            }
                            obj = obj3;
                        }
                        n nVar = (n) obj;
                        return Float.valueOf(nVar != null ? nVar.f9290a.a() : 0.0f);
                    default:
                        ArrayList arrayList4 = (ArrayList) this.f9282g.f166j;
                        if (arrayList4.isEmpty()) {
                            obj2 = null;
                        } else {
                            Object obj5 = arrayList4.get(0);
                            float fC = ((n) obj5).f9290a.f11766n.c();
                            int iT02 = d7.s.t0(arrayList4);
                            int i15 = 1;
                            if (1 <= iT02) {
                                while (true) {
                                    Object obj6 = arrayList4.get(i15);
                                    float fC2 = ((n) obj6).f9290a.f11766n.c();
                                    if (Float.compare(fC, fC2) < 0) {
                                        obj5 = obj6;
                                        fC = fC2;
                                    }
                                    if (i15 != iT02) {
                                        i15++;
                                    }
                                }
                            }
                            obj2 = obj5;
                        }
                        n nVar2 = (n) obj2;
                        return Float.valueOf(nVar2 != null ? nVar2.f9290a.f11766n.c() : 0.0f);
                }
            }
        });
        final int i14 = 1;
        this.f165i = s7.a.G(hVar, new p7.a(this) { // from class: s1.l

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ a3.b f9282g;

            {
                this.f9282g = this;
            }

            @Override // p7.a
            public final Object c() {
                Object obj;
                Object obj2;
                switch (i14) {
                    case 0:
                        ArrayList arrayList3 = (ArrayList) this.f9282g.f166j;
                        if (arrayList3.isEmpty()) {
                            obj = null;
                        } else {
                            Object obj3 = arrayList3.get(0);
                            float fA = ((n) obj3).f9290a.a();
                            int iT0 = d7.s.t0(arrayList3);
                            int i142 = 1;
                            if (1 <= iT0) {
                                while (true) {
                                    Object obj4 = arrayList3.get(i142);
                                    float fA2 = ((n) obj4).f9290a.a();
                                    if (Float.compare(fA, fA2) < 0) {
                                        obj3 = obj4;
                                        fA = fA2;
                                    }
                                    if (i142 != iT0) {
                                        i142++;
                                    }
                                }
                            }
                            obj = obj3;
                        }
                        n nVar = (n) obj;
                        return Float.valueOf(nVar != null ? nVar.f9290a.a() : 0.0f);
                    default:
                        ArrayList arrayList4 = (ArrayList) this.f9282g.f166j;
                        if (arrayList4.isEmpty()) {
                            obj2 = null;
                        } else {
                            Object obj5 = arrayList4.get(0);
                            float fC = ((n) obj5).f9290a.f11766n.c();
                            int iT02 = d7.s.t0(arrayList4);
                            int i15 = 1;
                            if (1 <= iT02) {
                                while (true) {
                                    Object obj6 = arrayList4.get(i15);
                                    float fC2 = ((n) obj6).f9290a.f11766n.c();
                                    if (Float.compare(fC, fC2) < 0) {
                                        obj5 = obj6;
                                        fC = fC2;
                                    }
                                    if (i15 != iT02) {
                                        i15++;
                                    }
                                }
                            }
                            obj2 = obj5;
                        }
                        n nVar2 = (n) obj2;
                        return Float.valueOf(nVar2 != null ? nVar2.f9290a.f11766n.c() : 0.0f);
                }
            }
        });
        p pVar = h0Var.f9273b;
        int i15 = s1.f.f9255a;
        ArrayList arrayList3 = eVar2.f9248i;
        String str2 = eVar2.f9246g;
        z zVar2 = z.f2978f;
        List listJ1 = arrayList3 != null ? r.j1(arrayList3, new s1.d(i14)) : zVar2;
        ArrayList arrayList4 = new ArrayList();
        d7.m mVar = new d7.m();
        int size = listJ1.size();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            s1.c cVar2 = (s1.c) listJ1.get(i16);
            p pVarA = pVar.a((p) cVar2.f9229a);
            int i18 = cVar2.f9230b;
            int i19 = cVar2.f9231c;
            if (i18 > i19) {
                x1.a.a("Reversed range is not supported");
            }
            while (i17 < i18 && !mVar.isEmpty()) {
                s1.c cVar3 = (s1.c) mVar.last();
                List list4 = listJ1;
                int i20 = cVar3.f9231c;
                z zVar3 = zVar2;
                Object obj = cVar3.f9229a;
                if (i18 < i20) {
                    arrayList4.add(new s1.c(i17, i18, obj));
                    i17 = i18;
                    listJ1 = list4;
                    zVar2 = zVar3;
                } else {
                    int i21 = size;
                    arrayList4.add(new s1.c(i17, i20, obj));
                    i17 = cVar3.f9231c;
                    while (!mVar.isEmpty() && i17 == ((s1.c) mVar.last()).f9231c) {
                        mVar.removeLast();
                    }
                    listJ1 = list4;
                    zVar2 = zVar3;
                    size = i21;
                }
            }
            List list5 = listJ1;
            z zVar4 = zVar2;
            int i22 = size;
            if (i17 < i18) {
                arrayList4.add(new s1.c(i17, i18, pVar));
                i17 = i18;
            }
            s1.c cVar4 = (s1.c) (mVar.isEmpty() ? null : mVar.f2970g[mVar.m(d7.s.t0(mVar) + mVar.f2969f)]);
            if (cVar4 != null) {
                int i23 = cVar4.f9231c;
                Object obj2 = cVar4.f9229a;
                int i24 = cVar4.f9230b;
                if (i24 == i18 && i23 == i19) {
                    mVar.removeLast();
                    mVar.addLast(new s1.c(i18, i19, ((p) obj2).a(pVarA)));
                } else if (i24 == i23) {
                    arrayList4.add(new s1.c(i24, i23, obj2));
                    mVar.removeLast();
                    mVar.addLast(new s1.c(i18, i19, pVarA));
                } else if (i23 >= i19) {
                    mVar.addLast(new s1.c(i18, i19, ((p) obj2).a(pVarA)));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                mVar.addLast(new s1.c(i18, i19, pVarA));
            }
            i16++;
            listJ1 = list5;
            zVar2 = zVar4;
            size = i22;
        }
        z zVar5 = zVar2;
        while (i17 <= str2.length() && !mVar.isEmpty()) {
            s1.c cVar5 = (s1.c) mVar.last();
            Object obj3 = cVar5.f9229a;
            int i25 = cVar5.f9231c;
            arrayList4.add(new s1.c(i17, i25, obj3));
            while (!mVar.isEmpty() && i25 == ((s1.c) mVar.last()).f9231c) {
                mVar.removeLast();
            }
            i17 = i25;
        }
        if (i17 < str2.length()) {
            arrayList4.add(new s1.c(i17, str2.length(), pVar));
        }
        if (arrayList4.isEmpty()) {
            i2 = 0;
            arrayList4.add(new s1.c(0, 0, pVar));
        } else {
            i2 = 0;
        }
        ArrayList arrayList5 = new ArrayList(arrayList4.size());
        int size2 = arrayList4.size();
        int i26 = i2;
        while (i26 < size2) {
            s1.c cVar6 = (s1.c) arrayList4.get(i26);
            int i27 = cVar6.f9230b;
            int i28 = cVar6.f9231c;
            if (i27 != i28) {
                strSubstring = str2.substring(i27, i28);
                q7.k.d(strSubstring, "substring(...)");
            } else {
                strSubstring = "";
            }
            if (i27 == i28 || (list2 = eVar2.f9245f) == null) {
                arrayList = arrayList4;
                str = str2;
                i11 = size2;
                i12 = i26;
                zVar = null;
            } else {
                if (i27 == 0 && i28 >= str2.length()) {
                    arrayList2 = new ArrayList(list2.size());
                    int size3 = list2.size();
                    arrayList = arrayList4;
                    int i29 = 0;
                    while (i29 < size3) {
                        int i30 = size3;
                        Object obj4 = list2.get(i29);
                        int i31 = i29;
                        if (!(((s1.b) ((s1.c) obj4).f9229a) instanceof p)) {
                            arrayList2.add(obj4);
                        }
                        i29 = i31 + 1;
                        size3 = i30;
                    }
                } else {
                    arrayList = arrayList4;
                    arrayList2 = new ArrayList(list2.size());
                    int size4 = list2.size();
                    int i32 = 0;
                    while (i32 < size4) {
                        int i33 = size4;
                        s1.c cVar7 = (s1.c) list2.get(i32);
                        int i34 = i32;
                        Object obj5 = cVar7.f9229a;
                        int i35 = cVar7.f9231c;
                        String str3 = str2;
                        int i36 = cVar7.f9230b;
                        int i37 = size2;
                        if ((((s1.b) obj5) instanceof p) || !s1.f.a(i27, i28, i36, i35)) {
                            i10 = i26;
                        } else {
                            i10 = i26;
                            arrayList2.add(new s1.c((s1.b) cVar7.f9229a, i.k(i36, i27, i28) - i27, i.k(i35, i27, i28) - i27, cVar7.f9232d));
                        }
                        i32 = i34 + 1;
                        size4 = i33;
                        str2 = str3;
                        size2 = i37;
                        i26 = i10;
                    }
                }
                str = str2;
                i11 = size2;
                i12 = i26;
                zVar = arrayList2;
            }
            s1.e eVar3 = new s1.e(strSubstring, zVar == null ? zVar5 : zVar);
            p pVar2 = (p) cVar6.f9229a;
            h0 h0Var2 = new h0(h0Var.f9272a, pVar.a(pVar2.f9294b == Integer.MIN_VALUE ? new p(pVar2.f9293a, pVar.f9294b, pVar2.f9295c, pVar2.f9296d, pVar2.f9297e, pVar2.f9298f, pVar2.f9299g, pVar2.f9300h, pVar2.f9301i) : pVar2));
            ?? r12 = eVar3.f9245f;
            z zVar6 = r12 == 0 ? zVar5 : r12;
            List list6 = (List) this.f163g;
            ArrayList arrayList6 = new ArrayList(list6.size());
            int size5 = list6.size();
            int i38 = 0;
            while (i38 < size5) {
                s1.c cVar8 = (s1.c) list6.get(i38);
                int i39 = cVar8.f9230b;
                int i40 = cVar8.f9231c;
                if (s1.f.a(i27, i28, i39, i40)) {
                    if (i27 > i39 || i40 > i28) {
                        x1.a.a("placeholder can not overlap with paragraph.");
                    }
                    list3 = list6;
                    arrayList6.add(new s1.c(i39 - i27, i40 - i27, cVar8.f9229a));
                } else {
                    list3 = list6;
                }
                i38++;
                list6 = list3;
            }
            arrayList5.add(new n(new z1.d(strSubstring, h0Var2, zVar6, arrayList6, dVar, cVar), i27, i28));
            i26 = i12 + 1;
            eVar2 = eVar;
            arrayList4 = arrayList;
            str2 = str;
            size2 = i11;
        }
        this.f166j = arrayList5;
    }

    public b(r8.a aVar, r8.f fVar, c7.f fVar2) {
        q7.k.e(fVar, "typeParameterResolver");
        this.f162f = aVar;
        this.f163g = fVar;
        this.f164h = fVar2;
        this.f165i = fVar2;
        this.f166j = new i5.l(this, fVar);
    }

    public b(g gVar, g gVar2, f fVar, ArrayList arrayList) {
        this.f163g = gVar;
        this.f164h = gVar2;
        this.f165i = fVar;
        this.f166j = arrayList;
        this.f162f = gVar;
    }
}
