package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"hasLinks", "", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextAnnotatedStringNodeKt {
    public static final boolean hasLinks(AnnotatedString r100) {
        return r100.hasLinkAnnotations(0, r100.length());
    }
}
