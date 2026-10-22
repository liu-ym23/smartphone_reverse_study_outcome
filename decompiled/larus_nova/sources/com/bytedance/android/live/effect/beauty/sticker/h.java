package com.bytedance.android.live.effect.beauty.sticker;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStickerListAdapter f67798a;

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.f67798a.notifyDataSetChanged();
        this.f67798a.f67762i = false;
    }

    public h(LiveStickerListAdapter r100) {
        this.f67798a = r100;
    }

    @Override // io.reactivex.Observer
    public final /* bridge */ /* synthetic */ void onNext(Boolean r100) {
        r100.booleanValue();
    }
}
