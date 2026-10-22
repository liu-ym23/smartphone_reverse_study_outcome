package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\r\u0010\u001d\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001eJ\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000e\u0010\u001f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u001cH\u0002R.\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\bX\u0084\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", ExifInterface.GPS_DIRECTION_TRUE, "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "getPath", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "hasNext", "", "getHasNext$annotations", "()V", "moveToNextNodeWithData", "pathIndex", "ensureNextEntryIsReady", "", "currentKey", "()Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, "checkHasNext", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    public static final int $stable = 8;
    private boolean hasNext;
    private final TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex;

    private static /* synthetic */ void getHasNext$annotations() {
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final void ensureNextEntryIsReady() {
        if (this.path[this.pathLastIndex].hasNextKey() == false) goto L5;
        return;
    L5:
        int r100 = this.pathLastIndex;
    L7:
        if ((-1) >= r100) goto L19;
        int r101 = moveToNextNodeWithData(r100);
        if (r101 == (-1)) goto L11;
    L13:
        if (r101 != (-1)) goto L14;
        if (r100 <= 0) goto L18;
        this.path[r100 - 1].moveToNextNode();
    L18:
        this.path[r100].reset(TrieNode.Companion.getEMPTY$runtime().getBuffer$runtime(), 0);
        r100 = r100 - 1;
        goto L7
    L14:
        this.pathLastIndex = r101;
        return;
    L11:
        if (this.path[r100].hasNextNode() == false) goto L13;
        this.path[r100].moveToNextNode();
        r101 = moveToNextNodeWithData(r100);
        goto L13
    L19:
        this.hasNext = false;
    }

    private final void checkHasNext() {
        if (hasNext() == false) goto L6;
        return;
    L6:
        throw new NoSuchElementException();
    }

    public final K currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    @Override // java.util.Iterator
    public T next() {
        checkHasNext();
        T r100 = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return r100;
    }

    public final TrieNodeBaseIterator<K, V, T>[] getPath() {
        return this.path;
    }

    public final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    private final int moveToNextNodeWithData(int r100) {
        if (this.path[r100].hasNextKey() == false) goto L6;
        return r100;
    L6:
        if (this.path[r100].hasNextNode() == false) goto L13;
        TrieNode<? extends K, ? extends V> r101 = this.path[r100].currentNode();
        if (r100 != 6) goto L10;
        this.path[r100 + 1].reset(r101.getBuffer$runtime(), r101.getBuffer$runtime().length);
    L12:
        return moveToNextNodeWithData(r100 + 1);
    L10:
        this.path[r100 + 1].reset(r101.getBuffer$runtime(), r101.entryCount$runtime() * 2);
        goto L12
    L13:
        return -1;
    }

    public final void setPathLastIndex(int r100) {
        this.pathLastIndex = r100;
    }

    public PersistentHashMapBaseIterator(TrieNode<K, V> r100, TrieNodeBaseIterator<K, V, T>[] r101) {
        this.path = r101;
        this.hasNext = true;
        r101[0].reset(r100.getBuffer$runtime(), r100.entryCount$runtime() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }
}
