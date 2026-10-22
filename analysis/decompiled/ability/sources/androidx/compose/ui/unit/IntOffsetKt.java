package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "toOffset--gyyYBs", "(J)J", "plus", TypedValues.CycleType.S_WAVE_OFFSET, "plus-Nv-tHpc", "(JJ)J", "minus", "minus-Nv-tHpc", "plus-oCl6YwE", "minus-oCl6YwE", "round", "round-k-4lQ0M", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i, int i6) {
        return IntOffset.m6966constructorimpl((i6 & 4294967295L) | (i << 32));
    }

    @Stable
    /* renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m6984lerp81ZRxRo(long j5, long j6, float f) {
        return IntOffset.m6966constructorimpl((MathHelpersKt.lerp(IntOffset.m6972getXimpl(j5), IntOffset.m6972getXimpl(j6), f) << 32) | (MathHelpersKt.lerp(IntOffset.m6973getYimpl(j5), IntOffset.m6973getYimpl(j6), f) & 4294967295L));
    }

    @Stable
    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m6985minusNvtHpc(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - IntOffset.m6972getXimpl(j6);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - IntOffset.m6973getYimpl(j6);
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    @Stable
    /* renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m6986minusoCl6YwE(long j5, long j6) {
        float fM6972getXimpl = IntOffset.m6972getXimpl(j5) - Float.intBitsToFloat((int) (j6 >> 32));
        float fM6973getYimpl = IntOffset.m6973getYimpl(j5) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fM6972getXimpl) << 32) | (Float.floatToRawIntBits(fM6973getYimpl) & 4294967295L));
    }

    @Stable
    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m6987plusNvtHpc(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) + IntOffset.m6972getXimpl(j6);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) + IntOffset.m6973getYimpl(j6);
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    @Stable
    /* renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m6988plusoCl6YwE(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j6 >> 32)) + IntOffset.m6972getXimpl(j5);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j6 & 4294967295L)) + IntOffset.m6973getYimpl(j5);
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    @Stable
    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m6989roundk4lQ0M(long j5) {
        return IntOffset.m6966constructorimpl((Math.round(Float.intBitsToFloat((int) (j5 & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j5 >> 32))) << 32));
    }

    @Stable
    /* renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m6990toOffsetgyyYBs(long j5) {
        float fM6972getXimpl = IntOffset.m6972getXimpl(j5);
        float fM6973getYimpl = IntOffset.m6973getYimpl(j5);
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fM6973getYimpl) & 4294967295L) | (Float.floatToRawIntBits(fM6972getXimpl) << 32));
    }
}
