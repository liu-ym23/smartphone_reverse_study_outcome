package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BubbleController f115846a;

    public e(BubbleController r100) {
        this.f115846a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        g.b r101 = (g.b) r100;
        r101.i();
        this.f115846a.f115774e.a().f(r101);
    }
}
