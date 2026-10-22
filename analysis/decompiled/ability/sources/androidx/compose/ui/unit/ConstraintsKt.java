package androidx.compose.ui.unit;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0012\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0012\u001a7\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u0019\u0010\u0018\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u001b\u0010\u001e\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010!\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b \u0010\u001d\u001a\u001b\u0010%\u001a\u00020\"*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0019H\u0007¢\u0006\u0004\b#\u0010$\u001a'\u0010*\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00002\b\b\u0002\u0010'\u001a\u00020\u0000H\u0007¢\u0006\u0004\b(\u0010)\u001a \u0010-\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b-\u0010.\u001a\u0018\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b0\u0010\u0012\u001a\u0018\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b2\u0010\u0012\u001a\u0018\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b4\u0010\u0012\u001a\u0018\u00105\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b5\u0010\u0012\u001a\u0018\u00106\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b6\u0010\u0012\"\u0014\u00107\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108\"\u0014\u0010:\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;\"\u0014\u0010<\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00108\"\u0014\u0010=\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00108\"\u0014\u0010>\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00108\"\u0014\u0010?\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00108\"\u0014\u0010@\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00108\"\u0014\u0010A\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00108\"\u0014\u0010B\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00108\"\u0014\u0010C\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00108\"\u0014\u0010D\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u00108\"\u0014\u0010E\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u00108\"\u0014\u0010F\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u00108\"\u0014\u0010G\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u00108\"\u001a\u0010H\u001a\u0002098\u0000X\u0081T¢\u0006\f\n\u0004\bH\u0010;\u0012\u0004\bI\u0010J¨\u0006K"}, d2 = {"", "widthVal", "heightVal", "LC7/r;", "throwInvalidConstraintException", "(II)V", "size", "", "throwInvalidConstraintsSizeException", "(I)Ljava/lang/Void;", "minWidth", "maxWidth", "minHeight", "maxHeight", "Landroidx/compose/ui/unit/Constraints;", "createConstraints", "(IIII)J", "bitsNeedForSizeUnchecked", "(I)I", "maxAllowedForSize", androidx.constraintlayout.widget.Constraints.TAG, "otherConstraints", "constrain-N9IONVI", "(JJ)J", "constrain", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainWidth", "height", "constrainHeight-K40F9xA", "constrainHeight", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "isSatisfiedBy", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", TypedValues.CycleType.S_WAVE_OFFSET, "max", "value", "addMaxWithMinimum", "(II)I", "index", "indexToBitOffset", "bits", "bitOffsetToIndex", "bitOffset", "minHeightOffsets", "widthMask", "heightMask", "Infinity", "I", "", "FocusMask", "J", "MinFocusBits", "MaxAllowedForMinFocusBits", "MinFocusMask", "MinNonFocusBits", "MaxAllowedForMinNonFocusBits", "MinNonFocusMask", "MaxFocusBits", "MaxAllowedForMaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxNonFocusMask", "MaxDimensionsAndFocusMask", "getMaxDimensionsAndFocusMask$annotations", "()V", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
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

    @Stable
    public static final long Constraints(int i, int i6, int i10, int i11) {
        if (!((i10 >= 0) & (i6 >= i) & (i11 >= i10) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i6, i10, i11);
    }

    public static /* synthetic */ long Constraints$default(int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = 0;
        }
        if ((i12 & 2) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return Constraints(i, i6, i10, i11);
    }

    private static final int addMaxWithMinimum(int i, int i6) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i10 = i + i6;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    private static final int bitOffsetToIndex(int i) {
        return (i >> 1) + (i & 1);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    @Stable
    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m6811constrain4WqzIAM(long j5, long j6) {
        int i = (int) (j6 >> 32);
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        if (i < iM6799getMinWidthimpl) {
            i = iM6799getMinWidthimpl;
        }
        if (i <= iM6797getMaxWidthimpl) {
            iM6797getMaxWidthimpl = i;
        }
        int i6 = (int) (j6 & 4294967295L);
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        if (i6 < iM6798getMinHeightimpl) {
            i6 = iM6798getMinHeightimpl;
        }
        if (i6 <= iM6796getMaxHeightimpl) {
            iM6796getMaxHeightimpl = i6;
        }
        return IntSize.m7010constructorimpl((iM6797getMaxWidthimpl << 32) | (iM6796getMaxHeightimpl & 4294967295L));
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m6812constrainN9IONVI(long j5, long j6) {
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        int iM6799getMinWidthimpl2 = Constraints.m6799getMinWidthimpl(j6);
        if (iM6799getMinWidthimpl2 < iM6799getMinWidthimpl) {
            iM6799getMinWidthimpl2 = iM6799getMinWidthimpl;
        }
        if (iM6799getMinWidthimpl2 > iM6797getMaxWidthimpl) {
            iM6799getMinWidthimpl2 = iM6797getMaxWidthimpl;
        }
        int iM6797getMaxWidthimpl2 = Constraints.m6797getMaxWidthimpl(j6);
        if (iM6797getMaxWidthimpl2 >= iM6799getMinWidthimpl) {
            iM6799getMinWidthimpl = iM6797getMaxWidthimpl2;
        }
        if (iM6799getMinWidthimpl <= iM6797getMaxWidthimpl) {
            iM6797getMaxWidthimpl = iM6799getMinWidthimpl;
        }
        int iM6798getMinHeightimpl2 = Constraints.m6798getMinHeightimpl(j6);
        if (iM6798getMinHeightimpl2 < iM6798getMinHeightimpl) {
            iM6798getMinHeightimpl2 = iM6798getMinHeightimpl;
        }
        if (iM6798getMinHeightimpl2 > iM6796getMaxHeightimpl) {
            iM6798getMinHeightimpl2 = iM6796getMaxHeightimpl;
        }
        int iM6796getMaxHeightimpl2 = Constraints.m6796getMaxHeightimpl(j6);
        if (iM6796getMaxHeightimpl2 >= iM6798getMinHeightimpl) {
            iM6798getMinHeightimpl = iM6796getMaxHeightimpl2;
        }
        if (iM6798getMinHeightimpl <= iM6796getMaxHeightimpl) {
            iM6796getMaxHeightimpl = iM6798getMinHeightimpl;
        }
        return Constraints(iM6799getMinWidthimpl2, iM6797getMaxWidthimpl, iM6798getMinHeightimpl2, iM6796getMaxHeightimpl);
    }

    @Stable
    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m6813constrainHeightK40F9xA(long j5, int i) {
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        if (i < iM6798getMinHeightimpl) {
            i = iM6798getMinHeightimpl;
        }
        return i > iM6796getMaxHeightimpl ? iM6796getMaxHeightimpl : i;
    }

    @Stable
    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m6814constrainWidthK40F9xA(long j5, int i) {
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        if (i < iM6799getMinWidthimpl) {
            i = iM6799getMinWidthimpl;
        }
        return i > iM6797getMaxWidthimpl ? iM6797getMaxWidthimpl : i;
    }

    public static final long createConstraints(int i, int i6, int i10, int i11) {
        int i12 = i11 == Integer.MAX_VALUE ? i10 : i11;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i12);
        int i13 = i6 == Integer.MAX_VALUE ? i : i6;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i13);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i13, i12);
        }
        int i14 = i6 + 1;
        int i15 = i11 + 1;
        int i16 = iBitsNeedForSizeUnchecked2 - 13;
        return Constraints.m6785constructorimpl(((i14 & (~(i14 >> 31))) << 33) | ((i16 >> 1) + (i16 & 1)) | (i << 2) | (i10 << (iBitsNeedForSizeUnchecked2 + 2)) | ((i15 & (~(i15 >> 31))) << (iBitsNeedForSizeUnchecked2 + 33)));
    }

    public static /* synthetic */ void getMaxDimensionsAndFocusMask$annotations() {
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return (((i & 2) >> 1) * 3) + ((i & 1) << 1);
    }

    @Stable
    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m6815isSatisfiedBy4WqzIAM(long j5, long j6) {
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        int i = (int) (j6 >> 32);
        if (iM6799getMinWidthimpl > i || i > iM6797getMaxWidthimpl) {
            return false;
        }
        int i6 = (int) (j6 & 4294967295L);
        return Constraints.m6798getMinHeightimpl(j5) <= i6 && i6 <= Constraints.m6796getMaxHeightimpl(j5);
    }

    private static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        throwInvalidConstraintsSizeException(i);
        throw new KotlinNothingValueException();
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    @Stable
    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m6816offsetNN6EwU(long j5, int i, int i6) {
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5) + i;
        if (iM6799getMinWidthimpl < 0) {
            iM6799getMinWidthimpl = 0;
        }
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        if (iM6797getMaxWidthimpl != Integer.MAX_VALUE && (iM6797getMaxWidthimpl = iM6797getMaxWidthimpl + i) < 0) {
            iM6797getMaxWidthimpl = 0;
        }
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5) + i6;
        if (iM6798getMinHeightimpl < 0) {
            iM6798getMinHeightimpl = 0;
        }
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        return Constraints(iM6799getMinWidthimpl, iM6797getMaxWidthimpl, iM6798getMinHeightimpl, (iM6796getMaxHeightimpl == Integer.MAX_VALUE || (iM6796getMaxHeightimpl = iM6796getMaxHeightimpl + i6) >= 0) ? iM6796getMaxHeightimpl : 0);
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m6817offsetNN6EwU$default(long j5, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        return m6816offsetNN6EwU(j5, i, i6);
    }

    public static final void throwInvalidConstraintException(int i, int i6) {
        throw new IllegalArgumentException(b.o(i, "Can't represent a width of ", i6, " and height of ", " in Constraints"));
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException(a.i(i, "Can't represent a size of ", " in Constraints"));
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }
}
