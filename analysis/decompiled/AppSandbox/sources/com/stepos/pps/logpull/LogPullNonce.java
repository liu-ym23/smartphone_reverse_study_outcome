package com.stepos.pps.logpull;

import android.os.SystemProperties;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class LogPullNonce {
    private static final String PROP_NONCE_KEY = "persist.sys.logpull.noncekey";
    private static final String TAG = "LogPull.Nonce";

    private LogPullNonce() {
    }

    public static String getNonceKey() {
        return SystemProperties.get(PROP_NONCE_KEY, "");
    }

    public static long nowMs() {
        return System.currentTimeMillis();
    }

    public static String forCheck(String str, long j) {
        return md5(str + j + getNonceKey());
    }

    public static String forStatus(String str, long j, int i, long j2) {
        return md5(str + j + i + j2 + getNonceKey());
    }

    public static String forUploadUrl(String str, long j, long j2, long j3) {
        return md5(str + j + j2 + j3 + getNonceKey());
    }

    public static String forComplete(String str, long j, String str2, long j2, long j3) {
        return md5(str + j + str2 + j2 + j3 + getNonceKey());
    }

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e(TAG, "md5 failed", e);
            return "";
        }
    }
}
