package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = null;
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    static final class Point {
        private final int x;
        private final int y;

        ResultPoint toResultPoint() {
            return new ResultPoint(getX(), getY());
        }

        Point(int r1, int r2) {
            this.x = r1;
            this.y = r2;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }

        public String toString() {
            return "<" + this.x + ' ' + this.y + '>';
        }
    }

    public Detector(BitMatrix r1) {
        this.image = r1;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        return detect(false);
    }

    public AztecDetectorResult detect(boolean r14) throws NotFoundException {
        ResultPoint[] r6 = getBullsEyeCorners(getMatrixCenter());
        if (r14 == false) goto L5;
        ResultPoint r1 = r6[0];
        r6[0] = r6[2];
        r6[2] = r1;
    L5:
        extractParameters(r6);
        BitMatrix r2 = this.image;
        int r0 = this.shift;
        return new AztecDetectorResult(sampleGrid(r2, r6[r0 % 4], r6[(r0 + 1) % 4], r6[(r0 + 2) % 4], r6[(r0 + 3) % 4]), getMatrixCornerPoints(r6), this.compact, this.nbDataBlocks, this.nbLayers);
    }

    private void extractParameters(ResultPoint[] r10) throws NotFoundException {
        int r0 = 0;
        if (isValid(r10[0]) == false) goto L24;
        if (isValid(r10[1]) == false) goto L24;
        if (isValid(r10[2]) == false) goto L24;
        if (isValid(r10[3]) == false) goto L24;
        int r4 = this.nbCenterLayers * 2;
        int[] r6 = {sampleLine(r10[0], r10[1], r4), sampleLine(r10[1], r10[2], r4), sampleLine(r10[2], r10[3], r4), sampleLine(r10[3], r10[0], r4)};
        this.shift = getRotation(r6, r4);
        long r2 = 0;
    L11:
        if (r0 >= 4) goto L17;
        int r11 = r6[(this.shift + r0) % 4];
        if (this.compact == false) goto L15;
        long r3 = r2 << 7;
        long r7 = (r11 >> 1) & WorkQueueKt.MASK;
    L16:
        r2 = r3 + r7;
        r0 = r0 + 1;
        goto L11
    L15:
        r3 = r2 << 10;
        r7 = ((r11 >> 2) & 992) + ((r11 >> 1) & 31);
        goto L16
    L17:
        int r12 = getCorrectedParameterData(r2, this.compact);
        if (this.compact == false) goto L21;
        this.nbLayers = (r12 >> 6) + 1;
        this.nbDataBlocks = (r12 & 63) + 1;
        return;
    L21:
        this.nbLayers = (r12 >> 11) + 1;
        this.nbDataBlocks = (r12 & 2047) + 1;
        return;
    L24:
        throw NotFoundException.getNotFoundInstance();
    }

    static {
        EXPECTED_CORNER_BITS = new int[]{3808, 476, 2107, 1799};
    }

    private static int getRotation(int[] r6, int r7) throws NotFoundException {
        int r0 = r6.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L6;
        int r5 = r6[r2];
        r3 = (r3 << 3) + (((r5 >> (r7 - 2)) << 1) + (r5 & 1));
        r2 = r2 + 1;
        goto L4
    L6:
        int r8 = ((r3 & 1) << 11) + (r3 >> 1);
    L8:
        if (r1 >= 4) goto L14;
        if (Integer.bitCount(EXPECTED_CORNER_BITS[r1] ^ r8) <= 2) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r1;
    L14:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getCorrectedParameterData(long r5, boolean r7) throws NotFoundException {
        if (r7 == false) goto L5;
        int r8 = 7;
        int r1 = 2;
    L6:
        int r2 = r8 - r1;
        int[] r3 = new int[r8];
        int r9 = r8 - 1;
    L7:
        if (r9 < 0) goto L16;
        r3[r9] = ((int) r5) & 15;
        r5 = r5 >> 4;
        r9 = r9 - 1;
        goto L7
    L16:
        new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(r3, r2);     // Catch: ReedSolomonException -> L14
        int r6 = 0;
        int r10 = 0;
    L11:
        if (r6 >= r1) goto L13;
        r10 = (r10 << 4) + r3[r6];
        r6 = r6 + 1;
        goto L11
    L13:
        return r10;
    L15:
        throw NotFoundException.getNotFoundInstance();
    L5:
        r8 = 10;
        r1 = 4;
        goto L6
    }

    private ResultPoint[] getBullsEyeCorners(Point r15) throws NotFoundException {
        this.nbCenterLayers = 1;
        Point r1 = r15;
        Point r2 = r1;
        Point r3 = r2;
        boolean r4 = true;
    L4:
        if (this.nbCenterLayers >= 9) goto L14;
        Point r6 = getFirstDifferent(r15, r4, 1, -1);
        Point r8 = getFirstDifferent(r1, r4, 1, 1);
        Point r9 = getFirstDifferent(r2, r4, -1, 1);
        Point r5 = getFirstDifferent(r3, r4, -1, -1);
        if (this.nbCenterLayers <= 2) goto L13;
        double r10 = (distance(r5, r6) * this.nbCenterLayers) / (distance(r3, r15) * (this.nbCenterLayers + 2));
        if (r10 < 0.75d) goto L14;
        if (r10 > 1.25d) goto L14;
        if (isWhiteOrBlackRectangle(r6, r8, r9, r5) == false) goto L14;
    L13:
        r4 = !r4;
        this.nbCenterLayers++;
        r3 = r5;
        r15 = r6;
        r1 = r8;
        r2 = r9;
    L14:
        int r7 = this.nbCenterLayers;
        if (r7 == 5) goto L22;
        if (r7 == 7) goto L22;
        throw NotFoundException.getNotFoundInstance();
    L22:
        if (r7 != 5) goto L24;
        boolean r11 = true;
    L25:
        this.compact = r11;
        ResultPoint[] r12 = {new ResultPoint(r15.getX() + 0.5f, r15.getY() - 0.5f), new ResultPoint(r1.getX() + 0.5f, r1.getY() + 0.5f), new ResultPoint(r2.getX() - 0.5f, r2.getY() + 0.5f), new ResultPoint(r3.getX() - 0.5f, r3.getY() - 0.5f)};
        int r14 = this.nbCenterLayers;
        return expandSquare(r12, (r14 * 2) - 3, r14 * 2);
    L24:
        r11 = false;
        goto L25
    }

    private Point getMatrixCenter() {
        ResultPoint[] r5 = new WhiteRectangleDetector(this.image).detect();     // Catch: NotFoundException -> L5
        ResultPoint r6 = r5[0];     // Catch: NotFoundException -> L5
        ResultPoint r7 = r5[1];     // Catch: NotFoundException -> L5
        ResultPoint r8 = r5[2];     // Catch: NotFoundException -> L5
        ResultPoint r9 = r5[3];     // Catch: NotFoundException -> L5
    L6:
        int r10 = MathUtils.round((((r6.getX() + r9.getX()) + r7.getX()) + r8.getX()) / 4.0f);
        int r11 = MathUtils.round((((r6.getY() + r9.getY()) + r7.getY()) + r8.getY()) / 4.0f);
        ResultPoint[] r12 = new WhiteRectangleDetector(this.image, 15, r10, r11).detect();     // Catch: NotFoundException -> L9
        ResultPoint r13 = r12[0];     // Catch: NotFoundException -> L9
        ResultPoint r14 = r12[1];     // Catch: NotFoundException -> L9
        ResultPoint r1 = r12[2];     // Catch: NotFoundException -> L9
        ResultPoint r15 = r12[3];     // Catch: NotFoundException -> L9
    L11:
        return new Point(MathUtils.round((((r13.getX() + r15.getX()) + r14.getX()) + r1.getX()) / 4.0f), MathUtils.round((((r13.getY() + r15.getY()) + r14.getY()) + r1.getY()) / 4.0f));
    L9:
        int r2 = r10 + 7;
        int r16 = r11 - 7;
        r13 = getFirstDifferent(new Point(r2, r16), false, 1, -1).toResultPoint();
        int r17 = r11 + 7;
        r14 = getFirstDifferent(new Point(r2, r17), false, 1, 1).toResultPoint();
        int r18 = r10 - 7;
        r1 = getFirstDifferent(new Point(r18, r17), false, -1, 1).toResultPoint();
        r15 = getFirstDifferent(new Point(r18, r16), false, -1, -1).toResultPoint();
    L5:
        int r19 = this.image.getWidth() / 2;
        int r20 = this.image.getHeight() / 2;
        int r21 = r19 + 7;
        int r22 = r20 - 7;
        ResultPoint r23 = getFirstDifferent(new Point(r21, r22), false, 1, -1).toResultPoint();
        int r24 = r20 + 7;
        ResultPoint r25 = getFirstDifferent(new Point(r21, r24), false, 1, 1).toResultPoint();
        int r26 = r19 - 7;
        ResultPoint r27 = getFirstDifferent(new Point(r26, r24), false, -1, 1).toResultPoint();
        r9 = getFirstDifferent(new Point(r26, r22), false, -1, -1).toResultPoint();
        r8 = r27;
        r6 = r23;
        r7 = r25;
        goto L6
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] r2) {
        return expandSquare(r2, this.nbCenterLayers * 2, getDimension());
    }

    private BitMatrix sampleGrid(BitMatrix r21, ResultPoint r22, ResultPoint r23, ResultPoint r24, ResultPoint r25) throws NotFoundException {
        GridSampler r0 = GridSampler.getInstance();
        int r4 = getDimension();
        float r6 = r4 / 2.0f;
        int r8 = this.nbCenterLayers;
        float r5 = r6 - r8;
        float r7 = r6 + r8;
        return r0.sampleGrid(r21, r4, r4, r5, r5, r7, r5, r7, r7, r5, r7, r22.getX(), r22.getY(), r23.getX(), r23.getY(), r24.getX(), r24.getY(), r25.getX(), r25.getY());
    }

    private int sampleLine(ResultPoint r8, ResultPoint r9, int r10) {
        float r0 = distance(r8, r9);
        float r1 = r0 / r10;
        float r2 = r8.getX();
        float r3 = r8.getY();
        float r4 = ((r9.getX() - r8.getX()) * r1) / r0;
        float r5 = (r1 * (r9.getY() - r8.getY())) / r0;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        float r6 = r11;
        if (this.image.get(MathUtils.round((r6 * r4) + r2), MathUtils.round((r6 * r5) + r3)) == false) goto L7;
        r12 = r12 | (1 << ((r10 - r11) - 1));
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        return r12;
    }

    private boolean isWhiteOrBlackRectangle(Point r3, Point r4, Point r5, Point r6) {
        Point r0 = new Point(r3.getX() - 3, r3.getY() + 3);
        Point r7 = new Point(r4.getX() - 3, r4.getY() - 3);
        Point r8 = new Point(r5.getX() + 3, r5.getY() - 3);
        Point r9 = new Point(r6.getX() + 3, r6.getY() + 3);
        int r10 = getColor(r9, r0);
        if (r10 != 0) goto L6;
        return false;
    L6:
        if (getColor(r0, r7) == r10) goto L9;
        return false;
    L9:
        if (getColor(r7, r8) == r10) goto L12;
        return false;
    L12:
        if (getColor(r8, r9) != r10) goto L15;
        return true;
    L15:
        return false;
    }

    private int getColor(Point r12, Point r13) {
        float r0 = distance(r12, r13);
        float r1 = (r13.getX() - r12.getX()) / r0;
        float r14 = (r13.getY() - r12.getY()) / r0;
        float r2 = r12.getX();
        float r3 = r12.getY();
        boolean r15 = this.image.get(r12.getX(), r12.getY());
        int r4 = (int) Math.ceil(r0);
        boolean r5 = false;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r6 >= r4) goto L8;
        r2 = r2 + r1;
        r3 = r3 + r14;
        if (this.image.get(MathUtils.round(r2), MathUtils.round(r3)) == r15) goto L7;
        r7 = r7 + 1;
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        float r11 = r7 / r0;
        if (r11 <= 0.1f) goto L14;
        if (r11 >= 0.9f) goto L14;
        return 0;
    L14:
        if (r11 > 0.1f) goto L16;
        r5 = true;
    L16:
        if (r5 != r15) goto L18;
        return 1;
    L18:
        return -1;
    }

    private Point getFirstDifferent(Point r3, boolean r4, int r5, int r6) {
        int r0 = r3.getX() + r5;
        int r7 = r3.getY();
    L3:
        r7 = r7 + r6;
        if (isValid(r0, r7) == false) goto L8;
        if (this.image.get(r0, r7) != r4) goto L8;
        r0 = r0 + r5;
    L8:
        int r1 = r0 - r5;
        int r8 = r7 - r6;
    L10:
        if (isValid(r1, r8) == false) goto L14;
        if (this.image.get(r1, r8) != r4) goto L14;
        r1 = r1 + r5;
    L14:
        int r2 = r1 - r5;
    L16:
        if (isValid(r2, r8) == false) goto L21;
        if (this.image.get(r2, r8) != r4) goto L21;
        r8 = r8 + r6;
    L21:
        return new Point(r2, r8 - r6);
    }

    private static ResultPoint[] expandSquare(ResultPoint[] r10, float r11, float r12) {
        float r13 = r12 / (r11 * 2.0f);
        float r1 = r10[0].getX() - r10[2].getX();
        float r3 = r10[0].getY() - r10[2].getY();
        float r4 = (r10[0].getX() + r10[2].getX()) / 2.0f;
        float r5 = (r10[0].getY() + r10[2].getY()) / 2.0f;
        float r2 = r1 * r13;
        float r6 = r3 * r13;
        ResultPoint r7 = new ResultPoint(r4 + r2, r5 + r6);
        ResultPoint r8 = new ResultPoint(r4 - r2, r5 - r6);
        float r9 = r10[1].getX() - r10[3].getX();
        float r14 = r10[1].getY() - r10[3].getY();
        float r15 = (r10[1].getX() + r10[3].getX()) / 2.0f;
        float r16 = (r10[1].getY() + r10[3].getY()) / 2.0f;
        float r17 = r9 * r13;
        float r18 = r13 * r14;
        return new ResultPoint[]{r7, new ResultPoint(r15 + r17, r16 + r18), r8, new ResultPoint(r15 - r17, r16 - r18)};
    }

    private boolean isValid(int r2, int r3) {
        if (r2 >= 0) goto L4;
        return false;
    L4:
        if (r2 >= this.image.getWidth()) goto L12;
        if (r3 > 0) goto L7;
        return false;
    L7:
        if (r3 >= this.image.getHeight()) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    private boolean isValid(ResultPoint r2) {
        return isValid(MathUtils.round(r2.getX()), MathUtils.round(r2.getY()));
    }

    private static float distance(Point r2, Point r3) {
        return MathUtils.distance(r2.getX(), r2.getY(), r3.getX(), r3.getY());
    }

    private static float distance(ResultPoint r2, ResultPoint r3) {
        return MathUtils.distance(r2.getX(), r2.getY(), r3.getX(), r3.getY());
    }

    private int getDimension() {
        if (this.compact == true) goto L5;
        int r2 = this.nbLayers;
        if (r2 > 4) goto L11;
        return (r2 * 4) + 15;
    L11:
        return ((r2 * 4) + ((((r2 - 4) / 8) + 1) * 2)) + 15;
    L5:
        return (this.nbLayers * 4) + 11;
    }
}
