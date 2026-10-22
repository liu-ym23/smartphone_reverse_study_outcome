package v1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: f, reason: collision with root package name */
    public static final ae.b f14416f = new ae.b(5);

    /* renamed from: a, reason: collision with root package name */
    public Rect f14417a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f14418b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f14419c;

    /* renamed from: d, reason: collision with root package name */
    public e1 f14420d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f14421e;

    public static void d(ViewGroup viewGroup, Rect rect) {
        int height = viewGroup.getHeight() + viewGroup.getScrollY();
        int width = viewGroup.getWidth() + viewGroup.getScrollX();
        rect.set(width, height, width, height);
    }

    public final View a(int i, Rect rect, View view, ViewGroup viewGroup, ArrayList arrayList) {
        int iIndexOf;
        int iLastIndexOf;
        int i3;
        Rect rect2 = this.f14417a;
        if (view != null) {
            view.getFocusedRect(rect2);
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        } else if (rect != null) {
            rect2.set(rect);
        } else if (i != 1) {
            if (i != 2) {
                if (i == 17 || i == 33) {
                    d(viewGroup, rect2);
                } else if (i == 66 || i == 130) {
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
        if (i != 1 && i != 2) {
            if (i == 17 || i == 33 || i == 66 || i == 130) {
                return c(i, rect2, view, viewGroup, arrayList);
            }
            g5.f.s(k0.a.j(i, "Unknown direction: "));
            return null;
        }
        e1 e1Var = this.f14420d;
        try {
            e1Var.a(arrayList, viewGroup);
            Collections.sort(arrayList, e1Var);
            e1Var.f14410g.a();
            e1Var.f14409f.b();
            e1Var.f14411h.a();
            e1Var.f14408c.a();
            int size = arrayList.size();
            View viewC = null;
            if (size < 2) {
                return null;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 17 || i == 33 || i == 66 || i == 130) {
                        viewC = c(i, this.f14417a, view, viewGroup, arrayList);
                    }
                } else if (size >= 2) {
                    viewC = (view == null || (iLastIndexOf = arrayList.lastIndexOf(view)) < 0 || (i3 = iLastIndexOf + 1) >= size) ? (View) arrayList.get(0) : (View) arrayList.get(i3);
                }
            } else if (size >= 2) {
                viewC = (view == null || (iIndexOf = arrayList.indexOf(view)) <= 0) ? (View) arrayList.get(size - 1) : (View) arrayList.get(iIndexOf - 1);
            }
            return viewC == null ? (View) arrayList.get(size - 1) : viewC;
        } catch (Throwable th) {
            e1Var.f14410g.a();
            e1Var.f14409f.b();
            e1Var.f14411h.a();
            e1Var.f14408c.a();
            throw th;
        }
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
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
        View viewI = g0.i(view, viewGroup2, i);
        boolean z10 = true;
        View viewI2 = viewI;
        while (viewI != null) {
            if (viewI.isFocusable() && viewI.getVisibility() == 0 && (!viewI.isInTouchMode() || viewI.isFocusableInTouchMode())) {
                viewA = viewI;
                break;
            }
            viewI = g0.i(viewI, viewGroup2, i);
            boolean z11 = !z10;
            if (!z10) {
                viewI2 = viewI2 != null ? g0.i(viewI2, viewGroup2, i) : null;
                if (viewI2 == viewI) {
                    break;
                }
            }
            z10 = z11;
        }
        if (viewA != null) {
            return viewA;
        }
        ArrayList<View> arrayList = this.f14421e;
        try {
            arrayList.clear();
            viewGroup2.addFocusables(arrayList, i, viewGroup2.isInTouchMode() ? 1 : 0);
            if (!arrayList.isEmpty()) {
                viewA = a(i, null, view, viewGroup2, arrayList);
            }
            arrayList.clear();
            return viewA;
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    public final View c(int i, Rect rect, View view, ViewGroup viewGroup, ArrayList arrayList) {
        Rect rect2 = this.f14419c;
        Rect rect3 = this.f14418b;
        rect3.set(rect);
        if (i == 17) {
            rect3.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect3.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect3.offset((-rect.width()) - 1, 0);
        } else if (i == 130) {
            rect3.offset(0, (-rect.height()) - 1);
        }
        int size = arrayList.size();
        View view2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view3 = (View) arrayList.get(i3);
            if (!yb.k.a(view3, view) && !yb.k.a(view3, viewGroup)) {
                view3.getFocusedRect(rect2);
                viewGroup.offsetDescendantRectToMyCoords(view3, rect2);
                c1.c cVarT = d1.f0.t(rect2);
                c1.c cVarT2 = d1.f0.t(rect3);
                c1.c cVarT3 = d1.f0.t(rect);
                b1.c cVarD = b1.e.D(i);
                if (b1.e.o(cVarT, cVarT2, cVarT3, cVarD != null ? cVarD.f1810a : 1)) {
                    rect3.set(rect2);
                    view2 = view3;
                }
            }
        }
        return view2;
    }
}
