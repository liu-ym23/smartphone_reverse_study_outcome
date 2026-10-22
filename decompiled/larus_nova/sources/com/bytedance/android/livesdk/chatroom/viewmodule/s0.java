package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class s0 implements Consumer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullVideoButtonWidget f115436a;

    public s0(FullVideoButtonWidget r100) {
        this.f115436a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Long r100) throws Exception {
        this.f115436a.f114954l.setVisibility(0);
    }
}
