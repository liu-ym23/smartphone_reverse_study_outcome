package androidx.compose.material.ripple;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import p9.d;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010!\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\u00020\u0014*\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020\u0014*\u00020'H&¢\u0006\u0004\b(\u0010)J*\u00100\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020+2\u0006\u0010-\u001a\u00020,H&ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020*H&¢\u0006\u0004\b1\u00102R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00103R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b5\u00106R\u001a\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\n\u00107R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00108R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u00109\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u00106R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u00107R*\u0010B\u001a\u00020+2\u0006\u0010A\u001a\u00020+8\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00104R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0017\u0010L\u001a\u00020J8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bK\u0010E\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "", "bounded", "Landroidx/compose/ui/unit/Dp;", "radius", "Landroidx/compose/ui/graphics/ColorProducer;", TypedValues.Custom.S_COLOR, "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;LS7/a;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/foundation/interaction/PressInteraction;", "pressInteraction", "LC7/r;", "handlePressInteraction", "(Landroidx/compose/foundation/interaction/PressInteraction;)V", "Landroidx/compose/foundation/interaction/Interaction;", "interaction", "Lm9/z;", "scope", "updateStateLayer", "(Landroidx/compose/foundation/interaction/Interaction;Lm9/z;)V", "Landroidx/compose/ui/unit/IntSize;", "size", "onRemeasured-ozmzZPI", "(J)V", "onRemeasured", "onAttach", "()V", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/ui/geometry/Size;", "", "targetRadius", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "addRipple", "removeRipple", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "Landroidx/compose/foundation/interaction/InteractionSource;", "Z", "getBounded", "()Z", "F", "Landroidx/compose/ui/graphics/ColorProducer;", "LS7/a;", "getRippleAlpha", "()LS7/a;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "Landroidx/compose/material/ripple/StateLayer;", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "<set-?>", "rippleSize", "J", "getRippleSize-NH-jbRc", "()J", "hasValidSize", "Landroidx/collection/MutableObjectList;", "pendingInteractions", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/graphics/Color;", "getRippleColor-0d7_KjU", "rippleColor", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final boolean bounded;
    private final ColorProducer color;
    private boolean hasValidSize;
    private final InteractionSource interactionSource;
    private final MutableObjectList<PressInteraction> pendingInteractions;
    private final float radius;
    private final a rippleAlpha;
    private long rippleSize;
    private final boolean shouldAutoInvalidate;
    private StateLayer stateLayer;
    private float targetRadius;

    @c(c = "androidx.compose.material.ripple.RippleNode$onAttach$1", f = "Ripple.kt", l = {378}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material.ripple.RippleNode$onAttach$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = RippleNode.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                p9.c interactions = RippleNode.this.interactionSource.getInteractions();
                final RippleNode rippleNode = RippleNode.this;
                d dVar = new d() { // from class: androidx.compose.material.ripple.RippleNode.onAttach.1.1
                    @Override // p9.d
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                        return emit((Interaction) obj2, (H7.c<? super r>) cVar);
                    }

                    public final Object emit(Interaction interaction, H7.c<? super r> cVar) {
                        if (!(interaction instanceof PressInteraction)) {
                            rippleNode.updateStateLayer(interaction, interfaceC1733z);
                        } else if (rippleNode.hasValidSize) {
                            rippleNode.handlePressInteraction((PressInteraction) interaction);
                        } else {
                            rippleNode.pendingInteractions.add(interaction);
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
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ RippleNode(InteractionSource interactionSource, boolean z10, float f, ColorProducer colorProducer, a aVar, e eVar) {
        this(interactionSource, z10, f, colorProducer, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePressInteraction(PressInteraction pressInteraction) {
        if (pressInteraction instanceof PressInteraction.Press) {
            mo1476addRipple12SF9DM((PressInteraction.Press) pressInteraction, this.rippleSize, this.targetRadius);
        } else if (pressInteraction instanceof PressInteraction.Release) {
            removeRipple(((PressInteraction.Release) pressInteraction).getPress());
        } else if (pressInteraction instanceof PressInteraction.Cancel) {
            removeRipple(((PressInteraction.Cancel) pressInteraction).getPress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStateLayer(Interaction interaction, InterfaceC1733z scope) {
        StateLayer stateLayer = this.stateLayer;
        if (stateLayer == null) {
            stateLayer = new StateLayer(this.bounded, this.rippleAlpha);
            DrawModifierNodeKt.invalidateDraw(this);
            this.stateLayer = stateLayer;
        }
        stateLayer.handleInteraction$material_ripple_release(interaction, scope);
    }

    /* renamed from: addRipple-12SF9DM */
    public abstract void mo1476addRipple12SF9DM(PressInteraction.Press interaction, long size, float targetRadius);

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        StateLayer stateLayer = this.stateLayer;
        if (stateLayer != null) {
            stateLayer.m1494drawStateLayermxwnekA(contentDrawScope, this.targetRadius, m1489getRippleColor0d7_KjU());
        }
        drawRipples(contentDrawScope);
    }

    public abstract void drawRipples(DrawScope drawScope);

    public final boolean getBounded() {
        return this.bounded;
    }

    public final a getRippleAlpha() {
        return this.rippleAlpha;
    }

    /* renamed from: getRippleColor-0d7_KjU, reason: not valid java name */
    public final long m1489getRippleColor0d7_KjU() {
        return this.color.mo1813invoke0d7_KjU();
    }

    /* renamed from: getRippleSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getRippleSize() {
        return this.rippleSize;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        AbstractC1683A.n(getCoroutineScope(), null, new AnonymousClass1(null), 3);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo371onRemeasuredozmzZPI(long size) {
        this.hasValidSize = true;
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        this.rippleSize = IntSizeKt.m7027toSizeozmzZPI(size);
        this.targetRadius = Float.isNaN(this.radius) ? RippleAnimationKt.m1482getRippleEndRadiuscSwnlzA(densityRequireDensity, this.bounded, this.rippleSize) : densityRequireDensity.mo381toPx0680j_4(this.radius);
        MutableObjectList<PressInteraction> mutableObjectList = this.pendingInteractions;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            handlePressInteraction((PressInteraction) objArr[i6]);
        }
        this.pendingInteractions.clear();
    }

    public abstract void removeRipple(PressInteraction.Press interaction);

    private RippleNode(InteractionSource interactionSource, boolean z10, float f, ColorProducer colorProducer, a aVar) {
        this.interactionSource = interactionSource;
        this.bounded = z10;
        this.radius = f;
        this.color = colorProducer;
        this.rippleAlpha = aVar;
        this.rippleSize = Size.INSTANCE.m3973getZeroNHjbRc();
        this.pendingInteractions = new MutableObjectList<>(0, 1, null);
    }
}
