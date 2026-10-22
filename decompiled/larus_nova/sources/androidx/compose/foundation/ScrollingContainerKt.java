package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¨\u0006\u0012"}, d2 = {"scrollingContainer", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "useLocalOverscrollFactory", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollingContainerKt {
    public static final Modifier scrollingContainer(Modifier r110, ScrollableState r111, Orientation r112, boolean r113, boolean r114, FlingBehavior r115, MutableInteractionSource r116, boolean r117, OverscrollEffect r210, BringIntoViewSpec r211) {
        return ClipScrollableContainerKt.clipScrollableContainer(r110, r112).then(new ScrollingContainerElement(r111, r112, r113, r114, r115, r116, r211, r117, r210));
    }

    public static /* synthetic */ Modifier scrollingContainer$default(Modifier r110, ScrollableState r111, Orientation r112, boolean r113, boolean r114, FlingBehavior r115, MutableInteractionSource r116, boolean r117, OverscrollEffect r118, BringIntoViewSpec r210, int r211, Object r212) {
        if ((r211 & 256) == 0) goto L5;
        BringIntoViewSpec r119 = null;
    L7:
        return scrollingContainer(r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L5:
        r119 = r210;
        goto L7
    }
}
