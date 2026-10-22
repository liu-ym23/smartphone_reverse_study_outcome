package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&JL\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J \u0010\u0016\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000fH&JL\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFastPayService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "doSuperPay", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tradeInfo", "", "hostInfo", "Lorg/json/JSONObject;", "source", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", "fastPay", "params", "", "ptcode", "heightInPx", "", "failureCallback", "Lcom/android/ttcjpaysdk/base/service/IFastPayFailureCallback;", "fastPayHideLoading", "fastPayOnlySendRequest", "fastPayShowLoading", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayFastPayService extends ICJPayService {
    void doSuperPay(Context r100, String r101, JSONObject r102, String r103);

    void doSuperPay(Context r100, String r101, JSONObject r102, String r103, IH5PayCallback r104);

    void fastPay(Context r100, Map<String, String> r101, String r102, int r103, JSONObject r104, IFastPayFailureCallback r105);

    void fastPayHideLoading();

    void fastPayOnlySendRequest(Map<String, String> r100);

    void fastPayShowLoading(Context r100, Map<String, String> r101, String r102, int r103, JSONObject r104, IFastPayFailureCallback r105);
}
