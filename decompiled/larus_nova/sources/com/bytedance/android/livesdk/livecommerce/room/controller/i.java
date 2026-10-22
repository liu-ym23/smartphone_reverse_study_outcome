package com.bytedance.android.livesdk.livecommerce.room.controller;

import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f151691a;

    public i(com.bytedance.android.livesdk.livecommerce.iron.helper.m r100) {
        this.f151691a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        v0 r102 = this.f151691a;
        if (r102 == null) goto L6;
        r102.onError(r101);
        return;
    }
}
