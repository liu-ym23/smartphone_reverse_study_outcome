package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import cd4.k;
import cd4.m;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.dependency.CJDependencyProvider;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.CJJsonValidResult;
import com.android.ttcjpaysdk.base.ktextension.CJResult;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.JSBConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerName;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerType;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import md4.b;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 T*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u00020\u0006:\u0003UTVB\u0007¢\u0006\u0004\bR\u0010SJ#\u0010\n\u001a\u0004\u0018\u00018\u0002\"\b\b\u0002\u0010\u0007*\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0011\u001a\u00020\b\"\b\b\u0002\u0010\u0007*\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190$H\u0002J\u0006\u0010&\u001a\u00020\u0019J\u000f\u0010'\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u0004\u0018\u00010\bJ\b\u0010,\u001a\u00020+H&J\"\u0010/\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010-J+\u00101\u001a\u00020\u0014\"\u0004\b\u0002\u0010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00018\u0002¢\u0006\u0004\b1\u00102J#\u00103\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f¢\u0006\u0004\b3\u00104J)\u00107\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u0001H$¢\u0006\u0004\b7\u00108J+\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001609\u0018\u00010$2\u0006\u00105\u001a\u00028\u0000H&¢\u0006\u0004\b:\u0010;J\u0006\u0010<\u001a\u00020\bJ\b\u0010=\u001a\u00020\u0016H\u0016J\u0016\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010$H\u0016J\u0016\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020?\u0018\u00010$H\u0016J\u0016\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010$H\u0016J\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020B0$J\b\u0010D\u001a\u00020\u0014H\u0016R\u0018\u00105\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010ER\u0018\u00106\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010K¨\u0006W"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "P", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "R", "Lcd4/m;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/json/JSONObject;", "params", "initParams", "(Lorg/json/JSONObject;)Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "initResult", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/lang/Class;", "clazz", "fixInputParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "invokeMonitor", "", "isSuccess", "result", "", "errorMsg", "callbackMonitor", "", LynxError.LYNX_THROWABLE, "crashMonitor", "getReportInputParams", "getReportResultParams", "getJSBReportCommonInfo", "getContainerCommonInfo", "getJsonStrErrorInfo", "", "getTimestampMap", "CJTag", "getOutput", "getInput", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "getInputParams", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "callbackStruct", "Lcd4/k;", "callback", "handle", "instance", "putDependency", "(Ljava/lang/Class;Ljava/lang/Object;)V", "getDependency", "(Ljava/lang/Class;)Ljava/lang/Object;", "input", BdpAppEventConstant.PARAMS_OUTPUT, "realHandle", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;)V", "Lkotlin/Function0;", "getCheckInputParamsRuleMap", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;)Ljava/util/Map;", "getJSBRiskInfo", "isReportInputParams", "getJsonStrNeedChecked", "", "getLogParams", "getJsbTimestampMap", "", "getDurationLogInfo", "release", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/CJDependencyProvider;", "dependencyProvider", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/dependency/CJDependencyProvider;", "originInputParams", "Lorg/json/JSONObject;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBSession;", "jsbSession", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBSession;", "containerId", "Ljava/lang/String;", "containerCommonLogParams", "<init>", "()V", "Companion", "CallbackStruct", "JsbCallbackWrapper", "base-context_release"}, k = 1, mv = {1, 6, 0})
public abstract class AbsJSBMethod<P extends IJSBParams, R extends JSBBaseOutput> implements m, ICJTag {
    public static final Companion Companion = null;
    private static volatile boolean sdkEnvEnsured;
    private JSONObject containerCommonLogParams;
    private String containerId;
    private final CJDependencyProvider dependencyProvider;
    private P input;
    private final JSBSession jsbSession;
    private JSONObject originInputParams;
    private R output;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "", "(Ljava/lang/String;I)V", "ORIGINAL", "WRAP_CJDATA", "ORIGINAL_WITH_WRAP_CJDATA", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CallbackStruct extends Enum<CallbackStruct> {
        private static final /* synthetic */ CallbackStruct[] $VALUES = null;
        public static final CallbackStruct ORIGINAL = null;
        public static final CallbackStruct ORIGINAL_WITH_WRAP_CJDATA = null;
        public static final CallbackStruct WRAP_CJDATA = null;

        private static final /* synthetic */ CallbackStruct[] $values() {
            return new CallbackStruct[]{ORIGINAL, WRAP_CJDATA, ORIGINAL_WITH_WRAP_CJDATA};
        }

        public static CallbackStruct valueOf(String r100) {
            return (CallbackStruct) a.a(CallbackStruct.class, r100);
        }

        public static CallbackStruct[] values() {
            return (CallbackStruct[]) $VALUES.clone();
        }

        static {
            ORIGINAL = new CallbackStruct("ORIGINAL", 0);
            WRAP_CJDATA = new CallbackStruct("WRAP_CJDATA", 1);
            ORIGINAL_WITH_WRAP_CJDATA = new CallbackStruct("ORIGINAL_WITH_WRAP_CJDATA", 2);
            $VALUES = $values();
        }

        private CallbackStruct(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$Companion;", "", "()V", "sdkEnvEnsured", "", "ensureSDKEnvReadyOnce", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final void ensureSDKEnvReadyOnce() {
            if (AbsJSBMethod.access$getSdkEnvEnsured$cp() == false) goto L5;
            return;
        L5:
            ve4.a.f554342a.getClass();
            CJHostService r100 = (CJHostService) ve4.a.a(CJHostService.class);
            if (r100 == null) goto L8;
            r100.getEnvController();
        L8:
            AbsJSBMethod.access$setSdkEnvEnsured$cp(true);
        }

        public static final /* synthetic */ void access$ensureSDKEnvReadyOnce(Companion r100) {
            r100.ensureSDKEnvReadyOnce();
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$JsbCallbackWrapper;", "Lcd4/k;", "Lcd4/m;", PrefetchTiming.JSB, "", WidgetCostModule.TYPE_ON_START, "Lorg/json/JSONObject;", "result", "onSuccess", "", "errorMsg", "onFailed", "jsbCallback", "Lcd4/k;", "<init>", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;Lcd4/k;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public final class JsbCallbackWrapper implements k {
        private final k jsbCallback;
        final /* synthetic */ AbsJSBMethod<P, R> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cd4.k
        public void onStart(m r110) {
            CJLogger.d(this.this$0.CJTag(), WidgetCostModule.TYPE_ON_START);
            AbsJSBMethod<P, R> r100 = this.this$0;
            boolean r101 = this instanceof ICJTag;
            String r102 = "runCatching";
            if (r101 == false) goto L8;
            String r103 = ((ICJTag) this).CJTag();
            if (r103 == null) goto L8;
            if (StringsKt.isBlank(r103) == true) goto L8;
        L10:
            if (StringsKt.isBlank(r103) == false) goto L18;
            if (r101 == false) goto L19;
            String r104 = ((ICJTag) this).CJTag();
            if (r104 == null) goto L19;
            if (StringsKt.isBlank(r104) == true) goto L19;
            r102 = r104;
        L19:
            String r105 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
            CJLogger.a(r102, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
            long r106 = System.currentTimeMillis();
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L29
            AbsJSBMethod.access$getJsbSession$p(r100).setStartTimestamp(System.currentTimeMillis());     // Catch: Throwable -> L29
            JSBSession r108 = AbsJSBMethod.access$getJsbSession$p(r100);     // Catch: Throwable -> L29
            JSONObject r109 = AbsJSBMethod.access$getOriginInputParams$p(r100);     // Catch: Throwable -> L29
            long r111 = 0;
            if (r109 == null) goto L23;
            long r112 = r109.optLong("cj_jsb_fe_invoke_timestamp");     // Catch: Throwable -> L29
        L24:
            r108.setFeInvokeTimestamp(r112);     // Catch: Throwable -> L29
            JSBSession r113 = AbsJSBMethod.access$getJsbSession$p(r100);     // Catch: Throwable -> L29
            JSONObject r114 = AbsJSBMethod.access$getOriginInputParams$p(r100);     // Catch: Throwable -> L29
            if (r114 == null) goto L27;
            r111 = r114.optLong("cj_jsb_native_invoke_timestamp");     // Catch: Throwable -> L29
        L27:
            r113.setNativeInvokeTimestamp(r111);     // Catch: Throwable -> L29
            Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        L31:
            String r116 = null;
            if (Result.m9456isSuccessimpl(r115) == false) goto L34;
            CJLogger.d(r102, "onSuccess\n " + r105);
            Object r117 = r115;
            boolean r118 = true;
        L35:
            Throwable r119 = Result.m9452exceptionOrNullimpl(r115);
            if (r119 == null) goto L38;
            CJBasicCommonUtils.reportCatchException("CJResult#unknown", r119);
            CJLogger.c(r102, "onFailure", r119);
            r118 = false;
        L39:
            long r120 = System.currentTimeMillis() - r106;
            CJLogger.d(r102, "is_success: " + r118 + ", duration: " + r120);
            CJReporter r121 = CJReporter.f202294a;
            Set<String> r122 = CJContext.f202254w;
            String r123 = "";
            CJContext r124 = CJContext.c.a(r103, "", "", new HashMap());
            Pair[] r125 = new Pair[5];
            r125[0] = TuplesKt.to("tag", r103);
            r125[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r118, "1", "0"));
            if (r119 == null) goto L42;
            r116 = r119.getMessage();
        L42:
            if (r116 == null) goto L45;
            r123 = r116;
        L45:
            r125[2] = TuplesKt.to("error_msg", r123);
            r125[3] = TuplesKt.to("trace", r105);
            r125[4] = TuplesKt.to("duration", Long.valueOf(r120));
            CJReporter.o(r124, "cjpay_run_catch_result", MapsKt.mapOf(r125));
            new CJResult(r117, r118, r119);
            k r126 = this.jsbCallback;
            if (r126 == null) goto L51;
            r126.onStart(r110);
            return;
        L51:
            return;
        L38:
            r119 = null;
            goto L39
        L34:
            r117 = null;
            r118 = false;
            goto L35
        L23:
            r112 = 0;
        L29:
            th = move-exception;
            Result.Companion r127 = Result.Companion;
            r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L31
        L18:
            r102 = r103;
        L8:
            r103 = "runCatching";
            goto L10
        }

        @Override // cd4.k
        public void onSuccess(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            AbsJSBMethod.access$getJsbSession$p(this.this$0).setEndTimestamp(System.currentTimeMillis());
            JSONObject r101 = AbsJSBMethod.access$getOriginInputParams$p(this.this$0);
            if (r101 == null) goto L5;
            String r102 = r101.optString("need_cj_jsb_timestamp");
        L7:
            if (Intrinsics.areEqual(r102, "1") == false) goto L9;
            KtSafeMethodExtensionKt.safePut(r100, "cj_jsb_timestamp", KtSafeMethodExtensionKt.safeToJson(AbsJSBMethod.access$getTimestampMap(this.this$0)).toString());
        L9:
            k r103 = this.jsbCallback;
            if (r103 == null) goto L12;
            r103.onSuccess(r100);
        L12:
            AbsJSBMethod.access$callbackMonitor(this.this$0, true, r100, "");
            return;
        L5:
            r102 = null;
            goto L7
        }

        public JsbCallbackWrapper(AbsJSBMethod r100, k r101) {
            this.this$0 = r100;
            this.jsbCallback = r101;
        }

        @Override // cd4.k
        public void onFailed(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMsg");
            Intrinsics.checkNotNullParameter(r101, "result");
            AbsJSBMethod.access$getJsbSession$p(this.this$0).setEndTimestamp(System.currentTimeMillis());
            JSONObject r102 = AbsJSBMethod.access$getOriginInputParams$p(this.this$0);
            if (r102 == null) goto L5;
            String r103 = r102.optString("need_cj_jsb_timestamp");
        L7:
            if (Intrinsics.areEqual(r103, "1") == false) goto L9;
            KtSafeMethodExtensionKt.safePut(r101, "cj_jsb_timestamp", KtSafeMethodExtensionKt.safeToJson(AbsJSBMethod.access$getTimestampMap(this.this$0)).toString());
        L9:
            k r104 = this.jsbCallback;
            if (r104 == null) goto L12;
            r104.onFailed(r100, r101);
        L12:
            AbsJSBMethod.access$callbackMonitor(this.this$0, false, r101, r100);
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final R initResult() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L17
        Class<? super Object> r101 = getClass().getSuperclass();     // Catch: Throwable -> L17
        if (r101 == null) goto L16;
        Type r102 = r101.getGenericSuperclass();     // Catch: Throwable -> L17
        if (r102 == null) goto L16;
        if ((r102 instanceof ParameterizedType) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L16;
        Type r103 = ((ParameterizedType) r102).getActualTypeArguments()[1];     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.Class<R of com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod>");     // Catch: Throwable -> L17
        Class r104 = (Class) r103;     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
        return (R) r104.newInstance();
    L16:
        return null;
    L17:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Throwable r106 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r106 == null) goto L21;
        CJBasicCommonUtils.reportCatchException("AbsJSBMethod#initResult", r106);
        CJBasicCommonUtils.logCatch("CJCatch", "AbsJSBMethod#initResult", r106);
        crashMonitor(r106);
    L21:
        return null;
    }

    public abstract CallbackStruct callbackStruct();

    @Override // cd4.m
    public boolean canRunInBackground() {
        return false;
    }

    public abstract Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(P r100);

    public final Map<String, Long> getDurationLogInfo() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(this.jsbSession.getDuration())), TuplesKt.to("real_handle_duration", Long.valueOf(this.jsbSession.getRealHandleDuaration())), TuplesKt.to("init_input_duration", Long.valueOf(this.jsbSession.getInputParamsInitDuration())), TuplesKt.to("fe_to_native_duration", Long.valueOf(this.jsbSession.getFe2NativeDuration()))});
    }

    public Map<String, String> getJsbTimestampMap() {
        return null;
    }

    public Map<String, String> getJsonStrNeedChecked() {
        return null;
    }

    public Map<String, Object> getLogParams() {
        return null;
    }

    @Override // cd4.m
    public abstract /* synthetic */ String getName();

    public boolean isReportInputParams() {
        return true;
    }

    public abstract void realHandle(Context r100, P r101, R r102);

    private final JSONObject getContainerCommonInfo() {
        b r100 = (b) getDependency(b.class);
        JSONObject r101 = this.containerCommonLogParams;
        if (r101 != null) goto L24;
        r101 = new JSONObject();
        ContainerName r102 = null;
        if (r100 == null) goto L7;
        String r103 = r100.getSchema();
    L8:
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        KtSafeMethodExtensionKt.safePut(r101, "schema", r103);
        if (r100 == null) goto L16;
        ContainerType r105 = r100.getContainerType();
        if (r105 == null) goto L16;
        String r106 = r105.getType();
    L17:
        if (r106 == null) goto L20;
        r104 = r106;
    L20:
        KtSafeMethodExtensionKt.safePut(r101, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r104);
        if (r100 == null) goto L23;
        r102 = r100.a();
    L23:
        KtSafeMethodExtensionKt.safePut(r101, "container_name", r102);
        this.containerCommonLogParams = r101;
    L16:
        r106 = null;
        goto L17
    L7:
        r103 = null;
    L24:
        return r101;
    }

    private final JSONObject getJSBReportCommonInfo() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "timestamp", Long.valueOf(System.currentTimeMillis()));
        KtSafeMethodExtensionKt.safePut(r100, e.f25671s, getName());
        if (Intrinsics.areEqual("ttcjpay.ttpay", getName()) == false) goto L11;
        JSONObject r101 = this.originInputParams;
        if (r101 == null) goto L7;
        String r102 = r101.optString("service");
    L8:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        KtSafeMethodExtensionKt.safePut(r100, "ttpay_service", r102);
        goto L11
    L7:
        r102 = null;
    L11:
        JSONObject r103 = this.originInputParams;
        if (r103 != null) goto L14;
        r103 = new JSONObject();
    L14:
        KtSafeMethodExtensionKt.safePut(r100, "input_params", getReportInputParams(r103));
        Map<String, Object> r104 = getLogParams();
        if (r104 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        Map.Entry<String, Object> r106 = r105.next();
        KtSafeMethodExtensionKt.safePut(r100, r106.getKey(), r106.getValue());
    L20:
        Iterator<Map.Entry<String, Long>> r107 = getDurationLogInfo().entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        Map.Entry<String, Long> r108 = r107.next();
        KtSafeMethodExtensionKt.safePut(r100, r108.getKey(), r108.getValue());
        goto L22
    L24:
        b r109 = (b) getDependency(b.class);
        if (r109 == null) goto L32;
        Map<String, String> r110 = r109.getReportParams();
        if (r110 == null) goto L32;
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L30:
        if (r111.hasNext() == false) goto L32;
        Map.Entry<String, String> r112 = r111.next();
        KtSafeMethodExtensionKt.safePut(r100, r112.getKey(), r112.getValue());
    L32:
        return r100;
    }

    private final Map<String, String> getTimestampMap() {
        JSONObject r100 = this.originInputParams;
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.optLong("cj_jsb_fe_invoke_timestamp");
    L6:
        JSONObject r103 = this.originInputParams;
        if (r103 == null) goto L9;
        r101 = r103.optLong("cj_jsb_native_invoke_timestamp");
    L9:
        Map<String, String> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_jsb_fe_invoke_timestamp", String.valueOf(r102)), TuplesKt.to("cj_jsb_native_invoke_timestamp", String.valueOf(r101)), TuplesKt.to("plugin_jsb_invoke_timestamp", String.valueOf(this.jsbSession.getStartTimestamp())), TuplesKt.to("plugin_jsb_callback_timestamp", String.valueOf(this.jsbSession.getEndTimestamp()))});
        Map<String, String> r105 = getJsbTimestampMap();
        if (r105 == null) goto L12;
        r104.putAll(r105);
    L12:
        return r104;
    L5:
        r102 = 0;
        goto L6
    }

    public final JSONObject getJSBRiskInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("channel", CJEnv.b());
        r100.put(WsConstants.KEY_INSTALL_ID, CJEnv.f().getIID());
        return r100;
    }

    @Override // cd4.m
    public void release() {
        JSBIntegratedLogger.INSTANCE.report(this.containerId, KtSafeMethodExtensionKt.toMap(getContainerCommonInfo()));
    }

    public AbsJSBMethod() {
        this.output = (R) initResult();
        this.dependencyProvider = new CJDependencyProvider();
        this.jsbSession = new JSBSession();
        this.containerId = "";
    }

    private final JSONObject getJsonStrErrorInfo() {
        Map<String, String> r100 = getJsonStrNeedChecked();
        String r101 = null;
        if (r100 == null) goto L37;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L5:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r105 = r103.next();
        if (r105.getValue().length() < 1000) goto L11;
        r104 = false;
    L11:
        if (r104 == false) goto L5;
        r102.put(r105.getKey(), r105.getValue());
        goto L5
    L13:
        ArrayList r106 = new ArrayList(r102.size());
        Iterator r107 = r102.entrySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.add(TuplesKt.to(r108.getKey(), KtSafeMethodExtensionKt.validJsonResult((String) r108.getValue())));
        goto L15
    L17:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r106.iterator();
    L19:
        if (r110.hasNext() == false) goto L28;
        Object r111 = r110.next();
        Pair r112 = (Pair) r111;
        if (((CJJsonValidResult) r112.getSecond()).isValid() == false) goto L23;
    L25:
        boolean r113 = false;
    L26:
        if (r113 == false) goto L19;
        r109.add(r111);
        goto L19
    L23:
        if (((CJJsonValidResult) r112.getSecond()).getThrowable() == null) goto L25;
        r113 = true;
        goto L26
    L28:
        Iterator r114 = r109.iterator();
        if (r114.hasNext() == false) goto L37;
        Pair r115 = (Pair) r114.next();
        JSONObject r116 = new JSONObject();
        String r117 = (String) r115.getFirst();
        Throwable r118 = ((CJJsonValidResult) r115.getSecond()).getThrowable();
        if (r118 == null) goto L33;
        r101 = r118.getMessage();
    L33:
        if (r101 != null) goto L35;
        r101 = "";
    L35:
        KtSafeMethodExtensionKt.safePut(r116, r117, r101);
        return r116;
    L37:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return getName();
    }

    public static final /* synthetic */ boolean access$getSdkEnvEnsured$cp() {
        return sdkEnvEnsured;
    }

    public final P getInput() {
        return this.input;
    }

    public final JSONObject getInputParams() {
        return this.originInputParams;
    }

    public final R getOutput() {
        return this.output;
    }

    public static final /* synthetic */ JSBSession access$getJsbSession$p(AbsJSBMethod r100) {
        return r100.jsbSession;
    }

    public static final /* synthetic */ JSONObject access$getOriginInputParams$p(AbsJSBMethod r100) {
        return r100.originInputParams;
    }

    public static final /* synthetic */ Map access$getTimestampMap(AbsJSBMethod r100) {
        return r100.getTimestampMap();
    }

    public static final /* synthetic */ void access$setSdkEnvEnsured$cp(boolean r100) {
        sdkEnvEnsured = r100;
    }

    private final void crashMonitor(Throwable r110) {
        JSONObject r100 = getJSBReportCommonInfo();
        KtSafeMethodExtensionKt.safePut(r100, "exception_type", r110.getClass().getName());
        KtSafeMethodExtensionKt.safePut(r100, MapMonitorConst.ERROR_INFO, Log.getStackTraceString(r110));
        R r111 = this.output;
        if (r111 == null) goto L5;
        Boolean r112 = Boolean.valueOf(r111.isFatalResult());
    L7:
        if (r112 == null) goto L9;
        boolean r113 = r112.booleanValue();
    L10:
        KtSafeMethodExtensionKt.safePut(r100, "is_fatal_result", KtSafeMethodExtensionKt.tf(r113, "1", "0"));
        JSONObject r114 = getJsonStrErrorInfo();
        if (r114 == null) goto L13;
        KtSafeMethodExtensionKt.safePut(r100, "json_string_error_info", r114);
    L13:
        Map<String, String> r101 = KtSafeMethodExtensionKt.merge(new JSONObject[]{r100, getContainerCommonInfo()});
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "cj_jsb_crash_monitor_" + getName(), 0, r101.toString());
        CJReporter.o(CJPayCallBackCenter.getInstance().getCjContext(), "cj_jsb_crash_monitor", r101);
        CJReporter.h(r102, CJPayCallBackCenter.getInstance().getCjContext(), "cj_jsb_crash_monitor", r101, null, 56);
        return;
    L9:
        r113 = false;
        goto L10
    L5:
        r112 = null;
        goto L7
    }

    private final String getReportInputParams(JSONObject r110) {
        String r100 = CJTag();
        String r101 = "runCatching";
        if (r100 != null) goto L5;
        String r102 = "runCatching";
    L10:
        if (StringsKt.isBlank(r102) == false) goto L17;
        String r103 = CJTag();
        if (r103 != null) goto L14;
    L18:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r105 = System.currentTimeMillis();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
        if (isReportInputParams() == true) goto L23;
        return "nothing";
    L23:
        String r107 = r110.toString();     // Catch: Throwable -> L27
        if (r107.length() <= 1000) goto L45;
        return r107.substring(0, 1000);
    L45:
        return r107;
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        String r111 = null;
        if (Result.m9456isSuccessimpl(r109) == false) goto L31;
        CJLogger.d(r101, "onSuccess\n " + r104);
        Object r112 = r109;
        boolean r113 = true;
    L32:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r109);
        if (r114 == null) goto L35;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r114);
        CJLogger.c(r101, "onFailure", r114);
        r113 = false;
    L36:
        long r115 = System.currentTimeMillis() - r105;
        CJLogger.d(r101, "is_success: " + r113 + ", duration: " + r115);
        CJReporter r116 = CJReporter.f202294a;
        Set<String> r117 = CJContext.f202254w;
        CJContext r118 = CJContext.c.a(r102, "", "", new HashMap());
        Pair[] r119 = new Pair[5];
        r119[0] = TuplesKt.to("tag", r102);
        r119[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r113, "1", "0"));
        if (r114 == null) goto L39;
        r111 = r114.getMessage();
    L39:
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        r119[2] = TuplesKt.to("error_msg", r111);
        r119[3] = TuplesKt.to("trace", r104);
        r119[4] = TuplesKt.to("duration", Long.valueOf(r115));
        CJReporter.o(r118, "cjpay_run_catch_result", MapsKt.mapOf(r119));
        new CJResult(r112, r113, r114);
        return "";
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        r113 = false;
        goto L32
    L14:
        if (StringsKt.isBlank(r103) == true) goto L18;
        r101 = r103;
        goto L18
    L17:
        r101 = r102;
        goto L18
    L5:
        if (StringsKt.isBlank(r100) == false) goto L7;
        r100 = "runCatching";
    L7:
        r102 = r100;
        goto L10
    }

    private final String getReportResultParams(JSONObject r110) {
        String r100 = CJTag();
        String r101 = "runCatching";
        if (r100 != null) goto L5;
        String r102 = "runCatching";
    L10:
        if (StringsKt.isBlank(r102) == false) goto L17;
        String r103 = CJTag();
        if (r103 != null) goto L14;
    L18:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r105 = System.currentTimeMillis();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
        String r107 = r110.toString();     // Catch: Throwable -> L23
        if (r107.length() <= 500) goto L41;
        return r107.substring(0, 500);
    L41:
        return r107;
    L23:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        String r111 = null;
        if (Result.m9456isSuccessimpl(r109) == false) goto L27;
        CJLogger.d(r101, "onSuccess\n " + r104);
        Object r112 = r109;
        boolean r113 = true;
    L28:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r109);
        if (r114 == null) goto L31;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r114);
        CJLogger.c(r101, "onFailure", r114);
        r113 = false;
    L32:
        long r115 = System.currentTimeMillis() - r105;
        CJLogger.d(r101, "is_success: " + r113 + ", duration: " + r115);
        CJReporter r116 = CJReporter.f202294a;
        Set<String> r117 = CJContext.f202254w;
        CJContext r118 = CJContext.c.a(r102, "", "", new HashMap());
        Pair[] r119 = new Pair[5];
        r119[0] = TuplesKt.to("tag", r102);
        r119[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r113, "1", "0"));
        if (r114 == null) goto L35;
        r111 = r114.getMessage();
    L35:
        if (r111 != null) goto L37;
        r111 = "";
    L37:
        r119[2] = TuplesKt.to("error_msg", r111);
        r119[3] = TuplesKt.to("trace", r104);
        r119[4] = TuplesKt.to("duration", Long.valueOf(r115));
        CJReporter.o(r118, "cjpay_run_catch_result", MapsKt.mapOf(r119));
        new CJResult(r112, r113, r114);
        return "";
    L31:
        r114 = null;
        goto L32
    L27:
        r112 = null;
        r113 = false;
        goto L28
    L14:
        if (StringsKt.isBlank(r103) == true) goto L18;
        r101 = r103;
        goto L18
    L17:
        r101 = r102;
        goto L18
    L5:
        if (StringsKt.isBlank(r100) == false) goto L7;
        r100 = "runCatching";
    L7:
        r102 = r100;
        goto L10
    }

    /* JADX WARN: Incorrect return type in method signature: <T::TP;>(Lorg/json/JSONObject;)TT; */
    private final IJSBParams initParams(JSONObject r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        Class<? super Object> r102 = getClass().getSuperclass();     // Catch: Throwable -> L17
        if (r102 == null) goto L16;
        Type r103 = r102.getGenericSuperclass();     // Catch: Throwable -> L17
        if (r103 == null) goto L16;
        if ((r103 instanceof ParameterizedType) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L16;
        Type r104 = ((ParameterizedType) r103).getActualTypeArguments()[0];     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.lang.Class<T of com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod.initParams>");     // Catch: Throwable -> L17
        Class<T> r105 = (Class) r104;     // Catch: Throwable -> L17
        if (r105 == 0) goto L16;
        return (IJSBParams) CJPayJsonParser.fromJson(fixInputParams(r100, r105), r105);
    L16:
        return null;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Throwable r107 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r107 == null) goto L21;
        CJBasicCommonUtils.reportCatchException("AbsJSBMethod#getCheckInputParamsRuleMap", r107);
        CJBasicCommonUtils.logCatch("CJCatch", "AbsJSBMethod#getCheckInputParamsRuleMap", r107);
        crashMonitor(r107);
    L21:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    public final <T> T getDependency(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.dependencyProvider.get(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    private final <T extends CJPayObject> JSONObject fixInputParams(JSONObject r100, Class<T> r101) {
        JSBConfig r102 = CJPaySettingsManager.getInstance().getJSBConfig();
        Unit r103 = null;
        if (r102 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r102.fixJSBInputParams(getName()));
    L6:
        boolean r105 = false;
        if (r104 == null) goto L9;
        boolean r106 = r104.booleanValue();
    L10:
        if (r106 == false) goto L51;
        JSONObject r107 = new JSONObject(r100.toString());
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L45
        Field[] r109 = r101.getFields();     // Catch: Throwable -> L45
        if (r109.length != 0) goto L16;
        r105 = true;
    L16:
        if ((!r105) == true) goto L19;
        r109 = null;
    L19:
        if (r109 == null) goto L43;
        List r110 = ArraysKt.filterNotNull(r109);     // Catch: Throwable -> L45
        if (r110 == null) goto L43;
        Iterator r111 = r110.iterator();     // Catch: Throwable -> L45
    L24:
        if (r111.hasNext() == false) goto L42;
        Field r112 = (Field) r111.next();     // Catch: Throwable -> L45
        String r113 = r112.getName();     // Catch: Throwable -> L45
        if ((!StringsKt.isBlank(r113)) == false) goto L28;
        String r114 = r113;
    L29:
        Object r115 = r107.opt(r114);     // Catch: Throwable -> L45
        if (r115 == null) goto L24;
        Class<?> r116 = r112.getType();     // Catch: Throwable -> L45
        if ((r115 instanceof Integer) == false) goto L38;
        if (String.class.isAssignableFrom(r116) == false) goto L38;
        KtSafeMethodExtensionKt.safePut(r107, r113, r107.optString(r113));     // Catch: Throwable -> L45
    L38:
        if ((r115 instanceof String) == false) goto L24;
        if (Integer.TYPE.isAssignableFrom(r116) == false) goto L24;
        KtSafeMethodExtensionKt.safePut(r107, r113, Integer.valueOf(r107.optInt(r113)));     // Catch: Throwable -> L45
        goto L24
    L28:
        r114 = null;
        goto L29
    L42:
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L45
    L43:
        Object r117 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L45
    L48:
        if (Result.m9456isSuccessimpl(r117) == false) goto L51;
        Unit r118 = (Unit) r117;
        return r107;
    L45:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L51:
        return r100;
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    private final void invokeMonitor(Context r100, JSONObject r101) {
        CJLogger.d(CJTag(), "invokeMonitor method: " + getName() + ", context: " + r100);
        JSONObject r102 = getJSBReportCommonInfo();
        Map<String, String> r103 = KtSafeMethodExtensionKt.merge(new JSONObject[]{r102, getContainerCommonInfo()});
        CJReporter r104 = CJReporter.f202294a;
        CJReporter.o(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_jsb_invoke", r103);
        JSBIntegratedLogger r105 = JSBIntegratedLogger.INSTANCE;
        b r106 = (b) getDependency(b.class);
        if (r106 == null) goto L5;
        String r107 = r106.getContainerId();
    L6:
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        r105.jsbInvoke(r107, String.valueOf(hashCode()), KtSafeMethodExtensionKt.toMap(r102));
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // cd4.m
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.dependencyProvider.put(r100, r101);
    }

    private final void callbackMonitor(boolean r100, JSONObject r101, String r102) {
        CJLogger.d(CJTag(), "invokeMonitor method: " + getName() + " isSuccess: " + r100 + ", errorMsg: " + r102);
        JSONObject r103 = getJSBReportCommonInfo();
        KtSafeMethodExtensionKt.safePut(r103, "is_success", KtSafeMethodExtensionKt.tf(r100, "1", "0"));
        KtSafeMethodExtensionKt.safePut(r103, "result", getReportResultParams(r101));
        KtSafeMethodExtensionKt.safePut(r103, "errorMsg", r102);
        R r104 = this.output;
        String r105 = null;
        if (r104 == null) goto L5;
        Boolean r106 = Boolean.valueOf(r104.isFatalResult());
    L7:
        if (r106 == null) goto L9;
        boolean r107 = r106.booleanValue();
    L10:
        KtSafeMethodExtensionKt.safePut(r103, "is_fatal_result", KtSafeMethodExtensionKt.tf(r107, "1", "0"));
        Map<String, String> r108 = KtSafeMethodExtensionKt.merge(new JSONObject[]{r103, getContainerCommonInfo()});
        CJReporter r109 = CJReporter.f202294a;
        CJReporter.o(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_jsb_callback", r108);
        JSBIntegratedLogger r110 = JSBIntegratedLogger.INSTANCE;
        b r111 = (b) getDependency(b.class);
        if (r111 == null) goto L13;
        r105 = r111.getContainerId();
    L13:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r110.jsbCallback(r105, String.valueOf(hashCode()), KtSafeMethodExtensionKt.toMap(r103));
        return;
    L9:
        r107 = false;
        goto L10
    L5:
        r106 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r14v6 */
    @Override // cd4.m
    public final void handle(Context r210, JSONObject r310, k r311) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r310, "params");
        String r101 = CJTag();
        String r102 = "runCatching";
        if (r101 != null) goto L5;
    L6:
        r101 = "runCatching";
    L8:
        if (StringsKt.isBlank(r101) == false) goto L15;
        String r103 = CJTag();
        if (r103 != null) goto L12;
    L16:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r102, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r110 = System.currentTimeMillis();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L119
        this.originInputParams = r310;     // Catch: Throwable -> L119
        JsbCallbackWrapper r112 = new JsbCallbackWrapper(this, r311);     // Catch: Throwable -> L119
        r112.onStart(this);     // Catch: Throwable -> L119
        invokeMonitor(r210, r310);     // Catch: Throwable -> L119
        Companion.access$ensureSDKEnvReadyOnce(Companion);     // Catch: Throwable -> L119
        b r113 = (b) getDependency(b.class);     // Catch: Throwable -> L119
        if (r113 == null) goto L20;
        String r114 = r113.getContainerId();     // Catch: Throwable -> L119
    L21:
        if (r114 != null) goto L23;
        r114 = "";
    L23:
        this.containerId = r114;     // Catch: Throwable -> L119
        String r115 = r104;
        this.jsbSession.setInputParamsInitStartTimestamp(System.currentTimeMillis());     // Catch: Throwable -> L117
        this.input = (P) initParams(r310);     // Catch: Throwable -> L117
        this.jsbSession.setInputParamsInitEndTimestamp(System.currentTimeMillis());     // Catch: Throwable -> L117
        R r105 = this.output;     // Catch: Throwable -> L117
        if (r105 == null) goto L43;
        r105.setJsbCallback(r112);     // Catch: Throwable -> L117
        if (callbackStruct() != CallbackStruct.WRAP_CJDATA) goto L30;
        boolean r116 = true;
    L31:
        r105.useNewStructure(r116);     // Catch: Throwable -> L117
        if (callbackStruct() != CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA) goto L34;
        boolean r117 = true;
    L35:
        r105.isOldStructContainCJData(r117);     // Catch: Throwable -> L117
        String r106 = r310.optString("old_struct_use_cj_data");     // Catch: Throwable -> L117
        if (r106 == null) goto L43;
        if ((!StringsKt.isBlank(r106)) == true) goto L41;
        r106 = null;
    L41:
        if (r106 == null) goto L43;
        r105.isOldStructContainCJData(Intrinsics.areEqual(r106, "1"));     // Catch: Throwable -> L117
        goto L43
    L34:
        r117 = false;
        goto L35
    L30:
        r116 = false;
    L43:
        R r107 = this.output;     // Catch: Throwable -> L117
        if (r107 != null) goto L47;
        r112.onFailed("output is null", new JSONObject());     // Catch: Throwable -> L117
        return;
    L47:
        P r108 = this.input;     // Catch: Throwable -> L117
        if (r108 == null) goto L50;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L117
        Map<String, Function0<Boolean>> r109 = getCheckInputParamsRuleMap(r108);     // Catch: Throwable -> L117
        if (r109 == null) goto L81;
        LinkedHashMap r118 = new LinkedHashMap();     // Catch: Throwable -> L117
        Iterator<Map.Entry<String, Function0<Boolean>>> r119 = r109.entrySet().iterator();     // Catch: Throwable -> L117
    L58:
        if (r119.hasNext() == false) goto L63;
        Map.Entry<String, Function0<Boolean>> r120 = r119.next();     // Catch: Throwable -> L117
        if (r120.getValue().invoke().booleanValue() == false) goto L58;
        r118.put(r120.getKey(), r120.getValue());     // Catch: Throwable -> L117
        goto L58
    L63:
        if ((!r118.isEmpty()) == true) goto L66;
        r118 = null;
    L66:
        if (r118 == null) goto L81;
        ArrayList r121 = new ArrayList(r118.size());     // Catch: Throwable -> L117
        Iterator r122 = r118.entrySet().iterator();     // Catch: Throwable -> L117
    L69:
        if (r122.hasNext() == false) goto L71;
        r121.add((String) ((Map.Entry) r122.next()).getKey());     // Catch: Throwable -> L117
        goto L69
    L71:
        String r123 = CollectionsKt.joinToString$default(r121, null, null, null, 0, null, null, 63, null);     // Catch: Throwable -> L117
        if (r123 == null) goto L81;
        R r124 = this.output;     // Catch: Throwable -> L117
        if (r124 != null) goto L76;
        Unit r125 = null;
    L78:
        if (r125 != null) goto L164;
        r112.onFailed(r123, new JSONObject());     // Catch: Throwable -> L115
        return;
    L164:
        return;
    L76:
        IJSBResult.DefaultImpls.onFatal$default(r124, r123, null, 2, null);     // Catch: Throwable -> L115
        r125 = Unit.INSTANCE;     // Catch: Throwable -> L115
    L81:
        r108 = null;
        this.jsbSession.setRealHandleStartTimestamp(System.currentTimeMillis());     // Catch: Throwable -> L115
        if (this.input != null) goto L84;
    L106:
        R r126 = this.output;     // Catch: Throwable -> L115
        if (r126 == null) goto L110;
        r126.onFatal("input/output is null", new JSONObject());     // Catch: Throwable -> L115
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L115
    L111:
        if (r127 != null) goto L113;
        r112.onFailed("input/output is null", new JSONObject());     // Catch: Throwable -> L115
    L113:
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L115
    L123:
        if (Result.m9456isSuccessimpl(r128) == false) goto L125;
        StringBuilder r129 = new StringBuilder("onSuccess\n ");
        String r130 = r115;
        r129.append(r130);
        CJLogger.d(r102, r129.toString());
        Object r131 = r128;
        boolean r132 = true;
    L126:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r128);
        if (r133 == null) goto L129;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r133);
        CJLogger.c(r102, "onFailure", r133);
        r132 = false;
        ?? r134 = r133;
    L130:
        long r135 = System.currentTimeMillis() - r110;
        CJLogger.d(r102, "is_success: " + r132 + ", duration: " + r135);
        CJReporter r136 = CJReporter.f202294a;
        Set<String> r137 = CJContext.f202254w;
        CJContext r138 = CJContext.c.a(r101, "", "", new HashMap());
        Pair[] r139 = new Pair[5];
        r139[0] = TuplesKt.to("tag", r101);
        r139[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r132, "1", "0"));
        if (r134 == 0) goto L133;
        Object r140 = r134.getMessage();
    L134:
        if (r140 != null) goto L136;
        r140 = "";
    L136:
        r139[2] = TuplesKt.to("error_msg", r140);
        r139[3] = TuplesKt.to("trace", r130);
        r139[4] = TuplesKt.to("duration", Long.valueOf(r135));
        CJReporter.o(r138, "cjpay_run_catch_result", MapsKt.mapOf(r139));
        CJResult r141 = new CJResult(r131, r132, r134);
        Throwable r142 = r141.getThrowable();
        if (r142 != null) goto L140;
        r142 = new Throwable();
    L140:
        if ((!r141.getResult()) == false) goto L142;
        ?? r143 = r142;
    L143:
        if (r143 == 0) goto L165;
        CJBasicCommonUtils.reportCatchException("AbsJSBMethod#handle", r143);
        CJBasicCommonUtils.logCatch("CJCatch", "AbsJSBMethod#handle", r143);
        R r144 = this.output;
        if (r144 == null) goto L151;
        String r145 = r143.getMessage();
        if (r145 == null) goto L150;
        r100 = r145;
    L150:
        r144.onFatal(r100, new JSONObject());
    L151:
        crashMonitor(r143);
        return;
    L165:
        return;
    L142:
        r143 = r108;
        goto L143
    L133:
        r140 = r108;
        goto L134
    L129:
        r134 = r108;
        goto L130
    L125:
        r130 = r115;
        r131 = r108;
        r132 = false;
        goto L126
    L110:
        r127 = null;
        goto L111
    L84:
        if (this.output == null) goto L106;
        if ((r210 instanceof Activity) == false) goto L88;
        Context r146 = (Activity) r210;     // Catch: Throwable -> L115
    L89:
        if (r146 == null) goto L92;
    L105:
        P r147 = this.input;     // Catch: Throwable -> L115
        Intrinsics.checkNotNull(r147);     // Catch: Throwable -> L115
        R r148 = this.output;     // Catch: Throwable -> L115
        Intrinsics.checkNotNull(r148);     // Catch: Throwable -> L115
        realHandle(r146, r147, r148);     // Catch: Throwable -> L115
        goto L113
    L92:
        if ((r210 instanceof ContextWrapper) == false) goto L94;
        ContextWrapper r149 = (ContextWrapper) r210;     // Catch: Throwable -> L115
    L95:
        if (r149 == null) goto L97;
        Context r150 = r149.getBaseContext();     // Catch: Throwable -> L115
    L99:
        if ((r150 instanceof Activity) == false) goto L101;
        r146 = (Activity) r150;     // Catch: Throwable -> L115
    L102:
        if (r146 != null) goto L105;
        r146 = r210;
        goto L105
    L101:
        r146 = null;
        goto L102
    L97:
        r150 = null;
        goto L99
    L94:
        r149 = null;
        goto L95
    L88:
        r146 = null;
    L115:
        th = th;
    L121:
        Result.Companion r151 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L123
    L50:
        IJSBResult.DefaultImpls.onFatal$default(r107, "input is null", null, 2, null);     // Catch: Throwable -> L117
        if (Unit.INSTANCE != null) goto L163;
        r112.onFailed("input is null", new JSONObject());     // Catch: Throwable -> L117
        return;
    L163:
        return;
    L117:
        th = th;
    L118:
        r108 = null;
        goto L121
    L20:
        r114 = null;
    L119:
        th = th;
        r115 = r104;
        goto L118
    L12:
        if (StringsKt.isBlank(r103) == true) goto L16;
        r102 = r103;
        goto L16
    L15:
        r102 = r101;
        goto L16
    L5:
        if (StringsKt.isBlank(r101) == false) goto L8;
        goto L6
    }

    public static final /* synthetic */ void access$callbackMonitor(AbsJSBMethod r100, boolean r101, JSONObject r102, String r103) {
        r100.callbackMonitor(r101, r102, r103);
    }
}
