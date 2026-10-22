package D7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.cache.CacheTagStore;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5536c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"LD7/b;", "", "Ltb/c;", "cache", "Lcom/stepos/net/cache/CacheTagStore;", "store", "<init>", "(Ltb/c;Lcom/stepos/net/cache/CacheTagStore;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/net/cache/CacheTagStore;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CacheTagStore store;

    public b(C5536c c5536c, CacheTagStore store) {
        p.i(store, "store");
        this.store = store;
    }
}
