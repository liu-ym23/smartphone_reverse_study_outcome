package com.android.server.accessibility.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.net.INetd;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class Swipe extends GestureMatcher {
    private static final float ANGLE_THRESHOLD = 0.0f;
    public static final int DOWN = 3;
    public static final int GESTURE_CONFIRM_CM = 1;
    public static final int LEFT = 0;
    public static final long MAX_TIME_TO_CONTINUE_SWIPE_MS = 350;
    public static final long MAX_TIME_TO_START_SWIPE_MS = 150;
    private static final float MIN_CM_BETWEEN_SAMPLES = 0.25f;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    private long mBaseTime;
    private float mBaseX;
    private float mBaseY;
    private int[] mDirections;
    private final float mGestureDetectionThresholdPixels;
    private final float mMinPixelsBetweenSamplesX;
    private final float mMinPixelsBetweenSamplesY;
    private float mPreviousGestureX;
    private float mPreviousGestureY;
    private final ArrayList<PointF> mStrokeBuffer;
    private int mTouchSlop;

    Swipe(Context context, int direction, int gesture, GestureMatcher.StateChangeListener listener) {
        this(context, new int[]{direction}, gesture, listener);
    }

    Swipe(Context context, int direction1, int direction2, int gesture, GestureMatcher.StateChangeListener listener) {
        this(context, new int[]{direction1, direction2}, gesture, listener);
    }

    private Swipe(Context context, int[] directions, int gesture, GestureMatcher.StateChangeListener listener) {
        super(gesture, new Handler(context.getMainLooper()), listener);
        this.mStrokeBuffer = new ArrayList(100);
        this.mDirections = directions;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mGestureDetectionThresholdPixels = TypedValue.applyDimension(5, GestureUtils.MM_PER_CM, displayMetrics) * 1.0f;
        float pixelsPerCmX = displayMetrics.xdpi / 2.54f;
        float pixelsPerCmY = displayMetrics.ydpi / 2.54f;
        this.mMinPixelsBetweenSamplesX = pixelsPerCmX * MIN_CM_BETWEEN_SAMPLES;
        this.mMinPixelsBetweenSamplesY = MIN_CM_BETWEEN_SAMPLES * pixelsPerCmY;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        this.mBaseX = Float.NaN;
        this.mBaseY = Float.NaN;
        this.mBaseTime = 0;
        this.mPreviousGestureX = Float.NaN;
        this.mPreviousGestureY = Float.NaN;
        this.mStrokeBuffer.clear();
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (Float.isNaN(this.mBaseX) == true) goto L5;
        return;
    L5:
        if (Float.isNaN(this.mBaseY) == false) goto L9;
        this.mBaseX = rawEvent.getX();
        this.mBaseY = rawEvent.getY();
        this.mBaseTime = rawEvent.getEventTime();
        this.mPreviousGestureX = this.mBaseX;
        this.mPreviousGestureY = this.mBaseY;
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        float x = rawEvent.getX();
        float y = rawEvent.getY();
        long time = rawEvent.getEventTime();
        float dX = Math.abs(x - this.mPreviousGestureX);
        float dY = Math.abs(y - this.mPreviousGestureY);
        double moveDelta = Math.hypot(Math.abs(x - this.mBaseX), Math.abs(y - this.mBaseY));
        long timeDelta = time - this.mBaseTime;
        if (TouchExplorer.DEBUG == false) goto L6;
        Slog.d(getGestureName(), "moveDelta:" + Double.toString(moveDelta) + " mGestureDetectionThreshold: " + Float.toString(this.mGestureDetectionThresholdPixels));
    L6:
        if (getState() != 0) goto L18;
        if (moveDelta >= this.mTouchSlop) goto L11;
        return;
    L11:
        if (this.mStrokeBuffer.size() != 0) goto L18;
        int direction = toDirection(x - this.mBaseX, y - this.mBaseY);
        if (direction == this.mDirections[0]) goto L16;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L16:
        this.mStrokeBuffer.add(new PointF(this.mBaseX, this.mBaseY));
    L18:
        if (moveDelta <= this.mGestureDetectionThresholdPixels) goto L21;
        this.mBaseX = x;
        this.mBaseY = y;
        this.mBaseTime = time;
        startGesture(event, rawEvent, policyFlags);
    L33:
        if (dX < this.mMinPixelsBetweenSamplesX) goto L35;
    L36:
        this.mPreviousGestureX = x;
        this.mPreviousGestureY = y;
        this.mStrokeBuffer.add(new PointF(x, y));
        return;
    L35:
        if (dY >= this.mMinPixelsBetweenSamplesY) goto L36;
        return;
    L21:
        if (getState() != 0) goto L27;
        if (timeDelta <= 150) goto L33;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L27:
        if (getState() != 1) goto L33;
        if (timeDelta <= 350) goto L33;
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (getState() == 1) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        float x = rawEvent.getX();
        float y = rawEvent.getY();
        float dX = Math.abs(x - this.mPreviousGestureX);
        float dY = Math.abs(y - this.mPreviousGestureY);
        if (dX < this.mMinPixelsBetweenSamplesX) goto L9;
    L10:
        this.mStrokeBuffer.add(new PointF(x, y));
    L11:
        recognizeGesture(event, rawEvent, policyFlags);
        return;
    L9:
        if (dY < this.mMinPixelsBetweenSamplesY) goto L11;
        goto L10
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    private void recognizeGesture(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mStrokeBuffer.size() >= 2) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        ArrayList<PointF> path = new ArrayList();
        PointF lastDelimiter = this.mStrokeBuffer.get(0);
        path.add(lastDelimiter);
        float dX = ANGLE_THRESHOLD;
        float dY = ANGLE_THRESHOLD;
        int count = 0;
        float length = ANGLE_THRESHOLD;
        PointF next = null;
        int i = 1;
    L8:
        if (i >= this.mStrokeBuffer.size()) goto L15;
        PointF next2 = this.mStrokeBuffer.get(i);
        next = next2;
        if (count <= 0) goto L14;
        float currentDX = dX / count;
        float currentDY = dY / count;
        PointF newDelimiter = new PointF((length * currentDX) + lastDelimiter.x, (length * currentDY) + lastDelimiter.y);
        float nextDX = next.x - newDelimiter.x;
        float nextDY = next.y - newDelimiter.y;
        float nextLength = (float) Math.sqrt((nextDX * nextDX) + (nextDY * nextDY));
        float dot = (currentDX * (nextDX / nextLength)) + (currentDY * (nextDY / nextLength));
        if (dot >= ANGLE_THRESHOLD) goto L14;
        path.add(newDelimiter);
        lastDelimiter = newDelimiter;
        dX = ANGLE_THRESHOLD;
        dY = ANGLE_THRESHOLD;
        count = 0;
    L14:
        float currentDX2 = next.x - lastDelimiter.x;
        float currentDY2 = next.y - lastDelimiter.y;
        length = (float) Math.sqrt((currentDX2 * currentDX2) + (currentDY2 * currentDY2));
        count = count + 1;
        dX = dX + (currentDX2 / length);
        dY = dY + (currentDY2 / length);
        i = i + 1;
        goto L8
    L15:
        path.add(next);
        if (TouchExplorer.DEBUG == false) goto L18;
        Slog.d(getGestureName(), "path=" + path.toString());
    L18:
        recognizeGesturePath(event, rawEvent, policyFlags, path);
    }

    private void recognizeGesturePath(MotionEvent event, MotionEvent rawEvent, int policyFlags, ArrayList<PointF> path) {
        event.getDisplayId();
        if (path.size() == (this.mDirections.length + 1)) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        int i = 0;
    L8:
        if (i >= (path.size() - 1)) goto L18;
        PointF start = path.get(i);
        PointF end = path.get(i + 1);
        float dX = end.x - start.x;
        float dY = end.y - start.y;
        int direction = toDirection(dX, dY);
        if (direction != this.mDirections[i]) goto L12;
        i = i + 1;
        goto L8
    L12:
        if (TouchExplorer.DEBUG == false) goto L14;
        Slog.d(getGestureName(), "Found direction " + directionToString(direction) + " when expecting " + directionToString(this.mDirections[i]));
    L14:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L18:
        if (TouchExplorer.DEBUG == false) goto L20;
        Slog.d(getGestureName(), "Completed.");
    L20:
        completeGesture(event, rawEvent, policyFlags);
    }

    private static int toDirection(float dX, float dY) {
        if (Math.abs(dX) <= Math.abs(dY)) goto L10;
        if (dX >= ANGLE_THRESHOLD) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (dY >= ANGLE_THRESHOLD) goto L12;
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
        StringBuilder builder = new StringBuilder();
        builder.append("Swipe ");
        builder.append(directionToString(this.mDirections[0]));
        int i = 1;
    L4:
        if (i >= this.mDirections.length) goto L7;
        builder.append(" and ");
        builder.append(directionToString(this.mDirections[i]));
        i = i + 1;
        goto L4
    L7:
        return builder.toString();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (getState() == 3) goto L6;
        builder.append(", mBaseX: ");
        builder.append(this.mBaseX);
        builder.append(", mBaseY: ");
        builder.append(this.mBaseY);
        builder.append(", mGestureDetectionThreshold:");
        builder.append(this.mGestureDetectionThresholdPixels);
        builder.append(", mMinPixelsBetweenSamplesX:");
        builder.append(this.mMinPixelsBetweenSamplesX);
        builder.append(", mMinPixelsBetweenSamplesY:");
        builder.append(this.mMinPixelsBetweenSamplesY);
    L6:
        return builder.toString();
    }
}
