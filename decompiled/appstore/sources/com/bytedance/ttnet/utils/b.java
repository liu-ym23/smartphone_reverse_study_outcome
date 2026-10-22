package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String a(Context r10, int r11) {
        switch(r11) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L12;
        };
    L5:
        String r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "tnc_abtest", "");     // Catch: Exception -> L16
    L17:
    L13:
        if (r12 != null) goto L15;
        return "";
    L15:
        return String.valueOf(r12);
    L6:
        r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "tnc_etag", "");     // Catch: Exception -> L16
        goto L17
    L7:
        r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "tnc_config", "");     // Catch: Exception -> L16
        goto L17
    L8:
        r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "https_dns", "");     // Catch: Exception -> L16
        goto L17
    L9:
        r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "dns", "");     // Catch: Exception -> L16
        goto L17
    L10:
        r12 = TTNetInit.getTTNetDepend().getProviderString(r10, "ssids", "");     // Catch: Exception -> L16
    L12:
        r12 = "";
        goto L13
    }

    public static void b(Context r10, int r11, String r12) {
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Exception -> L16
        switch(r11) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L12;
        };     // Catch: Exception -> L16
    L5:
        r13.put("tnc_abtest", r12);     // Catch: Exception -> L16
        goto L12
    L6:
        r13.put("tnc_etag", r12);     // Catch: Exception -> L16
        goto L12
    L7:
        r13.put("tnc_config", r12);     // Catch: Exception -> L16
        goto L12
    L8:
        r13.put("https_dns", r12);     // Catch: Exception -> L16
        goto L12
    L9:
        r13.put("dns", r12);     // Catch: Exception -> L16
        goto L12
    L10:
        r13.put("ssids", r12);     // Catch: Exception -> L16
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d("PushService", "saveData = " + r12);     // Catch: Exception -> L16
    L14:
        TTNetInit.getTTNetDepend().saveMapToProvider(r10, r13);     // Catch: Exception -> L16
        return;
    }
}
