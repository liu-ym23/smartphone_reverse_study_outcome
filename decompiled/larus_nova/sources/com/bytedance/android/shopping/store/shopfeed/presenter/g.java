package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMomentFlowGuidePresenter f186310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f186311b;

    public g(ECShopMomentFlowGuidePresenter r100, View r101) {
        this.f186310a = r100;
        this.f186311b = r101;
    }

    public final void a() {
        FrameLayout r100 = this.f186310a.f186268g;
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.addView(this.f186311b);
    L5:
        ECShopMomentFlowGuidePresenter r101 = this.f186310a;
        r101.getClass();
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(3500);
        r102.addListener(new f(r101));
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(0);
        r103.addListener(new e(r101));
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r102, r103});
        r104.start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
