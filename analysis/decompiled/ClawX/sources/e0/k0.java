package e0;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class k0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f2316c;
    public x.b d;

    /* renamed from: e, reason: collision with root package name */
    public int f2317e;

    /* renamed from: f, reason: collision with root package name */
    public Rect[][] f2318f;

    /* renamed from: g, reason: collision with root package name */
    public Rect[][] f2319g;

    public k0(x0 x0Var, WindowInsets windowInsets) {
        super(x0Var);
        this.d = null;
        this.f2318f = new Rect[10][];
        this.f2319g = new Rect[10][];
        this.f2316c = windowInsets;
    }

    private f v(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.f2336a.f2338a.o()) {
            return f.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        l lVarK = a.a.K(display, 0);
        l lVarK2 = a.a.K(display, 1);
        l lVarK3 = a.a.K(display, 2);
        l lVarK4 = a.a.K(display, 3);
        return f.a(point.x, point.y, false, lVarK != null ? lVarK.f2321b : 0, lVarK2 != null ? lVarK2.f2321b : 0, lVarK3 != null ? lVarK3.f2321b : 0, lVarK4 != null ? lVarK4.f2321b : 0);
    }

    private static List<Rect> w(Rect[][] rectArr, int i8) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i9 = 1; i9 <= 512; i9 <<= 1) {
            if ((i8 & i9) != 0 && (rectArr2 = rectArr[b8.h.t(i9)]) != null) {
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

    private Rect[] x(x.b bVar) {
        ArrayList arrayList = new ArrayList();
        int i8 = bVar.f6232a;
        int i9 = bVar.d;
        int i10 = bVar.f6234c;
        int i11 = bVar.f6233b;
        if (i8 != 0) {
            arrayList.add(new Rect(0, 0, bVar.f6232a, 0));
        }
        if (i11 != 0) {
            arrayList.add(new Rect(0, 0, 0, i11));
        }
        if (i10 != 0) {
            arrayList.add(new Rect(0 - i10, 0, 0, 0));
        }
        if (i9 != 0) {
            arrayList.add(new Rect(0, 0 - i9, 0, 0));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    public static boolean z(int i8, int i9) {
        return (i8 & 6) == (i9 & 6);
    }

    @Override // e0.t0
    public List<Rect> e(int i8) {
        return w(this.f2318f, i8);
    }

    @Override // e0.t0
    public List<Rect> f(int i8) {
        return w(this.f2319g, i8);
    }

    @Override // e0.t0
    public abstract x.b h(int i8);

    @Override // e0.t0
    public final x.b j() {
        if (this.d == null) {
            WindowInsets windowInsets = this.f2316c;
            this.d = x.b.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.d;
    }

    @Override // e0.t0
    public void k(View view) {
        v(view);
    }

    @Override // e0.t0
    @SuppressLint({"WrongConstant"})
    public void l() {
        for (int i8 = 1; i8 <= 512; i8 <<= 1) {
            int iT = b8.h.t(i8);
            this.f2318f[iT] = x(h(i8));
            if (i8 != 8) {
                this.f2319g[iT] = x(y(i8));
            }
        }
    }

    @Override // e0.t0
    public boolean o() {
        return this.f2316c.isRound();
    }

    @Override // e0.t0
    public void s(int i8) {
        this.f2317e = i8;
    }

    @Override // e0.t0
    public void t(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f2318f = (Rect[][]) rectArr.clone();
    }

    @Override // e0.t0
    public void u(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f2319g = (Rect[][]) rectArr.clone();
    }

    public abstract x.b y(int i8);

    @Override // e0.t0
    public void p(f fVar) {
    }

    @Override // e0.t0
    public void q(x.b[] bVarArr) {
    }

    @Override // e0.t0
    public void r(x0 x0Var) {
    }
}
