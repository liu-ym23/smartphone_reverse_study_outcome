package com.android.server;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.KeyValueListParser;
import android.util.Slog;
import com.android.internal.os.AppIdToPackageMap;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.CachedDeviceState;
import com.android.internal.os.LooperStats;
import com.android.internal.util.DumpUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LooperStatsService extends Binder {
    private static final String DEBUG_SYS_LOOPER_STATS_ENABLED = "debug.sys.looper_stats_enabled";
    private static final boolean DEFAULT_ENABLED = true;
    private static final int DEFAULT_ENTRIES_SIZE_CAP = 1500;
    private static final int DEFAULT_SAMPLING_INTERVAL = 1000;
    private static final boolean DEFAULT_TRACK_SCREEN_INTERACTIVE = false;
    private static final String LOOPER_STATS_SERVICE_NAME = "looper_stats";
    private static final String SETTINGS_ENABLED_KEY = "enabled";
    private static final String SETTINGS_IGNORE_BATTERY_STATUS_KEY = "ignore_battery_status";
    private static final String SETTINGS_SAMPLING_INTERVAL_KEY = "sampling_interval";
    private static final String SETTINGS_TRACK_SCREEN_INTERACTIVE_KEY = "track_screen_state";
    private static final String TAG = "LooperStatsService";
    private final Context mContext;
    private boolean mEnabled;
    private boolean mIgnoreBatteryStatus;
    private final LooperStats mStats;
    private boolean mTrackScreenInteractive;

    public static class Lifecycle extends SystemService {
        private final LooperStatsService mService;
        private final SettingsObserver mSettingsObserver;
        private final LooperStats mStats;

        public Lifecycle(Context context) {
            super(context);
            this.mStats = new LooperStats(1000, 1500);
            this.mService = new LooperStatsService(getContext(), this.mStats, null);
            this.mSettingsObserver = new SettingsObserver(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishLocalService(LooperStats.class, this.mStats);
            publishBinderService(LooperStatsService.LOOPER_STATS_SERVICE_NAME, this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (500 != phase) goto L6;
            LooperStatsService.m259$$Nest$minitFromSettings(this.mService);
            Uri settingsUri = Settings.Global.getUriFor(LooperStatsService.LOOPER_STATS_SERVICE_NAME);
            getContext().getContentResolver().registerContentObserver(settingsUri, false, this.mSettingsObserver, 0);
            this.mStats.setDeviceState((CachedDeviceState.Readonly) getLocalService(CachedDeviceState.Readonly.class));
            return;
        }
    }

    private class LooperShellCommand extends ShellCommand {
        final /* synthetic */ LooperStatsService this$0;

        /* synthetic */ LooperShellCommand(LooperStatsService r1, LooperStatsServiceIA r2) {
            this(r1);
        }

        private LooperShellCommand(LooperStatsService r1) {
            this.this$0 = r1;
        }

        public int onCommand(String cmd) {
            if ("enable".equals(cmd) == false) goto L7;
            LooperStatsService.m260$$Nest$msetEnabled(this.this$0, true);
            return 0;
        L7:
            if ("disable".equals(cmd) == false) goto L11;
            LooperStatsService.m260$$Nest$msetEnabled(this.this$0, false);
            return 0;
        L11:
            if ("reset".equals(cmd) == false) goto L15;
            LooperStatsService.m258$$Nest$fgetmStats(this.this$0).reset();
            return 0;
        L15:
            if (LooperStatsService.SETTINGS_SAMPLING_INTERVAL_KEY.equals(cmd) == false) goto L18;
            int sampling = Integer.parseUnsignedInt(getNextArgRequired());
            LooperStatsService.m261$$Nest$msetSamplingInterval(this.this$0, sampling);
            return 0;
        L18:
            int sampling2 = handleDefaultCommands(cmd);
            return sampling2;
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("looper_stats commands:");
            pw.println("  enable: Enable collecting stats.");
            pw.println("  disable: Disable collecting stats.");
            pw.println("  sampling_interval: Change the sampling interval.");
            pw.println("  reset: Reset stats.");
        }
    }

    private static class SettingsObserver extends ContentObserver {
        private final LooperStatsService mService;

        SettingsObserver(LooperStatsService service) {
            super(BackgroundThread.getHandler());
            this.mService = service;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            LooperStatsService.m259$$Nest$minitFromSettings(this.mService);
        }
    }

    public static /* synthetic */ String $r8$lambda$MFPLAKaAxjCatukZvbsKxcN2Mn4(LooperStats.ExportedEntry r0) {
        return lambda$dump$3(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$cUV0btwwOY1uYxUwT1mxYzTD78Q(LooperStats.ExportedEntry r0) {
        return lambda$dump$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dL_zJkoZu_QSoZ27oRJg-oPEqQM, reason: not valid java name */
    public static /* synthetic */ String m257$r8$lambda$dL_zJkoZu_QSoZ27oRJgoPEqQM(LooperStats.ExportedEntry r0) {
        return lambda$dump$1(r0);
    }

    public static /* synthetic */ String $r8$lambda$eWCqd7y5GHobibEFGYerm5LvqBw(LooperStats.ExportedEntry r0) {
        return lambda$dump$2(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ LooperStats m258$$Nest$fgetmStats(LooperStatsService r0) {
        return r0.mStats;
    }

    /* JADX INFO: renamed from: -$$Nest$minitFromSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m259$$Nest$minitFromSettings(LooperStatsService r0) {
        r0.initFromSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m260$$Nest$msetEnabled(LooperStatsService r0, boolean r1) {
        r0.setEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetSamplingInterval, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m261$$Nest$msetSamplingInterval(LooperStatsService r0, int r1) {
        r0.setSamplingInterval(r1);
    }

    /* synthetic */ LooperStatsService(Context r1, LooperStats r2, LooperStatsServiceIA r3) {
        this(r1, r2);
    }

    private LooperStatsService(Context context, LooperStats stats) {
        this.mEnabled = false;
        this.mTrackScreenInteractive = false;
        this.mIgnoreBatteryStatus = false;
        this.mContext = context;
        this.mStats = stats;
    }

    private void initFromSettings() {
        KeyValueListParser parser = new KeyValueListParser(',');
        parser.setString(Settings.Global.getString(this.mContext.getContentResolver(), LOOPER_STATS_SERVICE_NAME));     // Catch: IllegalArgumentException -> L5
    L7:
        setSamplingInterval(parser.getInt(SETTINGS_SAMPLING_INTERVAL_KEY, 1000));
        setTrackScreenInteractive(parser.getBoolean(SETTINGS_TRACK_SCREEN_INTERACTIVE_KEY, false));
        setIgnoreBatteryStatus(parser.getBoolean(SETTINGS_IGNORE_BATTERY_STATUS_KEY, false));
        setEnabled(SystemProperties.getBoolean(DEBUG_SYS_LOOPER_STATS_ENABLED, parser.getBoolean("enabled", true)));
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Bad looper_stats settings", e);
        goto L7
    }

    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new LooperShellCommand(this, null).exec(this, in, out, err, args, callback, resultReceiver);
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        AppIdToPackageMap packageMap = AppIdToPackageMap.getSnapshot();
        pw.print("Start time: ");
        pw.println(DateFormat.format("yyyy-MM-dd HH:mm:ss", this.mStats.getStartTimeMillis()));
        pw.print("On battery time (ms): ");
        pw.println(this.mStats.getBatteryTimeMillis());
        List<LooperStats.ExportedEntry> entries = this.mStats.getEntries();
        entries.sort(Comparator.comparing(new LooperStatsService$$ExternalSyntheticLambda0()).thenComparing(new LooperStatsService$$ExternalSyntheticLambda1()).thenComparing(new LooperStatsService$$ExternalSyntheticLambda2()).thenComparing(new LooperStatsService$$ExternalSyntheticLambda3()));
        String header = String.join(",", Arrays.asList(new String[]{"work_source_uid", "thread_name", "handler_class", "message_name", "is_interactive", "message_count", "recorded_message_count", "total_latency_micros", "max_latency_micros", "total_cpu_micros", "max_cpu_micros", "recorded_delay_message_count", "total_delay_millis", "max_delay_millis", "exception_count"}));
        pw.println(header);
        Iterator<LooperStats.ExportedEntry> r5 = entries.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        LooperStats.ExportedEntry entry = r5.next();
        if (entry.messageName.startsWith("__DEBUG_") == true) goto L7;
        AppIdToPackageMap packageMap2 = packageMap;
        pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", new Object[]{packageMap.mapUid(entry.workSourceUid), entry.threadName, entry.handlerClassName, entry.messageName, Boolean.valueOf(entry.isInteractive), Long.valueOf(entry.messageCount), Long.valueOf(entry.recordedMessageCount), Long.valueOf(entry.totalLatencyMicros), Long.valueOf(entry.maxLatencyMicros), Long.valueOf(entry.cpuUsageMicros), Long.valueOf(entry.maxCpuUsageMicros), Long.valueOf(entry.recordedDelayMessageCount), Long.valueOf(entry.delayMillis), Long.valueOf(entry.maxDelayMillis), Long.valueOf(entry.exceptionCount)});
        packageMap = packageMap2;
        entries = entries;
        goto L7
    }

    private static /* synthetic */ Integer lambda$dump$0(LooperStats.ExportedEntry entry) {
        return Integer.valueOf(entry.workSourceUid);
    }

    private static /* synthetic */ String lambda$dump$1(LooperStats.ExportedEntry entry) {
        return entry.threadName;
    }

    private static /* synthetic */ String lambda$dump$2(LooperStats.ExportedEntry entry) {
        return entry.handlerClassName;
    }

    private static /* synthetic */ String lambda$dump$3(LooperStats.ExportedEntry entry) {
        return entry.messageName;
    }

    private void setEnabled(boolean enabled) {
        if (this.mEnabled == enabled) goto L10;
        this.mEnabled = enabled;
        this.mStats.reset();
        this.mStats.setAddDebugEntries(enabled);
        if (enabled == false) goto L7;
        LooperStats r0 = this.mStats;
    L8:
        Looper.setObserver(r0);
        return;
    L7:
        r0 = null;
        goto L8
    }

    private void setTrackScreenInteractive(boolean enabled) {
        if (this.mTrackScreenInteractive == enabled) goto L6;
        this.mTrackScreenInteractive = enabled;
        this.mStats.reset();
        return;
    }

    private void setIgnoreBatteryStatus(boolean ignore) {
        if (this.mIgnoreBatteryStatus == ignore) goto L6;
        this.mStats.setIgnoreBatteryStatus(ignore);
        this.mIgnoreBatteryStatus = ignore;
        this.mStats.reset();
        return;
    }

    private void setSamplingInterval(int samplingInterval) {
        if (samplingInterval <= 0) goto L4;
        this.mStats.setSamplingInterval(samplingInterval);
        return;
    L4:
        Slog.w(TAG, "Ignored invalid sampling interval (value must be positive): " + samplingInterval);
    }
}
