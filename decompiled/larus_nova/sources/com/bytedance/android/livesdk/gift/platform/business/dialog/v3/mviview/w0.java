package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class w0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVITabView f128150a;

    public w0(GiftMVITabView r100) {
        this.f128150a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f128150a.x(((Integer) r100).intValue());
    }
}
