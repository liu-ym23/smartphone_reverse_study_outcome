package com.android.server.usb;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.debug.AdbManagerInternal;
import android.debug.AdbNotifications;
import android.debug.IAdbTransport;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.hardware.usb.gadget.V1_0.GadgetFunction;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IHwBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UEventObserver;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.SomeArgs;
import com.android.internal.usb.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.ExtconUEventObserver;
import com.android.server.FgThread;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.job.controllers.JobStatus;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.usb.descriptors.UsbDescriptor;
import com.android.server.usb.hal.gadget.UsbGadgetHal;
import com.android.server.usb.hal.gadget.UsbGadgetHalInstance;
import com.android.server.utils.EventLogger;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class UsbDeviceManager implements ActivityTaskManagerInternal.ScreenObserver {
    private static final int ACCESSORY_HANDSHAKE_TIMEOUT = 10000;
    private static final int ACCESSORY_REQUEST_TIMEOUT = 10000;
    private static final String ACCESSORY_START_MATCH = "DEVPATH=/devices/virtual/misc/usb_accessory";
    private static final String ADB_NOTIFICATION_CHANNEL_ID_TV = "usbdevicemanager.adb.tv";
    private static final String BOOT_MODE_PROPERTY = "ro.bootmode";
    private static final boolean DEBUG = true;
    private static final int DEVICE_STATE_UPDATE_DELAY = 1000;
    private static final int DEVICE_STATE_UPDATE_DELAY_EXT = 3000;
    private static final int DUMPSYS_LOG_BUFFER = 200;
    private static final String FUNCTIONS_PATH = "/sys/class/android_usb/android0/functions";
    private static final int HOST_STATE_UPDATE_DELAY = 1000;
    private static final String MIDI_ALSA_PATH = "/sys/class/android_usb/android0/f_midi/alsa";
    private static final int MIN_SELINUX_GENFS_LABELS_VERSION = 202404;
    private static final int MSG_ACCESSORY_HANDSHAKE_TIMEOUT = 20;
    private static final int MSG_ACCESSORY_MODE_ENTER_TIMEOUT = 8;
    private static final int MSG_BOOT_COMPLETED = 4;
    private static final int MSG_ENABLE_ADB = 1;
    private static final int MSG_FUNCTION_SWITCH_TIMEOUT = 17;
    private static final int MSG_GADGET_HAL_REGISTERED = 18;
    private static final int MSG_GET_CURRENT_USB_FUNCTIONS = 16;
    private static final int MSG_INCREASE_SENDSTRING_COUNT = 21;
    private static final int MSG_LOCALE_CHANGED = 11;
    private static final int MSG_RESET_USB_GADGET = 19;
    private static final int MSG_SET_CHARGING_FUNCTIONS = 14;
    private static final int MSG_SET_CURRENT_FUNCTIONS = 2;
    private static final int MSG_SET_FUNCTIONS_TIMEOUT = 15;
    private static final int MSG_SET_SCREEN_UNLOCKED_FUNCTIONS = 12;
    private static final int MSG_SYSTEM_READY = 3;
    private static final int MSG_UPDATE_CHARGING_STATE = 9;
    private static final int MSG_UPDATE_HAL_VERSION = 23;
    private static final int MSG_UPDATE_HOST_STATE = 10;
    private static final int MSG_UPDATE_PORT_STATE = 7;
    private static final int MSG_UPDATE_SCREEN_LOCK = 13;
    private static final int MSG_UPDATE_STATE = 0;
    private static final int MSG_UPDATE_USB_SPEED = 22;
    private static final int MSG_UPDATE_USER_RESTRICTIONS = 6;
    private static final int MSG_USER_SWITCHED = 5;
    private static final int MSG_USER_UNLOCKED_AFTER_BOOT = 24;
    private static final String NORMAL_BOOT = "normal";
    private static final String RNDIS_ETH_ADDR_PATH = "/sys/class/android_usb/android0/f_rndis/ethaddr";
    private static final String STATE_PATH = "/sys/class/android_usb/android0/state";
    private static final String TAG = null;
    private static final String UDC_SUBSYS_MATCH = "SUBSYSTEM=udc";
    static final String UNLOCKED_CONFIG_PREF = "usb-screen-unlocked-config-%d";
    private static final String USB_CONTROLLER_NAME_PROPERTY = "sys.usb.controller";
    private static final String USB_EVENT_MATCH = "DEVPATH=/devices/virtual/charger/test";
    private static final String USB_PREFS_XML = "UsbDeviceManagerPrefs.xml";
    private static final String USB_STATE_MATCH = "DEVPATH=/devices/virtual/android_usb/android0";
    private static final String USB_STATE_MATCH_SEC = "DEVPATH=/devices/virtual/android_usb/android1";
    private static IExtUsbDeviceManager mExt;
    private static UsbGadgetHal mUsbGadgetHal;
    private static Set<Integer> sDenyInterfaces;
    private static EventLogger sEventLogger;
    private static final AtomicInteger sUsbOperationCount = null;
    private String[] mAccessoryStrings;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private HashMap<Long, FileDescriptor> mControlFds;
    private UsbProfileGroupSettingsManager mCurrentSettings;
    private final boolean mEnableUdcSysfsUsbStateUpdate;
    private UsbHandler mHandler;
    private final boolean mHasUsbAccessory;
    private final Object mLock;
    private final UEventObserver mUEventObserver;
    private String mUdcName;

    static abstract class UsbHandler extends Handler {
        protected static final String MTP_PACKAGE_NAME = "com.android.mtp";
        protected static final String MTP_SERVICE_CLASS_NAME = "com.android.mtp.MtpService";
        protected static final String USB_PERSISTENT_CONFIG_PROPERTY = "persist.sys.usb.config";
        private long mAccessoryConnectionStartTime;
        private boolean mAdbNotificationShown;
        private boolean mAudioAccessoryConnected;
        private boolean mAudioAccessorySupported;
        private boolean mAudioSourceEnabled;
        protected boolean mBootCompleted;
        private Intent mBroadcastedIntent;
        protected boolean mConfigured;
        protected boolean mConnected;
        private boolean mConnectedToDataDisabledPort;
        protected final ContentResolver mContentResolver;
        private final Context mContext;
        private UsbAccessory mCurrentAccessory;
        protected long mCurrentFunctions;
        protected boolean mCurrentFunctionsApplied;
        protected int mCurrentGadgetHalVersion;
        protected boolean mCurrentUsbFunctionsReceived;
        protected int mCurrentUser;
        private boolean mHideUsbNotification;
        private boolean mHostConnected;
        private boolean mInHostModeWithNoAccessoryConnected;
        private boolean mIsMtpServiceBound;
        private int mMidiCard;
        private int mMidiDevice;
        private boolean mMidiEnabled;
        private ServiceConnection mMtpServiceConnection;
        private NotificationManager mNotificationManager;
        protected boolean mPendingBootAccessoryHandshakeBroadcast;
        private boolean mPendingBootBroadcast;
        private final UsbPermissionManager mPermissionManager;
        private int mPowerBrickConnectionStatus;
        protected boolean mResetUsbGadgetDisableDebounce;
        private boolean mScreenLocked;
        protected long mScreenUnlockedFunctions;
        private int mSendStringCount;
        protected SharedPreferences mSettings;
        private boolean mSinkPower;
        private boolean mSourcePower;
        private boolean mStartAccessory;
        private boolean mSupportsAllCombinations;
        private boolean mSystemReady;
        private boolean mUsbAccessoryConnected;
        private final UsbAlsaManager mUsbAlsaManager;
        private boolean mUsbCharging;
        protected final UsbDeviceManager mUsbDeviceManager;
        private int mUsbNotificationId;
        protected int mUsbSpeed;
        protected boolean mUseUsbNotification;
        protected boolean mUserUnlockedAfterBoot;

        private static class AdbTransport extends IAdbTransport.Stub {
            private final UsbHandler mHandler;

            AdbTransport(UsbHandler handler) {
                this.mHandler = handler;
            }

            public void onAdbEnabled(boolean enabled, byte transportType) {
                if (transportType != 0) goto L5;
                int operationId = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
                this.mHandler.sendMessage(1, enabled, operationId);
                return;
            }
        }

        public static /* synthetic */ boolean $r8$lambda$2nuEzuM7OlyuHKynOlppQlNwQYk(File r0, String r1) {
            return lambda$getMidiCardDevice$1(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$fHW3c8yL_XLWe8lUhAR7PSja3_s(File r0, String r1) {
            return lambda$getMidiCardDevice$0(r0, r1);
        }

        public abstract void getUsbSpeedCb(int r1);

        public abstract void handlerInitDone(int r1);

        public abstract void resetCb(int r1);

        public abstract void setCurrentUsbFunctionsCb(long r1, int r3, int r4, long r5, boolean r7);

        protected abstract void setEnabledFunctions(long r1, boolean r3, int r4);

        UsbHandler(Looper looper, Context context, UsbDeviceManager deviceManager, UsbAlsaManager alsaManager, UsbPermissionManager permissionManager) {
            super(looper);
            this.mAccessoryConnectionStartTime = 0;
            boolean r0 = false;
            this.mSendStringCount = 0;
            this.mStartAccessory = false;
            this.mIsMtpServiceBound = false;
            this.mMtpServiceConnection = new AnonymousClass1(this);
            this.mContext = context;
            this.mUsbDeviceManager = deviceManager;
            this.mUsbAlsaManager = alsaManager;
            this.mPermissionManager = permissionManager;
            this.mContentResolver = context.getContentResolver();
            this.mCurrentUser = ActivityManager.getCurrentUser();
            this.mScreenLocked = true;
            this.mSettings = getPinnedSharedPrefs(this.mContext);
            if (this.mSettings != null) goto L5;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Couldn't load shared preferences");
        L6:
            StorageManager storageManager = StorageManager.from(this.mContext);
            if (storageManager == null) goto L9;
            StorageVolume primary = storageManager.getPrimaryVolume();
        L10:
            if (primary != null) goto L12;
        L14:
            boolean massStorageSupported = false;
        L15:
            if (massStorageSupported == false) goto L17;
        L19:
            this.mUseUsbNotification = r0;
            return;
        L17:
            if (this.mContext.getResources().getBoolean(R.bool.config_useRoundIcon) == false) goto L19;
            r0 = true;
            goto L19
        L12:
            if (primary.allowMassStorage() == false) goto L14;
            massStorageSupported = true;
            goto L15
        L9:
            primary = null;
            goto L10
        L5:
            this.mScreenUnlockedFunctions = UsbManager.usbFunctionsFromString(this.mSettings.getString(String.format(Locale.ENGLISH, UsbDeviceManager.UNLOCKED_CONFIG_PREF, new Object[]{Integer.valueOf(this.mCurrentUser)}), ""));
            goto L6
        }

        public void sendMessage(int r2, boolean r3) {
            removeMessages(r2);
            Message r0 = Message.obtain(this, r2);
            r0.arg1 = r3 ? 1 : 0;
            sendMessage(r0);
        }

        public boolean sendMessage(int what) {
            removeMessages(what);
            Message m = Message.obtain(this, what);
            return sendMessageDelayed(m, 0);
        }

        public void sendMessage(int what, int operationId) {
            removeMessages(what);
            Message m = Message.obtain(this, what);
            m.arg1 = operationId;
            sendMessage(m);
        }

        public void sendMessage(int what, Object arg) {
            removeMessages(what);
            Message m = Message.obtain(this, what);
            m.obj = arg;
            sendMessage(m);
        }

        public void sendMessage(int what, Object arg, int operationId) {
            removeMessages(what);
            Message m = Message.obtain(this, what);
            m.obj = arg;
            m.arg1 = operationId;
            sendMessage(m);
        }

        public void sendMessage(int r2, boolean r3, int r4) {
            removeMessages(r2);
            Message r0 = Message.obtain(this, r2);
            r0.arg1 = r3 ? 1 : 0;
            r0.arg2 = r4;
            sendMessage(r0);
        }

        public void sendMessage(int r2, Object r3, boolean r4) {
            removeMessages(r2);
            Message r0 = Message.obtain(this, r2);
            r0.obj = r3;
            r0.arg1 = r4 ? 1 : 0;
            sendMessage(r0);
        }

        public void sendMessage(int r3, long r4, boolean r6, int r7) {
            removeMessages(r3);
            Message r0 = Message.obtain(this, r3);
            r0.obj = Long.valueOf(r4);
            r0.arg1 = r6 ? 1 : 0;
            r0.arg2 = r7;
            sendMessage(r0);
        }

        public void sendMessage(int r2, boolean r3, boolean r4) {
            removeMessages(r2);
            Message r0 = Message.obtain(this, r2);
            r0.arg1 = r3 ? 1 : 0;
            r0.arg2 = r4 ? 1 : 0;
            sendMessage(r0);
        }

        public void sendMessageDelayed(int r2, boolean r3, long r4) {
            removeMessages(r2);
            Message r0 = Message.obtain(this, r2);
            r0.arg1 = r3 ? 1 : 0;
            sendMessageDelayed(r0, r4);
        }

        public void updateState(String state) {
            if ("DISCONNECTED".equals(state) == false) goto L6;
            int connected = 0;
            int configured = 0;
        L12:
            if (connected != 1) goto L14;
            removeMessages(17);
        L14:
            Message msg = Message.obtain(this, 0);
            msg.arg1 = connected;
            msg.arg2 = configured;
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "mResetUsbGadgetDisableDebounce:" + this.mResetUsbGadgetDisableDebounce + " connected:" + connected + "configured:" + configured);
            if (this.mResetUsbGadgetDisableDebounce == false) goto L19;
            sendMessage(msg);
            if (connected != 1) goto L43;
            this.mResetUsbGadgetDisableDebounce = false;
            return;
        L43:
            return;
        L19:
            if (configured != 0) goto L21;
            UsbDeviceManager.m9168$$Nest$sfgetmExt().updateUsbReconnectState(connected, hasMessages(0));
            removeMessages(0);
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "removeMessages MSG_UPDATE_STATE");
        L21:
            if (connected != 1) goto L24;
            removeMessages(17);
        L24:
            if (connected == 0) goto L26;
            long r2 = 0;
        L31:
            sendMessageDelayed(msg, r2);
            return;
        L26:
            if (this.mScreenLocked == false) goto L28;
            int r3 = 1000;
        L29:
            r2 = r3;
            goto L31
        L28:
            r3 = 3000;
            goto L29
        L6:
            if ("CONNECTED".equals(state) == false) goto L9;
            connected = 1;
            configured = 0;
            goto L12
        L9:
            if ("CONFIGURED".equals(state) == false) goto L34;
            connected = 1;
            configured = 1;
            goto L12
        L34:
            if ("ONLINE".equals(state) == false) goto L38;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "usb line is plugged in");
            return;
        L38:
            if ("OFFLINE".equals(state) == false) goto L41;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "usb line is plugged out");
            return;
        L41:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "unknown state " + state);
        }

        public void updateHostState(UsbPort port, UsbPortStatus status) {
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "updateHostState " + port + " status=" + status);
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = port;
            args.arg2 = status;
            removeMessages(7);
            Message msg = obtainMessage(7, args);
            sendMessageDelayed(msg, 1000);
        }

        private void setAdbEnabled(boolean enable, int operationId) {
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "setAdbEnabled: " + enable);
            if (enable == false) goto L5;
            setSystemProperty(USB_PERSISTENT_CONFIG_PROPERTY, "adb");
        L6:
            setEnabledFunctions(this.mCurrentFunctions, true, operationId);
            updateAdbNotification(false);
            return;
        L5:
            setSystemProperty(USB_PERSISTENT_CONFIG_PROPERTY, "");
            goto L6
        }

        protected boolean isUsbTransferAllowed() {
            UserManager userManager = (UserManager) this.mContext.getSystemService("user");
            return !userManager.hasUserRestriction("no_usb_file_transfer");
        }

        private void attachAccessory() {
            this.mUsbDeviceManager.getCurrentSettings().accessoryAttached(this.mCurrentAccessory);
            removeMessages(20);
            broadcastUsbAccessoryHandshake();
        }

        private void updateCurrentAccessory() {
            int operationId = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            boolean enteringAccessoryMode = hasMessages(8);
            if (this.mConfigured == false) goto L13;
            if (enteringAccessoryMode == false) goto L13;
            String[] accessoryStrings = this.mUsbDeviceManager.getAccessoryStrings();
            if (accessoryStrings == null) goto L11;
            UsbSerialReader serialReader = new UsbSerialReader(this.mContext, this.mPermissionManager, accessoryStrings[5]);
            this.mCurrentAccessory = new UsbAccessory(accessoryStrings[0], accessoryStrings[1], accessoryStrings[2], accessoryStrings[3], accessoryStrings[4], serialReader);
            serialReader.setDevice(this.mCurrentAccessory);
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "entering USB accessory mode: " + this.mCurrentAccessory);
            if (this.mUserUnlockedAfterBoot == false) goto L20;
            attachAccessory();
            return;
        L20:
            return;
        L11:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "nativeGetAccessoryStrings failed");
            return;
        L13:
            if (enteringAccessoryMode == true) goto L15;
            notifyAccessoryModeExit(operationId);
            return;
        L15:
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Debouncing accessory mode exit");
        }

        protected void notifyAccessoryModeExit(int operationId) {
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "exited USB accessory mode");
            setEnabledFunctions(0, false, operationId);
            if (this.mCurrentAccessory != null) goto L5;
            return;
        L5:
            if (this.mUserUnlockedAfterBoot == false) goto L7;
            this.mPermissionManager.usbAccessoryRemoved(this.mCurrentAccessory);
        L7:
            this.mCurrentAccessory = null;
        }

        protected SharedPreferences getPinnedSharedPrefs(Context context) {
            File prefsFile = new File(Environment.getDataSystemDeDirectory(0), UsbDeviceManager.USB_PREFS_XML);
            return context.createDeviceProtectedStorageContext().getSharedPreferences(prefsFile, 0);
        }

        private boolean isUsbStateChanged(Intent intent) {
            Set<String> keySet = intent.getExtras().keySet();
            if (this.mBroadcastedIntent != null) goto L13;
            Iterator<String> r1 = keySet.iterator();
        L6:
            if (r1.hasNext() == false) goto L22;
            if (intent.getBooleanExtra(r1.next(), false) == false) goto L6;
            return true;
        L22:
            return false;
        L13:
            if (keySet.equals(this.mBroadcastedIntent.getExtras().keySet()) == true) goto L15;
            return true;
        L15:
            Iterator<String> r2 = keySet.iterator();
        L17:
            if (r2.hasNext() == false) goto L22;
            String key = r2.next();
            if (intent.getBooleanExtra(key, false) == this.mBroadcastedIntent.getBooleanExtra(key, false)) goto L17;
            return true;
        }

        private void broadcastUsbAccessoryHandshake() {
            Intent intent = new Intent("android.hardware.usb.action.USB_ACCESSORY_HANDSHAKE").addFlags(AudioFormat.EVRCB).putExtra("android.hardware.usb.extra.ACCESSORY_UEVENT_TIME", this.mAccessoryConnectionStartTime).putExtra("android.hardware.usb.extra.ACCESSORY_STRING_COUNT", this.mSendStringCount).putExtra("android.hardware.usb.extra.ACCESSORY_START", this.mStartAccessory).putExtra("android.hardware.usb.extra.ACCESSORY_HANDSHAKE_END", SystemClock.elapsedRealtime());
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "broadcasting " + intent + " extras: " + intent.getExtras());
            sendStickyBroadcast(intent);
            resetUsbAccessoryHandshakeDebuggingInfo();
        }

        protected void updateUsbStateBroadcastIfNeeded(long functions) {
            Intent intent = new Intent("android.hardware.usb.action.USB_STATE");
            intent.addFlags(822083584);
            intent.putExtra("connected", this.mConnected);
            intent.putExtra("host_connected", this.mHostConnected);
            intent.putExtra("configured", this.mConfigured);
            if (isUsbTransferAllowed() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            intent.putExtra("unlocked", r1);
            long remainingFunctions = functions;
        L10:
            if (remainingFunctions == 0) goto L13;
            intent.putExtra(UsbManager.usbFunctionsToString(Long.highestOneBit(remainingFunctions)), true);
            remainingFunctions = remainingFunctions - Long.highestOneBit(remainingFunctions);
            goto L10
        L13:
            if (isUsbStateChanged(intent) == true) goto L16;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "skip broadcasting " + intent + " extras: " + intent.getExtras());
            return;
        L16:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "broadcasting " + intent + " extras: " + intent.getExtras());
            sendStickyBroadcast(intent);
            this.mBroadcastedIntent = intent;
            return;
        L5:
            if (isUsbDataTransferActive(this.mCurrentFunctions) == false) goto L7;
            r1 = true;
            goto L8
        }

        protected void sendStickyBroadcast(Intent intent) {
            this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);
            UsbDeviceManager.m9171$$Nest$sfgetsEventLogger().enqueue(new EventLogger.StringEvent("USB intent: " + intent));
        }

        private void getMidiCardDevice() throws FileNotFoundException {
            String controllerName = getSystemProperty(UsbDeviceManager.USB_CONTROLLER_NAME_PROPERTY, "");
            if (TextUtils.isEmpty(controllerName) == true) goto L23;
            File soundDir = new File("/sys/class/udc/" + controllerName + "/gadget/sound");
            if (soundDir.exists() == false) goto L21;
            File[] cardDirs = FileUtils.listFilesOrEmpty(soundDir, new UsbDeviceManager$UsbHandler$$ExternalSyntheticLambda0());
            if (cardDirs.length != 1) goto L19;
            File[] midis = FileUtils.listFilesOrEmpty(cardDirs[0], new UsbDeviceManager$UsbHandler$$ExternalSyntheticLambda1());
            if (midis.length != 1) goto L17;
            Pattern pattern = Pattern.compile("midiC(\\d+)D(\\d+)");
            Matcher matcher = pattern.matcher(midis[0].getName());
            if (matcher.matches() == false) goto L15;
            this.mMidiCard = Integer.parseInt(matcher.group(1));
            this.mMidiDevice = Integer.parseInt(matcher.group(2));
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Found MIDI card " + this.mMidiCard + " device " + this.mMidiDevice);
            return;
        L15:
            throw new FileNotFoundException("MIDI name not match");
        L17:
            throw new FileNotFoundException("MIDI device not match");
        L19:
            throw new FileNotFoundException("sound card not match");
        L21:
            throw new FileNotFoundException("sound device not found");
        L23:
            throw new FileNotFoundException("controller name not found");
        }

        private static /* synthetic */ boolean lambda$getMidiCardDevice$0(File dir, String file) {
            return file.startsWith("card");
        }

        private static /* synthetic */ boolean lambda$getMidiCardDevice$1(File dir, String file) {
            return file.startsWith("midi");
        }

        private void updateUsbFunctions() {
            updateMidiFunction();
            updateMtpFunction();
        }

        private void updateMidiFunction() {
            boolean r1 = false;
            if ((this.mCurrentFunctions & 8) == 0) goto L5;
            boolean enabled = true;
        L7:
            if (enabled == this.mMidiEnabled) goto L31;
            if (enabled == false) goto L30;
            boolean midiDeviceFound = false;
            getMidiCardDevice();     // Catch: FileNotFoundException -> L12
            midiDeviceFound = true;
        L14:
            if (midiDeviceFound == true) goto L28;
            Scanner scanner = null;
            scanner = new Scanner(new File(UsbDeviceManager.MIDI_ALSA_PATH));     // Catch: Throwable -> L19 FileNotFoundException -> L21
            this.mMidiCard = scanner.nextInt();     // Catch: Throwable -> L19 FileNotFoundException -> L21
            this.mMidiDevice = scanner.nextInt();     // Catch: Throwable -> L19 FileNotFoundException -> L21
            midiDeviceFound = true;
        L18:
            scanner.close();
            goto L28
        L19:
            th = move-exception;
            if (scanner == null) goto L27;
            scanner.close();
        L27:
            throw th;
        L21:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "could not open MIDI file", e);     // Catch: Throwable -> L19
            if (scanner != null) goto L18;
        L28:
            if (midiDeviceFound == true) goto L30;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failed to enable MIDI function");
            enabled = false;
        L12:
            e = move-exception;
            Slog.w(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "could not identify MIDI device", e);
        L30:
            this.mMidiEnabled = enabled;
        L31:
            UsbAlsaManager r3 = this.mUsbAlsaManager;
            if (this.mMidiEnabled == true) goto L34;
        L36:
            r3.setPeripheralMidiState(r1, this.mMidiCard, this.mMidiDevice);
            return;
        L34:
            if (this.mConfigured == false) goto L36;
            r1 = true;
            goto L36
        L5:
            enabled = false;
            goto L7
        }

        private void updateMtpFunction() {
            boolean ptpEnabled = false;
            if ((this.mCurrentFunctions & 4) == 0) goto L5;
            boolean mtpEnabled = true;
        L7:
            if ((this.mCurrentFunctions & 16) == 0) goto L9;
            ptpEnabled = true;
        L9:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "updateMtpFunction , mtpEnabled: " + mtpEnabled + ", ptpEnabled: " + ptpEnabled + ", mIsMtpServiceBound: " + this.mIsMtpServiceBound);
            if (this.mConfigured == false) goto L15;
            if (mtpEnabled == true) goto L13;
            if (ptpEnabled == false) goto L15;
        L13:
            bindToMtpService();
            return;
        L15:
            if (this.mIsMtpServiceBound == false) goto L19;
            unbindMtpService();
            return;
        L19:
            return;
        L5:
            mtpEnabled = false;
            goto L7
        }

        private void bindToMtpService() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(MTP_PACKAGE_NAME, MTP_SERVICE_CLASS_NAME));
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Binding to MtpService");
            this.mIsMtpServiceBound = this.mContext.bindServiceAsUser(intent, this.mMtpServiceConnection, 1, UserHandle.CURRENT);     // Catch: SecurityException -> L5
        L8:
            if (this.mIsMtpServiceBound == true) goto L11;
            unbindMtpService();
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Binding to MtpService failed");
        L11:
            if (this.mIsMtpServiceBound == false) goto L16;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Successfully bound to MtpService");
            return;
        L16:
            return;
        L5:
            exception = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Unable to bind to MtpService due to SecurityException", exception);
            goto L8
        }

        private void unbindMtpService() {
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Unbinding from MtpService");
            this.mContext.unbindService(this.mMtpServiceConnection);
            this.mIsMtpServiceBound = false;
        }

        private void setScreenUnlockedFunctions(int operationId) {
            setEnabledFunctions(this.mScreenUnlockedFunctions, false, operationId);
        }

        long getAppliedFunctions(long functions) {
            if (functions != 0) goto L7;
            return getChargingFunctions();
        L7:
            if (isAdbEnabled() == true) goto L9;
            return functions;
        L9:
            return 1 | functions;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean r7 = false;
            boolean r8 = true;
            switch(msg.what) {
                case 0: goto L158;
                case 1: goto L155;
                case 2: goto L153;
                case 3: goto L149;
                case 4: goto L148;
                case 5: goto L142;
                case 6: goto L137;
                case 7: goto L84;
                case 8: goto L79;
                case 9: goto L75;
                case 10: goto L52;
                case 11: goto L51;
                case 12: goto L42;
                case 13: goto L18;
                case 14: goto L236;
                case 15: goto L236;
                case 16: goto L236;
                case 17: goto L236;
                case 18: goto L236;
                case 19: goto L236;
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L236;
                case 23: goto L236;
                case 24: goto L5;
                default: goto L236;
            };
        L5:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "MSG_USER_UNLOCKED_AFTER_BOOT");
            if (this.mUserUnlockedAfterBoot == true) goto L237;
            this.mUserUnlockedAfterBoot = true;
            if (this.mCurrentUsbFunctionsReceived == true) goto L11;
            return;
        L11:
            if (this.mUserUnlockedAfterBoot == false) goto L207;
            attachAccessoryAfterBoot();
            return;
        L207:
            return;
        L237:
            return;
        L13:
            this.mSendStringCount++;
            return;
        L14:
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Accessory handshake timeout");
            if (this.mBootCompleted == false) goto L17;
            broadcastUsbAccessoryHandshake();
            return;
        L17:
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Pending broadcasting intent as not boot completed yet.");
            this.mPendingBootAccessoryHandshakeBroadcast = true;
            return;
        L18:
            int operationId = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (msg.arg1 != 1) goto L21;
            boolean r1 = true;
        L23:
            if (r1 != this.mScreenLocked) goto L26;
            return;
        L26:
            if (msg.arg1 == 1) goto L29;
            r8 = false;
        L29:
            this.mScreenLocked = r8;
            if (this.mBootCompleted == true) goto L33;
            return;
        L33:
            if (this.mScreenLocked == false) goto L38;
            if (this.mConnected == true) goto L212;
            setEnabledFunctions(0, false, operationId);
            return;
        L212:
            return;
        L38:
            if (this.mScreenUnlockedFunctions != 0) goto L40;
            return;
        L40:
            if (this.mCurrentFunctions != 0) goto L215;
            setScreenUnlockedFunctions(operationId);
            return;
        L215:
            return;
        L21:
            r1 = false;
            goto L23
        L42:
            int operationId2 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            this.mScreenUnlockedFunctions = ((Long) msg.obj).longValue();
            if (this.mSettings == null) goto L46;
            SharedPreferences.Editor editor = this.mSettings.edit();
            editor.putString(String.format(Locale.ENGLISH, UsbDeviceManager.UNLOCKED_CONFIG_PREF, new Object[]{Integer.valueOf(this.mCurrentUser)}), UsbManager.usbFunctionsToString(this.mScreenUnlockedFunctions));
            editor.commit();
        L46:
            if (this.mScreenLocked == false) goto L48;
        L50:
            setEnabledFunctions(0, false, operationId2);
            return;
        L48:
            if (this.mScreenUnlockedFunctions == 0) goto L50;
            setScreenUnlockedFunctions(operationId2);
            return;
        L51:
            updateAdbNotification(true);
            updateUsbNotification(true);
            return;
        L52:
            Iterator devices = (Iterator) msg.obj;
            if (msg.arg1 != 1) goto L55;
            boolean r2 = true;
        L56:
            this.mUsbAccessoryConnected = r2;
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "HOST_STATE connected:" + this.mUsbAccessoryConnected);
            if (devices.hasNext() == true) goto L59;
            this.mInHostModeWithNoAccessoryConnected = true;
        L60:
            this.mHideUsbNotification = false;
        L62:
            if (devices.hasNext() == false) goto L73;
            Map.Entry pair = (Map.Entry) devices.next();
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), pair.getKey() + " = " + pair.getValue());
            UsbDevice device = (UsbDevice) pair.getValue();
            int configurationCount = device.getConfigurationCount() - 1;
        L64:
            if (configurationCount < 0) goto L62;
            UsbConfiguration config = device.getConfiguration(configurationCount);
            configurationCount = configurationCount - 1;
            int interfaceCount = config.getInterfaceCount() - 1;
        L66:
            if (interfaceCount < 0) goto L64;
            UsbInterface intrface = config.getInterface(interfaceCount);
            interfaceCount = interfaceCount - 1;
            if (UsbDeviceManager.m9170$$Nest$sfgetsDenyInterfaces().contains(Integer.valueOf(intrface.getInterfaceClass())) == false) goto L66;
            this.mHideUsbNotification = true;
            goto L64
        L73:
            updateUsbNotification(false);
            return;
        L59:
            this.mInHostModeWithNoAccessoryConnected = false;
            goto L60
        L55:
            r2 = false;
            goto L56
        L79:
            int operationId3 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Accessory mode enter timeout: " + this.mConnected + " ,operationId: " + operationId3);
            if (this.mConnected == true) goto L82;
        L83:
            notifyAccessoryModeExit(operationId3);
            return;
        L82:
            if ((2 & this.mCurrentFunctions) == 0) goto L83;
            return;
        L84:
            SomeArgs args = (SomeArgs) msg.obj;
            boolean prevHostConnected = this.mHostConnected;
            UsbPort port = (UsbPort) args.arg1;
            UsbPortStatus status = (UsbPortStatus) args.arg2;
            if (status != null) goto L87;
            this.mHostConnected = false;
            this.mSourcePower = false;
            this.mSinkPower = false;
            this.mAudioAccessoryConnected = false;
            this.mSupportsAllCombinations = false;
            this.mConnectedToDataDisabledPort = false;
            this.mPowerBrickConnectionStatus = 0;
        L124:
            if (this.mHostConnected == true) goto L126;
            this.mInHostModeWithNoAccessoryConnected = false;
        L130:
            this.mAudioAccessorySupported = port.isModeSupported(4);
            args.recycle();
            updateUsbNotification(false);
            if (this.mBootCompleted == true) goto L133;
            this.mPendingBootBroadcast = true;
            return;
        L133:
            if (this.mHostConnected == true) goto L135;
            if (prevHostConnected == true) goto L135;
            return;
        L135:
            updateUsbStateBroadcastIfNeeded(getAppliedFunctions(this.mCurrentFunctions));
            return;
        L126:
            if (this.mUsbAccessoryConnected == true) goto L128;
            this.mInHostModeWithNoAccessoryConnected = true;
            goto L130
        L128:
            this.mInHostModeWithNoAccessoryConnected = false;
            goto L130
        L87:
            if (status.getCurrentDataRole() != 1) goto L89;
            boolean r5 = true;
        L90:
            this.mHostConnected = r5;
            if (status.getCurrentPowerRole() != 1) goto L93;
            boolean r6 = true;
        L94:
            this.mSourcePower = r6;
            if (status.getCurrentPowerRole() != 2) goto L97;
            boolean r9 = true;
        L98:
            this.mSinkPower = r9;
            if (status.getCurrentMode() != 4) goto L101;
            boolean r10 = true;
        L102:
            this.mAudioAccessoryConnected = r10;
            if (status.isRoleCombinationSupported(1, 1) == true) goto L105;
        L111:
            boolean r11 = false;
        L112:
            this.mSupportsAllCombinations = r11;
            if (status.getUsbDataStatus() == 1) goto L115;
            boolean usbDataDisabled = true;
        L117:
            if (status.isConnected() == false) goto L120;
            if (usbDataDisabled == false) goto L120;
            boolean r12 = true;
        L121:
            this.mConnectedToDataDisabledPort = r12;
            this.mPowerBrickConnectionStatus = status.getPowerBrickConnectionStatus();
        L120:
            r12 = false;
            goto L121
        L115:
            usbDataDisabled = false;
            goto L117
        L105:
            if (status.isRoleCombinationSupported(2, 1) == false) goto L111;
            if (status.isRoleCombinationSupported(1, 2) == false) goto L111;
            if (status.isRoleCombinationSupported(2, 2) == false) goto L111;
            r11 = true;
            goto L112
        L101:
            r10 = false;
            goto L102
        L97:
            r9 = false;
            goto L98
        L93:
            r6 = false;
            goto L94
        L89:
            r5 = false;
            goto L90
        L137:
            int operationId4 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (isUsbDataTransferActive(this.mCurrentFunctions) == true) goto L140;
            return;
        L140:
            if (isUsbTransferAllowed() == true) goto L228;
            setEnabledFunctions(0, true, operationId4);
            return;
        L228:
            return;
        L142:
            int operationId5 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (this.mCurrentUser == msg.arg1) goto L230;
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Current user switched to " + msg.arg1);
            this.mCurrentUser = msg.arg1;
            this.mScreenLocked = true;
            this.mScreenUnlockedFunctions = 0;
            if (this.mSettings == null) goto L147;
            this.mScreenUnlockedFunctions = UsbManager.usbFunctionsFromString(this.mSettings.getString(String.format(Locale.ENGLISH, UsbDeviceManager.UNLOCKED_CONFIG_PREF, new Object[]{Integer.valueOf(this.mCurrentUser)}), ""));
        L147:
            setEnabledFunctions(0, false, operationId5);
            return;
        L230:
            return;
        L148:
            int operationId6 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            this.mBootCompleted = true;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "MSG_BOOT_COMPLETED");
            finishBoot(operationId6);
            return;
        L149:
            int operationId7 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            ((AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class)).registerTransport(new AdbTransport(this));
            if (isTv() == false) goto L152;
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(UsbDeviceManager.ADB_NOTIFICATION_CHANNEL_ID_TV, this.mContext.getString(R.string.aerr_process), 4));
        L152:
            this.mSystemReady = true;
            finishBoot(operationId7);
            return;
        L153:
            long functions = ((Long) msg.obj).longValue();
            setEnabledFunctions(functions, false, msg.arg1);
            return;
        L158:
            int operationId8 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (msg.arg1 != 1) goto L161;
            boolean r3 = true;
        L162:
            this.mConnected = r3;
            if (msg.arg2 != 1) goto L165;
            boolean r4 = true;
        L166:
            this.mConfigured = r4;
            if (UsbDeviceManager.m9168$$Nest$sfgetmExt().handleUsbDialogRestoreState(this.mConnected, this.mConfigured) == true) goto L169;
        L174:
            UsbDeviceManager.m9168$$Nest$sfgetmExt().updateConnectionState(this.mConnected);
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "handleMessage MSG_UPDATE_STATE mConnected:" + this.mConnected + " mConfigured:" + this.mConfigured);
            updateUsbNotification(false);
            updateAdbNotification(false);
            if (this.mBootCompleted == false) goto L178;
            updateUsbStateBroadcastIfNeeded(getAppliedFunctions(this.mCurrentFunctions));
        L178:
            if ((2 & this.mCurrentFunctions) == 0) goto L181;
            updateCurrentAccessory();
        L181:
            if (this.mBootCompleted == true) goto L183;
            this.mPendingBootBroadcast = true;
        L196:
            updateUsbSpeed();
            return;
        L183:
            if (this.mConnected == false) goto L185;
        L194:
            updateUsbFunctions();
            goto L196
        L185:
            if (hasMessages(8) == true) goto L194;
            if (hasMessages(17) == true) goto L194;
            if (this.mScreenLocked == false) goto L191;
        L193:
            setEnabledFunctions(0, false, operationId8);
            goto L194
        L191:
            if (this.mScreenUnlockedFunctions == 0) goto L193;
            setScreenUnlockedFunctions(operationId8);
            goto L194
        L169:
            if (this.mUsbNotificationId != 0) goto L171;
        L173:
            this.mUsbNotificationId = 0;
            UsbDeviceManager.m9168$$Nest$sfgetmExt().updateConnectionState(false);
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Rapid connect/disconnect detected, state reset");
            goto L174
        L171:
            if (this.mNotificationManager == null) goto L173;
            this.mNotificationManager.cancelAsUser(null, this.mUsbNotificationId, UserHandle.ALL);
            goto L173
        L165:
            r4 = false;
            goto L166
        L161:
            r3 = false;
            goto L162
        L236:
            return;
        L75:
            if (msg.arg1 == 1) goto L78;
            r8 = false;
        L78:
            this.mUsbCharging = r8;
            updateUsbNotification(false);
            return;
        L155:
            if (msg.arg1 != 1) goto L157;
            r7 = true;
        L157:
            setAdbEnabled(r7, msg.arg2);
        }

        private void attachAccessoryAfterBoot() {
            if (this.mCurrentAccessory == null) goto L6;
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "AccessoryAttached");
            this.mUsbDeviceManager.getCurrentSettings().accessoryAttached(this.mCurrentAccessory);
            broadcastUsbAccessoryHandshake();
        L8:
            this.mPendingBootAccessoryHandshakeBroadcast = false;
            return;
        L6:
            if (this.mPendingBootAccessoryHandshakeBroadcast == false) goto L8;
            broadcastUsbAccessoryHandshake();
            goto L8
        }

        protected void finishBoot(int operationId) {
            if (this.mBootCompleted == true) goto L5;
            return;
        L5:
            if (this.mCurrentUsbFunctionsReceived == true) goto L7;
            return;
        L7:
            if (this.mSystemReady == false) goto L24;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "finishBoot all flags true");
            if (this.mPendingBootBroadcast == false) goto L12;
            updateUsbStateBroadcastIfNeeded(getAppliedFunctions(this.mCurrentFunctions));
            this.mPendingBootBroadcast = false;
        L12:
            if (this.mScreenLocked == false) goto L14;
        L16:
            setEnabledFunctions(0, false, operationId);
        L18:
            if (this.mUserUnlockedAfterBoot == false) goto L20;
            attachAccessoryAfterBoot();
        L20:
            updateUsbNotification(false);
            updateAdbNotification(false);
            updateUsbFunctions();
            return;
        L14:
            if (this.mScreenUnlockedFunctions == 0) goto L16;
            setScreenUnlockedFunctions(operationId);
            goto L18
        }

        protected boolean isUsbDataTransferActive(long functions) {
            if ((4 & functions) == 0) goto L5;
        L8:
            return true;
        L5:
            if ((16 & functions) != 0) goto L8;
            return false;
        }

        public UsbAccessory getCurrentAccessory() {
            return this.mCurrentAccessory;
        }

        protected void updateUsbGadgetHalVersion() {
            sendMessage(23, null);
        }

        protected void updateUsbSpeed() {
            if (this.mCurrentGadgetHalVersion >= 10) goto L7;
            this.mUsbSpeed = -1;
            return;
        L7:
            if (this.mConnected == true) goto L9;
        L11:
            this.mUsbSpeed = -1;
            return;
        L9:
            if (this.mConfigured == false) goto L11;
            sendMessage(22, null);
        }

        protected void updateUsbNotification(boolean force) {
            if (this.mNotificationManager != null) goto L5;
            return;
        L5:
            if (this.mUseUsbNotification == true) goto L7;
            return;
        L7:
            if ("0".equals(getSystemProperty("persist.charging.notify", "")) == true) goto L118;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "updateUsbNotification mAudioAccessoryConnected = " + this.mAudioAccessoryConnected);
            if (this.mAudioAccessoryConnected == true) goto L109;
            if (this.mHideUsbNotification == true) goto L16;
            if (this.mInHostModeWithNoAccessoryConnected == true) goto L16;
        L18:
            int id = 0;
            int titleRes = 0;
            Resources r = this.mContext.getResources();
            CharSequence message = r.getText(17042304);
            if (this.mAudioAccessoryConnected == false) goto L24;
            if (this.mAudioAccessorySupported == true) goto L24;
            titleRes = 17042317;
            id = 41;
        L76:
            if (id != this.mUsbNotificationId) goto L79;
            if (force == true) goto L79;
            return;
        L79:
            if (this.mUsbNotificationId == 0) goto L82;
            this.mNotificationManager.cancelAsUser(null, this.mUsbNotificationId, UserHandle.ALL);
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Clear notification");
            this.mUsbNotificationId = 0;
        L82:
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == true) goto L86;
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == true) goto L86;
        L89:
            if (id != 0) goto L91;
            return;
        L91:
            if (this.mHostConnected == true) goto L115;
            CharSequence title = r.getText(titleRes);
            PendingIntent pi = null;
            if (titleRes == 17042317) goto L95;
            String channel = ExtconUEventObserver.ExtconInfo.EXTCON_USB;
        L100:
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.allowDuringSetup", true);
            Notification.Builder builder = new Notification.Builder(this.mContext, channel).setSmallIcon(17305206).setWhen(0).setOngoing(true).setTicker(title).setDefaults(0).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setContentIntent(pi).setSound(null, null).setVibrate(null).setPriority(-2).setExtras(bundle).setVisibility(1);
            if (titleRes != 17042317) goto L104;
            builder.setStyle(new Notification.BigTextStyle().bigText(message));
        L104:
            if (titleRes == 17042317) goto L106;
            builder.setContentText(r.getText(17042304));
            Intent intent = Intent.makeRestartActivityTask(new ComponentName("com.android.settings", "com.android.settings.UsbSettings"));
            PendingIntent pi2 = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 67108864, null, UserHandle.CURRENT);
            builder.setContentIntent(pi2);
            UsbDeviceManager.m9168$$Nest$sfgetmExt().startUsbSettingsActivity(intent, this.mContext);
        L106:
            Notification notification = builder.build();
            this.mNotificationManager.notifyAsUser(null, id, notification, UserHandle.ALL);
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "push notification:" + title);
            this.mUsbNotificationId = id;
            return;
        L95:
            Intent intent2 = new Intent();
            intent2.setClassName("com.android.settings", "com.android.settings.HelpTrampoline");
            intent2.putExtra("android.intent.extra.TEXT", "help_url_audio_accessory_not_supported");
            if (this.mContext.getPackageManager().resolveActivity(intent2, 0) == null) goto L98;
            pi = PendingIntent.getActivity(this.mContext, 0, intent2, 67108864);
        L99:
            message = r.getText(17042316);
            channel = "ALERTS";
            goto L100
        L98:
            pi = null;
            goto L99
        L115:
            return;
        L86:
            if (id != 32) goto L89;
            this.mUsbNotificationId = 0;
            return;
        L24:
            if (this.mConnected == false) goto L57;
            if (this.mCurrentFunctions != 4) goto L29;
            titleRes = 17042303;
            id = 27;
        L50:
            if (this.mSourcePower == false) goto L54;
            if (titleRes == 0) goto L53;
            message = r.getText(17042306);
            goto L76
        L53:
            titleRes = 17042312;
            id = 31;
            goto L76
        L54:
            if (titleRes != 0) goto L76;
            titleRes = 17042288;
            id = 32;
            goto L76
        L29:
            if (this.mCurrentFunctions != 16) goto L32;
            titleRes = 17042307;
            id = 28;
            goto L50
        L32:
            if (this.mCurrentFunctions != 8) goto L35;
            titleRes = 17042296;
            id = 29;
            goto L50
        L35:
            if (this.mCurrentFunctions != 32) goto L37;
        L48:
            titleRes = 17042313;
            id = 47;
            goto L50
        L37:
            if (this.mCurrentFunctions == DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) goto L48;
            if (this.mCurrentFunctions != 128) goto L43;
            titleRes = 17042318;
            id = 75;
            goto L50
        L43:
            if (this.mCurrentFunctions != 2) goto L46;
            titleRes = 17042279;
            id = 30;
            goto L50
        L46:
            if ((this.mCurrentFunctions & 64) == 0) goto L50;
            titleRes = 17042284;
            id = 90;
            goto L50
        L57:
            if (this.mSourcePower == false) goto L60;
            titleRes = 17042312;
            id = 31;
            goto L76
        L60:
            if (this.mHostConnected == false) goto L69;
            if (this.mSinkPower == false) goto L69;
            if (this.mUsbCharging == false) goto L66;
        L67:
            titleRes = 17042288;
            id = 32;
            goto L76
        L66:
            if (this.mUsbAccessoryConnected == true) goto L67;
        L69:
            if (this.mSinkPower == false) goto L76;
            if (this.mConnectedToDataDisabledPort == false) goto L76;
            if (this.mPowerBrickConnectionStatus == 1) goto L76;
            titleRes = 17042288;
            id = 32;
        L16:
            if (this.mSupportsAllCombinations == true) goto L18;
        L109:
            if (this.mUsbNotificationId == 0) goto L116;
            this.mNotificationManager.cancelAsUser(null, this.mUsbNotificationId, UserHandle.ALL);
            this.mUsbNotificationId = 0;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Clear notification");
            return;
        L116:
            return;
        }

        protected boolean isAdbEnabled() {
            return ((AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class)).isAdbEnabled((byte) 0);
        }

        protected void updateAdbNotification(boolean force) {
            if (this.mNotificationManager != null) goto L6;
            return;
        L6:
            if (isAdbEnabled() == false) goto L20;
            if (this.mConnected == false) goto L20;
            if ("0".equals(getSystemProperty("persist.adb.notify", "")) == false) goto L12;
            return;
        L12:
            if (force == false) goto L17;
            if (this.mAdbNotificationShown == false) goto L17;
            this.mAdbNotificationShown = false;
            this.mNotificationManager.cancelAsUser(null, 26, UserHandle.ALL);
        L17:
            if (this.mAdbNotificationShown == true) goto L23;
            Notification notification = AdbNotifications.createNotification(this.mContext, (byte) 0);
            this.mAdbNotificationShown = true;
            this.mNotificationManager.notifyAsUser(null, 26, notification, UserHandle.ALL);
            return;
        L23:
            return;
        L20:
            if (this.mAdbNotificationShown == false) goto L25;
            this.mAdbNotificationShown = false;
            this.mNotificationManager.cancelAsUser(null, 26, UserHandle.ALL);
            return;
        }

        private boolean isTv() {
            return this.mContext.getPackageManager().hasSystemFeature("android.software.leanback");
        }

        protected long getChargingFunctions() {
            if (isAdbEnabled() == false) goto L6;
            return 1;
        L6:
            return 4;
        }

        protected void setSystemProperty(String prop, String val) {
            SystemProperties.set(prop, val);
        }

        protected String getSystemProperty(String prop, String def) {
            return SystemProperties.get(prop, def);
        }

        protected void putGlobalSettings(ContentResolver contentResolver, String setting, int val) {
            Settings.Global.putInt(contentResolver, setting, val);
        }

        public long getEnabledFunctions() {
            return this.mCurrentFunctions;
        }

        public long getScreenUnlockedFunctions() {
            return this.mScreenUnlockedFunctions;
        }

        public int getUsbSpeed() {
            return this.mUsbSpeed;
        }

        public int getGadgetHalVersion() {
            return this.mCurrentGadgetHalVersion;
        }

        private void dumpFunctions(DualDumpOutputStream dump, String idName, long id, long functions) {
            int i = 0;
        L4:
            if (i >= 63) goto L13;
            if (((1 << i) & functions) == 0) goto L11;
            if (dump.isProto() == false) goto L10;
            dump.write(idName, id, 1 << i);
            goto L11
        L10:
            dump.write(idName, id, GadgetFunction.toString(1 << i));
        L11:
            i = i + 1;
            goto L4
        }

        public void dump(DualDumpOutputStream dump, String idName, long id) {
            long token = dump.start(idName, id);
            dumpFunctions(dump, "current_functions", 2259152797697L, this.mCurrentFunctions);
            dump.write("current_functions_applied", 1133871366146L, this.mCurrentFunctionsApplied);
            dumpFunctions(dump, "screen_unlocked_functions", 2259152797699L, this.mScreenUnlockedFunctions);
            dump.write("screen_locked", 1133871366148L, this.mScreenLocked);
            dump.write("connected", 1133871366149L, this.mConnected);
            dump.write("configured", 1133871366150L, this.mConfigured);
            if (this.mCurrentAccessory == null) goto L5;
            DumpUtils.writeAccessory(dump, "current_accessory", 1146756268039L, this.mCurrentAccessory);
        L5:
            dump.write("host_connected", 1133871366152L, this.mHostConnected);
            dump.write("source_power", 1133871366153L, this.mSourcePower);
            dump.write("sink_power", 1133871366154L, this.mSinkPower);
            dump.write("usb_charging", 1133871366155L, this.mUsbCharging);
            dump.write("hide_usb_notification", 1133871366156L, this.mHideUsbNotification);
            dump.write("audio_accessory_connected", 1133871366157L, this.mAudioAccessoryConnected);
            com.android.internal.util.dump.DumpUtils.writeStringIfNotNull(dump, "kernel_state", 1138166333455L, FileUtils.readTextFile(new File(UsbDeviceManager.STATE_PATH), 0, null).trim());     // Catch: Exception -> L8 FileNotFoundException -> L10
        L24:
            com.android.internal.util.dump.DumpUtils.writeStringIfNotNull(dump, "kernel_function_list", 1138166333456L, FileUtils.readTextFile(new File(UsbDeviceManager.FUNCTIONS_PATH), 0, null).trim());     // Catch: Exception -> L16 FileNotFoundException -> L18
        L22:
            dump.end(token);
            return;
        L16:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Could not read kernel function list", e);
        L21:
            Slog.w(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Ignore missing legacy kernel path in bugreport dump: kernel function list:/sys/class/android_usb/android0/functions");
            goto L22
        L8:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Could not read kernel state", e);
        L13:
            Slog.w(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Ignore missing legacy kernel path in bugreport dump: kernel state:/sys/class/android_usb/android0/state");
            goto L24
        }

        public void setAccessoryUEventTime(long accessoryConnectionStartTime) {
            this.mAccessoryConnectionStartTime = accessoryConnectionStartTime;
        }

        public void setStartAccessoryTrue() {
            this.mStartAccessory = true;
        }

        public void resetUsbAccessoryHandshakeDebuggingInfo() {
            this.mAccessoryConnectionStartTime = 0;
            this.mSendStringCount = 0;
            this.mStartAccessory = false;
        }
    }

    private static final class UsbHandlerHal extends UsbHandler {
        private static final int ENUMERATION_TIME_OUT_MS = 2000;
        protected static final String GADGET_HAL_FQ_NAME = "android.hardware.usb.gadget@1.0::IUsbGadget";
        private static final int SET_FUNCTIONS_LEEWAY_MS = 500;
        private static final int SET_FUNCTIONS_TIMEOUT_MS = 3000;
        private static final int USB_GADGET_HAL_DEATH_COOKIE = 2000;
        private int mCurrentRequest;
        protected boolean mCurrentUsbFunctionsRequested;
        private final Object mGadgetProxyLock;

        final class ServiceNotification extends IServiceNotification.Stub {
            final /* synthetic */ UsbHandlerHal this$0;

            ServiceNotification(UsbHandlerHal this$0) {
                this.this$0 = this$0;
            }

            @Override // android.hidl.manager.V1_0.IServiceNotification
            public void onRegistration(String fqName, String name, boolean preexisting) {
                Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Usb gadget hal service started " + fqName + " " + name);
                if (fqName.equals(UsbHandlerHal.GADGET_HAL_FQ_NAME) == true) goto L6;
                Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "fqName does not match");
                return;
            L6:
                this.this$0.sendMessage(18, preexisting);
            }
        }

        final class UsbGadgetDeathRecipient implements IHwBinder.DeathRecipient {
            final /* synthetic */ UsbHandlerHal this$0;

            UsbGadgetDeathRecipient(UsbHandlerHal this$0) {
                this.this$0 = this$0;
            }

            public void serviceDied(long cookie) {
                if (cookie != ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L13;
                Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Usb Gadget hal service died cookie: " + cookie);
                Object r0 = UsbHandlerHal.m9174$$Nest$fgetmGadgetProxyLock(this.this$0);
                monitor-enter(r0);
                UsbDeviceManager.m9173$$Nest$sfputmUsbGadgetHal(null);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGadgetProxyLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m9174$$Nest$fgetmGadgetProxyLock(UsbHandlerHal r0) {
            return r0.mGadgetProxyLock;
        }

        UsbHandlerHal(Looper looper, Context context, UsbDeviceManager deviceManager, UsbAlsaManager alsaManager, UsbPermissionManager permissionManager) {
            super(looper, context, deviceManager, alsaManager, permissionManager);
            this.mGadgetProxyLock = new Object();
            this.mCurrentRequest = 0;
            UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            Object r3 = this.mGadgetProxyLock;     // Catch: Exception -> L10 NoSuchElementException -> L12
            monitor-enter(r3);     // Catch: Exception -> L10 NoSuchElementException -> L12
            this.mCurrentFunctions = 0;     // Catch: Throwable -> L14
            this.mCurrentUsbFunctionsRequested = true;     // Catch: Throwable -> L14
            this.mUsbSpeed = -1;     // Catch: Throwable -> L14
            this.mCurrentGadgetHalVersion = 10;     // Catch: Throwable -> L14
            updateUsbGadgetHalVersion();     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            String state = FileUtils.readTextFile(new File(UsbDeviceManager.STATE_PATH), 0, null).trim();     // Catch: Exception -> L10 NoSuchElementException -> L12
            updateState(state);     // Catch: Exception -> L10 NoSuchElementException -> L12
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Exception -> L10 NoSuchElementException -> L12
        L12:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Usb gadget hal not found", e);
            return;
        L10:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Error initializing UsbHandler", e);
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler, android.os.Handler
        public void handleMessage(Message msg) {
            boolean r1 = false;
            boolean r2 = true;
            switch(msg.what) {
                case 14: goto L80;
                case 15: goto L77;
                case 16: goto L70;
                case 17: goto L64;
                case 18: goto L43;
                case 19: goto L19;
                case 20: goto L4;
                case 21: goto L4;
                case 22: goto L12;
                case 23: goto L6;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L12:
            int operationId = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal() != null) goto L85;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "mGadgetHal is null, operationId:" + operationId);
            return;
        L85:
            UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal().getUsbSpeed(operationId);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "get UsbSpeed failed", e);
            return;
        L19:
            int operationId2 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            Object r3 = this.mGadgetProxyLock;
            monitor-enter(r3);
        L26:
            th = move-exception;
            throw th;
        L22:
            if (UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal() != null) goto L90;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "reset Usb Gadget mUsbGadgetHal is null");     // Catch: Throwable -> L26
            monitor-exit(r3);     // Catch: Throwable -> L26
            return;
        L90:
            removeMessages(8);     // Catch: Throwable -> L26 Exception -> L32
            if (this.mConfigured == false) goto L34;
            this.mResetUsbGadgetDisableDebounce = true;     // Catch: Throwable -> L26 Exception -> L32
        L34:
            UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal().reset(operationId2);     // Catch: Throwable -> L26 Exception -> L32
        L38:
            monitor-exit(r3);     // Catch: Throwable -> L26
            return;
        L32:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "reset Usb Gadget failed", e);     // Catch: Throwable -> L26
            this.mResetUsbGadgetDisableDebounce = false;     // Catch: Throwable -> L26
            goto L38
        L64:
            int operationId3 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            if (msg.arg1 != 1) goto L67;
            return;
        L67:
            if (this.mCurrentFunctions != 2) goto L69;
            notifyAccessoryModeExit(operationId3);
            return;
        L69:
            setEnabledFunctions(this.mScreenUnlockedFunctions, false, operationId3);
            return;
        L70:
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "processing MSG_GET_CURRENT_USB_FUNCTIONS");
            this.mCurrentUsbFunctionsReceived = true;
            int operationId4 = msg.arg2;
            if (this.mCurrentUsbFunctionsRequested == false) goto L76;
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "updating mCurrentFunctions");
            this.mCurrentFunctions = ((Long) msg.obj).longValue() & (-2);
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "mCurrentFunctions:" + this.mCurrentFunctions + "applied:" + msg.arg1);
            if (msg.arg1 != 1) goto L75;
            r1 = true;
        L75:
            this.mCurrentFunctionsApplied = r1;
        L76:
            finishBoot(operationId4);
            return;
        L77:
            int operationId5 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Set functions timed out! no reply from usb hal ,operationId:" + operationId5);
            if (msg.arg1 == 1) goto L103;
            setEnabledFunctions(this.mScreenUnlockedFunctions, false, operationId5);
            return;
        L103:
            return;
        L80:
            setEnabledFunctions(0, false, UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet());
            return;
        L6:
            if (UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal() != null) goto L88;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "mUsbGadgetHal is null");
            return;
        L88:
            this.mCurrentGadgetHalVersion = UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal().getGadgetHalVersion();     // Catch: RemoteException -> L10
            return;
        L10:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "update Usb gadget version failed", e);
            return;
        L43:
            if (msg.arg1 == 1) goto L46;
            r2 = false;
        L46:
            boolean preexisting = r2;
            int operationId6 = UsbDeviceManager.m9172$$Nest$sfgetsUsbOperationCount().incrementAndGet();
            Object r4 = this.mGadgetProxyLock;
            monitor-enter(r4);
            UsbDeviceManager.m9173$$Nest$sfputmUsbGadgetHal(UsbGadgetHalInstance.getInstance(this.mUsbDeviceManager, null));     // Catch: Throwable -> L53 NoSuchElementException -> L55
            if (this.mCurrentFunctionsApplied == true) goto L60;
            if (preexisting == true) goto L60;
            setEnabledFunctions(this.mCurrentFunctions, false, operationId6);     // Catch: Throwable -> L53 NoSuchElementException -> L55
        L60:
            monitor-exit(r4);     // Catch: Throwable -> L53
            return;
        L55:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Usb gadget hal not found", e);     // Catch: Throwable -> L53
        L53:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void setCurrentUsbFunctionsCb(long functions, int status, int mRequest, long mFunctions, boolean mChargingFunctions) {
            if (this.mCurrentRequest == mRequest) goto L5;
            return;
        L5:
            if (hasMessages(15) == true) goto L7;
            return;
        L7:
            if (mFunctions != functions) goto L19;
            removeMessages(15);
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "notifyCurrentFunction request:" + mRequest + " status:" + status);
            if (status != 0) goto L12;
            this.mCurrentFunctionsApplied = true;
            return;
        L12:
            if (mChargingFunctions == true) goto L17;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Setting default fuctions");
            sendEmptyMessage(14);
            return;
        L17:
            return;
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void getUsbSpeedCb(int speed) {
            this.mUsbSpeed = speed;
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void resetCb(int status) {
            if (status == 0) goto L5;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "resetCb fail");
            return;
        }

        private void setUsbConfig(long config, boolean chargingFunctions, int operationId) {
            String r0 = UsbDeviceManager.m9167$$Nest$sfgetTAG();
            StringBuilder r1 = new StringBuilder();
            r1.append("setUsbConfig(");
            r1.append(config);
            r1.append(") request:");
            int r2 = this.mCurrentRequest + 1;
            this.mCurrentRequest = r2;
            r1.append(r2);
            Slog.d(r0, r1.toString());
            removeMessages(17);
            removeMessages(15);
            removeMessages(14);
            Object r10 = this.mGadgetProxyLock;
            monitor-enter(r10);
        L22:
            th = th;
        L32:
            monitor-exit(r10);     // Catch: Throwable -> L22
            throw th;
        L9:
            th = th;
            goto L32
        L5:
            if (UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal() != null) goto L37;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "setUsbConfig mUsbGadgetHal is null");     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L37:
            if ((1 & config) == 0) goto L16;
            ((AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class)).startAdbdForTransport((byte) 0);     // Catch: Throwable -> L9 Exception -> L14
        L17:
            UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal().setCurrentUsbFunctions(this.mCurrentRequest, config, chargingFunctions, 2500, operationId);     // Catch: Throwable -> L22 Exception -> L24
            sendMessageDelayed(15, chargingFunctions, BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);     // Catch: Throwable -> L22 Exception -> L24
            if (this.mConnected == false) goto L26;
            sendMessageDelayed(17, chargingFunctions, 5000);     // Catch: Throwable -> L22 Exception -> L24
        L26:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "timeout message queued");     // Catch: Throwable -> L22 Exception -> L24
        L30:
            monitor-exit(r10);     // Catch: Throwable -> L22
            return;
        L24:
            e = e;
        L29:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Remoteexception while calling setCurrentUsbFunctions", e);     // Catch: Throwable -> L22
            goto L30
        L16:
            ((AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class)).stopAdbdForTransport((byte) 0);     // Catch: Throwable -> L9 Exception -> L14
        L14:
            e = e;
            goto L29
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        protected void setEnabledFunctions(long functions, boolean forceRestart, int operationId) {
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "setEnabledFunctionsi functions=" + functions + ", forceRestart=" + forceRestart + ", operationId=" + operationId);
            if (this.mCurrentGadgetHalVersion >= 12) goto L9;
            if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES & functions) == 0) goto L9;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Could not set unsupported function for the GadgetHal");
            return;
        L9:
            if (this.mCurrentFunctions == functions) goto L11;
        L13:
            Slog.i(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Setting USB config to " + UsbManager.usbFunctionsToString(functions));
            this.mCurrentFunctions = functions;
            boolean chargingFunctions = false;
            this.mCurrentFunctionsApplied = false;
            this.mCurrentUsbFunctionsRequested = false;
            if (functions != 0) goto L16;
            chargingFunctions = true;
        L16:
            long functions2 = getAppliedFunctions(functions);
            setUsbConfig(functions2, chargingFunctions, operationId);
            if (this.mBootCompleted == true) goto L19;
            return;
        L19:
            if (isUsbDataTransferActive(functions2) == false) goto L24;
            updateUsbStateBroadcastIfNeeded(functions2);
            return;
        L24:
            return;
        L11:
            if (this.mCurrentFunctionsApplied == false) goto L13;
            if (forceRestart == true) goto L13;
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void handlerInitDone(int operationId) {
            UsbDeviceManager.m9169$$Nest$sfgetmUsbGadgetHal().getCurrentUsbFunctions(operationId);
        }
    }

    private static final class UsbHandlerLegacy extends UsbHandler {
        private static final String USB_CONFIG_PROPERTY = "sys.usb.config";
        private static final String USB_STATE_PROPERTY = "sys.usb.state";
        private String mCurrentFunctionsStr;
        private String mCurrentOemFunctions;
        private int mCurrentRequest;
        private HashMap<String, HashMap<String, Pair<String, String>>> mOemModeMap;
        private boolean mUsbDataUnlocked;

        UsbHandlerLegacy(Looper looper, Context context, UsbDeviceManager deviceManager, UsbAlsaManager alsaManager, UsbPermissionManager permissionManager) {
            super(looper, context, deviceManager, alsaManager, permissionManager);
            this.mCurrentRequest = 0;
            readOemUsbOverrideConfig(context);     // Catch: Exception -> L7
            this.mCurrentOemFunctions = getSystemProperty(getPersistProp(false), "none");     // Catch: Exception -> L7
            if (isNormalBoot() == false) goto L9;
            this.mCurrentFunctionsStr = getSystemProperty(USB_CONFIG_PROPERTY, "none");     // Catch: Exception -> L7
            this.mCurrentFunctionsApplied = this.mCurrentFunctionsStr.equals(getSystemProperty(USB_STATE_PROPERTY, "none"));     // Catch: Exception -> L7
        L10:
            this.mCurrentFunctions = 0;     // Catch: Exception -> L7
            this.mCurrentUsbFunctionsReceived = true;     // Catch: Exception -> L7
            this.mUsbSpeed = -1;     // Catch: Exception -> L7
            this.mCurrentGadgetHalVersion = -1;     // Catch: Exception -> L7
            String state = FileUtils.readTextFile(new File(UsbDeviceManager.STATE_PATH), 0, null).trim();     // Catch: Exception -> L7
            updateState(state);     // Catch: Exception -> L7
            return;
        L9:
            this.mCurrentFunctionsStr = getSystemProperty(getPersistProp(true), "none");     // Catch: Exception -> L7
            this.mCurrentFunctionsApplied = getSystemProperty(USB_CONFIG_PROPERTY, "none").equals(getSystemProperty(USB_STATE_PROPERTY, "none"));     // Catch: Exception -> L7
        L7:
            e = move-exception;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Error initializing UsbHandler", e);
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void handlerInitDone(int operationId) {
        }

        private void readOemUsbOverrideConfig(Context context) {
            String[] configList = context.getResources().getStringArray(R.array.config_roundedCornerTopRadiusArray);
            if (configList == null) goto L24;
            int r1 = configList.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L30;
            String config = configList[r3];
            String[] items = config.split(":");
            if (items.length == 3) goto L12;
            if (items.length == 4) goto L12;
        L23:
            r3 = r3 + 1;
        L12:
            if (this.mOemModeMap != null) goto L14;
            this.mOemModeMap = new HashMap();
        L14:
            HashMap<String, Pair<String, String>> overrideMap = this.mOemModeMap.get(items[0]);
            if (overrideMap != null) goto L18;
            overrideMap = new HashMap();
            this.mOemModeMap.put(items[0], overrideMap);
        L18:
            if (overrideMap.containsKey(items[1]) == true) goto L23;
            if (items.length != 3) goto L22;
            overrideMap.put(items[1], new Pair(items[2], ""));
            goto L23
        L22:
            overrideMap.put(items[1], new Pair(items[2], items[3]));
            goto L23
        L30:
            return;
        }

        private String applyOemOverrideFunction(String usbFunctions) {
            if (usbFunctions != null) goto L4;
        L28:
            return usbFunctions;
        L4:
            if (this.mOemModeMap == null) goto L28;
            String bootMode = getSystemProperty(UsbDeviceManager.BOOT_MODE_PROPERTY, "unknown");
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "applyOemOverride usbfunctions=" + usbFunctions + " bootmode=" + bootMode);
            Map<String, Pair<String, String>> overridesMap = this.mOemModeMap.get(bootMode);
            if (overridesMap != null) goto L9;
        L27:
            return usbFunctions;
        L9:
            if (bootMode.equals(UsbDeviceManager.NORMAL_BOOT) == true) goto L27;
            if (bootMode.equals("unknown") == true) goto L27;
            Pair<String, String> overrideFunctions = overridesMap.get(usbFunctions);
            if (overrideFunctions == null) goto L24;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "OEM USB override: " + usbFunctions + " ==> " + ((String) overrideFunctions.first) + " persist across reboot " + ((String) overrideFunctions.second));
            if (((String) overrideFunctions.second).equals("") == true) goto L22;
            if (isAdbEnabled() == false) goto L19;
            String newFunction = addFunction((String) overrideFunctions.second, "adb");
        L20:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "OEM USB override persisting: " + newFunction + "in prop: " + getPersistProp(false));
            setSystemProperty(getPersistProp(false), newFunction);
            goto L22
        L19:
            newFunction = (String) overrideFunctions.second;
        L22:
            return (String) overrideFunctions.first;
        L24:
            if (isAdbEnabled() == false) goto L26;
            String newFunction2 = addFunction("none", "adb");
            setSystemProperty(getPersistProp(false), newFunction2);
            goto L27
        L26:
            setSystemProperty(getPersistProp(false), "none");
            goto L27
        }

        private boolean waitForState(String state) {
            String value = null;
            int i = 0;
        L4:
            if (i >= 20) goto L10;
            value = getSystemProperty(USB_STATE_PROPERTY, "");
            if (state.equals(value) == true) goto L7;
            SystemClock.sleep(50);
            i = i + 1;
            goto L4
        L7:
            return true;
        L10:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "waitForState(" + state + ") FAILED: got " + value);
            return false;
        }

        private void setUsbConfig(String config) {
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "setUsbConfig(" + config + ")");
            setSystemProperty(USB_CONFIG_PROPERTY, config);
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        protected void setEnabledFunctions(long usbFunctions, boolean forceRestart, int operationId) {
            boolean usbDataUnlocked = isUsbDataTransferActive(usbFunctions);
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "setEnabledFunctions functions=" + usbFunctions + " ,forceRestart=" + forceRestart + " ,usbDataUnlocked=" + usbDataUnlocked + " ,operationId=" + operationId);
            if (usbDataUnlocked == this.mUsbDataUnlocked) goto L5;
            this.mUsbDataUnlocked = usbDataUnlocked;
            updateUsbNotification(false);
            forceRestart = true;
        L5:
            long oldFunctions = this.mCurrentFunctions;
            boolean oldFunctionsApplied = this.mCurrentFunctionsApplied;
            if (trySetEnabledFunctions(usbFunctions, forceRestart) == false) goto L8;
            return;
        L8:
            if (oldFunctionsApplied == true) goto L10;
        L14:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failsafe 2: Restoring default USB functions.");
            if (trySetEnabledFunctions(0, false) == false) goto L17;
            return;
        L17:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failsafe 3: Restoring empty function list (with ADB if enabled).");
            if (trySetEnabledFunctions(0, false) == false) goto L20;
            return;
        L20:
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Unable to set any USB functions!");
            return;
        L10:
            if (oldFunctions == usbFunctions) goto L14;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failsafe 1: Restoring previous USB functions.");
            if (trySetEnabledFunctions(oldFunctions, false) == false) goto L14;
        }

        private boolean isNormalBoot() {
            String bootMode = getSystemProperty(UsbDeviceManager.BOOT_MODE_PROPERTY, "unknown");
            if (bootMode.equals(UsbDeviceManager.NORMAL_BOOT) == false) goto L5;
        L8:
            return true;
        L5:
            if (bootMode.equals("unknown") == true) goto L8;
            return false;
        }

        protected String applyAdbFunction(String functions) {
            if (functions != null) goto L5;
            functions = "";
        L5:
            if (isAdbEnabled() == false) goto L8;
            return addFunction(functions, "adb");
        L8:
            return removeFunction(functions, "adb");
        }

        private boolean trySetEnabledFunctions(long usbFunctions, boolean forceRestart) {
            String functions = null;
            if (usbFunctions == 0) goto L5;
            functions = UsbManager.usbFunctionsToString(usbFunctions);
        L5:
            this.mCurrentFunctions = usbFunctions;
            if (functions != null) goto L8;
        L9:
            functions = getSystemProperty(getPersistProp(true), "none");
            if (functions.equals("none") == false) goto L12;
            functions = UsbManager.usbFunctionsToString(getChargingFunctions());
        L12:
            String functions2 = applyAdbFunction(functions);
            String oemFunctions = applyOemOverrideFunction(functions2);
            if (isNormalBoot() == true) goto L18;
            if (this.mCurrentFunctionsStr.equals(functions2) == true) goto L18;
            setSystemProperty(getPersistProp(true), functions2);
        L18:
            if (functions2.equals(oemFunctions) == true) goto L22;
            if (this.mCurrentOemFunctions.equals(oemFunctions) == true) goto L22;
        L26:
            this.mCurrentFunctionsStr = functions2;
            this.mCurrentOemFunctions = oemFunctions;
            this.mCurrentFunctionsApplied = false;
            setUsbConfig("none");
            if (waitForState("none") == true) goto L30;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failed to kick USB config");
            return false;
        L30:
            setUsbConfig(oemFunctions);
            if (this.mBootCompleted == false) goto L38;
            if (containsFunction(functions2, "mtp") == false) goto L35;
        L36:
            updateUsbStateBroadcastIfNeeded(getAppliedFunctions(this.mCurrentFunctions));
            goto L38
        L35:
            if (containsFunction(functions2, "ptp") == true) goto L36;
        L38:
            if (waitForState(oemFunctions) == true) goto L41;
            Slog.e(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "Failed to switch USB config to " + functions2);
            return false;
        L41:
            this.mCurrentFunctionsApplied = true;
        L42:
            return true;
        L22:
            if (this.mCurrentFunctionsStr.equals(functions2) == false) goto L26;
            if (this.mCurrentFunctionsApplied == false) goto L26;
            if (forceRestart == false) goto L42;
        L8:
            if (applyAdbFunction(functions).equals("none") == false) goto L12;
            goto L9
        }

        private String getPersistProp(boolean functions) {
            String bootMode = getSystemProperty(UsbDeviceManager.BOOT_MODE_PROPERTY, "unknown");
            if (bootMode.equals(UsbDeviceManager.NORMAL_BOOT) == false) goto L5;
            return "persist.sys.usb.config";
        L5:
            if (bootMode.equals("unknown") == false) goto L7;
            return "persist.sys.usb.config";
        L7:
            if (functions == false) goto L9;
            String persistProp = "persist.sys.usb." + bootMode + ".func";
            return persistProp;
        L9:
            String persistProp2 = "persist.sys.usb." + bootMode + ".config";
            return persistProp2;
        }

        private static String addFunction(String functions, String function) {
            if ("none".equals(functions) == false) goto L6;
            return function;
        L6:
            if (containsFunction(functions, function) == false) goto L8;
            return functions;
        L8:
            if (functions.length() <= 0) goto L11;
            functions = functions + ",";
        L11:
            return functions + function;
        }

        private static String removeFunction(String functions, String function) {
            String[] split = functions.split(",");
            int i = 0;
        L4:
            if (i >= split.length) goto L9;
            if (function.equals(split[i]) == false) goto L8;
            split[i] = null;
        L8:
            i = i + 1;
            goto L4
        L9:
            int i2 = split.length;
            if (i2 == 1) goto L12;
        L15:
            StringBuilder builder = new StringBuilder();
            int i3 = 0;
        L17:
            if (i3 >= split.length) goto L26;
            String s = split[i3];
            if (s == null) goto L24;
            if (builder.length() <= 0) goto L23;
            builder.append(",");
        L23:
            builder.append(s);
        L24:
            i3 = i3 + 1;
            goto L17
        L26:
            return builder.toString();
        L12:
            if (split[0] != null) goto L15;
            return "none";
        }

        static boolean containsFunction(String functions, String function) {
            int index = functions.indexOf(function);
            if (index >= 0) goto L6;
            return false;
        L6:
            if (index > 0) goto L8;
        L10:
            int charAfter = function.length() + index;
            if (charAfter < functions.length()) goto L13;
            return true;
        L13:
            if (functions.charAt(charAfter) == ',') goto L17;
            return false;
        L17:
            return true;
        L8:
            if (functions.charAt(index - 1) == ',') goto L10;
            return false;
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void setCurrentUsbFunctionsCb(long functions, int status, int mRequest, long mFunctions, boolean mChargingFunctions) {
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void getUsbSpeedCb(int speed) {
        }

        @Override // com.android.server.usb.UsbDeviceManager.UsbHandler
        public void resetCb(int status) {
        }
    }

    private final class UsbUEventObserver extends UEventObserver {
        final /* synthetic */ UsbDeviceManager this$0;

        /* synthetic */ UsbUEventObserver(UsbDeviceManager r1, UsbDeviceManagerIA r2) {
            this(r1);
        }

        private UsbUEventObserver(UsbDeviceManager r1) {
            this.this$0 = r1;
        }

        public void onUEvent(UEventObserver.UEvent event) {
            Slog.v(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "USB UEVENT: " + event.toString());
            if (UsbDeviceManager.m9171$$Nest$sfgetsEventLogger() == null) goto L5;
            UsbDeviceManager.m9171$$Nest$sfgetsEventLogger().enqueue(new EventLogger.StringEvent("USB UEVENT: " + event.toString()));
        L6:
            String accessory = event.get("ACCESSORY");
            if ("GETPROTOCOL".equals(accessory) == false) goto L10;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "got accessory get protocol");
            UsbDeviceManager.m9159$$Nest$fgetmHandler(this.this$0).setAccessoryUEventTime(SystemClock.elapsedRealtime());
            UsbDeviceManager.m9165$$Nest$mresetAccessoryHandshakeTimeoutHandler(this.this$0);
        L16:
            if (UsbDeviceManager.m9158$$Nest$fgetmEnableUdcSysfsUsbStateUpdate(this.this$0) == true) goto L18;
            String state = event.get("USB_STATE");
            if (state == null) goto L37;
            UsbDeviceManager.m9159$$Nest$fgetmHandler(this.this$0).updateState(state);
            return;
        L37:
            return;
        L18:
            if (UsbDeviceManager.m9160$$Nest$fgetmUdcName(this.this$0).isEmpty() == false) goto L20;
            return;
        L20:
            if ("udc".equals(event.get("SUBSYSTEM")) == true) goto L22;
            return;
        L22:
            if (event.get("DEVPATH").contains(UsbDeviceManager.m9160$$Nest$fgetmUdcName(this.this$0)) == false) goto L36;
            String action = event.get("ACTION");
            if ("add".equals(action) == false) goto L27;
            UsbDeviceManager.m9162$$Nest$mnativeStartGadgetMonitor(this.this$0, UsbDeviceManager.m9160$$Nest$fgetmUdcName(this.this$0));
            return;
        L27:
            if ("remove".equals(action) == false) goto L40;
            UsbDeviceManager.m9163$$Nest$mnativeStopGadgetMonitor(this.this$0);
            return;
        L40:
            return;
        L36:
            return;
        L10:
            if ("SENDSTRING".equals(accessory) == false) goto L13;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "got accessory send string");
            UsbDeviceManager.m9159$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(21);
            UsbDeviceManager.m9165$$Nest$mresetAccessoryHandshakeTimeoutHandler(this.this$0);
            goto L16
        L13:
            if ("START".equals(accessory) == false) goto L16;
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "got accessory start");
            UsbDeviceManager.m9159$$Nest$fgetmHandler(this.this$0).removeMessages(20);
            UsbDeviceManager.m9159$$Nest$fgetmHandler(this.this$0).setStartAccessoryTrue();
            UsbDeviceManager.m9166$$Nest$mstartAccessoryMode(this.this$0);
            goto L16
        L5:
            Slog.d(UsbDeviceManager.m9167$$Nest$sfgetTAG(), "sEventLogger == null");
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnableUdcSysfsUsbStateUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9158$$Nest$fgetmEnableUdcSysfsUsbStateUpdate(UsbDeviceManager r0) {
        return r0.mEnableUdcSysfsUsbStateUpdate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbHandler m9159$$Nest$fgetmHandler(UsbDeviceManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUdcName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9160$$Nest$fgetmUdcName(UsbDeviceManager r0) {
        return r0.mUdcName;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUdcName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9161$$Nest$fputmUdcName(UsbDeviceManager r0, String r1) {
        r0.mUdcName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeStartGadgetMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9162$$Nest$mnativeStartGadgetMonitor(UsbDeviceManager r0, String r1) {
        return r0.nativeStartGadgetMonitor(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeStopGadgetMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9163$$Nest$mnativeStopGadgetMonitor(UsbDeviceManager r0) {
        r0.nativeStopGadgetMonitor();
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeWaitAndGetProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9164$$Nest$mnativeWaitAndGetProperty(UsbDeviceManager r0, String r1) {
        return r0.nativeWaitAndGetProperty(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetAccessoryHandshakeTimeoutHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9165$$Nest$mresetAccessoryHandshakeTimeoutHandler(UsbDeviceManager r0) {
        r0.resetAccessoryHandshakeTimeoutHandler();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartAccessoryMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9166$$Nest$mstartAccessoryMode(UsbDeviceManager r0) {
        r0.startAccessoryMode();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9167$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtUsbDeviceManager m9168$$Nest$sfgetmExt() {
        return mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmUsbGadgetHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbGadgetHal m9169$$Nest$sfgetmUsbGadgetHal() {
        return mUsbGadgetHal;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsDenyInterfaces, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m9170$$Nest$sfgetsDenyInterfaces() {
        return sDenyInterfaces;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m9171$$Nest$sfgetsEventLogger() {
        return sEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsUsbOperationCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m9172$$Nest$sfgetsUsbOperationCount() {
        return sUsbOperationCount;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputmUsbGadgetHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9173$$Nest$sfputmUsbGadgetHal(UsbGadgetHal r0) {
        mUsbGadgetHal = r0;
    }

    private native String[] nativeGetAccessoryStrings();

    private native boolean nativeIsStartRequested();

    private native ParcelFileDescriptor nativeOpenAccessory();

    private native FileDescriptor nativeOpenControl(String r1);

    private native boolean nativeStartGadgetMonitor(String r1);

    private native void nativeStopGadgetMonitor();

    private native String nativeWaitAndGetProperty(String r1);

    static {
        TAG = UsbDeviceManager.class.getSimpleName();
        sUsbOperationCount = new AtomicInteger();
        sDenyInterfaces = new HashSet();
        sDenyInterfaces.add(1);
        sDenyInterfaces.add(2);
        sDenyInterfaces.add(3);
        sDenyInterfaces.add(7);
        sDenyInterfaces.add(8);
        sDenyInterfaces.add(9);
        sDenyInterfaces.add(10);
        sDenyInterfaces.add(11);
        sDenyInterfaces.add(13);
        sDenyInterfaces.add(14);
        sDenyInterfaces.add(Integer.valueOf(UsbDescriptor.CLASSID_WIRELESS));
        mExt = (IExtUsbDeviceManager) ExtImplFactory.getImpl(IExtUsbDeviceManager.class, new Object[0]);
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onKeyguardStateChanged(boolean isShowing) {
        int userHandle = ActivityManager.getCurrentUser();
        boolean secure = ((KeyguardManager) this.mContext.getSystemService(KeyguardManager.class)).isDeviceSecure(userHandle);
        Slog.v(TAG, "onKeyguardStateChanged: isShowing:" + isShowing + " secure:" + secure + " user:" + userHandle);
        UsbHandler r2 = this.mHandler;
        if (isShowing == false) goto L6;
        if (secure == false) goto L6;
        boolean r3 = true;
    L7:
        r2.sendMessage(13, r3);
        return;
    L6:
        r3 = false;
        goto L7
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onAwakeStateChanged(boolean isAwake) {
    }

    public void onUnlockUser(int userHandle) {
        onKeyguardStateChanged(false);
    }

    public UsbDeviceManager(Context context, UsbAlsaManager alsaManager, UsbSettingsManager settingsManager, UsbPermissionManager permissionManager) {
        this.mLock = new Object();
        this.mUdcName = "";
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        PackageManager pm = this.mContext.getPackageManager();
        this.mHasUsbAccessory = pm.hasSystemFeature("android.hardware.usb.accessory");
        initRndisAddress();
        int operationId = sUsbOperationCount.incrementAndGet();
        UsbDeviceManagerIA r10 = null;
        mUsbGadgetHal = UsbGadgetHalInstance.getInstance(this, null);
        Slog.d(TAG, "getInstance done");
        this.mControlFds = new HashMap();
        FileDescriptor mtpFd = nativeOpenControl("mtp");
        if (mtpFd != null) goto L5;
        Slog.e(TAG, "Failed to open control for mtp");
    L5:
        this.mControlFds.put(4L, mtpFd);
        FileDescriptor ptpFd = nativeOpenControl("ptp");
        if (ptpFd != null) goto L8;
        Slog.e(TAG, "Failed to open control for ptp");
    L8:
        this.mControlFds.put(16L, ptpFd);
        if (mUsbGadgetHal != null) goto L11;
        this.mHandler = new UsbHandlerLegacy(FgThread.get().getLooper(), this.mContext, this, alsaManager, permissionManager);
    L12:
        this.mHandler.handlerInitDone(operationId);
        if (nativeIsStartRequested() == false) goto L15;
        Slog.d(TAG, "accessory attached at boot");
        startAccessoryMode();
    L15:
        BroadcastReceiver portReceiver = new AnonymousClass1(this);
        BroadcastReceiver chargingReceiver = new AnonymousClass2(this);
        BroadcastReceiver hostReceiver = new AnonymousClass3(this);
        BroadcastReceiver languageChangedReceiver = new AnonymousClass4(this);
        BroadcastReceiver userUnlockedAfterBootReceiver = new AnonymousClass5(this);
        this.mContext.registerReceiver(userUnlockedAfterBootReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        this.mContext.registerReceiver(portReceiver, new IntentFilter("android.hardware.usb.action.USB_PORT_CHANGED"));
        this.mContext.registerReceiver(chargingReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        IntentFilter filter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this.mContext.registerReceiver(hostReceiver, filter);
        this.mContext.registerReceiver(languageChangedReceiver, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        this.mUEventObserver = new UsbUEventObserver(this, r10);
        this.mUEventObserver.startObserving(USB_STATE_MATCH_SEC);
        this.mUEventObserver.startObserving(ACCESSORY_START_MATCH);
        this.mEnableUdcSysfsUsbStateUpdate = false;
        if (this.mEnableUdcSysfsUsbStateUpdate == false) goto L18;
        this.mUEventObserver.startObserving(UDC_SUBSYS_MATCH);
        final String r13 = "GetUsbControllerSysprop";
        new AnonymousClass6(this, r13).start();
    L19:
        this.mUEventObserver.startObserving(USB_EVENT_MATCH);
        sEventLogger = new EventLogger(200, "UsbDeviceManager activity");
        return;
    L18:
        this.mUEventObserver.startObserving(USB_STATE_MATCH);
        goto L19
    L11:
        this.mHandler = new UsbHandlerHal(FgThread.get().getLooper(), this.mContext, this, alsaManager, permissionManager);
        goto L12
    }

    UsbProfileGroupSettingsManager getCurrentSettings() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UsbProfileGroupSettingsManager r1 = this.mCurrentSettings;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    String[] getAccessoryStrings() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String[] r1 = this.mAccessoryStrings;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void systemReady() {
        Slog.d(TAG, "systemReady");
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).registerScreenObserver(this);
        this.mHandler.sendEmptyMessage(3);
    }

    public void bootCompleted() {
        Slog.d(TAG, "boot completed");
        this.mHandler.sendEmptyMessage(4);
    }

    public void setCurrentUser(int newCurrentUserId, UsbProfileGroupSettingsManager settings) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentSettings = settings;     // Catch: Throwable -> L7
        this.mHandler.obtainMessage(5, newCurrentUserId, 0).sendToTarget();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateUserRestrictions() {
        this.mHandler.sendEmptyMessage(6);
    }

    private void resetAccessoryHandshakeTimeoutHandler() {
        long functions = getCurrentFunctions();
        if ((2 & functions) != 0) goto L6;
        this.mHandler.removeMessages(20);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(20), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    }

    private void startAccessoryMode() {
        if (this.mHasUsbAccessory == true) goto L5;
        return;
    L5:
        int operationId = sUsbOperationCount.incrementAndGet();
        this.mAccessoryStrings = nativeGetAccessoryStrings();
        boolean enableAccessory = false;
        if (this.mAccessoryStrings != null) goto L8;
    L12:
        long functions = 0;
        if (enableAccessory == false) goto L16;
        functions = 0 | 2;
    L16:
        if (functions == 0) goto L19;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(8), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(20), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        setCurrentFunctions(functions, operationId);
        return;
    L19:
        return;
    L8:
        if (this.mAccessoryStrings[0] == null) goto L12;
        if (this.mAccessoryStrings[1] == null) goto L12;
        enableAccessory = true;
        goto L12
    }

    private static void initRndisAddress() {
        int[] address = new int[6];
        address[0] = 2;
        String serial = SystemProperties.get("ro.serialno", "1234567890ABCDEF");
        int serialLength = serial.length();
        int i = 0;
    L4:
        if (i >= serialLength) goto L6;
        int r8 = (i % 5) + 1;
        address[r8] = address[r8] ^ serial.charAt(i);
        i = i + 1;
        goto L4
    L6:
        String addrString = String.format(Locale.US, "%02X:%02X:%02X:%02X:%02X:%02X", new Object[]{Integer.valueOf(address[0]), Integer.valueOf(address[1]), Integer.valueOf(address[2]), Integer.valueOf(address[3]), Integer.valueOf(address[4]), Integer.valueOf(address[5])});
        FileUtils.stringToFile(RNDIS_ETH_ADDR_PATH, addrString);     // Catch: IOException -> L9
        return;
    L10:
        Slog.i(TAG, "failed to write to /sys/class/android_usb/android0/f_rndis/ethaddr");
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

    public UsbAccessory getCurrentAccessory() {
        return this.mHandler.getCurrentAccessory();
    }

    public ParcelFileDescriptor openAccessory(UsbAccessory accessory, UsbUserPermissionManager permissions, int pid, int uid) {
        UsbAccessory currentAccessory = this.mHandler.getCurrentAccessory();
        if (currentAccessory == null) goto L11;
        if (currentAccessory.equals(accessory) == false) goto L8;
        permissions.checkPermission(accessory, pid, uid);
        return nativeOpenAccessory();
    L8:
        String error = accessory.toString() + " does not match current accessory " + currentAccessory;
        throw new IllegalArgumentException(error);
    L11:
        throw new IllegalArgumentException("no accessory attached");
    }

    public long getCurrentFunctions() {
        return this.mHandler.getEnabledFunctions();
    }

    public int getCurrentUsbSpeed() {
        return this.mHandler.getUsbSpeed();
    }

    public int getGadgetHalVersion() {
        return this.mHandler.getGadgetHalVersion();
    }

    public void setCurrentUsbFunctionsCb(long functions, int status, int mRequest, long mFunctions, boolean mChargingFunctions) {
        this.mHandler.setCurrentUsbFunctionsCb(functions, status, mRequest, mFunctions, mChargingFunctions);
    }

    public void getCurrentUsbFunctionsCb(long functions, int status) {
        UsbHandler r0 = this.mHandler;
        Long r1 = Long.valueOf(functions);
        if (status != 2) goto L5;
        boolean r2 = true;
    L6:
        r0.sendMessage(16, r1, r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void getUsbSpeedCb(int speed) {
        this.mHandler.getUsbSpeedCb(speed);
    }

    public void resetCb(int status) {
        this.mHandler.resetCb(status);
    }

    public ParcelFileDescriptor getControlFd(long usbFunction) {
        FileDescriptor fd = this.mControlFds.get(Long.valueOf(usbFunction));
        if (fd != null) goto L10;
        return null;
    L10:
        return ParcelFileDescriptor.dup(fd);
    L8:
        Slog.e(TAG, "Could not dup fd for " + usbFunction);
        return null;
    }

    public long getScreenUnlockedFunctions() {
        return this.mHandler.getScreenUnlockedFunctions();
    }

    public void setCurrentFunctions(long functions, int operationId) {
        Slog.d(TAG, "setCurrentFunctions(" + UsbManager.usbFunctionsToString(functions) + ")");
        if (functions != 0) goto L6;
        MetricsLogger.action(this.mContext, 1275);
    L21:
        this.mHandler.sendMessage(2, Long.valueOf(functions), operationId);
        return;
    L6:
        if (functions != 4) goto L9;
        MetricsLogger.action(this.mContext, 1276);
        goto L21
    L9:
        if (functions != 16) goto L12;
        MetricsLogger.action(this.mContext, 1277);
        goto L21
    L12:
        if (functions != 8) goto L15;
        MetricsLogger.action(this.mContext, 1279);
        goto L21
    L15:
        if (functions != 32) goto L18;
        MetricsLogger.action(this.mContext, 1278);
        goto L21
    L18:
        if (functions != 2) goto L21;
        MetricsLogger.action(this.mContext, 1280);
        goto L21
    }

    public void setScreenUnlockedFunctions(long functions) {
        Slog.d(TAG, "setScreenUnlockedFunctions(" + UsbManager.usbFunctionsToString(functions) + ")");
        this.mHandler.sendMessage(12, Long.valueOf(functions));
    }

    public void resetUsbGadget() {
        Slog.d(TAG, "reset Usb Gadget");
        this.mHandler.sendMessage(19, null);
    }

    private void onAdbEnabled(boolean enabled) {
        int operationId = sUsbOperationCount.incrementAndGet();
        this.mHandler.sendMessage(1, enabled, operationId);
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        if (this.mHandler == null) goto L5;
        this.mHandler.dump(dump, "handler", 1146756268033L);
        sEventLogger.dump(new DualOutputStreamDumpSink(dump, 1138166333457L));
    L5:
        dump.end(token);
    }

    private void updateGadgetState(String state) {
        Slog.d(TAG, "Usb state update " + state);
        this.mHandler.updateState(state);
    }

    public IExtUsbDeviceManager getExt() {
        return mExt;
    }
}
