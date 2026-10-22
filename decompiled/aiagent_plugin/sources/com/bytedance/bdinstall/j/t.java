package com.bytedance.bdinstall.j;

import android.os.SystemProperties;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SystemPropertiesProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Object f6338a;

    public t() {
    }

    private Object a() {
        if (f6338a != null) goto L18;
        monitor-enter(t.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f6338a == null) goto L21;
    L12:
        monitor-exit(t.class);     // Catch: Throwable -> L14
        goto L18
    L21:
        f6338a = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return f6338a;
    }

    public String a(String r7) {
        return SystemProperties.get(r7);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r6 = a();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r6.getClass().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r6, new Object[]{r7}), String.class, "com.obric.aiagent.plugin");
    L10:
        e = move-exception;
        throw e;
    L8:
        return "";
    }
}
