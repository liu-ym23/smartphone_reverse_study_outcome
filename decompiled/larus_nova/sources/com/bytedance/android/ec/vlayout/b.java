package com.bytedance.android.ec.vlayout;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    View findViewByPosition(int r100);

    View getChildAt(int r100);

    int getChildCount();

    int getOrientation();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getPosition(View r100);

    boolean getReverseLayout();

    void measureChildWithMargins(View r100, int r101, int r102);
}
