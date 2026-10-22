package com.obric.capabilitykit;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f32140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f32141b;

    static {
        f32140a = new f();
    }

    private f() {
    }

    private final String a() {
        BufferedReader r0 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L13
        z.d r1 = new z.d();     // Catch: Throwable -> L18
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L18
    L5:
        int r3 = r0.read();     // Catch: Throwable -> L18
        r1.f38502a = r3;     // Catch: Throwable -> L18
        if (r3 <= 0) goto L10;
        r2.append((char) r3);     // Catch: Throwable -> L18
        goto L5
    L10:
        Logger.INSTANCE.d("ProcessUtils", "get processName = " + r2);     // Catch: Throwable -> L18
        String r6 = r2.toString();     // Catch: Throwable -> L18
        r0.close();     // Catch: Exception -> L17
    L12:
        return r6;
    L14:
        if (r0 != null) goto L20;
    L16:
        return null;
    L20:
        r0.close();     // Catch: Exception -> L19
    L13:
        r0 = null;
        goto L14
    }

    public final boolean a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        String r4 = b(r6);
        if (r4 != null) goto L5;
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (d.h.b.o.a(r4, r6.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (d.o.o.c(r4, ":", false, 2, null) == false) goto L7;
        return false;
    }

    public final String b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        String r0 = f32141b;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        return r0;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L26;
        f32141b = Application.getProcessName();
        Logger.INSTANCE.d("ProcessUtils", "processName = " + f32141b);
    L15:
        return f32141b;
    L26:
        int r1 = Process.myPid();     // Catch: Exception -> L23
        Object r9 = r8.getSystemService("activity");     // Catch: Exception -> L23
        d.h.b.o.a(r9, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L23
        Iterator<ActivityManager.RunningAppProcessInfo> r10 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r9, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L23
    L18:
        if (r10.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r3.pid != r1) goto L18;
        Logger.INSTANCE.d("ProcessUtils", "processName = " + r3.processName);     // Catch: Exception -> L23
        f32141b = r3.processName;     // Catch: Exception -> L23
        return f32141b;
    L25:
        f32141b = a();
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
