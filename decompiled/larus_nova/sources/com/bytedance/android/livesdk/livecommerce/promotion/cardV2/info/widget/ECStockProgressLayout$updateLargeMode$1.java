package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStockProgressLayout$updateLargeMode$1 extends MutablePropertyReference0Impl {
    public ECStockProgressLayout$updateLargeMode$1(ECStockProgressLayout r100) {
        super(r100, ECStockProgressLayout.class, "tvStockProgressDes", "getTvStockProgressDes()Landroid/widget/TextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        TextView r100 = ((ECStockProgressLayout) this.receiver).f150623b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        TextView r101 = (TextView) r100;
        ((ECStockProgressLayout) this.receiver).f150623b = r101;
    }
}
