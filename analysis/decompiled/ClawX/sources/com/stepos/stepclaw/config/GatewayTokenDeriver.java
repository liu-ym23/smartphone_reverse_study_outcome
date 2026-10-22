package com.stepos.stepclaw.config;

import a6.z;
import a8.b;
import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/config/GatewayTokenDeriver;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "APP_SALT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DATA_PREFIX", "derive", "deviceId", "salt", "maskToken", GatewayAuthConstants.AUTH_MODE, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayTokenDeriver {
    public static final String APP_SALT = "stepclaw-gateway-token-salt-v1";
    private static final String DATA_PREFIX = "stepclaw-gateway-v1";
    public static final GatewayTokenDeriver INSTANCE = new GatewayTokenDeriver();

    private GatewayTokenDeriver() {
    }

    public static /* synthetic */ String derive$default(GatewayTokenDeriver gatewayTokenDeriver, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = APP_SALT;
        }
        return gatewayTokenDeriver.derive(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence derive$lambda$0(byte b9) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
    }

    public final String derive(String deviceId, String salt) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        p.e(deviceId, "deviceId");
        p.e(salt, "salt");
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.d(UTF_8, "UTF_8");
        byte[] bytes = salt.getBytes(UTF_8);
        p.d(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = "stepclaw-gateway-v1|".concat(deviceId).getBytes(UTF_8);
        p.d(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        p.d(bArrDoFinal, "doFinal(...)");
        return l.h0(bArrDoFinal, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, new z(25), 30);
    }

    public final String maskToken(String token) {
        p.e(token, "token");
        return token.length() <= 8 ? "****" : b.o(n.Q1(4, token), "...", n.R1(4, token));
    }
}
