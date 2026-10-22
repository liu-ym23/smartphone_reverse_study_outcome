package com.android.ttcjpaysdk.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.adapter.ICJExternalEventCenterAdapter;
import com.android.ttcjpaysdk.base.adapter.ICJExternalLynxServiceAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayNetworkErrorAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.base.paynologin.CJBDPayWithoutLoginUtils;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.android.ttcjpaysdk.base.service.CJOuterPayCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.service.ICJPaySettingService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.ttcjpayapi.IBasicMode;
import com.android.ttcjpaysdk.ttcjpayapi.IBlockDialog;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostLoginService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostPrivacyService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJPayReleaseAll;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomActionListener;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomerServiceCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IGeneralPay;
import com.android.ttcjpaysdk.ttcjpayapi.IH5NotificationCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.ITTCJPayPhoneCarrierService;
import com.android.ttcjpaysdk.ttcjpayapi.ITTCJPayResultInterceptor;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayEvent;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayHostJSBMethodsInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayMonitor;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayObserver;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayResult;
import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper;
import com.bytedance.caijing.sdk.infra.base.api.container.SilentType;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.router.CJHostRouterService;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.core.b;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayCallBackCenter implements CJContext.a {
    private static final String TAG = "CJPayCallBackCenter";
    private static volatile CJPayCallBackCenter instance;
    private String appId;
    private IBasicMode basicModeInterface;
    private IBlockDialog blockDialog;
    private CJContext cjContext;
    private int currentCallbackId;
    private ICustomActionListener customActionListener;
    private ICustomerServiceCallback customerServiceCallback;
    private TTCJPayEvent event;
    private ICJExternalEventCenterAdapter externalEventCenterAdapter;
    private ICJExternalLynxServiceAdapter externalLynxServiceAdapter;
    private TTCJPayDoFaceLive faceLive;
    private IGeneralPay generalPay;
    private IH5NotificationCallback h5NotificationCallback;
    private final AtomicReference<IH5PayCallback> h5PayCallbackRef;
    private final HashMap<Integer, IH5PayCallback> h5SchemePayCallbackMap;
    private TTCJPayHostJSBMethodsInterface hostJSBMethodsInterface;
    private ICJHostLoginService hostLoginService;
    public final String hostSettingsConfig;
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final AtomicBoolean lifecycleRegistered;
    private TTCJPayLoadingAdapter loadingAdapter;
    private String merchantId;
    private TTCJPayMonitor monitor;
    private TTCJPayNetworkErrorAdapter networkErrorAdapter;
    private TTCJPayObserver observer;
    private ITTCJPayResultInterceptor observerInterceptor;
    private final ConcurrentHashMap<String, ITTCJPayResultInterceptor> observerInterceptorMap;
    private final Deque<TTCJPayObserver> observerStack;
    private TTCJPayOpenSchemeInterface openSchemeInterface;
    private TTCJPayOpenSchemeWithContextInterface openSchemeWithContextInterface;
    private String outerAid;
    private CJOuterPayCallback outerPayCallback;
    private volatile TTCJPayResult payResult;
    private ITTCJPayPhoneCarrierService phoneCarrierService;
    private ICJHostPrivacyService privacyService;
    private ICJPayReleaseAll releaseAllCallBack;
    private volatile int resumedCount;
    private volatile int rootActivityId;
    private final CJHostRouterService routerService;
    private JSONObject sCachedCreateOrderJSON;
    private String service;
    private final AtomicBoolean sessionActive;
    private TTCJPayToastAdapter toastAdapter;
    private String traceId;
    private JSONObject trackInfo;

    /* JADX INFO: loaded from: classes28.dex */
    public class OpenSchemaWithContextInterfaceProxy implements TTCJPayOpenSchemeWithContextInterface {
        private TTCJPayOpenSchemeWithContextInterface proxy;
        final /* synthetic */ CJPayCallBackCenter this$0;

        public static /* synthetic */ TTCJPayOpenSchemeWithContextInterface access$100(OpenSchemaWithContextInterfaceProxy r100) {
            return r100.proxy;
        }

        public OpenSchemaWithContextInterfaceProxy(CJPayCallBackCenter r100, TTCJPayOpenSchemeWithContextInterface r101) {
            this.this$0 = r100;
            this.proxy = r101;
        }

        @Override // com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface
        public void openScheme(final Context r110, String r111) {
            CJLogger.d(CJPayCallBackCenter.TAG, "OpenSchemaWithContextInterfaceProxy openScheme: scheme=" + r111);
            if (this.proxy == null) goto L35;
            ICJPaySettingService r100 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
            if (r100 != null) goto L7;
        L9:
            final String r101 = r111;
        L10:
            boolean r102 = false;
            ILivePluginHelper r103 = null;
            r102 = TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r111), "cjpay_check_live_plugin"), "1");     // Catch: Exception -> L15
            ve4.a.f554342a.getClass();     // Catch: Exception -> L15
            IContainerHostDepend r104 = (IContainerHostDepend) ve4.a.a(IContainerHostDepend.class);     // Catch: Exception -> L15
            if (r104 == null) goto L17;
            r103 = r104.getLivePluginHelper();     // Catch: Exception -> L15
        L17:
            if (r102 == false) goto L20;
            if (r103 == null) goto L20;
            r103.checkLiveAvailableAndInstall(new AnonymousClass1(this, r110, r101), SilentType.TYPE0);
        L31:
            HashMap r105 = new HashMap();     // Catch: Exception -> L28
            r105.put("schema", r111);     // Catch: Exception -> L28
            r105.put("new_schema", r101);     // Catch: Exception -> L28
            ve4.a.f554342a.getClass();     // Catch: Exception -> L28
            IContainerHostDepend r112 = (IContainerHostDepend) ve4.a.a(IContainerHostDepend.class);     // Catch: Exception -> L28
            if (r112 != null) goto L24;
        L26:
            CJReporter r113 = CJReporter.f202294a;     // Catch: Exception -> L28
            CJReporter.g(this.this$0.getCjContext(), "wallet_cashier_open_schema", r105, null, -1, false);     // Catch: Exception -> L28
            return;
        L24:
            if (r112.getLivePluginHelper() == null) goto L26;
            r105.put("is_live_plugin_ready", Boolean.valueOf(r112.getLivePluginHelper().hasPluginLoaded()));     // Catch: Exception -> L28
        L28:
            e = move-exception;
            CJLogger.b("openScheme", e.getMessage());
            return;
        L20:
            CJLogger.d(CJPayCallBackCenter.TAG, "this.proxy.openScheme, newSchema=" + r101);
            this.proxy.openScheme(r110, r101);
        L15:
            e = move-exception;
            CJLogger.b("openScheme", "" + e.getMessage());
            goto L17
        L7:
            if (TextUtils.isEmpty(r111) == true) goto L9;
            r101 = r100.appendSchemaParams(r111);
            goto L10
        }
    }

    public static /* synthetic */ void a(CJPayCallBackCenter r100, Context r101, String r102) {
        r100.lambda$getOpenSchemeWithContextInterface$0(r101, r102);
    }

    public void startSession() {
        this.sessionActive.set(true);     // Catch: Exception -> L27
    L38:
        this.rootActivityId = -1;     // Catch: Exception -> L28
    L34:
        this.resumedCount = 0;     // Catch: Exception -> L29
    L44:
        boolean r100 = CJPaySettingsManager.getInstance().isLifecycleGuardEnabled();     // Catch: Exception -> L10
    L11:
        if (r100 == true) goto L14;
        return;
    L14:
        if (this.lifecycleRegistered.compareAndSet(false, true) == true) goto L16;
        return;
    L16:
        Application r101 = CJEnv.a();
        if (r101 == null) goto L32;
        Application.ActivityLifecycleCallbacks r102 = new AnonymousClass3(this);
        this.lifecycleCallbacks = r102;
        r101.registerActivityLifecycleCallbacks(r102);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        CJLogger.b(TAG, "startSession: register lifecycle error " + e.getMessage());
        this.lifecycleRegistered.set(false);     // Catch: Exception -> L30
        return;
    L48:
        return;
    L32:
        this.lifecycleRegistered.set(false);     // Catch: Exception -> L31
        return;
    L46:
        return;
    L10:
        r100 = true;
        goto L11
    }

    private void clearCallbacks() {
        this.h5PayCallbackRef.set(null);     // Catch: Exception -> L4
        return;
    }

    public static CJPayCallBackCenter getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayCallBackCenter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayCallBackCenter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayCallBackCenter.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private JSONObject getSystemParams() {
        JSONObject r100 = new JSONObject();
        if (TextUtils.isEmpty(this.traceId) == true) goto L7;
        r100.put(BindCardPayConfirmConstants.Key.TRACE_ID, this.traceId);     // Catch: JSONException -> L13
    L7:
        if (TextUtils.isEmpty(this.outerAid) == true) goto L9;
        r100.put("outer_aid", this.outerAid);     // Catch: JSONException -> L13
    L9:
        r100.put("font_size", CJPayHostInfo.fontScale);     // Catch: JSONException -> L13
        Context r101 = CJPayHostInfo.applicationContext;     // Catch: JSONException -> L13
        if (r101 == null) goto L12;
        r100.put("package_name", r101.getPackageName());     // Catch: JSONException -> L13
    L12:
        return r100;
    }

    private void resetPayResult() {
        this.payResult = new TTCJPayResult();
        this.payResult.setCode(104);
    }

    private void uploadFaceInjectError() {
        onEvent("wallet_rd_face_inject_error", new JSONObject[]{CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId)});
    }

    public CJContext getCjContext() {
        if (this.cjContext != null) goto L5;
        Set<String> r100 = CJContext.f202254w;
        this.cjContext = CJContext.c.a("", "", "", new HashMap());
    L5:
        this.cjContext.b(this.hostSettingsConfig);
        return this.cjContext;
    }

    public IGeneralPay getGeneralPay() {
        if (this.generalPay != null) goto L8;
        ICJPayIntegratedCounterService r100 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r100 == null) goto L8;
        r100.ttcjPayInvokeInit();
    L8:
        return this.generalPay;
    }

    public IH5PayCallback getH5PayCallback() {
        return this.h5PayCallbackRef.get();
    }

    public TTCJPayOpenSchemeWithContextInterface getOpenSchemeWithContextInterface() {
        if (this.openSchemeWithContextInterface != null) goto L8;
        CJHostRouterService r100 = this.routerService;
        if (r100 == null) goto L8;
        this.openSchemeWithContextInterface = new OpenSchemaWithContextInterfaceProxy(this, r100.getOpenSchemeWithContextInterface());
    L8:
        if (CJPaySaasUtils.INSTANCE.checkIsCaijingSaasEnv() == false) goto L14;
        TTCJPayOpenSchemeWithContextInterface r101 = this.openSchemeWithContextInterface;
        if (r101 != null) goto L12;
        return r101;
    L12:
        return new AnonymousClass1(this);
    L14:
        if (CJBDPayWithoutLoginUtils.INSTANCE.isPayWithoutLogin() == false) goto L18;
        return new a(this);
    L18:
        return this.openSchemeWithContextInterface;
    }

    public void notifyPayResult() {
        if (this.payResult != null) goto L27;
        this.payResult = new TTCJPayResult();
        this.payResult.setCode(104);
    L27:
    L10:
        e = move-exception;
        CJLogger.c(TAG, " callbackInfo error", e);
    L12:
        JSONObject r100 = null;
    L14:
        if (getH5PayCallback() != null) goto L16;
        ITTCJPayResultInterceptor r101 = this.observerInterceptor;
        if (r101 != null) goto L23;
    L25:
        onIObserverPayResult("", this.payResult);
        return;
    L23:
        if (r101.onInterceptor(this.payResult) == false) goto L25;
        return;
    L16:
        if (this.payResult != null) goto L18;
        return;
    L18:
        if (this.payResult.getCode() == 110) goto L30;
        reportCallbackResult(this.payResult.getCode(), r100, "callback", false);
        handleH5Result(this.payResult);
        resetPayResult();
        this.cjContext.f202266l = null;
        clearCallbacks("delivered");
        this.trackInfo = null;
        return;
    L30:
        return;
    L7:
        if (this.payResult.getCallBackInfo() == null) goto L12;
        r100 = new JSONObject(this.payResult.getCallBackInfo());     // Catch: Exception -> L10
        goto L14
    }

    public void releaseAll() {
        ICJPayReleaseAll r100 = this.releaseAllCallBack;
        if (r100 == null) goto L6;
        r100.onReleaseAll();
        return;
    }

    private CJPayCallBackCenter() {
        this.observerStack = new ArrayDeque();
        this.observerInterceptorMap = new ConcurrentHashMap();
        this.h5PayCallbackRef = new AtomicReference(null);
        this.sessionActive = new AtomicBoolean(false);
        this.rootActivityId = -1;
        this.resumedCount = 0;
        this.lifecycleRegistered = new AtomicBoolean(false);
        this.h5SchemePayCallbackMap = new HashMap();
        this.currentCallbackId = 0;
        this.traceId = "";
        this.outerAid = "";
        this.sCachedCreateOrderJSON = null;
        ve4.a.f554342a.getClass();
        this.routerService = (CJHostRouterService) ve4.a.a(CJHostRouterService.class);
        this.hostSettingsConfig = ((CJHostService) ve4.a.d(CJHostService.class)).getHostSettingsConfig();
        b.f202286a = this;
    }

    public void release() {
        resetPayResult();
        this.trackInfo = null;
        this.outerAid = "";
        this.observerInterceptor = null;
    }

    public IBasicMode getBasicModeInterface() {
        return this.basicModeInterface;
    }

    public IBlockDialog getBlockDialog() {
        return this.blockDialog;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.core.CJContext.a
    public TTCJPayResult getCJPayResult() {
        return this.payResult;
    }

    public ICustomActionListener getCustomActionListener() {
        return this.customActionListener;
    }

    public ICustomerServiceCallback getCustomerServiceCallback() {
        return this.customerServiceCallback;
    }

    public TTCJPayEvent getEvent() {
        return this.event;
    }

    public ICJExternalEventCenterAdapter getExternalEventCenterAdapter() {
        return this.externalEventCenterAdapter;
    }

    public ICJExternalLynxServiceAdapter getExternalLynxServiceAdapter() {
        return this.externalLynxServiceAdapter;
    }

    public TTCJPayDoFaceLive getFaceLive() {
        return this.faceLive;
    }

    public IH5NotificationCallback getH5NotificationCallback() {
        return this.h5NotificationCallback;
    }

    public TTCJPayHostJSBMethodsInterface getHostJSBMethodsInterface() {
        return this.hostJSBMethodsInterface;
    }

    public ICJHostLoginService getHostLoginService() {
        return this.hostLoginService;
    }

    public ICJHostPrivacyService getHostPrivacyService() {
        return this.privacyService;
    }

    public TTCJPayLoadingAdapter getLoadingAdapter() {
        return this.loadingAdapter;
    }

    public TTCJPayMonitor getMonitor() {
        return this.monitor;
    }

    public TTCJPayNetworkErrorAdapter getNetworkErrorAdapter() {
        return this.networkErrorAdapter;
    }

    public TTCJPayObserver getObserver() {
        return this.observer;
    }

    public TTCJPayOpenSchemeInterface getOpenSchemeInterface() {
        return this.openSchemeInterface;
    }

    public String getOuterAid() {
        return this.outerAid;
    }

    public CJOuterPayCallback getOuterPayCallback() {
        return this.outerPayCallback;
    }

    public TTCJPayResult getPayResult() {
        return this.payResult;
    }

    public ITTCJPayPhoneCarrierService getPhoneCarrierService() {
        return this.phoneCarrierService;
    }

    public String getService() {
        return this.service;
    }

    public TTCJPayToastAdapter getToastAdapter() {
        return this.toastAdapter;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public JSONObject getTrackInfo() {
        return this.trackInfo;
    }

    public static /* synthetic */ TTCJPayOpenSchemeWithContextInterface access$000(CJPayCallBackCenter r100) {
        return r100.openSchemeWithContextInterface;
    }

    public static /* synthetic */ AtomicBoolean access$200(CJPayCallBackCenter r100) {
        return r100.sessionActive;
    }

    public static /* synthetic */ int access$300(CJPayCallBackCenter r100) {
        return r100.resumedCount;
    }

    public static /* synthetic */ int access$308(CJPayCallBackCenter r100) {
        int r101 = r100.resumedCount;
        r100.resumedCount = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$310(CJPayCallBackCenter r100) {
        int r101 = r100.resumedCount;
        r100.resumedCount = r101 - 1;
        return r101;
    }

    public static /* synthetic */ int access$400(CJPayCallBackCenter r100) {
        return r100.rootActivityId;
    }

    private void handleH5Result(TTCJPayResult r110) {
        IH5PayCallback r100 = getH5PayCallback();
        if (r100 == null) goto L119;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.getCode() != 0) goto L9;
        int r101 = 0;
        String r102 = "支付成功";
    L91:
        if (r110.getCallBackInfo() == null) goto L101;
        if (r110.getCallBackInfo().containsKey("front_standard_data") == false) goto L101;
        JSONObject r103 = new JSONObject(r110.getCallBackInfo().get("front_standard_data"));     // Catch: Throwable -> L96 Exception -> L111
        r103.put("result_msg", r102);     // Catch: Throwable -> L96 Exception -> L111
        r103.put(BytedCertConstant.CertKey.SDK_CODE, r101);     // Catch: Throwable -> L96 Exception -> L111
        r103.put("sdk_msg", r102);     // Catch: Throwable -> L96 Exception -> L111
        r102 = r103.toString();     // Catch: Throwable -> L96 Exception -> L111
    L96:
        th = move-exception;
        r110.getCallBackInfo().remove("front_standard_data");
        throw th;
    L99:
        r110.getCallBackInfo().remove("front_standard_data");
    L106:
        setCreateOrderResponseJSON(null);
        uploadWalletCashierSdk(r110.getCode(), r102);
        if (r101 != 0) goto L115;
    L109:
        r100.onResult(r101, r102);     // Catch: Exception -> L112
        return;
    L121:
        return;
    L115:
        CJLogger.d("payjsb", r101 + "," + r102);     // Catch: Exception -> L112
    L101:
        if (this.sCachedCreateOrderJSON == null) goto L106;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L104
        r104.put("create_order_response", this.sCachedCreateOrderJSON);     // Catch: JSONException -> L104
        r104.put("result_msg", r102);     // Catch: JSONException -> L104
        r104.put(BytedCertConstant.CertKey.SDK_CODE, r101);     // Catch: JSONException -> L104
        r104.put("sdk_msg", r102);     // Catch: JSONException -> L104
        r102 = r104.toString();     // Catch: JSONException -> L104
    L104:
        e = move-exception;
        CJLogger.b("handleH5Result", e.toString());
        goto L106
    L9:
        if (r110.getCode() != 103) goto L22;
        if (r110.getCallBackInfo() == null) goto L19;
        String r105 = r110.getCallBackInfo().get("fail_desc");
        if (r105 != null) goto L15;
    L17:
        r105 = "支付超时";
    L18:
        r102 = r105;
    L20:
        r101 = 1;
        goto L91
    L15:
        if (r105.isEmpty() == true) goto L17;
    L19:
        r102 = "支付超时";
        goto L20
    L22:
        if (r110.getCode() == 102) goto L24;
        r102 = "支付取消";
        if (r110.getCode() != 104) goto L38;
        r101 = 4;
        goto L91
    L38:
        if (r110.getCode() != 101) goto L41;
        r101 = 9;
        r102 = "支付处理中";
        goto L91
    L41:
        if (r110.getCode() != 109) goto L44;
        r102 = "网络错误";
        r101 = 109;
        goto L91
    L44:
        if (r110.getCode() != 112) goto L47;
        r102 = "参数非法";
        r101 = 112;
        goto L91
    L47:
        if (r110.getCode() != 113) goto L50;
        r101 = 113;
        goto L91
    L50:
        if (r110.getCode() != 116) goto L53;
        r102 = "刷单风控弹窗取消支付";
        r101 = 116;
        goto L91
    L53:
        if (r110.getCode() != 117) goto L56;
        r102 = "用户手动切回前台";
        r101 = 117;
        goto L91
    L56:
        if (r110.getCode() != 118) goto L59;
        r102 = "亲友银行卡邀请成功";
        r101 = 118;
        goto L91
    L59:
        if (r110.getCode() != 119) goto L62;
        r102 = "";
        r101 = 119;
        goto L91
    L62:
        if (r110.getCode() != 4100) goto L65;
        r102 = "绑卡成功";
        r101 = 4100;
        goto L91
    L65:
        if (r110.getCode() != 4101) goto L68;
        r102 = "绑卡失败";
        r101 = 4101;
        goto L91
    L68:
        if (r110.getCode() != 4102) goto L71;
        r102 = "绑卡取消";
        r101 = 4102;
        goto L91
    L71:
        if (r110.getCode() != 4103) goto L74;
        r102 = "调起绑卡失败";
        r101 = 4103;
        goto L91
    L74:
        if (r110.getCode() != 4110) goto L77;
        r101 = 4110;
        r102 = "登录失败";
        goto L91
    L77:
        if (r110.getCode() != 4111) goto L81;
        r102 = "参数非法";
    L79:
        r101 = 4111;
        goto L91
    L81:
        if (r110.getCode() != 4199) goto L84;
        r102 = "网络错误";
        goto L79
    L84:
        if (r110.getCode() != 5000) goto L87;
        r101 = 5000;
        r102 = "创建订单错误";
        goto L91
    L87:
        if (r110.getCode() != 5001) goto L89;
        r101 = 5001;
        r102 = "创建订单成功，跳过支付";
        goto L91
    L89:
        r102 = "";
        r101 = 104;
        goto L91
    L24:
        if (r110.getCallBackInfo() == null) goto L32;
        String r106 = r110.getCallBackInfo().get("fail_desc");
        if (r106 != null) goto L28;
    L30:
        r106 = "支付失败";
    L31:
        r102 = r106;
    L33:
        r101 = 2;
        goto L91
    L28:
        if (r106.isEmpty() == true) goto L30;
    L32:
        r102 = "支付失败";
        goto L33
    }

    public int addH5Callback(IH5PayCallback r100) {
        if (r100 == null) goto L5;
        HashMap<Integer, IH5PayCallback> r101 = this.h5SchemePayCallbackMap;
        int r102 = this.currentCallbackId + 1;
        this.currentCallbackId = r102;
        r101.put(Integer.valueOf(r102), r100);
        return this.currentCallbackId;
    L5:
        return -1;
    }

    public void clearCallbacks(String r100) {
        CJLogger.d(TAG, "clearCallbacks: reason=".concat(String.valueOf(r100)));
        clearCallbacks();     // Catch: Exception -> L22
    L33:
        this.sessionActive.set(false);     // Catch: Exception -> L23
    L31:
        this.rootActivityId = -1;     // Catch: Exception -> L24
    L29:
        this.resumedCount = 0;     // Catch: Exception -> L25
    L35:
    L17:
        e = move-exception;
        CJLogger.b(TAG, "clearCallbacks: unregister lifecycle error " + e.getMessage());
    L27:
        this.lifecycleRegistered.set(false);     // Catch: Exception -> L26
    L20:
        this.lifecycleCallbacks = null;
        return;
    L10:
        if (this.lifecycleRegistered.get() == false) goto L27;
        Application r101 = CJEnv.a();     // Catch: Exception -> L17
        if (r101 == null) goto L27;
        Application.ActivityLifecycleCallbacks r102 = this.lifecycleCallbacks;     // Catch: Exception -> L17
        if (r102 == null) goto L27;
        r101.unregisterActivityLifecycleCallbacks(r102);     // Catch: Exception -> L17
        goto L27
    }

    public IH5PayCallback getAndRemoveCallbackById(int r100) {
        Boolean r101 = Boolean.FALSE;
        r101 = Boolean.valueOf(CJPaySettingsManager.getInstance().getWebViewCommonConfig().get_and_remove_close_callback);     // Catch: Exception -> L5
    L7:
        CJLogger.d(TAG, "[getAndRemoveCallbackById] isRemove=" + r101 + "、callcallbackId=" + r100);
        if (r101.booleanValue() == false) goto L12;
        return this.h5SchemePayCallbackMap.remove(Integer.valueOf(r100));
    L12:
        return this.h5SchemePayCallbackMap.get(Integer.valueOf(r100));
    L5:
        e = move-exception;
        CJLogger.b(TAG, "[getAndRemoveCallbackById] error: " + e.getMessage());
        goto L7
    }

    public JSONObject getTrackParams(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L13;
    L22:
        return r101;
    L5:
        if (r100.length <= 0) goto L13;
        int r102 = r100.length;     // Catch: Throwable -> L23
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        JSONObject r104 = r100[r103];     // Catch: Throwable -> L23
        if (r104 == null) goto L11;
        putKeyValues(r104, r101);     // Catch: Throwable -> L23
    L11:
        r103 = r103 + 1;     // Catch: Throwable -> L23
    L13:
        String r105 = "";
        if (r101.has(e.f25671s) == false) goto L16;
        r105 = r101.optString(e.f25671s, "");     // Catch: Throwable -> L23
    L16:
        JSONObject r106 = this.trackInfo;     // Catch: Throwable -> L23
        if (r106 == null) goto L19;
        putKeyValues(r106, r101);     // Catch: Throwable -> L23
    L19:
        putKeyValues(getSystemParams(), r101);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r105) == true) goto L22;
        r101.put(e.f25671s, r105);     // Catch: Throwable -> L23
        goto L22
    }

    public void init(ICJPayReleaseAll r100) {
        this.releaseAllCallBack = r100;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.core.CJContext.a
    public void onNotifyPayResult(CJContext r100) {
        IH5PayCallback r101 = r100.f202266l;     // Catch: Exception -> L5
    L6:
        IH5PayCallback r102 = getH5PayCallback();
        if (r101 == null) goto L10;
        if (r101 != r102) goto L10;
        clearCallbacks("delivered");
    L10:
        CJContext r103 = this.cjContext;
        if (r103 != r100) goto L19;
        r103.f202266l = null;     // Catch: Exception -> L14
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void release(int r100) {
        IH5PayCallback r101 = this.h5SchemePayCallbackMap.remove(Integer.valueOf(r100));
        StringBuilder r102 = new StringBuilder("[release] callbackId=");
        r102.append(r100);
        r102.append("、removed=");
        if (r101 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        CJLogger.d(TAG, r102.toString());
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void removePayResultNotifyInterceptor(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.observerInterceptorMap.remove(r100);
    L5:
        this.observerInterceptor = null;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setBasicModeInterface(IBasicMode r100) {
        this.basicModeInterface = r100;
    }

    public void setBlockDialog(IBlockDialog r100) {
        this.blockDialog = r100;
    }

    public void setCJContext(CJContext r100) {
        this.cjContext = r100;
    }

    public CJPayCallBackCenter setCallBackInfo(Map<String, String> r100) {
        CJContext r101 = com.bytedance.caijing.sdk.infra.base.core.a.f202280a;
        if (r101 == null) goto L6;
        r101.f202262h.setCallBackInfo(r100);
    L6:
        if (this.payResult != null) goto L8;
        this.payResult = new TTCJPayResult();
    L8:
        this.payResult.setCallBackInfo(r100);
        return this;
    }

    public void setCreateOrderResponseJSON(JSONObject r100) {
        this.sCachedCreateOrderJSON = r100;
    }

    public void setCustomActionListener(ICustomActionListener r100) {
        this.customActionListener = r100;
    }

    public void setCustomerServiceCallback(ICustomerServiceCallback r100) {
        this.customerServiceCallback = r100;
    }

    public void setEvent(TTCJPayEvent r100) {
        this.event = r100;
    }

    public void setExternalEventCenterAdapter(ICJExternalEventCenterAdapter r100) {
        this.externalEventCenterAdapter = r100;
    }

    public void setExternalLynxServiceAdapter(ICJExternalLynxServiceAdapter r100) {
        this.externalLynxServiceAdapter = r100;
    }

    public void setFaceLive(TTCJPayDoFaceLive r100) {
        this.faceLive = r100;
    }

    public void setGeneralPay(IGeneralPay r100) {
        this.generalPay = r100;
    }

    public void setH5NotificationCallback(IH5NotificationCallback r100) {
        this.h5NotificationCallback = r100;
    }

    public void setH5PayCallback(IH5PayCallback r100) {
        getInstance().startSession();
        this.h5PayCallbackRef.set(r100);
    }

    public void setHostJSBMethodsInterface(TTCJPayHostJSBMethodsInterface r100) {
        this.hostJSBMethodsInterface = r100;
    }

    public void setHostLoginService(ICJHostLoginService r100) {
        this.hostLoginService = r100;
    }

    public void setHostPrivacyService(ICJHostPrivacyService r100) {
        this.privacyService = r100;
    }

    public void setLoadingAdapter(TTCJPayLoadingAdapter r100) {
        this.loadingAdapter = r100;
    }

    public void setMerchantId(String r100) {
        this.merchantId = r100;
    }

    public void setMonitor(TTCJPayMonitor r100) {
        this.monitor = r100;
    }

    public void setNetworkErrorAdapter(TTCJPayNetworkErrorAdapter r100) {
        this.networkErrorAdapter = r100;
    }

    public void setObserver(TTCJPayObserver r100) {
        this.observer = r100;
        if (r100 == null) goto L16;
        Deque<TTCJPayObserver> r101 = this.observerStack;
        monitor-enter(r101);
        this.observerStack.push(r100);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L8
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.f202302i = new AnonymousClass2(this);
        return;
    L10:
        e = move-exception;
        CJLogger.c(TAG, "setObserver", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L16:
        CJReporter r103 = CJReporter.f202294a;
        CJReporter.f202302i = null;
    }

    public void setOpenSchemeInterface(TTCJPayOpenSchemeInterface r100) {
        this.openSchemeInterface = r100;
    }

    public void setOpenSchemeWithContextInterface(TTCJPayOpenSchemeWithContextInterface r100) {
        this.openSchemeWithContextInterface = new OpenSchemaWithContextInterfaceProxy(this, r100);
    }

    public void setOuterAid(String r100) {
        this.outerAid = r100;
    }

    public void setOuterPayCallback(CJOuterPayCallback r100) {
        this.outerPayCallback = r100;
    }

    public void setPhoneCarrierService(ITTCJPayPhoneCarrierService r100) {
        this.phoneCarrierService = r100;
    }

    public CJPayCallBackCenter setResultCode(int r100) {
        CJContext r101 = com.bytedance.caijing.sdk.infra.base.core.a.f202280a;
        if (r101 == null) goto L6;
        r101.m(r100);
    L6:
        if (this.payResult != null) goto L8;
        this.payResult = new TTCJPayResult();
    L8:
        this.payResult.setCode(r100);
        return this;
    }

    public void setService(String r100) {
        this.service = r100;
    }

    public void setToastAdapter(TTCJPayToastAdapter r100) {
        this.toastAdapter = r100;
    }

    public void setTraceId(String r100) {
        this.traceId = r100;
    }

    public void setTrackInfo(JSONObject r100) {
        this.trackInfo = r100;
    }

    public static /* synthetic */ int access$302(CJPayCallBackCenter r100, int r101) {
        r100.resumedCount = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(CJPayCallBackCenter r100, int r101) {
        r100.rootActivityId = r101;
        return r101;
    }

    private /* synthetic */ void lambda$getOpenSchemeWithContextInterface$0(Context r100, String r101) {
        this.openSchemeWithContextInterface.openScheme(r100, CJBDPayWithoutLoginUtils.INSTANCE.appendParams(r101));
    }

    private void putKeyValues(JSONObject r100, JSONObject r101) {
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();     // Catch: JSONException -> L7
        r101.put(r103, r100.opt(r103));     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        CJLogger.b(TAG, "putKeyValues: " + e.getMessage());
        goto L4
    }

    private void uploadWalletCashierSdk(int r100, String r101) {
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId);
        r102.put("error_code", r100);     // Catch: Exception -> L9
        r102.put("service", this.service);     // Catch: Exception -> L9
        r102.put("error_message", r101);     // Catch: Exception -> L9
        if (r100 != 0) goto L6;
        int r103 = 1;
    L7:
        r102.put("result", r103);     // Catch: Exception -> L9
        goto L10
    L6:
        r103 = 0;
    L10:
        JSONObject[] r104 = new JSONObject[2];
        r104[0] = r102;
        JSONObject r105 = this.trackInfo;
        if (r105 != null) goto L14;
        r105 = new JSONObject();
    L14:
        r104[1] = r105;
        onEvent("wallet_cashier_callback_sdk", r104);
        this.merchantId = "";
        this.appId = "";
        this.service = "";
    }

    public void onEvent(String r110, JSONObject... r111) {
        JSONObject r100 = new JSONObject();
        int r101 = r111.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        putKeyValues(r111[r102], r100);
        r102 = r102 + 1;
        goto L3
    L6:
        if (r100.has(e.f25671s) == false) goto L8;
        String r103 = r100.optString(e.f25671s, "");
    L9:
        JSONObject r104 = this.trackInfo;
        if (r104 == null) goto L12;
        putKeyValues(r104, r100);
    L12:
        putKeyValues(getSystemParams(), r100);
        CJContext r105 = this.cjContext;
        if (r105 != null) goto L15;
        Set<String> r106 = CJContext.f202254w;
        r105 = CJContext.c.a("", "", "", new HashMap());
    L15:
        CJContext r107 = r105;
        if (TextUtils.isEmpty(r103) == false) goto L21;
    L18:
        CJReporter r112 = CJReporter.f202294a;
        CJReporter.g(r107, r110, CJPayBasicUtils.Json2Map(r100), null, -1, false);
        return;
    L21:
        r100.put(e.f25671s, r103);     // Catch: JSONException -> L20
        goto L18
    L8:
        r103 = "";
        goto L9
    }

    @Override // com.bytedance.caijing.sdk.infra.base.core.CJContext.a
    public boolean onIObserverPayResult(String r100, TTCJPayResult r101) {
        boolean r102 = false;
        if (this.observer == null) goto L38;
        if (r101 == null) goto L38;
    L10:
        e = move-exception;
        CJLogger.c(TAG, " callbackInfo error", e);
    L12:
        JSONObject r103 = null;
    L13:
        CJLogger.d(TAG, "payResult:" + r101.getCode() + "," + Log.getStackTraceString(new Throwable()));
        Deque<TTCJPayObserver> r104 = this.observerStack;
        monitor-enter(r104);
    L31:
        e = move-exception;
        CJLogger.c(TAG, "onIObserverPayResult", e);     // Catch: Throwable -> L29
    L33:
        monitor-exit(r104);     // Catch: Throwable -> L29
        reportCallbackResult(r101.getCode(), r103, "observer", r102);
        this.observer.onPayCallback(r101);
        resetPayResult();
        return true;
    L29:
        th = move-exception;
        throw th;
    L17:
        if (this.observerStack.isEmpty() == false) goto L19;
        TTCJPayObserver r105 = null;
    L21:
        if (r101.getCode() != 110) goto L23;
    L26:
        if (r105 == this.observer) goto L33;
        r102 = true;
        goto L33
    L23:
        if (this.observerStack.isEmpty() == true) goto L25;
        this.observerStack.pop();     // Catch: Throwable -> L29 Exception -> L31
    L25:
        this.trackInfo = null;     // Catch: Throwable -> L29 Exception -> L31
        goto L26
    L19:
        r105 = this.observerStack.getFirst();     // Catch: Throwable -> L29 Exception -> L31
        goto L21
    L7:
        if (r101.getCallBackInfo() == null) goto L12;
        r103 = new JSONObject(r101.getCallBackInfo());     // Catch: Exception -> L10
    L38:
        return false;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.core.CJContext.a
    public boolean onITTCJPayResultInterceptor(String r100, TTCJPayResult r101) {
        ITTCJPayResultInterceptor r102 = this.observerInterceptorMap.get(r100);
        if (r102 != null) goto L5;
        ITTCJPayResultInterceptor r103 = this.observerInterceptor;
        if (r103 != null) goto L9;
        return false;
    L9:
        return r103.onInterceptor(r101);
    L5:
        return r102.onInterceptor(r101);
    }

    public void onMonitor(String r100, JSONObject r110) {
        CJContext r101 = this.cjContext;
        if (r101 != null) goto L5;
        Set<String> r102 = CJContext.f202254w;
        r101 = CJContext.c.a("", "", "", new HashMap());
    L5:
        CJContext r103 = r101;
        CJReporter r104 = CJReporter.f202294a;
        CJReporter.n(r103, r100, CJPayBasicUtils.Json2Map(r110), null, -1, true);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.core.CJContext.a
    public void onUploadWalletCashierSdk(int r100, String r101) {
        uploadWalletCashierSdk(r100, r101);
    }

    public CJPayCallBackCenter setCallBackInfo(CJContext r100, Map<String, String> r101) {
        if (r100 == null) goto L5;
        r100.f202262h.setCallBackInfo(r101);
    L5:
        return setCallBackInfo(r101);
    }

    public void setPayResultNotifyInterceptorForMap(String r100, ITTCJPayResultInterceptor r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.observerInterceptorMap.put(r100, r101);
    L5:
        this.observerInterceptor = r101;
    }

    public CJPayCallBackCenter setResultCode(CJContext r100, int r101) {
        if (r100 == null) goto L5;
        r100.m(r101);
    L5:
        if (this.payResult != null) goto L7;
        this.payResult = new TTCJPayResult();
    L7:
        this.payResult.setCode(r101);
        return this;
    }

    public void setTraceId(String r100, CJContext r101) {
        this.traceId = r100;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "traceId");
        r101.f202271q = r100;
        return;
    }

    public void submitEventForCJReporter(String r100, JSONObject r101) {
        if (this.observer == null) goto L6;
        Map<String, String> r102 = CJPayBasicUtils.Json2Map(r101);
        this.observer.onEvent(r100, r102);
        return;
    L6:
        if (CJPayPerformance.getInstance().isInstallAppLog() == false) goto L10;
        CJPayPerformance.getInstance().onAppLogEvent(r100, r101);
        return;
    }

    public void doFaceLive(Activity r100, Map<String, String> r101, TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r102) {
        TTCJPayDoFaceLive r103 = this.faceLive;
        if (r103 == null) goto L5;
        r103.doFaceLive(r100, r101, r102);
        return;
    L5:
        if (r102 == null) goto L14;
        String r104 = r100.getString(R.string.cj_pay_server_error_toast);     // Catch: JSONException -> L8
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L8
        r105.put("success", false);     // Catch: JSONException -> L8
        r105.put("errorMsg", r104);     // Catch: JSONException -> L8
        r105.put("errorCode", "-9999");     // Catch: JSONException -> L8
        r102.onResult(r105);     // Catch: JSONException -> L8
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L8
        r106.put("errorMsg", r104);     // Catch: JSONException -> L8
        r106.put("errorCode", "-9999");     // Catch: JSONException -> L8
        uploadFaceInjectError();     // Catch: JSONException -> L8
        onMonitor("wallet_rd_call_cert_sdk_failed", r106);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void uploadExceptionLog(String r100, String r101, String r102) {
        uploadExceptionLog(r100, r101, r102, "", "");
    }

    private void reportCallbackResult(int r100, JSONObject r110, String r111, boolean r112) {
        CJContext r101 = this.cjContext;
        if (r101 != null) goto L5;
        Set<String> r102 = CJContext.f202254w;
        r101 = CJContext.c.a("", "", "", new HashMap());
    L5:
        CJContext r103 = r101;
        HashMap r104 = new HashMap();
        r104.put("result", Integer.valueOf(r100));
        r104.put("from", r111);
        if (r110 != null) goto L8;
        String r105 = "null";
    L9:
        r104.put("callbackInfo", r105);
        r104.put("observerProblem", Boolean.valueOf(r112));
        CJReporter r106 = CJReporter.f202294a;
        CJReporter.g(r103, "wallet_rd_pay_result_callback", r104, null, -1, true);
        return;
    L8:
        r105 = r110.toString();
        goto L9
    }

    public void onMonitor(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        CJPaySDKMonitor.monitorEvent(r100, r101, r102, r103);
        TTCJPayMonitor r104 = this.monitor;
        if (r104 == null) goto L6;
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    L6:
        if (CJPayPerformance.getInstance().isInstallApmMonitor() == false) goto L10;
        CJPayPerformance.getInstance().onApmMonitorEvent(r100, r101, r102, r103);
        return;
    }

    public void uploadExceptionLog(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L4
        r105.put("tag", r100);     // Catch: Exception -> L4
        r105.put("method_name", r101);     // Catch: Exception -> L4
        r105.put("error_msg", r102);     // Catch: Exception -> L4
        r105.put("error_code", r103);     // Catch: Exception -> L4
        r105.put("ext", r104);     // Catch: Exception -> L4
        onMonitor("wallet_rd_exception_log", r105);     // Catch: Exception -> L4
        return;
    }
}
