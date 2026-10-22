package com.bytedance.android.shopping.buynow.container;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnApplyWindowInsetsListener f170779a;

    public f(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        this.f170779a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        this.f170779a.onApplyWindowInsets(r100, r101);
        return ViewCompat.onApplyWindowInsets(r100, r101);
    }
}
