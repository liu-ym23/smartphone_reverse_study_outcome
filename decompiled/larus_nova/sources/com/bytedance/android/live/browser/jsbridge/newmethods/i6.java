package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class i6<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n6 f63447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.ua f63448b;

    public i6(n6 r100, w20.ua r101) {
        this.f63447a = r100;
        this.f63448b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        n6 r102 = this.f63447a;
        w20.ua r103 = this.f63448b;
        String r104 = r102.f63565a;
        if (r104 == null) goto L5;
        TTExecutors.getNormalExecutor().submit(new h6(r104, r103));
    L5:
        this.f63447a.finishWithFailure(r101);
    }
}
