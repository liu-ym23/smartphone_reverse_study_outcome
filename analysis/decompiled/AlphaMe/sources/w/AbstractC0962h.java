package w;

import com.stepos.alphame.utils.Property;
import java.util.HashSet;
import java.util.Iterator;
import v.C0943c;
import v.C0944d;
import v.C0945e;
import v.C0948h;

/* renamed from: w.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0962h {

    /* renamed from: a, reason: collision with root package name */
    public static final C0956b f15765a = new C0956b();

    public static boolean a(C0944d c0944d) {
        int[] iArr = c0944d.f15580p0;
        int i4 = iArr[0];
        int i5 = iArr[1];
        C0944d c0944d2 = c0944d.T;
        C0945e c0945e = c0944d2 != null ? (C0945e) c0944d2 : null;
        if (c0945e != null) {
            int i6 = c0945e.f15580p0[0];
        }
        if (c0945e != null) {
            int i7 = c0945e.f15580p0[1];
        }
        boolean z4 = i4 == 1 || c0944d.B() || i4 == 2 || (i4 == 3 && c0944d.f15582r == 0 && c0944d.f15545W == Property.DEFAULT_FLOAT_VALUE && c0944d.u(0)) || (i4 == 3 && c0944d.f15582r == 1 && c0944d.v(0, c0944d.r()));
        boolean z5 = i5 == 1 || c0944d.C() || i5 == 2 || (i5 == 3 && c0944d.f15583s == 0 && c0944d.f15545W == Property.DEFAULT_FLOAT_VALUE && c0944d.u(1)) || (i5 == 3 && c0944d.f15583s == 1 && c0944d.v(1, c0944d.l()));
        if (c0944d.f15545W <= Property.DEFAULT_FLOAT_VALUE || !(z4 || z5)) {
            return z4 && z5;
        }
        return true;
    }

    public static void b(int i4, C0944d c0944d, C0968n c0968n, boolean z4) {
        C0943c c0943c;
        C0943c c0943c2;
        C0943c c0943c3;
        C0943c c0943c4;
        if (c0944d.f15573m) {
            return;
        }
        if (!(c0944d instanceof C0945e) && c0944d.A() && a(c0944d)) {
            C0945e.W(c0944d, c0968n, new C0956b());
        }
        C0943c c0943cJ = c0944d.j(2);
        C0943c c0943cJ2 = c0944d.j(4);
        int iD = c0943cJ.d();
        int iD2 = c0943cJ2.d();
        HashSet hashSet = c0943cJ.f15515a;
        char c4 = 0;
        if (hashSet != null && c0943cJ.f15517c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                C0943c c0943c5 = (C0943c) it.next();
                C0944d c0944d2 = c0943c5.f15518d;
                int i5 = i4 + 1;
                boolean zA = a(c0944d2);
                if (c0944d2.A() && zA) {
                    C0945e.W(c0944d2, c0968n, new C0956b());
                }
                C0943c c0943c6 = c0944d2.f15532I;
                C0943c c0943c7 = c0944d2.f15534K;
                char c5 = ((c0943c5 == c0943c6 && (c0943c4 = c0943c7.f15520f) != null && c0943c4.f15517c) || (c0943c5 == c0943c7 && (c0943c3 = c0943c6.f15520f) != null && c0943c3.f15517c)) ? (char) 1 : c4;
                int i6 = c0944d2.f15580p0[c4];
                if (i6 != 3 || zA) {
                    if (!c0944d2.A()) {
                        if (c0943c5 == c0943c6 && c0943c7.f15520f == null) {
                            int iE = c0943c6.e() + iD;
                            c0944d2.K(iE, c0944d2.r() + iE);
                            b(i5, c0944d2, c0968n, z4);
                        } else if (c0943c5 == c0943c7 && c0943c6.f15520f == null) {
                            int iE2 = iD - c0943c7.e();
                            c0944d2.K(iE2 - c0944d2.r(), iE2);
                            b(i5, c0944d2, c0968n, z4);
                        } else if (c5 != 0 && !c0944d2.y()) {
                            c(i5, c0944d2, c0968n, z4);
                        }
                    }
                } else if (i6 == 3 && c0944d2.f15586v >= 0 && c0944d2.f15585u >= 0 && ((c0944d2.f15562g0 == 8 || (c0944d2.f15582r == 0 && c0944d2.f15545W == Property.DEFAULT_FLOAT_VALUE)) && !c0944d2.y() && !c0944d2.f15529F && c5 != 0 && !c0944d2.y())) {
                    d(i5, c0944d, c0968n, c0944d2, z4);
                }
                c4 = 0;
            }
        }
        if (c0944d instanceof C0948h) {
            return;
        }
        HashSet hashSet2 = c0943cJ2.f15515a;
        if (hashSet2 != null && c0943cJ2.f15517c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                C0943c c0943c8 = (C0943c) it2.next();
                C0944d c0944d3 = c0943c8.f15518d;
                int i7 = i4 + 1;
                boolean zA2 = a(c0944d3);
                if (c0944d3.A() && zA2) {
                    C0945e.W(c0944d3, c0968n, new C0956b());
                }
                C0943c c0943c9 = c0944d3.f15532I;
                C0943c c0943c10 = c0944d3.f15534K;
                boolean z5 = (c0943c8 == c0943c9 && (c0943c2 = c0943c10.f15520f) != null && c0943c2.f15517c) || (c0943c8 == c0943c10 && (c0943c = c0943c9.f15520f) != null && c0943c.f15517c);
                int i8 = c0944d3.f15580p0[0];
                if (i8 != 3 || zA2) {
                    if (!c0944d3.A()) {
                        if (c0943c8 == c0943c9 && c0943c10.f15520f == null) {
                            int iE3 = c0943c9.e() + iD2;
                            c0944d3.K(iE3, c0944d3.r() + iE3);
                            b(i7, c0944d3, c0968n, z4);
                        } else if (c0943c8 == c0943c10 && c0943c9.f15520f == null) {
                            int iE4 = iD2 - c0943c10.e();
                            c0944d3.K(iE4 - c0944d3.r(), iE4);
                            b(i7, c0944d3, c0968n, z4);
                        } else if (z5 && !c0944d3.y()) {
                            c(i7, c0944d3, c0968n, z4);
                        }
                    }
                } else if (i8 == 3 && c0944d3.f15586v >= 0 && c0944d3.f15585u >= 0) {
                    if (c0944d3.f15562g0 != 8) {
                        if (c0944d3.f15582r == 0) {
                            if (c0944d3.f15545W == Property.DEFAULT_FLOAT_VALUE) {
                            }
                        }
                    }
                    if (!c0944d3.y() && !c0944d3.f15529F && z5 && !c0944d3.y()) {
                        d(i7, c0944d, c0968n, c0944d3, z4);
                    }
                }
            }
        }
        c0944d.f15573m = true;
    }

    public static void c(int i4, C0944d c0944d, C0968n c0968n, boolean z4) {
        float f4 = c0944d.f15556d0;
        C0943c c0943c = c0944d.f15532I;
        int iD = c0943c.f15520f.d();
        C0943c c0943c2 = c0944d.f15534K;
        int iD2 = c0943c2.f15520f.d();
        int iE = c0943c.e() + iD;
        int iE2 = iD2 - c0943c2.e();
        if (iD == iD2) {
            f4 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iR = c0944d.r();
        int i5 = (iD2 - iD) - iR;
        if (iD > iD2) {
            i5 = (iD - iD2) - iR;
        }
        int i6 = ((int) (i5 > 0 ? (f4 * i5) + 0.5f : f4 * i5)) + iD;
        int i7 = i6 + iR;
        if (iD > iD2) {
            i7 = i6 - iR;
        }
        c0944d.K(i6, i7);
        b(i4 + 1, c0944d, c0968n, z4);
    }

    public static void d(int i4, C0944d c0944d, C0968n c0968n, C0944d c0944d2, boolean z4) {
        float f4 = c0944d2.f15556d0;
        C0943c c0943c = c0944d2.f15532I;
        int iE = c0943c.e() + c0943c.f15520f.d();
        C0943c c0943c2 = c0944d2.f15534K;
        int iD = c0943c2.f15520f.d() - c0943c2.e();
        if (iD >= iE) {
            int iR = c0944d2.r();
            if (c0944d2.f15562g0 != 8) {
                int i5 = c0944d2.f15582r;
                if (i5 == 2) {
                    iR = (int) (c0944d2.f15556d0 * 0.5f * (c0944d instanceof C0945e ? c0944d.r() : c0944d.T.r()));
                } else if (i5 == 0) {
                    iR = iD - iE;
                }
                iR = Math.max(c0944d2.f15585u, iR);
                int i6 = c0944d2.f15586v;
                if (i6 > 0) {
                    iR = Math.min(i6, iR);
                }
            }
            int i7 = iE + ((int) ((f4 * ((iD - iE) - iR)) + 0.5f));
            c0944d2.K(i7, iR + i7);
            b(i4 + 1, c0944d2, c0968n, z4);
        }
    }

    public static void e(int i4, C0944d c0944d, C0968n c0968n) {
        float f4 = c0944d.f15558e0;
        C0943c c0943c = c0944d.f15533J;
        int iD = c0943c.f15520f.d();
        C0943c c0943c2 = c0944d.f15535L;
        int iD2 = c0943c2.f15520f.d();
        int iE = c0943c.e() + iD;
        int iE2 = iD2 - c0943c2.e();
        if (iD == iD2) {
            f4 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iL = c0944d.l();
        int i5 = (iD2 - iD) - iL;
        if (iD > iD2) {
            i5 = (iD - iD2) - iL;
        }
        int i6 = (int) (i5 > 0 ? (f4 * i5) + 0.5f : f4 * i5);
        int i7 = iD + i6;
        int i8 = i7 + iL;
        if (iD > iD2) {
            i7 = iD - i6;
            i8 = i7 - iL;
        }
        c0944d.L(i7, i8);
        g(i4 + 1, c0944d, c0968n);
    }

    public static void f(int i4, C0944d c0944d, C0968n c0968n, C0944d c0944d2) {
        float f4 = c0944d2.f15558e0;
        C0943c c0943c = c0944d2.f15533J;
        int iE = c0943c.e() + c0943c.f15520f.d();
        C0943c c0943c2 = c0944d2.f15535L;
        int iD = c0943c2.f15520f.d() - c0943c2.e();
        if (iD >= iE) {
            int iL = c0944d2.l();
            if (c0944d2.f15562g0 != 8) {
                int i5 = c0944d2.f15583s;
                if (i5 == 2) {
                    iL = (int) (f4 * 0.5f * (c0944d instanceof C0945e ? c0944d.l() : c0944d.T.l()));
                } else if (i5 == 0) {
                    iL = iD - iE;
                }
                iL = Math.max(c0944d2.f15588x, iL);
                int i6 = c0944d2.f15589y;
                if (i6 > 0) {
                    iL = Math.min(i6, iL);
                }
            }
            int i7 = iE + ((int) ((f4 * ((iD - iE) - iL)) + 0.5f));
            c0944d2.L(i7, iL + i7);
            g(i4 + 1, c0944d2, c0968n);
        }
    }

    public static void g(int i4, C0944d c0944d, C0968n c0968n) {
        C0943c c0943c;
        C0943c c0943c2;
        C0943c c0943c3;
        C0943c c0943c4;
        C0943c c0943c5;
        if (c0944d.f15575n) {
            return;
        }
        if (!(c0944d instanceof C0945e) && c0944d.A() && a(c0944d)) {
            C0945e.W(c0944d, c0968n, new C0956b());
        }
        C0943c c0943cJ = c0944d.j(3);
        C0943c c0943cJ2 = c0944d.j(5);
        int iD = c0943cJ.d();
        int iD2 = c0943cJ2.d();
        HashSet hashSet = c0943cJ.f15515a;
        if (hashSet != null && c0943cJ.f15517c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                C0943c c0943c6 = (C0943c) it.next();
                C0944d c0944d2 = c0943c6.f15518d;
                int i5 = i4 + 1;
                boolean zA = a(c0944d2);
                if (c0944d2.A() && zA) {
                    C0945e.W(c0944d2, c0968n, new C0956b());
                }
                C0943c c0943c7 = c0944d2.f15533J;
                C0943c c0943c8 = c0944d2.f15535L;
                boolean z4 = (c0943c6 == c0943c7 && (c0943c5 = c0943c8.f15520f) != null && c0943c5.f15517c) || (c0943c6 == c0943c8 && (c0943c4 = c0943c7.f15520f) != null && c0943c4.f15517c);
                int i6 = c0944d2.f15580p0[1];
                if (i6 != 3 || zA) {
                    if (!c0944d2.A()) {
                        if (c0943c6 == c0943c7 && c0943c8.f15520f == null) {
                            int iE = c0943c7.e() + iD;
                            c0944d2.L(iE, c0944d2.l() + iE);
                            g(i5, c0944d2, c0968n);
                        } else if (c0943c6 == c0943c8 && c0943c7.f15520f == null) {
                            int iE2 = iD - c0943c8.e();
                            c0944d2.L(iE2 - c0944d2.l(), iE2);
                            g(i5, c0944d2, c0968n);
                        } else if (z4 && !c0944d2.z()) {
                            e(i5, c0944d2, c0968n);
                        }
                    }
                } else if (i6 == 3 && c0944d2.f15589y >= 0 && c0944d2.f15588x >= 0 && (c0944d2.f15562g0 == 8 || (c0944d2.f15583s == 0 && c0944d2.f15545W == Property.DEFAULT_FLOAT_VALUE))) {
                    if (!c0944d2.z() && !c0944d2.f15529F && z4 && !c0944d2.z()) {
                        f(i5, c0944d, c0968n, c0944d2);
                    }
                }
            }
        }
        if (c0944d instanceof C0948h) {
            return;
        }
        HashSet hashSet2 = c0943cJ2.f15515a;
        if (hashSet2 != null && c0943cJ2.f15517c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                C0943c c0943c9 = (C0943c) it2.next();
                C0944d c0944d3 = c0943c9.f15518d;
                int i7 = i4 + 1;
                boolean zA2 = a(c0944d3);
                if (c0944d3.A() && zA2) {
                    C0945e.W(c0944d3, c0968n, new C0956b());
                }
                C0943c c0943c10 = c0944d3.f15533J;
                C0943c c0943c11 = c0944d3.f15535L;
                boolean z5 = (c0943c9 == c0943c10 && (c0943c3 = c0943c11.f15520f) != null && c0943c3.f15517c) || (c0943c9 == c0943c11 && (c0943c2 = c0943c10.f15520f) != null && c0943c2.f15517c);
                int i8 = c0944d3.f15580p0[1];
                if (i8 != 3 || zA2) {
                    if (!c0944d3.A()) {
                        if (c0943c9 == c0943c10 && c0943c11.f15520f == null) {
                            int iE3 = c0943c10.e() + iD2;
                            c0944d3.L(iE3, c0944d3.l() + iE3);
                            g(i7, c0944d3, c0968n);
                        } else if (c0943c9 == c0943c11 && c0943c10.f15520f == null) {
                            int iE4 = iD2 - c0943c11.e();
                            c0944d3.L(iE4 - c0944d3.l(), iE4);
                            g(i7, c0944d3, c0968n);
                        } else if (z5 && !c0944d3.z()) {
                            e(i7, c0944d3, c0968n);
                        }
                    }
                } else if (i8 == 3 && c0944d3.f15589y >= 0 && c0944d3.f15588x >= 0) {
                    if (c0944d3.f15562g0 != 8) {
                        if (c0944d3.f15583s == 0) {
                            if (c0944d3.f15545W == Property.DEFAULT_FLOAT_VALUE) {
                            }
                        }
                    }
                    if (!c0944d3.z() && !c0944d3.f15529F && z5 && !c0944d3.z()) {
                        f(i7, c0944d, c0968n, c0944d3);
                    }
                }
            }
        }
        C0943c c0943cJ3 = c0944d.j(6);
        if (c0943cJ3.f15515a != null && c0943cJ3.f15517c) {
            int iD3 = c0943cJ3.d();
            Iterator it3 = c0943cJ3.f15515a.iterator();
            while (it3.hasNext()) {
                C0943c c0943c12 = (C0943c) it3.next();
                C0944d c0944d4 = c0943c12.f15518d;
                int i9 = i4 + 1;
                boolean zA3 = a(c0944d4);
                if (c0944d4.A() && zA3) {
                    C0945e.W(c0944d4, c0968n, new C0956b());
                }
                if (c0944d4.f15580p0[1] != 3 || zA3) {
                    if (!c0944d4.A() && c0943c12 == (c0943c = c0944d4.f15536M)) {
                        int iE5 = c0943c12.e() + iD3;
                        if (c0944d4.f15528E) {
                            int i10 = iE5 - c0944d4.f15550a0;
                            int i11 = c0944d4.f15544V + i10;
                            c0944d4.f15548Z = i10;
                            c0944d4.f15533J.l(i10);
                            c0944d4.f15535L.l(i11);
                            c0943c.l(iE5);
                            c0944d4.f15571l = true;
                        }
                        g(i9, c0944d4, c0968n);
                    }
                }
            }
        }
        c0944d.f15575n = true;
    }
}
