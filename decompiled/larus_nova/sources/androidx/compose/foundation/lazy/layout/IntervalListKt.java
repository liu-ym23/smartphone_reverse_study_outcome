package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"binarySearch", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntervalListKt {
    public static final /* synthetic */ int access$binarySearch(MutableVector r100, int r101) {
        return binarySearch(r100, r101);
    }

    private static final <T> int binarySearch(MutableVector<IntervalList.Interval<T>> r100, int r101) {
        int r102 = r100.getSize() - 1;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        int r104 = ((r102 - r103) / 2) + r103;
        int r105 = r100.content[r104].getStartIndex();
        if (r105 == r101) goto L6;
        if (r105 < r101) goto L8;
        r102 = r104 - 1;
        goto L3
    L8:
        r103 = r104 + 1;
        if (r101 >= r100.content[r103].getStartIndex()) goto L3;
        return r104;
    L6:
        return r104;
    L12:
        return r103;
    }
}
