package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\f\u0010\u0019\u001a\u00020\u0017*\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/ScrollingContainerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollingContainerNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "useLocalOverscrollFactory", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;ZLandroidx/compose/foundation/OverscrollEffect;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingContainerElement extends ModifierNodeElement<ScrollingContainerNode> {
    private final BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseScrolling;
    private final ScrollableState state;
    private final boolean useLocalOverscrollFactory;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ScrollingContainerNode create() {
        return new ScrollingContainerNode(this.state, this.orientation, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec, this.useLocalOverscrollFactory, this.overscrollEffect);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        int r101 = 1231;
        if (this.enabled == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.reverseScrolling == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        FlingBehavior r106 = this.flingBehavior;
        int r107 = 0;
        if (r106 == null) goto L13;
        int r108 = r106.hashCode();
    L14:
        int r109 = (r105 + r108) * 31;
        MutableInteractionSource r110 = this.interactionSource;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        BringIntoViewSpec r113 = this.bringIntoViewSpec;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.useLocalOverscrollFactory == true) goto L26;
        r101 = 1237;
    L26:
        int r116 = (r115 + r101) * 31;
        OverscrollEffect r117 = this.overscrollEffect;
        if (r117 == null) goto L30;
        r107 = r117.hashCode();
    L30:
        return r116 + r107;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L38:
        return false;
    L8:
        if (ScrollingContainerElement.class != r100.getClass()) goto L38;
        ScrollingContainerElement r101 = (ScrollingContainerElement) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L14;
        return false;
    L14:
        if (this.orientation == r101.orientation) goto L17;
        return false;
    L17:
        if (this.enabled == r101.enabled) goto L20;
        return false;
    L20:
        if (this.reverseScrolling == r101.reverseScrolling) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.flingBehavior, r101.flingBehavior) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.interactionSource, r101.interactionSource) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.bringIntoViewSpec, r101.bringIntoViewSpec) == true) goto L32;
        return false;
    L32:
        if (this.useLocalOverscrollFactory == r101.useLocalOverscrollFactory) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.overscrollEffect, r101.overscrollEffect) == true) goto L37;
        return false;
    L37:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("scrollingContainer");
        r100.getProperties().set("state", this.state);
        r100.getProperties().set("orientation", this.orientation);
        r100.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r100.getProperties().set("reverseScrolling", Boolean.valueOf(this.reverseScrolling));
        r100.getProperties().set("flingBehavior", this.flingBehavior);
        r100.getProperties().set("interactionSource", this.interactionSource);
        r100.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
        r100.getProperties().set("useLocalOverscrollFactory", Boolean.valueOf(this.useLocalOverscrollFactory));
        r100.getProperties().set("overscrollEffect", this.overscrollEffect);
    }

    public void update(ScrollingContainerNode r110) {
        r110.update(this.state, this.orientation, this.useLocalOverscrollFactory, this.overscrollEffect, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((ScrollingContainerNode) r100);
    }

    public ScrollingContainerElement(ScrollableState r100, Orientation r101, boolean r102, boolean r103, FlingBehavior r104, MutableInteractionSource r105, BringIntoViewSpec r106, boolean r107, OverscrollEffect r108) {
        this.state = r100;
        this.orientation = r101;
        this.enabled = r102;
        this.reverseScrolling = r103;
        this.flingBehavior = r104;
        this.interactionSource = r105;
        this.bringIntoViewSpec = r106;
        this.useLocalOverscrollFactory = r107;
        this.overscrollEffect = r108;
    }
}
