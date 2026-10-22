package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes2.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new DynamicAnimation.MassState();
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == UNSET) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.mDampingRatio;
        if (d > 1.0d) {
            double d6 = this.mNaturalFreq;
            this.mGammaPlus = (Math.sqrt((d * d) - 1.0d) * d6) + ((-d) * d6);
            double d10 = this.mDampingRatio;
            double d11 = this.mNaturalFreq;
            this.mGammaMinus = ((-d10) * d11) - (Math.sqrt((d10 * d10) - 1.0d) * d11);
        } else if (d >= 0.0d && d < 1.0d) {
            this.mDampedFreq = Math.sqrt(1.0d - (d * d)) * this.mNaturalFreq;
        }
        this.mInitialized = true;
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f, float f7) {
        float finalPosition = f - getFinalPosition();
        double d = this.mNaturalFreq;
        return (float) (((-(d * d)) * finalPosition) - (((d * 2.0d) * this.mDampingRatio) * f7));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d = this.mNaturalFreq;
        return (float) (d * d);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f, float f7) {
        return ((double) Math.abs(f7)) < this.mVelocityThreshold && ((double) Math.abs(f - getFinalPosition())) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.mDampingRatio = f;
        this.mInitialized = false;
        return this;
    }

    public SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public void setValueThreshold(double d) {
        double dAbs = Math.abs(d);
        this.mValueThreshold = dAbs;
        this.mVelocityThreshold = dAbs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation.MassState updateValues(double d, double d6, long j5) {
        double dSin;
        double dCos;
        init();
        double d10 = j5 / 1000.0d;
        double d11 = d - this.mFinalPosition;
        double d12 = this.mDampingRatio;
        if (d12 > 1.0d) {
            double d13 = this.mGammaMinus;
            double d14 = this.mGammaPlus;
            double d15 = d11 - (((d13 * d11) - d6) / (d13 - d14));
            double d16 = ((d11 * d13) - d6) / (d13 - d14);
            dSin = (Math.pow(2.718281828459045d, this.mGammaPlus * d10) * d16) + (Math.pow(2.718281828459045d, d13 * d10) * d15);
            double d17 = this.mGammaMinus;
            double dPow = Math.pow(2.718281828459045d, d17 * d10) * d15 * d17;
            double d18 = this.mGammaPlus;
            dCos = (Math.pow(2.718281828459045d, d18 * d10) * d16 * d18) + dPow;
        } else if (d12 == 1.0d) {
            double d19 = this.mNaturalFreq;
            double d20 = (d19 * d11) + d6;
            double d21 = (d20 * d10) + d11;
            double dPow2 = Math.pow(2.718281828459045d, (-d19) * d10) * d21;
            double dPow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d10) * d21;
            double d22 = this.mNaturalFreq;
            dCos = (Math.pow(2.718281828459045d, (-d22) * d10) * d20) + (dPow3 * (-d22));
            dSin = dPow2;
        } else {
            double d23 = 1.0d / this.mDampedFreq;
            double d24 = this.mNaturalFreq;
            double d25 = ((d12 * d24 * d11) + d6) * d23;
            dSin = ((Math.sin(this.mDampedFreq * d10) * d25) + (Math.cos(this.mDampedFreq * d10) * d11)) * Math.pow(2.718281828459045d, (-d12) * d24 * d10);
            double d26 = this.mNaturalFreq;
            double d27 = this.mDampingRatio;
            double d28 = (-d26) * dSin * d27;
            double dPow4 = Math.pow(2.718281828459045d, (-d27) * d26 * d10);
            double d29 = this.mDampedFreq;
            double dSin2 = Math.sin(d29 * d10) * (-d29) * d11;
            double d30 = this.mDampedFreq;
            dCos = (((Math.cos(d30 * d10) * d25 * d30) + dSin2) * dPow4) + d28;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (dSin + this.mFinalPosition);
        massState.mVelocity = (float) dCos;
        return massState;
    }

    public SpringForce(float f) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = UNSET;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }
}
