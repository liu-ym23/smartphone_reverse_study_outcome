package com.bytedance.android.livesdk.chatroom.replay.commerce;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayECProductWidget f108284a;

    public d(ReplayECProductWidget r100) {
        this.f108284a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f108284a.wq(((Boolean) r100).booleanValue());
    }
}
