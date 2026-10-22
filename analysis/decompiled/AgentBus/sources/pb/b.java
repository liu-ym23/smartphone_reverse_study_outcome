package pb;

import c7.j;
import d7.e0;
import d7.r;
import h4.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import m4.i0;
import ob.h0;
import ob.z;
import q7.k;
import q7.u;
import q7.v;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f8577a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = z.f8042g;
        z zVarL = n.l("/", false);
        LinkedHashMap linkedHashMapV = e0.V(new j(zVarL, new g(zVarL)));
        for (g gVar : r.j1(arrayList, new i0(3))) {
            if (((g) linkedHashMapV.put(gVar.f8592a, gVar)) == null) {
                while (true) {
                    z zVar = gVar.f8592a;
                    z zVarC = zVar.c();
                    if (zVarC != null) {
                        g gVar2 = (g) linkedHashMapV.get(zVarC);
                        if (gVar2 != null) {
                            gVar2.f8599h.add(zVar);
                            break;
                        }
                        g gVar3 = new g(zVarC);
                        linkedHashMapV.put(zVarC, gVar3);
                        gVar3.f8599h.add(zVar);
                        gVar = gVar3;
                    }
                }
            }
        }
        return linkedHashMapV;
    }

    public static final String c(int i2) {
        ib.c.o(16);
        String string = Integer.toString(i2, 16);
        k.d(string, "toString(...)");
        return "0x".concat(string);
    }

    public static final g d(ob.e0 e0Var) throws IOException {
        Long lValueOf;
        int iD = e0Var.d();
        if (iD != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iD));
        }
        e0Var.skip(4L);
        short sG = e0Var.g();
        int i2 = sG & 65535;
        if ((sG & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i2));
        }
        int iG = e0Var.g() & 65535;
        short sG2 = e0Var.g();
        int i10 = sG2 & 65535;
        short sG3 = e0Var.g();
        int i11 = sG3 & 65535;
        if (i10 == -1) {
            lValueOf = null;
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((i11 >> 9) & 127) + 1980, ((i11 >> 5) & 15) - 1, sG3 & 31, (i10 >> 11) & 31, (i10 >> 5) & 63, (sG2 & 31) << 1);
            lValueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
        }
        Long l6 = lValueOf;
        e0Var.d();
        u uVar = new u();
        uVar.f8819f = e0Var.d() & 4294967295L;
        u uVar2 = new u();
        uVar2.f8819f = e0Var.d() & 4294967295L;
        int iG2 = e0Var.g() & 65535;
        int iG3 = e0Var.g() & 65535;
        int iG4 = e0Var.g() & 65535;
        e0Var.skip(8L);
        u uVar3 = new u();
        uVar3.f8819f = e0Var.d() & 4294967295L;
        String strI = e0Var.i(iG2);
        if (ga.k.l0(strI, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j2 = uVar2.f8819f == 4294967295L ? 8 : 0L;
        if (uVar.f8819f == 4294967295L) {
            j2 += 8;
        }
        if (uVar3.f8819f == 4294967295L) {
            j2 += 8;
        }
        q7.r rVar = new q7.r();
        e(e0Var, iG3, new h(rVar, j2, uVar2, e0Var, uVar, uVar3));
        if (j2 > 0 && !rVar.f8816f) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String strI2 = e0Var.i(iG4);
        String str = z.f8042g;
        return new g(n.l("/", false).e(strI), ga.r.Z(strI, "/", false), strI2, uVar.f8819f, uVar2.f8819f, iG, l6, uVar3.f8819f);
    }

    public static final void e(ob.e0 e0Var, int i2, p7.n nVar) throws IOException {
        ob.h hVar = e0Var.f7965g;
        long j2 = i2;
        while (j2 != 0) {
            if (j2 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iG = e0Var.g() & 65535;
            long jG = e0Var.g() & 65535;
            long j4 = j2 - 4;
            if (j4 < jG) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            e0Var.L(jG);
            long j10 = hVar.f7993g;
            nVar.invoke(Integer.valueOf(iG), Long.valueOf(jG));
            long j11 = (hVar.f7993g + jG) - j10;
            if (j11 < 0) {
                throw new IOException(n.f.c(iG, "unsupported zip: too many bytes processed for "));
            }
            if (j11 > 0) {
                hVar.skip(j11);
            }
            j2 = j4 - jG;
        }
    }

    public static final ob.n f(ob.e0 e0Var, ob.n nVar) throws IOException {
        v vVar = new v();
        vVar.f8820f = nVar != null ? nVar.f8015e : null;
        v vVar2 = new v();
        v vVar3 = new v();
        int iD = e0Var.d();
        if (iD != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iD));
        }
        e0Var.skip(2L);
        short sG = e0Var.g();
        int i2 = sG & 65535;
        if ((sG & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i2));
        }
        e0Var.skip(18L);
        int iG = e0Var.g() & 65535;
        e0Var.skip(e0Var.g() & 65535);
        if (nVar == null) {
            e0Var.skip(iG);
            return null;
        }
        e(e0Var, iG, new i(e0Var, vVar, vVar2, vVar3));
        return new ob.n(nVar.f8011a, nVar.f8012b, nVar.f8013c, (Long) vVar3.f8820f, (Long) vVar.f8820f, (Long) vVar2.f8820f);
    }

    public static final int g(h0 h0Var, int i2) {
        int i10;
        int[] iArr = h0Var.f7995k;
        int i11 = i2 + 1;
        int length = h0Var.f7994j.length;
        k.e(iArr, "<this>");
        int i12 = length - 1;
        int i13 = 0;
        while (true) {
            if (i13 <= i12) {
                i10 = (i13 + i12) >>> 1;
                int i14 = iArr[i10];
                if (i14 >= i11) {
                    if (i14 <= i11) {
                        break;
                    }
                    i12 = i10 - 1;
                } else {
                    i13 = i10 + 1;
                }
            } else {
                i10 = (-i13) - 1;
                break;
            }
        }
        return i10 >= 0 ? i10 : ~i10;
    }
}
