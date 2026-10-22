package com.android.server.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.usb.IDisplayPortAltModeInfoListener;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.IUsbManagerInternal;
import android.hardware.usb.IUsbOperationInternal;
import android.hardware.usb.ParcelableUsbPort;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.FgThread;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.SystemService;
import com.android.server.location.StarLocation;
import com.android.server.storage.DiskStatsFileLogger;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class UsbService extends IUsbManager.Stub {
    public static final int OS_USB_DISABLE_REASON_AAPM = 0;
    public static final int OS_USB_DISABLE_REASON_LOCKDOWN_MODE = 1;
    static final int PACKAGE_MONITOR_OPERATION_ID = 1;
    static final int STRONG_AUTH_OPERATION_ID = 2;
    private static final String TAG = "UsbService";
    private final UsbAlsaManager mAlsaManager;
    private final Context mContext;
    private int mCurrentUserId;
    private UsbDeviceManager mDeviceManager;
    private UsbHostManager mHostManager;
    private final Object mLock;
    private final UsbPermissionManager mPermissionManager;
    private UsbPortManager mPortManager;
    private final UsbSettingsManager mSettingsManager;
    private final ArrayMap<String, UsbDataSignalDisableRequesters> mUsbDisableRequesters;
    private final UserManager mUserManager;

    public static class Lifecycle extends SystemService {
        private final CompletableFuture<Void> mOnActivityManagerPhaseFinished;
        private final CompletableFuture<Void> mOnStartFinished;
        private UsbService mUsbService;

        /* JADX INFO: renamed from: $r8$lambda$HIZVSW8uTg1XjWF6etZh-bC1WP4, reason: not valid java name */
        public static /* synthetic */ void m9200$r8$lambda$HIZVSW8uTg1XjWF6etZhbC1WP4(Lifecycle r0) {
            r0.lambda$onStart$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$Mg_De1rrLXj-nb8KhKM4m5DIFVU, reason: not valid java name */
        public static /* synthetic */ void m9201$r8$lambda$Mg_De1rrLXjnb8KhKM4m5DIFVU(Lifecycle r0) {
            r0.lambda$onBootPhase$1();
        }

        public static /* synthetic */ void $r8$lambda$lHHjBX3uMC4py3Xqq6rTL0s78YU(Lifecycle r0, SystemService.TargetUser r1) {
            r0.lambda$onUserSwitching$2(r1);
        }

        public Lifecycle(Context context) {
            super(context);
            this.mOnStartFinished = new CompletableFuture();
            this.mOnActivityManagerPhaseFinished = new CompletableFuture();
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            SystemServerInitThreadPool.submit(new UsbService$Lifecycle$$ExternalSyntheticLambda0(this), "UsbService$Lifecycle#onStart");
        }

        private /* synthetic */ void lambda$onStart$0() {
            this.mUsbService = new UsbService(getContext());
            publishBinderService("usb", this.mUsbService);
            this.mOnStartFinished.complete(null);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            SystemServerInitThreadPool.submit(new UsbService$Lifecycle$$ExternalSyntheticLambda1(this), "UsbService$Lifecycle#onBootPhase");
            return;
        L6:
            if (phase != 1000) goto L10;
            this.mOnActivityManagerPhaseFinished.join();
            this.mUsbService.bootCompleted();
            return;
        }

        private /* synthetic */ void lambda$onBootPhase$1() {
            this.mOnStartFinished.join();
            this.mUsbService.systemReady();
            this.mOnActivityManagerPhaseFinished.complete(null);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, final SystemService.TargetUser to) {
            FgThread.getHandler().postAtFrontOfQueue(new UsbService$Lifecycle$$ExternalSyntheticLambda2(this, to));
        }

        private /* synthetic */ void lambda$onUserSwitching$2(SystemService.TargetUser to) {
            UsbService.m9199$$Nest$monSwitchUser(this.mUsbService, to.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser userInfo) {
            UsbService.m9198$$Nest$monStopUser(this.mUsbService, userInfo.getUserHandle());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser userInfo) {
            this.mUsbService.onUnlockUser(userInfo.getUserIdentifier());
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OsUsbDisableReason {
    }

    private class PackageUninstallMonitor extends PackageMonitor {
        final /* synthetic */ UsbService this$0;

        /* synthetic */ PackageUninstallMonitor(UsbService r1, UsbServiceIA r2) {
            this(r1);
        }

        private PackageUninstallMonitor(UsbService r1) {
            this.this$0 = r1;
        }

        public void onUidRemoved(int uid) {
            ArrayMap r0 = UsbService.m9197$$Nest$fgetmUsbDisableRequesters(this.this$0);
            monitor-enter(r0);
            Iterator r1 = UsbService.m9197$$Nest$fgetmUsbDisableRequesters(this.this$0).keySet().iterator();     // Catch: Throwable -> L12
        L6:
            if (r1.hasNext() == false) goto L15;
            String portId = (String) r1.next();     // Catch: Throwable -> L12
            UsbDataSignalDisableRequesters disableRequesters = (UsbDataSignalDisableRequesters) UsbService.m9197$$Nest$fgetmUsbDisableRequesters(this.this$0).get(portId);     // Catch: Throwable -> L12
            if (disableRequesters == null) goto L6;
            disableRequesters.mExternalUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L12
            if (disableRequesters.isEmpty() == false) goto L6;
            this.this$0.enableUsbData(portId, true, 1, new IUsbOperationInternal.Default());     // Catch: Throwable -> L12
            goto L6
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    private class StrongAuthTracker extends LockPatternUtils.StrongAuthTracker {
        private boolean mLockdownModeStatus;
        final /* synthetic */ UsbService this$0;

        StrongAuthTracker(UsbService r1, Context context, Looper looper) {
            this.this$0 = r1;
            super(context, looper);
        }

        public synchronized void onStrongAuthRequiredChanged(int userId) {
            monitor-enter(this);
        L19:
            th = move-exception;
            throw th;
        L4:
            if ((getStrongAuthForUser(userId) & 32) == 0) goto L6;
            boolean lockDownTriggeredByUser = true;
        L8:
            if (this.mLockdownModeStatus != lockDownTriggeredByUser) goto L11;
            monitor-exit(this);
            return;
        L11:
            this.mLockdownModeStatus = lockDownTriggeredByUser;     // Catch: Throwable -> L19
            UsbPort[] r3 = UsbService.m9196$$Nest$fgetmPortManager(this.this$0).getPorts();     // Catch: Throwable -> L19
            int r4 = r3.length;     // Catch: Throwable -> L19
            int r5 = 0;
        L12:
            if (r5 >= r4) goto L21;
            UsbPort port = r3[r5];     // Catch: Throwable -> L19
            UsbService r7 = this.this$0;     // Catch: Throwable -> L19
            String r8 = port.getId();     // Catch: Throwable -> L19
            if (lockDownTriggeredByUser == true) goto L16;
            boolean r9 = true;
        L17:
            r7.enableUsbDataInternal(r8, r9, 2, new IUsbOperationInternal.Default(), 1, true);     // Catch: Throwable -> L19
            r5 = r5 + 1;
            goto L12
        L16:
            r9 = false;
            goto L17
        L21:
            monitor-exit(this);
            return;
        L6:
            lockDownTriggeredByUser = false;
            goto L8
        }
    }

    private class UsbManagerInternalImpl extends IUsbManagerInternal.Stub {
        private static final AtomicInteger sUsbOperationCount = null;
        final /* synthetic */ UsbService this$0;

        private UsbManagerInternalImpl(UsbService r1) {
            this.this$0 = r1;
        }

        static {
            sUsbOperationCount = new AtomicInteger();
        }

        public boolean enableUsbDataSignal(boolean enable, int disableReason) {
            boolean result = true;
            int operationId = sUsbOperationCount.incrementAndGet() + disableReason;
            UsbPort[] r1 = UsbService.m9196$$Nest$fgetmPortManager(this.this$0).getPorts();
            int r9 = r1.length;
            int r10 = 0;
        L3:
            if (r10 >= r9) goto L8;
            UsbPort port = r1[r10];
            boolean enable2 = enable;
            int disableReason2 = disableReason;
            boolean success = this.this$0.enableUsbDataInternal(port.getId(), enable2, operationId, new IUsbOperationInternal.Default(), disableReason2, true);
            if (success == true) goto L7;
            Slog.e(UsbService.TAG, "enableUsbDataInternal failed to change USB port " + port.getId() + "state to " + enable2);
        L7:
            result = result & success;
            r10 = r10 + 1;
            enable = enable2;
            disableReason = disableReason2;
            goto L3
        L8:
            return result;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbDeviceManager m9195$$Nest$fgetmDeviceManager(UsbService r0) {
        return r0.mDeviceManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPortManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbPortManager m9196$$Nest$fgetmPortManager(UsbService r0) {
        return r0.mPortManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsbDisableRequesters, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9197$$Nest$fgetmUsbDisableRequesters(UsbService r0) {
        return r0.mUsbDisableRequesters;
    }

    /* JADX INFO: renamed from: -$$Nest$monStopUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9198$$Nest$monStopUser(UsbService r0, UserHandle r1) {
        r0.onStopUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monSwitchUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9199$$Nest$monSwitchUser(UsbService r0, int r1) {
        r0.onSwitchUser(r1);
    }

    UsbUserSettingsManager getSettingsForUser(int userId) {
        return this.mSettingsManager.getSettingsForUser(userId);
    }

    UsbUserPermissionManager getPermissionsForUser(int userId) {
        return this.mPermissionManager.getPermissionsForUser(userId);
    }

    public UsbService(Context context) {
        this.mLock = new Object();
        this.mUsbDisableRequesters = new ArrayMap();
        this.mContext = context;
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mSettingsManager = new UsbSettingsManager(context, this);
        this.mPermissionManager = new UsbPermissionManager(context, this);
        this.mAlsaManager = new UsbAlsaManager(context);
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.usb.host") == false) goto L6;
        this.mHostManager = new UsbHostManager(context, this.mAlsaManager, this.mPermissionManager);
    L6:
        if (new File("/sys/class/android_usb").exists() == false) goto L9;
        this.mDeviceManager = new UsbDeviceManager(context, this.mAlsaManager, this.mSettingsManager, this.mPermissionManager);
    L9:
        if (this.mHostManager == null) goto L11;
    L12:
        this.mPortManager = new UsbPortManager(context);
    L13:
        onSwitchUser(0);
        BroadcastReceiver receiver = new AnonymousClass1(this);
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);
        filter.addAction("android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED");
        this.mContext.registerReceiverAsUser(receiver, UserHandle.ALL, filter, null, null);
        return;
    L11:
        if (this.mDeviceManager == null) goto L13;
        goto L12
    }

    UsbService(Context context, UsbPortManager usbPortManager, UsbAlsaManager usbAlsaManager, UserManager userManager, UsbSettingsManager usbSettingsManager) {
        this.mLock = new Object();
        this.mUsbDisableRequesters = new ArrayMap();
        this.mContext = context;
        this.mPortManager = usbPortManager;
        this.mAlsaManager = usbAlsaManager;
        this.mUserManager = userManager;
        this.mSettingsManager = usbSettingsManager;
        this.mPermissionManager = new UsbPermissionManager(context, this);
    }

    private void onSwitchUser(int newUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentUserId = newUserId;     // Catch: Throwable -> L7
        UsbProfileGroupSettingsManager settings = this.mSettingsManager.getSettingsForProfileGroup(UserHandle.of(newUserId));     // Catch: Throwable -> L7
        if (this.mHostManager == null) goto L10;
        this.mHostManager.setCurrentUserSettings(settings);     // Catch: Throwable -> L7
    L10:
        if (this.mDeviceManager == null) goto L12;
        this.mDeviceManager.setCurrentUser(newUserId, settings);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onStopUser(UserHandle stoppedUser) {
        this.mSettingsManager.remove(stoppedUser);
    }

    public void systemReady() {
        this.mAlsaManager.systemReady();
        if (this.mDeviceManager == null) goto L6;
        this.mDeviceManager.systemReady();
    L6:
        if (this.mHostManager == null) goto L9;
        this.mHostManager.systemReady();
    L9:
        if (this.mPortManager == null) goto L12;
        this.mPortManager.systemReady();
        return;
    }

    public void bootCompleted() {
        if (this.mDeviceManager == null) goto L5;
        this.mDeviceManager.bootCompleted();
    L5:
        new PackageUninstallMonitor(this, null).register(this.mContext, UserHandle.ALL, BackgroundThread.getHandler());
        new LockPatternUtils(this.mContext).registerStrongAuthTracker(new StrongAuthTracker(this, this.mContext, BackgroundThread.getHandler().getLooper()));
    }

    public void onUnlockUser(int user) {
        if (this.mDeviceManager == null) goto L6;
        this.mDeviceManager.onUnlockUser(user);
        return;
    }

    public void getDeviceList(Bundle devices) {
        if (this.mHostManager == null) goto L6;
        this.mHostManager.getDeviceList(devices);
        return;
    }

    public ParcelFileDescriptor openDevice(String deviceName, String packageName) {
        ParcelFileDescriptor fd = null;
        if (this.mHostManager == null) goto L30;
        if (deviceName == null) goto L30;
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int user = UserHandle.getUserId(uid);
        long ident = IUsbManager.Stub.clearCallingIdentity();
        Object r11 = this.mLock;     // Catch: Throwable -> L24
        monitor-enter(r11);     // Catch: Throwable -> L24
    L15:
        th = move-exception;
        Throwable r13 = th;
    L20:
        monitor-exit(r11);     // Catch: Throwable -> L13
        throw r13;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r14 = th;
    L26:
        IUsbManager.Stub.restoreCallingIdentity(ident);
        throw r14;
    L9:
        if (this.mUserManager.isSameProfileGroup(user, this.mCurrentUserId) == false) goto L17;
        fd = this.mHostManager.openDevice(deviceName, getPermissionsForUser(user), packageName, pid, uid);     // Catch: Throwable -> L13
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L13
        IUsbManager.Stub.restoreCallingIdentity(ident);
        goto L30
    L17:
        Slog.w(TAG, "Cannot open " + deviceName + " for user " + user + " as user is not active.");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13 = th;
    L24:
        th = move-exception;
        r14 = th;
    L30:
        return fd;
    }

    public UsbAccessory getCurrentAccessory() {
        if (this.mDeviceManager != null) goto L5;
        return null;
    L5:
        return this.mDeviceManager.getCurrentAccessory();
    }

    public ParcelFileDescriptor openAccessory(UsbAccessory accessory) {
        if (this.mDeviceManager == null) goto L23;
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int user = UserHandle.getUserId(uid);
        long ident = IUsbManager.Stub.clearCallingIdentity();
        Object r5 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r5);     // Catch: Throwable -> L20
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L8:
        if (this.mUserManager.isSameProfileGroup(user, this.mCurrentUserId) == false) goto L15;
        ParcelFileDescriptor r6 = this.mDeviceManager.openAccessory(accessory, getPermissionsForUser(user), pid, uid);     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        IUsbManager.Stub.restoreCallingIdentity(ident);
        return r6;
    L15:
        Slog.w(TAG, "Cannot open " + accessory + " for user " + user + " as user is not active.");     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        IUsbManager.Stub.restoreCallingIdentity(ident);
        return null;
    L20:
        th = move-exception;
        IUsbManager.Stub.restoreCallingIdentity(ident);
        throw th;
    L23:
        return null;
    }

    public ParcelFileDescriptor getControlFd(long function) {
        getControlFd_enforcePermission();
        return this.mDeviceManager.getControlFd(function);
    }

    public void setDevicePackage(UsbDevice device, String packageName, int userId) {
        device.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        UserHandle user = UserHandle.of(userId);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).setDevicePackage(device, packageName, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setAccessoryPackage(UsbAccessory accessory, String packageName, int userId) {
        accessory.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        UserHandle user = UserHandle.of(userId);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).setAccessoryPackage(accessory, packageName, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void addDevicePackagesToPreferenceDenied(UsbDevice device, String[] packageNames, UserHandle user) {
        device.getClass();
        String[] packageNames2 = (String[]) Preconditions.checkArrayElementsNotNull(packageNames, DiskStatsFileLogger.PACKAGE_NAMES_KEY);
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).addDevicePackagesToDenied(device, packageNames2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void addAccessoryPackagesToPreferenceDenied(UsbAccessory accessory, String[] packageNames, UserHandle user) {
        accessory.getClass();
        String[] packageNames2 = (String[]) Preconditions.checkArrayElementsNotNull(packageNames, DiskStatsFileLogger.PACKAGE_NAMES_KEY);
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).addAccessoryPackagesToDenied(accessory, packageNames2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void removeDevicePackagesFromPreferenceDenied(UsbDevice device, String[] packageNames, UserHandle user) {
        device.getClass();
        String[] packageNames2 = (String[]) Preconditions.checkArrayElementsNotNull(packageNames, DiskStatsFileLogger.PACKAGE_NAMES_KEY);
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).removeDevicePackagesFromDenied(device, packageNames2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void removeAccessoryPackagesFromPreferenceDenied(UsbAccessory accessory, String[] packageNames, UserHandle user) {
        accessory.getClass();
        String[] packageNames2 = (String[]) Preconditions.checkArrayElementsNotNull(packageNames, DiskStatsFileLogger.PACKAGE_NAMES_KEY);
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).removeAccessoryPackagesFromDenied(accessory, packageNames2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setDevicePersistentPermission(UsbDevice device, int uid, UserHandle user, boolean shouldBeGranted) {
        device.getClass();
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mPermissionManager.getPermissionsForUser(user).setDevicePersistentPermission(device, uid, shouldBeGranted);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setAccessoryPersistentPermission(UsbAccessory accessory, int uid, UserHandle user, boolean shouldBeGranted) {
        accessory.getClass();
        user.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long token = Binder.clearCallingIdentity();
        this.mPermissionManager.getPermissionsForUser(user).setAccessoryPersistentPermission(accessory, uid, shouldBeGranted);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean hasDevicePermission(UsbDevice device, String packageName) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        boolean r5 = getPermissionsForUser(userId).hasPermission(device, packageName, pid, uid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r5;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean hasDevicePermissionWithIdentity(UsbDevice device, String packageName, int pid, int uid) {
        hasDevicePermissionWithIdentity_enforcePermission();
        int userId = UserHandle.getUserId(uid);
        return getPermissionsForUser(userId).hasPermission(device, packageName, pid, uid);
    }

    public boolean hasAccessoryPermission(UsbAccessory accessory) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        boolean r5 = getPermissionsForUser(userId).hasPermission(accessory, pid, uid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r5;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean hasAccessoryPermissionWithIdentity(UsbAccessory accessory, int pid, int uid) {
        hasAccessoryPermissionWithIdentity_enforcePermission();
        int userId = UserHandle.getUserId(uid);
        return getPermissionsForUser(userId).hasPermission(accessory, pid, uid);
    }

    public void requestDevicePermission(UsbDevice device, String packageName, PendingIntent pi) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        getPermissionsForUser(userId).requestPermission(device, packageName, pi, pid, uid);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public void requestAccessoryPermission(UsbAccessory accessory, String packageName, PendingIntent pi) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        getPermissionsForUser(userId).requestPermission(accessory, packageName, pi, pid, uid);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public void grantDevicePermission(UsbDevice device, int uid) {
        grantDevicePermission_enforcePermission();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        getPermissionsForUser(userId).grantDevicePermission(device, uid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void grantAccessoryPermission(UsbAccessory accessory, int uid) {
        grantAccessoryPermission_enforcePermission();
        int userId = UserHandle.getUserId(uid);
        long token = Binder.clearCallingIdentity();
        getPermissionsForUser(userId).grantAccessoryPermission(accessory, uid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean hasDefaults(String packageName, int userId) {
        String packageName2 = (String) Preconditions.checkStringNotEmpty(packageName);
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        UserHandle user = UserHandle.of(userId);
        long token = Binder.clearCallingIdentity();
        boolean r3 = this.mSettingsManager.getSettingsForProfileGroup(user).hasDefaults(packageName2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void clearDefaults(String packageName, int userId) {
        String packageName2 = (String) Preconditions.checkStringNotEmpty(packageName);
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        UserHandle user = UserHandle.of(userId);
        long token = Binder.clearCallingIdentity();
        this.mSettingsManager.getSettingsForProfileGroup(user).clearDefaults(packageName2, user);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void setCurrentFunctions(long functions, int operationId) {
        setCurrentFunctions_enforcePermission();
        Preconditions.checkArgument(UsbManager.areSettableFunctions(functions));
        if (this.mDeviceManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.mDeviceManager.setCurrentFunctions(functions, operationId);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setCurrentFunction(String functions, boolean usbDataUnlocked, int operationId) {
        setCurrentFunctions(UsbManager.usbFunctionsFromString(functions), operationId);
    }

    public boolean isFunctionEnabled(String function) {
        if ((getCurrentFunctions() & UsbManager.usbFunctionsFromString(function)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUvcGadgetSupportEnabled() {
        return SystemProperties.getBoolean("ro.usb.uvc.enabled", false);
    }

    public long getCurrentFunctions() {
        getCurrentFunctions_enforcePermission();
        if (this.mDeviceManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.mDeviceManager.getCurrentFunctions();
    L5:
        r0 = false;
        goto L6
    }

    public void setScreenUnlockedFunctions(long functions) {
        setScreenUnlockedFunctions_enforcePermission();
        Preconditions.checkArgument(UsbManager.areSettableFunctions(functions));
        if (this.mDeviceManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.mDeviceManager.setScreenUnlockedFunctions(functions);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public long getScreenUnlockedFunctions() {
        getScreenUnlockedFunctions_enforcePermission();
        if (this.mDeviceManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.mDeviceManager.getScreenUnlockedFunctions();
    L5:
        r0 = false;
        goto L6
    }

    public int getCurrentUsbSpeed() {
        getCurrentUsbSpeed_enforcePermission();
        Preconditions.checkNotNull(this.mDeviceManager, "DeviceManager must not be null");
        long ident = Binder.clearCallingIdentity();
        int r2 = this.mDeviceManager.getCurrentUsbSpeed();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public int getGadgetHalVersion() {
        getGadgetHalVersion_enforcePermission();
        Preconditions.checkNotNull(this.mDeviceManager, "DeviceManager must not be null");
        long ident = Binder.clearCallingIdentity();
        int r2 = this.mDeviceManager.getGadgetHalVersion();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void resetUsbGadget() {
        resetUsbGadget_enforcePermission();
        Preconditions.checkNotNull(this.mDeviceManager, "DeviceManager must not be null");
        long ident = Binder.clearCallingIdentity();
        this.mDeviceManager.resetUsbGadget();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void resetUsbPort(String portId, int operationId, IUsbOperationInternal callback) {
        String r0 = "resetUsbPort: portId must not be null. opId:" + operationId;
        portId.getClass();
        String r1 = "resetUsbPort: callback must not be null. opId:" + operationId;
        callback.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L18;
        this.mPortManager.resetUsbPort(portId, operationId, callback, null);     // Catch: Throwable -> L7
    L14:
        Binder.restoreCallingIdentity(ident);
        return;
    L18:
        callback.onOperationComplete(1);     // Catch: Throwable -> L7 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "resetUsbPort: Failed to call onOperationComplete", e);     // Catch: Throwable -> L7
        goto L14
    }

    public List<ParcelableUsbPort> getPorts() {
        getPorts_enforcePermission();
        long ident = Binder.clearCallingIdentity();
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager != null) goto L7;
        Binder.restoreCallingIdentity(ident);
        return null;
    L7:
        UsbPort[] ports = this.mPortManager.getPorts();     // Catch: Throwable -> L11
        int numPorts = ports.length;     // Catch: Throwable -> L11
        ArrayList<ParcelableUsbPort> parcelablePorts = new ArrayList();     // Catch: Throwable -> L11
        int i = 0;
    L8:
        if (i >= numPorts) goto L13;
        parcelablePorts.add(ParcelableUsbPort.of(ports[i]));     // Catch: Throwable -> L11
        i = i + 1;
        goto L8
    L13:
        Binder.restoreCallingIdentity(ident);
        return parcelablePorts;
    }

    public UsbPortStatus getPortStatus(String portId) {
        portId.getClass();
        UsbPortStatus r2 = null;
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L9;
        r2 = this.mPortManager.getPortStatus(portId);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(ident);
        return r2;
    }

    public boolean isModeChangeSupported(String portId) {
        isModeChangeSupported_enforcePermission();
        portId.getClass();
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L9;
        boolean r2 = this.mPortManager.isModeChangeSupported(portId);     // Catch: Throwable -> L7
    L10:
        Binder.restoreCallingIdentity(ident);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    public void setPortRoles(String portId, int powerRole, int dataRole) {
        portId.getClass();
        UsbPort.checkRoles(powerRole, dataRole);
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L9;
        this.mPortManager.setPortRoles(portId, powerRole, dataRole, null);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(ident);
    }

    public void enableLimitPowerTransfer(String portId, boolean limit, int operationId, IUsbOperationInternal callback) {
        String r0 = "portId must not be null. opID:" + operationId;
        portId.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L11:
        th = move-exception;
        Throwable r11 = th;
    L21:
        Binder.restoreCallingIdentity(ident);
        throw r11;
    L27:
        if (this.mPortManager == null) goto L23;
        this.mPortManager.enableLimitPowerTransfer(portId, limit, operationId, callback, null);     // Catch: Throwable -> L9
    L19:
        Binder.restoreCallingIdentity(ident);
        return;
    L23:
        callback.onOperationComplete(1);     // Catch: Throwable -> L9 RemoteException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "enableLimitPowerTransfer: Failed to call onOperationComplete", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r11 = th;
        goto L21
    }

    public void enableContaminantDetection(String portId, boolean enable) {
        portId.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L9;
        this.mPortManager.enableContaminantDetection(portId, enable, null);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(ident);
    }

    public int getUsbHalVersion() {
        getUsbHalVersion_enforcePermission();
        long ident = Binder.clearCallingIdentity();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L10;
        int r2 = this.mPortManager.getUsbHalVersion();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);
        return r2;
    L10:
        Binder.restoreCallingIdentity(ident);
        return -1;
    }

    public boolean enableUsbData(String portId, boolean enable, int operationId, IUsbOperationInternal callback) {
        return enableUsbDataInternal(portId, enable, operationId, callback, Binder.getCallingUid(), false);
    }

    boolean enableUsbDataInternal(String portId, boolean enable, int operationId, IUsbOperationInternal callback, int requester, boolean isInternalRequest) {
        String r0 = "enableUsbData: portId must not be null. opId:" + operationId;
        portId.getClass();
        String r1 = "enableUsbData: callback must not be null. opId:" + operationId;
        callback.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        if (shouldUpdateUsbSignaling(portId, enable, requester, isInternalRequest) == false) goto L29;
        long ident = Binder.clearCallingIdentity();
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L12:
        if (this.mPortManager == null) goto L27;
        boolean wait = this.mPortManager.enableUsbData(portId, enable, operationId, callback, null);     // Catch: Throwable -> L15
    L23:
        Binder.restoreCallingIdentity(ident);
        return wait;
    L27:
        callback.onOperationComplete(1);     // Catch: Throwable -> L15 RemoteException -> L20
    L22:
        wait = false;
        goto L23
    L20:
        e = move-exception;
        Slog.e(TAG, "enableUsbData: Failed to call onOperationComplete", e);     // Catch: Throwable -> L15
        goto L22
    L29:
        callback.onOperationComplete(1);     // Catch: RemoteException -> L6
        return false;
    L6:
        e = move-exception;
        Slog.e(TAG, "enableUsbData: Failed to call onOperationComplete", e);
        return false;
    }

    private boolean shouldUpdateUsbSignaling(String portId, boolean enable, int requester, boolean isInternalRequest) {
        if (isInternalRequest == false) goto L5;
        return false;
    L5:
        ArrayMap<String, UsbDataSignalDisableRequesters> r0 = this.mUsbDisableRequesters;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mUsbDisableRequesters.containsKey(portId) == true) goto L12;
        this.mUsbDisableRequesters.put(portId, new UsbDataSignalDisableRequesters());     // Catch: Throwable -> L10
    L12:
        UsbDataSignalDisableRequesters disableRequests = this.mUsbDisableRequesters.get(portId);     // Catch: Throwable -> L10
        if (enable == false) goto L20;
        if (isInternalRequest == false) goto L16;
        disableRequests.mInternalReasons.remove(Integer.valueOf(requester));     // Catch: Throwable -> L10
    L17:
        boolean r2 = disableRequests.isEmpty();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L16:
        disableRequests.mExternalUids.remove(Integer.valueOf(requester));     // Catch: Throwable -> L10
        goto L17
    L20:
        if (isInternalRequest == false) goto L22;
        disableRequests.mInternalReasons.add(Integer.valueOf(requester));     // Catch: Throwable -> L10
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L22:
        disableRequests.mExternalUids.add(Integer.valueOf(requester));     // Catch: Throwable -> L10
        goto L23
    }

    public void enableUsbDataWhileDocked(String portId, int operationId, IUsbOperationInternal callback) {
        enableUsbDataWhileDockedInternal(portId, operationId, callback, Binder.getCallingUid(), false);
    }

    void enableUsbDataWhileDockedInternal(String portId, int operationId, IUsbOperationInternal callback, int callerUid, boolean isInternalRequest) {
        String r0 = "enableUsbDataWhileDocked: portId must not be null. opId:" + operationId;
        portId.getClass();
        String r1 = "enableUsbDataWhileDocked: callback must not be null. opId:" + operationId;
        callback.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        if (shouldUpdateUsbSignaling(portId, true, callerUid, isInternalRequest) == false) goto L24;
        long ident = Binder.clearCallingIdentity();
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L11:
        if (this.mPortManager == null) goto L26;
        this.mPortManager.enableUsbDataWhileDocked(portId, operationId, callback, null);     // Catch: Throwable -> L14
    L20:
        Binder.restoreCallingIdentity(ident);
        return;
    L26:
        callback.onOperationComplete(1);     // Catch: Throwable -> L14 RemoteException -> L18
    L18:
        e = move-exception;
        Slog.e(TAG, "enableUsbData: Failed to call onOperationComplete", e);     // Catch: Throwable -> L14
        goto L20
    L24:
        callback.onOperationComplete(1);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "enableUsbDataWhileDocked: Failed to call onOperationComplete", e);
    }

    public void setUsbDeviceConnectionHandler(ComponentName usbDeviceConnectionHandler) {
        setUsbDeviceConnectionHandler_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId != UserHandle.getCallingUserId()) goto L14;
        if (this.mHostManager == null) goto L11;
        this.mHostManager.setUsbDeviceConnectionHandler(usbDeviceConnectionHandler);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        throw new IllegalArgumentException("Only the current user can register a usb connection handler");     // Catch: Throwable -> L9
    }

    public boolean registerForDisplayPortEvents(IDisplayPortAltModeInfoListener listener) {
        listener.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L10;
        boolean r2 = this.mPortManager.registerForDisplayPortEvents(listener);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);
        return r2;
    L10:
        Binder.restoreCallingIdentity(ident);
        return false;
    }

    public void unregisterForDisplayPortEvents(IDisplayPortAltModeInfoListener listener) {
        listener.getClass();
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_USB", null);
        long ident = Binder.clearCallingIdentity();
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (this.mPortManager == null) goto L9;
        this.mPortManager.unregisterForDisplayPortEvents(listener);     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(ident);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NeverCompile
    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
        long ident = Binder.clearCallingIdentity();
        ArraySet<String> argsSet = new ArraySet();     // Catch: Throwable -> L303
        Collections.addAll(argsSet, args);     // Catch: Throwable -> L303
        if (argsSet.contains("--proto") == false) goto L9;
        boolean dumpAsProto = true;
    L334:
        if (args == null) goto L330;
        if (args.length == 0) goto L330;
        if (args[0].equals("-a") == true) goto L330;
        if (dumpAsProto == true) goto L330;
        if ("set-port-roles".equals(args[0]) == false) goto L69;
        String[] r9 = args;
        int r24 = 1;
    L29:
        th = th;
    L325:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L22:
        if (r9.length != 4) goto L328;
        String portId = r9[1];     // Catch: Throwable -> L29
        String r2 = r9[2];     // Catch: Throwable -> L29
        switch(r2.hashCode()) {
            case -896505829: goto L35;
            case -440560135: goto L32;
            case 3530387: goto L27;
            default: goto L37;
        };     // Catch: Throwable -> L29
    L37:
        byte r3 = -1;
    L38:
        switch(r3) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L42;
            default: goto L39;
        };     // Catch: Throwable -> L29
    L39:
        pw.println("Invalid power role: " + r9[2]);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);
        return;
    L42:
        int powerRole = 0;
    L45:
        String r4 = r9[3];     // Catch: Throwable -> L29
        switch(r4.hashCode()) {
            case -1335157162: goto L55;
            case 3208616: goto L52;
            case 2063627318: goto L49;
            default: goto L57;
        };     // Catch: Throwable -> L29
    L57:
        byte r8 = -1;
    L58:
        switch(r8) {
            case 0: goto L64;
            case 1: goto L63;
            case 2: goto L62;
            default: goto L59;
        };     // Catch: Throwable -> L29
    L59:
        pw.println("Invalid data role: " + r9[3]);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);
        return;
    L62:
        int dataRole = 0;
    L66:
        if (this.mPortManager == null) goto L323;
        this.mPortManager.setPortRoles(portId, powerRole, dataRole, pw);     // Catch: Throwable -> L29
        pw.println();     // Catch: Throwable -> L29
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L29
    L323:
        Binder.restoreCallingIdentity(ident);
        return;
    L63:
        dataRole = 2;
        goto L66
    L64:
        dataRole = 1;
        goto L66
    L49:
        if (r4.equals("no-data") == false) goto L57;
        r8 = 2;
        goto L58
    L52:
        if (r4.equals("host") == false) goto L57;
        r8 = 0;
        goto L58
    L55:
        if (r4.equals("device") == false) goto L57;
        r8 = 1;
        goto L58
    L43:
        powerRole = 2;
        goto L45
    L44:
        powerRole = 1;
        goto L45
    L27:
        if (r2.equals("sink") == false) goto L37;
        r3 = 1;
        goto L38
    L32:
        if (r2.equals("no-power") == false) goto L37;
        r3 = 2;
        goto L38
    L35:
        if (r2.equals(StarLocation.KEY_LOCATION_SOURCE) == false) goto L37;
        r3 = 0;
    L328:
    L129:
        th = th;
        goto L325
    L72:
        if ("add-port".equals(r9[0]) == false) goto L136;
        if (r9.length < 3) goto L136;
        String portId2 = r9[r24];     // Catch: Throwable -> L129
        String r10 = r9[2];     // Catch: Throwable -> L129
        switch(r10.hashCode()) {
            case 99374: goto L89;
            case 115711: goto L86;
            case 3094652: goto L83;
            case 3387192: goto L80;
            default: goto L91;
        };
    L91:
        int r5 = -1;
    L92:
        switch(r5) {
            case 0: goto L99;
            case 1: goto L98;
            case 2: goto L97;
            case 3: goto L96;
            default: goto L93;
        };
    L93:
        pw.println("Invalid mode: " + r9[2]);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(ident);
        return;
    L96:
        int supportedModes = 0;
    L100:
        int i = 3;
        boolean supportsComplianceWarnings = false;
        boolean supportsDisplayPortAltMode = false;
    L102:
        if (i >= r9.length) goto L120;
        String r6 = r9[i];     // Catch: Throwable -> L29
        switch(r6.hashCode()) {
            case -1384270173: goto L110;
            case 407165993: goto L107;
            default: goto L112;
        };     // Catch: Throwable -> L29
    L112:
        int r7 = -1;
    L113:
        switch(r7) {
            case 0: goto L117;
            case 1: goto L116;
            default: goto L114;
        };     // Catch: Throwable -> L29
    L114:
        pw.println("Invalid Identifier: " + r9[i]);     // Catch: Throwable -> L29
    L118:
        i = i + 1;
        goto L102
    L116:
        supportsDisplayPortAltMode = true;
        goto L118
    L117:
        supportsComplianceWarnings = true;
        goto L118
    L107:
        if (r6.equals("--compliance-warnings") == false) goto L112;
        r7 = 0;
        goto L113
    L110:
        if (r6.equals("--displayport") == false) goto L112;
        r7 = r24;
        goto L113
    L120:
        if (this.mPortManager == null) goto L323;
        this.mPortManager.addSimulatedPort(portId2, supportedModes, supportsComplianceWarnings, supportsDisplayPortAltMode, pw);     // Catch: Throwable -> L127
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L127:
        th = th;
        goto L325
    L97:
        supportedModes = 3;
        goto L100
    L98:
        supportedModes = 2;
        goto L100
    L99:
        supportedModes = 1;
        goto L100
    L80:
        if (r10.equals("none") == false) goto L345;
        r5 = 3;
        goto L92
    L345:
        r5 = -1;
        goto L92
    L83:
        if (r10.equals("dual") == false) goto L346;
        r5 = 2;
        goto L92
    L346:
        r5 = -1;
        goto L92
    L86:
        if (r10.equals("ufp") == false) goto L347;
        r5 = 0;
        goto L92
    L347:
        r5 = -1;
        goto L92
    L89:
        if (r10.equals("dfp") == false) goto L348;
        r5 = r24;
        goto L92
    L348:
        r5 = -1;
    L136:
        if ("connect-port".equals(r9[0]) == false) goto L214;
        if (r9.length != 5) goto L214;
        String portId3 = r9[r24];     // Catch: Throwable -> L125
        boolean canChangeMode = r9[2].endsWith("?");     // Catch: Throwable -> L125
        if (canChangeMode == false) goto L143;
        String r26 = removeLastChar(r9[2]);     // Catch: Throwable -> L125
    L142:
        String r27 = r26;
        switch(r27.hashCode()) {
            case 99374: goto L151;
            case 115711: goto L148;
            default: goto L153;
        };     // Catch: Throwable -> L125
    L153:
        int r11 = -1;
    L154:
        switch(r11) {
            case 0: goto L159;
            case 1: goto L158;
            default: goto L155;
        };     // Catch: Throwable -> L125
    L155:
        pw.println("Invalid mode: " + r9[2]);     // Catch: Throwable -> L125
        Binder.restoreCallingIdentity(ident);
        return;
    L158:
        int mode = 2;
    L161:
        boolean canChangePowerRole = r9[3].endsWith("?");     // Catch: Throwable -> L125
        if (canChangePowerRole == false) goto L164;
        String r12 = removeLastChar(r9[3]);     // Catch: Throwable -> L125
    L166:
        switch(r12.hashCode()) {
            case -896505829: goto L172;
            case 3530387: goto L169;
            default: goto L174;
        };     // Catch: Throwable -> L125
    L174:
        int r13 = -1;
    L175:
        switch(r13) {
            case 0: goto L180;
            case 1: goto L179;
            default: goto L176;
        };     // Catch: Throwable -> L125
    L176:
        pw.println("Invalid power role: " + r9[3]);     // Catch: Throwable -> L125
        Binder.restoreCallingIdentity(ident);
        return;
    L179:
        int powerRole2 = 2;
    L182:
        boolean canChangeDataRole = r9[4].endsWith("?");     // Catch: Throwable -> L125
        if (canChangeDataRole == false) goto L185;
        String r14 = removeLastChar(r9[4]);     // Catch: Throwable -> L125
    L187:
        switch(r14.hashCode()) {
            case -1335157162: goto L193;
            case 3208616: goto L190;
            default: goto L195;
        };     // Catch: Throwable -> L125
    L195:
        int r15 = -1;
    L196:
        switch(r15) {
            case 0: goto L201;
            case 1: goto L200;
            default: goto L197;
        };     // Catch: Throwable -> L125
    L197:
        pw.println("Invalid data role: " + r9[4]);     // Catch: Throwable -> L125
        Binder.restoreCallingIdentity(ident);
        return;
    L200:
        int dataRole2 = 2;
    L203:
        if (this.mPortManager == null) goto L323;
        this.mPortManager.connectSimulatedPort(portId3, mode, canChangeMode, powerRole2, canChangePowerRole, dataRole2, canChangeDataRole, pw);     // Catch: Throwable -> L209
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L209:
        th = th;
        goto L325
    L201:
        dataRole2 = 1;
        goto L203
    L190:
        if (r14.equals("host") == false) goto L195;
        r15 = 0;
        goto L196
    L193:
        if (r14.equals("device") == false) goto L195;
        r15 = r24;
        goto L196
    L185:
        r14 = r9[4];     // Catch: Throwable -> L125
        goto L187
    L180:
        powerRole2 = 1;
        goto L182
    L169:
        if (r12.equals("sink") == false) goto L174;
        r13 = r24;
        goto L175
    L172:
        if (r12.equals(StarLocation.KEY_LOCATION_SOURCE) == false) goto L174;
        r13 = 0;
        goto L175
    L164:
        r12 = r9[3];     // Catch: Throwable -> L125
        goto L166
    L159:
        mode = 1;
        goto L161
    L148:
        if (r27.equals("ufp") == false) goto L153;
        r11 = 0;
        goto L154
    L151:
        if (r27.equals("dfp") == false) goto L153;
        r11 = r24;
        goto L154
    L143:
        r26 = r9[2];     // Catch: Throwable -> L125
    L214:
        if ("disconnect-port".equals(r9[0]) == false) goto L222;
        if (r9.length != 2) goto L222;
        String portId4 = r9[r24];     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.disconnectSimulatedPort(portId4, pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L222:
        if ("remove-port".equals(r9[0]) == false) goto L230;
        if (r9.length != 2) goto L230;
        String portId5 = r9[r24];     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.removeSimulatedPort(portId5, pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L230:
        if ("reset".equals(r9[0]) == false) goto L238;
        if (r9.length != r24) goto L238;
        if (this.mPortManager == null) goto L323;
        this.mPortManager.resetSimulation(pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L238:
        if ("set-contaminant-status".equals(r9[0]) == false) goto L246;
        if (r9.length != 3) goto L246;
        String portId6 = r9[1];     // Catch: Throwable -> L125
        Boolean wet = Boolean.valueOf(Boolean.parseBoolean(r9[2]));     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.simulateContaminantStatus(portId6, wet.booleanValue(), pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L246:
        if ("set-compliance-reasons".equals(r9[0]) == false) goto L254;
        if (r9.length != 3) goto L254;
        String portId7 = r9[1];     // Catch: Throwable -> L125
        String complianceWarnings = r9[2];     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.simulateComplianceWarnings(portId7, complianceWarnings, pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L254:
        if ("clear-compliance-reasons".equals(r9[0]) == false) goto L262;
        if (r9.length != 2) goto L262;
        String portId8 = r9[1];     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.simulateComplianceWarnings(portId8, "", pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L262:
        if ("set-displayport-status".equals(r9[0]) == false) goto L271;
        if (r9.length != 7) goto L271;
        String portId9 = r9[1];     // Catch: Throwable -> L125
        int partnerSinkStatus = Integer.parseInt(r9[2]);     // Catch: Throwable -> L125
        int cableStatus = Integer.parseInt(r9[3]);     // Catch: Throwable -> L125
        int displayPortNumLanes = Integer.parseInt(r9[4]);     // Catch: Throwable -> L125
        boolean hpd = Boolean.parseBoolean(r9[5]);     // Catch: Throwable -> L125
        int linkTrainingStatus = Integer.parseInt(r9[6]);     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.simulateDisplayPortAltModeInfo(portId9, partnerSinkStatus, cableStatus, displayPortNumLanes, hpd, linkTrainingStatus, pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L271:
        if ("reset-displayport-status".equals(r9[0]) == false) goto L279;
        if (r9.length != 2) goto L279;
        String portId10 = r9[1];     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        this.mPortManager.simulateDisplayPortAltModeInfo(portId10, 0, 0, 0, false, 0, pw);     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L279:
        if ("enable-usb-data".equals(r9[0]) == false) goto L292;
        if (r9.length != 3) goto L292;
        String portId11 = r9[1];     // Catch: Throwable -> L125
        boolean enable = Boolean.parseBoolean(r9[2]);     // Catch: Throwable -> L125
        if (this.mPortManager == null) goto L323;
        UsbPort[] r16 = this.mPortManager.getPorts();     // Catch: Throwable -> L125
        int r17 = r16.length;     // Catch: Throwable -> L125
        int r18 = 0;
    L285:
        if (r18 >= r17) goto L323;
        UsbPort p = r16[r18];     // Catch: Throwable -> L125
        if (p.getId().equals(portId11) == true) goto L288;
        r18 = r18 + 1;     // Catch: Throwable -> L125
        goto L285
    L288:
        int res = p.enableUsbData(enable);     // Catch: Throwable -> L125
        Slog.i(TAG, "enableUsbData " + portId11 + " status " + res);     // Catch: Throwable -> L125
    L292:
        if ("ports".equals(r9[0]) == false) goto L300;
        if (r9.length != 1) goto L300;
        if (this.mPortManager == null) goto L323;
        this.mPortManager.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")), "", 0);     // Catch: Throwable -> L125
    L300:
        if ("dump-descriptors".equals(r9[0]) == false) goto L302;
        this.mHostManager.dumpDescriptors(pw, r9);     // Catch: Throwable -> L125
        goto L323
    L302:
        pw.println("Dump current USB state or issue command:");     // Catch: Throwable -> L125
        pw.println("  ports");     // Catch: Throwable -> L125
        pw.println("  set-port-roles <id> <source|sink|no-power> <host|device|no-data>");     // Catch: Throwable -> L125
        pw.println("  add-port <id> <ufp|dfp|dual|none> <optional args>");     // Catch: Throwable -> L125
        pw.println("    <optional args> include:");     // Catch: Throwable -> L125
        pw.println("      --compliance-warnings: enables compliance warnings on port");     // Catch: Throwable -> L125
        pw.println("      --displayport: enables DisplayPort Alt Mode on port");     // Catch: Throwable -> L125
        pw.println("  connect-port <id> <ufp|dfp><?> <source|sink><?> <host|device><?>");     // Catch: Throwable -> L125
        pw.println("    (add ? suffix if mode, power role, or data role can be changed)");     // Catch: Throwable -> L125
        pw.println("  disconnect-port <id>");     // Catch: Throwable -> L125
        pw.println("  remove-port <id>");     // Catch: Throwable -> L125
        pw.println("  reset");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB type C port role switch:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb set-port-roles \"default\" source device");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB type C port simulation with full capabilities:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" dual --compliance-warnings --displayport");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb connect-port \"matrix\" ufp? sink? device?");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb ports");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb disconnect-port \"matrix\"");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb remove-port \"matrix\"");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb reset");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB type C port where only power role can be changed:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" dual");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb connect-port \"matrix\" dfp source? host");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb reset");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB OTG port where id pin determines function:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" dual");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb connect-port \"matrix\" dfp source host");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb reset");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB device-only port:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" ufp");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb connect-port \"matrix\" ufp sink device");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb reset");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example simulate contaminant status:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" ufp");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb set-contaminant-status \"matrix\" true");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb set-contaminant-status \"matrix\" false");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example simulate compliance warnings:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" dual --compliance-warnings");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb set-compliance-reasons \"matrix\" <reason-list>");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb clear-compliance-reasons \"matrix\"");     // Catch: Throwable -> L125
        pw.println("<reason-list> is expected to be formatted as \"1, ..., N\"");     // Catch: Throwable -> L125
        pw.println("with reasons that need to be simulated.");     // Catch: Throwable -> L125
        pw.println("  1: other");     // Catch: Throwable -> L125
        pw.println("  2: debug accessory");     // Catch: Throwable -> L125
        pw.println("  3: bc12");     // Catch: Throwable -> L125
        pw.println("  4: missing rp");     // Catch: Throwable -> L125
        pw.println("  5: input power limited");     // Catch: Throwable -> L125
        pw.println("  6: missing data lines");     // Catch: Throwable -> L125
        pw.println("  7: enumeration fail");     // Catch: Throwable -> L125
        pw.println("  8: flaky connection");     // Catch: Throwable -> L125
        pw.println("  9: unreliable io");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example simulate DisplayPort Alt Mode Changes:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb add-port \"matrix\" dual --displayport");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb set-displayport-status \"matrix\" <partner-sink> <cable> <num-lanes> <hpd> <link-training-status>");     // Catch: Throwable -> L125
        pw.println("The required fields are as followed:");     // Catch: Throwable -> L125
        pw.println("    <partner-sink>: type DisplayPortAltModeStatus");     // Catch: Throwable -> L125
        pw.println("    <cable>: type DisplayPortAltModeStatus");     // Catch: Throwable -> L125
        pw.println("    <num-lanes>: type int, expected 0, 2, or 4");     // Catch: Throwable -> L125
        pw.println("    <hpd>: type boolean, expected true or false");     // Catch: Throwable -> L125
        pw.println("    <link-training-status>: type LinkTrainingStatus");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb reset-displayport-status \"matrix\"");     // Catch: Throwable -> L125
        pw.println("reset-displayport-status can also be used in order to set");     // Catch: Throwable -> L125
        pw.println("the DisplayPortInfo to default values.");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example enableUsbData");     // Catch: Throwable -> L125
        pw.println("This dumpsys command functions for both simulated and real ports.");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb enable-usb-data \"matrix\" true");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb enable-usb-data \"matrix\" false");     // Catch: Throwable -> L125
        pw.println();     // Catch: Throwable -> L125
        pw.println("Example USB device descriptors:");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb dump-descriptors -dump-short");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb dump-descriptors -dump-tree");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb dump-descriptors -dump-list");     // Catch: Throwable -> L125
        pw.println("  dumpsys usb dump-descriptors -dump-raw");     // Catch: Throwable -> L125
        goto L323
    L69:
        r9 = args;
        r24 = 1;
    L330:
        if (dumpAsProto == true) goto L309;
        pw.println("USB MANAGER STATE (dumpsys usb):");     // Catch: Throwable -> L310
        DualDumpOutputStream dump = new DualDumpOutputStream(new IndentingPrintWriter(pw, "  "));     // Catch: Throwable -> L310
    L314:
        if (this.mDeviceManager == null) goto L317;
        this.mDeviceManager.dump(dump, "device_manager", 1146756268033L);     // Catch: Throwable -> L310
    L317:
        if (this.mHostManager == null) goto L320;
        this.mHostManager.dump(dump, "host_manager", 1146756268034L);     // Catch: Throwable -> L310
    L320:
        if (this.mPortManager == null) goto L322;
        this.mPortManager.dump(dump, "port_manager", 1146756268035L);     // Catch: Throwable -> L310
    L322:
        this.mAlsaManager.dump(dump, "alsa_manager", 1146756268036L);     // Catch: Throwable -> L310
        this.mSettingsManager.dump(dump, "settings_manager", 1146756268037L);     // Catch: Throwable -> L310
        this.mPermissionManager.dump(dump, "permissions_manager", 1146756268038L);     // Catch: Throwable -> L310
        dump.flush();     // Catch: Throwable -> L310
        goto L323
    L309:
        dump = new DualDumpOutputStream(new ProtoOutputStream(fd));     // Catch: Throwable -> L310
    L310:
        th = th;
    L125:
        th = th;
        goto L325
    L9:
        dumpAsProto = false;
    L303:
        th = th;
        goto L325
    }

    private static String removeLastChar(String value) {
        return value.substring(0, value.length() - 1);
    }
}
