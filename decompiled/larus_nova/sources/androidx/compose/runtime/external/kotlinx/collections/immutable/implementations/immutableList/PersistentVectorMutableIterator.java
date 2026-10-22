package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0015\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorMutableIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "index", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;I)V", "expectedModCount", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "lastIteratedIndex", "previous", "()Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, BasicTestActionHandler.TEST_ACTION_RESET, "", "setupTrieIterator", "add", "element", "(Ljava/lang/Object;)V", "remove", "set", "checkForComodification", "checkHasIterated", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentVectorMutableIterator<T> extends AbstractListIterator<T> implements KMutableListIterator {
    public static final int $stable = 8;
    private final PersistentVectorBuilder<T> builder;
    private int expectedModCount;
    private int lastIteratedIndex;
    private TrieIterator<? extends T> trieIterator;

    private final void checkForComodification() {
        if (this.expectedModCount != this.builder.getModCount$runtime()) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    private final void checkHasIterated() {
        if (this.lastIteratedIndex == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    private final void reset() {
        setSize(this.builder.size());
        this.expectedModCount = this.builder.getModCount$runtime();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    private final void setupTrieIterator() {
        Object[] r100 = this.builder.getRoot$runtime();
        if (r100 != null) goto L6;
        this.trieIterator = null;
        return;
    L6:
        int r101 = UtilsKt.rootSize(this.builder.size());
        int r102 = RangesKt.coerceAtMost(getIndex(), r101);
        int r103 = (this.builder.getRootShift$runtime() / 5) + 1;
        TrieIterator<? extends T> r104 = this.trieIterator;
        if (r104 != null) goto L9;
        this.trieIterator = new TrieIterator(r100, r102, r101, r103);
        return;
    L9:
        Intrinsics.checkNotNull(r104);
        r104.reset$runtime(r100, r102, r101, r103);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public T next() {
        checkForComodification();
        checkHasNext$runtime();
        this.lastIteratedIndex = getIndex();
        TrieIterator<? extends T> r100 = this.trieIterator;
        if (r100 != null) goto L7;
        Object[] r101 = this.builder.getTail$runtime();
        int r102 = getIndex();
        setIndex(r102 + 1);
        return (T) r101[r102];
    L7:
        if (r100.hasNext() == false) goto L10;
        setIndex(getIndex() + 1);
        return r100.next();
    L10:
        Object[] r103 = this.builder.getTail$runtime();
        int r104 = getIndex();
        setIndex(r104 + 1);
        return (T) r103[r104 - r100.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        checkForComodification();
        checkHasPrevious$runtime();
        this.lastIteratedIndex = getIndex() - 1;
        TrieIterator<? extends T> r100 = this.trieIterator;
        if (r100 != null) goto L7;
        Object[] r101 = this.builder.getTail$runtime();
        setIndex(getIndex() - 1);
        return (T) r101[getIndex()];
    L7:
        if (getIndex() <= r100.getSize()) goto L10;
        Object[] r102 = this.builder.getTail$runtime();
        setIndex(getIndex() - 1);
        return (T) r102[getIndex() - r100.getSize()];
    L10:
        setIndex(getIndex() - 1);
        return r100.previous();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public void remove() {
        checkForComodification();
        checkHasIterated();
        this.builder.remove(this.lastIteratedIndex);
        if (this.lastIteratedIndex >= getIndex()) goto L5;
        setIndex(this.lastIteratedIndex);
    L5:
        reset();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void add(T r100) {
        checkForComodification();
        this.builder.add(getIndex(), r100);
        setIndex(getIndex() + 1);
        reset();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator
    public void set(T r100) {
        checkForComodification();
        checkHasIterated();
        this.builder.set(this.lastIteratedIndex, r100);
        this.expectedModCount = this.builder.getModCount$runtime();
        setupTrieIterator();
    }

    public PersistentVectorMutableIterator(PersistentVectorBuilder<T> r100, int r101) {
        super(r101, r100.size());
        this.builder = r100;
        this.expectedModCount = r100.getModCount$runtime();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }
}
