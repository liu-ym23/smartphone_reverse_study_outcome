package com.bytedance.android.livesdk.chatroom.tetris.portrait;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitRow3rdTetris$initFirstShowHint$1 f111814a;

    public u(PortraitRow3rdTetris$initFirstShowHint$1 r100) {
        this.f111814a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f111814a.invoke2();
    }
}
