package com.stepos.pps.data.net;

import android.content.Context;
import com.stepos.pps.data.util.LogUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class OkHttpHelper {
    private static final String TAG = "OkHttpHelper";
    private static OkHttpClient client;
    private static final Object lock = new Object();
    private static volatile OkHttpHelper sInstance;

    public static OkHttpHelper get(Context context) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new OkHttpHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private OkHttpHelper(Context context) throws NoSuchAlgorithmException, IOException, CertificateException {
        OkHttpClient.Builder builderEventListener = new OkHttpClient.Builder().callTimeout(10L, TimeUnit.MINUTES).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.MINUTES).writeTimeout(10L, TimeUnit.MINUTES).eventListener(new EventListener(this) { // from class: com.stepos.pps.data.net.OkHttpHelper.1
            @Override // okhttp3.EventListener
            public void callStart(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "callStart: request start");
            }

            @Override // okhttp3.EventListener
            public void dnsStart(Call call, String str) {
                LogUtil.d(OkHttpHelper.TAG, "dnsStart: domain " + str + " resolution");
            }

            @Override // okhttp3.EventListener
            public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                LogUtil.d(OkHttpHelper.TAG, "connectStart: " + inetSocketAddress);
            }

            @Override // okhttp3.EventListener
            public void secureConnectStart(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "secureConnectStart: SSL Handshake");
            }

            @Override // okhttp3.EventListener
            public void requestHeadersStart(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "requestHeadersStart: post Header");
            }

            @Override // okhttp3.EventListener
            public void requestBodyStart(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "requestBodyStart: post Body (upload file)");
            }

            @Override // okhttp3.EventListener
            public void responseHeadersStart(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "responseHeadersStart: receive response (server received the request)");
            }

            @Override // okhttp3.EventListener
            public void callEnd(Call call) {
                LogUtil.d(OkHttpHelper.TAG, "callEnd: request and post end");
            }

            @Override // okhttp3.EventListener
            public void callFailed(Call call, IOException iOException) {
                LogUtil.e(OkHttpHelper.TAG, "callFailed: request erro : " + iOException.getMessage());
            }
        });
        try {
            KeyStore.getInstance(KeyStore.getDefaultType()).load(null);
            builderEventListener.hostnameVerifier(DsHostnameVerifier.INSTANCE);
            builderEventListener.proxy(Proxy.NO_PROXY);
        } catch (IOException e) {
            LogUtil.e(TAG, e.getMessage());
        } catch (KeyStoreException e2) {
            LogUtil.e(TAG, e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            LogUtil.e(TAG, e3.getMessage());
        } catch (CertificateException e4) {
            LogUtil.e(TAG, e4.getMessage());
        }
        client = builderEventListener.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String post(java.lang.String r3, okhttp3.RequestBody r4) {
        /*
            r2 = this;
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.Request$Builder r2 = r2.url(r3)
            okhttp3.Request$Builder r2 = r2.post(r4)
            okhttp3.Request r2 = r2.build()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "post url: "
            r4.<init>(r0)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "OkHttpHelper"
            com.stepos.pps.data.util.LogUtil.d(r0, r4)
            okhttp3.OkHttpClient r4 = com.stepos.pps.data.net.OkHttpHelper.client     // Catch: java.lang.NullPointerException -> L2f java.io.IOException -> L38
            okhttp3.Call r2 = r4.newCall(r2)     // Catch: java.lang.NullPointerException -> L2f java.io.IOException -> L38
            okhttp3.Response r2 = r2.execute()     // Catch: java.lang.NullPointerException -> L2f java.io.IOException -> L38
            goto L41
        L2f:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.stepos.pps.data.util.LogUtil.e(r0, r2)
            goto L40
        L38:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.stepos.pps.data.util.LogUtil.e(r0, r2)
        L40:
            r2 = 0
        L41:
            if (r2 == 0) goto L93
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "got response "
            r4.<init>(r1)
            int r1 = r2.code()
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.stepos.pps.data.util.LogUtil.d(r0, r4)
            int r4 = r2.code()
            r1 = 200(0xc8, float:2.8E-43)
            if (r4 != r1) goto La4
            okhttp3.ResponseBody r4 = r2.body()     // Catch: java.lang.NullPointerException -> L6f java.io.IOException -> L75
            if (r4 == 0) goto La4
            okhttp3.ResponseBody r4 = r2.body()     // Catch: java.lang.NullPointerException -> L6f java.io.IOException -> L75
            java.lang.String r2 = r4.string()     // Catch: java.lang.NullPointerException -> L6f java.io.IOException -> L75
            return r2
        L6f:
            java.lang.String r2 = "executeHttpPost, NullPointerException"
            com.stepos.pps.data.util.LogUtil.e(r0, r2)
            goto La4
        L75:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "executeHttpPost, rescode="
            r4.<init>(r1)
            int r2 = r2.code()
            r4.append(r2)
            java.lang.String r2 = ", url="
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            com.stepos.pps.data.util.LogUtil.e(r0, r2)
            goto La4
        L93:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "executeHttpPost, response null, url="
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.stepos.pps.data.util.LogUtil.d(r0, r2)
        La4:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.net.OkHttpHelper.post(java.lang.String, okhttp3.RequestBody):java.lang.String");
    }
}
