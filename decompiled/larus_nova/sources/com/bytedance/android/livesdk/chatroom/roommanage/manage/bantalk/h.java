package com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f111441a;

    public h(f r100) {
        this.f111441a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        f r102 = this.f111441a;
        r102.f111430e = false;
        r102.f111436k.setLoadingMore(false);
    }
}
