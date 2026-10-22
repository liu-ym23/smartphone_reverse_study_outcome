package androidx.compose.ui.geometry;

import S7.a;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\n\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0017\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0018\u001a\u0013\u0010\u001c\u001a\u00020\u0019*\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\"\u001f\u0010\"\u001a\u00020\u001d*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\"\u001f\u0010%\u001a\u00020\u001d*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001f\"\u001e\u0010*\u001a\u00020&*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010!\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"", "width", "height", "Landroidx/compose/ui/geometry/Size;", "Size", "(FF)J", "Lkotlin/Function0;", "block", "takeOrElse-TmRCtEA", "(JLS7/a;)J", "takeOrElse", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "lerp", "", "size", "times-d16Qtg0", "(IJ)J", "times", "", "(DJ)J", "(FJ)J", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "toRect", "", "isSpecified-uvyYCjk", "(J)Z", "isSpecified-uvyYCjk$annotations", "(J)V", "isSpecified", "isUnspecified-uvyYCjk", "isUnspecified-uvyYCjk$annotations", "isUnspecified", "Landroidx/compose/ui/geometry/Offset;", "getCenter-uvyYCjk", "(J)J", "getCenter-uvyYCjk$annotations", "center", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SizeKt {
    @Stable
    public static final long Size(float f, float f7) {
        return Size.m3955constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m3974getCenteruvyYCjk(long j5) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) / 2.0f;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    @Stable
    /* renamed from: getCenter-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m3975getCenteruvyYCjk$annotations(long j5) {
    }

    /* renamed from: isSpecified-uvyYCjk, reason: not valid java name */
    public static final boolean m3976isSpecifieduvyYCjk(long j5) {
        return j5 != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isSpecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m3977isSpecifieduvyYCjk$annotations(long j5) {
    }

    /* renamed from: isUnspecified-uvyYCjk, reason: not valid java name */
    public static final boolean m3978isUnspecifieduvyYCjk(long j5) {
        return j5 == InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isUnspecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m3979isUnspecifieduvyYCjk$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp-VgWVRYQ, reason: not valid java name */
    public static final long m3980lerpVgWVRYQ(long j5, long j6, float f) {
        float fLerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j6 >> 32)), f);
        float fLerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 & 4294967295L)), f);
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fLerp) << 32) | (Float.floatToRawIntBits(fLerp2) & 4294967295L));
    }

    /* renamed from: takeOrElse-TmRCtEA, reason: not valid java name */
    public static final long m3981takeOrElseTmRCtEA(long j5, a aVar) {
        return j5 != InlineClassHelperKt.UnspecifiedPackedFloats ? j5 : ((Size) aVar.invoke()).m3969unboximpl();
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m3984timesd16Qtg0(int i, long j5) {
        return Size.m3967times7Ah8Wj8(j5, i);
    }

    @Stable
    /* renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m3985toRectuvyYCjk(long j5) {
        return RectKt.m3935Recttz77jQw(Offset.INSTANCE.m3911getZeroF1C5BW0(), j5);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m3982timesd16Qtg0(double d, long j5) {
        return Size.m3967times7Ah8Wj8(j5, (float) d);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m3983timesd16Qtg0(float f, long j5) {
        return Size.m3967times7Ah8Wj8(j5, f);
    }
}
