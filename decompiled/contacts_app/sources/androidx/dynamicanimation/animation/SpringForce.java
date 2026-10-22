package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
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
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float r3) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = r3;
    }

    public SpringForce setStiffness(float r3) {
        if (r3 <= 0.0f) goto L7;
        this.mNaturalFreq = Math.sqrt(r3);
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public float getStiffness() {
        double r0 = this.mNaturalFreq;
        return (float) (r0 * r0);
    }

    public SpringForce setDampingRatio(float r3) {
        if (r3 < 0.0f) goto L7;
        this.mDampingRatio = r3;
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public SpringForce setFinalPosition(float r3) {
        this.mFinalPosition = r3;
        return this;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float r7, float r8) {
        float r9 = r7 - getFinalPosition();
        double r0 = this.mNaturalFreq;
        double r2 = r0 * r0;
        double r1 = (r0 * 2.0d) * this.mDampingRatio;
        return (float) (((-r2) * ((double) r9)) - (r1 * ((double) r8)));
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float r5, float r6) {
        if (Math.abs(r6) < this.mVelocityThreshold) goto L5;
        return false;
    L5:
        if (Math.abs(r5 - getFinalPosition()) >= this.mValueThreshold) goto L10;
        return true;
    L10:
        return false;
    }

    private void init() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mFinalPosition == Double.MAX_VALUE) goto L18;
        double r0 = this.mDampingRatio;
        if (r0 <= 1.0d) goto L11;
        double r6 = this.mNaturalFreq;
        this.mGammaPlus = ((-r0) * r6) + (r6 * Math.sqrt((r0 * r0) - 1.0d));
        double r1 = this.mDampingRatio;
        double r7 = this.mNaturalFreq;
        this.mGammaMinus = ((-r1) * r7) - (r7 * Math.sqrt((r1 * r1) - 1.0d));
    L15:
        this.mInitialized = true;
        return;
    L11:
        if (r0 < 0.0d) goto L15;
        if (r0 >= 1.0d) goto L15;
        this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (r0 * r0));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    DynamicAnimation.MassState updateValues(double r17, double r19, long r21) {
        init();
        double r1 = r21 / 1000.0d;
        double r3 = r17 - this.mFinalPosition;
        double r5 = this.mDampingRatio;
        if (r5 <= 1.0d) goto L6;
        double r6 = this.mGammaMinus;
        double r12 = this.mGammaPlus;
        double r7 = r3 - (((r6 * r3) - r19) / (r6 - r12));
        double r4 = ((r3 * r6) - r19) / (r6 - r12);
        double r8 = (Math.pow(2.718281828459045d, r6 * r1) * r7) + (Math.pow(2.718281828459045d, this.mGammaPlus * r1) * r4);
        double r13 = this.mGammaMinus;
        double r9 = (r7 * r13) * Math.pow(2.718281828459045d, r13 * r1);
        double r14 = this.mGammaPlus;
        double r10 = r9 + ((r4 * r14) * Math.pow(2.718281828459045d, r14 * r1));
    L9:
        this.mMassState.mValue = (float) (r8 + this.mFinalPosition);
        this.mMassState.mVelocity = (float) r10;
        return this.mMassState;
    L6:
        if (r5 != 1.0d) goto L8;
        double r11 = this.mNaturalFreq;
        double r15 = r19 + (r11 * r3);
        double r16 = r3 + (r15 * r1);
        r8 = Math.pow(2.718281828459045d, (-r11) * r1) * r16;
        double r18 = r16 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * r1);
        double r110 = this.mNaturalFreq;
        r10 = (r15 * Math.pow(2.718281828459045d, (-r110) * r1)) + (r18 * (-r110));
        goto L9
    L8:
        double r20 = 1.0d / this.mDampedFreq;
        double r111 = this.mNaturalFreq;
        double r22 = r20 * (((r5 * r111) * r3) + r19);
        double r23 = Math.pow(2.718281828459045d, ((-r5) * r111) * r1) * ((Math.cos(this.mDampedFreq * r1) * r3) + (Math.sin(this.mDampedFreq * r1) * r22));
        double r112 = this.mNaturalFreq;
        double r113 = this.mDampingRatio;
        double r114 = ((-r112) * r23) * r113;
        double r24 = Math.pow(2.718281828459045d, ((-r113) * r112) * r1);
        double r115 = this.mDampedFreq;
        double r25 = ((-r115) * r3) * Math.sin(r115 * r1);
        double r26 = this.mDampedFreq;
        r10 = r114 + (r24 * (r25 + ((r22 * r26) * Math.cos(r26 * r1))));
        r8 = r23;
        goto L9
    }

    void setValueThreshold(double r3) {
        double r4 = Math.abs(r3);
        this.mValueThreshold = r4;
        this.mVelocityThreshold = r4 * VELOCITY_THRESHOLD_MULTIPLIER;
    }
}
