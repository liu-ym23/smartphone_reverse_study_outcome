package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes2.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d) {
        if (d <= 0.0d) {
            return;
        }
        double d6 = this.mStiffness;
        double d10 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d6 / this.mMass) * d) * 4.0d)) + 1.0d);
        double d11 = d / iSqrt;
        int i = 0;
        while (i < iSqrt) {
            float f = this.mPos;
            double d12 = this.mTargetPos;
            float f7 = this.mV;
            double d13 = d6;
            double d14 = ((-d6) * (f - d12)) - (f7 * d10);
            float f9 = this.mMass;
            double d15 = d10;
            double d16 = (((d14 / f9) * d11) / 2.0d) + f7;
            double d17 = ((((-((((d11 * d16) / 2.0d) + f) - d12)) * d13) - (d16 * d15)) / f9) * d11;
            double d18 = (d17 / 2.0d) + f7;
            float f10 = f7 + ((float) d17);
            this.mV = f10;
            float f11 = f + ((float) (d18 * d11));
            this.mPos = f11;
            int i6 = this.mBoundaryMode;
            if (i6 > 0) {
                if (f11 < 0.0f && (i6 & 1) == 1) {
                    this.mPos = -f11;
                    this.mV = -f10;
                }
                float f12 = this.mPos;
                if (f12 > 1.0f && (i6 & 2) == 2) {
                    this.mPos = 2.0f - f12;
                    this.mV = -this.mV;
                }
            }
            i++;
            d6 = d13;
            d10 = d15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.mStiffness) * (this.mPos - this.mTargetPos)) - (this.mDamping * this.mV))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        compute(f - this.mLastTime);
        this.mLastTime = f;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = this.mPos - this.mTargetPos;
        double d6 = this.mStiffness;
        double d10 = this.mV;
        return Math.sqrt((((d6 * d) * d) + ((d10 * d10) * ((double) this.mMass))) / d6) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f, float f7, float f9, float f10, float f11, float f12, float f13, int i) {
        this.mTargetPos = f7;
        this.mDamping = f12;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = f9;
        this.mStiffness = f11;
        this.mMass = f10;
        this.mStopThreshold = f13;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.mV;
    }
}
