package com.android.server.testharness;

import android.R;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.debug.AdbManagerInternal;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pdb.PersistentDataBlockManagerInternal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class TestHarnessModeService extends SystemService {
    private static final String TAG = null;
    public static final String TEST_HARNESS_MODE_PROPERTY = "persist.sys.test_harness";
    private boolean mEnableKeepMemtagMode;
    private PersistentDataBlockManagerInternal mPersistentDataBlockManagerInternal;
    private final IBinder mService;

    public static class PersistentData {
        static final byte VERSION_1 = 1;
        static final byte VERSION_2 = 2;
        final byte[] mAdbKeys;
        final byte[] mAdbTempKeys;
        final int mVersion;

        PersistentData(byte[] adbKeys, byte[] adbTempKeys) {
            this(2, adbKeys, adbTempKeys);
        }

        PersistentData(int version, byte[] adbKeys, byte[] adbTempKeys) {
            this.mVersion = version;
            this.mAdbKeys = adbKeys;
            this.mAdbTempKeys = adbTempKeys;
        }

        static PersistentData fromBytes(byte[] bytes) throws SetUpTestHarnessModeException {
            DataInputStream is = new DataInputStream(new ByteArrayInputStream(bytes));     // Catch: IOException -> L5
            int version = is.readInt();     // Catch: IOException -> L5
            if (version != 1) goto L7;
            is.readBoolean();     // Catch: IOException -> L5
        L7:
            int adbKeysLength = is.readInt();     // Catch: IOException -> L5
            byte[] adbKeys = new byte[adbKeysLength];     // Catch: IOException -> L5
            is.readFully(adbKeys);     // Catch: IOException -> L5
            int adbTempKeysLength = is.readInt();     // Catch: IOException -> L5
            byte[] adbTempKeys = new byte[adbTempKeysLength];     // Catch: IOException -> L5
            is.readFully(adbTempKeys);     // Catch: IOException -> L5
            return new PersistentData(version, adbKeys, adbTempKeys);
        L5:
            e = move-exception;
            throw new SetUpTestHarnessModeException(e);
        }

        byte[] toBytes() {
            ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: IOException -> L4
            DataOutputStream dos = new DataOutputStream(os);     // Catch: IOException -> L4
            dos.writeInt(2);     // Catch: IOException -> L4
            dos.writeInt(this.mAdbKeys.length);     // Catch: IOException -> L4
            dos.write(this.mAdbKeys);     // Catch: IOException -> L4
            dos.writeInt(this.mAdbTempKeys.length);     // Catch: IOException -> L4
            dos.write(this.mAdbTempKeys);     // Catch: IOException -> L4
            dos.close();     // Catch: IOException -> L4
            return os.toByteArray();
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    private static class SetUpTestHarnessModeException extends Exception {
        SetUpTestHarnessModeException(Exception e) {
            super(e);
        }
    }

    private class TestHarnessModeShellCommand extends ShellCommand {
        final /* synthetic */ TestHarnessModeService this$0;

        /* synthetic */ TestHarnessModeShellCommand(TestHarnessModeService r1, TestHarnessModeServiceIA r2) {
            this(r1);
        }

        private TestHarnessModeShellCommand(TestHarnessModeService r1) {
            this.this$0 = r1;
        }

        public int onCommand(String cmd) {
            if (cmd != null) goto L6;
            return handleDefaultCommands(cmd);
        L6:
            switch(cmd.hashCode()) {
                case -1298848381: goto L12;
                case 1097519758: goto L9;
                default: goto L14;
            };
        L14:
            byte r0 = -1;
        L15:
            switch(r0) {
                case 0: goto L18;
                case 1: goto L18;
                default: goto L17;
            };
        L18:
            String opt = getNextOption();
            if (opt == null) goto L31;
            switch(opt.hashCode()) {
                case -510577843: goto L24;
                default: goto L26;
            };
        L26:
            byte r1 = -1;
        L27:
            switch(r1) {
                case 0: goto L30;
                default: goto L28;
            };
        L30:
            TestHarnessModeService.m8464$$Nest$fputmEnableKeepMemtagMode(this.this$0, true);
            goto L18
        L28:
            getErrPrintWriter().println("Invalid option: " + opt);
            return 1;
        L24:
            if (opt.equals("--keep-memtag") == false) goto L26;
            r1 = 0;
            goto L27
        L31:
            checkPermissions();
            long originalId = Binder.clearCallingIdentity();
        L37:
            th = move-exception;
            Binder.restoreCallingIdentity(originalId);
            throw th;
        L33:
            if (isDeviceSecure() == false) goto L39;
            getErrPrintWriter().println("Test Harness Mode cannot be enabled if there is a lock screen");     // Catch: Throwable -> L37
            Binder.restoreCallingIdentity(originalId);
            return 2;
        L39:
            int r2 = handleEnable();     // Catch: Throwable -> L37
            Binder.restoreCallingIdentity(originalId);
            return r2;
        L17:
            return handleDefaultCommands(cmd);
        L9:
            if (cmd.equals("restore") == false) goto L47;
            r0 = 1;
            goto L15
        L47:
            r0 = -1;
            goto L15
        L12:
            if (cmd.equals("enable") == false) goto L48;
            r0 = 0;
            goto L15
        L48:
            r0 = -1;
            goto L15
        }

        private void checkPermissions() {
            this.this$0.getContext().enforceCallingPermission("android.permission.ENABLE_TEST_HARNESS_MODE", "You must hold android.permission.ENABLE_TEST_HARNESS_MODE to enable Test Harness Mode");
        }

        private boolean isDeviceSecure() {
            KeyguardManager keyguardManager = (KeyguardManager) this.this$0.getContext().getSystemService(KeyguardManager.class);
            return keyguardManager.isDeviceSecure(TestHarnessModeService.m8465$$Nest$mgetMainUserId(this.this$0));
        }

        private int handleEnable() {
            AdbManagerInternal adbManager = (AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class);
            File adbKeys = adbManager.getAdbKeysFile();
            File adbTempKeys = adbManager.getAdbTempKeysFile();
            byte[] adbKeysBytes = getBytesFromFile(adbKeys);     // Catch: IOException -> L7
            byte[] adbTempKeysBytes = getBytesFromFile(adbTempKeys);     // Catch: IOException -> L7
            PersistentData persistentData = new PersistentData(adbKeysBytes, adbTempKeysBytes);     // Catch: IOException -> L7
            PersistentDataBlockManagerInternal blockManager = TestHarnessModeService.m8466$$Nest$mgetPersistentDataBlock(this.this$0);     // Catch: IOException -> L7
            if (blockManager != null) goto L9;
            Slog.e("ShellCommand", "Failed to enable Test Harness Mode. No implementation of PersistentDataBlockManagerInternal was bound.");     // Catch: IOException -> L7
            getErrPrintWriter().println("Failed to enable Test Harness Mode");     // Catch: IOException -> L7
            return 1;
        L9:
            blockManager.setTestHarnessModeData(persistentData.toBytes());     // Catch: IOException -> L7
            Intent i = new Intent("android.intent.action.FACTORY_RESET");
            i.setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME);
            i.addFlags(268435456);
            i.putExtra("android.intent.extra.REASON", "ShellCommand");
            i.putExtra("android.intent.extra.WIPE_EXTERNAL_STORAGE", true);
            i.putExtra("keep_memtag_mode", TestHarnessModeService.m8463$$Nest$fgetmEnableKeepMemtagMode(this.this$0));
            this.this$0.getContext().sendBroadcastAsUser(i, UserHandle.SYSTEM);
            return 0;
        L7:
            e = move-exception;
            Slog.e("ShellCommand", "Failed to store ADB keys.", e);
            getErrPrintWriter().println("Failed to enable Test Harness Mode");
            return 1;
        }

        private byte[] getBytesFromFile(File file) throws IOException {
            if (file == null) goto L22;
            if (file.exists() == false) goto L22;
            Path path = file.toPath();
            InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);
            int size = (int) Files.size(path);     // Catch: Throwable -> L14
            byte[] bytes = new byte[size];     // Catch: Throwable -> L14
            int numBytes = inputStream.read(bytes);     // Catch: Throwable -> L14
            if (numBytes != size) goto L13;
            inputStream.close();
            return bytes;
        L13:
            throw new IOException("Failed to read the whole file");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (inputStream != null) goto L23;
        L20:
            throw th;
        L23:
            inputStream.close();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            th.addSuppressed(th);
        L22:
            return new byte[0];
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("About:");
            pw.println("  Test Harness Mode is a mode that the device can be placed in to prepare");
            pw.println("  the device for running UI tests. The device is placed into this mode by");
            pw.println("  first wiping all data from the device, preserving ADB keys.");
            pw.println();
            pw.println("  By default, the following settings are configured:");
            pw.println("    * Package Verifier is disabled");
            pw.println("    * Stay Awake While Charging is enabled");
            pw.println("    * OTA Updates are disabled");
            pw.println("    * Auto-Sync for accounts is disabled");
            pw.println();
            pw.println("  Other apps may configure themselves differently in Test Harness Mode by");
            pw.println("  checking ActivityManager.isRunningInUserTestHarness()");
            pw.println();
            pw.println("Test Harness Mode commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println();
            pw.println("  enable|restore");
            pw.println("    Erase all data from this device and enable Test Harness Mode,");
            pw.println("    preserving the stored ADB keys currently on the device and toggling");
            pw.println("    settings in a way that are conducive to Instrumentation testing.");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnableKeepMemtagMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8463$$Nest$fgetmEnableKeepMemtagMode(TestHarnessModeService r0) {
        return r0.mEnableKeepMemtagMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEnableKeepMemtagMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8464$$Nest$fputmEnableKeepMemtagMode(TestHarnessModeService r0, boolean r1) {
        r0.mEnableKeepMemtagMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMainUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8465$$Nest$mgetMainUserId(TestHarnessModeService r0) {
        return r0.getMainUserId();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPersistentDataBlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PersistentDataBlockManagerInternal m8466$$Nest$mgetPersistentDataBlock(TestHarnessModeService r0) {
        return r0.getPersistentDataBlock();
    }

    static {
        TAG = TestHarnessModeService.class.getSimpleName();
    }

    public TestHarnessModeService(Context context) {
        super(context);
        this.mEnableKeepMemtagMode = false;
        this.mService = new AnonymousClass1(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("testharness", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        switch(phase) {
            case 500: goto L5;
            case 1000: goto L4;
            default: goto L6;
        };
    L4:
        completeTestHarnessModeSetup();
        showNotificationIfEnabled();
        goto L6
    L5:
        setUpTestHarnessMode();
    L6:
        super.onBootPhase(phase);
    }

    private void setUpTestHarnessMode() {
        Slog.d(TAG, "Setting up test harness mode");
        byte[] testHarnessModeData = getTestHarnessModeData();
        if (testHarnessModeData != null) goto L5;
        return;
    L5:
        setDeviceProvisioned();
        disableLockScreen();
        SystemProperties.set(TEST_HARNESS_MODE_PROPERTY, "1");
    }

    private void disableLockScreen() {
        int mainUserId = getMainUserId();
        LockPatternUtils utils = new LockPatternUtils(getContext());
        utils.setLockScreenDisabled(true, mainUserId);
    }

    private void completeTestHarnessModeSetup() {
        Slog.d(TAG, "Completing Test Harness Mode setup.");
        byte[] testHarnessModeData = getTestHarnessModeData();
        if (testHarnessModeData != null) goto L15;
        return;
    L15:
        setUpAdbFiles(PersistentData.fromBytes(testHarnessModeData));     // Catch: Throwable -> L7 SetUpTestHarnessModeException -> L9
        configureSettings();     // Catch: Throwable -> L7 SetUpTestHarnessModeException -> L9
        configureUser();     // Catch: Throwable -> L7 SetUpTestHarnessModeException -> L9
    L6:
        getPersistentDataBlock().clearTestHarnessModeData();
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to set up Test Harness Mode. Bad data.", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        getPersistentDataBlock().clearTestHarnessModeData();
        throw th;
    }

    private byte[] getTestHarnessModeData() {
        PersistentDataBlockManagerInternal blockManager = getPersistentDataBlock();
        if (blockManager != null) goto L6;
        Slog.e(TAG, "Failed to start Test Harness Mode; no implementation of PersistentDataBlockManagerInternal was bound!");
        return null;
    L6:
        byte[] testHarnessModeData = blockManager.getTestHarnessModeData();
        if (testHarnessModeData != null) goto L9;
    L12:
        return null;
    L9:
        if (testHarnessModeData.length == 0) goto L12;
        return testHarnessModeData;
    }

    private void configureSettings() {
        ContentResolver cr = getContext().getContentResolver();
        if (Settings.Global.getInt(cr, "adb_enabled", 0) != 1) goto L5;
        SystemProperties.set("ctl.restart", "adbd");
        Slog.d(TAG, "Restarted adbd");
    L5:
        Settings.Global.putLong(cr, "adb_allowed_connection_time", 0);
        Settings.Global.putInt(cr, "development_settings_enabled", 1);
        Settings.Global.putInt(cr, "verifier_verify_adb_installs", 0);
        Settings.Global.putInt(cr, "stay_on_while_plugged_in", 15);
        Settings.Global.putInt(cr, "ota_disable_automatic_update", 1);
    }

    private void setUpAdbFiles(PersistentData persistentData) {
        AdbManagerInternal adbManager = (AdbManagerInternal) LocalServices.getService(AdbManagerInternal.class);
        if (adbManager.getAdbKeysFile() == null) goto L6;
        writeBytesToFile(persistentData.mAdbKeys, adbManager.getAdbKeysFile().toPath());
    L6:
        if (adbManager.getAdbTempKeysFile() == null) goto L8;
        writeBytesToFile(persistentData.mAdbTempKeys, adbManager.getAdbTempKeysFile().toPath());
    L8:
        adbManager.notifyKeyFilesUpdated();
    }

    private void configureUser() {
        int mainUserId = getMainUserId();
        ContentResolver.setMasterSyncAutomaticallyAsUser(false, mainUserId);
        LocationManager locationManager = (LocationManager) getContext().getSystemService(LocationManager.class);
        locationManager.setLocationEnabledForUser(true, UserHandle.of(mainUserId));
    }

    private int getMainUserId() {
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int mainUserId = umi.getMainUserId();
        if (mainUserId < 0) goto L5;
        return mainUserId;
    L5:
        Slog.w(TAG, "No MainUser exists; using user 0 instead");
        return 0;
    }

    private void writeBytesToFile(byte[] keys, Path adbKeys) {
        OutputStream fileOutputStream = Files.newOutputStream(adbKeys, new OpenOption[0]);     // Catch: IOException -> L5
        fileOutputStream.write(keys);     // Catch: IOException -> L5
        fileOutputStream.close();     // Catch: IOException -> L5
        Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(adbKeys, new LinkOption[0]);     // Catch: IOException -> L5
        permissions.add(PosixFilePermission.GROUP_READ);     // Catch: IOException -> L5
        Files.setPosixFilePermissions(adbKeys, permissions);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to set up adb keys", e);
    }

    private void setDeviceProvisioned() {
        ContentResolver cr = getContext().getContentResolver();
        Settings.Global.putInt(cr, "device_provisioned", 1);
        Settings.Secure.putIntForUser(cr, "user_setup_complete", 1, -2);
    }

    private void showNotificationIfEnabled() {
        if (SystemProperties.getBoolean(TEST_HARNESS_MODE_PROPERTY, false) == true) goto L5;
        return;
    L5:
        String title = getContext().getString(17042225);
        String message = getContext().getString(17042224);
        Notification notification = new Notification.Builder(getContext(), "DEVELOPER").setSmallIcon(17305175).setWhen(0).setOngoing(true).setTicker(title).setDefaults(0).setColor(getContext().getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setVisibility(1).build();
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(NotificationManager.class);
        notificationManager.notifyAsUser(null, 54, notification, UserHandle.ALL);
    }

    private PersistentDataBlockManagerInternal getPersistentDataBlock() {
        if (this.mPersistentDataBlockManagerInternal != null) goto L6;
        Slog.d(TAG, "Getting PersistentDataBlockManagerInternal from LocalServices");
        this.mPersistentDataBlockManagerInternal = (PersistentDataBlockManagerInternal) LocalServices.getService(PersistentDataBlockManagerInternal.class);
    L6:
        return this.mPersistentDataBlockManagerInternal;
    }
}
