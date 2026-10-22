package com.bytedance.crypto.cloudtrans.response;

import android.util.Log;
import com.bytedance.crypto.cloudtrans.CloudDskBody;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.LogUtils;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DSKExchangeResponse {
    private static String DSK_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/ex";
    private static String DSK_RESULT_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/exResult";
    private static String DSK_RESULT_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/exResult";
    private static String DSK_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/ex";
    public static String SIGN_PUBLIC_KEY_BOE = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEveLhMZvIaKypKND3AGzpwpAVWXHh\nhaiHQN6/WMgq2jE4vBR/6L0gO7ubgoU1Q1Yh9Q/qwz0+w6RN5rp0j13RiQ==\n-----END PUBLIC KEY-----";
    public static String SIGN_PUBLIC_KEY_PRO = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEKALR6oZdBB8SHBCGj4XZDseXEIHo\nIIcL77rmRu6i97Ui5NDAFtTjjbyQPn7WayyZ0uTlMUIGyzdfIg1LLP1SZg==\n-----END PUBLIC KEY-----";
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_SUCCESS = 1;
    private static final String TAG = "DSKExchangeResponse";
    private final String publicKey;
    private final String resultUrl;
    private final String url;

    public DSKExchangeResponse() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L5;
        this.url = DSK_BOE_URL;
        this.resultUrl = DSK_RESULT_BOE_URL;
        String r0 = SIGN_PUBLIC_KEY_BOE;
    L6:
        this.publicKey = r0;
        return;
    L5:
        this.url = DSK_URL;
        this.resultUrl = DSK_RESULT_URL;
        r0 = SIGN_PUBLIC_KEY_PRO;
        goto L6
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public String constructBodyJson(String r2, String r3, long r4, int r6) {
        JSONObject r1 = new JSONObject();
        r1.put("app_id", r2);     // Catch: Exception -> L6
        r1.put("did", r3);     // Catch: Exception -> L6
        r1.put("key_version", r4);     // Catch: Exception -> L6
        r1.put("status", r6);     // Catch: Exception -> L6
        return r1.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("constructBodyJson failed, " + e.getMessage());
    }

    public String dskExchangeByCert(String r4) {
        ad r3 = new z().a(new ab.a().a(this.url).b(DownloadHelper.CONTENT_TYPE, "application/json").b("x-att-certchain", r4).a(ac.a(x.b("application/json; charset=utf-8"), "{}")).b()).b();     // Catch: Exception -> L12
        if (r3.n() == false) goto L11;
        if (r3.g() != null) goto L7;
        return null;
    L7:
        return r3.g().f();
    L11:
        throw new IOException("Unexpected code " + r3);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeByTempKey(String r3, String r4) {
        ad r2 = new z().a(new ab.a().a(this.url).b(DownloadHelper.CONTENT_TYPE, "application/json").b("x-client-pubkey", r3).a(ac.a(x.b("application/json; charset=utf-8"), r4)).b()).b();     // Catch: Exception -> L12
        if (r2.n() == true) goto L5;
        LogUtils.d(TAG, "responseBody:" + r2.g().f());     // Catch: Exception -> L12
        throw new IOException("Unexpected code " + r2);     // Catch: Exception -> L12
    L5:
        if (r2.g() != null) goto L7;
        return null;
    L7:
        return r2.g().f();
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeResult(String r3) {
        ad r2 = new z().a(new ab.a().a(this.resultUrl).b(DownloadHelper.CONTENT_TYPE, "application/json").a(ac.a(x.b("application/json; charset=utf-8"), r3)).b()).b();     // Catch: Exception -> L12
        if (r2.n() == false) goto L11;
        if (r2.g() != null) goto L7;
        return null;
    L7:
        return r2.g().f();
    L11:
        throw new IOException("Unexpected code " + r2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        throw new CloudTransException("dskExchangeResult failed, " + e.getMessage());
    }

    public String getPlublicKey() {
        return this.publicKey;
    }

    public CloudDskBody jsonParsing(String r4) {
        CloudDskBody r3 = new CloudDskBody();
        r3.bodyJson = r4;
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L9
        int r5 = r0.getInt(MonitorConstants.CODE);     // Catch: Exception -> L9
        r3.code = r5;     // Catch: Exception -> L9
        if (r5 != 200) goto L7;
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_response_DSKExchangeResponse_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Request success!");     // Catch: Exception -> L9
        r3.msg = r0.getString("msg");     // Catch: Exception -> L9
        r3.logId = r0.getString("log_id");     // Catch: Exception -> L9
        JSONObject r6 = r0.getJSONObject("data");     // Catch: Exception -> L9
        r3.data.cloudPublicKey = r6.getString("cloud_public_key");     // Catch: Exception -> L9
        r3.data.sharedKeyHash = r6.getString("shared_key_hash");     // Catch: Exception -> L9
        r3.data.keyVersion = r6.getLong("key_version");     // Catch: Exception -> L9
        r3.data.expectExpiryTime = r6.getLong("expect_expiry_time");     // Catch: Exception -> L9
        r3.data.signature = r6.getString("signature");     // Catch: Exception -> L9
    L8:
        return r3;
    L7:
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_response_DSKExchangeResponse_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Request failed, error: " + r5);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        r3.code = -1;
        throw new CloudTransException("parse body json failed, " + e.getMessage());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_crypto_cloudtrans_response_DSKExchangeResponse_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_crypto_cloudtrans_response_DSKExchangeResponse_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
