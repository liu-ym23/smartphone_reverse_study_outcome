package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", ExifInterface.LONGITUDE_EAST, "", "index", "", "size", "<init>", "(II)V", "getIndex", "()I", "setIndex", "(I)V", "getSize", "setSize", "hasNext", "", "hasPrevious", "nextIndex", "previousIndex", "checkHasNext", "", "checkHasNext$runtime", "checkHasPrevious", "checkHasPrevious$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractListIterator<E> implements ListIterator<E>, KMappedMarker {
    public static final int $stable = 8;
    private int index;
    private int size;

    @Override // java.util.ListIterator
    public void add(E r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(E r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.size) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        if (this.index <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index - 1;
    }

    public final void checkHasNext$runtime() {
        if (hasNext() == false) goto L6;
        return;
    L6:
        throw new NoSuchElementException();
    }

    public final void checkHasPrevious$runtime() {
        if (hasPrevious() == false) goto L6;
        return;
    L6:
        throw new NoSuchElementException();
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setSize(int r100) {
        this.size = r100;
    }

    public AbstractListIterator(int r100, int r101) {
        this.index = r100;
        this.size = r101;
    }
}
