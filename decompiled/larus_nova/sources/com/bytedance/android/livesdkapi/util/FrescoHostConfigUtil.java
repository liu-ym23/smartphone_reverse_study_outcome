package com.bytedance.android.livesdkapi.util;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class FrescoHostConfigUtil {
    public static final String LIVE_FRESCO_CONFIG_KEY = "live_fresco_config_key";

    public FrescoHostConfigUtil() {
    }

    public static String[] allowDomains(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = 0;
        String r102 = r100.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getString(LIVE_FRESCO_CONFIG_KEY, "");
        if (TextUtils.isEmpty(r102) == false) goto L17;
    L16:
        return null;
    L17:
        JSONArray r103 = new JSONObject(r102).optJSONArray("allowDomains");     // Catch: Exception -> L14
        if (r103 == null) goto L16;
        int r104 = r103.length();     // Catch: Exception -> L14
        String[] r105 = new String[r104];     // Catch: Exception -> L14
    L10:
        if (r101 >= r104) goto L13;
        r105[r101] = JSONArrayProtectorUtils.getString(r103, r101);     // Catch: Exception -> L14
        r101 = r101 + 1;
        goto L10
    L13:
        return r105;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static boolean enable(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L12:
        String r101 = r100.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getString(LIVE_FRESCO_CONFIG_KEY, "");
        if (TextUtils.isEmpty(r101) == false) goto L19;
    L18:
        return false;
    L19:
        return new JSONObject(r101).optBoolean("enable", false);
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L8:
        if (r100.getApplicationInfo().targetSdkVersion != 26) goto L12;
        if (r100.getSystemService(StorageManager.class) != null) goto L12;
        return false;
    }
}
