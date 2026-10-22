package androidx.compose.ui.focus;

import C7.c;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0003"}, d2 = {"focusTarget", "Landroidx/compose/ui/Modifier;", "focusModifier", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusModifierKt {
    @c
    public static final Modifier focusModifier(Modifier modifier) {
        return focusTarget(modifier);
    }

    public static final Modifier focusTarget(Modifier modifier) {
        return modifier.then(FocusTargetNode.FocusTargetElement.INSTANCE);
    }
}
