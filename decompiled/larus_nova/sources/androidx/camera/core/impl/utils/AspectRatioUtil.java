package androidx.camera.core.impl.utils;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class AspectRatioUtil {
    private static final int ALIGN16 = 16;
    public static final Rational ASPECT_RATIO_16_9 = null;
    public static final Rational ASPECT_RATIO_3_4 = null;
    public static final Rational ASPECT_RATIO_4_3 = null;
    public static final Rational ASPECT_RATIO_9_16 = null;

    public static final class CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace implements Comparator<Rational> {
        private final Rational mFullFovRatio;
        private final Rational mTargetRatio;
        private final RectF mTransformedMappingArea;

        private float getMappingAreaSize(RectF r100) {
            return r100.width() * r100.height();
        }

        private RectF getTransformedMappingArea(Rational r100) {
            if (r100.floatValue() != this.mFullFovRatio.floatValue()) goto L7;
            return new RectF(0.0f, 0.0f, this.mFullFovRatio.getNumerator(), this.mFullFovRatio.getDenominator());
        L7:
            if (r100.floatValue() <= this.mFullFovRatio.floatValue()) goto L11;
            return new RectF(0.0f, 0.0f, this.mFullFovRatio.getNumerator(), (r100.getDenominator() * this.mFullFovRatio.getNumerator()) / r100.getNumerator());
        L11:
            return new RectF(0.0f, 0.0f, (r100.getNumerator() * this.mFullFovRatio.getDenominator()) / r100.getDenominator(), this.mFullFovRatio.getDenominator());
        }

        public CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(Rational r100, Rational r101) {
            this.mTargetRatio = r100;
            if (r101 != null) goto L6;
            r101 = new Rational(4, 3);
        L6:
            this.mFullFovRatio = r101;
            this.mTransformedMappingArea = getTransformedMappingArea(r100);
        }

        private float getOverlappingAreaSize(RectF r100, RectF r101) {
            if (r100.width() >= r101.width()) goto L5;
            float r102 = r100.width();
        L7:
            if (r100.height() >= r101.height()) goto L9;
            float r103 = r100.height();
        L11:
            return r102 * r103;
        L9:
            r103 = r101.height();
            goto L11
        L5:
            r102 = r101.width();
            goto L7
        }

        private boolean isMappingAreaCovered(RectF r100, RectF r101) {
            if (r100.width() >= r101.width()) goto L5;
        L7:
            return false;
        L5:
            if (r100.height() < r101.height()) goto L7;
            return true;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Rational r100, Rational r101) {
            if (r100.equals(r101) == false) goto L6;
            return 0;
        L6:
            RectF r102 = getTransformedMappingArea(r100);
            RectF r103 = getTransformedMappingArea(r101);
            boolean r104 = isMappingAreaCovered(r102, this.mTransformedMappingArea);
            boolean r105 = isMappingAreaCovered(r103, this.mTransformedMappingArea);
            if (r104 == false) goto L11;
            if (r105 == false) goto L11;
            return (int) Math.signum(getMappingAreaSize(r102) - getMappingAreaSize(r103));
        L11:
            if (r104 == false) goto L14;
            return -1;
        L14:
            if (r105 == false) goto L18;
            return 1;
        L18:
            return -((int) Math.signum(getOverlappingAreaSize(r102, this.mTransformedMappingArea) - getOverlappingAreaSize(r103, this.mTransformedMappingArea)));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Rational r100, Rational r101) {
            return compare2(r100, r101);
        }
    }

    static {
        ASPECT_RATIO_4_3 = new Rational(4, 3);
        ASPECT_RATIO_3_4 = new Rational(3, 4);
        ASPECT_RATIO_16_9 = new Rational(16, 9);
        ASPECT_RATIO_9_16 = new Rational(9, 16);
    }

    private AspectRatioUtil() {
    }

    public static boolean hasMatchingAspectRatio(Size r100, Rational r101) {
        return hasMatchingAspectRatio(r100, r101, SizeUtil.RESOLUTION_VGA);
    }

    private static boolean isPossibleMod16FromAspectRatio(Size r100, Rational r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        Rational r104 = new Rational(r101.getDenominator(), r101.getNumerator());
        int r105 = r102 % 16;
        if (r105 == 0) goto L5;
    L12:
        if (r105 != 0) goto L16;
        return ratioIntersectsMod16Segment(r103, r102, r101);
    L16:
        if ((r103 % 16) == 0) goto L18;
        return false;
    L18:
        return ratioIntersectsMod16Segment(r102, r103, r104);
    L5:
        if ((r103 % 16) != 0) goto L12;
        if (ratioIntersectsMod16Segment(Math.max(0, r103 - 16), r102, r101) == false) goto L9;
    L10:
        return true;
    L9:
        if (ratioIntersectsMod16Segment(Math.max(0, r102 - 16), r103, r104) == true) goto L10;
        return false;
    }

    public static boolean hasMatchingAspectRatio(Size r100, Rational r101, Size r102) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.equals(new Rational(r100.getWidth(), r100.getHeight())) == false) goto L9;
        return true;
    L9:
        if (SizeUtil.getArea(r100) >= SizeUtil.getArea(r102)) goto L11;
        return false;
    L11:
        return isPossibleMod16FromAspectRatio(r100, r101);
    }

    private static boolean ratioIntersectsMod16Segment(int r100, int r101, Rational r102) {
        if ((r101 % 16) != 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        double r104 = ((double) (r100 * r102.getNumerator())) / ((double) r102.getDenominator());
        if (r104 > Math.max(0, r101 - 16)) goto L9;
    L11:
        return false;
    L9:
        if (r104 >= (r101 + 16)) goto L11;
        return true;
    L5:
        r103 = false;
        goto L6
    }
}
