package com.stepos.net.token;

import I7.c;
import M5.a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import tb.InterfaceC5535b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/net/token/TokenAuthenticator;", "Ltb/b;", "Lcom/stepos/net/token/TokenProvider;", Const.JSON_KEY_PROVIDER, "LI7/c;", "signatureProvider", "<init>", "(Lcom/stepos/net/token/TokenProvider;LI7/c;)V", "Ltb/C;", UxipConstants.f30685x, "", "responseCount", "(Ltb/C;)I", "Ltb/E;", a.CARD_TYPE_ROUTE, "Ltb/A;", "authenticate", "(Ltb/E;Ltb/C;)Ltb/A;", "Lcom/stepos/net/token/TokenProvider;", "LI7/c;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TokenAuthenticator implements InterfaceC5535b {
    private final TokenProvider provider;
    private final c signatureProvider;

    public TokenAuthenticator(TokenProvider provider, c cVar) {
        p.i(provider, "provider");
        this.provider = provider;
        this.signatureProvider = cVar;
    }

    private final int responseCount(C5530C response) {
        int i10 = 1;
        for (C5530C priorResponse = response.getPriorResponse(); priorResponse != null; priorResponse = priorResponse.getPriorResponse()) {
            i10++;
        }
        return i10;
    }

    @Override // tb.InterfaceC5535b
    public C5528A authenticate(C5532E route, C5530C response) {
        String strRefreshToken;
        Map<String, String> mapA;
        p.i(response, "response");
        if (responseCount(response) >= 2 || (strRefreshToken = this.provider.refreshToken()) == null) {
            return null;
        }
        C5528A.a aVarL = response.getRequest().i().l(this.provider.headerName(), this.provider.tokenPrefix() + strRefreshToken);
        c cVar = this.signatureProvider;
        if (cVar != null && (mapA = cVar.a(response.getRequest())) != null) {
            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                aVarL.l(entry.getKey(), entry.getValue());
            }
        }
        return aVarL.b();
    }

    public /* synthetic */ TokenAuthenticator(TokenProvider tokenProvider, c cVar, int i10, i iVar) {
        this(tokenProvider, (i10 & 2) != 0 ? null : cVar);
    }
}
