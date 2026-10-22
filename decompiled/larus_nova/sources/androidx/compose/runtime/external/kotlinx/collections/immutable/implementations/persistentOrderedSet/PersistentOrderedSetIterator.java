package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0002J\u000e\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", ExifInterface.LONGITUDE_EAST, "", "nextElement", "", "map", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "getMap$runtime", "()Ljava/util/Map;", "index", "", "getIndex$runtime", "()I", "setIndex$runtime", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "checkHasNext", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PersistentOrderedSetIterator<E> implements Iterator<E>, KMappedMarker {
    public static final int $stable = 8;
    private int index;
    private final Map<E, Links> map;
    private Object nextElement;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.map.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final void checkHasNext() {
        if (hasNext() == false) goto L6;
        return;
    L6:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public E next() {
        checkHasNext();
        E r100 = (E) this.nextElement;
        this.index++;
        Links r101 = this.map.get(r100);
        if (r101 == null) goto L7;
        this.nextElement = r101.getNext();
        return r100;
    L7:
        throw new ConcurrentModificationException("Hash code of an element (" + r100 + ") has changed after it was added to the persistent set.");
    }

    public final int getIndex$runtime() {
        return this.index;
    }

    public final Map<E, Links> getMap$runtime() {
        return this.map;
    }

    public final void setIndex$runtime(int r100) {
        this.index = r100;
    }

    public PersistentOrderedSetIterator(Object r100, Map<E, Links> r101) {
        this.nextElement = r100;
        this.map = r101;
    }
}
