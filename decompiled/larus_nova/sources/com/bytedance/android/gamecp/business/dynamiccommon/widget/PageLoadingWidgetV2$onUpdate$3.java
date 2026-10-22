package com.bytedance.android.gamecp.business.dynamiccommon.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PageLoadingWidgetV2$onUpdate$3 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new PageLoadingWidgetV2$onUpdate$3();
    }

    public PageLoadingWidgetV2$onUpdate$3() {
        super(a.class, "errorCode", "getErrorCode()I", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Integer.valueOf(((a) r100).f53154b);
    }
}
