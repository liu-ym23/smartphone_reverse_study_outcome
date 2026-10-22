package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u0005¢\u0006\u0002\u0010\b\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a/\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u0005¢\u0006\u0002\u0010\f\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000e\"\u0002H\u0005¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0011\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0012\u001a/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u000e\"\u0002H\u0005¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EmptyScatterSet", "Landroidx/collection/MutableScatterSet;", "", "emptyScatterSet", "Landroidx/collection/ScatterSet;", ExifInterface.LONGITUDE_EAST, "scatterSetOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", SlcElement.KEY_ELEMENTS, "", "([Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "mutableScatterSetOf", "(Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "([Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScatterSetKt {
    private static final MutableScatterSet<Object> EmptyScatterSet = null;

    static {
        EmptyScatterSet = new MutableScatterSet(0);
    }

    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet<Object> r100 = EmptyScatterSet;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return r100;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        int r100 = 0;
        return new MutableScatterSet(r100, 1, null);
    }

    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet<Object> r100 = EmptyScatterSet;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return r100;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableScatterSet<E> r101 = new MutableScatterSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableScatterSet r101 = new MutableScatterSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E r100) {
        MutableScatterSet<E> r101 = new MutableScatterSet(1);
        r101.plusAssign(r100);
        return r101;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E r100) {
        return mutableScatterSetOf(r100);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E r100, E r101) {
        MutableScatterSet<E> r102 = new MutableScatterSet(2);
        r102.plusAssign(r100);
        r102.plusAssign(r101);
        return r102;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E r100, E r101) {
        return mutableScatterSetOf(r100, r101);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E r100, E r101, E r102) {
        MutableScatterSet<E> r103 = new MutableScatterSet(3);
        r103.plusAssign(r100);
        r103.plusAssign(r101);
        r103.plusAssign(r102);
        return r103;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E r100, E r101, E r102) {
        return mutableScatterSetOf(r100, r101, r102);
    }
}
