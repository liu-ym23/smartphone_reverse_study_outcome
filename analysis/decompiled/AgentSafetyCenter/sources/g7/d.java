package g7;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import t.i1;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends i1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b3.a f4359b;

    public /* synthetic */ d(b3.a aVar, int i) {
        this.f4358a = i;
        this.f4359b = aVar;
    }

    @Override // t.i1
    public final int b(int i, View view) {
        switch (this.f4358a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4359b;
                return h.j(i, sideSheetBehavior.f2443a.A(), sideSheetBehavior.f2443a.z());
            default:
                return view.getLeft();
        }
    }

    @Override // t.i1
    public final int c(int i, View view) {
        switch (this.f4358a) {
            case 0:
                return view.getTop();
            default:
                return h.j(i, ((BottomSheetBehavior) this.f4359b).i(), g());
        }
    }

    @Override // t.i1
    public int f(View view) {
        switch (this.f4358a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4359b;
                return sideSheetBehavior.f2453l + sideSheetBehavior.f2456o;
            default:
                return super.f(view);
        }
    }

    @Override // t.i1
    public int g() {
        switch (this.f4358a) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4359b;
                return bottomSheetBehavior.I ? bottomSheetBehavior.V : bottomSheetBehavior.G;
            default:
                return super.g();
        }
    }

    @Override // t.i1
    public final void k(int i) {
        switch (this.f4358a) {
            case 0:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4359b;
                    if (sideSheetBehavior.f2449g) {
                        sideSheetBehavior.c(1);
                        break;
                    }
                }
                break;
            default:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4359b;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.n(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // t.i1
    public final void l(View view, int i, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f4358a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4359b;
                WeakReference weakReference = sideSheetBehavior.f2458q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f2443a.V(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f2462u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f2443a.h(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
                return;
            default:
                ((BottomSheetBehavior) this.f4359b).f(i3);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // t.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(android.view.View r5, float r6, float r7) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.d.m(android.view.View, float, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    @Override // t.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(int r4, android.view.View r5) {
        /*
            r3 = this;
            int r0 = r3.f4358a
            switch(r0) {
                case 0: goto L41;
                default: goto L5;
            }
        L5:
            b3.a r3 = r3.f4359b
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r3
            int r0 = r3.N
            r1 = 1
            if (r0 != r1) goto Lf
            goto L3f
        Lf:
            boolean r2 = r3.f2415c0
            if (r2 == 0) goto L14
            goto L3f
        L14:
            r2 = 3
            if (r0 != r2) goto L31
            int r0 = r3.f2411a0
            if (r0 != r4) goto L31
            java.lang.ref.WeakReference r4 = r3.X
            if (r4 == 0) goto L26
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == 0) goto L31
            r0 = -1
            boolean r4 = r4.canScrollVertically(r0)
            if (r4 == 0) goto L31
            goto L3f
        L31:
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r3 = r3.W
            if (r3 == 0) goto L3f
            java.lang.Object r3 = r3.get()
            if (r3 != r5) goto L3f
            goto L40
        L3f:
            r1 = 0
        L40:
            return r1
        L41:
            b3.a r3 = r3.f4359b
            com.google.android.material.sidesheet.SideSheetBehavior r3 = (com.google.android.material.sidesheet.SideSheetBehavior) r3
            int r4 = r3.f2450h
            r0 = 1
            if (r4 != r0) goto L4b
            goto L56
        L4b:
            java.lang.ref.WeakReference r3 = r3.f2457p
            if (r3 == 0) goto L56
            java.lang.Object r3 = r3.get()
            if (r3 != r5) goto L56
            goto L57
        L56:
            r0 = 0
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.d.t(int, android.view.View):boolean");
    }
}
