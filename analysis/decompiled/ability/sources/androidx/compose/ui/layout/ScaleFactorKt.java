package androidx.compose.ui.layout;

import S7.a;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\n\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b\u0011\u0010\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\u0012\u0010\u000e\u001a'\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\"\u001f\u0010\u001f\u001a\u00020\u001a*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\"\u001f\u0010\"\u001a\u00020\u001a*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001c¨\u0006#"}, d2 = {"", "scaleX", "scaleY", "Landroidx/compose/ui/layout/ScaleFactor;", "ScaleFactor", "(FF)J", "Lkotlin/Function0;", "block", "takeOrElse-oyDd2qo", "(JLS7/a;)J", "takeOrElse", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "times-UQTWf7w", "(JJ)J", "times", "size", "times-m-w2e94", "div-UQTWf7w", "div", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "lerp", "", "isSpecified-FK8aYYs", "(J)Z", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified", "isUnspecified-FK8aYYs", "isUnspecified-FK8aYYs$annotations", "isUnspecified", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f, float f7) {
        return ScaleFactor.m5636constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m5650divUQTWf7w(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) / Float.intBitsToFloat((int) (j6 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) / Float.intBitsToFloat((int) (j6 & 4294967295L));
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m5651isSpecifiedFK8aYYs(long j5) {
        return j5 != ScaleFactor.INSTANCE.m5649getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m5652isSpecifiedFK8aYYs$annotations(long j5) {
    }

    /* renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m5653isUnspecifiedFK8aYYs(long j5) {
        return j5 == ScaleFactor.INSTANCE.m5649getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m5654isUnspecifiedFK8aYYs$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m5655lerpbDIf60(long j5, long j6, float f) {
        float fLerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j6 >> 32)), f);
        float fLerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 & 4294967295L)), f);
        return ScaleFactor.m5636constructorimpl((Float.floatToRawIntBits(fLerp) << 32) | (Float.floatToRawIntBits(fLerp2) & 4294967295L));
    }

    /* renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m5656takeOrElseoyDd2qo(long j5, a aVar) {
        return j5 != ScaleFactor.INSTANCE.m5649getUnspecified_hLwfpc() ? j5 : ((ScaleFactor) aVar.invoke()).m5647unboximpl();
    }

    @Stable
    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m5657timesUQTWf7w(long j5, long j6) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j6 >> 32)) * Float.intBitsToFloat((int) (j5 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j6 & 4294967295L)) * Float.intBitsToFloat((int) (j5 & 4294967295L));
        return Size.m3955constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    @Stable
    /* renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m5658timesmw2e94(long j5, long j6) {
        return m5657timesUQTWf7w(j6, j5);
    }
}
