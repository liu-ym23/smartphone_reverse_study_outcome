package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

/* JADX INFO: loaded from: classes17.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public VelocityMatrix() {
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet r100, float r101) {
        if (r100 == null) goto L5;
        this.mDRotate = r100.getSlope(r101);
        this.mRotate = r100.get(r101);
        return;
    }

    public void setRotationVelocity(KeyCycleOscillator r100, float r101) {
        if (r100 == null) goto L5;
        this.mDRotate = r100.getSlope(r101);
        return;
    }

    public void setScaleVelocity(KeyCycleOscillator r100, KeyCycleOscillator r101, float r102) {
        if (r100 != null) goto L5;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        this.mDScaleX = r100.getSlope(r102);
    L7:
        if (r101 != null) goto L10;
        this.mDScaleY = r101.getSlope(r102);
        return;
    }

    public void setTranslationVelocity(KeyCycleOscillator r100, KeyCycleOscillator r101, float r102) {
        if (r100 == null) goto L4;
        this.mDTranslateX = r100.getSlope(r102);
    L4:
        if (r101 == null) goto L7;
        this.mDTranslateY = r101.getSlope(r102);
        return;
    }

    public void setScaleVelocity(SplineSet r100, SplineSet r101, float r102) {
        if (r100 == null) goto L4;
        this.mDScaleX = r100.getSlope(r102);
    L4:
        if (r101 == null) goto L7;
        this.mDScaleY = r101.getSlope(r102);
        return;
    }

    public void setTranslationVelocity(SplineSet r100, SplineSet r101, float r102) {
        if (r100 == null) goto L4;
        this.mDTranslateX = r100.getSlope(r102);
    L4:
        if (r101 == null) goto L7;
        this.mDTranslateY = r101.getSlope(r102);
        return;
    }

    public void applyTransform(float r110, float r210, int r211, int r212, float[] r213) {
        float r100 = r213[0];
        float r101 = r213[1];
        float r102 = (r110 - 0.5f) * 2.0f;
        float r103 = (r210 - 0.5f) * 2.0f;
        float r104 = r100 + this.mDTranslateX;
        float r105 = r101 + this.mDTranslateY;
        float r106 = r104 + (this.mDScaleX * r102);
        float r107 = r105 + (this.mDScaleY * r103);
        float r108 = (float) Math.toRadians(this.mRotate);
        float r109 = (float) Math.toRadians(this.mDRotate);
        double r111 = r108;
        double r112 = r212 * r103;
        float r113 = r106 + (((float) ((((double) ((-r211) * r102)) * Math.sin(r111)) - (Math.cos(r111) * r112))) * r109);
        float r114 = r107 + (r109 * ((float) ((((double) (r211 * r102)) * Math.cos(r111)) - (r112 * Math.sin(r111)))));
        r213[0] = r113;
        r213[1] = r114;
    }
}
