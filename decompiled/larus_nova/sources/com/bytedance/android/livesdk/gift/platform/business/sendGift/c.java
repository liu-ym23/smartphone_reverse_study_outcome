package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f130105a;

    public c(d r100) {
        this.f130105a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f130105a.f130107b.invoke();
        Disposable r102 = this.f130105a.f130106a;
        if (r102 == null) goto L6;
        r102.dispose();
        return;
    }
}
