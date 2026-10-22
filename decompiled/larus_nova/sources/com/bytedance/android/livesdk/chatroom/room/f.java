package com.bytedance.android.livesdk.chatroom.room;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f111097a;

    public f(c r100) {
        this.f111097a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        zg1.i r101 = (zg1.i) r100;
        c r102 = this.f111097a;
        if (r101 != null) goto L5;
        r102.getClass();
        return;
    L5:
        r102.f110986j.setValue(Integer.valueOf(r101.f571848a));
    }
}
