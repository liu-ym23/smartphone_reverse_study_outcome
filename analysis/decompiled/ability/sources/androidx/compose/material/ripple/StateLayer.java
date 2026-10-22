package androidx.compose.material.ripple;

import D7.v;
import S7.a;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0018\u001a\u00020\r*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "", "bounded", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha", AppAgent.CONSTRUCT, "(ZLS7/a;)V", "Landroidx/compose/foundation/interaction/Interaction;", "interaction", "Lm9/z;", "scope", "LC7/r;", "handleInteraction$material_ripple_release", "(Landroidx/compose/foundation/interaction/Interaction;Lm9/z;)V", "handleInteraction", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "radius", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "drawStateLayer", "Z", "LS7/a;", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "interactions", "Ljava/util/List;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final a rippleAlpha;
    private final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List<Interaction> interactions = new ArrayList();

    public StateLayer(boolean z10, a aVar) {
        this.bounded = z10;
        this.rippleAlpha = aVar;
    }

    /* renamed from: drawStateLayer-mxwnekA, reason: not valid java name */
    public final void m1494drawStateLayermxwnekA(DrawScope drawScope, float f, long j5) {
        float fFloatValue = this.animatedAlpha.getValue().floatValue();
        if (fFloatValue > 0.0f) {
            long jM4138copywmQWz5c$default = Color.m4138copywmQWz5c$default(j5, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (!this.bounded) {
                DrawScope.m4688drawCircleVaOC9Bg$default(drawScope, jM4138copywmQWz5c$default, f, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float fM3964getWidthimpl = Size.m3964getWidthimpl(drawScope.mo4707getSizeNHjbRc());
            float fM3961getHeightimpl = Size.m3961getHeightimpl(drawScope.mo4707getSizeNHjbRc());
            int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo4631clipRectN_I0leg(0.0f, 0.0f, fM3964getWidthimpl, fM3961getHeightimpl, iM4128getIntersectrtfAjoo);
            DrawScope.m4688drawCircleVaOC9Bg$default(drawScope, jM4138copywmQWz5c$default, f, 0L, 0.0f, null, null, 0, 124, null);
            androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, InterfaceC1733z scope) {
        boolean z10 = interaction instanceof HoverInteraction.Enter;
        if (z10) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction.Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) v.L0(this.interactions);
        if (k.b(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            RippleAlpha rippleAlpha = (RippleAlpha) this.rippleAlpha.invoke();
            AbstractC1683A.n(scope, null, new StateLayer$handleInteraction$1(this, z10 ? rippleAlpha.getHoveredAlpha() : interaction instanceof FocusInteraction.Focus ? rippleAlpha.getFocusedAlpha() : interaction instanceof DragInteraction.Start ? rippleAlpha.getDraggedAlpha() : 0.0f, RippleKt.incomingStateLayerAnimationSpecFor(interaction2), null), 3);
        } else {
            AbstractC1683A.n(scope, null, new StateLayer$handleInteraction$2(this, RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), null), 3);
        }
        this.currentInteraction = interaction2;
    }
}
