package com.stepos.net.token;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/net/token/CachedTokenProvider;", "Lcom/stepos/net/token/TokenProvider;", "delegate", AppAgent.CONSTRUCT, "(Lcom/stepos/net/token/TokenProvider;)V", "", "getToken", "()Ljava/lang/String;", "headerName", "tokenPrefix", "refreshToken", "LC7/r;", "invalidate", "()V", "Lcom/stepos/net/token/TokenProvider;", "cached", "Ljava/lang/String;", "", "lock", "Ljava/lang/Object;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedTokenProvider implements TokenProvider {
    private volatile String cached;
    private final TokenProvider delegate;
    private final Object lock;

    public CachedTokenProvider(TokenProvider delegate) {
        k.f(delegate, "delegate");
        this.delegate = delegate;
        this.lock = new Object();
    }

    @Override // com.stepos.net.token.TokenProvider
    public String getToken() {
        String token;
        String str = this.cached;
        if (str != null) {
            return str;
        }
        synchronized (this.lock) {
            token = this.cached;
            if (token == null) {
                token = this.delegate.getToken();
                if (token != null) {
                    this.cached = token;
                } else {
                    token = null;
                }
            }
        }
        return token;
    }

    @Override // com.stepos.net.token.TokenProvider
    public String headerName() {
        return this.delegate.headerName();
    }

    public final void invalidate() {
        synchronized (this.lock) {
            this.cached = null;
        }
    }

    @Override // com.stepos.net.token.TokenProvider
    public String refreshToken() {
        String strRefreshToken;
        synchronized (this.lock) {
            strRefreshToken = this.delegate.refreshToken();
            this.cached = strRefreshToken;
        }
        return strRefreshToken;
    }

    @Override // com.stepos.net.token.TokenProvider
    public String tokenPrefix() {
        return this.delegate.tokenPrefix();
    }
}
