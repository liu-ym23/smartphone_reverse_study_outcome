package com.bytedance.android.livesdk.chatroom.resolution.tips.rec;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameRecSceneStrategy f110502a;

    public b(GameRecSceneStrategy r100) {
        this.f110502a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        GameRecSceneStrategy.c(this.f110502a);
    }
}
