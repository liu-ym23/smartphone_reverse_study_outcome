package androidx.compose.animation;

import b0.b1;
import b0.f1;
import b0.k;
import b0.p;
import b0.z1;
import c1.w;
import fi.iki.elonen.NanoHTTPD;
import j0.d;
import m.f;
import m.g;
import m.h;
import m.n;
import m.y;
import m.z;
import n.e1;
import n0.j;
import n0.m;
import p7.o;
import q6.b;

/* loaded from: classes.dex */
public abstract class a {
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(n.b1 r28, n0.m r29, m.y r30, m.z r31, j0.d r32, b0.p r33, int r34) {
        /*
            Method dump skipped, instructions count: 1227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.a.a(n.b1, n0.m, m.y, m.z, j0.d, b0.p, int):void");
    }

    public static final void b(boolean z4, m mVar, y yVar, z zVar, String str, d dVar, p pVar, int i2) {
        m mVar2;
        String str2;
        pVar.T(1766503102);
        int i10 = i2 | (pVar.g(z4) ? 32 : 16) | 196992;
        if ((599185 & i10) == 599184 && pVar.z()) {
            pVar.O();
            mVar2 = mVar;
            str2 = str;
        } else {
            Boolean boolValueOf = Boolean.valueOf(z4);
            int i11 = ((i10 >> 3) & 14) | 48;
            int i12 = e1.f6605a;
            Object objJ = pVar.J();
            b1 b1Var = k.f1229a;
            if (objJ == b1Var) {
                objJ = new n.b1("AnimatedVisibility", null, new b(boolValueOf));
                pVar.b0(objJ);
            }
            n.b1 b1Var2 = (n.b1) objJ;
            b1Var2.a(boolValueOf, pVar, (i11 & 14) | 48);
            Object objJ2 = pVar.J();
            if (objJ2 == b1Var) {
                objJ2 = new w(19, b1Var2);
                pVar.b0(objJ2);
            }
            b0.b.d(b1Var2, (p7.k) objJ2, pVar);
            c(b1Var2, yVar, zVar, dVar, pVar, 224688);
            mVar2 = j.f6796a;
            str2 = "AnimatedVisibility";
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new g(z4, mVar2, yVar, zVar, str2, dVar, i2);
        }
    }

    public static final void c(n.b1 b1Var, y yVar, z zVar, d dVar, p pVar, int i2) {
        int i10;
        f fVar = f.f6059h;
        pVar.T(429978603);
        if ((i2 & 6) == 0) {
            i10 = (pVar.f(b1Var) ? 4 : 2) | i2;
        } else {
            i10 = i2;
        }
        if ((i2 & 48) == 0) {
            i10 |= pVar.h(fVar) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i10 |= pVar.f(j.f6796a) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i10 |= pVar.f(yVar) ? 2048 : NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        }
        if ((i2 & 24576) == 0) {
            i10 |= pVar.f(zVar) ? 16384 : NanoHTTPD.HTTPSession.BUFSIZE;
        }
        if ((i2 & 196608) == 0) {
            i10 |= pVar.h(dVar) ? 131072 : 65536;
        }
        if ((74899 & i10) == 74898 && pVar.z()) {
            pVar.O();
        } else {
            int i11 = i10 & 112;
            int i12 = i10 & 14;
            boolean z4 = (i11 == 32) | (i12 == 4);
            Object objJ = pVar.J();
            if (z4 || objJ == k.f1229a) {
                objJ = new h(b1Var);
                pVar.b0(objJ);
            }
            a(b1Var, androidx.compose.ui.layout.a.a((o) objJ), yVar, zVar, dVar, pVar, 196608 | i12 | i11 | (i10 & 7168) | (57344 & i10) | ((i10 << 6) & 29360128));
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new m.j(b1Var, yVar, zVar, dVar, i2);
        }
    }

    public static final n d(n.b1 b1Var, Object obj, p pVar) {
        pVar.P(-902048200, b1Var, 0, null);
        boolean zG = b1Var.g();
        n nVar = n.f6080f;
        n nVar2 = n.f6082h;
        n nVar3 = n.f6081g;
        if (zG) {
            pVar.S(2101296683);
            pVar.q(false);
            Boolean bool = (Boolean) obj;
            bool.booleanValue();
            if (bool.booleanValue()) {
                nVar = nVar3;
            } else {
                Boolean bool2 = (Boolean) b1Var.c();
                bool2.booleanValue();
                if (bool2.booleanValue()) {
                    nVar = nVar2;
                }
            }
        } else {
            pVar.S(2101530516);
            Object objJ = pVar.J();
            if (objJ == k.f1229a) {
                objJ = b0.b.n(Boolean.FALSE);
                pVar.b0(objJ);
            }
            f1 f1Var = (f1) objJ;
            Boolean bool3 = (Boolean) b1Var.c();
            bool3.booleanValue();
            if (bool3.booleanValue()) {
                f1Var.setValue(Boolean.TRUE);
            }
            Boolean bool4 = (Boolean) obj;
            bool4.booleanValue();
            if (bool4.booleanValue()) {
                nVar = nVar3;
            } else if (((Boolean) f1Var.getValue()).booleanValue()) {
                nVar = nVar2;
            }
            pVar.q(false);
        }
        pVar.q(false);
        return nVar;
    }
}
