package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VisibleLogManager f182100a;

    public h(VisibleLogManager r100) {
        this.f182100a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        VisibleLogManager.a(this.f182100a);
    }
}
