package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ5\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", "V", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "setValue", "key", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "checkNextWasInvoked", "checkForComodification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;
    private K lastIteratedKey;
    private boolean nextWasInvoked;

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime() != this.expectedModCount) goto L6;
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

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public T next() {
        checkForComodification();
        this.lastIteratedKey = currentKey();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext() == false) goto L9;
        K r100 = currentKey();
        PersistentHashMapBuilder<K, V> r101 = this.builder;
        K r102 = this.lastIteratedKey;
        TypeIntrinsics.asMutableMap(r101).remove(r102);
        if (r100 == null) goto L7;
        int r103 = r100.hashCode();
    L8:
        resetPath(r103, this.builder.getNode$runtime(), r100, 0);
    L10:
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime();
        return;
    L7:
        r103 = 0;
        goto L8
    L9:
        PersistentHashMapBuilder<K, V> r104 = this.builder;
        K r105 = this.lastIteratedKey;
        TypeIntrinsics.asMutableMap(r104).remove(r105);
        goto L10
    }

    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder<K, V> r100, TrieNodeBaseIterator<K, V, T>[] r101) {
        super(r100.getNode$runtime(), r101);
        this.builder = r100;
        this.expectedModCount = r100.getModCount$runtime();
    }

    public final void setValue(K r100, V r101) {
        if (this.builder.containsKey(r100) == true) goto L6;
        return;
    L6:
        if (hasNext() == false) goto L12;
        K r102 = currentKey();
        this.builder.put(r100, r101);
        if (r102 == null) goto L10;
        int r103 = r102.hashCode();
    L11:
        resetPath(r103, this.builder.getNode$runtime(), r102, 0);
    L13:
        this.expectedModCount = this.builder.getModCount$runtime();
        return;
    L10:
        r103 = 0;
        goto L11
    L12:
        this.builder.put(r100, r101);
        goto L13
    }

    private final void resetPath(int r100, TrieNode<?, ?> r101, K r102, int r103) {
        int r104 = r103 * 5;
        if (r104 <= 30) goto L10;
        getPath()[r103].reset(r101.getBuffer$runtime(), r101.getBuffer$runtime().length, 0);
    L6:
        if (Intrinsics.areEqual(getPath()[r103].currentKey(), r102) == true) goto L8;
        getPath()[r103].moveToNextKey();
        goto L6
    L8:
        setPathLastIndex(r103);
        return;
    L10:
        int r105 = 1 << TrieNodeKt.indexSegment(r100, r104);
        if (r101.hasEntryAt$runtime(r105) == false) goto L14;
        int r106 = r101.entryKeyIndex$runtime(r105);
        getPath()[r103].reset(r101.getBuffer$runtime(), r101.entryCount$runtime() * 2, r106);
        setPathLastIndex(r103);
        return;
    L14:
        int r107 = r101.nodeIndex$runtime(r105);
        TrieNode<?, ?> r108 = r101.nodeAtIndex$runtime(r107);
        getPath()[r103].reset(r101.getBuffer$runtime(), r101.entryCount$runtime() * 2, r107);
        resetPath(r100, r108, r102, r103 + 1);
    }
}
