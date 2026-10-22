package com.android.server.display.whitebalance;

import android.util.Slog;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class DisplayWhiteBalanceThrottler {
    protected static final String TAG = "DisplayWhiteBalanceThrottler";
    private float[] mBaseThresholds;
    private int mDecreaseDebounce;
    private float mDecreaseThreshold;
    private float[] mDecreaseThresholds;
    private int mIncreaseDebounce;
    private float mIncreaseThreshold;
    private float[] mIncreaseThresholds;
    private long mLastTime;
    private float mLastValue;
    protected boolean mLoggingEnabled;

    DisplayWhiteBalanceThrottler(int increaseDebounce, int decreaseDebounce, float[] baseThresholds, float[] increaseThresholds, float[] decreaseThresholds) {
        validateArguments(increaseDebounce, decreaseDebounce, baseThresholds, increaseThresholds, decreaseThresholds);
        this.mLoggingEnabled = false;
        this.mIncreaseDebounce = increaseDebounce;
        this.mDecreaseDebounce = decreaseDebounce;
        this.mBaseThresholds = baseThresholds;
        this.mIncreaseThresholds = increaseThresholds;
        this.mDecreaseThresholds = decreaseThresholds;
        clear();
    }

    public boolean throttle(float value) {
        if (this.mLastTime != (-1)) goto L5;
    L10:
        computeThresholds(value);
        this.mLastTime = System.currentTimeMillis();
        this.mLastValue = value;
        return false;
    L5:
        if (tooSoon(value) == false) goto L7;
        return true;
    L7:
        if (tooClose(value) == false) goto L10;
        return true;
    }

    public void clear() {
        this.mLastTime = -1;
        this.mIncreaseThreshold = -1.0f;
        this.mDecreaseThreshold = -1.0f;
        this.mLastValue = -1.0f;
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public void dump(PrintWriter writer) {
        writer.println("  DisplayWhiteBalanceThrottler");
        writer.println("    mLoggingEnabled=" + this.mLoggingEnabled);
        writer.println("    mIncreaseDebounce=" + this.mIncreaseDebounce);
        writer.println("    mDecreaseDebounce=" + this.mDecreaseDebounce);
        writer.println("    mLastTime=" + this.mLastTime);
        writer.println("    mBaseThresholds=" + Arrays.toString(this.mBaseThresholds));
        writer.println("    mIncreaseThresholds=" + Arrays.toString(this.mIncreaseThresholds));
        writer.println("    mDecreaseThresholds=" + Arrays.toString(this.mDecreaseThresholds));
        writer.println("    mIncreaseThreshold=" + this.mIncreaseThreshold);
        writer.println("    mDecreaseThreshold=" + this.mDecreaseThreshold);
        writer.println("    mLastValue=" + this.mLastValue);
    }

    private void validateArguments(float increaseDebounce, float decreaseDebounce, float[] baseThresholds, float[] increaseThresholds, float[] decreaseThresholds) {
        if (Float.isNaN(increaseDebounce) == true) goto L22;
        if (increaseDebounce < 0.0f) goto L22;
        if (Float.isNaN(decreaseDebounce) == true) goto L20;
        if (decreaseDebounce < 0.0f) goto L20;
        if (isValidMapping(baseThresholds, increaseThresholds) == false) goto L18;
        if (isValidMapping(baseThresholds, decreaseThresholds) == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("baseThresholds to decreaseThresholds is not a valid mapping.");
    L18:
        throw new IllegalArgumentException("baseThresholds to increaseThresholds is not a valid mapping.");
    L20:
        throw new IllegalArgumentException("decreaseDebounce must be a non-negative number.");
    L22:
        throw new IllegalArgumentException("increaseDebounce must be a non-negative number.");
    }

    private static boolean isValidMapping(float[] x, float[] y) {
        if (x == null) goto L28;
        if (y == null) goto L28;
        if (x.length == 0) goto L28;
        if (y.length == 0) goto L28;
        if (x.length != y.length) goto L28;
        float prevX = -1.0f;
        int i = 0;
    L14:
        if (i >= x.length) goto L26;
        if (Float.isNaN(x[i]) == true) goto L25;
        if (Float.isNaN(y[i]) == true) goto L25;
        if (x[i] < 0.0f) goto L25;
        if (prevX >= x[i]) goto L25;
        prevX = x[i];
        i = i + 1;
    L25:
        return false;
    L26:
        return true;
    L28:
        return false;
    }

    private boolean tooSoon(float value) {
        long time = System.currentTimeMillis();
        if (value <= this.mLastValue) goto L5;
        long earliestTime = this.mLastTime + ((long) this.mIncreaseDebounce);
    L7:
        if (time >= earliestTime) goto L9;
        boolean tooSoon = true;
    L11:
        if (this.mLoggingEnabled == false) goto L21;
        StringBuilder r5 = new StringBuilder();
        if (tooSoon == false) goto L15;
        String r6 = "too soon: ";
    L16:
        r5.append(r6);
        r5.append(time);
        if (tooSoon == false) goto L19;
        String r7 = " < ";
    L20:
        r5.append(r7);
        r5.append(earliestTime);
        Slog.d(TAG, r5.toString());
        goto L21
    L19:
        r7 = " > ";
        goto L20
    L15:
        r6 = "late enough: ";
    L21:
        return tooSoon;
    L9:
        tooSoon = false;
        goto L11
    L5:
        long earliestTime2 = this.mLastTime;
        earliestTime = earliestTime2 + ((long) this.mDecreaseDebounce);
        goto L7
    }

    private boolean tooClose(float value) {
        boolean tooClose = false;
        if (value <= this.mLastValue) goto L8;
        float threshold = this.mIncreaseThreshold;
        if (value >= threshold) goto L12;
        tooClose = true;
    L12:
        if (this.mLoggingEnabled == false) goto L22;
        StringBuilder r2 = new StringBuilder();
        if (tooClose == false) goto L16;
        String r3 = "too close: ";
    L17:
        r2.append(r3);
        r2.append(value);
        if (value <= threshold) goto L20;
        String r4 = " > ";
    L21:
        r2.append(r4);
        r2.append(threshold);
        Slog.d(TAG, r2.toString());
        goto L22
    L20:
        r4 = " < ";
        goto L21
    L16:
        r3 = "far enough: ";
    L22:
        return tooClose;
    L8:
        threshold = this.mDecreaseThreshold;
        if (value <= threshold) goto L12;
        tooClose = true;
        goto L12
    }

    private void computeThresholds(float value) {
        int index = getHighestIndexBefore(value, this.mBaseThresholds);
        this.mIncreaseThreshold = (this.mIncreaseThresholds[index] + 1.0f) * value;
        this.mDecreaseThreshold = (1.0f - this.mDecreaseThresholds[index]) * value;
    }

    private int getHighestIndexBefore(float value, float[] values) {
        int i = 0;
    L4:
        if (i >= values.length) goto L9;
        if (values[i] >= value) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        int i2 = values.length;
        return i2 - 1;
    }
}
