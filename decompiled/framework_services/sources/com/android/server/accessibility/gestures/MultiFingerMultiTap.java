package com.android.server.accessibility.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MultiFingerMultiTap extends GestureMatcher {
    private PointF[] mBases;
    protected int mCompletedTapCount;
    private int mDoubleTapSlop;
    private ArrayList<PointF> mExcludedPointsForDownSlopChecked;
    protected boolean mIsTargetFingerCountReached;
    final int mTargetFingerCount;
    final int mTargetTapCount;
    private int mTouchSlop;

    public MultiFingerMultiTap(Context context, int fingers, int taps, int gestureId, GestureMatcher.StateChangeListener listener) {
        super(gestureId, new Handler(context.getMainLooper()), listener);
        boolean r0 = false;
        this.mIsTargetFingerCountReached = false;
        if (fingers < 2) goto L5;
        r0 = true;
    L5:
        Preconditions.checkArgument(r0);
        Preconditions.checkArgumentPositive(taps, "Tap count must greater than 0.");
        this.mTargetTapCount = taps;
        this.mTargetFingerCount = fingers;
        this.mDoubleTapSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop() * fingers;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * fingers;
        this.mBases = new PointF[this.mTargetFingerCount];
        int i = 0;
    L7:
        if (i >= this.mBases.length) goto L9;
        this.mBases[i] = new PointF();
        i = i + 1;
        goto L7
    L9:
        this.mExcludedPointsForDownSlopChecked = new ArrayList(this.mTargetFingerCount);
        clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        this.mCompletedTapCount = 0;
        this.mIsTargetFingerCountReached = false;
        int i = 0;
    L4:
        if (i >= this.mBases.length) goto L6;
        this.mBases[i].set(Float.NaN, Float.NaN);
        i = i + 1;
        goto L4
    L6:
        this.mExcludedPointsForDownSlopChecked.clear();
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mCompletedTapCount != this.mTargetTapCount) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        cancelAfterTapTimeout(event, rawEvent, policyFlags);
        if (this.mCompletedTapCount != 0) goto L10;
        initBaseLocation(rawEvent);
        return;
    L10:
        PointF nearest = findNearestPoint(rawEvent, this.mDoubleTapSlop, true);
        if (nearest == null) goto L13;
        int index = event.getActionIndex();
        nearest.set(event.getX(index), event.getY(index));
        return;
    L13:
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelAfterDoubleTapTimeout(event, rawEvent, policyFlags);
        PointF nearest = findNearestPoint(rawEvent, this.mTouchSlop, false);
        if (getState() != 1) goto L5;
    L6:
        if (nearest != null) goto L8;
    L16:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L8:
        if (this.mIsTargetFingerCountReached == false) goto L11;
        this.mCompletedTapCount++;
        this.mIsTargetFingerCountReached = false;
        this.mExcludedPointsForDownSlopChecked.clear();
    L11:
        if (this.mCompletedTapCount != 1) goto L14;
        startGesture(event, rawEvent, policyFlags);
    L14:
        if (this.mCompletedTapCount != this.mTargetTapCount) goto L18;
        completeAfterDoubleTapTimeout(event, rawEvent, policyFlags);
        return;
    L18:
        return;
    L5:
        if (getState() != 0) goto L16;
        goto L6
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (findNearestPoint(rawEvent, this.mTouchSlop, false) != null) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelAfterTapTimeout(event, rawEvent, policyFlags);
        int currentFingerCount = event.getPointerCount();
        if (currentFingerCount <= this.mTargetFingerCount) goto L5;
    L22:
        this.mIsTargetFingerCountReached = false;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L5:
        if (this.mIsTargetFingerCountReached == true) goto L22;
        if (this.mCompletedTapCount != 0) goto L10;
        PointF nearest = initBaseLocation(rawEvent);
    L12:
        if (getState() != 1) goto L14;
    L15:
        if (nearest != null) goto L17;
    L20:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L17:
        if (currentFingerCount != this.mTargetFingerCount) goto L19;
        this.mIsTargetFingerCountReached = true;
    L19:
        int index = event.getActionIndex();
        nearest.set(event.getX(index), event.getY(index));
        return;
    L14:
        if (getState() != 0) goto L20;
    L10:
        nearest = findNearestPoint(rawEvent, this.mDoubleTapSlop, true);
        goto L12
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mIsTargetFingerCountReached == true) goto L7;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L7:
        if (getState() != 1) goto L9;
    L12:
        cancelAfterTapTimeout(event, rawEvent, policyFlags);
        return;
    L9:
        if (getState() == 0) goto L12;
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String getGestureName() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.mTargetFingerCount);
        builder.append("-Finger ");
        if (this.mTargetTapCount != 1) goto L6;
        builder.append("Single");
    L14:
        builder.append(" Tap");
        return builder.toString();
    L6:
        if (this.mTargetTapCount != 2) goto L9;
        builder.append("Double");
        goto L14
    L9:
        if (this.mTargetTapCount != 3) goto L12;
        builder.append("Triple");
        goto L14
    L12:
        if (this.mTargetTapCount <= 3) goto L14;
        builder.append(this.mTargetTapCount);
        goto L14
    }

    private PointF initBaseLocation(MotionEvent event) {
        int index = event.getActionIndex();
        int baseIndex = event.getPointerCount() - 1;
        PointF p = this.mBases[baseIndex];
        if (Float.isNaN(p.x) == true) goto L5;
    L7:
        return p;
    L5:
        if (Float.isNaN(p.y) == false) goto L7;
        p.set(event.getX(index), event.getY(index));
        goto L7
    }

    private PointF findNearestPoint(MotionEvent event, float slop, boolean filterMatched) {
        float moveDelta = Float.MAX_VALUE;
        PointF nearest = null;
        int i = 0;
    L4:
        if (i >= this.mBases.length) goto L26;
        PointF p = this.mBases[i];
        if (Float.isNaN(p.x) == true) goto L8;
    L10:
        if (filterMatched == true) goto L12;
    L14:
        int index = event.getActionIndex();
        float dX = p.x - event.getX(index);
        float dY = p.y - event.getY(index);
        if (dX == 0.0f) goto L17;
    L21:
        float delta = (float) Math.hypot(dX, dY);
        if (moveDelta <= delta) goto L24;
        moveDelta = delta;
        nearest = p;
    L24:
        i = i + 1;
        goto L4
    L17:
        if (dY != 0.0f) goto L21;
        if (filterMatched == false) goto L20;
        this.mExcludedPointsForDownSlopChecked.add(p);
    L20:
        return p;
    L12:
        if (this.mExcludedPointsForDownSlopChecked.contains(p) == false) goto L14;
    L8:
        if (Float.isNaN(p.y) == false) goto L10;
    L26:
        if (moveDelta >= slop) goto L30;
        if (filterMatched == false) goto L29;
        this.mExcludedPointsForDownSlopChecked.add(nearest);
    L29:
        return nearest;
    L30:
        return null;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (getState() == 3) goto L6;
        builder.append(", CompletedTapCount: ");
        builder.append(this.mCompletedTapCount);
        builder.append(", IsTargetFingerCountReached: ");
        builder.append(this.mIsTargetFingerCountReached);
        builder.append(", Bases: ");
        builder.append(Arrays.toString(this.mBases));
        builder.append(", ExcludedPointsForDownSlopChecked: ");
        builder.append(this.mExcludedPointsForDownSlopChecked.toString());
    L6:
        return builder.toString();
    }
}
