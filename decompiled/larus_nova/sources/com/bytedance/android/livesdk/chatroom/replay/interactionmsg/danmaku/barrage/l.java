package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayMessageHandlePopup f109018a;

    public l(ReplayMessageHandlePopup r100) {
        this.f109018a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f109018a.a();
    }
}
