package i1;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import b8.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import x.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3129c;
    public final /* synthetic */ t.a d;

    public /* synthetic */ b(t.a aVar, int i8) {
        this.f3129c = i8;
        this.d = aVar;
    }

    @Override // b8.h
    public final void C(int i8) throws Resources.NotFoundException {
        switch (this.f3129c) {
            case 0:
                if (i8 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.d;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.C(1);
                        break;
                    }
                }
                break;
            default:
                if (i8 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
                    if (sideSheetBehavior.f1330g) {
                        sideSheetBehavior.r(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // b8.h
    public final void D(View view, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f3129c) {
            case 0:
                ((BottomSheetBehavior) this.d).u(i9);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
                WeakReference weakReference = sideSheetBehavior.f1340q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f1325a.s0(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f1344u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f1325a.g(i8);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e9  */
    @Override // b8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.view.View r5, float r6, float r7) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.b.E(android.view.View, float, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    @Override // b8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Q(android.view.View r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.f3129c
            switch(r0) {
                case 0: goto L1c;
                default: goto L5;
            }
        L5:
            t.a r3 = r3.d
            com.google.android.material.sidesheet.SideSheetBehavior r3 = (com.google.android.material.sidesheet.SideSheetBehavior) r3
            int r5 = r3.f1331h
            r0 = 0
            r1 = 1
            if (r5 != r1) goto L10
            goto L1b
        L10:
            java.lang.ref.WeakReference r3 = r3.f1339p
            if (r3 == 0) goto L1b
            java.lang.Object r3 = r3.get()
            if (r3 != r4) goto L1b
            r0 = r1
        L1b:
            return r0
        L1c:
            t.a r3 = r3.d
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r3
            int r0 = r3.N
            r1 = 1
            if (r0 != r1) goto L26
            goto L56
        L26:
            boolean r2 = r3.f1237c0
            if (r2 == 0) goto L2b
            goto L56
        L2b:
            r2 = 3
            if (r0 != r2) goto L48
            int r0 = r3.f1233a0
            if (r0 != r5) goto L48
            java.lang.ref.WeakReference r5 = r3.X
            if (r5 == 0) goto L3d
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            goto L3e
        L3d:
            r5 = 0
        L3e:
            if (r5 == 0) goto L48
            r0 = -1
            boolean r5 = r5.canScrollVertically(r0)
            if (r5 == 0) goto L48
            goto L56
        L48:
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r3 = r3.W
            if (r3 == 0) goto L56
            java.lang.Object r3 = r3.get()
            if (r3 != r4) goto L56
            goto L57
        L56:
            r1 = 0
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.b.Q(android.view.View, int):boolean");
    }

    @Override // b8.h
    public final int g(View view, int i8) {
        switch (this.f3129c) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
                return f.t(i8, sideSheetBehavior.f1325a.M(), sideSheetBehavior.f1325a.L());
        }
    }

    @Override // b8.h
    public final int h(View view, int i8) {
        switch (this.f3129c) {
            case 0:
                return f.t(i8, ((BottomSheetBehavior) this.d).x(), s());
            default:
                return view.getTop();
        }
    }

    @Override // b8.h
    public int r(View view) {
        switch (this.f3129c) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
                return sideSheetBehavior.f1335l + sideSheetBehavior.f1338o;
            default:
                return super.r(view);
        }
    }

    @Override // b8.h
    public int s() {
        switch (this.f3129c) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.d;
                return bottomSheetBehavior.I ? bottomSheetBehavior.V : bottomSheetBehavior.G;
            default:
                return super.s();
        }
    }
}
