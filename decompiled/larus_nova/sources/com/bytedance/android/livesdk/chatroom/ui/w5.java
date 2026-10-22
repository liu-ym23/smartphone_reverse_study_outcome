package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class w5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicEmojiView f114288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wj0.b f114289b;

    public w5(DynamicEmojiView r100, wj0.b r101) {
        this.f114288a = r100;
        this.f114289b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f114288a.f112133b.b(new wj0.a.C8118a(this.f114289b));
    }
}
