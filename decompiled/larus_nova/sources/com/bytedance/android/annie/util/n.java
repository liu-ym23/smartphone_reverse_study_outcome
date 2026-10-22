package com.bytedance.android.annie.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import kotlin.text.Regex;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f40067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static double f40068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f40069c = 0;

    static {
        f40068b = -1.0d;
    }

    public static long b() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L12
        Object[] r101 = new Regex(" ").split(r100.readLine(), 0).toArray(new String[0]);     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        String[] r102 = (String[]) r101;     // Catch: Throwable -> L11
        long r103 = ((Long.parseLong(r102[13]) + Long.parseLong(r102[14])) + Long.parseLong(r102[15])) + Long.parseLong(r102[16]);
        r100.close();
        return r103;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L11
    L13:
        if (r100 == null) goto L20;
        r100.close();
        return -1;
    L20:
        return -1;
    L12:
        r100 = null;
        goto L13
    }

    public static long c() {
        int r100 = Runtime.getRuntime().availableProcessors();
        long r101 = -1;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L29;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu" + r102 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L24
    L31:
        String r104 = r103.readLine();     // Catch: Throwable -> L22
        if (r104 != null) goto L8;
    L35:
        r103.close();     // Catch: Throwable -> L30
        r102 = r102 + 1;     // Catch: Throwable -> L30
        goto L3
    L8:
        if (r104.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L35;
        Object[] r106 = new Regex("\\s+").split(r104, 0).toArray(new String[0]);     // Catch: Throwable -> L22
        if (r106 == null) goto L20;
        String[] r107 = (String[]) r106;     // Catch: Throwable -> L22
        if (r107.length != 2) goto L31;
        r101 = r101 + Long.parseLong(r107[1]);     // Catch: Throwable -> L22
        goto L31
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L22
    L10:
        r105 = false;
    L22:
        th = th;
    L26:
        if (r103 == null) goto L28;
        r103.close();     // Catch: Throwable -> L30
    L28:
        throw th;     // Catch: Throwable -> L30
    L24:
        th = th;
        r103 = null;
    L29:
        return r101;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r100, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r110);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return r100.registerReceiver(null, r110);
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(null, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(null, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, null, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(null, r110);
    }
}
