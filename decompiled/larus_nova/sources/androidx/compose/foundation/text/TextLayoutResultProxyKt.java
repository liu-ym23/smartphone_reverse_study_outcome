package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResultProxyKt {
    /* JADX INFO: renamed from: access$coerceIn-3MmeM6k, reason: not valid java name */
    public static final /* synthetic */ long m1165access$coerceIn3MmeM6k(long r100, Rect r101) {
        return m1166coerceIn3MmeM6k(r100, r101);
    }

    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    private static final long m1166coerceIn3MmeM6k(long r100, Rect r101) {
        int r102 = (int) (r100 >> 32);
        if (Float.intBitsToFloat(r102) >= r101.getLeft()) goto L6;
        float r103 = r101.getLeft();
    L9:
        int r104 = (int) (r100 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r104) >= r101.getTop()) goto L13;
        float r105 = r101.getTop();
    L17:
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r105) & BodyPartID.bodyIdMax));
    L13:
        if (Float.intBitsToFloat(r104) <= r101.getBottom()) goto L15;
        r105 = r101.getBottom();
        goto L17
    L15:
        r105 = Float.intBitsToFloat(r104);
        goto L17
    L6:
        if (Float.intBitsToFloat(r102) <= r101.getRight()) goto L8;
        r103 = r101.getRight();
        goto L9
    L8:
        r103 = Float.intBitsToFloat(r102);
        goto L9
    }
}
