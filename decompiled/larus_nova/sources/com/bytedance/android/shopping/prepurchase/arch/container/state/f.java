package com.bytedance.android.shopping.prepurchase.arch.container.state;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleOwnerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {
    public static final LifecycleOwnerDelegate a(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toAndroidLifecycleOwner");
        return new LifecycleOwnerDelegate(r100);
    }
}
