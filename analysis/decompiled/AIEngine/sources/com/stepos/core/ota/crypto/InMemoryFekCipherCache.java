package com.stepos.core.ota.crypto;

import java.util.HashMap;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InMemoryFekCipherCache implements FekCipherCache {
    private final HashMap<String, FekEnvelopeCipher> entries = new HashMap<>();

    private final String key(String str, int i10) {
        return str + ":" + i10;
    }

    @Override // com.stepos.core.ota.crypto.FekCipherCache
    public FekEnvelopeCipher get(String modelId, int i10) {
        FekEnvelopeCipher fekEnvelopeCipher;
        g.f(modelId, "modelId");
        synchronized (this.entries) {
            fekEnvelopeCipher = this.entries.get(key(modelId, i10));
        }
        return fekEnvelopeCipher;
    }

    @Override // com.stepos.core.ota.crypto.FekCipherCache
    public void put(String modelId, int i10, FekEnvelopeCipher cipher) {
        g.f(modelId, "modelId");
        g.f(cipher, "cipher");
        synchronized (this.entries) {
            this.entries.put(key(modelId, i10), cipher);
            n nVar = n.f10413a;
        }
    }

    @Override // com.stepos.core.ota.crypto.FekCipherCache
    public void remove(String modelId, int i10) {
        g.f(modelId, "modelId");
        synchronized (this.entries) {
            this.entries.remove(key(modelId, i10));
        }
    }
}
