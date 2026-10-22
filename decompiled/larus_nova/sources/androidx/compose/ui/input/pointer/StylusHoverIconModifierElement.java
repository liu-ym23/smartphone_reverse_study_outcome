package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "touchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "getOverrideDescendants", "()Z", "getTouchBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StylusHoverIconModifierElement extends ModifierNodeElement<StylusHoverIconModifierNode> {
    public static final int $stable = 0;
    private final PointerIcon icon;
    private final boolean overrideDescendants;
    private final DpTouchBoundsExpansion touchBoundsExpansion;

    public static /* synthetic */ StylusHoverIconModifierElement copy$default(StylusHoverIconModifierElement r100, PointerIcon r101, boolean r102, DpTouchBoundsExpansion r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.overrideDescendants;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.touchBoundsExpansion;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final PointerIcon component1() {
        return this.icon;
    }

    public final boolean component2() {
        return this.overrideDescendants;
    }

    public final DpTouchBoundsExpansion component3() {
        return this.touchBoundsExpansion;
    }

    public final StylusHoverIconModifierElement copy(PointerIcon r100, boolean r101, DpTouchBoundsExpansion r102) {
        return new StylusHoverIconModifierElement(r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StylusHoverIconModifierElement) == true) goto L8;
        return false;
    L8:
        StylusHoverIconModifierElement r101 = (StylusHoverIconModifierElement) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (this.overrideDescendants == r101.overrideDescendants) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.touchBoundsExpansion, r101.touchBoundsExpansion) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = this.icon.hashCode() * 31;
        if (this.overrideDescendants == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        DpTouchBoundsExpansion r103 = this.touchBoundsExpansion;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "StylusHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ", touchBoundsExpansion=" + this.touchBoundsExpansion + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public StylusHoverIconModifierNode create() {
        return new StylusHoverIconModifierNode(this.icon, this.overrideDescendants, this.touchBoundsExpansion);
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    public final DpTouchBoundsExpansion getTouchBoundsExpansion() {
        return this.touchBoundsExpansion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("stylusHoverIcon");
        r100.getProperties().set("icon", this.icon);
        r100.getProperties().set("overrideDescendants", Boolean.valueOf(this.overrideDescendants));
        r100.getProperties().set("touchBoundsExpansion", this.touchBoundsExpansion);
    }

    public void update(StylusHoverIconModifierNode r100) {
        r100.setIcon(this.icon);
        r100.setOverrideDescendants(this.overrideDescendants);
        r100.setDpTouchBoundsExpansion(this.touchBoundsExpansion);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((StylusHoverIconModifierNode) r100);
    }

    public StylusHoverIconModifierElement(PointerIcon r100, boolean r101, DpTouchBoundsExpansion r102) {
        this.icon = r100;
        this.overrideDescendants = r101;
        this.touchBoundsExpansion = r102;
    }

    public /* synthetic */ StylusHoverIconModifierElement(PointerIcon r100, boolean r101, DpTouchBoundsExpansion r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
