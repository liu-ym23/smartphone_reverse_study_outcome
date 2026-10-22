package com.android.server.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.util.Slog;
import android.util.TimeUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStorageMonitorServiceSmtEx {
    private static long DEFAULT_BACKUP_STEP_SIZE = 0;
    private static long DEFAULT_BACKUP_TOTAL_SIZE = 0;
    private static final long DEFAULT_CHECK_INTERVAL = 60000;
    private static long DEFAULT_CHECK_MIN_INTERVAL = 0;
    private static final long DEFAULT_NOTIFY_INTERVAL = 86400000;
    private static final long DEFAULT_STORAGE_FULL_DLG_INTERVAL = 86400000;
    private static final String RESERVE_DIR = null;
    protected static final long STORAGE_COMPLETE_FULL_THRESHOLD = 10485760;
    private static final long STORAGE_FULL_DLG_INTERVAL = 0;
    private static final long STORAGE_LOW_NOTIFY_INTERVAL = 0;
    private static final String SYS_STORAGE_FULL = "sys.storage.full";
    private static final String TAG = "DeviceStorageMonitorService";
    private BackupMemory mBackupMem;
    private boolean mBootComplete;
    protected long mCheckInterval;
    private final DialogInterface.OnDismissListener mDismissListener;
    private long mLastMemFullTime;
    protected long mLastMemLowNotifyTime;
    private StorageFullDialog mMemFullDialog;
    private long mMemReleaseThreshold;
    private long mMemReserveThreshold;
    private boolean mReady;
    private DeviceStorageMonitorService mService;

    class BackupMemory {
        boolean mReservedFull;

        public BackupMemory(DeviceStorageMonitorServiceSmtEx this$0) {
            this.mReservedFull = false;
            if (createReseveDir() == false) goto L6;
            reserve(false);
            return;
        }

        private boolean createReseveDir() {
            File file = new File(DeviceStorageMonitorServiceSmtEx.m8431$$Nest$sfgetRESERVE_DIR());
            if (file.exists() == true) goto L6;
            file.mkdirs();
            return true;
        L6:
            return false;
        }

        public void reserve(boolean step) {
            if (this.mReservedFull == false) goto L5;
            return;
        L5:
            int N = (int) (DeviceStorageMonitorServiceSmtEx.m8430$$Nest$sfgetDEFAULT_BACKUP_TOTAL_SIZE() / DeviceStorageMonitorServiceSmtEx.m8429$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE());
            int n = 0;
        L6:
            if (n >= N) goto L46;
            File file = new File(DeviceStorageMonitorServiceSmtEx.m8431$$Nest$sfgetRESERVE_DIR() + "/mem" + String.valueOf(n));
            if (file.exists() == true) goto L45;
            FileOutputStream fos = null;
            fos = new FileOutputStream(file);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            long buffSize = DeviceStorageMonitorServiceSmtEx.m8429$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            int loop = (int) (DeviceStorageMonitorServiceSmtEx.m8429$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE() / buffSize);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            byte[] buff = new byte[(int) buffSize];     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            int i = 0;
        L11:
            if (i >= loop) goto L19;
            fos.write(buff);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            i = i + 1;     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            goto L11
        L19:
            fos.flush();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
            if (n != (N - 1)) goto L51;
            this.mReservedFull = true;     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        L51:
            fos.close();     // Catch: IOException -> L25
        L37:
            if (step == false) goto L45;
            return;
        L25:
            e = move-exception;
            e.printStackTrace();
            goto L37
        L13:
            th = move-exception;
            if (fos != null) goto L49;
        L44:
            throw th;
        L49:
            fos.close();     // Catch: IOException -> L42
        L42:
            e = move-exception;
            e.printStackTrace();
        L17:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L13
            if (fos == null) goto L37;
            fos.close();     // Catch: IOException -> L25
        L15:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L13
            if (fos == null) goto L37;
            fos.close();     // Catch: IOException -> L25
        L45:
            n = n + 1;
            goto L6
        }

        public boolean release() {
            int N = (int) (DeviceStorageMonitorServiceSmtEx.m8430$$Nest$sfgetDEFAULT_BACKUP_TOTAL_SIZE() / DeviceStorageMonitorServiceSmtEx.m8429$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE());
            int n = N - 1;
        L3:
            if (n < 0) goto L16;
            File file = new File(DeviceStorageMonitorServiceSmtEx.m8431$$Nest$sfgetRESERVE_DIR() + "/mem" + String.valueOf(n));
            if (file.exists() == false) goto L10;
            boolean deleted = file.delete();
            if (deleted == true) goto L8;
            Slog.e(DeviceStorageMonitorServiceSmtEx.TAG, "failed to release reserve " + file.getName());
            goto L10
        L8:
            this.mReservedFull = false;
            return true;
        L10:
            n = n - 1;
            goto L3
        L16:
            return false;
        }
    }

    public static class StateSmtEx {
        public static final int LEVEL_COMPLETE_FULL = 3;

        public StateSmtEx() {
        }
    }

    public class TrafficStats {

        @Deprecated
        public static final long GB_IN_BYTES = 1073741824;

        @Deprecated
        public static final long KB_IN_BYTES = 1024;

        @Deprecated
        public static final long MB_IN_BYTES = 1048576;

        @Deprecated
        public static final long PB_IN_BYTES = 1125899906842624L;

        @Deprecated
        public static final long TB_IN_BYTES = 1099511627776L;
        public static final int UNSUPPORTED = -1;

        public TrafficStats(DeviceStorageMonitorServiceSmtEx this$0) {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMemFullDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ StorageFullDialog m8427$$Nest$fgetmMemFullDialog(DeviceStorageMonitorServiceSmtEx r0) {
        return r0.mMemFullDialog;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMemFullDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8428$$Nest$fputmMemFullDialog(DeviceStorageMonitorServiceSmtEx r0, StorageFullDialog r1) {
        r0.mMemFullDialog = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m8429$$Nest$sfgetDEFAULT_BACKUP_STEP_SIZE() {
        return DEFAULT_BACKUP_STEP_SIZE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT_BACKUP_TOTAL_SIZE, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m8430$$Nest$sfgetDEFAULT_BACKUP_TOTAL_SIZE() {
        return DEFAULT_BACKUP_TOTAL_SIZE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetRESERVE_DIR, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8431$$Nest$sfgetRESERVE_DIR() {
        return RESERVE_DIR;
    }

    static {
        DEFAULT_BACKUP_STEP_SIZE = TrafficStats.MB_IN_BYTES;
        DEFAULT_BACKUP_TOTAL_SIZE = 52428800;
        DEFAULT_CHECK_MIN_INTERVAL = 1000;
        STORAGE_LOW_NOTIFY_INTERVAL = SystemProperties.getLong("persist.memlow.interval", 86400000);
        STORAGE_FULL_DLG_INTERVAL = SystemProperties.getLong("persist.memfull.interval", 86400000);
        RESERVE_DIR = Environment.getDataDirectory() + "/system/reserve";
    }

    public DeviceStorageMonitorServiceSmtEx(DeviceStorageMonitorService service) {
        this.mCheckInterval = 60000;
        this.mLastMemLowNotifyTime = -1;
        this.mLastMemFullTime = -1;
        this.mDismissListener = new AnonymousClass1(this);
        this.mService = service;
    }

    public void setSystemReady(boolean systemReady) {
        this.mReady = systemReady;
    }

    public void setBootComplete() {
        this.mBootComplete = true;
    }

    protected void init(Context context) {
        this.mBackupMem = new BackupMemory(this);
    }

    public final void notifyDismiss() {
        this.mLastMemFullTime = SystemClock.elapsedRealtime();
    }

    protected void setMemThreshold() {
        long fullThreshold = ((StorageManager) this.mService.getContext().getSystemService(StorageManager.class)).getStorageFullBytes(Environment.getDataDirectory());
        this.mMemReleaseThreshold = fullThreshold / 5;
        this.mMemReserveThreshold = (4 * fullThreshold) / 5;
    }

    public void updateBroadcasts(int oldLevel, int newLevel, int seq) {
        Intent completeFullIntent = new Intent("com.obric.action.DEVICE_STORAGE_COMPLETE_FULL").addFlags(67108864).putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, seq);
        Intent notCompleteFullIntent = new Intent("com.obric.action.DEVICE_STORAGE_NOT_COMPLETE_FULL").addFlags(67108864).putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, seq);
        if (DeviceStorageMonitorService.State.isEntering(3, oldLevel, newLevel) == false) goto L6;
        this.mService.getContext().sendStickyBroadcastAsUser(completeFullIntent, UserHandle.ALL);
        return;
    L6:
        if (DeviceStorageMonitorService.State.isLeaving(3, oldLevel, newLevel) == false) goto L10;
        this.mService.getContext().removeStickyBroadcastAsUser(completeFullIntent, UserHandle.ALL);
        this.mService.getContext().sendBroadcastAsUser(notCompleteFullIntent, UserHandle.ALL);
        return;
    }

    protected final void updateCheckInterval(VolumeInfo vol, int oldLevel, int newLevel, long usableBytes) {
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, vol.getFsUuid()) == true) goto L6;
        return;
    L6:
        if (newLevel != 2) goto L16;
        if (usableBytes > this.mMemReleaseThreshold) goto L11;
        this.mCheckInterval = DEFAULT_CHECK_MIN_INTERVAL;
        return;
    L11:
        if (usableBytes > this.mMemReserveThreshold) goto L13;
        long x = (usableBytes - this.mMemReserveThreshold) / TrafficStats.MB_IN_BYTES;
        long y = (DEFAULT_CHECK_MIN_INTERVAL + 30000) - (((x * x) * 25) / 3);
        this.mCheckInterval = Math.min(y, 30000);
        return;
    L13:
        this.mCheckInterval = 30000;
        return;
    L16:
        if (newLevel != 1) goto L18;
        this.mCheckInterval = 30000;
        return;
    L18:
        this.mCheckInterval = 60000;
    }

    protected final long checkCompleteFull(VolumeInfo vol, long usableBytes) {
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, vol.getFsUuid()) == true) goto L6;
        return usableBytes;
    L6:
        if (usableBytes <= this.mMemReserveThreshold) goto L10;
        this.mBackupMem.reserve(true);
        return usableBytes - DEFAULT_BACKUP_STEP_SIZE;
    L10:
        if (usableBytes >= this.mMemReleaseThreshold) goto L17;
        boolean released = this.mBackupMem.release();
        if (released == false) goto L14;
        long r1 = DEFAULT_BACKUP_STEP_SIZE;
    L16:
        return r1 + usableBytes;
    L14:
        r1 = 0;
        goto L16
    L17:
        return usableBytes;
    }

    protected final boolean shouldDisplayMemLowNotification(int level, int oldLevel, int newLevel) {
        StringBuilder r0 = new StringBuilder();
        r0.append("shouldDisplayMemLowNotification:, mBootComplete=");
        r0.append(this.mBootComplete);
        r0.append(", level=");
        r0.append(oldLevel);
        r0.append("->");
        r0.append(newLevel);
        r0.append(", mLastMemLowNotifyTime=");
        if (this.mLastMemLowNotifyTime >= 0) goto L5;
        String r1 = "NONE";
    L6:
        r0.append(r1);
        Slog.d(TAG, r0.toString());
        if (this.mBootComplete == true) goto L10;
        return false;
    L10:
        if (this.mService.mForceLevel == 1) goto L12;
        long currTime = SystemClock.elapsedRealtime();
        if (this.mLastMemLowNotifyTime > 0) goto L16;
    L18:
        if (newLevel == 1) goto L20;
        return false;
    L20:
        return true;
    L16:
        if ((currTime - this.mLastMemLowNotifyTime) >= STORAGE_LOW_NOTIFY_INTERVAL) goto L18;
        return false;
    L12:
        return DeviceStorageMonitorService.State.isEntering(level, oldLevel, newLevel);
    L5:
        r1 = TimeUtils.formatRealtime(this.mLastMemLowNotifyTime);
        goto L6
    }

    protected final void updateFullState(VolumeInfo vol, int oldLevel, int newLevel) {
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, vol.getFsUuid()) == true) goto L6;
        return;
    L6:
        if (DeviceStorageMonitorService.State.isEntering(2, oldLevel, newLevel) == false) goto L9;
        SystemProperties.set(SYS_STORAGE_FULL, "1");
    L11:
        if (newLevel >= 2) goto L13;
        return;
    L13:
        if (this.mReady == false) goto L17;
        showFullDialog();
        return;
    L17:
        return;
    L9:
        if (DeviceStorageMonitorService.State.isLeaving(2, oldLevel, newLevel) == false) goto L11;
        SystemProperties.set(SYS_STORAGE_FULL, "0");
        hideFullDialog();
        goto L11
    }

    private final void showFullDialog() {
        if (this.mLastMemFullTime <= 0) goto L8;
        if ((SystemClock.elapsedRealtime() - this.mLastMemFullTime) >= STORAGE_FULL_DLG_INTERVAL) goto L8;
        return;
    L8:
        if (this.mMemFullDialog != null) goto L10;
        this.mMemFullDialog = new StorageFullDialog(this.mService.getContext(), this.mService);
    L10:
        this.mLastMemFullTime = SystemClock.elapsedRealtime();
        this.mMemFullDialog.setOnDismissListener(this.mDismissListener);
        this.mMemFullDialog.show();
    }

    private final void hideFullDialog() {
        this.mLastMemFullTime = -1;
        if (this.mMemFullDialog == null) goto L6;
        this.mMemFullDialog.dismiss();
        return;
    }
}
