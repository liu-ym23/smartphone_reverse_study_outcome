package com.android.ttcjpaysdk.util;

import android.content.Context;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/util/CJPaySaasAPI;", "", "()V", "checkCaijingSaasProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "saasScene", "", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", d.D, "integrated-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySaasAPI {
    public static final CJPaySaasAPI INSTANCE = null;

    static {
        INSTANCE = new CJPaySaasAPI();
    }

    private CJPaySaasAPI() {
    }

    public final void checkCaijingSaasProcess(CJPayHostInfo r100, String r101) {
        if (r100 == null) goto L13;
        Context r102 = r100.getContext();     // Catch: Exception -> L8
        if (r102 == null) goto L14;
        String r103 = new JSONObject(r101).optString(CJOuterPayBean.KEY_SAAS_SCENE);     // Catch: Exception -> L8
        CJLogger.d("Saas", "checkCaijingSaasProcess saasScene: " + r103);     // Catch: Exception -> L8
        INSTANCE.checkCaijingSaasProcess(r102, r103);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        CJLogger.d("Saas", "checkCaijingSaasProcess exception: " + e.getMessage());
        return;
    }

    public final void checkCaijingSaasProcess(Context r100, String r101) {
        CJLogger.d("Saas", "checkCaijingSaasProcess from tradeConfirm saasScene: " + r101);     // Catch: Exception -> L15
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L21;
        CJPaySaasUtils.INSTANCE.saveSaasEnv(r100, r101, false);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
    L15:
        e = move-exception;
        CJLogger.d("Saas", "checkCaijingSaasProcess from tradeConfirm exception: " + e.getMessage());
    }
}
