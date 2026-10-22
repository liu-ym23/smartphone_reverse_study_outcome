package com.bytedance.android.livesdk.chatroom.replay.paid;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayPresenter f109361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f109362b;

    public b0(PaidReplayPresenter r100, String r101) {
        this.f109361a = r100;
        this.f109362b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        PaidReplayPresenter r102 = this.f109361a;
        String r103 = this.f109362b;
        int r104 = PaidReplayPresenter.f109299u;
        r102.h(r103);
    }
}
