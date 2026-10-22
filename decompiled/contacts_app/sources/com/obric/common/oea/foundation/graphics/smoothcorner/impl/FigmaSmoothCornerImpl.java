package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: FigmaSmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/FigmaSmoothCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "()V", "DEGREES_TO_RADIANS", "", "smoothness", "", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "radius", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class FigmaSmoothCornerImpl extends ISmoothCornerImpl {
    private final double DEGREES_TO_RADIANS;
    private final float smoothness;
    private final String type;

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public boolean canDraw(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public FigmaSmoothCornerImpl() {
        this.DEGREES_TO_RADIANS = 0.017453292519943295d;
        this.smoothness = 0.6f;
        this.type = "FigmaSmoothCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public String getType() {
        return this.type;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl
    public Path buildPath(float r51, float r52, float r53, float r54, float r55) {
        float r5 = r53 - r51;
        float r7 = Math.min(r5, r54 - r52);
        Path r15 = new Path();
        if (r55 == 0.0f) goto L14;
        if (r55 >= (0.5f * r7)) goto L14;
        float r9 = Math.min(r7 / 2.0f, (this.smoothness + 1.0f) * r55);
        float r8 = r7 / 4.0f;
        if (r55 <= r8) goto L10;
        float r14 = this.smoothness;
        float r10 = 1.0f - ((r55 - r8) / r8);
        float r11 = 90 * (1.0f - (r14 * r10));
        float r12 = 45 * r14;
    L11:
        float r16 = (90 - r11) / 2.0f;
        double r13 = r12 * r10;
        float r17 = (float) Math.tan(this.DEGREES_TO_RADIANS * r13);
        float r18 = ((float) Math.tan(((double) (r16 / 2.0f)) * this.DEGREES_TO_RADIANS)) * r55;
        float r3 = (float) ((Math.sin(((double) (r11 / 2.0f)) * this.DEGREES_TO_RADIANS) * ((double) r55)) * Math.sqrt(2.0d));
        float r19 = r18 * ((float) Math.cos(r13 * this.DEGREES_TO_RADIANS));
        float r0 = r19 * r17;
        float r4 = ((r9 - r3) - ((r17 + 1.0f) * r19)) / 3.0f;
        Point r20 = new Point(r51 + (r5 / 2.0f), r52);
        float r110 = r53 - r9;
        Point r6 = new Point(r110, r52);
        float r21 = r9 - (r4 * 2.0f);
        float r111 = r53 - r21;
        Point r112 = new Point(r111, r52);
        float r22 = r21 - r4;
        float r113 = r53 - r22;
        Point r114 = new Point(r113, r52);
        float r23 = r22 - r19;
        float r24 = r53 - r23;
        float r115 = r52 + r0;
        Point r116 = new Point(r24, r115);
        float r25 = r53 - r55;
        float r117 = r52 + r55;
        float r118 = r53 - r0;
        float r1 = r52 + r23;
        new Point(r118, r1);
        float r2 = r52 + r22;
        Point r119 = new Point(r53, r2);
        float r26 = r52 + r21;
        Point r120 = new Point(r53, r26);
        float r27 = r52 + r9;
        Point r121 = new Point(r53, r27);
        float r28 = r54 - r9;
        Point r122 = new Point(r53, r28);
        float r29 = r54 - r21;
        Point r123 = new Point(r53, r29);
        float r30 = r54 - r22;
        Point r124 = new Point(r53, r30);
        float r125 = r54 - r23;
        Point r31 = new Point(r118, r125);
        float r32 = r54 - r55;
        float r126 = r54 - r0;
        new Point(r24, r126);
        Point r33 = new Point(r113, r54);
        Point r34 = new Point(r111, r54);
        Point r127 = new Point(r110, r54);
        float r128 = r9 + r51;
        Point r129 = new Point(r128, r54);
        float r35 = r21 + r51;
        Point r36 = new Point(r35, r54);
        float r37 = r22 + r51;
        Point r38 = new Point(r37, r54);
        float r39 = r23 + r51;
        Point r40 = new Point(r39, r126);
        float r41 = r51 + r55;
        float r42 = r0 + r51;
        new Point(r42, r125);
        Point r43 = new Point(r51, r30);
        Point r44 = new Point(r51, r29);
        Point r130 = new Point(r51, r28);
        Point r45 = new Point(r51, r27);
        Point r46 = new Point(r51, r26);
        Point r47 = new Point(r51, r2);
        Point r48 = new Point(r42, r1);
        new Point(r39, r115);
        Point r49 = new Point(r37, r52);
        Point r50 = new Point(r35, r52);
        Point r56 = new Point(r128, r52);
        r15.moveTo(r20.getX(), r20.getY());
        r15.lineTo(r6.getX(), r6.getY());
        r15.cubicTo(r112.getX(), r112.getY(), r114.getX(), r114.getY(), r116.getX(), r116.getY());
        ISmoothCornerImpl.Companion.arcTo$foundation_standardRelease(r15, new Point(r25, r117), r55, r16 + 270.0f, 360.0f - r16);
        r15.cubicTo(r119.getX(), r119.getY(), r120.getX(), r120.getY(), r121.getX(), r121.getY());
        r15.lineTo(r122.getX(), r122.getY());
        r15.cubicTo(r123.getX(), r123.getY(), r124.getX(), r124.getY(), r31.getX(), r31.getY());
        ISmoothCornerImpl.Companion.arcTo$foundation_standardRelease(r15, new Point(r25, r32), r55, r16, 90.0f - r16);
        r15.cubicTo(r33.getX(), r33.getY(), r34.getX(), r34.getY(), r127.getX(), r127.getY());
        r15.lineTo(r129.getX(), r129.getY());
        r15.cubicTo(r36.getX(), r36.getY(), r38.getX(), r38.getY(), r40.getX(), r40.getY());
        ISmoothCornerImpl.Companion.arcTo$foundation_standardRelease(r15, new Point(r41, r32), r55, r16 + 90.0f, 180.0f - r16);
        r15.cubicTo(r43.getX(), r43.getY(), r44.getX(), r44.getY(), r130.getX(), r130.getY());
        r15.lineTo(r45.getX(), r45.getY());
        r15.cubicTo(r46.getX(), r46.getY(), r47.getX(), r47.getY(), r48.getX(), r48.getY());
        ISmoothCornerImpl.Companion.arcTo$foundation_standardRelease(r15, new Point(r41, r117), r55, r16 + 180.0f, 270.0f - r16);
        r15.cubicTo(r49.getX(), r49.getY(), r50.getX(), r50.getY(), r56.getX(), r56.getY());
        r15.close();
        return r15;
    L10:
        r10 = this.smoothness;
        r11 = 90 * (1.0f - r10);
        r12 = 45;
    L14:
        return buildRoundRect(r51, r52, r53, r54, r55);
    }
}
