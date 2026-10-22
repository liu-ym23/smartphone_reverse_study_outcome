package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class q1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerShadowWidget f119162a;

    public q1(PlayerShadowWidget r100) {
        this.f119162a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.chatroom.progress.context.a r101 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r100;
        PlayerShadowWidget.wq(this.f119162a, true);
    }
}
