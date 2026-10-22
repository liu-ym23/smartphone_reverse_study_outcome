package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SelectPresenter$refreshTitleSpec$3 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SelectPresenter$refreshTitleSpec$3();
    }

    public SelectPresenter$refreshTitleSpec$3() {
        super(SpecInfo.class, "name", "getName()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((SpecInfo) r100).getName();
    }
}
