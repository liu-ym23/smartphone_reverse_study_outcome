package n3;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f8740a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f8741b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f8742c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8743d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f8744e;

    public p(ViewGroup viewGroup) {
        this.f8742c = viewGroup;
    }

    public final boolean a(float f5, float f10, boolean z10) {
        ViewParent viewParentE;
        if (this.f8743d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedFling(this.f8742c, f5, f10, z10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e10);
            }
        }
        return false;
    }

    public final boolean b(float f5, float f10) {
        ViewParent viewParentE;
        if (this.f8743d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedPreFling(this.f8742c, f5, f10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e10);
            }
        }
        return false;
    }

    public final boolean c(int i, int i3, int[] iArr, int[] iArr2, int i10) {
        ViewParent viewParentE;
        int i11;
        int i12;
        int[] iArr3;
        if (!this.f8743d || (viewParentE = e(i10)) == null) {
            return false;
        }
        if (i == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f8742c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i11 = iArr2[0];
            i12 = iArr2[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr == null) {
            if (this.f8744e == null) {
                this.f8744e = new int[2];
            }
            iArr3 = this.f8744e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentE instanceof q) {
            ((q) viewParentE).q(viewGroup, i, i3, iArr3, i10);
            viewGroup = viewGroup;
        } else if (i10 == 0) {
            try {
                viewParentE.onNestedPreScroll(viewGroup, i, i3, iArr3);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e10);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i11;
            iArr2[1] = iArr2[1] - i12;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i, int i3, int i10, int i11, int[] iArr, int i12, int[] iArr2) {
        ViewParent viewParentE;
        int i13;
        int i14;
        int[] iArr3;
        if (this.f8743d && (viewParentE = e(i12)) != null) {
            if (i != 0 || i3 != 0 || i10 != 0 || i11 != 0) {
                ViewGroup viewGroup = this.f8742c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i13 = iArr[0];
                    i14 = iArr[1];
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                if (iArr2 == null) {
                    if (this.f8744e == null) {
                        this.f8744e = new int[2];
                    }
                    int[] iArr4 = this.f8744e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentE instanceof r) {
                    ((r) viewParentE).k(viewGroup, i, i3, i10, i11, i12, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i10;
                    iArr3[1] = iArr3[1] + i11;
                    if (viewParentE instanceof q) {
                        ((q) viewParentE).l(viewGroup, i, i3, i10, i11, i12);
                    } else if (i12 == 0) {
                        try {
                            viewParentE.onNestedScroll(viewGroup, i, i3, i10, i11);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e10);
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

    public final ViewParent e(int i) {
        if (i == 0) {
            return this.f8740a;
        }
        if (i != 1) {
            return null;
        }
        return this.f8741b;
    }

    public final boolean f(int i) {
        return e(i) != null;
    }

    public final boolean g(int i, int i3) {
        boolean zOnStartNestedScroll;
        if (!f(i3)) {
            if (this.f8743d) {
                View view = this.f8742c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z10 = parent instanceof q;
                    if (z10) {
                        zOnStartNestedScroll = ((q) parent).m(view2, view, i, i3);
                    } else if (i3 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e10);
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i3 == 0) {
                            this.f8740a = parent;
                        } else if (i3 == 1) {
                            this.f8741b = parent;
                        }
                        if (z10) {
                            ((q) parent).n(view2, view, i, i3);
                        } else if (i3 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i);
                            } catch (AbstractMethodError e11) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e11);
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

    public final void h(int i) {
        ViewParent viewParentE = e(i);
        if (viewParentE != null) {
            boolean z10 = viewParentE instanceof q;
            ViewGroup viewGroup = this.f8742c;
            if (z10) {
                ((q) viewParentE).j(i, viewGroup);
            } else if (i == 0) {
                try {
                    viewParentE.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e10);
                }
            }
            if (i == 0) {
                this.f8740a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.f8741b = null;
            }
        }
    }
}
