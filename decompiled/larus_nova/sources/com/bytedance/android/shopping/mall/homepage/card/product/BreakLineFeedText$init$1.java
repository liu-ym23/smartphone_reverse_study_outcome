package com.bytedance.android.shopping.mall.homepage.card.product;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BreakLineFeedText$init$1 extends MutablePropertyReference0Impl {
    public BreakLineFeedText$init$1(BreakLineFeedText r100) {
        super(r100, BreakLineFeedText.class, "fullText", "getFullText()Ljava/lang/CharSequence;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        CharSequence r100 = ((BreakLineFeedText) this.receiver).f178011a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        CharSequence r101 = (CharSequence) r100;
        ((BreakLineFeedText) this.receiver).f178011a = r101;
    }
}
