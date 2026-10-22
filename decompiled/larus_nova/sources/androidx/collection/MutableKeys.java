package androidx.collection;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u0019\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/collection/MutableKeys;", "K", "V", "", "parent", "Landroidx/collection/MutableScatterMap;", "<init>", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "clear", "", "addAll", SlcElement.KEY_ELEMENTS, "", "add", "element", "(Ljava/lang/Object;)Z", "retainAll", "removeAll", "remove", "containsAll", "contains", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableKeys<K, V> implements Set<K>, KMutableSet {
    private final MutableScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.MutableKeys$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"androidx/collection/MutableKeys$iterator$1", "", "iterator", "", "", "getIterator", "()Ljava/util/Iterator;", "current", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<K>, KMutableIterator {
        private int current;
        private final Iterator<Integer> iterator;
        final /* synthetic */ MutableKeys<K, V> this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            this.current = this.iterator.next().intValue();
            return (K) MutableKeys.access$getParent$p(this.this$0).keys[this.current];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current < 0) goto L6;
            MutableKeys.access$getParent$p(this.this$0).removeValueAt(this.current);
            this.current = -1;
            return;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final Iterator<Integer> getIterator() {
            return this.iterator;
        }

        public AnonymousClass1(MutableKeys<K, V> r100) {
            this.this$0 = r100;
            this.iterator = SequencesKt.iterator(new MutableKeys$iterator$1$iterator$1(r100, null));
            this.current = -1;
        }

        public final void setCurrent(int r100) {
            this.current = r100;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<K> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public MutableKeys(MutableScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.parent = r100;
    }

    public static final /* synthetic */ MutableScatterMap access$getParent$p(MutableKeys r100) {
        return r100.parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(K r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r100) {
        return this.parent.containsKey(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Collection<?> r101 = r100;
        if (r101.isEmpty() == true) goto L15;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if (this.parent.containsKey((K) r103) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r110) {
        MutableScatterMap<K, V> r100 = this.parent;
        if (r110 == null) goto L5;
        int r101 = r110.hashCode();
    L6:
        int r102 = r101 * ScatterMapKt.MurmurHashC1;
        int r103 = r102 ^ (r102 << 16);
        int r104 = r103 & 127;
        int r105 = r100._capacity;
        int r106 = (r103 >>> 7) & r105;
        int r107 = 0;
    L7:
        long[] r108 = r100.metadata;
        int r109 = r106 >> 3;
        int r111 = (r106 & 7) << 3;
        long r112 = ((r108[r109 + 1] << (64 - r111)) & ((-r111) >> 63)) | (r108[r109] >>> r111);
        long r113 = (((long) r104) * ScatterMapKt.BitmaskLsb) ^ r112;
        long r114 = ((~r113) & (r113 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r114 == 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L18;
        int r116 = ((Long.numberOfTrailingZeros(r114) >> 3) + r106) & r105;
        if (Intrinsics.areEqual(r100.keys[r116], r110) == true) goto L20;
        r114 = r114 & (r114 - 1);
    L20:
        if (r116 < 0) goto L23;
        this.parent.removeValueAt(r116);
        return true;
    L23:
        return false;
    L18:
        if (((r112 & ((~r112) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r107 = r107 + 8;
        r106 = (r106 + r107) & r105;
        goto L7
    L19:
        r116 = -1;
        goto L20
    L11:
        r115 = false;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = this.parent.metadata;
        int r101 = r100.length - 2;
        boolean r102 = false;
        if (r101 < 0) goto L23;
        int r103 = 0;
        boolean r104 = false;
    L5:
        long r105 = r100[r103];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r106 = 8 - ((~(r103 - r101)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r103 << 3) + r111;
        if (CollectionsKt.contains(r110, this.parent.keys[r113]) == false) goto L17;
        this.parent.removeValueAt(r113);
        r104 = true;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r106 == 8) goto L19;
        return r104;
    L19:
        if (r103 == r101) goto L21;
        r103 = r103 + 1;
        goto L5
    L21:
        r102 = r104;
    L23:
        return r102;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        long[] r100 = this.parent.metadata;
        int r101 = r100.length - 2;
        boolean r102 = false;
        if (r101 < 0) goto L23;
        int r103 = 0;
        boolean r104 = false;
    L5:
        long r105 = r100[r103];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r106 = 8 - ((~(r103 - r101)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r103 << 3) + r111;
        if (CollectionsKt.contains(r110, this.parent.keys[r113]) == true) goto L17;
        this.parent.removeValueAt(r113);
        r104 = true;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r106 == 8) goto L19;
        return r104;
    L19:
        if (r103 == r101) goto L21;
        r103 = r103 + 1;
        goto L5
    L21:
        r102 = r104;
    L23:
        return r102;
    }
}
