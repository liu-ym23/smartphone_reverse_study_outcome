package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;
    private ShapeData shapeData;

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r1, List<Content> r2) {
    }

    public RoundedCornersContent(LottieDrawable r1, BaseLayer r2, RoundedCorners r3) {
        this.lottieDrawable = r1;
        this.name = r3.getName();
        BaseKeyframeAnimation<Float, Float> r4 = r3.getCornerRadius().createAnimation();
        this.roundedCorners = r4;
        r2.addAnimation(r4);
        r4.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public ShapeData modifyShape(ShapeData r19) {
        List<CubicCurveData> r0 = r19.getCurves();
        if (r0.size() > 2) goto L5;
        return r19;
    L5:
        float r2 = this.roundedCorners.getValue().floatValue();
        if (r2 != 0.0f) goto L8;
        return r19;
    L8:
        ShapeData r1 = getShapeData(r19);
        r1.setInitialPoint(r19.getInitialPoint().x, r19.getInitialPoint().y);
        List<CubicCurveData> r3 = r1.getCurves();
        boolean r4 = r19.isClosed();
        int r6 = 0;
        int r7 = 0;
    L10:
        if (r6 >= r0.size()) goto L38;
        CubicCurveData r8 = r0.get(r6);
        CubicCurveData r9 = r0.get(floorMod(r6 - 1, r0.size()));
        CubicCurveData r10 = r0.get(floorMod(r6 - 2, r0.size()));
        if (r6 != 0) goto L15;
        if (r4 == true) goto L15;
        PointF r11 = r19.getInitialPoint();
    L16:
        if (r6 != 0) goto L19;
        if (r4 == true) goto L19;
        PointF r12 = r11;
    L20:
        PointF r13 = r8.getControlPoint1();
        PointF r14 = r10.getVertex();
        PointF r15 = r8.getVertex();
        if (r19.isClosed() == true) goto L26;
        if (r6 != 0) goto L26;
        if (r6 != (r0.size() - 1)) goto L26;
        boolean r16 = true;
    L28:
        if (r12.equals(r11) == true) goto L30;
    L36:
        int r17 = r6;
        CubicCurveData r5 = r3.get(floorMod(r7 - 1, r3.size()));
        CubicCurveData r18 = r3.get(r7);
        r5.setControlPoint2(r9.getControlPoint2().x, r9.getControlPoint2().y);
        r5.setVertex(r9.getVertex().x, r9.getVertex().y);
        r18.setControlPoint1(r8.getControlPoint1().x, r8.getControlPoint1().y);
    L37:
        r7 = r7 + 1;
        r6 = r17 + 1;
        r0 = r0;
        goto L10
    L30:
        if (r13.equals(r11) == false) goto L36;
        if (r16 == true) goto L36;
        float r20 = r11.x - r14.x;
        float r21 = r11.y - r14.y;
        float r110 = r15.x - r11.x;
        float r111 = r15.y - r11.y;
        r17 = r6;
        float r22 = (float) Math.hypot(r20, r21);
        float r23 = (float) Math.hypot(r110, r111);
        float r24 = Math.min(r2 / r22, 0.5f);
        float r25 = Math.min(r2 / r23, 0.5f);
        float r26 = r11.x + ((r14.x - r11.x) * r24);
        float r27 = r11.y + ((r14.y - r11.y) * r24);
        float r28 = r11.x + ((r15.x - r11.x) * r25);
        float r112 = r11.y + ((r15.y - r11.y) * r25);
        float r29 = r26 - ((r26 - r11.x) * ROUNDED_CORNER_MAGIC_NUMBER);
        float r113 = r27 - ((r27 - r11.y) * ROUNDED_CORNER_MAGIC_NUMBER);
        float r114 = r28 - ((r28 - r11.x) * ROUNDED_CORNER_MAGIC_NUMBER);
        float r115 = r112 - ((r112 - r11.y) * ROUNDED_CORNER_MAGIC_NUMBER);
        CubicCurveData r30 = r3.get(floorMod(r7 - 1, r3.size()));
        CubicCurveData r116 = r3.get(r7);
        r30.setControlPoint2(r26, r27);
        r30.setVertex(r26, r27);
        if (r17 != 0) goto L35;
        r1.setInitialPoint(r26, r27);
    L35:
        r116.setControlPoint1(r29, r113);
        r7 = r7 + 1;
        CubicCurveData r31 = r3.get(r7);
        r116.setControlPoint2(r114, r115);
        r116.setVertex(r28, r112);
        r31.setControlPoint1(r28, r112);
    L26:
        r16 = false;
    L19:
        r12 = r9.getControlPoint2();
    L15:
        r11 = r9.getVertex();
        goto L16
    L38:
        return r1;
    }

    private ShapeData getShapeData(ShapeData r11) {
        List<CubicCurveData> r0 = r11.getCurves();
        boolean r1 = r11.isClosed();
        int r2 = r0.size() - 1;
        int r5 = 0;
    L3:
        if (r2 < 0) goto L28;
        CubicCurveData r6 = r0.get(r2);
        CubicCurveData r7 = r0.get(floorMod(r2 - 1, r0.size()));
        if (r2 != 0) goto L8;
        if (r1 == true) goto L8;
        PointF r8 = r11.getInitialPoint();
    L9:
        if (r2 != 0) goto L12;
        if (r1 == true) goto L12;
        PointF r9 = r8;
    L13:
        PointF r10 = r6.getControlPoint1();
        if (r11.isClosed() == true) goto L19;
        if (r2 != 0) goto L19;
        if (r2 != (r0.size() - 1)) goto L19;
        boolean r12 = true;
    L21:
        if (r9.equals(r8) == true) goto L23;
    L26:
        r5 = r5 + 1;
    L27:
        r2 = r2 - 1;
        goto L3
    L23:
        if (r10.equals(r8) == false) goto L26;
        if (r12 == true) goto L26;
        r5 = r5 + 2;
    L19:
        r12 = false;
    L12:
        r9 = r7.getControlPoint2();
    L8:
        r8 = r7.getVertex();
        goto L9
    L28:
        ShapeData r13 = this.shapeData;
        if (r13 != null) goto L31;
    L32:
        ArrayList r14 = new ArrayList(r5);
        int r3 = 0;
    L33:
        if (r3 >= r5) goto L35;
        r14.add(new CubicCurveData());
        r3 = r3 + 1;
        goto L33
    L35:
        this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, r14);
    L36:
        this.shapeData.setClosed(r1);
        return this.shapeData;
    L31:
        if (r13.getCurves().size() == r5) goto L36;
        goto L32
    }

    private static int floorMod(int r1, int r2) {
        return r1 - (floorDiv(r1, r2) * r2);
    }

    private static int floorDiv(int r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }
}
