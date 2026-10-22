package f0;

import Z8.AbstractC1161i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h0.DeltaCounter;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010&\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u001f8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00018\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010@\u001a\u0002062\u0006\u0010\u0011\u001a\u0002068\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b7\u0010:\"\u0004\b?\u0010<R&\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B0A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lf0/f;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "LZ8/i;", "Lf0/d;", C3081a.FOCUS_MAP_NAME, "<init>", "(Lf0/d;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lf0/d;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", UxipConstants.f30680s, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "LY8/t;", "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "()V", Const.INTENT_KEY_APIKEY, "Lf0/d;", "Lh0/e;", Const.INTENT_KEY_PKGNAME, "Lh0/e;", "m", "()Lh0/e;", "setOwnership", "(Lh0/e;)V", "ownership", "Lf0/t;", "c", "Lf0/t;", "l", "()Lf0/t;", "setNode$runtime", "(Lf0/t;)V", "node", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "getOperationResult$runtime", "()Ljava/lang/Object;", "o", "(Ljava/lang/Object;)V", "operationResult", "", "e", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()I", "n", "(I)V", "modCount", "f", "p", ContentDisposition.Parameters.Size, "", "", "()Ljava/util/Set;", "entries", "keys", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Collection;", "values", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class f<K, V> extends AbstractC1161i<K, V> implements Map, q9.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public d<K, V> map;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public h0.e ownership = new h0.e();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public t<K, V> node;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public V operationResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int modCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int size;

    public f(d<K, V> dVar) {
        this.map = dVar;
        this.node = this.map.s();
        this.size = this.map.size();
    }

    @Override // Z8.AbstractC1161i
    public Set<Map.Entry<K, V>> b() {
        return new h(this);
    }

    @Override // Z8.AbstractC1161i
    public Set<K> c() {
        return new j(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        t<K, V> tVarA = t.INSTANCE.a();
        kotlin.jvm.internal.p.g(tVarA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = tVarA;
        p(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return this.node.k(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // Z8.AbstractC1161i
    /* renamed from: e, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // Z8.AbstractC1161i
    public Collection<V> g() {
        return new l(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        return this.node.o(key != null ? key.hashCode() : 0, key, 0);
    }

    public d<K, V> i() {
        d<K, V> dVar;
        if (this.node == this.map.s()) {
            dVar = this.map;
        } else {
            this.ownership = new h0.e();
            dVar = new d<>(this.node, size());
        }
        this.map = dVar;
        return dVar;
    }

    /* renamed from: j, reason: from getter */
    public final int getModCount() {
        return this.modCount;
    }

    public final t<K, V> l() {
        return this.node;
    }

    /* renamed from: m, reason: from getter */
    public final h0.e getOwnership() {
        return this.ownership;
    }

    public final void n(int i10) {
        this.modCount = i10;
    }

    public final void o(V v10) {
        this.operationResult = v10;
    }

    public void p(int i10) {
        this.size = i10;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        this.operationResult = null;
        this.node = this.node.D(key != null ? key.hashCode() : 0, key, value, 0, this);
        return this.operationResult;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        d<K, V> dVarI = from instanceof d ? (d) from : null;
        if (dVarI == null) {
            f fVar = from instanceof f ? (f) from : null;
            dVarI = fVar != null ? fVar.i() : null;
        }
        if (dVarI == null) {
            super.putAll(from);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        t<K, V> tVar = this.node;
        t<K, V> tVarS = dVarI.s();
        kotlin.jvm.internal.p.g(tVarS, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = tVar.E(tVarS, 0, deltaCounter, this);
        int size2 = (dVarI.size() + size) - deltaCounter.getCount();
        if (size != size2) {
            p(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        this.operationResult = null;
        t tVarG = this.node.G(key != null ? key.hashCode() : 0, key, 0, this);
        if (tVarG == null) {
            tVarG = t.INSTANCE.a();
            kotlin.jvm.internal.p.g(tVarG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = tVarG;
        return this.operationResult;
    }

    @Override // java.util.Map
    public final boolean remove(Object key, Object value) {
        int size = size();
        t tVarH = this.node.H(key != null ? key.hashCode() : 0, key, value, 0, this);
        if (tVarH == null) {
            tVarH = t.INSTANCE.a();
            kotlin.jvm.internal.p.g(tVarH, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = tVarH;
        return size != size();
    }
}
