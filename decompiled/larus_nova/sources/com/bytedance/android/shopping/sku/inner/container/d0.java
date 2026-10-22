package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d0 implements SlcKeyboardMonitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f182838a;

    public d0(View r100) {
        this.f182838a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void a(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f182838a, new c0(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void b(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f182838a, null);
    }
}
