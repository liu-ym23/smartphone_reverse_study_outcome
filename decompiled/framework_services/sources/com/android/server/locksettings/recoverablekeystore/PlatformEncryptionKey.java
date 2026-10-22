package com.android.server.locksettings.recoverablekeystore;

import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformEncryptionKey {
    private final int mGenerationId;
    private final SecretKey mKey;

    public PlatformEncryptionKey(int generationId, SecretKey key) {
        this.mGenerationId = generationId;
        this.mKey = key;
    }

    public int getGenerationId() {
        return this.mGenerationId;
    }

    public SecretKey getKey() {
        return this.mKey;
    }
}
