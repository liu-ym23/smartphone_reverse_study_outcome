package io.ktor.client.plugins.cache.storage;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0004\b\u0011\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0012\u0010\u0010¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CacheStorage;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "LY8/t;", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Le9/c;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Le9/c;)Ljava/lang/Object;", "remove", "removeAll", "Companion", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CacheStorage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CacheStorage$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Unlimited", "Lp9/a;", "getUnlimited", "()Lp9/a;", "Disabled", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getDisabled", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InterfaceC5063a<CacheStorage> Unlimited = new InterfaceC5063a() { // from class: io.ktor.client.plugins.cache.storage.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CacheStorage.Companion.Unlimited$lambda$0();
            }
        };
        private static final CacheStorage Disabled = DisabledStorage.INSTANCE;

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final UnlimitedStorage Unlimited$lambda$0() {
            return new UnlimitedStorage();
        }

        public final CacheStorage getDisabled() {
            return Disabled;
        }

        public final InterfaceC5063a<CacheStorage> getUnlimited() {
            return Unlimited;
        }
    }

    Object find(Url url, Map<String, String> map, InterfaceC4014c<? super CachedResponseData> interfaceC4014c);

    Object findAll(Url url, InterfaceC4014c<? super Set<CachedResponseData>> interfaceC4014c);

    Object remove(Url url, Map<String, String> map, InterfaceC4014c<? super t> interfaceC4014c);

    Object removeAll(Url url, InterfaceC4014c<? super t> interfaceC4014c);

    Object store(Url url, CachedResponseData cachedResponseData, InterfaceC4014c<? super t> interfaceC4014c);
}
