package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00106J\u001f\u00107\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001e\u00109\u001a\u00020:2\u0014\u0010;\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<H\u0016J\u0017\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J\u001b\u0010=\u001a\u0002022\u0006\u00103\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020:H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00018\u0001X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R&\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(0'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006@"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "value", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnership", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "getOperationResult$runtime", "()Ljava/lang/Object;", "setOperationResult$runtime", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "modCount", "", "getModCount$runtime", "()I", "setModCount$runtime", "(I)V", "size", "getSize", "setSize", "build", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "", "from", "", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    public static final int $stable = 8;
    private PersistentHashMap<K, V> map;
    private int modCount;
    private TrieNode<K, V> node;
    private V operationResult;
    private MutabilityOwnership ownership;
    private int size;

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public PersistentHashMap<K, V> build() {
        if (this.node != this.map.getNode$runtime()) goto L5;
        PersistentHashMap<K, V> r100 = this.map;
    L6:
        this.map = r100;
        return r100;
    L5:
        this.ownership = new MutabilityOwnership();
        r100 = new PersistentHashMap(this.node, size());
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        TrieNode<K, V> r100 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = r100;
        setSize(0);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection<V> getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    public final TrieNode<K, V> getNode$runtime() {
        return this.node;
    }

    public final V getOperationResult$runtime() {
        return this.operationResult;
    }

    public final MutabilityOwnership getOwnership() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public /* bridge */ /* synthetic */ PersistentMap build() {
        return build();
    }

    public PersistentHashMapBuilder(PersistentHashMap<K, V> r100) {
        this.map = r100;
        this.ownership = new MutabilityOwnership();
        this.node = this.map.getNode$runtime();
        this.size = this.map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        TrieNode<K, V> r101 = this.node;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L7:
        return r101.containsKey(r102, r100, 0);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        TrieNode<K, V> r101 = this.node;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L7:
        return r101.get(r102, r100, 0);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        if ((r100 instanceof PersistentHashMap) == false) goto L5;
        PersistentHashMap<K, V> r101 = (PersistentHashMap) r100;
    L6:
        if (r101 == null) goto L8;
    L14:
        if (r101 == null) goto L18;
        DeltaCounter r102 = new DeltaCounter(0, 1, null);
        int r103 = size();
        TrieNode<K, V> r104 = this.node;
        TrieNode<K, V> r105 = r101.getNode$runtime();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = r104.mutablePutAll(r105, 0, r102, this);
        int r106 = (r101.size() + r103) - r102.getCount();
        if (r103 == r106) goto L20;
        setSize(r106);
        return;
    L20:
        return;
    L18:
        super.putAll(r100);
        return;
    L8:
        if ((r100 instanceof PersistentHashMapBuilder) == false) goto L10;
        PersistentHashMapBuilder r107 = (PersistentHashMapBuilder) r100;
    L11:
        if (r107 == null) goto L13;
        r101 = r107.build();
        goto L14
    L13:
        r101 = null;
        goto L14
    L10:
        r107 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        this.operationResult = null;
        TrieNode<K, V> r101 = this.node;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        TrieNode r103 = r101.mutableRemove(r102, r100, 0, this);
        if (r103 != null) goto L9;
        r103 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
    L9:
        this.node = r103;
        return this.operationResult;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setModCount$runtime(int r100) {
        this.modCount = r100;
    }

    public final void setNode$runtime(TrieNode<K, V> r100) {
        this.node = r100;
    }

    public final void setOperationResult$runtime(V r100) {
        this.operationResult = r100;
    }

    public final void setOwnership(MutabilityOwnership r100) {
        this.ownership = r100;
    }

    public void setSize(int r100) {
        this.size = r100;
        this.modCount++;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        this.operationResult = null;
        TrieNode<K, V> r102 = this.node;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        this.node = r102.mutablePut(r103, r100, r101, 0, this);
        return this.operationResult;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r110) {
        int r101 = size();
        TrieNode<K, V> r102 = this.node;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        TrieNode r104 = r102.mutableRemove(r103, r100, r110, 0, this);
        if (r104 != null) goto L9;
        r104 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
    L9:
        this.node = r104;
        if (r101 == size()) goto L13;
        return true;
    L13:
        return false;
    L5:
        r103 = 0;
        goto L6
    }
}
