package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class w2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarBubbleManager.i f116820a;

    public w2(ToolbarBubbleManager.i r100) {
        this.f116820a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f116820a.f115724b.a(ToolbarBubbleManager.BubbleInfo.State.DISMISSED);
    }
}
