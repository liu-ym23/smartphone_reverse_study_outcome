package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.viewmodel.CartState;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CartDialogFragment$initView$2 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new CartDialogFragment$initView$2();
    }

    public CartDialogFragment$initView$2() {
        super(CartState.class, "fpsValue", "getFpsValue()I", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Integer.valueOf(((CartState) r100).f179368b);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object r100, Object r101) {
        int r102 = ((Number) r101).intValue();
        ((CartState) r100).f179368b = r102;
    }
}
