package androidx.palette.graphics;

/* JADX INFO: loaded from: classes17.dex */
public final class Target {
    public static final Target DARK_MUTED = null;
    public static final Target DARK_VIBRANT = null;
    static final int INDEX_MAX = 2;
    static final int INDEX_MIN = 0;
    static final int INDEX_TARGET = 1;
    static final int INDEX_WEIGHT_LUMA = 1;
    static final int INDEX_WEIGHT_POP = 2;
    static final int INDEX_WEIGHT_SAT = 0;
    public static final Target LIGHT_MUTED = null;
    public static final Target LIGHT_VIBRANT = null;
    private static final float MAX_DARK_LUMA = 0.45f;
    private static final float MAX_MUTED_SATURATION = 0.4f;
    private static final float MAX_NORMAL_LUMA = 0.7f;
    private static final float MIN_LIGHT_LUMA = 0.55f;
    private static final float MIN_NORMAL_LUMA = 0.3f;
    private static final float MIN_VIBRANT_SATURATION = 0.35f;
    public static final Target MUTED = null;
    private static final float TARGET_DARK_LUMA = 0.26f;
    private static final float TARGET_LIGHT_LUMA = 0.74f;
    private static final float TARGET_MUTED_SATURATION = 0.3f;
    private static final float TARGET_NORMAL_LUMA = 0.5f;
    private static final float TARGET_VIBRANT_SATURATION = 1.0f;
    public static final Target VIBRANT = null;
    private static final float WEIGHT_LUMA = 0.52f;
    private static final float WEIGHT_POPULATION = 0.24f;
    private static final float WEIGHT_SATURATION = 0.24f;
    boolean mIsExclusive;
    final float[] mLightnessTargets;
    final float[] mSaturationTargets;
    final float[] mWeights;

    public static final class Builder {
        private final Target mTarget;

        public Builder() {
            this.mTarget = new Target();
        }

        public Target build() {
            return this.mTarget;
        }

        public Builder(Target r100) {
            this.mTarget = new Target(r100);
        }

        public Builder setExclusive(boolean r100) {
            this.mTarget.mIsExclusive = r100;
            return this;
        }

        public Builder setLightnessWeight(float r100) {
            this.mTarget.mWeights[1] = r100;
            return this;
        }

        public Builder setMaximumLightness(float r100) {
            this.mTarget.mLightnessTargets[2] = r100;
            return this;
        }

        public Builder setMaximumSaturation(float r100) {
            this.mTarget.mSaturationTargets[2] = r100;
            return this;
        }

        public Builder setMinimumLightness(float r100) {
            this.mTarget.mLightnessTargets[0] = r100;
            return this;
        }

        public Builder setMinimumSaturation(float r100) {
            this.mTarget.mSaturationTargets[0] = r100;
            return this;
        }

        public Builder setPopulationWeight(float r100) {
            this.mTarget.mWeights[2] = r100;
            return this;
        }

        public Builder setSaturationWeight(float r100) {
            this.mTarget.mWeights[0] = r100;
            return this;
        }

        public Builder setTargetLightness(float r100) {
            this.mTarget.mLightnessTargets[1] = r100;
            return this;
        }

        public Builder setTargetSaturation(float r100) {
            this.mTarget.mSaturationTargets[1] = r100;
            return this;
        }
    }

    static {
        Target r100 = new Target();
        LIGHT_VIBRANT = r100;
        setDefaultLightLightnessValues(r100);
        setDefaultVibrantSaturationValues(r100);
        Target r101 = new Target();
        VIBRANT = r101;
        setDefaultNormalLightnessValues(r101);
        setDefaultVibrantSaturationValues(r101);
        Target r102 = new Target();
        DARK_VIBRANT = r102;
        setDefaultDarkLightnessValues(r102);
        setDefaultVibrantSaturationValues(r102);
        Target r103 = new Target();
        LIGHT_MUTED = r103;
        setDefaultLightLightnessValues(r103);
        setDefaultMutedSaturationValues(r103);
        Target r104 = new Target();
        MUTED = r104;
        setDefaultNormalLightnessValues(r104);
        setDefaultMutedSaturationValues(r104);
        Target r105 = new Target();
        DARK_MUTED = r105;
        setDefaultDarkLightnessValues(r105);
        setDefaultMutedSaturationValues(r105);
    }

