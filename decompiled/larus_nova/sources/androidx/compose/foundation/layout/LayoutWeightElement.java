package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/LayoutWeightNode;", "weight", "", LynxVideoManagerLite.FILL, "", "<init>", "(FZ)V", "getWeight", "()F", "getFill", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutWeightElement extends ModifierNodeElement<LayoutWeightNode> {
    public static final int $stable = 0;
    private final boolean fill;
    private final float weight;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public LayoutWeightNode create() {
        return new LayoutWeightNode(this.weight, this.fill);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = Float.floatToIntBits(this.weight) * 31;
        if (this.fill == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
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
        if ((r100 instanceof LayoutWeightElement) == false) goto L8;
        LayoutWeightElement r101 = (LayoutWeightElement) r100;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (this.weight != r101.weight) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L18;
    L20:
        return false;
    L18:
        if (this.fill != r101.fill) goto L20;
        return true;
    L15:
        r102 = false;
        goto L16
    L8:
        r101 = null;
        goto L10
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("weight");
        r100.setValue(Float.valueOf(this.weight));
        r100.getProperties().set("weight", Float.valueOf(this.weight));
        r100.getProperties().set(LynxVideoManagerLite.FILL, Boolean.valueOf(this.fill));
    }

    public void update(LayoutWeightNode r100) {
        r100.setWeight(this.weight);
        r100.setFill(this.fill);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((LayoutWeightNode) r100);
    }

    public LayoutWeightElement(float r100, boolean r101) {
        this.weight = r100;
        this.fill = r101;
    }
}
