package com.android.server.wm;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: classes3.dex */
class LaunchParamsUtil {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_LANDSCAPE_FREEFORM_HEIGHT_DP = 600;
    private static final int DEFAULT_LANDSCAPE_FREEFORM_WIDTH_DP = 1064;
    static final int DEFAULT_PORTRAIT_FREEFORM_HEIGHT_DP = 732;
    static final int DEFAULT_PORTRAIT_FREEFORM_WIDTH_DP = 412;
    private static final int DISPLAY_EDGE_OFFSET_DP = 27;
    private static final String TAG = "ActivityTaskManager";
    private static final Rect TMP_STABLE_BOUNDS = null;

    static {
        TMP_STABLE_BOUNDS = new Rect();
    }

    private LaunchParamsUtil() {
    }

    static void centerBounds(TaskDisplayArea displayArea, int width, int height, Rect inOutBounds) {
        if (inOutBounds.isEmpty() == false) goto L5;
        displayArea.getStableRect(inOutBounds);
    L5:
        int left = inOutBounds.centerX() - (width / 2);
        int top = inOutBounds.centerY() - (height / 2);
        inOutBounds.set(left, top, left + width, top + height);
    }

    static Size getDefaultFreeformSize(ActivityRecord activityRecord, TaskDisplayArea displayArea, ActivityInfo.WindowLayout layout, int orientation, Rect stableBounds) {
        float density = displayArea.getConfiguration().densityDpi / 160.0f;
        if (orientation != 0) goto L5;
        int freeformWidthInDp = DEFAULT_LANDSCAPE_FREEFORM_WIDTH_DP;
    L6:
        if (orientation != 0) goto L8;
        int freeformHeightInDp = 600;
    L9:
        int freeformWidth = (int) ((freeformWidthInDp * density) + 0.5f);
        int freeformHeight = (int) ((freeformHeightInDp * density) + 0.5f);
        int layoutMinHeight = -1;
        if (layout != null) goto L12;
        int layoutMinWidth = -1;
    L13:
        if (layout == null) goto L16;
        layoutMinHeight = layout.minHeight;
    L16:
        int portraitHeight = Math.min(stableBounds.width(), stableBounds.height());
        int otherDimension = Math.max(stableBounds.width(), stableBounds.height());
        int portraitWidth = (portraitHeight * portraitHeight) / otherDimension;
        if (orientation != 0) goto L19;
        int maxWidth = portraitHeight;
    L21:
        if (orientation != 0) goto L23;
        int maxHeight = portraitWidth;
    L24:
        int width = Math.min(maxWidth, Math.max(freeformWidth, layoutMinWidth));
        int height = Math.min(maxHeight, Math.max(freeformHeight, layoutMinHeight));
        float aspectRatio = Math.max(width, height) / Math.min(width, height);
        float minAspectRatio = activityRecord.getMinAspectRatio();
        float maxAspectRatio = activityRecord.info.getMaxAspectRatio();
        if (minAspectRatio >= 1.0f) goto L27;
    L31:
        int adjWidth = width;
        int adjHeight = height;
        if (maxAspectRatio >= 1.0f) goto L34;
    L39:
        return new Size(adjWidth, adjHeight);
    L34:
        if (aspectRatio <= maxAspectRatio) goto L39;
        if (orientation != 0) goto L37;
        adjHeight = (int) ((adjWidth / maxAspectRatio) + 0.5f);
        goto L39
    L37:
        adjWidth = (int) ((adjHeight / maxAspectRatio) + 0.5f);
        goto L39
    L27:
        if (aspectRatio >= minAspectRatio) goto L31;
        if (orientation != 0) goto L30;
        adjWidth = width;
        adjHeight = (int) ((adjWidth / minAspectRatio) + 0.5f);
        goto L39
    L30:
        adjHeight = height;
        adjWidth = (int) ((adjHeight / minAspectRatio) + 0.5f);
        goto L39
    L23:
        maxHeight = portraitHeight;
        goto L24
    L19:
        maxWidth = portraitWidth;
        goto L21
    L12:
        layoutMinWidth = layout.minWidth;
        goto L13
    L8:
        freeformHeightInDp = DEFAULT_PORTRAIT_FREEFORM_HEIGHT_DP;
        goto L9
    L5:
        freeformWidthInDp = 412;
        goto L6
    }

