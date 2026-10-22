package com.obric.oui.common.style;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface IOUIAlpha {
    void disablePressReleaseAnim(boolean r1);

    void handleTouchEvent(MotionEvent r1);

    void onPressedChanged(View r1, boolean r2);

    void onSelectedChanged(View r1, boolean r2);

    void refreshColors(String r1);

    void resetAlphaAnim();

    void setChangeAlphaWhenDisable(boolean r1);

    void setChangeAlphaWhenPress(boolean r1);

    void setChangeAlphaWhenSelected(boolean r1);

    void setKeepPressAlpha(boolean r1);

    void setOverridePressColor(int r1);
}
