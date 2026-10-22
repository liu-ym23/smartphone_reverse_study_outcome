package com.smartisanos.appstore.apm;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f17874b;

    static {
        f17873a = new a();
    }

    public a() {
    }

    public final String a(Context r10) {
        q.g(r10, "context");
        String r11 = f17874b;
        if (e.b(r11) == true) goto L20;
        return r11;
    L20:
        int r12 = Process.myPid();     // Catch: Exception -> L13
        Object r13 = r10.getSystemService("activity");     // Catch: Exception -> L13
        q.e(r13, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r14 = ((ActivityManager) r13).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r14.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r15 = r14.next();     // Catch: Exception -> L13
        if (r15.pid != r12) goto L7;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r15.processName);     // Catch: Exception -> L13
    L15:
        String r16 = r15.processName;     // Catch: Exception -> L13
        f17874b = r16;     // Catch: Exception -> L13
        return r16;
    L18:
        String r17 = b();
        f17874b = r17;
        return r17;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public final String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        Ref$IntRef r11 = new Ref$IntRef();     // Catch: Throwable -> L16
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r13 = r10.read();     // Catch: Throwable -> L16
        r11.element = r13;     // Catch: Throwable -> L16
        if (r13 <= 0) goto L8;
        r12.append((char) r13);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r14 = r12.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r14;
    L12:
        if (r10 != null) goto L24;
    L14:
        return null;
    L24:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }

    public final boolean c(Context r10) {
        q.g(r10, "context");
        String r11 = a(r10);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (q.b(r11, r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt__StringsKt.E(r11, ":", false, 2, null) == false) goto L7;
        return false;
    }
}
