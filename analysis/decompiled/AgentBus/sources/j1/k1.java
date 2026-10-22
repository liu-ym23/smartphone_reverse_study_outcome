package j1;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class k1 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final k.a0 f5215a;

    /* renamed from: b, reason: collision with root package name */
    public final k.b0 f5216b;

    /* renamed from: c, reason: collision with root package name */
    public final k.a0 f5217c;

    /* renamed from: d, reason: collision with root package name */
    public final k.y f5218d;

    public k1(b4.b bVar) {
        long[] jArr = k.g0.f5491a;
        this.f5215a = new k.a0();
        int i2 = k.h0.f5493a;
        this.f5216b = new k.b0();
        this.f5217c = new k.a0();
        k.y yVar = k.e0.f5483a;
        this.f5218d = new k.y();
    }

    public final void a(ArrayList arrayList, ViewGroup viewGroup) {
        k.y yVar;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            yVar = this.f5218d;
            if (i2 >= size) {
                break;
            }
            yVar.h(i2, (View) arrayList.get(i2));
            i2++;
        }
        int size2 = arrayList.size() - 1;
        k.b0 b0Var = this.f5216b;
        k.a0 a0Var = this.f5215a;
        if (size2 >= 0) {
            while (true) {
                int i10 = size2 - 1;
                View view = (View) arrayList.get(size2);
                int nextFocusForwardId = view.getNextFocusForwardId();
                View viewF = (nextFocusForwardId == 0 || nextFocusForwardId == -1) ? null : k0.f(view, viewGroup, 2);
                if (viewF != null && yVar.d(viewF) >= 0) {
                    a0Var.l(view, viewF);
                    b0Var.a(viewF);
                }
                if (i10 < 0) {
                    break;
                } else {
                    size2 = i10;
                }
            }
        }
        int size3 = arrayList.size() - 1;
        if (size3 < 0) {
            return;
        }
        while (true) {
            int i11 = size3 - 1;
            View view2 = (View) arrayList.get(size3);
            if (((View) a0Var.g(view2)) != null && !b0Var.c(view2)) {
                View view3 = view2;
                while (view2 != null) {
                    k.a0 a0Var2 = this.f5217c;
                    View view4 = (View) a0Var2.g(view2);
                    if (view4 != null) {
                        if (view4 == view3) {
                            break;
                        }
                        view2 = view3;
                        view3 = view4;
                    }
                    a0Var2.l(view2, view3);
                    view2 = (View) a0Var.g(view2);
                }
            }
            if (i11 < 0) {
                return;
            } else {
                size3 = i11;
            }
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        View view = (View) obj;
        View view2 = (View) obj2;
        if (view == view2) {
            return 0;
        }
        if (view == null) {
            return -1;
        }
        if (view2 == null) {
            return 1;
        }
        k.a0 a0Var = this.f5217c;
        View view3 = (View) a0Var.g(view);
        View view4 = (View) a0Var.g(view2);
        if (view3 == view4 && view3 != null) {
            if (view == view3) {
                return -1;
            }
            return (view2 == view3 || this.f5215a.g(view) == null) ? 1 : -1;
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
        k.y yVar = this.f5218d;
        return yVar.e(view) < yVar.e(view2) ? -1 : 1;
    }
}
