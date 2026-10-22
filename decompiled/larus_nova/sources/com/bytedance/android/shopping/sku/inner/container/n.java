package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements SlcKeyboardMonitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f182858a;

    public n(View r100) {
        this.f182858a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void a(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f182858a, new m(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void b(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f182858a, null);
    }
}
