package com.bytedance.android.shopping.searchsimilar;

import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SimilarProductFragment$initScribe$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SimilarProductFragment$initScribe$1();
    }

    public SimilarProductFragment$initScribe$1() {
        super(SimilarProductState.class, "isInitializeLoadingSuccess", "isInitializeLoadingSuccess()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return Boolean.valueOf(((SimilarProductState) r100).f182577c);
    }
}
