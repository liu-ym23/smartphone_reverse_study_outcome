package com.bytedance.android.shopping.api.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/accessibility/AccessibilityDelegateCompatImpl;", "Landroidx/core/view/AccessibilityDelegateCompat;", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AccessibilityDelegateCompatImpl extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f170189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f170190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f170191c;

    public AccessibilityDelegateCompatImpl(View r100) {
        String r101 = Button.class.getName();
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f170189a = r100;
        this.f170190b = null;
        this.f170191c = r101;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        super.onInitializeAccessibilityEvent(r100, r101);
        CharSequence r102 = this.f170190b;
        if (r102 != null) goto L5;
        r102 = r100.getContentDescription();
    L5:
        r101.setContentDescription(r102);
        r101.setClassName(this.f170191c);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        CharSequence r102 = this.f170190b;
        if (r102 != null) goto L5;
        r102 = r100.getContentDescription();
    L5:
        r101.setContentDescription(r102);
        r101.setClassName(this.f170191c);
    }
}
