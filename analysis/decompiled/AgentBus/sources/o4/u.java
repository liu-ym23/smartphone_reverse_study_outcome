package o4;

import com.stepos.account.oauth.OAuthConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class u implements e2 {
    public static final Set C = d7.n.x0(new String[]{"assistant", "chat"});
    public static final Set D = d7.n.x0(new String[]{"TOOL_CALLS", "TOOL_CALL", "FUNCTION_CALL", "PENDING"});
    public static volatile b0.r E;
    public final ConcurrentHashMap A;
    public final Map B;

    /* renamed from: a, reason: collision with root package name */
    public final long f7614a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.t f7615b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.t f7616c;

    /* renamed from: d, reason: collision with root package name */
    public final q5.t f7617d;

    /* renamed from: e, reason: collision with root package name */
    public final z5.c f7618e;

    /* renamed from: f, reason: collision with root package name */
    public volatile a5.a f7619f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ia.j1 f7620g;

    /* renamed from: h, reason: collision with root package name */
    public final p4.a f7621h;

    /* renamed from: i, reason: collision with root package name */
    public final p4.a f7622i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f7623j;

    /* renamed from: k, reason: collision with root package name */
    public final Map f7624k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f7625l;

    /* renamed from: m, reason: collision with root package name */
    public final Map f7626m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f7627n;

    /* renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f7628o;

    /* renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f7629p;

    /* renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f7630q;

    /* renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap f7631r;

    /* renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f7632s;

    /* renamed from: t, reason: collision with root package name */
    public final Map f7633t;

    /* renamed from: u, reason: collision with root package name */
    public final Map f7634u;

    /* renamed from: v, reason: collision with root package name */
    public final Map f7635v;

    /* renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap f7636w;

    /* renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap f7637x;

    /* renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap f7638y;

    /* renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap f7639z;

    public u(long j2, f5.b bVar, d5.t tVar, k5.t tVar2, q5.t tVar3, z5.c cVar) {
        q7.k.e(tVar2, "logger");
        this.f7614a = j2;
        this.f7615b = tVar;
        this.f7616c = tVar2;
        this.f7617d = tVar3;
        this.f7618e = cVar;
        this.f7621h = new p4.a(bVar, tVar2, 1);
        this.f7622i = new p4.a(bVar, tVar2, 0);
        this.f7623j = a.f();
        this.f7624k = a.f();
        this.f7625l = a.f();
        this.f7626m = a.f();
        this.f7627n = a.f();
        this.f7628o = new ConcurrentHashMap();
        this.f7629p = new ConcurrentHashMap();
        this.f7630q = new ConcurrentHashMap();
        this.f7631r = new ConcurrentHashMap();
        this.f7632s = new ConcurrentHashMap();
        this.f7633t = a.f();
        this.f7634u = a.f();
        this.f7635v = a.f();
        this.f7636w = new ConcurrentHashMap();
        this.f7637x = new ConcurrentHashMap();
        this.f7638y = new ConcurrentHashMap();
        this.f7639z = new ConcurrentHashMap();
        this.A = new ConcurrentHashMap();
        this.B = a.f();
    }

    public static void B(JSONArray jSONArray) throws JSONException {
        Object objInvoke;
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("key");
                if (strOptString.length() == 0) {
                    strOptString = jSONObjectOptJSONObject.optString("id");
                }
                q7.k.b(strOptString);
                if (strOptString.length() != 0) {
                    jSONObjectOptJSONObject.put("id", strOptString);
                    fa.p pVarT0 = fa.l.t0(d7.n.T(new String[]{"displayName", "title", "derivedTitle", "label"}), new a5.a(15, jSONObjectOptJSONObject));
                    Iterator it = pVarT0.f3642a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            objInvoke = null;
                            break;
                        }
                        objInvoke = pVarT0.f3643b.invoke(it.next());
                        String str = (String) objInvoke;
                        q7.k.b(str);
                        if (str.length() > 0) {
                            break;
                        }
                    }
                    String str2 = (String) objInvoke;
                    if (str2 != null) {
                        jSONObjectOptJSONObject.put("title", str2);
                    } else {
                        jSONObjectOptJSONObject.remove("title");
                    }
                    long jOptLong = jSONObjectOptJSONObject.optLong("createdAtMs", jSONObjectOptJSONObject.optLong("createdAt", 0L));
                    if (jOptLong > 0) {
                        jSONObjectOptJSONObject.put("createdAtMs", jOptLong);
                    }
                    long jOptLong2 = jSONObjectOptJSONObject.optLong("updatedAtMs", jSONObjectOptJSONObject.optLong("updatedAt", 0L));
                    if (jOptLong2 > 0) {
                        jSONObjectOptJSONObject.put("updatedAtMs", jOptLong2);
                    }
                    List<String> listU0 = d7.s.u0("kind", "channel", "chatType", "subject", "space", "groupChannel", "lastMessagePreview", "sessionId", "spawnedBy", "modelProvider", "model");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("metadata");
                    if (jSONObjectOptJSONObject2 == null) {
                        jSONObjectOptJSONObject2 = new JSONObject();
                    }
                    for (String str3 : listU0) {
                        Object objOpt = jSONObjectOptJSONObject.opt(str3);
                        if (objOpt != null && objOpt != JSONObject.NULL && (!(objOpt instanceof String) || ((CharSequence) objOpt).length() != 0)) {
                            jSONObjectOptJSONObject2.put(str3, objOpt);
                            jSONObjectOptJSONObject.remove(str3);
                        }
                    }
                    if (jSONObjectOptJSONObject2.length() > 0) {
                        jSONObjectOptJSONObject.put("metadata", jSONObjectOptJSONObject2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List D(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.D(java.lang.String):java.util.List");
    }

    public static Map E(String str) {
        Object objN;
        Object objN2;
        String string = ga.k.N0(str).toString();
        if (string.length() == 0) {
            return null;
        }
        if (ga.r.g0(string, "{", false)) {
            try {
                objN = w(new JSONObject(string));
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            return (Map) (objN instanceof c7.l ? null : objN);
        }
        if (!ga.r.g0(string, "[", false)) {
            return d7.e0.T(new c7.j("text", string));
        }
        try {
            objN2 = d7.e0.T(new c7.j("content", x(new JSONArray(string))));
        } catch (Throwable th2) {
            objN2 = w7.e0.n(th2);
        }
        return (Map) (objN2 instanceof c7.l ? null : objN2);
    }

    public static a H(String str, String str2) {
        if (str2.length() != 0 && !ga.r.g0(str, str2, false)) {
            return (!ga.r.g0(str2, str, false) || str.length() >= str2.length()) ? l.f7433b : k.f7418b;
        }
        return new j(str);
    }

    public static c5.b h(u uVar, String str, String str2, String str3, LinkedHashMap linkedHashMap, Map map, HashMap map2, int i2) {
        Map map3 = (i2 & 16) != 0 ? d7.a0.f2944f : map;
        HashMap map4 = (i2 & 32) != 0 ? null : map2;
        uVar.getClass();
        if (str == null) {
            str = "";
        }
        return k(uVar, str, str2, str3, linkedHashMap, false, map3, null, map4, 64);
    }

    public static /* synthetic */ c5.b j(u uVar, String str, String str2, Map map, int i2) {
        if ((i2 & 16) != 0) {
            map = null;
        }
        return uVar.i(str, str2, null, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    public static c5.b k(u uVar, String str, String str2, String str3, LinkedHashMap linkedHashMap, boolean z4, Map map, String str4, Map map2, int i2) {
        Object arrayList;
        Collection collectionValues;
        Map map3 = (i2 & 32) != 0 ? d7.a0.f2944f : map;
        Object obj = (i2 & 64) != 0 ? null : str4;
        if (linkedHashMap == null || (collectionValues = linkedHashMap.values()) == null) {
            arrayList = d7.z.f2978f;
        } else {
            Collection<s> collection = collectionValues;
            arrayList = new ArrayList(d7.t.A0(collection, 10));
            for (s sVar : collection) {
                LinkedHashMap linkedHashMapV = d7.e0.V(new c7.j("id", sVar.f7543a), new c7.j("name", sVar.f7544b), new c7.j("arguments", sVar.f7545c), new c7.j("status", sVar.f7546d));
                Map map4 = sVar.f7547e;
                if (map4 != null) {
                    linkedHashMapV.put("result", map4);
                }
                String str5 = sVar.f7548f;
                if (str5 != null) {
                    linkedHashMapV.put("errorMessage", str5);
                }
                HashMap map5 = sVar.f7549g;
                if (map5 != null) {
                    linkedHashMapV.put("update", map5);
                }
                arrayList.add(linkedHashMapV);
            }
        }
        Object obj2 = (String) uVar.f7624k.get(str);
        e7.g gVar = new e7.g();
        gVar.put("sessionId", str2);
        gVar.put("text", str3);
        gVar.put("role", "assistant");
        gVar.put("replyTo", obj2);
        gVar.put("toolCalls", arrayList);
        if (obj != null) {
            gVar.put("delta", obj);
        }
        e7.g gVar2 = new e7.g();
        gVar2.put("runId", str);
        gVar2.put("streaming", Boolean.valueOf(z4));
        gVar2.putAll(map3);
        if (map2 != null) {
            gVar2.put("stepclaw", map2);
        }
        gVar.put("metadata", gVar2.c());
        return new c5.b("req", d7.e0.U(new c7.j("type", "req"), new c7.j("method", "node.event"), new c7.j("params", d7.e0.U(new c7.j("event", "session.message"), new c7.j("payload", gVar.c())))));
    }

    public static String q(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("content")) == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject2 != null && q7.k.a(jSONObjectOptJSONObject2.optString("type"), "text")) {
                sb2.append(jSONObjectOptJSONObject2.optString("text"));
            }
        }
        String string = sb2.toString();
        q7.k.b(string);
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [c7.l] */
    public static Map r(JSONObject jSONObject) {
        HashMap mapN;
        Map mapE;
        Map mapE2;
        Map mapE3;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("details");
        if (jSONObjectOptJSONObject != null) {
            return w(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
        if (jSONObjectOptJSONObject2 != null) {
            return w(jSONObjectOptJSONObject2);
        }
        String strOptString = jSONObject.optString("result");
        q7.k.b(strOptString);
        if (strOptString.length() > 0 && (mapE3 = E(strOptString)) != null) {
            return mapE3;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("partialResult");
        if (jSONObjectOptJSONObject3 != null) {
            return w(jSONObjectOptJSONObject3);
        }
        String strOptString2 = jSONObject.optString("output");
        q7.k.b(strOptString2);
        if (strOptString2.length() <= 0) {
            strOptString2 = null;
        }
        if (strOptString2 != null && (mapE2 = E(strOptString2)) != null) {
            return mapE2;
        }
        String strOptString3 = jSONObject.optString("progressText");
        q7.k.b(strOptString3);
        if (strOptString3.length() <= 0) {
            strOptString3 = null;
        }
        if (strOptString3 != null && (mapE = E(strOptString3)) != null) {
            return mapE;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject4 != null && q7.k.a(jSONObjectOptJSONObject4.optString("type"), "text")) {
            String strOptString4 = jSONObjectOptJSONObject4.optString("text");
            q7.k.b(strOptString4);
            if (strOptString4.length() <= 0) {
                strOptString4 = null;
            }
            if (strOptString4 != null) {
                String string = ga.k.N0(strOptString4).toString();
                if (ga.r.g0(string, "{", false)) {
                    try {
                        mapN = w(new JSONObject(string));
                    } catch (Throwable th) {
                        mapN = w7.e0.n(th);
                    }
                    map = mapN instanceof c7.l ? null : mapN;
                }
            }
        }
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(x(jSONArrayOptJSONArray.opt(i2)));
        }
        return d7.e0.T(new c7.j("content", arrayList));
    }

    public static HashMap w(JSONObject jSONObject) {
        HashMap map = new HashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        q7.k.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, x(jSONObject.opt(next)));
        }
        return map;
    }

    public static Object x(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return w((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(x(jSONArray.opt(i2)));
        }
        return arrayList;
    }

    public final c5.b A(String str) {
        Map map = this.B;
        q qVar = (q) map.get(str);
        if (qVar == null || !g(qVar.f7516c, str) || v(str)) {
            return null;
        }
        map.remove(str);
        return u(str, qVar.f7514a, qVar.f7515b, qVar.f7517d);
    }

    public final void C(int i2, String str, String str2) {
        if (i2 < 0 || str.length() == 0 || this.f7633t.containsKey(str)) {
            return;
        }
        ((ConcurrentHashMap) this.f7636w.computeIfAbsent(str, new g5.a(new b(1), 6))).merge(Integer.valueOf(i2), str2, new k4.f(new g7.b(9), 1));
    }

    public final c5.b F(String str, String str2, String str3) {
        Collection<s> collectionValues;
        q7.k.e(str, "runId");
        q7.k.e(str2, "sessionKey");
        Map map = this.f7633t;
        if (map.containsKey(str)) {
            return null;
        }
        this.B.remove(str);
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7632s.remove(str);
        this.f7628o.remove(str);
        this.f7629p.remove(str);
        this.f7631r.remove(str);
        this.f7630q.remove(str);
        n(str);
        ConcurrentHashMap concurrentHashMap = b2.f7283a;
        if (b2.a(str)) {
            this.f7624k.putIfAbsent(str, str);
        }
        m(str);
        if (linkedHashMap != null && (collectionValues = linkedHashMap.values()) != null) {
            for (s sVar : collectionValues) {
                if (sVar.f7546d.equals("PENDING") && sVar.f7547e != null) {
                    sVar.f7546d = "OK";
                }
            }
        }
        map.put(str, Boolean.TRUE);
        return h(this, str, str2, str3, linkedHashMap, d7.e0.T(new c7.j("recoverySource", "chat.history")), null, 32);
    }

    public final void G(String str, String str2, String str3, String str4, String str5, String str6, HashMap map) {
        String strU;
        z5.c cVar = this.f7618e;
        if (cVar == null) {
            return;
        }
        String str7 = null;
        if (map == null || (strU = n7.b.u(map)) == null || strU.length() <= 0) {
            strU = null;
        }
        if (strU != null && z(str, str3, "end")) {
            String strL0 = ga.k.L0(500, str5);
            if (cVar.f11810c) {
                String str8 = strU.length() > 0 ? strU : null;
                if (str8 == null) {
                    return;
                }
                if (str6 != null && !ga.k.t0(str6)) {
                    str7 = str6;
                }
                int i2 = str7 == null ? OAuthConstants.RESPONSE_CODE_OK : 500;
                z5.d.reportEvent$default(cVar.f11808a, str8, "agent_bus_toolcall", d7.e0.W(z5.c.n("downlink", "", str2, str3), str7 != null ? d7.e0.U(new c7.j("status_code", Integer.valueOf(i2)), new c7.j("status_message", str7)) : d7.a0.f2944f), z5.c.m(str3), null, "tool_result: ".concat(strL0), i2, 16, null);
                k5.t tVar = cVar.f11809b;
                String strL02 = ga.k.L0(16, str8);
                if (str7 == null) {
                    str7 = "";
                }
                StringBuilder sbP = a1.a.p("claw tool result traceId=", strL02, " tool=", str4, " toolCallId=");
                sbP.append(str3);
                sbP.append(" status=");
                sbP.append(i2);
                sbP.append(" err=");
                sbP.append(str7);
                k5.s.debug$default(tVar, "DataReportCoordinator", sbP.toString(), null, 4, null);
            }
        }
    }

    public final a I(String str, String str2, String str3) {
        Object obj;
        Object objPrevious;
        int iNextIndex;
        q7.k.e(str, "runId");
        q7.k.e(str3, "historyPayloadJson");
        List listD = D(str3);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listD) {
            if (q7.k.a(((i) obj2).f7387a, "assistant")) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            return l.f7433b;
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            obj = null;
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (q7.k.a(((i) objPrevious).f7389c, str)) {
                break;
            }
        }
        i iVar = (i) objPrevious;
        if (iVar == null) {
            String str4 = (String) this.f7624k.get(str);
            String str5 = str4 != null ? (String) this.f7627n.get(str4) : null;
            if (str5 != null) {
                ListIterator listIterator2 = listD.listIterator(listD.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        iNextIndex = -1;
                        break;
                    }
                    i iVar2 = (i) listIterator2.previous();
                    if (q7.k.a(iVar2.f7387a, "user") && iVar2.f7388b.equals(str5)) {
                        iNextIndex = listIterator2.nextIndex();
                        break;
                    }
                }
                if (iNextIndex >= 0) {
                    List listK0 = d7.r.K0(listD, iNextIndex + 1);
                    ListIterator listIterator3 = listK0.listIterator(listK0.size());
                    while (true) {
                        if (!listIterator3.hasPrevious()) {
                            break;
                        }
                        Object objPrevious2 = listIterator3.previous();
                        if (q7.k.a(((i) objPrevious2).f7387a, "assistant")) {
                            obj = objPrevious2;
                            break;
                        }
                    }
                    i iVar3 = (i) obj;
                    if (iVar3 != null && !iVar3.a()) {
                        return H(iVar3.f7388b, str2);
                    }
                }
            } else if (str2.length() != 0) {
                i iVar4 = (i) d7.r.W0(arrayList);
                if (!iVar4.a()) {
                    return H(iVar4.f7388b, str2);
                }
            }
        } else if (!iVar.a()) {
            return new j(iVar.f7388b);
        }
        return k.f7418b;
    }

    public final boolean J(String str, int i2, JSONObject jSONObject) {
        String strOptString;
        if (this.f7633t.containsKey(str)) {
            return false;
        }
        Integer num = null;
        if (jSONObject != null && (strOptString = jSONObject.optString("livenessState")) != null) {
            if (!strOptString.equals("abandoned")) {
                strOptString = null;
            }
            if (strOptString != null) {
                return false;
            }
        }
        if (v(str)) {
            return true;
        }
        if (i2 < 0) {
            return false;
        }
        q qVar = (q) this.B.get(str);
        if (qVar != null) {
            int i10 = qVar.f7516c;
            Integer numValueOf = Integer.valueOf(i10);
            if (i10 >= 0) {
                num = numValueOf;
            }
        }
        if (num != null) {
            i2 = Math.min(num.intValue(), i2);
        }
        return !g(i2, str);
    }

    public final void K(String str, String str2, JSONObject jSONObject, int i2, String str3) {
        Map map = this.B;
        q qVar = (q) map.get(str);
        if (qVar == null) {
            map.put(str, new q(str2, jSONObject, i2, str3));
            return;
        }
        String str4 = qVar.f7517d;
        int i10 = qVar.f7516c;
        int iMin = i10 < 0 ? i2 : i2 < 0 ? i10 : Math.min(i10, i2);
        boolean z4 = i2 >= 0 && (i10 < 0 || i2 < i10);
        if (jSONObject == null) {
            jSONObject = qVar.f7515b;
        }
        if (!z4 ? str4 != null : str3 == null) {
            str3 = str4;
        }
        map.put(str, new q(str2, jSONObject, iMin, str3));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b2  */
    @Override // o4.e2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c5.b a(org.json.JSONObject r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.a(org.json.JSONObject):c5.b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0248 A[PHI: r10
      0x0248: PHI (r10v24 java.lang.String) = (r10v21 java.lang.String), (r10v25 java.lang.String) binds: [B:142:0x0278, B:124:0x0246] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0481 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017e  */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v26, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v50, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v14, types: [org.json.JSONObject] */
    @Override // o4.e2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(c5.b r48, c5.c r49) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.b(c5.b, c5.c):java.lang.String");
    }

    public final boolean c(int i2, String str, String str2) {
        if (i2 < 0) {
            return true;
        }
        String strX = a1.a.x(str, "#", str2);
        ConcurrentHashMap concurrentHashMap = this.f7637x;
        Integer num = (Integer) concurrentHashMap.get(strX);
        if (i2 <= (num != null ? num.intValue() : -1)) {
            return false;
        }
        concurrentHashMap.put(strX, Integer.valueOf(i2));
        C(i2, str, str2);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x031d, code lost:
    
        if (r5.equals("stepclaw.tool") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x033c, code lost:
    
        if (r5.equals("tool") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0340, code lost:
    
        if (r8 == null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0342, code lost:
    
        r1 = r8.optString("phase");
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0349, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x034a, code lost:
    
        if (r1 != null) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x034c, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x034e, code lost:
    
        if (r8 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0350, code lost:
    
        r2 = r8.optString("toolCallId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0356, code lost:
    
        if (r2 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x035c, code lost:
    
        if (r2.length() <= 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x035f, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0360, code lost:
    
        if (r2 != null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0364, code lost:
    
        r4 = r8.optString("name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x036e, code lost:
    
        if (r4.length() != 0) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0370, code lost:
    
        r4 = "tool";
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0372, code lost:
    
        r5 = r29.f7632s.computeIfAbsent(r7, new g5.a(new o4.b(2), 7));
        q7.k.d(r5, "computeIfAbsent(...)");
        r5 = (java.util.LinkedHashMap) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x038f, code lost:
    
        switch(r1.hashCode()) {
            case -934426595: goto L256;
            case -838846263: goto L244;
            case 96784904: goto L231;
            case 109757538: goto L192;
            default: goto L258;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x039a, code lost:
    
        if (r1.equals("start") != false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x039e, code lost:
    
        r1 = r8.optJSONObject("args");
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03a4, code lost:
    
        if (r1 == null) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03a6, code lost:
    
        r1 = w(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x03ab, code lost:
    
        r1 = d7.a0.f2944f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03ad, code lost:
    
        r5.put(r2, new o4.s(r2, r4, "PENDING", r1));
        r1 = r8.optJSONObject("args");
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03bd, code lost:
    
        if (r1 == null) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03bf, code lost:
    
        r1 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03c4, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03c5, code lost:
    
        if (r1 != null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03c7, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x03c9, code lost:
    
        r5 = r29.f7618e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03cb, code lost:
    
        if (r5 != null) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03cf, code lost:
    
        if (r10 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03d1, code lost:
    
        r6 = n7.b.u(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03d5, code lost:
    
        if (r6 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03db, code lost:
    
        if (r6.length() <= 0) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03de, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03df, code lost:
    
        if (r6 != null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03e8, code lost:
    
        if (z(r7, r2, "start") != false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x03eb, code lost:
    
        r1 = ga.k.L0(500, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x03f3, code lost:
    
        if (r5.f11810c != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x03fa, code lost:
    
        if (r6.length() <= 0) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x03fc, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x03ff, code lost:
    
        r19 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0401, code lost:
    
        if (r19 != null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0404, code lost:
    
        z5.d.reportEvent$default(r5.f11808a, r19, "agent_bus_toolcall", z5.c.n("downlink", "", r3, r2), z5.c.m(r2), null, a1.a.k("tool_start: ", r4, ": ", r1), com.stepos.account.oauth.OAuthConstants.RESPONSE_CODE_OK, 16, null);
        r11 = r5.f11809b;
        r1 = a1.a.p("claw tool start traceId=", ga.k.L0(16, r19), " tool=", r4, " toolCallId=");
        r1.append(r2);
        k5.s.debug$default(r11, "DataReportCoordinator", r1.toString(), null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x044d, code lost:
    
        p("llm_tool_call", r3, r7, d7.e0.U(new c7.j("toolCallId", r2), new c7.j("toolName", r4)));
        r2 = r3;
        r1 = r7;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0473, code lost:
    
        if (r1.equals("error") != false) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0477, code lost:
    
        r1 = r8.optString("error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0481, code lost:
    
        if (r1.length() != 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0483, code lost:
    
        r1 = "tool error";
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0485, code lost:
    
        r6 = r1;
        r1 = (o4.s) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x048c, code lost:
    
        if (r1 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x048e, code lost:
    
        r1.f7546d = "ERROR";
        r1.f7548f = r6;
        r5 = r(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0498, code lost:
    
        if (r5 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x049a, code lost:
    
        r1.f7547e = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x049c, code lost:
    
        r5 = r8.toString();
        q7.k.d(r5, "toString(...)");
        r1 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r7;
        r7 = r10;
        G(r1, r2, r3, r4, r5, r6, r7);
        r6 = r7;
        r7 = r1;
        r29.f7639z.put(r7, java.lang.Boolean.TRUE);
        r29.A.remove(r7);
        p("llm_tool_result", r2, r7, d7.e0.U(new c7.j("toolCallId", r3), new c7.j("toolName", r4), new c7.j("error", r8.optString("error"))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04e3, code lost:
    
        r1 = r7;
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x04e7, code lost:
    
        r6 = r3;
        r3 = r2;
        r2 = r6;
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04f1, code lost:
    
        if (r1.equals("update") != false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x04f4, code lost:
    
        r1 = (o4.s) r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04fa, code lost:
    
        if (r1 == null) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04fc, code lost:
    
        r1.f7546d = "RUNNING";
        r1.f7549g = w(r8);
        r3 = r(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x050a, code lost:
    
        if (r3 == null) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x050c, code lost:
    
        r4 = r1.f7547e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x050e, code lost:
    
        if (r4 != null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0511, code lost:
    
        r3 = d7.e0.W(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0515, code lost:
    
        r1.f7547e = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0518, code lost:
    
        r6 = r3;
        r3 = r2;
        r2 = r6;
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0522, code lost:
    
        if (r1.equals("result") != false) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0524, code lost:
    
        k5.s.debug$default(r29.f7616c, "OpenClawAdapter", a1.a.j("agent stream=tool unknown phase=", r1, ", ignored"), null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0538, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0539, code lost:
    
        r1 = (o4.s) r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x053f, code lost:
    
        if (r1 == null) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0541, code lost:
    
        r1.f7546d = "OK";
        r5 = r(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0549, code lost:
    
        if (r5 == null) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x054b, code lost:
    
        r1.f7547e = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x054d, code lost:
    
        r5 = r8.toString();
        q7.k.d(r5, "toString(...)");
        r1 = r7;
        r7 = r6;
        G(r1, r2, r3, r4, r5, null, r7);
        r29.f7639z.put(r1, java.lang.Boolean.TRUE);
        r29.A.remove(r1);
        p("llm_tool_result", r2, r1, d7.e0.U(new c7.j("toolCallId", r3), new c7.j("toolName", r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0584, code lost:
    
        r29.f7631r.put(r1, r2);
        r3 = A(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x058d, code lost:
    
        if (r3 != null) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0595, code lost:
    
        return j(r29, r1, r2, r7, 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0596, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0818, code lost:
    
        if (r2.equals("tick") == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0936, code lost:
    
        if (r2.equals("seqGap") == false) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0940, code lost:
    
        if (r2.equals("health") == false) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x094a, code lost:
    
        if (r2.equals("presence") != false) goto L7;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0782 A[PHI: r2 r3 r4 r7 r8
      0x0782: PHI (r2v67 java.lang.String) = 
      (r2v16 java.lang.String)
      (r2v17 java.lang.String)
      (r2v18 java.lang.String)
      (r2v19 java.lang.String)
      (r2v20 java.lang.String)
      (r2v73 java.lang.String)
     binds: [B:389:0x0780, B:362:0x0723, B:340:0x069f, B:304:0x060c, B:273:0x05a2, B:111:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0782: PHI (r3v59 org.json.JSONObject) = 
      (r3v25 org.json.JSONObject)
      (r3v28 org.json.JSONObject)
      (r3v30 org.json.JSONObject)
      (r3v31 org.json.JSONObject)
      (r3v38 org.json.JSONObject)
      (r3v61 org.json.JSONObject)
     binds: [B:389:0x0780, B:362:0x0723, B:340:0x069f, B:304:0x060c, B:273:0x05a2, B:111:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0782: PHI (r4v72 int) = (r4v21 int), (r4v25 int), (r4v31 int), (r4v48 int), (r4v54 int), (r4v74 int) binds: [B:389:0x0780, B:362:0x0723, B:340:0x069f, B:304:0x060c, B:273:0x05a2, B:111:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0782: PHI (r7v23 java.lang.String) = 
      (r7v11 java.lang.String)
      (r7v11 java.lang.String)
      (r7v11 java.lang.String)
      (r7v11 java.lang.String)
      (r7v15 java.lang.String)
      (r7v11 java.lang.String)
     binds: [B:389:0x0780, B:362:0x0723, B:340:0x069f, B:304:0x060c, B:273:0x05a2, B:111:0x020a] A[DONT_GENERATE, DONT_INLINE]
      0x0782: PHI (r8v23 java.util.HashMap) = 
      (r8v4 java.util.HashMap)
      (r8v5 java.util.HashMap)
      (r8v6 java.util.HashMap)
      (r8v9 java.util.HashMap)
      (r8v10 java.util.HashMap)
      (r8v25 java.util.HashMap)
     binds: [B:389:0x0780, B:362:0x0723, B:340:0x069f, B:304:0x060c, B:273:0x05a2, B:111:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x078b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x08cf  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x098c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c5.b d(org.json.JSONObject r30) {
        /*
            Method dump skipped, instructions count: 2710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.d(org.json.JSONObject):c5.b");
    }

    public final c5.b e(String str, String str2, String str3, String str4, JSONObject jSONObject, boolean z4, HashMap map) {
        Object objComputeIfAbsent = this.f7632s.computeIfAbsent(str, new g5.a(new b(4), 9));
        q7.k.d(objComputeIfAbsent, "computeIfAbsent(...)");
        LinkedHashMap linkedHashMap = (LinkedHashMap) objComputeIfAbsent;
        s sVar = (s) linkedHashMap.get(str3);
        if (sVar == null) {
            sVar = new s(str3, str4, "PENDING", d7.a0.f2944f);
            linkedHashMap.put(str3, sVar);
        }
        Map mapR = r(jSONObject);
        if (mapR != null) {
            Map map2 = sVar.f7547e;
            if (map2 != null) {
                mapR = d7.e0.W(map2, mapR);
            }
            sVar.f7547e = mapR;
        }
        if (z4) {
            sVar.f7546d = "OK";
        } else if (sVar.f7547e != null && sVar.f7546d.equals("PENDING")) {
            sVar.f7546d = "OK";
        }
        this.f7631r.put(str, str2);
        return j(this, str, str2, map, 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r9, java.lang.String r10, java.lang.String r11, o4.r r12) {
        /*
            r8 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r8.f7628o
            java.lang.Object r1 = r0.get(r9)
            java.lang.String r1 = (java.lang.String) r1
            int[] r2 = o4.t.$EnumSwitchMapping$0
            int r3 = r12.ordinal()
            r2 = r2[r3]
            r3 = 0
            java.util.concurrent.ConcurrentHashMap r4 = r8.f7629p
            r5 = 1
            if (r2 == r5) goto Lb5
            r6 = 2
            if (r2 == r6) goto L7f
            r6 = 3
            if (r2 != r6) goto L79
            if (r1 == 0) goto L70
            int r2 = r1.length()
            if (r2 != 0) goto L25
            goto L70
        L25:
            boolean r2 = ga.r.g0(r11, r1, r3)
            if (r2 == 0) goto L2c
            goto L70
        L2c:
            boolean r2 = ga.r.g0(r1, r11, r3)
            r6 = 0
            if (r2 != 0) goto L6a
            boolean r2 = ga.k.k0(r1, r11, r3)
            if (r2 == 0) goto L3a
            goto L6a
        L3a:
            java.lang.CharSequence r2 = ga.k.N0(r11)
            java.lang.String r2 = r2.toString()
            int r7 = r2.length()
            if (r7 != 0) goto L49
            goto L6c
        L49:
            java.lang.String r7 = "⚠️"
            boolean r3 = ga.r.g0(r2, r7, r3)
            if (r3 == 0) goto L52
            goto L6a
        L52:
            java.lang.String r3 = "Agent failed"
            boolean r7 = r2.equalsIgnoreCase(r3)
            if (r7 == 0) goto L5b
            goto L6a
        L5b:
            boolean r3 = ga.r.g0(r2, r3, r5)
            if (r3 == 0) goto L62
            goto L6a
        L62:
            java.lang.String r3 = "Quota exceeded"
            boolean r2 = ga.r.g0(r2, r3, r5)
            if (r2 == 0) goto L6c
        L6a:
            r11 = r6
            goto L70
        L6c:
            java.lang.String r11 = r1.concat(r11)
        L70:
            if (r11 == 0) goto Ld4
            r0.put(r9, r11)
            r4.put(r9, r12)
            goto Ld4
        L79:
            a4.u r8 = new a4.u
            r8.<init>()
            throw r8
        L7f:
            if (r1 == 0) goto Lae
            int r2 = r1.length()
            if (r2 != 0) goto L88
            goto Lae
        L88:
            boolean r2 = ga.r.g0(r11, r1, r3)
            if (r2 == 0) goto L95
            r0.put(r9, r11)
            r4.put(r9, r12)
            goto Ld4
        L95:
            java.lang.Object r2 = r4.get(r9)
            o4.r r3 = o4.r.CHAT_DELTA
            if (r2 != r3) goto Ld4
            int r2 = r11.length()
            int r1 = r1.length()
            if (r2 < r1) goto Ld4
            r0.put(r9, r11)
            r4.put(r9, r12)
            goto Ld4
        Lae:
            r0.put(r9, r11)
            r4.put(r9, r12)
            goto Ld4
        Lb5:
            if (r1 == 0) goto Ld4
            int r2 = r1.length()
            if (r2 != 0) goto Lbe
            goto Ld4
        Lbe:
            int r2 = r11.length()
            int r5 = r1.length()
            if (r2 <= r5) goto Ld4
            boolean r1 = ga.r.g0(r11, r1, r3)
            if (r1 == 0) goto Ld4
            r0.put(r9, r11)
            r4.put(r9, r12)
        Ld4:
            java.util.concurrent.ConcurrentHashMap r8 = r8.f7631r
            r8.put(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.f(java.lang.String, java.lang.String, java.lang.String, o4.r):void");
    }

    public final boolean g(int i2, String str) {
        if (i2 > 1) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f7636w.get(str);
            if (concurrentHashMap == null) {
                return false;
            }
            Set setKeySet = concurrentHashMap.keySet();
            q7.k.d(setKeySet, "<get-keys>(...)");
            Integer num = (Integer) d7.r.Y0(setKeySet);
            if (num == null) {
                return false;
            }
            int iIntValue = num.intValue();
            for (int i10 = i2 - 1; i10 >= iIntValue; i10--) {
                String str2 = (String) concurrentHashMap.get(Integer.valueOf(i10));
                if (str2 == null) {
                    return false;
                }
                if (C.contains(str2)) {
                    break;
                }
            }
        }
        return true;
    }

    public final c5.b i(String str, String str2, String str3, Map map) {
        String str4 = (String) this.f7628o.get(str);
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7632s.get(str);
        if (str5.length() == 0 && ((linkedHashMap == null || linkedHashMap.isEmpty()) && map == null)) {
            return null;
        }
        return k(this, str, str2, str5, linkedHashMap, true, null, str3, map, 32);
    }

    public final void l(String str) {
        this.f7628o.remove(str);
        this.f7629p.remove(str);
        this.f7632s.remove(str);
        this.f7631r.remove(str);
        this.f7630q.remove(str);
        n(str);
        this.B.remove(str);
    }

    public final void m(String str) {
        String str2 = (String) this.f7624k.get(str);
        if (str2 != null) {
        }
    }

    public final void n(String str) {
        this.f7636w.remove(str);
        Set setKeySet = this.f7637x.keySet();
        q7.k.d(setKeySet, "<get-keys>(...)");
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            q7.k.e(str2, "it");
            if (ga.r.g0(str2, str + "#", false)) {
                it.remove();
            }
        }
    }

    public final boolean o(String str, boolean z4) {
        q7.k.e(str, "runId");
        Map map = this.f7633t;
        if (map.containsKey(str)) {
            return false;
        }
        if (!this.f7631r.containsKey(str) && !this.f7628o.containsKey(str) && !this.f7632s.containsKey(str) && !this.B.containsKey(str)) {
            return false;
        }
        l(str);
        if (!z4) {
            return true;
        }
        map.put(str, Boolean.TRUE);
        return true;
    }

    public final void p(String str, String str2, String str3, Map map) {
        Object objN;
        a5.a aVar = this.f7619f;
        if (aVar == null) {
            k5.s.debug$default(this.f7616c, "OpenClawAdapter", a1.a.j("emitLlmPhase: sink=null node=", str, " (OpenClawVirtualConnection 没注入)"), null, 4, null);
            return;
        }
        if (str3 == null || str3.length() == 0) {
            k5.s.debug$default(this.f7616c, "OpenClawAdapter", a1.a.j("emitLlmPhase: runId empty node=", str, " (上游还没分配)"), null, 4, null);
            return;
        }
        if (q7.k.a(this.f7625l.get(str3), Boolean.TRUE)) {
            e7.g gVar = new e7.g();
            gVar.put("runId", str3);
            Integer num = (Integer) this.f7638y.get(str3);
            gVar.put("round", Integer.valueOf(num != null ? num.intValue() : 0));
            gVar.putAll(map);
            try {
                aVar.invoke(u4.i.b(str, null, str2, null, gVar.c(), 10));
                objN = c7.r.f1986a;
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            Throwable thA = c7.m.a(objN);
            if (thA != null) {
                k5.s.warn$default(this.f7616c, "OpenClawAdapter", a1.a.k("onLlmPhaseEvent ", str, " failed: ", thA.getMessage()), null, 4, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x037f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(org.json.JSONArray r36) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.s(org.json.JSONArray):void");
    }

    public final c5.b t(String str, boolean z4) {
        Collection<s> collectionValues;
        q7.k.e(str, "runId");
        Map map = this.B;
        q qVar = (q) map.get(str);
        Integer numValueOf = null;
        if (qVar == null) {
            return null;
        }
        int i2 = qVar.f7516c;
        if (!z4 && v(str)) {
            k5.s.info$default(this.f7616c, "OpenClawAdapter", "deferred run end soft-timeout runId=" + ga.k.L0(20, str) + " endSeq=" + i2 + ": incomplete tools still pending; keep defer for renew", null, 4, null);
            return null;
        }
        String strL0 = ga.k.L0(20, str);
        ConcurrentHashMap concurrentHashMap = this.f7636w;
        if (i2 > 1) {
            ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) concurrentHashMap.get(str);
            if (concurrentHashMap2 == null) {
                numValueOf = Integer.valueOf(i2 - 1);
            } else {
                Set setKeySet = concurrentHashMap2.keySet();
                q7.k.d(setKeySet, "<get-keys>(...)");
                Integer num = (Integer) d7.r.Y0(setKeySet);
                if (num != null) {
                    int iIntValue = num.intValue();
                    int i10 = i2 - 1;
                    while (true) {
                        if (i10 < iIntValue) {
                            break;
                        }
                        String str2 = (String) concurrentHashMap2.get(Integer.valueOf(i10));
                        if (str2 == null) {
                            numValueOf = Integer.valueOf(i10);
                            break;
                        }
                        if (C.contains(str2)) {
                            break;
                        }
                        i10--;
                    }
                } else {
                    numValueOf = Integer.valueOf(i2 - 1);
                }
            }
        }
        ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) concurrentHashMap.get(str);
        int size = concurrentHashMap3 != null ? concurrentHashMap3.size() : 0;
        StringBuilder sbO = a1.a.o("deferred run end timed out runId=", strL0, " endSeq=", i2, " missingSeq=");
        sbO.append(numValueOf);
        sbO.append(" seenCount=");
        sbO.append(size);
        sbO.append(" force=");
        sbO.append(z4);
        sbO.append("; force flush");
        k5.s.warn$default(this.f7616c, "OpenClawAdapter", sbO.toString(), null, 4, null);
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7632s.get(str);
        if (linkedHashMap != null && (collectionValues = linkedHashMap.values()) != null) {
            for (s sVar : collectionValues) {
                if (sVar.f7546d.equals("PENDING") || sVar.f7546d.equals("RUNNING")) {
                    String str3 = sVar.f7546d;
                    sVar.f7546d = "ERROR";
                    String str4 = sVar.f7548f;
                    if (str4 == null || str4.length() == 0) {
                        sVar.f7548f = "tool result missing: forced timeout after deferred run end";
                    }
                    String strL02 = ga.k.L0(20, str);
                    String str5 = sVar.f7543a;
                    String str6 = sVar.f7544b;
                    StringBuilder sbP = a1.a.p("force flush coerce tool state runId=", strL02, " toolId=", str5, " name=");
                    sbP.append(str6);
                    sbP.append(" from=");
                    sbP.append(str3);
                    sbP.append(" to=ERROR");
                    k5.s.warn$default(this.f7616c, "OpenClawAdapter", sbP.toString(), null, 4, null);
                }
            }
        }
        map.remove(str);
        return u(str, qVar.f7514a, qVar.f7515b, qVar.f7517d);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c5.b u(java.lang.String r22, java.lang.String r23, org.json.JSONObject r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.u.u(java.lang.String, java.lang.String, org.json.JSONObject, java.lang.String):c5.b");
    }

    public final boolean v(String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7632s.get(str);
        if (linkedHashMap == null) {
            return false;
        }
        Collection collectionValues = linkedHashMap.values();
        q7.k.d(collectionValues, "<get-values>(...)");
        Collection<s> collection = collectionValues;
        if (collection.isEmpty()) {
            return false;
        }
        for (s sVar : collection) {
            if (q7.k.a(sVar.f7546d, "PENDING") || q7.k.a(sVar.f7546d, "RUNNING")) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList y() {
        g gVar;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ConcurrentHashMap concurrentHashMap = this.f7628o;
        linkedHashSet.addAll(concurrentHashMap.keySet());
        linkedHashSet.addAll(this.f7632s.keySet());
        ConcurrentHashMap concurrentHashMap2 = this.f7631r;
        linkedHashSet.addAll(concurrentHashMap2.keySet());
        linkedHashSet.addAll(this.B.keySet());
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSet) {
            if (!this.f7633t.containsKey((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) concurrentHashMap2.get(str);
            if (str2 == null) {
                gVar = null;
            } else {
                String str3 = (String) concurrentHashMap.get(str);
                if (str3 == null) {
                    str3 = "";
                }
                gVar = new g(str, str2, str3);
            }
            if (gVar != null) {
                arrayList2.add(gVar);
            }
        }
        return arrayList2;
    }

    public final boolean z(String str, String str2, String str3) {
        return this.f7635v.putIfAbsent(m.x.l(str, "#", str2, "#", str3), Boolean.TRUE) == null;
    }
}
