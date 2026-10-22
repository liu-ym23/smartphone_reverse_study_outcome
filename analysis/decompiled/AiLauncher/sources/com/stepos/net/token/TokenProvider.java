package com.stepos.net.token;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/net/token/TokenProvider;", "", "getToken", "", "headerName", "tokenPrefix", "refreshToken", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TokenProvider {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String headerName(TokenProvider tokenProvider) {
            return TokenProvider.super.headerName();
        }

        @Deprecated
        public static String refreshToken(TokenProvider tokenProvider) {
            return TokenProvider.super.refreshToken();
        }

        @Deprecated
        public static String tokenPrefix(TokenProvider tokenProvider) {
            return TokenProvider.super.tokenPrefix();
        }
    }

    String getToken();

    default String headerName() {
        return "Authorization";
    }

    default String refreshToken() {
        return null;
    }

    default String tokenPrefix() {
        return "Bearer ";
    }
}
