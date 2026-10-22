package u6;

import La.H;
import Z8.A;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lu6/d;", "", "<init>", "()V", "", "key", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "url", "", "ttlMs", "LY8/t;", "f", "(Ljava/lang/String;Ljava/lang/String;J)V", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "Lu6/d$a;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "SAFETY_MARGIN_MS", "J", "", "MAX_ENTRIES", "I", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5581d {
    private static final int MAX_ENTRIES = 256;
    private static final long SAFETY_MARGIN_MS = 60000;
    public static final C5581d INSTANCE = new C5581d();
    private static final ConcurrentHashMap<String, Entry> cache = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lu6/d$a;", "", "", "url", "", "expireAtMs", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_APIKEY, "()J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u6.d$a, reason: from toString */
    public static final /* data */ class Entry {
        private final long expireAtMs;
        private final String url;

        public Entry(String url, long j10) {
            p.i(url, "url");
            this.url = url;
            this.expireAtMs = j10;
        }

        /* renamed from: a, reason: from getter */
        public final long getExpireAtMs() {
            return this.expireAtMs;
        }

        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return p.d(this.url, entry.url) && this.expireAtMs == entry.expireAtMs;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + Long.hashCode(this.expireAtMs);
        }

        public String toString() {
            return "Entry(url=" + this.url + ", expireAtMs=" + this.expireAtMs + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u6.d$b */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((Entry) ((Map.Entry) t10).getValue()).getExpireAtMs()), Long.valueOf(((Entry) ((Map.Entry) t11).getValue()).getExpireAtMs()));
        }
    }

    public static final boolean c(long j10, Map.Entry it) {
        p.i(it, "it");
        return j10 >= ((Entry) it.getValue()).getExpireAtMs();
    }

    public final void b() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<String, Entry> concurrentHashMap = cache;
        Set<Map.Entry<String, Entry>> setEntrySet = concurrentHashMap.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        A.J(setEntrySet, new InterfaceC5074l() { // from class: u6.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C5581d.c(jCurrentTimeMillis, (Map.Entry) obj));
            }
        });
        if (concurrentHashMap.size() <= 256) {
            return;
        }
        Set<Map.Entry<String, Entry>> setEntrySet2 = concurrentHashMap.entrySet();
        p.h(setEntrySet2, "<get-entries>(...)");
        Iterator it = F.f1(F.c1(setEntrySet2, new b()), concurrentHashMap.size() - 256).iterator();
        while (it.hasNext()) {
            cache.remove(((Map.Entry) it.next()).getKey());
        }
    }

    public final String d(String key) {
        p.i(key, "key");
        ConcurrentHashMap<String, Entry> concurrentHashMap = cache;
        Entry entry = concurrentHashMap.get(key);
        if (entry == null) {
            return null;
        }
        if (System.currentTimeMillis() < entry.getExpireAtMs()) {
            return entry.getUrl();
        }
        concurrentHashMap.remove(key);
        return null;
    }

    public final void e(String key) {
        p.i(key, "key");
        cache.remove(key);
    }

    public final void f(String key, String url, long ttlMs) {
        p.i(key, "key");
        p.i(url, "url");
        if (H.x0(url)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + C5685n.g(ttlMs - 60000, 0L);
        ConcurrentHashMap<String, Entry> concurrentHashMap = cache;
        concurrentHashMap.put(key, new Entry(url, jCurrentTimeMillis));
        if (concurrentHashMap.size() > 256) {
            b();
        }
    }
}
