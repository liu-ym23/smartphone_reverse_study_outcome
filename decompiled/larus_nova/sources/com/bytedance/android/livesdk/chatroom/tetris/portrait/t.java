package com.bytedance.android.livesdk.chatroom.tetris.portrait;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitRow3rdTetris$initFirstShowHint$1 f111813a;

    public t(PortraitRow3rdTetris$initFirstShowHint$1 r100) {
        this.f111813a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        this.f111813a.invoke2();
    }
}
