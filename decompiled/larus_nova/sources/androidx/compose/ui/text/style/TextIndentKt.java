package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextIndent;", "start", "stop", "fraction", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextIndentKt {
    public static final TextIndent lerp(TextIndent r100, TextIndent r101, float r102) {
        return new TextIndent(SpanStyleKt.m6945lerpTextUnitInheritableC3pnCVY(r100.m7442getFirstLineXSAIIZE(), r101.m7442getFirstLineXSAIIZE(), r102), SpanStyleKt.m6945lerpTextUnitInheritableC3pnCVY(r100.m7443getRestLineXSAIIZE(), r101.m7443getRestLineXSAIIZE(), r102), null);
    }
}
