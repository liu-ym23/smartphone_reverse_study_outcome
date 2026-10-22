package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "builder", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "Landroidx/compose/ui/text/SpanStyle;", "style", "", "start", "end", "LC7/r;", "replaceStyle", "(Landroidx/compose/ui/text/SpanStyle;II)V", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextAnnotatorScope {
    private final AnnotatedString.Builder builder;

    public TextAnnotatorScope(AnnotatedString.Builder builder) {
        this.builder = builder;
    }

    public final void replaceStyle(SpanStyle style, int start, int end) {
        this.builder.addStyle(style, start, end);
    }
}
