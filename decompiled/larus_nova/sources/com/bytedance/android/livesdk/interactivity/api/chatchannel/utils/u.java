package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import zg1.k1;

/* JADX INFO: loaded from: classes9.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomChatChannelCreator f133014a;

    public u(RoomChatChannelCreator r100) {
        this.f133014a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((k1) r100).f571866a == false) goto L11;
        RoomChatChannelCreator r101 = this.f133014a;
        int r102 = RoomChatChannelCreator.f132943m;
        s22.e r103 = r101.b();
        if (r103 == null) goto L7;
        r103.onLoginSuccess();
    L7:
        Disposable r104 = this.f133014a.f132945b;
        if (r104 == null) goto L12;
        r104.dispose();
        return;
    L12:
        return;
    }
}
