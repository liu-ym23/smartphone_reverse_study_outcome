package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class c extends ViewDragHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f2517a;

    public c(SideSheetBehavior sideSheetBehavior) {
        this.f2517a = sideSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i6) {
        SideSheetBehavior sideSheetBehavior = this.f2517a;
        return MathUtils.clamp(i, sideSheetBehavior.f2509a.A(), sideSheetBehavior.f2509a.z());
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i6) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        SideSheetBehavior sideSheetBehavior = this.f2517a;
        return sideSheetBehavior.l + sideSheetBehavior.o;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        if (i == 1) {
            SideSheetBehavior sideSheetBehavior = this.f2517a;
            if (sideSheetBehavior.g) {
                sideSheetBehavior.c(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i6, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f2517a;
        WeakReference weakReference = sideSheetBehavior.f2511q;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            sideSheetBehavior.f2509a.P(marginLayoutParams, view.getLeft(), view.getRight());
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.u;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        sideSheetBehavior.f2509a.l(i);
        Iterator it = linkedHashSet.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewReleased(android.view.View r2, float r3, float r4) {
        /*
            r1 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r1 = r1.f2517a
            Z6.k r0 = r1.f2509a
            boolean r0 = r0.F(r3)
            if (r0 == 0) goto Lb
            goto L53
        Lb:
            Z6.k r0 = r1.f2509a
            boolean r0 = r0.N(r2, r3)
            if (r0 == 0) goto L24
            Z6.k r0 = r1.f2509a
            boolean r3 = r0.H(r3, r4)
            if (r3 != 0) goto L55
            Z6.k r3 = r1.f2509a
            boolean r3 = r3.G(r2)
            if (r3 == 0) goto L53
            goto L55
        L24:
            r0 = 0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L36
            float r3 = java.lang.Math.abs(r3)
            float r4 = java.lang.Math.abs(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L36
            goto L55
        L36:
            int r3 = r2.getLeft()
            Z6.k r4 = r1.f2509a
            int r4 = r4.x()
            int r4 = r3 - r4
            int r4 = java.lang.Math.abs(r4)
            Z6.k r0 = r1.f2509a
            int r0 = r0.y()
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            if (r4 >= r3) goto L55
        L53:
            r3 = 3
            goto L56
        L55:
            r3 = 5
        L56:
            r4 = 1
            r1.e(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.c.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f2517a;
        return (sideSheetBehavior.h == 1 || (weakReference = sideSheetBehavior.p) == null || weakReference.get() != view) ? false : true;
    }
}
