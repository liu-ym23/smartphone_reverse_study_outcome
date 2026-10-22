package com.bytedance.android.livesdk.gift.format;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPlayerView f126224a;

    public c(GiftPlayerView r100) {
        this.f126224a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GiftPlayerView r101 = this.f126224a;
        GiftPlayerView.d(r101, (tr.a) r100);
    }
}
