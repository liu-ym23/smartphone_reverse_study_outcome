package androidx.recyclerview.widget;

import a8.b;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import f0.g;
import java.util.Arrays;
import m0.f;
import r6.x;
import v0.b0;
import v0.c0;
import v0.h0;
import v0.k0;
import v0.m;
import v0.p;
import v0.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public final x A;
    public final Rect B;

    /* renamed from: v, reason: collision with root package name */
    public final int f741v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f742w;

    /* renamed from: x, reason: collision with root package name */
    public View[] f743x;
    public final SparseIntArray y;
    public final SparseIntArray z;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f741v = -1;
        this.y = new SparseIntArray();
        this.z = new SparseIntArray();
        x xVar = new x(4);
        this.A = xVar;
        this.B = new Rect();
        int i10 = b0.B(context, attributeSet, i8, i9).f5901c;
        if (i10 == this.f741v) {
            return;
        }
        if (i10 < 1) {
            throw new IllegalArgumentException(b.j(i10, "Span count should be at least 1. Provided "));
        }
        this.f741v = i10;
        ((SparseIntArray) xVar.f5220a).clear();
        W();
    }

    @Override // v0.b0
    public final int C(h0 h0Var, k0 k0Var) {
        if (this.f744k == 0) {
            return this.f741v;
        }
        if (k0Var.a() < 1) {
            return 0;
        }
        return v0(k0Var.a() - 1, h0Var, k0Var) + 1;
    }

    @Override // v0.b0
    public final void O(h0 h0Var, k0 k0Var, View view, g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        if (view.getLayoutParams() instanceof m) {
            throw null;
        }
        N(view, gVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int X(int i8, h0 h0Var, k0 k0Var) {
        y0();
        t0();
        return super.X(i8, h0Var, k0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int Y(int i8, h0 h0Var, k0 k0Var) {
        y0();
        t0();
        return super.Y(i8, h0Var, k0Var);
    }

    @Override // v0.b0
    public final boolean e(c0 c0Var) {
        return c0Var instanceof m;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int h(k0 k0Var) {
        return d0(k0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int i(k0 k0Var) {
        return e0(k0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int k(k0 k0Var) {
        return d0(k0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final int l(k0 k0Var) {
        return e0(k0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v0.b0
    public final c0 m() {
        return this.f744k == 0 ? new m(-2, -1) : new m(-1, -2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void m0(h0 h0Var, k0 k0Var, q qVar, p pVar) {
        int iW0;
        int i8;
        int i9;
        int i10;
        int iF;
        int iX;
        int iZ;
        int iF2;
        int iR;
        int iR2;
        ?? r13;
        int i11;
        View viewB;
        int i12;
        int iL = this.f746m.l();
        boolean z = iL != 1073741824;
        int i13 = q() > 0 ? this.f742w[this.f741v] : 0;
        if (z) {
            y0();
        }
        boolean z2 = qVar.f5911e == 1;
        if (z2) {
            iW0 = this.f741v;
        } else {
            int i14 = qVar.d;
            boolean z8 = k0Var.f5868e;
            x xVar = this.A;
            if (z8) {
                int i15 = this.z.get(i14, -1);
                if (i15 != -1) {
                    i12 = i15;
                } else {
                    int iB = h0Var.b(i14);
                    if (iB == -1) {
                        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i14);
                        i12 = 0;
                    } else {
                        xVar.getClass();
                        i12 = iB % this.f741v;
                    }
                }
            } else {
                xVar.getClass();
                i12 = i14 % this.f741v;
            }
            iW0 = w0(qVar.d, h0Var, k0Var) + i12;
        }
        int i16 = 0;
        while (i16 < this.f741v && (i11 = qVar.d) >= 0 && i11 < k0Var.a() && iW0 > 0) {
            int i17 = qVar.d;
            int iW02 = w0(i17, h0Var, k0Var);
            if (iW02 > this.f741v) {
                throw new IllegalArgumentException(f.e(b.t("Item at position ", i17, " requires ", iW02, " spans but GridLayoutManager has only "), this.f741v, " spans."));
            }
            iW0 -= iW02;
            if (iW0 < 0 || (viewB = qVar.b(h0Var)) == null) {
                break;
            }
            this.f743x[i16] = viewB;
            i16++;
        }
        if (i16 == 0) {
            pVar.f5905b = true;
            return;
        }
        if (z2) {
            i10 = 1;
            i9 = i16;
            i8 = 0;
        } else {
            i8 = i16 - 1;
            i9 = -1;
            i10 = -1;
        }
        int i18 = 0;
        while (i8 != i9) {
            View view = this.f743x[i8];
            m mVar = (m) view.getLayoutParams();
            int iW03 = w0(b0.A(view), h0Var, k0Var);
            mVar.f5878e = iW03;
            mVar.d = i18;
            i18 += iW03;
            i8 += i10;
        }
        float f3 = 0.0f;
        int i19 = 0;
        for (int i20 = 0; i20 < i16; i20++) {
            View view2 = this.f743x[i20];
            if (qVar.f5916j != null) {
                r13 = 0;
                r13 = 0;
                if (z2) {
                    a(view2, -1, true);
                } else {
                    a(view2, 0, true);
                }
            } else if (z2) {
                r13 = 0;
                a(view2, -1, false);
            } else {
                r13 = 0;
                a(view2, 0, false);
            }
            RecyclerView recyclerView = this.f5793b;
            Rect rect = this.B;
            if (recyclerView == null) {
                rect.set(r13, r13, r13, r13);
            } else {
                rect.set(recyclerView.t(view2));
            }
            x0(view2, iL, r13);
            int iE = this.f746m.e(view2);
            if (iE > i19) {
                i19 = iE;
            }
            float f7 = (this.f746m.f(view2) * 1.0f) / ((m) view2.getLayoutParams()).f5878e;
            if (f7 > f3) {
                f3 = f7;
            }
        }
        if (z) {
            s0(Math.max(Math.round(f3 * this.f741v), i13));
            int i21 = 0;
            for (int i22 = 0; i22 < i16; i22++) {
                View view3 = this.f743x[i22];
                x0(view3, 1073741824, true);
                int iE2 = this.f746m.e(view3);
                if (iE2 > i21) {
                    i21 = iE2;
                }
            }
            i19 = i21;
        }
        for (int i23 = 0; i23 < i16; i23++) {
            View view4 = this.f743x[i23];
            if (this.f746m.e(view4) != i19) {
                m mVar2 = (m) view4.getLayoutParams();
                Rect rect2 = mVar2.f5804a;
                int i24 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar2).topMargin + ((ViewGroup.MarginLayoutParams) mVar2).bottomMargin;
                int i25 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) mVar2).leftMargin + ((ViewGroup.MarginLayoutParams) mVar2).rightMargin;
                int iU0 = u0(mVar2.d, mVar2.f5878e);
                if (this.f744k == 1) {
                    iR2 = b0.r(false, iU0, 1073741824, i25, ((ViewGroup.MarginLayoutParams) mVar2).width);
                    iR = View.MeasureSpec.makeMeasureSpec(i19 - i24, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - i25, 1073741824);
                    iR = b0.r(false, iU0, 1073741824, i24, ((ViewGroup.MarginLayoutParams) mVar2).height);
                    iR2 = iMakeMeasureSpec;
                }
                if (b0(view4, iR2, iR, (c0) view4.getLayoutParams())) {
                    view4.measure(iR2, iR);
                }
            }
        }
        pVar.f5904a = i19;
        if (this.f744k != 1) {
            if (qVar.f5912f == -1) {
                int i26 = qVar.f5909b;
                iX = i26 - i19;
                iF = i26;
            } else {
                int i27 = qVar.f5909b;
                iF = i27 + i19;
                iX = i27;
            }
            iZ = 0;
            iF2 = 0;
        } else if (qVar.f5912f == -1) {
            iF2 = qVar.f5909b;
            iZ = iF2 - i19;
            iX = 0;
            iF = 0;
        } else {
            int i28 = qVar.f5909b;
            iZ = i28;
            iF = 0;
            iF2 = i28 + i19;
            iX = 0;
        }
        if (i16 <= 0) {
            Arrays.fill(this.f743x, (Object) null);
            return;
        }
        View view5 = this.f743x[0];
        m mVar3 = (m) view5.getLayoutParams();
        if (this.f744k != 1) {
            iZ = z() + this.f742w[mVar3.d];
            iF2 = this.f746m.f(view5) + iZ;
        } else if (l0()) {
            iF = this.f742w[this.f741v - mVar3.d] + x();
            iX = iF - this.f746m.f(view5);
        } else {
            iX = x() + this.f742w[mVar3.d];
            iF = this.f746m.f(view5) + iX;
        }
        b0.G(view5, iX, iZ, iF, iF2);
        mVar3.getClass();
        throw null;
    }

    @Override // v0.b0
    public final c0 n(Context context, AttributeSet attributeSet) {
        m mVar = new m(context, attributeSet);
        mVar.d = -1;
        mVar.f5878e = 0;
        return mVar;
    }

    @Override // v0.b0
    public final c0 o(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            m mVar = new m((ViewGroup.MarginLayoutParams) layoutParams);
            mVar.d = -1;
            mVar.f5878e = 0;
            return mVar;
        }
        m mVar2 = new m(layoutParams);
        mVar2.d = -1;
        mVar2.f5878e = 0;
        return mVar2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void r0(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.r0(false);
    }

    @Override // v0.b0
    public final int s(h0 h0Var, k0 k0Var) {
        if (this.f744k == 1) {
            return this.f741v;
        }
        if (k0Var.a() < 1) {
            return 0;
        }
        return v0(k0Var.a() - 1, h0Var, k0Var) + 1;
    }

    public final void s0(int i8) {
        int i9;
        int[] iArr = this.f742w;
        int i10 = this.f741v;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i8) {
            iArr = new int[i10 + 1];
        }
        int i11 = 0;
        iArr[0] = 0;
        int i12 = i8 / i10;
        int i13 = i8 % i10;
        int i14 = 0;
        for (int i15 = 1; i15 <= i10; i15++) {
            i11 += i13;
            if (i11 <= 0 || i10 - i11 >= i13) {
                i9 = i12;
            } else {
                i9 = i12 + 1;
                i11 -= i10;
            }
            i14 += i9;
            iArr[i15] = i14;
        }
        this.f742w = iArr;
    }

    public final void t0() {
        View[] viewArr = this.f743x;
        if (viewArr == null || viewArr.length != this.f741v) {
            this.f743x = new View[this.f741v];
        }
    }

    public final int u0(int i8, int i9) {
        if (this.f744k != 1 || !l0()) {
            int[] iArr = this.f742w;
            return iArr[i9 + i8] - iArr[i8];
        }
        int[] iArr2 = this.f742w;
        int i10 = this.f741v;
        return iArr2[i10 - i8] - iArr2[(i10 - i8) - i9];
    }

    public final int v0(int i8, h0 h0Var, k0 k0Var) {
        boolean z = k0Var.f5868e;
        x xVar = this.A;
        if (!z) {
            xVar.getClass();
            return x.f(i8, this.f741v);
        }
        int iB = h0Var.b(i8);
        if (iB != -1) {
            xVar.getClass();
            return x.f(iB, this.f741v);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i8);
        return 0;
    }

    public final int w0(int i8, h0 h0Var, k0 k0Var) {
        boolean z = k0Var.f5868e;
        x xVar = this.A;
        if (!z) {
            xVar.getClass();
            return 1;
        }
        int i9 = this.y.get(i8, -1);
        if (i9 != -1) {
            return i9;
        }
        if (h0Var.b(i8) != -1) {
            xVar.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i8);
        return 1;
    }

    public final void x0(View view, int i8, boolean z) {
        int iR;
        int iR2;
        m mVar = (m) view.getLayoutParams();
        Rect rect = mVar.f5804a;
        int i9 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
        int i10 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
        int iU0 = u0(mVar.d, mVar.f5878e);
        if (this.f744k == 1) {
            iR2 = b0.r(false, iU0, i8, i10, ((ViewGroup.MarginLayoutParams) mVar).width);
            iR = b0.r(true, this.f746m.n(), this.f5798h, i9, ((ViewGroup.MarginLayoutParams) mVar).height);
        } else {
            int iR3 = b0.r(false, iU0, i8, i9, ((ViewGroup.MarginLayoutParams) mVar).height);
            int iR4 = b0.r(true, this.f746m.n(), this.f5797g, i10, ((ViewGroup.MarginLayoutParams) mVar).width);
            iR = iR3;
            iR2 = iR4;
        }
        c0 c0Var = (c0) view.getLayoutParams();
        if (z ? b0(view, iR2, iR, c0Var) : a0(view, iR2, iR, c0Var)) {
            view.measure(iR2, iR);
        }
    }

    public final void y0() {
        int iW;
        int iZ;
        if (this.f744k == 1) {
            iW = this.f5799i - y();
            iZ = x();
        } else {
            iW = this.f5800j - w();
            iZ = z();
        }
        s0(iW - iZ);
    }
}
