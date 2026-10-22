package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListService f132277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f132278b;

    public f(FormatGiftListService r100, w r101) {
        this.f132277a = r100;
        this.f132278b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f132277a.f132260e = false;
        w r102 = this.f132278b;
        if (r102 == null) goto L6;
        r102.a();
        return;
    }
}
