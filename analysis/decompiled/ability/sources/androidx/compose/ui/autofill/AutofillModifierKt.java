package androidx.compose.ui.autofill;

import C7.r;
import S7.k;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, d2 = {"contentType", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/autofill/ContentType;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutofillModifierKt {
    public static final Modifier contentType(Modifier modifier, final ContentType contentType) {
        return SemanticsModifierKt.semantics$default(modifier, false, new k() { // from class: androidx.compose.ui.autofill.AutofillModifierKt.contentType.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, contentType);
            }
        }, 1, null);
    }
}
