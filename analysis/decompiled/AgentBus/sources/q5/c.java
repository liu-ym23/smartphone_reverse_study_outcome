package q5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class c implements b0 {

    /* renamed from: k, reason: collision with root package name */
    public static final Set f8653k = ib.k.S("stepclaw.config.update");

    /* renamed from: a, reason: collision with root package name */
    public final d5.l f8654a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f8655b;

    /* renamed from: c, reason: collision with root package name */
    public final h5.g f8656c;

    /* renamed from: d, reason: collision with root package name */
    public final h5.b f8657d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8658e;

    /* renamed from: f, reason: collision with root package name */
    public final k5.t f8659f;

    /* renamed from: g, reason: collision with root package name */
    public final b f8660g;

    /* renamed from: h, reason: collision with root package name */
    public final v4.a f8661h;

    /* renamed from: i, reason: collision with root package name */
    public final t f8662i;

    /* renamed from: j, reason: collision with root package name */
    public final s1.u f8663j;

    public c(d5.l lVar, a3.b bVar, h5.g gVar, h5.b bVar2, List list, k5.g gVar2, b bVar3, v4.a aVar, t tVar, s1.u uVar) {
        q7.k.e(lVar, "pool");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(gVar, "invocationMapper");
        q7.k.e(bVar2, "idempotencyStore");
        q7.k.e(list, "staticRoutes");
        q7.k.e(gVar2, "logger");
        this.f8654a = lVar;
        this.f8655b = bVar;
        this.f8656c = gVar;
        this.f8657d = bVar2;
        this.f8658e = list;
        this.f8659f = gVar2;
        this.f8660g = bVar3;
        this.f8661h = aVar;
        this.f8662i = tVar;
        this.f8663j = uVar;
    }

    public final a0 a(c5.b bVar, d5.e eVar) {
        Object next;
        d5.e eVarC;
        boolean zEquals;
        Object obj;
        q7.k.e(bVar, "frame");
        q7.k.e(eVar, "source");
        String strE = bVar.e();
        if (strE != null && f8653k.contains(strE)) {
            return v.f8777a;
        }
        boolean z4 = false;
        if (q7.k.a(bVar.d(), "node.invoke.result")) {
            Map mapG = bVar.g();
            Object obj2 = mapG != null ? mapG.get("id") : null;
            str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null) {
                return new z("STEPCLAW_INVALID_FRAME", "result missing id", false);
            }
            h5.d dVarB = h5.g.b(this.f8656c, str);
            if (dVarB == null) {
                k5.s.debug$default(this.f8659f, "DefaultRouter", a1.a.j("node.invoke.result ", str, ": no mapping, drop"), null, 4, null);
                return v.f8777a;
            }
            d5.e eVarC2 = this.f8654a.c(dVarB.f4187c);
            return eVarC2 == null ? new z("STEPCLAW_TRANSPORT_ERROR", "upstream conn lost", false) : new x(eVarC2, dVarB.f4186b);
        }
        if (!q7.k.a(bVar.a(), "node.invoke.request")) {
            d5.m mVarF = eVar.f();
            d5.m mVar = d5.m.CHANNEL;
            if (mVarF == mVar || eVar.f() == d5.m.CONSOLE) {
                d5.e eVarB = b(bVar, eVar.c());
                return eVarB != null ? new y(eVarB) : new w("GATEWAY");
            }
            if (eVar.f() != d5.m.GATEWAY) {
                return v.f8777a;
            }
            String strE2 = bVar.e();
            if (strE2 != null && ((Boolean) this.f8663j.invoke(strE2)).booleanValue()) {
                return v.f8777a;
            }
            ArrayList arrayListD = this.f8654a.d(mVar);
            if (arrayListD.isEmpty()) {
                String strE3 = bVar.e();
                if (strE3 != null && ga.r.g0(strE3, "stepclaw.trace", false)) {
                    z4 = true;
                }
                if (z4) {
                    k5.s.warn$default(this.f8659f, "DefaultRouter", a1.a.j("trace ", bVar.e(), " drop: no online CHANNEL"), null, 4, null);
                }
                return new w("CHANNEL");
            }
            Map mapH = bVar.h();
            Object obj3 = mapH != null ? mapH.get("sessionId") : null;
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (str != null) {
                str = str;
            } else {
                Map mapG2 = bVar.g();
                Object obj4 = mapG2 != null ? mapG2.get("payload") : null;
                Map map = obj4 instanceof Map ? (Map) obj4 : null;
                Object obj5 = map != null ? map.get("sessionId") : null;
                if (obj5 instanceof String) {
                    str = (String) obj5;
                }
            }
            if (str != null) {
                Set set = (Set) this.f8662i.f8775a.get(str);
                Collection collectionQ1 = set != null ? d7.r.q1(set) : d7.b0.f2947f;
                if (!collectionQ1.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = arrayListD.iterator();
                    while (it.hasNext()) {
                        Object next2 = it.next();
                        if (d7.r.I0(collectionQ1, ((d5.e) next2).e())) {
                            arrayList.add(next2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return arrayList.size() == 1 ? new y((d5.e) d7.r.f1(arrayList)) : new u(arrayList);
                    }
                    k5.s.info$default(this.f8659f, "DefaultRouter", "session origin clientIds=" + collectionQ1 + " not online, enqueue offline", null, 4, null);
                    return new w("CHANNEL");
                }
                k5.s.debug$default(this.f8659f, "DefaultRouter", a1.a.j("session ", str, " has no registered origin clientIds, fallback to broadcast"), null, 4, null);
            }
            return arrayListD.size() == 1 ? new y((d5.e) d7.r.f1(arrayListD)) : new u(arrayListD);
        }
        Map mapH2 = bVar.h();
        Object obj6 = mapH2 != null ? mapH2.get("command") : null;
        String str2 = obj6 instanceof String ? (String) obj6 : null;
        if (str2 == null) {
            return new z("STEPCLAW_INVALID_FRAME", "invoke missing command", false);
        }
        Map mapH3 = bVar.h();
        if (mapH3 != null && (obj = mapH3.get("idempotencyKey")) != null && (obj instanceof String)) {
            h5.b bVar2 = this.f8657d;
            String str3 = (String) obj;
            bVar2.getClass();
            long jLongValue = ((Number) bVar2.f4182c.c()).longValue();
            synchronized (bVar2.f4183d) {
                h5.a aVar = (h5.a) bVar2.f4183d.get(str3);
                if (aVar != null) {
                    if (jLongValue - aVar.f4179b < bVar2.f4180a) {
                        return new z("STEPCLAW_DUPLICATE", "duplicate idempotencyKey: " + obj, false);
                    }
                    bVar2.f4183d.remove(str3);
                }
            }
        }
        Iterator it2 = this.f8658e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            d0 d0Var = (d0) next;
            d0Var.getClass();
            if (d0Var.f8676d) {
                zEquals = ga.r.g0(str2, d0Var.f8677e + ".", false);
            } else {
                zEquals = str2.equals(d0Var.f8673a);
            }
            if (zEquals) {
                break;
            }
        }
        d0 d0Var2 = (d0) next;
        if (d0Var2 == null) {
            String strS = this.f8655b.s(str2);
            if (strS != null && (eVarC = this.f8654a.c(strS)) != null) {
                return new y(eVarC);
            }
            d5.e eVarB2 = b(bVar, null);
            return eVarB2 != null ? new y(eVarB2) : new z("STEPCLAW_NODE_NOT_FOUND", "no node for command ".concat(str2), false);
        }
        ArrayList arrayListA = this.f8654a.a(d5.m.GATEWAY);
        if (d0Var2.f8674b != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayListA.iterator();
            while (it3.hasNext()) {
                Object next3 = it3.next();
                if (q7.k.a(((d5.e) next3).g(), d0Var2.f8674b)) {
                    arrayList2.add(next3);
                }
            }
            arrayListA = arrayList2;
        }
        d5.e eVarA = this.f8660g.a(bVar, arrayListA, (c0) this.f8661h.c());
        return eVarA == null ? new z("STEPCLAW_NO_ROUTE", a1.a.j("static route '", d0Var2.f8673a, "' target unavailable"), true) : new y(eVarA);
    }

    public final d5.e b(c5.b bVar, d5.t tVar) {
        c0 c0Var;
        ArrayList arrayListA = this.f8654a.a(d5.m.GATEWAY);
        v4.a aVar = this.f8661h;
        if (tVar != null) {
            c0 c0Var2 = (c0) aVar.c();
            c0Var = new c0(c0Var2.f8664a, c0Var2.f8665b, c0Var2.f8666c, c0Var2.f8667d, tVar);
        } else {
            c0Var = (c0) aVar.c();
        }
        return this.f8660g.a(bVar, arrayListA, c0Var);
    }
}
