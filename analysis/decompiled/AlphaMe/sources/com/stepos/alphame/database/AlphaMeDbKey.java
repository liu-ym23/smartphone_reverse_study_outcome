package com.stepos.alphame.database;

import android.security.keystore.KeyGenParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import kotlin.UByte;

/* loaded from: classes.dex */
final class AlphaMeDbKey {
    private static final String ALIAS = "com.stepos.alphame.db_hmac_v1";
    private static final String CONTEXT = "com.stepos.alphame/AlphaMe.db/v1";
    private static final String KEYSTORE = "AndroidKeyStore";

    private AlphaMeDbKey() {
    }

    private static byte[] deriveRawKey() throws Exception {
        SecretKey secretKeyGenerateKey;
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE);
        keyStore.load(null);
        if (keyStore.containsAlias(ALIAS)) {
            secretKeyGenerateKey = (SecretKey) keyStore.getKey(ALIAS, null);
            if (secretKeyGenerateKey == null) {
                throw new IllegalStateException("keystore alias exists but key is null");
            }
        } else {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256", KEYSTORE);
            keyGenerator.init(new KeyGenParameterSpec.Builder(ALIAS, 4).setDigests("SHA-256").build());
            secretKeyGenerateKey = keyGenerator.generateKey();
        }
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeyGenerateKey);
        return mac.doFinal(CONTEXT.getBytes(StandardCharsets.UTF_8));
    }

    public static String getKeySpec() throws Exception {
        return toSqlRawKey(deriveRawKey());
    }

    public static byte[] toKeyBytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    private static String toSqlRawKey(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b4 & UByte.MAX_VALUE)));
        }
        return "x'" + ((Object) sb) + "'";
    }
}
