package K;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f999a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f1000b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1001c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1002d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1003e;

    public r(View view) {
        this.f1001c = view;
    }

    public final boolean a(float f4, float f5, boolean z4) {
        ViewParent viewParentF;
        if (!this.f1002d || (viewParentF = f(0)) == null) {
            return false;
        }
        try {
            return AbstractC0070b0.a(viewParentF, this.f1001c, f4, f5, z4);
        } catch (AbstractMethodError e4) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onNestedFling", e4);
            return false;
        }
    }

    public final boolean b(float f4, float f5) {
        ViewParent viewParentF;
        if (!this.f1002d || (viewParentF = f(0)) == null) {
            return false;
        }
        try {
            return AbstractC0070b0.b(viewParentF, this.f1001c, f4, f5);
        } catch (AbstractMethodError e4) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onNestedPreFling", e4);
            return false;
        }
    }

    public final boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        ViewParent viewParentF;
        int i7;
        int i8;
        int[] iArr3;
        if (!this.f1002d || (viewParentF = f(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f1001c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            int i9 = iArr2[0];
            i8 = iArr2[1];
            i7 = i9;
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            if (this.f1003e == null) {
                this.f1003e = new int[2];
            }
            iArr3 = this.f1003e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean z4 = viewParentF instanceof InterfaceC0086s;
        View view2 = this.f1001c;
        if (z4) {
            ((InterfaceC0086s) viewParentF).i(view2, i4, i5, iArr3, i6);
        } else if (i6 == 0) {
            try {
                AbstractC0070b0.c(viewParentF, view2, i4, i5, iArr3);
            } catch (AbstractMethodError e4) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onNestedPreScroll", e4);
            }
        }
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i8;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final void d(int i4, int i5, int i6, int[] iArr) {
        e(0, i4, 0, i5, null, i6, iArr);
    }

    public final boolean e(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        ViewParent viewParentF;
        int i9;
        int i10;
        int[] iArr3;
        if (!this.f1002d || (viewParentF = f(i8)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f1001c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i9 = iArr[0];
            i10 = iArr[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr2 == null) {
            if (this.f1003e == null) {
                this.f1003e = new int[2];
            }
            int[] iArr4 = this.f1003e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        boolean z4 = viewParentF instanceof InterfaceC0087t;
        View view2 = this.f1001c;
        if (z4) {
            ((InterfaceC0087t) viewParentF).p(view2, i4, i5, i6, i7, i8, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i6;
            iArr3[1] = iArr3[1] + i7;
            if (viewParentF instanceof InterfaceC0086s) {
                ((InterfaceC0086s) viewParentF).q(view2, i4, i5, i6, i7, i8);
            } else if (i8 == 0) {
                try {
                    AbstractC0070b0.d(viewParentF, view2, i4, i5, i6, i7);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onNestedScroll", e4);
                }
            }
        }
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i9;
            iArr[1] = iArr[1] - i10;
        }
        return true;
    }

    public final ViewParent f(int i4) {
        if (i4 == 0) {
            return this.f999a;
        }
        if (i4 != 1) {
            return null;
        }
        return this.f1000b;
    }

    public final boolean g(int i4) {
        return f(i4) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(int r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.g(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.f1002d
            if (r0 == 0) goto L7c
            android.view.View r0 = r8.f1001c
            android.view.ViewParent r2 = r0.getParent()
            r3 = r0
        L13:
            if (r2 == 0) goto L7c
            boolean r4 = r2 instanceof K.InterfaceC0086s
            java.lang.String r5 = "ViewParentCompat"
            java.lang.String r6 = "ViewParent "
            if (r4 == 0) goto L25
            r7 = r2
            K.s r7 = (K.InterfaceC0086s) r7
            boolean r7 = r7.r(r3, r0, r9, r10)
            goto L2b
        L25:
            if (r10 != 0) goto L70
            boolean r7 = K.AbstractC0070b0.f(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L5b
        L2b:
            if (r7 == 0) goto L70
            if (r10 == 0) goto L35
            if (r10 == r1) goto L32
            goto L37
        L32:
            r8.f1000b = r2
            goto L37
        L35:
            r8.f999a = r2
        L37:
            if (r4 == 0) goto L3f
            K.s r2 = (K.InterfaceC0086s) r2
            r2.d(r3, r0, r9, r10)
            goto L5a
        L3f:
            if (r10 != 0) goto L5a
            K.AbstractC0070b0.e(r2, r3, r0, r9)     // Catch: java.lang.AbstractMethodError -> L45
            goto L5a
        L45:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            r9.append(r2)
            java.lang.String r10 = " does not implement interface method onNestedScrollAccepted"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r5, r9, r8)
        L5a:
            return r1
        L5b:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r2)
            java.lang.String r6 = " does not implement interface method onStartNestedScroll"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.e(r5, r6, r4)
        L70:
            boolean r4 = r2 instanceof android.view.View
            if (r4 == 0) goto L77
            r3 = r2
            android.view.View r3 = (android.view.View) r3
        L77:
            android.view.ViewParent r2 = r2.getParent()
            goto L13
        L7c:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: K.r.h(int, int):boolean");
    }

    public final void i(int i4) {
        ViewParent viewParentF = f(i4);
        if (viewParentF != null) {
            boolean z4 = viewParentF instanceof InterfaceC0086s;
            View view = this.f1001c;
            if (z4) {
                ((InterfaceC0086s) viewParentF).n(i4, view);
            } else if (i4 == 0) {
                try {
                    AbstractC0070b0.g(viewParentF, view);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentF + " does not implement interface method onStopNestedScroll", e4);
                }
            }
            if (i4 == 0) {
                this.f999a = null;
            } else {
                if (i4 != 1) {
                    return;
                }
                this.f1000b = null;
            }
        }
    }
}
