package com.android.ttcjpaysdk.base.performance.keep;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class PageKeepManager {
    private static Map<String, Long> pageInfo;

    public PageKeepManager() {
    }

    static {
        pageInfo = new HashMap();
    }

    public static void endKeep(String r100) {
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PageKeepManager#report", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PageKeepManager#report", e);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (pageInfo.containsKey(r100) == false) goto L18;
        Long r101 = pageInfo.remove(r100);     // Catch: Exception -> L13
        if (r101 == null) goto L10;
    L11:
        report(r100, System.currentTimeMillis() - r101.longValue());     // Catch: Exception -> L13
        return;
    L10:
        if (r101.longValue() != 0) goto L11;
        return;
    }

    public static void startKeep(String r100) {
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PageKeepManager#startKeep", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PageKeepManager#startKeep", e);
        return;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        pageInfo.put(r100, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L7
    }

    private static void report(String r100, long r101) {
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams("", "");     // Catch: Exception -> L5
        r102.put("time", r101);     // Catch: Exception -> L5
        r102.put("page_name", r100);     // Catch: Exception -> L5
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_page_keep_time", new JSONObject[]{r102});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PageKeepManager#report", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PageKeepManager#report", e);
    }
}
