package com.stepos.core.common.cloud;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GatewayAuthSigner {
    private static final String HMAC_SHA256 = "HmacSHA256";
    public static final GatewayAuthSigner INSTANCE = new GatewayAuthSigner();

    private GatewayAuthSigner() {
    }

    private final String bytesToHex(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String sign(String appId, String nonce, String timestamp, String appSecret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        kotlin.jvm.internal.g.f(appId, "appId");
        kotlin.jvm.internal.g.f(nonce, "nonce");
        kotlin.jvm.internal.g.f(timestamp, "timestamp");
        kotlin.jvm.internal.g.f(appSecret, "appSecret");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(appId);
        String strP = ai.onnxruntime.a.p(sb2, nonce, timestamp, appSecret);
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = gc.a.f9106b;
        byte[] bytes = appSecret.getBytes(charset);
        kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = strP.getBytes(charset);
        kotlin.jvm.internal.g.e(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        kotlin.jvm.internal.g.e(bArrDoFinal, "doFinal(...)");
        return bytesToHex(bArrDoFinal);
    }
}
