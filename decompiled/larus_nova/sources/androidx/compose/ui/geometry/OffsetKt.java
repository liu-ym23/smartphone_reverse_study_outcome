package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\"\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\"\u001f\u0010\f\u001a\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u001f\u0010\u0012\u001a\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u001f\u0010\u0015\u001a\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001d"}, d2 = {"Offset", "Landroidx/compose/ui/geometry/Offset;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "isFinite", "", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OffsetKt {
    /* JADX INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m4599isFinitek4lQ0M(long r100) {
        if (((((r100 & InlineClassHelperKt.DualFloatInfinityBase) ^ InlineClassHelperKt.DualFloatInfinityBase) - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m4600isFinitek4lQ0M$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m4601isSpecifiedk4lQ0M(long r100) {
        if ((r100 & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m4602isSpecifiedk4lQ0M$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m4603isUnspecifiedk4lQ0M(long r100) {
        if ((r100 & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m4604isUnspecifiedk4lQ0M$annotations(long r100) {
    }

    public static final long Offset(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m4606takeOrElse3MmeM6k(long r100, Function0<Offset> r101) {
        if ((9223372034707292159L & r100) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r101.invoke().m4592unboximpl();
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m4605lerpWko1d7g(long r100, long r101, float r102) {
        float r103 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r101 >> 32)), r102);
        float r104 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)), r102);
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }
}
