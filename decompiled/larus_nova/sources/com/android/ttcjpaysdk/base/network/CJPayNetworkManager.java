package com.android.ttcjpaysdk.base.network;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayHostService;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import com.bytedance.caijing.sdk.infra.base.api.okhttp.OKHttpService;
import com.bytedance.caijing.sdk.infra.base.api.ttnet.TTNetService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.event.CJServerApiMonitor;
import com.bytedance.caijing.sdk.infra.base.event.DynamicEventTracker;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayNetworkManager {
    private static final int MAX_LENGTH = 5242880;
    private static final int NET_ERROR_CODE = -99;
    private static final String NET_ERROR_MESSAGE = "Weak connection, please check";
    private static final int NET_FAILED_WITH_THROWABLE_MSG = -1;
    private static final String TAG = "CJPayNetworkManager";
    private static Handler handler;
    private static volatile HandlerThread handlerThread;
    private static boolean isUsingTTNet;
    private static volatile Handler workerHandler;

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes28.dex */
    public class AnonymousClass1 implements te4.a {
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ ICJPayRawStringCallback val$callback;
        final /* synthetic */ Map val$fieldMap;
        final /* synthetic */ long val$firstTime;
        final /* synthetic */ Map val$headerMap;
        final /* synthetic */ String val$path;

        public static /* synthetic */ void a(String r100, te4.b r101) {
            lambda$onResponse$0(r100, r101);
        }

        @Override // te4.a
        public void onFailure(Throwable r100) {
            String r101 = this.val$path;
            Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
            DynamicEventTracker.c.b("wallet_rd_common_network_end", r101);
            CJPayNetworkManager.logServerApiStatus(this.val$path, null, r100);
            if (this.val$callback == null) goto L17;
            if (r100 == null) goto L6;
            JSONObject r103 = CJPayNetworkManager.generateFailureInfo(CJPayNetworkManager.access$100(r100), r100.getMessage(), r100);
        L7:
            ICJPayRawStringCallback r104 = this.val$callback;
            if (r103 == null) goto L10;
            String r105 = r103.toString();
        L11:
            r104.onFailure(r105);
            String r106 = this.val$baseUrl;
            Map r107 = this.val$headerMap;
            if (r107 == null) goto L14;
            String r108 = (String) r107.get("pb_test_vid");
        L15:
            CJPayNetworkManager.logNetworkError(r106, null, r100, r108);
            return;
        L14:
            r108 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L6:
            r103 = CJPayNetworkManager.generateFailureInfo(-99, "");
            goto L7
        }

        @Override // te4.a
        public void onResponse(final te4.b r100) {
            long r101 = System.currentTimeMillis() - this.val$firstTime;
            ICJPayRawStringCallback r102 = this.val$callback;
            String r103 = null;
            if (r102 == null) goto L8;
            if (r100 == null) goto L6;
            String r104 = r100.f545562b;
        L7:
            r102.onResponse(r104);
            goto L8
        L6:
            r104 = null;
        L8:
            Map r105 = this.val$fieldMap;
            Map r106 = this.val$headerMap;
            if (r106 == null) goto L11;
            r103 = (String) r106.get("pb_test_vid");
        L11:
            CJPayNetworkManager.access$000(r100, r101, r105, r103);
            String r107 = this.val$path;
            Lazy<DynamicEventTracker> r108 = DynamicEventTracker.f202325b;
            DynamicEventTracker.c.b("wallet_rd_common_network_end", r107);
            final String r109 = this.val$path;
            com.bytedance.caijing.sdk.infra.base.task.b.c(new a(r109, r100), 0);
        }

        private static /* synthetic */ void lambda$onResponse$0(String r100, te4.b r101) {
            CJPayNetworkManager.logServerApiStatus(r100, r101, null);
        }

        public AnonymousClass1(long r100, ICJPayRawStringCallback r101, Map r102, Map r103, String r104, String r105) {
            this.val$firstTime = r100;
            this.val$callback = r101;
            this.val$fieldMap = r102;
            this.val$headerMap = r103;
            this.val$path = r104;
            this.val$baseUrl = r105;
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$19, reason: invalid class name */
    public class AnonymousClass19 implements te4.a {
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ ICJPayCallback val$callback;
        final /* synthetic */ long val$firstTime;
        final /* synthetic */ Map val$headerMap;
        final /* synthetic */ boolean val$needMonitor;
        final /* synthetic */ String val$path;

        public static /* synthetic */ void a(ICJPayCallback r100, te4.b r101, JSONException r102) {
            lambda$onResponse$1(r100, r101, r102);
        }

        public static /* synthetic */ void b(ICJPayCallback r100) {
            lambda$onResponse$4(r100);
        }

        public static /* synthetic */ void c(ICJPayCallback r100, JSONObject r101) {
            lambda$onResponse$0(r100, r101);
        }

        public static /* synthetic */ void d(te4.b r100, String r101, ICJPayCallback r102) {
            lambda$onResponse$3(r100, r101, r102);
        }

        public static /* synthetic */ void e(ICJPayCallback r100, JSONException r101) {
            lambda$onResponse$2(r100, r101);
        }

        private static /* synthetic */ void lambda$onResponse$4(ICJPayCallback r100) {
            r100.onFailure(CJPayNetworkManager.generateFailureInfo(-99, "", null));
        }

        @Override // te4.a
        public void onFailure(Throwable r100) {
            String r101 = this.val$path;
            Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
            DynamicEventTracker.c.b("wallet_rd_common_network_end", r101);
            ICJPayCallback r103 = this.val$callback;
            if (r103 == null) goto L9;
            if (r100 == null) goto L6;
            r103.onFailure(CJPayNetworkManager.generateFailureInfo(CJPayNetworkManager.access$100(r100), r100.getMessage(), r100));
        L7:
            CJPayNetworkManager.logNetworkError(this.val$baseUrl, null, r100, null);
            return;
        L6:
            r103.onFailure(CJPayNetworkManager.generateFailureInfo(-99, ""));
            goto L7
        }

        @Override // te4.a
        public void onResponse(final te4.b r100) {
            String r101 = this.val$path;
            Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
            DynamicEventTracker.c.b("wallet_rd_common_network_end", r101);
            if (this.val$needMonitor == false) goto L6;
            CJPayNetworkManager.access$000(r100, System.currentTimeMillis() - this.val$firstTime, this.val$headerMap, null);
        L6:
            if (this.val$callback != null) goto L8;
            return;
        L8:
            if ("1".equals(CJPayABExperimentKeys.getCjPayHttpGetJsonParseOpt().value(true)) == false) goto L18;
            final String r103 = this.val$baseUrl;
            final ICJPayCallback r104 = this.val$callback;
            CJPayNetworkManager.access$400(new b(r100, r103, r104), new c(r104));
            return;
        L18:
            JSONObject r105 = new JSONObject(r100.f545562b);     // Catch: JSONException -> L12
            CJPayNetworkManager.access$300(r105.optJSONObject("response"), this.val$baseUrl);     // Catch: JSONException -> L12
            this.val$callback.onResponse(r105);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#setJSONFlag", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#setJSONFlag", e);
            if (r100 == null) goto L16;
            this.val$callback.onFailure(CJPayNetworkManager.generateFailureInfo(r100.f545561a, r100.f545562b, e));
            CJPayNetworkManager.logNetworkError(this.val$baseUrl, r100, null, null);
            return;
        L16:
            this.val$callback.onFailure(CJPayNetworkManager.generateFailureInfo(-99, "", e));
            CJPayNetworkManager.logNetworkError(this.val$baseUrl);
        }

        private static /* synthetic */ void lambda$onResponse$0(ICJPayCallback r100, JSONObject r101) {
            r100.onResponse(r101);
        }

        private static /* synthetic */ void lambda$onResponse$2(ICJPayCallback r100, JSONException r101) {
            r100.onFailure(CJPayNetworkManager.generateFailureInfo(-99, "", r101));
        }

        private static void lambda$onResponse$1(ICJPayCallback r100, te4.b r101, JSONException r102) {
            r100.onFailure(CJPayNetworkManager.generateFailureInfo(r101.f545561a, r101.f545562b, r102));
        }

        private static void lambda$onResponse$3(final te4.b r100, String r101, final ICJPayCallback r102) {
            final JSONObject r103 = new JSONObject(r100.f545562b);     // Catch: JSONException -> L4
            CJPayNetworkManager.access$300(r103.optJSONObject("response"), r101);     // Catch: JSONException -> L4
            CJPayNetworkManager.access$200().post(new d(r102, r103));     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#setJSONFlag", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#setJSONFlag", e);
            if (r100 == null) goto L8;
            CJPayNetworkManager.access$200().post(new e(r102, r100, e));
            CJPayNetworkManager.logNetworkError(r101, r100, null, null);
            return;
        L8:
            CJPayNetworkManager.access$200().post(new f(r102, e));
            CJPayNetworkManager.logNetworkError(r101);
        }

        public AnonymousClass19(String r100, boolean r101, long r102, Map r103, ICJPayCallback r104, String r105) {
            this.val$path = r100;
            this.val$needMonitor = r101;
            this.val$firstTime = r102;
            this.val$headerMap = r103;
            this.val$callback = r104;
            this.val$baseUrl = r105;
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$3, reason: invalid class name */
    /* JADX INFO: loaded from: classes28.dex */
    public class AnonymousClass3 implements ICJPayCallback {
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ ICJPayNetWorkCallback val$networkCallback;
        final /* synthetic */ ICJPayParserCallback val$payParserCallback;

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onFailure(JSONObject r100) {
            Runnable r101 = new AnonymousClass5(this);
            if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
            CJPayNetworkManager.access$200().post(r101);
            return;
        L5:
            r101.run();
        }

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onResponse(final JSONObject r100) {
            String r101 = CJPayNetworkManager.NET_ERROR_MESSAGE;
        L21:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#run", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#run", e);
            e.printStackTrace();
            ICJPayNetWorkCallback r102 = this.val$networkCallback;
            Context r103 = CJPayHostInfo.applicationContext;
            if (r103 == null) goto L25;
            r101 = r103.getResources().getString(R.string.cj_pay_network_exception);
        L25:
            r102.onFailure("-99", r101);
            return;
        L4:
            if (r100.has("error_code") == false) goto L10;
            ICJPayNetWorkCallback r104 = this.val$networkCallback;     // Catch: Exception -> L21
            Context r105 = CJPayHostInfo.applicationContext;     // Catch: Exception -> L21
            if (r105 == null) goto L8;
            String r106 = r105.getResources().getString(R.string.cj_pay_network_exception);     // Catch: Exception -> L21
        L9:
            r104.onFailure("-99", r106);     // Catch: Exception -> L21
            return;
        L8:
            r106 = CJPayNetworkManager.NET_ERROR_MESSAGE;
            goto L9
        L10:
            final JSONObject r107 = r100.optJSONObject("response");     // Catch: Exception -> L21
            if (r107 != null) goto L16;
            final Class r108 = (Class) ((ParameterizedType) this.val$networkCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];     // Catch: Exception -> L21
            ICJPayParserCallback r109 = this.val$payParserCallback;     // Catch: Exception -> L21
            if (r109 == null) goto L15;
            r109.onParseStart();     // Catch: Exception -> L21
        L15:
            CJPayNetworkManager.access$400(new AnonymousClass1(this, r100, r108), new AnonymousClass2(this));     // Catch: Exception -> L21
            return;
        L16:
            final Class r110 = (Class) ((ParameterizedType) this.val$networkCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];     // Catch: Exception -> L21
            ICJPayParserCallback r111 = this.val$payParserCallback;     // Catch: Exception -> L21
            if (r111 == null) goto L19;
            r111.onParseStart();     // Catch: Exception -> L21
        L19:
            CJPayNetworkManager.access$400(new RunnableC05303(this, r107, r110), new AnonymousClass4(this));     // Catch: Exception -> L21
        }

        public AnonymousClass3(ICJPayNetWorkCallback r100, ICJPayParserCallback r101, String r102) {
            this.val$networkCallback = r100;
            this.val$payParserCallback = r101;
            this.val$baseUrl = r102;
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$4, reason: invalid class name */
    /* JADX INFO: loaded from: classes28.dex */
    public class AnonymousClass4 implements ICJPayCallback {
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ ICJPayNetWorkRawCallback val$networkCallback;
        final /* synthetic */ ICJPayParserCallback val$payParserCallback;

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onFailure(JSONObject r100) {
            ICJPayNetWorkRawCallback r101 = this.val$networkCallback;
            Context r102 = CJPayHostInfo.applicationContext;
            if (r102 == null) goto L5;
            String r103 = r102.getResources().getString(R.string.cj_pay_network_exception);
        L6:
            r101.onFailure("-99", r103);
            return;
        L5:
            r103 = CJPayNetworkManager.NET_ERROR_MESSAGE;
            goto L6
        }

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onResponse(final JSONObject r100) {
            String r101 = CJPayNetworkManager.NET_ERROR_MESSAGE;
        L21:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#run", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#run", e);
            ICJPayNetWorkRawCallback r102 = this.val$networkCallback;
            Context r103 = CJPayHostInfo.applicationContext;
            if (r103 == null) goto L25;
            r101 = r103.getResources().getString(R.string.cj_pay_network_exception);
        L25:
            r102.onFailure("-99", r101);
            return;
        L4:
            if (r100.has("error_code") == false) goto L10;
            ICJPayNetWorkRawCallback r104 = this.val$networkCallback;     // Catch: Exception -> L21
            Context r105 = CJPayHostInfo.applicationContext;     // Catch: Exception -> L21
            if (r105 == null) goto L8;
            String r106 = r105.getResources().getString(R.string.cj_pay_network_exception);     // Catch: Exception -> L21
        L9:
            r104.onFailure("-99", r106);     // Catch: Exception -> L21
            return;
        L8:
            r106 = CJPayNetworkManager.NET_ERROR_MESSAGE;
            goto L9
        L10:
            final JSONObject r107 = r100.optJSONObject("response");     // Catch: Exception -> L21
            if (r107 != null) goto L16;
            final Class r108 = (Class) ((ParameterizedType) this.val$networkCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];     // Catch: Exception -> L21
            ICJPayParserCallback r109 = this.val$payParserCallback;     // Catch: Exception -> L21
            if (r109 == null) goto L15;
            r109.onParseStart();     // Catch: Exception -> L21
        L15:
            CJPayNetworkManager.access$400(new AnonymousClass1(this, r100, r108), new AnonymousClass2(this));     // Catch: Exception -> L21
            return;
        L16:
            final Class r110 = (Class) ((ParameterizedType) this.val$networkCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];     // Catch: Exception -> L21
            ICJPayParserCallback r111 = this.val$payParserCallback;     // Catch: Exception -> L21
            if (r111 == null) goto L19;
            r111.onParseStart();     // Catch: Exception -> L21
        L19:
            CJPayNetworkManager.access$400(new AnonymousClass3(this, r107, r110), new RunnableC05324(this));     // Catch: Exception -> L21
        }

        public AnonymousClass4(ICJPayNetWorkRawCallback r100, ICJPayParserCallback r101, String r102) {
            this.val$networkCallback = r100;
            this.val$payParserCallback = r101;
            this.val$baseUrl = r102;
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$6, reason: invalid class name */
    /* JADX INFO: loaded from: classes28.dex */
    public class AnonymousClass6 implements ICJPayCallback {
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ ICJPayNetWorkCallback val$netWorkCallback;

        /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$6$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ AnonymousClass6 this$0;
            final /* synthetic */ Class val$cls;
            final /* synthetic */ JSONObject val$json;

            @Override // java.lang.Runnable
            public void run() {
                com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$1__run$___twin___() {
                CJPayNetworkManager.access$300(this.val$json, this.this$0.val$baseUrl);
                final CJPayObject r100 = CJPayJsonParser.fromJson(this.val$json, this.val$cls);
                CJPayNetworkManager.access$200().post(new RunnableC05331(this, r100));
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
                r100.com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$1__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public AnonymousClass1(AnonymousClass6 r100, JSONObject r101, Class r102) {
                this.this$0 = r100;
                this.val$json = r101;
                this.val$cls = r102;
            }
        }

        /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.network.CJPayNetworkManager$6$2, reason: invalid class name */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ AnonymousClass6 this$0;

            @Override // java.lang.Runnable
            public void run() {
                com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$2__run$___twin___() {
                ICJPayNetWorkCallback r100 = this.this$0.val$netWorkCallback;
                if (r100 == null) goto L10;
                Context r101 = CJPayHostInfo.applicationContext;
                if (r101 == null) goto L7;
                String r102 = r101.getResources().getString(R.string.cj_pay_network_exception);
            L8:
                r100.onFailure("-99", r102);
                return;
            L7:
                r102 = CJPayNetworkManager.NET_ERROR_MESSAGE;
                goto L8
            }

            public AnonymousClass2(AnonymousClass6 r100) {
                this.this$0 = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$2_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass2 r100) {
                r100.com_android_ttcjpaysdk_base_network_CJPayNetworkManager$6$2__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onFailure(JSONObject r100) {
            ICJPayNetWorkCallback r101 = this.val$netWorkCallback;
            Context r102 = CJPayHostInfo.applicationContext;
            if (r102 == null) goto L5;
            String r103 = r102.getResources().getString(R.string.cj_pay_network_exception);
        L6:
            r101.onFailure("-99", r103);
            return;
        L5:
            r103 = CJPayNetworkManager.NET_ERROR_MESSAGE;
            goto L6
        }

        @Override // com.android.ttcjpaysdk.base.network.ICJPayCallback
        public void onResponse(final JSONObject r100) {
            String r101 = CJPayNetworkManager.NET_ERROR_MESSAGE;
        L12:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#run", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#run", e);
            e.printStackTrace();
            ICJPayNetWorkCallback r102 = this.val$netWorkCallback;
            Context r103 = CJPayHostInfo.applicationContext;
            if (r103 == null) goto L16;
            r101 = r103.getResources().getString(R.string.cj_pay_network_exception);
        L16:
            r102.onFailure("-99", r101);
            return;
        L4:
            if (r100.has("error_code") == false) goto L10;
            ICJPayNetWorkCallback r104 = this.val$netWorkCallback;     // Catch: Exception -> L12
            Context r105 = CJPayHostInfo.applicationContext;     // Catch: Exception -> L12
            if (r105 == null) goto L8;
            String r106 = r105.getResources().getString(R.string.cj_pay_network_exception);     // Catch: Exception -> L12
        L9:
            r104.onFailure("-99", r106);     // Catch: Exception -> L12
            return;
        L8:
            r106 = CJPayNetworkManager.NET_ERROR_MESSAGE;
            goto L9
        L10:
            final Class r107 = (Class) ((ParameterizedType) this.val$netWorkCallback.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];     // Catch: Exception -> L12
            CJPayNetworkManager.access$400(new AnonymousClass3(this, r100, r107), new AnonymousClass4(this));     // Catch: Exception -> L12
        }

        public AnonymousClass6(ICJPayNetWorkCallback r100, String r101) {
            this.val$netWorkCallback = r100;
            this.val$baseUrl = r101;
        }
    }

    public CJPayNetworkManager() {
    }

    static {
        handler = new Handler(Looper.getMainLooper());
        isUsingTTNet = true;
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L5
        ((TTNetService) ve4.a.d(TTNetService.class)).addInterceptorWhenPluginRequest();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#unknown", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#unknown", th);
    }

    public static JSONObject generateFailureInfo() {
        Context r100 = CJPayHostInfo.applicationContext;
        if (r100 == null) goto L5;
        String r101 = r100.getResources().getString(R.string.cj_pay_network_exception);
    L7:
        return generateFailureInfo(-99, r101);
    L5:
        r101 = NET_ERROR_MESSAGE;
        goto L7
    }

    public static int getEffectiveConnectionType() {
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).getEffectiveConnectionType();
    }

    private static synchronized HandlerThread getHandlerThread() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.android.ttcjpaysdk.base.network.CJPayNetworkManager> r0 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.class
            monitor-enter(r0)
            android.os.HandlerThread r1 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.handlerThread     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L21
            java.lang.Class<android.os.HandlerThread> r1 = android.os.HandlerThread.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L25
            android.os.HandlerThread r2 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.handlerThread     // Catch: java.lang.Throwable -> L1e
            if (r2 != 0) goto L1c
            com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2 r2 = new com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2     // Catch: java.lang.Throwable -> L1e
            java.lang.String r3 = "CJPayNetworkManager"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1e
            com.android.ttcjpaysdk.base.network.CJPayNetworkManager.handlerThread = r2     // Catch: java.lang.Throwable -> L1e
            android.os.HandlerThread r2 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.handlerThread     // Catch: java.lang.Throwable -> L1e
            com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy.start(r2)     // Catch: java.lang.Throwable -> L1e
        L1c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1e
            goto L21
        L1e:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1e
            throw r2     // Catch: java.lang.Throwable -> L25
        L21:
            android.os.HandlerThread r1 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.handlerThread     // Catch: java.lang.Throwable -> L25
            monitor-exit(r0)
            return r1
        L25:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ttcjpaysdk.base.network.CJPayNetworkManager.getHandlerThread():android.os.HandlerThread");
    }

    private static synchronized Handler getWorkerHandler() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.android.ttcjpaysdk.base.network.CJPayNetworkManager> r0 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.class
            monitor-enter(r0)
            android.os.Handler r1 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.workerHandler     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L2a
            java.lang.Class<android.os.Handler> r1 = android.os.Handler.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2e
            android.os.Handler r2 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.workerHandler     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L25
            android.os.HandlerThread r2 = getHandlerThread()     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L25
            boolean r3 = com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy.isAlive(r2)     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L25
            android.os.Handler r3 = new android.os.Handler     // Catch: java.lang.Throwable -> L27
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L27
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L27
            com.android.ttcjpaysdk.base.network.CJPayNetworkManager.workerHandler = r3     // Catch: java.lang.Throwable -> L27
        L25:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L27
            goto L2a
        L27:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L27
            throw r2     // Catch: java.lang.Throwable -> L2e
        L2a:
            android.os.Handler r1 = com.android.ttcjpaysdk.base.network.CJPayNetworkManager.workerHandler     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r0)
            return r1
        L2e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ttcjpaysdk.base.network.CJPayNetworkManager.getWorkerHandler():android.os.Handler");
    }

    public static /* synthetic */ Handler access$700() {
        return getWorkerHandler();
    }

    public static /* synthetic */ Handler access$200() {
        return handler;
    }

    public static boolean isUsingTTNet() {
        return isUsingTTNet;
    }

    public static /* synthetic */ int access$100(Throwable r100) {
        return getTTNetErrorCode(r100);
    }

    public static /* synthetic */ void access$800(ICJPayDownloadFileCallback r100) {
        handleDownloadFailure(r100);
    }

    private static void addCommonHeaderParams(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put("x-native-devinfo", CJPayParamsUtils.buildDevInfoHeaderParams());
        r100.put("X-Cjpay-Sdk-Info", CJPayParamsUtils.buildSdkInfoHeaderParams());
        if (TextUtils.isEmpty(CJPayHostInfo.boeEnv) == true) goto L7;
        r100.put("X-TT-ENV", CJPayHostInfo.boeEnv);
    L7:
        CJPaySaasUtils r101 = CJPaySaasUtils.INSTANCE;
        if (TextUtils.isEmpty(r101.getSaasAccessToken()) == true) goto L11;
        r100.put("bd-ticket-guard-target", r101.getSaasAccessToken());
        return;
    }

    private static String addCommonParams(String r100) {
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L4
        return ((AppLogService) ve4.a.a(AppLogService.class)).addCommonParams(r100, false);
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#addCommonParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#addCommonParams", th);
        return r100;
    }

    public static void addTTNetInterceptor(Object r100) {
        ve4.a.f554342a.getClass();
        ((TTNetService) ve4.a.a(TTNetService.class)).addInterceptor("from_app", r100);
    }

    private static String getHost(String r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        return UriProtector.parse(r100).getHost();
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#getHost", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#getHost", e);
        return "";
    }

    private static String getSimplifiedUrl(String r100) {
        if (r100 != null) goto L12;
        return "";
    L12:
        int r101 = r100.indexOf("?");     // Catch: Exception -> L9
        if (r101 <= 0) goto L14;
        return r100.substring(0, r101);
    L14:
        return r100;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#getSimplifiedUrl", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#getSimplifiedUrl", e);
        return r100;
    }

    private static int getTTNetErrorCode(Throwable r100) {
        ve4.a.f554342a.getClass();
        TTNetService r101 = (TTNetService) ve4.a.a(TTNetService.class);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getTTNetErrorCode(-1, r100);
    }

    private static int getTTNetInternalErrorCode(Throwable r100) {
        ve4.a.f554342a.getClass();
        TTNetService r101 = (TTNetService) ve4.a.a(TTNetService.class);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getTTNetInternalErrorCode(-1, r100);
    }

    private static Map<String, String> getTTNetRequestHeader(Throwable r100) {
        ve4.a.f554342a.getClass();
        TTNetService r101 = (TTNetService) ve4.a.a(TTNetService.class);
        if (r101 == null) goto L7;
        return r101.getTTNetRequestHeader(r100);
    L7:
        return new HashMap();
    }

    private static String getTTNetRequestTraceId(Throwable r100) {
        Map<String, String> r101 = getTTNetRequestHeader(r100);
        if (r101.containsKey(OkHttpEventListener.X_TT_TRACE_ID) == true) goto L5;
        return "";
    L5:
        return r101.get(OkHttpEventListener.X_TT_TRACE_ID);
    }

    private static String getUrl(String r100) {
        if ("1128".equals(CJEnv.e()) == false) goto L5;
    L19:
        ICJPayHostService r101 = (ICJPayHostService) CJPayServiceManager.getInstance().getIService(ICJPayHostService.class);     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        r100 = r101.networkParamsLoadToUrl(r100, false);     // Catch: Throwable -> L15
    L18:
        return r100;
    L13:
        r100 = addCommonParams(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#getUrl", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#getUrl", th);
        return addCommonParams(r100);
    L5:
        if ("3908".equals(CJEnv.e()) == true) goto L19;
        if ("2329".equals(CJEnv.e()) == true) goto L19;
        return addCommonParams(r100);
    }

    public static String getUrlPath(String r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        return UriProtector.parse(r100).getPath();
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#getUrlPath", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#getUrlPath", e);
        return "";
    }

    private static void handleDownloadFailure(final ICJPayDownloadFileCallback r100) {
        handler.post(new AnonymousClass13(r100));
    }

    public static void logNetworkError(String r100) {
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 == null) goto L5;
        String r102 = r101.getResources().getString(R.string.cj_pay_network_exception);
    L6:
        logNetworkError(r100, -99, r102, null);
        return;
    L5:
        r102 = NET_ERROR_MESSAGE;
        goto L6
    }

    public static void preConnect(String r100) {
        ve4.a.f554342a.getClass();
        ((TTNetService) ve4.a.a(TTNetService.class)).preconnectUrl(r100);
    }

    public static void setUsingTTNet(boolean r100) {
        isUsingTTNet = r100;
    }

    public static /* synthetic */ void access$300(JSONObject r100, String r101) {
        setJSONFlag(r100, r101);
    }

    public static /* synthetic */ void access$400(Runnable r100, Runnable r101) {
        workerHandlerPost(r100, r101);
    }

    public static void addInterceptor(String r100, ICJPayInterceptor r101) {
    L7:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#addInterceptor", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#addInterceptor", th);
        return;
    L3:
        if (isUsingTTNet == false) goto L5;
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L7
        ((TTNetService) ve4.a.a(TTNetService.class)).addInterceptor(r100, r101);     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L7
        ((OKHttpService) ve4.a.a(OKHttpService.class)).addInterceptor(r100, r101);     // Catch: Throwable -> L7
        goto L10
    }

    public static void downloadFile(String r100, ICJPayDownloadFileCallback r101) {
        downloadFile(r100, null, r101, false);
    }

    public static JSONObject generateFailureInfo(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("error_code", r100);     // Catch: JSONException -> L5
        r102.put("error_msg", r101);     // Catch: JSONException -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#generateFailureInfo", e);
        CJLogger.c(TAG, "generateFailureInfo JSONException", e);
        goto L7
    }

    private static synchronized void setJSONFlag(JSONObject r100, String r101) {
        monitor-enter(CJPayNetworkManager.class);
        if (r100 != null) goto L18;
        monitor-exit(CJPayNetworkManager.class);
        return;
    L18:
        r100.put("cj_pay_network_api_to_json_url", r101);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CJPayNetworkManager.class);
        return;
    L9:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#setJSONFlag", th);     // Catch: Throwable -> L13
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#setJSONFlag", th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private static synchronized void workerHandlerPost(Runnable r100, Runnable r101) {
        monitor-enter(CJPayNetworkManager.class);
        Handler r102 = getWorkerHandler();     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        r102.post(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayNetworkManager.class);
        return;
    L7:
        if (r101 == null) goto L9;
        handler.post(r101);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$500(String r100, ICJPayCallback r101, JSONObject r102) {
        checkInMainThread(r100, r101, r102);
    }

    private static void checkInMainThread(String r100, ICJPayCallback r101, JSONObject r102) {
        checkInMainThread(r100, r101, r102, null);
    }

    public static void downloadFile(String r100, ICJPayDownloadFileCallback r101, boolean r102) {
        downloadFile(r100, null, r101, r102);
    }

    private static void downloadFileOKHttp(String r100, final ICJPayDownloadFileCallback r101, final boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        handleDownloadFailure(r101);
        return;
    L6:
        ve4.a.f554342a.getClass();
        ((OKHttpService) ve4.a.a(OKHttpService.class)).downloadFileOKHttp(r100, new AnonymousClass12(r102, r101));
    }

    public static JSONObject generateFailureInfo(int r100, String r101, Throwable r102) {
        JSONObject r103 = new JSONObject();
        r103.put("error_code", r100);     // Catch: JSONException -> L7
        r103.put("error_msg", r101);     // Catch: JSONException -> L7
        if (r102 == null) goto L9;
        String r104 = Log.getStackTraceString(r102);     // Catch: JSONException -> L7
        r103.put("error_stack_trace", r104);     // Catch: JSONException -> L7
        CJLogger.b(TAG, "[generateFailureInfo] error_stack_trace: " + r104);     // Catch: JSONException -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#generateFailureInfo", e);
        CJLogger.c(TAG, "generateFailureInfo JSONException", e);
        goto L9
    }

    public static ICJPayRequest get(String r100, Map<String, String> r101, ICJPayCallback r102) {
        return get(r100, r101, r102, true);
    }

    private static ICJPayRequest getOKHttp(final String r100, Map<String, String> r101, final ICJPayCallback r102) {
        final String r103 = getUrlPath(r100);
        Lazy<DynamicEventTracker> r104 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r103);
        ve4.a.f554342a.getClass();
        return ((OKHttpService) ve4.a.a(OKHttpService.class)).getOKHttp(r100, r101, new AnonymousClass18(r103, r102, r100));
    }

    private static ICJPayRequest getTTNet(String r100, Map<String, String> r101, ICJPayCallback r102) {
        return getTTNet(r100, r101, r102, true);
    }

    public static void logServerApiStatus(String r100, te4.b r101, Throwable r102) {
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101 != null) goto L32;
    L15:
        String r103 = "";
    L16:
        CJServerApiMonitor.c r104 = new CJServerApiMonitor.c();     // Catch: Throwable -> L13
        r104.f202319c = r100;     // Catch: Throwable -> L13
        if (r101 == null) goto L24;
        r104.f202322f = r101.f545570j;     // Catch: Throwable -> L13
        r104.f202323g = r101.f545568h;     // Catch: Throwable -> L13
        r104.f202324h = r101.f545569i;     // Catch: Throwable -> L13
        r104.f202317a = r101.f545561a;     // Catch: Throwable -> L13
        r104.f202320d = r101.f545562b;     // Catch: Throwable -> L13
        r104.f202321e = r101.f545567g;     // Catch: Throwable -> L21
    L23:
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L13
        r105.put("log_id", r103);     // Catch: Throwable -> L13
        int r106 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;     // Catch: Throwable -> L13
        com.bytedance.caijing.sdk.infra.base.logger.a.i(r100, r101.f545562b, r105.toString());     // Catch: Throwable -> L13
    L28:
        CJServerApiMonitor.f202312b.getValue().a(r104);     // Catch: Throwable -> L13
        return;
    L21:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#logServerApiStatus", th);     // Catch: Throwable -> L13
        CJLogger.c(TAG, "logServerApiStatus", th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#logServerApiStatus", th);
        CJLogger.c(TAG, "logServerApiStatus", th);
        return;
    L24:
        if (r102 == null) goto L26;
        r104.f202317a = getTTNetErrorCode(r102);     // Catch: Throwable -> L13
        r104.f202318b = r102.getMessage();     // Catch: Throwable -> L13
    L27:
        int r107 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;     // Catch: Throwable -> L13
        com.bytedance.caijing.sdk.infra.base.logger.a.h(r100, r104.f202318b);     // Catch: Throwable -> L13
        goto L28
    L26:
        r104.f202317a = -99;     // Catch: Throwable -> L13
        r104.f202318b = NET_ERROR_MESSAGE;     // Catch: Throwable -> L13
        goto L27
    L32:
        Map<String, String> r108 = r101.f545567g;     // Catch: Throwable -> L13
        if (r108 == null) goto L15;
        if (r108.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L15;
        r103 = r101.f545567g.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L13
        goto L16
    }

    public static void downloadFile(String r100, Map<String, String> r101, ICJPayDownloadFileCallback r102) {
        downloadFile(r100, r101, r102, false);
    }

    public static /* synthetic */ void access$000(te4.b r100, long r101, Map r102, String r103) {
        sendMonitor(r100, r101, r102, r103);
    }

    public static /* synthetic */ void access$600(String r100, ICJPayCallback r101, JSONObject r102, ae4.b r103) {
        checkInMainThread(r100, r101, r102, r103);
    }

    private static void checkInMainThread(final String r100, final ICJPayCallback r101, final JSONObject r102, final ae4.b r103) {
        handler.post(new AnonymousClass20(r102, r103, r101, r100));
    }

    public static void downloadFile(String r100, Map<String, String> r101, ICJPayDownloadFileCallback r102, boolean r103) {
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#downloadFileOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#downloadFileOKHttp", e);
        if (r102 == null) goto L14;
        r102.onFailure();
    L14:
        logNetworkError(r100);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (isUsingTTNet == false) goto L8;
        downloadFileTTNet(r100, r101, r102, r103);     // Catch: Exception -> L10
    L16:
        return;
    L8:
        downloadFileOKHttp(r100, r102, r103);     // Catch: Exception -> L10
        goto L16
    }

    private static void downloadFileTTNet(final String r100, Map<String, String> r110, final ICJPayDownloadFileCallback r111, final boolean r112) {
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L8;
        if (r111 == null) goto L6;
        r111.onFailure();
    L6:
        logNetworkError(r100);
        return;
    L8:
        String r102 = r101.getScheme() + "://" + r101.getHost();
        final long r103 = System.currentTimeMillis();
        ve4.a.f554342a.getClass();
        ((TTNetService) ve4.a.a(TTNetService.class)).downloadFileTTNet(r102, r100, r110, new AnonymousClass11(r103, r112, r111, r100));
    }

    public static ICJPayRequest get(String r100, Map<String, String> r101, ICJPayCallback r102, boolean r103) {
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#getOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#getOKHttp", e);
        if (r102 == null) goto L16;
        r102.onFailure(generateFailureInfo());
    L16:
        logNetworkError(r100);
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r101);     // Catch: Exception -> L12
        String r104 = getUrl(r100);     // Catch: Exception -> L12
        if (isUsingTTNet == false) goto L11;
        return getTTNet(r104, r101, r102, r103);
    L11:
        return getOKHttp(r104, r101, r102);
    }

    private static ICJPayRequest getTTNet(String r110, Map<String, String> r111, ICJPayCallback r112, boolean r113) {
        long r100 = System.currentTimeMillis();
        String r101 = getUrlPath(r110);
        Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r101);
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).getTTNet(r110, r111, 5242880, new AnonymousClass19(r101, r113, r100, r111, r112, r110));
    }

    public static void logNetworkError(String r100, int r101, String r110, JSONObject r111) {
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams("", "");
        if (r110 != null) goto L19;
        r110 = NET_ERROR_MESSAGE;
    L19:
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#logNetworkError", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#logNetworkError", e);
        return;
    L6:
        if (r110.length() <= 200) goto L8;
        r110 = r110.substring(0, 200);     // Catch: Exception -> L16
    L8:
        String r112 = r110.split("[\\u4e00-\\u9fa5]")[0];     // Catch: Exception -> L16
        r102.put("host", getHost(r100));     // Catch: Exception -> L16
        r102.put("url", getSimplifiedUrl(r100));     // Catch: Exception -> L16
        r102.put("path", getUrlPath(r100));     // Catch: Exception -> L16
        r102.put("error_code", String.valueOf(r101));     // Catch: Exception -> L16
        r102.put("error_msg", r112);     // Catch: Exception -> L16
        if (r111 == null) goto L14;
        Iterator<String> r103 = r111.keys();     // Catch: Exception -> L16
    L12:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();     // Catch: Exception -> L16
        r102.put(r104, r111.opt(r104));     // Catch: Exception -> L16
    L14:
        CJReporter r105 = CJReporter.f202294a;     // Catch: Exception -> L16
        CJReporter.g(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_network_error", CJPayBasicUtils.json2MapObject(r102), null, -1, false);     // Catch: Exception -> L16
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_network_error", r102);     // Catch: Exception -> L16
    }

    public static ICJPayRequest lynxPostForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayCallback r103) {
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postFormOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postFormOKHttp", e);
        if (r103 == null) goto L16;
        r103.onFailure(generateFailureInfo());
    L16:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L12
        r102.remove("x-native-devinfo");     // Catch: Exception -> L12
        String r104 = getUrl(r100);     // Catch: Exception -> L12
        if (isUsingTTNet == false) goto L11;
        return postFormTTNet(r104, r101, r102, r103);
    L11:
        return postFormOKHttp(r104, r101, r102, r103);
    }

    public static ICJPayRequest postForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayCallback r103) {
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postFormOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postFormOKHttp", e);
        if (r103 == null) goto L16;
        r103.onFailure(generateFailureInfo());
    L16:
        logNetworkError(r100);
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L12
        String r104 = getUrl(r100);     // Catch: Exception -> L12
        if (isUsingTTNet == false) goto L11;
        return postFormTTNet(r104, r101, r102, r103);
    L11:
        return postFormOKHttp(r104, r101, r102, r103);
    }

    private static ICJPayRequest postFormOKHttp(final String r100, Map<String, String> r101, Map<String, String> r102, final ICJPayCallback r103) {
        final String r104 = getUrlPath(r100);
        Lazy<DynamicEventTracker> r105 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r104);
        ve4.a.f554342a.getClass();
        return ((OKHttpService) ve4.a.a(OKHttpService.class)).postFormOKHttp(r100, r101, r102, new AnonymousClass17(r104, r103, r100));
    }

    public static ICJPayRequest postFormRawString(final String r110, Map<String, String> r111, Map<String, String> r112, final ICJPayRawStringCallback r113) {
    L16:
        e = e;
    L18:
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postFormRawString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postFormRawString", e);
        if (r113 == null) goto L25;
        JSONObject r100 = generateFailureInfo();
        if (r100 == null) goto L23;
        String r101 = r100.toString();
    L24:
        r113.onFailure(r101);
        goto L25
    L23:
        r101 = null;
    L25:
        logNetworkError(r110);
        return null;
    L4:
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r112);     // Catch: Exception -> L16
        String r102 = getUrl(r110);     // Catch: Exception -> L16
        final String r103 = getUrlPath(r102);     // Catch: Exception -> L16
        Lazy<DynamicEventTracker> r104 = DynamicEventTracker.f202325b;     // Catch: Exception -> L16
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r103);     // Catch: Exception -> L16
        if (isUsingTTNet == false) goto L10;
        long r105 = System.currentTimeMillis();     // Catch: Exception -> L16
        ve4.a.f554342a.getClass();     // Catch: Exception -> L16
        return ((TTNetService) ve4.a.a(TTNetService.class)).postFormTTNet(r102, r111, r112, 5242880, new AnonymousClass1(r105, r113, r111, r112, r103, r110));
    L10:
        ve4.a.f554342a.getClass();     // Catch: Exception -> L16
        return ((OKHttpService) ve4.a.a(OKHttpService.class)).postFormOKHttp(r102, r111, r112, new AnonymousClass2(r103, r113, r110));
    L14:
        e = e;
        goto L18
    }

    private static ICJPayRequest postFormTTNet(final String r110, final Map<String, String> r111, final Map<String, String> r112, final ICJPayCallback r113) {
        final long r100 = System.currentTimeMillis();
        final String r101 = getUrlPath(r110);
        CJLogger.d(TAG, "prepare postForm:" + g.a(r110) + " , path=" + r101);
        int r102 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;     // Catch: Throwable -> L9
        com.bytedance.caijing.sdk.infra.base.logger.a.g(r101, new JSONObject(r111).toString());     // Catch: Throwable -> L7
    L12:
        Lazy<DynamicEventTracker> r103 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r101);
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).postFormTTNet(r110, r111, r112, 5242880, new AnonymousClass14(r100, r111, r112, r110, r101, r113));
    L7:
        th = th;
    L11:
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#JSONObject", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#JSONObject", th);
    L9:
        th = th;
        goto L11
    }

    private static ICJPayRequest postFormTTNetHighPriority(final String r110, final Map<String, String> r111, Map<String, String> r112, final ICJPayCallback r113) {
        final long r100 = System.currentTimeMillis();
        final String r101 = getUrlPath(r110);
        CJLogger.d(TAG, "prepare postForm:" + g.a(r110));
        int r102 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;     // Catch: Throwable -> L5
        com.bytedance.caijing.sdk.infra.base.logger.a.g(r101, new JSONObject(r111).toString());     // Catch: Throwable -> L5
    L7:
        Lazy<DynamicEventTracker> r103 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r101);
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).postFormTTNetHighPriority(r110, r111, r112, 5242880, new AnonymousClass16(r100, r111, r110, r101, r113));
    L5:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#JSONObject", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#JSONObject", th);
        goto L7
    }

    private static ICJPayRequest postJsonOKHttp(final String r100, Map<String, String> r101, String r102, final ICJPayCallback r103) {
        final long r104 = System.currentTimeMillis();
        ve4.a.f554342a.getClass();
        return ((OKHttpService) ve4.a.a(OKHttpService.class)).postJsonOKHttp(r100, r101, r102, new AnonymousClass10(r103, r104, r100));
    }

    private static ICJPayRequest postPbTTNet(final String r110, byte[] r111, final Map<String, String> r112, final ICJPayPbCallback r113) {
        final long r100 = System.currentTimeMillis();
        final String r101 = getUrlPath(r110);
        CJLogger.d(TAG, "prepare postForm:" + g.a(r110) + " , path=" + r101);
        Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r101);
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).postPbTTNet(r110, r111, r112, 5242880, new AnonymousClass15(r100, r112, r110, r101, r113));
    }

    private static void sendMonitor(te4.b r100, long r101, Map<String, String> r102, String r103) {
        if (r100 == null) goto L28;
        String r104 = "";
        if (r102 != null) goto L26;
        String r105 = "";
        String r106 = r105;
    L10:
        Map<String, String> r107 = r100.f545567g;     // Catch: Throwable -> L7
        if (r107 != null) goto L13;
    L15:
        JSONObject r108 = CJPayParamsUtils.getCommonLogParams(r105, r106);     // Catch: Throwable -> L7
        String r109 = r100.f545563c;     // Catch: Throwable -> L7
        String r110 = getHost(r109);     // Catch: Throwable -> L7
        String r111 = getSimplifiedUrl(r109);     // Catch: Throwable -> L7
        r108.put("host", r110);     // Catch: Throwable -> L7
        r108.put("url", r111);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r103) == true) goto L18;
        r108.put("vid", r103);     // Catch: Throwable -> L7
    L18:
        r108.put("path", getUrlPath(r111));     // Catch: Throwable -> L7
        r108.put("status", r100.f545564d);     // Catch: Throwable -> L7
        r108.put("reason", r100.f545565e);     // Catch: Throwable -> L7
        Long r112 = r100.f545571k;     // Catch: Throwable -> L7
        if (r112 == null) goto L21;
        long r113 = r112.longValue();     // Catch: Throwable -> L7
    L22:
        r108.put("length", r113);     // Catch: Throwable -> L7
        r108.put("time", r101);     // Catch: Throwable -> L7
        r108.put("server_type", CJPayHostInfo.serverType);     // Catch: Throwable -> L7
        r108.put("x_tt_logid", r104);     // Catch: Throwable -> L7
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_network_success_info", new JSONObject[]{r108});     // Catch: Throwable -> L7
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_network_success_info", r108);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#sendMonitor", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#sendMonitor", th);
        return;
    L21:
        r113 = 0;
        goto L22
    L13:
        if (r107.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L15;
        r104 = r100.f545567g.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L7
        goto L15
    L26:
        r106 = r102.get("app_id");     // Catch: Throwable -> L7
        r105 = r102.get("merchant_id");     // Catch: Throwable -> L7
        goto L10
    }

    public static void logNetworkError(String r100, te4.b r101, Throwable r102, String r110) {
        JSONObject r103 = new JSONObject();
        int r104 = -99;
        String r105 = "";
        if (r101 == null) goto L16;
        int r106 = r101.f545561a;     // Catch: Exception -> L18
        String r107 = r101.f545562b;     // Catch: Exception -> L18
        Map<String, String> r108 = r101.f545567g;     // Catch: Exception -> L18
        if (r108 != null) goto L7;
    L9:
        String r109 = "";
    L10:
        Map<String, String> r111 = r101.f545567g;     // Catch: Exception -> L18
        if (r111 != null) goto L13;
    L15:
        String r112 = r105;
        r105 = r107;
    L21:
        if (r105 != null) goto L23;
        r105 = NET_ERROR_MESSAGE;
    L23:
        r103.put("ttnet_error_code", r104);     // Catch: Exception -> L18
        r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r112);     // Catch: Exception -> L18
        r103.put("log_id", r109);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r110) == true) goto L26;
        r103.put("vid", r110);     // Catch: Exception -> L18
    L26:
        logNetworkError(r100, r106, r105, r103);     // Catch: Exception -> L18
        return;
    L13:
        if (r111.containsKey(OkHttpEventListener.X_TT_TRACE_ID) == false) goto L15;
        r105 = r101.f545567g.get(OkHttpEventListener.X_TT_TRACE_ID);     // Catch: Exception -> L18
        goto L15
    L7:
        if (r108.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L9;
        r109 = r101.f545567g.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Exception -> L18
        goto L10
    L16:
        if (r102 == null) goto L20;
        int r113 = getTTNetErrorCode(r102);     // Catch: Exception -> L18
        String r114 = r102.getMessage();     // Catch: Exception -> L18
        int r115 = getTTNetInternalErrorCode(r102);     // Catch: Exception -> L18
        r109 = "";
        r105 = r114;
        r112 = getTTNetRequestTraceId(r102);     // Catch: Exception -> L18
        r106 = r113;
        r104 = r115;
        goto L21
    L20:
        r112 = "";
        r109 = r112;
        r106 = -99;
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#logNetworkError", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#logNetworkError", e);
    }

    public static <T> ICJPayRequest postForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayNetWorkCallback<T> r103) {
        return postForm(r100, r101, r102, r103, null);
    }

    public static ICJPayRequest postJsonOKHttp(final String r100, Map<String, String> r101, JSONObject r102, final ICJPayCallback r103) {
        final long r104 = System.currentTimeMillis();
        ve4.a.f554342a.getClass();
        return ((OKHttpService) ve4.a.a(OKHttpService.class)).postJsonOKHttp(r100, r101, r102, new AnonymousClass8(r103, r104, r100));
    }

    public static <T> ICJPayRequest postForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayNetWorkRawCallback<T> r103, ICJPayParserCallback r104) {
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postFormOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postFormOKHttp", e);
        if (r103 == null) goto L20;
        Context r105 = CJPayHostInfo.applicationContext;
        if (r105 == null) goto L18;
        String r106 = r105.getResources().getString(R.string.cj_pay_network_exception);
    L19:
        r103.onFailure("-99", r106);
        goto L20
    L18:
        r106 = NET_ERROR_MESSAGE;
    L20:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L12
        String r107 = getUrl(r100);     // Catch: Exception -> L12
        AnonymousClass4 r108 = new AnonymousClass4(r103, r104, r100);     // Catch: Exception -> L12
        if (isUsingTTNet == false) goto L11;
        return postFormTTNet(r107, r101, r102, r108);
    L11:
        return postFormOKHttp(r107, r101, r102, r108);
    }

    public static ICJPayRequest postJson(String r100, Map<String, String> r101, Map<String, String> r102, String r103, ICJPayCallback r110) {
        return postJson(r100, r101, r102, r103, true, r110);
    }

    private static ICJPayRequest postJsonTTNet(final String r110, final Map<String, String> r111, Map<String, String> r112, String r113, final ICJPayCallback r114) {
        final long r100 = System.currentTimeMillis();
        final String r101 = getUrlPath(r110);
        CJLogger.d(TAG, "prepare postJsonTTNet:" + g.a(r110));
        Lazy<DynamicEventTracker> r102 = DynamicEventTracker.f202325b;
        DynamicEventTracker.c.b("wallet_rd_common_network_start", r101);
        ve4.a.f554342a.getClass();
        return ((TTNetService) ve4.a.a(TTNetService.class)).postJsonTTNet(r110, r111, r112, r113, 5242880, new AnonymousClass9(r100, r111, r110, r101, r114));
    }

    public static <T> ICJPayRequest postForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayNetWorkCallback<T> r103, ICJPayParserCallback r110) {
        return postForm(r100, r101, r102, r103, r110, false);
    }

    public static <T> ICJPayRequest postJson(String r100, Map<String, String> r101, Map<String, String> r102, String r103, ICJPayNetWorkCallback<T> r110) {
        return postJson(r100, r101, r102, r103, true, r110);
    }

    public static <T> ICJPayRequest postForm(String r100, Map<String, String> r101, Map<String, String> r102, ICJPayNetWorkCallback<T> r103, ICJPayParserCallback r104, boolean r105) {
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postFormOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postFormOKHttp", e);
        if (r103 == null) goto L23;
        Context r106 = CJPayHostInfo.applicationContext;
        if (r106 == null) goto L21;
        String r107 = r106.getResources().getString(R.string.cj_pay_network_exception);
    L22:
        r103.onFailure("-99", r107);
        goto L23
    L21:
        r107 = NET_ERROR_MESSAGE;
    L23:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L15
        String r108 = getUrl(r100);     // Catch: Exception -> L15
        AnonymousClass3 r109 = new AnonymousClass3(r103, r104, r100);     // Catch: Exception -> L15
        if (isUsingTTNet == false) goto L14;
        if (r105 == false) goto L12;
        return postFormTTNetHighPriority(r108, r101, r102, r109);
    L12:
        return postFormTTNet(r108, r101, r102, r109);
    L14:
        return postFormOKHttp(r108, r101, r102, r109);
    }

    public static <T> ICJPayRequest postJson(String r100, Map<String, String> r101, Map<String, String> r102, String r103, boolean r104, ICJPayNetWorkCallback<T> r105) {
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postJsonOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postJsonOKHttp", e);
        if (r105 == null) goto L24;
        Context r106 = CJPayHostInfo.applicationContext;
        if (r106 == null) goto L22;
        String r107 = r106.getResources().getString(R.string.cj_pay_network_exception);
    L23:
        r105.onFailure("-99", r107);
        goto L24
    L22:
        r107 = NET_ERROR_MESSAGE;
    L24:
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L16
        if (r104 == false) goto L9;
        String r108 = getUrl(r100);     // Catch: Exception -> L16
    L10:
        AnonymousClass6 r109 = new AnonymousClass6(r105, r100);     // Catch: Exception -> L16
        if (isUsingTTNet == false) goto L15;
        return postJsonTTNet(r108, r101, r102, r103, r109);
    L15:
        return postJsonOKHttp(r108, r102, r103, r109);
    L9:
        r108 = r100;
        goto L10
    }

    public static <T> ICJPayRequest postPb(String r100, byte[] r101, Map<String, String> r102, final ICJPayNetWorkRawCallback<T> r103, ICJPayParserCallback r104, final ICJPayResponseCallback r105) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L10
        String r106 = getUrl(r100);     // Catch: Exception -> L10
        ICJPayPbCallback r107 = new AnonymousClass5(r105, r103);     // Catch: Exception -> L10
        if (isUsingTTNet == false) goto L17;
        return postPbTTNet(r106, r101, r102, r107);
    L17:
        return null;
    L11:
        if (r103 == null) goto L17;
        Context r108 = CJPayHostInfo.applicationContext;
        if (r108 == null) goto L15;
        String r109 = r108.getResources().getString(R.string.cj_pay_network_exception);
    L16:
        r103.onFailure("-99", r109);
        goto L17
    L15:
        r109 = NET_ERROR_MESSAGE;
        goto L16
    }

    public static ICJPayRequest postJson(String r100, Map<String, String> r101, Map<String, String> r102, String r103, boolean r104, ICJPayCallback r105) {
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNetworkManager#postJsonOKHttp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNetworkManager#postJsonOKHttp", e);
        if (r105 == null) goto L20;
        r105.onFailure(generateFailureInfo());
    L20:
        logNetworkError(r100);
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        addCommonHeaderParams(r102);     // Catch: Exception -> L16
        if (r104 == false) goto L9;
        String r106 = getUrl(r100);     // Catch: Exception -> L16
    L11:
        if (isUsingTTNet == false) goto L15;
        return postJsonTTNet(r106, r101, r102, r103, r105);
    L15:
        return postJsonOKHttp(r106, r102, r103, r105);
    L9:
        r106 = r100;
        goto L11
    }

    public static ICJPayRequest postMultipartImageTTNet(final String r110, final Map<String, String> r111, Map<String, String> r112, List<byte[]> r113, JSONObject r114, boolean r115, final ICJPayCallback r116) {
        final long r100 = System.currentTimeMillis();
        addCommonHeaderParams(r112);
        if (r115 == false) goto L5;
        String r101 = getUrl(r110);
    L6:
        ve4.a.f554342a.getClass();
        String r102 = r101;
        return ((TTNetService) ve4.a.a(TTNetService.class)).postMultipartImageTTNet(r102, r111, r112, r113, r114, 5242880, new AnonymousClass7(r100, r111, r116, r110));
    L5:
        r101 = r110;
        goto L6
    }
}
