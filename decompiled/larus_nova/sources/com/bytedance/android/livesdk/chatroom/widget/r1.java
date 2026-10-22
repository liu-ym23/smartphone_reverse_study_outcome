package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class r1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerShadowWidget f119171a;

    public r1(PlayerShadowWidget r100) {
        this.f119171a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        PlayerShadowWidget.wq(this.f119171a, false);
    }
}
