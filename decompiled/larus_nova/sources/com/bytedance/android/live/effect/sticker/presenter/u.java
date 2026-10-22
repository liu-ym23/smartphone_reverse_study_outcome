package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f68408a;

    public u(StickerAigcViewModel.b.a r100) {
        this.f68408a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        j r102 = this.f68408a;
        if (r102 == null) goto L6;
        r102.onFail();
        return;
    }
}
