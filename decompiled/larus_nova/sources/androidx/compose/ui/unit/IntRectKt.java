package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0016H\u0007¨\u0006\u0018"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "topLeft", "bottomRight", "IntRect-E1MhUcY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "toRect", "Landroidx/compose/ui/geometry/Rect;", "roundToIntRect", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntRectKt {
    public static final IntRect roundToIntRect(Rect r100) {
        return new IntRect(Math.round(r100.getLeft()), Math.round(r100.getTop()), Math.round(r100.getRight()), Math.round(r100.getBottom()));
    }

    public static final Rect toRect(IntRect r100) {
        return new Rect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m7708IntRectE1MhUcY(long r100, long r101) {
        return new IntRect(IntOffset.m7676getXimpl(r100), IntOffset.m7677getYimpl(r100), IntOffset.m7676getXimpl(r101), IntOffset.m7677getYimpl(r101));
    }

    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m7709IntRectVbeCjmY(long r100, long r101) {
        return new IntRect(IntOffset.m7676getXimpl(r100), IntOffset.m7677getYimpl(r100), IntOffset.m7676getXimpl(r100) + ((int) (r101 >> 32)), IntOffset.m7677getYimpl(r100) + ((int) (r101 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m7710IntRectar5cAso(long r100, int r101) {
        return new IntRect(IntOffset.m7676getXimpl(r100) - r101, IntOffset.m7677getYimpl(r100) - r101, IntOffset.m7676getXimpl(r100) + r101, IntOffset.m7677getYimpl(r100) + r101);
    }

    public static final IntRect lerp(IntRect r100, IntRect r101, float r102) {
        return new IntRect(MathHelpersKt.lerp(r100.getLeft(), r101.getLeft(), r102), MathHelpersKt.lerp(r100.getTop(), r101.getTop(), r102), MathHelpersKt.lerp(r100.getRight(), r101.getRight(), r102), MathHelpersKt.lerp(r100.getBottom(), r101.getBottom(), r102));
    }
}
