package com.bytedance.android.live.profile.usecase;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f87041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f87042b;

    public p(n r100, Context r101) {
        this.f87041a = r100;
        this.f87042b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        v r101 = os0.b.b(this.f87041a.f87033c.getRoomDataCenter());
        Context r102 = this.f87042b;
        r101.d(r102, (Throwable) r100);
    }
}
