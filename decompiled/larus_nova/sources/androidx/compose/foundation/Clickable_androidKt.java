package androidx.compose.foundation;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0002\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"isComposeRootInScrollableContainer", "", "Landroidx/compose/ui/node/DelegatableNode;", "isInScrollableViewGroup", "Landroid/view/View;", "TapIndicationDelay", "", "getTapIndicationDelay", "()J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = 0;

    static {
        TapIndicationDelay = ViewConfiguration.getTapTimeout();
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    public static final boolean isComposeRootInScrollableContainer(DelegatableNode r100) {
        return isInScrollableViewGroup(DelegatableNode_androidKt.requireView(r100));
    }

    private static final boolean isInScrollableViewGroup(View r100) {
        ViewParent r101 = r100.getParent();
    L3:
        if (r101 == null) goto L11;
        if ((r101 instanceof ViewGroup) == false) goto L16;
        ViewGroup r102 = (ViewGroup) r101;
        if (r102.shouldDelayChildPressedState() == true) goto L8;
        r101 = r102.getParent();
        goto L3
    L8:
        return true;
    L16:
        return false;
    L11:
        return false;
    }
}
