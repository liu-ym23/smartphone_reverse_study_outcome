package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b*\u0002H\u0007H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"nestedScrollModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", WsConstants.KEY_CONNECTION, "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "findNearestAttachedAncestor", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollNodeKt {
    public static final /* synthetic */ TraversableNode access$findNearestAttachedAncestor(TraversableNode r100) {
        return findNearestAttachedAncestor(r100);
    }

    private static final <T extends TraversableNode> T findNearestAttachedAncestor(T r100) {
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        TraversableNodeKt.traverseAncestors(r100, new AnonymousClass1(r101));
        return (T) r101.element;
    }

    public static final DelegatableNode nestedScrollModifierNode(NestedScrollConnection r100, NestedScrollDispatcher r101) {
        return new NestedScrollNode(r100, r101);
    }
}
