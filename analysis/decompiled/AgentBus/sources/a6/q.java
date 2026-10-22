package a6;

import b0.f2;
import ia.f1;
import ia.g1;
import j1.q1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import m4.u0;
import o4.b3;
import o4.h1;
import o4.r2;
import o4.t2;
import o4.y1;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f361f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f362g;

    public /* synthetic */ q(int i2, Object obj) {
        this.f361f = i2;
        this.f362g = obj;
    }

    /* JADX WARN: Type inference failed for: r11v19, types: [i7.i, p7.n] */
    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) throws Throwable {
        Object objK;
        c5.b bVarA;
        long jLongValue;
        Object objB;
        Object pVar;
        switch (this.f361f) {
            case 0:
                ((a7.d) ((k5.q) ((a4.p) this.f362g).f194h)).C((s) obj);
                return c7.r.f1986a;
            case 1:
                String str = (String) obj;
                c7.r rVar = c7.r.f1986a;
                d5.z zVar = (d5.z) this.f362g;
                String str2 = zVar.f2927a;
                try {
                    c5.b bVarA2 = ((c5.d) zVar.f2931e).a(str);
                    zVar.f2932f.getClass();
                    c5.e eVarQ = s9.d.q(bVarA2);
                    if (eVarQ != null) {
                        k5.s.warn$default(zVar.f2935i, "MgdClientConn", a1.a.x(str2, " invalid frame: ", eVarQ.f1900a), null, 4, null);
                        return rVar;
                    }
                    Object objEmit = zVar.f2939m.emit(bVarA2, dVar);
                    return objEmit == h7.a.f4212f ? objEmit : rVar;
                } catch (Throwable th) {
                    ((k5.g) zVar.f2935i).c("MgdClientConn", a1.a.x(str2, " decode failed: ", th.getMessage()), th);
                    return rVar;
                }
            case 2:
                ((q1) this.f362g).f5304f.e(((Number) obj).floatValue());
                return c7.r.f1986a;
            case 3:
                Object objInvoke = ((i7.i) this.f362g).invoke((k5.r) obj, dVar);
                return objInvoke == h7.a.f4212f ? objInvoke : c7.r.f1986a;
            case 4:
                t2 t2Var = (t2) this.f362g;
                int i2 = r2.$EnumSwitchMapping$0[((h1) obj).ordinal()];
                c7.r rVar2 = c7.r.f1986a;
                if (i2 != 1) {
                    return (i2 == 2 && (objK = t2Var.k(dVar)) == h7.a.f4212f) ? objK : rVar2;
                }
                String str3 = t2Var.f7608g;
                if (!t2Var.j()) {
                    k5.s.info$default(t2Var.f7605d, "OpenClawStreamRecovery", a1.a.j("operator OFFLINE on ", str3, "; scheduling disconnect finalize"), null, 4, null);
                    t2Var.p();
                    return rVar2;
                }
                k5.s.info$default(t2Var.f7605d, "OpenClawStreamRecovery", a1.a.j("operator OFFLINE on ", str3, " during screen-off; skip disconnect finalize (expect history recovery on resume)"), null, 4, null);
                ConcurrentHashMap concurrentHashMap = t2Var.f7612k;
                Set setKeySet = concurrentHashMap.keySet();
                q7.k.d(setKeySet, "<get-keys>(...)");
                Iterator it = d7.r.m1(setKeySet).iterator();
                while (it.hasNext()) {
                    g1 g1Var = (g1) concurrentHashMap.remove((String) it.next());
                    if (g1Var != null) {
                        f1.cancel$default(g1Var, (CancellationException) null, 1, (Object) null);
                    }
                }
                return rVar2;
            case 5:
                c7.j jVar = (c7.j) obj;
                b3 b3Var = (b3) this.f362g;
                String str4 = (String) jVar.f1973f;
                JSONObject jSONObject = (JSONObject) jVar.f1974g;
                q7.k.e(str4, "sessionRole");
                q7.k.e(jSONObject, "jsonObj");
                if ((str4.equals("operator") ? true : str4.equals("node") ? q7.k.a(jSONObject.optString("event"), "node.invoke.request") : false) && (bVarA = b3Var.f7288e.a(jSONObject)) != null) {
                    b3Var.f7297n.M(bVarA);
                }
                return c7.r.f1986a;
            case 6:
                c5.b bVar = (c5.b) obj;
                u0 u0Var = (u0) this.f362g;
                ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) u0Var.f6346f;
                String strE = bVar.e();
                if (strE != null) {
                    if (strE.equals("stepclaw.bypass.engaged")) {
                        Map mapH = bVar.h();
                        Object obj2 = mapH != null ? mapH.get("clientId") : null;
                        String str5 = obj2 instanceof String ? (String) obj2 : null;
                        if (str5 != null) {
                            Map mapH2 = bVar.h();
                            Object obj3 = mapH2 != null ? mapH2.get("timestamp") : null;
                            Number number = obj3 instanceof Number ? (Number) obj3 : null;
                            concurrentHashMap2.put(str5, Long.valueOf(number != null ? number.longValue() : System.currentTimeMillis()));
                            ((AtomicLong) u0Var.f6347g).incrementAndGet();
                            k5.s.warn$default((k5.t) u0Var.f6342b, "BypassObserver", "[D6] bypass ENGAGED clientId=" + str5 + " engagedNow=" + concurrentHashMap2.size(), null, 4, null);
                        }
                    } else if (strE.equals("stepclaw.bypass.recovered")) {
                        Map mapH3 = bVar.h();
                        Object obj4 = mapH3 != null ? mapH3.get("clientId") : null;
                        String str6 = obj4 instanceof String ? (String) obj4 : null;
                        if (str6 != null) {
                            Map mapH4 = bVar.h();
                            Object obj5 = mapH4 != null ? mapH4.get("durationMs") : null;
                            Number number2 = obj5 instanceof Number ? (Number) obj5 : null;
                            Long lValueOf = number2 != null ? Long.valueOf(number2.longValue()) : null;
                            if (lValueOf != null) {
                                jLongValue = lValueOf.longValue();
                            } else {
                                Long l6 = (Long) concurrentHashMap2.get(str6);
                                Long lValueOf2 = l6 != null ? Long.valueOf(System.currentTimeMillis() - l6.longValue()) : null;
                                jLongValue = lValueOf2 != null ? lValueOf2.longValue() : 0L;
                            }
                            concurrentHashMap2.remove(str6);
                            ((AtomicLong) u0Var.f6348h).addAndGet(jLongValue);
                            k5.s.info$default((k5.t) u0Var.f6342b, "BypassObserver", "[D6] bypass RECOVERED clientId=" + str6 + " durationMs=" + jLongValue + " engagedNow=" + concurrentHashMap2.size(), null, 4, null);
                        }
                    }
                }
                return c7.r.f1986a;
            case 7:
                d5.i iVar = (d5.i) obj;
                q5.q qVar = (q5.q) this.f362g;
                boolean z4 = iVar instanceof d5.g;
                c7.r rVar3 = c7.r.f1986a;
                if (!z4) {
                    if (!(iVar instanceof d5.h)) {
                        throw new a4.u();
                    }
                    Object objB2 = q5.q.b(((d5.h) iVar).f2877a, qVar, dVar);
                    return objB2 == h7.a.f4212f ? objB2 : rVar3;
                }
                d5.e eVar = ((d5.g) iVar).f2876a;
                qVar.getClass();
                q7.k.e(eVar, "connection");
                ia.d0.s(qVar.f8770x, null, null, new q5.f(qVar, eVar, (g7.d) null), 3);
                return rVar3;
            case 8:
                Object objL = ((ka.s) ((ka.t) this.f362g)).f5719i.l(dVar, obj);
                return objL == h7.a.f4212f ? objL : c7.r.f1986a;
            case 9:
                s2.z zVar2 = (s2.z) this.f362g;
                return ((zVar2.f9470l.J() instanceof s2.a0) || (objB = s2.z.b(zVar2, true, dVar)) != h7.a.f4212f) ? c7.r.f1986a : objB;
            case 10:
                t4.d dVar2 = (t4.d) obj;
                la.u0 u0Var2 = ((s4.b) this.f362g).f9492g;
                if (q7.k.a(dVar2, t4.c.f9733a)) {
                    pVar = new d5.p("zeroclaw service disconnected", null);
                } else if (q7.k.a(dVar2, t4.b.f9732a)) {
                    pVar = d5.n.f2892a;
                } else {
                    if (!(dVar2 instanceof t4.a)) {
                        throw new a4.u();
                    }
                    pVar = d5.q.f2898a;
                }
                u0Var2.getClass();
                u0Var2.g(null, pVar);
                return c7.r.f1986a;
            case 11:
                x4.b bVar2 = (x4.b) obj;
                la.u0 u0Var3 = ((v4.k) this.f362g).P;
                o5.a aVar = new o5.a(true, bVar2.f11160a, bVar2.f11161b);
                u0Var3.getClass();
                u0Var3.g(null, aVar);
                return c7.r.f1986a;
            case 12:
                v4.p pVar2 = (v4.p) this.f362g;
                ia.d0.s(pVar2.f10495i, null, null, new f2(pVar2, (c6.l) obj, (g7.d) null, 20), 3);
                return c7.r.f1986a;
            case 13:
                q.h hVar = (q.h) obj;
                l0.q qVar2 = (l0.q) this.f362g;
                if (hVar instanceof q.f) {
                    qVar2.add(hVar);
                } else if (hVar instanceof q.g) {
                    qVar2.remove(((q.g) hVar).f8613a);
                } else if (hVar instanceof q.d) {
                    qVar2.add(hVar);
                } else if (hVar instanceof q.e) {
                    qVar2.remove(((q.e) hVar).f8612a);
                } else if (hVar instanceof q.k) {
                    qVar2.add(hVar);
                } else if (hVar instanceof q.l) {
                    qVar2.remove(((q.l) hVar).f8617a);
                } else if (hVar instanceof q.j) {
                    qVar2.remove(((q.j) hVar).f8615a);
                }
                return c7.r.f1986a;
            default:
                y1 y1Var = (y1) this.f362g;
                List listJ0 = d7.r.J0(d7.t.B0(((a3.b) y1Var.f7700a).u().values()));
                if (listJ0.isEmpty()) {
                    k5.s.debug$default((k5.t) y1Var.f7702c, "EdgeCapsForwarder", "syncSnapshot: no caps registered, skip", null, 4, null);
                } else {
                    k5.s.info$default((k5.t) y1Var.f7702c, "EdgeCapsForwarder", "syncSnapshot: pushing " + listJ0.size() + " caps to edge gateway: " + listJ0, null, 4, null);
                    ia.d0.s((ia.b0) y1Var.f7703d, null, null, new p.v(y1Var, listJ0, null, 13), 3);
                    y1Var.c();
                }
                return c7.r.f1986a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(p7.n nVar) {
        this.f361f = 3;
        this.f362g = (i7.i) nVar;
    }
}
