package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WelfareProjectCardWidget f117672a;

    public y(WelfareProjectCardWidget r100) {
        this.f117672a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        WelfareProjectCardWidget r102 = this.f117672a;
        int r103 = WelfareProjectCardWidget.f117598h;
        r102.getClass();
        xs2.b.a().post(new w(false, true, new int[2], 0));
    }
}
