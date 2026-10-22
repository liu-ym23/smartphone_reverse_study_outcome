package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class TransformKeyframeAnimation {
    private BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    private BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix;
    private BaseKeyframeAnimation<Integer, Integer> opacity;
    private BaseKeyframeAnimation<?, PointF> position;
    private BaseKeyframeAnimation<Float, Float> rotation;
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    private FloatKeyframeAnimation skew;
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    private BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform r3) {
        this.matrix = new Matrix();
        if (r3.getAnchorPoint() != null) goto L5;
        BaseKeyframeAnimation<PointF, PointF> r0 = null;
    L6:
        this.anchorPoint = r0;
        if (r3.getPosition() != null) goto L9;
        BaseKeyframeAnimation<PointF, PointF> r1 = null;
    L10:
        this.position = r1;
        if (r3.getScale() != null) goto L13;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r2 = null;
    L14:
        this.scale = r2;
        if (r3.getRotation() != null) goto L17;
        BaseKeyframeAnimation<Float, Float> r4 = null;
    L18:
        this.rotation = r4;
        if (r3.getSkew() != null) goto L21;
        FloatKeyframeAnimation r5 = null;
    L22:
        this.skew = r5;
        if (r5 == null) goto L25;
        this.skewMatrix1 = new Matrix();
        this.skewMatrix2 = new Matrix();
        this.skewMatrix3 = new Matrix();
        this.skewValues = new float[9];
    L27:
        if (r3.getSkewAngle() != null) goto L29;
        FloatKeyframeAnimation r6 = null;
    L30:
        this.skewAngle = r6;
        if (r3.getOpacity() == null) goto L34;
        this.opacity = r3.getOpacity().createAnimation();
    L34:
        if (r3.getStartOpacity() == null) goto L36;
        this.startOpacity = r3.getStartOpacity().createAnimation();
    L38:
        if (r3.getEndOpacity() == null) goto L40;
        this.endOpacity = r3.getEndOpacity().createAnimation();
        return;
    L40:
        this.endOpacity = null;
        return;
    L36:
        this.startOpacity = null;
        goto L38
    L29:
        r6 = (FloatKeyframeAnimation) r3.getSkewAngle().createAnimation();
        goto L30
    L25:
        this.skewMatrix1 = null;
        this.skewMatrix2 = null;
        this.skewMatrix3 = null;
        this.skewValues = null;
        goto L27
    L21:
        r5 = (FloatKeyframeAnimation) r3.getSkew().createAnimation();
        goto L22
    L17:
        r4 = r3.getRotation().createAnimation();
        goto L18
    L13:
        r2 = r3.getScale().createAnimation();
        goto L14
    L9:
        r1 = r3.getPosition().createAnimation();
        goto L10
    L5:
        r0 = r3.getAnchorPoint().createAnimation();
        goto L6
    }

    public void addAnimationsToLayer(BaseLayer r2) {
        r2.addAnimation(this.opacity);
        r2.addAnimation(this.startOpacity);
        r2.addAnimation(this.endOpacity);
        r2.addAnimation(this.anchorPoint);
        r2.addAnimation(this.position);
        r2.addAnimation(this.scale);
        r2.addAnimation(this.rotation);
        r2.addAnimation(this.skew);
        r2.addAnimation(this.skewAngle);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener r2) {
        BaseKeyframeAnimation<Integer, Integer> r0 = this.opacity;
        if (r0 == null) goto L5;
        r0.addUpdateListener(r2);
    L5:
        BaseKeyframeAnimation<?, Float> r1 = this.startOpacity;
        if (r1 == null) goto L8;
        r1.addUpdateListener(r2);
    L8:
        BaseKeyframeAnimation<?, Float> r3 = this.endOpacity;
        if (r3 == null) goto L11;
        r3.addUpdateListener(r2);
    L11:
        BaseKeyframeAnimation<PointF, PointF> r4 = this.anchorPoint;
        if (r4 == null) goto L14;
        r4.addUpdateListener(r2);
    L14:
        BaseKeyframeAnimation<?, PointF> r5 = this.position;
        if (r5 == null) goto L17;
        r5.addUpdateListener(r2);
    L17:
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r6 = this.scale;
        if (r6 == null) goto L20;
        r6.addUpdateListener(r2);
    L20:
        BaseKeyframeAnimation<Float, Float> r7 = this.rotation;
        if (r7 == null) goto L23;
        r7.addUpdateListener(r2);
    L23:
        FloatKeyframeAnimation r8 = this.skew;
        if (r8 == null) goto L26;
        r8.addUpdateListener(r2);
    L26:
        FloatKeyframeAnimation r9 = this.skewAngle;
        if (r9 == null) goto L30;
        r9.addUpdateListener(r2);
        return;
    }

    public void setProgress(float r2) {
        BaseKeyframeAnimation<Integer, Integer> r0 = this.opacity;
        if (r0 == null) goto L5;
        r0.setProgress(r2);
    L5:
        BaseKeyframeAnimation<?, Float> r1 = this.startOpacity;
        if (r1 == null) goto L8;
        r1.setProgress(r2);
    L8:
        BaseKeyframeAnimation<?, Float> r3 = this.endOpacity;
        if (r3 == null) goto L11;
        r3.setProgress(r2);
    L11:
        BaseKeyframeAnimation<PointF, PointF> r4 = this.anchorPoint;
        if (r4 == null) goto L14;
        r4.setProgress(r2);
    L14:
        BaseKeyframeAnimation<?, PointF> r5 = this.position;
        if (r5 == null) goto L17;
        r5.setProgress(r2);
    L17:
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r6 = this.scale;
        if (r6 == null) goto L20;
        r6.setProgress(r2);
    L20:
        BaseKeyframeAnimation<Float, Float> r7 = this.rotation;
        if (r7 == null) goto L23;
        r7.setProgress(r2);
    L23:
        FloatKeyframeAnimation r8 = this.skew;
        if (r8 == null) goto L26;
        r8.setProgress(r2);
    L26:
        FloatKeyframeAnimation r9 = this.skewAngle;
        if (r9 == null) goto L30;
        r9.setProgress(r2);
        return;
    }

    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        BaseKeyframeAnimation<?, PointF> r0 = this.position;
        if (r0 == null) goto L11;
        PointF r1 = r0.getValue();
        if (r1 == null) goto L11;
        if (r1.x == 0.0f) goto L9;
    L10:
        this.matrix.preTranslate(r1.x, r1.y);
        goto L11
    L9:
        if (r1.y != 0.0f) goto L10;
    L11:
        BaseKeyframeAnimation<Float, Float> r2 = this.rotation;
        if (r2 != null) goto L14;
    L20:
        FloatKeyframeAnimation r3 = this.skew;
        if (r3 == null) goto L31;
        FloatKeyframeAnimation r4 = this.skewAngle;
        if (r4 != null) goto L25;
        float r5 = 0.0f;
    L26:
        FloatKeyframeAnimation r6 = this.skewAngle;
        if (r6 != null) goto L29;
        float r7 = 1.0f;
    L30:
        float r8 = (float) Math.tan(Math.toRadians(r3.getFloatValue()));
        clearSkewValues();
        float[] r9 = this.skewValues;
        r9[0] = r5;
        r9[1] = r7;
        float r10 = -r7;
        r9[3] = r10;
        r9[4] = r5;
        r9[8] = 1.0f;
        this.skewMatrix1.setValues(r9);
        clearSkewValues();
        float[] r11 = this.skewValues;
        r11[0] = 1.0f;
        r11[3] = r8;
        r11[4] = 1.0f;
        r11[8] = 1.0f;
        this.skewMatrix2.setValues(r11);
        clearSkewValues();
        float[] r12 = this.skewValues;
        r12[0] = r5;
        r12[1] = r10;
        r12[3] = r7;
        r12[4] = r5;
        r12[8] = 1.0f;
        this.skewMatrix3.setValues(r12);
        this.skewMatrix2.preConcat(this.skewMatrix1);
        this.skewMatrix3.preConcat(this.skewMatrix2);
        this.matrix.preConcat(this.skewMatrix3);
        goto L31
    L29:
        r7 = (float) Math.sin(Math.toRadians((-r6.getFloatValue()) + 90.0f));
        goto L30
    L25:
        r5 = (float) Math.cos(Math.toRadians((-r4.getFloatValue()) + 90.0f));
    L31:
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r13 = this.scale;
        if (r13 == null) goto L38;
        ScaleXY r14 = r13.getValue();
        if (r14.getScaleX() == 1.0f) goto L36;
    L37:
        this.matrix.preScale(r14.getScaleX(), r14.getScaleY());
        goto L38
    L36:
        if (r14.getScaleY() != 1.0f) goto L37;
    L38:
        BaseKeyframeAnimation<PointF, PointF> r15 = this.anchorPoint;
        if (r15 == null) goto L48;
        PointF r16 = r15.getValue();
        if (r16 == null) goto L45;
        if (r16.x == 0.0f) goto L45;
    L46:
        this.matrix.preTranslate(-r16.x, -r16.y);
    L45:
        if (r16.y != 0.0f) goto L46;
    L48:
        return this.matrix;
    L14:
        if ((r2 instanceof ValueCallbackKeyframeAnimation) == false) goto L16;
        float r17 = r2.getValue().floatValue();
    L18:
        if (r17 == 0.0f) goto L20;
        this.matrix.preRotate(r17);
        goto L20
    L16:
        r17 = ((FloatKeyframeAnimation) r2).getFloatValue();
        goto L18
    }

    private void clearSkewValues() {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        this.skewValues[r0] = 0.0f;
        r0 = r0 + 1;
        goto L4
    }

    public Matrix getMatrixForRepeater(float r10) {
        BaseKeyframeAnimation<?, PointF> r0 = this.position;
        PointF r1 = null;
        if (r0 != null) goto L5;
        PointF r2 = null;
    L6:
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r3 = this.scale;
        if (r3 != null) goto L9;
        ScaleXY r4 = null;
    L10:
        this.matrix.reset();
        if (r2 == null) goto L13;
        this.matrix.preTranslate(r2.x * r10, r2.y * r10);
    L13:
        if (r4 == null) goto L15;
        double r5 = r10;
        this.matrix.preScale((float) Math.pow(r4.getScaleX(), r5), (float) Math.pow(r4.getScaleY(), r5));
    L15:
        BaseKeyframeAnimation<Float, Float> r6 = this.rotation;
        if (r6 == null) goto L30;
        float r7 = r6.getValue().floatValue();
        BaseKeyframeAnimation<PointF, PointF> r8 = this.anchorPoint;
        if (r8 == null) goto L21;
        r1 = r8.getValue();
    L21:
        Matrix r9 = this.matrix;
        float r11 = r7 * r10;
        float r12 = 0.0f;
        if (r1 != null) goto L24;
        float r13 = 0.0f;
    L25:
        if (r1 == null) goto L28;
        r12 = r1.y;
    L28:
        r9.preRotate(r11, r13, r12);
        goto L30
    L24:
        r13 = r1.x;
    L30:
        return this.matrix;
    L9:
        r4 = r3.getValue();
        goto L10
    L5:
        r2 = r0.getValue();
        goto L6
    }

    public <T> boolean applyValueCallback(T r4, LottieValueCallback<T> r5) {
        if (r4 != LottieProperty.TRANSFORM_ANCHOR_POINT) goto L9;
        BaseKeyframeAnimation<PointF, PointF> r6 = this.anchorPoint;
        if (r6 != null) goto L7;
        this.anchorPoint = new ValueCallbackKeyframeAnimation(r5, new PointF());
        return true;
    L7:
        r6.setValueCallback(r5);
        return true;
    L9:
        if (r4 != LottieProperty.TRANSFORM_POSITION) goto L15;
        BaseKeyframeAnimation<?, PointF> r7 = this.position;
        if (r7 != null) goto L13;
        this.position = new ValueCallbackKeyframeAnimation(r5, new PointF());
        return true;
    L13:
        r7.setValueCallback(r5);
        return true;
    L15:
        if (r4 != LottieProperty.TRANSFORM_POSITION_X) goto L20;
        BaseKeyframeAnimation<?, PointF> r0 = this.position;
        if ((r0 instanceof SplitDimensionPathKeyframeAnimation) == false) goto L20;
        ((SplitDimensionPathKeyframeAnimation) r0).setXValueCallback(r5);
        return true;
    L20:
        if (r4 != LottieProperty.TRANSFORM_POSITION_Y) goto L25;
        BaseKeyframeAnimation<?, PointF> r1 = this.position;
        if ((r1 instanceof SplitDimensionPathKeyframeAnimation) == false) goto L25;
        ((SplitDimensionPathKeyframeAnimation) r1).setYValueCallback(r5);
        return true;
    L25:
        if (r4 != LottieProperty.TRANSFORM_SCALE) goto L31;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> r8 = this.scale;
        if (r8 != null) goto L29;
        this.scale = new ValueCallbackKeyframeAnimation(r5, new ScaleXY());
        return true;
    L29:
        r8.setValueCallback(r5);
        return true;
    L31:
        if (r4 != LottieProperty.TRANSFORM_ROTATION) goto L37;
        BaseKeyframeAnimation<Float, Float> r9 = this.rotation;
        if (r9 != null) goto L35;
        this.rotation = new ValueCallbackKeyframeAnimation(r5, Float.valueOf(0.0f));
        return true;
    L35:
        r9.setValueCallback(r5);
        return true;
    L37:
        if (r4 != LottieProperty.TRANSFORM_OPACITY) goto L43;
        BaseKeyframeAnimation<Integer, Integer> r10 = this.opacity;
        if (r10 != null) goto L41;
        this.opacity = new ValueCallbackKeyframeAnimation(r5, 100);
        return true;
    L41:
        r10.setValueCallback(r5);
        return true;
    L43:
        if (r4 != LottieProperty.TRANSFORM_START_OPACITY) goto L49;
        BaseKeyframeAnimation<?, Float> r11 = this.startOpacity;
        if (r11 != null) goto L47;
        this.startOpacity = new ValueCallbackKeyframeAnimation(r5, Float.valueOf(100.0f));
        return true;
    L47:
        r11.setValueCallback(r5);
        return true;
    L49:
        if (r4 != LottieProperty.TRANSFORM_END_OPACITY) goto L55;
        BaseKeyframeAnimation<?, Float> r12 = this.endOpacity;
        if (r12 != null) goto L53;
        this.endOpacity = new ValueCallbackKeyframeAnimation(r5, Float.valueOf(100.0f));
        return true;
    L53:
        r12.setValueCallback(r5);
        return true;
    L55:
        if (r4 != LottieProperty.TRANSFORM_SKEW) goto L61;
        if (this.skew != null) goto L59;
        this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
    L59:
        this.skew.setValueCallback(r5);
        return true;
    L61:
        if (r4 == LottieProperty.TRANSFORM_SKEW_ANGLE) goto L63;
        return false;
    L63:
        if (this.skewAngle != null) goto L65;
        this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
    L65:
        this.skewAngle.setValueCallback(r5);
        return true;
    }
}
