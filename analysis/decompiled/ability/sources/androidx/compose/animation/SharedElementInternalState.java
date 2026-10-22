package androidx.compose.animation;

import C7.r;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001c\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010\u001eR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010\r\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u00100\"\u0004\b1\u00102R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010)\u001a\u0004\b4\u00105\"\u0004\b6\u00107R+\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010)\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R+\u0010\n\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010)\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R+\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010)\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010)\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u0004\u0018\u00010\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R/\u0010e\u001a\u0004\u0018\u00010_2\b\u0010!\u001a\u0004\u0018\u00010_8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010)\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0017\u0010h\u001a\u00020f8Fø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u001a\u0004\bg\u0010\u001bR\u0011\u0010j\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bi\u0010+R\u0014\u0010l\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bk\u0010+R\u0011\u0010n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bm\u0010+R\u0014\u0010p\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010+\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006q"}, d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/animation/SharedElement;", "sharedElement", "Landroidx/compose/animation/BoundsAnimation;", "boundsAnimation", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "placeHolderSize", "", "renderOnlyWhenVisible", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "overlayClip", "renderInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "userState", "", "zIndex", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawScope", "LC7/r;", "drawInOverlay", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "Landroidx/compose/ui/geometry/Offset;", "calculateLookaheadOffset-F1C5BW0", "()J", "calculateLookaheadOffset", "onRemembered", "()V", "onForgotten", "onAbandoned", "<set-?>", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getZIndex", "()F", "setZIndex", "(F)V", "renderInOverlayDuringTransition$delegate", "Landroidx/compose/runtime/MutableState;", "getRenderInOverlayDuringTransition", "()Z", "setRenderInOverlayDuringTransition", "(Z)V", "sharedElement$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "boundsAnimation$delegate", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "placeHolderSize$delegate", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "renderOnlyWhenVisible$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "overlayClip$delegate", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "userState$delegate", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "Landroidx/compose/ui/graphics/Path;", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation_release", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation_release", "(Landroidx/compose/ui/graphics/Path;)V", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoords", "LS7/a;", "getLookaheadCoords", "()LS7/a;", "setLookaheadCoords", "(LS7/a;)V", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer$delegate", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", WindowStateInfo.KEY_LAYER, "Landroidx/compose/ui/geometry/Size;", "getNonNullLookaheadSize-NH-jbRc", "nonNullLookaheadSize", "getTarget", TypedValues.AttributesType.S_TARGET, "getShouldRenderInOverlay$animation_release", "shouldRenderInOverlay", "getShouldRenderInPlace", "shouldRenderInPlace", "getShouldRenderBasedOnTarget", "shouldRenderBasedOnTarget", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;

    /* renamed from: boundsAnimation$delegate, reason: from kotlin metadata */
    private final MutableState boundsAnimation;
    private Path clipPathInOverlay;

    /* renamed from: overlayClip$delegate, reason: from kotlin metadata */
    private final MutableState overlayClip;
    private SharedElementInternalState parentState;

    /* renamed from: placeHolderSize$delegate, reason: from kotlin metadata */
    private final MutableState placeHolderSize;

    /* renamed from: renderInOverlayDuringTransition$delegate, reason: from kotlin metadata */
    private final MutableState renderInOverlayDuringTransition;

    /* renamed from: renderOnlyWhenVisible$delegate, reason: from kotlin metadata */
    private final MutableState renderOnlyWhenVisible;

    /* renamed from: sharedElement$delegate, reason: from kotlin metadata */
    private final MutableState sharedElement;

    /* renamed from: userState$delegate, reason: from kotlin metadata */
    private final MutableState userState;

    /* renamed from: zIndex$delegate, reason: from kotlin metadata */
    private final MutableFloatState zIndex;
    private S7.a lookaheadCoords = new S7.a() { // from class: androidx.compose.animation.SharedElementInternalState$lookaheadCoords$1
        @Override // S7.a
        public final Void invoke() {
            return null;
        }
    };

    /* renamed from: layer$delegate, reason: from kotlin metadata */
    private final MutableState layer = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public SharedElementInternalState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z10, SharedTransitionScope.OverlayClip overlayClip, boolean z11, SharedTransitionScope.SharedContentState sharedContentState, float f) {
        this.zIndex = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.renderInOverlayDuringTransition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
        this.sharedElement = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedElement, null, 2, null);
        this.boundsAnimation = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsAnimation, null, 2, null);
        this.placeHolderSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(placeHolderSize, null, 2, null);
        this.renderOnlyWhenVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z10), null, 2, null);
        this.overlayClip = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(overlayClip, null, 2, null);
        this.userState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedContentState, null, 2, null);
    }

    private final boolean getShouldRenderBasedOnTarget() {
        return k.b(getSharedElement().getTargetBoundsProvider(), this) || !getRenderOnlyWhenVisible();
    }

    /* renamed from: calculateLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m105calculateLookaheadOffsetF1C5BW0() {
        Object objInvoke = this.lookaheadCoords.invoke();
        if (objInvoke == null) {
            throw new IllegalArgumentException("Error: lookahead coordinates is null.");
        }
        return getSharedElement().getScope().getLookaheadRoot$animation_release().mo5558localPositionOfR5De75A((LayoutCoordinates) objInvoke, Offset.INSTANCE.m3911getZeroF1C5BW0());
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(DrawScope drawScope) {
        GraphicsLayer layer = getLayer();
        if (layer != null && getShouldRenderInOverlay$animation_release()) {
            if (getSharedElement().getCurrentBounds() == null) {
                throw new IllegalArgumentException("Error: current bounds not set yet.");
            }
            Rect currentBounds = getSharedElement().getCurrentBounds();
            r rVar = null;
            Offset offsetM3884boximpl = currentBounds != null ? Offset.m3884boximpl(currentBounds.m3930getTopLeftF1C5BW0()) : null;
            k.c(offsetM3884boximpl);
            long jM3905unboximpl = offsetM3884boximpl.m3905unboximpl();
            float fM3895getXimpl = Offset.m3895getXimpl(jM3905unboximpl);
            float fM3896getYimpl = Offset.m3896getYimpl(jM3905unboximpl);
            Path path = this.clipPathInOverlay;
            if (path != null) {
                int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo4630clipPathmtrdDE(path, iM4128getIntersectrtfAjoo);
                    drawScope.getDrawContext().getTransform().translate(fM3895getXimpl, fM3896getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, layer);
                        androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                        rVar = r.f317a;
                    } finally {
                    }
                } catch (Throwable th) {
                    androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                    throw th;
                }
            }
            if (rVar == null) {
                drawScope.getDrawContext().getTransform().translate(fM3895getXimpl, fM3896getYimpl);
                try {
                    GraphicsLayerKt.drawLayer(drawScope, layer);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation.getValue();
    }

    /* renamed from: getClipPathInOverlay$animation_release, reason: from getter */
    public final Path getClipPathInOverlay() {
        return this.clipPathInOverlay;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer.getValue();
    }

    public final S7.a getLookaheadCoords() {
        return this.lookaheadCoords;
    }

    /* renamed from: getNonNullLookaheadSize-NH-jbRc, reason: not valid java name */
    public final long m106getNonNullLookaheadSizeNHjbRc() {
        Object objInvoke = this.lookaheadCoords.invoke();
        if (objInvoke != null) {
            return IntSizeKt.m7027toSizeozmzZPI(((LayoutCoordinates) objInvoke).mo5557getSizeYbymL2g());
        }
        throw new IllegalArgumentException(("Error: lookahead coordinates is null for " + getSharedElement().getKey() + '.').toString());
    }

    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public SharedElementInternalState getParentState() {
        return this.parentState;
    }

    public final SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        return (SharedTransitionScope.PlaceHolderSize) this.placeHolderSize.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement.getValue();
    }

    public final boolean getShouldRenderInOverlay$animation_release() {
        return getShouldRenderBasedOnTarget() && getSharedElement().getFoundMatch() && getRenderInOverlayDuringTransition();
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getFoundMatch()) {
            return !getShouldRenderInOverlay$animation_release() && getShouldRenderBasedOnTarget();
        }
        return true;
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        return this.zIndex.getFloatValue();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    public final void setBoundsAnimation(BoundsAnimation boundsAnimation) {
        this.boundsAnimation.setValue(boundsAnimation);
    }

    public final void setClipPathInOverlay$animation_release(Path path) {
        this.clipPathInOverlay = path;
    }

    public final void setLayer(GraphicsLayer graphicsLayer) {
        this.layer.setValue(graphicsLayer);
    }

    public final void setLookaheadCoords(S7.a aVar) {
        this.lookaheadCoords = aVar;
    }

    public final void setOverlayClip(SharedTransitionScope.OverlayClip overlayClip) {
        this.overlayClip.setValue(overlayClip);
    }

    public void setParentState(SharedElementInternalState sharedElementInternalState) {
        this.parentState = sharedElementInternalState;
    }

    public final void setPlaceHolderSize(SharedTransitionScope.PlaceHolderSize placeHolderSize) {
        this.placeHolderSize.setValue(placeHolderSize);
    }

    public final void setRenderInOverlayDuringTransition(boolean z10) {
        this.renderInOverlayDuringTransition.setValue(Boolean.valueOf(z10));
    }

    public final void setRenderOnlyWhenVisible(boolean z10) {
        this.renderOnlyWhenVisible.setValue(Boolean.valueOf(z10));
    }

    public final void setSharedElement(SharedElement sharedElement) {
        this.sharedElement.setValue(sharedElement);
    }

    public final void setUserState(SharedTransitionScope.SharedContentState sharedContentState) {
        this.userState.setValue(sharedContentState);
    }

    public void setZIndex(float f) {
        this.zIndex.setFloatValue(f);
    }
}
