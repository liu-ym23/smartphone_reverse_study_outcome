package com.bytedance.android.shopping.abscontainer.arch.platform.slice;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements SlcKeyboardMonitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f164192a;

    public b(View r100) {
        this.f164192a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void a(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f164192a, new a(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.b
    public final void b(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.f164192a, null);
    }
}
