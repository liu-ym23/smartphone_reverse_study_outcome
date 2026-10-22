package com.bytedance.android.livesdk.gift.platform.business.anchor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f126528a;

    public d(e r100) {
        this.f126528a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f126528a.f126529a = false;
    }
}
