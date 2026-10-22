package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStockProgressLayout$updateLargeMode$3 extends MutablePropertyReference0Impl {
    public ECStockProgressLayout$updateLargeMode$3(ECStockProgressLayout r100) {
        super(r100, ECStockProgressLayout.class, "svStockLabel", "getSvStockLabel()Landroid/widget/TextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        TextView r100 = ((ECStockProgressLayout) this.receiver).f150625d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        TextView r101 = (TextView) r100;
        ((ECStockProgressLayout) this.receiver).f150625d = r101;
    }
}
