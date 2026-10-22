package com.android.server;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.app.compat.CompatChanges;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.CpuUsageInfo;
import android.os.IHardwarePropertiesManager;
import android.os.UserHandle;
import com.android.internal.util.DumpUtils;
import com.android.server.vr.VrManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class HardwarePropertiesManagerService extends IHardwarePropertiesManager.Stub {
    private static final String TAG = "HardwarePropertiesManagerService";
    private final AppOpsManager mAppOps;
    private final Context mContext;
    private final Object mLock;

    private static native CpuUsageInfo[] nativeGetCpuUsages();

    private static native float[] nativeGetDeviceTemperatures(int r0, int r1);

    private static native float[] nativeGetFanSpeeds();

    private static native void nativeInit();

    public HardwarePropertiesManagerService(Context context) {
        this.mLock = new Object();
        this.mContext = context;
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService("appops");
        Object r0 = this.mLock;
        monitor-enter(r0);
        nativeInit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public float[] getDeviceTemperatures(String callingPackage, int type, int source) throws SecurityException {
        enforceHardwarePropertiesRetrievalAllowed(callingPackage);
        Object r0 = this.mLock;
        monitor-enter(r0);
        float[] r1 = nativeGetDeviceTemperatures(type, source);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public CpuUsageInfo[] getCpuUsages(String callingPackage) throws SecurityException {
        enforceHardwarePropertiesRetrievalAllowed(callingPackage);
        Object r0 = this.mLock;
        monitor-enter(r0);
        CpuUsageInfo[] r1 = nativeGetCpuUsages();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public float[] getFanSpeeds(String callingPackage) throws SecurityException {
        enforceHardwarePropertiesRetrievalAllowed(callingPackage);
        Object r0 = this.mLock;
        monitor-enter(r0);
        float[] r1 = nativeGetFanSpeeds();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private String getCallingPackageName() {
        PackageManager pm = this.mContext.getPackageManager();
        int uid = Binder.getCallingUid();
        String[] packages = pm.getPackagesForUid(uid);
        if (packages != null) goto L5;
    L8:
        String name = pm.getNameForUid(uid);
        if (name == null) goto L12;
        return name;
    L12:
        return String.valueOf(uid);
    L5:
        if (packages.length <= 0) goto L8;
        return packages[0];
    }

    private void dumpTempValues(String pkg, PrintWriter pw, int type, String typeLabel) {
        dumpTempValues(pkg, pw, type, typeLabel, "temperatures: ", 0);
        dumpTempValues(pkg, pw, type, typeLabel, "throttling temperatures: ", 1);
        dumpTempValues(pkg, pw, type, typeLabel, "shutdown temperatures: ", 2);
        dumpTempValues(pkg, pw, type, typeLabel, "vr throttling temperatures: ", 3);
    }

    private void dumpTempValues(String pkg, PrintWriter pw, int type, String typeLabel, String subLabel, int valueType) {
        pw.println(typeLabel + subLabel + Arrays.toString(getDeviceTemperatures(pkg, type, valueType)));
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        pw.println("****** Dump of HardwarePropertiesManagerService ******");
        String PKG = getCallingPackageName();
        dumpTempValues(PKG, pw, 0, "CPU ");
        dumpTempValues(PKG, pw, 1, "GPU ");
        dumpTempValues(PKG, pw, 2, "Battery ");
        dumpTempValues(PKG, pw, 3, "Skin ");
        float[] fanSpeeds = getFanSpeeds(PKG);
        pw.println("Fan speed: " + Arrays.toString(fanSpeeds) + "\n");
        CpuUsageInfo[] cpuUsageInfos = getCpuUsages(PKG);
        int i = 0;
    L7:
        if (i >= cpuUsageInfos.length) goto L9;
        pw.println("Cpu usage of core: " + i + ", active = " + cpuUsageInfos[i].getActive() + ", total = " + cpuUsageInfos[i].getTotal());
        i = i + 1;
        goto L7
    L9:
        pw.println("****** End of HardwarePropertiesManagerService dump ******");
    }

    private void enforceHardwarePropertiesRetrievalAllowed(String callingPackage) throws SecurityException {
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        int userId = UserHandle.getUserId(Binder.getCallingUid());
        VrManagerInternal vrService = (VrManagerInternal) LocalServices.getService(VrManagerInternal.class);
        if (CompatChanges.isChangeEnabled(307233716) == false) goto L5;
        UserHandle handle = new UserHandle(userId);
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.createContextAsUser(handle, 0).getSystemService(DevicePolicyManager.class);
    L7:
        if (dpm.isDeviceOwnerApp(callingPackage) == false) goto L9;
        return;
    L9:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L17;
        if (vrService == null) goto L15;
        if (vrService.isCurrentVrListener(callingPackage, userId) == false) goto L15;
        return;
    L15:
        throw new SecurityException("The caller is neither a device owner, nor holding the DEVICE_POWER permission, nor the current VrListener.");
    L17:
        return;
    L5:
        dpm = (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);
        goto L7
    }
}
