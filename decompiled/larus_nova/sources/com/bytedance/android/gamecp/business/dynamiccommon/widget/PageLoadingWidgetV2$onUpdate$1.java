package com.bytedance.android.gamecp.business.dynamiccommon.widget;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageLoadingWidgetV2$onUpdate$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new PageLoadingWidgetV2$onUpdate$1();
    }

    public PageLoadingWidgetV2$onUpdate$1() {
        super(a.class, DyPayConstant.KEY_SHOW_LOADING, "getShowLoading()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((a) r100).f53153a);
    }
}
