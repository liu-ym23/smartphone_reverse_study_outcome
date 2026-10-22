package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"findIndexByKey", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "key", "", "lastKnownIndex", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemProviderKt {
    public static final int findIndexByKey(LazyLayoutItemProvider r100, Object r101, int r102) {
        if (r101 != null) goto L4;
    L14:
        return r102;
    L4:
        if (r100.getItemCount() == 0) goto L14;
        if (r102 < r100.getItemCount()) goto L9;
    L11:
        int r103 = r100.getIndex(r101);
        if (r103 == (-1)) goto L14;
        return r103;
    L9:
        if (Intrinsics.areEqual(r101, r100.getKey(r102)) == false) goto L11;
        return r102;
    }
}
