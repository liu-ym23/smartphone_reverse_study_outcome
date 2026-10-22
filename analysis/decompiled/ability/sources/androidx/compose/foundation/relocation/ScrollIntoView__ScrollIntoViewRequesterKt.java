package androidx.compose.foundation.relocation;

import C7.r;
import H7.c;
import S7.a;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0080@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/geometry/Rect;", "rect", "LC7/r;", "scrollIntoView", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/geometry/Rect;LH7/c;)Ljava/lang/Object;", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/ScrollIntoView")
/* loaded from: classes.dex */
public final /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static final Object scrollIntoView(DelegatableNode delegatableNode, final Rect rect, c<? super r> cVar) {
        Object objBringChildIntoView;
        boolean isAttached = delegatableNode.getNode().getIsAttached();
        r rVar = r.f317a;
        if (!isAttached) {
            return rVar;
        }
        final LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode);
        BringIntoViewParent bringIntoViewParentFindBringIntoViewParent = BringIntoViewRequesterKt.findBringIntoViewParent(delegatableNode);
        return (bringIntoViewParentFindBringIntoViewParent != null && (objBringChildIntoView = bringIntoViewParentFindBringIntoViewParent.bringChildIntoView(layoutCoordinatesRequireLayoutCoordinates, new a() { // from class: androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Rect invoke() {
                Rect rect2 = rect;
                if (rect2 != null) {
                    return rect2;
                }
                LayoutCoordinates layoutCoordinates = layoutCoordinatesRequireLayoutCoordinates;
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return SizeKt.m3985toRectuvyYCjk(IntSizeKt.m7027toSizeozmzZPI(layoutCoordinates.mo5557getSizeYbymL2g()));
                }
                return null;
            }
        }, cVar)) == CoroutineSingletons.f4909a) ? objBringChildIntoView : rVar;
    }

    public static /* synthetic */ Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect, c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return ScrollIntoView.scrollIntoView(delegatableNode, rect, cVar);
    }
}
