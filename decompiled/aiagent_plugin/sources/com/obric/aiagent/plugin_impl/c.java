package com.obric.aiagent.plugin_impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.plugin_api.ExportedDebugActivity;
import com.obric.aiagent.plugin_api.IPluginApi;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PluginImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements IPluginApi {
    public void init() {
    }

    c() {
    }

    public String query(Context r2, String r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        a("wangkai", "start query 8");
        if (r4 == null) goto L5;
        r4.setClassLoader(c.class.getClassLoader());
    L5:
        if (r4 == null) goto L7;
        String r6 = r4.getString("target_class");
    L8:
        if (r6 != null) goto L10;
        return "query(Context context, String method, Bundle extras)";
    L10:
        return a(r5, r6);
    L7:
        r6 = null;
        goto L8
    }

    public String startTargetActivity(Context r3, Class<?> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        String r6 = r4.getName();
    L7:
        return a(r5, r6);
    L5:
        r6 = String.valueOf(DebugActivity.class);
        goto L7
    }

    public String startTargetActivity(Context r3, String r4) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    private String a(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
        r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    L10:
        Intent r5 = new Intent();
        r5.setClassName(r2, ExportedDebugActivity.class.getName());
        r5.setFlags(268435456);
        ZeusTransformUtils.startActivity(r2, r5, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        return "ookkk10---8";
    L13:
        e = move-exception;
        a("wangkai", "startActivity failed, fallback to AppContext", e);
        ZeusTransformUtils.startActivity((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r5, "com.obric.aiagent.plugin");
        return "ookkk10---8";
    L5:
        if (r4.startsWith("class ") == false) goto L7;
        r4.substring(6).trim();
        goto L7
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
