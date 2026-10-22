package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CornerRadiusKt {
    public static final long CornerRadius(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m4555lerp3Ry4LBc(long r100, long r101, float r102) {
        float r103 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r101 >> 32)), r102);
        float r104 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)), r102);
        return CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }

    public static /* synthetic */ long CornerRadius$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = r100;
    L5:
        long r104 = Float.floatToRawIntBits(r100);
        return CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r104 << 32));
    }
}
