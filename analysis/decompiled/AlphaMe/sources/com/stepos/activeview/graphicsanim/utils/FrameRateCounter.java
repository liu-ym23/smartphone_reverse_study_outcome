package com.stepos.activeview.graphicsanim.utils;

import android.os.SystemClock;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class FrameRateCounter {
    private long mLastTime;

    public float timeStep() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j4 = this.mLastTime;
        long j5 = jUptimeMillis - j4;
        float f4 = j4;
        float f5 = Property.DEFAULT_FLOAT_VALUE;
        if (f4 > Property.DEFAULT_FLOAT_VALUE) {
            f5 = j5 / 1000.0f;
        }
        this.mLastTime = jUptimeMillis;
        return Math.min(0.021f, f5);
    }
}
