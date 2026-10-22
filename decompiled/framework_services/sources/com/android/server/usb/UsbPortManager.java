package com.android.server.usb;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.usb.DisplayPortAltModeInfo;
import android.hardware.usb.IDisplayPortAltModeInfoListener;
import android.hardware.usb.IUsbOperationInternal;
import android.hardware.usb.ParcelableUsbPort;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.Slog;
import com.android.internal.usb.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.FgThread;
import com.android.server.usb.hal.port.RawPortInfo;
import com.android.server.usb.hal.port.UsbPortHal;
import com.android.server.usb.hal.port.UsbPortHalInstance;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class UsbPortManager implements IBinder.DeathRecipient {
    private static final int COMBO_SINK_DEVICE = 0;
    private static final int COMBO_SINK_HOST = 0;
    private static final int COMBO_SOURCE_DEVICE = 0;
    private static final int COMBO_SOURCE_HOST = 0;
    private static final int MSG_SYSTEM_READY = 2;
    private static final int MSG_UPDATE_PORTS = 1;
    private static final String PORT_INFO = "port_info";
    private static final String TAG = "UsbPortManager";
    private final ArrayMap<String, Boolean> mConnected;
    private final ArrayMap<String, Integer> mContaminantStatus;
    private final Context mContext;
    private final Object mDisplayPortListenerLock;
    private final ArrayMap<IBinder, IDisplayPortAltModeInfoListener> mDisplayPortListeners;
    private IExtUsbPortManager mExt;
    protected final Handler mHandler;
    private int mIsPortContaminatedNotificationId;
    final Object mLock;
    private NotificationManager mNotificationManager;
    final ArrayMap<String, PortInfo> mPorts;
    private final ArrayMap<String, RawPortInfo> mSimulatedPorts;
    private boolean mSystemReady;
    private long mTransactionId;
    private UsbPortHal mUsbPortHal;

    public static final class PortInfo {
        public static final int ALTMODE_INFO_CHANGED = 1;
        public static final int ALTMODE_INFO_UNCHANGED = 0;
        public static final int COMPLIANCE_WARNING_CHANGED = 1;
        public static final int COMPLIANCE_WARNING_UNCHANGED = 0;
        public static final int DISPOSITION_ADDED = 0;
        public static final int DISPOSITION_CHANGED = 1;
        public static final int DISPOSITION_READY = 2;
        public static final int DISPOSITION_REMOVED = 3;
        public boolean mCanChangeDataRole;
        public boolean mCanChangeMode;
        public boolean mCanChangePowerRole;
        public int mComplianceWarningChange;
        public long mConnectedAtMillis;
        public int mDisplayPortAltModeChange;
        public int mDisposition;
        public long mLastConnectDurationMillis;
        public final UsbPort mUsbPort;
        public UsbPortStatus mUsbPortStatus;

        PortInfo(UsbManager usbManager, String portId, int supportedModes, int supportedContaminantProtectionModes, boolean supportsEnableContaminantPresenceDetection, boolean supportsEnableContaminantPresenceProtection, boolean supportsComplianceWarnings, int supportedAltModes) {
            this.mUsbPort = new UsbPort(usbManager, portId, supportedModes, supportedContaminantProtectionModes, supportsEnableContaminantPresenceDetection, supportsEnableContaminantPresenceProtection, supportsComplianceWarnings, supportedAltModes);
            this.mComplianceWarningChange = 0;
            this.mDisplayPortAltModeChange = 0;
        }

        public boolean complianceWarningsChanged(int[] complianceWarnings) {
            if (Arrays.equals(complianceWarnings, this.mUsbPortStatus.getComplianceWarnings()) == false) goto L6;
            this.mComplianceWarningChange = 0;
            return false;
        L6:
            this.mComplianceWarningChange = 1;
            return true;
        }

        public boolean displayPortAltModeChanged(DisplayPortAltModeInfo displayPortAltModeInfo) {
            DisplayPortAltModeInfo currentDisplayPortAltModeInfo = this.mUsbPortStatus.getDisplayPortAltModeInfo();
            this.mDisplayPortAltModeChange = 0;
            if (displayPortAltModeInfo != null) goto L7;
            if (currentDisplayPortAltModeInfo == null) goto L7;
            this.mDisplayPortAltModeChange = 1;
            return true;
        L7:
            if (currentDisplayPortAltModeInfo != null) goto L13;
            if (displayPortAltModeInfo == null) goto L11;
            this.mDisplayPortAltModeChange = 1;
            return true;
        L11:
            return false;
        L13:
            if (currentDisplayPortAltModeInfo.equals(displayPortAltModeInfo) == true) goto L16;
            this.mDisplayPortAltModeChange = 1;
            return true;
        L16:
            return false;
        }

        public boolean setStatus(int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, int supportedRoleCombinations) {
            boolean dispositionChanged = false;
            this.mCanChangeMode = canChangeMode;
            this.mCanChangePowerRole = canChangePowerRole;
            this.mCanChangeDataRole = canChangeDataRole;
            if (this.mUsbPortStatus == null) goto L16;
            int r7 = currentMode;
            if (this.mUsbPortStatus.getCurrentMode() != r7) goto L15;
            int r8 = currentPowerRole;
            if (this.mUsbPortStatus.getCurrentPowerRole() != r8) goto L14;
            int r9 = currentDataRole;
            if (this.mUsbPortStatus.getCurrentDataRole() != r9) goto L13;
            int r10 = supportedRoleCombinations;
            if (this.mUsbPortStatus.getSupportedRoleCombinations() == r10) goto L19;
        L17:
            this.mUsbPortStatus = new UsbPortStatus(r7, r8, r9, r10, 0, 0, 0, false, 0, new int[0], 0, null);
            dispositionChanged = true;
        L19:
            if (this.mUsbPortStatus.isConnected() == false) goto L24;
            if (this.mConnectedAtMillis != 0) goto L24;
            this.mConnectedAtMillis = SystemClock.elapsedRealtime();
            this.mLastConnectDurationMillis = 0;
        L28:
            return dispositionChanged;
        L24:
            if (this.mUsbPortStatus.isConnected() == true) goto L28;
            if (this.mConnectedAtMillis == 0) goto L28;
            this.mLastConnectDurationMillis = SystemClock.elapsedRealtime() - this.mConnectedAtMillis;
            this.mConnectedAtMillis = 0;
            goto L28
        L13:
            r10 = supportedRoleCombinations;
            goto L17
        L14:
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            goto L17
        L15:
            r8 = currentPowerRole;
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            goto L17
        L16:
            r7 = currentMode;
            r8 = currentPowerRole;
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            goto L17
        }

        public boolean setStatus(int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, int supportedRoleCombinations, int contaminantProtectionStatus, int contaminantDetectionStatus, int usbDataStatus, boolean powerTransferLimited, int powerBrickConnectionStatus) {
            boolean dispositionChanged = false;
            this.mCanChangeMode = canChangeMode;
            this.mCanChangePowerRole = canChangePowerRole;
            this.mCanChangeDataRole = canChangeDataRole;
            if (this.mUsbPortStatus == null) goto L31;
            int r7 = currentMode;
            if (this.mUsbPortStatus.getCurrentMode() != r7) goto L30;
            int r8 = currentPowerRole;
            if (this.mUsbPortStatus.getCurrentPowerRole() != r8) goto L29;
            int r9 = currentDataRole;
            if (this.mUsbPortStatus.getCurrentDataRole() != r9) goto L28;
            int r10 = supportedRoleCombinations;
            if (this.mUsbPortStatus.getSupportedRoleCombinations() != r10) goto L27;
            int r11 = contaminantProtectionStatus;
            if (this.mUsbPortStatus.getContaminantProtectionStatus() != r11) goto L26;
            int r12 = contaminantDetectionStatus;
            if (this.mUsbPortStatus.getContaminantDetectionStatus() != r12) goto L25;
            int r13 = usbDataStatus;
            if (this.mUsbPortStatus.getUsbDataStatus() != r13) goto L24;
            boolean r14 = powerTransferLimited;
            if (this.mUsbPortStatus.isPowerTransferLimited() != r14) goto L23;
            int r15 = powerBrickConnectionStatus;
            if (this.mUsbPortStatus.getPowerBrickConnectionStatus() == r15) goto L34;
        L32:
            this.mUsbPortStatus = new UsbPortStatus(r7, r8, r9, r10, r11, r12, r13, r14, r15, new int[0], 0, null);
            dispositionChanged = true;
        L34:
            if (this.mUsbPortStatus.isConnected() == false) goto L39;
            if (this.mConnectedAtMillis != 0) goto L39;
            this.mConnectedAtMillis = SystemClock.elapsedRealtime();
            this.mLastConnectDurationMillis = 0;
        L43:
            return dispositionChanged;
        L39:
            if (this.mUsbPortStatus.isConnected() == true) goto L43;
            if (this.mConnectedAtMillis == 0) goto L43;
            this.mLastConnectDurationMillis = SystemClock.elapsedRealtime() - this.mConnectedAtMillis;
            this.mConnectedAtMillis = 0;
            goto L43
        L23:
            r15 = powerBrickConnectionStatus;
            goto L32
        L24:
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L25:
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L26:
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L27:
            r11 = contaminantProtectionStatus;
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L28:
            r10 = supportedRoleCombinations;
            r11 = contaminantProtectionStatus;
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L29:
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            r11 = contaminantProtectionStatus;
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L30:
            r8 = currentPowerRole;
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            r11 = contaminantProtectionStatus;
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        L31:
            r7 = currentMode;
            r8 = currentPowerRole;
            r9 = currentDataRole;
            r10 = supportedRoleCombinations;
            r11 = contaminantProtectionStatus;
            r12 = contaminantDetectionStatus;
            r13 = usbDataStatus;
            r14 = powerTransferLimited;
            r15 = powerBrickConnectionStatus;
            goto L32
        }

        public boolean setStatus(int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, int supportedRoleCombinations, int contaminantProtectionStatus, int contaminantDetectionStatus, int usbDataStatus, boolean powerTransferLimited, int powerBrickConnectionStatus, int[] complianceWarnings, int plugState, DisplayPortAltModeInfo displayPortAltModeInfo) {
            boolean dispositionChanged = false;
            if (this.mUsbPortStatus == null) goto L5;
            boolean complianceChanged = complianceWarningsChanged(complianceWarnings);
            DisplayPortAltModeInfo r13 = displayPortAltModeInfo;
            boolean displayPortChanged = displayPortAltModeChanged(r13);
            boolean complianceChanged2 = complianceChanged;
            boolean displayPortChanged2 = displayPortChanged;
        L6:
            this.mCanChangeMode = canChangeMode;
            this.mCanChangePowerRole = canChangePowerRole;
            this.mCanChangeDataRole = canChangeDataRole;
            if (this.mUsbPortStatus == null) goto L33;
            if (this.mUsbPortStatus.getCurrentMode() != currentMode) goto L33;
            if (this.mUsbPortStatus.getCurrentPowerRole() != currentPowerRole) goto L33;
            if (this.mUsbPortStatus.getCurrentDataRole() != currentDataRole) goto L33;
            if (this.mUsbPortStatus.getSupportedRoleCombinations() != supportedRoleCombinations) goto L33;
            if (this.mUsbPortStatus.getContaminantProtectionStatus() != contaminantProtectionStatus) goto L33;
            if (this.mUsbPortStatus.getContaminantDetectionStatus() != contaminantDetectionStatus) goto L33;
            if (this.mUsbPortStatus.getUsbDataStatus() != usbDataStatus) goto L33;
            if (this.mUsbPortStatus.isPowerTransferLimited() != powerTransferLimited) goto L33;
            if (this.mUsbPortStatus.getPowerBrickConnectionStatus() != powerBrickConnectionStatus) goto L33;
            if (this.mUsbPortStatus.getPlugState() != plugState) goto L33;
            if (complianceChanged2 == true) goto L31;
            if (displayPortChanged2 == true) goto L31;
        L39:
            if (this.mUsbPortStatus.isConnected() == false) goto L44;
            if (this.mConnectedAtMillis != 0) goto L44;
            this.mConnectedAtMillis = SystemClock.elapsedRealtime();
            this.mLastConnectDurationMillis = 0;
        L48:
            return dispositionChanged;
        L44:
            if (this.mUsbPortStatus.isConnected() == true) goto L48;
            if (this.mConnectedAtMillis == 0) goto L48;
            this.mLastConnectDurationMillis = SystemClock.elapsedRealtime() - this.mConnectedAtMillis;
            this.mConnectedAtMillis = 0;
        L31:
            this.mUsbPortStatus = new UsbPortStatus(currentMode, currentPowerRole, currentDataRole, supportedRoleCombinations, contaminantProtectionStatus, contaminantDetectionStatus, usbDataStatus, powerTransferLimited, powerBrickConnectionStatus, complianceWarnings, plugState, r13);
        L33:
            if (this.mUsbPortStatus == null) goto L35;
        L37:
            this.mUsbPortStatus = new UsbPortStatus(currentMode, currentPowerRole, currentDataRole, supportedRoleCombinations, contaminantProtectionStatus, contaminantDetectionStatus, usbDataStatus, powerTransferLimited, powerBrickConnectionStatus, complianceWarnings, plugState, displayPortAltModeInfo);
            dispositionChanged = true;
            goto L39
        L35:
            if (complianceWarnings.length <= 0) goto L37;
            this.mComplianceWarningChange = 1;
            goto L37
        L5:
            r13 = displayPortAltModeInfo;
            complianceChanged2 = false;
            displayPortChanged2 = false;
            goto L6
        }

        void dump(DualDumpOutputStream dump, String idName, long id) {
            long token = dump.start(idName, id);
            DumpUtils.writePort(dump, "port", 1146756268033L, this.mUsbPort);
            DumpUtils.writePortStatus(dump, "status", 1146756268034L, this.mUsbPortStatus);
            dump.write("can_change_mode", 1133871366147L, this.mCanChangeMode);
            dump.write("can_change_power_role", 1133871366148L, this.mCanChangePowerRole);
            dump.write("can_change_data_role", 1133871366149L, this.mCanChangeDataRole);
            dump.write("connected_at_millis", 1112396529670L, this.mConnectedAtMillis);
            dump.write("last_connect_duration_millis", 1112396529671L, this.mLastConnectDurationMillis);
            dump.end(token);
        }

        public String toString() {
            return "port=" + this.mUsbPort + ", status=" + this.mUsbPortStatus + ", canChangeMode=" + this.mCanChangeMode + ", canChangePowerRole=" + this.mCanChangePowerRole + ", canChangeDataRole=" + this.mCanChangeDataRole + ", connectedAtMillis=" + this.mConnectedAtMillis + ", lastConnectDurationMillis=" + this.mLastConnectDurationMillis;
        }
    }

    public static /* synthetic */ void $r8$lambda$AI2H4RJmxXJkfvJgoE6doUVmqKg(UsbPortManager r0, Intent r1) {
        r0.lambda$sendPortChangedBroadcastLocked$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$RewhrlhXhZaphTPKUwIQcNRv6IY(UsbPortManager r0, Intent r1) {
        r0.lambda$sendComplianceWarningBroadcastLocked$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9187$$Nest$fgetmContext(UsbPortManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9188$$Nest$fputmNotificationManager(UsbPortManager r0, NotificationManager r1) {
        r0.mNotificationManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateContaminantNotificationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9189$$Nest$mupdateContaminantNotificationLocked(UsbPortManager r0) {
        r0.updateContaminantNotificationLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePortsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9190$$Nest$mupdatePortsLocked(UsbPortManager r0, IndentingPrintWriter r1, ArrayList r2) {
        r0.updatePortsLocked(r1, r2);
    }

    static {
        COMBO_SOURCE_HOST = UsbPort.combineRolesAsBit(1, 1);
        COMBO_SOURCE_DEVICE = UsbPort.combineRolesAsBit(1, 2);
        COMBO_SINK_HOST = UsbPort.combineRolesAsBit(2, 1);
        COMBO_SINK_DEVICE = UsbPort.combineRolesAsBit(2, 2);
    }

    public UsbPortManager(Context context) {
        this.mLock = new Object();
        this.mPorts = new ArrayMap();
        this.mSimulatedPorts = new ArrayMap();
        this.mConnected = new ArrayMap();
        this.mContaminantStatus = new ArrayMap();
        this.mDisplayPortListenerLock = new Object();
        this.mDisplayPortListeners = new ArrayMap();
        final Looper r1 = FgThread.get().getLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mContext = context;
        this.mUsbPortHal = UsbPortHalInstance.getInstance(this, null);
        logAndPrint(3, null, "getInstance done");
        this.mExt = (IExtUsbPortManager) ExtImplFactory.getImpl(IExtUsbPortManager.class, new Object[]{this, this.mContext});
    }

    public void systemReady() {
        this.mSystemReady = true;
        if (this.mUsbPortHal == null) goto L9;
        this.mUsbPortHal.systemReady();
        UsbPortHal r0 = this.mUsbPortHal;     // Catch: Exception -> L7
        long r1 = this.mTransactionId + 1;     // Catch: Exception -> L7
        this.mTransactionId = r1;     // Catch: Exception -> L7
        r0.queryPortStatus(r1);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        logAndPrintException(null, "ServiceStart: Failed to query port status", e);
    L9:
        this.mExt.systemReady();
        this.mHandler.sendEmptyMessage(2);
    }

    private void updateContaminantNotificationLocked() {
        if (this.mNotificationManager != null) goto L5;
        return;
    L5:
        PortInfo currentPortInfo = null;
        Resources r = this.mContext.getResources();
        int contaminantStatus = 2;
        Iterator<PortInfo> r4 = this.mPorts.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        PortInfo portInfo = r4.next();
        contaminantStatus = portInfo.mUsbPortStatus.getContaminantDetectionStatus();
        if (contaminantStatus == 3) goto L13;
        if (contaminantStatus != 1) goto L7;
    L13:
        currentPortInfo = portInfo;
    L15:
        if (contaminantStatus == 3) goto L17;
    L23:
        if (contaminantStatus != 3) goto L25;
        return;
    L25:
        if (this.mIsPortContaminatedNotificationId != 52) goto L37;
        this.mNotificationManager.cancelAsUser(null, this.mIsPortContaminatedNotificationId, UserHandle.ALL);
        this.mIsPortContaminatedNotificationId = 0;
        if (contaminantStatus != 2) goto L34;
        this.mIsPortContaminatedNotificationId = 53;
        CharSequence title = r.getText(17042294);
        CharSequence message = r.getText(17042293);
        Notification.Builder builder = new Notification.Builder(this.mContext, "ALERTS").setSmallIcon(R.drawable.pointer_wait_vector_26).setTicker(title).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setVisibility(1).setStyle(new Notification.BigTextStyle().bigText(message));
        Notification notification = builder.build();
        this.mNotificationManager.notifyAsUser(null, this.mIsPortContaminatedNotificationId, notification, UserHandle.ALL);
        return;
    L34:
        return;
    L37:
        return;
    L17:
        if (this.mIsPortContaminatedNotificationId == 52) goto L23;
        if (this.mIsPortContaminatedNotificationId != 53) goto L21;
        this.mNotificationManager.cancelAsUser(null, this.mIsPortContaminatedNotificationId, UserHandle.ALL);
    L21:
        this.mIsPortContaminatedNotificationId = 52;
        CharSequence title2 = r.getText(17042291);
        CharSequence message2 = r.getText(17042289);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setComponent(ComponentName.unflattenFromString(r.getString(R.string.data_usage_limit_body)));
        intent.putExtra("port", ParcelableUsbPort.of(currentPortInfo.mUsbPort));
        intent.putExtra("portStatus", currentPortInfo.mUsbPortStatus);
        PendingIntent pi = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 67108864, null, UserHandle.CURRENT);
        Notification.Builder builder2 = new Notification.Builder(this.mContext, "ALERTS").setOngoing(true).setTicker(title2).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentIntent(pi).setContentTitle(title2).setContentText(message2).setVisibility(1).setSmallIcon(R.drawable.stat_sys_warning).setStyle(new Notification.BigTextStyle().bigText(message2));
        Notification notification2 = builder2.build();
        this.mNotificationManager.notifyAsUser(null, this.mIsPortContaminatedNotificationId, notification2, UserHandle.ALL);
    }

    public UsbPort[] getPorts() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = this.mPorts.size();     // Catch: Throwable -> L7
        UsbPort[] result = new UsbPort[count];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= count) goto L10;
        result[i] = this.mPorts.valueAt(i).mUsbPort;     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return result;
    L7:
        th = move-exception;
        throw th;
    }

    public UsbPortStatus getPortStatus(String portId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PortInfo portInfo = this.mPorts.get(portId);     // Catch: Throwable -> L7
        if (portInfo == null) goto L9;
        UsbPortStatus r2 = portInfo.mUsbPortStatus;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isModeChangeSupported(String portId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PortInfo portInfo = this.mPorts.get(portId);     // Catch: Throwable -> L7
        if (portInfo == null) goto L9;
        boolean r2 = portInfo.mCanChangeMode;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = false;
    L7:
        th = move-exception;
        throw th;
    }

    public void enableContaminantDetection(String portId, boolean enable, IndentingPrintWriter pw) {
        PortInfo portInfo = this.mPorts.get(portId);
        if (portInfo != null) goto L8;
        if (pw == null) goto L28;
        pw.println("No such USB port: " + portId);
        return;
    L28:
        return;
    L8:
        if (portInfo.mUsbPort.supportsEnableContaminantPresenceDetection() == true) goto L11;
        return;
    L11:
        if (enable == true) goto L13;
    L15:
        if (enable == true) goto L19;
        if (portInfo.mUsbPortStatus.getContaminantDetectionStatus() != 1) goto L19;
        return;
    L19:
        if (portInfo.mUsbPortStatus.getContaminantDetectionStatus() == 0) goto L30;
        UsbPortHal r1 = this.mUsbPortHal;     // Catch: Exception -> L23
        long r2 = this.mTransactionId + 1;     // Catch: Exception -> L23
        this.mTransactionId = r2;     // Catch: Exception -> L23
        r1.enableContaminantPresenceDetection(portId, enable, r2);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        logAndPrintException(pw, "Failed to set contaminant detection", e);
        return;
    L30:
        return;
    L13:
        if (portInfo.mUsbPortStatus.getContaminantDetectionStatus() == 1) goto L15;
    }

    public void enableLimitPowerTransfer(String portId, boolean limit, long transactionId, IUsbOperationInternal callback, IndentingPrintWriter pw) {
        portId.getClass();
        PortInfo portInfo = this.mPorts.get(portId);
        if (portInfo != null) goto L34;
        logAndPrint(6, pw, "enableLimitPowerTransfer: No such port: " + portId + " opId:" + transactionId);
        if (callback != null) goto L30;
        return;
    L30:
        callback.onOperationComplete(3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        logAndPrintException(pw, "enableLimitPowerTransfer: Failed to call OperationComplete. opId:" + transactionId, e);
        return;
    L34:
        long transactionId2 = transactionId;
        IUsbOperationInternal callback2 = callback;
        this.mUsbPortHal.enableLimitPowerTransfer(portId, limit, transactionId2, callback2);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Exception e = e;
    L32:
        logAndPrintException(pw, "enableLimitPowerTransfer: Failed to limit power transfer. opId:" + transactionId2, e);     // Catch: RemoteException -> L25
        if (callback2 == null) goto L40;
        callback2.onOperationComplete(1);     // Catch: RemoteException -> L25
        return;
    L40:
        return;
    L25:
        e = move-exception;
        logAndPrintException(pw, "enableLimitPowerTransfer:Failed to call onOperationComplete. opId:" + transactionId2, e);
        return;
    L19:
        e = move-exception;
        transactionId2 = transactionId;
        callback2 = callback;
        e = e;
        goto L32
    }

    public void enableUsbDataWhileDocked(String portId, long transactionId, IUsbOperationInternal callback, IndentingPrintWriter pw) {
        portId.getClass();
        PortInfo portInfo = this.mPorts.get(portId);
        if (portInfo != null) goto L27;
        logAndPrint(6, pw, "enableUsbDataWhileDocked: No such port: " + portId + " opId:" + transactionId);
        if (callback != null) goto L25;
        return;
    L25:
        callback.onOperationComplete(3);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        logAndPrintException(pw, "enableUsbDataWhileDocked: Failed to call OperationComplete. opId:" + transactionId, e);
        return;
    L27:
        this.mUsbPortHal.enableUsbDataWhileDocked(portId, transactionId, callback);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        logAndPrintException(pw, "enableUsbDataWhileDocked: Failed to limit power transfer. opId:" + transactionId, e);     // Catch: RemoteException -> L20
        if (callback == null) goto L33;
        callback.onOperationComplete(1);     // Catch: RemoteException -> L20
        return;
    L33:
        return;
    L20:
        e = move-exception;
        logAndPrintException(pw, "enableUsbDataWhileDocked:Failed to call onOperationComplete. opId:" + transactionId, e);
    }

    public boolean enableUsbData(String portId, boolean enable, int transactionId, IUsbOperationInternal callback, IndentingPrintWriter pw) {
        callback.getClass();
        portId.getClass();
        PortInfo portInfo = this.mPorts.get(portId);
        if (portInfo != null) goto L23;
        logAndPrint(6, pw, "enableUsbData: No such port: " + portId + " opId:" + transactionId);
        callback.onOperationComplete(3);     // Catch: RemoteException -> L7
    L9:
        return false;
    L7:
        e = move-exception;
        logAndPrintException(pw, "enableUsbData: Failed to call OperationComplete. opId:" + transactionId, e);
        goto L9
    L23:
        IUsbOperationInternal callback2 = callback;
        return this.mUsbPortHal.enableUsbData(portId, enable, transactionId, callback2);
    L14:
        e = move-exception;
        Exception e = e;
    L29:
        logAndPrintException(pw, "enableUsbData: Failed to invoke enableUsbData. opId:" + transactionId, e);     // Catch: RemoteException -> L20
        callback2.onOperationComplete(1);     // Catch: RemoteException -> L20
    L22:
        return false;
    L20:
        e = move-exception;
        logAndPrintException(pw, "enableUsbData: Failed to call onOperationComplete. opId:" + transactionId, e);
    L16:
        e = move-exception;
        callback2 = callback;
        e = e;
        goto L29
    }

    public int getUsbHalVersion() {
        if (this.mUsbPortHal != null) goto L9;
        return -2;
    L9:
        return this.mUsbPortHal.getUsbHalVersion();
    L7:
        return -2;
    }

    private int toHalUsbDataRole(int usbDataRole) {
        if (usbDataRole != 2) goto L5;
        return 2;
    L5:
        return 1;
    }

    private int toHalUsbPowerRole(int usbPowerRole) {
        if (usbPowerRole != 2) goto L5;
        return 2;
    L5:
        return 1;
    }

    private int toHalUsbMode(int usbMode) {
        if (usbMode != 1) goto L5;
        return 1;
    L5:
        return 2;
    }

    public void resetUsbPort(String portId, int transactionId, IUsbOperationInternal callback, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        callback.getClass();     // Catch: Throwable -> L10
        portId.getClass();     // Catch: Throwable -> L10
        PortInfo portInfo = this.mPorts.get(portId);     // Catch: Throwable -> L10
        if (portInfo != null) goto L31;
        logAndPrint(6, pw, "resetUsbPort: No such port: " + portId + " opId:" + transactionId);     // Catch: Throwable -> L10
        callback.onOperationComplete(3);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        logAndPrintException(pw, "resetUsbPort: Failed to call OperationComplete. opId:" + transactionId, e);     // Catch: Throwable -> L10
    L31:
        this.mUsbPortHal.resetUsbPort(portId, transactionId, callback);     // Catch: Throwable -> L10 Exception -> L16
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L16:
        e = move-exception;
        logAndPrintException(pw, "reseetUsbPort: Failed to resetUsbPort. opId:" + transactionId, e);     // Catch: Throwable -> L10 RemoteException -> L19
        callback.onOperationComplete(1);     // Catch: Throwable -> L10 RemoteException -> L19
    L19:
        e = move-exception;
        logAndPrintException(pw, "resetUsbPort: Failed to call onOperationComplete. opId:" + transactionId, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setPortRoles(String portId, int newPowerRole, int newDataRole, IndentingPrintWriter pw) {
        Object r6 = this.mLock;
        monitor-enter(r6);
        PortInfo portInfo = this.mPorts.get(portId);     // Catch: Throwable -> L8
        if (portInfo != null) goto L13;
        if (pw == null) goto L10;
        pw.println("No such USB port: " + portId);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L13:
        if (portInfo.mUsbPortStatus.isRoleCombinationSupported(newPowerRole, newDataRole) == true) goto L17;
        logAndPrint(6, pw, "Attempted to set USB port into unsupported role combination: portId=" + portId + ", newPowerRole=" + UsbPort.powerRoleToString(newPowerRole) + ", newDataRole=" + UsbPort.dataRoleToString(newDataRole));     // Catch: Throwable -> L8
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L17:
        int currentDataRole = portInfo.mUsbPortStatus.getCurrentDataRole();     // Catch: Throwable -> L8
        int currentPowerRole = portInfo.mUsbPortStatus.getCurrentPowerRole();     // Catch: Throwable -> L8
        if (currentDataRole != newDataRole) goto L24;
        if (currentPowerRole != newPowerRole) goto L24;
        if (pw == null) goto L22;
        pw.println("No change.");     // Catch: Throwable -> L8
    L22:
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L24:
        boolean canChangeMode = portInfo.mCanChangeMode;     // Catch: Throwable -> L8
        boolean canChangePowerRole = portInfo.mCanChangePowerRole;     // Catch: Throwable -> L8
        boolean canChangeDataRole = portInfo.mCanChangeDataRole;     // Catch: Throwable -> L8
        int currentMode = portInfo.mUsbPortStatus.getCurrentMode();     // Catch: Throwable -> L8
        if (canChangePowerRole == true) goto L27;
        if (currentPowerRole == newPowerRole) goto L27;
    L29:
        if (canChangeMode == true) goto L31;
    L34:
        if (canChangeMode == true) goto L36;
    L39:
        logAndPrint(6, pw, "Found mismatch in supported USB role combinations while attempting to change role: " + portInfo + ", newPowerRole=" + UsbPort.powerRoleToString(newPowerRole) + ", newDataRole=" + UsbPort.dataRoleToString(newDataRole));     // Catch: Throwable -> L8
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L36:
        if (newPowerRole != 2) goto L39;
        if (newDataRole != 2) goto L39;
        int newMode = 1;
    L43:
        logAndPrint(4, pw, "Setting USB port mode and role: portId=" + portId + ", currentMode=" + UsbPort.modeToString(currentMode) + ", currentPowerRole=" + UsbPort.powerRoleToString(currentPowerRole) + ", currentDataRole=" + UsbPort.dataRoleToString(currentDataRole) + ", newMode=" + UsbPort.modeToString(newMode) + ", newPowerRole=" + UsbPort.powerRoleToString(newPowerRole) + ", newDataRole=" + UsbPort.dataRoleToString(newDataRole));     // Catch: Throwable -> L8
        RawPortInfo sim = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L8
        if (sim == null) goto L47;
        sim.currentMode = newMode;     // Catch: Throwable -> L8
        sim.currentPowerRole = newPowerRole;     // Catch: Throwable -> L8
        sim.currentDataRole = newDataRole;     // Catch: Throwable -> L8
        updatePortsLocked(pw, null);     // Catch: Throwable -> L8
    L76:
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L47:
        if (this.mUsbPortHal == null) goto L76;
        if (currentMode == newMode) goto L63;
        logAndPrint(6, pw, "Trying to set the USB port mode: portId=" + portId + ", newMode=" + UsbPort.modeToString(newMode));     // Catch: Throwable -> L8
        UsbPortHal r0 = this.mUsbPortHal;     // Catch: Throwable -> L8 Exception -> L57
        int r7 = toHalUsbMode(newMode);     // Catch: Throwable -> L8 Exception -> L57
        long r11 = this.mTransactionId + 1;     // Catch: Throwable -> L8 Exception -> L55
        this.mTransactionId = r11;     // Catch: Throwable -> L8 Exception -> L55
        r0.switchMode(portId, r7, r11);     // Catch: Throwable -> L8 Exception -> L55
    L55:
        e = e;
    L60:
        logAndPrintException(pw, "Failed to set the USB port mode: portId=" + portId + ", newMode=" + UsbPort.modeToString(newMode), e);     // Catch: Throwable -> L8
    L57:
        e = e;
        goto L60
    L63:
        if (currentPowerRole != newPowerRole) goto L84;
    L70:
        if (currentDataRole == newDataRole) goto L76;
        UsbPortHal r1 = this.mUsbPortHal;     // Catch: Throwable -> L8 Exception -> L73
        int r8 = toHalUsbDataRole(newDataRole);     // Catch: Throwable -> L8 Exception -> L73
        long r12 = this.mTransactionId + 1;     // Catch: Throwable -> L8 Exception -> L73
        this.mTransactionId = r12;     // Catch: Throwable -> L8 Exception -> L73
        r1.switchDataRole(portId, r8, r12);     // Catch: Throwable -> L8 Exception -> L73
    L73:
        e = move-exception;
        logAndPrintException(pw, "Failed to set the USB port data role: portId=" + portId + ", newDataRole=" + UsbPort.dataRoleToString(newDataRole), e);     // Catch: Throwable -> L8
        goto L76
    L84:
        UsbPortHal r2 = this.mUsbPortHal;     // Catch: Throwable -> L8 Exception -> L66
        int r9 = toHalUsbPowerRole(newPowerRole);     // Catch: Throwable -> L8 Exception -> L66
        long r13 = this.mTransactionId + 1;     // Catch: Throwable -> L8 Exception -> L66
        this.mTransactionId = r13;     // Catch: Throwable -> L8 Exception -> L66
        r2.switchPowerRole(portId, r9, r13);     // Catch: Throwable -> L8 Exception -> L66
    L66:
        e = move-exception;
        logAndPrintException(pw, "Failed to set the USB port power role: portId=" + portId + ", newPowerRole=" + UsbPort.powerRoleToString(newPowerRole), e);     // Catch: Throwable -> L8
        return;
    L31:
        if (newPowerRole != 1) goto L34;
        if (newDataRole != 1) goto L34;
        newMode = 2;
    L27:
        if (canChangeDataRole == true) goto L42;
        if (currentDataRole != newDataRole) goto L29;
    L42:
        newMode = currentMode;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.wtf(TAG, "binderDied() called unexpectedly");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder deadBinder) {
        Object r0 = this.mDisplayPortListenerLock;
        monitor-enter(r0);
        this.mDisplayPortListeners.remove(deadBinder);     // Catch: Throwable -> L7
        Slog.d(TAG, "DisplayPortEventDispatcherListener died at " + deadBinder);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean registerForDisplayPortEvents(IDisplayPortAltModeInfoListener listener) {
        Object r0 = this.mDisplayPortListenerLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.mDisplayPortListeners.containsKey(listener.asBinder()) == false) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L23:
        listener.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L12 RemoteException -> L14
        this.mDisplayPortListeners.put(listener.asBinder(), listener);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        e = move-exception;
        logAndPrintException(null, "Caught RemoteException in registerForDisplayPortEvents: ", e);     // Catch: Throwable -> L12
        return false;
    }

    public void unregisterForDisplayPortEvents(IDisplayPortAltModeInfoListener listener) {
        Object r0 = this.mDisplayPortListenerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDisplayPortListeners.remove(listener.asBinder()) == null) goto L9;
        listener.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void updatePorts(ArrayList<RawPortInfo> newPortInfo) {
        Message message = this.mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PORT_INFO, newPortInfo);
        message.what = 1;
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    public void addSimulatedPort(String portId, int supportedModes, boolean supportsComplianceWarnings, boolean supportsDisplayPortAltMode, IndentingPrintWriter pw) {
        if (supportsDisplayPortAltMode == false) goto L5;
        int supportedAltModes = 1;
    L7:
        if (supportsDisplayPortAltMode == false) goto L9;
        DisplayPortAltModeInfo displayPortAltModeInfo = new DisplayPortAltModeInfo();
        DisplayPortAltModeInfo displayPortAltModeInfo2 = displayPortAltModeInfo;
    L10:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L27:
        th = th;
    L33:
        monitor-exit(r24);     // Catch: Throwable -> L27
        throw th;
    L17:
        th = th;
    L18:
        Object r24 = r4;
        goto L33
    L13:
        if (this.mSimulatedPorts.containsKey(portId) == false) goto L19;
        pw.println("Port with same name already exists.  Please remove it first.");     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        return;
    L19:
        pw.println("Adding simulated port: portId=" + portId + ", supportedModes=" + UsbPort.modeToString(supportedModes));     // Catch: Throwable -> L17
        r24 = r4;
        this.mSimulatedPorts.put(portId, new RawPortInfo(portId, supportedModes, 0, 0, false, 0, false, 0, false, false, 0, false, 0, 0, false, 0, supportsComplianceWarnings, new int[0], 0, supportedAltModes, displayPortAltModeInfo2));     // Catch: Throwable -> L29
        updatePortsLocked(pw, null);     // Catch: Throwable -> L27
        monitor-exit(r24);     // Catch: Throwable -> L27
        return;
    L29:
        th = th;
    L31:
        th = th;
        goto L18
    L9:
        displayPortAltModeInfo2 = null;
        goto L10
    L5:
        supportedAltModes = 0;
        goto L7
    }

    public void connectSimulatedPort(String portId, int mode, boolean canChangeMode, int powerRole, boolean canChangePowerRole, int dataRole, boolean canChangeDataRole, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RawPortInfo portInfo = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L9
        if (portInfo != null) goto L11;
        pw.println("Cannot connect simulated port which does not exist.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        if (mode == 0) goto L23;
        if (powerRole == 0) goto L23;
        if (dataRole == 0) goto L23;
        if ((portInfo.supportedModes & mode) != 0) goto L20;
        pw.println("Simulated port does not support mode: " + UsbPort.modeToString(mode));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        pw.println("Connecting simulated port: portId=" + portId + ", mode=" + UsbPort.modeToString(mode) + ", canChangeMode=" + canChangeMode + ", powerRole=" + UsbPort.powerRoleToString(powerRole) + ", canChangePowerRole=" + canChangePowerRole + ", dataRole=" + UsbPort.dataRoleToString(dataRole) + ", canChangeDataRole=" + canChangeDataRole);     // Catch: Throwable -> L9
        portInfo.currentMode = mode;     // Catch: Throwable -> L9
        portInfo.canChangeMode = canChangeMode;     // Catch: Throwable -> L9
        portInfo.currentPowerRole = powerRole;     // Catch: Throwable -> L9
        portInfo.canChangePowerRole = canChangePowerRole;     // Catch: Throwable -> L9
        portInfo.currentDataRole = dataRole;     // Catch: Throwable -> L9
        portInfo.canChangeDataRole = canChangeDataRole;     // Catch: Throwable -> L9
        updatePortsLocked(pw, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L23:
        pw.println("Cannot connect simulated port in null mode, power role, or data role.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void simulateContaminantStatus(String portId, boolean detected, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RawPortInfo portInfo = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L9
        if (portInfo != null) goto L11;
        pw.println("Simulated port not found.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        pw.println("Simulating wet port: portId=" + portId + ", wet=" + detected);     // Catch: Throwable -> L9
        if (detected == false) goto L14;
        int r2 = 3;
    L15:
        portInfo.contaminantDetectionStatus = r2;     // Catch: Throwable -> L9
        updatePortsLocked(pw, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        r2 = 2;
    L9:
        th = move-exception;
        throw th;
    }

    public void simulateComplianceWarnings(String portId, String complianceWarningsString, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RawPortInfo portInfo = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L9
        if (portInfo != null) goto L11;
        pw.println("Simulated port not found");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        IntArray complianceWarnings = new IntArray();     // Catch: Throwable -> L9
        String[] r3 = complianceWarningsString.split("[, ]");     // Catch: Throwable -> L9
        int r4 = r3.length;     // Catch: Throwable -> L9
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L17;
        String s = r3[r5];     // Catch: Throwable -> L9
        if (s.length() <= 0) goto L16;
        complianceWarnings.add(Integer.parseInt(s));     // Catch: Throwable -> L9
    L16:
        r5 = r5 + 1;     // Catch: Throwable -> L9
        goto L12
    L17:
        pw.println("Simulating Compliance Warnings: portId=" + portId + " Warnings=" + complianceWarningsString);     // Catch: Throwable -> L9
        portInfo.complianceWarnings = complianceWarnings.toArray();     // Catch: Throwable -> L9
        updatePortsLocked(pw, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void simulateDisplayPortAltModeInfo(String portId, int partnerSinkStatus, int cableStatus, int numLanes, boolean hpd, int linkTrainingStatus, IndentingPrintWriter pw) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        RawPortInfo portInfo = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L18
        if (portInfo == null) goto L24;
        DisplayPortAltModeInfo displayPortAltModeInfo = new DisplayPortAltModeInfo(partnerSinkStatus, cableStatus, numLanes, hpd, linkTrainingStatus);     // Catch: Throwable -> L16
        portInfo.displayPortAltModeInfo = displayPortAltModeInfo;     // Catch: Throwable -> L16
        pw.println("Simulating DisplayPort Info: " + displayPortAltModeInfo);     // Catch: Throwable -> L16
        updatePortsLocked(pw, null);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L24:
        pw.println("Simulated port not found");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw th;
    L16:
        th = th;
    L18:
        th = th;
        goto L20
    }

    public void disconnectSimulatedPort(String portId, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RawPortInfo portInfo = this.mSimulatedPorts.get(portId);     // Catch: Throwable -> L9
        if (portInfo != null) goto L11;
        pw.println("Cannot disconnect simulated port which does not exist.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        pw.println("Disconnecting simulated port: portId=" + portId);     // Catch: Throwable -> L9
        portInfo.currentMode = 0;     // Catch: Throwable -> L9
        portInfo.canChangeMode = false;     // Catch: Throwable -> L9
        portInfo.currentPowerRole = 0;     // Catch: Throwable -> L9
        portInfo.canChangePowerRole = false;     // Catch: Throwable -> L9
        portInfo.currentDataRole = 0;     // Catch: Throwable -> L9
        portInfo.canChangeDataRole = false;     // Catch: Throwable -> L9
        updatePortsLocked(pw, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeSimulatedPort(String portId, IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mSimulatedPorts.indexOfKey(portId);     // Catch: Throwable -> L9
        if (index >= 0) goto L11;
        pw.println("Cannot remove simulated port which does not exist.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        pw.println("Disconnecting simulated port: portId=" + portId);     // Catch: Throwable -> L9
        this.mSimulatedPorts.removeAt(index);     // Catch: Throwable -> L9
        updatePortsLocked(pw, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void resetSimulation(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Removing all simulated ports and ending simulation.");     // Catch: Throwable -> L7
        if (this.mSimulatedPorts.isEmpty() == true) goto L9;
        this.mSimulatedPorts.clear();     // Catch: Throwable -> L7
        updatePortsLocked(pw, null);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mSimulatedPorts.isEmpty() == true) goto L7;
        boolean r4 = true;
    L8:
        dump.write("is_simulation_active", 1133871366145L, r4);     // Catch: Throwable -> L12
        Iterator<PortInfo> r3 = this.mPorts.values().iterator();     // Catch: Throwable -> L12
    L10:
        if (r3.hasNext() == false) goto L14;
        PortInfo portInfo = r3.next();     // Catch: Throwable -> L12
        portInfo.dump(dump, "usb_ports", 2246267895810L);     // Catch: Throwable -> L12
        goto L10
    L14:
        dump.write("usb_hal_version", 1159641169924L, getUsbHalVersion());     // Catch: Throwable -> L12
        this.mExt.dump(dump);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        dump.end(token);
        return;
    L7:
        r4 = false;
        goto L8
    }

    private void updatePortsLocked(IndentingPrintWriter pw, ArrayList<RawPortInfo> newPortInfo) {
        UsbPortManager r0 = this;
        int i = r0.mPorts.size();
    L3:
        int i2 = i - 1;
        if (i <= 0) goto L7;
        r0.mPorts.valueAt(i2).mDisposition = 3;
        i = i2;
        goto L3
    L7:
        if (r0.mSimulatedPorts.isEmpty() == true) goto L12;
        int count = r0.mSimulatedPorts.size();
        int i3 = 0;
    L9:
        if (i3 >= count) goto L17;
        RawPortInfo portInfo = r0.mSimulatedPorts.valueAt(i3);
        int count2 = count;
        String r1 = portInfo.portId;
        int i4 = i3;
        int i5 = portInfo.supportedModes;
        int r6 = portInfo.supportedContaminantProtectionModes;
        int count3 = portInfo.currentMode;
        boolean r5 = portInfo.canChangeMode;
        int r7 = portInfo.currentPowerRole;
        boolean r8 = portInfo.canChangePowerRole;
        int i6 = portInfo.currentDataRole;
        boolean r9 = portInfo.canChangeDataRole;
        boolean r10 = portInfo.supportsEnableContaminantPresenceProtection;
        int i7 = portInfo.contaminantProtectionStatus;
        boolean r12 = portInfo.supportsEnableContaminantPresenceDetection;
        int count4 = portInfo.contaminantDetectionStatus;
        int i8 = portInfo.usbDataStatus;
        boolean r15 = portInfo.powerTransferLimited;
        int count5 = portInfo.powerBrickConnectionStatus;
        r0 = this;
        r0.addOrUpdatePortLocked(r1, i5, r6, count3, r5, r7, r8, i6, r9, r10, i7, r12, count4, i8, r15, count5, portInfo.supportsComplianceWarnings, portInfo.complianceWarnings, portInfo.plugState, portInfo.supportedAltModes, portInfo.displayPortAltModeInfo, pw);
        i3 = i4 + 1;
        count = count2;
    L17:
        int i9 = this.mPorts.size();
    L18:
        int i10 = i9 - 1;
        if (i9 <= 0) goto L38;
        PortInfo portInfo2 = this.mPorts.valueAt(i10);
        switch(portInfo2.mDisposition) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L27;
            case 3: goto L23;
            default: goto L27;
        };
    L23:
        this.mPorts.removeAt(i10);
        portInfo2.mUsbPortStatus = null;
        handlePortRemovedLocked(portInfo2, pw);
        goto L27
    L24:
        handlePortChangedLocked(portInfo2, pw);
        portInfo2.mDisposition = 2;
        goto L27
    L25:
        handlePortAddedLocked(portInfo2, pw);
        portInfo2.mDisposition = 2;
    L27:
        if (portInfo2.mComplianceWarningChange != 1) goto L30;
        handlePortComplianceWarningLocked(portInfo2, pw);
    L30:
        if (portInfo2.mDisplayPortAltModeChange != 1) goto L36;
        if (portInfo2.mUsbPortStatus != null) goto L34;
        Slog.w(TAG, "usb removed no need notify altMode change");
        goto L36
    L34:
        handleDpAltModeLocked(portInfo2, pw);
    L36:
        i9 = i10;
        goto L18
    L38:
        return;
    L12:
        Iterator<RawPortInfo> r23 = newPortInfo.iterator();
    L14:
        if (r23.hasNext() == false) goto L17;
        RawPortInfo currentPortInfo = r23.next();
        addOrUpdatePortLocked(currentPortInfo.portId, currentPortInfo.supportedModes, currentPortInfo.supportedContaminantProtectionModes, currentPortInfo.currentMode, currentPortInfo.canChangeMode, currentPortInfo.currentPowerRole, currentPortInfo.canChangePowerRole, currentPortInfo.currentDataRole, currentPortInfo.canChangeDataRole, currentPortInfo.supportsEnableContaminantPresenceProtection, currentPortInfo.contaminantProtectionStatus, currentPortInfo.supportsEnableContaminantPresenceDetection, currentPortInfo.contaminantDetectionStatus, currentPortInfo.usbDataStatus, currentPortInfo.powerTransferLimited, currentPortInfo.powerBrickConnectionStatus, currentPortInfo.supportsComplianceWarnings, currentPortInfo.complianceWarnings, currentPortInfo.plugState, currentPortInfo.supportedAltModes, currentPortInfo.displayPortAltModeInfo, pw);
        goto L14
    }

    private void addOrUpdatePortLocked(String portId, int supportedModes, int supportedContaminantProtectionModes, int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, boolean supportsEnableContaminantPresenceProtection, int contaminantProtectionStatus, boolean supportsEnableContaminantPresenceDetection, int contaminantDetectionStatus, int usbDataStatus, boolean powerTransferLimited, int powerBrickConnectionStatus, boolean supportsComplianceWarnings, int[] complianceWarnings, int plugState, int supportedAltModes, DisplayPortAltModeInfo displayPortAltModeInfo, IndentingPrintWriter pw) {
        if ((supportedModes & 3) != 3) goto L5;
        boolean canChangeMode2 = canChangeMode;
        int currentMode2 = currentMode;
    L10:
        int supportedRoleCombinations = UsbPort.combineRolesAsBit(currentPowerRole, currentDataRole);
        if (currentMode2 == 0) goto L23;
        if (currentPowerRole == 0) goto L23;
        if (currentDataRole == 0) goto L23;
        if (canChangePowerRole == false) goto L17;
        if (canChangeDataRole == false) goto L17;
        int supportedRoleCombinations2 = supportedRoleCombinations | (((COMBO_SOURCE_HOST | COMBO_SOURCE_DEVICE) | COMBO_SINK_HOST) | COMBO_SINK_DEVICE);
    L24:
        PortInfo portInfo = this.mPorts.get(portId);
        if (portInfo != null) goto L27;
        PortInfo portInfo2 = new PortInfo((UsbManager) this.mContext.getSystemService(UsbManager.class), portId, supportedModes, supportedContaminantProtectionModes, supportsEnableContaminantPresenceProtection, supportsEnableContaminantPresenceDetection, supportsComplianceWarnings, supportedAltModes);
        portInfo2.setStatus(currentMode2, canChangeMode2, currentPowerRole, canChangePowerRole, currentDataRole, canChangeDataRole, supportedRoleCombinations2, contaminantProtectionStatus, contaminantDetectionStatus, usbDataStatus, powerTransferLimited, powerBrickConnectionStatus, complianceWarnings, plugState, displayPortAltModeInfo);
        this.mPorts.put(portId, portInfo2);
        return;
    L27:
        int currentMode3 = currentMode2;
        boolean canChangeMode3 = canChangeMode2;
        int supportedRoleCombinations3 = supportedRoleCombinations2;
        if (supportedModes == portInfo.mUsbPort.getSupportedModes()) goto L30;
        IndentingPrintWriter r12 = pw;
        logAndPrint(5, r12, "Ignoring inconsistent list of supported modes from USB port driver (should be immutable): previous=" + UsbPort.modeToString(portInfo.mUsbPort.getSupportedModes()) + ", current=" + UsbPort.modeToString(supportedModes));
    L32:
        if (supportsEnableContaminantPresenceProtection == portInfo.mUsbPort.supportsEnableContaminantPresenceProtection()) goto L35;
        logAndPrint(5, r12, "Ignoring inconsistent supportsEnableContaminantPresenceProtectionUSB port driver (should be immutable): previous=" + portInfo.mUsbPort.supportsEnableContaminantPresenceProtection() + ", current=" + supportsEnableContaminantPresenceProtection);
    L35:
        if (supportsEnableContaminantPresenceDetection == portInfo.mUsbPort.supportsEnableContaminantPresenceDetection()) goto L38;
        logAndPrint(5, r12, "Ignoring inconsistent supportsEnableContaminantPresenceDetection USB port driver (should be immutable): previous=" + portInfo.mUsbPort.supportsEnableContaminantPresenceDetection() + ", current=" + supportsEnableContaminantPresenceDetection);
    L38:
        if (portInfo.setStatus(currentMode3, canChangeMode3, currentPowerRole, canChangePowerRole, currentDataRole, canChangeDataRole, supportedRoleCombinations3, contaminantProtectionStatus, contaminantDetectionStatus, usbDataStatus, powerTransferLimited, powerBrickConnectionStatus, complianceWarnings, plugState, displayPortAltModeInfo) == false) goto L40;
        portInfo.mDisposition = 1;
    L42:
        return;
    L40:
        portInfo.mDisposition = 2;
        goto L42
    L30:
        r12 = pw;
    L17:
        if (canChangePowerRole == false) goto L19;
        supportedRoleCombinations2 = (supportedRoleCombinations | UsbPort.combineRolesAsBit(1, currentDataRole)) | UsbPort.combineRolesAsBit(2, currentDataRole);
        goto L24
    L19:
        if (canChangeDataRole == false) goto L21;
        supportedRoleCombinations2 = (supportedRoleCombinations | UsbPort.combineRolesAsBit(currentPowerRole, 1)) | UsbPort.combineRolesAsBit(currentPowerRole, 2);
        goto L24
    L21:
        if (canChangeMode2 == false) goto L23;
        supportedRoleCombinations2 = supportedRoleCombinations | (COMBO_SOURCE_HOST | COMBO_SINK_DEVICE);
    L23:
        supportedRoleCombinations2 = supportedRoleCombinations;
        goto L24
    L5:
        if (currentMode == 0) goto L8;
        if (currentMode == supportedModes) goto L8;
        logAndPrint(5, pw, "Ignoring inconsistent current mode from USB port driver: supportedModes=" + UsbPort.modeToString(supportedModes) + ", currentMode=" + UsbPort.modeToString(currentMode));
        currentMode2 = 0;
        canChangeMode2 = false;
    L8:
        currentMode2 = currentMode;
        canChangeMode2 = false;
        goto L10
    }

    private void handlePortLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        sendPortChangedBroadcastLocked(portInfo);
        logToStatsd(portInfo, pw);
        getExt().updateContaminantNotificationNew(this.mPorts);
        this.mExt.updateOtgStatusLocked(false);
    }

    private void handlePortAddedLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        logAndPrint(4, pw, "USB port added: " + portInfo);
        handlePortLocked(portInfo, pw);
    }

    private void handlePortChangedLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        logAndPrint(4, pw, "USB port changed: " + portInfo);
        enableContaminantDetectionIfNeeded(portInfo, pw);
        disableLimitPowerTransferIfNeeded(portInfo, pw);
        handlePortLocked(portInfo, pw);
    }

    private void handlePortComplianceWarningLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        logAndPrint(4, pw, "USB port compliance warning changed: " + portInfo);
        logToStatsdComplianceWarnings(portInfo);
        sendComplianceWarningBroadcastLocked(portInfo);
    }

    private void handleDpAltModeLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        logAndPrint(4, pw, "USB port DisplayPort Alt Mode Status Changed: " + portInfo);
        sendDpAltModeCallbackLocked(portInfo, pw);
    }

    private void handlePortRemovedLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        logAndPrint(4, pw, "USB port removed: " + portInfo);
        handlePortLocked(portInfo, pw);
    }

    private static int convertContaminantDetectionStatusToProto(int contaminantDetectionStatus) {
        switch(contaminantDetectionStatus) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    }

    private static int[] toStatsLogConstant(int[] complianceWarnings) {
        IntArray complianceWarningsProto = new IntArray();
        int r1 = complianceWarnings.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        int warning = complianceWarnings[r2];
        switch(warning) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L16;
        };
    L7:
        complianceWarningsProto.add(9);
        goto L16
    L8:
        complianceWarningsProto.add(8);
        goto L16
    L9:
        complianceWarningsProto.add(7);
        goto L16
    L10:
        complianceWarningsProto.add(6);
        goto L16
    L11:
        complianceWarningsProto.add(5);
        goto L16
    L12:
        complianceWarningsProto.add(3);
        goto L16
    L13:
        complianceWarningsProto.add(2);
        goto L16
    L14:
        complianceWarningsProto.add(1);
        goto L16
    L15:
        complianceWarningsProto.add(4);
    L16:
        r2 = r2 + 1;
        goto L3
    L18:
        return complianceWarningsProto.toArray();
    }

    private void sendPortChangedBroadcastLocked(PortInfo portInfo) {
        final Intent intent = new Intent("android.hardware.usb.action.USB_PORT_CHANGED");
        intent.addFlags(AudioFormat.EVRCB);
        intent.putExtra("port", ParcelableUsbPort.of(portInfo.mUsbPort));
        intent.putExtra("portStatus", portInfo.mUsbPortStatus);
        this.mHandler.post(new UsbPortManager$$ExternalSyntheticLambda0(this, intent));
    }

    private /* synthetic */ void lambda$sendPortChangedBroadcastLocked$0(Intent intent) {
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.MANAGE_USB");
    }

    private void sendComplianceWarningBroadcastLocked(PortInfo portInfo) {
        if (portInfo.mComplianceWarningChange != 0) goto L5;
        return;
    L5:
        final Intent intent = new Intent("android.hardware.usb.action.USB_PORT_COMPLIANCE_CHANGED");
        intent.addFlags(AudioFormat.EVRCB);
        intent.putExtra("port", ParcelableUsbPort.of(portInfo.mUsbPort));
        intent.putExtra("portStatus", portInfo.mUsbPortStatus);
        this.mHandler.post(new UsbPortManager$$ExternalSyntheticLambda1(this, intent));
    }

    private /* synthetic */ void lambda$sendComplianceWarningBroadcastLocked$1(Intent intent) {
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.MANAGE_USB");
    }

    private void sendDpAltModeCallbackLocked(PortInfo portInfo, IndentingPrintWriter pw) {
        String portId = portInfo.mUsbPort.getId();
        Object r1 = this.mDisplayPortListenerLock;
        monitor-enter(r1);
        Iterator<IDisplayPortAltModeInfoListener> r2 = this.mDisplayPortListeners.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L15;
        IDisplayPortAltModeInfoListener mListener = r2.next();     // Catch: Throwable -> L10
        mListener.onDisplayPortAltModeInfoChanged(portId, portInfo.mUsbPortStatus.getDisplayPortAltModeInfo());     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        logAndPrintException(pw, "Caught RemoteException at sendDpAltModeCallbackLocked", e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void enableContaminantDetectionIfNeeded(PortInfo portInfo, IndentingPrintWriter pw) {
        if (this.mConnected.containsKey(portInfo.mUsbPort.getId()) == true) goto L6;
        return;
    L6:
        if (this.mConnected.get(portInfo.mUsbPort.getId()).booleanValue() == true) goto L8;
        return;
    L8:
        if (portInfo.mUsbPortStatus.isConnected() == false) goto L10;
        return;
    L10:
        if (portInfo.mUsbPortStatus.getContaminantDetectionStatus() != 1) goto L15;
        enableContaminantDetection(portInfo.mUsbPort.getId(), true, pw);
        return;
    }

    private void disableLimitPowerTransferIfNeeded(PortInfo portInfo, IndentingPrintWriter pw) {
        if (this.mConnected.containsKey(portInfo.mUsbPort.getId()) == true) goto L6;
        return;
    L6:
        if (this.mConnected.get(portInfo.mUsbPort.getId()).booleanValue() == false) goto L15;
        if (portInfo.mUsbPortStatus.isConnected() == true) goto L18;
        if (portInfo.mUsbPortStatus.isPowerTransferLimited() == false) goto L17;
        String r2 = portInfo.mUsbPort.getId();
        long r4 = this.mTransactionId + 1;
        this.mTransactionId = r4;
        enableLimitPowerTransfer(r2, false, r4, null, pw);
        return;
    L17:
        return;
    L18:
        return;
    }

    private void logToStatsd(PortInfo portInfo, IndentingPrintWriter pw) {
        int r2 = 0;
        if (portInfo.mUsbPortStatus != null) goto L18;
        if (this.mConnected.containsKey(portInfo.mUsbPort.getId()) == false) goto L11;
        if (this.mConnected.get(portInfo.mUsbPort.getId()).booleanValue() == false) goto L9;
        FrameworkStatsLog.write(70, 0, portInfo.mUsbPort.getId(), portInfo.mLastConnectDurationMillis);
    L9:
        this.mConnected.remove(portInfo.mUsbPort.getId());
    L11:
        if (this.mContaminantStatus.containsKey(portInfo.mUsbPort.getId()) == true) goto L13;
        return;
    L13:
        if (this.mContaminantStatus.get(portInfo.mUsbPort.getId()).intValue() != 3) goto L15;
        FrameworkStatsLog.write(146, portInfo.mUsbPort.getId(), convertContaminantDetectionStatusToProto(2));
    L15:
        this.mContaminantStatus.remove(portInfo.mUsbPort.getId());
        return;
    L18:
        if (this.mConnected.containsKey(portInfo.mUsbPort.getId()) == true) goto L20;
    L21:
        this.mConnected.put(portInfo.mUsbPort.getId(), Boolean.valueOf(portInfo.mUsbPortStatus.isConnected()));
        if (portInfo.mUsbPortStatus.isConnected() == false) goto L25;
        r2 = 1;
    L25:
        FrameworkStatsLog.write(70, r2, portInfo.mUsbPort.getId(), portInfo.mLastConnectDurationMillis);
    L27:
        if (this.mContaminantStatus.containsKey(portInfo.mUsbPort.getId()) == true) goto L29;
    L30:
        this.mContaminantStatus.put(portInfo.mUsbPort.getId(), Integer.valueOf(portInfo.mUsbPortStatus.getContaminantDetectionStatus()));
        FrameworkStatsLog.write(146, portInfo.mUsbPort.getId(), convertContaminantDetectionStatusToProto(portInfo.mUsbPortStatus.getContaminantDetectionStatus()));
        return;
    L29:
        if (this.mContaminantStatus.get(portInfo.mUsbPort.getId()).intValue() != portInfo.mUsbPortStatus.getContaminantDetectionStatus()) goto L30;
        return;
    L20:
        if (this.mConnected.get(portInfo.mUsbPort.getId()).booleanValue() == portInfo.mUsbPortStatus.isConnected()) goto L27;
        goto L21
    }

    private void logToStatsdComplianceWarnings(PortInfo portInfo) {
        if (portInfo.mUsbPortStatus != null) goto L5;
        return;
    L5:
        if (portInfo.mUsbPortStatus.getComplianceWarnings().length == 0) goto L10;
        FrameworkStatsLog.write(FrameworkStatsLog.USB_COMPLIANCE_WARNINGS_REPORTED, portInfo.mUsbPort.getId(), toStatsLogConstant(portInfo.mUsbPortStatus.getComplianceWarnings()));
        return;
    }

    public static void logAndPrint(int priority, IndentingPrintWriter pw, String msg) {
        Slog.println(priority, TAG, msg);
        if (pw == null) goto L6;
        pw.println(msg);
        return;
    }

    public static void logAndPrintException(IndentingPrintWriter pw, String msg, Exception e) {
        Slog.e(TAG, msg, e);
        if (pw == null) goto L6;
        pw.println(msg + e);
        return;
    }

    public IExtUsbPortManager getExt() {
        return this.mExt;
    }
}
