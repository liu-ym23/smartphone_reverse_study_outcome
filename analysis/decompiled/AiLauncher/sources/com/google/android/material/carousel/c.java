package com.google.android.material.carousel;

import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import w0.C5715a;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f20580a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f20581b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f20582c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f20583d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f20584e;

    /* renamed from: f, reason: collision with root package name */
    public final float f20585f;

    /* renamed from: g, reason: collision with root package name */
    public final float f20586g;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20587a;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            f20587a = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public c(b bVar, List<b> list, List<b> list2) {
        this.f20580a = bVar;
        this.f20581b = Collections.unmodifiableList(list);
        this.f20582c = Collections.unmodifiableList(list2);
        float f10 = list.get(list.size() - 1).d().f20572a - bVar.d().f20572a;
        this.f20585f = f10;
        float f11 = bVar.k().f20572a - list2.get(list2.size() - 1).k().f20572a;
        this.f20586g = f11;
        this.f20583d = m(f10, list, true);
        this.f20584e = m(f11, list2, false);
    }

    public static int b(b bVar, float f10) {
        for (int iJ = bVar.j(); iJ < bVar.h().size(); iJ++) {
            if (f10 == bVar.h().get(iJ).f20574c) {
                return iJ;
            }
        }
        return bVar.h().size() - 1;
    }

    public static int c(b bVar) {
        for (int i10 = 0; i10 < bVar.h().size(); i10++) {
            if (!bVar.h().get(i10).f20576e) {
                return i10;
            }
        }
        return -1;
    }

    public static int d(b bVar, float f10) {
        for (int iC = bVar.c() - 1; iC >= 0; iC--) {
            if (f10 == bVar.h().get(iC).f20574c) {
                return iC;
            }
        }
        return 0;
    }

    public static int e(b bVar) {
        for (int size = bVar.h().size() - 1; size >= 0; size--) {
            if (!bVar.h().get(size).f20576e) {
                return size;
            }
        }
        return -1;
    }

    public static c f(I2.b bVar, b bVar2, float f10, float f11, float f12, CarouselStrategy.StrategyType strategyType) {
        return new c(bVar2, p(bVar, bVar2, f10, f11, strategyType), n(bVar, bVar2, f10, f12, strategyType));
    }

    public static float[] m(float f10, List<b> list, boolean z10) {
        int size = list.size();
        float[] fArr = new float[size];
        int i10 = 1;
        while (i10 < size) {
            int i11 = i10 - 1;
            b bVar = list.get(i11);
            b bVar2 = list.get(i10);
            fArr[i10] = i10 == size + (-1) ? 1.0f : fArr[i11] + ((z10 ? bVar2.d().f20572a - bVar.d().f20572a : bVar.k().f20572a - bVar2.k().f20572a) / f10);
            i10++;
        }
        return fArr;
    }

    public static List<b> n(I2.b bVar, b bVar2, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int iE = e(bVar2);
        int iA = bVar.l() ? bVar.a() : bVar.b();
        if (!r(bVar, bVar2) && iE != -1) {
            int iJ = iE - bVar2.j();
            float f12 = bVar2.d().f20573b - (bVar2.d().f20575d / 2.0f);
            if (iJ <= 0 && bVar2.i().f20577f > 0.0f) {
                arrayList.add(x(bVar2, (f12 - bVar2.i().f20577f) - f11, iA));
                return arrayList;
            }
            float f13 = 0.0f;
            int i10 = 0;
            while (i10 < iJ) {
                b bVar3 = (b) arrayList.get(arrayList.size() - 1);
                int i11 = iE - i10;
                float f14 = f13 + bVar2.h().get(i11).f20577f;
                int i12 = i11 + 1;
                int i13 = iA;
                b bVarT = t(bVar3, iE, i12 < bVar2.h().size() ? d(bVar3, bVar2.h().get(i12).f20574c) + 1 : 0, f12 - f14, bVar2.c() + i10 + 1, bVar2.j() + i10 + 1, i13);
                if (i10 == iJ - 1 && f11 > 0.0f) {
                    bVarT = u(bVarT, f11, i13, false, f10, strategyType);
                    i13 = i13;
                }
                arrayList.add(bVarT);
                i10++;
                iA = i13;
                f13 = f14;
            }
        } else if (f11 > 0.0f) {
            arrayList.add(u(bVar2, f11, iA, false, f10, strategyType));
        }
        return arrayList;
    }

    public static float[] o(List<b> list, float f10, float[] fArr) {
        int size = list.size();
        float f11 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f12 = fArr[i10];
            if (f10 <= f12) {
                return new float[]{E2.a.b(0.0f, 1.0f, f11, f12, f10), i10 - 1, i10};
            }
            i10++;
            f11 = f12;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static List<b> p(I2.b bVar, b bVar2, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int iC = c(bVar2);
        int iA = bVar.l() ? bVar.a() : bVar.b();
        if (!q(bVar2) && iC != -1) {
            int iC2 = bVar2.c() - iC;
            float f12 = bVar2.d().f20573b - (bVar2.d().f20575d / 2.0f);
            if (iC2 <= 0 && bVar2.b().f20577f > 0.0f) {
                arrayList.add(x(bVar2, f12 + bVar2.b().f20577f + f11, iA));
                return arrayList;
            }
            float f13 = 0.0f;
            for (int i10 = 0; i10 < iC2; i10++) {
                b bVar3 = (b) arrayList.get(arrayList.size() - 1);
                int i11 = iC + i10;
                int size = bVar2.h().size() - 1;
                f13 += bVar2.h().get(i11).f20577f;
                int i12 = i11 - 1;
                if (i12 >= 0) {
                    size = b(bVar3, bVar2.h().get(i12).f20574c) - 1;
                }
                int i13 = iA;
                b bVarT = t(bVar3, iC, size, f12 + f13, (bVar2.c() - i10) - 1, (bVar2.j() - i10) - 1, i13);
                iA = i13;
                if (i10 == iC2 - 1 && f11 > 0.0f) {
                    bVarT = u(bVarT, f11, iA, true, f10, strategyType);
                }
                arrayList.add(bVarT);
            }
        } else if (f11 > 0.0f) {
            arrayList.add(u(bVar2, f11, iA, true, f10, strategyType));
        }
        return arrayList;
    }

    public static boolean q(b bVar) {
        return bVar.b().f20573b - (bVar.b().f20575d / 2.0f) >= 0.0f && bVar.b() == bVar.e();
    }

    public static boolean r(I2.b bVar, b bVar2) {
        int iB = bVar.b();
        if (bVar.l()) {
            iB = bVar.a();
        }
        return bVar2.i().f20573b + (bVar2.i().f20575d / 2.0f) <= ((float) iB) && bVar2.i() == bVar2.l();
    }

    public static b s(List<b> list, float f10, float[] fArr) {
        float[] fArrO = o(list, f10, fArr);
        return b.o(list.get((int) fArrO[1]), list.get((int) fArrO[2]), fArrO[0]);
    }

    public static b t(b bVar, int i10, int i11, float f10, int i12, int i13, int i14) {
        ArrayList arrayList = new ArrayList(bVar.h());
        arrayList.add(i11, (b.c) arrayList.remove(i10));
        b.C0231b c0231b = new b.C0231b(bVar.g(), i14);
        int i15 = 0;
        while (i15 < arrayList.size()) {
            b.c cVar = (b.c) arrayList.get(i15);
            float f11 = cVar.f20575d;
            c0231b.e(f10 + (f11 / 2.0f), cVar.f20574c, f11, i15 >= i12 && i15 <= i13, cVar.f20576e, cVar.f20577f);
            f10 += cVar.f20575d;
            i15++;
        }
        return c0231b.i();
    }

    public static b u(b bVar, float f10, int i10, boolean z10, float f11, CarouselStrategy.StrategyType strategyType) {
        return a.f20587a[strategyType.ordinal()] != 1 ? w(bVar, f10, i10, z10) : v(bVar, f10, i10, z10, f11);
    }

    public static b v(b bVar, float f10, int i10, boolean z10, float f11) {
        ArrayList arrayList = new ArrayList(bVar.h());
        b.C0231b c0231b = new b.C0231b(bVar.g(), i10);
        float fM = f10 / bVar.m();
        float f12 = z10 ? f10 : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            b.c cVar = (b.c) arrayList.get(i11);
            if (cVar.f20576e) {
                c0231b.e(cVar.f20573b, cVar.f20574c, cVar.f20575d, false, true, cVar.f20577f);
            } else {
                boolean z11 = i11 >= bVar.c() && i11 <= bVar.j();
                float f13 = cVar.f20575d - fM;
                float fB = CarouselStrategy.b(f13, bVar.g(), f11);
                float f14 = (f13 / 2.0f) + f12;
                float fAbs = Math.abs(f14 - cVar.f20573b);
                c0231b.f(f14, fB, f13, z11, false, cVar.f20577f, z10 ? fAbs : 0.0f, z10 ? 0.0f : fAbs);
                f12 += f13;
            }
            i11++;
        }
        return c0231b.i();
    }

    public static b w(b bVar, float f10, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList(bVar.h());
        b.C0231b c0231b = new b.C0231b(bVar.g(), i10);
        boolean z11 = true;
        int size = z10 ? 0 : arrayList.size() - 1;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            b.c cVar = (b.c) arrayList.get(i11);
            if (cVar.f20576e && i11 == size) {
                c0231b.e(cVar.f20573b, cVar.f20574c, cVar.f20575d, false, true, cVar.f20577f);
            } else {
                float f11 = cVar.f20573b;
                float f12 = z10 ? f11 + f10 : f11 - f10;
                float f13 = z10 ? f10 : 0.0f;
                float f14 = z10 ? 0.0f : f10;
                boolean z12 = (i11 < bVar.c() || i11 > bVar.j()) ? false : z11;
                float f15 = f12;
                float f16 = cVar.f20574c;
                float f17 = cVar.f20575d;
                c0231b.f(f15, f16, f17, z12, cVar.f20576e, Math.abs(z10 ? Math.max(0.0f, ((f17 / 2.0f) + f15) - i10) : Math.min(0.0f, f15 - (f17 / 2.0f))), f13, f14);
            }
            i11++;
            z11 = true;
        }
        return c0231b.i();
    }

    public static b x(b bVar, float f10, int i10) {
        return t(bVar, 0, 0, f10, bVar.c(), bVar.j(), i10);
    }

    public final b a(List<b> list, float f10, float[] fArr) {
        float[] fArrO = o(list, f10, fArr);
        return fArrO[0] >= 0.5f ? list.get((int) fArrO[2]) : list.get((int) fArrO[1]);
    }

    public b g() {
        return this.f20580a;
    }

    public b h() {
        return this.f20582c.get(r1.size() - 1);
    }

    public Map<Integer, b> i(int i10, int i11, int i12, boolean z10) {
        float fG = this.f20580a.g();
        HashMap map = new HashMap();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= i10) {
                break;
            }
            int i15 = z10 ? (i10 - i13) - 1 : i13;
            if (i15 * fG * (z10 ? -1 : 1) > i12 - this.f20586g || i13 >= i10 - this.f20582c.size()) {
                Integer numValueOf = Integer.valueOf(i15);
                List<b> list = this.f20582c;
                map.put(numValueOf, list.get(C5715a.b(i14, 0, list.size() - 1)));
                i14++;
            }
            i13++;
        }
        int i16 = 0;
        for (int i17 = i10 - 1; i17 >= 0; i17--) {
            int i18 = z10 ? (i10 - i17) - 1 : i17;
            if (i18 * fG * (z10 ? -1 : 1) < i11 + this.f20585f || i17 < this.f20581b.size()) {
                Integer numValueOf2 = Integer.valueOf(i18);
                List<b> list2 = this.f20581b;
                map.put(numValueOf2, list2.get(C5715a.b(i16, 0, list2.size() - 1)));
                i16++;
            }
        }
        return map;
    }

    public b j(float f10, float f11, float f12) {
        return k(f10, f11, f12, false);
    }

    public b k(float f10, float f11, float f12, boolean z10) {
        float fB;
        List<b> list;
        float[] fArr;
        float f13 = this.f20585f + f11;
        float f14 = f12 - this.f20586g;
        float f15 = l().b().f20578g;
        float f16 = h().b().f20579h;
        if (this.f20585f == f15) {
            f13 += f15;
        }
        if (this.f20586g == f16) {
            f14 -= f16;
        }
        if (f10 < f13) {
            fB = E2.a.b(1.0f, 0.0f, f11, f13, f10);
            list = this.f20581b;
            fArr = this.f20583d;
        } else {
            if (f10 <= f14) {
                return this.f20580a;
            }
            fB = E2.a.b(0.0f, 1.0f, f14, f12, f10);
            list = this.f20582c;
            fArr = this.f20584e;
        }
        return z10 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    public b l() {
        return this.f20581b.get(r1.size() - 1);
    }
}
