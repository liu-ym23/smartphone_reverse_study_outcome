package androidx.collection;

import C7.c;
import D7.G;
import D7.q;
import S7.n;
import T7.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\u001a*\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a0\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a,\u0010\t\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\bH\u0080\b¢\u0006\u0004\b\t\u0010\u0007\u001a(\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a0\u0010\u000b\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u000b\u0010\u000f\u001a(\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0007\u001a8\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0014\u0010\u0017\u001a \u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001a\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a0\u0010\u001d\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a2\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001f\u0010\u0007\u001a \u0010 \u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b \u0010!\u001a \u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0080\b¢\u0006\u0004\b$\u0010%\u001a(\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0080\b¢\u0006\u0004\b&\u0010'\u001a0\u0010(\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b(\u0010)\u001a(\u0010*\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b*\u0010+\u001a(\u0010,\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b,\u0010-\u001a(\u0010.\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b.\u0010/\u001a(\u00100\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b0\u00101\u001a \u00102\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b2\u0010\u0019\u001a0\u00103\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b3\u0010\u001b\u001a \u00105\u001a\u000204\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b5\u00106\u001a(\u00108\u001a\u00020\u000e\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b8\u0010/\u001a0\u00109\u001a\u00020\n\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b9\u0010\u001b\u001a4\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b:\u0010;\u001a0\u0010<\u001a\u00028\u0000\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b<\u0010\u0007\u001a9\u0010>\u001a\u00028\u0000\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0086\bø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a \u0010@\u001a\u00020\u000e\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b@\u0010#\u001a/\u0010A\u001a\u00020\u000e\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0007¢\u0006\u0004\bA\u0010\u000f\u001a=\u0010D\u001a\u00020\n\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0BH\u0086\bø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u001d\u0010G\u001a\u00020F\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bG\u0010H\u001a#\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bJ\u0010K\"\u0014\u0010L\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M\"(\u0010P\u001a\u00020\u0010\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002¢\u0006\f\u0012\u0004\bO\u0010\u0019\u001a\u0004\bN\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Q"}, d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/LongSparseArray;", "", "key", "commonGet", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "", "commonGetInternal", "LC7/r;", "commonRemove", "(Landroidx/collection/LongSparseArray;J)V", "value", "", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "", "index", "commonRemoveAt", "(Landroidx/collection/LongSparseArray;I)V", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonGc", "(Landroidx/collection/LongSparseArray;)V", "commonPut", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "other", "commonPutAll", "(Landroidx/collection/LongSparseArray;Landroidx/collection/LongSparseArray;)V", "commonPutIfAbsent", "commonSize", "(Landroidx/collection/LongSparseArray;)I", "commonIsEmpty", "(Landroidx/collection/LongSparseArray;)Z", "commonKeyAt", "(Landroidx/collection/LongSparseArray;I)J", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonIndexOfKey", "(Landroidx/collection/LongSparseArray;J)I", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonContainsKey", "(Landroidx/collection/LongSparseArray;J)Z", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonClear", "commonAppend", "", "commonToString", "(Landroidx/collection/LongSparseArray;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "contains", "set", "plus", "(Landroidx/collection/LongSparseArray;Landroidx/collection/LongSparseArray;)Landroidx/collection/LongSparseArray;", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/LongSparseArray;JLS7/a;)Ljava/lang/Object;", "isNotEmpty", "remove", "Lkotlin/Function2;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "forEach", "(Landroidx/collection/LongSparseArray;LS7/n;)V", "LD7/G;", "keyIterator", "(Landroidx/collection/LongSparseArray;)LD7/G;", "", "valueIterator", "(Landroidx/collection/LongSparseArray;)Ljava/util/Iterator;", "DELETED", "Ljava/lang/Object;", "getSize", "getSize$annotations", "size", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    private static final Object DELETED = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03231<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C03231(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return longSparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        int i = longSparseArray.size;
        if (i != 0 && j5 <= longSparseArray.keys[i - 1]) {
            longSparseArray.put(j5, e);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i6 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    Object obj = objArr[i10];
                    if (obj != DELETED) {
                        if (i10 != i6) {
                            jArr[i6] = jArr[i10];
                            objArr[i6] = obj;
                            objArr[i10] = null;
                        }
                        i6++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i6;
            }
        }
        int i11 = longSparseArray.size;
        if (i11 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i11 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            k.e(jArrCopyOf, "copyOf(...)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            k.e(objArrCopyOf, "copyOf(...)");
            longSparseArray.values = objArrCopyOf;
        }
        longSparseArray.keys[i11] = j5;
        longSparseArray.values[i11] = e;
        longSparseArray.size = i11 + 1;
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        k.f(longSparseArray, "<this>");
        int i = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i6 = 0; i6 < i; i6++) {
            objArr[i6] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j5) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j5) >= 0;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(e) >= 0;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        k.f(longSparseArray, "<this>");
        int i = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            if (obj != DELETED) {
                if (i10 != i6) {
                    jArr[i6] = jArr[i10];
                    objArr[i6] = obj;
                    objArr[i10] = null;
                }
                i6++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i6;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j5) {
        k.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[iBinarySearch];
    }

    public static final Object commonGetInternal(LongSparseArray<?> longSparseArray, long j5, Object obj) {
        k.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? obj : longSparseArray.values[iBinarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j5) {
        k.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e) {
        k.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        int i11 = longSparseArray.size;
        for (int i12 = 0; i12 < i11; i12++) {
            if (longSparseArray.values[i12] == e) {
                return i12;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i) {
        k.f(longSparseArray, "<this>");
        if (!(i >= 0 && i < longSparseArray.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        return longSparseArray.keys[i];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (iBinarySearch >= 0) {
            longSparseArray.values[iBinarySearch] = e;
            return;
        }
        int i = ~iBinarySearch;
        if (i < longSparseArray.size && longSparseArray.values[i] == DELETED) {
            longSparseArray.keys[i] = j5;
            longSparseArray.values[i] = e;
            return;
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i10 = 0;
                for (int i11 = 0; i11 < i6; i11++) {
                    Object obj = objArr[i11];
                    if (obj != DELETED) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i10;
                i = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i10, j5);
            }
        }
        int i12 = longSparseArray.size;
        if (i12 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i12 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            k.e(jArrCopyOf, "copyOf(...)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            k.e(objArrCopyOf, "copyOf(...)");
            longSparseArray.values = objArrCopyOf;
        }
        int i13 = longSparseArray.size;
        if (i13 - i != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i14 = i + 1;
            q.W(jArr2, jArr2, i14, i, i13);
            Object[] objArr2 = longSparseArray.values;
            q.X(objArr2, objArr2, i14, i, longSparseArray.size);
        }
        longSparseArray.keys[i] = j5;
        longSparseArray.values[i] = e;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> other) {
        k.f(longSparseArray, "<this>");
        k.f(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        E e6 = longSparseArray.get(j5);
        if (e6 == null) {
            longSparseArray.put(j5, e);
        }
        return e6;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j5) {
        k.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[iBinarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i) {
        k.f(longSparseArray, "<this>");
        if (longSparseArray.values[i] != DELETED) {
            longSparseArray.values[i] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j5);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i, E e) {
        k.f(longSparseArray, "<this>");
        if (!(i >= 0 && i < longSparseArray.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        longSparseArray.values[i] = e;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        k.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        k.f(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i = longSparseArray.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i6));
            sb.append('=');
            E eValueAt = longSparseArray.valueAt(i6);
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return androidx.appfunctions.metadata.a.h('}', "toString(...)", sb);
    }

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i) {
        k.f(longSparseArray, "<this>");
        if (!(i >= 0 && i < longSparseArray.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        return (E) longSparseArray.values[i];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j5) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.containsKey(j5);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, n action) {
        k.f(longSparseArray, "<this>");
        k.f(action, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j5, T t9) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.get(j5, t9);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j5, S7.a defaultValue) {
        k.f(longSparseArray, "<this>");
        k.f(defaultValue, "defaultValue");
        T t9 = longSparseArray.get(j5);
        return t9 == null ? (T) defaultValue.invoke() : t9;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        k.f(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    public static final <T> G keyIterator(final LongSparseArray<T> longSparseArray) {
        k.f(longSparseArray, "<this>");
        return new G() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // D7.G
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> other) {
        k.f(longSparseArray, "<this>");
        k.f(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(other.size() + longSparseArray.size());
        longSparseArray2.putAll(longSparseArray);
        longSparseArray2.putAll(other);
        return longSparseArray2;
    }

    @c
    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j5, Object obj) {
        k.f(longSparseArray, "<this>");
        return longSparseArray.remove(j5, obj);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j5, T t9) {
        k.f(longSparseArray, "<this>");
        longSparseArray.put(j5, t9);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        k.f(longSparseArray, "<this>");
        return new C03231(longSparseArray);
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j5);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? e : (E) longSparseArray.values[iBinarySearch];
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j5, E e, E e6) {
        k.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j5);
        if (iIndexOfKey < 0 || !k.b(longSparseArray.values[iIndexOfKey], e)) {
            return false;
        }
        longSparseArray.values[iIndexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j5, E e) {
        k.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j5);
        if (iIndexOfKey < 0 || !k.b(e, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }
}
