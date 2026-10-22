package com.bytedance.crypto.network;

import com.bytedance.crypto.utils.LogUtils;
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
    private static final String TAG = "ChallengeManager";

    public ChallengeManager() {
    }

    private static String getChallenge(String r3) {
        return new JSONObject(new JSONObject(r3).getString(JSON_TAG_DATA)).getString(JSON_TAG_NONCE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getChallenge exception:" + e.getMessage());
        return "";
    }

    private static String getChallengeFromServer() {
        z r0 = new z();
        ab r1 = new ab.a().a(getRequestUrl()).a().b();
        String r2 = TAG;
        LogUtils.i(r2, "Request:" + r1.toString());
        LogUtils.d(r2, "Request body:" + r1.d());
        ad r3 = r0.a(r1).b();     // Catch: Exception -> L8
        if (r3.n() == false) goto L6;
        String r4 = r3.g().f();     // Catch: Exception -> L8
        LogUtils.i(r2, "response:" + r3.toString());     // Catch: Exception -> L8
        LogUtils.d(r2, "response body:" + r4);     // Catch: Exception -> L8
        return parseChallenge(r4);
    L6:
        LogUtils.i(r2, "newCall failed!! response:" + r3.toString());     // Catch: Exception -> L8
        LogUtils.i(r2, "newCall failed!! response body:" + r3.g().f());     // Catch: Exception -> L8
    L10:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static String getRequestUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_CHALLENGE_URL_BOE;
    L6:
        return GET_CHALLENGE_URL;
    }

    private static int getResponseCode(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception:" + e.getMessage());
        return 400;
    }

    private static String parseChallenge(String r3) {
        int r0 = getResponseCode(r3);
        if (r0 >= 200) goto L5;
    L10:
        return "";
    L5:
        if (r0 >= 300) goto L10;
        return getChallenge(r3);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "parseChallenge exception:" + e.getMessage());
        goto L10
    }

    public static String requestChallenge() {
        return getChallengeFromServer();
    }
}
