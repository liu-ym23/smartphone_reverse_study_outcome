package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes2.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j5;
        int i = this.mDataPointsBufferSize;
        if (i < 2) {
            return 0.0f;
        }
        int i6 = this.mDataPointsBufferLastUsedIndex;
        int i10 = ((i6 + 20) - (i - 1)) % 20;
        long j6 = this.mEventTimes[i6];
        while (true) {
            jArr = this.mEventTimes;
            j5 = jArr[i10];
            if (j6 - j5 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i10 = (i10 + 1) % 20;
        }
        int i11 = this.mDataPointsBufferSize;
        if (i11 < 2) {
            return 0.0f;
        }
        if (i11 == 2) {
            int i12 = (i10 + 1) % 20;
            if (j5 == jArr[i12]) {
                return 0.0f;
            }
            return this.mMovements[i12] / (r2 - j5);
        }
        float f = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < this.mDataPointsBufferSize - 1; i14++) {
            int i15 = i14 + i10;
            long[] jArr2 = this.mEventTimes;
            long j10 = jArr2[i15 % 20];
            int i16 = (i15 + 1) % 20;
            if (jArr2[i16] != j10) {
                i13++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f7 = this.mMovements[i16] / (this.mEventTimes[i16] - j10);
                float fAbs = (Math.abs(f7) * (f7 - fKineticEnergyToVelocity)) + f;
                if (i13 == 1) {
                    fAbs *= 0.5f;
                }
                f = fAbs;
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i;
        int i6 = this.mDataPointsBufferSize;
        if (i6 != 20) {
            this.mDataPointsBufferSize = i6 + 1;
        }
        this.mMovements[i] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i) {
        computeCurrentVelocity(i, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i, float f) {
        float currentVelocity = getCurrentVelocity() * i;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }
}
