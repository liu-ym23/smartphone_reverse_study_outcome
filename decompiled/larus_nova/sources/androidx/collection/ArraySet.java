package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010)\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001@B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\tB\u0019\b\u0016\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bB\u001b\b\u0016\u0012\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0004\b\u0006\u0010\u000eJ\b\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0015J\u0013\u0010*\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u0005¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020%H\u0016J\u0015\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\u0016\u0010/\u001a\u00020!2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0015\u00100\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\u0013\u00101\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u0005¢\u0006\u0002\u0010,J\u0016\u00102\u001a\u00020%2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\u0010\u0017J%\u00103\u001a\b\u0012\u0004\u0012\u0002H40\r\"\u0004\b\u0001\u001042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H40\r¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020:H\u0016J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<H\u0096\u0002J\u0016\u0010=\u001a\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u0010/\u001a\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u00102\u001a\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u0010?\u001a\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001c¨\u0006A"}, d2 = {"Landroidx/collection/ArraySet;", ExifInterface.LONGITUDE_EAST, "", "", "capacity", "", "<init>", "(I)V", "set", "(Landroidx/collection/ArraySet;)V", "", "(Ljava/util/Collection;)V", "array", "", "([Ljava/lang/Object;)V", "hashes", "", "getHashes$collection", "()[I", "setHashes$collection", "([I)V", "", "getArray$collection", "()[Ljava/lang/Object;", "setArray$collection", "[Ljava/lang/Object;", "_size", "get_size$collection", "()I", "set_size$collection", "size", "getSize", "clear", "", "ensureCapacity", "minimumCapacity", "contains", "", "element", "(Ljava/lang/Object;)Z", "indexOf", "key", "valueAt", "index", "(I)Ljava/lang/Object;", "isEmpty", "add", "addAll", "remove", "removeAt", "removeAll", "toArray", ExifInterface.GPS_DIRECTION_TRUE, "([Ljava/lang/Object;)[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "iterator", "", "containsAll", SlcElement.KEY_ELEMENTS, "retainAll", "ElementIterator", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArraySet<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {
    private int _size;
    private Object[] array;
    private int[] hashes;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\n"}, d2 = {"Landroidx/collection/ArraySet$ElementIterator;", "Landroidx/collection/IndexBasedArrayIterator;", "<init>", "(Landroidx/collection/ArraySet;)V", "elementAt", "index", "", "(I)Ljava/lang/Object;", "removeAt", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        final /* synthetic */ ArraySet<E> this$0;

        public ElementIterator(ArraySet r100) {
            this.this$0 = r100;
            super(r100.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int r100) {
            return this.this$0.valueAt(r100);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r100) {
            this.this$0.removeAt(r100);
        }
    }

    public ArraySet() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.array, 0, this._size);
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() == 0) goto L6;
        setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
        setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
        set_size$collection(0);
    L6:
        if (get_size$collection() != 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r100 = getHashes$collection();
        int r101 = get_size$collection();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r103 = r103 + r100[r102];
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (get_size$collection() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        if (isEmpty() == false) goto L5;
        return SliceInitService.DEFAULT_SWITCH;
    L5:
        StringBuilder r100 = new StringBuilder(get_size$collection() * 14);
        r100.append('{');
        int r101 = get_size$collection();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        if (r102 <= 0) goto L9;
        r100.append(", ");
    L9:
        E r103 = valueAt(r102);
        if (r103 == this) goto L12;
        r100.append(r103);
    L13:
        r102 = r102 + 1;
        goto L6
    L12:
        r100.append("(this Set)");
        goto L13
    L14:
        r100.append('}');
        return r100.toString();
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] r100) {
        this(0);
        if (r100 == null) goto L8;
        Iterator r101 = ArrayIteratorKt.iterator(r100);
    L6:
        if (r101.hasNext() == false) goto L10;
        add(r101.next());
        goto L6
    L10:
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E r110) {
        int r100 = get_size$collection();
        boolean r101 = false;
        if (r110 != null) goto L5;
        int r102 = ArraySetKt.indexOfNull(this);
        int r103 = 0;
    L6:
        if (r102 >= 0) goto L37;
        int r104 = ~r102;
        if (r100 < getHashes$collection().length) goto L27;
        int r105 = 8;
        if (r100 < 8) goto L14;
        r105 = (r100 >> 1) + r100;
    L17:
        int[] r106 = getHashes$collection();
        Object[] r111 = getArray$collection();
        ArraySetKt.allocArrays(this, r105);
        if (r100 != get_size$collection()) goto L26;
        if (getHashes$collection().length != 0) goto L23;
        r101 = true;
    L23:
        if ((!r101) == false) goto L27;
        ArraysKt.copyInto$default(r106, getHashes$collection(), 0, 0, r106.length, 6, null);
        ArraysKt.copyInto$default(r111, getArray$collection(), 0, 0, r111.length, 6, null);
        goto L27
    L26:
        throw new ConcurrentModificationException();
    L14:
        if (r100 >= 4) goto L17;
        r105 = 4;
    L27:
        if (r104 >= r100) goto L30;
        int r107 = r104 + 1;
        ArraysKt.copyInto(getHashes$collection(), getHashes$collection(), r107, r104, r100);
        ArraysKt.copyInto(getArray$collection(), getArray$collection(), r107, r104, r100);
    L30:
        if (r100 != get_size$collection()) goto L36;
        if (r104 >= getHashes$collection().length) goto L36;
        getHashes$collection()[r104] = r103;
        getArray$collection()[r104] = r110;
        set_size$collection(get_size$collection() + 1);
        return true;
    L36:
        throw new ConcurrentModificationException();
    L37:
        return false;
    L5:
        int r108 = r110.hashCode();
        r103 = r108;
        r102 = ArraySetKt.indexOf(this, r110, r108);
        goto L6
    }

    public final void addAll(ArraySet<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = r100.get_size$collection();
        ensureCapacity(get_size$collection() + r101);
        if (get_size$collection() != 0) goto L10;
        if (r101 <= 0) goto L13;
        ArraysKt.copyInto$default(r100.getHashes$collection(), getHashes$collection(), 0, 0, r101, 6, null);
        ArraysKt.copyInto$default(r100.getArray$collection(), getArray$collection(), 0, 0, r101, 6, null);
        if (get_size$collection() != 0) goto L9;
        set_size$collection(r101);
        return;
    L9:
        throw new ConcurrentModificationException();
    L13:
        return;
    L10:
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L16;
        add(r100.valueAt(r102));
        r102 = r102 + 1;
        goto L11
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<?> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (contains(r101.next()) == true) goto L4;
        return false;
    L8:
        return true;
    }

    public final void ensureCapacity(int r110) {
        int r100 = get_size$collection();
        if (getHashes$collection().length >= r110) goto L8;
        int[] r101 = getHashes$collection();
        Object[] r102 = getArray$collection();
        ArraySetKt.allocArrays(this, r110);
        if (get_size$collection() <= 0) goto L8;
        ArraysKt.copyInto$default(r101, getHashes$collection(), 0, 0, get_size$collection(), 6, null);
        ArraysKt.copyInto$default(r102, getArray$collection(), 0, 0, get_size$collection(), 6, null);
    L8:
        if (get_size$collection() != r100) goto L11;
        return;
    L11:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Set) == true) goto L8;
    L16:
        return false;
    L8:
        if (size() != ((Set) r100).size()) goto L16;
        int r101 = get_size$collection();     // Catch: Throwable -> L18
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L24;
        Set r103 = (Set) r100;     // Catch: Throwable -> L18
        if (r103.contains(valueAt(r102)) == false) goto L16;
        r102 = r102 + 1;
        goto L11
    L24:
        return true;
    }

    public final int indexOf(Object r100) {
        if (r100 != null) goto L5;
        return ArraySetKt.indexOfNull(this);
    L5:
        return ArraySetKt.indexOf(this, r100, r100.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L5;
        removeAt(r101);
        return true;
    L5:
        return false;
    }

    public final boolean removeAll(ArraySet<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = r100.get_size$collection();
        int r102 = get_size$collection();
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        remove(r100.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    L6:
        if (r102 == get_size$collection()) goto L10;
        return true;
    L10:
        return false;
    }

    public final E removeAt(int r110) {
        int r100 = get_size$collection();
        E r101 = (E) getArray$collection()[r110];
        if (r100 > 1) goto L5;
        clear();
    L23:
        return r101;
    L5:
        int r102 = r100 - 1;
        int r103 = 8;
        if (getHashes$collection().length > 8) goto L8;
    L17:
        if (r110 >= r102) goto L19;
        int r104 = r110 + 1;
        int r105 = r102 + 1;
        ArraysKt.copyInto(getHashes$collection(), getHashes$collection(), r110, r104, r105);
        ArraysKt.copyInto(getArray$collection(), getArray$collection(), r110, r104, r105);
    L19:
        getArray$collection()[r102] = null;
    L21:
        if (r100 != get_size$collection()) goto L25;
        set_size$collection(r102);
        goto L23
    L25:
        throw new ConcurrentModificationException();
    L8:
        if (get_size$collection() >= (getHashes$collection().length / 3)) goto L17;
        if (get_size$collection() <= 8) goto L12;
        r103 = get_size$collection() + (get_size$collection() >> 1);
    L12:
        int[] r106 = getHashes$collection();
        Object[] r107 = getArray$collection();
        ArraySetKt.allocArrays(this, r103);
        if (r110 <= 0) goto L15;
        ArraysKt.copyInto$default(r106, getHashes$collection(), 0, 0, r110, 6, null);
        ArraysKt.copyInto$default(r107, getArray$collection(), 0, 0, r110, 6, null);
    L15:
        if (r110 >= r102) goto L21;
        int r108 = r110 + 1;
        int r109 = r102 + 1;
        ArraysKt.copyInto(r106, getHashes$collection(), r110, r108, r109);
        ArraysKt.copyInto(r107, getArray$collection(), r110, r108, r109);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = get_size$collection() - 1;
        boolean r102 = false;
    L4:
        if ((-1) >= r101) goto L9;
        if (CollectionsKt.contains(r100, getArray$collection()[r101]) == true) goto L8;
        removeAt(r101);
        r102 = true;
    L8:
        r101 = r101 - 1;
        goto L4
    L9:
        return r102;
    }

    public final void setArray$collection(Object[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.array = r100;
    }

    public final void setHashes$collection(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hashes = r100;
    }

    public final void set_size$collection(int r100) {
        this._size = r100;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        T[] r101 = (T[]) ArraySetJvmUtil.resizeForToArray(r100, this._size);
        ArraysKt.copyInto(this.array, r101, 0, 0, this._size);
        return r101;
    }

    public final E valueAt(int r100) {
        return (E) getArray$collection()[r100];
    }

    public ArraySet(int r100) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (r100 <= 0) goto L6;
        ArraySetKt.allocArrays(this, r100);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        ensureCapacity(get_size$collection() + r100.size());
        Iterator<? extends E> r101 = r100.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | add(r101.next());
        goto L4
    L6:
        return r102;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<?> r101 = r100.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | remove(r101.next());
        goto L4
    L6:
        return r102;
    }

    public ArraySet(ArraySet<? extends E> r100) {
        this(0);
        if (r100 == null) goto L6;
        addAll(r100);
        return;
    }

    public ArraySet(Collection<? extends E> r100) {
        this(0);
        if (r100 == null) goto L6;
        addAll(r100);
        return;
    }

    public /* synthetic */ ArraySet(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
