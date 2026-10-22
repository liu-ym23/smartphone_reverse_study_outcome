package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class p0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.e f116648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.f f116649b;

    public p0(i0.e r100, i0.g r101) {
        this.f116648a = r100;
        this.f116649b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f116648a.f116343d = true;
        this.f116649b.onFinish();
    }
}
