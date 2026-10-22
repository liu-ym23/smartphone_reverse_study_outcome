package androidx.compose.ui.node;

import S7.a;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u0004\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "LC7/r;", "block", "observeReads", "(Landroidx/compose/ui/Modifier$Node;LS7/a;)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ObserverModifierNodeKt {
    public static final <T extends Modifier.Node & ObserverModifierNode> void observeReads(T t9, a aVar) {
        ObserverNodeOwnerScope ownerScope = t9.getOwnerScope();
        if (ownerScope == null) {
            ownerScope = new ObserverNodeOwnerScope(t9);
            t9.setOwnerScope$ui_release(ownerScope);
        }
        DelegatableNodeKt.requireOwner(t9).getSnapshotObserver().observeReads$ui_release(ownerScope, ObserverNodeOwnerScope.INSTANCE.getOnObserveReadsChanged$ui_release(), aVar);
    }
}
