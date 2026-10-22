package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout r10);

    void onPostDraw(Canvas r10);

    void onPreDraw(Canvas r10);

    void onPreSetup(MotionLayout r10, HashMap<View, l> r11);
}
