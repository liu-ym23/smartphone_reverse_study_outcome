package com.bytedanceos.common.ui.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteItemAnimation {
    public DeleteItemAnimation() {
    }

    public static void hideOrShowView(final View r10, View r11, final int r12, final Animation.AnimationListener r13) {
        Animation r14 = new AnonymousClass3(r13, r12, r10);
        if (r11 == null) goto L5;
        r11.setVisibility(8);
    L5:
        r10.startAnimation(r14);
    }

    public static void slideAnimBottomView(final View r10) {
        AlphaAnimation r11 = new AlphaAnimation(1.0f, 0.0f);
        r11.setInterpolator(CubicInterpolator.OUT);
        r11.setDuration(150);
        r11.setAnimationListener(new AnonymousClass1(r10));
        r10.startAnimation(r11);
    }

    public static void slideAnimTopView(final View r10, final View r11, int r12, final int r13, final Animation.AnimationListener r14) {
        TranslateAnimation r15 = new TranslateAnimation(0.0f, r12, 0.0f, 0.0f);
        r15.setInterpolator(CubicInterpolator.OUT);
        r15.setDuration(150);
        r15.setAnimationListener(new AnonymousClass2(r10, r11, r13, r14));
        r10.startAnimation(r15);
    }
}
