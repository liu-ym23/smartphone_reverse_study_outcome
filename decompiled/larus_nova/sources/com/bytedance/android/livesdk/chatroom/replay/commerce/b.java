package com.bytedance.android.livesdk.chatroom.replay.commerce;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayECProductWidget f108282a;

    public b(ReplayECProductWidget r100) {
        this.f108282a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.chatroom.progress.context.a r101 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r100;
        this.f108282a.wq(true);
    }
}
