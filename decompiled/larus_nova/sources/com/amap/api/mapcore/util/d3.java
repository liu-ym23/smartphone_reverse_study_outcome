package com.amap.api.mapcore.util;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes28.dex */
public class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f27167a;

    private static void a(String r100) {
    }

    static {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= 80) goto L6;
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101 = r101 + 1;
        goto L4
    L6:
        f27167a = r100.toString();
    }

    public static void a() {
        String r100 = p0.a(2131034394);
        a(f27167a);
        a(r100);
        a(f27167a);
    }

    public static void b(String r100) {
        a(f27167a);
        a(r100);
        a(f27167a);
    }

    public static void c(String r100) {
        int r101 = 0;
        if (r100.length() >= 78) goto L9;
        StringBuilder r102 = new StringBuilder(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r102.append(r100);
    L6:
        if (r101 >= (78 - r100.length())) goto L8;
        r102.append(" ");
        r101 = r101 + 1;
        goto L6
    L8:
        r102.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        a(r102.toString());
        return;
    L9:
        a(HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100.substring(0, 78) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        c(r100.substring(78));
    }

    public static void a(Context r100, String r101) {
        a(f27167a);
        if (r100 == null) goto L5;
        c("key:" + l5.e(r100));
    L5:
        a(r101);
        a(f27167a);
    }
}
