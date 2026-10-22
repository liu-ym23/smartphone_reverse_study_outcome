package androidx.core.content.res;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes17.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = null;
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    static {
        DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    public float getAw() {
        return this.mAw;
    }

    public float getC() {
        return this.mC;
    }

    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    public float getN() {
        return this.mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    public float getNc() {
        return this.mNc;
    }

    public float getNcb() {
        return this.mNcb;
    }

    public float[] getRgbD() {
        return this.mRgbD;
    }

    public float getZ() {
        return this.mZ;
    }

    public static ViewingConditions make(float[] r210, float r211, float r212, float r213, boolean r214) {
        float[][] r100 = CamUtils.XYZ_TO_CAM16RGB;
        float r101 = r210[0];
        float[] r102 = r100[0];
        float r103 = r102[0] * r101;
        float r104 = r210[1];
        float r105 = r103 + (r102[1] * r104);
        float r106 = r210[2];
        float r107 = r105 + (r102[2] * r106);
        float[] r108 = r100[1];
        float r110 = ((r108[0] * r101) + (r108[1] * r104)) + (r108[2] * r106);
        float[] r109 = r100[2];
        float r111 = ((r101 * r109[0]) + (r104 * r109[1])) + (r106 * r109[2]);
        float r112 = (r213 / 10.0f) + 0.8f;
        if (r112 < 0.9d) goto L5;
        float r113 = CamUtils.lerp(0.59f, 0.69f, (r112 - 0.9f) * 10.0f);
    L6:
        float r114 = r113;
        if (r214 == false) goto L9;
        float r115 = 1.0f;
    L10:
        double r116 = r115;
        if (r116 <= 1.0d) goto L14;
        r115 = 1.0f;
    L16:
        float[] r117 = {(((100.0f / r107) * r115) + 1.0f) - r115, (((100.0f / r110) * r115) + 1.0f) - r115, (((100.0f / r111) * r115) + 1.0f) - r115};
        float r118 = 1.0f / ((5.0f * r211) + 1.0f);
        float r119 = ((r118 * r118) * r118) * r118;
        float r120 = 1.0f - r119;
        float r121 = (r119 * r211) + (((0.1f * r120) * r120) * ((float) Math.cbrt(((double) r211) * 5.0d)));
        float r122 = CamUtils.yFromLStar(r212) / r210[1];
        double r123 = r122;
        float r215 = ((float) Math.sqrt(r123)) + 1.48f;
        float r124 = 0.725f / ((float) Math.pow(r123, 0.2d));
        float r125 = (float) Math.pow(((double) ((r117[2] * r121) * r111)) / 100.0d, 0.42d);
        float[] r126 = {(float) Math.pow(((double) ((r117[0] * r121) * r107)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r117[1] * r121) * r110)) / 100.0d, 0.42d), r125};
        float r127 = r126[0];
        float r128 = r126[1];
        return new ViewingConditions(r122, (((((r127 * 400.0f) / (r127 + 27.13f)) * 2.0f) + ((r128 * 400.0f) / (r128 + 27.13f))) + (((400.0f * r125) / (r125 + 27.13f)) * 0.05f)) * r124, r124, r124, r114, r112, r117, r121, (float) Math.pow(r121, 0.25d), r215);
    L14:
        if (r116 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        r115 = 0.0f;
        goto L16
    L9:
        r115 = (1.0f - (((float) Math.exp(((-r211) - 42.0f) / 92.0f)) * 0.2777778f)) * r112;
        goto L10
    L5:
        r113 = CamUtils.lerp(0.525f, 0.59f, (r112 - 0.8f) * 10.0f);
        goto L6
    }

    private ViewingConditions(float r100, float r101, float r102, float r103, float r104, float r105, float[] r106, float r107, float r108, float r110) {
        this.mN = r100;
        this.mAw = r101;
        this.mNbb = r102;
        this.mNcb = r103;
        this.mC = r104;
        this.mNc = r105;
        this.mRgbD = r106;
        this.mFl = r107;
        this.mFlRoot = r108;
        this.mZ = r110;
    }
}
