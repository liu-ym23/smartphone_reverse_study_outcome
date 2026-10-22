package androidx.compose.ui.autofill;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, d2 = {"contentType", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/autofill/ContentType;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AutofillModifierKt {
    public static final Modifier contentType(Modifier r100, final ContentType r101) {
        return SemanticsModifierKt.semantics$default(r100, false, new AnonymousClass1(r101), 1, null);
    }
}
