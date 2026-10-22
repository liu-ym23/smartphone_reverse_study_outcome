package com.bytedance.android.live.tetris;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpPushServiceWidget f101935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k61.a f101936b;

    public b(ExpPushServiceWidget r100, k61.a r101) {
        this.f101935a = r100;
        this.f101936b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f101935a.yq(this.f101936b);
    }
}
