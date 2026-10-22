package com.stepos.net.token;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/stepos/net/token/InMemoryTokenStore;", "Lcom/stepos/net/token/TokenStore;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "clear", "", "access", "Ljava/lang/String;", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "refresh", "getRefresh", "setRefresh", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InMemoryTokenStore implements TokenStore {
    private volatile String access;
    private volatile String refresh;

    @Override // com.stepos.net.token.TokenStore
    public void clear() {
        setAccess(null);
        setRefresh(null);
    }

    @Override // com.stepos.net.token.TokenStore
    public String getAccess() {
        return this.access;
    }

    @Override // com.stepos.net.token.TokenStore
    public String getRefresh() {
        return this.refresh;
    }

    @Override // com.stepos.net.token.TokenStore
    public void setAccess(String str) {
        this.access = str;
    }

    @Override // com.stepos.net.token.TokenStore
    public void setRefresh(String str) {
        this.refresh = str;
    }
}
