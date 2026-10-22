package com.mdisdk.capability.input.impl.gesture;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.InputEventFactory;

/* loaded from: classes3.dex */
public class PinchGestureExecutor extends BaseGestureExecutor {
    private final float centerX;
    private final float centerY;
    private final long durationMs;
    private final float endDistance;
    private final float startDistance;
    private final int steps;

    public PinchGestureExecutor(InputManagerAdapter inputManagerAdapter, InputEventFactory inputEventFactory, float f, float f7, float f9, float f10, int i, long j5) {
        super(inputManagerAdapter, inputEventFactory);
        this.centerX = f;
        this.centerY = f7;
        this.startDistance = f9;
        this.endDistance = f10;
        this.steps = i;
        this.durationMs = j5;
    }

    @Override // com.mdisdk.capability.input.impl.gesture.BaseGestureExecutor
    public boolean executeInternal(int i) throws InterruptedException {
        MotionEvent.PointerProperties[] pointerPropertiesArrCreateTwoFingerProperties = this.factory.createTwoFingerProperties();
        float f = this.startDistance / 2.0f;
        float f7 = this.endDistance / 2.0f;
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent.PointerCoords pointerCoordsCreatePointerCoordsWithOffset = this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, f, -1, 0);
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, pointerCoordsCreatePointerCoordsWithOffset.x, pointerCoordsCreatePointerCoordsWithOffset.y, 0);
        motionEventObtain.setSource(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        if (!this.adapter.injectInputEvent(motionEventObtain, i)) {
            motionEventObtain.recycle();
            return false;
        }
        motionEventObtain.recycle();
        float f9 = f;
        MotionEvent motionEventCreateMultiTouchEvent = this.factory.createMultiTouchEvent(jUptimeMillis, SystemClock.uptimeMillis(), 261, 2, pointerPropertiesArrCreateTwoFingerProperties, new MotionEvent.PointerCoords[]{pointerCoordsCreatePointerCoordsWithOffset, this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, f, 1, 0)});
        if (!this.adapter.injectInputEvent(motionEventCreateMultiTouchEvent, i)) {
            motionEventCreateMultiTouchEvent.recycle();
            return false;
        }
        motionEventCreateMultiTouchEvent.recycle();
        double d = this.durationMs / this.steps;
        int i6 = 1;
        while (i6 <= this.steps) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            float fLerp = lerp(f9, f7, i6 / this.steps);
            double d6 = d;
            long j5 = jUptimeMillis;
            int i10 = i6;
            float f10 = f9;
            MotionEvent motionEventCreateMultiTouchEvent2 = this.factory.createMultiTouchEvent(j5, jUptimeMillis2, 2, 2, pointerPropertiesArrCreateTwoFingerProperties, new MotionEvent.PointerCoords[]{this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, fLerp, -1, 0), this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, fLerp, 1, 0)});
            if (!this.adapter.injectInputEvent(motionEventCreateMultiTouchEvent2, i)) {
                motionEventCreateMultiTouchEvent2.recycle();
                return false;
            }
            motionEventCreateMultiTouchEvent2.recycle();
            sleepSafely((long) d6);
            int i11 = i10 + 1;
            jUptimeMillis = j5;
            i6 = i11;
            d = d6;
            f9 = f10;
        }
        long j6 = jUptimeMillis;
        long jUptimeMillis3 = SystemClock.uptimeMillis();
        MotionEvent.PointerCoords pointerCoordsCreatePointerCoordsWithOffset2 = this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, f7, -1, 0);
        MotionEvent motionEventCreateMultiTouchEvent3 = this.factory.createMultiTouchEvent(j6, jUptimeMillis3, 262, 2, pointerPropertiesArrCreateTwoFingerProperties, new MotionEvent.PointerCoords[]{pointerCoordsCreatePointerCoordsWithOffset2, this.factory.createPointerCoordsWithOffset(this.centerX, this.centerY, f7, 1, 0)});
        if (!this.adapter.injectInputEvent(motionEventCreateMultiTouchEvent3, i)) {
            motionEventCreateMultiTouchEvent3.recycle();
            return false;
        }
        motionEventCreateMultiTouchEvent3.recycle();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(j6, SystemClock.uptimeMillis(), 1, pointerCoordsCreatePointerCoordsWithOffset2.x, pointerCoordsCreatePointerCoordsWithOffset2.y, 0);
        motionEventObtain2.setSource(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventObtain2, i);
        motionEventObtain2.recycle();
        return zInjectInputEvent;
    }
}
