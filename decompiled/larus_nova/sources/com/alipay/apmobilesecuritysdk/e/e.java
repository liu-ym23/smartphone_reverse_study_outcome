package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class e {
    public static f a(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = com.alipay.apmobilesecuritysdk.f.a.a(r100, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L9;
        r101 = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
    L9:
        if (com.alipay.sdk.m.z.a.a(r101) == false) goto L16;
        return null;
    L16:
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L13
        f r103 = new f();     // Catch: Exception -> L13
        r103.a(JSONObjectProtectorUtils.getString(r102, "imei"));     // Catch: Exception -> L13
        r103.b(JSONObjectProtectorUtils.getString(r102, "imsi"));     // Catch: Exception -> L13
        r103.c(JSONObjectProtectorUtils.getString(r102, "mac"));     // Catch: Exception -> L13
        r103.d(JSONObjectProtectorUtils.getString(r102, "bluetoothmac"));     // Catch: Exception -> L13
        r103.e(JSONObjectProtectorUtils.getString(r102, "gsi"));     // Catch: Exception -> L13
        return r103;
    L13:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);
        return null;
    }
}
