package com.android.server;

import android.app.ActivityThread;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.net.util.NetworkConstants;
import android.os.BatteryStatsInternal;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.KeyValueListParser;
import android.util.Slog;
import com.android.internal.os.AppIdToPackageMap;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BinderCallsStats;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.CachedDeviceState;
import com.android.internal.util.DumpUtils;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BinderCallsStatsService extends Binder {
    private static final String PERSIST_SYS_BINDER_CALLS_DETAILED_TRACKING = "persist.sys.binder_calls_detailed_tracking";
    private static final String SERVICE_NAME = "binder_calls_stats";
    private static final String TAG = "BinderCallsStatsService";
    private final BinderCallsStats mBinderCallsStats;
    private SettingsObserver mSettingsObserver;
    private final AuthorizedWorkSourceProvider mWorkSourceProvider;

    static class AuthorizedWorkSourceProvider implements BinderInternal.WorkSourceProvider {
        private ArraySet<Integer> mAppIdTrustlist;

        AuthorizedWorkSourceProvider() {
            this.mAppIdTrustlist = new ArraySet();
        }

        public int resolveWorkSourceUid(int untrustedWorkSourceUid) {
            int callingUid = getCallingUid();
            int appId = UserHandle.getAppId(callingUid);
            if (this.mAppIdTrustlist.contains(Integer.valueOf(appId)) == true) goto L5;
            return callingUid;
        L5:
            if (untrustedWorkSourceUid == (-1)) goto L7;
            boolean isWorkSourceSet = true;
        L8:
            if (isWorkSourceSet == false) goto L11;
            return untrustedWorkSourceUid;
        L11:
            return callingUid;
        L7:
            isWorkSourceSet = false;
            goto L8
        }

        public void systemReady(Context context) {
            this.mAppIdTrustlist = createAppidTrustlist(context);
        }

        public void dump(PrintWriter pw, AppIdToPackageMap packageMap) {
            pw.println("AppIds of apps that can set the work source:");
            ArraySet<Integer> trustlist = this.mAppIdTrustlist;
            Iterator<Integer> r1 = trustlist.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Integer appId = r1.next();
            pw.println("\t- " + packageMap.mapAppId(appId.intValue()));
            goto L4
        }

        protected int getCallingUid() {
            return Binder.getCallingUid();
        }

        private ArraySet<Integer> createAppidTrustlist(Context context) {
            ArraySet<Integer> trustlist = new ArraySet();
            trustlist.add(Integer.valueOf(UserHandle.getAppId(Process.myUid())));
            PackageManager pm = context.getPackageManager();
            String[] permissions = {"android.permission.UPDATE_DEVICE_STATS"};
            List<PackageInfo> packages = pm.getPackagesHoldingPermissions(permissions, 786432);
            int packagesSize = packages.size();
            int i = 0;
        L3:
            if (i >= packagesSize) goto L11;
            PackageInfo pkgInfo = packages.get(i);
            int uid = pm.getPackageUid(pkgInfo.packageName, 786432);     // Catch: PackageManager.NameNotFoundException -> L7
            int appId = UserHandle.getAppId(uid);     // Catch: PackageManager.NameNotFoundException -> L7
            trustlist.add(Integer.valueOf(appId));     // Catch: PackageManager.NameNotFoundException -> L7
        L9:
            i = i + 1;
        L7:
            e = move-exception;
            Slog.e(BinderCallsStatsService.TAG, "Cannot find uid for package name " + pkgInfo.packageName, e);
            goto L9
        L11:
            return trustlist;
        }
    }

    private class BinderCallsStatsShellCommand extends ShellCommand {
        private final PrintWriter mPrintWriter;
        final /* synthetic */ BinderCallsStatsService this$0;

        BinderCallsStatsShellCommand(BinderCallsStatsService r1, PrintWriter printWriter) {
            this.this$0 = r1;
            this.mPrintWriter = printWriter;
        }

        public PrintWriter getOutPrintWriter() {
            if (this.mPrintWriter == null) goto L7;
            return this.mPrintWriter;
        L7:
            return super.getOutPrintWriter();
        }

        public int onCommand(String cmd) {
            PrintWriter pw = getOutPrintWriter();
            if (cmd != null) goto L6;
            return -1;
        L6:
            switch(cmd.hashCode()) {
                case -1615291473: goto L30;
                case -1289263917: goto L27;
                case -1237677752: goto L24;
                case -534486470: goto L21;
                case -106516359: goto L18;
                case 1101165347: goto L15;
                case 1448286703: goto L12;
                case 2041864970: goto L9;
                default: goto L32;
            };
        L32:
            byte r2 = -1;
        L34:
            switch(r2) {
                case 0: goto L49;
                case 1: goto L48;
                case 2: goto L47;
                case 3: goto L46;
                case 4: goto L45;
                case 5: goto L44;
                case 6: goto L43;
                case 7: goto L37;
                default: goto L36;
            };
        L37:
            String uidArg = getNextArgRequired();
            int uid = Integer.parseInt(uidArg);     // Catch: NumberFormatException -> L40
            BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0).recordAllCallsForWorkSourceUid(uid);     // Catch: NumberFormatException -> L40
        L50:
            return 0;
        L41:
            pw.println("Invalid UID: " + uidArg);
            return -1;
        L43:
            BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0).setDetailedTracking(true);
            BinderCallsStatsService.m138$$Nest$fgetmWorkSourceProvider(this.this$0).dump(pw, AppIdToPackageMap.getSnapshot());
            goto L50
        L44:
            SystemProperties.set(BinderCallsStatsService.PERSIST_SYS_BINDER_CALLS_DETAILED_TRACKING, "");
            BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0).setDetailedTracking(false);
            pw.println("Detailed tracking disabled");
            goto L50
        L45:
            SystemProperties.set(BinderCallsStatsService.PERSIST_SYS_BINDER_CALLS_DETAILED_TRACKING, "1");
            BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0).setDetailedTracking(true);
            pw.println("Detailed tracking enabled");
            goto L50
        L46:
            BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0).setSamplingInterval(1);
            goto L50
        L47:
            Binder.setObserver(null);
            goto L50
        L48:
            Binder.setObserver(BinderCallsStatsService.m137$$Nest$fgetmBinderCallsStats(this.this$0));
            goto L50
        L49:
            this.this$0.reset();
            pw.println("binder_calls_stats reset.");
            goto L50
        L36:
            return handleDefaultCommands(cmd);
        L9:
            if (cmd.equals("--enable-detailed-tracking") == false) goto L53;
            r2 = 4;
            goto L34
        L53:
            r2 = -1;
            goto L34
        L12:
            if (cmd.equals("--disable-detailed-tracking") == false) goto L54;
            r2 = 5;
            goto L34
        L54:
            r2 = -1;
            goto L34
        L15:
            if (cmd.equals("--enable") == false) goto L55;
            r2 = 1;
            goto L34
        L55:
            r2 = -1;
            goto L34
        L18:
            if (cmd.equals("--dump-worksource-provider") == false) goto L56;
            r2 = 6;
            goto L34
        L56:
            r2 = -1;
            goto L34
        L21:
            if (cmd.equals("--work-source-uid") == false) goto L57;
            r2 = 7;
            goto L34
        L57:
            r2 = -1;
            goto L34
        L24:
            if (cmd.equals("--disable") == false) goto L58;
            r2 = 2;
            goto L34
        L58:
            r2 = -1;
            goto L34
        L27:
            if (cmd.equals("--no-sampling") == false) goto L59;
            r2 = 3;
            goto L34
        L59:
            r2 = -1;
            goto L34
        L30:
            if (cmd.equals("--reset") == false) goto L60;
            r2 = 0;
            goto L34
        L60:
            r2 = -1;
            goto L34
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("binder_calls_stats commands:");
            pw.println("  --reset: Reset stats");
            pw.println("  --enable: Enable tracking binder calls");
            pw.println("  --disable: Disables tracking binder calls");
            pw.println("  --no-sampling: Tracks all calls");
            pw.println("  --enable-detailed-tracking: Enables detailed tracking");
            pw.println("  --disable-detailed-tracking: Disables detailed tracking");
            pw.println("  --work-source-uid <UID>: Track all binder calls from the UID");
        }
    }

    public static class Internal {
        private final BinderCallsStats mBinderCallsStats;

        Internal(BinderCallsStats binderCallsStats) {
            this.mBinderCallsStats = binderCallsStats;
        }

        public void reset() {
            this.mBinderCallsStats.reset();
        }

        public ArrayList<BinderCallsStats.ExportedCallStat> getExportedCallStats() {
            return this.mBinderCallsStats.getExportedCallStats();
        }

        public ArrayMap<String, Integer> getExportedExceptionStats() {
            return this.mBinderCallsStats.getExportedExceptionStats();
        }
    }

    public static class LifeCycle extends SystemService {
        private BinderCallsStats mBinderCallsStats;
        private BinderCallsStatsService mService;
        private AuthorizedWorkSourceProvider mWorkSourceProvider;

        /* JADX INFO: renamed from: com.android.server.BinderCallsStatsService$LifeCycle$1, reason: invalid class name */
        class AnonymousClass1 implements BinderInternal.CallStatsObserver {
            final /* synthetic */ BatteryStatsInternal val$batteryStatsInternal;

            AnonymousClass1(LifeCycle this$0, BatteryStatsInternal r2) {
                this.val$batteryStatsInternal = r2;
            }

            public void noteCallStats(int workSourceUid, long incrementalCallCount, Collection<BinderCallsStats.CallStat> callStats) {
                this.val$batteryStatsInternal.noteBinderCallStats(workSourceUid, incrementalCallCount, callStats);
            }

            public void noteBinderThreadNativeIds(int[] binderThreadNativeTids) {
                this.val$batteryStatsInternal.noteBinderThreadNativeIds(binderThreadNativeTids);
            }
        }

        public LifeCycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mBinderCallsStats = new BinderCallsStats(new BinderCallsStats.Injector());
            this.mWorkSourceProvider = new AuthorizedWorkSourceProvider();
            this.mService = new BinderCallsStatsService(this.mBinderCallsStats, this.mWorkSourceProvider);
            publishLocalService(Internal.class, new Internal(this.mBinderCallsStats));
            publishBinderService(BinderCallsStatsService.SERVICE_NAME, this.mService);
            boolean detailedTrackingEnabled = SystemProperties.getBoolean(BinderCallsStatsService.PERSIST_SYS_BINDER_CALLS_DETAILED_TRACKING, false);
            if (detailedTrackingEnabled == false) goto L6;
            Slog.i(BinderCallsStatsService.TAG, "Enabled CPU usage tracking for binder calls. Controlled by persist.sys.binder_calls_detailed_tracking or via dumpsys binder_calls_stats --enable-detailed-tracking");
            this.mBinderCallsStats.setDetailedTracking(true);
            return;
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (500 != phase) goto L6;
            CachedDeviceState.Readonly deviceState = (CachedDeviceState.Readonly) getLocalService(CachedDeviceState.Readonly.class);
            this.mBinderCallsStats.setDeviceState(deviceState);
            this.mWorkSourceProvider.systemReady(getContext());
            this.mService.systemReady(getContext());
            return;
        }
    }

    private static class SettingsObserver extends ContentObserver {
        private final BinderCallsStats mBinderCallsStats;
        private final Context mContext;
        private boolean mEnabled;
        private final KeyValueListParser mParser;
        private final Uri mUri;
        private final AuthorizedWorkSourceProvider mWorkSourceProvider;

        /* JADX INFO: renamed from: $r8$lambda$BBEj-ioByYkQlCwUqgfq1j9WdeY, reason: not valid java name */
        public static /* synthetic */ int m139$r8$lambda$BBEjioByYkQlCwUqgfq1j9WdeY(int r0) {
            return lambda$onChange$0(r0);
        }

        SettingsObserver(Context context, BinderCallsStats binderCallsStats, AuthorizedWorkSourceProvider workSourceProvider) {
            super(BackgroundThread.getHandler());
            this.mUri = Settings.Global.getUriFor(BinderCallsStatsService.SERVICE_NAME);
            this.mParser = new KeyValueListParser(',');
            this.mContext = context;
            context.getContentResolver().registerContentObserver(this.mUri, false, this, 0);
            this.mBinderCallsStats = binderCallsStats;
            this.mWorkSourceProvider = workSourceProvider;
            onChange();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mUri.equals(uri) == false) goto L6;
            onChange();
            return;
        }

        public void onChange() {
            if (SystemProperties.get(BinderCallsStatsService.PERSIST_SYS_BINDER_CALLS_DETAILED_TRACKING).isEmpty() == true) goto L16;
            return;
        L16:
            this.mParser.setString(Settings.Global.getString(this.mContext.getContentResolver(), BinderCallsStatsService.SERVICE_NAME));     // Catch: IllegalArgumentException -> L7
        L9:
            this.mBinderCallsStats.setDetailedTracking(this.mParser.getBoolean("detailed_tracking", true));
            this.mBinderCallsStats.setSamplingInterval(this.mParser.getInt("sampling_interval", 1000));
            this.mBinderCallsStats.setMaxBinderCallStats(this.mParser.getInt("max_call_stats_count", NetworkConstants.ETHER_MTU));
            this.mBinderCallsStats.setTrackScreenInteractive(this.mParser.getBoolean("track_screen_state", false));
            this.mBinderCallsStats.setTrackDirectCallerUid(this.mParser.getBoolean("track_calling_uid", true));
            this.mBinderCallsStats.setIgnoreBatteryStatus(this.mParser.getBoolean("ignore_battery_status", false));
            this.mBinderCallsStats.setShardingModulo(this.mParser.getInt("sharding_modulo", 1));
            this.mBinderCallsStats.setCollectLatencyData(this.mParser.getBoolean("collect_latency_data", true));
            BinderCallsStats.SettingsObserver.configureLatencyObserver(this.mParser, this.mBinderCallsStats.getLatencyObserver());
            boolean enabled = this.mParser.getBoolean(ServiceConfigAccessor.PROVIDER_MODE_ENABLED, true);
            if (this.mEnabled == enabled) goto L18;
            if (enabled == false) goto L13;
            Binder.setObserver(this.mBinderCallsStats);
            Binder.setProxyTransactListener(new Binder.PropagateWorkSourceTransactListener());
            Binder.setWorkSourceProvider(this.mWorkSourceProvider);
        L14:
            this.mEnabled = enabled;
            this.mBinderCallsStats.reset();
            this.mBinderCallsStats.setAddDebugEntries(enabled);
            this.mBinderCallsStats.getLatencyObserver().reset();
            return;
        L13:
            Binder.setObserver(null);
            Binder.setProxyTransactListener(null);
            Binder.setWorkSourceProvider(new BinderCallsStatsService$SettingsObserver$$ExternalSyntheticLambda0());
            goto L14
        L18:
            return;
        L7:
            e = move-exception;
            Slog.e(BinderCallsStatsService.TAG, "Bad binder call stats settings", e);
            goto L9
        }

        private static /* synthetic */ int lambda$onChange$0(int x) {
            return Binder.getCallingUid();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinderCallsStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinderCallsStats m137$$Nest$fgetmBinderCallsStats(BinderCallsStatsService r0) {
        return r0.mBinderCallsStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorkSourceProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuthorizedWorkSourceProvider m138$$Nest$fgetmWorkSourceProvider(BinderCallsStatsService r0) {
        return r0.mWorkSourceProvider;
    }

    BinderCallsStatsService(BinderCallsStats binderCallsStats, AuthorizedWorkSourceProvider workSourceProvider) {
        this.mBinderCallsStats = binderCallsStats;
        this.mWorkSourceProvider = workSourceProvider;
    }

    public void systemReady(Context context) {
        this.mSettingsObserver = new SettingsObserver(context, this.mBinderCallsStats, this.mWorkSourceProvider);
    }

    public void reset() {
        Slog.i(TAG, "Resetting stats");
        this.mBinderCallsStats.reset();
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(ActivityThread.currentApplication(), SERVICE_NAME, pw) == true) goto L5;
        return;
    L5:
        boolean verbose = false;
        int worksourceUid = -1;
        if (args == null) goto L39;
        boolean verbose2 = false;
        int i = 0;
        int worksourceUid2 = -1;
    L9:
        if (i >= args.length) goto L30;
        String arg = args[i];
        if ("-a".equals(arg) == false) goto L14;
        verbose2 = true;
    L29:
        i = i + 1;
        goto L9
    L14:
        if ("-h".equals(arg) == true) goto L15;
        if ("--work-source-uid".equals(arg) == false) goto L29;
        int i2 = i + 1;
        int i3 = args.length;
        if (i2 >= i3) goto L28;
        String uidArg = args[i2];
        int worksourceUid3 = Integer.parseInt(uidArg);     // Catch: NumberFormatException -> L24
        worksourceUid2 = worksourceUid3;
        i = i2;
    L25:
        pw.println("Invalid UID: " + uidArg);
        return;
    L28:
        throw new IllegalArgumentException("Argument expected after \"" + arg + "\"");
    L15:
        pw.println("dumpsys binder_calls_stats options:");
        pw.println("  -a: Verbose");
        pw.println("  --work-source-uid <UID>: Dump binder calls from the UID");
        return;
    L30:
        int i4 = args.length;
        if (i4 > 0) goto L33;
    L37:
        BinderCallsStatsService r4 = this;
    L38:
        verbose = verbose2;
        worksourceUid = worksourceUid2;
    L40:
        r4.mBinderCallsStats.dump(pw, AppIdToPackageMap.getSnapshot(), worksourceUid, verbose);
        return;
    L33:
        if (worksourceUid2 != (-1)) goto L37;
        BinderCallsStatsShellCommand command = new BinderCallsStatsShellCommand(this, pw);
        r4 = this;
        int status = command.exec(r4, null, FileDescriptor.out, FileDescriptor.err, args);
        if (status != 0) goto L38;
        return;
    L39:
        r4 = this;
        goto L40
    }

    public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
        ShellCommand command = new BinderCallsStatsShellCommand(this, null);
        int status = command.exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
        if (status == 0) goto L5;
        command.onHelp();
    L5:
        return status;
    }
}
