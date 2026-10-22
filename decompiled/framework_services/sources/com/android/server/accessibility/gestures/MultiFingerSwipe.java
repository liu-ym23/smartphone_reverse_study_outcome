package com.android.server.accessibility.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.net.INetd;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class MultiFingerSwipe extends GestureMatcher {
    public static final int DOWN = 3;
    public static final int LEFT = 0;
    private static final float MIN_CM_BETWEEN_SAMPLES = 0.25f;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    private PointF[] mBase;
    private int mCurrentFingerCount;
    private int mDirection;
    private final float mMinPixelsBetweenSamplesX;
    private final float mMinPixelsBetweenSamplesY;
    private int[] mPointerIds;
    private PointF[] mPreviousGesturePoint;
    private final ArrayList<PointF>[] mStrokeBuffers;
    private int mTargetFingerCount;
    private boolean mTargetFingerCountReached;
    private int mTouchSlop;

    MultiFingerSwipe(Context context, int fingerCount, int direction, int gesture, GestureMatcher.StateChangeListener listener) {
        super(gesture, new Handler(context.getMainLooper()), listener);
        this.mTargetFingerCountReached = false;
        this.mTargetFingerCount = fingerCount;
        this.mPointerIds = new int[this.mTargetFingerCount];
        this.mBase = new PointF[this.mTargetFingerCount];
        this.mPreviousGesturePoint = new PointF[this.mTargetFingerCount];
        this.mStrokeBuffers = new ArrayList[this.mTargetFingerCount];
        this.mDirection = direction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float pixelsPerCmX = displayMetrics.xdpi / GestureUtils.CM_PER_INCH;
        float pixelsPerCmY = displayMetrics.ydpi / GestureUtils.CM_PER_INCH;
        this.mMinPixelsBetweenSamplesX = pixelsPerCmX * MIN_CM_BETWEEN_SAMPLES;
        this.mMinPixelsBetweenSamplesY = MIN_CM_BETWEEN_SAMPLES * pixelsPerCmY;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        this.mTargetFingerCountReached = false;
        this.mCurrentFingerCount = 0;
        int i = 0;
    L4:
        if (i >= this.mTargetFingerCount) goto L15;
        this.mPointerIds[i] = -1;
        if (this.mBase[i] != null) goto L8;
        this.mBase[i] = new PointF();
    L8:
        this.mBase[i].x = Float.NaN;
        this.mBase[i].y = Float.NaN;
        if (this.mPreviousGesturePoint[i] != null) goto L11;
        this.mPreviousGesturePoint[i] = new PointF();
    L11:
        this.mPreviousGesturePoint[i].x = Float.NaN;
        this.mPreviousGesturePoint[i].y = Float.NaN;
        if (this.mStrokeBuffers[i] != null) goto L14;
        this.mStrokeBuffers[i] = new ArrayList(100);
    L14:
        this.mStrokeBuffers[i].clear();
        i = i + 1;
        goto L4
    L15:
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mCurrentFingerCount <= 0) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        this.mCurrentFingerCount = 1;
        int actionIndex = GestureUtils.getActionIndex(rawEvent);
        int pointerId = rawEvent.getPointerId(actionIndex);
        int pointerIndex = rawEvent.getPointerCount() - 1;
        if (pointerId >= 0) goto L11;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L11:
        if (this.mPointerIds[pointerIndex] == (-1)) goto L14;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L14:
        this.mPointerIds[pointerIndex] = pointerId;
        if (Float.isNaN(this.mBase[pointerIndex].x) == true) goto L17;
    L27:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L17:
        if (Float.isNaN(this.mBase[pointerIndex].y) == false) goto L27;
        float x = rawEvent.getX(actionIndex);
        float y = rawEvent.getY(actionIndex);
        if (x >= 0.0f) goto L21;
    L25:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L21:
        if (y < 0.0f) goto L25;
        this.mBase[pointerIndex].x = x;
        this.mBase[pointerIndex].y = y;
        this.mPreviousGesturePoint[pointerIndex].x = x;
        this.mPreviousGesturePoint[pointerIndex].y = y;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getPointerCount() <= this.mTargetFingerCount) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        this.mCurrentFingerCount++;
        if (this.mCurrentFingerCount == rawEvent.getPointerCount()) goto L11;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L11:
        if (this.mCurrentFingerCount != this.mTargetFingerCount) goto L13;
        this.mTargetFingerCountReached = true;
    L13:
        int actionIndex = GestureUtils.getActionIndex(rawEvent);
        int pointerId = rawEvent.getPointerId(actionIndex);
        if (pointerId >= 0) goto L17;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L17:
        int pointerIndex = this.mCurrentFingerCount - 1;
        if (this.mPointerIds[pointerIndex] == (-1)) goto L21;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L21:
        this.mPointerIds[pointerIndex] = pointerId;
        if (Float.isNaN(this.mBase[pointerIndex].x) == true) goto L24;
    L34:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L24:
        if (Float.isNaN(this.mBase[pointerIndex].y) == false) goto L34;
        float x = rawEvent.getX(actionIndex);
        float y = rawEvent.getY(actionIndex);
        if (x >= 0.0f) goto L28;
    L32:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L28:
        if (y < 0.0f) goto L32;
        this.mBase[pointerIndex].x = x;
        this.mBase[pointerIndex].y = y;
        this.mPreviousGesturePoint[pointerIndex].x = x;
        this.mPreviousGesturePoint[pointerIndex].y = y;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mTargetFingerCountReached == true) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        this.mCurrentFingerCount--;
        int actionIndex = GestureUtils.getActionIndex(event);
        int pointerId = event.getPointerId(actionIndex);
        if (pointerId >= 0) goto L10;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L10:
        int pointerIndex = Arrays.binarySearch(this.mPointerIds, pointerId);
        if (pointerIndex >= 0) goto L14;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L14:
        float x = rawEvent.getX(actionIndex);
        float y = rawEvent.getY(actionIndex);
        if (x >= 0.0f) goto L17;
    L25:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L17:
        if (y < 0.0f) goto L25;
        float dX = Math.abs(x - this.mPreviousGesturePoint[pointerIndex].x);
        float dY = Math.abs(y - this.mPreviousGesturePoint[pointerIndex].y);
        if (dX < this.mMinPixelsBetweenSamplesX) goto L22;
    L23:
        this.mStrokeBuffers[pointerIndex].add(new PointF(x, y));
        return;
    L22:
        if (dY >= this.mMinPixelsBetweenSamplesY) goto L23;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        int pointerIndex = 0;
    L4:
        if (pointerIndex >= this.mTargetFingerCount) goto L58;
        if (this.mPointerIds[pointerIndex] == (-1)) goto L54;
        if (TouchExplorer.DEBUG == false) goto L11;
        Slog.d(getGestureName(), "Processing move on finger " + pointerIndex);
    L11:
        int index = rawEvent.findPointerIndex(this.mPointerIds[pointerIndex]);
        if (index < 0) goto L14;
        float x = rawEvent.getX(index);
        float y = rawEvent.getY(index);
        if (x < 0.0f) goto L55;
        if (y < 0.0f) goto L55;
        float dX = Math.abs(x - this.mPreviousGesturePoint[pointerIndex].x);
        float dY = Math.abs(y - this.mPreviousGesturePoint[pointerIndex].y);
        double moveDelta = Math.hypot(Math.abs(x - this.mBase[pointerIndex].x), Math.abs(y - this.mBase[pointerIndex].y));
        if (TouchExplorer.DEBUG == false) goto L25;
        Slog.d(getGestureName(), "moveDelta:" + moveDelta);
    L25:
        if (getState() != 0) goto L44;
        if (moveDelta < (this.mTargetFingerCount * this.mTouchSlop)) goto L54;
        if (this.mCurrentFingerCount != this.mTargetFingerCount) goto L31;
        int direction = toDirection(x - this.mBase[pointerIndex].x, y - this.mBase[pointerIndex].y);
        if (direction != this.mDirection) goto L35;
        startGesture(event, rawEvent, policyFlags);
        int i = 0;
    L39:
        if (i >= this.mTargetFingerCount) goto L54;
        this.mStrokeBuffers[i].add(new PointF(this.mBase[i]));
        i = i + 1;
        goto L39
    L35:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L31:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L44:
        if (getState() != 1) goto L54;
        int direction2 = toDirection(x - this.mBase[pointerIndex].x, y - this.mBase[pointerIndex].y);
        if (direction2 != this.mDirection) goto L47;
        if (dX < this.mMinPixelsBetweenSamplesX) goto L52;
    L53:
        this.mPreviousGesturePoint[pointerIndex].x = x;
        this.mPreviousGesturePoint[pointerIndex].y = y;
        this.mStrokeBuffers[pointerIndex].add(new PointF(x, y));
        goto L54
    L52:
        if (dY < this.mMinPixelsBetweenSamplesY) goto L54;
    L47:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L55:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L14:
        if (TouchExplorer.DEBUG == false) goto L54;
        Slog.d(getGestureName(), "Finger " + pointerIndex + " not found in this event. skipping.");
    L54:
        pointerIndex = pointerIndex + 1;
        goto L4
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (getState() == 1) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        this.mCurrentFingerCount = 0;
        int actionIndex = GestureUtils.getActionIndex(event);
        int pointerId = event.getPointerId(actionIndex);
        int pointerIndex = Arrays.binarySearch(this.mPointerIds, pointerId);
        if (pointerIndex >= 0) goto L10;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L10:
        float x = rawEvent.getX(actionIndex);
        float y = rawEvent.getY(actionIndex);
        if (x >= 0.0f) goto L13;
    L22:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L13:
        if (y < 0.0f) goto L22;
        float dX = Math.abs(x - this.mPreviousGesturePoint[pointerIndex].x);
        float dY = Math.abs(y - this.mPreviousGesturePoint[pointerIndex].y);
        if (dX < this.mMinPixelsBetweenSamplesX) goto L18;
    L19:
        this.mStrokeBuffers[pointerIndex].add(new PointF(x, y));
    L20:
        recognizeGesture(event, rawEvent, policyFlags);
        return;
    L18:
        if (dY < this.mMinPixelsBetweenSamplesY) goto L20;
        goto L19
    }

    private void recognizeGesture(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        int i = 0;
    L4:
        if (i >= this.mTargetFingerCount) goto L20;
        if (TouchExplorer.DEBUG == false) goto L9;
        Slog.d(getGestureName(), "Recognizing finger: " + i);
    L9:
        if (this.mStrokeBuffers[i].size() < 2) goto L10;
        ArrayList<PointF> path = this.mStrokeBuffers[i];
        if (TouchExplorer.DEBUG == false) goto L16;
        Slog.d(getGestureName(), "path=" + path.toString());
    L16:
        if (recognizeGesturePath(event, rawEvent, policyFlags, path) == false) goto L17;
        i = i + 1;
        goto L4
    L17:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L10:
        Slog.d(getGestureName(), "Too few points.");
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L20:
        completeGesture(event, rawEvent, policyFlags);
    }

    private boolean recognizeGesturePath(MotionEvent event, MotionEvent rawEvent, int policyFlags, ArrayList<PointF> path) {
        event.getDisplayId();
        int i = 0;
    L4:
        if (i >= (path.size() - 1)) goto L14;
        PointF start = path.get(i);
        PointF end = path.get(i + 1);
        float dX = end.x - start.x;
        float dY = end.y - start.y;
        int direction = toDirection(dX, dY);
        if (direction != this.mDirection) goto L8;
        i = i + 1;
        goto L4
    L8:
        if (TouchExplorer.DEBUG == false) goto L19;
        Slog.d(getGestureName(), "Found direction " + directionToString(direction) + " when expecting " + directionToString(this.mDirection));
        return false;
    L19:
        return false;
    L14:
        if (TouchExplorer.DEBUG == false) goto L16;
        Slog.d(getGestureName(), "Completed.");
    L16:
        return true;
    }

    private static int toDirection(float dX, float dY) {
        if (Math.abs(dX) <= Math.abs(dY)) goto L10;
        if (dX >= 0.0f) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (dY >= 0.0f) goto L12;
        return 2;
    L12:
        return 3;
    }

    public static String directionToString(int direction) {
        switch(direction) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown Direction";
    L5:
        return INetd.IF_STATE_DOWN;
    L7:
        return INetd.IF_STATE_UP;
    L9:
        return "right";
    L11:
        return "left";
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected String getGestureName() {
        return this.mTargetFingerCount + "-finger Swipe " + directionToString(this.mDirection);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (getState() == 3) goto L6;
        builder.append(", mBase: ");
        builder.append(Arrays.toString(this.mBase));
        builder.append(", mMinPixelsBetweenSamplesX:");
        builder.append(this.mMinPixelsBetweenSamplesX);
        builder.append(", mMinPixelsBetweenSamplesY:");
        builder.append(this.mMinPixelsBetweenSamplesY);
    L6:
        return builder.toString();
    }
}
