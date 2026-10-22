package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListService f132272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f132273b;

    public c(FormatGiftListService r100, w r101) {
        this.f132272a = r100;
        this.f132273b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        w r101 = this.f132273b;
        if (r101 == null) goto L6;
        r101.b(this.f132272a.f132257b);
        return;
    }
}
