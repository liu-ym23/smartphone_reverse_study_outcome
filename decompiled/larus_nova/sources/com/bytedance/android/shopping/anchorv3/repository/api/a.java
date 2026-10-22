package com.bytedance.android.shopping.anchorv3.repository.api;

import com.bytedance.android.shopping.anchorv3.repository.dto.DepositPresaleAppointResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Observer<DepositPresaleAppointResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f165270a;

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    public a(Function1 r100) {
        this.f165270a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f165270a.invoke(null);
    }

    @Override // io.reactivex.Observer
    public final void onNext(DepositPresaleAppointResponse r100) {
        DepositPresaleAppointResponse r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        this.f165270a.invoke(r101);
    }
}
