package cn.com.infosec.mobile.isec;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class IsecCrypto {
    public static int errCode;

    public IsecCrypto() {
    }

    private static native int base64DecodeNative(String r100, ByteArrayOutputStream r101);

    private static native String base64EncodeNative(byte[] r100, int r101);

    private static native int genRandomNative(int r100, ByteArrayOutputStream r101);

    private static native int messageDecryptNative(byte[] r100, ByteArrayOutputStream r101);

    private static native int messageEncryptNative(byte[] r100, byte[] r101, ByteArrayOutputStream r102);

    public static int base64Decode(String r100, ByteArrayOutputStream r101) {
        return base64DecodeNative(r100, r101);
    }

    public static String base64Encode(byte[] r100, int r101) {
        return base64EncodeNative(r100, r101);
    }

    public static int genRandom(int r100, ByteArrayOutputStream r101) {
        return genRandomNative(r100, r101);
    }

    public static int messageDecrypt(byte[] r100, ByteArrayOutputStream r101) {
        return messageDecryptNative(r100, r101);
    }

    public static int messageEncrypt(byte[] r100, byte[] r101, ByteArrayOutputStream r102) {
        return messageEncryptNative(r100, r101, r102);
    }
}
