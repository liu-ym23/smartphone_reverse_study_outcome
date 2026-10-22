package com.ttnet.org.chromium.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class RadioUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37657a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f37658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f37659c;

    static {
    }

    private RadioUtils() {
    }

    private static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L9:
        return false;
    L5:
        if (a() == false) goto L9;
        if (b() == false) goto L9;
        return true;
    }

    private static boolean a() {
        if (f37658b != null) goto L10;
        if (a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        f37658b = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return f37658b.booleanValue();
    }

    private static boolean b() {
        if (f37659c != null) goto L10;
        if (a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r0 = true;
    L8:
        f37659c = Boolean.valueOf(r0);
        goto L10
    L7:
        r0 = false;
    L10:
        return f37659c.booleanValue();
    }

    private static boolean isWifiConnected() {
        if (f37657a == false) goto L5;
    L9:
        TraceEvent r1 = TraceEvent.a("RadioUtils::isWifiConnected");
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Network r2 = com.ttnet.org.chromium.base.compat.a.a(r0);     // Catch: Throwable -> L26
        if (r2 != null) goto L16;
        if (r1 == null) goto L15;
        r1.close();
    L15:
        return false;
    L16:
        NetworkCapabilities r3 = r0.getNetworkCapabilities(r2);     // Catch: Throwable -> L26
        if (r3 != null) goto L22;
        if (r1 == null) goto L20;
        r1.close();
    L20:
        return false;
    L22:
        boolean r4 = r3.hasTransport(1);     // Catch: Throwable -> L26
        if (r1 == null) goto L25;
        r1.close();
    L25:
        return r4;
    L26:
        th = move-exception;
        if (r1 != null) goto L33;
    L32:
        throw th;
    L33:
        r1.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);
        goto L32
    L5:
        if (isSupported() == true) goto L9;
        throw new AssertionError();
    }

    private static int getCellSignalLevel() {
        if (f37657a == false) goto L5;
    L9:
        TraceEvent r1 = TraceEvent.a("RadioUtils::getCellSignalLevel");
    L19:
        th = move-exception;
        if (r1 != null) goto L27;
    L25:
        throw th;
    L27:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    L11:
        int r2 = -1;
        SignalStrength r0 = com.ttnet.org.chromium.base.compat.d.a((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin"));     // Catch: SecurityException -> L26 Throwable -> L19
        if (r0 == null) goto L16;
        r2 = r0.getLevel();     // Catch: SecurityException -> L26 Throwable -> L19
        goto L16
    L16:
        if (r1 == null) goto L18;
        r1.close();
    L18:
        return r2;
    L5:
        if (isSupported() == true) goto L9;
        throw new AssertionError();
    }

    private static int getCellDataActivity() {
        if (f37657a == false) goto L5;
    L9:
        TraceEvent r1 = TraceEvent.a("RadioUtils::getCellDataActivity");
    L19:
        th = move-exception;
        if (r1 != null) goto L29;
    L25:
        throw th;
    L29:
        r1.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    L26:
        int r0 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getDataActivity();     // Catch: SecurityException -> L15 Throwable -> L19
        if (r1 == null) goto L14;
        r1.close();
    L14:
        return r0;
    L16:
        if (r1 == null) goto L18;
        r1.close();
    L18:
        return -1;
    L5:
        if (isSupported() == true) goto L9;
        throw new AssertionError();
    }
}
