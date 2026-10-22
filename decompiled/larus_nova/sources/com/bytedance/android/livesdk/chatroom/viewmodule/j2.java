package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j2 implements Consumer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewFullVideoButtonWidget f115288a;

    public j2(NewFullVideoButtonWidget r100) {
        this.f115288a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Long r100) throws Exception {
        this.f115288a.f115007p.setVisibility(0);
    }
}
