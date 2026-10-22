package com.obric.network.ttnet;

import android.app.Application;
import android.content.Context;
import com.GlobalProxyLancet;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetInitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/network/ttnet/TTNetInitHelper;", "", "()V", "TAG", "", "sMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "initTTNet", "", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "packageRequestParamters", AlogMonitor.ALOG_RESULT_INFO, "jsonObject", "Lorg/json/JSONObject;", "InnerApiProcessHook", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TTNetInitHelper {
    public static final TTNetInitHelper INSTANCE = null;
    private static final String TAG = "TTNetInitHelper";
    private static final NetworkParams.MonitorProcessHook<HttpRequestInfo> sMonitorProcessHook = null;

    /* JADX INFO: compiled from: TTNetInitHelper.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J1\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u001c\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J$\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/network/ttnet/TTNetInitHelper$InnerApiProcessHook;", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addCommonParams", "", "url", "isApi", "", "addRequestVertifyParams", "isAddCommonParam", "extra", "", "", "(Ljava/lang/String;Z[Ljava/lang/Object;)Ljava/lang/String;", "getCommonParamsByLevel", "", "level", "", "handleApiError", "", "e", "", DBHelper.COL_TIME, "", AlogMonitor.ALOG_RESULT_INFO, "handleApiOk", "onTryInit", "putCommonParams", "params", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InnerApiProcessHook implements NetworkParams.ApiProcessHook<HttpRequestInfo> {
        private final Context context;

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addRequestVertifyParams(String r1, boolean r2, Object... r3) {
            Intrinsics.checkNotNullParameter(r1, "url");
            Intrinsics.checkNotNullParameter(r3, "extra");
            return r1;
        }

        public void handleApiOk(String r1, long r2, HttpRequestInfo r4) {
            Intrinsics.checkNotNullParameter(r1, "url");
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void onTryInit() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void putCommonParams(Map<String, String> r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "params");
        }

        public InnerApiProcessHook(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiError(String r1, Throwable r2, long r3, BaseHttpRequestInfo r5) {
            handleApiError(r1, r2, r3, (HttpRequestInfo) r5);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiOk(String r1, long r2, BaseHttpRequestInfo r4) {
            handleApiOk(r1, r2, (HttpRequestInfo) r4);
        }

        public void handleApiError(String r1, Throwable r2, long r3, HttpRequestInfo r5) {
            Intrinsics.checkNotNullParameter(r1, "url");
            Intrinsics.checkNotNullParameter(r2, "e");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TTNetInitHelper.TAG, "handleApiError", r2);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addCommonParams(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "url");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TTNetInitHelper.TAG, "addCommonParams url " + r1);
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public Map<String, String> getCommonParamsByLevel(int r1) {
            return new HashMap();
        }
    }

    private TTNetInitHelper() {
    }

    public static final /* synthetic */ void access$packageRequestParamters(TTNetInitHelper r0, HttpRequestInfo r1, JSONObject r2) {
        r0.packageRequestParamters(r1, r2);
    }

    public final void initTTNet(Context r10, Application r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "application");
        MessageLoop.disableVaildThreadAssert(true);     // Catch: Throwable -> L5
        TTNetCronetDependAdapter.INSTANCE.inJect();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new TTNetDepend(r10));     // Catch: Throwable -> L5
        TTNetInit.setBypassOfflineCheck(true);     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r10, r11, new InnerApiProcessHook(r10), sMonitorProcessHook, null, true, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(TTNetCronetDependAdapter.INSTANCE);     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initTTNet success");     // Catch: Throwable -> L5
    L7:
        NetworkClient.setDefault(new SSNetworkClient());
        return;
    L5:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "initTTNet error", th);
        goto L7
    }

    static {
        INSTANCE = new TTNetInitHelper();
        sMonitorProcessHook = new TTNetInitHelper$sMonitorProcessHook$1();
    }

    private final void packageRequestParamters(HttpRequestInfo r3, JSONObject r4) {
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        r4.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: JSONException -> L13
        r4.put("appLevelRequestStart", r3.appLevelRequestStart);     // Catch: JSONException -> L13
        r4.put("beforeAllInterceptors", r3.beforeAllInterceptors);     // Catch: JSONException -> L13
        r4.put("requestStart", r3.requestStart);     // Catch: JSONException -> L13
        r4.put("responseBack", r3.responseBack);     // Catch: JSONException -> L13
        r4.put("completeReadResponse", r3.completeReadResponse);     // Catch: JSONException -> L13
        r4.put("requestEnd", r3.requestEnd);     // Catch: JSONException -> L13
        r4.put("recycleCount", r3.recycleCount);     // Catch: JSONException -> L13
        if (r3.httpClientType != 0) goto L9;
        r4.put("timing_dns", r3.dnsTime);     // Catch: JSONException -> L13
        r4.put("timing_connect", r3.connectTime);     // Catch: JSONException -> L13
        r4.put("timing_ssl", r3.sslTime);     // Catch: JSONException -> L13
        r4.put("timing_send", r3.sendTime);     // Catch: JSONException -> L13
        r4.put("timing_waiting", r3.ttfbMs);     // Catch: JSONException -> L13
        r4.put("timing_receive", r3.receiveTime);     // Catch: JSONException -> L13
        r4.put("timing_total", r3.totalTime);     // Catch: JSONException -> L13
        r4.put("timing_isSocketReused", r3.isSocketReused);     // Catch: JSONException -> L13
        r4.put(TrafficConsts.KEY_SENT_BYTES, r3.sentByteCount);     // Catch: JSONException -> L13
        r4.put(TrafficConsts.KEY_RECEIVED_BYTES, r3.receivedByteCount);     // Catch: JSONException -> L13
        r4.put("timing_remoteIP", r3.remoteIp);     // Catch: JSONException -> L13
        r4.put("request_log", r3.requestLog);     // Catch: JSONException -> L13
    L9:
        if (r3.extraInfo == null) goto L11;
        r4.put("req_info", r3.extraInfo);     // Catch: JSONException -> L13
    L11:
        r4.put("streaming", r3.downloadFile);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "packageRequestParamters error:", e);
        return;
    L19:
        return;
    }
}
