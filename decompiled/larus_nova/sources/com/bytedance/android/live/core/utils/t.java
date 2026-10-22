package com.bytedance.android.live.core.utils;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f66402a = null;

    static {
        f66402a = new t();
    }

    public t() {
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setClassName(Button.class.getName());
    }
}
