package androidx.compose.ui.input.pointer;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u000e*\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "icon", "", "overrideDescendants", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "touchBoundsExpansion", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)V", "create", "()Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;", "node", "LC7/r;", "update", "(Landroidx/compose/ui/input/pointer/StylusHoverIconModifierNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "component2", "()Z", "component3", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "copy", "(Landroidx/compose/ui/input/pointer/PointerIcon;ZLandroidx/compose/ui/node/DpTouchBoundsExpansion;)Landroidx/compose/ui/input/pointer/StylusHoverIconModifierElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getIcon", "Z", "getOverrideDescendants", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "getTouchBoundsExpansion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class StylusHoverIconModifierElement extends ModifierNodeElement<StylusHoverIconModifierNode> {
    public static final int $stable = 0;
    private final PointerIcon icon;
    private final boolean overrideDescendants;
    private final DpTouchBoundsExpansion touchBoundsExpansion;

    public /* synthetic */ StylusHoverIconModifierElement(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion, int i, e eVar) {
        this(pointerIcon, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : dpTouchBoundsExpansion);
    }

    public static /* synthetic */ StylusHoverIconModifierElement copy$default(StylusHoverIconModifierElement stylusHoverIconModifierElement, PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerIcon = stylusHoverIconModifierElement.icon;
        }
        if ((i & 2) != 0) {
            z10 = stylusHoverIconModifierElement.overrideDescendants;
        }
        if ((i & 4) != 0) {
            dpTouchBoundsExpansion = stylusHoverIconModifierElement.touchBoundsExpansion;
        }
        return stylusHoverIconModifierElement.copy(pointerIcon, z10, dpTouchBoundsExpansion);
    }

    /* renamed from: component1, reason: from getter */
    public final PointerIcon getIcon() {
        return this.icon;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    /* renamed from: component3, reason: from getter */
    public final DpTouchBoundsExpansion getTouchBoundsExpansion() {
        return this.touchBoundsExpansion;
    }

    public final StylusHoverIconModifierElement copy(PointerIcon icon, boolean overrideDescendants, DpTouchBoundsExpansion touchBoundsExpansion) {
        return new StylusHoverIconModifierElement(icon, overrideDescendants, touchBoundsExpansion);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) other;
        return k.b(this.icon, stylusHoverIconModifierElement.icon) && this.overrideDescendants == stylusHoverIconModifierElement.overrideDescendants && k.b(this.touchBoundsExpansion, stylusHoverIconModifierElement.touchBoundsExpansion);
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
    public int hashCode() {
        int iD = a.d(this.icon.hashCode() * 31, 31, this.overrideDescendants);
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.touchBoundsExpansion;
        return iD + (dpTouchBoundsExpansion == null ? 0 : dpTouchBoundsExpansion.hashCode());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("stylusHoverIcon");
        inspectorInfo.getProperties().set("icon", this.icon);
        b.k(this.overrideDescendants, inspectorInfo.getProperties(), "overrideDescendants", inspectorInfo).set("touchBoundsExpansion", this.touchBoundsExpansion);
    }

    public String toString() {
        return "StylusHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=" + this.overrideDescendants + ", touchBoundsExpansion=" + this.touchBoundsExpansion + ')';
    }

    public StylusHoverIconModifierElement(PointerIcon pointerIcon, boolean z10, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.icon = pointerIcon;
        this.overrideDescendants = z10;
        this.touchBoundsExpansion = dpTouchBoundsExpansion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public StylusHoverIconModifierNode getNode() {
        return new StylusHoverIconModifierNode(this.icon, this.overrideDescendants, this.touchBoundsExpansion);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(StylusHoverIconModifierNode node) {
        node.setIcon(this.icon);
        node.setOverrideDescendants(this.overrideDescendants);
        node.setDpTouchBoundsExpansion(this.touchBoundsExpansion);
    }
}
