package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
abstract class SheetDelegate {
    abstract int calculateInnerMargin(ViewGroup.MarginLayoutParams r1);

    abstract float calculateSlideOffset(int r1);

    abstract int calculateTargetStateOnViewReleased(View r1, float r2, float r3);

    abstract int getExpandedOffset();

    abstract int getHiddenOffset();

    abstract <V extends View> int getOuterEdge(V r1);

    abstract int getSheetEdge();

    abstract boolean isSettling(View r1, int r2, boolean r3);

    abstract boolean shouldHide(View r1, float r2);

    abstract void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams r1, int r2, int r3);

    SheetDelegate() {
    }
}
