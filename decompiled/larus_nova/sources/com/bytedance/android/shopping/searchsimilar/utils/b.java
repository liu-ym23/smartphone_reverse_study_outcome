package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.model.QuerySimilarProductGuideResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Observer<QuerySimilarProductGuideResponse> {
    public b() {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onNext(QuerySimilarProductGuideResponse r100) {
        QuerySimilarProductGuideResponse r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r101.getStatusCode() != 0) goto L6;
        boolean r102 = f.f182499a;
        f.f182499a = r101.getEnableShowGuide();
        return;
    }
}
