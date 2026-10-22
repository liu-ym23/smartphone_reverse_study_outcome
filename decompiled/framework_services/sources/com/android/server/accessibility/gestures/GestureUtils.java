package com.android.server.accessibility.gestures;

import android.graphics.PointF;
import android.util.MathUtils;
import android.view.MotionEvent;
import com.android.server.job.JobPackageTracker;

/* JADX INFO: loaded from: classes.dex */
public final class GestureUtils {
    public static float CM_PER_INCH;
    public static int MM_PER_CM;

    static {
        MM_PER_CM = 10;
        CM_PER_INCH = 2.54f;
    }

    private GestureUtils() {
    }

    public static boolean isMultiTap(MotionEvent firstUp, MotionEvent secondUp, int multiTapTimeSlop, int multiTapDistanceSlop) {
        if (firstUp == null) goto L7;
        if (secondUp != null) goto L6;
        return false;
    L6:
        return eventsWithinTimeAndDistanceSlop(firstUp, secondUp, multiTapTimeSlop, multiTapDistanceSlop);
    L7:
        return false;
    }

    private static boolean eventsWithinTimeAndDistanceSlop(MotionEvent first, MotionEvent second, int timeout, int distance) {
        if (isTimedOut(first, second, timeout) == false) goto L5;
        return false;
    L5:
        double deltaMove = distance(first, second);
        if (deltaMove < distance) goto L8;
        return false;
    L8:
        return true;
    }

    public static double distance(MotionEvent first, MotionEvent second) {
        return MathUtils.dist(first.getX(), first.getY(), second.getX(), second.getY());
    }

    public static double distanceClosestPointerToPoint(PointF pointerDown, MotionEvent moveEvent) {
        float movement = Float.MAX_VALUE;
        int i = 0;
    L4:
        if (i >= moveEvent.getPointerCount()) goto L10;
        float moveDelta = MathUtils.dist(pointerDown.x, pointerDown.y, moveEvent.getX(i), moveEvent.getY(i));
        if (movement <= moveDelta) goto L8;
        movement = moveDelta;
    L8:
        i = i + 1;
        goto L4
    L10:
        return movement;
    }

    public static boolean isTimedOut(MotionEvent firstUp, MotionEvent secondUp, int timeout) {
        long deltaTime = secondUp.getEventTime() - firstUp.getEventTime();
        if (deltaTime < timeout) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDraggingGesture(float firstPtrDownX, float firstPtrDownY, float secondPtrDownX, float secondPtrDownY, float firstPtrX, float firstPtrY, float secondPtrX, float secondPtrY, float maxDraggingAngleCos) {
        float firstDeltaX = firstPtrX - firstPtrDownX;
        float firstDeltaY = firstPtrY - firstPtrDownY;
        if (firstDeltaX == 0.0f) goto L5;
    L7:
        float firstMagnitude = (float) Math.hypot(firstDeltaX, firstDeltaY);
        if (firstMagnitude <= 0.0f) goto L10;
        float firstXNormalized = firstDeltaX / firstMagnitude;
    L12:
        if (firstMagnitude <= 0.0f) goto L14;
        float firstYNormalized = firstDeltaY / firstMagnitude;
    L15:
        float secondDeltaX = secondPtrX - secondPtrDownX;
        float secondDeltaY = secondPtrY - secondPtrDownY;
        if (secondDeltaX == 0.0f) goto L18;
    L20:
        float secondMagnitude = (float) Math.hypot(secondDeltaX, secondDeltaY);
        if (secondMagnitude <= 0.0f) goto L23;
        float secondXNormalized = secondDeltaX / secondMagnitude;
    L25:
        if (secondMagnitude <= 0.0f) goto L27;
        float secondYNormalized = secondDeltaY / secondMagnitude;
    L28:
        float angleCos = (firstXNormalized * secondXNormalized) + (firstYNormalized * secondYNormalized);
        if (angleCos >= maxDraggingAngleCos) goto L32;
        return false;
    L32:
        return true;
    L27:
        secondYNormalized = secondDeltaY;
        goto L28
    L23:
        secondXNormalized = secondDeltaX;
        goto L25
    L18:
        if (secondDeltaY != 0.0f) goto L20;
        return true;
    L14:
        firstYNormalized = firstDeltaY;
        goto L15
    L10:
        firstXNormalized = firstDeltaX;
        goto L12
    L5:
        if (firstDeltaY != 0.0f) goto L7;
        return true;
    }

    public static int getActionIndex(MotionEvent event) {
        return (event.getAction() & JobPackageTracker.EVENT_STOP_REASON_MASK) >> 8;
    }
}
