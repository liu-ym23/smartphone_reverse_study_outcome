package androidx.compose.runtime.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a!\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0086\b\u001a@\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0014\b\b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u0001H\u0086\b\u001a0\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0006\b\u0000\u0010\u000f\u0018\u00012\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\u0015\"\u0002H\u000fH\u0086\b¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"checkIndex", "", "", "index", "", "throwListIndexOutOfBoundsException", "size", "checkSubIndex", "fromIndex", "toIndex", "throwOutOfRangeException", "throwNegativeIndexException", "throwReversedIndicesException", "MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "init", "Lkotlin/Function1;", "mutableVectorOf", SlcElement.KEY_ELEMENTS, "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MutableVectorKt {
    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[16], 0);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int r100) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[r100], 0);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... r100) {
        return new MutableVector(r100, r100.length);
    }

    private static final void throwNegativeIndexException(int r100) {
        throw new IndexOutOfBoundsException("fromIndex (" + r100 + ") is less than 0.");
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int r100, Function1<? super Integer, ? extends T> r101) {
        int r102 = 0;
        Intrinsics.reifiedOperationMarker(0, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] r103 = new Object[r100];
    L3:
        if (r102 >= r100) goto L6;
        r103[r102] = r101.invoke(Integer.valueOf(r102));
        r102 = r102 + 1;
        goto L3
    L6:
        return new MutableVector(r103, r100);
    }

    public static final void checkIndex(List<?> r100, int r101) {
        int r102 = r100.size();
        if (r101 < 0) goto L5;
        if (r101 >= r102) goto L5;
        return;
    L5:
        throwListIndexOutOfBoundsException(r101, r102);
    }

    private static final void throwListIndexOutOfBoundsException(int r100, int r101) {
        throw new IndexOutOfBoundsException("Index " + r100 + " is out of bounds. The list has " + r101 + " elements.");
    }

    private static final void throwOutOfRangeException(int r100, int r101) {
        throw new IndexOutOfBoundsException("toIndex (" + r100 + ") is more than than the list size (" + r101 + ')');
    }

    private static final void throwReversedIndicesException(int r100, int r101) {
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + r100 + ") is greater than toIndex (" + r101 + ").");
    }

    public static /* synthetic */ MutableVector MutableVector$default(int r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 16;
    L5:
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[r100], 0);
    }

    public static final void checkSubIndex(List<?> r100, int r101, int r102) {
        if (r101 <= r102) goto L4;
        throwReversedIndicesException(r101, r102);
    L4:
        if (r101 >= 0) goto L7;
        throwNegativeIndexException(r101);
    L7:
        if (r102 <= r100.size()) goto L10;
        throwOutOfRangeException(r102, r100.size());
        return;
    }
}
