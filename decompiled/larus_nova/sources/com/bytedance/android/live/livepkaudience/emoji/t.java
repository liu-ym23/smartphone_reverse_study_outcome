package com.bytedance.android.live.livepkaudience.emoji;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f81993a;

    public t(p r100) {
        this.f81993a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        p r102 = this.f81993a;
        r102.f81968c = false;
        p.a r103 = (p.a) r102.f531633a;
        if (r103 == null) goto L6;
        r103.U2(r101);
        return;
    }
}
