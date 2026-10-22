package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.ECReplayScrollProductCardDataSourceFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECScrollProductCardRepository$generateReplayObservablePagedList$1 extends MutablePropertyReference0Impl {
    public ECScrollProductCardRepository$generateReplayObservablePagedList$1(a r100) {
        super(r100, a.class, "dataReplaySourceFactory", "getDataReplaySourceFactory()Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/ECReplayScrollProductCardDataSourceFactory;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ECReplayScrollProductCardDataSourceFactory r100 = ((a) this.receiver).f149349b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataReplaySourceFactory");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ECReplayScrollProductCardDataSourceFactory r101 = (ECReplayScrollProductCardDataSourceFactory) r100;
        ((a) this.receiver).f149349b = r101;
    }
}
