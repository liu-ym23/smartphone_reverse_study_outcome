package com.bytedance.android.shopping.store.home.view;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStoreTipsView$setupInternal$1 extends MutablePropertyReference0Impl {
    public ECStoreTipsView$setupInternal$1(p r100) {
        super(r100, p.class, "text", "getText()Landroid/widget/TextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        TextView r100 = ((p) this.receiver).f184730d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("text");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        TextView r101 = (TextView) r100;
        ((p) this.receiver).f184730d = r101;
    }
}
