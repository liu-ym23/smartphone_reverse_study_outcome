package E7;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.token.TokenProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.w;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LE7/d;", "Ltb/w;", "", "", "headers", "Lcom/stepos/net/token/TokenProvider;", "tokenProvider", "<init>", "(Ljava/util/Map;Lcom/stepos/net/token/TokenProvider;)V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/net/token/TokenProvider;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> headers;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final TokenProvider tokenProvider;

    public d(Map<String, String> headers, TokenProvider tokenProvider) {
        p.i(headers, "headers");
        this.headers = headers;
        this.tokenProvider = tokenProvider;
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) {
        String cachedToken;
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        if (this.headers.isEmpty() && this.tokenProvider == null) {
            return chain.i(request);
        }
        C5528A.a aVarI = request.i();
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (request.e(key) == null) {
                aVarI.l(key, value);
            }
        }
        TokenProvider tokenProvider = this.tokenProvider;
        if (tokenProvider != null && (cachedToken = tokenProvider.getCachedToken()) != null) {
            if (H.x0(cachedToken)) {
                cachedToken = null;
            }
            if (cachedToken != null) {
                String strHeaderName = this.tokenProvider.headerName();
                if (request.e(strHeaderName) == null) {
                    aVarI.l(strHeaderName, this.tokenProvider.tokenPrefix() + cachedToken);
                }
            }
        }
        return chain.i(aVarI.b());
    }
}
