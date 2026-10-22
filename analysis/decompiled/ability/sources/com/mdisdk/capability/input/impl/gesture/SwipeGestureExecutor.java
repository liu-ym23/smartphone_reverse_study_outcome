package com.mdisdk.capability.input.impl.gesture;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.InputEventFactory;

/* loaded from: classes3.dex */
public class SwipeGestureExecutor extends BaseGestureExecutor {
    private final long durationMs;
    private final float endX;
    private final float endY;
    private final float startX;
    private final float startY;
    private final int steps;

    public SwipeGestureExecutor(InputManagerAdapter inputManagerAdapter, InputEventFactory inputEventFactory, float f, float f7, float f9, float f10, long j5, int i) {
        super(inputManagerAdapter, inputEventFactory);
        this.startX = f;
        this.startY = f7;
        this.endX = f9;
        this.endY = f10;
        this.durationMs = j5;
        this.steps = i;
    }

    @Override // com.mdisdk.capability.input.impl.gesture.BaseGestureExecutor
    public boolean executeInternal(int i) throws InterruptedException {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventCreateTouchEvent = this.factory.createTouchEvent(jUptimeMillis, jUptimeMillis, 0, this.startX, this.startY);
        if (!this.adapter.injectInputEvent(motionEventCreateTouchEvent, i)) {
            motionEventCreateTouchEvent.recycle();
            return false;
        }
        motionEventCreateTouchEvent.recycle();
        double d = this.durationMs / this.steps;
        for (int i6 = 1; i6 <= this.steps; i6++) {
            float f = i6 / this.steps;
            MotionEvent motionEventCreateTouchEvent2 = this.factory.createTouchEvent(jUptimeMillis, SystemClock.uptimeMillis(), 2, lerp(this.startX, this.endX, f), lerp(this.startY, this.endY, f));
            if (!this.adapter.injectInputEvent(motionEventCreateTouchEvent2, i)) {
                motionEventCreateTouchEvent2.recycle();
                return false;
            }
            motionEventCreateTouchEvent2.recycle();
            sleepSafely((long) d);
        }
        MotionEvent motionEventCreateTouchEvent3 = this.factory.createTouchEvent(jUptimeMillis, SystemClock.uptimeMillis(), 1, this.endX, this.endY);
        boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventCreateTouchEvent3, i);
        motionEventCreateTouchEvent3.recycle();
        return zInjectInputEvent;
    }
}
