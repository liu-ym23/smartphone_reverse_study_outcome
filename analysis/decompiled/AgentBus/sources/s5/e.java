package s5;

import com.stepos.account.oauth.OAuthConstants;
import d5.m;
import d7.a0;
import d7.z;
import ia.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import k5.g;
import k5.h;
import k5.s;
import k5.t;
import o4.j0;
import o4.l0;
import org.json.JSONObject;
import q7.k;

/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9499a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final t f9500b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9501c;

    public e(a3.b bVar, g gVar) {
        k.e(bVar, "capabilityRegistry");
        k.e(gVar, "logger");
        this.f9501c = bVar;
        this.f9500b = gVar;
    }

    @Override // s5.d
    public final boolean a(c5.b bVar, d5.e eVar) {
        switch (this.f9499a) {
            case 0:
                k.e(bVar, "frame");
                k.e(eVar, "source");
                if (eVar.f() != m.NODE || !k.a(bVar.d(), "node.event") || !k.a(bVar.e(), "stepclaw.caps.update")) {
                }
                break;
            default:
                k.e(bVar, "frame");
                k.e(eVar, "source");
                if (eVar.f() != m.NODE || !k.a(bVar.d(), "node.invoke.result")) {
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object, java.util.List] */
    @Override // s5.d
    public final Object b(c5.b bVar, d5.e eVar, g7.d dVar) {
        List list;
        r rVar;
        l0 l0Var;
        switch (this.f9499a) {
            case 0:
                Map mapG = bVar.g();
                Object obj = mapG != null ? mapG.get("payload") : null;
                Map map = obj instanceof Map ? (Map) obj : null;
                g5.b bVar2 = map == null ? g5.b.f3848c : new g5.b(s7.a.R(map.get("added")), s7.a.R(map.get("removed")));
                ?? r13 = bVar2.f3849a;
                ?? r11 = bVar2.f3850b;
                if (!r13.isEmpty() || !r11.isEmpty()) {
                    a3.b bVar3 = (a3.b) this.f9501c;
                    String id = eVar.getId();
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) bVar3.f163g;
                    k.e(id, "nodeId");
                    if (r13.isEmpty() && r11.isEmpty()) {
                        list = z.f2978f;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : r13) {
                            String strH = bVar3.h(str);
                            if (strH == null || strH.equals(id)) {
                                arrayList2.add(str);
                            } else {
                                arrayList.add(str);
                            }
                        }
                        Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(id, new g5.a(new c6.d(17), 1));
                        k.d(objComputeIfAbsent, "computeIfAbsent(...)");
                        Set set = (Set) objComputeIfAbsent;
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (set.add((String) next)) {
                                arrayList3.add(next);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (Object obj2 : r11) {
                            if (set.remove((String) obj2)) {
                                arrayList4.add(obj2);
                            }
                        }
                        if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                            if (set.isEmpty()) {
                                concurrentHashMap.remove(id);
                            }
                            ((AtomicLong) bVar3.f164h).incrementAndGet();
                            bVar3.q();
                            ((a7.d) bVar3.f162f).C(new h(id, arrayList3, arrayList4));
                        } else if (set.isEmpty()) {
                            concurrentHashMap.remove(id);
                        }
                        list = arrayList;
                    }
                    s.info$default(this.f9500b, "NodeCapsUpdatePreprocessor", "caps.update " + eVar.getId() + ": +" + ((Object) r13) + " -" + ((Object) r11) + (list.isEmpty() ? "" : " rejectedConflict=" + list), null, 4, null);
                }
                return b.f9498a;
            default:
                Map mapG2 = bVar.g();
                Object obj3 = mapG2 != null ? mapG2.get("id") : null;
                String str2 = obj3 instanceof String ? (String) obj3 : null;
                if (str2 == null || (rVar = (r) ((ConcurrentHashMap) this.f9501c).remove(str2)) == null) {
                    return b.f9498a;
                }
                Map mapG3 = bVar.g();
                Object obj4 = mapG3 != null ? mapG3.get("ok") : null;
                Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                if (zBooleanValue) {
                    Map mapG4 = bVar.g();
                    Object obj5 = mapG4 != null ? mapG4.get("payload") : null;
                    Map map2 = obj5 instanceof Map ? (Map) obj5 : null;
                    if (map2 == null) {
                        map2 = a0.f2944f;
                    }
                    l0Var = new l0(true, new JSONObject(map2).toString(), null);
                } else {
                    Map mapG5 = bVar.g();
                    Object obj6 = mapG5 != null ? mapG5.get("error") : null;
                    Map map3 = obj6 instanceof Map ? (Map) obj6 : null;
                    Object obj7 = map3 != null ? map3.get("code") : null;
                    String str3 = obj7 instanceof String ? (String) obj7 : null;
                    if (str3 == null) {
                        str3 = "STEPCLAW_INTERNAL";
                    }
                    Object obj8 = map3 != null ? map3.get(OAuthConstants.FACTOR_RESULT_MESSAGE) : null;
                    String str4 = obj8 instanceof String ? (String) obj8 : null;
                    if (str4 == null) {
                        str4 = "unknown error";
                    }
                    l0Var = new l0(false, null, new j0(str3, str4, null));
                }
                ((ia.s) rVar).X(l0Var);
                s.debug$default(this.f9500b, "InvokeInterceptor", a1.a.k("intercepted ", str2, " → ", zBooleanValue ? "ok" : "error"), null, 4, null);
                return a.f9497a;
        }
    }

    @Override // s5.d
    public final String getId() {
        switch (this.f9499a) {
            case 0:
                return "node.caps-update";
            default:
                return "openclaw.invoke-interceptor";
        }
    }

    public e(g gVar) {
        k.e(gVar, "logger");
        this.f9500b = gVar;
        this.f9501c = new ConcurrentHashMap();
    }
}
