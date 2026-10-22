package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetMutableIterator;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;)V", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "checkNextWasInvoked", "checkForComodification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentOrderedSetMutableIterator<E> extends PersistentOrderedSetIterator<E> implements KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedSetBuilder<E> builder;
    private int expectedModCount;
    private E lastIteratedElement;
    private boolean nextWasInvoked;

    private final void checkForComodification() {
        if (this.builder.getHashMapBuilder$runtime().getModCount$runtime() != this.expectedModCount) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    private final void checkNextWasInvoked() {
        if (this.nextWasInvoked == false) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public E next() {
        checkForComodification();
        E r100 = (E) super.next();
        this.lastIteratedElement = r100;
        this.nextWasInvoked = true;
        return r100;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        PersistentOrderedSetBuilder<E> r100 = this.builder;
        TypeIntrinsics.asMutableCollection(r100).remove(this.lastIteratedElement);
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime().getModCount$runtime();
        setIndex$runtime(getIndex$runtime() - 1);
    }

    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder<E> r100) {
        super(r100.getFirstElement$runtime(), r100.getHashMapBuilder$runtime());
        this.builder = r100;
        this.expectedModCount = r100.getHashMapBuilder$runtime().getModCount$runtime();
    }
}
