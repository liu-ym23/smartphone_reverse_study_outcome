package com.android.ttcjpaysdk.base.framework;

import android.os.Build;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes28.dex */
public class SystemIssue {
    private static final List<String> models = null;

    public SystemIssue() {
    }

    static {
        models = new ArrayList();
    }

    private static List<String> getModels() {
        List<String> r100 = models;
        if (r100.isEmpty() == false) goto L5;
        r100.addAll(getModelsForSp());
    L5:
        return r100;
    }

    private static List<String> getModelsForSp() {
        ArrayList r100 = new ArrayList();
        String r101 = CJPaySettingsManager.getInstance().getSettingsInfo("cjpay_fixed_transparent_issue_model");
        if (r101 != null) goto L5;
    L13:
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L13;
        JSONArray r102 = new JSONArray(r101);     // Catch: Exception -> L11
        int r103 = 0;
    L8:
        if (r103 >= r102.length()) goto L13;
        r100.add(JSONArrayProtectorUtils.getString(r102, r103));     // Catch: Exception -> L11
        r103 = r103 + 1;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SystemIssue#getModelsForSp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SystemIssue#getModelsForSp", e);
        goto L13
    }

    public static boolean willFixTransparentIssue() {
        String r100 = Build.MODEL;
        if ("V1821A".equals(r100) == false) goto L6;
        return true;
    L6:
        if (getModels().contains(r100) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
