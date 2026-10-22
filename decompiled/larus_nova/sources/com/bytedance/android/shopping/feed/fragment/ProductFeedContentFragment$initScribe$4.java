package com.bytedance.android.shopping.feed.fragment;

import com.bytedance.android.shopping.feed.viewmodel.ProductFeedState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ProductFeedContentFragment$initScribe$4 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ProductFeedContentFragment$initScribe$4();
    }

    public ProductFeedContentFragment$initScribe$4() {
        super(ProductFeedState.class, "headerList", "getHeaderList()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((ProductFeedState) r100).f175702e;
    }
}
