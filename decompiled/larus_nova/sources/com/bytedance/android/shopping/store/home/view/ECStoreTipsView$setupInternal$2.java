package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECStoreTipsView$setupInternal$2 extends MutablePropertyReference0Impl {
    public ECStoreTipsView$setupInternal$2(p r100) {
        super(r100, p.class, "triangle", "getTriangle()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((p) this.receiver).f184731e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        View r101 = (View) r100;
        ((p) this.receiver).f184731e = r101;
    }
}
