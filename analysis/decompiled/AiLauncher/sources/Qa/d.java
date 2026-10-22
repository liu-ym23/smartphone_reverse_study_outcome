package Qa;

import Pa.d;
import Qa.t;
import Z8.AbstractC1158f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 6*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u00017B#\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010\u001b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0002¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J!\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0&H\u0002¢\u0006\u0004\b'\u0010(R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010%R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010(R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"LQa/d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LZ8/f;", "LPa/d;", "LQa/t;", "node", "", ContentDisposition.Parameters.Size, "<init>", "(LQa/t;I)V", "", "", "e", "()Ljava/util/Set;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", UxipConstants.f30680s, "u", "(Ljava/lang/Object;Ljava/lang/Object;)LQa/d;", "v", "(Ljava/lang/Object;)LQa/d;", "", "m", "putAll", "(Ljava/util/Map;)LPa/d;", "LQa/f;", "p", "()LQa/f;", "", "other", "equals", "hashCode", "()I", "LPa/c;", "q", "()LPa/c;", Const.INTENT_KEY_PKGNAME, "LQa/t;", "s", "()LQa/t;", "c", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "r", "keys", "LPa/b;", "t", "()LPa/b;", "values", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d<K, V> extends AbstractC1158f<K, V> implements Pa.d<K, V> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final d f5473e = new d(t.INSTANCE.a(), 0);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final t<K, V> node;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int size;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LQa/d$a;", "", "<init>", "()V", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LQa/d;", Const.INTENT_KEY_APIKEY, "()LQa/d;", "", "EMPTY", "LQa/d;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Qa.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final <K, V> d<K, V> a() {
            d<K, V> dVar = d.f5473e;
            kotlin.jvm.internal.p.g(dVar, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return dVar;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5476a = new b();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5477a = new c();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Qa.d$d, reason: collision with other inner class name */
    public static final class C0095d implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0095d f5478a = new C0095d();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Object obj) {
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, obj));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class e implements p9.p<V, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f5479a = new e();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(V v10, Object obj) {
            return Boolean.valueOf(kotlin.jvm.internal.p.d(v10, obj));
        }
    }

    public d(t<K, V> node, int i10) {
        kotlin.jvm.internal.p.i(node, "node");
        this.node = node;
        this.size = i10;
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.node.l(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // Z8.AbstractC1158f
    public final Set<Map.Entry<K, V>> e() {
        return q();
    }

    @Override // Z8.AbstractC1158f, java.util.Map
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Map)) {
            return false;
        }
        Map map = (Map) other;
        if (size() != map.size()) {
            return false;
        }
        return map instanceof Ra.c ? this.node.p(((Ra.c) other).r().node, b.f5476a) : map instanceof Ra.d ? this.node.p(((Ra.d) other).j().m(), c.f5477a) : map instanceof d ? this.node.p(((d) other).node, C0095d.f5478a) : map instanceof f ? this.node.p(((f) other).m(), e.f5479a) : super.equals(other);
    }

    @Override // java.util.Map
    public V get(Object key) {
        return this.node.q(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // Z8.AbstractC1158f, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: i, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // Pa.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f<K, V> builder() {
        return new f<>(this);
    }

    @Override // java.util.Map, Pa.d
    public Pa.d<K, V> putAll(Map<? extends K, ? extends V> m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.isEmpty()) {
            return this;
        }
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type kotlinx.collections.immutable.PersistentMap<K of kotlinx.collections.immutable.ExtensionsKt.mutate, V of kotlinx.collections.immutable.ExtensionsKt.mutate>");
        d.a<K, V> aVarBuilder = builder();
        aVarBuilder.putAll(m10);
        return aVarBuilder.build();
    }

    public final Pa.c<Map.Entry<K, V>> q() {
        return new n(this);
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Pa.c<K> g() {
        return new p(this);
    }

    public final t<K, V> s() {
        return this.node;
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Pa.b<V> j() {
        return new r(this);
    }

    @Override // Z8.AbstractC1158f, java.util.Map, Pa.d
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public d<K, V> put(K key, V value) {
        t.b<K, V> bVarQ = this.node.Q(key != null ? key.hashCode() : 0, key, value, 0);
        return bVarQ == null ? this : new d<>(bVarQ.a(), size() + bVarQ.getSizeDelta());
    }

    @Override // Z8.AbstractC1158f, java.util.Map, Pa.d
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public d<K, V> remove(K key) {
        t<K, V> tVarR = this.node.R(key != null ? key.hashCode() : 0, key, 0);
        return this.node == tVarR ? this : tVarR == null ? INSTANCE.a() : new d<>(tVarR, size() - 1);
    }
}
