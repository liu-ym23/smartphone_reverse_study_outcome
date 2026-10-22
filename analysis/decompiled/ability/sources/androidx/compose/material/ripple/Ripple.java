package androidx.compose.material.ripple;

import C7.c;
import S7.n;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.b;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Stable
@c
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b!\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H'ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "", "bounded", "Landroidx/compose/ui/unit/Dp;", "radius", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, AppAgent.CONSTRUCT, "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedInstance", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "rememberUpdatedRippleInstance", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "F", "Landroidx/compose/runtime/State;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Ripple implements Indication {
    public static final int $stable = 0;
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;

    public /* synthetic */ Ripple(boolean z10, float f, State state, e eVar) {
        this(z10, f, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) other;
        return this.bounded == ripple.bounded && Dp.m6849equalsimpl0(this.radius, ripple.radius) && k.b(this.color, ripple.color);
    }

    public int hashCode() {
        return this.color.hashCode() + b.b(this.radius, Boolean.hashCode(this.bounded) * 31, 31);
    }

    @Override // androidx.compose.foundation.Indication
    @c
    @Composable
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer, int i) {
        long jMo1480defaultColorWaAFU9c;
        composer.startReplaceGroup(988743187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(988743187, i, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.getLocalRippleTheme());
        if (this.color.getValue().m4149unboximpl() != Color.INSTANCE.m4175getUnspecified0d7_KjU()) {
            composer.startReplaceGroup(-303571590);
            composer.endReplaceGroup();
            jMo1480defaultColorWaAFU9c = this.color.getValue().m4149unboximpl();
        } else {
            composer.startReplaceGroup(-303521246);
            jMo1480defaultColorWaAFU9c = rippleTheme.mo1480defaultColorWaAFU9c(composer, 0);
            composer.endReplaceGroup();
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(jMo1480defaultColorWaAFU9c), composer, 0);
        State<RippleAlpha> stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(rippleTheme.rippleAlpha(composer, 0), composer, 0);
        int i6 = i & 14;
        RippleIndicationInstance rippleIndicationInstanceMo1478rememberUpdatedRippleInstance942rkJo = mo1478rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, stateRememberUpdatedState, stateRememberUpdatedState2, composer, i6 | ((i << 12) & 458752));
        boolean zChangedInstance = composer.changedInstance(rippleIndicationInstanceMo1478rememberUpdatedRippleInstance942rkJo) | (((i6 ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Ripple$rememberUpdatedInstance$1$1(interactionSource, rippleIndicationInstanceMo1478rememberUpdatedRippleInstance942rkJo, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        EffectsKt.LaunchedEffect(rippleIndicationInstanceMo1478rememberUpdatedRippleInstance942rkJo, interactionSource, (n) objRememberedValue, composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rippleIndicationInstanceMo1478rememberUpdatedRippleInstance942rkJo;
    }

    @Composable
    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo1478rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z10, float f, State<Color> state, State<RippleAlpha> state2, Composer composer, int i);

    private Ripple(boolean z10, float f, State<Color> state) {
        this.bounded = z10;
        this.radius = f;
        this.color = state;
    }
}
