package j1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: f, reason: collision with root package name */
    public static final fb.c f5240f = new fb.c(7);

    /* renamed from: a, reason: collision with root package name */
    public final Rect f5241a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f5242b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final Rect f5243c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final k1 f5244d = new k1(new b4.b(this));

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f5245e = new ArrayList();

    public static void d(ViewGroup viewGroup, Rect rect) {
        int height = viewGroup.getHeight() + viewGroup.getScrollY();
        int width = viewGroup.getWidth() + viewGroup.getScrollX();
        rect.set(width, height, width, height);
    }

    public final View a(int i2, Rect rect, View view, ViewGroup viewGroup, ArrayList arrayList) {
        ArrayList arrayList2;
        int iIndexOf;
        int iLastIndexOf;
        int i10;
        Rect rect2 = this.f5241a;
        if (view != null) {
            view.getFocusedRect(rect2);
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        } else if (rect != null) {
            rect2.set(rect);
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 17 || i2 == 33) {
                    d(viewGroup, rect2);
                } else if (i2 == 66 || i2 == 130) {
                    int scrollY = viewGroup.getScrollY();
                    int scrollX = viewGroup.getScrollX();
                    rect2.set(scrollX, scrollY, scrollX, scrollY);
                }
            } else if (viewGroup.getLayoutDirection() == 1) {
                d(viewGroup, rect2);
            } else {
                int scrollY2 = viewGroup.getScrollY();
                int scrollX2 = viewGroup.getScrollX();
                rect2.set(scrollX2, scrollY2, scrollX2, scrollY2);
            }
        } else if (viewGroup.getLayoutDirection() == 1) {
            int scrollY3 = viewGroup.getScrollY();
            int scrollX3 = viewGroup.getScrollX();
            rect2.set(scrollX3, scrollY3, scrollX3, scrollY3);
        } else {
            d(viewGroup, rect2);
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
                return c(i2, rect2, view, viewGroup, arrayList);
            }
            throw new IllegalArgumentException(n.f.c(i2, "Unknown direction: "));
        }
        k1 k1Var = this.f5244d;
        try {
            k1Var.a(arrayList, viewGroup);
            Collections.sort(arrayList, k1Var);
            k1Var.f5217c.a();
            k1Var.f5216b.b();
            k1Var.f5218d.a();
            k1Var.f5215a.a();
            int size = arrayList.size();
            View viewC = null;
            if (size < 2) {
                return null;
            }
            if (i2 == 1) {
                arrayList2 = arrayList;
                if (size >= 2) {
                    viewC = (view == null || (iIndexOf = arrayList2.indexOf(view)) <= 0) ? (View) arrayList2.get(size - 1) : (View) arrayList2.get(iIndexOf - 1);
                }
            } else if (i2 == 2) {
                arrayList2 = arrayList;
                if (size >= 2) {
                    viewC = (view == null || (iLastIndexOf = arrayList2.lastIndexOf(view)) < 0 || (i10 = iLastIndexOf + 1) >= size) ? (View) arrayList2.get(0) : (View) arrayList2.get(i10);
                }
            } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
                arrayList2 = arrayList;
                viewC = c(i2, this.f5241a, view, viewGroup, arrayList2);
            } else {
                arrayList2 = arrayList;
            }
            return viewC == null ? (View) arrayList2.get(size - 1) : viewC;
        } catch (Throwable th) {
            k1Var.f5217c.a();
            k1Var.f5216b.b();
            k1Var.f5218d.a();
            k1Var.f5215a.a();
            throw th;
        }
    }

    public final View b(ViewGroup viewGroup, View view, int i2) {
        ViewGroup viewGroup2;
        View viewA = null;
        if (view == null || view == viewGroup) {
            viewGroup2 = viewGroup;
        } else {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup3 = null;
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                if (parent != viewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) parent;
                    if (viewGroup4.getTouchscreenBlocksFocus() && view.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                        viewGroup3 = viewGroup4;
                    }
                    parent = viewGroup4.getParent();
                } else {
                    if (viewGroup3 == null) {
                        break;
                    }
                    viewGroup2 = viewGroup3;
                }
            }
            viewGroup2 = viewGroup;
        }
        View viewF = k0.f(view, viewGroup2, i2);
        boolean z4 = true;
        View viewF2 = viewF;
        while (viewF != null) {
            if (viewF.isFocusable() && viewF.getVisibility() == 0 && (!viewF.isInTouchMode() || viewF.isFocusableInTouchMode())) {
                viewA = viewF;
                break;
            }
            viewF = k0.f(viewF, viewGroup2, i2);
            boolean z10 = !z4;
            if (!z4) {
                viewF2 = viewF2 != null ? k0.f(viewF2, viewGroup2, i2) : null;
                if (viewF2 == viewF) {
                    break;
                }
            }
            z4 = z10;
        }
        if (viewA != null) {
            return viewA;
        }
        ArrayList<View> arrayList = this.f5245e;
        try {
            arrayList.clear();
            viewGroup2.addFocusables(arrayList, i2, viewGroup2.isInTouchMode() ? 1 : 0);
            if (!arrayList.isEmpty()) {
                viewA = a(i2, null, view, viewGroup2, arrayList);
            }
            arrayList.clear();
            return viewA;
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    public final View c(int i2, Rect rect, View view, ViewGroup viewGroup, ArrayList arrayList) {
        Rect rect2 = this.f5242b;
        rect2.set(rect);
        if (i2 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i2 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i2 == 66) {
            rect2.offset((-rect.width()) - 1, 0);
        } else if (i2 == 130) {
            rect2.offset(0, (-rect.height()) - 1);
        }
        int size = arrayList.size();
        View view2 = null;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = (View) arrayList.get(i10);
            if (!q7.k.a(view3, view) && !q7.k.a(view3, viewGroup)) {
                Rect rect3 = this.f5243c;
                view3.getFocusedRect(rect3);
                viewGroup.offsetDescendantRectToMyCoords(view3, rect3);
                t0.c cVarQ = u0.z.q(rect3);
                t0.c cVarQ2 = u0.z.q(rect2);
                t0.c cVarQ3 = u0.z.q(rect);
                s0.b bVarA = s0.e.A(i2);
                if (s0.e.o(cVarQ, cVarQ2, cVarQ3, bVarA != null ? bVarA.f9166a : 1)) {
                    rect2.set(rect3);
                    view2 = view3;
                }
            }
        }
        return view2;
    }
}
