package com.android.server;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class DockObserver extends SystemService {
    private static final String TAG = "DockObserver";
    private int mActualDockState;
    private final boolean mAllowTheaterModeWakeFromDock;
    private DeviceProvisionedObserver mDeviceProvisionedObserver;
    private final DockObserverLocalService mDockObserverLocalService;
    private final List<ExtconStateConfig> mExtconStateConfigs;
    private final ExtconUEventObserver mExtconUEventObserver;
    private final Handler mHandler;
    private final boolean mKeepDreamingWhenUnplugging;
    private final Object mLock;
    private final PowerManager mPowerManager;
    private int mPreviousDockState;
    private int mReportedDockState;
    private boolean mSystemReady;
    private boolean mUpdatesStopped;
    private final PowerManager.WakeLock mWakeLock;

    private final class BinderService extends Binder {
        final /* synthetic */ DockObserver this$0;

        /* synthetic */ BinderService(DockObserver r1, DockObserverIA r2) {
            this(r1);
        }

        private BinderService(DockObserver r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), DockObserver.TAG, pw) == true) goto L5;
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
            Object r2 = DockObserver.m206$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L46
            monitor-enter(r2);     // Catch: Throwable -> L46
            if (args == null) goto L37;
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L46
        L10:
            if (args.length == 0) goto L37;
            if ("-a".equals(args[0]) == true) goto L37;
            if (args.length != 3) goto L32;
            if ("set".equals(args[0]) == false) goto L32;
            String key = args[1];     // Catch: Throwable -> L22
            String value = args[2];     // Catch: Throwable -> L22
            if ("state".equals(key) == false) goto L26;
            DockObserver.m210$$Nest$fputmUpdatesStopped(this.this$0, true);     // Catch: Throwable -> L22 NumberFormatException -> L24
            DockObserver.m212$$Nest$msetDockStateLocked(this.this$0, Integer.parseInt(value));     // Catch: Throwable -> L22 NumberFormatException -> L24
        L52:
        L41:
            monitor-exit(r2);     // Catch: Throwable -> L22
            Binder.restoreCallingIdentity(ident);
            return;
        L26:
            pw.println("Unknown set option: " + key);     // Catch: Throwable -> L22 NumberFormatException -> L24
        L29:
            pw.println("Bad value: " + value);     // Catch: Throwable -> L22
        L32:
            if (args.length == 1) goto L34;
        L36:
            pw.println("Dump current dock state, or:");     // Catch: Throwable -> L22
            pw.println("  set state <value>");     // Catch: Throwable -> L22
            pw.println("  reset");     // Catch: Throwable -> L22
            goto L41
        L34:
            if ("reset".equals(args[0]) == false) goto L36;
            DockObserver.m210$$Nest$fputmUpdatesStopped(this.this$0, false);     // Catch: Throwable -> L22
            DockObserver.m212$$Nest$msetDockStateLocked(this.this$0, DockObserver.m205$$Nest$fgetmActualDockState(this.this$0));     // Catch: Throwable -> L22
        L37:
            pw.println("Current Dock Observer Service state:");     // Catch: Throwable -> L22
            if (DockObserver.m209$$Nest$fgetmUpdatesStopped(this.this$0) == false) goto L40;
            pw.println("  (UPDATES STOPPED -- use 'reset' to restart)");     // Catch: Throwable -> L22
        L40:
            pw.println("  reported state: " + DockObserver.m208$$Nest$fgetmReportedDockState(this.this$0));     // Catch: Throwable -> L22
            pw.println("  previous state: " + DockObserver.m207$$Nest$fgetmPreviousDockState(this.this$0));     // Catch: Throwable -> L22
            pw.println("  actual state: " + DockObserver.m205$$Nest$fgetmActualDockState(this.this$0));     // Catch: Throwable -> L22
        L46:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }
    }

    private final class DeviceProvisionedObserver extends ContentObserver {
        private boolean mRegistered;
        final /* synthetic */ DockObserver this$0;

        public DeviceProvisionedObserver(DockObserver r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            Object r0 = DockObserver.m206$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            updateRegistration();     // Catch: Throwable -> L7
            if (isDeviceProvisioned() == false) goto L9;
            DockObserver.m213$$Nest$mupdateIfDockedLocked(this.this$0);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void onSystemReady() {
            updateRegistration();
        }

        private void updateRegistration() {
            boolean register = !isDeviceProvisioned();
            if (register != this.mRegistered) goto L5;
            return;
        L5:
            ContentResolver resolver = this.this$0.getContext().getContentResolver();
            if (register == false) goto L8;
            resolver.registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, this);
        L9:
            this.mRegistered = register;
            return;
        L8:
            resolver.unregisterContentObserver(this);
            goto L9
        }

        boolean isDeviceProvisioned() {
            if (Settings.Global.getInt(this.this$0.getContext().getContentResolver(), "device_provisioned", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public class DockObserverLocalService extends DockObserverInternal {
        final /* synthetic */ DockObserver this$0;

        public DockObserverLocalService(DockObserver this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.DockObserverInternal
        public int getActualDockState() {
            return DockObserver.m205$$Nest$fgetmActualDockState(this.this$0);
        }
    }

    private static final class ExtconStateConfig {
        public final int extraStateValue;
        public final List<Pair<String, String>> keyValuePairs;

        ExtconStateConfig(int extraStateValue) {
            this.keyValuePairs = new ArrayList();
            this.extraStateValue = extraStateValue;
        }
    }

    static final class ExtconStateProvider {
        private final Map<String, String> mState;

        ExtconStateProvider(Map<String, String> state) {
            this.mState = state;
        }

        String getValue(String key) {
            return this.mState.get(key);
        }

        static ExtconStateProvider fromString(String stateString) {
            Map<String, String> states = new HashMap();
            String[] lines = stateString.split("\n");
            int r2 = lines.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L10;
            String line = lines[r4];
            String[] fields = line.split("=");
            if (fields.length != 2) goto L7;
            states.put(fields[0], fields[1]);
        L8:
            r4 = r4 + 1;
            goto L3
        L7:
            Slog.e(DockObserver.TAG, "Invalid line: " + line);
            goto L8
        L10:
            return new ExtconStateProvider(states);
        }

        static ExtconStateProvider fromFile(String stateFilePath) {
            char[] buffer = new char[1024];
            FileReader file = new FileReader(stateFilePath);     // Catch: Exception -> L8 FileNotFoundException -> L10
            int len = file.read(buffer, 0, 1024);     // Catch: Throwable -> L12
            String stateString = new String(buffer, 0, len).trim();     // Catch: Throwable -> L12
            ExtconStateProvider r5 = fromString(stateString);     // Catch: Throwable -> L12
            file.close();     // Catch: Exception -> L8 FileNotFoundException -> L10
            return r5;
        L12:
            th = move-exception;
            file.close();     // Catch: Throwable -> L15
        L17:
            throw th;     // Catch: Exception -> L8 FileNotFoundException -> L10
        L15:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Exception -> L8 FileNotFoundException -> L10
        L8:
            e = move-exception;
            Slog.e(DockObserver.TAG, "", e);
            return new ExtconStateProvider(new HashMap());
        L20:
            Slog.w(DockObserver.TAG, "No state file found at: " + stateFilePath);
            return new ExtconStateProvider(new HashMap());
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$qaC52jh3OvGtaUchew8hK3-YO2Y, reason: not valid java name */
    public static /* synthetic */ void m204$r8$lambda$qaC52jh3OvGtaUchew8hK3YO2Y(DockObserver r0) {
        r0.handleDockStateChange();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActualDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m205$$Nest$fgetmActualDockState(DockObserver r0) {
        return r0.mActualDockState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m206$$Nest$fgetmLock(DockObserver r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreviousDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m207$$Nest$fgetmPreviousDockState(DockObserver r0) {
        return r0.mPreviousDockState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmReportedDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m208$$Nest$fgetmReportedDockState(DockObserver r0) {
        return r0.mReportedDockState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdatesStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m209$$Nest$fgetmUpdatesStopped(DockObserver r0) {
        return r0.mUpdatesStopped;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUpdatesStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m210$$Nest$fputmUpdatesStopped(DockObserver r0, boolean r1) {
        r0.mUpdatesStopped = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msetDockStateFromProviderLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m211$$Nest$msetDockStateFromProviderLocked(DockObserver r0, ExtconStateProvider r1) {
        r0.setDockStateFromProviderLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDockStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m212$$Nest$msetDockStateLocked(DockObserver r0, int r1) {
        r0.setDockStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateIfDockedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m213$$Nest$mupdateIfDockedLocked(DockObserver r0) {
        r0.updateIfDockedLocked();
    }

    private static List<ExtconStateConfig> loadExtconStateConfigs(Context context) {
        String[] rows = context.getResources().getStringArray(R.array.config_forceSlowJpegModeList);
        ArrayList<ExtconStateConfig> configs = new ArrayList();     // Catch: Throwable -> L11
        int r2 = rows.length;     // Catch: Throwable -> L11
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L17;
        String row = rows[r4];     // Catch: Throwable -> L11
        String[] rowFields = row.split(",");     // Catch: Throwable -> L11
        ExtconStateConfig config = new ExtconStateConfig(Integer.parseInt(rowFields[0]));     // Catch: Throwable -> L11
        int i = 1;
    L7:
        if (i >= rowFields.length) goto L15;
        String[] keyValueFields = rowFields[i].split("=");     // Catch: Throwable -> L11
        if (keyValueFields.length != 2) goto L14;
        config.keyValuePairs.add(Pair.create(keyValueFields[0], keyValueFields[1]));     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L7
    L14:
        throw new IllegalArgumentException("Invalid key-value: " + rowFields[i]);     // Catch: Throwable -> L11
    L15:
        configs.add(config);     // Catch: Throwable -> L11
        r4 = r4 + 1;
        goto L4
    L17:
        return configs;
    L11:
        e = move-exception;
        Slog.e(TAG, "Could not parse extcon state config", e);
        return new ArrayList();
    }

    public DockObserver(Context context) {
        super(context);
        this.mLock = new Object();
        this.mActualDockState = 0;
        this.mReportedDockState = 0;
        this.mPreviousDockState = 0;
        this.mHandler = new Handler(true);
        this.mExtconUEventObserver = new AnonymousClass1(this);
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mWakeLock = this.mPowerManager.newWakeLock(1, TAG);
        this.mAllowTheaterModeWakeFromDock = context.getResources().getBoolean(R.bool.config_allowTheaterModeWakeFromDock);
        this.mKeepDreamingWhenUnplugging = context.getResources().getBoolean(R.bool.config_letterboxIsAutomaticReachabilityInBookModeEnabled);
        this.mDeviceProvisionedObserver = new DeviceProvisionedObserver(this, this.mHandler);
        this.mExtconStateConfigs = loadExtconStateConfigs(context);
        List<ExtconUEventObserver.ExtconInfo> infos = ExtconUEventObserver.ExtconInfo.getExtconInfoForTypes(new String[]{ExtconUEventObserver.ExtconInfo.EXTCON_DOCK});
        Object r2 = this.mLock;
        monitor-enter(r2);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (infos.isEmpty() == true) goto L9;
        ExtconUEventObserver.ExtconInfo info = infos.get(0);     // Catch: Throwable -> L7
        Slog.i(TAG, "Found extcon info devPath: " + info.getDevicePath() + ", statePath: " + info.getStatePath());     // Catch: Throwable -> L7
        setDockStateFromProviderLocked(ExtconStateProvider.fromFile(info.getStatePath()));     // Catch: Throwable -> L7
        this.mPreviousDockState = this.mActualDockState;     // Catch: Throwable -> L7
        this.mExtconUEventObserver.startObserving(info);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L7
        this.mDockObserverLocalService = new DockObserverLocalService(this);
        LocalServices.addService(DockObserverInternal.class, this.mDockObserverLocalService);
        return;
    L9:
        Slog.i(TAG, "No extcon dock device found in this kernel.");     // Catch: Throwable -> L7
        goto L10
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(TAG, new BinderService(this, null));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemReady = true;     // Catch: Throwable -> L10
        this.mDeviceProvisionedObserver.onSystemReady();     // Catch: Throwable -> L10
        updateIfDockedLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateIfDockedLocked() {
        if (this.mReportedDockState == 0) goto L6;
        postWakefulDockStateChange();
        return;
    }

    private void setActualDockStateLocked(int newState) {
        this.mActualDockState = newState;
        if (this.mUpdatesStopped == true) goto L6;
        setDockStateLocked(newState);
        return;
    }

    private void setDockStateLocked(int newState) {
        if (newState == this.mReportedDockState) goto L11;
        this.mReportedDockState = newState;
        FrameworkStatsLog.write(FrameworkStatsLog.DOCK_STATE_CHANGED, this.mReportedDockState);
        if (this.mSystemReady == true) goto L7;
        return;
    L7:
        if (allowWakeFromDock() == false) goto L9;
        this.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 18, "android.server:DOCK");
    L9:
        postWakefulDockStateChange();
        return;
    }

    private boolean allowWakeFromDock() {
        if (this.mKeepDreamingWhenUnplugging == false) goto L6;
        return false;
    L6:
        if (this.mAllowTheaterModeWakeFromDock == false) goto L8;
    L9:
        return true;
    L8:
        if (Settings.Global.getInt(getContext().getContentResolver(), "theater_mode_on", 0) == 0) goto L9;
        return false;
    }

    private void postWakefulDockStateChange() {
        this.mHandler.post(this.mWakeLock.wrap(new DockObserver$$ExternalSyntheticLambda0(this)));
    }

    private void handleDockStateChange() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.i(TAG, "Dock state changed from " + this.mPreviousDockState + " to " + this.mReportedDockState);     // Catch: Throwable -> L11
        int previousDockState = this.mPreviousDockState;     // Catch: Throwable -> L11
        this.mPreviousDockState = this.mReportedDockState;     // Catch: Throwable -> L11
        ContentResolver cr = getContext().getContentResolver();     // Catch: Throwable -> L11
        Resources r = getContext().getResources();     // Catch: Throwable -> L11
        boolean allowDockBeforeProvision = r.getBoolean(R.bool.config_allowDockBeforeProvision);     // Catch: Throwable -> L11
        if (allowDockBeforeProvision == false) goto L7;
    L13:
        Intent intent = new Intent("android.intent.action.DOCK_EVENT");     // Catch: Throwable -> L11
        intent.addFlags(536870912);     // Catch: Throwable -> L11
        intent.putExtra("android.intent.extra.DOCK_STATE", this.mReportedDockState);     // Catch: Throwable -> L11
        boolean accessibilityEnabled = false;
        if (Settings.Global.getInt(cr, "dock_sounds_enabled", 1) != 1) goto L16;
        boolean dockSoundsEnabled = true;
    L18:
        if (Settings.Global.getInt(cr, "dock_sounds_enabled_when_accessbility", 1) != 1) goto L20;
        boolean dockSoundsEnabledWhenAccessibility = true;
    L22:
        if (Settings.Secure.getInt(cr, "accessibility_enabled", 0) != 1) goto L24;
        accessibilityEnabled = true;
    L24:
        if (dockSoundsEnabled == true) goto L27;
        if (accessibilityEnabled == false) goto L55;
        if (dockSoundsEnabledWhenAccessibility == true) goto L27;
    L55:
        getContext().sendStickyBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L27:
        String whichSound = null;
        if (this.mReportedDockState != 0) goto L37;
        if (previousDockState == 1) goto L35;
        if (previousDockState == 3) goto L35;
        if (previousDockState == 4) goto L35;
        if (previousDockState != 2) goto L47;
        whichSound = "car_undock_sound";
    L47:
        if (whichSound == null) goto L55;
        String soundPath = Settings.Global.getString(cr, whichSound);     // Catch: Throwable -> L11
        if (soundPath == null) goto L55;
        Uri soundUri = Uri.parse("file://" + soundPath);     // Catch: Throwable -> L11
        if (soundUri == null) goto L55;
        Ringtone sfx = RingtoneManager.getRingtone(getContext(), soundUri);     // Catch: Throwable -> L11
        if (sfx == null) goto L55;
        sfx.setStreamType(1);     // Catch: Throwable -> L11
        sfx.preferBuiltinDevice(true);     // Catch: Throwable -> L11
        sfx.play();     // Catch: Throwable -> L11
    L35:
        whichSound = "desk_undock_sound";
        goto L47
    L37:
        if (this.mReportedDockState == 1) goto L46;
        if (this.mReportedDockState == 3) goto L46;
        if (this.mReportedDockState == 4) goto L46;
        if (this.mReportedDockState != 2) goto L47;
        whichSound = "car_dock_sound";
    L46:
        whichSound = "desk_dock_sound";
        goto L47
    L20:
        dockSoundsEnabledWhenAccessibility = false;
        goto L22
    L16:
        dockSoundsEnabled = false;
        goto L18
    L7:
        if (this.mDeviceProvisionedObserver.isDeviceProvisioned() == true) goto L13;
        Slog.i(TAG, "Device not provisioned, skipping dock broadcast");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private int getDockedStateExtraValue(ExtconStateProvider state) {
        Iterator<ExtconStateConfig> r0 = this.mExtconStateConfigs.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        ExtconStateConfig config = r0.next();
        boolean match = true;
        Iterator<Pair<String, String>> r4 = config.keyValuePairs.iterator();
    L7:
        if (r4.hasNext() == false) goto L18;
        Pair<String, String> keyValue = r4.next();
        String stateValue = state.getValue((String) keyValue.first);
        if (match == true) goto L11;
    L13:
        boolean r7 = false;
    L14:
        match = r7;
        if (match == true) goto L7;
    L11:
        if (((String) keyValue.second).equals(stateValue) == false) goto L13;
        r7 = true;
    L18:
        if (match == false) goto L4;
        return config.extraStateValue;
    L22:
        return 1;
    }

    void setDockStateFromProviderForTesting(ExtconStateProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setDockStateFromProviderLocked(provider);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setDockStateFromProviderLocked(ExtconStateProvider provider) {
        int state = 0;
        if ("1".equals(provider.getValue(ExtconUEventObserver.ExtconInfo.EXTCON_DOCK)) == false) goto L5;
        state = getDockedStateExtraValue(provider);
    L5:
        setActualDockStateLocked(state);
    }
}
