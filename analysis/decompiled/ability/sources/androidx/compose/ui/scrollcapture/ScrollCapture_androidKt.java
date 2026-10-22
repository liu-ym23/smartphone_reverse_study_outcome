package androidx.compose.ui.scrollcapture;

import S7.k;
import S7.n;
import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a5\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\t\u001a(\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\u0004H\u0082\b¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e*\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"6\u0010\u0017\u001a \b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0011*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u001a\u001a\u00020\n*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "fromNode", "", "depth", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "LC7/r;", "onCandidate", "visitScrollCaptureCandidates", "(Landroidx/compose/ui/semantics/SemanticsNode;ILS7/k;)V", "", "onNode", "visitDescendants", "(Landroidx/compose/ui/semantics/SemanticsNode;LS7/k;)V", "", "getChildrenForSearch", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/util/List;", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "LH7/c;", "", "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)LS7/n;", "scrollCaptureScrollByAction", "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "canScrollVertically", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollCapture_androidKt {
    private static final boolean getCanScrollVertically(SemanticsNode semanticsNode) {
        n scrollCaptureScrollByAction = getScrollCaptureScrollByAction(semanticsNode);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        return (scrollCaptureScrollByAction == null || scrollAxisRange == null || ((Number) scrollAxisRange.getMaxValue().invoke()).floatValue() <= 0.0f) ? false : true;
    }

    private static final List<SemanticsNode> getChildrenForSearch(SemanticsNode semanticsNode) {
        return semanticsNode.getChildren$ui_release(false, false, false);
    }

    public static final n getScrollCaptureScrollByAction(SemanticsNode semanticsNode) {
        return (n) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final void visitDescendants(SemanticsNode semanticsNode, k kVar) {
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        mutableVector.addAll(mutableVector.getSize(), (List) getChildrenForSearch(semanticsNode));
        while (mutableVector.getSize() != 0) {
            SemanticsNode semanticsNode2 = (SemanticsNode) b.l(mutableVector, 1);
            if (((Boolean) kVar.invoke(semanticsNode2)).booleanValue()) {
                mutableVector.addAll(mutableVector.getSize(), (List) getChildrenForSearch(semanticsNode2));
            }
        }
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode semanticsNode, int i, k kVar) {
        SemanticsNode semanticsNode2;
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        List<SemanticsNode> childrenForSearch = getChildrenForSearch(semanticsNode);
        while (true) {
            mutableVector.addAll(mutableVector.getSize(), (List) childrenForSearch);
            while (mutableVector.getSize() != 0) {
                semanticsNode2 = (SemanticsNode) b.l(mutableVector, 1);
                if (!SemanticsOwnerKt.isHidden(semanticsNode2) && !semanticsNode2.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getDisabled())) {
                    NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = semanticsNode2.findCoordinatorToGetBounds$ui_release();
                    if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release == null) {
                        throw b.x("Expected semantics node to have a coordinator.");
                    }
                    LayoutCoordinates coordinates = nodeCoordinatorFindCoordinatorToGetBounds$ui_release.getCoordinates();
                    IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow(coordinates));
                    if (intRectRoundToIntRect.isEmpty()) {
                        continue;
                    } else {
                        if (!getCanScrollVertically(semanticsNode2)) {
                            break;
                        }
                        int i6 = 1 + i;
                        kVar.invoke(new ScrollCaptureCandidate(semanticsNode2, i6, intRectRoundToIntRect, coordinates));
                        visitScrollCaptureCandidates(semanticsNode2, i6, kVar);
                    }
                }
            }
            return;
            childrenForSearch = getChildrenForSearch(semanticsNode2);
        }
    }

    public static /* synthetic */ void visitScrollCaptureCandidates$default(SemanticsNode semanticsNode, int i, k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        visitScrollCaptureCandidates(semanticsNode, i, kVar);
    }
}
