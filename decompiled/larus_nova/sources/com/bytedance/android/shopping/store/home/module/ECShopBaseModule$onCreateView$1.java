package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECShopBaseModule$onCreateView$1 extends PropertyReference0Impl {
    public ECShopBaseModule$onCreateView$1(b r100) {
        super(r100, b.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((b) this.receiver).f183788m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r100;
    }
}
