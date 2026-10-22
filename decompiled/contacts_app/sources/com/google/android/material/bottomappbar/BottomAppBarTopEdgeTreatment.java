package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes2.dex */
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

    public BottomAppBarTopEdgeTreatment(float r2, float r3, float r4) {
        this.fabCornerSize = -1.0f;
        this.fabMargin = r2;
        this.roundedCornerRadius = r3;
        setCradleVerticalOffset(r4);
        this.horizontalOffset = 0.0f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r24, float r25, float r26, ShapePath r27) {
        float r2 = this.fabDiameter;
        if (r2 != 0.0f) goto L6;
        r27.lineTo(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.fabMargin * 2.0f) + r2) / 2.0f;
        float r13 = r26 * this.roundedCornerRadius;
        float r14 = r25 + this.horizontalOffset;
        float r3 = (this.cradleVerticalOffset * r26) + ((1.0f - r26) * r12);
        if ((r3 / r12) < 1.0f) goto L10;
        r27.lineTo(r24, 0.0f);
        return;
    L10:
        float r4 = this.fabCornerSize;
        float r15 = r4 * r26;
        if (r4 != (-1.0f)) goto L13;
    L16:
        boolean r5 = true;
    L17:
        boolean r16 = r5;
        if (r16 == true) goto L20;
        float r6 = ROUNDED_CORNER_FAB_OFFSET;
        float r17 = 0.0f;
    L21:
        float r7 = r12 + r13;
        float r8 = r17 + r13;
        float r9 = (float) Math.sqrt((r7 * r7) - (r8 * r8));
        float r10 = r14 - r9;
        float r18 = r14 + r9;
        float r11 = (float) Math.toDegrees(Math.atan(r9 / r8));
        float r19 = (90.0f - r11) + r6;
        r27.lineTo(r10, 0.0f);
        float r20 = r13 * 2.0f;
        r27.addArc(r10 - r13, 0.0f, r10 + r13, r20, 270.0f, r11);
        if (r16 == false) goto L24;
        r27.addArc(r14 - r12, (-r12) - r17, r14 + r12, r12 - r17, 180.0f - r19, (r19 * 2.0f) - 180.0f);
    L25:
        r27.addArc(r18 - r13, 0.0f, r18 + r13, r20, 270.0f - r11, r11);
        r27.lineTo(r24, 0.0f);
        return;
    L24:
        float r21 = this.fabMargin;
        float r110 = r15 * 2.0f;
        float r22 = r14 - r12;
        r27.addArc(r22, -(r15 + r21), r22 + (r21 + r110), r21 + r15, 180.0f - r19, ((r19 * 2.0f) - 180.0f) / 2.0f);
        float r23 = r14 + r12;
        float r28 = this.fabMargin;
        r27.lineTo(r23 - ((r28 / 2.0f) + r15), r28 + r15);
        float r0 = this.fabMargin;
        r27.addArc(r23 - (r110 + r0), -(r15 + r0), r23, r0 + r15, 90.0f, r19 - 90.0f);
        goto L25
    L20:
        r17 = r3;
        r6 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r4 * 2.0f) - r2) < 0.1f) goto L16;
        r5 = false;
        goto L17
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public void setFabDiameter(float r1) {
        this.fabDiameter = r1;
    }

    void setHorizontalOffset(float r1) {
        this.horizontalOffset = r1;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    void setCradleVerticalOffset(float r2) {
        if (r2 < 0.0f) goto L7;
        this.cradleVerticalOffset = r2;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    float getFabCradleMargin() {
        return this.fabMargin;
    }

    void setFabCradleMargin(float r1) {
        this.fabMargin = r1;
    }

    float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    void setFabCradleRoundedCornerRadius(float r1) {
        this.roundedCornerRadius = r1;
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public void setFabCornerSize(float r1) {
        this.fabCornerSize = r1;
    }
}
