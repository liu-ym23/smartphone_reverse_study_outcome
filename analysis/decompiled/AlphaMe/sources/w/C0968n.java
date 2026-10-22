package w;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.alphame.utils.Property;
import java.lang.ref.WeakReference;
import v.AbstractC0951k;
import v.C0943c;
import v.C0944d;
import v.C0945e;
import v.C0947g;
import y.t;

/* renamed from: w.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0968n {

    /* renamed from: a, reason: collision with root package name */
    public int f15771a;

    /* renamed from: b, reason: collision with root package name */
    public int f15772b;

    /* renamed from: c, reason: collision with root package name */
    public int f15773c;

    /* renamed from: d, reason: collision with root package name */
    public int f15774d;

    /* renamed from: e, reason: collision with root package name */
    public int f15775e;

    /* renamed from: f, reason: collision with root package name */
    public int f15776f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f15777g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f15778h;

    public C0968n(o oVar, C0944d c0944d, t.e eVar, int i4) {
        this.f15778h = oVar;
        this.f15777g = new WeakReference(c0944d);
        C0943c c0943c = c0944d.f15532I;
        eVar.getClass();
        this.f15771a = t.e.n(c0943c);
        this.f15772b = t.e.n(c0944d.f15533J);
        this.f15773c = t.e.n(c0944d.f15534K);
        this.f15774d = t.e.n(c0944d.f15535L);
        this.f15775e = t.e.n(c0944d.f15536M);
        this.f15776f = i4;
    }

    public static boolean a(int i4, int i5, int i6) {
        if (i4 == i5) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i6 == size;
        }
        return false;
    }

    public final void b(C0944d c0944d, C0956b c0956b) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int i4;
        int iMin;
        boolean z4;
        int baseline;
        int i5;
        if (c0944d == null) {
            return;
        }
        if (c0944d.f15562g0 == 8) {
            c0956b.f15736e = 0;
            c0956b.f15737f = 0;
            c0956b.f15738g = 0;
            return;
        }
        if (c0944d.T == null) {
            return;
        }
        int i6 = c0956b.f15732a;
        int i7 = c0956b.f15733b;
        int i8 = c0956b.f15734c;
        int i9 = c0956b.f15735d;
        int i10 = this.f15771a + this.f15772b;
        int i11 = this.f15773c;
        View view = (View) c0944d.f15560f0;
        int iA = t.h.a(i6);
        C0943c c0943c = c0944d.f15534K;
        C0943c c0943c2 = c0944d.f15532I;
        if (iA == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else if (iA == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f15775e, i11, -2);
        } else if (iA == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f15775e, i11, -2);
            boolean z5 = c0944d.f15582r == 1;
            int i12 = c0956b.f15741j;
            if (i12 == 1 || i12 == 2) {
                boolean z6 = view.getMeasuredHeight() == c0944d.l();
                if (c0956b.f15741j == 2 || !z5 || ((z5 && z6) || c0944d.B())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c0944d.r(), 1073741824);
                }
            }
        } else if (iA != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i13 = this.f15775e;
            int i14 = c0943c2 != null ? c0943c2.f15521g : 0;
            if (c0943c != null) {
                i14 += c0943c.f15521g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i13, i11 + i14, -1);
        }
        int iA2 = t.h.a(i7);
        if (iA2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        } else if (iA2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f15776f, i10, -2);
        } else if (iA2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f15776f, i10, -2);
            boolean z7 = c0944d.f15583s == 1;
            int i15 = c0956b.f15741j;
            if (i15 == 1 || i15 == 2) {
                boolean z8 = view.getMeasuredWidth() == c0944d.r();
                if (c0956b.f15741j == 2 || !z7 || ((z7 && z8) || c0944d.C())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(c0944d.l(), 1073741824);
                }
            }
        } else if (iA2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i16 = this.f15776f;
            int i17 = c0943c2 != null ? c0944d.f15533J.f15521g : 0;
            if (c0943c != null) {
                i17 += c0944d.f15535L.f15521g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i16, i10 + i17, -1);
        }
        C0945e c0945e = (C0945e) c0944d.T;
        Object obj = this.f15778h;
        if (c0945e != null && AbstractC0951k.b(((ConstraintLayout) obj).f3237i, 256) && view.getMeasuredWidth() == c0944d.r() && view.getMeasuredWidth() < c0945e.r() && view.getMeasuredHeight() == c0944d.l() && view.getMeasuredHeight() < c0945e.l() && view.getBaseline() == c0944d.f15550a0 && !c0944d.A() && a(c0944d.f15530G, iMakeMeasureSpec, c0944d.r()) && a(c0944d.f15531H, iMakeMeasureSpec2, c0944d.l())) {
            c0956b.f15736e = c0944d.r();
            c0956b.f15737f = c0944d.l();
            c0956b.f15738g = c0944d.f15550a0;
            return;
        }
        boolean z9 = i6 == 3;
        boolean z10 = i7 == 3;
        boolean z11 = i7 == 4 || i7 == 1;
        boolean z12 = i6 == 4 || i6 == 1;
        boolean z13 = z9 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        boolean z14 = z10 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        if (view == null) {
            return;
        }
        y.e eVar = (y.e) view.getLayoutParams();
        int i18 = c0956b.f15741j;
        if (i18 != 1 && i18 != 2 && z9 && c0944d.f15582r == 0 && z10 && c0944d.f15583s == 0) {
            i5 = -1;
            baseline = 0;
            z4 = false;
            iMin = 0;
            iMax = 0;
        } else {
            if ((view instanceof t) && (c0944d instanceof C0947g)) {
                ((t) view).j((C0947g) c0944d, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            c0944d.f15530G = iMakeMeasureSpec;
            c0944d.f15531H = iMakeMeasureSpec2;
            c0944d.f15561g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i19 = c0944d.f15585u;
            iMax = i19 > 0 ? Math.max(i19, measuredWidth) : measuredWidth;
            int i20 = c0944d.f15586v;
            if (i20 > 0) {
                iMax = Math.min(i20, iMax);
            }
            int i21 = c0944d.f15588x;
            if (i21 > 0) {
                iMin = Math.max(i21, measuredHeight);
                i4 = iMakeMeasureSpec;
            } else {
                i4 = iMakeMeasureSpec;
                iMin = measuredHeight;
            }
            int i22 = c0944d.f15589y;
            if (i22 > 0) {
                iMin = Math.min(i22, iMin);
            }
            if (!AbstractC0951k.b(((ConstraintLayout) obj).f3237i, 1)) {
                if (z13 && z11) {
                    iMax = (int) ((iMin * c0944d.f15545W) + 0.5f);
                } else if (z14 && z12) {
                    iMin = (int) ((iMax / c0944d.f15545W) + 0.5f);
                }
            }
            if (measuredWidth == iMax && measuredHeight == iMin) {
                baseline = baseline2;
                i5 = -1;
                z4 = false;
            } else {
                int iMakeMeasureSpec3 = measuredWidth != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i4;
                if (measuredHeight != iMin) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                }
                view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                c0944d.f15530G = iMakeMeasureSpec3;
                c0944d.f15531H = iMakeMeasureSpec2;
                z4 = false;
                c0944d.f15561g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredWidth2;
                iMin = measuredHeight2;
                i5 = -1;
            }
        }
        boolean z15 = baseline != i5 ? true : z4;
        if (iMax != c0956b.f15734c || iMin != c0956b.f15735d) {
            z4 = true;
        }
        c0956b.f15740i = z4;
        boolean z16 = eVar.f15983c0 ? true : z15;
        if (z16 && baseline != -1 && c0944d.f15550a0 != baseline) {
            c0956b.f15740i = true;
        }
        c0956b.f15736e = iMax;
        c0956b.f15737f = iMin;
        c0956b.f15739h = z16;
        c0956b.f15738g = baseline;
    }

    public C0968n(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f15778h = constraintLayout;
        this.f15777g = constraintLayout2;
    }
}
