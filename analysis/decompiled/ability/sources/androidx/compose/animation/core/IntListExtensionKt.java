package androidx.compose.animation.core;

import androidx.collection.IntList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006"}, d2 = {"binarySearch", "", "Landroidx/collection/IntList;", "element", "fromIndex", "toIndex", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntListExtensionKt {
    public static final int binarySearch(IntList intList, int i) {
        return binarySearch$default(intList, i, 0, 0, 6, null);
    }

    public static /* synthetic */ int binarySearch$default(IntList intList, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i6 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = intList.getSize();
        }
        return binarySearch(intList, i, i6, i10);
    }

    public static final int binarySearch(IntList intList, int i, int i6) {
        return binarySearch$default(intList, i, i6, 0, 4, null);
    }

    public static final int binarySearch(IntList intList, int i, int i6, int i10) {
        if (!(i6 <= i10)) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex(" + i6 + ") > toIndex(" + i10 + ')');
        }
        if (i6 >= 0) {
            if (i10 > intList.getSize()) {
                throw new IndexOutOfBoundsException(B7.a.h(i10, "Index out of range: "));
            }
            int i11 = i10 - 1;
            while (i6 <= i11) {
                int i12 = (i6 + i11) >>> 1;
                int i13 = intList.get(i12);
                if (i13 < i) {
                    i6 = i12 + 1;
                } else {
                    if (i13 <= i) {
                        return i12;
                    }
                    i11 = i12 - 1;
                }
            }
            return -(i6 + 1);
        }
        throw new IndexOutOfBoundsException(B7.a.h(i6, "Index out of range: "));
    }
}
