package c59;

import com.bytedance.keva.Keva;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f22505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f22506b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/dynamic/dsl/DslStarlingRepo$loadStarlingFromCache$1$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    static {
        f22505a = new ConcurrentHashMap();
        f22506b = new Object();
    }

    public static Map a() {
        return MapsKt.toMap(f22505a);
    }

    public static void b() {
        Object r100 = f22506b;
        monitor-enter(r100);
        String r101 = g49.c.f480007a.getString("key_dora_kv_starling", "");     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        if (r101.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        g49.d.d("DslStarlingRepo", "loadStarlingFromCache: empty cache, no need to load");     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        monitor-exit(r100);
        return;
    L12:
        Map<? extends String, ? extends String> r103 = (Map) s.a(r101, new a());     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        if (r103 != null) goto L15;
        r103 = MapsKt.emptyMap();     // Catch: JsonSyntaxException -> L17 Throwable -> L19
    L15:
        ConcurrentHashMap<String, String> r104 = f22505a;     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        r104.clear();     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        r104.putAll(r103);     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        g49.d.d("DslStarlingRepo", "loadStarlingFromCache: load starling map from cache, size=" + r103.size());     // Catch: JsonSyntaxException -> L17 Throwable -> L19
    L22:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r100);
        return;
    L7:
        r102 = false;
    L25:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        g49.d.c("DslStarlingRepo", "loadStarlingFromCache JsonSyntaxException error: " + e.getMessage(), e);     // Catch: Throwable -> L25
        Keva r106 = g49.c.f480007a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter("", "value");     // Catch: Throwable -> L25
        g49.c.f480007a.storeString("key_dora_kv_starling", "");     // Catch: Throwable -> L25
    L19:
        th = move-exception;
        g49.d.c("DslStarlingRepo", "loadStarlingFromCache error: " + th.getMessage(), th);     // Catch: Throwable -> L25
        goto L22
    }

    public static void c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (r100.isEmpty() == false) goto L6;
        g49.d.d("DslStarlingRepo", "updateStarling: empty map，no need to update");
        return;
    L6:
        Object r101 = f22506b;
        monitor-enter(r101);
        g49.d.d("DslStarlingRepo", "updateStaring: begin update starling map");     // Catch: Throwable -> L25
        Iterator r102 = r100.entrySet().iterator();     // Catch: Throwable -> L25
        boolean r103 = false;
    L10:
        if (r102.hasNext() == false) goto L18;
        Map.Entry r104 = (Map.Entry) r102.next();     // Catch: Throwable -> L25
        String r105 = (String) r104.getKey();     // Catch: Throwable -> L25
        String r106 = (String) r104.getValue();     // Catch: Throwable -> L25
        ConcurrentHashMap<String, String> r107 = f22505a;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r107.get(r105), r106) == true) goto L10;
        if (o0.d(r106) == false) goto L10;
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r107.put(r105, r106);     // Catch: Throwable -> L25
        r103 = true;
        goto L10
    L18:
        if (r103 == false) goto L22;
        g49.d.d("DslStarlingRepo", "updateStaring: starling map changed, save to cache");     // Catch: Throwable -> L25
        Lazy r108 = s.f22521a;     // Catch: Throwable -> L25
        String r109 = s.d(a());     // Catch: Throwable -> L25
        if (r109 == null) goto L22;
        Keva r110 = g49.c.f480007a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r109, "value");     // Catch: Throwable -> L25
        g49.c.f480007a.storeString("key_dora_kv_starling", r109);     // Catch: Throwable -> L25
    L22:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
