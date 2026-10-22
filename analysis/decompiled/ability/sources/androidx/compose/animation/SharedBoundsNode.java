package androidx.compose.animation;

import C7.r;
import S7.k;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J&\u0010\u001f\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J&\u0010)\u001a\u00020\u000f*\u00020&2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010+\u001a\u00020\u0012*\u00020*H\u0016¢\u0006\u0004\b+\u0010,R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00058\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\bR(\u00103\u001a\u0004\u0018\u0001022\b\u0010-\u001a\u0004\u0018\u0001028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00108\u001a\u0002078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u000bR\u0014\u0010?\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u000bR\u0014\u0010C\u001a\u00020@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/animation/SharedElementInternalState;", "state", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/SharedElementInternalState;)V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Placeable;", "placeable", "Landroidx/compose/ui/layout/MeasureResult;", "place", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/ui/layout/MeasureResult;", "LC7/r;", "updateCurrentBounds", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "onAttach", "()V", "onDetach", "onReset", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "isMeasurementApproachInProgress", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "value", "Landroidx/compose/animation/SharedElementInternalState;", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation_release", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "getRootCoords", "rootCoords", "getRootLookaheadCoords", "rootLookaheadCoords", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "boundsAnimation", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "sharedElement", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementInternalState state;

    public SharedBoundsNode(SharedElementInternalState sharedElementInternalState) {
        this.state = sharedElementInternalState;
        this.layer = sharedElementInternalState.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(new Pair(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoundsAnimation getBoundsAnimation() {
        return this.state.getBoundsAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getRootLookaheadCoords() {
        return getSharedElement().getScope().getLookaheadRoot$animation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement getSharedElement() {
        return this.state.getSharedElement();
    }

    private final MeasureResult place(MeasureScope measureScope, final Placeable placeable) {
        long jMo107calculateSizeJyjRU_E = this.state.getPlaceHolderSize().mo107calculateSizeJyjRU_E(requireLookaheadLayoutCoordinates().mo5557getSizeYbymL2g(), IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()));
        return MeasureScope.layout$default(measureScope, IntSize.m7015getWidthimpl(jMo107calculateSizeJyjRU_E), IntSize.m7014getHeightimpl(jMo107calculateSizeJyjRU_E), null, new k() { // from class: androidx.compose.animation.SharedBoundsNode.place.1
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
                long jM3930getTopLeftF1C5BW0;
                LayoutCoordinates coordinates;
                if (!SharedBoundsNode.this.getSharedElement().getFoundMatch()) {
                    LayoutCoordinates coordinates2 = placementScope.getCoordinates();
                    if (coordinates2 != null) {
                        SharedBoundsNode.this.updateCurrentBounds(coordinates2);
                    }
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                    return;
                }
                if (SharedBoundsNode.this.getSharedElement().getTargetBounds() != null) {
                    BoundsAnimation boundsAnimation = SharedBoundsNode.this.getBoundsAnimation();
                    Rect currentBounds = SharedBoundsNode.this.getSharedElement().getCurrentBounds();
                    kotlin.jvm.internal.k.c(currentBounds);
                    Rect targetBounds = SharedBoundsNode.this.getSharedElement().getTargetBounds();
                    kotlin.jvm.internal.k.c(targetBounds);
                    boundsAnimation.animate(currentBounds, targetBounds);
                }
                Rect value = SharedBoundsNode.this.getBoundsAnimation().getValue();
                LayoutCoordinates coordinates3 = placementScope.getCoordinates();
                Offset offsetM3884boximpl = coordinates3 != null ? Offset.m3884boximpl(SharedBoundsNode.this.getRootCoords().mo5558localPositionOfR5De75A(coordinates3, Offset.INSTANCE.m3911getZeroF1C5BW0())) : null;
                if (value != null) {
                    if (SharedBoundsNode.this.getBoundsAnimation().getTarget()) {
                        SharedBoundsNode.this.getSharedElement().setCurrentBounds(value);
                    }
                    jM3930getTopLeftF1C5BW0 = value.m3930getTopLeftF1C5BW0();
                } else {
                    if (SharedBoundsNode.this.getBoundsAnimation().getTarget() && (coordinates = placementScope.getCoordinates()) != null) {
                        SharedBoundsNode.this.updateCurrentBounds(coordinates);
                    }
                    Rect currentBounds2 = SharedBoundsNode.this.getSharedElement().getCurrentBounds();
                    kotlin.jvm.internal.k.c(currentBounds2);
                    jM3930getTopLeftF1C5BW0 = currentBounds2.m3930getTopLeftF1C5BW0();
                }
                long jM3899minusMKHz9U = offsetM3884boximpl != null ? Offset.m3899minusMKHz9U(jM3930getTopLeftF1C5BW0, offsetM3884boximpl.m3905unboximpl()) : Offset.INSTANCE.m3911getZeroF1C5BW0();
                Placeable.PlacementScope.place$default(placementScope, placeable, Math.round(Offset.m3895getXimpl(jM3899minusMKHz9U)), Math.round(Offset.m3896getYimpl(jM3899minusMKHz9U)), 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(this));
    }

    private final void setLayer(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.layer;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer2);
            }
        } else {
            this.state.setLayer(graphicsLayer);
        }
        this.layer = graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentBounds(LayoutCoordinates layoutCoordinates) {
        getSharedElement().setCurrentBounds(RectKt.m3935Recttz77jQw(getRootCoords().mo5558localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m3911getZeroF1C5BW0()), SizeKt.Size(IntSize.m7015getWidthimpl(layoutCoordinates.mo5557getSizeYbymL2g()), IntSize.m7014getHeightimpl(layoutCoordinates.mo5557getSizeYbymL2g()))));
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult mo101approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j5) {
        if (getSharedElement().getFoundMatch()) {
            Rect value = getBoundsAnimation().getValue();
            if (value == null) {
                value = getSharedElement().getCurrentBounds();
            }
            if (value != null) {
                long jM7023roundToIntSizeuvyYCjk = IntSizeKt.m7023roundToIntSizeuvyYCjk(value.m3928getSizeNHjbRc());
                int iM7015getWidthimpl = IntSize.m7015getWidthimpl(jM7023roundToIntSizeuvyYCjk);
                int iM7014getHeightimpl = IntSize.m7014getHeightimpl(jM7023roundToIntSizeuvyYCjk);
                if (iM7015getWidthimpl == Integer.MAX_VALUE || iM7014getHeightimpl == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + getBoundsAnimation().getValue() + ", current bounds: " + getSharedElement().getCurrentBounds()).toString());
                }
                Constraints.Companion companion = Constraints.INSTANCE;
                if (iM7015getWidthimpl < 0) {
                    iM7015getWidthimpl = 0;
                }
                if (iM7014getHeightimpl < 0) {
                    iM7014getHeightimpl = 0;
                }
                j5 = companion.m6807fixedJhjzzOo(iM7015getWidthimpl, iM7014getHeightimpl);
            }
        }
        return place(approachMeasureScope, measurable.mo5549measureBRTryo0(j5));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        SharedElementInternalState sharedElementInternalState = this.state;
        SharedTransitionScope.OverlayClip overlayClip = sharedElementInternalState.getOverlayClip();
        SharedTransitionScope.SharedContentState userState = this.state.getUserState();
        Rect currentBounds = getSharedElement().getCurrentBounds();
        kotlin.jvm.internal.k.c(currentBounds);
        sharedElementInternalState.setClipPathInOverlay$animation_release(overlayClip.getClipPath(userState, currentBounds, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.requireDensity(this)));
        GraphicsLayer layer = this.state.getLayer();
        if (layer != null) {
            DrawScope.m4705recordJVtK1S4$default(contentDrawScope, layer, 0L, new k() { // from class: androidx.compose.animation.SharedBoundsNode.draw.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DrawScope) obj);
                    return r.f317a;
                }

                public final void invoke(DrawScope drawScope) {
                    contentDrawScope.drawContent();
                }
            }, 1, null);
            if (this.state.getShouldRenderInPlace()) {
                GraphicsLayerKt.drawLayer(contentDrawScope, layer);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + getSharedElement().getKey() + ",target: " + this.state.getBoundsAnimation().getTarget() + ", is attached: " + getIsAttached()).toString());
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public final SharedElementInternalState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean mo102isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        return getSharedElement().getFoundMatch() && this.state.getSharedElement().getScope().isTransitionActive();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
        final long jSize = SizeKt.Size(placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight());
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Offset offsetM3884boximpl;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    SharedBoundsNode sharedBoundsNode = this;
                    long j6 = jSize;
                    long jMo5558localPositionOfR5De75A = sharedBoundsNode.getRootLookaheadCoords().mo5558localPositionOfR5De75A(coordinates, Offset.INSTANCE.m3911getZeroF1C5BW0());
                    if (sharedBoundsNode.getSharedElement().getCurrentBounds() == null) {
                        sharedBoundsNode.getSharedElement().setCurrentBounds(RectKt.m3935Recttz77jQw(jMo5558localPositionOfR5De75A, j6));
                    }
                    offsetM3884boximpl = Offset.m3884boximpl(jMo5558localPositionOfR5De75A);
                } else {
                    offsetM3884boximpl = null;
                }
                Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
                if (offsetM3884boximpl != null) {
                    SharedBoundsNode sharedBoundsNode2 = this;
                    sharedBoundsNode2.getSharedElement().m103onLookaheadResultv_w8tDc(sharedBoundsNode2.getState(), jSize, offsetM3884boximpl.m3905unboximpl());
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.state.setLookaheadCoords(new S7.a() { // from class: androidx.compose.animation.SharedBoundsNode.onAttach.1
            {
                super(0);
            }

            @Override // S7.a
            public final LayoutCoordinates invoke() {
                return SharedBoundsNode.this.requireLookaheadLayoutCoordinates();
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        setLayer(null);
        this.state.setParentState(null);
        this.state.setLookaheadCoords(new S7.a() { // from class: androidx.compose.animation.SharedBoundsNode.onDetach.1
            @Override // S7.a
            public final Void invoke() {
                return null;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    public final void setState$animation_release(SharedElementInternalState sharedElementInternalState) {
        if (kotlin.jvm.internal.k.b(sharedElementInternalState, this.state)) {
            return;
        }
        this.state = sharedElementInternalState;
        if (getIsAttached()) {
            provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), sharedElementInternalState);
            this.state.setParentState((SharedElementInternalState) getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
            this.state.setLayer(this.layer);
            this.state.setLookaheadCoords(new S7.a() { // from class: androidx.compose.animation.SharedBoundsNode$state$1
                {
                    super(0);
                }

                @Override // S7.a
                public final LayoutCoordinates invoke() {
                    return this.this$0.requireLookaheadLayoutCoordinates();
                }
            });
        }
    }
}
