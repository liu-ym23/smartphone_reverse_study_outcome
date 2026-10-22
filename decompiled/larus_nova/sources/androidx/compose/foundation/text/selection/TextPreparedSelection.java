package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/selection/TextPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextPreparedSelection extends BaseTextPreparedSelection<TextPreparedSelection> {
    public static final int $stable = 8;

    public /* synthetic */ TextPreparedSelection(AnnotatedString r100, long r101, TextLayoutResult r102, OffsetMapping r103, TextPreparedSelectionState r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    private TextPreparedSelection(AnnotatedString r100, long r110, TextLayoutResult r111, OffsetMapping r112, TextPreparedSelectionState r113) {
        super(r100, r110, r111, r112, r113, null);
    }

    public /* synthetic */ TextPreparedSelection(AnnotatedString r110, long r111, TextLayoutResult r112, OffsetMapping r113, TextPreparedSelectionState r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 4) == 0) goto L5;
        TextLayoutResult r100 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        OffsetMapping r101 = OffsetMapping.Companion.getIdentity();
    L11:
        if ((r115 & 16) == 0) goto L13;
        TextPreparedSelectionState r102 = new TextPreparedSelectionState();
    L14:
        this(r110, r111, r100, r101, r102, null);
        return;
    L13:
        r102 = r114;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
