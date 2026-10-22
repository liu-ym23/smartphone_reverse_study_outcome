package com.bytedance.android.shopping.feed;

import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Observer<InflowGuessFeedResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f174432a;

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f174432a.f174435c = false;
    }

    public c(d r100) {
        this.f174432a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f174432a.f174434b.setValue(null);
    }

    @Override // io.reactivex.Observer
    public final void onNext(InflowGuessFeedResponse r100) {
        InflowGuessFeedResponse r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "resp");
        this.f174432a.f174434b.setValue(r101);
    }
}
