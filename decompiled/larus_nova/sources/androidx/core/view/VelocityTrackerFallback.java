package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes17.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private int mDataPointsBufferLastUsedIndex;
    private int mDataPointsBufferSize;
    private final long[] mEventTimes;
    private float mLastComputedVelocity;
    private final float[] mMovements;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        int r100 = this.mDataPointsBufferSize;
        if (r100 >= 2) goto L5;
        return 0.0f;
    L5:
        int r101 = this.mDataPointsBufferLastUsedIndex;
        int r102 = ((r101 + 20) - (r100 - 1)) % 20;
        long r103 = this.mEventTimes[r101];
    L6:
        long[] r104 = this.mEventTimes;
        long r105 = r104[r102];
        if ((r103 - r105) <= 100) goto L9;
        this.mDataPointsBufferSize--;
        r102 = (r102 + 1) % 20;
        goto L6
    L9:
        int r106 = this.mDataPointsBufferSize;
        if (r106 >= 2) goto L12;
        return 0.0f;
    L12:
        if (r106 != 2) goto L18;
        int r107 = (r102 + 1) % 20;
        long r108 = r104[r107];
        if (r105 != r108) goto L17;
        return 0.0f;
    L17:
        return this.mMovements[r107] / (r108 - r105);
    L18:
        int r109 = 0;
        int r110 = 0;
        float r111 = 0.0f;
    L20:
        if (r109 >= (this.mDataPointsBufferSize - 1)) goto L29;
        int r112 = r109 + r102;
        long[] r113 = this.mEventTimes;
        long r114 = r113[r112 % 20];
        int r115 = (r112 + 1) % 20;
        if (r113[r115] == r114) goto L27;
        r110 = r110 + 1;
        float r116 = kineticEnergyToVelocity(r111);
        float r117 = this.mMovements[r115] / (this.mEventTimes[r115] - r114);
        r111 = r111 + ((r117 - r116) * Math.abs(r117));
        if (r110 != 1) goto L27;
        r111 = r111 * 0.5f;
    L27:
        r109 = r109 + 1;
        goto L20
    L29:
        return kineticEnergyToVelocity(r111);
    }

    public VelocityTrackerFallback() {
        this.mMovements = new float[20];
        this.mEventTimes = new long[20];
        this.mLastComputedVelocity = 0.0f;
        this.mDataPointsBufferSize = 0;
        this.mDataPointsBufferLastUsedIndex = 0;
    }

    private static float kineticEnergyToVelocity(float r100) {
        if (r100 >= 0.0f) goto L5;
        float r101 = -1.0f;
    L7:
        return r101 * ((float) Math.sqrt(Math.abs(r100) * 2.0f));
    L5:
        r101 = 1.0f;
        goto L7
    }

    public void addMovement(MotionEvent r100) {
        long r101 = r100.getEventTime();
        if (this.mDataPointsBufferSize != 0) goto L5;
    L7:
        int r102 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = r102;
        int r103 = this.mDataPointsBufferSize;
        if (r103 == 20) goto L10;
        this.mDataPointsBufferSize = r103 + 1;
    L10:
        this.mMovements[r102] = r100.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = r101;
        return;
    L5:
        if ((r101 - this.mEventTimes[this.mDataPointsBufferLastUsedIndex]) <= ASSUME_POINTER_STOPPED_MS) goto L7;
        clear();
        goto L7
    }

    public void computeCurrentVelocity(int r100) {
        computeCurrentVelocity(r100, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int r100) {
        if (r100 == 26) goto L7;
        return 0.0f;
    L7:
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int r100, float r101) {
        float r102 = getCurrentVelocity() * r100;
        this.mLastComputedVelocity = r102;
        if (r102 >= (-Math.abs(r101))) goto L6;
        this.mLastComputedVelocity = -Math.abs(r101);
        return;
    L6:
        if (this.mLastComputedVelocity <= Math.abs(r101)) goto L10;
        this.mLastComputedVelocity = Math.abs(r101);
        return;
    }
}
