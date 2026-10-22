package cn.com.chinatelecom.account;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes28.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24452a = "RSA/ECB/PKCS1Padding";

    public static String a(String r100, RSAPublicKey r101) {
        return b0.a(a(r101, r100.getBytes()));
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static PublicKey a(String r100) {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(c.a(r100));
        return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(r101);
    }

    public static byte[] a(RSAPublicKey r100, byte[] r101) {
        if (r100 == null) goto L18;
        Cipher r102 = Cipher.getInstance(f24452a);     // Catch: BadPaddingException -> L6 IllegalBlockSizeException -> L8 InvalidKeyException -> L10 NoSuchPaddingException -> L12 NoSuchAlgorithmException -> L15
        r102.init(1, r100);     // Catch: BadPaddingException -> L6 IllegalBlockSizeException -> L8 InvalidKeyException -> L10 NoSuchPaddingException -> L12 NoSuchAlgorithmException -> L15
        return r102.doFinal(r101);
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        throw new Exception(h0.a(new byte[]{-17, ByteCompanionObject.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, -104, -81, -29, -105, -108, -20, -71, -97, 38, -30, -91, -67, -20, -87, -118, -20, -107, -81}));
    L16:
        throw new Exception(h0.a(new byte[]{-20, -99, -86, -20, -89, -82, -17, ByteCompanionObject.MIN_VALUE, -86, -17, -91, -116, -19, -92, -99, -20, -71, -97}));
    L7:
        throw new Exception(h0.a(new byte[]{-20, -110, -124, -20, -100, -115, -20, -97, -70, -20, -121, -92, -17, -67, -72, -20, -121, -107, -17, -105, -123}));
    L9:
        throw new Exception(h0.a(new byte[]{-20, -110, -124, -20, -100, -115, -29, -97, -75, -17, -80, -84, -29, -105, -108, -20, -71, -97}));
    L18:
        throw new Exception(h0.a(new byte[]{-17, ByteCompanionObject.MIN_VALUE, -86, -17, -91, -116, -17, -113, -90, -29, -104, -81, -18, -78, -80, -19, -93, -80, 38, 42, -30, -91, -67, -30, -92, -76, -19, -73, -92}));
    }
}
