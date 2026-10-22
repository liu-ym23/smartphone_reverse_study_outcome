package com.bytedance.crypto.e2eetrans;

/* JADX INFO: loaded from: classes.dex */
public interface CryptoSession extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    void confirmHandshake(byte[] r1);

    byte[] decrypt(byte[] r1, String r2, String r3, int r4);

    byte[] encrypt(byte[] r1, String r2, String r3, int r4);

    byte[] getAuthMessage();

    byte[] getFinishMessage();

    byte[] processAuthMessage(byte[] r1);
}
