package com.google.android.material.carousel;

import b1.C0553a;
import com.google.android.material.carousel.c;
import com.google.android.material.carousel.e;
import e1.InterfaceC0682a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final e f12538a;

    /* renamed from: b, reason: collision with root package name */
    private final List<e> f12539b;

    /* renamed from: c, reason: collision with root package name */
    private final List<e> f12540c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f12541d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f12542e;

    /* renamed from: f, reason: collision with root package name */
    private final float f12543f;

    /* renamed from: g, reason: collision with root package name */
    private final float f12544g;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12545a;

        static {
            int[] iArr = new int[c.a.values().length];
            f12545a = iArr;
            try {
                iArr[c.a.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private f(e eVar, List<e> list, List<e> list2) {
        this.f12538a = eVar;
        this.f12539b = Collections.unmodifiableList(list);
        this.f12540c = Collections.unmodifiableList(list2);
        float f5 = list.get(list.size() - 1).d().f12530a - eVar.d().f12530a;
        this.f12543f = f5;
        float f6 = eVar.k().f12530a - list2.get(list2.size() - 1).k().f12530a;
        this.f12544g = f6;
        this.f12541d = m(f5, list, true);
        this.f12542e = m(f6, list2, false);
    }

    private e a(List<e> list, float f5, float[] fArr) {
        float[] fArrO = o(list, f5, fArr);
        return fArrO[0] >= 0.5f ? list.get((int) fArrO[2]) : list.get((int) fArrO[1]);
    }

    private static int b(e eVar, float f5) {
        for (int iJ = eVar.j(); iJ < eVar.h().size(); iJ++) {
            if (f5 == eVar.h().get(iJ).f12532c) {
                return iJ;
            }
        }
        return eVar.h().size() - 1;
    }

    private static int c(e eVar) {
        for (int i5 = 0; i5 < eVar.h().size(); i5++) {
            if (!eVar.h().get(i5).f12534e) {
                return i5;
            }
        }
        return -1;
    }

    private static int d(e eVar, float f5) {
        for (int iC = eVar.c() - 1; iC >= 0; iC--) {
            if (f5 == eVar.h().get(iC).f12532c) {
                return iC;
            }
        }
        return 0;
    }

    private static int e(e eVar) {
        for (int size = eVar.h().size() - 1; size >= 0; size--) {
            if (!eVar.h().get(size).f12534e) {
                return size;
            }
        }
        return -1;
    }

    static f f(InterfaceC0682a interfaceC0682a, e eVar, float f5, float f6, float f7, c.a aVar) {
        return new f(eVar, p(interfaceC0682a, eVar, f5, f6, aVar), n(interfaceC0682a, eVar, f5, f7, aVar));
    }

    private static float[] m(float f5, List<e> list, boolean z5) {
        int size = list.size();
        float[] fArr = new float[size];
        int i5 = 1;
        while (i5 < size) {
            int i6 = i5 - 1;
            e eVar = list.get(i6);
            e eVar2 = list.get(i5);
            fArr[i5] = i5 == size + (-1) ? 1.0f : fArr[i6] + ((z5 ? eVar2.d().f12530a - eVar.d().f12530a : eVar.k().f12530a - eVar2.k().f12530a) / f5);
            i5++;
        }
        return fArr;
    }

    private static List<e> n(InterfaceC0682a interfaceC0682a, e eVar, float f5, float f6, c.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        int iE = e(eVar);
        int iA = interfaceC0682a.r() ? interfaceC0682a.a() : interfaceC0682a.b();
        if (!r(interfaceC0682a, eVar) && iE != -1) {
            int iJ = iE - eVar.j();
            float f7 = eVar.d().f12531b - (eVar.d().f12533d / 2.0f);
            if (iJ <= 0 && eVar.i().f12535f > 0.0f) {
                arrayList.add(x(eVar, (f7 - eVar.i().f12535f) - f6, iA));
                return arrayList;
            }
            float f8 = 0.0f;
            int i5 = 0;
            while (i5 < iJ) {
                e eVar2 = (e) arrayList.get(arrayList.size() - 1);
                int i6 = iE - i5;
                float f9 = f8 + eVar.h().get(i6).f12535f;
                int i7 = i6 + 1;
                int i8 = iA;
                e eVarT = t(eVar2, iE, i7 < eVar.h().size() ? d(eVar2, eVar.h().get(i7).f12532c) + 1 : 0, f7 - f9, eVar.c() + i5 + 1, eVar.j() + i5 + 1, i8);
                if (i5 == iJ - 1 && f6 > 0.0f) {
                    eVarT = u(eVarT, f6, i8, false, f5, aVar);
                    i8 = i8;
                }
                arrayList.add(eVarT);
                i5++;
                iA = i8;
                f8 = f9;
            }
        } else if (f6 > 0.0f) {
            arrayList.add(u(eVar, f6, iA, false, f5, aVar));
        }
        return arrayList;
    }

    private static float[] o(List<e> list, float f5, float[] fArr) {
        int size = list.size();
        float f6 = fArr[0];
        int i5 = 1;
        while (i5 < size) {
            float f7 = fArr[i5];
            if (f5 <= f7) {
                return new float[]{C0553a.b(0.0f, 1.0f, f6, f7, f5), i5 - 1, i5};
            }
            i5++;
            f6 = f7;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<e> p(InterfaceC0682a interfaceC0682a, e eVar, float f5, float f6, c.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        int iC = c(eVar);
        int iA = interfaceC0682a.r() ? interfaceC0682a.a() : interfaceC0682a.b();
        if (!q(eVar) && iC != -1) {
            int iC2 = eVar.c() - iC;
            float f7 = eVar.d().f12531b - (eVar.d().f12533d / 2.0f);
            if (iC2 <= 0 && eVar.b().f12535f > 0.0f) {
                arrayList.add(x(eVar, f7 + eVar.b().f12535f + f6, iA));
                return arrayList;
            }
            float f8 = 0.0f;
            for (int i5 = 0; i5 < iC2; i5++) {
                e eVar2 = (e) arrayList.get(arrayList.size() - 1);
                int i6 = iC + i5;
                int size = eVar.h().size() - 1;
                f8 += eVar.h().get(i6).f12535f;
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    size = b(eVar2, eVar.h().get(i7).f12532c) - 1;
                }
                int i8 = iA;
                e eVarT = t(eVar2, iC, size, f7 + f8, (eVar.c() - i5) - 1, (eVar.j() - i5) - 1, i8);
                iA = i8;
                if (i5 == iC2 - 1 && f6 > 0.0f) {
                    eVarT = u(eVarT, f6, iA, true, f5, aVar);
                }
                arrayList.add(eVarT);
            }
        } else if (f6 > 0.0f) {
            arrayList.add(u(eVar, f6, iA, true, f5, aVar));
        }
        return arrayList;
    }

    private static boolean q(e eVar) {
        return eVar.b().f12531b - (eVar.b().f12533d / 2.0f) >= 0.0f && eVar.b() == eVar.e();
    }

    private static boolean r(InterfaceC0682a interfaceC0682a, e eVar) {
        int iB = interfaceC0682a.b();
        if (interfaceC0682a.r()) {
            iB = interfaceC0682a.a();
        }
        return eVar.i().f12531b + (eVar.i().f12533d / 2.0f) <= ((float) iB) && eVar.i() == eVar.l();
    }

    private static e s(List<e> list, float f5, float[] fArr) {
        float[] fArrO = o(list, f5, fArr);
        return e.o(list.get((int) fArrO[1]), list.get((int) fArrO[2]), fArrO[0]);
    }

    private static e t(e eVar, int i5, int i6, float f5, int i7, int i8, int i9) {
        ArrayList arrayList = new ArrayList(eVar.h());
        arrayList.add(i6, (e.c) arrayList.remove(i5));
        e.b bVar = new e.b(eVar.g(), i9);
        int i10 = 0;
        while (i10 < arrayList.size()) {
            e.c cVar = (e.c) arrayList.get(i10);
            float f6 = cVar.f12533d;
            bVar.e(f5 + (f6 / 2.0f), cVar.f12532c, f6, i10 >= i7 && i10 <= i8, cVar.f12534e, cVar.f12535f);
            f5 += cVar.f12533d;
            i10++;
        }
        return bVar.i();
    }

    private static e u(e eVar, float f5, int i5, boolean z5, float f6, c.a aVar) {
        return a.f12545a[aVar.ordinal()] != 1 ? w(eVar, f5, i5, z5) : v(eVar, f5, i5, z5, f6);
    }

    private static e v(e eVar, float f5, int i5, boolean z5, float f6) {
        ArrayList arrayList = new ArrayList(eVar.h());
        e.b bVar = new e.b(eVar.g(), i5);
        float fM = f5 / eVar.m();
        float f7 = z5 ? f5 : 0.0f;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            e.c cVar = (e.c) arrayList.get(i6);
            if (cVar.f12534e) {
                bVar.e(cVar.f12531b, cVar.f12532c, cVar.f12533d, false, true, cVar.f12535f);
            } else {
                boolean z6 = i6 >= eVar.c() && i6 <= eVar.j();
                float f8 = cVar.f12533d - fM;
                float fB = c.b(f8, eVar.g(), f6);
                float f9 = (f8 / 2.0f) + f7;
                float fAbs = Math.abs(f9 - cVar.f12531b);
                bVar.f(f9, fB, f8, z6, false, cVar.f12535f, z5 ? fAbs : 0.0f, z5 ? 0.0f : fAbs);
                f7 += f8;
            }
            i6++;
        }
        return bVar.i();
    }

    private static e w(e eVar, float f5, int i5, boolean z5) {
        ArrayList arrayList = new ArrayList(eVar.h());
        e.b bVar = new e.b(eVar.g(), i5);
        boolean z6 = true;
        int size = z5 ? 0 : arrayList.size() - 1;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            e.c cVar = (e.c) arrayList.get(i6);
            if (cVar.f12534e && i6 == size) {
                bVar.e(cVar.f12531b, cVar.f12532c, cVar.f12533d, false, true, cVar.f12535f);
            } else {
                float f6 = cVar.f12531b;
                float f7 = z5 ? f6 + f5 : f6 - f5;
                float f8 = z5 ? f5 : 0.0f;
                float f9 = z5 ? 0.0f : f5;
                boolean z7 = (i6 < eVar.c() || i6 > eVar.j()) ? false : z6;
                float f10 = f7;
                float f11 = cVar.f12532c;
                float f12 = cVar.f12533d;
                bVar.f(f10, f11, f12, z7, cVar.f12534e, Math.abs(z5 ? Math.max(0.0f, ((f12 / 2.0f) + f10) - i5) : Math.min(0.0f, f10 - (f12 / 2.0f))), f8, f9);
            }
            i6++;
            z6 = true;
        }
        return bVar.i();
    }

    private static e x(e eVar, float f5, int i5) {
        return t(eVar, 0, 0, f5, eVar.c(), eVar.j(), i5);
    }

    e g() {
        return this.f12538a;
    }

    e h() {
        return this.f12540c.get(r1.size() - 1);
    }

    Map<Integer, e> i(int i5, int i6, int i7, boolean z5) {
        float fG = this.f12538a.g();
        HashMap map = new HashMap();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= i5) {
                break;
            }
            int i10 = z5 ? (i5 - i8) - 1 : i8;
            if (i10 * fG * (z5 ? -1 : 1) > i7 - this.f12544g || i8 >= i5 - this.f12540c.size()) {
                Integer numValueOf = Integer.valueOf(i10);
                List<e> list = this.f12540c;
                map.put(numValueOf, list.get(B.a.b(i9, 0, list.size() - 1)));
                i9++;
            }
            i8++;
        }
        int i11 = 0;
        for (int i12 = i5 - 1; i12 >= 0; i12--) {
            int i13 = z5 ? (i5 - i12) - 1 : i12;
            if (i13 * fG * (z5 ? -1 : 1) < i6 + this.f12543f || i12 < this.f12539b.size()) {
                Integer numValueOf2 = Integer.valueOf(i13);
                List<e> list2 = this.f12539b;
                map.put(numValueOf2, list2.get(B.a.b(i11, 0, list2.size() - 1)));
                i11++;
            }
        }
        return map;
    }

    public e j(float f5, float f6, float f7) {
        return k(f5, f6, f7, false);
    }

    e k(float f5, float f6, float f7, boolean z5) {
        float fB;
        List<e> list;
        float[] fArr;
        float f8 = this.f12543f + f6;
        float f9 = f7 - this.f12544g;
        float f10 = l().b().f12536g;
        float f11 = h().b().f12537h;
        if (this.f12543f == f10) {
            f8 += f10;
        }
        if (this.f12544g == f11) {
            f9 -= f11;
        }
        if (f5 < f8) {
            fB = C0553a.b(1.0f, 0.0f, f6, f8, f5);
            list = this.f12539b;
            fArr = this.f12541d;
        } else {
            if (f5 <= f9) {
                return this.f12538a;
            }
            fB = C0553a.b(0.0f, 1.0f, f9, f7, f5);
            list = this.f12540c;
            fArr = this.f12542e;
        }
        return z5 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    e l() {
        return this.f12539b.get(r1.size() - 1);
    }
}
