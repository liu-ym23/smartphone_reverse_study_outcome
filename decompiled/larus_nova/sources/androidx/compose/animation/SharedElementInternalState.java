package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010a\u001a\u00020DH\u0016J\b\u0010b\u001a\u00020DH\u0016J\b\u0010c\u001a\u00020DH\u0016R+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\r\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010 \u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010G\u001a\u0004\u0018\u00010\u0000X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bM\u0010\u001cR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR/\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0014\u001a\u0004\u0018\u00010T8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010 \u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u001cR\u0014\u0010]\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u001cR\u0011\u0010_\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b`\u0010\u001c¨\u0006d"}, d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", UserInfo.USERSTATE, "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "<init>", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getRenderInOverlayDuringTransition", "()Z", "setRenderInOverlayDuringTransition", "(Z)V", "renderInOverlayDuringTransition$delegate", "Landroidx/compose/runtime/MutableState;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "placeHolderSize$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation", "(Landroidx/compose/ui/graphics/Path;)V", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", PickerReporterConstants.KEY.TARGET, "getTarget", "boundsProvider", "Landroidx/compose/animation/BoundsProvider;", "getBoundsProvider", "()Landroidx/compose/animation/BoundsProvider;", "setBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", GXTemplateKey.GAIAX_LAYER, "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "shouldRenderBasedOnTarget", "getShouldRenderBasedOnTarget", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation", "shouldRenderInPlace", "getShouldRenderInPlace", "onRemembered", "onForgotten", "onAbandoned", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;
    private final MutableState boundsAnimation$delegate;
    private BoundsProvider boundsProvider;
    private Path clipPathInOverlay;
    private final MutableState layer$delegate;
    private final MutableState overlayClip$delegate;
    private SharedElementInternalState parentState;
    private final MutableState placeHolderSize$delegate;
    private final MutableState renderInOverlayDuringTransition$delegate;
    private final MutableState renderOnlyWhenVisible$delegate;
    private final MutableState sharedElement$delegate;
    private final MutableState userState$delegate;
    private final MutableFloatState zIndex$delegate;

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer$delegate.getValue();
    }

    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip$delegate.getValue();
    }

    public final SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        return (SharedTransitionScope.PlaceHolderSize) this.placeHolderSize$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        return this.zIndex$delegate.getFloatValue();
    }

    private final boolean getShouldRenderBasedOnTarget() {
        if (Intrinsics.areEqual(getSharedElement().getTargetBoundsProvider$animation(), this.boundsProvider) == false) goto L5;
    L8:
        return true;
    L5:
        if (getRenderOnlyWhenVisible() == false) goto L8;
        return false;
    }

    public final boolean getShouldRenderInOverlay$animation() {
        if (getShouldRenderBasedOnTarget() == true) goto L5;
    L11:
        return false;
    L5:
        if (getSharedElement().getFoundMatch() == false) goto L11;
        if (getRenderInOverlayDuringTransition() == false) goto L11;
        if (getSharedElement().getScope().isTransitionActive() == false) goto L11;
        return true;
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getFoundMatch() == true) goto L5;
    L10:
        return true;
    L5:
        if (getShouldRenderInOverlay$animation() == false) goto L7;
    L9:
        return false;
    L7:
        if (getShouldRenderBasedOnTarget() == false) goto L9;
        goto L9
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation(this);
        getSharedElement().invalidateTargetBoundsProvider();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation(this);
        getSharedElement().invalidateTargetBoundsProvider();
    }

    public final BoundsProvider getBoundsProvider() {
        return this.boundsProvider;
    }

    public final Path getClipPathInOverlay$animation() {
        return this.clipPathInOverlay;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public SharedElementInternalState getParentState() {
        return this.parentState;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(DrawScope r110) {
        GraphicsLayer r100 = getLayer();
        if (r100 != null) goto L6;
        return;
    L6:
        if (getShouldRenderInOverlay$animation() == true) goto L8;
        return;
    L8:
        if (getSharedElement().getCurrentBoundsWhenMatched() == null) goto L38;
        Rect r101 = getSharedElement().getCurrentBoundsWhenMatched();
        if (r101 == null) goto L12;
        Offset r102 = Offset.m4571boximpl(r101.m4617getTopLeftF1C5BW0());
    L13:
        Intrinsics.checkNotNull(r102);
        long r103 = r102.m4592unboximpl();
        float r104 = Float.intBitsToFloat((int) (r103 >> 32));
        float r105 = Float.intBitsToFloat((int) (r103 & BodyPartID.bodyIdMax));
        Path r106 = this.clipPathInOverlay;
        if (r106 == null) goto L26;
        int r107 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        DrawContext r108 = r110.getDrawContext();
        long r109 = r108.mo5329getSizeNHjbRc();
        r108.getCanvas().save();
        r108.getTransform().mo5331clipPathmtrdDE(r106, r107);     // Catch: Throwable -> L23
        r110.getDrawContext().getTransform().translate(r104, r105);     // Catch: Throwable -> L23
        GraphicsLayerKt.drawLayer(r110, r100);     // Catch: Throwable -> L20
        r110.getDrawContext().getTransform().translate(-r104, -r105);     // Catch: Throwable -> L23
        r108.getCanvas().restore();
        r108.mo5330setSizeuvyYCjk(r109);
        return;
    L20:
        th = move-exception;
        r110.getDrawContext().getTransform().translate(-r104, -r105);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r108.getCanvas().restore();
        r108.mo5330setSizeuvyYCjk(r109);
        throw th;
    L26:
        r110.getDrawContext().getTransform().translate(r104, r105);
        GraphicsLayerKt.drawLayer(r110, r100);     // Catch: Throwable -> L29
        r110.getDrawContext().getTransform().translate(-r104, -r105);
        return;
    L29:
        th = move-exception;
        r110.getDrawContext().getTransform().translate(-r104, -r105);
        throw th;
    L12:
        r102 = null;
        goto L13
    }

    public final void setBoundsAnimation(BoundsAnimation r100) {
        this.boundsAnimation$delegate.setValue(r100);
    }

    public final void setBoundsProvider(BoundsProvider r100) {
        this.boundsProvider = r100;
    }

    public final void setClipPathInOverlay$animation(Path r100) {
        this.clipPathInOverlay = r100;
    }

    public final void setLayer(GraphicsLayer r100) {
        this.layer$delegate.setValue(r100);
    }

    public final void setOverlayClip(SharedTransitionScope.OverlayClip r100) {
        this.overlayClip$delegate.setValue(r100);
    }

    public void setParentState(SharedElementInternalState r100) {
        this.parentState = r100;
    }

    public final void setPlaceHolderSize(SharedTransitionScope.PlaceHolderSize r100) {
        this.placeHolderSize$delegate.setValue(r100);
    }

    public final void setRenderInOverlayDuringTransition(boolean r100) {
        this.renderInOverlayDuringTransition$delegate.setValue(Boolean.valueOf(r100));
    }

    public final void setRenderOnlyWhenVisible(boolean r100) {
        this.renderOnlyWhenVisible$delegate.setValue(Boolean.valueOf(r100));
    }

    public final void setSharedElement(SharedElement r100) {
        this.sharedElement$delegate.setValue(r100);
    }

    public final void setUserState(SharedTransitionScope.SharedContentState r100) {
        this.userState$delegate.setValue(r100);
    }

    public void setZIndex(float r100) {
        this.zIndex$delegate.setFloatValue(r100);
    }

    public SharedElementInternalState(SharedElement r100, BoundsAnimation r101, SharedTransitionScope.PlaceHolderSize r102, boolean r103, SharedTransitionScope.OverlayClip r104, boolean r105, SharedTransitionScope.SharedContentState r106, float r107) {
        this.zIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r107);
        this.renderInOverlayDuringTransition$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r105), null, 2, null);
        this.sharedElement$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.boundsAnimation$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        this.placeHolderSize$delegate = SnapshotStateKt.mutableStateOf$default(r102, null, 2, null);
        this.renderOnlyWhenVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r103), null, 2, null);
        this.overlayClip$delegate = SnapshotStateKt.mutableStateOf$default(r104, null, 2, null);
        this.userState$delegate = SnapshotStateKt.mutableStateOf$default(r106, null, 2, null);
        this.layer$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }
}
