package com.stepos.net.token;

import A5.a;
import A5.c;
import F9.G;
import F9.InterfaceC0224b;
import F9.M;
import F9.Q;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/net/token/TokenAuthenticator;", "LF9/b;", "Lcom/stepos/net/token/TokenProvider;", "provider", "LA5/a;", "signatureProvider", AppAgent.CONSTRUCT, "(Lcom/stepos/net/token/TokenProvider;LA5/a;)V", "LF9/M;", "response", "", "responseCount", "(LF9/M;)I", "LF9/Q;", "route", "LF9/G;", "authenticate", "(LF9/Q;LF9/M;)LF9/G;", "Lcom/stepos/net/token/TokenProvider;", "LA5/a;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TokenAuthenticator implements InterfaceC0224b {
    private final TokenProvider provider;
    private final a signatureProvider;

    public TokenAuthenticator(TokenProvider provider, a aVar) {
        k.f(provider, "provider");
        this.provider = provider;
        this.signatureProvider = aVar;
    }

    private final int responseCount(M response) {
        int i = 1;
        for (M m = response.f632j; m != null; m = m.f632j) {
            i++;
        }
        return i;
    }

    @Override // F9.InterfaceC0224b
    public G authenticate(Q route, M response) {
        String strRefreshToken;
        k.f(response, "response");
        G g = response.f631a;
        if (responseCount(response) >= 2 || (strRefreshToken = this.provider.refreshToken()) == null) {
            return null;
        }
        K1.a aVarB = g.b();
        aVarB.g(this.provider.headerName(), this.provider.tokenPrefix() + strRefreshToken);
        a aVar = this.signatureProvider;
        if (aVar != null) {
            for (Map.Entry entry : ((c) aVar).z(g).entrySet()) {
                aVarB.g((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return aVarB.d();
    }

    public /* synthetic */ TokenAuthenticator(TokenProvider tokenProvider, a aVar, int i, e eVar) {
        this(tokenProvider, (i & 2) != 0 ? null : aVar);
    }
}
