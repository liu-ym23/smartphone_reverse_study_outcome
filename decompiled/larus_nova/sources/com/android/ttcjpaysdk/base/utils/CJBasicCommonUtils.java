package com.android.ttcjpaysdk.base.utils;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.lynx.tasm.LynxError;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJBasicCommonUtils;", "", "()V", "blackLogSet", "Ljava/util/HashSet;", "", "getBlackLogSet", "()Ljava/util/HashSet;", "blackLogSet$delegate", "Lkotlin/Lazy;", "blackReportSet", "getBlackReportSet", "blackReportSet$delegate", "degradeLog", "", "getDegradeLog", "()Z", "degradeLog$delegate", "degradeReport", "getDegradeReport", "degradeReport$delegate", "logCatch", "", "tag", "msg", LynxError.LYNX_THROWABLE, "", "reportCatchException", "fieldName", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBasicCommonUtils {
    public static final CJBasicCommonUtils INSTANCE = null;
    private static final Lazy blackLogSet$delegate = null;
    private static final Lazy blackReportSet$delegate = null;
    private static final Lazy degradeLog$delegate = null;
    private static final Lazy degradeReport$delegate = null;

    private CJBasicCommonUtils() {
    }

    static {
        INSTANCE = new CJBasicCommonUtils();
        degradeReport$delegate = LazyKt.lazy(CJBasicCommonUtils$degradeReport$2.INSTANCE);
        degradeLog$delegate = LazyKt.lazy(CJBasicCommonUtils$degradeLog$2.INSTANCE);
        blackReportSet$delegate = LazyKt.lazy(CJBasicCommonUtils$blackReportSet$2.INSTANCE);
        blackLogSet$delegate = LazyKt.lazy(CJBasicCommonUtils$blackLogSet$2.INSTANCE);
    }

    private final HashSet<String> getBlackLogSet() {
        return (HashSet) blackLogSet$delegate.getValue();
    }

    private final HashSet<String> getBlackReportSet() {
        return (HashSet) blackReportSet$delegate.getValue();
    }

    private final boolean getDegradeLog() {
        return ((Boolean) degradeLog$delegate.getValue()).booleanValue();
    }

    private final boolean getDegradeReport() {
        return ((Boolean) degradeReport$delegate.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void reportCatchException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldName");
        CJBasicCommonUtils r102 = INSTANCE;
        if (r102.getDegradeReport() == false) goto L5;
        return;
    L5:
        if (r102.getBlackReportSet().contains(r100) == true) goto L15;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "aid", CJEnv.e());     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "os_name", "android");     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "app_platform", "native");     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "params_for_special", a.VALUE_PARAMS_FOR_SPECIAL);     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "error_code", r100);     // Catch: Throwable -> L9
        KtSafeMethodExtensionKt.safePut(r103, "error_msg", CJBasicCommonUtilsKt.access$asErrorMessage(r101));     // Catch: Throwable -> L9
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_catch_exception", new JSONObject[]{r103});     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        CJLogger.c("CJBasicCommonUtils", "reportCatchException internal error", th);
        return;
    }

    @JvmStatic
    public static final void logCatch(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        CJBasicCommonUtils r103 = INSTANCE;
        if (r103.getDegradeLog() == false) goto L5;
        return;
    L5:
        if (r103.getBlackLogSet().contains(r101) == true) goto L13;
        if (r102 == null) goto L9;
        CJLogger.c(r100, r101, r102);
        return;
    L9:
        CJLogger.b(r100, r101);
        return;
    }

    public static /* synthetic */ void logCatch$default(String r100, String r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        logCatch(r100, r101, r102);
    }
}
