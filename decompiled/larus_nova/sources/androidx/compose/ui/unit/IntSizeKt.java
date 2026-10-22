package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0013\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0013\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0013\"\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"IntSize", "Landroidx/compose/ui/unit/IntSize;", "width", "", "height", "(II)J", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "center", "Landroidx/compose/ui/unit/IntOffset;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "toSize", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "toIntSize", "toIntSize-uvyYCjk", "roundToIntSize", "roundToIntSize-uvyYCjk", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntSizeKt {
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m7726getCenterozmzZPI$annotations(long r100) {
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m7725getCenterozmzZPI(long r100) {
        long r101 = (r100 >> 33) << 32;
        return IntOffset.m7670constructorimpl((((r100 << 32) >> 33) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m7727roundToIntSizeuvyYCjk(long r100) {
        int r101 = Math.round(Float.intBitsToFloat((int) (r100 >> 32)));
        long r102 = ((long) Math.round(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax;
        return IntSize.m7714constructorimpl(r102 | (((long) r101) << 32));
    }

    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m7729toIntRectozmzZPI(long r100) {
        return IntRectKt.m7709IntRectVbeCjmY(IntOffset.Companion.m7687getZeronOccac(), r100);
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m7730toIntSizeuvyYCjk(long r100) {
        int r101 = (int) Float.intBitsToFloat((int) (r100 >> 32));
        long r102 = ((long) ((int) Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax;
        return IntSize.m7714constructorimpl(r102 | (((long) r101) << 32));
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m7731toSizeozmzZPI(long r100) {
        float r101 = (int) (r100 >> 32);
        float r102 = (int) (r100 & BodyPartID.bodyIdMax);
        long r103 = Float.floatToRawIntBits(r101);
        return Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final long IntSize(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return IntSize.m7714constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m7728timesO0kMr_c(int r100, long r101) {
        return IntSize.m7721timesYEO4UFw(r101, r100);
    }
}
