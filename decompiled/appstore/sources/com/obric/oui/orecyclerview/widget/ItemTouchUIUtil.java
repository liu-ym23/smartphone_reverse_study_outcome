package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public interface ItemTouchUIUtil {
    @SuppressLint({"UnknownNullness"})
    void clearView(View r10);

    @SuppressLint({"UnknownNullness"})
    void onDraw(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16);

    @SuppressLint({"UnknownNullness"})
    void onDrawOver(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16);

    @SuppressLint({"UnknownNullness"})
    void onSelected(View r10);
}
