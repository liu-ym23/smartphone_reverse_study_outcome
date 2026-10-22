package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0013J%\u0010\u0014\u001a\u00020\u00152\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "<init>", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime", "checkPositionIndex", "checkPositionIndex$runtime", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime", "orderedHashCode", "c", "", "orderedHashCode$runtime", "orderedEquals", "", "other", "orderedEquals$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListImplementation {
    public static final int $stable = 0;
    public static final ListImplementation INSTANCE = null;

    static {
        INSTANCE = new ListImplementation();
    }

    private ListImplementation() {
    }

    @JvmStatic
    public static final int orderedHashCode$runtime(Collection<?> r100) {
        Iterator<?> r101 = r100.iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L10;
        Object r103 = r101.next();
        int r104 = r102 * 31;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        r102 = r104 + r105;
        goto L4
    L8:
        r105 = 0;
        goto L9
    L10:
        return r102;
    }

    @JvmStatic
    public static final void checkElementIndex$runtime(int r100, int r101) {
        if (r100 < 0) goto L6;
        if (r100 >= r101) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException("index: " + r100 + ", size: " + r101);
    }

    @JvmStatic
    public static final void checkPositionIndex$runtime(int r100, int r101) {
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException("index: " + r100 + ", size: " + r101);
    }

    @JvmStatic
    public static final boolean orderedEquals$runtime(Collection<?> r100, Collection<?> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        Iterator<?> r102 = r101.iterator();
        Iterator<?> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r103.next(), r102.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @JvmStatic
    public static final void checkRangeIndexes$runtime(int r100, int r101, int r102) {
        if (r100 < 0) goto L10;
        if (r101 > r102) goto L10;
        if (r100 > r101) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("fromIndex: " + r100 + " > toIndex: " + r101);
    L10:
        throw new IndexOutOfBoundsException("fromIndex: " + r100 + ", toIndex: " + r101 + ", size: " + r102);
    }
}
