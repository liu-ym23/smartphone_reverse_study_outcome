package cn.com.infosec.mobile.isec;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class IsecHMAC extends IsecBase {
    private static native int HMACNative(IsecHash.HashAlgEnum r100, byte[] r101, byte[] r102, ByteArrayOutputStream r103);

    public IsecHMAC() {
    }

    public static int HMAC(IsecHash.HashAlgEnum r100, byte[] r101, byte[] r102, ByteArrayOutputStream r103) {
        return HMACNative(r100, r101, r102, r103);
    }
}
