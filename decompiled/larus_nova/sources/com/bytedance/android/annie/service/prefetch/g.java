package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f39965a;

    public g(d r100) {
        this.f39965a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f39965a.k();
        d r101 = this.f39965a;
        r101.finishWithFailure((Throwable) r100);
    }
}
