package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class m2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.api.b f116483a;

    public m2(com.bytedance.android.livesdk.chatroom.vsplayer.api.b r100) {
        this.f116483a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f116483a.hidePlayerTip("schedule_close");
    }
}
