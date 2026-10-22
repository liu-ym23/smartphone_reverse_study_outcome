package com.android.server.usb;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.IUsbSerialReader;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: loaded from: classes3.dex */
class UsbSerialReader extends IUsbSerialReader.Stub {
    private final Context mContext;
    private Object mDevice;
    private final UsbPermissionManager mPermissionManager;
    private final String mSerialNumber;

    UsbSerialReader(Context context, UsbPermissionManager permissionManager, String serialNumber) {
        this.mContext = context;
        this.mPermissionManager = permissionManager;
        this.mSerialNumber = serialNumber;
    }

    public void setDevice(Object device) {
        this.mDevice = device;
    }

    public String getSerial(String packageName) throws RemoteException {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        if (uid == 1000) goto L23;
        enforcePackageBelongsToUid(uid, packageName);
        UserHandle user = Binder.getCallingUserHandle();
        long token = Binder.clearCallingIdentity();
        PackageInfo pkg = this.mContext.getPackageManager().getPackageInfoAsUser(packageName, 0, user.getIdentifier());     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L17
        int packageTargetSdkVersion = pkg.applicationInfo.targetSdkVersion;     // Catch: Throwable -> L13
        if (packageTargetSdkVersion >= 29) goto L9;
    L16:
        Binder.restoreCallingIdentity(token);
        goto L23
    L9:
        if (this.mContext.checkPermission("android.permission.MANAGE_USB", pid, uid) != (-1)) goto L16;
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L13
        if ((this.mDevice instanceof UsbDevice) == false) goto L15;
        this.mPermissionManager.getPermissionsForUser(userId).checkPermission((UsbDevice) this.mDevice, packageName, pid, uid);     // Catch: Throwable -> L13
        goto L16
    L15:
        this.mPermissionManager.getPermissionsForUser(userId).checkPermission((UsbAccessory) this.mDevice, pid, uid);     // Catch: Throwable -> L13
        goto L16
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L19:
        throw new RemoteException("package " + packageName + " cannot be found");     // Catch: Throwable -> L13
    L23:
        return this.mSerialNumber;
    }

    private void enforcePackageBelongsToUid(int uid, String packageName) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (ArrayUtils.contains(packages, packageName) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(packageName + " does to belong to the " + uid);
    }
}
