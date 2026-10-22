package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/largertoucharea/LargerAreaAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final class LargerAreaAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f38137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccessibilityDelegateCompat f38138b;

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r100) {
        AccessibilityNodeInfoCompat r101 = AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(this.f38137a));     // Catch: Exception -> L13
        this.f38138b.onInitializeAccessibilityNodeInfo(this.f38137a, r101);     // Catch: Exception -> L13
        Rect r102 = new Rect();     // Catch: Exception -> L13
        r101.getBoundsInScreen(r102);     // Catch: Exception -> L13
        boolean r103 = false;
        int r104 = RangesKt.coerceAtLeast((a.f38140f - r102.width()) / 2, 0);     // Catch: Exception -> L13
        int r105 = RangesKt.coerceAtLeast((a.f38141g - r102.height()) / 2, 0);     // Catch: Exception -> L13
        if (r104 != 0) goto L7;
        if (r105 != 0) goto L7;
        return r101;
    L7:
        if (this.f38137a.getVisibility() != 0) goto L9;
        r103 = true;
    L9:
        if (r103 == true) goto L11;
        return r101;
    L11:
        r102.left -= r104;     // Catch: Exception -> L13
        r102.top -= r105;     // Catch: Exception -> L13
        r102.right += r104;     // Catch: Exception -> L13
        r102.bottom += r105;     // Catch: Exception -> L13
        r101.setBoundsInScreen(r102);     // Catch: Exception -> L13
        return r101;
    L13:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L18;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L18:
        if (("large touch area failed,occur exception, error message = " + e.getMessage()) == null) goto L20;
        Context r107 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L20:
        return null;
    }

    public LargerAreaAccessibilityNodeProvider(View r100, AccessibilityDelegateCompat r101) {
        this.f38137a = r100;
        this.f38138b = r101;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final boolean performAction(int r100, int r101, Bundle r102) {
        return this.f38138b.performAccessibilityAction(this.f38137a, r101, r102);
    }
}
