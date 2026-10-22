package pd;

import a9.n;
import hc.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kb.l;
import kb.w;
import kb.x;
import od.c0;
import od.f0;
import od.z;
import xb.p;
import yb.q;
import yb.t;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9998a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' <= c9 && c9 < 'G') {
            return c9 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c9);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = z.f9497f;
        z zVarN = f8.b.n("/");
        jb.g[] gVarArr = {new jb.g(zVarN, new g(zVarN, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.L(1));
        w.O(linkedHashMap, gVarArr);
        for (g gVar : l.I0(arrayList, new n(5))) {
            if (((g) linkedHashMap.put(gVar.f10013a, gVar)) == null) {
                while (true) {
                    z zVar = gVar.f10013a;
                    z zVarB = zVar.b();
                    if (zVarB != null) {
                        g gVar2 = (g) linkedHashMap.get(zVarB);
                        if (gVar2 != null) {
                            gVar2.f10028q.add(zVar);
                            break;
                        }
                        g gVar3 = new g(zVarB, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        linkedHashMap.put(zVarB, gVar3);
                        gVar3.f10028q.add(zVar);
                        gVar = gVar3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final String c(int i) {
        com.stepos.statsrpk.h.f(16);
        String string = Integer.toString(i, 16);
        string.getClass();
        return "0x".concat(string);
    }

    public static final g d(c0 c0Var) throws IOException {
        int iO = c0Var.o();
        if (iO != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iO));
        }
        c0Var.M(4L);
        short sC = c0Var.C();
        int i = sC & 65535;
        if ((sC & 1) != 0) {
            od.f.l("unsupported zip: general purpose bit flag=".concat(c(i)));
            return null;
        }
        int iC = c0Var.C() & 65535;
        int iC2 = c0Var.C() & 65535;
        int iC3 = c0Var.C() & 65535;
        long jO = c0Var.o() & 4294967295L;
        t tVar = new t();
        tVar.f16097c = c0Var.o() & 4294967295L;
        t tVar2 = new t();
        tVar2.f16097c = c0Var.o() & 4294967295L;
        int iC4 = c0Var.C() & 65535;
        int iC5 = c0Var.C() & 65535;
        int iC6 = c0Var.C() & 65535;
        c0Var.M(8L);
        t tVar3 = new t();
        tVar3.f16097c = c0Var.o() & 4294967295L;
        String strF = c0Var.F(iC4);
        if (hc.h.Y(strF, (char) 0)) {
            od.f.l("bad zip: filename contains 0x00");
            return null;
        }
        long j10 = tVar2.f16097c == 4294967295L ? 8 : 0L;
        if (tVar.f16097c == 4294967295L) {
            j10 += 8;
        }
        if (tVar3.f16097c == 4294967295L) {
            j10 += 8;
        }
        long j11 = j10;
        u uVar = new u();
        u uVar2 = new u();
        u uVar3 = new u();
        q qVar = new q();
        e(c0Var, iC5, new i(qVar, j11, tVar2, c0Var, tVar, tVar3, uVar, uVar2, uVar3));
        if (j11 > 0 && !qVar.f16094c) {
            od.f.l("bad zip: zip64 extra required but absent");
            return null;
        }
        String strF2 = c0Var.F(iC6);
        String str = z.f9497f;
        return new g(f8.b.n("/").d(strF), o.P(strF, "/", false), strF2, jO, tVar.f16097c, tVar2.f16097c, iC, tVar3.f16097c, iC3, iC2, (Long) uVar.f16098c, (Long) uVar2.f16098c, (Long) uVar3.f16098c, 57344);
    }

    public static final void e(c0 c0Var, int i, p pVar) throws IOException {
        od.i iVar = c0Var.f9428f;
        long j10 = i;
        while (j10 != 0) {
            if (j10 < 4) {
                od.f.l("bad zip: truncated header in extra field");
                return;
            }
            int iC = c0Var.C() & 65535;
            long jC = c0Var.C() & 65535;
            long j11 = j10 - 4;
            if (j11 < jC) {
                od.f.l("bad zip: truncated value in extra field");
                return;
            }
            c0Var.H(jC);
            long j12 = iVar.f9454f;
            pVar.invoke(Integer.valueOf(iC), Long.valueOf(jC));
            long j13 = (iVar.f9454f + jC) - j12;
            if (j13 < 0) {
                od.f.l(k0.a.j(iC, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j13 > 0) {
                    iVar.W(j13);
                }
                j10 = j11 - jC;
            }
        }
    }

    public static final g f(c0 c0Var, g gVar) throws IOException {
        int iO = c0Var.o();
        if (iO != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iO));
        }
        c0Var.M(2L);
        short sC = c0Var.C();
        int i = sC & 65535;
        if ((sC & 1) != 0) {
            od.f.l("unsupported zip: general purpose bit flag=".concat(c(i)));
            return null;
        }
        c0Var.M(18L);
        int iC = c0Var.C() & 65535;
        c0Var.M(c0Var.C() & 65535);
        if (gVar == null) {
            c0Var.M(iC);
            return null;
        }
        u uVar = new u();
        u uVar2 = new u();
        u uVar3 = new u();
        e(c0Var, iC, new h(c0Var, uVar, uVar2, uVar3));
        return new g(gVar.f10013a, gVar.f10014b, gVar.f10015c, gVar.f10016d, gVar.f10017e, gVar.f10018f, gVar.f10019g, gVar.f10020h, gVar.i, gVar.f10021j, gVar.f10022k, gVar.f10023l, gVar.f10024m, (Integer) uVar.f16098c, (Integer) uVar2.f16098c, (Integer) uVar3.f16098c);
    }

    public static final int g(f0 f0Var, int i) {
        int i3;
        int[] iArr = f0Var.f9447j;
        int i10 = i + 1;
        int length = f0Var.i.length;
        iArr.getClass();
        int i11 = length - 1;
        int i12 = 0;
        while (true) {
            if (i12 <= i11) {
                i3 = (i12 + i11) >>> 1;
                int i13 = iArr[i3];
                if (i13 >= i10) {
                    if (i13 <= i10) {
                        break;
                    }
                    i11 = i3 - 1;
                } else {
                    i12 = i3 + 1;
                }
            } else {
                i3 = (-i12) - 1;
                break;
            }
        }
        return i3 >= 0 ? i3 : ~i3;
    }
}
