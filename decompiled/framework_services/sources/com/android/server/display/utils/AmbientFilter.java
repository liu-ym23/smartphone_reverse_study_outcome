package com.android.server.display.utils;

import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AmbientFilter {
    protected static final boolean DEBUG = false;
    private final RollingBuffer mBuffer;
    private final int mHorizon;
    protected boolean mLoggingEnabled;
    protected final String mTag;

    static class WeightedMovingAverageAmbientFilter extends AmbientFilter {
        private static final int PREDICTION_TIME = 100;
        private final float mIntercept;

        WeightedMovingAverageAmbientFilter(String tag, int horizon, float intercept) {
            super(tag, horizon);
            validateArguments(intercept);
            this.mIntercept = intercept;
        }

        @Override // com.android.server.display.utils.AmbientFilter
        public void dump(PrintWriter writer) {
            super.dump(writer);
            writer.println("    mIntercept=" + this.mIntercept);
        }

        @Override // com.android.server.display.utils.AmbientFilter
        protected float filter(long time, RollingBuffer buffer) {
            if (buffer.isEmpty() == false) goto L6;
            return -1.0f;
        L6:
            float total = 0.0f;
            float totalWeight = 0.0f;
            float[] weights = getWeights(time, buffer);
            int i = 0;
        L8:
            if (i >= weights.length) goto L11;
            float value = buffer.getValue(i);
            float weight = weights[i];
            total = total + (weight * value);
            totalWeight = totalWeight + weight;
            i = i + 1;
            goto L8
        L11:
            if (totalWeight != 0.0f) goto L15;
            return buffer.getValue(buffer.size() - 1);
        L15:
            return total / totalWeight;
        }

        private void validateArguments(float intercept) {
            if (Float.isNaN(intercept) == true) goto L8;
            if (intercept < 0.0f) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("intercept must be a non-negative number");
        }

        private float[] getWeights(long time, RollingBuffer buffer) {
            float[] weights = new float[buffer.size()];
            long startTime = buffer.getTime(0);
            float previousTime = 0.0f;
            int i = 1;
        L4:
            if (i >= weights.length) goto L6;
            float currentTime = (buffer.getTime(i) - startTime) / 1000.0f;
            float weight = calculateIntegral(previousTime, currentTime);
            weights[i - 1] = weight;
            previousTime = currentTime;
            i = i + 1;
            goto L4
        L6:
            float lastTime = ((100 + time) - startTime) / 1000.0f;
            float lastWeight = calculateIntegral(previousTime, lastTime);
            weights[weights.length - 1] = lastWeight;
            return weights;
        }

        private float calculateIntegral(float from, float to) {
            return antiderivative(to) - antiderivative(from);
        }

        private float antiderivative(float x) {
            return ((0.5f * x) * x) + (this.mIntercept * x);
        }
    }

    protected abstract float filter(long r1, RollingBuffer r3);

    AmbientFilter(String tag, int horizon) {
        validateArguments(horizon);
        this.mTag = tag;
        this.mLoggingEnabled = false;
        this.mHorizon = horizon;
        this.mBuffer = new RollingBuffer();
    }

    public boolean addValue(long time, float value) {
        if (value >= 0.0f) goto L6;
        return false;
    L6:
        truncateOldValues(time);
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(this.mTag, "add value: " + value + " @ " + time);
    L9:
        this.mBuffer.add(time, value);
        return true;
    }

    public float getEstimate(long time) {
        truncateOldValues(time);
        float value = filter(time, this.mBuffer);
        if (this.mLoggingEnabled == false) goto L5;
        Slog.d(this.mTag, "get estimate: " + value + " @ " + time);
    L5:
        return value;
    }

    public void clear() {
        this.mBuffer.clear();
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public void dump(PrintWriter writer) {
        writer.println("  " + this.mTag);
        writer.println("    mLoggingEnabled=" + this.mLoggingEnabled);
        writer.println("    mHorizon=" + this.mHorizon);
        writer.println("    mBuffer=" + this.mBuffer);
    }

    private void validateArguments(int horizon) {
        if (horizon <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("horizon must be positive");
    }

    private void truncateOldValues(long time) {
        long minTime = time - ((long) this.mHorizon);
        this.mBuffer.truncate(minTime);
    }
}
