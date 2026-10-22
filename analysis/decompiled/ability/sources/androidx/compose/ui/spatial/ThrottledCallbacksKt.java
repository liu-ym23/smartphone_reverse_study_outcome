package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ThrottledCallbacksKt {
    /* renamed from: rectInfoFor-Dg36KO4, reason: not valid java name */
    public static final RelativeLayoutBounds m6124rectInfoForDg36KO4(DelegatableNode delegatableNode, long j5, long j6, long j10, long j11, long j12, float[] fArr) {
        NodeCoordinator nodeCoordinatorM5702requireCoordinator64DMado = DelegatableNodeKt.m5702requireCoordinator64DMado(delegatableNode, NodeKind.m5862constructorimpl(2));
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (!layoutNodeRequireLayoutNode.isPlaced()) {
            return null;
        }
        if (layoutNodeRequireLayoutNode.getOuterCoordinator$ui_release() == nodeCoordinatorM5702requireCoordinator64DMado) {
            return new RelativeLayoutBounds(j5, j6, j10, j11, j12, fArr, delegatableNode, null);
        }
        long jM6966constructorimpl = IntOffset.m6966constructorimpl(j5);
        float fM6972getXimpl = IntOffset.m6972getXimpl(jM6966constructorimpl);
        float fM6973getYimpl = IntOffset.m6973getYimpl(jM6966constructorimpl);
        long jM3887constructorimpl = Offset.m3887constructorimpl((Float.floatToRawIntBits(fM6972getXimpl) << 32) | (Float.floatToRawIntBits(fM6973getYimpl) & 4294967295L));
        long jMo5557getSizeYbymL2g = nodeCoordinatorM5702requireCoordinator64DMado.getCoordinates().mo5557getSizeYbymL2g();
        return new RelativeLayoutBounds(IntOffsetKt.m6989roundk4lQ0M(layoutNodeRequireLayoutNode.getOuterCoordinator$ui_release().getCoordinates().mo5558localPositionOfR5De75A(nodeCoordinatorM5702requireCoordinator64DMado, jM3887constructorimpl)), IntOffset.m6966constructorimpl(((IntOffset.m6972getXimpl(r0) + ((int) (jMo5557getSizeYbymL2g >> 32))) << 32) | ((IntOffset.m6973getYimpl(r0) + ((int) (jMo5557getSizeYbymL2g & 4294967295L))) & 4294967295L)), j10, j11, j12, fArr, delegatableNode, null);
    }
}
