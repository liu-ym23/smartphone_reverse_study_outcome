package com.alipay.sdk.m.p;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public a() {
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String[] r101 = r100.split("&");
        if (r101.length != 0) goto L8;
        return "";
    L8:
        int r102 = r101.length;
        String r103 = null;
        String r104 = null;
        String r105 = null;
        String r106 = null;
        int r107 = 0;
    L9:
        if (r107 >= r102) goto L23;
        String r108 = r101[r107];
        if (TextUtils.isEmpty(r103) == false) goto L14;
        r103 = e(r108);
    L14:
        if (TextUtils.isEmpty(r104) == false) goto L17;
        r104 = d(r108);
    L17:
        if (TextUtils.isEmpty(r105) == false) goto L20;
        r105 = f(r108);
    L20:
        if (TextUtils.isEmpty(r106) == false) goto L22;
        r106 = c(r108);
    L22:
        r107 = r107 + 1;
        goto L9
    L23:
        StringBuilder r109 = new StringBuilder();
        if (TextUtils.isEmpty(r103) == true) goto L27;
        r109.append("biz_type=" + r103 + i.f25853b);
    L27:
        if (TextUtils.isEmpty(r104) == true) goto L30;
        r109.append("biz_no=" + r104 + i.f25853b);
    L30:
        if (TextUtils.isEmpty(r105) == true) goto L33;
        r109.append("trade_no=" + r105 + i.f25853b);
    L33:
        if (TextUtils.isEmpty(r106) == true) goto L35;
        r109.append("app_userid=" + r106 + i.f25853b);
    L35:
        String r110 = r109.toString();
        if (r110.endsWith(i.f25853b) == true) goto L38;
        return r110;
    L38:
        return r110.substring(0, r110.length() - 1);
    }

    public static String b(String r100) {
        String[] r101 = r100.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r101.length <= 1) goto L7;
        String r102 = r101[1];
        if (r102.contains("\"") == true) goto L10;
        return r102;
    L10:
        return r102.replaceAll("\"", "");
    L7:
        return null;
    }

    public static String c(String r100) {
        if (r100.contains("app_userid") == true) goto L7;
        return null;
    L7:
        return b(r100);
    }

    public static String d(String r100) {
        if (r100.contains("biz_no") == true) goto L7;
        return null;
    L7:
        return b(r100);
    }

    public static String e(String r100) {
        if (r100.contains("biz_type") == true) goto L7;
        return null;
    L7:
        return b(r100);
    }

    public static String f(String r100) {
        if (r100.contains(com.alipay.sdk.m.k.b.B0) == true) goto L5;
        return null;
    L5:
        if (r100.startsWith(com.alipay.sdk.m.k.b.A0) == false) goto L8;
        return null;
    L8:
        return b(r100);
    }
}
