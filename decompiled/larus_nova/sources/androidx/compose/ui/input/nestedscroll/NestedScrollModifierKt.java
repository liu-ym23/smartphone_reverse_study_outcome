package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", WsConstants.KEY_CONNECTION, "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollModifierKt {
    public static final Modifier nestedScroll(Modifier r100, NestedScrollConnection r101, NestedScrollDispatcher r102) {
        return r100.then(new NestedScrollElement(r101, r102));
    }

    public static /* synthetic */ Modifier nestedScroll$default(Modifier r100, NestedScrollConnection r101, NestedScrollDispatcher r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return nestedScroll(r100, r101, r102);
    }
}
