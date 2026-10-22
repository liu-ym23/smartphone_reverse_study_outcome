package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0001J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0096\u0003¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\fH\u0096\u0001J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0003J\u0016\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001cJ\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0096\u0001J\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0019\u001a\u00020\tH\u0096\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableListAdapter;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "impl", "<init>", "(Ljava/util/List;)V", "subList", "fromIndex", "", "toIndex", "equals", "", "other", "", "hashCode", "toString", "", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "size", "getSize", "()I", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImmutableListAdapter<E> implements ImmutableList<E>, List<E>, KMappedMarker {
    public static final int $stable = 8;
    private final List<E> impl;

    @Override // java.util.List
    public void add(int r100, E r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends E> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        return this.impl.contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return this.impl.containsAll(r100);
    }

    @Override // java.util.List
    public E get(int r100) {
        return (E) ListProtector.get(this.impl, r100);
    }

    public int getSize() {
        return this.impl.size();
    }

    @Override // java.util.List
    public int indexOf(Object r100) {
        return this.impl.indexOf(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.impl.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r100) {
        return this.impl.lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.impl.listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r100) {
        return this.impl.listIterator(r100);
    }

    @Override // java.util.List
    public E remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int r100, E r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.impl.hashCode();
    }

    public String toString() {
        return this.impl.toString();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableListAdapter(List<? extends E> r100) {
        this.impl = r100;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r100) {
        return this.impl.equals(r100);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList, java.util.List
    public ImmutableList<E> subList(int r100, int r101) {
        return new ImmutableListAdapter(this.impl.subList(r100, r101));
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
        return subList(r100, r101);
    }
}
