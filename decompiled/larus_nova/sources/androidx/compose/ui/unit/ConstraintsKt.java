package androidx.compose.ui.unit;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a-\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0082\b\u001a5\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010 \u001a\u0019\u0010$\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'\u001a\u001b\u0010$\u001a\u00020(*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010'\u001a\u001b\u0010*\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010+\u001a\u00020\u0001H\u0007¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010.\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010/\u001a\u00020\u0001H\u0007¢\u0006\u0004\b0\u0010-\u001a\u001b\u00101\u001a\u000202*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020(H\u0007¢\u0006\u0004\b3\u00104\u001a'\u00105\u001a\u00020\u001b*\u00020\u001b2\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u00020\u0001H\u0007¢\u0006\u0004\b8\u00109\u001a\u0019\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010C\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010D\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012¨\u0006E"}, d2 = {"Infinity", "", "FocusMask", "", "MinFocusBits", "MaxAllowedForMinFocusBits", "MinFocusMask", "MinNonFocusBits", "MaxAllowedForMinNonFocusBits", "MinNonFocusMask", "MaxFocusBits", "MaxAllowedForMaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxNonFocusMask", "MaxDimensionsAndFocusMask", "getMaxDimensionsAndFocusMask$annotations", "()V", "throwInvalidConstraintException", "", "widthVal", "heightVal", "throwInvalidConstraintsSizeException", "", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "bitsNeedForSizeUnchecked", "maxAllowedForSize", androidx.constraintlayout.widget.Constraints.TAG, "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainWidth", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainHeight", "height", "constrainHeight-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "addMaxWithMinimum", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "value", "indexToBitOffset", "index", "bitOffsetToIndex", "bits", "minHeightOffsets", "bitOffset", "widthMask", "heightMask", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    public static final long MaxDimensionsAndFocusMask = -8589934589L;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusMask = 262143;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusMask = 65535;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    private static final int addMaxWithMinimum(int r100, int r101) {
        if (r100 == Integer.MAX_VALUE) goto L10;
        int r102 = r100 + r101;
        if (r102 >= 0) goto L9;
        return 0;
    L9:
        return r102;
    L10:
        return r100;
    }

    private static final int bitOffsetToIndex(int r100) {
        return (r100 >> 1) + (r100 & 1);
    }

    public static final int bitsNeedForSizeUnchecked(int r100) {
        if (r100 >= MaxNonFocusMask) goto L6;
        return 13;
    L6:
        if (r100 >= 32767) goto L9;
        return 15;
    L9:
        if (r100 >= 65535) goto L12;
        return 16;
    L12:
        if (r100 >= MaxFocusMask) goto L14;
        return 18;
    L14:
        return 255;
    }

    public static /* synthetic */ void getMaxDimensionsAndFocusMask$annotations() {
    }

    private static final int heightMask(int r100) {
        return (1 << (18 - r100)) - 1;
    }

    private static final int indexToBitOffset(int r100) {
        return ((r100 & 1) << 1) + (((r100 & 2) >> 1) * 3);
    }

    private static final int minHeightOffsets(int r100) {
        return r100 + 15;
    }

    private static final int widthMask(int r100) {
        return (1 << (r100 + 13)) - 1;
    }

    private static final int maxAllowedForSize(int r100) {
        if (r100 >= MaxNonFocusMask) goto L6;
        return MaxAllowedForMaxNonFocusBits;
    L6:
        if (r100 >= 32767) goto L9;
        return MaxAllowedForMinNonFocusBits;
    L9:
        if (r100 >= 65535) goto L12;
        return MaxAllowedForMinFocusBits;
    L12:
        if (r100 >= MaxFocusMask) goto L15;
        return MaxAllowedForMaxFocusBits;
    L15:
        throwInvalidConstraintsSizeException(r100);
        throw new KotlinNothingValueException();
    }

    public static final Void throwInvalidConstraintsSizeException(int r100) {
        throw new IllegalArgumentException("Can't represent a size of " + r100 + " in Constraints");
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m7501constrain4WqzIAM(long r100, long r101) {
        int r102 = (int) (r101 >> 32);
        int r103 = Constraints.m7489getMinWidthimpl(r100);
        int r104 = Constraints.m7487getMaxWidthimpl(r100);
        if (r102 >= r103) goto L5;
        r102 = r103;
    L5:
        if (r102 > r104) goto L8;
        r104 = r102;
    L8:
        int r105 = (int) (r101 & BodyPartID.bodyIdMax);
        int r106 = Constraints.m7488getMinHeightimpl(r100);
        int r107 = Constraints.m7486getMaxHeightimpl(r100);
        if (r105 >= r106) goto L11;
        r105 = r106;
    L11:
        if (r105 > r107) goto L15;
        r107 = r105;
    L15:
        return IntSize.m7714constructorimpl((((long) r104) << 32) | (((long) r107) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m7502constrainN9IONVI(long r100, long r101) {
        int r102 = Constraints.m7489getMinWidthimpl(r100);
        int r103 = Constraints.m7487getMaxWidthimpl(r100);
        int r104 = Constraints.m7488getMinHeightimpl(r100);
        int r105 = Constraints.m7486getMaxHeightimpl(r100);
        int r106 = Constraints.m7489getMinWidthimpl(r101);
        if (r106 >= r102) goto L5;
        r106 = r102;
    L5:
        if (r106 <= r103) goto L7;
        r106 = r103;
    L7:
        int r107 = Constraints.m7487getMaxWidthimpl(r101);
        if (r107 < r102) goto L11;
        r102 = r107;
    L11:
        if (r102 > r103) goto L14;
        r103 = r102;
    L14:
        int r108 = Constraints.m7488getMinHeightimpl(r101);
        if (r108 >= r104) goto L17;
        r108 = r104;
    L17:
        if (r108 <= r105) goto L19;
        r108 = r105;
    L19:
        int r109 = Constraints.m7486getMaxHeightimpl(r101);
        if (r109 < r104) goto L23;
        r104 = r109;
    L23:
        if (r104 > r105) goto L27;
        r105 = r104;
    L27:
        return Constraints(r106, r103, r108, r105);
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m7503constrainHeightK40F9xA(long r100, int r101) {
        int r102 = Constraints.m7488getMinHeightimpl(r100);
        int r103 = Constraints.m7486getMaxHeightimpl(r100);
        if (r101 >= r102) goto L5;
        r101 = r102;
    L5:
        if (r101 <= r103) goto L8;
        return r103;
    L8:
        return r101;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m7504constrainWidthK40F9xA(long r100, int r101) {
        int r102 = Constraints.m7489getMinWidthimpl(r100);
        int r103 = Constraints.m7487getMaxWidthimpl(r100);
        if (r101 >= r102) goto L5;
        r101 = r102;
    L5:
        if (r101 <= r103) goto L8;
        return r103;
    L8:
        return r101;
    }

    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m7505isSatisfiedBy4WqzIAM(long r100, long r101) {
        int r102 = Constraints.m7489getMinWidthimpl(r100);
        int r103 = Constraints.m7487getMaxWidthimpl(r100);
        int r104 = (int) (r101 >> 32);
        if (r102 > r104) goto L6;
        if (r104 > r103) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L15;
        int r106 = Constraints.m7488getMinHeightimpl(r100);
        int r107 = Constraints.m7486getMaxHeightimpl(r100);
        int r108 = (int) (r101 & BodyPartID.bodyIdMax);
        if (r106 > r108) goto L12;
        if (r108 > r107) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L15;
        return true;
    L12:
        r109 = false;
    L15:
        return false;
    L6:
        r105 = false;
        goto L7
    }

    public static final void throwInvalidConstraintException(int r100, int r101) {
        throw new IllegalArgumentException("Can't represent a width of " + r100 + " and height of " + r101 + " in Constraints");
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m7506offsetNN6EwU(long r100, int r101, int r102) {
        int r103 = Constraints.m7489getMinWidthimpl(r100) + r101;
        int r104 = 0;
        if (r103 >= 0) goto L5;
        r103 = 0;
    L5:
        int r105 = Constraints.m7487getMaxWidthimpl(r100);
        if (r105 == Integer.MAX_VALUE) goto L11;
        r105 = r105 + r101;
        if (r105 >= 0) goto L11;
        r105 = 0;
    L11:
        int r106 = Constraints.m7488getMinHeightimpl(r100) + r102;
        if (r106 >= 0) goto L14;
        r106 = 0;
    L14:
        int r107 = Constraints.m7486getMaxHeightimpl(r100);
        if (r107 != Integer.MAX_VALUE) goto L17;
    L16:
        r104 = r107;
    L20:
        return Constraints(r103, r105, r106, r104);
    L17:
        r107 = r107 + r102;
        if (r107 >= 0) goto L16;
        goto L16
    }

    public static final long Constraints(int r100, int r101, int r102, int r103) {
        boolean r104 = true;
        if (r101 < r100) goto L5;
        boolean r105 = true;
    L6:
        if (r103 < r102) goto L8;
        boolean r106 = true;
    L9:
        boolean r107 = r105 & r106;
        if (r100 < 0) goto L12;
        boolean r108 = true;
    L13:
        boolean r109 = r107 & r108;
        if (r102 >= 0) goto L18;
        r104 = false;
    L18:
        if ((r104 & r109) == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
    L21:
        return createConstraints(r100, r101, r102, r103);
    L12:
        r108 = false;
        goto L13
    L8:
        r106 = false;
        goto L9
    L5:
        r105 = false;
        goto L6
    }

    public static final long createConstraints(int r100, int r101, int r110, int r111) {
        if (r111 != Integer.MAX_VALUE) goto L5;
        int r102 = r110;
    L6:
        int r103 = bitsNeedForSizeUnchecked(r102);
        if (r101 != Integer.MAX_VALUE) goto L9;
        int r104 = r100;
    L10:
        int r105 = bitsNeedForSizeUnchecked(r104);
        if ((r103 + r105) <= 31) goto L13;
        throwInvalidConstraintException(r104, r102);
    L13:
        int r106 = r101 + 1;
        int r107 = r106 & (~(r106 >> 31));
        int r112 = r111 + 1;
        int r108 = r105 - 13;
        int r109 = (r108 >> 1) + (r108 & 1);
        int r113 = r108 + 15;
        return Constraints.m7475constructorimpl((((((long) r107) << 33) | (((long) r109) | (((long) r100) << 2))) | (((long) r110) << r113)) | ((r112 & (~(r112 >> 31))) << (r113 + 31)));
    L9:
        r104 = r101;
        goto L10
    L5:
        r102 = r111;
        goto L6
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m7507offsetNN6EwU$default(long r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        return m7506offsetNN6EwU(r100, r101, r102);
    }

    public static /* synthetic */ long Constraints$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Integer.MAX_VALUE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = Integer.MAX_VALUE;
    L15:
        return Constraints(r100, r101, r102, r103);
    }
}
