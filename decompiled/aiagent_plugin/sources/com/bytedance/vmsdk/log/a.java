package com.bytedance.vmsdk.log;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ALogReflect.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static long a() {
        return ((Long) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.ss.android.agilelogger.ALog", "com.obric.aiagent.plugin").getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0]), Long.class, "com.obric.aiagent.plugin")).longValue();
    L5:
        e = move-exception;
        a("vmsdk", "No ALog found in the host [ " + e.getMessage() + " ]");
        return 0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
