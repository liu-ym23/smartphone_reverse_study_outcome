package c6;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import c7.r;
import d5.d0;
import d7.a0;
import ia.b0;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import k5.s;
import ka.t;
import m.x;
import m4.q0;
import m4.r0;
import m4.u0;
import v4.p;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1934f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1935g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1936h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1937i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1938j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d5.m mVar, p pVar, d0 d0Var, String str, g7.d dVar) {
        super(2, dVar);
        this.f1934f = 3;
        this.f1935g = mVar;
        this.f1936h = pVar;
        this.f1937i = d0Var;
        this.f1938j = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f1934f) {
            case 0:
                g gVar = new g((LocalServerSocket) this.f1936h, (h) this.f1937i, (t) this.f1938j, dVar, 0);
                gVar.f1935g = obj;
                return gVar;
            case 1:
                g gVar2 = new g((q0) this.f1936h, (String) this.f1937i, (Map) this.f1938j, dVar, 1);
                gVar2.f1935g = obj;
                return gVar2;
            case 2:
                g gVar3 = new g((q0) this.f1936h, (String) this.f1937i, (String) this.f1938j, dVar, 2);
                gVar3.f1935g = obj;
                return gVar3;
            default:
                return new g((d5.m) this.f1935g, (p) this.f1936h, (d0) this.f1937i, (String) this.f1938j, dVar);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f1934f) {
            case 0:
                g gVar = (g) create(b0Var, dVar);
                r rVar = r.f1986a;
                gVar.invokeSuspend(rVar);
                return rVar;
            case 1:
                return ((g) create(b0Var, dVar)).invokeSuspend(r.f1986a);
            case 2:
                return ((g) create(b0Var, dVar)).invokeSuspend(r.f1986a);
            default:
                g gVar2 = (g) create(b0Var, dVar);
                r rVar2 = r.f1986a;
                gVar2.invokeSuspend(rVar2);
                return rVar2;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws IOException {
        Object objN;
        Object objN2;
        String str;
        int i2 = this.f1934f;
        r rVar = r.f1986a;
        int i10 = 0;
        Object obj2 = this.f1936h;
        Object obj3 = this.f1937i;
        Object obj4 = this.f1938j;
        switch (i2) {
            case 0:
                h hVar = (h) obj3;
                k5.t tVar = hVar.f1942d;
                int i11 = hVar.f1940b;
                CopyOnWriteArrayList copyOnWriteArrayList = hVar.f1945g;
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                b0 b0Var = (b0) this.f1935g;
                while (ia.d0.q(b0Var)) {
                    try {
                        LocalSocket localSocketAccept = ((LocalServerSocket) obj2).accept();
                        s.debug$default(hVar.f1942d, "LSServer", x.k("New conn attempt, activeChannels: ", copyOnWriteArrayList.size(), i11, "/"), null, 4, null);
                        if (copyOnWriteArrayList.size() >= i11) {
                            s.info$default(hVar.f1942d, "LSServer", x.k("Purging closed channels, current: ", copyOnWriteArrayList.size(), i11, "/"), null, 4, null);
                            int size = copyOnWriteArrayList.size();
                            final d dVar = new d(i10);
                            copyOnWriteArrayList.removeIf(new Predicate() { // from class: c6.e
                                @Override // java.util.function.Predicate
                                public final boolean test(Object obj5) {
                                    return ((Boolean) dVar.invoke(obj5)).booleanValue();
                                }
                            });
                            int size2 = copyOnWriteArrayList.size();
                            if (size != size2) {
                                s.info$default(hVar.f1942d, "LSServer", "Purged " + size + " → " + size2 + " channels", null, 4, null);
                            }
                        }
                        if (copyOnWriteArrayList.size() >= i11) {
                            s.warn$default(hVar.f1942d, "LSServer", a1.a.f(i11, "maxConnections(", ") exceeded, dropping new conn"), null, 4, null);
                            try {
                                localSocketAccept.close();
                            } catch (Throwable th) {
                                e0.n(th);
                            }
                        } else {
                            try {
                                q7.k.b(localSocketAccept);
                                c cVar = new c(localSocketAccept, hVar.f1941c, tVar);
                                copyOnWriteArrayList.add(cVar);
                                s.debug$default(hVar.f1942d, "LSServer", x.k("Channel added, activeChannels: ", copyOnWriteArrayList.size(), i11, "/"), null, 4, null);
                                ia.d0.s(hVar.f1943e, null, null, new a5.b(cVar, hVar, null, 4), 3);
                                ((ka.s) ((t) obj4)).u(cVar);
                            } catch (Throwable th2) {
                                ((k5.g) tVar).c("LSServer", a1.a.w("channel init failed (peer gone?): ", th2.getMessage()), th2);
                                try {
                                    localSocketAccept.close();
                                } catch (Throwable th3) {
                                    e0.n(th3);
                                }
                            }
                        }
                    } catch (IOException e10) {
                        if (ia.d0.q(b0Var)) {
                            ((k5.g) tVar).c("LSServer", a1.a.w("accept failed: ", e10.getMessage()), e10);
                        }
                    }
                    i10 = 0;
                }
                return rVar;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                q0 q0Var = (q0) obj2;
                u0 u0Var = q0Var.f6312a;
                String str2 = (String) obj3;
                boolean zExists = u0Var.c(str2).exists();
                a0 a0Var = a0.f2944f;
                if (!zExists) {
                    return new a6.m(false, null, "NOT_FOUND", a1.a.j("channel ", str2, " not installed"), a0Var, 2);
                }
                Map map = (Map) obj4;
                try {
                    r0 r0Var = q0Var.f6316e;
                    u0Var.getClass();
                    File fileO = n7.l.O(u0Var.c(str2), "credentials.json");
                    r0Var.getClass();
                    Map mapB = r0Var.b(fileO);
                    for (Map.Entry entry : map.entrySet()) {
                        mapB.put((String) entry.getKey(), (String) entry.getValue());
                    }
                    r0Var.c(fileO, mapB);
                    q0Var.e0("channels", "configured", str2);
                    objN = new a6.m(true, str2, null, null, null, 28);
                } catch (Throwable th4) {
                    objN = e0.n(th4);
                }
                Throwable thA = c7.m.a(objN);
                return thA == null ? objN : new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                q0 q0Var2 = (q0) obj2;
                String str3 = (String) obj3;
                String str4 = (String) obj4;
                try {
                    File fileL = q0Var2.f6312a.l(str3);
                    File parentFile = fileL.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    n7.l.Q(fileL, str4);
                    q0Var2.e0("files", "updated", str3);
                    objN2 = new a6.m(true, str3, null, null, null, 28);
                } catch (Throwable th5) {
                    objN2 = e0.n(th5);
                }
                Throwable thA2 = c7.m.a(objN2);
                return thA2 == null ? objN2 : new a6.m(false, null, "STEPCLAW_INVALID_FRAME", thA2.getMessage(), a0.f2944f, 2);
            default:
                String str5 = (String) obj4;
                d0 d0Var = (d0) obj3;
                p pVar = (p) obj2;
                h7.a aVar4 = h7.a.f4212f;
                e0.N(obj);
                d5.m mVar = (d5.m) this.f1935g;
                if (mVar == d5.m.NODE) {
                    pVar.f10489c.v(d0Var.f2863a);
                    s.info$default(pVar.f10493g, "LocalSocketAcceptor", a1.a.j("LS ", d0Var.f2863a, " capabilityRegistry: unregistered"), null, 4, null);
                }
                if (str5 != null && mVar == d5.m.CHANNEL) {
                    q6.b bVar = pVar.f10498l;
                    if (bVar != null && (str = (String) ((ConcurrentHashMap) bVar.f8787g).remove(str5)) != null) {
                        ((ConcurrentHashMap) bVar.f8788h).computeIfPresent(str, new k4.f(new k4.e(str5, 0), i10));
                    }
                    s.info$default(pVar.f10493g, "LocalSocketAcceptor", "bffOrigin unregister clientId=".concat(str5), null, 4, null);
                }
                pVar.f10488b.g(d0Var, d0Var.f2863a);
                return rVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, Object obj2, Object obj3, g7.d dVar, int i2) {
        super(2, dVar);
        this.f1934f = i2;
        this.f1936h = obj;
        this.f1937i = obj2;
        this.f1938j = obj3;
    }
}
