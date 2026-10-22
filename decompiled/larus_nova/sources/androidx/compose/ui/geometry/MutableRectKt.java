package androidx.compose.ui.geometry;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\t\u001a\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "MutableRect", "offset", "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/geometry/Size;", "MutableRect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/MutableRect;", "topLeft", "bottomRight", "MutableRect-0a9Yr6o", "center", "radius", "", "MutableRect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/MutableRect;", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MutableRectKt {
    public static final Rect toRect(MutableRect r100) {
        return new Rect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    /* JADX INFO: renamed from: MutableRect-0a9Yr6o, reason: not valid java name */
    public static final MutableRect m4568MutableRect0a9Yr6o(long r100, long r101) {
        return new MutableRect(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: MutableRect-3MmeM6k, reason: not valid java name */
    public static final MutableRect m4569MutableRect3MmeM6k(long r100, float r101) {
        int r102 = (int) (r100 >> 32);
        float r103 = Float.intBitsToFloat(r102) - r101;
        int r104 = (int) (r100 & BodyPartID.bodyIdMax);
        return new MutableRect(r103, Float.intBitsToFloat(r104) - r101, Float.intBitsToFloat(r102) + r101, Float.intBitsToFloat(r104) + r101);
    }

    /* JADX INFO: renamed from: MutableRect-tz77jQw, reason: not valid java name */
    public static final MutableRect m4570MutableRecttz77jQw(long r100, long r110) {
        int r101 = (int) (r100 >> 32);
        float r102 = Float.intBitsToFloat(r101);
        int r103 = (int) (r100 & BodyPartID.bodyIdMax);
        return new MutableRect(r102, Float.intBitsToFloat(r103), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r110 >> 32)), Float.intBitsToFloat(r103) + Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)));
    }
}
