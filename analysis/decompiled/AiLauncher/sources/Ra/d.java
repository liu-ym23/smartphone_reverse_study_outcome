package Ra;

import Pa.d;
import Z8.AbstractC1161i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R(\u0010'\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001a8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$R,\u00100\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+0*8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001fR&\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00028\u0000038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u00105R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00028\u0001088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"LRa/d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LZ8/i;", "LPa/d$a;", "LRa/c;", C3081a.FOCUS_MAP_NAME, "<init>", "(LRa/c;)V", "LPa/d;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()LPa/d;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", UxipConstants.f30680s, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "LY8/t;", "clear", "()V", "", "other", "equals", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "LRa/c;", "builtMap", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "firstKey", "c", "lastKey", "LQa/f;", "LRa/a;", Const.INTENT_KEY_UMID, "LQa/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LQa/f;", "hashMapBuilder", "e", ContentDisposition.Parameters.Size, "", "", "()Ljava/util/Set;", "entries", "keys", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Collection;", "values", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d<K, V> extends AbstractC1161i<K, V> implements d.a<K, V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Ra.c<K, V> builtMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object firstKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Object lastKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Qa.f<K, Ra.a<V>> hashMapBuilder;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a implements p9.p<Ra.a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5608a = new a();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Ra.a<V> a10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements p9.p<Ra.a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5609a = new b();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Ra.a<V> a10, Ra.a<? extends Object> b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), b10.e()));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c implements p9.p<Ra.a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5610a = new c();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Ra.a<V> a10, Object obj) {
            kotlin.jvm.internal.p.i(a10, "a");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), obj));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Ra.d$d, reason: collision with other inner class name */
    public static final class C0098d implements p9.p<Ra.a<V>, ?, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0098d f5611a = new C0098d();

        @Override // p9.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Ra.a<V> a10, Object obj) {
            kotlin.jvm.internal.p.i(a10, "a");
            return Boolean.valueOf(kotlin.jvm.internal.p.d(a10.e(), obj));
        }
    }

    public d(Ra.c<K, V> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.builtMap = map;
        this.firstKey = map.getFirstKey();
        this.lastKey = map.getLastKey();
        this.hashMapBuilder = map.r().builder();
    }

    @Override // Z8.AbstractC1161i
    public Set<Map.Entry<K, V>> b() {
        return new e(this);
    }

    @Override // Pa.d.a
    public Pa.d<K, V> build() {
        Ra.c<K, V> cVar = this.builtMap;
        if (cVar != null) {
            Ta.a.a(this.hashMapBuilder.j() != null);
            Ta.a.a(this.firstKey == cVar.getFirstKey());
            Ta.a.a(this.lastKey == cVar.getLastKey());
            return cVar;
        }
        Ta.a.a(this.hashMapBuilder.j() == null);
        Ra.c<K, V> cVar2 = new Ra.c<>(this.firstKey, this.lastKey, this.hashMapBuilder.build());
        this.builtMap = cVar2;
        return cVar2;
    }

    @Override // Z8.AbstractC1161i
    public Set<K> c() {
        return new g(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (!this.hashMapBuilder.isEmpty()) {
            this.builtMap = null;
        }
        this.hashMapBuilder.clear();
        Ta.c cVar = Ta.c.f5919a;
        this.firstKey = cVar;
        this.lastKey = cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return this.hashMapBuilder.containsKey(key);
    }

    @Override // Z8.AbstractC1161i
    /* renamed from: e */
    public int getIo.ktor.http.ContentDisposition.Parameters.Size java.lang.String() {
        return this.hashMapBuilder.size();
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
        return map instanceof Ra.c ? this.hashMapBuilder.m().p(((Ra.c) other).r().s(), a.f5608a) : map instanceof d ? this.hashMapBuilder.m().p(((d) other).hashMapBuilder.m(), b.f5609a) : map instanceof Qa.d ? this.hashMapBuilder.m().p(((Qa.d) other).s(), c.f5610a) : map instanceof Qa.f ? this.hashMapBuilder.m().p(((Qa.f) other).m(), C0098d.f5611a) : Ta.d.f5920a.b(this, map);
    }

    @Override // Z8.AbstractC1161i
    public Collection<V> g() {
        return new j(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        Ra.a<V> aVar = this.hashMapBuilder.get(key);
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return Ta.d.f5920a.c(this);
    }

    /* renamed from: i, reason: from getter */
    public final Object getFirstKey() {
        return this.firstKey;
    }

    public final Qa.f<K, Ra.a<V>> j() {
        return this.hashMapBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        Ra.a<V> aVar = this.hashMapBuilder.get(key);
        if (aVar != null) {
            if (aVar.e() == value) {
                return value;
            }
            this.builtMap = null;
            this.hashMapBuilder.put(key, aVar.h(value));
            return aVar.e();
        }
        this.builtMap = null;
        if (isEmpty()) {
            this.firstKey = key;
            this.lastKey = key;
            this.hashMapBuilder.put(key, new Ra.a<>(value));
        } else {
            Object obj = this.lastKey;
            Ra.a<V> aVar2 = this.hashMapBuilder.get(obj);
            kotlin.jvm.internal.p.f(aVar2);
            Ta.a.a(!r2.a());
            this.hashMapBuilder.put(obj, aVar2.f(key));
            this.hashMapBuilder.put(key, new Ra.a<>(value, obj));
            this.lastKey = key;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        Ra.a<V> aVarRemove = this.hashMapBuilder.remove(key);
        if (aVarRemove == null) {
            return null;
        }
        this.builtMap = null;
        if (aVarRemove.b()) {
            Ra.a<V> aVar = this.hashMapBuilder.get(aVarRemove.getPrevious());
            kotlin.jvm.internal.p.f(aVar);
            this.hashMapBuilder.put(aVarRemove.getPrevious(), aVar.f(aVarRemove.getNext()));
        } else {
            this.firstKey = aVarRemove.getNext();
        }
        if (aVarRemove.a()) {
            Ra.a<V> aVar2 = this.hashMapBuilder.get(aVarRemove.getNext());
            kotlin.jvm.internal.p.f(aVar2);
            this.hashMapBuilder.put(aVarRemove.getNext(), aVar2.g(aVarRemove.getPrevious()));
        } else {
            this.lastKey = aVarRemove.getPrevious();
        }
        return aVarRemove.e();
    }

    @Override // java.util.Map
    public final boolean remove(Object key, Object value) {
        Ra.a<V> aVar = this.hashMapBuilder.get(key);
        if (aVar == null || !kotlin.jvm.internal.p.d(aVar.e(), value)) {
            return false;
        }
        remove(key);
        return true;
    }
}
