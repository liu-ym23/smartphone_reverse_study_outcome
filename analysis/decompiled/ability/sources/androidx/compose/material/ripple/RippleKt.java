package androidx.compose.material.ripple;

import C7.c;
import S7.a;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0019\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "", "bounded", "Landroidx/compose/ui/unit/Dp;", "radius", "Landroidx/compose/ui/graphics/ColorProducer;", TypedValues.Custom.S_COLOR, "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha", "Landroidx/compose/ui/node/DelegatableNode;", "createRippleModifierNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;LS7/a;)Landroidx/compose/ui/node/DelegatableNode;", "createRippleModifierNode", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/foundation/Indication;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "rememberRipple", "Landroidx/compose/foundation/interaction/Interaction;", "interaction", "Landroidx/compose/animation/core/AnimationSpec;", "", "incomingStateLayerAnimationSpecFor", "(Landroidx/compose/foundation/interaction/Interaction;)Landroidx/compose/animation/core/AnimationSpec;", "outgoingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/TweenSpec;", "DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleKt {
    private static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec<>(15, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: createRippleModifierNode-TDGSqEk, reason: not valid java name */
    public static final DelegatableNode m1487createRippleModifierNodeTDGSqEk(InteractionSource interactionSource, boolean z10, float f, ColorProducer colorProducer, a aVar) {
        return Ripple_androidKt.m1493createPlatformRippleNodeTDGSqEk(interactionSource, z10, f, colorProducer, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        if (interaction instanceof HoverInteraction.Enter) {
            return DefaultTweenSpec;
        }
        if (!(interaction instanceof FocusInteraction.Focus) && !(interaction instanceof DragInteraction.Start)) {
            return DefaultTweenSpec;
        }
        return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        if (!(interaction instanceof HoverInteraction.Enter) && !(interaction instanceof FocusInteraction.Focus) && (interaction instanceof DragInteraction.Start)) {
            return new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, null);
        }
        return DefaultTweenSpec;
    }

    @c
    @Composable
    /* renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final Indication m1488rememberRipple9IZ8Weo(boolean z10, float f, long j5, Composer composer, int i, int i6) {
        boolean z11 = true;
        if ((i6 & 1) != 0) {
            z10 = true;
        }
        if ((i6 & 2) != 0) {
            f = Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM();
        }
        if ((i6 & 4) != 0) {
            j5 = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1635163520, i, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:146)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(j5), composer, (i >> 6) & 14);
        boolean z12 = (((i & 14) ^ 6) > 4 && composer.changed(z10)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(f)) && (i & 48) != 32) {
            z11 = false;
        }
        boolean z13 = z12 | z11;
        Object objRememberedValue = composer.rememberedValue();
        if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PlatformRipple(z10, f, stateRememberUpdatedState, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        PlatformRipple platformRipple = (PlatformRipple) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return platformRipple;
    }
}
