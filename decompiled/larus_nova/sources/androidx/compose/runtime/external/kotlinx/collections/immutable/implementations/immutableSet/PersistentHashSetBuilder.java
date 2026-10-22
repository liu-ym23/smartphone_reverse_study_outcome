package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010\"\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010#\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010$\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0015\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010&\u001a\u00020'H\u0016J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "value", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "modCount", "getModCount$runtime", "()I", "size", "getSize", "setSize", "(I)V", "build", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "addAll", SlcElement.KEY_ELEMENTS, "", "retainAll", "removeAll", "containsAll", "remove", "clear", "", "iterator", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    public static final int $stable = 8;
    private int modCount;
    private TrieNode<E> node;
    private MutabilityOwnership ownership;
    private PersistentHashSet<E> set;
    private int size;

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentHashSet<E> build() {
        if (this.node != this.set.getNode$runtime()) goto L5;
        PersistentHashSet<E> r100 = this.set;
    L6:
        this.set = r100;
        return r100;
    L5:
        this.ownership = new MutabilityOwnership();
        r100 = new PersistentHashSet(this.node, size());
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        TrieNode<E> r100 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = r100;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    public final TrieNode<E> getNode$runtime() {
        return this.node;
    }

    public final MutabilityOwnership getOwnership$runtime() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentCollection build() {
        return build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentSet build() {
        return build();
    }

    public PersistentHashSetBuilder(PersistentHashSet<E> r100) {
        this.set = r100;
        this.ownership = new MutabilityOwnership();
        this.node = this.set.getNode$runtime();
        this.size = this.set.size();
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r100) {
        int r101 = size();
        TrieNode<E> r102 = this.node;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        this.node = r102.mutableAdd(r103, r100, 0, this);
        if (r101 == size()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r100) {
        if ((r100 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r101 = (PersistentHashSet) r100;
    L6:
        if (r101 == null) goto L8;
    L14:
        if (r101 == null) goto L23;
        DeltaCounter r102 = new DeltaCounter(0, 1, null);
        int r103 = size();
        TrieNode<E> r104 = this.node.mutableAddAll(r101.getNode$runtime(), 0, r102, this);
        int r105 = (r100.size() + r103) - r102.getCount();
        if (r103 == r105) goto L19;
        this.node = r104;
        setSize(r105);
    L19:
        if (r103 == size()) goto L24;
        return true;
    L24:
        return false;
    L23:
        return super.addAll(r100);
    L8:
        if ((r100 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r106 = (PersistentHashSetBuilder) r100;
    L11:
        if (r106 == null) goto L13;
        r101 = r106.build();
        goto L14
    L13:
        r101 = null;
        goto L14
    L10:
        r106 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r100) {
        TrieNode<E> r101 = this.node;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L7:
        return r101.contains(r102, r100, 0);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r100) {
        if ((r100 instanceof PersistentHashSet) == false) goto L7;
        return this.node.containsAll(((PersistentHashSet) r100).getNode$runtime(), 0);
    L7:
        if ((r100 instanceof PersistentHashSetBuilder) == false) goto L11;
        return this.node.containsAll(((PersistentHashSetBuilder) r100).node, 0);
    L11:
        return super.containsAll(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r100) {
        int r101 = size();
        TrieNode<E> r102 = this.node;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        this.node = r102.mutableRemove(r103, r100, 0, this);
        if (r101 == size()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> r100) {
        if ((r100 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r101 = (PersistentHashSet) r100;
    L6:
        if (r101 == null) goto L8;
    L14:
        if (r101 == null) goto L25;
        DeltaCounter r102 = new DeltaCounter(0, 1, null);
        int r103 = size();
        Object r104 = this.node.mutableRemoveAll(r101.getNode$runtime(), 0, r102, this);
        int r105 = r103 - r102.getCount();
        if (r105 != 0) goto L18;
        clear();
    L21:
        if (r103 == size()) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r105 == r103) goto L21;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = (TrieNode) r104;
        setSize(r105);
        goto L21
    L25:
        return super.removeAll(r100);
    L8:
        if ((r100 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r106 = (PersistentHashSetBuilder) r100;
    L11:
        if (r106 == null) goto L13;
        r101 = r106.build();
        goto L14
    L13:
        r101 = null;
        goto L14
    L10:
        r106 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> r100) {
        if ((r100 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r101 = (PersistentHashSet) r100;
    L6:
        if (r101 == null) goto L8;
    L14:
        if (r101 == null) goto L25;
        DeltaCounter r102 = new DeltaCounter(0, 1, null);
        int r103 = size();
        Object r104 = this.node.mutableRetainAll(r101.getNode$runtime(), 0, r102, this);
        int r105 = r102.getCount();
        if (r105 != 0) goto L18;
        clear();
    L21:
        if (r103 == size()) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r105 == r103) goto L21;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = (TrieNode) r104;
        setSize(r105);
        goto L21
    L25:
        return super.retainAll(r100);
    L8:
        if ((r100 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r106 = (PersistentHashSetBuilder) r100;
    L11:
        if (r106 == null) goto L13;
        r101 = r106.build();
        goto L14
    L13:
        r101 = null;
        goto L14
    L10:
        r106 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public void setSize(int r100) {
        this.size = r100;
        this.modCount++;
    }
}
