package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import vl2.m;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonLottieAnimationWidget f153472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f153473b;

    public g(CommonLottieAnimationWidget r100, k r101) {
        this.f153472a = r100;
        this.f153473b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        CommonLottieAnimationWidget r102 = this.f153472a;
        m r103 = (m) r101.component2();
        LottieComposition r104 = (LottieComposition) r101.component1();
        LottieAnimationView r105 = r102.f153462a;
        if (r105 == null) goto L5;
        r105.cancelAnimation();
        r105.setProgress(0.0f);
        r105.setImageAssetDelegate(new d(r103));
        r105.setComposition(r104);
    L5:
        LottieAnimationView r106 = this.f153472a.f153462a;
        if (r106 == null) goto L8;
        r106.addAnimatorListener(new f(this));
    L8:
        LottieAnimationView r107 = this.f153472a.f153462a;
        if (r107 == null) goto L11;
        r107.setVisibility(0);
    L11:
        LottieAnimationView r108 = this.f153472a.f153462a;
        if (r108 == null) goto L15;
        r108.playAnimation();
        return;
    }
}
