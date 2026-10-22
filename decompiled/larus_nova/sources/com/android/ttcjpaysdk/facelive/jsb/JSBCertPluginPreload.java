package com.android.ttcjpaysdk.facelive.jsb;

import android.content.Context;
import android.util.Pair;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayExperimentValue;
import com.android.ttcjpaysdk.base.settings.bean.CJPayFaceCertPluginOptConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.facelive.jsb.abs.AbsJsbCertPluginPreload;
import com.android.ttcjpaysdk.facelive.utils.JSBLoggerForDy;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J7\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0018\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J'\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/JSBCertPluginPreload;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload;", "()V", "logger", "Lcom/android/ttcjpaysdk/facelive/utils/JSBLoggerForDy;", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "doCallback", "", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadOutput;", "isException", "", "isSilent", "isHitPreload", "delayTime", "", "(Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadOutput;ZZLjava/lang/Boolean;J)V", "getBizParams", "Lorg/json/JSONObject;", "(Ljava/lang/Boolean;J)Lorg/json/JSONObject;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "input", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadInput;", "logCallback", "(Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbCertPluginPreload$CertPluginPreloadOutput;Ljava/lang/Boolean;J)V", "realHandle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBCertPluginPreload extends AbsJsbCertPluginPreload {
    public static final Companion Companion = null;
    private static final String TAG = null;
    public static AtomicBoolean isInvoking;
    private final JSBLoggerForDy logger;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/JSBCertPluginPreload$Companion;", "", "()V", "TAG", "", "isInvoking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbCertPluginPreload.CertPluginPreloadInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    static {
        Companion = new Companion(null);
        TAG = "JSBCertPluginPreload";
        isInvoking = new AtomicBoolean(false);
    }

    public JSBCertPluginPreload() {
        this.logger = new JSBLoggerForDy(getName());
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbCertPluginPreload.CertPluginPreloadInput) r100);
    }

    private final JSONObject getBizParams(Boolean r100, long r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L6;
        String r103 = (String) KtSafeMethodExtensionKt.tf(r100.booleanValue(), "1", "0");
        if (r103 == null) goto L6;
    L7:
        KtSafeMethodExtensionKt.safePut(r102, "hit_preload", r103);
        KtSafeMethodExtensionKt.safePut(r102, "preload_delay_time", Long.valueOf(r101));
        return r102;
    L6:
        r103 = "-1";
        goto L7
    }

    private final void logCallback(AbsJsbCertPluginPreload.CertPluginPreloadOutput r100, Boolean r101, long r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        JSBLoggerForDy r104 = this.logger;     // Catch: Throwable -> L10
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L10
        Map<String, Long> r106 = getDurationLogInfo();     // Catch: Throwable -> L10
        if (r106 == null) goto L8;
        Iterator<Map.Entry<String, Long>> r107 = r106.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r107.hasNext() == false) goto L8;
        Map.Entry<String, Long> r108 = r107.next();     // Catch: Throwable -> L10
        KtSafeMethodExtensionKt.safePut(r105, r108.getKey(), r108.getValue());     // Catch: Throwable -> L10
    L8:
        r104.jsbCallbackLog(r105, r100.buildLogData(), getBizParams(r101, r102));     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void realHandle(final Context r110, final AbsJsbCertPluginPreload.CertPluginPreloadInput r210, final AbsJsbCertPluginPreload.CertPluginPreloadOutput r211) {
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, BdpAppEventConstant.PARAMS_OUTPUT);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L71
        if (isInvoking.getAndSet(true) == false) goto L6;
        return;
    L6:
        final boolean r101 = r210.silent_install;     // Catch: Throwable -> L71
        String r102 = r210.risk_source;     // Catch: Throwable -> L71
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        final String r111 = r102;
        CJPayExperimentValue<CJPayFaceCertPluginOptConfig> r103 = CJPayABExperimentKeys.getFaceCertPluginOptConfig();     // Catch: Throwable -> L71
        Iterator<T> r104 = r103.value(false).preload_config.iterator();     // Catch: Throwable -> L71
    L11:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();     // Catch: Throwable -> L71
        CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig r106 = (CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig) r105;     // Catch: Throwable -> L71
        if ((!StringsKt.isBlank(r111)) == true) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L11;
    L21:
        if (r105 == null) goto L23;
        boolean r112 = true;
    L24:
        Iterator<T> r108 = r103.value(false).preload_config.iterator();     // Catch: Throwable -> L71
    L26:
        if (r108.hasNext() == false) goto L35;
        Object r109 = r108.next();     // Catch: Throwable -> L71
        CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig r113 = (CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig) r109;     // Catch: Throwable -> L71
        if ((!StringsKt.isBlank(r111)) == true) goto L30;
    L32:
        boolean r114 = false;
    L33:
        if (r114 == false) goto L26;
    L36:
        CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig r115 = (CJPayFaceCertPluginOptConfig.CJPayCertPluginPreloadConfig) r109;     // Catch: Throwable -> L71
        if (r115 == null) goto L39;
        long r116 = r115.delay_time;     // Catch: Throwable -> L71
    L40:
        this.logger.jsbInvokeLog(CJPayJsonParser.toJsonObject(r210), getBizParams(Boolean.valueOf(r112), r116));     // Catch: Throwable -> L71
        a.f554342a.getClass();     // Catch: Throwable -> L71
        FaceService r117 = (FaceService) a.d(FaceService.class);     // Catch: Throwable -> L71
        if (r101 == false) goto L43;
        if (r110 == null) goto L43;
    L46:
        boolean r118 = true;
    L48:
        if (r118 == false) goto L50;
        FaceService r119 = r117;
    L51:
        if (r119 != null) goto L53;
        long r120 = r116;
    L68:
        FaceService.Companion.getClass();     // Catch: Throwable -> L71
        Pair<Integer, String> r121 = FaceService.a.f202222b;     // Catch: Throwable -> L71
        r211.code = ((Number) r121.first).intValue();     // Catch: Throwable -> L71
        r211.msg = (String) r121.second;     // Catch: Throwable -> L71
        doCallback(r211, false, r101, Boolean.valueOf(r112), r120);     // Catch: Throwable -> L71
        Object r122 = Unit.INSTANCE;     // Catch: Throwable -> L71
    L69:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L71
    L73:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L89;
        CJBasicCommonUtils.reportCatchException("JSBCertPluginPreload#onResult", r124);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBCertPluginPreload#onResult", r124);
        FaceService.Companion.getClass();
        Pair<Integer, String> r125 = FaceService.a.f202222b;
        r211.code = ((Number) r125.first).intValue();
        r211.msg = (String) r125.second;
        doCallback(r211, true, r210.silent_install, null, 0);
        return;
    L89:
        return;
    L53:
        if (r119.isPluginAlready(true) == false) goto L55;
        r211.code = 0;     // Catch: Throwable -> L71
        r211.msg = "plugin already ready";     // Catch: Throwable -> L71
        JSONObject r126 = new JSONObject();     // Catch: Throwable -> L71
        KtSafeMethodExtensionKt.safePut(r126, "is_ready_before", "1");     // Catch: Throwable -> L71
        r211.ext = r126.toString();     // Catch: Throwable -> L71
        doCallback(r211, false, r101, Boolean.valueOf(r112), r116);     // Catch: Throwable -> L71
        r122 = Unit.INSTANCE;     // Catch: Throwable -> L71
        r120 = r116;
    L65:
        if (r122 == null) goto L68;
    L55:
        long r127 = r116;
        r103.value(true);     // Catch: Throwable -> L71
        if (r112 == false) goto L64;
        if (r101 == false) goto L59;
        FaceService.Companion.getClass();     // Catch: Throwable -> L71
        Pair<Integer, String> r128 = FaceService.a.f202222b;     // Catch: Throwable -> L71
        r211.code = ((Number) r128.first).intValue();     // Catch: Throwable -> L71
        r211.msg = (String) r128.second;     // Catch: Throwable -> L71
        doCallback(r211, false, true, Boolean.TRUE, r127);     // Catch: Throwable -> L71
        final long r129 = r127;
        final JSBCertPluginPreload$realHandle$1$2$preloadCallback$2 r130 = 0;
    L60:
        final FaceService r131 = r119;
        r120 = r129;
        Function0<Unit> r132 = new JSBCertPluginPreload$realHandle$1$2$preloadTask$1(r131, r110, r130, r111, r101, r210);     // Catch: Throwable -> L71
        if (r120 <= 0) goto L63;
        r122 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new JSBCertPluginPreload$realHandle$1$2$2(r120, r132, null), 3, null);     // Catch: Throwable -> L71
        goto L65
    L63:
        r132.invoke();     // Catch: Throwable -> L71
        r122 = Unit.INSTANCE;     // Catch: Throwable -> L71
        goto L65
    L59:
        r129 = r127;
        r130 = new JSBCertPluginPreload$realHandle$1$2$preloadCallback$2(this, r211, r129);     // Catch: Throwable -> L71
        goto L60
    L64:
        r120 = r127;
        FaceService.Companion.getClass();     // Catch: Throwable -> L71
        Pair<Integer, String> r133 = FaceService.a.f202223c;     // Catch: Throwable -> L71
        r211.code = ((Number) r133.first).intValue();     // Catch: Throwable -> L71
        r211.msg = (String) r133.second;     // Catch: Throwable -> L71
        doCallback(r211, false, r101, Boolean.FALSE, r120);     // Catch: Throwable -> L71
        r122 = Unit.INSTANCE;     // Catch: Throwable -> L71
        goto L65
    L50:
        r119 = null;
    L43:
        if (r101 == false) goto L45;
    L47:
        r118 = false;
        goto L48
    L45:
        if (CJPayKotlinExtensionsKt.isAlive(r110) == false) goto L47;
    L39:
        r116 = 0;
        goto L40
    L30:
        if (Intrinsics.areEqual(r113.risk_source, r111) == false) goto L32;
        r114 = true;
        goto L33
    L35:
        r109 = null;
        goto L36
    L23:
        r112 = false;
        goto L24
    L15:
        if (Intrinsics.areEqual(r106.risk_source, r111) == false) goto L17;
        r107 = true;
        goto L18
    L20:
        r105 = null;
    L71:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbCertPluginPreload.CertPluginPreloadInput) r101, (AbsJsbCertPluginPreload.CertPluginPreloadOutput) r102);
    }

    private final void doCallback(final AbsJsbCertPluginPreload.CertPluginPreloadOutput r100, boolean r101, final boolean r102, Boolean r103, long r104) {
        KtSafeMethodExtensionKt.tf(r101, new AnonymousClass1(r100), new AnonymousClass2(r102, r100));
        isInvoking.set(false);
        logCallback(r100, r103, r104);
    }

    public static final /* synthetic */ void access$doCallback(JSBCertPluginPreload r100, AbsJsbCertPluginPreload.CertPluginPreloadOutput r101, boolean r102, boolean r103, Boolean r104, long r105) {
        r100.doCallback(r101, r102, r103, r104, r105);
    }
}
