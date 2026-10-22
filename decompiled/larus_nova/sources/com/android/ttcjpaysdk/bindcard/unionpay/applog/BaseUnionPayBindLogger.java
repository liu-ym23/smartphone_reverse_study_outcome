package com.android.ttcjpaysdk.bindcard.unionpay.applog;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/BaseUnionPayBindLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "setHostInfo", "(Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "logEvent", "", "event", "", "paramMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseUnionPayBindLogger implements MvpLogger {
    private CJPayHostInfo hostInfo;

    public BaseUnionPayBindLogger() {
        this.hostInfo = BindCardCommonInfoUtil.INSTANCE.getHostInfo();
    }

    public final CJPayHostInfo getHostInfo() {
        return this.hostInfo;
    }

    public final void setHostInfo(CJPayHostInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostInfo = r100;
    }

    public final void logEvent(String r100, HashMap<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L11
        JSONObject r103 = CJPayParamsUtils.getCommonLogParams(r102.getMerchantId(), r102.getAppId());     // Catch: Exception -> L11
        JSONObject r104 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L11
        if (r101 == null) goto L9;
        Iterator<Map.Entry<String, Object>> r105 = r101.entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry<String, Object> r106 = r105.next();     // Catch: Exception -> L11
        r104.put(r106.getKey(), r106.getValue());     // Catch: Exception -> L11
    L9:
        r104.put("addbcard_type", "云闪付");     // Catch: Exception -> L11
        CJPayBindCardLogUtils.doReport(r100, new JSONObject[]{r103, r104});     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseUnionPayBindLogger#logEvent", e);
        CJLogger.b("UnionPayBindLog", e.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logEvent$default(BaseUnionPayBindLogger r100, String r101, HashMap r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.logEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logEvent");
    }
}
