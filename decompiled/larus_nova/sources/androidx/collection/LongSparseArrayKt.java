package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.slice.SliceInitService;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001a(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b¢\u0006\u0002\u0010\u0007\u001a.\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a!\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a.\u0010\u000b\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a0\u0010\u0013\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a6\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u0002H\u00032\u0006\u0010\u0015\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a.\u0010\u0018\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0019\u001a)\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0004H\u0080\b\u001a0\u0010\u001c\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a\u0019\u0010\u001e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a!\u0010\u001f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a&\u0010 \u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010#\u001a!\u0010$\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a&\u0010%\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010&\u001a!\u0010'\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a&\u0010(\u001a\u00020\r\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010)\u001a\u0019\u0010*\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a.\u0010+\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\u0003H\u0080\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010,\u001a\u00020-\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0080\b\u001a!\u00104\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u001a.\u00105\u001a\u00020\f\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H/H\u0086\n¢\u0006\u0002\u0010\u0019\u001a-\u00106\u001a\b\u0012\u0004\u0012\u0002H/0\u0004\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H/0\u0004H\u0086\u0002\u001a.\u00107\u001a\u0002H/\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u0002H/H\u0086\b¢\u0006\u0002\u0010\t\u001a7\u00108\u001a\u0002H/\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H/09H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010:\u001a\u0019\u0010;\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004H\u0086\b\u001a-\u0010<\u001a\u00020\r\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u0002H/H\u0007¢\u0006\u0002\u0010\u000f\u001aT\u0010=\u001a\u00020\f\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u000426\u0010>\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u0011H/¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\f0?H\u0086\bø\u0001\u0000\u001a\u0016\u0010B\u001a\u00020C\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004\u001a\u001c\u0010D\u001a\b\u0012\u0004\u0012\u0002H/0E\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010.\u001a\u00020\u0012\"\u0004\b\u0000\u0010/*\b\u0012\u0004\u0012\u0002H/0\u00048Æ\u0002¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"DELETED", "", "commonGet", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/LongSparseArray;", "key", "", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "commonGetInternal", "commonRemove", "", "", "value", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "commonRemoveAt", "index", "", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonGc", "commonPut", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "commonPutAll", "other", "commonPutIfAbsent", "commonSize", "commonIsEmpty", "commonKeyAt", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonContainsKey", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonClear", "commonAppend", "commonToString", "", "size", ExifInterface.GPS_DIRECTION_TRUE, "getSize$annotations", "(Landroidx/collection/LongSparseArray;)V", "getSize", "(Landroidx/collection/LongSparseArray;)I", "contains", "set", "plus", "getOrDefault", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "remove", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "keyIterator", "Lkotlin/collections/LongIterator;", "valueIterator", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongSparseArrayKt {
    private static final Object DELETED = null;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C85161<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray<T> r100 = this.$this_valueIterator;
            int r101 = this.index;
            this.index = r101 + 1;
            return r100.valueAt(r101);
        }

        public final int getIndex() {
            return this.index;
        }

        public C85161(LongSparseArray<T> r100) {
            this.$this_valueIterator = r100;
        }

        public final void setIndex(int r100) {
            this.index = r100;
        }
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray r100) {
    }

    static {
        DELETED = new Object();
    }

    public static final /* synthetic */ Object access$getDELETED$p() {
        return DELETED;
    }

    public static final <E> void commonClear(LongSparseArray<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.size;
        Object[] r102 = r100.values;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = null;
        r103 = r103 + 1;
        goto L3
    L5:
        r100.size = 0;
        r100.garbage = false;
    }

    public static final <E> void commonGc(LongSparseArray<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.size;
        long[] r102 = r100.keys;
        Object[] r103 = r100.values;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r101) goto L10;
        Object r106 = r103[r104];
        if (r106 == access$getDELETED$p()) goto L9;
        if (r104 == r105) goto L8;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L8:
        r105 = r105 + 1;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        r100.garbage = false;
        r100.size = r105;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> int commonSize(LongSparseArray<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L14;
        int r101 = r100.size;
        long[] r102 = r100.keys;
        Object[] r103 = r100.values;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r101) goto L12;
        Object r106 = r103[r104];
        if (r106 == access$getDELETED$p()) goto L11;
        if (r104 == r105) goto L10;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L10:
        r105 = r105 + 1;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        r100.garbage = false;
        r100.size = r105;
    L14:
        return r100.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() > 0) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r101 = new StringBuilder(r100.size * 28);
        r101.append('{');
        int r102 = r100.size;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        if (r103 <= 0) goto L10;
        r101.append(", ");
    L10:
        r101.append(r100.keyAt(r103));
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        E r104 = r100.valueAt(r103);
        if (r104 == r101) goto L13;
        r101.append(r104);
    L14:
        r103 = r103 + 1;
        goto L7
    L13:
        r101.append("(this Map)");
        goto L14
    L15:
        r101.append('}');
        return r101.toString();
    }

    public static final <T> int getSize(LongSparseArray<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !r100.isEmpty();
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new AnonymousClass1(r100);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new C85161(r100);
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> r100, E r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.indexOfValue(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> E commonGet(LongSparseArray<E> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r102 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (r100.values[r102] == access$getDELETED$p()) goto L8;
        return (E) r100.values[r102];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L14;
        int r101 = r100.size;
        long[] r102 = r100.keys;
        Object[] r103 = r100.values;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r101) goto L12;
        Object r106 = r103[r104];
        if (r106 == access$getDELETED$p()) goto L11;
        if (r104 == r105) goto L10;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L10:
        r105 = r105 + 1;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        r100.garbage = false;
        r100.size = r105;
    L14:
        return ContainerHelpersKt.binarySearch(r100.keys, r100.size, r110);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> r100, E r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
        if (r100.garbage == false) goto L13;
        int r102 = r100.size;
        long[] r103 = r100.keys;
        Object[] r104 = r100.values;
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r105 >= r102) goto L12;
        Object r107 = r104[r105];
        if (r107 == access$getDELETED$p()) goto L11;
        if (r105 == r106) goto L10;
        r103[r106] = r103[r105];
        r104[r106] = r107;
        r104[r105] = null;
    L10:
        r106 = r106 + 1;
    L11:
        r105 = r105 + 1;
        goto L5
    L12:
        r100.garbage = false;
        r100.size = r106;
    L13:
        int r108 = r100.size;
    L14:
        if (r101 >= r108) goto L19;
        if (r100.values[r101] == r110) goto L17;
        r101 = r101 + 1;
        goto L14
    L17:
        return r101;
    L19:
        return -1;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r110 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (r100.garbage == false) goto L22;
        int r102 = r100.size;
        long[] r103 = r100.keys;
        Object[] r104 = r100.values;
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r105 >= r102) goto L20;
        Object r107 = r104[r105];
        if (r107 == access$getDELETED$p()) goto L19;
        if (r105 == r106) goto L18;
        r103[r106] = r103[r105];
        r104[r106] = r107;
        r104[r105] = null;
    L18:
        r106 = r106 + 1;
    L19:
        r105 = r105 + 1;
        goto L13
    L20:
        r100.garbage = false;
        r100.size = r106;
    L22:
        return r100.keys[r110];
    L5:
        if (r110 >= r100.size) goto L7;
        r101 = true;
        goto L8
    }

    public static final <E> void commonPutAll(LongSparseArray<E> r100, LongSparseArray<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101.keyAt(r103), r101.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <E> void commonRemove(LongSparseArray<E> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r100.values[r102] == access$getDELETED$p()) goto L9;
        r100.values[r102] = access$getDELETED$p();
        r100.garbage = true;
        return;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.values[r101] == access$getDELETED$p()) goto L6;
        r100.values[r101] = access$getDELETED$p();
        r100.garbage = true;
        return;
    }

    public static final <E> E commonValueAt(LongSparseArray<E> r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r110 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (r100.garbage == false) goto L22;
        int r102 = r100.size;
        long[] r103 = r100.keys;
        Object[] r104 = r100.values;
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r105 >= r102) goto L20;
        Object r107 = r104[r105];
        if (r107 == access$getDELETED$p()) goto L19;
        if (r105 == r106) goto L18;
        r103[r106] = r103[r105];
        r104[r106] = r107;
        r104[r105] = null;
    L18:
        r106 = r106 + 1;
    L19:
        r105 = r105 + 1;
        goto L13
    L20:
        r100.garbage = false;
        r100.size = r106;
    L22:
        return (E) r100.values[r110];
    L5:
        if (r110 >= r100.size) goto L7;
        r101 = true;
        goto L8
    }

    public static final <T> boolean contains(LongSparseArray<T> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.containsKey(r101);
    }

    public static final <T> void forEach(LongSparseArray<T> r100, Function2<? super Long, ? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Long.valueOf(r100.keyAt(r103)), r100.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r100, LongSparseArray<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        LongSparseArray<T> r102 = new LongSparseArray(r100.size() + r101.size());
        r102.putAll(r100);
        r102.putAll(r101);
        return r102;
    }

    public static final <E> void commonAppend(LongSparseArray<E> r100, long r110, E r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.size;
        if (r101 == 0) goto L9;
        if (r110 > r100.keys[r101 - 1]) goto L9;
        r100.put(r110, r111);
        return;
    L9:
        if (r100.garbage == false) goto L21;
        long[] r102 = r100.keys;
        if (r101 < r102.length) goto L21;
        Object[] r103 = r100.values;
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r104 >= r101) goto L20;
        Object r106 = r103[r104];
        if (r106 == access$getDELETED$p()) goto L19;
        if (r104 == r105) goto L18;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L18:
        r105 = r105 + 1;
    L19:
        r104 = r104 + 1;
        goto L13
    L20:
        r100.garbage = false;
        r100.size = r105;
    L21:
        int r107 = r100.size;
        if (r107 < r100.keys.length) goto L24;
        int r108 = ContainerHelpersKt.idealLongArraySize(r107 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r108);
        r100.values = Arrays.copyOf(r100.values, r108);
    L24:
        r100.keys[r107] = r110;
        r100.values[r107] = r111;
        r100.size = r107 + 1;
    }

    public static final <E> E commonGet(LongSparseArray<E> r100, long r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r103 >= 0) goto L5;
        return r102;
    L5:
        if (r100.values[r103] != access$getDELETED$p()) goto L8;
        return r102;
    L8:
        return (E) r100.values[r103];
    }

    public static final Object commonGetInternal(LongSparseArray<?> r100, long r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r103 >= 0) goto L5;
        return r102;
    L5:
        if (r100.values[r103] != access$getDELETED$p()) goto L8;
        return r102;
    L8:
        return r100.values[r103];
    }

    public static final <E> void commonPut(LongSparseArray<E> r100, long r110, E r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r110);
        if (r101 < 0) goto L5;
        r100.values[r101] = r111;
        return;
    L5:
        int r102 = ~r101;
        if (r102 >= r100.size) goto L12;
        if (r100.values[r102] != access$getDELETED$p()) goto L12;
        r100.keys[r102] = r110;
        r100.values[r102] = r111;
        return;
    L12:
        if (r100.garbage == false) goto L24;
        int r103 = r100.size;
        long[] r104 = r100.keys;
        if (r103 < r104.length) goto L24;
        Object[] r105 = r100.values;
        int r106 = 0;
        int r107 = 0;
    L16:
        if (r106 >= r103) goto L23;
        Object r108 = r105[r106];
        if (r108 == access$getDELETED$p()) goto L22;
        if (r106 == r107) goto L21;
        r104[r107] = r104[r106];
        r105[r107] = r108;
        r105[r106] = null;
    L21:
        r107 = r107 + 1;
    L22:
        r106 = r106 + 1;
        goto L16
    L23:
        r100.garbage = false;
        r100.size = r107;
        r102 = ~ContainerHelpersKt.binarySearch(r100.keys, r107, r110);
    L24:
        int r109 = r100.size;
        if (r109 < r100.keys.length) goto L27;
        int r112 = ContainerHelpersKt.idealLongArraySize(r109 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r112);
        r100.values = Arrays.copyOf(r100.values, r112);
    L27:
        int r113 = r100.size;
        if ((r113 - r102) == 0) goto L30;
        long[] r114 = r100.keys;
        int r115 = r102 + 1;
        ArraysKt.copyInto(r114, r114, r115, r102, r113);
        Object[] r116 = r100.values;
        ArraysKt.copyInto(r116, r116, r115, r102, r100.size);
    L30:
        r100.keys[r102] = r110;
        r100.values[r102] = r111;
        r100.size++;
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> r100, long r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        E r103 = r100.get(r101);
        if (r103 != null) goto L5;
        r100.put(r101, r102);
    L5:
        return r103;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> r100, long r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.indexOfKey(r101);
        if (r103 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r102, r100.valueAt(r103)) == false) goto L10;
        r100.removeAt(r103);
        return true;
    L10:
        return false;
    }

    public static final <E> E commonReplace(LongSparseArray<E> r100, long r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.indexOfKey(r101);
        if (r103 < 0) goto L6;
        Object[] r104 = r100.values;
        E r105 = (E) r104[r103];
        r104[r103] = r102;
        return r105;
    L6:
        return null;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> r100, int r110, E r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r110 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (r100.garbage == false) goto L21;
        int r102 = r100.size;
        long[] r103 = r100.keys;
        Object[] r104 = r100.values;
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r105 >= r102) goto L20;
        Object r107 = r104[r105];
        if (r107 == access$getDELETED$p()) goto L19;
        if (r105 == r106) goto L18;
        r103[r106] = r103[r105];
        r104[r106] = r107;
        r104[r105] = null;
    L18:
        r106 = r106 + 1;
    L19:
        r105 = r105 + 1;
        goto L13
    L20:
        r100.garbage = false;
        r100.size = r106;
    L21:
        r100.values[r110] = r111;
        return;
    L5:
        if (r110 >= r100.size) goto L7;
        r101 = true;
        goto L8
    }

    public static final <T> T getOrDefault(LongSparseArray<T> r100, long r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.get(r101, r102);
    }

    public static final <T> T getOrElse(LongSparseArray<T> r100, long r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        T r103 = r100.get(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r102.invoke();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(LongSparseArray r100, long r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.remove(r101, r102);
    }

    public static final <T> void set(LongSparseArray<T> r100, long r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r101, r102);
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> r100, long r101, E r102, E r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r104 = r100.indexOfKey(r101);
        if (r104 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.values[r104], r102) == false) goto L10;
        r100.values[r104] = r103;
        return true;
    L10:
        return false;
    }
}
