package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/FillCrossAxisSizeNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "<init>", "(F)V", "getFraction", "()F", "setFraction", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FillCrossAxisSizeNode extends Modifier.Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private float fraction;

    public final float getFraction() {
        return this.fraction;
    }

    public FillCrossAxisSizeNode(float r100) {
        this.fraction = r100;
    }

    public final void setFraction(float r100) {
        this.fraction = r100;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public RowColumnParentData modifyParentData(Density r100, Object r101) {
        if ((r101 instanceof RowColumnParentData) == false) goto L5;
        RowColumnParentData r102 = (RowColumnParentData) r101;
    L6:
        if (r102 != null) goto L8;
        r102 = new RowColumnParentData(0.0f, false, null, null, 15, null);
    L8:
        FlowLayoutData r103 = r102.getFlowLayoutData();
        if (r103 != null) goto L11;
        r103 = new FlowLayoutData(this.fraction);
    L11:
        r102.setFlowLayoutData(r103);
        FlowLayoutData r104 = r102.getFlowLayoutData();
        Intrinsics.checkNotNull(r104);
        r104.setFillCrossAxisFraction(this.fraction);
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public /* bridge */ /* synthetic */ Object modifyParentData(Density r100, Object r101) {
        return modifyParentData(r100, r101);
    }
}
