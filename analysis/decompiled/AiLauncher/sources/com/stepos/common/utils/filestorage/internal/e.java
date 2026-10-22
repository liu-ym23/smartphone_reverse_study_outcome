package com.stepos.common.utils.filestorage.internal;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u0004*\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/e;", "", "<init>", "()V", "", "appId", Parameters.UXIP_REQUEST_PARAM_NONCE, "timestamp", "secret", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "c", "", Const.INTENT_KEY_UMID, "([B)Ljava/lang/String;", "ALGORITHM", "Ljava/lang/String;", "Ljava/security/SecureRandom;", "random", "Ljava/security/SecureRandom;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    private static final String ALGORITHM = "HmacSHA256";
    public static final e INSTANCE = new e();
    private static final SecureRandom random = new SecureRandom();

    public final String a() {
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        return d(bArr);
    }

    public final String b(String appId, String nonce, String timestamp, String secret) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.i(appId, "appId");
        p.i(nonce, "nonce");
        p.i(timestamp, "timestamp");
        p.i(secret, "secret");
        String str = appId + nonce + timestamp + secret;
        Mac mac = Mac.getInstance(ALGORITHM);
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.h(UTF_8, "UTF_8");
        byte[] bytes = secret.getBytes(UTF_8);
        p.h(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, ALGORITHM));
        p.h(UTF_8, "UTF_8");
        byte[] bytes2 = str.getBytes(UTF_8);
        p.h(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        p.f(bArrDoFinal);
        return d(bArrDoFinal);
    }

    public final String c() {
        return String.valueOf(System.currentTimeMillis());
    }

    public final String d(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }
}
