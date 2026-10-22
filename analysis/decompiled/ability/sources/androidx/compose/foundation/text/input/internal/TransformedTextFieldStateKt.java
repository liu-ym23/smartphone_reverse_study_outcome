package androidx.compose.foundation.text.input.internal;

import S7.o;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"R", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "transformedQueryIndex", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "Landroidx/compose/ui/text/TextRange;", "onResult", "getIndexTransformationType", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;ILS7/o;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformedTextFieldStateKt {
    public static final <R> R getIndexTransformationType(TransformedTextFieldState transformedTextFieldState, int i, o oVar) {
        long jM1263mapFromTransformedjx7JFs = transformedTextFieldState.m1263mapFromTransformedjx7JFs(i);
        long jM1266mapToTransformedGEjPoXI = transformedTextFieldState.m1266mapToTransformedGEjPoXI(jM1263mapFromTransformedjx7JFs);
        return (R) oVar.invoke((TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) && TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) || TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? (!TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) || TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement, TextRange.m6299boximpl(jM1263mapFromTransformedjx7JFs), TextRange.m6299boximpl(jM1266mapToTransformedGEjPoXI));
    }
}
