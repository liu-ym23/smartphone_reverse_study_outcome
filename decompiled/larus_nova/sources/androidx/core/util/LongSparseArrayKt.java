package androidx.core.util;

import android.util.LongSparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0086\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0086\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"androidx/core/util/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C87771<T> implements Iterator<T>, KMappedMarker {
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

        public C87771(LongSparseArray<T> r100) {
            this.$this_valueIterator = r100;
        }

        public final void setIndex(int r100) {
            this.index = r100;
        }
    }

    public static final <T> int getSize(LongSparseArray<T> r100) {
        return r100.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> r100) {
        if (r100.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> r100) {
        if (r100.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> LongIterator keyIterator(final LongSparseArray<T> r100) {
        return new AnonymousClass1(r100);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r100) {
        return new C87771(r100);
    }

    public static final <T> boolean contains(LongSparseArray<T> r100, long r101) {
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> r100, long r101) {
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> r100, T r101) {
        if (r100.indexOfValue(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void forEach(LongSparseArray<T> r100, Function2<? super Long, ? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Long.valueOf(r100.keyAt(r103)), r100.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r100, LongSparseArray<T> r101) {
        LongSparseArray<T> r102 = new LongSparseArray(r100.size() + r101.size());
        putAll(r102, r100);
        putAll(r102, r101);
        return r102;
    }

    public static final <T> void putAll(LongSparseArray<T> r100, LongSparseArray<T> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101.keyAt(r103), r101.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> T getOrDefault(LongSparseArray<T> r100, long r101, T r102) {
        T r103 = r100.get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103;
    }

    public static final <T> T getOrElse(LongSparseArray<T> r100, long r101, Function0<? extends T> r102) {
        T r103 = r100.get(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r102.invoke();
    }

    public static final <T> boolean remove(LongSparseArray<T> r100, long r101, T r102) {
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

    public static final <T> void set(LongSparseArray<T> r100, long r101, T r102) {
        r100.put(r101, r102);
    }
}
