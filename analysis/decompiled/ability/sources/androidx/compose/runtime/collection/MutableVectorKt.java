package androidx.compose.runtime.collection;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u000b\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\b\u001a\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\b\u001a(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0006\b\u0000\u0010\u0011\u0018\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001aG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0006\b\u0000\u0010\u0011\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0014\b\b\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u0014\u0010\u0018\u001a\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0006\b\u0000\u0010\u0011\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0006\b\u0000\u0010\u0011\u0018\u00012\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001d¨\u0006\u001e"}, d2 = {"", "", "index", "LC7/r;", "checkIndex", "(Ljava/util/List;I)V", "size", "throwListIndexOutOfBoundsException", "(II)V", "fromIndex", "toIndex", "checkSubIndex", "(Ljava/util/List;II)V", "throwOutOfRangeException", "throwNegativeIndexException", "(I)V", "throwReversedIndicesException", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "Landroidx/compose/runtime/collection/MutableVector;", "MutableVector", "(I)Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "init", "(ILS7/k;)Landroidx/compose/runtime/collection/MutableVector;", "mutableVectorOf", "()Landroidx/compose/runtime/collection/MutableVector;", "", "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableVectorKt {
    public static final <T> MutableVector<T> MutableVector(int i) {
        k.m();
        throw null;
    }

    public static MutableVector MutableVector$default(int i, int i6, Object obj) {
        k.m();
        throw null;
    }

    public static final void checkIndex(List<?> list, int i) {
        int size = list.size();
        if (i < 0 || i >= size) {
            throwListIndexOutOfBoundsException(i, size);
        }
    }

    public static final void checkSubIndex(List<?> list, int i, int i6) {
        if (i > i6) {
            throwReversedIndicesException(i, i6);
        }
        if (i < 0) {
            throwNegativeIndexException(i);
        }
        if (i6 > list.size()) {
            throwOutOfRangeException(i6, list.size());
        }
    }

    public static final <T> MutableVector<T> mutableVectorOf() {
        k.m();
        throw null;
    }

    private static final void throwListIndexOutOfBoundsException(int i, int i6) {
        throw new IndexOutOfBoundsException(b.o(i, "Index ", i6, " is out of bounds. The list has ", " elements."));
    }

    private static final void throwNegativeIndexException(int i) {
        throw new IndexOutOfBoundsException(a.i(i, "fromIndex (", ") is less than 0."));
    }

    private static final void throwOutOfRangeException(int i, int i6) {
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is more than than the list size (" + i6 + ')');
    }

    private static final void throwReversedIndicesException(int i, int i6) {
        throw new IllegalArgumentException(b.o(i, "Indices are out of order. fromIndex (", i6, ") is greater than toIndex (", ")."));
    }

    public static final <T> MutableVector<T> MutableVector(int i, S7.k kVar) {
        k.m();
        throw null;
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... tArr) {
        return new MutableVector<>(tArr, tArr.length);
    }
}
