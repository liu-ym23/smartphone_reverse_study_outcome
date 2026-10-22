package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes17.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction;
        private final DynamicAnimation.MassState mMassState;
        private float mVelocityThreshold;

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        public DragForce() {
            this.mFriction = DEFAULT_FRICTION;
            this.mMassState = new DynamicAnimation.MassState();
        }

        public void setFrictionScalar(float r100) {
            this.mFriction = r100 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float r100) {
            this.mVelocityThreshold = r100 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float r100, float r101) {
            return r101 * this.mFriction;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float r100, float r101) {
            if (Math.abs(r101) >= this.mVelocityThreshold) goto L5;
            return true;
        L5:
            return false;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float r100, float r101, long r102) {
            float r103 = r102;
            this.mMassState.mVelocity = (float) (((double) r101) * Math.exp((r103 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState r104 = this.mMassState;
            float r105 = this.mFriction;
            r104.mValue = (float) (((double) (r100 - (r101 / r105))) + (((double) (r101 / r105)) * Math.exp((r105 * r103) / 1000.0f)));
            DynamicAnimation.MassState r106 = this.mMassState;
            if (isAtEquilibrium(r106.mValue, r106.mVelocity) == false) goto L6;
            this.mMassState.mVelocity = 0.0f;
        L6:
            return this.mMassState;
        }
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    public FlingAnimation(FloatValueHolder r100) {
        super(r100);
        DragForce r101 = new DragForce();
        this.mFlingForce = r101;
        r101.setValueThreshold(getValueThreshold());
    }

    public FlingAnimation setFriction(float r100) {
        if (r100 <= 0.0f) goto L7;
        this.mFlingForce.setFrictionScalar(r100);
        return this;
    L7:
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMaxValue(float r100) {
        return setMaxValue(r100);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMinValue(float r100) {
        return setMinValue(r100);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setStartVelocity(float r100) {
        return setStartVelocity(r100);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float r100) {
        this.mFlingForce.setValueThreshold(r100);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long r100) {
        DynamicAnimation.MassState r101 = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, r100);
        float r102 = r101.mValue;
        this.mValue = r102;
        float r103 = r101.mVelocity;
        this.mVelocity = r103;
        float r104 = this.mMinValue;
        if (r102 >= r104) goto L6;
        this.mValue = r104;
        return true;
    L6:
        float r105 = this.mMaxValue;
        if (r102 <= r105) goto L11;
        this.mValue = r105;
        return true;
    L11:
        if (isAtEquilibrium(r102, r103) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float r100) {
        super.setMaxValue(r100);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float r100) {
        super.setMinValue(r100);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float r100) {
        super.setStartVelocity(r100);
        return this;
    }

    public <K> FlingAnimation(K r100, FloatPropertyCompat<K> r101) {
        super(r100, r101);
        DragForce r102 = new DragForce();
        this.mFlingForce = r102;
        r102.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float r100, float r101) {
        return this.mFlingForce.getAcceleration(r100, r101);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float r100, float r101) {
        if (r100 < this.mMaxValue) goto L5;
    L10:
        return true;
    L5:
        if (r100 <= this.mMinValue) goto L10;
        if (this.mFlingForce.isAtEquilibrium(r100, r101) == true) goto L10;
        return false;
    }
}
