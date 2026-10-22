package e0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f2306a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f2307b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f2308c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f2309e;

    public g(ViewGroup viewGroup) {
        this.f2308c = viewGroup;
    }

    public final boolean a(float f3, float f7, boolean z) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedFling(this.f2308c, f3, f7, z);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e9);
            }
        }
        return false;
    }

    public final boolean b(float f3, float f7) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedPreFling(this.f2308c, f3, f7);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e9);
            }
        }
        return false;
    }

    public final boolean c(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
        ViewParent viewParentE;
        int i11;
        int i12;
        int[] iArr3;
        if (!this.d || (viewParentE = e(i10)) == null) {
            return false;
        }
        if (i8 == 0 && i9 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f2308c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i11 = iArr2[0];
            i12 = iArr2[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr == null) {
            if (this.f2309e == null) {
                this.f2309e = new int[2];
            }
            iArr3 = this.f2309e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentE instanceof h) {
            ((h) viewParentE).c(viewGroup, i8, i9, iArr3, i10);
            viewGroup = viewGroup;
        } else if (i10 == 0) {
            try {
                viewParentE.onNestedPreScroll(viewGroup, i8, i9, iArr3);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e9);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i11;
            iArr2[1] = iArr2[1] - i12;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i8, int i9, int i10, int i11, int[] iArr, int i12, int[] iArr2) {
        ViewParent viewParentE;
        int i13;
        int i14;
        int[] iArr3;
        if (this.d && (viewParentE = e(i12)) != null) {
            if (i8 != 0 || i9 != 0 || i10 != 0 || i11 != 0) {
                ViewGroup viewGroup = this.f2308c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i13 = iArr[0];
                    i14 = iArr[1];
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                if (iArr2 == null) {
                    if (this.f2309e == null) {
                        this.f2309e = new int[2];
                    }
                    int[] iArr4 = this.f2309e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentE instanceof i) {
                    ((i) viewParentE).d(viewGroup, i8, i9, i10, i11, i12, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i10;
                    iArr3[1] = iArr3[1] + i11;
                    if (viewParentE instanceof h) {
                        ((h) viewParentE).e(viewGroup, i8, i9, i10, i11, i12);
                    } else if (i12 == 0) {
                        try {
                            viewParentE.onNestedScroll(viewGroup, i8, i9, i10, i11);
                        } catch (AbstractMethodError e9) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e9);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i13;
                    iArr[1] = iArr[1] - i14;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i8) {
        if (i8 == 0) {
            return this.f2306a;
        }
        if (i8 != 1) {
            return null;
        }
        return this.f2307b;
    }

    public final boolean f(int i8) {
        return e(i8) != null;
    }

    public final boolean g(int i8, int i9) {
        boolean zOnStartNestedScroll;
        if (!f(i9)) {
            if (this.d) {
                View view = this.f2308c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof h;
                    if (z) {
                        zOnStartNestedScroll = ((h) parent).f(view2, view, i8, i9);
                    } else if (i9 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i8);
                        } catch (AbstractMethodError e9) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e9);
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i9 == 0) {
                            this.f2306a = parent;
                        } else if (i9 == 1) {
                            this.f2307b = parent;
                        }
                        if (z) {
                            ((h) parent).a(view2, view, i8, i9);
                        } else if (i9 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i8);
                            } catch (AbstractMethodError e10) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e10);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i8) {
        ViewParent viewParentE = e(i8);
        if (viewParentE != null) {
            boolean z = viewParentE instanceof h;
            ViewGroup viewGroup = this.f2308c;
            if (z) {
                ((h) viewParentE).b(viewGroup, i8);
            } else if (i8 == 0) {
                try {
                    viewParentE.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e9) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e9);
                }
            }
            if (i8 == 0) {
                this.f2306a = null;
            } else {
                if (i8 != 1) {
                    return;
                }
                this.f2307b = null;
            }
        }
    }
}
