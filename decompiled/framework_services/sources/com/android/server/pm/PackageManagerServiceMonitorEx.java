package com.android.server.pm;

import android.content.pm.IPackageManagerMonitorEx;
import bytedanceos.util.FeatLog;
import com.android.server.LocalServices;
import com.android.server.am.ActivityManagerServiceSysMoEx;
import com.android.server.am.UidCpuRunnerInternal;
import com.android.server.pm.dex.DexoptOptions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceMonitorEx extends IPackageManagerMonitorEx.Stub {
    static final int DEX2OPT_IN_SCREENOFF_IDLE_MSG = 200;
    public static final String TAG = "PackageManager";
    private static ActivityManagerServiceSysMoEx.CpuStateObserver mIdleDex2oatObServer;
    static final Map<String, DexoptOptions> pendingDexoptMap = null;
    private static ActivityManagerServiceSysMoEx.CpuStateProvider sCpuStateProvider;
    static boolean sDexoptResumed;
    static final Object sIdleDex2oatLock = null;
    static boolean sObserverRegistered;
    private PackageManagerService mPackageManagerService;

    static {
        sIdleDex2oatLock = new Object();
        sObserverRegistered = false;
        sDexoptResumed = false;
        pendingDexoptMap = new HashMap();
        mIdleDex2oatObServer = new AnonymousClass1();
    }

    public PackageManagerServiceMonitorEx(PackageManagerService packageManagerService) {
        this.mPackageManagerService = packageManagerService;
    }

    public static void startIdleDex2oat() {
        Object r0 = sIdleDex2oatLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sObserverRegistered == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (pendingDexoptMap.size() <= 0) goto L13;
        registerCpuStateObserver(mIdleDex2oatObServer);     // Catch: Throwable -> L8
        sObserverRegistered = true;     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public static void stopIdleDex2oat() {
        Object r0 = sIdleDex2oatLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sObserverRegistered == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        unregisterCpuStateObserver(mIdleDex2oatObServer);     // Catch: Throwable -> L8
        sObserverRegistered = false;     // Catch: Throwable -> L8
        sDexoptResumed = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private static void registerCpuStateObserver(ActivityManagerServiceSysMoEx.CpuStateObserver observer) {
        if (sCpuStateProvider != null) goto L8;
        if (LocalServices.getService(UidCpuRunnerInternal.class) == null) goto L8;
        sCpuStateProvider = ((UidCpuRunnerInternal) LocalServices.getService(UidCpuRunnerInternal.class)).getUidCpuRunner();
    L8:
        if (sCpuStateProvider == null) goto L11;
        sCpuStateProvider.registerCpuStateObserver(observer);
        FeatLog.d(TAG, "FEAT_DELAY_DEX2OAT", 0, "registerCpuStateObserver");
        return;
    }

    private static void unregisterCpuStateObserver(ActivityManagerServiceSysMoEx.CpuStateObserver observer) {
        if (sCpuStateProvider == null) goto L6;
        sCpuStateProvider.unregisterCpuStateObserver(observer);
        FeatLog.d(TAG, "FEAT_DELAY_DEX2OAT", 20, "unregisterCpuStateObserver");
        return;
    }
}
