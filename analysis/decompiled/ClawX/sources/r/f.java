package r;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f4956a;

    /* renamed from: b, reason: collision with root package name */
    public int f4957b;

    /* renamed from: c, reason: collision with root package name */
    public int f4958c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f4959e;

    /* renamed from: f, reason: collision with root package name */
    public int f4960f;

    /* renamed from: g, reason: collision with root package name */
    public int f4961g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f4962h;

    public f(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f4962h = constraintLayout;
        this.f4956a = constraintLayout2;
    }

    public static boolean a(int i8, int i9, int i10) {
        if (i8 == i9) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i8);
        View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i10 == size;
        }
        return false;
    }

    public final void b(o.d dVar, p.b bVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int iMax2;
        boolean z;
        int baseline;
        int i8;
        if (dVar == null) {
            return;
        }
        o.c cVar = dVar.J;
        o.c cVar2 = dVar.H;
        if (dVar.f4222f0 == 8) {
            bVar.f4595e = 0;
            bVar.f4596f = 0;
            bVar.f4597g = 0;
            return;
        }
        if (dVar.S == null) {
            return;
        }
        int i9 = bVar.f4592a;
        int i10 = bVar.f4593b;
        int i11 = bVar.f4594c;
        int i12 = bVar.d;
        int i13 = this.f4957b + this.f4958c;
        int i14 = this.d;
        View view = dVar.f4220e0;
        int iA = m.f.a(i9);
        if (iA == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        } else if (iA == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4960f, i14, -2);
        } else if (iA == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4960f, i14, -2);
            boolean z2 = dVar.f4241q == 1;
            int i15 = bVar.f4600j;
            if (i15 == 1 || i15 == 2) {
                boolean z8 = view.getMeasuredHeight() == dVar.k();
                if (bVar.f4600j == 2 || !z2 || ((z2 && z8) || dVar.x())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dVar.n(), 1073741824);
                }
            }
        } else if (iA != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i16 = this.f4960f;
            int i17 = cVar2 != null ? cVar2.f4209g : 0;
            if (cVar != null) {
                i17 += cVar.f4209g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i16, i14 + i17, -1);
        }
        int iA2 = m.f.a(i10);
        if (iA2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else if (iA2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4961g, i13, -2);
        } else if (iA2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4961g, i13, -2);
            boolean z9 = dVar.f4242r == 1;
            int i18 = bVar.f4600j;
            if (i18 == 1 || i18 == 2) {
                boolean z10 = view.getMeasuredWidth() == dVar.n();
                if (bVar.f4600j == 2 || !z9 || ((z9 && z10) || dVar.y())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(dVar.k(), 1073741824);
                }
            }
        } else if (iA2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i19 = this.f4961g;
            int i20 = cVar2 != null ? dVar.I.f4209g : 0;
            if (cVar != null) {
                i20 += dVar.K.f4209g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i19, i13 + i20, -1);
        }
        o.e eVar = (o.e) dVar.S;
        ConstraintLayout constraintLayout = this.f4962h;
        if (eVar != null && o.j.c(constraintLayout.f367j, 256) && view.getMeasuredWidth() == dVar.n() && view.getMeasuredWidth() < eVar.n() && view.getMeasuredHeight() == dVar.k() && view.getMeasuredHeight() < eVar.k() && view.getBaseline() == dVar.Z && !dVar.w() && a(dVar.F, iMakeMeasureSpec, dVar.n()) && a(dVar.G, iMakeMeasureSpec2, dVar.k())) {
            bVar.f4595e = dVar.n();
            bVar.f4596f = dVar.k();
            bVar.f4597g = dVar.Z;
            return;
        }
        boolean z11 = i9 == 3;
        boolean z12 = i10 == 3;
        boolean z13 = i10 == 4 || i10 == 1;
        boolean z14 = i9 == 4 || i9 == 1;
        boolean z15 = z11 && dVar.V > 0.0f;
        boolean z16 = z12 && dVar.V > 0.0f;
        if (view == null) {
            return;
        }
        e eVar2 = (e) view.getLayoutParams();
        int i21 = bVar.f4600j;
        if (i21 != 1 && i21 != 2 && z11 && dVar.f4241q == 0 && z12 && dVar.f4242r == 0) {
            i8 = -1;
            z = false;
            baseline = 0;
            iMax2 = 0;
            iMax = 0;
        } else {
            if ((view instanceof t) && (dVar instanceof o.g)) {
                ((t) view).j((o.g) dVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            dVar.F = iMakeMeasureSpec;
            dVar.G = iMakeMeasureSpec2;
            dVar.f4223g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i22 = dVar.f4244t;
            iMax = i22 > 0 ? Math.max(i22, measuredWidth) : measuredWidth;
            int i23 = dVar.f4245u;
            if (i23 > 0) {
                iMax = Math.min(i23, iMax);
            }
            int i24 = dVar.f4247w;
            iMax2 = i24 > 0 ? Math.max(i24, measuredHeight) : measuredHeight;
            int i25 = iMakeMeasureSpec2;
            int i26 = dVar.f4248x;
            if (i26 > 0) {
                iMax2 = Math.min(i26, iMax2);
            }
            if (!o.j.c(constraintLayout.f367j, 1)) {
                if (z15 && z13) {
                    iMax = (int) ((iMax2 * dVar.V) + 0.5f);
                } else if (z16 && z14) {
                    iMax2 = (int) ((iMax / dVar.V) + 0.5f);
                }
            }
            if (measuredWidth == iMax && measuredHeight == iMax2) {
                baseline = baseline2;
                i8 = -1;
                z = false;
            } else {
                if (measuredWidth != iMax) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax2 ? View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824) : i25;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                dVar.F = iMakeMeasureSpec;
                dVar.G = iMakeMeasureSpec3;
                z = false;
                dVar.f4223g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredWidth2;
                iMax2 = measuredHeight2;
                i8 = -1;
            }
        }
        boolean z17 = baseline != i8 ? true : z;
        bVar.f4599i = (iMax == bVar.f4594c && iMax2 == bVar.d) ? z : true;
        boolean z18 = eVar2.f4922b0 ? true : z17;
        if (z18 && baseline != -1 && dVar.Z != baseline) {
            bVar.f4599i = true;
        }
        bVar.f4595e = iMax;
        bVar.f4596f = iMax2;
        bVar.f4598h = z18;
        bVar.f4597g = baseline;
    }
}
