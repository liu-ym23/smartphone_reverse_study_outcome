package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class h2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f2 f63411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f63412b;

    public h2(f2 r100, Object r101) {
        this.f63411a = r100;
        this.f63412b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((com.bytedance.android.livesdk.event.z) r100).f123384b == false) goto L5;
        this.f63411a.finishWithSuccess();
        return;
    L5:
        this.f63411a.finishWithFailure();
    }
}
