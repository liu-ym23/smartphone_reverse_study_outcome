package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: androidx.core.view.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1334w {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f13211a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f13212b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13213c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13214d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f13215e;

    public C1334w(View view) {
        this.f13213c = view;
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return S.a(viewParentI, this.f13213c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return S.b(viewParentI, this.f13213c, f10, f11);
    }

    public boolean c(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent viewParentI;
        int i13;
        int i14;
        if (!m() || (viewParentI = i(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f13213c.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        S.c(viewParentI, this.f13213c, i10, i11, iArr3, i12);
        if (iArr2 != null) {
            this.f13213c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        h(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, int[] iArr) {
        return h(i10, i11, i12, i13, iArr, 0, null);
    }

    public boolean g(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return h(i10, i11, i12, i13, iArr, i14, null);
    }

    public final boolean h(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent viewParentI;
        int i15;
        int i16;
        int[] iArr3;
        if (!m() || (viewParentI = i(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f13213c.getLocationInWindow(iArr);
            i15 = iArr[0];
            i16 = iArr[1];
        } else {
            i15 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        S.d(viewParentI, this.f13213c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            this.f13213c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i15;
            iArr[1] = iArr[1] - i16;
        }
        return true;
    }

    public final ViewParent i(int i10) {
        if (i10 == 0) {
            return this.f13211a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f13212b;
    }

    public final int[] j() {
        if (this.f13215e == null) {
            this.f13215e = new int[2];
        }
        return this.f13215e;
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i10) {
        return i(i10) != null;
    }

    public boolean m() {
        return this.f13214d;
    }

    public void n(boolean z10) {
        if (this.f13214d) {
            N.H0(this.f13213c);
        }
        this.f13214d = z10;
    }

    public final void o(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f13211a = viewParent;
        } else {
            if (i10 != 1) {
                return;
            }
            this.f13212b = viewParent;
        }
    }

    public boolean p(int i10) {
        return q(i10, 0);
    }

    public boolean q(int i10, int i11) {
        if (l(i11)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f13213c;
        for (ViewParent parent = this.f13213c.getParent(); parent != null; parent = parent.getParent()) {
            if (S.f(parent, view, this.f13213c, i10, i11)) {
                o(i11, parent);
                S.e(parent, view, this.f13213c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i10) {
        ViewParent viewParentI = i(i10);
        if (viewParentI != null) {
            S.g(viewParentI, this.f13213c, i10);
            o(i10, null);
        }
    }
}
