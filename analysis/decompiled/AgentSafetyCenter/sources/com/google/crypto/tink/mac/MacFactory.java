package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Mac;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public final class MacFactory {
    private MacFactory() {
    }

    @Deprecated
    public static Mac getPrimitive(KeysetHandle keysetHandle) {
        MacWrapper.register();
        return (Mac) keysetHandle.getPrimitive(Mac.class);
    }
}
