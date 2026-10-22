package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080\b\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0080\b\u001a-\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0080\b\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u001aD\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001a>\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001a>\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001a\u001d\u0010\u0013\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u000bH\u0000¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"fastMap", "Landroidx/collection/ObjectList;", "R", ExifInterface.GPS_DIRECTION_TRUE, "transform", "Lkotlin/Function1;", "fastFilter", "predicate", "", "all", "toMutableObjectList", "Landroidx/collection/MutableObjectList;", "sortedBy", "K", "", "selector", "isSorted", "sortBy", "", "removeLast", "(Landroidx/collection/MutableObjectList;)Ljava/lang/Object;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExtensionsKt {
    public static final <T> T removeLast(MutableObjectList<T> r100) {
        if (r100.isEmpty() == true) goto L7;
        int r101 = r100.getSize() - 1;
        T r102 = r100.get(r101);
        r100.removeAt(r101);
        return r102;
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> MutableObjectList<T> toMutableObjectList(ObjectList<T> r100) {
        MutableObjectList<T> r101 = (MutableObjectList<T>) new MutableObjectList(r100.getSize());
        Object[] r102 = r100.content;
        int r103 = r100._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(r102[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <T> boolean all(ObjectList<T> r100, Function1<? super T, Boolean> r101) {
        Object[] r102 = r100.content;
        int r103 = r100._size;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        if (r101.invoke(r102[r104]).booleanValue() == false) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final <T> ObjectList<T> fastFilter(ObjectList<T> r100, Function1<? super T, Boolean> r101) {
        Object[] r102 = r100.content;
        int r103 = r100._size;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L9;
        if (r101.invoke(r102[r105]).booleanValue() == false) goto L7;
        r105 = r105 + 1;
        goto L4
    L7:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L12;
        return r100;
    L12:
        MutableObjectList r107 = new MutableObjectList(0, 1, null);
        Object[] r108 = r100.content;
        int r109 = r100._size;
    L13:
        if (r104 >= r109) goto L18;
        Object r110 = r108[r104];
        if (r101.invoke(r110).booleanValue() == false) goto L17;
        r107.add(r110);
    L17:
        r104 = r104 + 1;
        goto L13
    L18:
        return r107;
    L9:
        r106 = true;
        goto L10
    }

    public static final <T, R> ObjectList<R> fastMap(ObjectList<T> r100, Function1<? super T, ? extends R> r101) {
        MutableObjectList r102 = new MutableObjectList(r100.getSize());
        Object[] r103 = r100.content;
        int r104 = r100._size;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r102.add(r101.invoke(r103[r105]));
        r105 = r105 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final <T, K extends Comparable<? super K>> boolean isSorted(ObjectList<T> r100, Function1<? super T, ? extends K> r101) {
        if (r100.getSize() > 1) goto L5;
        return true;
    L5:
        K r102 = r101.invoke(r100.get(0));
        if (r102 != null) goto L8;
        return false;
    L8:
        int r103 = r100.getSize();
        int r104 = 1;
    L9:
        if (r104 >= r103) goto L17;
        K r105 = r101.invoke(r100.get(r104));
        if (r105 == null) goto L12;
        if (r102.compareTo(r105) > 0) goto L15;
        r104 = r104 + 1;
        r102 = r105;
        goto L9
    L15:
        return false;
    L12:
        return false;
    L17:
        return true;
    }

    public static final <T, K extends Comparable<? super K>> void sortBy(MutableObjectList<T> r100, final Function1<? super T, ? extends K> r101) {
        List<T> r102 = r100.asMutableList();
        if (r102.size() <= 1) goto L6;
        CollectionsKt.sortWith(r102, new ExtensionsKt$sortBy$$inlined$sortBy$1(r101));
        return;
    }

    public static final <T, K extends Comparable<? super K>> ObjectList<T> sortedBy(ObjectList<T> r100, Function1<? super T, ? extends K> r101) {
        if (isSorted(r100, r101) == true) goto L7;
        MutableObjectList r102 = toMutableObjectList(r100);
        sortBy(r102, r101);
        return r102;
    L7:
        return r100;
    }
}
