package com.mdisdk.capability.input.impl;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;

/* loaded from: classes3.dex */
public class InputEventFactory {
    public KeyEvent createKeyEvent(int i, boolean z10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        return new KeyEvent(jUptimeMillis, jUptimeMillis, !z10 ? 1 : 0, i, 0, 0, -1, 0, 8, 257);
    }

    public MotionEvent createMultiTouchEvent(long j5, long j6, int i, int i6, MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr) {
        return MotionEvent.obtain(j5, j6, i, i6, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, -1, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0);
    }

    public MotionEvent.PointerCoords createPointerCoords(float f, float f7) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f;
        pointerCoords.y = f7;
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        return pointerCoords;
    }

    public MotionEvent.PointerCoords createPointerCoordsWithOffset(float f, float f7, float f9, int i, int i6) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = (i * f9) + f;
        pointerCoords.y = (f9 * i6) + f7;
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        return pointerCoords;
    }

    public MotionEvent.PointerProperties createPointerProperties(int i) {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = i;
        pointerProperties.toolType = 1;
        return pointerProperties;
    }

    public MotionEvent createTouchEvent(long j5, long j6, int i, float f, float f7) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j5, j6, i, f, f7, 0);
        motionEventObtain.setSource(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        return motionEventObtain;
    }

    public MotionEvent.PointerProperties[] createTwoFingerProperties() {
        return new MotionEvent.PointerProperties[]{createPointerProperties(0), createPointerProperties(1)};
    }
}
