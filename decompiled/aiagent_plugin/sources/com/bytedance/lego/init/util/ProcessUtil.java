package com.bytedance.lego.init.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.t;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

/* JADX INFO: compiled from: ProcessUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessUtil {
    public static final ProcessUtil INSTANCE = null;
    private static String sCurrentProcessName;

    static {
        INSTANCE = new ProcessUtil();
    }

    private ProcessUtil() {
    }

    public final boolean isMainProcess(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.d(r7, "context");
        String r5 = getCurrentProcessName(r7);
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (o.a(r5, r7.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L7;
        return false;
    }

    public final String getCurrentProcessName(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.d(r8, "context");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(sCurrentProcessName, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L33;
        String r6 = sCurrentProcessName;
        if (r6 != null) goto L13;
        o.a();
    L13:
        return r6;
    L33:
        int r3 = Process.myPid();     // Catch: Exception -> L27
        Object r9 = r8.getSystemService("activity");     // Catch: Exception -> L27
        if (r9 == null) goto L26;
        Iterator<ActivityManager.RunningAppProcessInfo> r10 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r9, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L27
    L18:
        if (r10.hasNext() == false) goto L29;
        ActivityManager.RunningAppProcessInfo r4 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        if (r4.pid != r3) goto L18;
        InitLogger.d$default(InitLogger.INSTANCE, null, "processName = " + r4.processName, 1, null);     // Catch: Exception -> L27
        String r11 = r4.processName;     // Catch: Exception -> L27
        sCurrentProcessName = r11;     // Catch: Exception -> L27
        if (r11 != null) goto L24;
        return InitTaskProcess.NONMAIN;
    L24:
        return r11;
    L29:
        String r12 = getCurProcessNameFromProc();
        sCurrentProcessName = r12;
        if (r12 != null) goto L32;
        return InitTaskProcess.NONMAIN;
    L32:
        return r12;
    L26:
        throw new t("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final String getCurProcessNameFromProc() {
        BufferedReader r7 = (BufferedReader) ZeusTransformUtils.preCheckCast(null, BufferedReader.class, "com.obric.aiagent.plugin");
        BufferedReader r2 = new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), InputStream.class, "com.obric.aiagent.plugin"), "iso-8859-1"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        int r8 = r2.read();     // Catch: Throwable -> L13
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L13
    L5:
        if (r8 <= 0) goto L7;
        r1.append((char) r8);     // Catch: Throwable -> L13
        r8 = r2.read();     // Catch: Throwable -> L13
        goto L5
    L7:
        InitLogger.d$default(InitLogger.INSTANCE, null, "processName = " + r1, 1, null);     // Catch: Throwable -> L13
        String r9 = r1.toString();     // Catch: Throwable -> L13
        r2.close();     // Catch: Exception -> L10
    L12:
        return r9;
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        Throwable th = th;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L24
        if (r2 != null) goto L41;
    L23:
        return null;
    L41:
        r2.close();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = move-exception;
        if (r2 != null) goto L33;
    L30:
        throw th;
    L33:
        r2.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L15:
        th = move-exception;
        r2 = r7;
        th = th;
        goto L39
    }
}
