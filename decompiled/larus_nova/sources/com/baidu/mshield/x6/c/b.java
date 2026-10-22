package com.baidu.mshield.x6.c;

import android.os.Build;
import android.view.InputDevice;
import com.baidu.mshield.x6.f.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static boolean b() {
        if (Build.VERSION.SDK_INT < 26) goto L13;
        return true;
    L13:
        return false;
    L8:
        th = move-exception;
        f.b(th);
        return false;
    }

    public static String a() {
        int[] r100 = InputDevice.getDeviceIds();     // Catch: Exception -> L19
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L19
        int r102 = r100.length;     // Catch: Exception -> L19
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L17;
        InputDevice r104 = InputDevice.getDevice(r100[r103]);     // Catch: Exception -> L19
        if (r104 == null) goto L16;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L19
        r105.put("0", r104.getName());     // Catch: Exception -> L19
        r105.put("1", r104.isVirtual() ? 1 : 0);     // Catch: Exception -> L19
        r105.put("2", r104.getVendorId());     // Catch: Exception -> L19
        r105.put("3", r104.getSources());     // Catch: Exception -> L19
        String r106 = r104.toString();     // Catch: Exception -> L19
        if (r106.indexOf("Location: built-in") <= 0) goto L12;
        int r107 = 1;
    L15:
        r105.put("4", r107);     // Catch: Exception -> L19
        r101.put(r105);     // Catch: Exception -> L19
        goto L16
    L12:
        if (r106.indexOf("Location: external") <= 0) goto L14;
        r107 = 2;
        goto L15
    L14:
        r107 = 0;
    L16:
        r103 = r103 + 1;     // Catch: Exception -> L19
        goto L4
    L17:
        return r101.toString().replace("   ", "");
    L19:
        e = move-exception;
        f.b(e);
        return "";
    }
}
