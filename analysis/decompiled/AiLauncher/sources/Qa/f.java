package Qa;

import Pa.d;
import Ta.DeltaCounter;
import Z8.AbstractC1161i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R@\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00058\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR$\u0010,\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020'8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+RB\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u00018\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010A\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010@R*\u0010D\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020 8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\b<\u0010\"\"\u0004\bC\u0010@R&\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010F0E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010GR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00010J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006N"}, d2 = {"LQa/f;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LPa/d$a;", "LZ8/i;", "LQa/d;", C3081a.FOCUS_MAP_NAME, "<init>", "(LQa/d;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LQa/d;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", UxipConstants.f30680s, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "LY8/t;", "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "()V", "", "other", "equals", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "LQa/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "builtMap", "LTa/e;", Const.INTENT_KEY_PKGNAME, "LTa/e;", "n", "()LTa/e;", "ownership", "LQa/t;", "c", "LQa/t;", "m", "()LQa/t;", "p", "(LQa/t;)V", "node", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "getOperationResult$kotlinx_collections_immutable", "()Ljava/lang/Object;", "q", "(Ljava/lang/Object;)V", "operationResult", "e", "I", "l", "o", "(I)V", "modCount", "f", "r", ContentDisposition.Parameters.Size, "", "", "()Ljava/util/Set;", "entries", "keys", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Collection;", "values", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f<K, V> extends AbstractC1161i<K, V> implements d.a<K, V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Qa.d<K, V> builtMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Ta.e ownership;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public t<K, V> node;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public V operationResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int modCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int size;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5489a = new a();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Object obj) {
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, obj));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5490a = new b();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Object obj) {
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, obj));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5491a = new c();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class d implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5492a = new d();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, b10.e()));
        }
    }

    public f(Qa.d<K, V> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.builtMap = map;
        this.ownership = new Ta.e();
        this.node = map.s();
        this.size = map.size();
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
        t tVarA = t.INSTANCE.a();
        kotlin.jvm.internal.p.g(tVarA, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        p(tVarA);
        r(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return this.node.l(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // Z8.AbstractC1161i
    /* renamed from: e, reason: from getter */
    public int getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Map)) {
            return false;
        }
        Map<?, ?> map = (Map) other;
        if (size() != map.size()) {
            return false;
        }
        return map instanceof Qa.d ? this.node.p(((Qa.d) other).s(), a.f5489a) : map instanceof f ? this.node.p(((f) other).node, b.f5490a) : map instanceof Ra.c ? this.node.p(((Ra.c) other).r().s(), c.f5491a) : map instanceof Ra.d ? this.node.p(((Ra.d) other).j().node, d.f5492a) : Ta.d.f5920a.b(this, map);
    }

    @Override // Z8.AbstractC1161i
    public Collection<V> g() {
        return new l(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        return this.node.q(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return Ta.d.f5920a.c(this);
    }

    @Override // Pa.d.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Qa.d<K, V> build() {
        Qa.d<K, V> dVar = this.builtMap;
        if (dVar != null) {
            return dVar;
        }
        Qa.d<K, V> dVar2 = new Qa.d<>(this.node, size());
        this.builtMap = dVar2;
        this.ownership = new Ta.e();
        return dVar2;
    }

    public final Qa.d<K, V> j() {
        return this.builtMap;
    }

    /* renamed from: l, reason: from getter */
    public final int getModCount() {
        return this.modCount;
    }

    public final t<K, V> m() {
        return this.node;
    }

    /* renamed from: n, reason: from getter */
    public final Ta.e getOwnership() {
        return this.ownership;
    }

    public final void o(int i10) {
        this.modCount = i10;
    }

    public final void p(t<K, V> value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (value != this.node) {
            this.node = value;
            this.builtMap = null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        this.operationResult = null;
        p(this.node.F(key != null ? key.hashCode() : 0, key, value, 0, this));
        return this.operationResult;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.p.i(from, "from");
        if (from.isEmpty()) {
            return;
        }
        Qa.d<K, V> dVarBuild = from instanceof Qa.d ? (Qa.d) from : null;
        if (dVarBuild == null) {
            f fVar = from instanceof f ? (f) from : null;
            dVarBuild = fVar != null ? fVar.build() : null;
        }
        if (dVarBuild == null) {
            super.putAll(from);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        t<K, V> tVar = this.node;
        t<K, V> tVarS = dVarBuild.s();
        kotlin.jvm.internal.p.g(tVarS, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        p(tVar.G(tVarS, 0, deltaCounter, this));
        int size2 = (dVarBuild.size() + size) - deltaCounter.getCount();
        if (size != size2) {
            r(size2);
        }
    }

    public final void q(V v10) {
        this.operationResult = v10;
    }

    public void r(int i10) {
        this.size = i10;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        this.operationResult = null;
        t tVarI = this.node.I(key != null ? key.hashCode() : 0, key, 0, this);
        if (tVarI == null) {
            tVarI = t.INSTANCE.a();
            kotlin.jvm.internal.p.g(tVarI, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        p(tVarI);
        return this.operationResult;
    }

    @Override // java.util.Map
    public final boolean remove(Object key, Object value) {
        int size = size();
        t tVarJ = this.node.J(key != null ? key.hashCode() : 0, key, value, 0, this);
        if (tVarJ == null) {
            tVarJ = t.INSTANCE.a();
            kotlin.jvm.internal.p.g(tVarJ, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        p(tVarJ);
        return size != size();
    }
}
