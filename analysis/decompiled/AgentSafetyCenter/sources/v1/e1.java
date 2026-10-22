package v1;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public p.f0 f14408c;

    /* renamed from: f, reason: collision with root package name */
    public p.g0 f14409f;

    /* renamed from: g, reason: collision with root package name */
    public p.f0 f14410g;

    /* renamed from: h, reason: collision with root package name */
    public p.z f14411h;

    public final void a(ArrayList arrayList, ViewGroup viewGroup) {
        p.g0 g0Var = this.f14409f;
        p.z zVar = this.f14411h;
        p.f0 f0Var = this.f14408c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zVar.h(i, (View) arrayList.get(i));
        }
        int size2 = arrayList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i3 = size2 - 1;
                View view = (View) arrayList.get(size2);
                int nextFocusForwardId = view.getNextFocusForwardId();
                View viewI = (nextFocusForwardId == 0 || nextFocusForwardId == -1) ? null : g0.i(view, viewGroup, 2);
                if (viewI != null && zVar.d(viewI) >= 0) {
                    f0Var.m(view, viewI);
                    g0Var.a(viewI);
                }
                if (i3 < 0) {
                    break;
                } else {
                    size2 = i3;
                }
            }
        }
        int size3 = arrayList.size() - 1;
        if (size3 < 0) {
            return;
        }
        while (true) {
            int i10 = size3 - 1;
            View view2 = (View) arrayList.get(size3);
            if (((View) f0Var.g(view2)) != null && !g0Var.c(view2)) {
                p.f0 f0Var2 = this.f14410g;
                View view3 = view2;
                while (view2 != null) {
                    View view4 = (View) f0Var2.g(view2);
                    if (view4 != null) {
                        if (view4 == view3) {
                            break;
                        }
                        view2 = view3;
                        view3 = view4;
                    }
                    f0Var2.m(view2, view3);
                    view2 = (View) f0Var.g(view2);
                }
            }
            if (i10 < 0) {
                return;
            } else {
                size3 = i10;
            }
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        View view = (View) obj;
        View view2 = (View) obj2;
        p.z zVar = this.f14411h;
        p.f0 f0Var = this.f14410g;
        if (view == view2) {
            return 0;
        }
        if (view == null) {
            return -1;
        }
        if (view2 == null) {
            return 1;
        }
        View view3 = (View) f0Var.g(view);
        View view4 = (View) f0Var.g(view2);
        if (view3 == view4 && view3 != null) {
            if (view == view3) {
                return -1;
            }
            return (view2 == view3 || this.f14408c.g(view) == null) ? 1 : -1;
        }
        if (view3 != null) {
            view = view3;
        }
        if (view4 != null) {
            view2 = view4;
        }
        if (view3 == null && view4 == null) {
            return 0;
        }
        return zVar.e(view) < zVar.e(view2) ? -1 : 1;
    }
}
