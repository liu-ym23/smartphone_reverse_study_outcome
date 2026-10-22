package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019H\u0016J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u001b\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0002\u0010.J\b\u0010/\u001a\u000200H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00061"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "value", "", "firstKey", "getFirstKey$runtime", "()Ljava/lang/Object;", "lastKey", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "getHashMapBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "size", "", "getSize", "()I", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    public static final int $stable = 8;
    private Object firstKey;
    private final PersistentHashMapBuilder<K, LinkedValue<V>> hashMapBuilder;
    private Object lastKey;
    private PersistentOrderedMap<K, V> map;

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public PersistentMap<K, V> build() {
        PersistentHashMap<K, LinkedValue<V>> r100 = this.hashMapBuilder.build();
        if (r100 != this.map.getHashMap$runtime()) goto L13;
        boolean r101 = true;
        if (this.firstKey != this.map.getFirstKey$runtime()) goto L7;
        boolean r102 = true;
    L8:
        CommonFunctionsKt.m4281assert(r102);
        if (this.lastKey == this.map.getLastKey$runtime()) goto L12;
        r101 = false;
    L12:
        CommonFunctionsKt.m4281assert(r101);
        PersistentOrderedMap<K, V> r103 = this.map;
    L14:
        this.map = r103;
        return r103;
    L7:
        r102 = false;
        goto L8
    L13:
        r103 = new PersistentOrderedMap(this.firstKey, this.lastKey, r100);
        goto L14
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain r100 = EndOfChain.INSTANCE;
        this.firstKey = r100;
        this.lastKey = r100;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection<V> getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    public final Object getFirstKey$runtime() {
        return this.firstKey;
    }

    public final PersistentHashMapBuilder<K, LinkedValue<V>> getHashMapBuilder$runtime() {
        return this.hashMapBuilder;
    }

    public PersistentOrderedMapBuilder(PersistentOrderedMap<K, V> r100) {
        this.map = r100;
        this.firstKey = r100.getFirstKey$runtime();
        this.lastKey = this.map.getLastKey$runtime();
        this.hashMapBuilder = this.map.getHashMap$runtime().builder();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        return this.hashMapBuilder.containsKey(r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        LinkedValue<V> r101 = this.hashMapBuilder.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        LinkedValue<V> r101 = this.hashMapBuilder.remove(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.getHasPrevious() == false) goto L9;
        LinkedValue<V> r102 = this.hashMapBuilder.get(r101.getPrevious());
        Intrinsics.checkNotNull(r102);
        PersistentHashMapBuilder<K, LinkedValue<V>> r103 = this.hashMapBuilder;
        Object r104 = r101.getPrevious();
        K r105 = (K) r104;
        r103.put(r105, r102.withNext(r101.getNext()));
    L11:
        if (r101.getHasNext() == false) goto L13;
        LinkedValue<V> r106 = this.hashMapBuilder.get(r101.getNext());
        Intrinsics.checkNotNull(r106);
        PersistentHashMapBuilder<K, LinkedValue<V>> r107 = this.hashMapBuilder;
        Object r108 = r101.getNext();
        K r109 = (K) r108;
        r107.put(r109, r106.withPrevious(r101.getPrevious()));
    L15:
        return r101.getValue();
    L13:
        this.lastKey = r101.getPrevious();
        goto L15
    L9:
        this.firstKey = r101.getNext();
        goto L11
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        LinkedValue<V> r102 = this.hashMapBuilder.get(r100);
        if (r102 == null) goto L10;
        if (r102.getValue() != r101) goto L7;
        return r101;
    L7:
        this.hashMapBuilder.put(r100, r102.withValue(r101));
        return r102.getValue();
    L10:
        if (isEmpty() == false) goto L13;
        this.firstKey = r100;
        this.lastKey = r100;
        this.hashMapBuilder.put(r100, new LinkedValue(r101));
        return null;
    L13:
        Object r103 = this.lastKey;
        LinkedValue<V> r104 = this.hashMapBuilder.get(r103);
        Intrinsics.checkNotNull(r104);
        LinkedValue<V> r105 = r104;
        CommonFunctionsKt.m4281assert(!r105.getHasNext());
        this.hashMapBuilder.put((K) r103, r105.withNext(r100));
        this.hashMapBuilder.put(r100, new LinkedValue(r101, r103));
        this.lastKey = r100;
        return null;
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r101) {
        LinkedValue<V> r102 = this.hashMapBuilder.get(r100);
        if (r102 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r102.getValue(), r101) == false) goto L10;
        remove(r100);
        return true;
    L10:
        return false;
    }
}
