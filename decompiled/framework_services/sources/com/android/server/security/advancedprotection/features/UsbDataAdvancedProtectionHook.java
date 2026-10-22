package com.android.server.security.advancedprotection.features;

import android.R;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.IUsbManagerInternal;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.security.advancedprotection.AdvancedProtectionFeature;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UsbDataAdvancedProtectionHook extends AdvancedProtectionHook {
    private static final int APM_USB_FEATURE_CHANNEL_ID = 1;
    private static final String APM_USB_FEATURE_NOTIF_CHANNEL = "APM_USB_SERVICE_NOTIF_CHANNEL";
    private static final String CHANNEL_NAME = "BackgroundInstallUiNotificationChannel";
    private static final int DELAY_DISABLE_MS = 1000;
    private static final int OS_USB_DISABLE_REASON_LOCKDOWN_MODE = 1;
    private static final String TAG = "AdvancedProtectionUsb";
    private boolean mBroadcastReceiverIsRegistered;
    private final Context mContext;
    private final Handler mDelayedDisableHandler;
    private AdvancedProtectionFeature mFeature;
    private boolean mInitialPlugInNotificationSent;
    private KeyguardManager mKeyguardManager;
    private NotificationChannel mNotificationChannel;
    private NotificationManager mNotificationManager;
    private UsbManager mUsbManager;
    private IUsbManagerInternal mUsbManagerInternal;
    private BroadcastReceiver mUsbProtectionBroadcastReceiver;

    /* JADX INFO: renamed from: com.android.server.security.advancedprotection.features.UsbDataAdvancedProtectionHook$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ UsbDataAdvancedProtectionHook this$0;

        public static /* synthetic */ void $r8$lambda$IpkQrIvwQabk52ZOno8Oi1LFTso(AnonymousClass1 r0) {
            r0.lambda$updateDelayedDisableTask$0();
        }

        AnonymousClass1(UsbDataAdvancedProtectionHook this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        L7:
            e = move-exception;
            Slog.e(UsbDataAdvancedProtectionHook.TAG, "USB Data protection failed with: " + e.getMessage());
            return;
        L3:
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction()) == false) goto L10;
            if (UsbDataAdvancedProtectionHook.m8035$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == true) goto L10;
            UsbDataAdvancedProtectionHook.m8034$$Nest$fgetmDelayedDisableHandler(this.this$0).removeCallbacksAndMessages(null);     // Catch: Exception -> L7
            UsbDataAdvancedProtectionHook.m8038$$Nest$msetUsbDataSignalIfPossible(this.this$0, true);     // Catch: Exception -> L7
            return;
        L10:
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) == false) goto L15;
            if (UsbDataAdvancedProtectionHook.m8035$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == false) goto L15;
            UsbDataAdvancedProtectionHook.m8038$$Nest$msetUsbDataSignalIfPossible(this.this$0, false);     // Catch: Exception -> L7
            return;
        L15:
            if ("android.hardware.usb.action.USB_PORT_CHANGED".equals(intent.getAction()) == true) goto L17;
            return;
        L17:
            if (Build.IS_DEBUGGABLE == false) goto L20;
            dumpUsbDevices();     // Catch: Exception -> L7
        L20:
            if (UsbDataAdvancedProtectionHook.m8035$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == false) goto L22;
            updateDelayedDisableTask(intent);     // Catch: Exception -> L7
        L22:
            UsbDataAdvancedProtectionHook.m8037$$Nest$msendNotificationIfDeviceLocked(this.this$0, intent);     // Catch: Exception -> L7
        }

        private void updateDelayedDisableTask(Intent intent) {
            if (usbPortIsConnectedAndDataEnabled(intent) == false) goto L6;
            UsbDataAdvancedProtectionHook.m8034$$Nest$fgetmDelayedDisableHandler(this.this$0).removeCallbacksAndMessages(null);
            return;
        L6:
            if (UsbDataAdvancedProtectionHook.m8034$$Nest$fgetmDelayedDisableHandler(this.this$0).hasMessagesOrCallbacks() == true) goto L10;
            UsbDataAdvancedProtectionHook.m8034$$Nest$fgetmDelayedDisableHandler(this.this$0).postDelayed(new UsbDataAdvancedProtectionHook$1$$ExternalSyntheticLambda0(this), 1000);
            return;
        }

        private /* synthetic */ void lambda$updateDelayedDisableTask$0() {
            if (UsbDataAdvancedProtectionHook.m8035$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == false) goto L6;
            UsbDataAdvancedProtectionHook.m8038$$Nest$msetUsbDataSignalIfPossible(this.this$0, false);
            return;
        }

        private boolean usbPortIsConnectedAndDataEnabled(Intent intent) {
            UsbPortStatus portStatus = (UsbPortStatus) intent.getParcelableExtra("portStatus", UsbPortStatus.class);
            if (portStatus != null) goto L5;
        L9:
            return false;
        L5:
            if (portStatus.isConnected() == false) goto L9;
            if (portStatus.getUsbDataStatus() == 16) goto L9;
            return true;
        }

        private void dumpUsbDevices() {
            Slog.d(UsbDataAdvancedProtectionHook.TAG, "dumpUsbDevices: ");
            Map<String, UsbDevice> portStatusMap = UsbDataAdvancedProtectionHook.m8036$$Nest$fgetmUsbManager(this.this$0).getDeviceList();
            Iterator<UsbDevice> r2 = portStatusMap.values().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            UsbDevice device = r2.next();
            Slog.d(UsbDataAdvancedProtectionHook.TAG, "Device: " + device.getDeviceName());
            goto L4
        L6:
            UsbAccessory[] accessoryList = UsbDataAdvancedProtectionHook.m8036$$Nest$fgetmUsbManager(this.this$0).getAccessoryList();
            if (accessoryList == null) goto L12;
            int r3 = accessoryList.length;
            int r4 = 0;
        L10:
            if (r4 >= r3) goto L15;
            UsbAccessory accessory = accessoryList[r4];
            Slog.d(UsbDataAdvancedProtectionHook.TAG, "Accessory: " + accessory.toString());
            r4 = r4 + 1;
            goto L10
        L15:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDelayedDisableHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8034$$Nest$fgetmDelayedDisableHandler(UsbDataAdvancedProtectionHook r0) {
        return r0.mDelayedDisableHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardManager m8035$$Nest$fgetmKeyguardManager(UsbDataAdvancedProtectionHook r0) {
        return r0.mKeyguardManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsbManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbManager m8036$$Nest$fgetmUsbManager(UsbDataAdvancedProtectionHook r0) {
        return r0.mUsbManager;
    }

    /* JADX INFO: renamed from: -$$Nest$msendNotificationIfDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8037$$Nest$msendNotificationIfDeviceLocked(UsbDataAdvancedProtectionHook r0, Intent r1) {
        r0.sendNotificationIfDeviceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUsbDataSignalIfPossible, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8038$$Nest$msetUsbDataSignalIfPossible(UsbDataAdvancedProtectionHook r0, boolean r1) {
        r0.setUsbDataSignalIfPossible(r1);
    }

    public UsbDataAdvancedProtectionHook(Context context, boolean enabled) {
        super(context, enabled);
        this.mDelayedDisableHandler = new Handler(Looper.getMainLooper());
        this.mFeature = new AdvancedProtectionFeature(2);
        this.mBroadcastReceiverIsRegistered = false;
        this.mInitialPlugInNotificationSent = false;
        this.mContext = context;
        this.mUsbManager = (UsbManager) this.mContext.getSystemService(UsbManager.class);
        IUsbManagerInternal r0 = (IUsbManagerInternal) LocalServices.getService(IUsbManagerInternal.class);
        r0.getClass();
        this.mUsbManagerInternal = r0;
        onAdvancedProtectionChanged(enabled);
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public AdvancedProtectionFeature getFeature() {
        return this.mFeature;
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public boolean isAvailable() {
        return canSetUsbDataSignal();
    }

    @Override // com.android.server.security.advancedprotection.features.AdvancedProtectionHook
    public void onAdvancedProtectionChanged(boolean enabled) {
        if (isAvailable() == true) goto L6;
        Slog.w(TAG, "AAPM USB data protection feature is disabled");
        return;
    L6:
        Slog.i(TAG, "onAdvancedProtectionChanged: " + enabled);
        if (enabled == false) goto L15;
        Slog.i(TAG, "onAdvancedProtectionChanged: enabled");
        if (this.mUsbProtectionBroadcastReceiver != null) goto L12;
        initialize();
    L12:
        if (this.mBroadcastReceiverIsRegistered == true) goto L19;
        registerReceiver();
        return;
    L19:
        return;
    L15:
        if (this.mBroadcastReceiverIsRegistered == false) goto L17;
        unregisterReceiver();
    L17:
        setUsbDataSignalIfPossible(true);
    }

    private void initialize() {
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
        initializeNotifications();
        this.mUsbProtectionBroadcastReceiver = new AnonymousClass1(this);
    }

    private void initializeNotifications() {
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        if (this.mNotificationManager.getNotificationChannel(APM_USB_FEATURE_NOTIF_CHANNEL) != null) goto L6;
        this.mNotificationChannel = new NotificationChannel(APM_USB_FEATURE_NOTIF_CHANNEL, CHANNEL_NAME, 4);
        this.mNotificationManager.createNotificationChannel(this.mNotificationChannel);
        return;
    }

    private void sendNotification(String title, String message) {
        Notification notif = new Notification.Builder(this.mContext, APM_USB_FEATURE_NOTIF_CHANNEL).setSmallIcon(R.drawable.pointer_wait_60).setContentTitle(title).setStyle(new Notification.BigTextStyle().bigText(message)).setAutoCancel(true).build();
        this.mNotificationManager.notify(TAG, 1, notif);
    }

    private void sendNotificationIfDeviceLocked(Intent intent) {
        if (this.mInitialPlugInNotificationSent == true) goto L10;
        UsbPortStatus portStatus = (UsbPortStatus) intent.getParcelableExtra("portStatus", UsbPortStatus.class);
        if (this.mKeyguardManager.isKeyguardLocked() == true) goto L7;
        return;
    L7:
        if (usbPortIsConnectedWithDataDisabled(portStatus) == false) goto L12;
        sendNotification(this.mContext.getString(17042281), this.mContext.getString(17042280));
        this.mInitialPlugInNotificationSent = true;
        return;
    L12:
        return;
    }

    private boolean usbPortIsConnectedWithDataDisabled(UsbPortStatus portStatus) {
        if (portStatus != null) goto L4;
    L8:
        return false;
    L4:
        if (portStatus.isConnected() == false) goto L8;
        if (portStatus.getUsbDataStatus() != 16) goto L8;
        return true;
    }

    private void setUsbDataSignalIfPossible(boolean status) {
        if (status == false) goto L5;
    L16:
    L11:
        e = move-exception;
        Slog.e(TAG, "RemoteException thrown when calling enableUsbDataSignal", e);
        return;
    L8:
        if (this.mUsbManagerInternal.enableUsbDataSignal(status, 1) == true) goto L18;
        Slog.e(TAG, "USB Data protection toggle failed");     // Catch: RemoteException -> L11
        return;
    L18:
        return;
    L5:
        if (deviceHaveUsbDataConnection() == false) goto L16;
    }

    private boolean deviceHaveUsbDataConnection() {
        Iterator r0 = this.mUsbManager.getPorts().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        UsbPort usbPort = (UsbPort) r0.next();
        if (Build.IS_DEBUGGABLE == false) goto L13;
        if (("setUsbDataSignal: false, Port status: " + usbPort.getStatus()) != null) goto L10;
        String r2 = "null";
    L11:
        Slog.i(TAG, r2);
        goto L13
    L10:
        r2 = usbPort.getStatus().toString();
    L13:
        if (usbPortIsConnectedWithDataEnabled(usbPort) == false) goto L4;
        return true;
    L17:
        return false;
    }

    private boolean usbPortIsConnectedWithDataEnabled(UsbPort usbPort) {
        if (usbPort.getStatus() != null) goto L5;
    L9:
        return false;
    L5:
        if (usbPort.getStatus().isConnected() == false) goto L9;
        if (usbPort.getStatus().getCurrentDataRole() == 0) goto L9;
        return true;
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);
        filter.addAction("android.intent.action.USER_PRESENT");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.hardware.usb.action.USB_PORT_CHANGED");
        this.mContext.registerReceiverAsUser(this.mUsbProtectionBroadcastReceiver, UserHandle.ALL, filter, null, null);
        this.mBroadcastReceiverIsRegistered = true;
    }

    private void unregisterReceiver() {
        this.mContext.unregisterReceiver(this.mUsbProtectionBroadcastReceiver);
        this.mBroadcastReceiverIsRegistered = false;
    }

    private boolean canSetUsbDataSignal() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        Slog.i(TAG, "USB_HAL_VERSION: " + this.mUsbManager.getUsbHalVersion());
    L6:
        if (this.mUsbManager.getUsbHalVersion() < 13) goto L8;
        return true;
    L8:
        return false;
    }
}
