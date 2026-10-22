package androidx.compose.material3.carousel;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.pager.PagerDefaults;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0011R\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u00020\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u000e\u0010\u001b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/CarouselDefaults;", "", "<init>", "()V", "singleAdvanceFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/material3/carousel/CarouselState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "multiBrowseFlingBehavior", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "noSnapFlingBehavior", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "MinSmallItemSize", "Landroidx/compose/ui/unit/Dp;", "getMinSmallItemSize-D9Ej5fM", "()F", FaceService.girlLabel, "MaxSmallItemSize", "getMaxSmallItemSize-D9Ej5fM", "AnchorSize", "getAnchorSize-D9Ej5fM$material3", "MediumLargeItemDiffThreshold", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CarouselDefaults {
    public static final int $stable = 0;
    private static final float AnchorSize = 0.0f;
    public static final CarouselDefaults INSTANCE = null;
    private static final float MaxSmallItemSize = 0.0f;
    public static final float MediumLargeItemDiffThreshold = 0.85f;
    private static final float MinSmallItemSize = 0.0f;

    private CarouselDefaults() {
    }

    static {
        INSTANCE = new CarouselDefaults();
        MinSmallItemSize = Dp.m7544constructorimpl(40);
        MaxSmallItemSize = Dp.m7544constructorimpl(56);
        AnchorSize = Dp.m7544constructorimpl(10);
    }

    /* JADX INFO: renamed from: getAnchorSize-D9Ej5fM$material3, reason: not valid java name */
    public final float m3106getAnchorSizeD9Ej5fM$material3() {
        return AnchorSize;
    }

    /* JADX INFO: renamed from: getMaxSmallItemSize-D9Ej5fM, reason: not valid java name */
    public final float m3107getMaxSmallItemSizeD9Ej5fM() {
        return MaxSmallItemSize;
    }

    /* JADX INFO: renamed from: getMinSmallItemSize-D9Ej5fM, reason: not valid java name */
    public final float m3108getMinSmallItemSizeD9Ej5fM() {
        return MinSmallItemSize;
    }

    public final TargetedFlingBehavior noSnapFlingBehavior(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-418415756, r101, -1, "androidx.compose.material3.carousel.CarouselDefaults.noSnapFlingBehavior (Carousel.kt:845)");
    L5:
        Object r102 = r100.rememberedValue();
        if (r102 != Composer.Companion.getEmpty()) goto L8;
        r102 = new CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1();
        r100.updateRememberedValue(r102);
    L8:
        TargetedFlingBehavior r103 = SnapFlingBehaviorKt.rememberSnapFlingBehavior((CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1) r102, r100, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r103;
    }

    public final TargetedFlingBehavior singleAdvanceFlingBehavior(CarouselState r110, AnimationSpec<Float> r111, Composer r112, int r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        r111 = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    L5:
        AnimationSpec<Float> r100 = r111;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1701587199, r113, -1, "androidx.compose.material3.carousel.CarouselDefaults.singleAdvanceFlingBehavior (Carousel.kt:783)");
    L8:
        TargetedFlingBehavior r115 = PagerDefaults.INSTANCE.flingBehavior(r110.getPagerState$material3(), PagerSnapDistance.Companion.atMost(1), null, r100, 0.0f, r112, ((r113 << 6) & 7168) | (PagerDefaults.$stable << 15), 20);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r115;
    }

    public final TargetedFlingBehavior multiBrowseFlingBehavior(CarouselState r110, DecayAnimationSpec<Float> r111, AnimationSpec<Float> r112, Composer r113, int r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        r111 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r113, 0);
    L5:
        DecayAnimationSpec<Float> r100 = r111;
        if ((r115 & 4) == 0) goto L8;
        r112 = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    L8:
        AnimationSpec<Float> r101 = r112;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1105043293, r114, -1, "androidx.compose.material3.carousel.CarouselDefaults.multiBrowseFlingBehavior (Carousel.kt:816)");
    L11:
        PagerSnapDistance r102 = new CarouselDefaults$multiBrowseFlingBehavior$pagerSnapDistance$1();
        PagerDefaults r103 = PagerDefaults.INSTANCE;
        CarouselPagerState r104 = r110.getPagerState$material3();
        int r116 = r114 << 3;
        int r117 = r116 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT;
        TargetedFlingBehavior r118 = r103.flingBehavior(r104, r102, r100, r101, 0.0f, r113, ((r116 & 7168) | r117) | (PagerDefaults.$stable << 15), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r118;
    }
}
