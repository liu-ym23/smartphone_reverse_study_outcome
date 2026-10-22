package com.bytedance.watson.assist.d;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SystemProperties.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f11873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f11874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f11875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f11876d;

    static {
        Method[] r0 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethods();     // Catch: ClassNotFoundException -> L17
        int r1 = r0.length;     // Catch: ClassNotFoundException -> L17
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L28;
        Method r3 = r0[r2];     // Catch: ClassNotFoundException -> L17
        String r4 = r3.getName();     // Catch: ClassNotFoundException -> L17
        if (r4.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L8;
        f11873a = r3;     // Catch: ClassNotFoundException -> L17
    L16:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4.equals("set") == false) goto L11;
        f11876d = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L11:
        if (r4.equals("getLong") == false) goto L14;
        f11874b = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L14:
        if (r4.equals("getInt") == false) goto L16;
        f11875c = r3;     // Catch: ClassNotFoundException -> L17
        goto L16
    L28:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(String r4, String r5) {
        Method r0 = f11873a;
        if (r0 != null) goto L15;
        return r5;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r0.invoke(null, new Object[]{r4, r5}), String.class, "com.obric.aiagent.plugin");
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r5;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
