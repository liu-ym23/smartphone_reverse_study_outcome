package g3;

import android.accounts.Account;
import android.content.Context;
import android.util.Log;
import b0.g2;
import c7.r;
import com.stepos.agentbus.config.OpenClawCloudUpstream;
import com.stepos.agentbus.platform.AgentBusService;
import d5.t;
import ia.b0;
import ia.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import la.u0;
import m5.s;
import mobile.Guard;
import o4.w;
import s2.h0;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3798f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3799g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f3800h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f3798f = i2;
        this.f3800h = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f3798f) {
            case 0:
                return new c((Callable) this.f3799g, (ia.m) this.f3800h, dVar, 0);
            case 1:
                c cVar = new c((m5.j) this.f3800h, dVar, 1);
                cVar.f3799g = obj;
                return cVar;
            case 2:
                c cVar2 = new c((p5.h) this.f3800h, dVar, 2);
                cVar2.f3799g = obj;
                return cVar2;
            case 3:
                c cVar3 = new c((h0) this.f3800h, dVar, 3);
                cVar3.f3799g = obj;
                return cVar3;
            case 4:
                return new c((i5.l) this.f3799g, (String) this.f3800h, dVar, 4);
            case 5:
                return new c((p7.k) this.f3799g, (AgentBusService) this.f3800h, dVar, 5);
            case 6:
                return new c((v5.c) this.f3799g, (Account[]) this.f3800h, dVar, 6);
            case 7:
                c cVar4 = new c((y4.h) this.f3800h, dVar, 7);
                cVar4.f3799g = obj;
                return cVar4;
            default:
                return new c((y4.m) this.f3799g, (OpenClawCloudUpstream) this.f3800h, dVar, 8);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3798f) {
            case 0:
                c cVar = (c) create((b0) obj, (g7.d) obj2);
                r rVar = r.f1986a;
                cVar.invokeSuspend(rVar);
                return rVar;
            case 1:
                c cVar2 = (c) create((k5.p) obj, (g7.d) obj2);
                r rVar2 = r.f1986a;
                cVar2.invokeSuspend(rVar2);
                return rVar2;
            case 2:
                c cVar3 = (c) create((k5.i) obj, (g7.d) obj2);
                r rVar3 = r.f1986a;
                cVar3.invokeSuspend(rVar3);
                return rVar3;
            case 3:
                return ((c) create((h0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 4:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 5:
                c cVar4 = (c) create((b0) obj, (g7.d) obj2);
                r rVar4 = r.f1986a;
                cVar4.invokeSuspend(rVar4);
                return rVar4;
            case 6:
                c cVar5 = (c) create((b0) obj, (g7.d) obj2);
                r rVar5 = r.f1986a;
                cVar5.invokeSuspend(rVar5);
                return rVar5;
            case 7:
                c cVar6 = (c) create((b0) obj, (g7.d) obj2);
                r rVar6 = r.f1986a;
                cVar6.invokeSuspend(rVar6);
                return rVar6;
            default:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [g7.d] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        d5.e eVarC;
        Object objN;
        y4.f fVarD;
        str = null;
        String str = null;
        switch (this.f3798f) {
            case 0:
                ia.m mVar = (ia.m) this.f3800h;
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                try {
                    mVar.resumeWith(((Callable) this.f3799g).call());
                } catch (Throwable th) {
                    mVar.resumeWith(e0.n(th));
                }
                return r.f1986a;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                k5.p pVar = (k5.p) this.f3799g;
                m5.j jVar = (m5.j) this.f3800h;
                String strH = a1.a.h("auto-", pVar.f5647g);
                String strH2 = a1.a.h("sp-", System.nanoTime());
                m5.r rVar = pVar.f5641a == k5.k.OUTBOUND ? m5.r.CLIENT : m5.r.SERVER;
                String str2 = pVar.f5646f;
                if (str2 == null) {
                    str2 = "frame";
                }
                long j2 = pVar.f5647g;
                s sVar = new s(strH, strH2, rVar, str2, j2 - (pVar.f5645e / 1000000), j2, d7.e0.U(new c7.j("src", pVar.f5642b), new c7.j("dst", pVar.f5643c), new c7.j("size", String.valueOf(pVar.f5644d))));
                if (jVar.f6417f.u(sVar) instanceof ka.m) {
                    k5.s.debug$default(jVar.f6415d, "FileTraceLogger", "trace queue full, drop span ".concat(strH2), null, 4, null);
                }
                synchronized (jVar.f6418g) {
                    try {
                        LinkedHashMap linkedHashMap = jVar.f6418g;
                        Object obj2 = linkedHashMap.get(strH);
                        Object obj3 = obj2;
                        if (obj2 == null) {
                            ArrayList arrayList = new ArrayList();
                            linkedHashMap.put(strH, arrayList);
                            obj3 = arrayList;
                        }
                        ((List) obj3).add(sVar);
                        while (jVar.f6418g.size() > 200) {
                            Iterator it = jVar.f6418g.entrySet().iterator();
                            if (it.hasNext()) {
                                it.next();
                                it.remove();
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return r.f1986a;
            case 2:
                r rVar2 = r.f1986a;
                p5.h hVar = (p5.h) this.f3800h;
                t tVar = hVar.f8463j;
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                k5.i iVar = (k5.i) this.f3799g;
                if (iVar.f5631c == k5.j.ONLINE && (eVarC = hVar.f8454a.c(iVar.f5629a)) != null && eVarC.f() == hVar.f8461h) {
                    if (tVar == null || eVarC.c() == tVar) {
                        d0.s(hVar.f8466m, null, null, new g2(hVar, eVarC, , 5), 3);
                    } else {
                        k5.s.info$default(hVar.f8457d, "OfflineQueueDrainer", hVar.f8460g + ": skip drain on " + eVarC.getId() + " ONLINE (deployment=" + eVarC.c() + ", require=" + tVar + ")", null, 4, null);
                    }
                }
                return rVar2;
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                e0.N(obj);
                h0 h0Var = (h0) this.f3799g;
                return Boolean.valueOf((h0Var instanceof s2.c) && h0Var.f9379a <= ((h0) this.f3800h).f9379a);
            case 4:
                h7.a aVar5 = h7.a.f4212f;
                e0.N(obj);
                Object value = ((c7.o) ((i5.l) this.f3799g).f4689i).getValue();
                q7.k.d(value, "getValue(...)");
                return ((Guard) value).sanitizeDetail((String) this.f3800h);
            case 5:
                AgentBusService agentBusService = (AgentBusService) this.f3800h;
                h7.a aVar6 = h7.a.f4212f;
                e0.N(obj);
                try {
                    p7.k kVar = (p7.k) this.f3799g;
                    Context applicationContext = agentBusService.getApplicationContext();
                    q7.k.d(applicationContext, "getApplicationContext(...)");
                    v4.k kVar2 = (v4.k) kVar.invoke(applicationContext);
                    kVar2.b();
                    agentBusService.f2685h = kVar2;
                    u0 u0Var = agentBusService.f2686i;
                    Boolean bool = Boolean.TRUE;
                    u0Var.getClass();
                    u0Var.g(null, bool);
                    Log.i("AgentBusService", "container started (async)");
                } catch (Throwable th3) {
                    Log.e("AgentBusService", "container init failed: " + th3.getMessage(), th3);
                    agentBusService.f2688k.set(false);
                }
                return r.f1986a;
            case 6:
                h7.a aVar7 = h7.a.f4212f;
                e0.N(obj);
                v5.c cVar = (v5.c) this.f3799g;
                q7.k.b((Account[]) this.f3800h);
                cVar.b();
                return r.f1986a;
            case 7:
                h7.a aVar8 = h7.a.f4212f;
                e0.N(obj);
                y4.h hVar2 = (y4.h) this.f3800h;
                try {
                    objN = ((v5.c) hVar2.f11571e).a();
                } catch (Throwable th4) {
                    objN = e0.n(th4);
                }
                if (((String) (objN instanceof c7.l ? 0 : objN)) != null) {
                    k5.s.info$default(hVar2.f11569c, "openclaw-cloud", "token available after persistent failure; reconnect loop will pick it up", null, 4, null);
                } else {
                    k5.s.warn$default(hVar2.f11569c, "openclaw-cloud", "token still unavailable after persistent failure", null, 4, null);
                }
                return r.f1986a;
            default:
                h7.a aVar9 = h7.a.f4212f;
                e0.N(obj);
                y4.h hVar3 = ((y4.m) this.f3799g).f11608g;
                OpenClawCloudUpstream openClawCloudUpstream = (OpenClawCloudUpstream) this.f3800h;
                hVar3.getClass();
                Object objN2 = r.f1986a;
                String endpoint = openClawCloudUpstream.getEndpoint();
                if (endpoint == null) {
                    return null;
                }
                if (ga.k.t0(endpoint)) {
                    endpoint = null;
                }
                if (endpoint == null) {
                    return null;
                }
                String mtlsFallbackEndpoint = openClawCloudUpstream.getMtlsFallbackEndpoint();
                if (mtlsFallbackEndpoint != null && !ga.k.t0(mtlsFallbackEndpoint)) {
                    str = mtlsFallbackEndpoint;
                }
                if (!openClawCloudUpstream.getMtlsRequired()) {
                    return y4.h.d(hVar3, openClawCloudUpstream, endpoint, false, false);
                }
                if (str == null) {
                    try {
                        hVar3.c(openClawCloudUpstream);
                    } catch (Throwable th5) {
                        objN2 = e0.n(th5);
                    }
                    Throwable thA = c7.m.a(objN2);
                    if (thA != null) {
                        k5.s.warn$default(hVar3.f11569c, "OpenClawClientFactory", a1.a.w("mtls enroll failed (no fallback): ", thA.getMessage()), null, 4, null);
                    }
                    fVarD = y4.h.d(hVar3, openClawCloudUpstream, endpoint, true, false);
                } else {
                    w wVarA = hVar3.a(openClawCloudUpstream);
                    if (hVar3.f11578l) {
                        if (!wVarA.a()) {
                            k5.s.info$default(hVar3.f11569c, "OpenClawClientFactory", "mtls legacy fallback sticky → ".concat(str), null, 4, null);
                            return y4.h.d(hVar3, openClawCloudUpstream, str, false, true);
                        }
                        hVar3.f11578l = false;
                        k5.s.info$default(hVar3.f11569c, "OpenClawClientFactory", "mtls cert ready; leaving legacy fallback → primary endpoint", null, 4, null);
                        return y4.h.d(hVar3, openClawCloudUpstream, endpoint, true, false);
                    }
                    try {
                        hVar3.c(openClawCloudUpstream);
                    } catch (Throwable th6) {
                        objN2 = e0.n(th6);
                    }
                    Throwable thA2 = c7.m.a(objN2);
                    if (thA2 == null) {
                        fVarD = y4.h.d(hVar3, openClawCloudUpstream, endpoint, true, false);
                    } else {
                        hVar3.f11578l = true;
                        k5.s.warn$default(hVar3.f11569c, "OpenClawClientFactory", a1.a.k("mtls_enroll_fail → fallback_legacy endpoint=", str, " reason=", thA2.getMessage()), null, 4, null);
                        fVarD = y4.h.d(hVar3, openClawCloudUpstream, str, false, true);
                        if (fVarD == null) {
                            fVarD = y4.h.d(hVar3, openClawCloudUpstream, endpoint, true, false);
                        }
                    }
                }
                return fVarD;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f3798f = i2;
        this.f3799g = obj;
        this.f3800h = obj2;
    }
}
