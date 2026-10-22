package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: androidx.core.view.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0475u {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f9825a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f9826b;

    /* renamed from: c, reason: collision with root package name */
    private final View f9827c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9828d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f9829e;

    public C0475u(View view) {
        this.f9827c = view;
    }

    private boolean h(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        ViewParent viewParentI;
        int i10;
        int i11;
        int[] iArr3;
        if (!m() || (viewParentI = i(i9)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f9827c.getLocationInWindow(iArr);
            i10 = iArr[0];
            i11 = iArr[1];
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        P.d(viewParentI, this.f9827c, i5, i6, i7, i8, i9, iArr3);
        if (iArr != null) {
            this.f9827c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i10;
            iArr[1] = iArr[1] - i11;
        }
        return true;
    }

    private ViewParent i(int i5) {
        if (i5 == 0) {
            return this.f9825a;
        }
        if (i5 != 1) {
            return null;
        }
        return this.f9826b;
    }

    private int[] j() {
        if (this.f9829e == null) {
            this.f9829e = new int[2];
        }
        return this.f9829e;
    }

    private void o(int i5, ViewParent viewParent) {
        if (i5 == 0) {
            this.f9825a = viewParent;
        } else {
            if (i5 != 1) {
                return;
            }
            this.f9826b = viewParent;
        }
    }

    public boolean a(float f5, float f6, boolean z5) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return P.a(viewParentI, this.f9827c, f5, f6, z5);
    }

    public boolean b(float f5, float f6) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return P.b(viewParentI, this.f9827c, f5, f6);
    }

    public boolean c(int i5, int i6, int[] iArr, int[] iArr2) {
        return d(i5, i6, iArr, iArr2, 0);
    }

    public boolean d(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        ViewParent viewParentI;
        int i8;
        int i9;
        if (!m() || (viewParentI = i(i7)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f9827c.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i9 = iArr2[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        P.c(viewParentI, this.f9827c, i5, i6, iArr3, i7);
        if (iArr2 != null) {
            this.f9827c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i9;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public void e(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        h(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public boolean f(int i5, int i6, int i7, int i8, int[] iArr) {
        return h(i5, i6, i7, i8, iArr, 0, null);
    }

    public boolean g(int i5, int i6, int i7, int i8, int[] iArr, int i9) {
        return h(i5, i6, i7, i8, iArr, i9, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i5) {
        return i(i5) != null;
    }

    public boolean m() {
        return this.f9828d;
    }

    public void n(boolean z5) {
        if (this.f9828d) {
            H.K0(this.f9827c);
        }
        this.f9828d = z5;
    }

    public boolean p(int i5) {
        return q(i5, 0);
    }

    public boolean q(int i5, int i6) {
        if (l(i6)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f9827c;
        for (ViewParent parent = this.f9827c.getParent(); parent != null; parent = parent.getParent()) {
            if (P.f(parent, view, this.f9827c, i5, i6)) {
                o(i6, parent);
                P.e(parent, view, this.f9827c, i5, i6);
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

    public void s(int i5) {
        ViewParent viewParentI = i(i5);
        if (viewParentI != null) {
            P.g(viewParentI, this.f9827c, i5);
            o(i5, null);
        }
    }
}
