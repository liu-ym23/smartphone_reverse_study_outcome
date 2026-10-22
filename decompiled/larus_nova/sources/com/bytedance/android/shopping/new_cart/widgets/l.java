package com.bytedance.android.shopping.new_cart.widgets;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends com.bytedance.android.shopping.card_list.components.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f179499b;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.f179499b;
    }

    public l(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        super(r100);
        this.f179499b = r100;
    }
}
