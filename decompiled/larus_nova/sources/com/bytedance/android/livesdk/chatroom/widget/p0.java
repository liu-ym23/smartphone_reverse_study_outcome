package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class p0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f119157a;

    public p0(q0 r100) {
        this.f119157a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LiveGiftMenuStickerServiceWidget r102 = this.f119157a.f119161a;
        r102.f118528g = null;
        LiveGiftMenuStickerServiceWidget.wq(r102);
    }
}
