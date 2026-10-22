package com.bytedance.android.livesdk.chatroom.ui;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;

/* JADX INFO: loaded from: classes8.dex */
public final class v7<T> implements LottieListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSkeletonScreenLoadingView f114270a;

    public v7(LiveSkeletonScreenLoadingView r100) {
        this.f114270a = r100;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(Object r100) {
        LottieComposition r101 = (LottieComposition) r100;
        LottieAnimationView r102 = this.f114270a.f112345a;
        if (r102 == null) goto L5;
        r102.setComposition(r101);
    L5:
        LottieAnimationView r103 = this.f114270a.f112345a;
        if (r103 == null) goto L9;
        r103.playAnimation();
        return;
    }
}
