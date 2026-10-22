package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: MultiProcessFileUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "MultiProcessFileUtils";

    public static void a(Context r3, int r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L18
        switch(r4) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L14;
        };     // Catch: Exception -> L18
    L6:
        r0.put("is_full_config", r5);     // Catch: Exception -> L18
        goto L14
    L7:
        r0.put("tnc_abtest", r5);     // Catch: Exception -> L18
        goto L14
    L8:
        r0.put("tnc_etag", r5);     // Catch: Exception -> L18
        goto L14
    L9:
        r0.put("tnc_config", r5);     // Catch: Exception -> L18
        goto L14
    L10:
        r0.put("https_dns", r5);     // Catch: Exception -> L18
        goto L14
    L11:
        r0.put("dns", r5);     // Catch: Exception -> L18
        goto L14
    L12:
        r0.put("ssids", r5);     // Catch: Exception -> L18
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("PushService", "saveData = " + r5);     // Catch: Exception -> L18
    L16:
        TTNetInit.getTTNetDepend().a(r6, r0);     // Catch: Exception -> L18
        return;
    }

    public static String a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        switch(r4) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        String r6 = TTNetInit.getTTNetDepend().a(r5, "is_full_config", "");     // Catch: Exception -> L18
    L19:
    L15:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == true) goto L17;
        return "";
    L17:
        return String.valueOf(r6);
    L6:
        r6 = TTNetInit.getTTNetDepend().a(r5, "tnc_abtest", "");     // Catch: Exception -> L18
        goto L19
    L7:
        r6 = TTNetInit.getTTNetDepend().a(r5, "tnc_etag", "");     // Catch: Exception -> L18
        goto L19
    L8:
        r6 = TTNetInit.getTTNetDepend().a(r5, "tnc_config", "");     // Catch: Exception -> L18
        goto L19
    L9:
        r6 = TTNetInit.getTTNetDepend().a(r5, "https_dns", "");     // Catch: Exception -> L18
        goto L19
    L10:
        r6 = TTNetInit.getTTNetDepend().a(r5, "dns", "");     // Catch: Exception -> L18
        goto L19
    L11:
        r6 = TTNetInit.getTTNetDepend().a(r5, "ssids", "");     // Catch: Exception -> L18
    L13:
        r6 = "";
        goto L15
    }

    public static String a(boolean r0) {
        return Boolean.valueOf(r0).toString();
    }

    public static boolean a(String r0) {
        return Boolean.parseBoolean(r0);
    }
}
