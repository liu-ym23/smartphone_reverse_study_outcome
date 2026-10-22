package com.bytedance.android.shopping.feed.fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f175095a;

    public l(LottieAnimationView r100) {
        this.f175095a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f175095a.setImageAssetsFolder("images");     // Catch: Throwable -> L4
        this.f175095a.setAnimation("commerce_anchor_v3_guide.json");     // Catch: Throwable -> L4
        this.f175095a.loop(true);     // Catch: Throwable -> L4
        this.f175095a.setRepeatCount(1);     // Catch: Throwable -> L4
        this.f175095a.playAnimation();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
