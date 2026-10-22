package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25806a = "00:00:00:00:00:00";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f25807b;

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String d() {
        return f25806a;
    }

    public String a() {
        String r100 = b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        String r101 = c();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100 + "000000000000000";
    L6:
        return r100 + r101;
    }

    public c(Context r100) {
    }

    public static String a(Context r100) {
        return b(r100).a().substring(0, 8);
    }

    public static c b(Context r100) {
        if (f25807b != null) goto L6;
        f25807b = new c(r100);
    L6:
        return f25807b;
    }

    public static String c(Context r100) {
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100.getResources().getConfiguration().locale.toString();
    L7:
        return "";
    }

    public static g d(Context r100) {
        NetworkInfo r101 = com.alipay.sdk.m.w.b.a(null, r100);     // Catch: Exception -> L16
        if (r101 != null) goto L6;
    L9:
        if (r101 == null) goto L15;
        if (r101.getType() != 1) goto L15;
        return g.f25811c;
    L15:
        return g.f25826r;
    L6:
        if (r101.getType() != 0) goto L9;
        return g.a(r101.getSubtype());
    L17:
        return g.f25826r;
    }
}
