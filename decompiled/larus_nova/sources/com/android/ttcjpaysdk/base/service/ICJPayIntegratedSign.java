package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.alipay.sdk.m.x.d;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&JN\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSign;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "showCounter", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "hostInfo", "Lorg/json/JSONObject;", "signPreRoute", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", d.D, "", "", "extraInfo", "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayIntegratedSign extends ICJPayService {
    void showCounter(Context r100, JSONObject r101);

    void signPreRoute(Context r100, CJContext r101, Map<String, String> r102, Map<String, ? extends Object> r103, ICJPayIntegratedSignCallback r104);
}
