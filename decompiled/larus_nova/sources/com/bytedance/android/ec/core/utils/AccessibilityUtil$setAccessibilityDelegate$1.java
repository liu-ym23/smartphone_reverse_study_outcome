package com.bytedance.android.ec.core.utils;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/ec/core/utils/AccessibilityUtil$setAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AccessibilityUtil$setAccessibilityDelegate$1 extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0810a f45498a;

    public AccessibilityUtil$setAccessibilityDelegate$1(a.InterfaceC0810a r100) {
        this.f45498a = r100;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        a.InterfaceC0810a r102 = this.f45498a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
