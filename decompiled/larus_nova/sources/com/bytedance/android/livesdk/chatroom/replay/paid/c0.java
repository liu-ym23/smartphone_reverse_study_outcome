package com.bytedance.android.livesdk.chatroom.replay.paid;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayPresenter f109363a;

    public c0(PaidReplayPresenter r100) {
        this.f109363a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PaidReplayPresenter r101 = this.f109363a;
        int r102 = PaidReplayPresenter.f109299u;
        ALogger.i(r101.getLogTag(), "timing error ! " + ((Throwable) r100).getMessage());
    }
}
