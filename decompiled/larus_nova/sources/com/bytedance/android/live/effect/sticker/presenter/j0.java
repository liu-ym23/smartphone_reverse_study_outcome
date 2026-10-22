package com.bytedance.android.live.effect.sticker.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 extends p0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.b f68339a;

    public j0(LiveStickerDataManager.f r100) {
        this.f68339a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f68339a.a(false);
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        boolean r101 = ((Boolean) r100).booleanValue();
        this.f68339a.a(r101);
    }
}
