package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class r0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVISearchView f127972a;

    public r0(GiftMVISearchView r100) {
        this.f127972a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f127972a.s();
    }
}
