package com.android.server.storage;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.DataUnit;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.utils.PriorityDump;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStorageMonitorService extends SystemService {
    private static final long BOOT_IMAGE_STORAGE_REQUIREMENT = 0;
    private static final long DEFAULT_LOG_DELTA_BYTES = 0;
    public static final String EXTRA_SEQUENCE = "seq";
    private static final long HIGH_CHECK_INTERVAL = 36000000;
    private static final long LOW_CHECK_INTERVAL = 60000;
    private static final int MSG_CHECK_HIGH = 2;
    private static final int MSG_CHECK_LOW = 1;
    static final int OPTION_FORCE_UPDATE = 1;
    static final String SERVICE = "devicestoragemonitor";
    private static final String TAG = "DeviceStorageMonitorService";
    protected static final String TV_NOTIFICATION_CHANNEL_ID = "devicestoragemonitor.tv";
    private CacheFileDeletedObserver mCacheFileDeletedObserver;
    protected volatile int mForceLevel;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final DeviceStorageMonitorInternal mLocalService;
    private NotificationManager mNotifManager;
    private final Binder mRemoteService;
    private final AtomicInteger mSeq;
    private final DeviceStorageMonitorServiceSmtEx mSmtEx;
    private final ArrayMap<UUID, State> mStates;

    private static class CacheFileDeletedObserver extends FileObserver {
        public CacheFileDeletedObserver() {
            super(Environment.getDownloadCacheDirectory().getAbsolutePath(), 512);
        }

        @Override // android.os.FileObserver
        public void onEvent(int event, String path) {
            EventLogTags.writeCacheFileDeleted(path);
        }
    }

    class Shell extends ShellCommand {
        final /* synthetic */ DeviceStorageMonitorService this$0;

        Shell(DeviceStorageMonitorService this$0) {
            this.this$0 = this$0;
        }

        public int onCommand(String cmd) {
            return this.this$0.onShellCommand(this, cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            DeviceStorageMonitorService.dumpHelp(pw);
        }
    }

    protected static class State {
        protected static final int LEVEL_FULL = 2;
        protected static final int LEVEL_LOW = 1;
        private static final int LEVEL_NORMAL = 0;
        private static final int LEVEL_UNKNOWN = -1;
        public long lastUsableBytes;
        public int level;

        /* JADX INFO: renamed from: -$$Nest$smlevelToString, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8426$$Nest$smlevelToString(int r0) {
            return levelToString(r0);
        }

        protected State() {
            this.level = 0;
            this.lastUsableBytes = Long.MAX_VALUE;
        }

        static boolean isEntering(int level, int oldLevel, int newLevel) {
            if (newLevel < level) goto L7;
            if (oldLevel >= level) goto L5;
        L6:
            return true;
        L5:
            if (oldLevel == (-1)) goto L6;
        L7:
            return false;
        }

        static boolean isLeaving(int level, int oldLevel, int newLevel) {
            if (newLevel >= level) goto L7;
            if (oldLevel < level) goto L5;
        L6:
            return true;
        L5:
            if (oldLevel == (-1)) goto L6;
        L7:
            return false;
        }

        private static String levelToString(int level) {
            switch(level) {
                case -1: goto L11;
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L5;
                default: goto L4;
            };
        L5:
            return "FULL";
        L7:
            return "LOW";
        L9:
            return PriorityDump.PRIORITY_ARG_NORMAL;
        L11:
            return "UNKNOWN";
        L4:
            return Integer.toString(level);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8423$$Nest$fgetmHandler(DeviceStorageMonitorService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckHigh, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8424$$Nest$mcheckHigh(DeviceStorageMonitorService r0) {
        r0.checkHigh();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckLow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8425$$Nest$mcheckLow(DeviceStorageMonitorService r0) {
        r0.checkLow();
    }

    static {
        DEFAULT_LOG_DELTA_BYTES = DataUnit.MEBIBYTES.toBytes(64);
        BOOT_IMAGE_STORAGE_REQUIREMENT = DataUnit.MEBIBYTES.toBytes(250);
    }

    private State findOrCreateState(UUID uuid) {
        State state = this.mStates.get(uuid);
        if (state != null) goto L6;
        State state2 = new State();
        this.mStates.put(uuid, state2);
        return state2;
    L6:
        return state;
    }

    private void checkLow() {
        Slog.d(TAG, "checkLow: start");
        StorageManager storage = (StorageManager) getContext().getSystemService(StorageManager.class);
        int seq = this.mSeq.get();
        Iterator r5 = storage.getWritablePrivateVolumes().iterator();
    L4:
        if (r5.hasNext() == false) goto L41;
        VolumeInfo vol = (VolumeInfo) r5.next();
        File file = vol.getPath();
        long fullBytes = storage.getStorageFullBytes(file);
        long lowBytes = storage.getStorageLowBytes(file);
        if (file.getUsableSpace() >= ((3 * lowBytes) / 2)) goto L12;
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        pm.freeStorage(vol.getFsUuid(), lowBytes * 2, 0);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, e);
    L12:
        UUID uuid = StorageManager.convert(vol.getFsUuid());
        State state = findOrCreateState(uuid);
        long totalBytes = file.getTotalSpace();
        long usableBytes = this.mSmtEx.checkCompleteFull(vol, file.getUsableSpace());
        int oldLevel = state.level;
        if (this.mForceLevel == (-1)) goto L16;
        oldLevel = -1;
        int newLevel = this.mForceLevel;
    L31:
        if (Math.abs(state.lastUsableBytes - usableBytes) > DEFAULT_LOG_DELTA_BYTES) goto L35;
        if (oldLevel != newLevel) goto L35;
        long usableBytes2 = usableBytes;
    L36:
        StringBuilder r0 = new StringBuilder();
        StorageManager storage2 = storage;
        r0.append("checkLow: old=");
        r0.append(oldLevel);
        r0.append(", new=");
        r0.append(newLevel);
        Slog.d(TAG, r0.toString());
        updateNotifications(vol, oldLevel, newLevel);
        updateBroadcasts(vol, oldLevel, newLevel, seq);
        this.mSmtEx.updateFullState(vol, oldLevel, newLevel);
        this.mSmtEx.updateCheckInterval(vol, oldLevel, newLevel, usableBytes2);
        state.level = newLevel;
        if (file.getPath().equals("/data") == false) goto L39;
        SysMonitorSvcBridge.getFactory().getFallocateManager().fallocateOrRelease(file);
    L39:
        storage = storage2;
    L35:
        EventLogTags.writeStorageState(uuid.toString(), oldLevel, newLevel, usableBytes, totalBytes);
        usableBytes2 = usableBytes;
        state.lastUsableBytes = usableBytes2;
        goto L36
    L16:
        if (usableBytes >= 10485760) goto L19;
        newLevel = 3;
        goto L31
    L19:
        if (usableBytes > fullBytes) goto L22;
        newLevel = 2;
        goto L31
    L22:
        if (usableBytes > lowBytes) goto L25;
        newLevel = 1;
        goto L31
    L25:
        if (StorageManager.UUID_DEFAULT.equals(uuid) == true) goto L27;
    L29:
        newLevel = 0;
        goto L31
    L27:
        if (usableBytes >= BOOT_IMAGE_STORAGE_REQUIREMENT) goto L29;
        newLevel = 1;
        goto L31
    L41:
        if (this.mHandler.hasMessages(1) == true) goto L44;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), getSmtEx().mCheckInterval);
    L44:
        if (this.mHandler.hasMessages(2) == true) goto L52;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), getSmtEx().mCheckInterval);
        return;
    }

    private void checkHigh() {
        StorageManager storage = (StorageManager) getContext().getSystemService(StorageManager.class);
        int storageThresholdPercentHigh = DeviceConfig.getInt("storage_native_boot", "storage_threshold_percent_high", 20);
        Iterator r2 = storage.getWritablePrivateVolumes().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        VolumeInfo vol = (VolumeInfo) r2.next();
        File file = vol.getPath();
        if (file.getUsableSpace() >= ((file.getTotalSpace() * ((long) storageThresholdPercentHigh)) / 100)) goto L4;
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        pm.freeAllAppCacheAboveQuota(vol.getFsUuid());     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, e);
        goto L4
    L14:
        if (this.mHandler.hasMessages(2) == true) goto L25;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), HIGH_CHECK_INTERVAL);
        return;
    }

    public DeviceStorageMonitorService(Context context) {
        super(context);
        this.mSeq = new AtomicInteger(1);
        this.mForceLevel = -1;
        this.mStates = new ArrayMap();
        this.mLocalService = new AnonymousClass2(this);
        this.mRemoteService = new AnonymousClass3(this);
        this.mSmtEx = new DeviceStorageMonitorServiceSmtEx(this);
        this.mHandlerThread = new HandlerThread(TAG, 10);
        this.mHandlerThread.start();
        final Looper r1 = this.mHandlerThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mSmtEx.init(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Context context = getContext();
        this.mNotifManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        this.mSmtEx.setMemThreshold();
        this.mCacheFileDeletedObserver = new CacheFileDeletedObserver();
        this.mCacheFileDeletedObserver.startWatching();
        PackageManager packageManager = context.getPackageManager();
        boolean isTv = packageManager.hasSystemFeature("android.software.leanback");
        if (isTv == false) goto L5;
        this.mNotifManager.createNotificationChannel(new NotificationChannel(TV_NOTIFICATION_CHANNEL_ID, context.getString(R.string.error_handwriting_unsupported), 4));
    L5:
        publishBinderService(SERVICE, this.mRemoteService);
        publishLocalService(DeviceStorageMonitorInternal.class, this.mLocalService);
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    int parseOptions(Shell shell) {
        int opts = 0;
    L3:
        String opt = shell.getNextOption();
        if (opt == null) goto L8;
        if ("-f".equals(opt) == false) goto L3;
        opts = opts | 1;
        goto L3
    L8:
        return opts;
    }

    int onShellCommand(Shell shell, String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = shell.getOutPrintWriter();
        switch(cmd.hashCode()) {
            case 108404047: goto L15;
            case 1526871410: goto L12;
            case 1692300408: goto L9;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L19:
        switch(r1) {
            case 0: goto L30;
            case 1: goto L26;
            case 2: goto L22;
            default: goto L21;
        };
    L22:
        int opts = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        this.mForceLevel = -1;
        int seq = this.mSeq.incrementAndGet();
        if ((opts & 1) == 0) goto L34;
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1).sendToTarget();
        pw.println(seq);
    L34:
        return 0;
    L26:
        int opts2 = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        this.mForceLevel = 0;
        int seq2 = this.mSeq.incrementAndGet();
        if ((opts2 & 1) == 0) goto L34;
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1).sendToTarget();
        pw.println(seq2);
        goto L34
    L30:
        int opts3 = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        this.mForceLevel = 1;
        int seq3 = this.mSeq.incrementAndGet();
        if ((opts3 & 1) == 0) goto L34;
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1).sendToTarget();
        pw.println(seq3);
        goto L34
    L21:
        return shell.handleDefaultCommands(cmd);
    L9:
        if (cmd.equals("force-not-low") == false) goto L35;
        r1 = 1;
        goto L19
    L35:
        r1 = -1;
        goto L19
    L12:
        if (cmd.equals("force-low") == false) goto L36;
        r1 = 0;
        goto L19
    L36:
        r1 = -1;
        goto L19
    L15:
        if (cmd.equals("reset") == false) goto L37;
        r1 = 2;
        goto L19
    L37:
        r1 = -1;
        goto L19
    L4:
        return shell.handleDefaultCommands(cmd);
    }

    static void dumpHelp(PrintWriter pw) {
        pw.println("Device storage monitor service (devicestoragemonitor) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  force-low [-f]");
        pw.println("    Force storage to be low, freezing storage state.");
        pw.println("    -f: force a storage change broadcast be sent, prints new sequence.");
        pw.println("  force-not-low [-f]");
        pw.println("    Force storage to not be low, freezing storage state.");
        pw.println("    -f: force a storage change broadcast be sent, prints new sequence.");
        pw.println("  reset [-f]");
        pw.println("    Unfreeze storage state, returning to current real values.");
        pw.println("    -f: force a storage change broadcast be sent, prints new sequence.");
    }

    void dumpImpl(FileDescriptor fd, PrintWriter _pw, String[] args) {
        IndentingPrintWriter pw = new IndentingPrintWriter(_pw, "  ");
        if (args == null) goto L11;
        if (args.length == 0) goto L11;
        if ("-a".equals(args[0]) == true) goto L11;
        Shell shell = new Shell(this);
        shell.exec(this.mRemoteService, null, fd, null, args, null, new ResultReceiver(null));
        return;
    L11:
        StorageManager storage = (StorageManager) getContext().getSystemService(StorageManager.class);
        pw.println("Known volumes:");
        pw.increaseIndent();
        int i = 0;
    L13:
        if (i >= this.mStates.size()) goto L26;
        UUID uuid = this.mStates.keyAt(i);
        State state = this.mStates.valueAt(i);
        if (StorageManager.UUID_DEFAULT.equals(uuid) == false) goto L17;
        pw.println("Default:");
    L18:
        pw.increaseIndent();
        pw.printPair("level", State.m8426$$Nest$smlevelToString(state.level));
        pw.printPair("lastUsableBytes", Long.valueOf(state.lastUsableBytes));
        pw.println();
        Iterator r3 = storage.getWritablePrivateVolumes().iterator();
    L20:
        if (r3.hasNext() == false) goto L25;
        VolumeInfo vol = (VolumeInfo) r3.next();
        File file = vol.getPath();
        UUID innerUuid = StorageManager.convert(vol.getFsUuid());
        if (Objects.equals(uuid, innerUuid) == false) goto L20;
        pw.print("lowBytes=");
        pw.print(storage.getStorageLowBytes(file));
        pw.print(" fullBytes=");
        pw.println(storage.getStorageFullBytes(file));
        pw.print("path=");
        pw.println(file);
    L25:
        pw.decreaseIndent();
        i = i + 1;
        goto L13
    L17:
        pw.println(uuid + ":");
        goto L18
    L26:
        pw.decreaseIndent();
        pw.println();
        pw.printPair("mSeq", Integer.valueOf(this.mSeq.get()));
        pw.printPair("mForceState", State.m8426$$Nest$smlevelToString(this.mForceLevel));
        pw.println();
        pw.println();
    }

    private void updateNotifications(VolumeInfo vol, int oldLevel, int newLevel) {
        Context context = getContext();
        UUID uuid = StorageManager.convert(vol.getFsUuid());
        if (State.isEntering(1, oldLevel, newLevel) == false) goto L7;
        Intent lowMemIntent = new Intent("android.os.storage.action.MANAGE_STORAGE");
        lowMemIntent.putExtra("android.os.storage.extra.UUID", uuid);
        lowMemIntent.addFlags(268435456);
        CharSequence title = context.getText(R.string.mime_type_presentation_ext);
        CharSequence details = context.getText(R.string.mime_type_image_ext);
        PendingIntent intent = PendingIntent.getActivityAsUser(context, 0, lowMemIntent, 67108864, null, UserHandle.CURRENT);
        Notification notification = new Notification.Builder(context, "ALERTS").setSmallIcon(17305166).setTicker(title).setColor(context.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(details).setContentIntent(intent).setStyle(new Notification.BigTextStyle().bigText(details)).setVisibility(1).setCategory("sys").extend(new Notification.TvExtender().setChannelId(TV_NOTIFICATION_CHANNEL_ID)).build();
        notification.flags |= 32;
        FrameworkStatsLog.write(130, Objects.toString(vol.getDescription()), 2);
        return;
    L7:
        if (State.isLeaving(1, oldLevel, newLevel) == false) goto L11;
        FrameworkStatsLog.write(130, Objects.toString(vol.getDescription()), 1);
        return;
    }

    private void updateBroadcasts(VolumeInfo vol, int oldLevel, int newLevel, int seq) {
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, vol.getFsUuid()) == true) goto L5;
        return;
    L5:
        Slog.d(TAG, "updateBroadcasts: old=" + oldLevel + ", new=" + newLevel);
        Intent lowIntent = new Intent("android.intent.action.DEVICE_STORAGE_LOW").addFlags(85983232).putExtra(EXTRA_SEQUENCE, seq);
        Intent notLowIntent = new Intent("android.intent.action.DEVICE_STORAGE_OK").addFlags(85983232).putExtra(EXTRA_SEQUENCE, seq);
        if (this.mSmtEx.shouldDisplayMemLowNotification(1, oldLevel, newLevel) == false) goto L9;
        getContext().sendStickyBroadcastAsUser(lowIntent, UserHandle.ALL);
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyDataStorageLevel(1);
        this.mSmtEx.mLastMemLowNotifyTime = SystemClock.elapsedRealtime();
    L11:
        Intent fullIntent = new Intent("android.intent.action.DEVICE_STORAGE_FULL").addFlags(67108864).putExtra(EXTRA_SEQUENCE, seq);
        Intent notFullIntent = new Intent("android.intent.action.DEVICE_STORAGE_NOT_FULL").addFlags(67108864).putExtra(EXTRA_SEQUENCE, seq);
        if (State.isEntering(2, oldLevel, newLevel) == false) goto L15;
        getContext().sendStickyBroadcastAsUser(fullIntent, UserHandle.ALL);
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyDataStorageLevel(2);
    L17:
        this.mSmtEx.updateBroadcasts(oldLevel, newLevel, seq);
        return;
    L15:
        if (State.isLeaving(2, oldLevel, newLevel) == false) goto L17;
        getContext().removeStickyBroadcastAsUser(fullIntent, UserHandle.ALL);
        getContext().sendBroadcastAsUser(notFullIntent, UserHandle.ALL);
        goto L17
    L9:
        if (State.isLeaving(1, oldLevel, newLevel) == false) goto L11;
        getContext().removeStickyBroadcastAsUser(lowIntent, UserHandle.ALL);
        getContext().sendBroadcastAsUser(notLowIntent, UserHandle.ALL);
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyDataStorageLevel(0);
        goto L11
    }

    public DeviceStorageMonitorServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        Slog.d(TAG, "onBootPhase: phase=" + phase);
        super.onBootPhase(phase);
        if (phase != 500) goto L6;
        this.mSmtEx.setSystemReady(true);
        this.mHandler.removeMessages(1);
        this.mHandler.obtainMessage(1).sendToTarget();
        return;
    L6:
        if (phase != 1000) goto L10;
        this.mSmtEx.setBootComplete();
        return;
    }
}
