package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "toOffset--gyyYBs", "(J)J", "plus", "offset", "plus-Nv-tHpc", "(JJ)J", "minus", "minus-Nv-tHpc", "plus-oCl6YwE", "minus-oCl6YwE", "round", "round-k-4lQ0M", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntOffsetKt {
    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m7693roundk4lQ0M(long r100) {
        int r101 = Math.round(Float.intBitsToFloat((int) (r100 >> 32)));
        long r102 = ((long) Math.round(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax;
        return IntOffset.m7670constructorimpl(r102 | (((long) r101) << 32));
    }

    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m7694toOffsetgyyYBs(long r100) {
        float r101 = IntOffset.m7676getXimpl(r100);
        float r102 = IntOffset.m7677getYimpl(r100);
        long r103 = Float.floatToRawIntBits(r101);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final long IntOffset(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m7689minusNvtHpc(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) - IntOffset.m7676getXimpl(r101);
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - IntOffset.m7677getYimpl(r101);
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m7690minusoCl6YwE(long r100, long r101) {
        float r102 = IntOffset.m7676getXimpl(r100) - Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = IntOffset.m7677getYimpl(r100) - Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m7691plusNvtHpc(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) + IntOffset.m7676getXimpl(r101);
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) + IntOffset.m7677getYimpl(r101);
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m7692plusoCl6YwE(long r100, long r101) {
        float r102 = IntOffset.m7676getXimpl(r100) + Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = IntOffset.m7677getYimpl(r100) + Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m7688lerp81ZRxRo(long r100, long r101, float r102) {
        int r103 = MathHelpersKt.lerp(IntOffset.m7676getXimpl(r100), IntOffset.m7676getXimpl(r101), r102);
        int r104 = MathHelpersKt.lerp(IntOffset.m7677getYimpl(r100), IntOffset.m7677getYimpl(r101), r102);
        return IntOffset.m7670constructorimpl((((long) r103) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    }
}
