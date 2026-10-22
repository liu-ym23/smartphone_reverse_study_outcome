package z1;

import B0.g;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class c extends com.stepos.statsrpk.c {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f16416h;

    public c(SideSheetBehavior sideSheetBehavior) {
        this.f16416h = sideSheetBehavior;
    }

    @Override // com.stepos.statsrpk.c
    public final void F(int i4) {
        if (i4 == 1) {
            SideSheetBehavior sideSheetBehavior = this.f16416h;
            if (sideSheetBehavior.f10884g) {
                sideSheetBehavior.c(1);
            }
        }
    }

    @Override // com.stepos.statsrpk.c
    public final void G(View view, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f16416h;
        WeakReference weakReference = sideSheetBehavior.f10894q;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            C1004a c1004a = sideSheetBehavior.f10878a;
            int left = view.getLeft();
            int right = view.getRight();
            int i6 = c1004a.f16412e;
            SideSheetBehavior sideSheetBehavior2 = c1004a.f16413f;
            switch (i6) {
                case 0:
                    if (left <= sideSheetBehavior2.f10890m) {
                        marginLayoutParams.leftMargin = right;
                        break;
                    }
                    break;
                default:
                    int i7 = sideSheetBehavior2.f10890m;
                    if (left <= i7) {
                        marginLayoutParams.rightMargin = i7 - left;
                        break;
                    }
                    break;
            }
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.f10898u;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        sideSheetBehavior.f10878a.j(i4);
        Iterator it = linkedHashSet.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // com.stepos.statsrpk.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r3 = r3.f16416h
            z1.a r0 = r3.f10878a
            boolean r0 = r0.m(r5)
            r1 = 3
            if (r0 == 0) goto Lc
            goto L56
        Lc:
            z1.a r0 = r3.f10878a
            boolean r0 = r0.p(r4, r5)
            r2 = 5
            if (r0 == 0) goto L27
            z1.a r0 = r3.f10878a
            boolean r5 = r0.o(r5, r6)
            if (r5 != 0) goto L25
            z1.a r5 = r3.f10878a
            boolean r5 = r5.n(r4)
            if (r5 == 0) goto L56
        L25:
            r1 = r2
            goto L56
        L27:
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L39
            float r5 = java.lang.Math.abs(r5)
            float r6 = java.lang.Math.abs(r6)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L39
            goto L25
        L39:
            int r5 = r4.getLeft()
            z1.a r6 = r3.f10878a
            int r6 = r6.k()
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            z1.a r0 = r3.f10878a
            int r0 = r0.l()
            int r5 = r5 - r0
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L25
        L56:
            r5 = 1
            r3.e(r4, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.c.H(android.view.View, float, float):void");
    }

    @Override // com.stepos.statsrpk.c
    public final boolean P(int i4, View view) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f16416h;
        return (sideSheetBehavior.f10885h == 1 || (weakReference = sideSheetBehavior.f10893p) == null || weakReference.get() != view) ? false : true;
    }

    @Override // com.stepos.statsrpk.c
    public final int o(View view, int i4) {
        int iK;
        int i5;
        SideSheetBehavior sideSheetBehavior = this.f16416h;
        C1004a c1004a = sideSheetBehavior.f10878a;
        switch (c1004a.f16412e) {
            case 0:
                iK = -c1004a.f16413f.f10889l;
                break;
            default:
                iK = c1004a.k();
                break;
        }
        C1004a c1004a2 = sideSheetBehavior.f10878a;
        int i6 = c1004a2.f16412e;
        SideSheetBehavior sideSheetBehavior2 = c1004a2.f16413f;
        switch (i6) {
            case 0:
                i5 = sideSheetBehavior2.f10892o;
                break;
            default:
                i5 = sideSheetBehavior2.f10890m;
                break;
        }
        return AbstractC0557a.o(i4, iK, i5);
    }

    @Override // com.stepos.statsrpk.c
    public final int p(View view, int i4) {
        return view.getTop();
    }

    @Override // com.stepos.statsrpk.c
    public final int x(View view) {
        SideSheetBehavior sideSheetBehavior = this.f16416h;
        return sideSheetBehavior.f10889l + sideSheetBehavior.f10892o;
    }
}
