package com.android.ttcjpaysdk.base.smart;

import androidx.collection.SieveCacheKt;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.smart.CJPaySmartConfig;
import com.bytedance.caijing.sdk.infra.base.api.smart.CJPaySmartService;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oe4.a;
import oe4.b;
import oe4.c;
import oe4.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)JQ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/base/smart/CJPaySmartBaseHelper;", "", "", "taskName", "Loe4/c;", "input", "Loe4/d;", "result", "", "errorCode", "errorCodeMsg", "", "durationMs", "originResult", "", "reportLlmRun", "(Ljava/lang/String;Loe4/c;Loe4/d;Ljava/lang/Integer;Ljava/lang/String;JLoe4/d;)V", "userPrompt", "Loe4/b;", "callback", "Lkotlin/Function1;", "systemPromptDecorator", "resultProcessor", "runSmartTask", "preLoadModel", "releaseModel", "Loe4/a;", "modelNames$delegate", "Lkotlin/Lazy;", "getModelNames", "()Loe4/a;", "modelNames", "", "getEnableSwitch", "()Z", "enableSwitch", "Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "getSmartConfig", "()Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "smartConfig", "<init>", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0})
public abstract class CJPaySmartBaseHelper {
    public static final Companion Companion = null;
    public static final int ERROR_FROM_EXTERNAL = -10;
    private static final Lazy<CJPaySmartService> smartService$delegate = null;
    private final Lazy modelNames$delegate;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007J[\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/smart/CJPaySmartBaseHelper$Companion;", "", "", "isSmartEnabled", "", "abKey", "isExposure", "Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "getSmartConfig", "config", "Loe4/a;", "buildModelNames", "clientConfig", "userPrompt", "taskName", "overrideModelName", "", "overrideTimeoutMs", "Lkotlin/Function1;", "systemPromptDecorator", "Loe4/c;", "buildSmartInput", "(Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)Loe4/c;", "Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartService;", "smartService$delegate", "Lkotlin/Lazy;", "getSmartService", "()Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartService;", "smartService", "", "ERROR_FROM_EXTERNAL", "I", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final boolean isSmartEnabled() {
            return true;
        }

        public final CJPaySmartService getSmartService() {
            return (CJPaySmartService) CJPaySmartBaseHelper.access$getSmartService$delegate$cp().getValue();
        }

        @JvmStatic
        public final a buildModelNames(CJPaySmartConfig r100) {
            if (isSmartEnabled() == true) goto L5;
            return null;
        L5:
            if (r100 != null) goto L7;
            return null;
        L7:
            String r101 = r100.scene;
            if (r101 != null) goto L10;
        L13:
            boolean r102 = true;
        L14:
            if (r102 == false) goto L17;
            return null;
        L17:
            return new a(r101);
        L10:
            if (r101.length() == 0) goto L13;
            r102 = false;
            goto L14
        }

        @JvmStatic
        public final CJPaySmartConfig getSmartConfig(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "abKey");
            if (isSmartEnabled() == true) goto L5;
            return null;
        L5:
            CJPaySmartService r102 = getSmartService();
            if (r102 != null) goto L8;
            return null;
        L8:
            return r102.getSmartConfig();
        }

        public static /* synthetic */ CJPaySmartConfig getSmartConfig$default(Companion r100, String r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = true;
        L9:
            return r100.getSmartConfig(r101, r102);
        }

