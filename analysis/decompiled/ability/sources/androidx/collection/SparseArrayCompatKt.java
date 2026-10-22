package androidx.collection;

import D7.q;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a<\u0010\u0006\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a'\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a2\u0010\u000b\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\b\u000b\u0010\u0010\u001a(\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0012\u0010\f\u001a0\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0007\u001a8\u0010\u0016\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a0\u0010\u001c\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a0\u0010\u001f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a2\u0010!\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b!\u0010\u0007\u001a \u0010\"\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a \u0010$\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b$\u0010%\u001a(\u0010&\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b&\u0010'\u001a(\u0010(\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b(\u0010\t\u001a0\u0010)\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b)\u0010\u001d\u001a(\u0010*\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b*\u0010'\u001a(\u0010+\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b+\u0010,\u001a(\u0010-\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b-\u0010.\u001a(\u0010/\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b/\u00100\u001a \u00101\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b1\u0010\u001b\u001a0\u00102\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b2\u0010\u001d\u001a \u00104\u001a\u000203\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/SparseArrayCompat;", "", "key", "defaultValue", "internalGet", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "LC7/r;", "commonRemove", "(Landroidx/collection/SparseArrayCompat;I)V", "", "value", "", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "index", "commonRemoveAt", "size", "commonRemoveAtRange", "(Landroidx/collection/SparseArrayCompat;II)V", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "gc", "(Landroidx/collection/SparseArrayCompat;)V", "commonPut", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "other", "commonPutAll", "(Landroidx/collection/SparseArrayCompat;Landroidx/collection/SparseArrayCompat;)V", "commonPutIfAbsent", "commonSize", "(Landroidx/collection/SparseArrayCompat;)I", "commonIsEmpty", "(Landroidx/collection/SparseArrayCompat;)Z", "commonKeyAt", "(Landroidx/collection/SparseArrayCompat;I)I", "commonValueAt", "commonSetValueAt", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonContainsKey", "(Landroidx/collection/SparseArrayCompat;I)Z", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonClear", "commonAppend", "", "commonToString", "(Landroidx/collection/SparseArrayCompat;)Ljava/lang/String;", "DELETED", "Ljava/lang/Object;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        k.f(sparseArrayCompat, "<this>");
        int i6 = sparseArrayCompat.size;
        if (i6 != 0 && i <= sparseArrayCompat.keys[i6 - 1]) {
            sparseArrayCompat.put(i, e);
            return;
        }
        if (sparseArrayCompat.garbage && i6 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i10 = sparseArrayCompat.size;
        if (i10 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            k.e(iArrCopyOf, "copyOf(...)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            k.e(objArrCopyOf, "copyOf(...)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        sparseArrayCompat.keys[i10] = i;
        sparseArrayCompat.values[i10] = e;
        sparseArrayCompat.size = i10 + 1;
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        k.f(sparseArrayCompat, "<this>");
        int i = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i6 = 0; i6 < i; i6++) {
            objArr[i6] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.indexOfKey(i) >= 0;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        int i6 = 0;
        while (true) {
            if (i6 >= i) {
                i6 = -1;
                break;
            }
            if (sparseArrayCompat.values[i6] == e) {
                break;
            }
            i6++;
        }
        return i6 >= 0;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i) {
        E e;
        k.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (iBinarySearch < 0 || (e = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (sparseArrayCompat.values[i6] == e) {
                return i6;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        k.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        k.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (iBinarySearch >= 0) {
            sparseArrayCompat.values[iBinarySearch] = e;
            return;
        }
        int i6 = ~iBinarySearch;
        if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
            sparseArrayCompat.keys[i6] = i;
            sparseArrayCompat.values[i6] = e;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        }
        int i10 = sparseArrayCompat.size;
        if (i10 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            k.e(iArrCopyOf, "copyOf(...)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            k.e(objArrCopyOf, "copyOf(...)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        int i11 = sparseArrayCompat.size;
        if (i11 - i6 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i12 = i6 + 1;
            q.R(i12, i6, iArr, iArr, i11);
            Object[] objArr = sparseArrayCompat.values;
            q.X(objArr, objArr, i12, i6, sparseArrayCompat.size);
        }
        sparseArrayCompat.keys[i6] = i;
        sparseArrayCompat.values[i6] = e;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> other) {
        k.f(sparseArrayCompat, "<this>");
        k.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = other.keyAt(i);
            E eValueAt = other.valueAt(i);
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = eValueAt;
            } else {
                int i6 = ~iBinarySearch;
                if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
                    }
                    int i10 = sparseArrayCompat.size;
                    if (i10 >= sparseArrayCompat.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                        k.e(iArrCopyOf, "copyOf(...)");
                        sparseArrayCompat.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                        k.e(objArrCopyOf, "copyOf(...)");
                        sparseArrayCompat.values = objArrCopyOf;
                    }
                    int i11 = sparseArrayCompat.size;
                    if (i11 - i6 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i12 = i6 + 1;
                        q.R(i12, i6, iArr, iArr, i11);
                        Object[] objArr = sparseArrayCompat.values;
                        q.X(objArr, objArr, i12, i6, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i6] = iKeyAt;
                    sparseArrayCompat.values[i6] = eValueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i6] = iKeyAt;
                    sparseArrayCompat.values[i6] = eValueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        k.f(sparseArrayCompat, "<this>");
        E e6 = (E) commonGet(sparseArrayCompat, i);
        if (e6 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = e;
                return e6;
            }
            int i6 = ~iBinarySearch;
            if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
                sparseArrayCompat.keys[i6] = i;
                sparseArrayCompat.values[i6] = e;
                return e6;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            }
            int i10 = sparseArrayCompat.size;
            if (i10 >= sparseArrayCompat.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                k.e(iArrCopyOf, "copyOf(...)");
                sparseArrayCompat.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                k.e(objArrCopyOf, "copyOf(...)");
                sparseArrayCompat.values = objArrCopyOf;
            }
            int i11 = sparseArrayCompat.size;
            if (i11 - i6 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i12 = i6 + 1;
                q.R(i12, i6, iArr, iArr, i11);
                Object[] objArr = sparseArrayCompat.values;
                q.X(objArr, objArr, i12, i6, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i6] = i;
            sparseArrayCompat.values[i6] = e;
            sparseArrayCompat.size++;
        }
        return e6;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (iBinarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i] != DELETED) {
            sparseArrayCompat.values[i] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i, int i6) {
        k.f(sparseArrayCompat, "<this>");
        int iMin = Math.min(i6, i + i6);
        while (i < iMin) {
            sparseArrayCompat.removeAt(i);
            i++;
        }
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        k.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i] = e;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i6));
            sb.append('=');
            E eValueAt = sparseArrayCompat.valueAt(i6);
            if (eValueAt != sparseArrayCompat) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return a.h('}', "toString(...)", sb);
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        k.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        Object[] objArr = sparseArrayCompat.values;
        if (i < objArr.length) {
            return (E) objArr[i];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            if (obj != DELETED) {
                if (i10 != i6) {
                    iArr[i6] = iArr[i10];
                    objArr[i6] = obj;
                    objArr[i10] = null;
                }
                i6++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i6;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i, T t9) {
        T t10;
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        return (iBinarySearch < 0 || (t10 = (T) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? t9 : t10;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        E e6;
        k.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        return (iBinarySearch < 0 || (e6 = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? e : e6;
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i, E e, E e6) {
        k.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i);
        if (iIndexOfKey < 0 || !k.b(sparseArrayCompat.values[iIndexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[iIndexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i, Object obj) {
        k.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i);
        if (iIndexOfKey < 0 || !k.b(obj, sparseArrayCompat.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(iIndexOfKey);
        return true;
    }
}
