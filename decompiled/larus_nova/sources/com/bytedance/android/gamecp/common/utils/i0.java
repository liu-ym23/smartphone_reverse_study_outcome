package com.bytedance.android.gamecp.common.utils;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes44.dex */
public final class i0 implements OnApplyWindowInsetsListener {
    public i0() {
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        if (r101.getSystemWindowInsetTop() == 0) goto L6;
        r101 = r101.replaceSystemWindowInsets(r101.getSystemWindowInsetLeft(), 0, r101.getSystemWindowInsetRight(), r101.getSystemWindowInsetBottom());
    L6:
        return ViewCompat.onApplyWindowInsets(r100, r101);
    }
}
