package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonLottieAnimationWidget f153467a;

    public a(CommonLottieAnimationWidget r100) {
        this.f153467a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LottieAnimationView r102 = this.f153467a.f153462a;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        return;
    }
}