    static void adjustBoundsToFitInDisplayArea(TaskDisplayArea displayArea, int layoutDirection, ActivityInfo.WindowLayout layout, Rect inOutBounds) {
        Rect stableBounds = TMP_STABLE_BOUNDS;
        displayArea.getStableRect(stableBounds);
        float density = displayArea.getConfiguration().densityDpi / 160.0f;
        int displayEdgeOffset = (int) ((27.0f * density) + 0.5f);
        stableBounds.inset(displayEdgeOffset, displayEdgeOffset);
        if (stableBounds.width() >= inOutBounds.width()) goto L5;
    L6:
        float heightShrinkRatio = stableBounds.width() / inOutBounds.width();
        float widthShrinkRatio = stableBounds.height() / inOutBounds.height();
        float shrinkRatio = Math.min(heightShrinkRatio, widthShrinkRatio);
        int layoutMinHeight = -1;
        if (layout != null) goto L9;
        int layoutMinWidth = -1;
    L10:
        if (layout == null) goto L13;
        layoutMinHeight = layout.minHeight;
    L13:
        int adjustedWidth = Math.max(layoutMinWidth, (int) (inOutBounds.width() * shrinkRatio));
        int adjustedHeight = Math.max(layoutMinHeight, (int) (inOutBounds.height() * shrinkRatio));
        if (stableBounds.width() < adjustedWidth) goto L36;
        if (stableBounds.height() < adjustedHeight) goto L36;
        inOutBounds.set(inOutBounds.left, inOutBounds.top, inOutBounds.left + adjustedWidth, inOutBounds.top + adjustedHeight);
    L20:
        if (inOutBounds.right <= stableBounds.right) goto L22;
        int dx = stableBounds.right - inOutBounds.right;
    L27:
        if (inOutBounds.top >= stableBounds.top) goto L29;
        int dy = stableBounds.top - inOutBounds.top;
    L33:
        inOutBounds.offset(dx, dy);
        return;
    L29:
        int dy2 = inOutBounds.bottom;
        if (dy2 <= stableBounds.bottom) goto L32;
        dy = stableBounds.bottom - inOutBounds.bottom;
        goto L33
    L32:
        dy = 0;
        goto L33
    L22:
        int dx2 = inOutBounds.left;
        if (dx2 >= stableBounds.left) goto L25;
        dx = stableBounds.left - inOutBounds.left;
        goto L27
    L25:
        dx = 0;
    L36:
        if (layoutDirection != 1) goto L38;
        int left = stableBounds.right - adjustedWidth;
    L39:
        inOutBounds.set(left, stableBounds.top, left + adjustedWidth, stableBounds.top + adjustedHeight);
        return;
    L38:
        left = stableBounds.left;
        goto L39
    L9:
        layoutMinWidth = layout.minWidth;
        goto L10
    L5:
        if (stableBounds.height() >= inOutBounds.height()) goto L20;
        goto L6
    }

    static void calculateLayoutBounds(Rect stableBounds, ActivityInfo.WindowLayout windowLayout, Rect inOutBounds, Size desiredSize) {
        int defaultWidth = stableBounds.width();
        int defaultHeight = stableBounds.height();
        if (desiredSize != null) goto L5;
        desiredSize = new Size(stableBounds.width(), stableBounds.height());
    L5:
        int width = desiredSize.getWidth();
        if (windowLayout.width <= 0) goto L11;
        if (windowLayout.width >= defaultWidth) goto L11;
        width = windowLayout.width;
    L15:
        int height = desiredSize.getHeight();
        if (windowLayout.height <= 0) goto L21;
        if (windowLayout.height >= defaultHeight) goto L21;
        height = windowLayout.height;
    L25:
        inOutBounds.set(0, 0, width, height);
        return;
    L21:
        if (windowLayout.heightFraction <= 0.0f) goto L25;
        if (windowLayout.heightFraction >= 1.0f) goto L25;
        height = (int) (defaultHeight * windowLayout.heightFraction);
    L11:
        if (windowLayout.widthFraction <= 0.0f) goto L15;
        if (windowLayout.widthFraction >= 1.0f) goto L15;
        width = (int) (defaultWidth * windowLayout.widthFraction);
        goto L15
    }

    static void applyLayoutGravity(int verticalGravity, int horizontalGravity, Rect inOutBounds, Rect stableBounds) {
        int width = inOutBounds.width();
        int height = inOutBounds.height();
        switch(horizontalGravity) {
            case 3: goto L6;
            case 4: goto L4;
            case 5: goto L5;
            default: goto L4;
        };
    L4:
        float fractionOfHorizontalOffset = 0.5f;
    L7:
        switch(verticalGravity) {
            case 48: goto L10;
            case 80: goto L9;
            default: goto L8;
        };
    L8:
        float fractionOfVerticalOffset = 0.5f;
    L11:
        inOutBounds.offsetTo(stableBounds.left, stableBounds.top);
        int xOffset = (int) ((stableBounds.width() - width) * fractionOfHorizontalOffset);
        int yOffset = (int) ((stableBounds.height() - height) * fractionOfVerticalOffset);
        inOutBounds.offset(xOffset, yOffset);
        return;
    L9:
        fractionOfVerticalOffset = 1.0f;
        goto L11
    L10:
        fractionOfVerticalOffset = 0.0f;
        goto L11
    L5:
        fractionOfHorizontalOffset = 1.0f;
        goto L7
    L6:
        fractionOfHorizontalOffset = 0.0f;
        goto L7
    }
}
