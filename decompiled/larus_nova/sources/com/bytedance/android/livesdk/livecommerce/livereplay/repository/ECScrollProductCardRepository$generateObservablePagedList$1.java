package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECScrollProductCardRepository$generateObservablePagedList$1 extends MutablePropertyReference0Impl {
    public ECScrollProductCardRepository$generateObservablePagedList$1(a r100) {
        super(r100, a.class, "dataSourceFactory", "getDataSourceFactory()Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/ECScrollProductCardDataSourceFactory;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ECScrollProductCardDataSourceFactory r100 = ((a) this.receiver).f149348a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ECScrollProductCardDataSourceFactory r101 = (ECScrollProductCardDataSourceFactory) r100;
        ((a) this.receiver).f149348a = r101;
    }
}
