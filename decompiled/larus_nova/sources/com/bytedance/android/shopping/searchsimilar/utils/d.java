package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Observer<CommerceBaseResponse> {
    public d() {
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
    public final void onNext(CommerceBaseResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
    }
}
