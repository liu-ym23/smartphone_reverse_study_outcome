package com.bytedance.android.livesdk.chatroom.replay.commerce;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayECProductWidget f108283a;

    public c(ReplayECProductWidget r100) {
        this.f108283a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        this.f108283a.wq(false);
    }
}
