package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.xclient.gdid.j.d;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static Pair<Integer, Integer> a(int r100, int r101, int r102) {
        if (r101 <= r100) goto L4;
        if (r100 == 0) goto L4;
    L6:
        return new Pair(Integer.valueOf(r100), Integer.valueOf(r102));
    L4:
        r100 = 1;
        goto L6
    }

    public static boolean a(int r100, int r101) {
        String r102 = Integer.toBinaryString(r101);
        if (r100 <= r102.length()) goto L6;
        return false;
    L6:
        if (r102.charAt(r100 - 1) != '1') goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean a(Context r100, JSONObject r101, String r102, int r103, int r104, int r105) {
        if (com.baidu.sec.privacy.b.b.a(r100).a() == true) goto L8;
        if (a(r104, r105) == true) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L11:
        return true;
    L10:
        if (r101.optInt(r102, r103) == 1) goto L11;
        return false;
    }

    public static String[] a(String r100) {
        String[] r101 = new String[2];
        String[] r102 = r100.split("\n");     // Catch: Throwable -> L31
        if (r102 != null) goto L6;
        return r101;
    L6:
        int r103 = r102.length;     // Catch: Throwable -> L31
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L33;
        String r105 = r102[r104];     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r105) == true) goto L30;
        String[] r106 = r105.trim().split(":");     // Catch: Throwable -> L31
        if (r106 == null) goto L30;
        if (r106.length != 2) goto L30;
        String r107 = r106[0];     // Catch: Throwable -> L31
        if (r107 == null) goto L30;
        if (r106[1] == null) goto L30;
        String r108 = r107.trim();     // Catch: Throwable -> L31
        if (r108.equals("Hardware") == false) goto L22;
    L29:
        r101[0] = r106[1].trim();     // Catch: Throwable -> L31
        goto L30
    L22:
        if (r108.equals("model name") == true) goto L29;
        if (r108.equals(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID) == false) goto L27;
    L28:
        r101[1] = r106[1].trim();     // Catch: Throwable -> L31
        goto L30
    L27:
        if (r108.equals("Processor") == true) goto L28;
    L30:
        r104 = r104 + 1;
    L33:
        return r101;
    L31:
        th = move-exception;
        d.a(th);
        goto L33
    }
}
