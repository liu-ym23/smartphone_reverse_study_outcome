package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010 \u001a\u00020!H\u0016J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;)V", "firstElement", "", "getFirstElement$runtime", "()Ljava/lang/Object;", "setFirstElement$runtime", "(Ljava/lang/Object;)V", "lastElement", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "getHashMapBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "size", "", "getSize", "()I", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "remove", "clear", "", "iterator", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentOrderedSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    public static final int $stable = 8;
    private Object firstElement;
    private final PersistentHashMapBuilder<E, Links> hashMapBuilder;
    private Object lastElement;
    private PersistentOrderedSet<E> set;

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentSet<E> build() {
        PersistentHashMap<E, Links> r100 = this.hashMapBuilder.build();
        if (r100 != this.set.getHashMap$runtime()) goto L13;
        boolean r101 = true;
        if (this.firstElement != this.set.getFirstElement$runtime()) goto L7;
        boolean r102 = true;
    L8:
        CommonFunctionsKt.m4281assert(r102);
        if (this.lastElement == this.set.getLastElement$runtime()) goto L12;
        r101 = false;
    L12:
        CommonFunctionsKt.m4281assert(r101);
        PersistentOrderedSet<E> r103 = this.set;
    L14:
        this.set = r103;
        return r103;
    L7:
        r102 = false;
        goto L8
    L13:
        r103 = new PersistentOrderedSet(this.firstElement, this.lastElement, r100);
        goto L14
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain r100 = EndOfChain.INSTANCE;
        this.firstElement = r100;
        this.lastElement = r100;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    public final Object getFirstElement$runtime() {
        return this.firstElement;
    }

    public final PersistentHashMapBuilder<E, Links> getHashMapBuilder$runtime() {
        return this.hashMapBuilder;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentCollection build() {
        return build();
    }

    public PersistentOrderedSetBuilder(PersistentOrderedSet<E> r100) {
        this.set = r100;
        this.firstElement = r100.getFirstElement$runtime();
        this.lastElement = this.set.getLastElement$runtime();
        this.hashMapBuilder = this.set.getHashMap$runtime().builder();
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r100) {
        if (this.hashMapBuilder.containsKey(r100) == false) goto L7;
        return false;
    L7:
        if (isEmpty() == false) goto L10;
        this.firstElement = r100;
        this.lastElement = r100;
        this.hashMapBuilder.put(r100, new Links());
        return true;
    L10:
        Links r101 = this.hashMapBuilder.get(this.lastElement);
        Intrinsics.checkNotNull(r101);
        PersistentHashMapBuilder<E, Links> r102 = this.hashMapBuilder;
        Object r103 = this.lastElement;
        E r104 = (E) r103;
        r102.put(r104, r101.withNext(r100));
        this.hashMapBuilder.put(r100, new Links(this.lastElement));
        this.lastElement = r100;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r100) {
        return this.hashMapBuilder.containsKey(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r100) {
        Links r101 = this.hashMapBuilder.remove(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getHasPrevious() == false) goto L9;
        Links r102 = this.hashMapBuilder.get(r101.getPrevious());
        Intrinsics.checkNotNull(r102);
        PersistentHashMapBuilder<E, Links> r103 = this.hashMapBuilder;
        Object r104 = r101.getPrevious();
        E r105 = (E) r104;
        r103.put(r105, r102.withNext(r101.getNext()));
    L11:
        if (r101.getHasNext() == false) goto L13;
        Links r106 = this.hashMapBuilder.get(r101.getNext());
        Intrinsics.checkNotNull(r106);
        PersistentHashMapBuilder<E, Links> r107 = this.hashMapBuilder;
        Object r108 = r101.getNext();
        E r109 = (E) r108;
        r107.put(r109, r106.withPrevious(r101.getPrevious()));
        return true;
    L13:
        this.lastElement = r101.getPrevious();
        return true;
    L9:
        this.firstElement = r101.getNext();
        goto L11
    }

    public final void setFirstElement$runtime(Object r100) {
        this.firstElement = r100;
    }
}
