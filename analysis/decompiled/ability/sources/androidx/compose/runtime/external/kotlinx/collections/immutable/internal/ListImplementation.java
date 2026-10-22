package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\tJ'\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0016\u001a\u00020\u00042\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\u00182\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", AppAgent.CONSTRUCT, "()V", "", "index", "size", "LC7/r;", "checkElementIndex$runtime", "(II)V", "checkElementIndex", "checkPositionIndex$runtime", "checkPositionIndex", "fromIndex", "toIndex", "checkRangeIndexes$runtime", "(III)V", "checkRangeIndexes", "", "c", "orderedHashCode$runtime", "(Ljava/util/Collection;)I", "orderedHashCode", "other", "", "orderedEquals$runtime", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "orderedEquals", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListImplementation {
    public static final int $stable = 0;
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    public static final void checkElementIndex$runtime(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(b.n(index, size, "index: ", ", size: "));
        }
    }

    public static final void checkPositionIndex$runtime(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(b.n(index, size, "index: ", ", size: "));
        }
    }

    public static final void checkRangeIndexes$runtime(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0 || toIndex > size) {
            StringBuilder sbS = a.s(fromIndex, "fromIndex: ", toIndex, ", toIndex: ", ", size: ");
            sbS.append(size);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(b.n(fromIndex, toIndex, "fromIndex: ", " > toIndex: "));
        }
    }

    public static final boolean orderedEquals$runtime(Collection<?> c, Collection<?> other) {
        if (c.size() != other.size()) {
            return false;
        }
        Iterator<?> it = other.iterator();
        Iterator<?> it2 = c.iterator();
        while (it2.hasNext()) {
            if (!k.b(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final int orderedHashCode$runtime(Collection<?> c) {
        Iterator<?> it = c.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }
}
