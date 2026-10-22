package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"GridItemSpan", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "currentLineSpan", "", "(I)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridSpanKt {
    public static final long GridItemSpan(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("The span value should be higher than 0");
    L8:
        return GridItemSpan.m849constructorimpl(r100);
    L4:
        r101 = false;
        goto L5
    }
}
