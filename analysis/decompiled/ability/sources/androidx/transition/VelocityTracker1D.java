package androidx.transition;

import java.util.Arrays;

/* loaded from: classes2.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.sqrt(Math.abs(f) * 2.0f) * Math.signum(f));
    }

    public void addDataPoint(long j5, float f) {
        int i = (this.mIndex + 1) % 20;
        this.mIndex = i;
        this.mTimeSamples[i] = j5;
        this.mDataSamples[i] = f;
    }

    public float calculateVelocity() {
        int i = this.mIndex;
        if (i == 0 && this.mTimeSamples[i] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j5 = this.mTimeSamples[i];
        int i6 = 0;
        long j6 = j5;
        while (true) {
            long j10 = this.mTimeSamples[i];
            if (j10 == Long.MIN_VALUE) {
                break;
            }
            float f = j5 - j10;
            float fAbs = Math.abs(j10 - j6);
            if (f > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i == 0) {
                i = 20;
            }
            i--;
            i6++;
            if (i6 >= 20) {
                break;
            }
            j6 = j10;
        }
        if (i6 < 2) {
            return 0.0f;
        }
        if (i6 == 2) {
            int i10 = this.mIndex;
            int i11 = i10 == 0 ? 19 : i10 - 1;
            long[] jArr = this.mTimeSamples;
            float f7 = jArr[i10] - jArr[i11];
            if (f7 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            return ((fArr[i10] - fArr[i11]) / f7) * 1000.0f;
        }
        int i12 = this.mIndex;
        int i13 = ((i12 - i6) + 21) % 20;
        int i14 = (i12 + 21) % 20;
        long j11 = this.mTimeSamples[i13];
        float f9 = this.mDataSamples[i13];
        int i15 = i13 + 1;
        float f10 = 0.0f;
        for (int i16 = i15 % 20; i16 != i14; i16 = (i16 + 1) % 20) {
            long j12 = this.mTimeSamples[i16];
            float f11 = j12 - j11;
            if (f11 != 0.0f) {
                float f12 = this.mDataSamples[i16];
                float f13 = (f12 - f9) / f11;
                float fAbs2 = (Math.abs(f13) * (f13 - kineticEnergyToVelocity(f10))) + f10;
                if (i16 == i15) {
                    fAbs2 *= 0.5f;
                }
                f10 = fAbs2;
                f9 = f12;
                j11 = j12;
            }
        }
        return kineticEnergyToVelocity(f10) * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
