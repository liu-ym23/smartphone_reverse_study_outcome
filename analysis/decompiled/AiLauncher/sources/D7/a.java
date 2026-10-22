package D7;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.cache.CacheTagStore;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LD7/a;", "Ltb/w;", "Lcom/stepos/net/cache/CacheTagStore;", "store", "<init>", "(Lcom/stepos/net/cache/CacheTagStore;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/net/cache/CacheTagStore;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CacheTagStore store;

    public a(CacheTagStore store) {
        p.i(store, "store");
        this.store = store;
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IOException {
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        String strE = request.e("Stepos-Cache-Tags");
        if (strE == null) {
            return chain.i(request);
        }
        C5528A c5528aB = request.i().q("Stepos-Cache-Tags").b();
        C5530C c5530cI = chain.i(c5528aB);
        this.store.a(c5528aB.getUrl().getUrl(), H.a1(strE, new char[]{','}, false, 0, 6, null));
        return c5530cI;
    }
}
