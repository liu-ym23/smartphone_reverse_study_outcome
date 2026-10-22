package com.bytedance.android.shopping.buynow.viewmodel;

import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import ul.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ)\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\nJG\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\bH\u0014R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R*\u0010>\u001a\n\u0018\u00010<j\u0004\u0018\u0001`=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bD\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010U\u001a\u0004\b\u0013\u0010V\"\u0004\bW\u0010XR,\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010PR$\u0010_\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010P\u001a\u0004\bf\u0010R\"\u0004\bg\u0010TR(\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010E\u001a\u0004\bp\u0010F\"\u0004\bq\u0010HR$\u0010r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010P\u001a\u0004\bs\u0010R\"\u0004\bt\u0010TR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010E\u001a\u0004\bz\u0010F\"\u0004\b{\u0010HR%\u0010}\u001a\u00020|8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R&\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010P\u001a\u0005\b\u0083\u0001\u0010R\"\u0005\b\u0084\u0001\u0010TR\u0018\u0010\u0085\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010JR&\u0010\u0086\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010E\u001a\u0005\b\u0087\u0001\u0010F\"\u0005\b\u0088\u0001\u0010HR,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010E\u001a\u0005\b\u0098\u0001\u0010F\"\u0005\b\u0099\u0001\u0010HR\u001a\u0010\u009a\u0001\u001a\u00020\n8\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010P\u001a\u0005\b\u009b\u0001\u0010RR&\u0010\u009c\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010E\u001a\u0005\b\u009d\u0001\u0010F\"\u0005\b\u009e\u0001\u0010HR\u001d\u0010 \u0001\u001a\u00030\u009f\u00018\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R)\u0010¤\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R&\u0010ª\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010E\u001a\u0005\bª\u0001\u0010F\"\u0005\b«\u0001\u0010H¨\u0006®\u0001"}, d2 = {"Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowState;", "defaultState", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "", "isQuery", "", "updateTrackerCommonParams", "", "status", "updateCheckStatus", "getCheckStatus", "handleAsyncEvent", "Lorg/json/JSONObject;", "param", "saveAsyncEventParam", "getAsyncEventparam", "isNoPwdCombined", "", d.D, "setCreateOrderLoadingData", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "checkParams", "setCurCheckParams", "triggerOrigin", "trackRequestStartCheckPoint", "success", "Lma3/b;", "response", "editOperatorType", "", "httpExceptionStatusCode", "", LynxError.LYNX_THROWABLE, "trackRequestEndCheckPoint", "(ZZLma3/b;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "onCleared", "Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "staticState", "Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "getStaticState", "()Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "Lul/f;", "skuPageState", "Lul/f;", "getSkuPageState", "()Lul/f;", "Lcom/bytedance/android/shopping/buynow/tracker/a;", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Lcom/bytedance/android/shopping/buynow/tracker/a;", "getTracker", "()Lcom/bytedance/android/shopping/buynow/tracker/a;", "Lcom/bytedance/android/shopping/sku/common/ability/b;", "skuService", "Lcom/bytedance/android/shopping/sku/common/ability/b;", "getSkuService", "()Lcom/bytedance/android/shopping/sku/common/ability/b;", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "Lcom/bytedance/kmp/ec/yata/YaTaInstance;", "yataInstance", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "getYataInstance", "()Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "setYataInstance", "(Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;)V", "isResumed", "Z", "()Z", "setResumed", "(Z)V", "addOnParams", "Lorg/json/JSONObject;", "getAddOnParams", "()Lorg/json/JSONObject;", "setAddOnParams", "(Lorg/json/JSONObject;)V", "addOnType", "Ljava/lang/String;", "getAddOnType", "()Ljava/lang/String;", "setAddOnType", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setNoPwdCombined", "(Ljava/lang/Boolean;)V", "Ljava/util/Map;", "getSdkInfo", "()Ljava/util/Map;", "setSdkInfo", "(Ljava/util/Map;)V", "curCheckStatus", "availability", "Ljava/lang/Integer;", "getAvailability", "()Ljava/lang/Integer;", "setAvailability", "(Ljava/lang/Integer;)V", "pageStartupStatus", "getPageStartupStatus", "setPageStartupStatus", "Ljava/util/Stack;", "currentShownPopupCodes", "Ljava/util/Stack;", "getCurrentShownPopupCodes", "()Ljava/util/Stack;", "setCurrentShownPopupCodes", "(Ljava/util/Stack;)V", "needToast", "getNeedToast", "setNeedToast", "failMsg", "getFailMsg", "setFailMsg", "Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "getCheckParams", "()Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "setCheckParams", "(Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;)V", "isPageLoading", "setPageLoading", "", "editStartTime", "J", "getEditStartTime", "()J", "setEditStartTime", "(J)V", "getEditOperatorType", "setEditOperatorType", "asyncTradeEventParam", "submitStatusFlag", "getSubmitStatusFlag", "setSubmitStatusFlag", "Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "ultimateBuyParams", "Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "getUltimateBuyParams", "()Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "setUltimateBuyParams", "(Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;)V", "Lcom/bytedance/android/shopping/buynow/starter/b;", "buyNowPageConfig", "Lcom/bytedance/android/shopping/buynow/starter/b;", "getBuyNowPageConfig", "()Lcom/bytedance/android/shopping/buynow/starter/b;", "setBuyNowPageConfig", "(Lcom/bytedance/android/shopping/buynow/starter/b;)V", "hasCheck", "getHasCheck", "setHasCheck", "continuePayPreSessionId", "getContinuePayPreSessionId", "hasReportDismiss", "getHasReportDismiss", "setHasReportDismiss", "Lcom/bytedance/android/shopping/sku/common/controller/a;", "asyncTwoStageController", "Lcom/bytedance/android/shopping/sku/common/controller/a;", "getAsyncTwoStageController", "()Lcom/bytedance/android/shopping/sku/common/controller/a;", DBDefinition.RETRY_COUNT, "I", "getRetryCount", "()I", "setRetryCount", "(I)V", "isAutoRetry", "setAutoRetry", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowViewModel extends JediViewModel<BuyNowState> {
    private JSONObject addOnParams;
    private String addOnType;
    private JSONObject asyncTradeEventParam;
    private final com.bytedance.android.shopping.sku.common.controller.a asyncTwoStageController;
    private Integer availability;
    private com.bytedance.android.shopping.buynow.starter.b buyNowPageConfig;
    private com.bytedance.android.shopping.buynow.eventcenter.handle.a checkParams;
    private final String continuePayPreSessionId;
    private String curCheckStatus;
    private Stack<String> currentShownPopupCodes;
    private String editOperatorType;
    private long editStartTime;
    private String failMsg;
    private boolean hasCheck;
    private boolean hasReportDismiss;
    private boolean isAutoRetry;
    private Boolean isNoPwdCombined;
    private boolean isPageLoading;
    private boolean isResumed;
    private boolean needToast;
    private String pageStartupStatus;
    private int retryCount;
    private Map<?, ?> sdkInfo;
    private final f skuPageState;
    private final com.bytedance.android.shopping.sku.common.ability.b skuService;
    private final a staticState;
    private boolean submitStatusFlag;
    private final com.bytedance.android.shopping.buynow.tracker.a tracker;
    private UltimateBuyParams ultimateBuyParams;
    private AndroidYaTaInstance yataInstance;

    @Override // com.bytedance.jedi.arch.JediViewModel
    public BuyNowState defaultState() {
        return new BuyNowState(null);
    }

    @Override // com.bytedance.jedi.arch.JediViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.f171010e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.f171009d = null;
        super.onCleared();
    }

    public BuyNowViewModel() {
        this.staticState = new a(0);
        this.skuPageState = new f();
        this.tracker = new com.bytedance.android.shopping.buynow.tracker.a(this);
        int r100 = SkuCommonAbility.f182612j;
        SkuAbilityType r101 = SkuAbilityType.BUYNOW;
        Intrinsics.checkNotNullParameter(r101, "type");
        this.skuService = new SkuCommonAbility(r101);
        this.addOnParams = new JSONObject();
        this.addOnType = "";
        this.curCheckStatus = "Init";
        this.pageStartupStatus = "loading";
        this.currentShownPopupCodes = new Stack();
        this.needToast = true;
        this.editOperatorType = "";
        this.asyncTradeEventParam = new JSONObject();
        this.submitStatusFlag = true;
        this.buyNowPageConfig = new com.bytedance.android.shopping.buynow.starter.b(false, false, false, 0.0f, 15);
        this.continuePayPreSessionId = UUID.randomUUID().toString();
        this.asyncTwoStageController = new com.bytedance.android.shopping.sku.common.controller.a();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Map] */
    public final void handleAsyncEvent() {
        if (getAsyncEventparam().length() > 0) goto L5;
        return;
    L5:
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = MapsKt.emptyMap();
        com.bytedance.android.shopping.buynow.monitor.error.a.f(this.tracker, "receive_params_from_jsb", null, new AnonymousClass1(this, r100));
        AndroidYaTaInstance r101 = this.yataInstance;
        if (r101 == null) goto L8;
        r101.k().d(e.f251660a.a(r101, null, com.bytedance.android.shopping.buynow.controller.e.f170832a, getAsyncEventparam().optString("type"), (Map) r100.element, "handleAsyncEvent"));
    L8:
        saveAsyncEventParam(new JSONObject());
    }

    public final JSONObject getAddOnParams() {
        return this.addOnParams;
    }

    public final String getAddOnType() {
        return this.addOnType;
    }

    public final JSONObject getAsyncEventparam() {
        return this.asyncTradeEventParam;
    }

    public final com.bytedance.android.shopping.sku.common.controller.a getAsyncTwoStageController() {
        return this.asyncTwoStageController;
    }

    public final Integer getAvailability() {
        return this.availability;
    }

    public final com.bytedance.android.shopping.buynow.starter.b getBuyNowPageConfig() {
        return this.buyNowPageConfig;
    }

    public final com.bytedance.android.shopping.buynow.eventcenter.handle.a getCheckParams() {
        return this.checkParams;
    }

    public final String getCheckStatus() {
        return this.curCheckStatus;
    }

    public final String getContinuePayPreSessionId() {
        return this.continuePayPreSessionId;
    }

    public final Stack<String> getCurrentShownPopupCodes() {
        return this.currentShownPopupCodes;
    }

    public final String getEditOperatorType() {
        return this.editOperatorType;
    }

    public final long getEditStartTime() {
        return this.editStartTime;
    }

    public final String getFailMsg() {
        return this.failMsg;
    }

    public final boolean getHasCheck() {
        return this.hasCheck;
    }

    public final boolean getHasReportDismiss() {
        return this.hasReportDismiss;
    }

    public final boolean getNeedToast() {
        return this.needToast;
    }

    public final String getPageStartupStatus() {
        return this.pageStartupStatus;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final Map<?, ?> getSdkInfo() {
        return this.sdkInfo;
    }

    public final f getSkuPageState() {
        return this.skuPageState;
    }

    public final com.bytedance.android.shopping.sku.common.ability.b getSkuService() {
        return this.skuService;
    }

    public final a getStaticState() {
        return this.staticState;
    }

    public final boolean getSubmitStatusFlag() {
        return this.submitStatusFlag;
    }

    public final com.bytedance.android.shopping.buynow.tracker.a getTracker() {
        return this.tracker;
    }

    public final UltimateBuyParams getUltimateBuyParams() {
        return this.ultimateBuyParams;
    }

    public final AndroidYaTaInstance getYataInstance() {
        return this.yataInstance;
    }

    public final boolean isAutoRetry() {
        return this.isAutoRetry;
    }

    public final Boolean isNoPwdCombined() {
        return this.isNoPwdCombined;
    }

    public final boolean isPageLoading() {
        return this.isPageLoading;
    }

    public final boolean isResumed() {
        return this.isResumed;
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public final void saveAsyncEventParam(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.asyncTradeEventParam = r100;
    }

    public final void setAddOnParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.addOnParams = r100;
    }

    public final void setAddOnType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.addOnType = r100;
    }

    public final void setAutoRetry(boolean r100) {
        this.isAutoRetry = r100;
    }

    public final void setAvailability(Integer r100) {
        this.availability = r100;
    }

    public final void setBuyNowPageConfig(com.bytedance.android.shopping.buynow.starter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buyNowPageConfig = r100;
    }

    public final void setCheckParams(com.bytedance.android.shopping.buynow.eventcenter.handle.a r100) {
        this.checkParams = r100;
    }

    public final void setCurCheckParams(com.bytedance.android.shopping.buynow.eventcenter.handle.a r100) {
        this.checkParams = r100;
        if (r100 == null) goto L8;
        String r101 = r100.f170936d;
        if (r101 == null) goto L9;
        updateCheckStatus(r101);
        return;
    L9:
        return;
    }

    public final void setCurrentShownPopupCodes(Stack<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentShownPopupCodes = r100;
    }

    public final void setEditOperatorType(String r100) {
        this.editOperatorType = r100;
    }

    public final void setEditStartTime(long r100) {
        this.editStartTime = r100;
    }

    public final void setFailMsg(String r100) {
        this.failMsg = r100;
    }

    public final void setHasCheck(boolean r100) {
        this.hasCheck = r100;
    }

    public final void setHasReportDismiss(boolean r100) {
        this.hasReportDismiss = r100;
    }

    public final void setNeedToast(boolean r100) {
        this.needToast = r100;
    }

    public final void setNoPwdCombined(Boolean r100) {
        this.isNoPwdCombined = r100;
    }

    public final void setPageLoading(boolean r100) {
        this.isPageLoading = r100;
    }

    public final void setPageStartupStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageStartupStatus = r100;
    }

    public final void setResumed(boolean r100) {
        this.isResumed = r100;
    }

    public final void setRetryCount(int r100) {
        this.retryCount = r100;
    }

    public final void setSdkInfo(Map<?, ?> r100) {
        this.sdkInfo = r100;
    }

    public final void setSubmitStatusFlag(boolean r100) {
        this.submitStatusFlag = r100;
    }

    public final void setUltimateBuyParams(UltimateBuyParams r100) {
        this.ultimateBuyParams = r100;
    }

    public final void setYataInstance(AndroidYaTaInstance r100) {
        this.yataInstance = r100;
    }

    public final void updateCheckStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.curCheckStatus = r100;
    }

    public final void setCreateOrderLoadingData(Boolean r100, Map<?, ?> r101) {
        this.isNoPwdCombined = r100;
        this.sdkInfo = r101;
    }

    public final void trackRequestStartCheckPoint(boolean r100, String r101) {
        if (r100 == false) goto L5;
        this.tracker.k(CheckPointType.RENDER_REQUEST_START, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.c(this.staticState))}));
        return;
    L5:
        this.tracker.k(CheckPointType.EDIT_REQUEST_START, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.b(this.staticState)), TuplesKt.to("trigger_origin", r101)}));
    }

    public final void updateTrackerCommonParams(c r100, boolean r101) {
        Object r102 = null;
        JSONObject r103 = null;
        if (r101 == true) goto L5;
    L34:
        if (r100 == null) goto L38;
        Map<String, Object> r104 = r100.g();
        if (r104 == null) goto L38;
        Object r105 = r104.get("tracker_common_params");
    L40:
        if ((r105 instanceof Map) == false) goto L43;
        r102 = r105;
    L43:
        Map<String, ? extends Object> r106 = (Map) r102;
        if (r106 != null) goto L47;
        r106 = new LinkedHashMap();
    L47:
        if (mq.b.c(r106, "all_forbidden", false) == false) goto L49;
        int r107 = 1;
    L50:
        this.availability = r107;
        Lazy r108 = BuyNowLog.f171168a;
        BuyNowLog.d("BuyNowFragment", "updateTrackerCommonParams " + this.availability);
        if ((!r106.isEmpty()) == false) goto L54;
        com.bytedance.android.shopping.buynow.tracker.a r109 = this.tracker;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r106, "paramsMap");
        r109.f171174d.appendEventParams(r106);
        return;
    L54:
        return;
    L49:
        r107 = 2;
    L38:
        r105 = null;
        goto L40
    L5:
        if (this.staticState.c() == false) goto L34;
        BuyNowPerformanceOpt.l();
        if (r100 == null) goto L11;
        Map<String, Object> r110 = r100.g();
        if (r110 == null) goto L11;
        Object r111 = r110.get("tracker_common_params");
    L13:
        if ((r111 instanceof Map) == true) goto L15;
        r111 = null;
    L15:
        r106 = (Map) r111;
        s.a r112 = s.f170867d;
        a r113 = this.staticState;
        Map<String, ? extends Object> r114 = r113.f171236j;
        String r115 = r113.f171237k;
        r112.getClass();
        if (r114 == null) goto L32;
        if (r106 != null) goto L20;
        r106 = r114;
        goto L32
    L20:
        Map<String, ? extends Object> r116 = MapsKt.toMutableMap(r114);
        s.a.a(r116, r114, r106);
        if (BuyNowPerformanceOpt.b() == false) goto L31;
        if (r115 == null) goto L31;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r115);
        Object r117 = r116.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if ((r117 instanceof String) == true) goto L26;
        r117 = null;
    L26:
        String r118 = (String) r117;
        if (r118 == null) goto L29;
        r103 = z1.g(r118);
    L29:
        if (r103 == null) goto L31;
        KtSafeMethodExtensionKt.safePut(r103, com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r115);
        r116.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r103.toString());
    L31:
        r106 = r116;
    L32:
        if (r106 != null) goto L47;
        r106 = MapsKt.emptyMap();
    L11:
        r111 = null;
        goto L13
    }

    public final void trackRequestEndCheckPoint(boolean r110, boolean r111, ma3.b r210, String r211, Integer r212, Throwable r213) {
        String r100 = "网络响应异常";
        if (r111 == false) goto L30;
        if (r110 == false) goto L6;
        this.tracker.k(CheckPointType.RENDER_REQUEST_SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.c(this.staticState))}));
        return;
    L6:
        com.bytedance.android.shopping.buynow.tracker.a r101 = this.tracker;
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.c(this.staticState));
        if (r210 == null) goto L10;
        Integer r103 = r210.a();
        if (r103 == null) goto L10;
    L11:
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
    L14:
        r102[1] = TuplesKt.to("code", Integer.valueOf(r104));
        if (r210 == null) goto L18;
        String r105 = r210.b();
        if (r105 == null) goto L18;
    L21:
        if (r105 == null) goto L24;
        r100 = r105;
    L24:
        r102[2] = TuplesKt.to("message", r100);
        if (r213 == null) goto L27;
        String r112 = r213.getMessage();
    L28:
        r102[3] = TuplesKt.to("throwable_message", r112);
        r101.k(CheckPointType.RENDER_REQUEST_FAILED, MapsKt.mutableMapOf(r102));
        return;
    L27:
        r112 = null;
    L18:
        if (r212 == null) goto L20;
        r105 = "HTTP Error(" + r212.intValue() + ')';
        goto L21
    L20:
        r105 = null;
        goto L21
    L13:
        r104 = Error.ParsingResponse;
    L10:
        r103 = r212;
        goto L11
    L30:
        if (r110 == false) goto L32;
        this.tracker.k(CheckPointType.EDIT_REQUEST_SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.b(this.staticState)), TuplesKt.to("trigger_origin", r211)}));
        return;
    L32:
        com.bytedance.android.shopping.buynow.tracker.a r113 = this.tracker;
        Pair[] r106 = new Pair[5];
        r106[0] = TuplesKt.to(SocialConstants.PARAM_APP_DESC, b.b(this.staticState));
        if (r210 == null) goto L36;
        Integer r107 = r210.a();
        if (r107 == null) goto L36;
    L37:
        if (r107 == null) goto L39;
        int r114 = r107.intValue();
    L40:
        r106[1] = TuplesKt.to("code", Integer.valueOf(r114));
        if (r210 == null) goto L44;
        String r108 = r210.b();
        if (r108 == null) goto L44;
    L47:
        if (r108 == null) goto L50;
        r100 = r108;
    L50:
        r106[2] = TuplesKt.to("message", r100);
        if (r213 == null) goto L53;
        String r109 = r213.getMessage();
    L54:
        r106[3] = TuplesKt.to("throwable_message", r109);
        r106[4] = TuplesKt.to("trigger_origin", r211);
        r113.k(CheckPointType.EDIT_REQUEST_FAILED, MapsKt.mutableMapOf(r106));
        return;
    L53:
        r109 = null;
    L44:
        if (r212 == null) goto L46;
        r108 = "HTTP Error(" + r212.intValue() + ')';
        goto L47
    L46:
        r108 = null;
        goto L47
    L39:
        r114 = Error.ParsingResponse;
    L36:
        r107 = r212;
        goto L37
    }

    public static /* synthetic */ void trackRequestEndCheckPoint$default(BuyNowViewModel r100, boolean r101, boolean r102, ma3.b r110, String r111, Integer r112, Throwable r113, int r114, Object r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = null;
    L5:
        r100.trackRequestEndCheckPoint(r101, r102, r110, r111, r112, r113);
    }
}
