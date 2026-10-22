package androidx.core.content.res;

import androidx.compose.foundation.b;

/* loaded from: classes2.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((CamUtils.yFromLStar(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
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

    private ViewingConditions(float f, float f7, float f9, float f10, float f11, float f12, float[] fArr, float f13, float f14, float f15) {
        this.mN = f;
        this.mAw = f7;
        this.mNbb = f9;
        this.mNcb = f10;
        this.mC = f11;
        this.mNc = f12;
        this.mRgbD = fArr;
        this.mFl = f13;
        this.mFlRoot = f14;
        this.mZ = f15;
    }

    public static ViewingConditions make(float[] fArr, float f, float f7, float f9, boolean z10) {
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f10 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f11 = fArr3[0] * f10;
        float f12 = fArr[1];
        float f13 = (fArr3[1] * f12) + f11;
        float f14 = fArr[2];
        float f15 = (fArr3[2] * f14) + f13;
        float[] fArr4 = fArr2[1];
        float f16 = (fArr4[2] * f14) + (fArr4[1] * f12) + (fArr4[0] * f10);
        float[] fArr5 = fArr2[2];
        float f17 = (f14 * fArr5[2]) + (f12 * fArr5[1]) + (f10 * fArr5[0]);
        float f18 = (f9 / 10.0f) + 0.8f;
        float fLerp = ((double) f18) >= 0.9d ? CamUtils.lerp(0.59f, 0.69f, (f18 - 0.9f) * 10.0f) : CamUtils.lerp(0.525f, 0.59f, (f18 - 0.8f) * 10.0f);
        float fA = z10 ? 1.0f : b.a((float) Math.exp(((-f) - 42.0f) / 92.0f), 0.2777778f, 1.0f, f18);
        double d = fA;
        if (d > 1.0d) {
            fA = 1.0f;
        } else if (d < 0.0d) {
            fA = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f15) * fA) + 1.0f) - fA, (((100.0f / f16) * fA) + 1.0f) - fA, (((100.0f / f17) * fA) + 1.0f) - fA};
        float f19 = 1.0f / ((5.0f * f) + 1.0f);
        float f20 = f19 * f19 * f19 * f19;
        float f21 = 1.0f - f20;
        float fCbrt = (0.1f * f21 * f21 * ((float) Math.cbrt(f * 5.0d))) + (f20 * f);
        float fYFromLStar = CamUtils.yFromLStar(f7) / fArr[1];
        double d6 = fYFromLStar;
        float fSqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f15) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f16) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f17) / 100.0d, 0.42d)};
        float f22 = fArr7[0];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[1];
        float f25 = (f24 * 400.0f) / (f24 + 27.13f);
        float f26 = fArr7[2];
        float[] fArr8 = {f23, f25, (400.0f * f26) / (f26 + 27.13f)};
        return new ViewingConditions(fYFromLStar, androidx.appfunctions.metadata.a.a(fArr8[2], 0.05f, (fArr8[0] * 2.0f) + fArr8[1], fPow), fPow, fPow, fLerp, f18, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
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
}
