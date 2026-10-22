package com.android.server.usb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseArray;
import com.android.internal.util.dump.DualDumpOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class UsbPermissionManager {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = null;
    private final Context mContext;
    private final SparseArray<UsbUserPermissionManager> mPermissionsByUser;
    final UsbService mUsbService;

    static {
        LOG_TAG = UsbPermissionManager.class.getSimpleName();
    }

    UsbPermissionManager(Context context, UsbService usbService) {
        this.mPermissionsByUser = new SparseArray();
        this.mContext = context;
        this.mUsbService = usbService;
    }

    UsbUserPermissionManager getPermissionsForUser(int userId) {
        SparseArray<UsbUserPermissionManager> r0 = this.mPermissionsByUser;
        monitor-enter(r0);
        UsbUserPermissionManager permissions = this.mPermissionsByUser.get(userId);     // Catch: Throwable -> L7
        if (permissions != null) goto L9;
        permissions = new UsbUserPermissionManager(this.mContext.createContextAsUser(UserHandle.of(userId), 0), this.mUsbService.getSettingsForUser(userId));     // Catch: Throwable -> L7
        this.mPermissionsByUser.put(userId, permissions);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return permissions;
    L7:
        th = move-exception;
        throw th;
    }

    UsbUserPermissionManager getPermissionsForUser(UserHandle user) {
        return getPermissionsForUser(user.getIdentifier());
    }

    void remove(UserHandle userToRemove) {
        SparseArray<UsbUserPermissionManager> r0 = this.mPermissionsByUser;
        monitor-enter(r0);
        this.mPermissionsByUser.remove(userToRemove.getIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void usbDeviceRemoved(UsbDevice device) {
        SparseArray<UsbUserPermissionManager> r0 = this.mPermissionsByUser;
        monitor-enter(r0);
        int i = 0;
    L16:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPermissionsByUser.size()) goto L11;
        this.mPermissionsByUser.valueAt(i).removeDevicePermissions(device);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Intent intent = new Intent("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intent.addFlags(16777216);
        intent.putExtra("device", device);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    void usbAccessoryRemoved(UsbAccessory accessory) {
        SparseArray<UsbUserPermissionManager> r0 = this.mPermissionsByUser;
        monitor-enter(r0);
        int i = 0;
    L16:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPermissionsByUser.size()) goto L11;
        this.mPermissionsByUser.valueAt(i).removeAccessoryPermissions(accessory);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Intent intent = new Intent("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intent.addFlags(16777216);
        intent.putExtra("accessory", accessory);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        SparseArray<UsbUserPermissionManager> r3 = this.mPermissionsByUser;
        monitor-enter(r3);
        List<UserInfo> users = userManager.getUsers();     // Catch: Throwable -> L7
        int numUsers = users.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numUsers) goto L10;
        getPermissionsForUser(users.get(i).id).dump(dump, "user_permissions", 2246267895809L);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L7
        dump.end(token);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
