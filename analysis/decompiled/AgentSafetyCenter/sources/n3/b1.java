package n3;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b1 extends j1 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f8687c;

    /* renamed from: d, reason: collision with root package name */
    public f3.b[] f8688d;

    /* renamed from: e, reason: collision with root package name */
    public f3.b f8689e;

    /* renamed from: f, reason: collision with root package name */
    public m1 f8690f;

    /* renamed from: g, reason: collision with root package name */
    public f3.b f8691g;

    /* renamed from: h, reason: collision with root package name */
    public int f8692h;
    public h i;

    /* renamed from: j, reason: collision with root package name */
    public int f8693j;

    /* renamed from: k, reason: collision with root package name */
    public int f8694k;

    /* renamed from: l, reason: collision with root package name */
    public Rect[][] f8695l;

    /* renamed from: m, reason: collision with root package name */
    public Rect[][] f8696m;

    public b1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var);
        this.f8689e = null;
        this.f8695l = new Rect[10][];
        this.f8696m = new Rect[10][];
        this.f8687c = windowInsets;
    }

    private h C(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.f8721a.f8737a.t()) {
            return h.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        t tVarE = a.a.E(display, 0);
        t tVarE2 = a.a.E(display, 1);
        t tVarE3 = a.a.E(display, 2);
        t tVarE4 = a.a.E(display, 3);
        return h.a(point.x, point.y, false, tVarE != null ? tVarE.f8751b : 0, tVarE2 != null ? tVarE2.f8751b : 0, tVarE3 != null ? tVarE3.f8751b : 0, tVarE4 != null ? tVarE4.f8751b : 0);
    }

    private static List<Rect> D(Rect[][] rectArr, int i) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i & i3) != 0 && (rectArr2 = rectArr[h5.t.C(i3)]) != null) {
                if (rectArr3 == null) {
                    rectArr3 = rectArr2;
                } else {
                    Rect[] rectArr4 = new Rect[rectArr3.length + rectArr2.length];
                    System.arraycopy(rectArr3, 0, rectArr4, 0, rectArr3.length);
                    System.arraycopy(rectArr2, 0, rectArr4, rectArr3.length, rectArr2.length);
                    rectArr3 = rectArr4;
                }
            }
        }
        return rectArr3 == null ? Collections.EMPTY_LIST : Arrays.asList(rectArr3);
    }

    private Rect[] E(f3.b bVar) {
        ArrayList arrayList = new ArrayList();
        int i = bVar.f3900a;
        int i3 = bVar.f3903d;
        int i10 = bVar.f3902c;
        int i11 = bVar.f3901b;
        if (i != 0) {
            arrayList.add(new Rect(0, 0, bVar.f3900a, this.f8693j));
        }
        if (i11 != 0) {
            arrayList.add(new Rect(0, 0, this.f8694k, i11));
        }
        if (i10 != 0) {
            int i12 = this.f8694k;
            arrayList.add(new Rect(i12 - i10, 0, i12, this.f8693j));
        }
        if (i3 != 0) {
            int i13 = this.f8693j;
            arrayList.add(new Rect(0, i13 - i3, this.f8694k, i13));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    @SuppressLint({"WrongConstant"})
    private f3.b F(int i, boolean z10) {
        f3.b bVarA = f3.b.f3899e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i & i3) != 0) {
                f3.b bVarG = G(i3, z10);
                bVarA = f3.b.a(Math.max(bVarA.f3900a, bVarG.f3900a), Math.max(bVarA.f3901b, bVarG.f3901b), Math.max(bVarA.f3902c, bVarG.f3902c), Math.max(bVarA.f3903d, bVarG.f3903d));
            }
        }
        return bVarA;
    }

    private f3.b H() {
        m1 m1Var = this.f8690f;
        return m1Var != null ? m1Var.f8737a.l() : f3.b.f3899e;
    }

    private f3.b I(View view) {
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    public static boolean K(int i, int i3) {
        return (i & 6) == (i3 & 6);
    }

    @Override // n3.j1
    public void A(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f8695l = (Rect[][]) rectArr.clone();
    }

    @Override // n3.j1
    public void B(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f8696m = (Rect[][]) rectArr.clone();
    }

    public f3.b G(int i, boolean z10) {
        f3.b bVarL;
        int i3;
        f3.b bVar = f3.b.f3899e;
        if (i != 1) {
            if (i != 2) {
                if (i == 8) {
                    f3.b[] bVarArr = this.f8688d;
                    bVarL = bVarArr != null ? bVarArr[h5.t.C(8)] : null;
                    if (bVarL != null) {
                        return bVarL;
                    }
                    f3.b bVarN = n();
                    f3.b bVarH = H();
                    int i10 = bVarN.f3903d;
                    if (i10 > bVarH.f3903d) {
                        return f3.b.a(0, 0, 0, i10);
                    }
                    f3.b bVar2 = this.f8691g;
                    if (bVar2 != null && !bVar2.equals(bVar) && (i3 = this.f8691g.f3903d) > bVarH.f3903d) {
                        return f3.b.a(0, 0, 0, i3);
                    }
                } else {
                    if (i == 16) {
                        return m();
                    }
                    if (i == 32) {
                        return k();
                    }
                    if (i == 64) {
                        return o();
                    }
                    if (i == 128) {
                        m1 m1Var = this.f8690f;
                        f fVarH = m1Var != null ? m1Var.f8737a.h() : h();
                        if (fVarH != null) {
                            DisplayCutout displayCutout = fVarH.f8712a;
                            return f3.b.a(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                        }
                    }
                }
            } else {
                if (z10) {
                    f3.b bVarH2 = H();
                    f3.b bVarL2 = l();
                    return f3.b.a(Math.max(bVarH2.f3900a, bVarL2.f3900a), 0, Math.max(bVarH2.f3902c, bVarL2.f3902c), Math.max(bVarH2.f3903d, bVarL2.f3903d));
                }
                if ((this.f8692h & 2) == 0) {
                    f3.b bVarN2 = n();
                    m1 m1Var2 = this.f8690f;
                    bVarL = m1Var2 != null ? m1Var2.f8737a.l() : null;
                    int iMin = bVarN2.f3903d;
                    if (bVarL != null) {
                        iMin = Math.min(iMin, bVarL.f3903d);
                    }
                    return f3.b.a(bVarN2.f3900a, 0, bVarN2.f3902c, iMin);
                }
            }
        } else {
            if (z10) {
                return f3.b.a(0, Math.max(H().f3901b, n().f3901b), 0, 0);
            }
            if ((this.f8692h & 4) == 0) {
                return f3.b.a(0, n().f3901b, 0, 0);
            }
        }
        return bVar;
    }

    public boolean J(int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return false;
            }
            if (i != 8 && i != 128) {
                return true;
            }
        }
        return !G(i, false).equals(f3.b.f3899e);
    }

    @Override // n3.j1
    public void d(View view) {
        this.f8694k = view.getWidth();
        this.f8693j = view.getHeight();
        f3.b bVarI = I(view);
        if (bVarI == null) {
            bVarI = f3.b.f3899e;
        }
        x(bVarI);
    }

    @Override // n3.j1
    public void e(m1 m1Var) {
        m1Var.f8737a.y(this.f8690f);
        f3.b bVar = this.f8691g;
        j1 j1Var = m1Var.f8737a;
        j1Var.x(bVar);
        j1Var.z(this.f8692h);
        j1Var.v(this.i);
        j1Var.A(this.f8695l);
        j1Var.B(this.f8696m);
    }

    @Override // n3.j1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return Objects.equals(this.f8691g, b1Var.f8691g) && K(this.f8692h, b1Var.f8692h);
    }

    @Override // n3.j1
    public List<Rect> f(int i) {
        return D(this.f8695l, i);
    }

    @Override // n3.j1
    public List<Rect> g(int i) {
        return D(this.f8696m, i);
    }

    @Override // n3.j1
    public f3.b i(int i) {
        return F(i, false);
    }

    @Override // n3.j1
    public f3.b j(int i) {
        return F(i, true);
    }

    @Override // n3.j1
    public final f3.b n() {
        if (this.f8689e == null) {
            WindowInsets windowInsets = this.f8687c;
            this.f8689e = f3.b.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f8689e;
    }

    @Override // n3.j1
    public void p(View view) {
        this.i = C(view);
    }

    @Override // n3.j1
    @SuppressLint({"WrongConstant"})
    public void q() {
        for (int i = 1; i <= 512; i <<= 1) {
            int iC = h5.t.C(i);
            this.f8695l[iC] = E(i(i));
            if (i != 8) {
                this.f8696m[iC] = E(j(i));
            }
        }
    }

    @Override // n3.j1
    public m1 r(int i, int i3, int i10, int i11) {
        m1 m1VarH = m1.h(null, this.f8687c);
        int i12 = Build.VERSION.SDK_INT;
        a1 z0Var = i12 >= 36 ? new z0(m1VarH) : i12 >= 35 ? new y0(m1VarH) : i12 >= 34 ? new x0(m1VarH) : new w0(m1VarH);
        z0Var.e(m1.e(n(), i, i3, i10, i11));
        z0Var.d(m1.e(l(), i, i3, i10, i11));
        return z0Var.b();
    }

    @Override // n3.j1
    public boolean t() {
        return this.f8687c.isRound();
    }

    @Override // n3.j1
    @SuppressLint({"WrongConstant"})
    public boolean u(int i) {
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i & i3) != 0 && !J(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // n3.j1
    public void v(h hVar) {
        this.i = hVar;
    }

    @Override // n3.j1
    public void w(f3.b[] bVarArr) {
        this.f8688d = bVarArr;
    }

    @Override // n3.j1
    public void x(f3.b bVar) {
        this.f8691g = bVar;
    }

    @Override // n3.j1
    public void y(m1 m1Var) {
        this.f8690f = m1Var;
    }

    @Override // n3.j1
    public void z(int i) {
        this.f8692h = i;
    }

    public b1(m1 m1Var, b1 b1Var) {
        this(m1Var, new WindowInsets(b1Var.f8687c));
    }
}
