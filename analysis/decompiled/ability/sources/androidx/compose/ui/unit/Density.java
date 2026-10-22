package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

@Immutable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\u0003*\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\f\u001a\u00020\r*\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\t*\u00020\rH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\rH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0003H\u0017¢\u0006\u0004\b\u0016\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\u0003H\u0017¢\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0017J\u0013\u0010\u001f\u001a\u00020 *\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020!*\u00020 H\u0017¢\u0006\u0004\b%\u0010#R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "toPx", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Density extends FontScaling {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6830roundToPxR2X_6o(Density density, long j5) {
            return Density.super.mo374roundToPxR2X_6o(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6831roundToPx0680j_4(Density density, float f) {
            return Density.super.mo375roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6832toDpGaN1DYA(Density density, long j5) {
            return Density.super.mo376toDpGaN1DYA(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6834toDpu2uoSUM(Density density, int i) {
            return Density.super.mo378toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6835toDpSizekrfVVM(Density density, long j5) {
            return Density.super.mo379toDpSizekrfVVM(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6836toPxR2X_6o(Density density, long j5) {
            return Density.super.mo380toPxR2X_6o(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6837toPx0680j_4(Density density, float f) {
            return Density.super.mo381toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6838toSizeXkaWNTQ(Density density, long j5) {
            return Density.super.mo382toSizeXkaWNTQ(j5);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6839toSp0xMU5do(Density density, float f) {
            return Density.super.mo383toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6841toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo385toSpkPz2Gy4(i);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6833toDpu2uoSUM(Density density, float f) {
            return Density.super.mo377toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6840toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo384toSpkPz2Gy4(f);
        }
    }

    float getDensity();

    @Stable
    /* renamed from: roundToPx--R2X_6o */
    default int mo374roundToPxR2X_6o(long j5) {
        return Math.round(mo380toPxR2X_6o(j5));
    }

    @Stable
    /* renamed from: roundToPx-0680j_4 */
    default int mo375roundToPx0680j_4(float f) {
        float fMo381toPx0680j_4 = mo381toPx0680j_4(f);
        if (Float.isInfinite(fMo381toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo381toPx0680j_4);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM */
    default float mo378toDpu2uoSUM(int i) {
        return Dp.m6844constructorimpl(i / getDensity());
    }

    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    default long mo379toDpSizekrfVVM(long j5) {
        return j5 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? DpKt.m6866DpSizeYgX7TsA(mo377toDpu2uoSUM(Float.intBitsToFloat((int) (j5 >> 32))), mo377toDpu2uoSUM(Float.intBitsToFloat((int) (j5 & 4294967295L)))) : DpSize.INSTANCE.m6951getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: toPx--R2X_6o */
    default float mo380toPxR2X_6o(long j5) {
        if (!TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(j5), TextUnitType.INSTANCE.m7071getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        return mo381toPx0680j_4(mo376toDpGaN1DYA(j5));
    }

    @Stable
    /* renamed from: toPx-0680j_4 */
    default float mo381toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Stable
    default Rect toRect(DpRect dpRect) {
        return new Rect(mo381toPx0680j_4(dpRect.m6927getLeftD9Ej5fM()), mo381toPx0680j_4(dpRect.m6929getTopD9Ej5fM()), mo381toPx0680j_4(dpRect.m6928getRightD9Ej5fM()), mo381toPx0680j_4(dpRect.m6926getBottomD9Ej5fM()));
    }

    @Stable
    /* renamed from: toSize-XkaWNTQ */
    default long mo382toSizeXkaWNTQ(long j5) {
        if (j5 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Size.INSTANCE.m3972getUnspecifiedNHjbRc();
        }
        float fMo381toPx0680j_4 = mo381toPx0680j_4(DpSize.m6942getWidthD9Ej5fM(j5));
        float fMo381toPx0680j_42 = mo381toPx0680j_4(DpSize.m6940getHeightD9Ej5fM(j5));
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fMo381toPx0680j_4) << 32) | (Float.floatToRawIntBits(fMo381toPx0680j_42) & 4294967295L));
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    default long mo385toSpkPz2Gy4(int i) {
        return mo383toSp0xMU5do(mo378toDpu2uoSUM(i));
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    default long mo384toSpkPz2Gy4(float f) {
        return mo383toSp0xMU5do(mo377toDpu2uoSUM(f));
    }

    @Stable
    /* renamed from: toDp-u2uoSUM */
    default float mo377toDpu2uoSUM(float f) {
        return Dp.m6844constructorimpl(f / getDensity());
    }
}
