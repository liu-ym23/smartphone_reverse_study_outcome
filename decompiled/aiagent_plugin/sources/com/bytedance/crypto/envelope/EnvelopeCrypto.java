package com.bytedance.crypto.envelope;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class EnvelopeCrypto {
    private static final String TAG = "EnvelopeCrypto";
    private static volatile EnvelopeCrypto instance;

    private EnvelopeCrypto() {
    }

    public static EnvelopeCrypto getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCrypto.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r1, InputStream r2, OutputStream r3) {
        return EnvelopeCryptoImpl.getInstance().decrypt(r1, r2, r3);
    }

    public int encrypt(byte[] r8, byte[] r9, long r10, InputStream r12, OutputStream r13) {
        return EnvelopeCryptoImpl.getInstance().encrypt(r8, r9, r10, r12, r13);
    }

    public byte[] extractDEKCipher(InputStream r1) {
        return EnvelopeCryptoImpl.getInstance().extractDEKCipher(r1);
    }
}
