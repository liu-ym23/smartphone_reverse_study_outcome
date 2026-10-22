package d5;

import ia.g1;
import ia.x1;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import la.u0;
import m4.m0;
import m4.q0;
import o4.h1;
import o4.t1;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2850f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f2851g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f2852h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f2853i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f2850f = i2;
        this.f2852h = obj;
        this.f2853i = obj2;
    }

    public static final void d(Object obj, v4.k kVar, t1 t1Var, h1 h1Var) {
        String str;
        String str2;
        synchronized (obj) {
            try {
                boolean z4 = h1Var == h1.ONLINE;
                o5.k kVar2 = (o5.k) kVar.O.getValue();
                boolean z10 = kVar2.f7766a;
                String str3 = kVar2.f7767b;
                boolean z11 = t1Var.F;
                if (!z4) {
                    str = !z11 ? "screen_off" : "cloud claw offline";
                } else if (z10) {
                    synchronized (t1Var) {
                        String str4 = t1Var.L;
                        if (q7.k.a(str4, "reconnect")) {
                            str = null;
                        } else {
                            t1Var.L = "reconnect";
                            str = str4;
                        }
                    }
                    if (str == null) {
                        if (str3 != null) {
                            if (ga.k.t0(str3)) {
                                str3 = null;
                            }
                            str = str3;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "reconnect";
                        }
                    }
                } else {
                    synchronized (t1Var) {
                        str2 = t1Var.L;
                        t1Var.L = "reconnect";
                    }
                    str = str2;
                }
                o5.k kVar3 = new o5.k(z4, str);
                u0 u0Var = kVar.O;
                u0Var.getClass();
                u0Var.g(null, kVar3);
                if (kVar2.f7766a != z4 || !q7.k.a(kVar2.f7767b, str)) {
                    k5.s.info$default(kVar.f10429e, "AgentBusContainer", "cloudUpstream publish online=" + z4 + " reason=" + str + " operator=" + h1Var, null, 4, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f2850f) {
            case 0:
                b bVar = new b((c) this.f2852h, (c5.c) this.f2853i, dVar, 0);
                bVar.f2851g = obj;
                return bVar;
            case 1:
                b bVar2 = new b((Set) this.f2852h, (q0) this.f2853i, dVar, 1);
                bVar2.f2851g = obj;
                return bVar2;
            case 2:
                b bVar3 = new b((q0) this.f2852h, (a6.d0) this.f2853i, dVar, 2);
                bVar3.f2851g = obj;
                return bVar3;
            default:
                b bVar4 = new b((t1) this.f2852h, (v4.k) this.f2853i, dVar, 3);
                bVar4.f2851g = obj;
                return bVar4;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2850f) {
            case 0:
                return ((b) create((String) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 1:
                return ((b) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 2:
                return ((b) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                b bVar = (b) create((ia.b0) obj, (g7.d) obj2);
                c7.r rVar = c7.r.f1986a;
                bVar.invokeSuspend(rVar);
                return rVar;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objN;
        Object objN2;
        Object objN3;
        int i2 = this.f2850f;
        boolean z4 = true;
        Object obj2 = this.f2852h;
        Object obj3 = this.f2853i;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                try {
                    objN = ((c5.d) ((c5.c) obj3)).a((String) this.f2851g);
                } catch (Throwable th) {
                    objN = e0.n(th);
                }
                c5.b bVar = (c5.b) (objN instanceof c7.l ? null : objN);
                if (bVar == null) {
                    return Boolean.FALSE;
                }
                String str = bVar.f1896a;
                if (!str.equals("hello-ok") && !str.equals("hello-error")) {
                    z4 = false;
                }
                return Boolean.valueOf(z4);
            case 1:
                d7.a0 a0Var = d7.a0.f2944f;
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                Set setX0 = (Set) obj2;
                if (setX0.contains(a6.x.ALL)) {
                    setX0 = d7.n.x0(new a6.x[]{a6.x.CLAW, a6.x.CRONJOBS});
                }
                q0 q0Var = (q0) obj3;
                m4.u0 u0Var = q0Var.f6312a;
                try {
                    Iterator it = setX0.iterator();
                    while (it.hasNext()) {
                        int i10 = m0.$EnumSwitchMapping$0[((a6.x) it.next()).ordinal()];
                        if (i10 == 1) {
                            File file = (File) u0Var.f6347g;
                            if (!file.exists()) {
                                file = null;
                            }
                            if (file != null) {
                                file.delete();
                            }
                            n7.l.K((File) u0Var.f6348h);
                        } else if (i10 == 2 || i10 == 3) {
                            if (((File) u0Var.f6343c).exists()) {
                                n7.l.J((File) u0Var.f6343c, (File) u0Var.f6342b);
                            } else {
                                q0Var.f6316e.c((File) u0Var.f6342b, a0Var);
                            }
                            if (((File) u0Var.f6345e).exists()) {
                                n7.l.J((File) u0Var.f6345e, (File) u0Var.f6344d);
                            }
                        } else if (i10 != 4 && i10 != 5) {
                            throw new a4.u();
                        }
                    }
                    List list = q0.f6311l;
                    q0Var.e0("config.backup", "restored", null);
                    objN2 = new a6.m(true, null, null, null, null, 28);
                } catch (Throwable th2) {
                    objN2 = e0.n(th2);
                }
                Throwable thA = c7.m.a(objN2);
                return thA == null ? objN2 : new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                q0 q0Var2 = (q0) obj2;
                f5.f fVar = q0Var2.f6313b;
                a6.d0 d0Var = (a6.d0) obj3;
                String str2 = d0Var.f304b;
                String str3 = d0Var.f303a;
                File fileD = fVar.d(str2);
                d7.a0 a0Var2 = d7.a0.f2944f;
                if (fileD == null) {
                    return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", d0Var.f304b, " not in cache"), a0Var2, 2);
                }
                m4.u0 u0Var2 = q0Var2.f6312a;
                u0Var2.getClass();
                File fileO = n7.l.O(n7.l.O((File) u0Var2.f6341a, "usr/local/lib/node_modules/openclaw/tools"), str3);
                if (!fileO.exists()) {
                    return new a6.m(false, null, "NOT_FOUND", a1.a.j("tool ", str3, " not installed"), a0Var2, 2);
                }
                try {
                    a.a.L(fileD, fileO);
                    q0Var2.e0("tools", "updated", str3);
                    objN3 = new a6.m(true, str3, null, null, null, 28);
                } catch (Throwable th3) {
                    objN3 = e0.n(th3);
                }
                Throwable thA2 = c7.m.a(objN3);
                return thA2 == null ? objN3 : new a6.m(false, null, "UPDATE_FAILED", thA2.getMessage(), a0Var2, 2);
            default:
                h7.a aVar4 = h7.a.f4212f;
                e0.N(obj);
                ia.b0 b0Var = (ia.b0) this.f2851g;
                Object obj4 = new Object();
                x1 x1Var = new x1((g1) b0Var.k().o(ia.z.f5027g));
                t1 t1Var = (t1) obj2;
                v4.k kVar = (v4.k) obj3;
                g7.d dVar = null;
                ia.d0.s(b0Var, x1Var, null, new v4.d(t1Var, kVar, obj4, dVar, 0), 2);
                ia.d0.s(b0Var, x1Var, null, new v4.d(t1Var, kVar, obj4, dVar, 1), 2);
                ia.d0.s(b0Var, x1Var, null, new v4.d(t1Var, kVar, obj4, dVar, 2), 2);
                return c7.r.f1986a;
        }
    }
}
