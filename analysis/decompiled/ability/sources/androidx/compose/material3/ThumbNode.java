package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import p9.d;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001bR$\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "", "checked", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "LC7/r;", "onAttach", "()V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "update", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "Z", "getChecked", "()Z", "setChecked", "(Z)V", "isPressed", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "sizeAnim", "initialOffset", "F", "initialSize", "getShouldAutoInvalidate", "shouldAutoInvalidate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private boolean checked;
    private float initialOffset = Float.NaN;
    private float initialSize = Float.NaN;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable<Float, AnimationVector1D> offsetAnim;
    private Animatable<Float, AnimationVector1D> sizeAnim;

    @J7.c(c = "androidx.compose.material3.ThumbNode$onAttach$1", f = "Switch.kt", l = {220}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.ThumbNode$onAttach$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ThumbNode.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                p9.c interactions = ThumbNode.this.getInteractionSource().getInteractions();
                final ThumbNode thumbNode = ThumbNode.this;
                d dVar = new d() { // from class: androidx.compose.material3.ThumbNode.onAttach.1.1
                    @Override // p9.d
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                        return emit((Interaction) obj2, (H7.c<? super r>) cVar);
                    }

                    public final Object emit(Interaction interaction, H7.c<? super r> cVar) {
                        if (interaction instanceof PressInteraction.Press) {
                            ref$IntRef.f4918a++;
                        } else if (interaction instanceof PressInteraction.Release) {
                            Ref$IntRef ref$IntRef2 = ref$IntRef;
                            ref$IntRef2.f4918a--;
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            Ref$IntRef ref$IntRef3 = ref$IntRef;
                            ref$IntRef3.f4918a--;
                        }
                        boolean z10 = ref$IntRef.f4918a > 0;
                        if (thumbNode.isPressed != z10) {
                            thumbNode.isPressed = z10;
                            LayoutModifierNodeKt.invalidateMeasurement(thumbNode);
                        }
                        return r.f317a;
                    }
                };
                this.label = 1;
                if (interactions.collect(dVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ThumbNode(InteractionSource interactionSource, boolean z10) {
        this.interactionSource = interactionSource;
        this.checked = z10;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        float fMo381toPx0680j_4 = measureScope.mo381toPx0680j_4(this.isPressed ? SwitchTokens.INSTANCE.m3296getPressedHandleWidthD9Ej5fM() : ((measurable.maxIntrinsicHeight(Constraints.m6797getMaxWidthimpl(j5)) != 0 && measurable.maxIntrinsicWidth(Constraints.m6796getMaxHeightimpl(j5)) != 0) || this.checked) ? SwitchKt.getThumbDiameter() : SwitchKt.getUncheckedThumbDiameter());
        Animatable<Float, AnimationVector1D> animatable = this.sizeAnim;
        int iFloatValue = (int) (animatable != null ? animatable.getValue().floatValue() : fMo381toPx0680j_4);
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(iFloatValue, iFloatValue));
        final float fMo381toPx0680j_42 = measureScope.mo381toPx0680j_4(Dp.m6844constructorimpl(Dp.m6844constructorimpl(SwitchKt.SwitchHeight - measureScope.mo377toDpu2uoSUM(fMo381toPx0680j_4)) / 2.0f));
        float fMo381toPx0680j_43 = measureScope.mo381toPx0680j_4(Dp.m6844constructorimpl(Dp.m6844constructorimpl(SwitchKt.SwitchWidth - SwitchKt.getThumbDiameter()) - SwitchKt.ThumbPadding));
        boolean z10 = this.isPressed;
        if (z10 && this.checked) {
            fMo381toPx0680j_42 = fMo381toPx0680j_43 - measureScope.mo381toPx0680j_4(SwitchTokens.INSTANCE.m3302getTrackOutlineWidthD9Ej5fM());
        } else if (z10 && !this.checked) {
            fMo381toPx0680j_42 = measureScope.mo381toPx0680j_4(SwitchTokens.INSTANCE.m3302getTrackOutlineWidthD9Ej5fM());
        } else if (this.checked) {
            fMo381toPx0680j_42 = fMo381toPx0680j_43;
        }
        Animatable<Float, AnimationVector1D> animatable2 = this.sizeAnim;
        if (!k.a(animatable2 != null ? animatable2.getTargetValue() : null, fMo381toPx0680j_4)) {
            AbstractC1683A.n(getCoroutineScope(), null, new ThumbNode$measure$1(this, fMo381toPx0680j_4, null), 3);
        }
        Animatable<Float, AnimationVector1D> animatable3 = this.offsetAnim;
        if (!k.a(animatable3 != null ? animatable3.getTargetValue() : null, fMo381toPx0680j_42)) {
            AbstractC1683A.n(getCoroutineScope(), null, new ThumbNode$measure$2(this, fMo381toPx0680j_42, null), 3);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = fMo381toPx0680j_4;
            this.initialOffset = fMo381toPx0680j_42;
        }
        return MeasureScope.layout$default(measureScope, iFloatValue, iFloatValue, null, new S7.k() { // from class: androidx.compose.material3.ThumbNode$measure$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable = placeableMo5549measureBRTryo0;
                Animatable animatable4 = this.offsetAnim;
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (int) (animatable4 != null ? ((Number) animatable4.getValue()).floatValue() : fMo381toPx0680j_42), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        AbstractC1683A.n(getCoroutineScope(), null, new AnonymousClass1(null), 3);
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        this.interactionSource = interactionSource;
    }

    public final void update() {
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, 0.0f, 2, null);
        }
        if (this.offsetAnim != null || Float.isNaN(this.initialOffset)) {
            return;
        }
        this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, 0.0f, 2, null);
    }
}
