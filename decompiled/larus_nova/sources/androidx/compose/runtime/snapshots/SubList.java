package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0002J\u0015\u0010!\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010%\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\b\u0010&\u001a\u00020#H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0015\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010*\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0015\u0010+\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001bJ\u0016\u0010,\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u001e\u0010-\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020#H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "structure", "value", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SubList<T> implements List<T>, KMutableList {
    public static final int $stable = 8;
    private final int offset;
    private final SnapshotStateList<T> parentList;
    private int size;
    private int structure;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SubList$listIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\r\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SubList$listIterator$1", "", "hasPrevious", "", "nextIndex", "", "previous", "()Ljava/lang/Object;", "previousIndex", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "set", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements ListIterator<T>, KMutableListIterator {
        final /* synthetic */ Ref.IntRef $current;
        final /* synthetic */ SubList<T> this$0;

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.$current.element < (this.this$0.size() - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.$current.element < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int r100 = this.$current.element + 1;
            SnapshotStateListKt.access$validateRange(r100, this.this$0.size());
            this.$current.element = r100;
            return this.this$0.get(r100);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.$current.element + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int r100 = this.$current.element;
            SnapshotStateListKt.access$validateRange(r100, this.this$0.size());
            this.$current.element = r100 - 1;
            return this.this$0.get(r100);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.$current.element;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Void remove() {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.ListIterator
        public Void add(T r100) {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        public Void set(T r100) {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object r100) {
            add(r100);
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object r100) {
            set(r100);
        }

        public AnonymousClass1(Ref.IntRef r100, SubList<T> r101) {
            this.$current = r100;
            this.this$0 = r101;
        }
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    private final void validateModification() {
        if (SnapshotStateListKt.getStructure(this.parentList) != this.structure) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() <= 0) goto L6;
        validateModification();
        SnapshotStateList<T> r100 = this.parentList;
        int r101 = this.offset;
        r100.removeRange(r101, size() + r101);
        this.size = 0;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r100) {
        validateModification();
        this.parentList.add(this.offset + size(), r100);
        this.size = size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
        return addAll(size(), r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        Collection<?> r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (contains(r102.next()) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.List
    public T get(int r100) {
        validateModification();
        SnapshotStateListKt.access$validateRange(r100, size());
        return this.parentList.get(this.offset + r100);
    }

    @Override // java.util.List
    public int indexOf(Object r100) {
        validateModification();
        int r101 = this.offset;
        Iterator<Integer> r102 = RangesKt.until(r101, size() + r101).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        int r103 = ((IntIterator) r102).nextInt();
        if (Intrinsics.areEqual(r100, this.parentList.get(r103)) == false) goto L4;
        return r103 - this.offset;
    L9:
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object r100) {
        validateModification();
        int r101 = this.offset + size();
    L3:
        r101 = r101 - 1;
        if (r101 < this.offset) goto L10;
        if (Intrinsics.areEqual(r100, this.parentList.get(r101)) == false) goto L3;
        return r101 - this.offset;
    L10:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r100) {
        validateModification();
        Ref.IntRef r101 = new Ref.IntRef();
        r101.element = r100 - 1;
        return new AnonymousClass1(r101, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L5;
        remove(r101);
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        Iterator<?> r101 = r100.iterator();
    L3:
        boolean r102 = false;
    L5:
        if (r101.hasNext() == false) goto L10;
        if (remove(r101.next()) == true) goto L9;
        if (r102 == false) goto L3;
    L9:
        r102 = true;
        goto L5
    L10:
        return r102;
    }

    public T removeAt(int r100) {
        validateModification();
        T r101 = this.parentList.remove(this.offset + r100);
        this.size = size() - 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        validateModification();
        SnapshotStateList<T> r101 = this.parentList;
        int r102 = this.offset;
        int r103 = r101.retainAllInRange$runtime(r100, r102, size() + r102);
        if (r103 <= 0) goto L5;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        this.size = size() - r103;
    L5:
        if (r103 <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int r100) {
        return removeAt(r100);
    }

    @Override // java.util.List
    public void add(int r100, T r101) {
        validateModification();
        this.parentList.add(this.offset + r100, r101);
        this.size = size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends T> r101) {
        validateModification();
        boolean r102 = this.parentList.addAll(r100 + this.offset, r101);
        if (r102 == false) goto L5;
        this.size = size() + r101.size();
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
    L5:
        return r102;
    }

    @Override // java.util.List
    public T set(int r100, T r101) {
        SnapshotStateListKt.access$validateRange(r100, size());
        validateModification();
        T r102 = this.parentList.set(r100 + this.offset, r101);
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return r102;
    }

    @Override // java.util.List
    public List<T> subList(int r100, int r101) {
        boolean r102 = true;
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L14;
        PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
    L14:
        validateModification();
        SnapshotStateList<T> r104 = this.parentList;
        int r105 = this.offset;
        return new SubList(r104, r100 + r105, r101 + r105);
    L9:
        if (r101 > size()) goto L11;
    L6:
        r103 = false;
        goto L7
    }

    public SubList(SnapshotStateList<T> r100, int r101, int r102) {
        this.parentList = r100;
        this.offset = r101;
        this.structure = SnapshotStateListKt.getStructure(r100);
        this.size = r102 - r101;
    }
}
