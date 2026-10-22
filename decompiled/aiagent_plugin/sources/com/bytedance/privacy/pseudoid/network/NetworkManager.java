package com.bytedance.privacy.pseudoid.network;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.utils.LogUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkManager {
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_MSG = "msg";
    private static final String JSON_TAG_RP_DID = "rpdid";
    private static final String JSON_TAG_RP_UID = "rpuid";
    private static final int MAX_RETRY = 3;
    private static String PSEUDO_ID_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    private static String PSEUDO_ID_URL = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
    public static final String REQUEST_TYPE_POST = "POST";
    private static final String TAG = "NetworkManager";
    private static final z client = null;
    private static volatile NetworkManager networkManager;

    public NetworkManager() {
    }

    static {
        client = new z();
    }

    public static NetworkManager getInstance() {
        if (networkManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (networkManager != null) goto L9;
        networkManager = new NetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return networkManager;
    }

    public static String getPseudoIDUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L7;
        return PSEUDO_ID_BOE_URL;
    L7:
        return PSEUDO_ID_URL;
    }

    private int getResponseCode(String r3) {
        return new JSONObject(r3).getInt("code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception: " + e.getMessage());
        return 400;
    }

    private String getResponseMsg(String r3) {
        return new JSONObject(r3).getString(JSON_TAG_MSG);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseMsg exception: " + e.getMessage());
        return "";
    }

    private PseudoID getPseudoID(String r3) {
        JSONObject r0 = new JSONObject(new JSONObject(r3).getString(JSON_TAG_DATA));     // Catch: Exception -> L5
        return new PseudoID(r0.optString(JSON_TAG_RP_DID, ""), r0.optString(JSON_TAG_RP_UID, ""));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "getPseudoID exception: " + e.getMessage());
        return null;
    }

    private NetworkResponse buildNetworkResponse(String r6) {
        int r0 = getResponseCode(r6);
        String r1 = getResponseMsg(r6);
        PseudoID r3 = null;
        if (r0 < 200) goto L11;
        if (r0 >= 300) goto L11;
        r3 = getPseudoID(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        LogUtils.e(TAG, "buildNetworkResponse exception: " + e.getMessage());
    L11:
        return new NetworkResponse(r0, r1, r3);
    }

    private ab buildOkHttpRequest(NetworkRequest r10) {
        ac r0 = ac.a(x.c("application/json"), "{}");
        Map<String, String> r1 = AccountApi.INSTANCE.getXttTokenMap();
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "xttTokenMap entry key:" + ((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return new ab.a().a(r10.getRequestUrl()).a(r10.getRequestType(), r0).a(u.a(r1)).b(DownloadHelper.CONTENT_TYPE, "application/json").b("x-att-certchain", r10.getCertChain()).b();
    }

    public NetworkResponse executeRequest(NetworkRequest r13) {
        String r1 = TAG;
        LogUtils.d(r1, "executeRequest enter");
        ab r14 = buildOkHttpRequest(r13);
        LogUtils.d(r1, "PseudoID Request:" + r14.toString());
        LogUtils.d(r1, "PseudoID Request body:" + r14.d());
        NetworkResponse r2 = new NetworkResponse(400, "", null);
        int r3 = 1;
    L4:
        if (r3 > 3) goto L51;
        ad r6 = client.a(r14).b();     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (r6 != null) goto L59;
    L38:
        throw th;     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
    L59:
        r6.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
        goto L38
    L7:
        if (r6.g() == null) goto L9;
        String r7 = r6.g().f();     // Catch: Throwable -> L30
    L12:
        if (r6.n() == true) goto L13;
        String r8 = TAG;     // Catch: Throwable -> L30
        LogUtils.e(r8, "PseudoID Attempt " + r3 + ": Response failed, code = " + r6.d());     // Catch: Throwable -> L30
        LogUtils.e(r8, "PseudoID Response body:" + r7);     // Catch: Throwable -> L30
        NetworkResponse r9 = new NetworkResponse(r6.d(), r6.c(), null);     // Catch: Throwable -> L30
        if (r6 != null) goto L61;
    L29:
        r2 = r9;
    L47:
        if (r3 >= 3) goto L50;
        Thread.sleep(500);     // Catch: InterruptedException -> L52
    L50:
        r3 = r3 + 1;
        goto L4
    L61:
        r6.close();     // Catch: Exception -> L21 IOException -> L23 ConnectException -> L25 SocketTimeoutException -> L27
    L25:
        e = e;
        r2 = r9;
    L44:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": ConnectException (connect timeout): " + e.getMessage());
    L27:
        e = e;
        r2 = r9;
    L46:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L23:
        e = e;
        r2 = r9;
    L42:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": IOException: " + e.getMessage());
    L21:
        e = e;
        r2 = r9;
    L40:
        LogUtils.e(TAG, "Challenge Attempt " + r3 + ": Unexpected exception: " + e.getMessage());
        goto L47
    L13:
        String r10 = TAG;     // Catch: Throwable -> L30
        LogUtils.d(r10, "PseudoID Response received successfully");     // Catch: Throwable -> L30
        LogUtils.d(r10, "PseudoID Response body:" + r7);     // Catch: Throwable -> L30
        r2 = buildNetworkResponse(r7);     // Catch: Throwable -> L30
        if (r6 == null) goto L51;
        r6.close();     // Catch: Exception -> L39 IOException -> L41 ConnectException -> L43 SocketTimeoutException -> L45
        goto L51
    L9:
        r7 = "";
    L43:
        e = e;
    L45:
        e = e;
    L41:
        e = e;
    L39:
        e = e;
    L51:
        return r2;
    }
}
