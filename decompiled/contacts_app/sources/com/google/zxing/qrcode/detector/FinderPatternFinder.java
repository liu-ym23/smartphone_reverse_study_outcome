package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.detector.FinderPatternFinder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ CenterComparator(float r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FinderPattern r1, FinderPattern r2) {
            return compare2(r1, r2);
        }

        private CenterComparator(float r1) {
            this.average = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FinderPattern r3, FinderPattern r4) {
            if (r4.getCount() != r3.getCount()) goto L15;
            float r5 = Math.abs(r4.getEstimatedModuleSize() - this.average);
            float r2 = Math.abs(r3.getEstimatedModuleSize() - this.average);
            if (r5 >= r2) goto L9;
            return 1;
        L9:
            if (r5 != r2) goto L12;
            return 0;
        L12:
            return -1;
        L15:
            return r4.getCount() - r3.getCount();
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        /* synthetic */ FurthestFromAverageComparator(float r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FinderPattern r1, FinderPattern r2) {
            return compare2(r1, r2);
        }

        private FurthestFromAverageComparator(float r1) {
            this.average = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FinderPattern r2, FinderPattern r3) {
            float r4 = Math.abs(r3.getEstimatedModuleSize() - this.average);
            float r1 = Math.abs(r2.getEstimatedModuleSize() - this.average);
            if (r4 >= r1) goto L7;
            return -1;
        L7:
            if (r4 != r1) goto L10;
            return 0;
        L10:
            return 1;
        }
    }

    public FinderPatternFinder(BitMatrix r2) {
        this(r2, null);
    }

    public FinderPatternFinder(BitMatrix r1, ResultPointCallback r2) {
        this.image = r1;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = r2;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> r15) throws NotFoundException {
        if (r15 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r15 != null) goto L10;
    L12:
        boolean r16 = false;
    L13:
        int r3 = this.image.getHeight();
        int r4 = this.image.getWidth();
        int r5 = (r3 * 3) / 228;
        if (r5 < 3) goto L16;
        if (r2 == true) goto L16;
    L17:
        int[] r6 = new int[5];
        int r7 = r5 - 1;
        boolean r8 = false;
    L18:
        if (r7 >= r3) goto L56;
        if (r8 == true) goto L56;
        r6[0] = 0;
        r6[1] = 0;
        r6[2] = 0;
        r6[3] = 0;
        r6[4] = 0;
        int r11 = 0;
        int r12 = 0;
    L21:
        if (r11 >= r4) goto L49;
        if (this.image.get(r11, r7) == false) goto L29;
        if ((r12 & 1) != 1) goto L27;
        r12 = r12 + 1;
    L27:
        r6[r12] = r6[r12] + 1;
    L47:
        r11 = r11 + 1;
        goto L21
    L29:
        if ((r12 & 1) != 0) goto L46;
        if (r12 == 4) goto L32;
        r12 = r12 + 1;
        r6[r12] = r6[r12] + 1;
        goto L47
    L32:
        if (foundPatternCross(r6) == true) goto L34;
        r6[0] = r6[2];
        r6[1] = r6[3];
        r6[2] = r6[4];
        r6[3] = 1;
        r6[4] = 0;
    L44:
        r12 = 3;
        goto L47
    L34:
        if (handlePossibleCenter(r6, r7, r11, r16) == true) goto L36;
        r6[0] = r6[2];
        r6[1] = r6[3];
        r6[2] = r6[4];
        r6[3] = 1;
        r6[4] = 0;
        goto L44
    L36:
        if (this.hasSkipped == false) goto L38;
        r8 = haveMultiplyConfirmedCenters();
    L41:
        r6[0] = 0;
        r6[1] = 0;
        r6[2] = 0;
        r6[3] = 0;
        r6[4] = 0;
        r12 = 0;
        r5 = 2;
        goto L47
    L38:
        int r9 = findRowSkip();
        int r13 = r6[2];
        if (r9 <= r13) goto L41;
        r7 = r7 + ((r9 - r13) - 2);
        r11 = r4 - 1;
        goto L41
    L46:
        r6[r12] = r6[r12] + 1;
        goto L47
    L49:
        if (foundPatternCross(r6) == false) goto L55;
        if (handlePossibleCenter(r6, r7, r4, r16) == false) goto L55;
        r5 = r6[0];
        if (this.hasSkipped == false) goto L55;
        r8 = haveMultiplyConfirmedCenters();
    L55:
        r7 = r7 + r5;
    L56:
        FinderPattern[] r14 = selectBestPatterns();
        ResultPoint.orderBestPatterns(r14);
        return new FinderPatternInfo(r14);
    L16:
        r5 = 3;
        goto L17
    L10:
        if (r15.containsKey(DecodeHintType.PURE_BARCODE) == false) goto L12;
        r16 = true;
        goto L13
    L5:
        if (r15.containsKey(DecodeHintType.TRY_HARDER) == false) goto L7;
        r2 = true;
        goto L8
    }

    private static float centerFromEnd(int[] r1, int r2) {
        return ((r2 - r1[4]) - r1[3]) - (r1[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] r7) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 5) goto L10;
        int r3 = r7[r1];
        if (r3 == 0) goto L7;
        r2 = r2 + r3;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r2 >= 7) goto L12;
        return false;
    L12:
        float r4 = r2 / 7.0f;
        float r5 = r4 / 2.0f;
        if (Math.abs(r4 - r7[0]) < r5) goto L15;
    L23:
        return false;
    L15:
        if (Math.abs(r4 - r7[1]) >= r5) goto L23;
        if (Math.abs((r4 * 3.0f) - r7[2]) >= (3.0f * r5)) goto L23;
        if (Math.abs(r4 - r7[3]) >= r5) goto L23;
        if (Math.abs(r4 - r7[4]) >= r5) goto L23;
        return true;
    }

    private int[] getCrossCheckStateCount() {
        int[] r2 = this.crossCheckStateCount;
        r2[0] = 0;
        r2[1] = 0;
        r2[2] = 0;
        r2[3] = 0;
        r2[4] = 0;
        return r2;
    }

    private boolean crossCheckDiagonal(int r17, int r18, int r19, int r20) {
        int[] r4 = getCrossCheckStateCount();
        int r6 = 0;
    L4:
        if (r17 < r6) goto L9;
        if (r18 < r6) goto L9;
        if (this.image.get(r18 - r6, r17 - r6) == false) goto L9;
        r4[2] = r4[2] + 1;
        r6 = r6 + 1;
    L9:
        if (r17 < r6) goto L78;
        if (r18 < r6) goto L78;
    L12:
        if (r17 < r6) goto L19;
        if (r18 < r6) goto L19;
        if (this.image.get(r18 - r6, r17 - r6) == true) goto L19;
        int r9 = r4[1];
        if (r9 > r19) goto L19;
        r4[1] = r9 + 1;
        r6 = r6 + 1;
    L19:
        if (r17 < r6) goto L78;
        if (r18 < r6) goto L78;
        if (r4[1] > r19) goto L78;
    L24:
        if (r17 < r6) goto L32;
        if (r18 < r6) goto L32;
        if (this.image.get(r18 - r6, r17 - r6) == false) goto L32;
        int r10 = r4[0];
        if (r10 > r19) goto L32;
        r4[0] = r10 + 1;
        r6 = r6 + 1;
    L32:
        if (r4[0] <= r19) goto L34;
        return false;
    L34:
        int r7 = this.image.getHeight();
        int r11 = this.image.getWidth();
        int r12 = 1;
    L35:
        int r13 = r17 + r12;
        if (r13 >= r7) goto L42;
        int r14 = r18 + r12;
        if (r14 >= r11) goto L42;
        if (this.image.get(r14, r13) == false) goto L42;
        r4[2] = r4[2] + 1;
        r12 = r12 + 1;
    L42:
        if (r13 >= r7) goto L78;
        if ((r18 + r12) >= r11) goto L78;
    L46:
        int r15 = r17 + r12;
        if (r15 >= r7) goto L55;
        int r16 = r18 + r12;
        if (r16 >= r11) goto L55;
        if (this.image.get(r16, r15) == true) goto L55;
        int r110 = r4[3];
        if (r110 >= r19) goto L55;
        r4[3] = r110 + 1;
        r12 = r12 + 1;
    L55:
        if (r15 >= r7) goto L78;
        if ((r18 + r12) >= r11) goto L78;
        if (r4[3] >= r19) goto L78;
    L61:
        int r111 = r17 + r12;
        if (r111 >= r7) goto L70;
        int r112 = r18 + r12;
        if (r112 >= r11) goto L70;
        if (this.image.get(r112, r111) == false) goto L70;
        int r113 = r4[4];
        if (r113 >= r19) goto L70;
        r4[4] = r113 + 1;
        r12 = r12 + 1;
    L70:
        int r0 = r4[4];
        if (r0 < r19) goto L74;
        return false;
    L74:
        if (Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r0) - r20) >= (r20 * 2)) goto L78;
        if (foundPatternCross(r4) == false) goto L78;
        return true;
    L78:
        return false;
    }

    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        BitMatrix r0 = this.image;
        int r1 = r0.getHeight();
        int[] r9 = getCrossCheckStateCount();
        int r2 = r10;
    L4:
        if (r2 < 0) goto L9;
        if (r0.get(r11, r2) == false) goto L9;
        r9[2] = r9[2] + 1;
        r2 = r2 - 1;
    L9:
        if (r2 >= 0) goto L11;
        return Float.NaN;
    L11:
        if (r2 < 0) goto L17;
        if (r0.get(r11, r2) == true) goto L17;
        int r6 = r9[1];
        if (r6 > r12) goto L17;
        r9[1] = r6 + 1;
        r2 = r2 - 1;
    L17:
        if (r2 >= 0) goto L19;
    L66:
        return Float.NaN;
    L19:
        if (r9[1] > r12) goto L66;
    L22:
        if (r2 < 0) goto L29;
        if (r0.get(r11, r2) == false) goto L29;
        int r7 = r9[0];
        if (r7 > r12) goto L29;
        r9[0] = r7 + 1;
        r2 = r2 - 1;
    L29:
        if (r9[0] <= r12) goto L31;
        return Float.NaN;
    L31:
        int r14 = r10 + 1;
    L32:
        if (r14 >= r1) goto L36;
        if (r0.get(r11, r14) == false) goto L36;
        r9[2] = r9[2] + 1;
        r14 = r14 + 1;
    L36:
        if (r14 != r1) goto L39;
        return Float.NaN;
    L39:
        if (r14 >= r1) goto L45;
        if (r0.get(r11, r14) == true) goto L45;
        int r8 = r9[3];
        if (r8 >= r12) goto L45;
        r9[3] = r8 + 1;
        r14 = r14 + 1;
    L45:
        if (r14 == r1) goto L66;
        if (r9[3] >= r12) goto L66;
    L50:
        if (r14 >= r1) goto L56;
        if (r0.get(r11, r14) == false) goto L56;
        int r15 = r9[4];
        if (r15 >= r12) goto L56;
        r9[4] = r15 + 1;
        r14 = r14 + 1;
    L56:
        int r16 = r9[4];
        if (r16 < r12) goto L60;
        return Float.NaN;
    L60:
        if ((Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r16) - r13) * 5) < (r13 * 2)) goto L63;
        return Float.NaN;
    L63:
        if (foundPatternCross(r9) == false) goto L66;
        return centerFromEnd(r9, r14);
    }

    private float crossCheckHorizontal(int r10, int r11, int r12, int r13) {
        BitMatrix r0 = this.image;
        int r1 = r0.getWidth();
        int[] r9 = getCrossCheckStateCount();
        int r2 = r10;
    L4:
        if (r2 < 0) goto L9;
        if (r0.get(r2, r11) == false) goto L9;
        r9[2] = r9[2] + 1;
        r2 = r2 - 1;
    L9:
        if (r2 >= 0) goto L11;
        return Float.NaN;
    L11:
        if (r2 < 0) goto L17;
        if (r0.get(r2, r11) == true) goto L17;
        int r6 = r9[1];
        if (r6 > r12) goto L17;
        r9[1] = r6 + 1;
        r2 = r2 - 1;
    L17:
        if (r2 >= 0) goto L19;
    L66:
        return Float.NaN;
    L19:
        if (r9[1] > r12) goto L66;
    L22:
        if (r2 < 0) goto L29;
        if (r0.get(r2, r11) == false) goto L29;
        int r7 = r9[0];
        if (r7 > r12) goto L29;
        r9[0] = r7 + 1;
        r2 = r2 - 1;
    L29:
        if (r9[0] <= r12) goto L31;
        return Float.NaN;
    L31:
        int r14 = r10 + 1;
    L32:
        if (r14 >= r1) goto L36;
        if (r0.get(r14, r11) == false) goto L36;
        r9[2] = r9[2] + 1;
        r14 = r14 + 1;
    L36:
        if (r14 != r1) goto L39;
        return Float.NaN;
    L39:
        if (r14 >= r1) goto L45;
        if (r0.get(r14, r11) == true) goto L45;
        int r8 = r9[3];
        if (r8 >= r12) goto L45;
        r9[3] = r8 + 1;
        r14 = r14 + 1;
    L45:
        if (r14 == r1) goto L66;
        if (r9[3] >= r12) goto L66;
    L50:
        if (r14 >= r1) goto L56;
        if (r0.get(r14, r11) == false) goto L56;
        int r15 = r9[4];
        if (r15 >= r12) goto L56;
        r9[4] = r15 + 1;
        r14 = r14 + 1;
    L56:
        int r16 = r9[4];
        if (r16 < r12) goto L60;
        return Float.NaN;
    L60:
        if ((Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r16) - r13) * 5) < r13) goto L63;
        return Float.NaN;
    L63:
        if (foundPatternCross(r9) == false) goto L66;
        return centerFromEnd(r9, r14);
    }

    protected final boolean handlePossibleCenter(int[] r7, int r8, int r9, boolean r10) {
        boolean r0 = false;
        int r1 = (((r7[0] + r7[1]) + r7[2]) + r7[3]) + r7[4];
        int r11 = (int) centerFromEnd(r7, r9);
        float r12 = crossCheckVertical(r8, r11, r7[2], r1);
        if (Float.isNaN(r12) == true) goto L21;
        int r4 = (int) r12;
        float r13 = crossCheckHorizontal(r11, r4, r7[2], r1);
        if (Float.isNaN(r13) == true) goto L21;
        if (r10 == true) goto L8;
    L9:
        float r14 = r1 / 7.0f;
        int r15 = 0;
    L11:
        if (r15 >= this.possibleCenters.size()) goto L16;
        FinderPattern r2 = this.possibleCenters.get(r15);
        if (r2.aboutEquals(r14, r12, r13) == true) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        this.possibleCenters.set(r15, r2.combineEstimate(r12, r13, r14));
        r0 = true;
    L16:
        if (r0 == true) goto L20;
        FinderPattern r16 = new FinderPattern(r13, r12, r14);
        this.possibleCenters.add(r16);
        ResultPointCallback r6 = this.resultPointCallback;
        if (r6 == null) goto L20;
        r6.foundPossibleResultPoint(r16);
    L20:
        return true;
    L8:
        if (crossCheckDiagonal(r4, (int) r13, r7[2], r1) == true) goto L9;
    L21:
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() > 1) goto L5;
        return 0;
    L5:
        Iterator<FinderPattern> r0 = this.possibleCenters.iterator();
        FinderPattern r3 = null;
    L7:
        if (r0.hasNext() == false) goto L14;
        FinderPattern r4 = r0.next();
        if (r4.getCount() < 2) goto L7;
        if (r3 != null) goto L12;
        r3 = r4;
        goto L7
    L12:
        this.hasSkipped = true;
        return ((int) (Math.abs(r3.getX() - r4.getX()) - Math.abs(r3.getY() - r4.getY()))) / 2;
    L14:
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int r0 = this.possibleCenters.size();
        Iterator<FinderPattern> r1 = this.possibleCenters.iterator();
        float r3 = 0.0f;
        int r4 = 0;
        float r5 = 0.0f;
    L4:
        if (r1.hasNext() == false) goto L9;
        FinderPattern r6 = r1.next();
        if (r6.getCount() < 2) goto L4;
        r4 = r4 + 1;
        r5 = r5 + r6.getEstimatedModuleSize();
        goto L4
    L9:
        if (r4 >= 3) goto L11;
        return false;
    L11:
        float r2 = r5 / r0;
        Iterator<FinderPattern> r9 = this.possibleCenters.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        r3 = r3 + Math.abs(r9.next().getEstimatedModuleSize() - r2);
        goto L13
    L16:
        if (r3 > (r5 * 0.05f)) goto L19;
        return true;
    L19:
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int r0 = this.possibleCenters.size();
        if (r0 < 3) goto L29;
        AnonymousClass1 r2 = null;
        float r5 = 0.0f;
        if (r0 <= 3) goto L20;
        Iterator<FinderPattern> r6 = this.possibleCenters.iterator();
        float r7 = 0.0f;
        float r8 = 0.0f;
    L8:
        if (r6.hasNext() == false) goto L10;
        float r9 = r6.next().getEstimatedModuleSize();
        r7 = r7 + r9;
        r8 = r8 + (r9 * r9);
        goto L8
    L10:
        float r1 = r0;
        float r10 = r7 / r1;
        float r3 = (float) Math.sqrt((r8 / r1) - (r10 * r10));
        Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(r10, r2));
        float r4 = Math.max(0.2f * r10, r3);
        int r11 = 0;
    L12:
        if (r11 >= this.possibleCenters.size()) goto L20;
        if (this.possibleCenters.size() <= 3) goto L20;
        if (Math.abs(this.possibleCenters.get(r11).getEstimatedModuleSize() - r10) <= r4) goto L18;
        this.possibleCenters.remove(r11);
        r11 = r11 - 1;
    L18:
        r11 = r11 + 1;
    L20:
        if (this.possibleCenters.size() <= 3) goto L27;
        Iterator<FinderPattern> r12 = this.possibleCenters.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r5 = r5 + r12.next().getEstimatedModuleSize();
        goto L23
    L25:
        Collections.sort(this.possibleCenters, new CenterComparator(r5 / this.possibleCenters.size(), r2));
        List<FinderPattern> r13 = this.possibleCenters;
        r13.subList(3, r13.size()).clear();
    L27:
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    L29:
        throw NotFoundException.getNotFoundInstance();
    }
}
