package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NavBarWidget$onUpdate$3 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new NavBarWidget$onUpdate$3();
    }

    public NavBarWidget$onUpdate$3() {
        super(c.class, "contentProp", "getContentProp()Lcom/bytedance/android/gamecp/base/gamedetail/DetailPageViewItemProps;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((c) r100).f54652f;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public void set(Object r100, Object r101) {
        d0 r102 = (d0) r101;
        ((c) r100).f54652f = r102;
    }
}
