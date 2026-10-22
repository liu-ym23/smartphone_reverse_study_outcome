package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: SketchSmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/SketchSmoothCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "()V", "CONTROL_HANDLE_RATIO", "", "CONTROL_POINTS_RATIO", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ControlPoint;", "CORNER_MAX_RATIO", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "radius", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SketchSmoothCornerImpl extends ISmoothCornerImpl {
    private final float CONTROL_HANDLE_RATIO;
    private final ControlPoint CONTROL_POINTS_RATIO;
    private final float CORNER_MAX_RATIO;
    private final String type;

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public boolean canDraw(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public SketchSmoothCornerImpl() {
        this.CORNER_MAX_RATIO = 128.19f;
        this.CONTROL_HANDLE_RATIO = 83.62f;
        this.CONTROL_POINTS_RATIO = new ControlPoint(67.45f, 51.16f, 34.86f, 22.07f, 13.36f, 4.64f);
        this.type = "SketchSmoothCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public String getType() {
        return this.type;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public Path buildPath(float r46, float r47, float r48, float r49, float r50) {
        Path r7 = new Path();
        float r5 = r48 - r46;
        float r6 = r49 - r47;
        float r8 = Math.min(r5, r6);
        if (r50 == 0.0f) goto L17;
        if (r50 >= (r8 * 0.5f)) goto L17;
        float r9 = r50 / (r8 / 2.0f);
        float r12 = 1.0f;
        if (r9 <= 0.5f) goto L10;
        float r10 = 1.0f - (Math.min(1.0f, (r9 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r9 <= 0.6f) goto L14;
        r12 = 1.0f + (Math.min(1.0f, (r9 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r11 = r50 / 100.0f;
        float r13 = (this.CORNER_MAX_RATIO * r11) * r10;
        float r14 = (this.CONTROL_HANDLE_RATIO * r11) * r12;
        ControlPoint r19 = new ControlPoint(r11 * this.CONTROL_POINTS_RATIO.getHandleLarge(), r11 * this.CONTROL_POINTS_RATIO.getDistanceOuter(), r11 * this.CONTROL_POINTS_RATIO.getDistanceInner(), r11 * this.CONTROL_POINTS_RATIO.getHandleMedium(), r11 * this.CONTROL_POINTS_RATIO.getCurveInner(), r11 * this.CONTROL_POINTS_RATIO.getCurveOuter());
        float r15 = (r5 / 2.0f) + r46;
        Point r0 = new Point(r15, r47);
        float r16 = r48 - r13;
        Point r17 = new Point(Math.max(r15, r16), r47);
        float r18 = r48 - r14;
        Point r110 = new Point(r18, r47);
        Point r111 = new Point(r48 - r19.getHandleLarge(), r47 + r19.getCurveOuter());
        Point r112 = new Point(r48 - r19.getDistanceOuter(), r47 + r19.getCurveInner());
        Point r113 = new Point(r48 - r19.getDistanceInner(), r47 + r19.getHandleMedium());
        Point r114 = new Point(r48 - r19.getHandleMedium(), r47 + r19.getDistanceInner());
        Point r115 = new Point(r48 - r19.getCurveInner(), r47 + r19.getDistanceOuter());
        Point r116 = new Point(r48 - r19.getCurveOuter(), r47 + r19.getHandleLarge());
        float r117 = r47 + r14;
        Point r118 = new Point(r48, r117);
        float r20 = r6 / 2.0f;
        Point r119 = new Point(r48, r47 + Math.min(r20, r13));
        float r21 = r20 + r47;
        float r120 = r49 - r13;
        Point r121 = new Point(r48, Math.max(r21, r120));
        float r122 = r49 - r14;
        Point r22 = new Point(r48, r122);
        Point r23 = new Point(r48 - r19.getCurveOuter(), r49 - r19.getHandleLarge());
        Point r24 = new Point(r48 - r19.getCurveInner(), r49 - r19.getDistanceOuter());
        Point r25 = new Point(r48 - r19.getHandleMedium(), r49 - r19.getDistanceInner());
        Point r26 = new Point(r48 - r19.getDistanceInner(), r49 - r19.getHandleMedium());
        Point r27 = new Point(r48 - r19.getDistanceOuter(), r49 - r19.getCurveInner());
        Point r28 = new Point(r48 - r19.getHandleLarge(), r49 - r19.getCurveOuter());
        Point r3 = new Point(r18, r49);
        Point r123 = new Point(Math.max(r15, r16), r49);
        float r1 = r46 + r13;
        Point r124 = new Point(Math.min(r15, r1), r49);
        float r29 = r14 + r46;
        Point r4 = new Point(r29, r49);
        Point r125 = new Point(r46 + r19.getHandleLarge(), r49 - r19.getCurveOuter());
        Point r126 = new Point(r19.getDistanceOuter() + r46, r49 - r19.getCurveInner());
        Point r127 = new Point(r19.getDistanceInner() + r46, r49 - r19.getHandleMedium());
        Point r128 = new Point(r19.getHandleMedium() + r46, r49 - r19.getDistanceInner());
        Point r129 = new Point(r19.getCurveInner() + r46, r49 - r19.getDistanceOuter());
        Point r130 = new Point(r19.getCurveOuter() + r46, r49 - r19.getHandleLarge());
        Point r30 = new Point(r46, r122);
        Point r131 = new Point(r46, Math.max(r21, r120));
        Point r132 = new Point(r46, Math.min(r21, r47 + r13));
        Point r133 = new Point(r46, r117);
        Point r134 = new Point(r19.getCurveOuter() + r46, r19.getHandleLarge() + r47);
        Point r31 = new Point(r19.getCurveInner() + r46, r47 + r19.getDistanceOuter());
        Point r32 = new Point(r19.getHandleMedium() + r46, r47 + r19.getDistanceInner());
        Point r33 = new Point(r19.getDistanceInner() + r46, r47 + r19.getHandleMedium());
        Point r34 = new Point(r19.getDistanceOuter() + r46, r47 + r19.getCurveInner());
        Point r35 = new Point(r46 + r19.getHandleLarge(), r19.getCurveOuter() + r47);
        Point r36 = new Point(r29, r47);
        Point r37 = new Point(Math.min(r15, r1), r47);
        r7.moveTo(r0.getX(), r0.getY());
        r7.lineTo(r17.getX(), r17.getY());
        r7.cubicTo(r110.getX(), r110.getY(), r111.getX(), r111.getY(), r112.getX(), r112.getY());
        r7.cubicTo(r113.getX(), r113.getY(), r114.getX(), r114.getY(), r115.getX(), r115.getY());
        r7.cubicTo(r116.getX(), r116.getY(), r118.getX(), r118.getY(), r119.getX(), r119.getY());
        r7.lineTo(r121.getX(), r121.getY());
        r7.cubicTo(r22.getX(), r22.getY(), r23.getX(), r23.getY(), r24.getX(), r24.getY());
        r7.cubicTo(r25.getX(), r25.getY(), r26.getX(), r26.getY(), r27.getX(), r27.getY());
        r7.cubicTo(r28.getX(), r28.getY(), r3.getX(), r3.getY(), r123.getX(), r123.getY());
        r7.lineTo(r124.getX(), r124.getY());
        r7.cubicTo(r4.getX(), r4.getY(), r125.getX(), r125.getY(), r126.getX(), r126.getY());
        r7.cubicTo(r127.getX(), r127.getY(), r128.getX(), r128.getY(), r129.getX(), r129.getY());
        r7.cubicTo(r130.getX(), r130.getY(), r30.getX(), r30.getY(), r131.getX(), r131.getY());
        r7.lineTo(r132.getX(), r132.getY());
        r7.cubicTo(r133.getX(), r133.getY(), r134.getX(), r134.getY(), r31.getX(), r31.getY());
        r7.cubicTo(r32.getX(), r32.getY(), r33.getX(), r33.getY(), r34.getX(), r34.getY());
        r7.cubicTo(r35.getX(), r35.getY(), r36.getX(), r36.getY(), r37.getX(), r37.getY());
        r7.close();
        return r7;
    L10:
        r10 = 1.0f;
    L17:
        return buildRoundRect(r46, r47, r48, r49, r50);
    }
}
