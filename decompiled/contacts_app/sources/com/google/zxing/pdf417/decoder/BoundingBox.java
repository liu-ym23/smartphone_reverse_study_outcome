package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes3.dex */
final class BoundingBox {
    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;

    BoundingBox(BitMatrix r1, ResultPoint r2, ResultPoint r3, ResultPoint r4, ResultPoint r5) throws NotFoundException {
        if (r2 != null) goto L5;
        if (r4 != null) goto L5;
    L13:
        throw NotFoundException.getNotFoundInstance();
    L5:
        if (r3 != null) goto L7;
        if (r5 == null) goto L13;
    L7:
        if (r2 == null) goto L9;
        if (r3 == null) goto L13;
    L9:
        if (r4 == null) goto L14;
        if (r5 == null) goto L13;
    L14:
        init(r1, r2, r3, r4, r5);
    }

    BoundingBox(BoundingBox r7) {
        init(r7.image, r7.topLeft, r7.bottomLeft, r7.topRight, r7.bottomRight);
    }

    private void init(BitMatrix r1, ResultPoint r2, ResultPoint r3, ResultPoint r4, ResultPoint r5) {
        this.image = r1;
        this.topLeft = r2;
        this.bottomLeft = r3;
        this.topRight = r4;
        this.bottomRight = r5;
        calculateMinMaxValues();
    }

    static BoundingBox merge(BoundingBox r7, BoundingBox r8) throws NotFoundException {
        if (r7 != null) goto L4;
        return r8;
    L4:
        if (r8 != null) goto L7;
        return r7;
    L7:
        return new BoundingBox(r7.image, r7.topLeft, r7.bottomLeft, r8.topRight, r8.bottomRight);
    }

    BoundingBox addMissingRows(int r13, int r14, boolean r15) throws NotFoundException {
        ResultPoint r0 = this.topLeft;
        ResultPoint r1 = this.bottomLeft;
        ResultPoint r2 = this.topRight;
        ResultPoint r3 = this.bottomRight;
        if (r13 <= 0) goto L14;
        if (r15 == false) goto L6;
        ResultPoint r4 = r0;
    L7:
        int r5 = ((int) r4.getY()) - r13;
        if (r5 >= 0) goto L10;
        r5 = 0;
    L10:
        ResultPoint r16 = new ResultPoint(r4.getX(), r5);
        if (r15 == false) goto L13;
        ResultPoint r8 = r16;
    L15:
        ResultPoint r10 = r2;
    L16:
        if (r14 <= 0) goto L27;
        if (r15 == false) goto L19;
        ResultPoint r17 = this.bottomLeft;
    L20:
        int r6 = ((int) r17.getY()) + r14;
        if (r6 < this.image.getHeight()) goto L23;
        r6 = this.image.getHeight() - 1;
    L23:
        ResultPoint r18 = new ResultPoint(r17.getX(), r6);
        if (r15 == false) goto L26;
        ResultPoint r9 = r18;
    L28:
        ResultPoint r11 = r3;
    L29:
        calculateMinMaxValues();
        return new BoundingBox(this.image, r8, r9, r10, r11);
    L26:
        r11 = r18;
        r9 = r1;
        goto L29
    L19:
        r17 = this.bottomRight;
        goto L20
    L27:
        r9 = r1;
        goto L28
    L13:
        r10 = r16;
        r8 = r0;
        goto L16
    L6:
        r4 = r2;
        goto L7
    L14:
        r8 = r0;
        goto L15
    }

    private void calculateMinMaxValues() {
        if (this.topLeft != null) goto L6;
        this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
        this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
    L8:
        this.minX = (int) Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int) Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int) Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int) Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
        return;
    L6:
        if (this.topRight != null) goto L8;
        this.topRight = new ResultPoint(this.image.getWidth() - 1, this.topLeft.getY());
        this.bottomRight = new ResultPoint(this.image.getWidth() - 1, this.bottomLeft.getY());
        goto L8
    }

    int getMinX() {
        return this.minX;
    }

    int getMaxX() {
        return this.maxX;
    }

    int getMinY() {
        return this.minY;
    }

    int getMaxY() {
        return this.maxY;
    }

    ResultPoint getTopLeft() {
        return this.topLeft;
    }

    ResultPoint getTopRight() {
        return this.topRight;
    }

    ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
