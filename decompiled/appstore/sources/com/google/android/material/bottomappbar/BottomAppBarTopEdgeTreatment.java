package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float r10, float r11, float r12) {
        this.fabCornerSize = -1.0f;
        this.fabMargin = r10;
        this.roundedCornerRadius = r11;
        setCradleVerticalOffset(r12);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r24, float r25, float r26, @NonNull ShapePath r27) {
        float r10 = this.fabDiameter;
        if (r10 != 0.0f) goto L6;
        r27.lineTo(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.fabMargin * 2.0f) + r10) / 2.0f;
        float r13 = r26 * this.roundedCornerRadius;
        float r14 = r25 + this.horizontalOffset;
        float r11 = (this.cradleVerticalOffset * r26) + ((1.0f - r26) * r12);
        if ((r11 / r12) < 1.0f) goto L10;
        r27.lineTo(r24, 0.0f);
        return;
    L10:
        float r15 = this.fabCornerSize;
        float r16 = r15 * r26;
        if (r15 != (-1.0f)) goto L13;
    L17:
        boolean r17 = true;
    L16:
        boolean r18 = r17;
        if (r18 == true) goto L20;
        float r19 = 1.75f;
        float r110 = 0.0f;
    L21:
        float r20 = r12 + r13;
        float r21 = r110 + r13;
        float r22 = (float) Math.sqrt((r20 * r20) - (r21 * r21));
        float r23 = r14 - r22;
        float r111 = r14 + r22;
        float r28 = (float) Math.toDegrees(Math.atan(r22 / r21));
        float r112 = (90.0f - r28) + r19;
        r27.lineTo(r23, 0.0f);
        float r29 = r13 * 2.0f;
        r27.addArc(r23 - r13, 0.0f, r23 + r13, r29, 270.0f, r28);
        if (r18 == false) goto L24;
        r27.addArc(r14 - r12, (-r12) - r110, r14 + r12, r12 - r110, 180.0f - r112, (r112 * 2.0f) - 180.0f);
    L25:
        r27.addArc(r111 - r13, 0.0f, r111 + r13, r29, 270.0f - r28, r28);
        r27.lineTo(r24, 0.0f);
        return;
    L24:
        float r30 = this.fabMargin;
        float r113 = r16 * 2.0f;
        float r31 = r14 - r12;
        r27.addArc(r31, -(r16 + r30), r31 + (r30 + r113), r30 + r16, 180.0f - r112, ((r112 * 2.0f) - 180.0f) / 2.0f);
        float r32 = r14 + r12;
        float r33 = this.fabMargin;
        r27.lineTo(r32 - ((r33 / 2.0f) + r16), r33 + r16);
        float r34 = this.fabMargin;
        r27.addArc(r32 - (r113 + r34), -(r16 + r34), r32, r34 + r16, 90.0f, r112 - 90.0f);
        goto L25
    L20:
        r110 = r11;
        r19 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r15 * 2.0f) - r10) < 0.1f) goto L17;
        r17 = false;
        goto L16
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float r10) {
        if (r10 < 0.0f) goto L7;
        this.cradleVerticalOffset = r10;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float r10) {
        this.fabCornerSize = r10;
    }

    public void setFabCradleMargin(float r10) {
        this.fabMargin = r10;
    }

    public void setFabCradleRoundedCornerRadius(float r10) {
        this.roundedCornerRadius = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float r10) {
        this.fabDiameter = r10;
    }

    public void setHorizontalOffset(float r10) {
        this.horizontalOffset = r10;
    }
}
