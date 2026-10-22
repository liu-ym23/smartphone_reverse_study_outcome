package s1;

import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final q6.b f9333a;

    /* renamed from: b, reason: collision with root package name */
    public static final q6.b f9334b;

    /* renamed from: c, reason: collision with root package name */
    public static final q6.b f9335c;

    static {
        int i2 = 17;
        f9333a = new q6.b(i2, new t(5), new u(4));
        f9334b = new q6.b(i2, new t(6), new u(5));
        f9335c = new q6.b(i2, new t(7), new u(6));
    }

    public static a a(String str, h0 h0Var, long j2, d2.c cVar, v1.d dVar, int i2) {
        d7.z zVar = d7.z.f2978f;
        return new a(new z1.d(str, h0Var, zVar, zVar, dVar, cVar), i2, 1, j2);
    }

    public static final long b(int i2, int i10) {
        if (i2 < 0 || i10 < 0) {
            x1.a.a("start and end cannot be negative. [start: " + i2 + ", end: " + i10 + ']');
        }
        long j2 = (i10 & 4294967295L) | (i2 << 32);
        int i11 = g0.f9269c;
        return j2;
    }

    public static final int c(int i2, List list) {
        int i10;
        int i11 = ((m) d7.r.W0(list)).f9285c;
        if (i2 > ((m) d7.r.W0(list)).f9285c) {
            x1.a.a("Index " + i2 + " should be less or equal than last line's end " + i11);
        }
        int size = list.size() - 1;
        int i12 = 0;
        while (true) {
            if (i12 > size) {
                i10 = -(i12 + 1);
                break;
            }
            i10 = (i12 + size) >>> 1;
            m mVar = (m) list.get(i10);
            char c10 = mVar.f9284b > i2 ? (char) 1 : mVar.f9285c <= i2 ? (char) 65535 : (char) 0;
            if (c10 >= 0) {
                if (c10 <= 0) {
                    break;
                }
                size = i10 - 1;
            } else {
                i12 = i10 + 1;
            }
        }
        if (i10 >= 0 && i10 < list.size()) {
            return i10;
        }
        StringBuilder sbN = a1.a.n(i10, "Found paragraph index ", " should be in range [0, ");
        sbN.append(list.size());
        sbN.append(").\nDebug info: index=");
        sbN.append(i2);
        sbN.append(", paragraphs=[");
        sbN.append(f2.a.a(list, null, new o4.b(11), 31));
        sbN.append(']');
        x1.a.a(sbN.toString());
        return i10;
    }

    public static final int d(int i2, List list) {
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            m mVar = (m) list.get(i11);
            char c10 = mVar.f9286d > i2 ? (char) 1 : mVar.f9287e <= i2 ? (char) 65535 : (char) 0;
            if (c10 < 0) {
                i10 = i11 + 1;
            } else {
                if (c10 <= 0) {
                    return i11;
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final h0 e(h0 h0Var, d2.l lVar) {
        c2.o oVar;
        long j2;
        v1.k kVar;
        v1.i iVar;
        y1.b bVar;
        a0 a0Var = h0Var.f9272a;
        c2.o oVar2 = b0.f9228d;
        c2.o oVar3 = a0Var.f9210a;
        if (oVar3.equals(c2.n.f1879a)) {
            oVar3 = b0.f9228d;
        }
        c2.o oVar4 = oVar3;
        long j4 = a0Var.f9211b;
        d2.o[] oVarArr = d2.n.f2797b;
        if ((j4 & 1095216660480L) == 0) {
            j4 = b0.f9225a;
        }
        long j10 = j4;
        v1.k kVar2 = a0Var.f9212c;
        if (kVar2 == null) {
            kVar2 = v1.k.f10358h;
        }
        v1.k kVar3 = kVar2;
        v1.i iVar2 = a0Var.f9213d;
        v1.i iVar3 = new v1.i(iVar2 != null ? iVar2.f10355a : 0);
        v1.j jVar = a0Var.f9214e;
        v1.j jVar2 = new v1.j(jVar != null ? jVar.f10356a : 65535);
        v1.p pVar = a0Var.f9215f;
        if (pVar == null) {
            pVar = v1.p.f10368a;
        }
        v1.p pVar2 = pVar;
        String str = a0Var.f9216g;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j11 = a0Var.f9217h;
        if ((j11 & 1095216660480L) == 0) {
            j11 = b0.f9226b;
        }
        c2.a aVar = a0Var.f9218i;
        c2.a aVar2 = new c2.a(aVar != null ? aVar.f1857a : 0.0f);
        c2.p pVar3 = a0Var.f9219j;
        if (pVar3 == null) {
            pVar3 = c2.p.f1880c;
        }
        c2.p pVar4 = pVar3;
        y1.b bVar2 = a0Var.f9220k;
        if (bVar2 == null) {
            y1.b bVar3 = y1.b.f11542h;
            u5.h hVar = y1.c.f11545a;
            hVar.getClass();
            LocaleList localeList = LocaleList.getDefault();
            oVar = oVar4;
            synchronized (((w4.a) hVar.f10131c)) {
                j2 = j10;
                try {
                    bVar = (y1.b) hVar.f10130b;
                    if (bVar == null || localeList != ((LocaleList) hVar.f10129a)) {
                        int size = localeList.size();
                        ArrayList arrayList = new ArrayList(size);
                        kVar = kVar3;
                        int i2 = 0;
                        while (i2 < size) {
                            arrayList.add(new y1.a(localeList.get(i2)));
                            i2++;
                            size = size;
                            iVar3 = iVar3;
                        }
                        iVar = iVar3;
                        bVar = new y1.b(arrayList);
                        hVar.f10129a = localeList;
                        hVar.f10130b = bVar;
                    } else {
                        kVar = kVar3;
                        iVar = iVar3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            bVar2 = bVar;
        } else {
            oVar = oVar4;
            j2 = j10;
            kVar = kVar3;
            iVar = iVar3;
        }
        y1.b bVar4 = bVar2;
        long j12 = a0Var.f9221l;
        if (j12 == 16) {
            j12 = b0.f9227c;
        }
        c2.l lVar2 = a0Var.f9222m;
        if (lVar2 == null) {
            lVar2 = c2.l.f1875b;
        }
        u0.b0 b0Var = a0Var.f9223n;
        if (b0Var == null) {
            b0Var = u0.b0.f9889d;
        }
        w0.c cVar = a0Var.f9224o;
        if (cVar == null) {
            cVar = w0.f.f10635b;
        }
        a0 a0Var2 = new a0(oVar, j2, kVar, iVar, jVar2, pVar2, str2, j11, aVar2, pVar4, bVar4, j12, lVar2, b0Var, cVar);
        p pVar5 = h0Var.f9273b;
        int i10 = q.f9303b;
        int i11 = pVar5.f9293a;
        int i12 = 5;
        if (i11 == Integer.MIN_VALUE) {
            i11 = 5;
        }
        int i13 = pVar5.f9294b;
        if (i13 == 3) {
            int i14 = i0.$EnumSwitchMapping$0[lVar.ordinal()];
            if (i14 == 1) {
                i12 = 4;
            } else if (i14 != 2) {
                throw new a4.u();
            }
        } else if (i13 == Integer.MIN_VALUE) {
            int i15 = i0.$EnumSwitchMapping$0[lVar.ordinal()];
            if (i15 == 1) {
                i12 = 1;
            } else {
                if (i15 != 2) {
                    throw new a4.u();
                }
                i12 = 2;
            }
        } else {
            i12 = i13;
        }
        long j13 = pVar5.f9295c;
        if ((j13 & 1095216660480L) == 0) {
            j13 = q.f9302a;
        }
        c2.q qVar = pVar5.f9296d;
        if (qVar == null) {
            qVar = c2.q.f1883c;
        }
        r rVar = pVar5.f9297e;
        c2.q qVar2 = qVar;
        c2.i iVar4 = pVar5.f9298f;
        int i16 = pVar5.f9299g;
        if (i16 == 0) {
            i16 = c2.e.f1861b;
        }
        int i17 = pVar5.f9300h;
        if (i17 == Integer.MIN_VALUE) {
            i17 = 1;
        }
        c2.s sVar = pVar5.f9301i;
        if (sVar == null) {
            sVar = c2.s.f1887c;
        }
        return new h0(a0Var2, new p(i11, i12, j13, qVar2, rVar, iVar4, i16, i17, sVar), h0Var.f9274c);
    }
}