    private void setDefaultWeights() {
        float[] r100 = this.mWeights;
        r100[0] = 0.24f;
        r100[1] = 0.52f;
        r100[2] = 0.24f;
    }

    public float getLightnessWeight() {
        return this.mWeights[1];
    }

    public float getMaximumLightness() {
        return this.mLightnessTargets[2];
    }

    public float getMaximumSaturation() {
        return this.mSaturationTargets[2];
    }

    public float getMinimumLightness() {
        return this.mLightnessTargets[0];
    }

    public float getMinimumSaturation() {
        return this.mSaturationTargets[0];
    }

    public float getPopulationWeight() {
        return this.mWeights[2];
    }

    public float getSaturationWeight() {
        return this.mWeights[0];
    }

    public float getTargetLightness() {
        return this.mLightnessTargets[1];
    }

    public float getTargetSaturation() {
        return this.mSaturationTargets[1];
    }

    public void normalizeWeights() {
        int r100 = this.mWeights.length;
        int r101 = 0;
        int r102 = 0;
        float r103 = 0.0f;
    L3:
        if (r102 >= r100) goto L9;
        float r104 = this.mWeights[r102];
        if (r104 <= 0.0f) goto L7;
        r103 = r103 + r104;
    L7:
        r102 = r102 + 1;
        goto L3
    L9:
        if (r103 == 0.0f) goto L16;
        int r105 = this.mWeights.length;
    L11:
        if (r101 >= r105) goto L23;
        float[] r106 = this.mWeights;
        float r107 = r106[r101];
        if (r107 <= 0.0f) goto L15;
        r106[r101] = r107 / r103;
    L15:
        r101 = r101 + 1;
        goto L11
    L23:
        return;
    }

    public Target() {
        float[] r100 = new float[3];
        this.mSaturationTargets = r100;
        float[] r101 = new float[3];
        this.mLightnessTargets = r101;
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        setTargetDefaultValues(r100);
        setTargetDefaultValues(r101);
        setDefaultWeights();
    }

    public boolean isExclusive() {
        return this.mIsExclusive;
    }

    public Target(Target r100) {
        float[] r101 = new float[3];
        this.mSaturationTargets = r101;
        float[] r102 = new float[3];
        this.mLightnessTargets = r102;
        float[] r103 = new float[3];
        this.mWeights = r103;
        this.mIsExclusive = true;
        System.arraycopy(r100.mSaturationTargets, 0, r101, 0, r101.length);
        System.arraycopy(r100.mLightnessTargets, 0, r102, 0, r102.length);
        System.arraycopy(r100.mWeights, 0, r103, 0, r103.length);
    }

    private static void setDefaultDarkLightnessValues(Target r100) {
        float[] r101 = r100.mLightnessTargets;
        r101[1] = 0.26f;
        r101[2] = 0.45f;
    }

    private static void setDefaultLightLightnessValues(Target r100) {
        float[] r101 = r100.mLightnessTargets;
        r101[0] = 0.55f;
        r101[1] = 0.74f;
    }

    private static void setDefaultMutedSaturationValues(Target r100) {
        float[] r101 = r100.mSaturationTargets;
        r101[1] = 0.3f;
        r101[2] = 0.4f;
    }

    private static void setDefaultNormalLightnessValues(Target r100) {
        float[] r101 = r100.mLightnessTargets;
        r101[0] = 0.3f;
        r101[1] = 0.5f;
        r101[2] = 0.7f;
    }

    private static void setDefaultVibrantSaturationValues(Target r100) {
        float[] r101 = r100.mSaturationTargets;
        r101[0] = 0.35f;
        r101[1] = 1.0f;
    }

    private static void setTargetDefaultValues(float[] r100) {
        r100[0] = 0.0f;
        r100[1] = 0.5f;
        r100[2] = 1.0f;
    }
}
