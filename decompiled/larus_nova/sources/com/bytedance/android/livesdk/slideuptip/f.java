package com.bytedance.android.livesdk.slideuptip;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSlideUpTipsGuideStrategy f158408a;

    public f(LiveSlideUpTipsGuideStrategy r100) {
        this.f158408a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveSlideUpTipsGuideStrategy r101 = this.f158408a;
        String r102 = "getSlideUpTips error " + ((Throwable) r100).getMessage();
        r101.getClass();
        LiveSlideUpTipsGuideStrategy.b(r102);
    }
}
