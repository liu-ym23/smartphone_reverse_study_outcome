package b0;

import com.squareup.moshi.JsonAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final /* synthetic */ class b2 implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1113f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1114g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1115h;

    public /* synthetic */ b2(int i2, Object obj, Object obj2) {
        this.f1113f = i2;
        this.f1114g = obj;
        this.f1115h = obj2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Object objN;
        Object objN2;
        a6.f fVar;
        switch (this.f1113f) {
            case 0:
                x xVar = (x) this.f1114g;
                k.b0 b0Var = (k.b0) this.f1115h;
                xVar.v(obj);
                if (b0Var != null) {
                    b0Var.a(obj);
                }
                return c7.r.f1986a;
            case 1:
                j2 j2Var = (j2) this.f1114g;
                Throwable th = (Throwable) this.f1115h;
                Throwable th2 = (Throwable) obj;
                synchronized (j2Var.f1207b) {
                    if (th == null) {
                        th = null;
                    } else if (th2 != null) {
                        try {
                            if (th2 instanceof CancellationException) {
                                th2 = null;
                            }
                            if (th2 != null) {
                                ib.k.e(th, th2);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    j2Var.f1209d = th;
                    la.u0 u0Var = j2Var.f1225t;
                    d2 d2Var = d2.f1123f;
                    u0Var.getClass();
                    u0Var.g(null, d2Var);
                    break;
                }
            case 2:
                e.b bVar = (e.b) this.f1114g;
                d.f fVar2 = (d.f) this.f1115h;
                i5.f fVar3 = bVar.f3040a;
                if (fVar3 != null) {
                    i5.f.w(fVar3, fVar2.f2739b);
                } else {
                    c.o oVar = bVar.f3041b;
                    if (oVar == null) {
                        throw new IllegalStateException("Unreachable");
                    }
                    x0 x0Var = fVar2.f2738a;
                    q7.k.e(x0Var, "onBackPressedCallback");
                    c.k kVar = new c.k(x0Var, new c.l(x0Var));
                    ((ArrayList) x0Var.f1414a).add(kVar);
                    i5.f.w(((c.n) oVar.f1712b.getValue()).f1710c, kVar);
                }
                return new d.d(0, bVar, fVar2);
            case 3:
                ((ja.d) this.f1114g).f5421h.removeCallbacks((c.b) this.f1115h);
                break;
            case 4:
                File file = (File) this.f1114g;
                JsonAdapter jsonAdapter = (JsonAdapter) this.f1115h;
                String str = (String) obj;
                q7.k.e(str, "line");
                try {
                    objN = (Map) jsonAdapter.fromJson(str);
                } catch (Throwable th4) {
                    objN = w7.e0.n(th4);
                }
                if (objN instanceof c7.l) {
                    objN = null;
                }
                Map map = (Map) objN;
                if (map == null) {
                    return null;
                }
                Object obj2 = map.get("tsMs");
                Number number = obj2 instanceof Number ? (Number) obj2 : null;
                long jLongValue = number != null ? number.longValue() : 0L;
                Object obj3 = map.get("jobId");
                String strK0 = obj3 instanceof String ? (String) obj3 : null;
                if (strK0 == null) {
                    q7.k.e(file, "<this>");
                    String name = file.getName();
                    q7.k.d(name, "getName(...)");
                    strK0 = ga.k.K0(name, ".", name);
                }
                String str2 = strK0;
                Object obj4 = map.get("status");
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                if (str3 != null) {
                    try {
                        String upperCase = str3.toUpperCase(Locale.ROOT);
                        q7.k.d(upperCase, "toUpperCase(...)");
                        objN2 = a6.f.valueOf(upperCase);
                    } catch (Throwable th5) {
                        objN2 = w7.e0.n(th5);
                    }
                    if (objN2 instanceof c7.l) {
                        objN2 = null;
                    }
                    fVar = (a6.f) objN2;
                } else {
                    fVar = null;
                }
                Object obj5 = map.get("summary");
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                Object obj6 = map.get("error");
                String str5 = obj6 instanceof String ? (String) obj6 : null;
                Object obj7 = map.get("nextRunAtMs");
                Number number2 = obj7 instanceof Number ? (Number) obj7 : null;
                Long lValueOf = number2 != null ? Long.valueOf(number2.longValue()) : null;
                Object obj8 = map.get("durationMs");
                Number number3 = obj8 instanceof Number ? (Number) obj8 : null;
                Long lValueOf2 = number3 != null ? Long.valueOf(number3.longValue()) : null;
                Object obj9 = map.get("runAtMs");
                Number number4 = obj9 instanceof Number ? (Number) obj9 : null;
                Long lValueOf3 = number4 != null ? Long.valueOf(number4.longValue()) : null;
                Object obj10 = map.get("sessionKey");
                return new a6.e(jLongValue, str2, fVar, str4, str5, lValueOf, lValueOf2, lValueOf3, obj10 instanceof String ? (String) obj10 : null);
            case 5:
                m4.q0 q0Var = (m4.q0) this.f1114g;
                a6.d dVar = (a6.d) this.f1115h;
                Map map2 = (Map) obj;
                q7.k.e(map2, "root");
                Object obj11 = map2.get("jobs");
                List arrayList = q7.z.e(obj11) ? (List) obj11 : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map2.put("jobs", arrayList);
                }
                d7.x.E0(arrayList, new a5.a(13, dVar));
                q0Var.getClass();
                arrayList.add(d7.e0.U(new c7.j("jobId", dVar.f295a), new c7.j("name", dVar.f296b), new c7.j("schedule", dVar.f297c), new c7.j("actionTarget", dVar.f298d), new c7.j("isEnabled", Boolean.valueOf(dVar.f299e)), new c7.j("deleteAfterRun", Boolean.valueOf(dVar.f300f)), new c7.j("nextRunAtMs", dVar.f301g), new c7.j("payloadText", dVar.f302h)));
                break;
            case 6:
                String str6 = (String) this.f1114g;
                String str7 = (String) this.f1115h;
                Map map3 = (Map) obj;
                q7.k.e(map3, "cfg");
                Object obj12 = map3.get("channels");
                Map linkedHashMap = q7.z.f(obj12) ? (Map) obj12 : null;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    map3.put("channels", linkedHashMap);
                }
                Object obj13 = linkedHashMap.get(str6);
                Map linkedHashMap2 = q7.z.f(obj13) ? (Map) obj13 : null;
                if (linkedHashMap2 == null) {
                    linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap.put(str6, linkedHashMap2);
                }
                Object obj14 = linkedHashMap2.get("accounts");
                Map linkedHashMap3 = q7.z.f(obj14) ? (Map) obj14 : null;
                if (linkedHashMap3 == null) {
                    linkedHashMap3 = new LinkedHashMap();
                    linkedHashMap2.put("accounts", linkedHashMap3);
                }
                Object obj15 = linkedHashMap3.get("default");
                Map linkedHashMap4 = q7.z.f(obj15) ? (Map) obj15 : null;
                if (linkedHashMap4 == null) {
                    linkedHashMap4 = new LinkedHashMap();
                    linkedHashMap3.put("default", linkedHashMap4);
                }
                linkedHashMap4.put("enabled", Boolean.TRUE);
                if (str7 != null) {
                    linkedHashMap4.put("version", str7);
                }
                return c7.r.f1986a;
            case 7:
                o4.t1 t1Var = (o4.t1) this.f1114g;
                o4.v2 v2Var = (o4.v2) this.f1115h;
                String str8 = (String) obj;
                q7.k.e(str8, "fp");
                t1Var.f7581i.invoke(v2Var.f7666c, str8);
                break;
            case 8:
                ((ra.d) this.f1114g).e(((ra.c) this.f1115h).f9115g);
                break;
            default:
                x4.i iVar = (x4.i) this.f1114g;
                ia.d0.s(iVar.f11187g, null, null, new f2(iVar, (q7.v) this.f1115h, (Throwable) obj, null, 24), 3);
                break;
        }
        return c7.r.f1986a;
    }

    public /* synthetic */ b2(m4.q0 q0Var, File file, JsonAdapter jsonAdapter) {
        this.f1113f = 4;
        this.f1114g = file;
        this.f1115h = jsonAdapter;
    }
}
