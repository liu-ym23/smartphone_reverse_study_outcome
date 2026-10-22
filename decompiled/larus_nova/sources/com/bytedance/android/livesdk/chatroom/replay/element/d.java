package com.bytedance.android.livesdk.chatroom.replay.element;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayBaseGestureWidget f108548a;

    public d(ReplayBaseGestureWidget r100) {
        this.f108548a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ReplayBaseGestureWidget r102 = this.f108548a;
        int r103 = ReplayBaseGestureWidget.f108322k;
        r102.Aq(null, false, null);
    }
}
