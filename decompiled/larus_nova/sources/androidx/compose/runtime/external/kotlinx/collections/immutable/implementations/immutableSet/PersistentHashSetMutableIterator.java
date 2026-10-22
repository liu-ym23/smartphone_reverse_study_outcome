package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u000b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetMutableIterator;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)V", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "resetPath", "hashCode", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "element", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;Ljava/lang/Object;I)V", "isCollision", "checkNextWasInvoked", "checkForComodification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> implements KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashSetBuilder<E> builder;
    private int expectedModCount;
    private E lastIteratedElement;
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

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public E next() {
        checkForComodification();
        E r100 = (E) super.next();
        this.lastIteratedElement = r100;
        this.nextWasInvoked = true;
        return r100;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext() == false) goto L9;
        E r100 = currentElement();
        PersistentHashSetBuilder<E> r101 = this.builder;
        E r102 = this.lastIteratedElement;
        TypeIntrinsics.asMutableCollection(r101).remove(r102);
        if (r100 == null) goto L7;
        int r103 = r100.hashCode();
    L8:
        resetPath(r103, this.builder.getNode$runtime(), r100, 0);
    L10:
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime();
        return;
    L7:
        r103 = 0;
        goto L8
    L9:
        PersistentHashSetBuilder<E> r104 = this.builder;
        E r105 = this.lastIteratedElement;
        TypeIntrinsics.asMutableCollection(r104).remove(r105);
        goto L10
    }

    public PersistentHashSetMutableIterator(PersistentHashSetBuilder<E> r100) {
        super(r100.getNode$runtime());
        this.builder = r100;
        this.expectedModCount = r100.getModCount$runtime();
    }

    private final boolean isCollision(TrieNode<?> r100) {
        if (r100.getBitmap() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void resetPath(int r100, TrieNode<?> r101, E r102, int r103) {
        boolean r104 = true;
        if (isCollision(r101) == false) goto L10;
        int r105 = ArraysKt.indexOf(r101.getBuffer(), r102);
        if (r105 != (-1)) goto L8;
        r104 = false;
    L8:
        CommonFunctionsKt.m4281assert(r104);
        ((TrieNodeIterator) ListProtector.get(getPath(), r103)).reset(r101.getBuffer(), r105);
        setPathLastIndex(r103);
        return;
    L10:
        int r106 = r101.indexOfCellAt$runtime(1 << TrieNodeKt.indexSegment(r100, r103 * 5));
        ((TrieNodeIterator) ListProtector.get(getPath(), r103)).reset(r101.getBuffer(), r106);
        Object r107 = r101.getBuffer()[r106];
        if ((r107 instanceof TrieNode) == false) goto L13;
        resetPath(r100, (TrieNode) r107, r102, r103 + 1);
        return;
    L13:
        setPathLastIndex(r103);
    }
}
