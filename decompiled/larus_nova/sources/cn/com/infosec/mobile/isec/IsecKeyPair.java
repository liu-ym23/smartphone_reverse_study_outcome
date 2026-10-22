package cn.com.infosec.mobile.isec;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class IsecKeyPair extends IsecBase {
    public int errCode;

    private native int decryptNative(boolean r100, byte[] r101, ByteArrayOutputStream r102);

    private native int encryptNative(boolean r100, byte[] r101, ByteArrayOutputStream r102);

    private native int exportKeyNative(boolean r100, ByteArrayOutputStream r101, ByteArrayOutputStream r102);

    private native int genKeyNative();

    private native int importKeyNative(byte[] r100, byte[] r101);

    private native int signNative(boolean r100, byte[] r101, ByteArrayOutputStream r102);

    private native int verifyNative(boolean r100, byte[] r101, byte[] r102);

    public int genKey() {
        return genKeyNative();
    }

    public IsecKeyPair() {
    }

    public int importKey(byte[] r100, byte[] r101) {
        return importKeyNative(r100, r101);
    }

    public int decrypt(boolean r100, byte[] r101, ByteArrayOutputStream r102) {
        return decryptNative(r100, r101, r102);
    }

    public int encrypt(boolean r100, byte[] r101, ByteArrayOutputStream r102) {
        return encryptNative(r100, r101, r102);
    }

    public int exportKey(boolean r100, ByteArrayOutputStream r101, ByteArrayOutputStream r102) {
        return exportKeyNative(r100, r101, r102);
    }

    public int sign(boolean r100, byte[] r101, ByteArrayOutputStream r102) {
        return signNative(r100, r101, r102);
    }

    public int verify(boolean r100, byte[] r101, byte[] r102) {
        return verifyNative(r100, r101, r102);
    }
}
