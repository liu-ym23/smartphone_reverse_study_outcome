package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidLiveCompositeWidget f113419a;

    public k0(PaidLiveCompositeWidget r100) {
        this.f113419a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PaidLiveCompositeWidget r101 = this.f113419a;
        r101.wq((com.bytedance.android.livesdk.vscore_api.paidlive.l) r100);
    }
}
