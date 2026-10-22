package E7;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LE7/i;", "Ltb/w;", "LI7/c;", Const.JSON_KEY_PROVIDER, "<init>", "(LI7/c;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "LI7/c;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final I7.c provider;

    public i(I7.c provider) {
        p.i(provider, "provider");
        this.provider = provider;
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) {
        p.i(chain, "chain");
        C5528A c5528aB = chain.b();
        Map<String, String> mapA = this.provider.a(c5528aB);
        if (mapA.isEmpty()) {
            return chain.i(c5528aB);
        }
        C5528A.a aVarI = c5528aB.i();
        for (Map.Entry<String, String> entry : mapA.entrySet()) {
            aVarI.l(entry.getKey(), entry.getValue());
        }
        return chain.i(aVarI.b());
    }
}
