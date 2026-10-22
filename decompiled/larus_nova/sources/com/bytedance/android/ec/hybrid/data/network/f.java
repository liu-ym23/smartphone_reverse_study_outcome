package com.bytedance.android.ec.hybrid.data.network;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f46818a;

    public f(HybridFetchDefault.b.a r100) {
        this.f46818a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f46818a.run();
    }
}
