package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007\u001a.\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\f"}, d2 = {"onLayoutRectChanged", "Landroidx/compose/ui/Modifier;", "throttleMillis", "", "debounceMillis", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "registerOnLayoutRectChanged", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OnLayoutRectChangedModifierKt {
    public static final Modifier onLayoutRectChanged(Modifier r100, long r101, long r110, Function1<? super RelativeLayoutBounds, Unit> r111) {
        return r100.then(new OnLayoutRectChangedElement(r101, r110, r111));
    }

    public static final DelegatableNode.RegistrationHandle registerOnLayoutRectChanged(DelegatableNode r100, long r110, long r111, Function1<? super RelativeLayoutBounds, Unit> r112) {
        LayoutNode r101 = DelegatableNodeKt.requireLayoutNode(r100);
        int r102 = r101.getSemanticsId();
        return LayoutNodeKt.requireOwner(r101).getRectManager().registerOnRectChangedCallback(r102, r110, r111, r100, r112);
    }

    public static /* synthetic */ Modifier onLayoutRectChanged$default(Modifier r100, long r101, long r102, Function1 r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L9;
        r102 = 64;
    L9:
        return onLayoutRectChanged(r100, r103, r102, r110);
    }
}
