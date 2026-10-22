package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\f\u0010\u001e\u001a\u00020\u0017*\u00020\u001fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "getBeyondBoundsInfo", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getReverseLayout", "()Z", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyLayoutBeyondBoundsModifierElement extends ModifierNodeElement<LazyLayoutBeyondBoundsModifierNode> {
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public LazyLayoutBeyondBoundsModifierNode create() {
        return new LazyLayoutBeyondBoundsModifierNode(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = ((this.state.hashCode() * 31) + this.beyondBoundsInfo.hashCode()) * 31;
        if (this.reverseLayout == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.orientation.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final LazyLayoutBeyondBoundsState getState() {
        return this.state;
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
        if ((r100 instanceof LazyLayoutBeyondBoundsModifierElement) == true) goto L8;
        return false;
    L8:
        LazyLayoutBeyondBoundsModifierElement r101 = (LazyLayoutBeyondBoundsModifierElement) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.beyondBoundsInfo, r101.beyondBoundsInfo) == true) goto L15;
        return false;
    L15:
        if (this.reverseLayout == r101.reverseLayout) goto L18;
        return false;
    L18:
        if (this.orientation == r101.orientation) goto L20;
        return false;
    L20:
        return true;
    }

    public void update(LazyLayoutBeyondBoundsModifierNode r100) {
        r100.update(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((LazyLayoutBeyondBoundsModifierNode) r100);
    }

    public LazyLayoutBeyondBoundsModifierElement(LazyLayoutBeyondBoundsState r100, LazyLayoutBeyondBoundsInfo r101, boolean r102, Orientation r103) {
        this.state = r100;
        this.beyondBoundsInfo = r101;
        this.reverseLayout = r102;
        this.orientation = r103;
    }
}
