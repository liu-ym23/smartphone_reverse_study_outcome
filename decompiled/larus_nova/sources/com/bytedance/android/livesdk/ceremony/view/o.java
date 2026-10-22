package com.bytedance.android.livesdk.ceremony.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StaticBorderView f104978a;

    public o(StaticBorderView r100) {
        this.f104978a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f104978a.setAlpha(0.0f);
    }
}
