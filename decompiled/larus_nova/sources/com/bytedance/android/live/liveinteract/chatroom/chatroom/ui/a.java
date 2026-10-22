package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f72441a;

    public a(b r100) {
        this.f72441a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f72441a.c();
    }
}
