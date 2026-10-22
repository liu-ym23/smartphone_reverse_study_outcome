package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "FadeInDuration", "", "RadiusDuration", "FadeOutDuration", "material-ripple"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = 0.0f;
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    static {
        BoundedRippleExtraRadius = Dp.m7544constructorimpl(10);
    }

    /* JADX INFO: renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m1823getRippleStartRadiusuvyYCjk(long r100) {
        return Math.max(Size.m4651getWidthimpl(r100), Size.m4648getHeightimpl(r100)) * 0.3f;
    }

    /* JADX INFO: renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m1822getRippleEndRadiuscSwnlzA(Density r100, boolean r101, long r102) {
        float r103 = Offset.m4580getDistanceimpl(OffsetKt.Offset(Size.m4651getWidthimpl(r102), Size.m4648getHeightimpl(r102))) / 2.0f;
        if (r101 == true) goto L5;
        return r103;
    L5:
        return r103 + r100.mo371toPx0680j_4(BoundedRippleExtraRadius);
    }
}