        @JvmStatic
        public final c buildSmartInput(CJPaySmartConfig r110, String r111, String r112, String r113, Long r114, Function1<? super String, String> r115) {
            Intrinsics.checkNotNullParameter(r111, "userPrompt");
            Intrinsics.checkNotNullParameter(r112, "taskName");
            if (isSmartEnabled() == true) goto L5;
            return null;
        L5:
            if (r110 != null) goto L7;
            return null;
        L7:
            if (r113 != null) goto L9;
            String r100 = r110.scene;
        L10:
            if (r100 != null) goto L12;
        L15:
            boolean r101 = true;
        L16:
            if (r101 == false) goto L18;
            return null;
        L18:
            String r102 = r110.systemPrompt;
            if (r102 != null) goto L21;
            r102 = "";
        L21:
            if (r115 == null) goto L26;
            String r103 = r115.invoke(r102);
            if (r103 == null) goto L26;
            String r104 = r103;
        L27:
            Map<String, String> r105 = r110.inferenceParams;
            if (r105 == null) goto L30;
            HashMap r106 = new HashMap(r105);
        L31:
            if (r114 == null) goto L33;
            long r107 = r114.longValue();
        L35:
            return new c(r112, r100, r104, r111, r106, r107);
        L33:
            r107 = r110.timeout;
            goto L35
        L30:
            r106 = null;
        L26:
            r104 = r102;
            goto L27
        L12:
            if (r100.length() == 0) goto L15;
            r101 = false;
            goto L16
        L9:
            r100 = r113;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c buildSmartInput$default(Companion r100, CJPaySmartConfig r110, String r111, String r112, String r113, Long r114, Function1 r115, int r116, Object r117) {
            if ((r116 & 8) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r116 & 16) == 0) goto L9;
            Long r102 = null;
        L11:
            if ((r116 & 32) == 0) goto L13;
            Function1 r103 = null;
        L15:
            return r100.buildSmartInput(r110, r111, r112, r101, r102, r103);
        L13:
            r103 = r115;
            goto L15
        L9:
            r102 = r114;
            goto L11
        L5:
            r101 = r113;
            goto L7
        }
    }

    @JvmStatic
    public static final a buildModelNames(CJPaySmartConfig r100) {
        return Companion.buildModelNames(r100);
    }

    @JvmStatic
    public static final c buildSmartInput(CJPaySmartConfig r100, String r101, String r102, String r110, Long r111, Function1<? super String, String> r112) {
        return Companion.buildSmartInput(r100, r101, r102, r110, r111, r112);
    }

    @JvmStatic
    public static final CJPaySmartConfig getSmartConfig(String r100, boolean r101) {
        return Companion.getSmartConfig(r100, r101);
    }

    @JvmStatic
    public static final boolean isSmartEnabled() {
        return Companion.isSmartEnabled();
    }

    public abstract boolean getEnableSwitch();

    public abstract CJPaySmartConfig getSmartConfig();

    static {
        Companion = new Companion(null);
        smartService$delegate = LazyKt.lazy(CJPaySmartBaseHelper$Companion$smartService$2.INSTANCE);
    }

    public final a getModelNames() {
        return (a) this.modelNames$delegate.getValue();
    }

    public CJPaySmartBaseHelper() {
        this.modelNames$delegate = LazyKt.lazy(new CJPaySmartBaseHelper$modelNames$2(this));
    }

    public final int preLoadModel() {
        if (getEnableSwitch() == true) goto L6;
        return -10;
    L6:
        if (CJPaySettingsManager.getInstance().isDegradeLoadModel() == false) goto L8;
        return -10;
    L8:
        CJPaySmartService r100 = Companion.getSmartService();
        if (r100 != null) goto L11;
        return -10;
    L11:
        a r101 = getModelNames();
        if (r101 != null) goto L15;
        return -10;
    L15:
        return r100.preLoad(r101);
    }

    public final int releaseModel() {
        if (getEnableSwitch() == true) goto L5;
        return -10;
    L5:
        CJPaySmartService r100 = Companion.getSmartService();
        if (r100 != null) goto L8;
        return -10;
    L8:
        a r101 = getModelNames();
        if (r101 != null) goto L12;
        return -10;
    L12:
        return r100.releaseModel(r101);
    }

    public static final /* synthetic */ Lazy access$getSmartService$delegate$cp() {
        return smartService$delegate;
    }

    public final void runSmartTask(final String r110, String r111, final b r112, Function1<? super String, String> r113, final Function1<? super d, d> r114) {
        Intrinsics.checkNotNullParameter(r110, "taskName");
        Intrinsics.checkNotNullParameter(r111, "userPrompt");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (getEnableSwitch() == true) goto L5;
        return;
    L5:
        Companion r100 = Companion;
        final c r115 = Companion.buildSmartInput$default(r100, getSmartConfig(), r111, r110, null, null, r113, 24, null);
        if (r115 != null) goto L8;
        return;
    L8:
        final CJPaySmartService r101 = r100.getSmartService();
        if (r101 != null) goto L11;
        return;
    L11:
        final a r102 = getModelNames();
        if (r102 != null) goto L14;
        return;
    L14:
        final long r103 = System.currentTimeMillis();
        r101.runAsync(r115, new AnonymousClass1(r103, r114, r112, r101, r102, this, r110, r115));
    }

    private final void reportLlmRun(String r100, c r101, d r102, Integer r103, String r110, long r111, d r112) {
        int r104 = 0;
        if (r103 != null) goto L44;
    L18:
        String r105 = "0";
    L20:
        if (r111 >= 0) goto L23;
    L26:
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L41
        r113.put("llm_error_code", r103);     // Catch: Throwable -> L41
        String r114 = "";
        if (r110 != null) goto L30;
        r110 = "";
    L30:
        r113.put("llm_error_msg", r110);     // Catch: Throwable -> L41
        r113.put("llm_task_name", r100);     // Catch: Throwable -> L41
        r113.put("llm_success", r105);     // Catch: Throwable -> L41
        r113.put("llm_inference_duration", r104);     // Catch: Throwable -> L41
        r113.put("llm_userpromt", r101.f522992d);     // Catch: Throwable -> L41
        if (r102 == null) goto L36;
        String r106 = r102.f522996a;     // Catch: Throwable -> L41
        if (r106 == null) goto L36;
        r114 = r106;
    L36:
        r113.put("llm_output", r114);     // Catch: Throwable -> L41
        if (r112 == null) goto L39;
        r113.put("llm_origin_output", r112.f522996a);     // Catch: Throwable -> L41
    L39:
        CJReporter.h(CJReporter.f202294a, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_llm_run", KtSafeMethodExtensionKt.toMap(r113), null, 56);     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySmartBaseHelper#reportLlmRun", th);
        CJLogger.b("CJSmartLlmMonitor", "reportLlmRun error: ${e.message}");
        return;
    L23:
        if (r111 <= SieveCacheKt.NodeLinkMask) goto L25;
        r104 = Integer.MAX_VALUE;
        goto L26
    L25:
        r104 = (int) r111;     // Catch: Throwable -> L41
        goto L26
    L44:
        if (r103.intValue() != 0) goto L18;
        if (r102 == null) goto L9;
        String r107 = r102.f522996a;     // Catch: Throwable -> L41
    L10:
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        r105 = "1";
        goto L20
    L12:
        if (r107.length() == 0) goto L15;
        r108 = false;
        goto L16
    L9:
        r107 = null;
        goto L10
    }

    public static final /* synthetic */ void access$reportLlmRun(CJPaySmartBaseHelper r100, String r101, c r102, d r103, Integer r104, String r105, long r106, d r107) {
        r100.reportLlmRun(r101, r102, r103, r104, r105, r106, r107);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runSmartTask$default(CJPaySmartBaseHelper r100, String r101, String r102, b r110, Function1 r111, Function1 r112, int r113, Object r114) {
        if (r114 != null) goto L14;
        if ((r113 & 8) == 0) goto L6;
        Function1 r103 = null;
    L8:
        if ((r113 & 16) == 0) goto L10;
        Function1 r104 = null;
    L11:
        r100.runSmartTask(r101, r102, r110, r103, r104);
        return;
    L10:
        r104 = r112;
        goto L11
    L6:
        r103 = r111;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runSmartTask");
    }

    public static /* synthetic */ void reportLlmRun$default(CJPaySmartBaseHelper r110, String r111, c r112, d r113, Integer r114, String r115, long r116, d r117, int r118, Object r210) {
        if (r210 != null) goto L10;
        if ((r118 & 64) == 0) goto L6;
        d r100 = null;
    L7:
        r110.reportLlmRun(r111, r112, r113, r114, r115, r116, r100);
        return;
    L6:
        r100 = r117;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportLlmRun");
    }
}
