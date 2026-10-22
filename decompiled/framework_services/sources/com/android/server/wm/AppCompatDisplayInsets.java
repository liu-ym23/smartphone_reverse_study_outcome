package com.android.server.wm;

import android.graphics.Point;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatDisplayInsets {
    private final int mHeight;
    final boolean mIsFloating;
    final boolean mIsInFixedOrientationOrAspectRatioLetterbox;
    final Rect[] mNonDecorInsets;
    final int mOriginalRequestedOrientation;
    final int mOriginalRotation;
    final Rect[] mStableInsets;
    private final int mWidth;

    AppCompatDisplayInsets(DisplayContent display, ActivityRecord container, Rect letterboxedContainerBounds, boolean useOverrideInsets) {
        int r2 = 4;
        this.mNonDecorInsets = new Rect[4];
        this.mStableInsets = new Rect[4];
        this.mOriginalRotation = display.getRotation();
        this.mIsFloating = container.getWindowConfiguration().tasksAreFloating();
        this.mOriginalRequestedOrientation = container.getRequestedConfigurationOrientation();
        int r4 = 0;
        if (this.mIsFloating == false) goto L9;
        Rect containerBounds = container.getWindowConfiguration().getBounds();
        this.mWidth = containerBounds.width();
        this.mHeight = containerBounds.height();
        Rect emptyRect = new Rect();
        int rotation = 0;
    L5:
        if (rotation >= 4) goto L7;
        this.mNonDecorInsets[rotation] = emptyRect;
        this.mStableInsets[rotation] = emptyRect;
        rotation = rotation + 1;
        goto L5
    L7:
        this.mIsInFixedOrientationOrAspectRatioLetterbox = false;
        return;
    L9:
        Task task = container.getTask();
        int r5 = 1;
        if (letterboxedContainerBounds == null) goto L12;
        boolean r6 = true;
    L13:
        this.mIsInFixedOrientationOrAspectRatioLetterbox = r6;
        if (this.mIsInFixedOrientationOrAspectRatioLetterbox == false) goto L16;
        Rect filledContainerBounds = letterboxedContainerBounds;
    L20:
        if (container.hasFixedRotationTransform() == true) goto L22;
    L24:
        boolean useActivityRotation = false;
    L25:
        if (useActivityRotation == false) goto L27;
        int filledContainerRotation = container.getWindowConfiguration().getRotation();
    L28:
        Point dimensions = getRotationZeroDimensions(filledContainerBounds, filledContainerRotation);
        this.mWidth = dimensions.x;
        this.mHeight = dimensions.y;
        if (filledContainerBounds.equals(display.getBounds()) == false) goto L31;
        Rect unfilledContainerBounds = null;
    L32:
        DisplayPolicy policy = display.getDisplayPolicy();
        int rotation2 = 0;
    L33:
        if (rotation2 >= r2) goto L56;
        this.mNonDecorInsets[rotation2] = new Rect();
        this.mStableInsets[rotation2] = new Rect();
        if (rotation2 != r5) goto L37;
    L40:
        int r13 = r5;
    L41:
        if (r13 == 0) goto L43;
        int dw = display.mBaseDisplayHeight;
    L44:
        if (r13 == 0) goto L46;
        int dh = display.mBaseDisplayWidth;
    L47:
        DisplayPolicy.DecorInsets.Info decorInfo = policy.getDecorInsetsInfo(rotation2, dw, dh);
        if (useOverrideInsets == false) goto L50;
        this.mStableInsets[rotation2].set(decorInfo.mOverrideConfigInsets);
        this.mNonDecorInsets[rotation2].set(decorInfo.mOverrideNonDecorInsets);
    L51:
        if (unfilledContainerBounds == null) goto L54;
        unfilledContainerBounds.set(filledContainerBounds);
        display.rotateBounds(filledContainerRotation, rotation2, unfilledContainerBounds);
        updateInsetsForBounds(unfilledContainerBounds, dw, dh, this.mNonDecorInsets[rotation2]);
        updateInsetsForBounds(unfilledContainerBounds, dw, dh, this.mStableInsets[rotation2]);
    L54:
        rotation2 = rotation2 + 1;
        r2 = 4;
        r4 = 0;
        r5 = 1;
        goto L33
    L50:
        this.mStableInsets[rotation2].set(decorInfo.mConfigInsets);
        this.mNonDecorInsets[rotation2].set(decorInfo.mNonDecorInsets);
        goto L51
    L46:
        dh = display.mBaseDisplayHeight;
        goto L47
    L43:
        dw = display.mBaseDisplayWidth;
        goto L44
    L37:
        if (rotation2 == 3) goto L40;
        r13 = r4;
        goto L41
    L56:
        return;
    L31:
        unfilledContainerBounds = new Rect();
        goto L32
    L27:
        filledContainerRotation = display.getConfiguration().windowConfiguration.getRotation();
        goto L28
    L22:
        if (this.mIsInFixedOrientationOrAspectRatioLetterbox == false) goto L24;
        useActivityRotation = true;
        goto L25
    L16:
        if (task == null) goto L18;
        filledContainerBounds = task.getBounds();
        goto L20
    L18:
        filledContainerBounds = display.getBounds();
        goto L20
    L12:
        r6 = false;
        goto L13
    }

    private static Point getRotationZeroDimensions(Rect bounds, int rotation) {
        boolean rotated = true;
        if (rotation != 1) goto L5;
    L8:
        int width = bounds.width();
        int height = bounds.height();
        if (rotated == false) goto L11;
        Point r3 = new Point(height, width);
    L12:
        return r3;
    L11:
        r3 = new Point(width, height);
        goto L12
    L5:
        if (rotation == 3) goto L8;
        rotated = false;
        goto L8
    }

    private static void updateInsetsForBounds(Rect bounds, int displayWidth, int displayHeight, Rect inset) {
        inset.left = Math.max(0, inset.left - bounds.left);
        inset.top = Math.max(0, inset.top - bounds.top);
        inset.right = Math.max(0, (bounds.right - displayWidth) + inset.right);
        inset.bottom = Math.max(0, (bounds.bottom - displayHeight) + inset.bottom);
    }

    void getBoundsByRotation(Rect outBounds, int rotation) {
        boolean rotated = true;
        if (rotation != 1) goto L5;
    L8:
        if (rotated == false) goto L10;
        int dw = this.mHeight;
    L11:
        if (rotated == false) goto L13;
        int dh = this.mWidth;
    L14:
        outBounds.set(0, 0, dw, dh);
        return;
    L13:
        dh = this.mHeight;
        goto L14
    L10:
        dw = this.mWidth;
        goto L11
    L5:
        if (rotation == 3) goto L8;
        rotated = false;
        goto L8
    }

    void getFrameByOrientation(Rect outBounds, int orientation) {
        int longSide = Math.max(this.mWidth, this.mHeight);
        int shortSide = Math.min(this.mWidth, this.mHeight);
        if (orientation != 2) goto L5;
        boolean isLandscape = true;
    L6:
        if (isLandscape == false) goto L8;
        int r4 = longSide;
    L9:
        if (isLandscape == false) goto L11;
        int r5 = shortSide;
    L12:
        outBounds.set(0, 0, r4, r5);
        return;
    L11:
        r5 = longSide;
        goto L12
    L8:
        r4 = shortSide;
        goto L9
    L5:
        isLandscape = false;
        goto L6
    }

    void getContainerBounds(Rect outAppBounds, Rect outBounds, int rotation, int orientation, boolean orientationRequested, boolean isFixedToUserRotation) {
        getFrameByOrientation(outBounds, orientation);
        if (this.mIsFloating == false) goto L6;
        outAppBounds.set(outBounds);
        return;
    L6:
        getBoundsByRotation(outAppBounds, rotation);
        int dW = outAppBounds.width();
        int dH = outAppBounds.height();
        boolean isOrientationMismatched = true;
        if (outBounds.width() <= outBounds.height()) goto L9;
        boolean r2 = true;
    L10:
        if (dW <= dH) goto L12;
        boolean r3 = true;
    L13:
        if (r2 != r3) goto L16;
        isOrientationMismatched = false;
    L16:
        if (isOrientationMismatched == false) goto L24;
        if (isFixedToUserRotation == false) goto L24;
        if (orientationRequested == false) goto L24;
        if (orientation != 2) goto L22;
        outBounds.bottom = (int) ((dW * dW) / dH);
        outBounds.right = dW;
    L23:
        outBounds.offset(getCenterOffset(this.mWidth, outBounds.width()), 0);
        goto L24
    L22:
        outBounds.bottom = dH;
        outBounds.right = (int) ((dH * dH) / dW);
    L24:
        outAppBounds.set(outBounds);
        if (isOrientationMismatched == false) goto L29;
        Rect insets = this.mNonDecorInsets[rotation];
        outBounds.offset(insets.left, insets.top);
        outAppBounds.offset(insets.left, insets.top);
        return;
    L29:
        if (rotation == (-1)) goto L33;
        TaskFragment.intersectWithInsetsIfFits(outAppBounds, outBounds, this.mNonDecorInsets[rotation]);
        return;
    L33:
        return;
    L12:
        r3 = false;
        goto L13
    L9:
        r2 = false;
        goto L10
    }

    private static int getCenterOffset(int viewportDim, int contentDim) {
        return (int) (((viewportDim - contentDim) + 1) * 0.5f);
    }
}
