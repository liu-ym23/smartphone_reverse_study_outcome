package androidx.compose.foundation.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"selectableGroup", "Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectableGroupKt {
    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r100) {
        return selectableGroup$lambda$0(r100);
    }

    public static final Modifier selectableGroup(Modifier r100) {
        return SemanticsModifierKt.semantics$default(r100, false, new a(), 1, null);
    }

    private static final Unit selectableGroup$lambda$0(SemanticsPropertyReceiver r100) {
        SemanticsPropertiesKt.selectableGroup(r100);
        return Unit.INSTANCE;
    }
}
