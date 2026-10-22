package com.android.server.display;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtRampAnimator<T> extends IExtBase {

    public interface IExtDualRampAnimator<T> extends IExtBase {
        void animateTo(float r1, float r2, float r3, boolean r4);

        RampAnimator<T> getFirstRampAnimator();

        RampAnimator<T> getSecondRampAnimator();

        void onDualAnimationEnd();

        void onDualAnimationStart();

        void setBrightnessRateSelector(IBrightnessRateSelector r1, IBrightnessRateSelector r2);

        void setListener(Listener r1);

        void setRateType(int r1, int r2);
    }

    public interface Listener {
        void onAnimationEnd(boolean r1, boolean r2, float r3);

        void onDualAnimationEnd(float r1, float r2);

        void onDualAnimationStart();
    }

    void init();

    void onAnimatingStart(float r1, float r2);

    void onAnimationEnd(boolean r1, float r2, float r3);

    void onAnimationStart(float r1, float r2);

    float recalculateAmount(float r1, float r2);

    void setBrightnessRateSelector(IBrightnessRateSelector r1);

    void setListener(Listener r1);

    void setPropertyValue(float r1, float r2);

    void setRateType(int r1, int r2);
}
