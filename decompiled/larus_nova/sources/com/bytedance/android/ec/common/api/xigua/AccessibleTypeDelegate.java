package com.bytedance.android.ec.common.api.xigua;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/api/xigua/AccessibleTypeDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AccessibleTypeDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42877b;

    public AccessibleTypeDelegate(String r100, String r101) {
        this.f42876a = r100;
        this.f42877b = r101;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        super.onInitializeAccessibilityEvent(r100, r101);
        r101.setClassName(this.f42877b);
        CharSequence r102 = this.f42876a;
        if (r102 != null) goto L6;
        r102 = r100.getContentDescription();
    L6:
        r101.setContentDescription(r102);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setClassName(this.f42877b);
        CharSequence r102 = this.f42876a;
        if (r102 != null) goto L6;
        r102 = r100.getContentDescription();
    L6:
        r101.setContentDescription(r102);
    }
}
