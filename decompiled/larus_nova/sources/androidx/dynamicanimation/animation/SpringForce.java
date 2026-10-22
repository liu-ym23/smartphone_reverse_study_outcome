package androidx.dynamicanimation.animation;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes17.dex */
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

    private void init() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mFinalPosition == Double.MAX_VALUE) goto L18;
        double r100 = this.mDampingRatio;
        if (r100 <= 1.0d) goto L11;
        double r101 = this.mNaturalFreq;
        this.mGammaPlus = ((-r100) * r101) + (r101 * Math.sqrt((r100 * r100) - 1.0d));
        double r102 = this.mDampingRatio;
        double r103 = this.mNaturalFreq;
        this.mGammaMinus = ((-r102) * r103) - (r103 * Math.sqrt((r102 * r102) - 1.0d));
    L15:
        this.mInitialized = true;
        return;
    L11:
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        if (r100 >= 1.0d) goto L15;
        this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (r100 * r100));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double r100 = this.mNaturalFreq;
        return (float) (r100 * r100);
    }

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float r100) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = r100;
    }

    public SpringForce setDampingRatio(float r100) {
        if (r100 < 0.0f) goto L7;
        this.mDampingRatio = r100;
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float r100) {
        this.mFinalPosition = r100;
        return this;
    }

    public SpringForce setStiffness(float r100) {
        if (r100 <= 0.0f) goto L7;
        this.mNaturalFreq = Math.sqrt(r100);
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void setValueThreshold(double r100) {
        double r101 = Math.abs(r100);
        this.mValueThreshold = r101;
        this.mVelocityThreshold = r101 * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float r100, float r101) {
        float r102 = r100 - getFinalPosition();
        double r103 = this.mNaturalFreq;
        double r104 = r103 * r103;
        double r105 = (r103 * 2.0d) * this.mDampingRatio;
        return (float) (((-r104) * ((double) r102)) - (r105 * ((double) r101)));
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float r100, float r101) {
        if (Math.abs(r101) < this.mVelocityThreshold) goto L5;
        return false;
    L5:
        if (Math.abs(r100 - getFinalPosition()) >= this.mValueThreshold) goto L10;
        return true;
    L10:
        return false;
    }

    public DynamicAnimation.MassState updateValues(double r110, double r111, long r210) {
        init();
        double r100 = r210 / 1000.0d;
        double r101 = r110 - this.mFinalPosition;
        double r102 = this.mDampingRatio;
        if (r102 <= 1.0d) goto L6;
        double r103 = this.mGammaMinus;
        double r112 = this.mGammaPlus;
        double r104 = r101 - (((r103 * r101) - r111) / (r103 - r112));
        double r105 = ((r101 * r103) - r111) / (r103 - r112);
        double r106 = (Math.pow(2.718281828459045d, r103 * r100) * r104) + (Math.pow(2.718281828459045d, this.mGammaPlus * r100) * r105);
        double r113 = this.mGammaMinus;
        double r107 = (r104 * r113) * Math.pow(2.718281828459045d, r113 * r100);
        double r114 = this.mGammaPlus;
        double r108 = r107 + ((r105 * r114) * Math.pow(2.718281828459045d, r114 * r100));
    L9:
        DynamicAnimation.MassState r109 = this.mMassState;
        r109.mValue = (float) (r106 + this.mFinalPosition);
        r109.mVelocity = (float) r108;
        return r109;
    L6:
        if (r102 != 1.0d) goto L8;
        double r115 = this.mNaturalFreq;
        double r116 = r111 + (r115 * r101);
        double r117 = r101 + (r116 * r100);
        r106 = Math.pow(2.718281828459045d, (-r115) * r100) * r117;
        double r118 = r117 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * r100);
        double r119 = this.mNaturalFreq;
        r108 = (r116 * Math.pow(2.718281828459045d, (-r119) * r100)) + (r118 * (-r119));
        goto L9
    L8:
        double r120 = 1.0d / this.mDampedFreq;
        double r121 = this.mNaturalFreq;
        double r122 = r120 * (((r102 * r121) * r101) + r111);
        double r123 = Math.pow(2.718281828459045d, ((-r102) * r121) * r100) * ((Math.cos(this.mDampedFreq * r100) * r101) + (Math.sin(this.mDampedFreq * r100) * r122));
        double r124 = this.mNaturalFreq;
        double r125 = this.mDampingRatio;
        double r126 = ((-r124) * r123) * r125;
        double r127 = Math.pow(2.718281828459045d, ((-r125) * r124) * r100);
        double r128 = this.mDampedFreq;
        double r129 = ((-r128) * r101) * Math.sin(r128 * r100);
        double r130 = this.mDampedFreq;
        r108 = r126 + (r127 * (r129 + ((r122 * r130) * Math.cos(r130 * r100))));
        r106 = r123;
        goto L9
    }
}
