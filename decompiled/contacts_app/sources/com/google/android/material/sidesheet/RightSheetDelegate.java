package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes2.dex */
final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getSheetEdge() {
        return 0;
    }

    RightSheetDelegate(SideSheetBehavior<? extends View> r1) {
        this.sheetBehavior = r1;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    private boolean isReleasedCloseToOriginEdge(View r2) {
        if (r2.getLeft() <= ((getHiddenOffset() - getExpandedOffset()) / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateTargetStateOnViewReleased(View r5, float r6, float r7) {
        if (r6 >= 0.0f) goto L6;
        return 3;
    L6:
        if (shouldHide(r5, r6) == false) goto L13;
        if (isSwipeSignificant(r6, r7) == true) goto L19;
        if (isReleasedCloseToOriginEdge(r5) == true) goto L19;
        return 3;
    L19:
        return 5;
    L13:
        if (r6 != 0.0f) goto L15;
    L16:
        int r8 = r5.getLeft();
        if (Math.abs(r8 - getExpandedOffset()) >= Math.abs(r8 - getHiddenOffset())) goto L19;
        return 3;
    L15:
        if (SheetUtils.isSwipeMostlyHorizontal(r6, r7) == true) goto L19;
        goto L16
    }

    private boolean isSwipeSignificant(float r1, float r2) {
        if (SheetUtils.isSwipeMostlyHorizontal(r1, r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2 <= this.sheetBehavior.getSignificantVelocityThreshold()) goto L7;
        return true;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean shouldHide(View r2, float r3) {
        if (Math.abs(r2.getRight() + (r3 * this.sheetBehavior.getHideFriction())) <= this.sheetBehavior.getHideThreshold()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isSettling(View r2, int r3, boolean r4) {
        int r5 = this.sheetBehavior.getOuterEdgeOffsetForState(r3);
        ViewDragHelper r1 = this.sheetBehavior.getViewDragHelper();
        if (r1 == null) goto L11;
        if (r4 == false) goto L9;
        if (r1.settleCapturedViewAt(r5, r2.getTop()) == false) goto L11;
    L10:
        return true;
    L9:
        if (r1.smoothSlideViewTo(r2, r5, r2.getTop()) == true) goto L10;
    L11:
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    <V extends View> int getOuterEdge(V r1) {
        return r1.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float calculateSlideOffset(int r2) {
        float r0 = getHiddenOffset();
        return (r0 - r2) / (r0 - getExpandedOffset());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams r1, int r2, int r3) {
        int r0 = this.sheetBehavior.getParentWidth();
        if (r2 > r0) goto L6;
        r1.rightMargin = r0 - r2;
        return;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateInnerMargin(ViewGroup.MarginLayoutParams r1) {
        return r1.rightMargin;
    }
}
