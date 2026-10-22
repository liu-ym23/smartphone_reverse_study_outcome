package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class y5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicEmojiView f114313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wj0.b f114314b;

    public y5(DynamicEmojiView r100, wj0.b r101) {
        this.f114313a = r100;
        this.f114314b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f114313a.f112133b.b(new wj0.a.e(this.f114314b));
    }
}
