package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"hoverable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HoverableKt {
    public static final Modifier hoverable(Modifier r100, MutableInteractionSource r101, boolean r102) {
        if (r102 == false) goto L4;
        Modifier r103 = new HoverableElement(r101);
    L6:
        return r100.then(r103);
    L4:
        r103 = Modifier.Companion;
        goto L6
    }

    public static /* synthetic */ Modifier hoverable$default(Modifier r100, MutableInteractionSource r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return hoverable(r100, r101, r102);
    }
}
