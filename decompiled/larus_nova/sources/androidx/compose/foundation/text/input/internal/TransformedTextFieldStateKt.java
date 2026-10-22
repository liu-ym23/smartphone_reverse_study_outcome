package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00010\u0006H\u0080\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"getIndexTransformationType", "R", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "transformedQueryIndex", "", "onResult", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "Landroidx/compose/ui/text/TextRange;", "Lkotlin/ParameterName;", "name", "untransformed", "retransformed", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;ILkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformedTextFieldStateKt {
    public static final <R> R getIndexTransformationType(TransformedTextFieldState r100, int r101, Function3<? super IndexTransformationType, ? super TextRange, ? super TextRange, ? extends R> r102) {
        long r103 = r100.m1319mapFromTransformedjx7JFs(r101);
        long r104 = r100.m1322mapToTransformedGEjPoXI(r103);
        if (TextRange.m6992getCollapsedimpl(r103) == false) goto L8;
        if (TextRange.m6992getCollapsedimpl(r104) == false) goto L8;
        IndexTransformationType r105 = IndexTransformationType.Untransformed;
    L19:
        return r102.invoke(r105, TextRange.m6986boximpl(r103), TextRange.m6986boximpl(r104));
    L8:
        if (TextRange.m6992getCollapsedimpl(r103) == true) goto L13;
        if (TextRange.m6992getCollapsedimpl(r104) == true) goto L13;
        r105 = IndexTransformationType.Replacement;
    L13:
        if (TextRange.m6992getCollapsedimpl(r103) == true) goto L15;
    L17:
        r105 = IndexTransformationType.Deletion;
        goto L19
    L15:
        if (TextRange.m6992getCollapsedimpl(r104) == true) goto L17;
        r105 = IndexTransformationType.Insertion;
        goto L19
    }
}
