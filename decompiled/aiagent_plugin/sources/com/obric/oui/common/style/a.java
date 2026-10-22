package com.obric.oui.common.style;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: IOUIAlpha.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void disablePressReleaseAnim(boolean r1);

    void handleTouchEvent(MotionEvent r1);

    void onPressedChanged(View r1, boolean r2);

    void onSelectedChanged(View r1, boolean r2);

    void refreshColors(String r1);

    void resetAlphaAnim();

    void setChangeAlphaWhenDisable(boolean r1);

    default void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    void setChangeAlphaWhenPress(boolean r1);

    void setChangeAlphaWhenSelected(boolean r1);

    void setKeepPressAlpha(boolean r1);

    void setOverridePressColor(int r1);
}
