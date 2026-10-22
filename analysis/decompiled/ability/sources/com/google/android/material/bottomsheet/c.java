package com.google.android.material.bottomsheet;

import android.os.SystemClock;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class c extends ViewDragHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f2346a;

    public c(BottomSheetBehavior bottomSheetBehavior) {
        this.f2346a = bottomSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i6) {
        return view.getLeft();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i6) {
        return MathUtils.clamp(i, this.f2346a.i(), getViewVerticalDragRange(view));
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewVerticalDragRange(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f2346a;
        return bottomSheetBehavior.f2311I ? bottomSheetBehavior.f2324V : bottomSheetBehavior.f2309G;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        if (i == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f2346a;
            if (bottomSheetBehavior.f2313K) {
                bottomSheetBehavior.n(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i6, int i10, int i11) {
        this.f2346a.f(i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewReleased(android.view.View r5, float r6, float r7) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.c.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        BottomSheetBehavior bottomSheetBehavior = this.f2346a;
        int i6 = bottomSheetBehavior.f2316N;
        if (i6 == 1 || bottomSheetBehavior.f2331c0) {
            return false;
        }
        if (i6 == 3 && bottomSheetBehavior.f2330a0 == i) {
            WeakReference weakReference = bottomSheetBehavior.f2326X;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        SystemClock.uptimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.f2325W;
        return weakReference2 != null && weakReference2.get() == view;
    }
}
