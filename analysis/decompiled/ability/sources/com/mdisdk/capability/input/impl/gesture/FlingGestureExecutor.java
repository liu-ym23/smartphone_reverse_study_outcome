package com.mdisdk.capability.input.impl.gesture;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.InputEventFactory;

/* loaded from: classes3.dex */
public class FlingGestureExecutor extends BaseGestureExecutor {
    private static final float FRICTION = 0.015f;
    private final long durationMs;
    private final float startX;
    private final float startY;
    private final int steps;
    private final float velocityX;
    private final float velocityY;

    public FlingGestureExecutor(InputManagerAdapter inputManagerAdapter, InputEventFactory inputEventFactory, float f, float f7, float f9, float f10, long j5, int i) {
        super(inputManagerAdapter, inputEventFactory);
        this.startX = f;
        this.startY = f7;
        this.velocityX = f9;
        this.velocityY = f10;
        this.durationMs = j5;
        this.steps = i;
    }

    private float calculateFlingDistance(float f) {
        return Math.signum(f) * Math.min(Math.abs((f * f) / (Math.abs(computeDeceleration(f)) * 2.0f)), 5000.0f);
    }

    private float computeDeceleration(float f) {
        return f * (f > 0.0f ? -0.015f : FRICTION);
    }

    private float decelerateInterpolation(float f) {
        float f7 = 1.0f - f;
        return 1.0f - (f7 * f7);
    }

    @Override // com.mdisdk.capability.input.impl.gesture.BaseGestureExecutor
    public boolean executeInternal(int i) throws InterruptedException {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float fCalculateFlingDistance = calculateFlingDistance(this.velocityX);
        float fCalculateFlingDistance2 = calculateFlingDistance(this.velocityY);
        float f = this.startX;
        float f7 = f + fCalculateFlingDistance;
        float f9 = this.startY;
        float f10 = f9 + fCalculateFlingDistance2;
        MotionEvent motionEventCreateTouchEvent = this.factory.createTouchEvent(jUptimeMillis, jUptimeMillis, 0, f, f9);
        boolean z10 = false;
        if (!this.adapter.injectInputEvent(motionEventCreateTouchEvent, i)) {
            motionEventCreateTouchEvent.recycle();
            return false;
        }
        motionEventCreateTouchEvent.recycle();
        double d = this.durationMs / this.steps;
        int i6 = 1;
        while (true) {
            int i10 = i6;
            if (i10 > this.steps) {
                MotionEvent motionEventCreateTouchEvent2 = this.factory.createTouchEvent(jUptimeMillis, SystemClock.uptimeMillis(), 1, f7, f10);
                boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventCreateTouchEvent2, i);
                motionEventCreateTouchEvent2.recycle();
                return zInjectInputEvent;
            }
            double d6 = d;
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            float fDecelerateInterpolation = decelerateInterpolation(i10 / this.steps);
            boolean z11 = z10;
            MotionEvent motionEventCreateTouchEvent3 = this.factory.createTouchEvent(jUptimeMillis, jUptimeMillis2, 2, (fCalculateFlingDistance * fDecelerateInterpolation) + this.startX, this.startY + (fDecelerateInterpolation * fCalculateFlingDistance2));
            if (!this.adapter.injectInputEvent(motionEventCreateTouchEvent3, i)) {
                motionEventCreateTouchEvent3.recycle();
                return z11;
            }
            motionEventCreateTouchEvent3.recycle();
            sleepSafely((long) d6);
            i6 = i10 + 1;
            d = d6;
            z10 = z11;
        }
    }
}
