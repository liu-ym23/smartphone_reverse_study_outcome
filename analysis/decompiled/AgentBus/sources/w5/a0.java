package w5;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import b0.b1;
import b0.f1;
import b0.f2;
import b0.t1;
import b0.z1;
import b0.z2;
import com.stepos.agentbus.platform.AgentBusService;
import fi.iki.elonen.NanoHTTPD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import r.g0;
import r.i0;
import r.j0;
import y.k0;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f10666a = u0.z.c(4281648985L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f10667b = u0.z.c(4294939904L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f10668c = u0.z.c(4294916912L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f10669d = u0.z.c(4287532691L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f10670e = u0.z.c(4278221567L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f10671f = u0.z.c(4291282892L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f10672g = u0.z.c(4294111991L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f10673h = u0.z.c(4294967295L);

    /* renamed from: i, reason: collision with root package name */
    public static final long f10674i = u0.z.c(4280032286L);

    /* renamed from: j, reason: collision with root package name */
    public static final long f10675j = u0.z.c(4285295728L);

    /* renamed from: k, reason: collision with root package name */
    public static final List f10676k = d7.s.u0(new b0(0, "内部状态", d7.s.u0("BUS_SERVICE_STATE", "BUS_HEALTH_SNAPSHOT", "BUS_GATEWAY_STATE", "BUS_POOL_STATE", "BUS_OFFLINE_QUEUE", "BUS_CONFIG")), new b0(1, "网络", d7.s.u0("NET_CONNECTIVITY", "NET_PROXY")), new b0(2, "DNS 解析", d7.s.u0("DNS_CLOUD_PROD", "DNS_CLOUD_NODE", "DNS_BASELINE")), new b0(3, "TCP 端口", d7.s.u0("TCP_CLOUD_PROD", "TCP_CLOUD_NODE", "TCP_BASELINE")), new b0(4, "TLS / SDK", d7.s.u0("TLS_HANDSHAKE", "SECURE_DATA_SDK")), new b0(5, "Token / 身份", d7.s.u0("TOKEN_ACCOUNT", "TOKEN_DEVICE", "TOKEN_DEVICE_IDENTITY")), new b0(6, "WebSocket", d7.s.u0("WS_CONNECT_STATE", "WS_LAST_FAILURE")), new b0(7, "心跳", d7.s.u0("PING_PONG", "KEEPALIVE_STATUS")));

    public static final void a(final boolean z4, final p7.a aVar, final p7.a aVar2, final p7.a aVar3, b0.p pVar, final int i2) {
        b0.p pVar2 = pVar;
        pVar2.T(1068735992);
        int i10 = i2 | (pVar2.g(z4) ? 4 : 2) | (pVar2.h(aVar2) ? 256 : 128) | (pVar2.h(aVar3) ? 2048 : NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        if ((i10 & 1171) == 1170 && pVar2.z()) {
            pVar2.O();
        } else {
            r.e eVar = r.i.f8866a;
            i0 i0VarA = g0.a(new r.d(8), n0.b.f6781o, pVar2, 6);
            int iHashCode = Long.hashCode(pVar2.Q);
            t1 t1VarL = pVar2.l();
            n0.m mVarV = a.a.V(pVar2, androidx.compose.foundation.layout.a.f744a);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            b0.b.q(pVar2, i0VarA, i1.g.f4477e);
            b0.b.q(pVar2, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar2, iHashCode, fVar);
            }
            b0.b.q(pVar2, mVarV, i1.g.f4475c);
            boolean z10 = !z4;
            n0.m mVarA = j0.a();
            r.c0 c0Var = y.b.f11354a;
            long j2 = u0.m.f9916f;
            y.i iVar = (y.i) pVar2.j(y.k.f11484a);
            y.a aVar4 = iVar.K;
            if (aVar4 == null) {
                float f10 = a0.d.f29a;
                aVar4 = new y.a(y.k.a(iVar, 26), y.k.a(iVar, a0.d.f36h), u0.m.b(0.12f, y.k.a(iVar, a0.d.f31c)), u0.m.b(0.38f, y.k.a(iVar, a0.d.f33e)));
                iVar.K = aVar4;
            }
            long j4 = f10670e;
            if (j4 == 16) {
                j4 = aVar4.f11349a;
            }
            long j10 = j4;
            long j11 = j2 != 16 ? j2 : aVar4.f11350b;
            long j12 = j2 != 16 ? j2 : aVar4.f11351c;
            if (j2 == 16) {
                j2 = aVar4.f11352d;
            }
            y.a0.a(aVar, mVarA, z10, null, new y.a(j10, j11, j12, j2), null, null, null, d.f10684a, pVar, 805306374, 488);
            pVar2 = pVar;
            y.a0.c(aVar2, j0.a(), z10, null, null, null, null, d.f10685b, pVar2, ((i10 >> 6) & 14) | 805306368, 504);
            y.a0.c(aVar3, j0.a(), false, null, null, null, null, d.f10686c, pVar2, ((i10 >> 9) & 14) | 805306368, 508);
            pVar2.q(true);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new p7.n(z4, aVar, aVar2, aVar3, i2) { // from class: w5.r

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ boolean f10748f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ p7.a f10749g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ p7.a f10750h;

                /* renamed from: i, reason: collision with root package name */
                public final /* synthetic */ p7.a f10751i;

                @Override // p7.n
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iS = b0.b.s(49);
                    a0.a(this.f10748f, this.f10749g, this.f10750h, this.f10751i, (b0.p) obj, iS);
                    return c7.r.f1986a;
                }
            };
        }
    }

    public static final void b(a aVar, b0.p pVar, int i2) {
        long j2;
        long j4;
        long jB;
        b0.p pVar2 = pVar;
        pVar2.T(1501045167);
        if (((i2 | (pVar2.h(aVar) ? 4 : 2)) & 3) == 2 && pVar2.z()) {
            pVar2.O();
        } else {
            i0 i0VarA = g0.a(r.i.f8866a, n0.b.f6781o, pVar2, 48);
            int iHashCode = Long.hashCode(pVar2.Q);
            t1 t1VarL = pVar2.l();
            n0.m mVarV = a.a.V(pVar2, androidx.compose.foundation.layout.a.f744a);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            i1.f fVar = i1.g.f4477e;
            b0.b.q(pVar2, i0VarA, fVar);
            i1.f fVar2 = i1.g.f4476d;
            b0.b.q(pVar2, t1VarL, fVar2);
            i1.f fVar3 = i1.g.f4478f;
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar2, iHashCode, fVar3);
            }
            i1.f fVar4 = i1.g.f4475c;
            b0.b.q(pVar2, mVarV, fVar4);
            b bVar = aVar.f10662c;
            String str = aVar.f10663d;
            String str2 = aVar.f10660a;
            int i10 = z.$EnumSwitchMapping$0[bVar.ordinal()];
            long j10 = f10666a;
            long j11 = f10668c;
            switch (i10) {
                case 1:
                    j2 = j10;
                    break;
                case 2:
                case 3:
                    j2 = j11;
                    break;
                case 4:
                    j2 = f10667b;
                    break;
                case 5:
                    j2 = f10669d;
                    break;
                case 6:
                    j2 = f10670e;
                    break;
                case 7:
                    j2 = f10671f;
                    break;
                default:
                    throw new a4.u();
            }
            r.l.a(androidx.compose.foundation.a.a(androidx.compose.foundation.layout.a.g(androidx.compose.foundation.layout.a.f(n0.j.f6796a, 0.0f, 4, 0.0f, 0.0f, 13), 6), j2, t.e.f9649a), pVar2, 0);
            n7.m.b(pVar2, androidx.compose.foundation.layout.a.h(8));
            n0.m mVarA = j0.a();
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar2, 0);
            int iHashCode2 = Long.hashCode(pVar2.Q);
            t1 t1VarL2 = pVar2.l();
            n0.m mVarV2 = a.a.V(pVar2, mVarA);
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            b0.b.q(pVar2, rVarA, fVar);
            b0.b.q(pVar2, t1VarL2, fVar2);
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode2))) {
                a1.a.r(iHashCode2, pVar2, iHashCode2, fVar3);
            }
            b0.b.q(pVar2, mVarV2, fVar4);
            String str3 = str2;
            long j12 = j11;
            k0.a(aVar.f10661b, null, f10674i, s7.a.z(12), v1.k.f10359i, null, 0L, 0L, 0, false, 0, 0, null, pVar, 200064, 0, 131026);
            pVar2 = pVar;
            pVar2.S(-76285176);
            int length = str.length();
            v1.m mVar = v1.p.f10370c;
            boolean z4 = true;
            if (length > 0) {
                for (Iterator it = ga.k.D0(str, new String[]{"; "}, 6).iterator(); it.hasNext(); it = it) {
                    String str4 = (String) it.next();
                    boolean z10 = (ga.k.k0(str4, "OFFLINE", z4) || ga.k.k0(str4, "Exception", z4) || ga.k.k0(str4, "Fail", z4) || ga.k.k0(str4, "Error", z4)) ? z4 : false;
                    boolean zK0 = ga.k.k0(str4, "ONLINE", false);
                    String str5 = str3;
                    if (q7.k.a(str5, "WS_LAST_FAILURE") && z10) {
                        if (aVar.f10662c == b.WARNING) {
                            j4 = j12;
                            jB = u0.m.b(0.45f, j4);
                        }
                        j12 = j4;
                        str3 = str5;
                        k0.a(ga.k.N0(str4).toString(), null, jB, s7.a.z(10), null, mVar, 0L, 0L, 0, false, 3, 0, null, pVar, 3072, 3072, 122802);
                        z4 = z4;
                        pVar2 = pVar;
                    }
                    j4 = j12;
                    if (z10) {
                        jB = j4;
                    } else if (zK0) {
                        jB = j10;
                    } else {
                        boolean zA = q7.k.a(str5, "WS_LAST_FAILURE");
                        jB = f10675j;
                        if (zA) {
                            jB = u0.m.b(0.6f, jB);
                        }
                    }
                    j12 = j4;
                    str3 = str5;
                    k0.a(ga.k.N0(str4).toString(), null, jB, s7.a.z(10), null, mVar, 0L, 0L, 0, false, 3, 0, null, pVar, 3072, 3072, 122802);
                    z4 = z4;
                    pVar2 = pVar;
                }
            }
            boolean z11 = z4;
            pVar2.q(false);
            pVar2.q(z11);
            pVar2.S(-1630505699);
            long j13 = aVar.f10665f;
            if (j13 > 0) {
                k0.a(j13 + "ms", null, f10675j, s7.a.z(10), null, mVar, 0L, 0L, 0, false, 0, 0, null, pVar, 3456, 0, 130994);
                pVar2 = pVar;
            }
            pVar2.q(false);
            pVar2.q(z11);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.r(i2, 11, aVar);
        }
    }

    public static final void c(final c.i iVar, b0.p pVar, final int i2) {
        f1 f1Var;
        f1 f1Var2;
        f1 f1Var3;
        f1 f1Var4;
        Integer num;
        f1 f1Var5;
        l0.q qVar;
        f1 f1Var6;
        f1 f1Var7;
        final c.i iVar2;
        pVar.T(777101162);
        if ((((pVar.h(iVar) ? 4 : 2) | i2) & 3) == 2 && pVar.z()) {
            pVar.O();
            iVar2 = iVar;
        } else {
            pVar.S(2089217270);
            Object objJ = pVar.J();
            b1 b1Var = b0.k.f1229a;
            if (objJ == b1Var) {
                objJ = b0.b.n(null);
                pVar.b0(objJ);
            }
            f1 f1Var8 = (f1) objJ;
            pVar.q(false);
            pVar.S(2089219604);
            Object objJ2 = pVar.J();
            if (objJ2 == b1Var) {
                objJ2 = b0.b.n(null);
                pVar.b0(objJ2);
            }
            f1 f1Var9 = (f1) objJ2;
            pVar.q(false);
            pVar.S(2089222083);
            Object objJ3 = pVar.J();
            if (objJ3 == b1Var) {
                objJ3 = b0.b.n(Boolean.FALSE);
                pVar.b0(objJ3);
            }
            f1 f1Var10 = (f1) objJ3;
            pVar.q(false);
            pVar.S(2089223875);
            Object objJ4 = pVar.J();
            if (objJ4 == b1Var) {
                objJ4 = b0.b.n(Boolean.FALSE);
                pVar.b0(objJ4);
            }
            f1 f1Var11 = (f1) objJ4;
            pVar.q(false);
            pVar.S(2089225721);
            Object objJ5 = pVar.J();
            if (objJ5 == b1Var) {
                objJ5 = b0.b.n(null);
                pVar.b0(objJ5);
            }
            f1 f1Var12 = (f1) objJ5;
            pVar.q(false);
            pVar.S(2089228111);
            Object objJ6 = pVar.J();
            if (objJ6 == b1Var) {
                objJ6 = new l0.q();
                pVar.b0(objJ6);
            }
            l0.q qVar2 = (l0.q) objJ6;
            pVar.q(false);
            pVar.S(2089230175);
            Object objJ7 = pVar.J();
            if (objJ7 == b1Var) {
                objJ7 = b0.b.n(0);
                pVar.b0(objJ7);
            }
            f1 f1Var13 = (f1) objJ7;
            pVar.q(false);
            pVar.S(2089232000);
            Object objJ8 = pVar.J();
            if (objJ8 == b1Var) {
                objJ8 = b0.b.n("");
                pVar.b0(objJ8);
            }
            f1 f1Var14 = (f1) objJ8;
            pVar.q(false);
            pVar.S(2089233667);
            Object objJ9 = pVar.J();
            if (objJ9 == b1Var) {
                objJ9 = b0.b.n(Boolean.FALSE);
                pVar.b0(objJ9);
            }
            f1 f1Var15 = (f1) objJ9;
            pVar.q(false);
            pVar.S(2089235033);
            if (((Boolean) f1Var15.getValue()).booleanValue()) {
                e eVar = (e) f1Var12.getValue();
                pVar.S(2089237429);
                Object objJ10 = pVar.J();
                if (objJ10 == b1Var) {
                    objJ10 = new n(f1Var15, 0);
                    pVar.b0(objJ10);
                }
                pVar.q(false);
                e0.c(eVar, (p7.a) objJ10, pVar, 48);
                pVar.q(false);
                z1 z1VarS = pVar.s();
                if (z1VarS != null) {
                    final int i10 = 0;
                    z1VarS.f1444d = new p7.n(iVar, i2, i10) { // from class: w5.o

                        /* renamed from: f, reason: collision with root package name */
                        public final /* synthetic */ int f10738f;

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ c.i f10739g;

                        {
                            this.f10738f = i10;
                        }

                        @Override // p7.n
                        public final Object invoke(Object obj, Object obj2) {
                            int i11 = this.f10738f;
                            b0.p pVar2 = (b0.p) obj;
                            ((Integer) obj2).getClass();
                            switch (i11) {
                                case 0:
                                    a0.c(this.f10739g, pVar2, b0.b.s(1));
                                    break;
                                default:
                                    a0.c(this.f10739g, pVar2, b0.b.s(1));
                                    break;
                            }
                            return c7.r.f1986a;
                        }
                    };
                    return;
                }
                return;
            }
            pVar.q(false);
            pVar.S(2089241176);
            boolean zH = pVar.h(iVar);
            Object objJ11 = pVar.J();
            if (zH || objJ11 == b1Var) {
                f1Var = f1Var8;
                f1Var2 = f1Var9;
                f1Var3 = f1Var10;
                f1Var4 = f1Var15;
                m4.a0 a0Var = new m4.a0(iVar, f1Var2, f1Var, f1Var3, 1);
                pVar.b0(a0Var);
                objJ11 = a0Var;
            } else {
                f1Var4 = f1Var15;
                f1Var3 = f1Var10;
                f1Var = f1Var8;
                f1Var2 = f1Var9;
            }
            pVar.q(false);
            b0.b.d(c7.r.f1986a, (p7.k) objJ11, pVar);
            AgentBusService agentBusService = (AgentBusService) f1Var2.getValue();
            pVar.S(2089266889);
            Object objJ12 = pVar.J();
            if (objJ12 == b1Var) {
                f1 f1Var16 = f1Var3;
                f1 f1Var17 = f1Var;
                objJ12 = new f2(f1Var2, f1Var16, f1Var17, null, 21);
                f1Var3 = f1Var16;
                f1Var = f1Var17;
                pVar.b0(objJ12);
            }
            pVar.q(false);
            b0.b.e(pVar, agentBusService, (p7.n) objJ12);
            Integer numValueOf = Integer.valueOf(((Boolean) f1Var3.getValue()).booleanValue() ? ((Number) f1Var13.getValue()).intValue() : -1);
            pVar.S(2089280244);
            boolean zH2 = pVar.h(iVar);
            Object objJ13 = pVar.J();
            if (zH2 || objJ13 == b1Var) {
                f1 f1Var18 = f1Var3;
                num = numValueOf;
                f1Var5 = f1Var14;
                z2 z2Var = new z2(qVar2, f1Var, f1Var18, f1Var11, f1Var12, f1Var5, iVar, null);
                qVar = qVar2;
                f1Var6 = f1Var11;
                f1Var3 = f1Var18;
                f1Var7 = f1Var12;
                pVar.b0(z2Var);
                objJ13 = z2Var;
            } else {
                f1Var6 = f1Var11;
                f1Var7 = f1Var12;
                qVar = qVar2;
                f1Var5 = f1Var14;
                num = numValueOf;
            }
            pVar.q(false);
            b0.b.e(pVar, num, (p7.n) objJ13);
            iVar2 = iVar;
            y.i0.a(androidx.compose.foundation.layout.a.f745b, null, f10672g, j0.i.d(-1229862929, new t(qVar, iVar, f1Var7, f1Var6, f1Var3, f1Var5, f1Var4, f1Var13), pVar), pVar, 12583302, 122);
        }
        z1 z1VarS2 = pVar.s();
        if (z1VarS2 != null) {
            final int i11 = 1;
            z1VarS2.f1444d = new p7.n(iVar2, i2, i11) { // from class: w5.o

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ int f10738f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ c.i f10739g;

                {
                    this.f10738f = i11;
                }

                @Override // p7.n
                public final Object invoke(Object obj, Object obj2) {
                    int i112 = this.f10738f;
                    b0.p pVar2 = (b0.p) obj;
                    ((Integer) obj2).getClass();
                    switch (i112) {
                        case 0:
                            a0.c(this.f10739g, pVar2, b0.b.s(1));
                            break;
                        default:
                            a0.c(this.f10739g, pVar2, b0.b.s(1));
                            break;
                    }
                    return c7.r.f1986a;
                }
            };
        }
    }

    public static final void d(int i2, b0.p pVar) {
        b0.p pVar2 = pVar;
        pVar2.T(2036816437);
        if (i2 == 0 && pVar2.z()) {
            pVar2.O();
        } else {
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6784r, pVar2, 0);
            int iHashCode = Long.hashCode(pVar2.Q);
            t1 t1VarL = pVar2.l();
            n0.m mVarV = a.a.V(pVar2, n0.j.f6796a);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            b0.b.q(pVar2, rVarA, i1.g.f4477e);
            b0.b.q(pVar2, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar2, iHashCode, fVar);
            }
            b0.b.q(pVar2, mVarV, i1.g.f4475c);
            k0.a("连接诊断", null, f10674i, s7.a.z(22), v1.k.f10360j, null, 0L, 0L, 0, false, 0, 0, null, pVar, 200070, 0, 131026);
            k0.a("全链路自动化检测 · AgentBus → Cloud Claw", null, f10675j, s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar, 3462, 0, 131058);
            pVar2 = pVar;
            pVar2.q(true);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new s1.t(i2, 8);
        }
    }

    public static final void e(String str, String str2, b0.p pVar, int i2) {
        b0.p pVar2 = pVar;
        pVar2.T(-1335686310);
        int i10 = i2 | (pVar2.f(str2) ? 32 : 16);
        if ((i10 & 19) == 18 && pVar2.z()) {
            pVar2.O();
        } else {
            r.r rVarA = r.p.a(r.i.f8867b, n0.b.f6785s, pVar2, 48);
            int iHashCode = Long.hashCode(pVar2.Q);
            t1 t1VarL = pVar2.l();
            n0.m mVarV = a.a.V(pVar2, n0.j.f6796a);
            i1.h.f4488c.getClass();
            i1.y yVar = i1.g.f4474b;
            pVar2.U();
            if (pVar2.P) {
                pVar2.k(yVar);
            } else {
                pVar2.e0();
            }
            b0.b.q(pVar2, rVarA, i1.g.f4477e);
            b0.b.q(pVar2, t1VarL, i1.g.f4476d);
            i1.f fVar = i1.g.f4478f;
            if (pVar2.P || !q7.k.a(pVar2.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar2, iHashCode, fVar);
            }
            b0.b.q(pVar2, mVarV, i1.g.f4475c);
            k0.a(str, null, f10675j, s7.a.z(9), v1.k.f10359i, null, 0L, 0L, 0, false, 0, 0, null, pVar2, 200070, 0, 131026);
            k0.a(str2, null, f10674i, s7.a.z(11), null, v1.p.f10370c, 0L, 0L, 0, false, 0, 0, null, pVar, ((i10 >> 3) & 14) | 3456, 0, 130994);
            pVar2 = pVar;
            pVar2.q(true);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.y(i2, 2, str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(w5.b0 r8, java.util.ArrayList r9, b0.p r10, int r11) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.a0.f(w5.b0, java.util.ArrayList, b0.p, int):void");
    }

    public static final void g(b bVar, b0.p pVar, int i2) {
        c7.j jVar;
        b0.p pVar2;
        pVar.T(917185090);
        if ((((pVar.f(bVar) ? 4 : 2) | i2) & 3) == 2 && pVar.z()) {
            pVar.O();
            pVar2 = pVar;
        } else {
            switch (z.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    jVar = new c7.j(new u0.m(f10666a), "通过");
                    break;
                case 2:
                case 3:
                    jVar = new c7.j(new u0.m(f10668c), "失败");
                    break;
                case 4:
                    jVar = new c7.j(new u0.m(f10667b), "警告");
                    break;
                case 5:
                    jVar = new c7.j(new u0.m(f10669d), "跳过");
                    break;
                case 6:
                    jVar = new c7.j(new u0.m(f10670e), "检测中");
                    break;
                case 7:
                    jVar = new c7.j(new u0.m(f10671f), "等待");
                    break;
                default:
                    throw new a4.u();
            }
            long j2 = ((u0.m) jVar.f1973f).f9918a;
            pVar2 = pVar;
            y.i0.a(null, t.e.a(4), u0.m.b(0.12f, j2), j0.i.d(-990161571, new w((String) jVar.f1974g, j2), pVar), pVar2, 12582912, 121);
        }
        z1 z1VarS = pVar2.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new b0.r(i2, 10, bVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static final void h(int i2, b0.p pVar) {
        Object objN;
        pVar.T(-183665489);
        if (i2 == 0 && pVar.z()) {
            pVar.O();
        } else {
            String str = "1.0.26_20260925_135026" instanceof c7.l ? "?" : "1.0.26_20260925_135026";
            try {
                objN = 100026;
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            if (objN instanceof c7.l) {
                objN = 0;
            }
            int iIntValue = ((Number) objN).intValue();
            int iMyPid = Process.myPid();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartUptimeMillis();
            long j2 = Runtime.getRuntime().totalMemory();
            long j4 = NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
            y.i0.a(null, t.e.a(10), f10673h, j0.i.d(1586839626, new x(str, iIntValue, iMyPid, jElapsedRealtime, (j2 / j4) / j4), pVar), pVar, 12583296, 121);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new s1.t(i2, 9);
        }
    }

    public static final void i(final e eVar, final boolean z4, final boolean z10, final String str, final List list, p7.a aVar, b0.p pVar, final int i2) {
        p7.a aVar2;
        pVar.T(1138196444);
        if (((i2 | (pVar.h(eVar) ? 4 : 2) | (pVar.g(z4) ? 32 : 16) | (pVar.g(z10) ? 256 : 128) | (pVar.f(str) ? 2048 : NanoHTTPD.HTTPSession.MAX_HEADER_SIZE)) & 74899) == 74898 && pVar.z()) {
            pVar.O();
            aVar2 = aVar;
        } else {
            t.d dVarA = t.e.a(12);
            boolean z11 = eVar != null;
            pVar.S(748355801);
            Object objJ = pVar.J();
            if (objJ == b0.k.f1229a) {
                aVar2 = aVar;
                objJ = new p(aVar2, 0);
                pVar.b0(objJ);
            } else {
                aVar2 = aVar;
            }
            pVar.q(false);
            y.i0.a(androidx.compose.foundation.a.c(n0.j.f6796a, z11, (p7.a) objJ, 6), dVarA, f10673h, j0.i.d(-1955296799, new y(str, list, z10, z4, eVar), pVar), pVar, 12583296, 120);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            final p7.a aVar3 = aVar2;
            z1VarS.f1444d = new p7.n(z4, z10, str, list, aVar3, i2) { // from class: w5.q

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ boolean f10743g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ boolean f10744h;

                /* renamed from: i, reason: collision with root package name */
                public final /* synthetic */ String f10745i;

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ List f10746j;

                /* renamed from: k, reason: collision with root package name */
                public final /* synthetic */ p7.a f10747k;

                @Override // p7.n
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iS = b0.b.s(221185);
                    a0.i(this.f10742f, this.f10743g, this.f10744h, this.f10745i, this.f10746j, this.f10747k, (b0.p) obj, iS);
                    return c7.r.f1986a;
                }
            };
        }
    }

    public static final void j(List list, e eVar) {
        ga.d dVar = new ga.d(k(list, eVar));
        while (dVar.hasNext()) {
            Log.i("DiagnosticScreen", (String) dVar.next());
        }
    }

    public static final String k(List list, e eVar) {
        StringBuilder sb2 = new StringBuilder("=== AgentBus 连接诊断报告 ===\n");
        sb2.append("时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "\n");
        sb2.append("PID: " + Process.myPid() + "\n");
        sb2.append("\n");
        if (eVar != null) {
            sb2.append("[诊断结论] " + eVar.f10692c + "\n");
            int i2 = 0;
            for (Object obj : eVar.f10693d) {
                int i10 = i2 + 1;
                if (i2 < 0) {
                    d7.s.z0();
                    throw null;
                }
                sb2.append("  建议" + i10 + ": " + ((String) obj) + "\n");
                i2 = i10;
            }
            sb2.append("\n");
        }
        sb2.append("[检测详情]\n");
        for (b0 b0Var : f10676k) {
            sb2.append("  -- Phase " + b0Var.f10677a + ": " + b0Var.f10678b + " --\n");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (b0Var.f10679c.contains(((a) obj2).f10660a)) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                int i11 = z.$EnumSwitchMapping$0[aVar.f10662c.ordinal()];
                String str = i11 != 1 ? (i11 == 2 || i11 == 3) ? "[FAIL]" : i11 != 4 ? i11 != 5 ? "[?]" : "[SKIP]" : "[WARN]" : "[OK]";
                String str2 = aVar.f10661b;
                String str3 = aVar.f10663d;
                StringBuilder sbP = a1.a.p("  ", str, " ", str2, ": ");
                sbP.append(str3);
                sbP.append("\n");
                sb2.append(sbP.toString());
            }
        }
        sb2.append("=============================\n");
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }
}
