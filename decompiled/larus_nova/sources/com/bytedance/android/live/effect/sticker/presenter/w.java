package com.bytedance.android.live.effect.sticker.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f68412a;

    public w(s.d.a.RunnableC1117a.C1118a r100) {
        this.f68412a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        m r102 = this.f68412a;
        if (r102 == null) goto L6;
        r102.onFail();
        return;
    }
}
