package androidx.constraintlayout.core.motion.utils;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;

/* loaded from: classes2.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f) {
        this.mDone = false;
        float f7 = this.mStage1Duration;
        if (f <= f7) {
            float f9 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f9) * f) * f) / (f7 * 2.0f)) + (f9 * f);
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return this.mStage1EndPosition;
        }
        float f10 = f - f7;
        float f11 = this.mStage2Duration;
        if (f10 < f11) {
            float f12 = this.mStage1EndPosition;
            float f13 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f13) * f10) * f10) / (f11 * 2.0f)) + (f13 * f10) + f12;
        }
        if (i == 2) {
            return this.mStage2EndPosition;
        }
        float f14 = f10 - f11;
        float f15 = this.mStage3Duration;
        if (f14 > f15) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f16 = this.mStage2EndPosition;
        float f17 = this.mStage3Velocity;
        return ((f17 * f14) + f16) - (((f17 * f14) * f14) / (f15 * 2.0f));
    }

    private void setup(float f, float f7, float f9, float f10, float f11) {
        this.mDone = false;
        this.mStage3EndPosition = f7;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        float f12 = f / f9;
        float f13 = (f12 * f) / 2.0f;
        if (f < 0.0f) {
            float fSqrt = (float) Math.sqrt((f7 - ((((-f) / f9) * f) / 2.0f)) * f9);
            if (fSqrt < f10) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f14 = (fSqrt - f) / f9;
                this.mStage1Duration = f14;
                this.mStage2Duration = fSqrt / f9;
                this.mStage1EndPosition = ((f + fSqrt) * f14) / 2.0f;
                this.mStage2EndPosition = f7;
                this.mStage3EndPosition = f7;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f10;
            this.mStage3Velocity = f10;
            float f15 = (f10 - f) / f9;
            this.mStage1Duration = f15;
            float f16 = f10 / f9;
            this.mStage3Duration = f16;
            float f17 = ((f + f10) * f15) / 2.0f;
            float f18 = (f16 * f10) / 2.0f;
            this.mStage2Duration = ((f7 - f17) - f18) / f10;
            this.mStage1EndPosition = f17;
            this.mStage2EndPosition = f7 - f18;
            this.mStage3EndPosition = f7;
            return;
        }
        if (f13 >= f7) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f7;
            this.mStage1Duration = (2.0f * f7) / f;
            return;
        }
        float f19 = f7 - f13;
        float f20 = f19 / f;
        if (f20 + f12 < f11) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f19;
            this.mStage2EndPosition = f7;
            this.mStage1Duration = f20;
            this.mStage2Duration = f12;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f9 * f7));
        float f21 = (fSqrt2 - f) / f9;
        this.mStage1Duration = f21;
        float f22 = fSqrt2 / f9;
        this.mStage2Duration = f22;
        if (fSqrt2 < f10) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f21;
            this.mStage2Duration = f22;
            this.mStage1EndPosition = ((f + fSqrt2) * f21) / 2.0f;
            this.mStage2EndPosition = f7;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f10;
        this.mStage3Velocity = f10;
        float f23 = (f10 - f) / f9;
        this.mStage1Duration = f23;
        float f24 = f10 / f9;
        this.mStage3Duration = f24;
        float f25 = ((f + f10) * f23) / 2.0f;
        float f26 = (f24 * f10) / 2.0f;
        this.mStage2Duration = ((f7 - f25) - f26) / f10;
        this.mStage1EndPosition = f25;
        this.mStage2EndPosition = f7 - f26;
        this.mStage3EndPosition = f7;
    }

    public void config(float f, float f7, float f9, float f10, float f11, float f12) {
        this.mDone = false;
        this.mStartPosition = f;
        boolean z10 = f > f7;
        this.mBackwards = z10;
        if (z10) {
            setup(-f9, f - f7, f11, f12, f10);
        } else {
            setup(f9, f7 - f, f11, f12, f10);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        StringBuilder sbX = a.x(B7.a.q(a.x(str, " ===== "), this.mType, "\n"), str);
        sbX.append(this.mBackwards ? "backwards" : "forward ");
        sbX.append(" time = ");
        sbX.append(f);
        sbX.append("  stages ");
        String strO = a.o(sbX, "\n", this.mNumberOfStages);
        StringBuilder sb = new StringBuilder();
        sb.append(strO);
        sb.append(str);
        sb.append(" dur ");
        sb.append(this.mStage1Duration);
        sb.append(" vel ");
        sb.append(this.mStage1Velocity);
        sb.append(" pos ");
        String strU = b.u(sb, "\n", this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strU);
            sb2.append(str);
            sb2.append(" dur ");
            sb2.append(this.mStage2Duration);
            sb2.append(" vel ");
            sb2.append(this.mStage2Velocity);
            sb2.append(" pos ");
            strU = b.u(sb2, "\n", this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(strU);
            sb3.append(str);
            sb3.append(" dur ");
            sb3.append(this.mStage3Duration);
            sb3.append(" vel ");
            sb3.append(this.mStage3Velocity);
            sb3.append(" pos ");
            strU = b.u(sb3, "\n", this.mStage3EndPosition);
        }
        float f7 = this.mStage1Duration;
        if (f <= f7) {
            return B7.a.B(strU, str, "stage 0\n");
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return B7.a.B(strU, str, "end stage 0\n");
        }
        float f9 = f - f7;
        float f10 = this.mStage2Duration;
        return f9 < f10 ? B7.a.B(strU, str, " stage 1\n") : i == 2 ? B7.a.B(strU, str, "end stage 1\n") : f9 - f10 < this.mStage3Duration ? B7.a.B(strU, str, " stage 2\n") : B7.a.B(strU, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float fCalcY = calcY(f);
        this.mLastPosition = fCalcY;
        this.mLastTime = f;
        boolean z10 = this.mBackwards;
        float f7 = this.mStartPosition;
        return z10 ? f7 - fCalcY : f7 + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        float f7 = this.mStage1Duration;
        if (f <= f7) {
            float f9 = this.mStage1Velocity;
            return (((this.mStage2Velocity - f9) * f) / f7) + f9;
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return 0.0f;
        }
        float f10 = f - f7;
        float f11 = this.mStage2Duration;
        if (f10 < f11) {
            float f12 = this.mStage2Velocity;
            return (((this.mStage3Velocity - f12) * f10) / f11) + f12;
        }
        if (i == 2) {
            return 0.0f;
        }
        float f13 = f10 - f11;
        float f14 = this.mStage3Duration;
        if (f13 >= f14) {
            return 0.0f;
        }
        float f15 = this.mStage3Velocity;
        return f15 - ((f13 * f15) / f14);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f, float f7, float f9) {
            this.mDone = false;
            this.mDestination = f7;
            this.mInitialVelocity = f9;
            this.mInitialPos = f;
            float f10 = (f7 - f) / (f9 / 2.0f);
            this.mDuration = f10;
            this.mAcceleration = (-f9) / f10;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public String debug(String str, float f) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f) {
            if (f > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f);
            return ((((this.mAcceleration * f) / 2.0f) + this.mInitialVelocity) * f) + this.mInitialPos;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity(float f) {
            if (f > this.mDuration) {
                return 0.0f;
            }
            float f7 = (this.mAcceleration * f) + this.mInitialVelocity;
            this.mLastVelocity = f7;
            return f7;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean isStopped() {
            return this.mDone;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity() {
            return this.mLastVelocity;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }
}
