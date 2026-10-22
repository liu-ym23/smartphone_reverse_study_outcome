package io.ktor.client.plugins.cache.storage;

import Y8.t;
import Z8.A;
import Z8.Y;
import e9.InterfaceC4014c;
import g9.C4109a;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.collections.ConcurrentSetKt;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u0013\u0010\u000fJ\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0014\u0010\u0012R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/cache/storage/UnlimitedStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "LY8/t;", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Le9/c;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Le9/c;)Ljava/lang/Object;", "remove", "removeAll", "Lio/ktor/util/collections/ConcurrentMap;", "", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnlimitedStorage implements CacheStorage {
    private final ConcurrentMap<Url, Set<CachedResponseData>> store = new ConcurrentMap<>(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean remove$lambda$5(Map map, CachedResponseData entry) {
        p.i(entry, "entry");
        if (!map.isEmpty()) {
            for (Map.Entry entry2 : map.entrySet()) {
                if (!p.d(entry.getVaryKeys().get((String) entry2.getKey()), (String) entry2.getValue())) {
                    return false;
                }
            }
        }
        return map.size() == entry.getVaryKeys().size();
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, InterfaceC4014c<? super CachedResponseData> interfaceC4014c) {
        for (Object obj : this.store.computeIfAbsent((ConcurrentMap<Url, Set<CachedResponseData>>) url, new InterfaceC5063a() { // from class: io.ktor.client.plugins.cache.storage.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConcurrentSetKt.ConcurrentSet();
            }
        })) {
            CachedResponseData cachedResponseData = (CachedResponseData) obj;
            if (map.isEmpty()) {
                return obj;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!p.d(cachedResponseData.getVaryKeys().get(key), entry.getValue())) {
                    break;
                }
            }
            return obj;
        }
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, InterfaceC4014c<? super Set<CachedResponseData>> interfaceC4014c) {
        Set<CachedResponseData> set = this.store.get(url);
        return set == null ? Y.e() : set;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, final Map<String, String> map, InterfaceC4014c<? super t> interfaceC4014c) {
        Set<CachedResponseData> set = this.store.get(url);
        if (set != null) {
            C4109a.a(A.J(set, new InterfaceC5074l() { // from class: io.ktor.client.plugins.cache.storage.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(UnlimitedStorage.remove$lambda$5(map, (CachedResponseData) obj));
                }
            }));
        }
        return t.f7040a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, InterfaceC4014c<? super t> interfaceC4014c) {
        this.store.remove(url);
        return t.f7040a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, InterfaceC4014c<? super t> interfaceC4014c) {
        Set<CachedResponseData> setComputeIfAbsent = this.store.computeIfAbsent((ConcurrentMap<Url, Set<CachedResponseData>>) url, new InterfaceC5063a() { // from class: io.ktor.client.plugins.cache.storage.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConcurrentSetKt.ConcurrentSet();
            }
        });
        if (!setComputeIfAbsent.add(cachedResponseData)) {
            setComputeIfAbsent.remove(cachedResponseData);
            setComputeIfAbsent.add(cachedResponseData);
        }
        return t.f7040a;
    }
}
