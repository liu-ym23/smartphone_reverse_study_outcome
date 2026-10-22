package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.ScopeInvalidationContext;
import androidx.compose.runtime.tooling.GlobalCompositionObserver;
import androidx.compose.runtime.tooling.GlobalCompositionObserverKt;
import androidx.compose.runtime.tooling.InvalidationKind;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"dispatchInvalidation", "", "kind", "Landroidx/compose/runtime/tooling/InvalidationKind;", "scope", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OwnerSnapshotObserverKt {
    public static final void dispatchInvalidation(InvalidationKind r100, Object r101) {
        if (GlobalCompositionObserverKt.isInvalidationObservingEnabled() == true) goto L5;
        return;
    L5:
        GlobalCompositionObserver r102 = GlobalCompositionObserverKt.getGlobalCompositionObserver();
        if (r102 != null) goto L8;
        return;
    L8:
        List<Object> r103 = ScopeInvalidationContext.getCurrentTriggerStates();
        if (r103 != null) goto L11;
        r103 = CollectionsKt.emptyList();
    L11:
        r102.onInvalidation(r100, r101, r103);
    }
}
