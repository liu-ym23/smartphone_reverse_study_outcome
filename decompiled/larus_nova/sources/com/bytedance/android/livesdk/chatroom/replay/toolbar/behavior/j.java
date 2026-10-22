package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mq1.u f110034a;

    public j(mq1.u r100) {
        this.f110034a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f110034a.hidePlayerTip("speed_up");
    }
}
