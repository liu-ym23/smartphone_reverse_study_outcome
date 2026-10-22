package com.bytedance.android.livesdk.interactivity.medialink.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaLinkControlPresenter f138528a;

    public c(MediaLinkControlPresenter r100) {
        this.f138528a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        this.f138528a.f0(r101);
        return;
    }
}
