package com.bytedance.android.window.shop.widget.holderprocessor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f190046a;

    public g(f r100) {
        this.f190046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f190046a.f190045e.invoke();
    }
}
