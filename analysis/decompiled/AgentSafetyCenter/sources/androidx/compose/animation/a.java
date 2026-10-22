package androidx.compose.animation;

import androidx.lifecycle.l0;
import androidx.recyclerview.widget.RecyclerView;
import b0.n;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;
import jb.v;
import k0.c1;
import k0.k1;
import k0.o2;
import k0.s;
import k0.v1;
import k0.z;
import o2.k;
import p5.u;
import r.a0;
import r.c0;
import r.e;
import r.h0;
import r.i0;
import r.o;
import r.q0;
import r.r;
import r.t;
import r.w;
import r.x;
import s.e1;
import s.g1;
import s.i1;
import s.y0;
import s0.c;
import s0.g;
import u1.h;
import u1.i;
import w0.j;
import w0.m;
import xb.l;
import xb.p;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final void a(e1 e1Var, l lVar, m mVar, h0 h0Var, i0 i0Var, p pVar, c cVar, s sVar, int i) {
        int i3;
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        h0 h0Var2;
        e1 e1Var2;
        Object obj;
        y0 y0VarA;
        y0 y0Var;
        boolean z12;
        boolean z13;
        y0 y0VarA2;
        boolean z14;
        k1 k1Var = e1Var.f10992d;
        sVar.Z(-891967166);
        if ((i & 6) == 0) {
            i3 = (sVar.f(e1Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(lVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.f(h0Var) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= sVar.f(i0Var) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= sVar.h(pVar) ? 131072 : 65536;
        }
        int i12 = i3 | 1572864;
        if ((12582912 & i) == 0) {
            i12 |= sVar.h(cVar) ? 8388608 : 4194304;
        }
        int i13 = i12;
        if ((4793491 & i13) == 4793490 && sVar.B()) {
            sVar.S();
        } else if (((Boolean) lVar.invoke(k1Var.getValue())).booleanValue() || ((Boolean) lVar.invoke(e1Var.c())).booleanValue() || e1Var.g() || e1Var.d()) {
            sVar.X(1787977937);
            int i14 = i13 & 14;
            int i15 = i14 | 48;
            int i16 = i15 & 14;
            boolean z15 = ((i16 ^ 6) > 4 && sVar.f(e1Var)) || (i15 & 6) == 4;
            Object objM = sVar.M();
            Object obj2 = k0.m.f6974a;
            if (z15 || objM == obj2) {
                objM = e1Var.c();
                sVar.i0(objM);
            }
            if (e1Var.g()) {
                objM = e1Var.c();
            }
            sVar.X(-466616829);
            w wVarD = d(e1Var, lVar, objM, sVar);
            sVar.q(false);
            Object value = k1Var.getValue();
            sVar.X(-466616829);
            w wVarD2 = d(e1Var, lVar, value, sVar);
            sVar.q(false);
            int i17 = i16 | 3072;
            int i18 = g1.f11015a;
            int i19 = (i17 & 14) ^ 6;
            boolean z16 = (i19 > 4 && sVar.f(e1Var)) || (i17 & 6) == 4;
            Object objM2 = sVar.M();
            if (z16 || objM2 == obj2) {
                i10 = i17;
                i11 = i13;
                objM2 = new e1(new u(wVarD), e1Var, e1Var.f10991c.concat(" > EnterExitTransition"));
                sVar.i0(objM2);
            } else {
                i10 = i17;
                i11 = i13;
            }
            e1 e1Var3 = (e1) objM2;
            boolean zF = ((i19 > 4 && sVar.f(e1Var)) || (i10 & 6) == 4) | sVar.f(e1Var3);
            Object objM3 = sVar.M();
            if (zF || objM3 == obj2) {
                objM3 = new n(16, e1Var, e1Var3);
                sVar.i0(objM3);
            }
            z.d(e1Var3, (l) objM3, sVar);
            if (e1Var.g()) {
                e1Var3.k(wVarD, wVarD2);
            } else {
                e1Var3.l(wVarD2);
                e1Var3.f10998k.setValue(Boolean.FALSE);
            }
            Object objZ = z.z(pVar, sVar);
            Object objC = e1Var3.c();
            k1 k1Var2 = e1Var3.f10992d;
            Object objInvoke = pVar.invoke(objC, k1Var2.getValue());
            boolean zF2 = sVar.f(e1Var3) | sVar.f(objZ);
            Object objM4 = sVar.M();
            int i20 = 18;
            nb.c cVar2 = null;
            if (zF2 || objM4 == obj2) {
                objM4 = new l0(e1Var3, objZ, cVar2, i20);
                sVar.i0(objM4);
            }
            p pVar2 = (p) objM4;
            Object objM5 = sVar.M();
            if (objM5 == obj2) {
                objM5 = z.v(objInvoke);
                sVar.i0(objM5);
            }
            c1 c1Var = (c1) objM5;
            boolean zH = sVar.h(pVar2);
            Object objM6 = sVar.M();
            if (zH || objM6 == obj2) {
                objM6 = new o2(pVar2, c1Var, null, 0);
                sVar.i0(objM6);
            }
            z.h(v.f6774a, sVar, (p) objM6);
            Object objC2 = e1Var3.c();
            w wVar = w.f10350g;
            if (objC2 == wVar && k1Var2.getValue() == wVar && ((Boolean) c1Var.getValue()).booleanValue()) {
                sVar.X(1790256282);
                z14 = false;
                sVar.q(false);
            } else {
                sVar.X(1788869559);
                boolean z17 = i14 == 4;
                Object objM7 = sVar.M();
                Object obj3 = objM7;
                if (z17 || objM7 == obj2) {
                    t tVar = new t();
                    tVar.f10342a = z.v(k.a(0L));
                    VarHandle.storeStoreFence();
                    sVar.i0(tVar);
                    obj3 = tVar;
                }
                t tVar2 = (t) obj3;
                n6.a aVar = c0.f10254a;
                boolean zF3 = sVar.f(e1Var3);
                Object objM8 = sVar.M();
                if (zF3 || objM8 == obj2) {
                    objM8 = z.v(h0Var);
                    sVar.i0(objM8);
                }
                c1 c1Var2 = (c1) objM8;
                Object objC3 = e1Var3.c();
                Object value2 = k1Var2.getValue();
                w wVar2 = w.f10349f;
                if (objC3 == value2 && e1Var3.c() == wVar2) {
                    if (e1Var3.g()) {
                        c1Var2.setValue(h0Var);
                    } else {
                        c1Var2.setValue(h0.f10296b);
                    }
                } else if (k1Var2.getValue() == wVar2) {
                    c1Var2.setValue(((h0) c1Var2.getValue()).a(h0Var));
                }
                h0 h0Var3 = (h0) c1Var2.getValue();
                boolean zF4 = sVar.f(e1Var3);
                Object objM9 = sVar.M();
                if (zF4 || objM9 == obj2) {
                    objM9 = z.v(i0Var);
                    sVar.i0(objM9);
                }
                c1 c1Var3 = (c1) objM9;
                if (e1Var3.c() == k1Var2.getValue() && e1Var3.c() == wVar2) {
                    if (e1Var3.g()) {
                        c1Var3.setValue(i0Var);
                    } else {
                        c1Var3.setValue(i0.f10304b);
                    }
                } else if (k1Var2.getValue() != wVar2) {
                    c1Var3.setValue(((i0) c1Var3.getValue()).a(i0Var));
                }
                i0 i0Var2 = (i0) c1Var3.getValue();
                boolean z18 = (h0Var3.f10297a.f10338b == null && i0Var2.f10306a.f10338b == null) ? false : true;
                q0 q0Var = i0Var2.f10306a;
                if (z18) {
                    sVar.X(-821375963);
                    n6.a aVar2 = i1.f11032g;
                    Object objM10 = sVar.M();
                    if (objM10 == obj2) {
                        objM10 = "Built-in slide";
                        sVar.i0("Built-in slide");
                    }
                    e1Var2 = e1Var3;
                    obj = obj2;
                    h0Var2 = h0Var3;
                    z10 = true;
                    y0VarA = g1.a(e1Var2, aVar2, (String) objM10, sVar, 384, 0);
                    z11 = false;
                    sVar.q(false);
                } else {
                    z10 = true;
                    z11 = false;
                    h0Var2 = h0Var3;
                    e1Var2 = e1Var3;
                    obj = obj2;
                    sVar.X(-821278096);
                    sVar.q(false);
                    y0VarA = null;
                }
                sVar.X(-821099041);
                sVar.q(z11);
                sVar.X(-820883777);
                sVar.q(z11);
                boolean z19 = false ^ z10;
                if ((h0Var2.f10297a.f10337a == null && i0Var2.f10306a.f10337a == null) ? false : z10) {
                    sVar.X(-675389204);
                    n6.a aVar3 = i1.f11026a;
                    Object objM11 = sVar.M();
                    if (objM11 == obj) {
                        objM11 = "Built-in alpha";
                        sVar.i0("Built-in alpha");
                    }
                    y0Var = y0VarA;
                    z12 = z19;
                    y0VarA2 = g1.a(e1Var2, aVar3, (String) objM11, sVar, 384, 0);
                    z13 = false;
                    sVar.q(false);
                } else {
                    y0Var = y0VarA;
                    z12 = z19;
                    z13 = false;
                    sVar.X(-675252433);
                    sVar.q(false);
                    y0VarA2 = null;
                }
                sVar.X(-675057009);
                sVar.q(z13);
                sVar.X(-674835793);
                sVar.q(z13);
                boolean zH2 = sVar.h(y0VarA2) | sVar.f(h0Var2) | sVar.f(i0Var2) | sVar.h(null) | sVar.f(e1Var2) | sVar.h(null);
                Object objM12 = sVar.M();
                Object obj4 = objM12;
                if (zH2 || objM12 == obj) {
                    x xVar = new x();
                    xVar.f10352a = y0VarA2;
                    xVar.f10353b = null;
                    xVar.f10354c = e1Var2;
                    xVar.f10355d = h0Var2;
                    xVar.f10356e = i0Var2;
                    xVar.f10357f = null;
                    VarHandle.storeStoreFence();
                    sVar.i0(xVar);
                    obj4 = xVar;
                }
                x xVar2 = (x) obj4;
                boolean zG = sVar.g(z12);
                r.z zVar = r.z.f10361c;
                boolean zF5 = zG | sVar.f(zVar);
                Object objM13 = sVar.M();
                if (zF5 || objM13 == obj) {
                    objM13 = new a0(z12, zVar);
                    sVar.i0(objM13);
                }
                j jVar = j.f15113c;
                m mVarA = androidx.compose.ui.graphics.a.a(jVar, (l) objM13);
                EnterExitTransitionElement enterExitTransitionElement = new EnterExitTransitionElement();
                enterExitTransitionElement.f829c = e1Var2;
                enterExitTransitionElement.f830f = null;
                enterExitTransitionElement.f831g = null;
                enterExitTransitionElement.f832h = y0Var;
                enterExitTransitionElement.i = h0Var2;
                enterExitTransitionElement.f833j = i0Var2;
                enterExitTransitionElement.f834k = zVar;
                enterExitTransitionElement.f835l = xVar2;
                VarHandle.storeStoreFence();
                m mVarD = mVarA.d(enterExitTransitionElement);
                sVar.X(1581766416);
                sVar.q(false);
                m mVarD2 = mVar.d(mVarD.d(jVar));
                Object objM14 = sVar.M();
                Object obj5 = objM14;
                if (objM14 == obj) {
                    o oVar = new o();
                    oVar.f10323a = tVar2;
                    VarHandle.storeStoreFence();
                    sVar.i0(oVar);
                    obj5 = oVar;
                }
                o oVar2 = (o) obj5;
                int iHashCode = Long.hashCode(sVar.T);
                g gVarL = sVar.l();
                m mVarM = t.o.m(sVar, mVarD2);
                u1.j.f13840e.getClass();
                xb.a aVar4 = i.f13833b;
                sVar.b0();
                if (sVar.S) {
                    sVar.k(aVar4);
                } else {
                    sVar.l0();
                }
                z.B(oVar2, sVar, i.f13836e);
                z.B(gVarL, sVar, i.f13835d);
                h hVar = i.f13837f;
                if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                    k0.a.y(iHashCode, sVar, iHashCode, hVar);
                }
                z.B(mVarM, sVar, i.f13834c);
                cVar.invoke(tVar2, sVar, Integer.valueOf((i11 >> 18) & 112));
                sVar.q(true);
                z14 = false;
                sVar.q(false);
            }
            sVar.q(z14);
        } else {
            sVar.X(1790262234);
            sVar.q(false);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r.p(e1Var, lVar, mVar, h0Var, i0Var, pVar, cVar, i);
        }
    }

    public static final void b(boolean z10, m mVar, h0 h0Var, i0 i0Var, String str, c cVar, s sVar, int i, int i3) {
        int i10;
        c cVar2;
        m mVar2;
        String str2;
        sVar.Z(2088733774);
        if ((i & 6) == 0) {
            i10 = (sVar.g(z10) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= sVar.f(mVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= sVar.f(h0Var) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i10 |= sVar.f(i0Var) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        int i12 = i10 | 24576;
        if ((196608 & i) == 0) {
            cVar2 = cVar;
            i12 |= sVar.h(cVar2) ? 131072 : 65536;
        } else {
            cVar2 = cVar;
        }
        if ((74899 & i12) == 74898 && sVar.B()) {
            sVar.S();
            mVar2 = mVar;
            str2 = str;
        } else {
            if (i11 != 0) {
                mVar = j.f15113c;
            }
            m mVar3 = mVar;
            int i13 = i12 << 3;
            c(g1.b(Boolean.valueOf(z10), "AnimatedVisibility", sVar, (i12 & 14) | ((i12 >> 9) & 112)), mVar3, h0Var, i0Var, cVar2, sVar, (i13 & 57344) | (i13 & 896) | 48 | (i13 & 7168) | (i12 & 458752));
            mVar2 = mVar3;
            str2 = "AnimatedVisibility";
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.m(z10, mVar2, h0Var, i0Var, str2, cVar, i, i3);
        }
    }

    public static final void c(e1 e1Var, m mVar, h0 h0Var, i0 i0Var, c cVar, s sVar, int i) {
        int i3;
        h0 h0Var2;
        i0 i0Var2;
        c cVar2;
        r.c cVar3 = r.c.f10249g;
        sVar.Z(429978603);
        if ((i & 6) == 0) {
            i3 = (sVar.f(e1Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(cVar3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            h0Var2 = h0Var;
            i3 |= sVar.f(h0Var2) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        } else {
            h0Var2 = h0Var;
        }
        if ((i & 24576) == 0) {
            i0Var2 = i0Var;
            i3 |= sVar.f(i0Var2) ? 16384 : 8192;
        } else {
            i0Var2 = i0Var;
        }
        if ((i & 196608) == 0) {
            cVar2 = cVar;
            i3 |= sVar.h(cVar2) ? 131072 : 65536;
        } else {
            cVar2 = cVar;
        }
        if ((74899 & i3) == 74898 && sVar.B()) {
            sVar.S();
        } else {
            int i10 = i3 & 112;
            int i11 = i3 & 14;
            boolean z10 = (i10 == 32) | (i11 == 4);
            Object objM = sVar.M();
            if (z10 || objM == k0.m.f6974a) {
                objM = new e(e1Var, 1);
                sVar.i0(objM);
            }
            a(e1Var, cVar3, androidx.compose.ui.layout.a.a(mVar, (q) objM), h0Var2, i0Var2, r.f10341c, cVar2, sVar, i11 | 196608 | i10 | (i3 & 7168) | (57344 & i3) | ((i3 << 6) & 29360128));
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r.i(e1Var, mVar, h0Var, i0Var, cVar, i, 1);
        }
    }

    public static final w d(e1 e1Var, l lVar, Object obj, s sVar) {
        sVar.T(e1Var, -902048200, 0, null);
        boolean zG = e1Var.g();
        w wVar = w.f10348c;
        w wVar2 = w.f10350g;
        w wVar3 = w.f10349f;
        if (zG) {
            sVar.X(2101296683);
            sVar.q(false);
            if (((Boolean) lVar.invoke(obj)).booleanValue()) {
                wVar = wVar3;
            } else if (((Boolean) lVar.invoke(e1Var.c())).booleanValue()) {
                wVar = wVar2;
            }
        } else {
            sVar.X(2101530516);
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = z.v(Boolean.FALSE);
                sVar.i0(objM);
            }
            c1 c1Var = (c1) objM;
            if (((Boolean) lVar.invoke(e1Var.c())).booleanValue()) {
                c1Var.setValue(Boolean.TRUE);
            }
            if (((Boolean) lVar.invoke(obj)).booleanValue()) {
                wVar = wVar3;
            } else if (((Boolean) c1Var.getValue()).booleanValue()) {
                wVar = wVar2;
            }
            sVar.q(false);
        }
        sVar.q(false);
        return wVar;
    }
}
