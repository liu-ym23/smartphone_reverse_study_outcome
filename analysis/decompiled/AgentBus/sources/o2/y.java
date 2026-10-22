package o2;

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

/* loaded from: classes.dex */
public abstract class y extends g0 {

    /* renamed from: b, reason: collision with root package name */
    public final WindowInsets f7249b;

    /* renamed from: c, reason: collision with root package name */
    public k2.a f7250c;

    /* renamed from: d, reason: collision with root package name */
    public int f7251d;

    /* renamed from: e, reason: collision with root package name */
    public Rect[][] f7252e;

    /* renamed from: f, reason: collision with root package name */
    public Rect[][] f7253f;

    public y(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var);
        this.f7250c = null;
        this.f7252e = new Rect[10][];
        this.f7253f = new Rect[10][];
        this.f7249b = windowInsets;
    }

    private e w(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (this.f7233a.f7236a.o()) {
            return e.a(point.x, point.y, true, 0, 0, 0, 0);
        }
        g gVarP = n7.b.p(display, 0);
        g gVarP2 = n7.b.p(display, 1);
        g gVarP3 = n7.b.p(display, 2);
        g gVarP4 = n7.b.p(display, 3);
        return e.a(point.x, point.y, false, gVarP != null ? gVarP.f7231b : 0, gVarP2 != null ? gVarP2.f7231b : 0, gVarP3 != null ? gVarP3.f7231b : 0, gVarP4 != null ? gVarP4.f7231b : 0);
    }

    private static List<Rect> x(Rect[][] rectArr, int i2) {
        Rect[] rectArr2;
        Rect[] rectArr3 = null;
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i2 & i10) != 0 && (rectArr2 = rectArr[n7.m.z(i10)]) != null) {
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

    private Rect[] y(k2.a aVar) {
        ArrayList arrayList = new ArrayList();
        int i2 = aVar.f5575a;
        int i10 = aVar.f5578d;
        int i11 = aVar.f5577c;
        int i12 = aVar.f5576b;
        if (i2 != 0) {
            arrayList.add(new Rect(0, 0, aVar.f5575a, 0));
        }
        if (i12 != 0) {
            arrayList.add(new Rect(0, 0, 0, i12));
        }
        if (i11 != 0) {
            arrayList.add(new Rect(0 - i11, 0, 0, 0));
        }
        if (i10 != 0) {
            arrayList.add(new Rect(0, 0 - i10, 0, 0));
        }
        return (Rect[]) arrayList.toArray(new Rect[arrayList.size()]);
    }

    public static boolean z(int i2, int i10) {
        return (i2 & 6) == (i10 & 6);
    }

    @Override // o2.g0
    public List<Rect> e(int i2) {
        return x(this.f7252e, i2);
    }

    @Override // o2.g0
    public List<Rect> f(int i2) {
        return x(this.f7253f, i2);
    }

    @Override // o2.g0
    public abstract k2.a h(int i2);

    @Override // o2.g0
    public abstract k2.a i(int i2);

    @Override // o2.g0
    public final k2.a k() {
        if (this.f7250c == null) {
            WindowInsets windowInsets = this.f7249b;
            this.f7250c = k2.a.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f7250c;
    }

    @Override // o2.g0
    public void l(View view) {
        w(view);
    }

    @Override // o2.g0
    @SuppressLint({"WrongConstant"})
    public void m() {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            int iZ = n7.m.z(i2);
            this.f7252e[iZ] = y(h(i2));
            if (i2 != 8) {
                this.f7253f[iZ] = y(i(i2));
            }
        }
    }

    @Override // o2.g0
    public boolean o() {
        return this.f7249b.isRound();
    }

    @Override // o2.g0
    public void q(e eVar) {
    }

    @Override // o2.g0
    public void r(k2.a[] aVarArr) {
    }

    @Override // o2.g0
    public void s(j0 j0Var) {
    }

    @Override // o2.g0
    public void t(int i2) {
        this.f7251d = i2;
    }

    @Override // o2.g0
    public void u(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f7252e = (Rect[][]) rectArr.clone();
    }

    @Override // o2.g0
    public void v(Rect[][] rectArr) {
        Objects.requireNonNull(rectArr);
        this.f7253f = (Rect[][]) rectArr.clone();
    }
}
