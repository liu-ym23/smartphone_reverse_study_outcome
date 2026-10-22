package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeysetHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public final class DeterministicAeadFactory {
    private DeterministicAeadFactory() {
    }

    @Deprecated
    public static DeterministicAead getPrimitive(KeysetHandle keysetHandle) {
        DeterministicAeadWrapper.register();
        return (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class);
    }
}
