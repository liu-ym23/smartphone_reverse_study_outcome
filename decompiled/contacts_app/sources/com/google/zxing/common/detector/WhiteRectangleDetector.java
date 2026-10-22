package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix r4) throws NotFoundException {
        this(r4, 10, r4.getWidth() / 2, r4.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix r4, int r5, int r6, int r7) throws NotFoundException {
        this.image = r4;
        int r0 = r4.getHeight();
        this.height = r0;
        int r8 = r4.getWidth();
        this.width = r8;
        int r9 = r5 / 2;
        int r1 = r6 - r9;
        this.leftInit = r1;
        int r10 = r6 + r9;
        this.rightInit = r10;
        int r2 = r7 - r9;
        this.upInit = r2;
        int r11 = r7 + r9;
        this.downInit = r11;
        if (r2 < 0) goto L9;
        if (r1 < 0) goto L9;
        if (r11 >= r0) goto L9;
        if (r10 >= r8) goto L9;
        return;
    L9:
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int r0 = this.leftInit;
        int r1 = this.rightInit;
        int r2 = this.upInit;
        int r3 = this.downInit;
        boolean r4 = false;
        int r5 = 1;
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r6 = true;
    L3:
        if (r6 == false) goto L54;
        boolean r12 = false;
        boolean r13 = true;
    L5:
        if (r13 == true) goto L8;
        if (r7 == false) goto L8;
    L15:
        if (r1 >= this.width) goto L16;
        boolean r14 = true;
    L18:
        if (r14 == true) goto L21;
        if (r8 == false) goto L21;
    L28:
        if (r3 >= this.height) goto L16;
        boolean r15 = true;
    L31:
        if (r15 == true) goto L33;
        if (r9 == false) goto L33;
    L39:
        if (r0 < 0) goto L16;
        r6 = r12;
        boolean r16 = true;
    L42:
        if (r16 == true) goto L44;
        if (r11 == false) goto L44;
    L50:
        if (r2 < 0) goto L16;
        if (r6 == false) goto L3;
        r10 = true;
    L44:
        if (r2 < 0) goto L50;
        r16 = containsBlackPoint(r0, r1, r2, true);
        if (r16 == true) goto L47;
        if (r11 == true) goto L42;
        r2 = r2 - 1;
        goto L42
    L47:
        r2 = r2 - 1;
        r6 = true;
        r11 = true;
    L33:
        if (r0 < 0) goto L39;
        r15 = containsBlackPoint(r2, r3, r0, false);
        if (r15 == true) goto L36;
        if (r9 == true) goto L31;
        r0 = r0 - 1;
        goto L31
    L36:
        r0 = r0 - 1;
        r9 = true;
        r12 = true;
    L21:
        if (r3 >= this.height) goto L28;
        r14 = containsBlackPoint(r0, r1, r3, true);
        if (r14 == true) goto L24;
        if (r8 == true) goto L18;
        r3 = r3 + 1;
        goto L18
    L24:
        r3 = r3 + 1;
        r8 = true;
        r12 = true;
    L16:
        r4 = true;
    L8:
        if (r1 >= this.width) goto L15;
        r13 = containsBlackPoint(r2, r3, r1, false);
        if (r13 == true) goto L11;
        if (r7 == true) goto L5;
        r1 = r1 + 1;
        goto L5
    L11:
        r1 = r1 + 1;
        r7 = true;
        r12 = true;
    L54:
        if (r4 == true) goto L86;
        if (r10 == false) goto L86;
        int r17 = r1 - r0;
        ResultPoint r18 = null;
        int r19 = 1;
        ResultPoint r20 = null;
    L57:
        if (r20 != null) goto L60;
        if (r19 >= r17) goto L60;
        r20 = getBlackPointOnSegment(r0, r3 - r19, r0 + r19, r3);
        r19 = r19 + 1;
    L60:
        if (r20 == null) goto L84;
        int r21 = 1;
        ResultPoint r22 = null;
    L62:
        if (r22 != null) goto L65;
        if (r21 >= r17) goto L65;
        r22 = getBlackPointOnSegment(r0, r2 + r21, r0 + r21, r2);
        r21 = r21 + 1;
    L65:
        if (r22 == null) goto L82;
        int r23 = 1;
        ResultPoint r24 = null;
    L67:
        if (r24 != null) goto L70;
        if (r23 >= r17) goto L70;
        r24 = getBlackPointOnSegment(r1, r2 + r23, r1 - r23, r2);
        r23 = r23 + 1;
    L70:
        if (r24 == null) goto L80;
    L71:
        if (r18 != null) goto L74;
        if (r5 >= r17) goto L74;
        r18 = getBlackPointOnSegment(r1, r3 - r5, r1 - r5, r3);
        r5 = r5 + 1;
    L74:
        if (r18 == null) goto L78;
        return centerEdges(r18, r20, r24, r22);
    L78:
        throw NotFoundException.getNotFoundInstance();
    L80:
        throw NotFoundException.getNotFoundInstance();
    L82:
        throw NotFoundException.getNotFoundInstance();
    L84:
        throw NotFoundException.getNotFoundInstance();
    L86:
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float r6, float r7, float r8, float r9) {
        int r0 = MathUtils.round(MathUtils.distance(r6, r7, r8, r9));
        float r1 = r0;
        float r10 = (r8 - r6) / r1;
        float r11 = (r9 - r7) / r1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        float r3 = r2;
        int r4 = MathUtils.round((r3 * r10) + r6);
        int r5 = MathUtils.round((r3 * r11) + r7);
        if (this.image.get(r4, r5) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return new ResultPoint(r4, r5);
    L9:
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint r11, ResultPoint r12, ResultPoint r13, ResultPoint r14) {
        float r0 = r11.getX();
        float r15 = r11.getY();
        float r1 = r12.getX();
        float r16 = r12.getY();
        float r2 = r13.getX();
        float r17 = r13.getY();
        float r3 = r14.getX();
        float r18 = r14.getY();
        if (r0 >= (this.width / 2.0f)) goto L7;
        return new ResultPoint[]{new ResultPoint(r3 - 1.0f, r18 + 1.0f), new ResultPoint(r1 + 1.0f, r16 + 1.0f), new ResultPoint(r2 - 1.0f, r17 - 1.0f), new ResultPoint(r0 + 1.0f, r15 - 1.0f)};
    L7:
        return new ResultPoint[]{new ResultPoint(r3 + 1.0f, r18 + 1.0f), new ResultPoint(r1 + 1.0f, r16 - 1.0f), new ResultPoint(r2 - 1.0f, r17 + 1.0f), new ResultPoint(r0 - 1.0f, r15 - 1.0f)};
    }

    private boolean containsBlackPoint(int r2, int r3, int r4, boolean r5) {
        if (r5 == false) goto L9;
    L4:
        if (r2 > r3) goto L14;
        if (this.image.get(r2, r4) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return true;
    L14:
        return false;
    L9:
        if (r2 > r3) goto L20;
        if (this.image.get(r4, r2) == true) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return true;
    L20:
        return false;
    }
}
