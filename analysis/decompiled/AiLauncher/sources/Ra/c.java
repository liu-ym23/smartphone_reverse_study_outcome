package Ra;

import Pa.d;
import Z8.AbstractC1158f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001=B5\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010 \u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b'\u0010\u0017J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0010R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00028\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"LRa/c;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LZ8/f;", "LPa/d;", "", "firstKey", "lastKey", "LQa/d;", "LRa/a;", "hashMap", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;LQa/d;)V", "LPa/c;", "", "p", "()LPa/c;", "", "e", "()Ljava/util/Set;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", UxipConstants.f30680s, "v", "(Ljava/lang/Object;Ljava/lang/Object;)LRa/c;", "w", "(Ljava/lang/Object;)LRa/c;", "", "m", "putAll", "(Ljava/util/Map;)LPa/d;", "LPa/d$a;", "builder", "()LPa/d$a;", "other", "equals", "", "hashCode", "()I", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "q", "()Ljava/lang/Object;", "c", "t", Const.INTENT_KEY_UMID, "LQa/d;", "r", "()LQa/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, ContentDisposition.Parameters.Size, "s", "keys", "LPa/b;", "u", "()LPa/b;", "values", Const.INTENT_KEY_APIKEY, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c<K, V> extends AbstractC1158f<K, V> implements Pa.d<K, V> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final c f5596f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object firstKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lastKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Qa.d<K, a<V>> hashMap;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LRa/c$a;", "", "<init>", "()V", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LRa/c;", Const.INTENT_KEY_APIKEY, "()LRa/c;", "", "EMPTY", "LRa/c;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Ra.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final <K, V> c<K, V> a() {
            c<K, V> cVar = c.f5596f;
            kotlin.jvm.internal.p.g(cVar, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K of kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf, V of kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf>");
            return cVar;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements p9.p<a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5600a = new b();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(a<V> a10, a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Ra.c$c, reason: collision with other inner class name */
    public static final class C0097c implements p9.p<a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0097c f5601a = new C0097c();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(a<V> a10, a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class d implements p9.p<a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f5602a = new d();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(a<V> a10, Object obj) {
            kotlin.jvm.internal.p.i(a10, "a");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), obj));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class e implements p9.p<a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f5603a = new e();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(a<V> a10, Object obj) {
            kotlin.jvm.internal.p.i(a10, "a");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), obj));
        }
    }

    static {
        Ta.c cVar = Ta.c.f5919a;
        f5596f = new c(cVar, cVar, Qa.d.INSTANCE.a());
    }

    public c(Object obj, Object obj2, Qa.d<K, a<V>> hashMap) {
        kotlin.jvm.internal.p.i(hashMap, "hashMap");
        this.firstKey = obj;
        this.lastKey = obj2;
        this.hashMap = hashMap;
    }

    private final Pa.c<Map.Entry<K, V>> p() {
        return new l(this);
    }

    @Override // Pa.d
    public d.a<K, V> builder() {
        return new Ra.d(this);
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.hashMap.containsKey(key);
    }

    @Override // Z8.AbstractC1158f
    public final Set<Map.Entry<K, V>> e() {
        return p();
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
        return map instanceof c ? this.hashMap.s().p(((c) other).hashMap.s(), b.f5600a) : map instanceof Ra.d ? this.hashMap.s().p(((Ra.d) other).j().m(), C0097c.f5601a) : map instanceof Qa.d ? this.hashMap.s().p(((Qa.d) other).s(), d.f5602a) : map instanceof Qa.f ? this.hashMap.s().p(((Qa.f) other).m(), e.f5603a) : super.equals(other);
    }

    @Override // java.util.Map
    public V get(Object key) {
        a<V> aVar = this.hashMap.get(key);
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    @Override // Z8.AbstractC1158f, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: i */
    public int getSize() {
        return this.hashMap.size();
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

    /* renamed from: q, reason: from getter */
    public final Object getFirstKey() {
        return this.firstKey;
    }

    public final Qa.d<K, a<V>> r() {
        return this.hashMap;
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Pa.c<K> g() {
        return new n(this);
    }

    /* renamed from: t, reason: from getter */
    public final Object getLastKey() {
        return this.lastKey;
    }

    @Override // Z8.AbstractC1158f
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Pa.b<V> j() {
        return new q(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Z8.AbstractC1158f, java.util.Map, Pa.d
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public c<K, V> put(K key, V value) {
        if (isEmpty()) {
            return new c<>(key, key, this.hashMap.put(key, new a<>(value)));
        }
        a<V> aVar = this.hashMap.get(key);
        if (aVar != null) {
            if (aVar.e() == value) {
                return this;
            }
            return new c<>(this.firstKey, this.lastKey, this.hashMap.put(key, aVar.h(value)));
        }
        Object obj = this.lastKey;
        a<V> aVar2 = this.hashMap.get(obj);
        kotlin.jvm.internal.p.f(aVar2);
        return new c<>(this.firstKey, key, this.hashMap.put(obj, aVar2.f(key)).put(key, new a(value, obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [Qa.d, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v2, types: [Qa.d, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // Z8.AbstractC1158f, java.util.Map, Pa.d
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public c<K, V> remove(K key) {
        a<V> aVar = this.hashMap.get(key);
        if (aVar == null) {
            return this;
        }
        Qa.d<K, a<V>> dVarRemove = this.hashMap.remove(key);
        ?? r52 = dVarRemove;
        if (aVar.b()) {
            Object obj = dVarRemove.get(aVar.getPrevious());
            kotlin.jvm.internal.p.f(obj);
            r52 = (Qa.d<K, a<V>>) dVarRemove.put(aVar.getPrevious(), ((a) obj).f(aVar.getNext()));
        }
        Qa.d dVarPut = r52;
        if (aVar.a()) {
            Object obj2 = r52.get(aVar.getNext());
            kotlin.jvm.internal.p.f(obj2);
            dVarPut = r52.put(aVar.getNext(), ((a) obj2).g(aVar.getPrevious()));
        }
        return new c<>(!aVar.b() ? aVar.getNext() : this.firstKey, !aVar.a() ? aVar.getPrevious() : this.lastKey, dVarPut);
    }
}
