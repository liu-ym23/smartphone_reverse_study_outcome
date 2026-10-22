package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomWidget f118831a;

    public j2(RoomWidget r100) {
        this.f118831a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) sh6.c.b((sh6.b) r100);
        if (r101 == null) goto L6;
        r101.booleanValue();
        this.f118831a.getClass();
        return;
    }
}
