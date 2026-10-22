package com.bytedance.privacy.network;

import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeManager {
    private static final String GET_CHALLENGE_URL = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    private static final String GET_CHALLENGE_URL_BOE = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_NONCE = "nonce";
    private static final int MAX_RETRY = 3;
    private static final String TAG = "ChallengeManager";
    private static final z client = null;

    public ChallengeManager() {
    }

    static {
        client = new z();
    }

    public static String requestChallenge() {
        return getChallengeFromServer();
    }

    private static String getRequestUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_CHALLENGE_URL_BOE;
    L6:
        return GET_CHALLENGE_URL;
    }

    private static String getChallengeFromServer() {
        ab r1 = new ab.a().a(getRequestUrl()).a().b();
        String r2 = TAG;
        LogUtils.d(r2, "Challenge Request:" + r1.toString());
        LogUtils.d(r2, "Challenge Request body:" + r1.d());
        int r3 = 1;
        String r4 = "";
    L4:
        if (r3 > 3) goto L42;
        ad r6 = client.a(r1).b();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r6 != null) goto L44;
    L29:
        throw th;     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L44:
        r6.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
        goto L29
    L7:
        if (r6.g() == null) goto L9;
        String r7 = r6.g().f();     // Catch: Throwable -> L21
    L12:
        if (r6.n() == true) goto L13;
        String r8 = TAG;     // Catch: Throwable -> L21
        LogUtils.e(r8, "Challenge Attempt " + r3 + ": Response failed, code = " + r6.d());     // Catch: Throwable -> L21
        LogUtils.e(r8, "Challenge Response body:" + r7);     // Catch: Throwable -> L21
        if (r6 == null) goto L38;
        r6.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
    L38:
        if (r3 >= 3) goto L41;
        Thread.sleep(500);     // Catch: InterruptedException -> L43
    L41:
        r3 = r3 + 1;
        goto L4
    L13:
        String r9 = TAG;     // Catch: Throwable -> L21
        LogUtils.d(r9, "Challenge Response received successfully");     // Catch: Throwable -> L21
        LogUtils.d(r9, "Challenge Response body:" + r7);     // Catch: Throwable -> L21
        r4 = parseChallenge(r7);     // Catch: Throwable -> L21
        if (r6 == null) goto L42;
        r6.close();     // Catch: Exception -> L30 IOException -> L32 ConnectException -> L34 SocketTimeoutException -> L36
        goto L42
    L9:
        r7 = "";
    L34:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": ConnectException (connect timeout): " + e.getMessage());
    L36:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L32:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": IOException: " + e.getMessage());
    L30:
        e = move-exception;
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Unexpected exception: ", e);
        e.printStackTrace();
    L42:
        return r4;
    }

    private static int getResponseCode(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private static String getChallenge(String r3) {
        return new JSONObject(new JSONObject(r3).getString(JSON_TAG_DATA)).getString(JSON_TAG_NONCE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getChallenge exception: " + e.getMessage());
        return "";
    }

    private static String parseChallenge(String r4) {
        int r0 = getResponseCode(r4);
        if (r0 >= 200) goto L5;
        return "";
    L5:
        if (r0 >= 300) goto L14;
        return getChallenge(r4);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "parseChallenge exception: " + e.getMessage());
        return "";
    L14:
        return "";
    }
}
