package com.google.crypto.tink.jwt;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JwtMacConfig {
    public static final String JWT_HMAC_TYPE_URL = new JwtHmacKeyManager().getKeyType();

    private JwtMacConfig() {
    }

    public static void register() {
        JwtHmacKeyManager.register(true);
        JwtMacWrapper.register();
    }
}
