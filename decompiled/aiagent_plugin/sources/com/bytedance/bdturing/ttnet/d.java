package com.bytedance.bdturing.ttnet;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: TrafficColorHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Context r2, String r3, Map<String, String> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        boolean r7 = a(r5, r3);     // Catch: Exception -> L9
        StringBuilder r8 = new StringBuilder().append("").append("n=");     // Catch: Exception -> L9
        if (r7 == false) goto L6;
        int r9 = 1;
    L7:
        r6.put("x-tt-request-tag", r8.append(r9).append(";").toString() + "t=0");     // Catch: Exception -> L9
        return;
    L6:
        r9 = 0;
    }

    private static boolean a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        URL r0 = new URL(r3);
        if (TextUtils.isEmpty(r0.getPath()) == false) goto L5;
        return true;
    L5:
        if (r0.getPath().contains("vc/setting") == true) goto L7;
        return true;
    L7:
        return true ^ r4.getSharedPreferences("bd_turning_settings_init", 0).getBoolean("inited", false);
    }
}
