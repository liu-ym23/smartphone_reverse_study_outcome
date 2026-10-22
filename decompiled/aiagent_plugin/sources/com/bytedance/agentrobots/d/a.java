package com.bytedance.agentrobots.d;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.agentrobots.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RobotsUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (b.a() != 0) goto L7;
        return false;
    L7:
        return b(r3);
    }

    public static boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Settings.Secure.getInt(r4.getContentResolver(), "robots_protocol_enabled", 1) == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        return false;
    L11:
        if (Settings.Secure.getInt(r4.getContentResolver(), "robots_protocol_enabled", -1) == 1) goto L9;
        return false;
    L9:
        return true;
    L14:
        return false;
    }

    public static boolean d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Settings.Secure.getInt(r4.getContentResolver(), "security_log_enabled", -1) == 1) goto L8;
        return false;
    L8:
        return true;
    }
}
