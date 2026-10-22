package z2;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f16230a;

    /* renamed from: b, reason: collision with root package name */
    public int f16231b;

    /* renamed from: c, reason: collision with root package name */
    public int f16232c;

    /* renamed from: d, reason: collision with root package name */
    public int f16233d;

    /* renamed from: e, reason: collision with root package name */
    public int f16234e;

    /* renamed from: f, reason: collision with root package name */
    public int f16235f;

    /* renamed from: g, reason: collision with root package name */
    public int f16236g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f16237h;

    public e(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f16237h = constraintLayout;
        this.f16230a = constraintLayout2;
    }

    public static boolean a(int i, int i3, int i10) {
        if (i == i3) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i10 == size;
        }
        return false;
    }

    public final void b(w2.e eVar, x2.b bVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int iMax2;
        boolean z10;
        int baseline;
        int i;
        w2.d dVar = eVar.J;
        w2.d dVar2 = eVar.H;
        if (eVar.f0 == 8) {
            bVar.f15527e = 0;
            bVar.f15528f = 0;
            bVar.f15529g = 0;
            return;
        }
        if (eVar.S == null) {
            return;
        }
        int i3 = bVar.f15523a;
        int i10 = bVar.f15524b;
        int i11 = bVar.f15525c;
        int i12 = bVar.f15526d;
        int i13 = this.f16231b + this.f16232c;
        int i14 = this.f16233d;
        View view = eVar.e0;
        int iC = s.f.c(i3);
        if (iC == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        } else if (iC == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f16235f, i14, -2);
        } else if (iC == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f16235f, i14, -2);
            boolean z11 = eVar.f15187r == 1;
            int i15 = bVar.f15531j;
            if (i15 == 1 || i15 == 2) {
                boolean z12 = view.getMeasuredHeight() == eVar.i();
                if (bVar.f15531j == 2 || !z11 || ((z11 && z12) || eVar.y())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.o(), 1073741824);
                }
            }
        } else if (iC != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i16 = this.f16235f;
            int i17 = dVar2 != null ? dVar2.f15156g : 0;
            if (dVar != null) {
                i17 += dVar.f15156g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i16, i14 + i17, -1);
        }
        int iC2 = s.f.c(i10);
        if (iC2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else if (iC2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f16236g, i13, -2);
        } else if (iC2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f16236g, i13, -2);
            boolean z13 = eVar.f15188s == 1;
            int i18 = bVar.f15531j;
            if (i18 == 1 || i18 == 2) {
                boolean z14 = view.getMeasuredWidth() == eVar.o();
                if (bVar.f15531j == 2 || !z13 || ((z13 && z14) || eVar.z())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.i(), 1073741824);
                }
            }
        } else if (iC2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i19 = this.f16236g;
            int i20 = dVar2 != null ? eVar.I.f15156g : 0;
            if (dVar != null) {
                i20 += eVar.K.f15156g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i19, i13 + i20, -1);
        }
        w2.f fVar = (w2.f) eVar.S;
        ConstraintLayout constraintLayout = this.f16237h;
        if (fVar != null && w2.h.c(constraintLayout.f1003m, ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) && view.getMeasuredWidth() == eVar.o() && view.getMeasuredWidth() < fVar.o() && view.getMeasuredHeight() == eVar.i() && view.getMeasuredHeight() < fVar.i() && view.getBaseline() == eVar.Z && !eVar.x() && a(eVar.F, iMakeMeasureSpec, eVar.o()) && a(eVar.G, iMakeMeasureSpec2, eVar.i())) {
            bVar.f15527e = eVar.o();
            bVar.f15528f = eVar.i();
            bVar.f15529g = eVar.Z;
            return;
        }
        boolean z15 = i3 == 3;
        boolean z16 = i10 == 3;
        boolean z17 = i10 == 4 || i10 == 1;
        boolean z18 = i3 == 4 || i3 == 1;
        boolean z19 = z15 && eVar.V > 0.0f;
        boolean z20 = z16 && eVar.V > 0.0f;
        if (view == null) {
            return;
        }
        d dVar3 = (d) view.getLayoutParams();
        int i21 = bVar.f15531j;
        if (i21 != 1 && i21 != 2 && z15 && eVar.f15187r == 0 && z16 && eVar.f15188s == 0) {
            i = -1;
            z10 = false;
            baseline = 0;
            iMax2 = 0;
            iMax = 0;
        } else {
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            eVar.F = iMakeMeasureSpec;
            eVar.G = iMakeMeasureSpec2;
            eVar.f15168g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i22 = eVar.f15190u;
            iMax = i22 > 0 ? Math.max(i22, measuredWidth) : measuredWidth;
            int i23 = eVar.f15191v;
            if (i23 > 0) {
                iMax = Math.min(i23, iMax);
            }
            int i24 = eVar.f15193x;
            iMax2 = i24 > 0 ? Math.max(i24, measuredHeight) : measuredHeight;
            int i25 = iMakeMeasureSpec2;
            int i26 = eVar.f15194y;
            if (i26 > 0) {
                iMax2 = Math.min(i26, iMax2);
            }
            if (!w2.h.c(constraintLayout.f1003m, 1)) {
                if (z19 && z17) {
                    iMax = (int) ((iMax2 * eVar.V) + 0.5f);
                } else if (z20 && z18) {
                    iMax2 = (int) ((iMax / eVar.V) + 0.5f);
                }
            }
            if (measuredWidth == iMax && measuredHeight == iMax2) {
                baseline = baseline2;
                i = -1;
                z10 = false;
            } else {
                if (measuredWidth != iMax) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax2 ? View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824) : i25;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                eVar.F = iMakeMeasureSpec;
                eVar.G = iMakeMeasureSpec3;
                z10 = false;
                eVar.f15168g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredWidth2;
                iMax2 = measuredHeight2;
                i = -1;
            }
        }
        boolean z21 = baseline != i ? true : z10;
        bVar.i = (iMax == bVar.f15525c && iMax2 == bVar.f15526d) ? z10 : true;
        boolean z22 = dVar3.f16196c0 ? true : z21;
        if (z22 && baseline != -1 && eVar.Z != baseline) {
            bVar.i = true;
        }
        bVar.f15527e = iMax;
        bVar.f15528f = iMax2;
        bVar.f15530h = z22;
        bVar.f15529g = baseline;
    }
}
