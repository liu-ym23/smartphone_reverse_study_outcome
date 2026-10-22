package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartResponse;
import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f151690a;

    public h(com.bytedance.android.livesdk.livecommerce.iron.helper.m r100) {
        this.f151690a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        v0 r101 = this.f151690a;
        r101.onSuccess((ECEditCartResponse) r100);
    }
}
