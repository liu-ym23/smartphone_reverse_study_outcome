package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010\u0015¨\u0006&"}, d2 = {"Landroidx/compose/material3/ThumbElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "", "checked", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "create", "()Landroidx/compose/material3/ThumbNode;", "node", "LC7/r;", "update", "(Landroidx/compose/material3/ThumbNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()Landroidx/compose/foundation/interaction/InteractionSource;", "component2", "()Z", "copy", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)Landroidx/compose/material3/ThumbElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "Z", "getChecked", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class ThumbElement extends ModifierNodeElement<ThumbNode> {
    private final boolean checked;
    private final InteractionSource interactionSource;

    public ThumbElement(InteractionSource interactionSource, boolean z10) {
        this.interactionSource = interactionSource;
        this.checked = z10;
    }

    public static /* synthetic */ ThumbElement copy$default(ThumbElement thumbElement, InteractionSource interactionSource, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            interactionSource = thumbElement.interactionSource;
        }
        if ((i & 2) != 0) {
            z10 = thumbElement.checked;
        }
        return thumbElement.copy(interactionSource, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    public final ThumbElement copy(InteractionSource interactionSource, boolean checked) {
        return new ThumbElement(interactionSource, checked);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) other;
        return k.b(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.checked) + (this.interactionSource.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("switchThumb");
        inspectorInfo.getProperties().set("interactionSource", this.interactionSource);
        inspectorInfo.getProperties().set("checked", Boolean.valueOf(this.checked));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ThumbElement(interactionSource=");
        sb.append(this.interactionSource);
        sb.append(", checked=");
        return androidx.appfunctions.metadata.a.r(sb, this.checked, ')');
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public ThumbNode getNode() {
        return new ThumbNode(this.interactionSource, this.checked);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ThumbNode node) {
        node.setInteractionSource(this.interactionSource);
        if (node.getChecked() != this.checked) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        node.setChecked(this.checked);
        node.update();
    }
}
