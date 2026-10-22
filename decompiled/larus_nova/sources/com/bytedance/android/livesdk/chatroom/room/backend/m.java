package com.bytedance.android.livesdk.chatroom.room.backend;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f110837a;

    public m(Consumer r100) {
        this.f110837a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f110837a.accept(null);
    }
}
