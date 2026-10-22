package com.bytedance.android.shopping.yata.biz.popup;

import hl3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PopupLayer$create$1 extends MutablePropertyReference0Impl {
    public PopupLayer$create$1(PopupLayer r100) {
        super(r100, PopupLayer.class, "host", "getHost()Lcom/bytedance/android/shopping/yata/biz/popup/api/IPopupLayer$IPopupHost;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        e.a r100 = ((PopupLayer) this.receiver).f187502c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        e.a r101 = (e.a) r100;
        ((PopupLayer) this.receiver).f187502c = r101;
    }
}
