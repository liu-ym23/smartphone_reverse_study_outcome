package s2;

import android.view.View;
import android.view.Window;
import k0.k1;
import k0.v1;
import n3.m1;
import n3.s;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends v1.a implements s {

    /* renamed from: m, reason: collision with root package name */
    public Window f11348m;

    /* renamed from: n, reason: collision with root package name */
    public k1 f11349n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11350o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11351p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11352q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11353r;

    @Override // v1.a
    public final void a(int i, k0.s sVar) {
        sVar.Z(1735448596);
        int i3 = (sVar.h(this) ? 4 : 2) | i;
        if (sVar.P(i3 & 1, (i3 & 3) != 2)) {
            ((p) this.f11349n.getValue()).invoke(sVar, 0);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.s(i, 4, this);
        }
    }

    @Override // v1.a
    public final void d(int i, int i3, int i10, int i11) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i12 = i10 - i;
        int i13 = i11 - i3;
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int paddingLeft = (((i12 - measuredWidth) - paddingRight) / 2) + getPaddingLeft();
        int paddingTop = (((i13 - measuredHeight) - paddingBottom) / 2) + getPaddingTop();
        childAt.layout(paddingLeft, paddingTop, measuredWidth + paddingLeft, measuredHeight + paddingTop);
    }

    @Override // v1.a
    public final void e(int i, int i3) {
        Window window = this.f11348m;
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.e(i, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int i10 = (mode != Integer.MIN_VALUE || this.f11350o || this.f11351p || window.getAttributes().height != -2) ? size2 : size2 + 1;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i11 = size - paddingRight;
        if (i11 < 0) {
            i11 = 0;
        }
        int i12 = i10 - paddingBottom;
        int i13 = i12 >= 0 ? i12 : 0;
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 != 0) {
            i = View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
        }
        if (mode != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
        }
        childAt.measure(i, i3);
        if (mode2 == Integer.MIN_VALUE) {
            size = Math.min(size, childAt.getMeasuredWidth() + paddingRight);
        } else if (mode2 != 1073741824) {
            size = childAt.getMeasuredWidth() + paddingRight;
        }
        setMeasuredDimension(size, mode != Integer.MIN_VALUE ? mode != 1073741824 ? childAt.getMeasuredHeight() + paddingBottom : size2 : Math.min(size2, childAt.getMeasuredHeight() + paddingBottom));
        if (this.f11351p || childAt.getMeasuredHeight() + paddingBottom <= size2 || window.getAttributes().height != -2) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        if (this.f11350o) {
            return;
        }
        window.setLayout(-1, -1);
    }

    @Override // v1.a
    public final boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f11353r;
    }

    @Override // n3.s
    public final m1 p(View view, m1 m1Var) {
        if (!this.f11351p) {
            View childAt = getChildAt(0);
            int iMax = Math.max(0, childAt.getLeft());
            int iMax2 = Math.max(0, childAt.getTop());
            int iMax3 = Math.max(0, getWidth() - childAt.getRight());
            int iMax4 = Math.max(0, getHeight() - childAt.getBottom());
            if (iMax != 0 || iMax2 != 0 || iMax3 != 0 || iMax4 != 0) {
                return m1Var.f8737a.r(iMax, iMax2, iMax3, iMax4);
            }
        }
        return m1Var;
    }
}
