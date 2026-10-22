package com.android.server.display;

import com.android.server.display.auto.AnimationInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface IBrightnessRateSelector {
    default void resetAnimatingArgs() {
    }

    default float recalculateAmount(AnimationInfo info) {
        return 1.0f;
    }

    default void updateAnimationInfo(AnimationInfo info) {
    }
}
