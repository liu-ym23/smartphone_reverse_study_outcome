package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001a!\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a.\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a.\u0010\u0011\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a-\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aT\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\f0\u001cH\u0086\bø\u0001\u0000\u001a\u0016\u0010\u001f\u001a\u00020 \"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\"\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"(\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/SparseArrayCompat;", "getSize$annotations", "(Landroidx/collection/SparseArrayCompat;)V", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "contains", "", "key", "set", "", "value", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "plus", "other", "getOrDefault", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "keyIterator", "Lkotlin/collections/IntIterator;", "valueIterator", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/SparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C85171<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
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
            SparseArrayCompat<T> r100 = this.$this_valueIterator;
            int r101 = this.index;
            this.index = r101 + 1;
            return r100.valueAt(r101);
        }

        public final int getIndex() {
            return this.index;
        }

        public C85171(SparseArrayCompat<T> r100) {
            this.$this_valueIterator = r100;
        }

        public final void setIndex(int r100) {
            this.index = r100;
        }
    }

    public static /* synthetic */ void getSize$annotations(SparseArrayCompat r100) {
    }

    public static final <T> int getSize(SparseArrayCompat<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !r100.isEmpty();
    }

    public static final <T> IntIterator keyIterator(final SparseArrayCompat<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new AnonymousClass1(r100);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new C85171(r100);
    }

    public static final <T> boolean contains(SparseArrayCompat<T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.containsKey(r101);
    }

    public static final <T> void forEach(SparseArrayCompat<T> r100, Function2<? super Integer, ? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Integer.valueOf(r100.keyAt(r103)), r100.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> r100, SparseArrayCompat<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        SparseArrayCompat<T> r102 = new SparseArrayCompat(r100.size() + r101.size());
        r102.putAll(r100);
        r102.putAll(r101);
        return r102;
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> r100, int r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.get(r101, r102);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> r100, int r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        T r103 = r100.get(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r102.invoke();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(SparseArrayCompat r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.remove(r101, r102);
    }

    public static final <T> void set(SparseArrayCompat<T> r100, int r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r101, r102);
    }
}
