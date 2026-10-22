package androidx.compose.ui.geometry;

import S7.a;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\"\u001f\u0010\u0016\u001a\u00020\u0011*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\"\u001f\u0010\u0019\u001a\u00020\u0011*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013\"\u001f\u0010\u001c\u001a\u00020\u0011*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001a\u0010\u0013¨\u0006\u001d"}, d2 = {"", "x", "y", "Landroidx/compose/ui/geometry/Offset;", "Offset", "(FF)J", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "lerp", "Lkotlin/Function0;", "block", "takeOrElse-3MmeM6k", "(JLS7/a;)J", "takeOrElse", "", "isFinite-k-4lQ0M", "(J)Z", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite", "isSpecified-k-4lQ0M", "isSpecified-k-4lQ0M$annotations", "isSpecified", "isUnspecified-k-4lQ0M", "isUnspecified-k-4lQ0M$annotations", "isUnspecified", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OffsetKt {
    @Stable
    public static final long Offset(float f, float f7) {
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m3912isFinitek4lQ0M(long j5) {
        return ((((j5 & InlineClassHelperKt.DualFloatInfinityBase) ^ InlineClassHelperKt.DualFloatInfinityBase) - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0;
    }

    @Stable
    /* renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m3913isFinitek4lQ0M$annotations(long j5) {
    }

    /* renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m3914isSpecifiedk4lQ0M(long j5) {
        return (j5 & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m3915isSpecifiedk4lQ0M$annotations(long j5) {
    }

    /* renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m3916isUnspecifiedk4lQ0M(long j5) {
        return (j5 & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m3917isUnspecifiedk4lQ0M$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m3918lerpWko1d7g(long j5, long j6, float f) {
        float fLerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j6 >> 32)), f);
        float fLerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 & 4294967295L)), f);
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fLerp) << 32) | (Float.floatToRawIntBits(fLerp2) & 4294967295L));
    }

    /* renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m3919takeOrElse3MmeM6k(long j5, a aVar) {
        return (9223372034707292159L & j5) != InlineClassHelperKt.UnspecifiedPackedFloats ? j5 : ((Offset) aVar.invoke()).m3905unboximpl();
    }
}
