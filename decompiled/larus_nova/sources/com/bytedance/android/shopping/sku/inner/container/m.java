package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnApplyWindowInsetsListener f182857a;

    public m(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        this.f182857a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        this.f182857a.onApplyWindowInsets(r100, r101);
        return ViewCompat.onApplyWindowInsets(r100, r101);
    }
}
