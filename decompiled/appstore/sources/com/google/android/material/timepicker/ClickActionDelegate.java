package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes3.dex */
class ClickActionDelegate extends a {
    private final AccessibilityNodeInfoCompat.a clickAction;

    public ClickActionDelegate(Context r10, int r11) {
        this.clickAction = new AccessibilityNodeInfoCompat.a(16, r10.getString(r11));
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        r11.b(this.clickAction);
    }
}
