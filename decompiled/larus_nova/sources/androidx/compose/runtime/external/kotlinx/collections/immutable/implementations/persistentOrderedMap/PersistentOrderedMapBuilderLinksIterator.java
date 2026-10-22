package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import com.byted.cast.common.TeaEventTrack;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B%\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001b\u001a\u00020\u0013H\u0096\u0002J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "K", "V", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "getBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "lastIteratedKey", "getLastIteratedKey$runtime", "()Ljava/lang/Object;", "setLastIteratedKey$runtime", "(Ljava/lang/Object;)V", "nextWasInvoked", "", "expectedModCount", "", "index", "getIndex$runtime", "()I", "setIndex$runtime", "(I)V", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "", "checkHasNext", "checkNextWasInvoked", "checkForComodification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PersistentOrderedMapBuilderLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilder<K, V> builder;
    private int expectedModCount;
    private int index;
    private Object lastIteratedKey;
    private Object nextKey;
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

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.builder.size()) goto L5;
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
    public LinkedValue<V> next() {
        checkForComodification();
        checkHasNext();
        this.lastIteratedKey = this.nextKey;
        this.nextWasInvoked = true;
        this.index++;
        LinkedValue<V> r100 = this.builder.getHashMapBuilder$runtime().get(this.nextKey);
        if (r100 == null) goto L7;
        LinkedValue<V> r101 = r100;
        this.nextKey = r101.getNext();
        return r101;
    L7:
        throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
    }

    @Override // java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        PersistentOrderedMapBuilder<K, V> r100 = this.builder;
        TypeIntrinsics.asMutableMap(r100).remove(this.lastIteratedKey);
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime().getModCount$runtime();
        this.index--;
    }

    public final PersistentOrderedMapBuilder<K, V> getBuilder$runtime() {
        return this.builder;
    }

    public final int getIndex$runtime() {
        return this.index;
    }

    public final Object getLastIteratedKey$runtime() {
        return this.lastIteratedKey;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    public final void setIndex$runtime(int r100) {
        this.index = r100;
    }

    public final void setLastIteratedKey$runtime(Object r100) {
        this.lastIteratedKey = r100;
    }

    public PersistentOrderedMapBuilderLinksIterator(Object r100, PersistentOrderedMapBuilder<K, V> r101) {
        this.nextKey = r100;
        this.builder = r101;
        this.lastIteratedKey = EndOfChain.INSTANCE;
        this.expectedModCount = r101.getHashMapBuilder$runtime().getModCount$runtime();
    }
}
