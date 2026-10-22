package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007¨\u0006\u0014"}, d2 = {"Rect", "Landroidx/compose/ui/geometry/Rect;", "offset", "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/Rect;", "topLeft", "bottomRight", "Rect-0a9Yr6o", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RectKt {
    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m4620Rect0a9Yr6o(long r100, long r101) {
        return new Rect(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m4621Rect3MmeM6k(long r100, float r101) {
        int r102 = (int) (r100 >> 32);
        float r103 = Float.intBitsToFloat(r102) - r101;
        int r104 = (int) (r100 & BodyPartID.bodyIdMax);
        return new Rect(r103, Float.intBitsToFloat(r104) - r101, Float.intBitsToFloat(r102) + r101, Float.intBitsToFloat(r104) + r101);
    }

    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m4622Recttz77jQw(long r100, long r110) {
        int r101 = (int) (r100 >> 32);
        float r102 = Float.intBitsToFloat(r101);
        int r103 = (int) (r100 & BodyPartID.bodyIdMax);
        return new Rect(r102, Float.intBitsToFloat(r103), Float.intBitsToFloat(r101) + Float.intBitsToFloat((int) (r110 >> 32)), Float.intBitsToFloat(r103) + Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)));
    }

    public static final Rect lerp(Rect r100, Rect r101, float r102) {
        return new Rect(MathHelpersKt.lerp(r100.getLeft(), r101.getLeft(), r102), MathHelpersKt.lerp(r100.getTop(), r101.getTop(), r102), MathHelpersKt.lerp(r100.getRight(), r101.getRight(), r102), MathHelpersKt.lerp(r100.getBottom(), r101.getBottom(), r102));
    }
}
