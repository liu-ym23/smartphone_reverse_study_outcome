package com.stepos.stepclaw.base.util;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/base/util/HmacSha256Utils;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "HMAC_SHA256_ALGORITHM", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sign", OperationResult.EXTRA_MESSAGE, "secret", "verify", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "signature", "bytesToHex", "bytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HmacSha256Utils {
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    public static final HmacSha256Utils INSTANCE = new HmacSha256Utils();

    private HmacSha256Utils() {
    }

    private final String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b9 : bytes) {
            String hexString = Integer.toHexString(b9 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        p.d(string, "toString(...)");
        return string;
    }

    public final String sign(String message, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.e(message, "message");
        p.e(secret, "secret");
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.d(UTF_8, "UTF_8");
        byte[] bytes = secret.getBytes(UTF_8);
        p.d(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, HMAC_SHA256_ALGORITHM));
        p.d(UTF_8, "UTF_8");
        byte[] bytes2 = message.getBytes(UTF_8);
        p.d(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        p.b(bArrDoFinal);
        return bytesToHex(bArrDoFinal);
    }

    public final boolean verify(String message, String secret, String signature) {
        p.e(message, "message");
        p.e(secret, "secret");
        p.e(signature, "signature");
        try {
            String strSign = sign(message, secret);
            Charset UTF_8 = StandardCharsets.UTF_8;
            p.d(UTF_8, "UTF_8");
            byte[] bytes = strSign.getBytes(UTF_8);
            p.d(bytes, "getBytes(...)");
            p.d(UTF_8, "UTF_8");
            byte[] bytes2 = signature.getBytes(UTF_8);
            p.d(bytes2, "getBytes(...)");
            return MessageDigest.isEqual(bytes, bytes2);
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return false;
        }
    }
}
