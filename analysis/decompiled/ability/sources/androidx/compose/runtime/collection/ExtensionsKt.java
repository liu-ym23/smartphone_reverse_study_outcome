package androidx.compose.runtime.collection;

import D7.z;
import N9.j;
import S7.k;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0003H\u0080\b¢\u0006\u0004\b\t\u0010\u0006\u001a4\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0003H\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003H\u0000¢\u0006\u0004\b\u0012\u0010\u0006\u001aE\u0010\u0013\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003H\u0000¢\u0006\u0004\b\u0013\u0010\u000b\u001aE\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00010\u000f*\b\u0012\u0004\u0012\u00028\u00000\f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0000¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/collection/ObjectList;", "Lkotlin/Function1;", "transform", "fastMap", "(Landroidx/collection/ObjectList;LS7/k;)Landroidx/collection/ObjectList;", "", "predicate", "fastFilter", "all", "(Landroidx/collection/ObjectList;LS7/k;)Z", "Landroidx/collection/MutableObjectList;", "toMutableObjectList", "(Landroidx/collection/ObjectList;)Landroidx/collection/MutableObjectList;", "", "K", "selector", "sortedBy", "isSorted", "LC7/r;", "sortBy", "(Landroidx/collection/MutableObjectList;LS7/k;)V", "removeLast", "(Landroidx/collection/MutableObjectList;)Ljava/lang/Object;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtensionsKt {
    public static final <T> boolean all(ObjectList<T> objectList, k kVar) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (!((Boolean) kVar.invoke(objArr[i6])).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> ObjectList<T> fastFilter(ObjectList<T> objectList, k kVar) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (!((Boolean) kVar.invoke(objArr[i6])).booleanValue()) {
                MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
                Object[] objArr2 = objectList.content;
                int i10 = objectList._size;
                for (int i11 = 0; i11 < i10; i11++) {
                    Object obj = objArr2[i11];
                    if (((Boolean) kVar.invoke(obj)).booleanValue()) {
                        mutableObjectList.add(obj);
                    }
                }
                return mutableObjectList;
            }
        }
        return objectList;
    }

    public static final <T, R> ObjectList<R> fastMap(ObjectList<T> objectList, k kVar) {
        MutableObjectList mutableObjectList = new MutableObjectList(objectList.getSize());
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            mutableObjectList.add(kVar.invoke(objArr[i6]));
        }
        return mutableObjectList;
    }

    public static final <T, K extends Comparable<? super K>> boolean isSorted(ObjectList<T> objectList, k kVar) {
        if (objectList.getSize() <= 1) {
            return true;
        }
        Comparable comparable = (Comparable) kVar.invoke(objectList.get(0));
        if (comparable == null) {
            return false;
        }
        int size = objectList.getSize();
        int i = 1;
        while (i < size) {
            Comparable comparable2 = (Comparable) kVar.invoke(objectList.get(i));
            if (comparable2 == null || comparable.compareTo(comparable2) > 0) {
                return false;
            }
            i++;
            comparable = comparable2;
        }
        return true;
    }

    public static final <T> T removeLast(MutableObjectList<T> mutableObjectList) {
        if (mutableObjectList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        int size = mutableObjectList.getSize() - 1;
        T t9 = mutableObjectList.get(size);
        mutableObjectList.removeAt(size);
        return t9;
    }

    public static final <T, K extends Comparable<? super K>> void sortBy(MutableObjectList<T> mutableObjectList, final k kVar) {
        List<T> listAsMutableList = mutableObjectList.asMutableList();
        if (listAsMutableList.size() > 1) {
            z.d0(new Comparator() { // from class: androidx.compose.runtime.collection.ExtensionsKt$sortBy$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    k kVar2 = kVar;
                    return j.m((Comparable) kVar2.invoke(t9), (Comparable) kVar2.invoke(t10));
                }
            }, listAsMutableList);
        }
    }

    public static final <T, K extends Comparable<? super K>> ObjectList<T> sortedBy(ObjectList<T> objectList, k kVar) {
        if (isSorted(objectList, kVar)) {
            return objectList;
        }
        MutableObjectList mutableObjectList = toMutableObjectList(objectList);
        sortBy(mutableObjectList, kVar);
        return mutableObjectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> MutableObjectList<T> toMutableObjectList(ObjectList<T> objectList) {
        MutableObjectList<T> mutableObjectList = (MutableObjectList<T>) new MutableObjectList(objectList.getSize());
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            mutableObjectList.add(objArr[i6]);
        }
        return mutableObjectList;
    }
}
