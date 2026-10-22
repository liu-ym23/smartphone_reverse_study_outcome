package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aH\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002\u001aR\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"MarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "spacing", "Landroidx/compose/ui/unit/Dp;", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "repeatDelayMillis", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicMarqueeKt {
    /* renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m243MarqueeSpacing0680j_4(float f) {
        return new a(f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MarqueeSpacing_0680j_4$lambda$1(float f, Density density, int i, int i6) {
        return density.mo375roundToPx0680j_4(f);
    }

    @Stable
    /* renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m245basicMarquee1Mj1MLw(Modifier modifier, int i, int i6, int i10, int i11, MarqueeSpacing marqueeSpacing, float f) {
        return modifier.then(new MarqueeModifierElement(i, i6, i10, i11, marqueeSpacing, f, null));
    }

    /* renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m246basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i6, int i10, int i11, MarqueeSpacing marqueeSpacing, float f, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = MarqueeDefaults.INSTANCE.getIterations();
        }
        if ((i12 & 2) != 0) {
            i6 = MarqueeAnimationMode.INSTANCE.m321getImmediatelyZbEOnfQ();
        }
        if ((i12 & 4) != 0) {
            i10 = MarqueeDefaults.INSTANCE.getRepeatDelayMillis();
        }
        if ((i12 & 8) != 0) {
            i11 = MarqueeAnimationMode.m317equalsimpl0(i6, MarqueeAnimationMode.INSTANCE.m321getImmediatelyZbEOnfQ()) ? i10 : 0;
        }
        if ((i12 & 16) != 0) {
            marqueeSpacing = MarqueeDefaults.INSTANCE.getSpacing();
        }
        if ((i12 & 32) != 0) {
            f = MarqueeDefaults.INSTANCE.m323getVelocityD9Ej5fM();
        }
        return m245basicMarquee1Mj1MLw(modifier, i, i6, i10, i11, marqueeSpacing, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m247createMarqueeAnimationSpecZ4HSEVQ(int i, float f, int i6, int i10, float f7, Density density) {
        TweenSpec<Float> tweenSpecVelocityBasedTween = velocityBasedTween(Math.abs(density.mo381toPx0680j_4(f7)), f, i10);
        long jM175constructorimpl$default = StartOffset.m175constructorimpl$default((-i10) + i6, 0, 2, null);
        return i == Integer.MAX_VALUE ? AnimationSpecKt.m139infiniteRepeatable9IiC70o$default(tweenSpecVelocityBasedTween, null, jM175constructorimpl$default, 2, null) : AnimationSpecKt.m141repeatable91I0pcU$default(i, tweenSpecVelocityBasedTween, null, jM175constructorimpl$default, 4, null);
    }

    private static final TweenSpec<Float> velocityBasedTween(float f, float f7, int i) {
        return AnimationSpecKt.tween((int) Math.ceil(f7 / (f / 1000.0f)), i, EasingKt.getLinearEasing());
    }
}
