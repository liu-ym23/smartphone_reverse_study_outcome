package com.android.ttcjpaysdk.cybs.logger;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/logger/StepUpLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "monitorPageError", "", "url", "", "errorCode", "", "errorMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StepUpLogger implements MvpLogger {
    public StepUpLogger() {
    }

    public final void monitorPageError(String r100, Integer r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("url", r100);     // Catch: Exception -> L5
        r103.put("error_code", r101);     // Catch: Exception -> L5
        r103.put("error_msg", r102);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_step_up_page_error", r103);
        CJLogger.b("StepUpLogger", "set up page load error, url is " + r100 + ", error code is: " + r101 + ", errorMsg is " + r102);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("StepUpLogger#monitorPageError", e);
        CJBasicCommonUtils.logCatch("CJCatch", "StepUpLogger#monitorPageError", e);
        goto L7
    }
}
