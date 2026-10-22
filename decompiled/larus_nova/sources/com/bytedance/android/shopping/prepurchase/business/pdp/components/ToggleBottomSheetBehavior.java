package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/ToggleBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToggleBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f181081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f181082b;

    public ToggleBottomSheetBehavior() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r102.getActionMasked() != 0) goto L5;
        this.f181081a = false;
        this.f181082b = false;
    L5:
        boolean r103 = super.onTouchEvent(r100, r101, r102);
        int r104 = r102.getActionMasked();
        if (r104 == 1) goto L11;
        if (r104 == 3) goto L11;
    L16:
        return r103;
    L11:
        if (this.f181081a == false) goto L13;
    L15:
        this.f181081a = false;
        this.f181082b = true;
        setState(5);
        goto L16
    L13:
        if (this.f181082b == true) goto L15;
        goto L15
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101, r102, r103);
        if (this.f181081a == false) goto L5;
    L7:
        this.f181081a = false;
        this.f181082b = true;
        setState(5);
        return;
    L5:
        if (this.f181082b == true) goto L7;
    }
}
