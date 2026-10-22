package com.bytedance.android.livesdk.gift.format;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPlayerView f126228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tr.a f126229b;

    public f(GiftPlayerView r100, tr.a r101) {
        this.f126228a = r100;
        this.f126229b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GiftPlayerView r101 = this.f126228a;
        String r102 = "download assets failed!!, assetId: " + this.f126229b.f547269d + ", error: " + ((Throwable) r100);
        int r103 = GiftPlayerView.f126206k;
        r101.e(r102);
        GiftPlayerView.c(this.f126228a);
    }
}
