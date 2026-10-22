package androidx.compose.foundation.text;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutMeasureScope;", "", AppAgent.CONSTRUCT, "()V", "", "width", "height", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "place", "Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "layout", "(IILS7/a;)Landroidx/compose/foundation/text/TextRangeLayoutMeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextRangeLayoutMeasureScope {
    public static final int $stable = 0;

    public final TextRangeLayoutMeasureResult layout(int width, int height, S7.a place) {
        return new TextRangeLayoutMeasureResult(width, height, place);
    }
}
