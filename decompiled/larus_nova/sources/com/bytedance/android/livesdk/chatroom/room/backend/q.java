package com.bytedance.android.livesdk.chatroom.room.backend;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Consumer f110847a;

    public q(Consumer r100) {
        this.f110847a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f110847a.accept(null);
    }
}
