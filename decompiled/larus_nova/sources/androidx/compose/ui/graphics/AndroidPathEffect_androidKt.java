package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0000\u001a/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\u0017*\u00020\u0013H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"asAndroidPathEffect", "Landroid/graphics/PathEffect;", "Landroidx/compose/ui/graphics/PathEffect;", "toComposePathEffect", "actualCornerPathEffect", "radius", "", "actualDashPathEffect", "intervals", "", "phase", "actualChainPathEffect", RNParamRegisterEventHandler.SRC_OUTER, RNParamRegisterEventHandler.SRC_INNER, "actualStampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "actualStampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "toAndroidPathDashPathEffectStyle", "Landroid/graphics/PathDashPathEffect$Style;", "toAndroidPathDashPathEffectStyle-oQv6xUo", "(I)Landroid/graphics/PathDashPathEffect$Style;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPathEffect_androidKt {
    public static final PathEffect actualCornerPathEffect(float r100) {
        return new AndroidPathEffect(new CornerPathEffect(r100));
    }

    public static final android.graphics.PathEffect asAndroidPathEffect(PathEffect r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return ((AndroidPathEffect) r100).getNativePathEffect();
    }

    /* JADX INFO: renamed from: toAndroidPathDashPathEffectStyle-oQv6xUo, reason: not valid java name */
    public static final PathDashPathEffect.Style m4722toAndroidPathDashPathEffectStyleoQv6xUo(int r100) {
        StampedPathEffectStyle.Companion r101 = StampedPathEffectStyle.Companion;
        if (StampedPathEffectStyle.m5192equalsimpl0(r100, r101.m5196getMorphYpspkwk()) == false) goto L6;
        return PathDashPathEffect.Style.MORPH;
    L6:
        if (StampedPathEffectStyle.m5192equalsimpl0(r100, r101.m5197getRotateYpspkwk()) == false) goto L9;
        return PathDashPathEffect.Style.ROTATE;
    L9:
        if (StampedPathEffectStyle.m5192equalsimpl0(r100, r101.m5198getTranslateYpspkwk()) == false) goto L12;
        return PathDashPathEffect.Style.TRANSLATE;
    L12:
        return PathDashPathEffect.Style.TRANSLATE;
    }

    public static final PathEffect toComposePathEffect(android.graphics.PathEffect r100) {
        return new AndroidPathEffect(r100);
    }

    public static final PathEffect actualChainPathEffect(PathEffect r100, PathEffect r101) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        android.graphics.PathEffect r102 = ((AndroidPathEffect) r100).getNativePathEffect();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return new AndroidPathEffect(new ComposePathEffect(r102, ((AndroidPathEffect) r101).getNativePathEffect()));
    }

    public static final PathEffect actualDashPathEffect(float[] r100, float r101) {
        return new AndroidPathEffect(new DashPathEffect(r100, r101));
    }

    /* JADX INFO: renamed from: actualStampedPathEffect-7aD1DOk, reason: not valid java name */
    public static final PathEffect m4721actualStampedPathEffect7aD1DOk(Path r100, float r101, float r102, int r103) {
        if ((r100 instanceof AndroidPath) == false) goto L7;
        return new AndroidPathEffect(new PathDashPathEffect(((AndroidPath) r100).getInternalPath(), r101, r102, m4722toAndroidPathDashPathEffectStyleoQv6xUo(r103)));
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
