package com.google.crypto.tink.prf;

import com.google.crypto.tink.config.TinkFips;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PrfConfig {
    public static final String PRF_TYPE_URL = new HkdfPrfKeyManager().getKeyType();

    private PrfConfig() {
    }

    public static void register() {
        PrfSetWrapper.register();
        HmacPrfKeyManager.register(true);
        if (TinkFips.useOnlyFips()) {
            return;
        }
        AesCmacPrfKeyManager.register(true);
        HkdfPrfKeyManager.register(true);
    }
}
