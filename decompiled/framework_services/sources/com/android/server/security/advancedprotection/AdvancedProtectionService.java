package com.android.server.security.advancedprotection;

import android.app.StatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.Settings;
import android.security.advancedprotection.AdvancedProtectionFeature;
import android.security.advancedprotection.IAdvancedProtectionCallback;
import android.security.advancedprotection.IAdvancedProtectionService;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.StatsEvent;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.security.advancedprotection.features.AdvancedProtectionHook;
import com.android.server.security.advancedprotection.features.AdvancedProtectionProvider;
import com.android.server.security.advancedprotection.features.DisallowCellular2GAdvancedProtectionHook;
import com.android.server.security.advancedprotection.features.DisallowInstallUnknownSourcesAdvancedProtectionHook;
import com.android.server.security.advancedprotection.features.DisallowWepAdvancedProtectionProvider;
import com.android.server.security.advancedprotection.features.MemoryTaggingExtensionHook;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AdvancedProtectionService extends IAdvancedProtectionService.Stub {
    private static final int CALLBACK_ADDED = 1;
    private static final String ENABLED_CHANGE_TIME = "enabled_change_time";
    private static final String LAST_DIALOG_FEATURE_ID = "last_dialog_feature_id";
    private static final String LAST_DIALOG_HOURS_SINCE_ENABLED = "last_dialog_hours_since_enabled";
    private static final String LAST_DIALOG_LEARN_MORE_CLICKED = "last_dialog_learn_more_clicked";
    private static final String LAST_DIALOG_TYPE = "last_dialog_type";
    private static final long MILLIS_PER_HOUR = 3600000;
    private static final int MODE_CHANGED = 0;
    private static final String PREFERENCE = "advanced_protection_preference";
    private static final String TAG = "AdvancedProtectionService";
    private final ArrayMap<IBinder, IAdvancedProtectionCallback> mCallbacks;
    private final Context mContext;
    private boolean mEmitLogs;
    private final Handler mHandler;
    private final ArrayList<AdvancedProtectionHook> mHooks;
    private final ArrayList<AdvancedProtectionProvider> mProviders;
    private SharedPreferences mSharedPreferences;
    private final AdvancedProtectionStore mStore;
    private final UserManagerInternal mUserManager;

    private class AdvancedProtectionHandler extends Handler {
        final /* synthetic */ AdvancedProtectionService this$0;

        /* synthetic */ AdvancedProtectionHandler(AdvancedProtectionService r1, Looper r2, AdvancedProtectionServiceIA r3) {
            this(r1, r2);
        }

        private AdvancedProtectionHandler(AdvancedProtectionService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean r1 = false;
            switch(msg.what) {
                case 0: goto L10;
                case 1: goto L6;
                default: goto L15;
            };
        L15:
            return;
        L6:
            if (msg.arg1 != 1) goto L8;
            r1 = true;
        L8:
            handleSingleCallback(r1, (IAdvancedProtectionCallback) msg.obj);
            return;
        L10:
            if (msg.arg1 != 1) goto L12;
            r1 = true;
        L12:
            handleAllCallbacks(r1);
        }

        private void handleAllCallbacks(boolean enabled) {
            ArrayList<IAdvancedProtectionCallback> deadObjects = new ArrayList();
            int i = 0;
        L4:
            if (i >= AdvancedProtectionService.m8029$$Nest$fgetmHooks(this.this$0).size()) goto L15;
            AdvancedProtectionHook feature = (AdvancedProtectionHook) AdvancedProtectionService.m8029$$Nest$fgetmHooks(this.this$0).get(i);
        L10:
            e = move-exception;
            Slog.e(AdvancedProtectionService.TAG, "Failed to call hook for feature " + feature.getFeature().getId(), e);
        L14:
            i = i + 1;
            goto L4
        L7:
            if (feature.isAvailable() == false) goto L14;
            feature.onAdvancedProtectionChanged(enabled);     // Catch: Exception -> L10
            goto L14
        L15:
            ArrayMap r1 = AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0);
            monitor-enter(r1);
            int i2 = 0;
        L37:
        L23:
            th = move-exception;
            throw th;
        L19:
            if (i2 >= AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0).size()) goto L28;
            IAdvancedProtectionCallback callback = (IAdvancedProtectionCallback) AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0).valueAt(i2);     // Catch: Throwable -> L23
            callback.onAdvancedProtectionChanged(enabled);     // Catch: Throwable -> L23 RemoteException -> L25
        L27:
            i2 = i2 + 1;     // Catch: Throwable -> L23
        L26:
            deadObjects.add(callback);     // Catch: Throwable -> L23
            goto L27
        L28:
            int i3 = 0;
        L30:
            if (i3 >= deadObjects.size()) goto L33;
            AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0).remove(deadObjects.get(i3).asBinder());     // Catch: Throwable -> L23
            i3 = i3 + 1;     // Catch: Throwable -> L23
            goto L30
        L33:
            monitor-exit(r1);     // Catch: Throwable -> L23
        }

        private void handleSingleCallback(boolean enabled, IAdvancedProtectionCallback callback) {
            callback.onAdvancedProtectionChanged(enabled);     // Catch: RemoteException -> L4
            return;
        L5:
            AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0).remove(callback.asBinder());
        }
    }

    private class AdvancedProtectionStatePullAtomCallback implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ AdvancedProtectionService this$0;

        /* synthetic */ AdvancedProtectionStatePullAtomCallback(AdvancedProtectionService r1, AdvancedProtectionServiceIA r2) {
            this(r1);
        }

        private AdvancedProtectionStatePullAtomCallback(AdvancedProtectionService r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            if (atomTag == 10236) goto L6;
            return 1;
        L6:
            data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.ADVANCED_PROTECTION_STATE_INFO, AdvancedProtectionService.m8033$$Nest$misAdvancedProtectionEnabledInternal(this.this$0), AdvancedProtectionService.m8030$$Nest$mhoursSinceLastChange(this.this$0)));
            return 0;
        }
    }

    static class AdvancedProtectionStore {
        static final int OFF = 0;
        static final int ON = 1;
        private final Context mContext;

        AdvancedProtectionStore(Context context) {
            this.mContext = context;
        }

        void storeAdvancedProtectionModeEnabled(boolean r4) {
            Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "advanced_protection_mode", r4 ? 1 : 0, 0);
        }

        boolean retrieveAdvancedProtectionModeEnabled() {
            if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "advanced_protection_mode", 0, 0) == 1) goto L5;
            return false;
        L5:
            return true;
        }

        void storeInt(String key, int value) {
            Settings.Secure.putIntForUser(this.mContext.getContentResolver(), key, value, 0);
        }

        int retrieveInt(String key, int defaultValue) {
            return Settings.Secure.getIntForUser(this.mContext.getContentResolver(), key, defaultValue, 0);
        }
    }

    private final class DeathRecipient implements IBinder.DeathRecipient {
        private final IBinder mBinder;
        final /* synthetic */ AdvancedProtectionService this$0;

        DeathRecipient(AdvancedProtectionService r1, IBinder binder) {
            this.this$0 = r1;
            this.mBinder = binder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ArrayMap r0 = AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0);
            monitor-enter(r0);
            AdvancedProtectionService.m8028$$Nest$fgetmCallbacks(this.this$0).remove(this.mBinder);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class Lifecycle extends SystemService {
        private final AdvancedProtectionService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new AdvancedProtectionService(context, null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("advanced_protection", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L9;
            boolean enabled = AdvancedProtectionService.m8033$$Nest$misAdvancedProtectionEnabledInternal(this.mService);
            if (enabled == false) goto L7;
            Slog.i(AdvancedProtectionService.TAG, "Advanced protection is enabled");
        L7:
            AdvancedProtectionService.m8031$$Nest$minitFeatures(this.mService, enabled);
            AdvancedProtectionService.m8032$$Nest$minitLogging(this.mService);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$YRxLhTb04fHYyMVzbjSCsnGHla4(PrintWriter r0, AdvancedProtectionHook r1) {
        lambda$dump$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$q5sMDx-bgKVL8aW9mrMJGtPEpso, reason: not valid java name */
    public static /* synthetic */ void m8027$r8$lambda$q5sMDxbgKVL8aW9mrMJGtPEpso(PrintWriter r0, AdvancedProtectionFeature r1) {
        lambda$dump$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wlOBLW1fvDzfBOsZ6BIr6fsv6Yc(AdvancedProtectionService r0, PrintWriter r1, AdvancedProtectionProvider r2) {
        r0.lambda$dump$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8028$$Nest$fgetmCallbacks(AdvancedProtectionService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHooks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m8029$$Nest$fgetmHooks(AdvancedProtectionService r0) {
        return r0.mHooks;
    }

    /* JADX INFO: renamed from: -$$Nest$mhoursSinceLastChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8030$$Nest$mhoursSinceLastChange(AdvancedProtectionService r0) {
        return r0.hoursSinceLastChange();
    }

    /* JADX INFO: renamed from: -$$Nest$minitFeatures, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8031$$Nest$minitFeatures(AdvancedProtectionService r0, boolean r1) {
        r0.initFeatures(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minitLogging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8032$$Nest$minitLogging(AdvancedProtectionService r0) {
        r0.initLogging();
    }

    /* JADX INFO: renamed from: -$$Nest$misAdvancedProtectionEnabledInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8033$$Nest$misAdvancedProtectionEnabledInternal(AdvancedProtectionService r0) {
        return r0.isAdvancedProtectionEnabledInternal();
    }

    /* synthetic */ AdvancedProtectionService(Context r1, AdvancedProtectionServiceIA r2) {
        this(r1);
    }

    private AdvancedProtectionService(Context context) {
        super(PermissionEnforcer.fromContext(context));
        this.mHooks = new ArrayList();
        this.mCallbacks = new ArrayMap();
        this.mProviders = new ArrayList();
        this.mEmitLogs = true;
        this.mContext = context;
        this.mHandler = new AdvancedProtectionHandler(this, FgThread.get().getLooper(), null);
        this.mStore = new AdvancedProtectionStore(this.mContext);
        this.mUserManager = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    private void initFeatures(boolean enabled) {
        this.mHooks.add(new DisallowInstallUnknownSourcesAdvancedProtectionHook(this.mContext, enabled));     // Catch: Exception -> L5
    L23:
        this.mHooks.add(new MemoryTaggingExtensionHook(this.mContext, enabled));     // Catch: Exception -> L10
    L21:
        this.mHooks.add(new DisallowCellular2GAdvancedProtectionHook(this.mContext, enabled));     // Catch: Exception -> L15
    L17:
        this.mProviders.add(new DisallowWepAdvancedProtectionProvider());
        return;
    L15:
        e = move-exception;
        Slog.e(TAG, "Failed to initialize DisallowCellular2g", e);
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to initialize MemoryTaggingExtension", e);
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to initialize DisallowInstallUnknownSources", e);
        goto L23
    }

    private void initLogging() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.ADVANCED_PROTECTION_STATE_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new AdvancedProtectionStatePullAtomCallback(this, null));
    }

    AdvancedProtectionService(Context context, AdvancedProtectionStore store, UserManagerInternal userManager, Looper looper, PermissionEnforcer permissionEnforcer, AdvancedProtectionHook hook, AdvancedProtectionProvider provider) {
        super(permissionEnforcer);
        this.mHooks = new ArrayList();
        this.mCallbacks = new ArrayMap();
        this.mProviders = new ArrayList();
        this.mEmitLogs = true;
        this.mContext = context;
        this.mStore = store;
        this.mUserManager = userManager;
        this.mHandler = new AdvancedProtectionHandler(this, looper, null);
        if (hook == null) goto L5;
        this.mHooks.add(hook);
    L5:
        if (provider == null) goto L7;
        this.mProviders.add(provider);
    L7:
        this.mEmitLogs = false;
    }

    public boolean isAdvancedProtectionEnabled() {
        isAdvancedProtectionEnabled_enforcePermission();
        long identity = Binder.clearCallingIdentity();
        boolean r2 = isAdvancedProtectionEnabledInternal();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean isAdvancedProtectionEnabledInternal() {
        return this.mStore.retrieveAdvancedProtectionModeEnabled();
    }

    public void registerAdvancedProtectionCallback(IAdvancedProtectionCallback callback) throws RemoteException {
        registerAdvancedProtectionCallback_enforcePermission();
        IBinder b = callback.asBinder();
        b.linkToDeath(new DeathRecipient(this, b), 0);
        ArrayMap<IBinder, IAdvancedProtectionCallback> r1 = this.mCallbacks;
        monitor-enter(r1);
        this.mCallbacks.put(b, callback);     // Catch: Throwable -> L7
        sendCallbackAdded(isAdvancedProtectionEnabledInternal(), callback);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterAdvancedProtectionCallback(IAdvancedProtectionCallback callback) {
        unregisterAdvancedProtectionCallback_enforcePermission();
        ArrayMap<IBinder, IAdvancedProtectionCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.remove(callback.asBinder());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAdvancedProtectionEnabled(boolean enabled) {
        setAdvancedProtectionEnabled_enforcePermission();
        UserHandle user = Binder.getCallingUserHandle();
        long identity = Binder.clearCallingIdentity();
        enforceAdminUser(user);     // Catch: Throwable -> L15
        ArrayMap<IBinder, IAdvancedProtectionCallback> r3 = this.mCallbacks;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (enabled == isAdvancedProtectionEnabledInternal()) goto L10;
        this.mStore.storeAdvancedProtectionModeEnabled(enabled);     // Catch: Throwable -> L8
        sendModeChanged(enabled);     // Catch: Throwable -> L8
        logAdvancedProtectionEnabled(enabled);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setUsbDataProtectionEnabled(boolean enabled) {
        if (enabled == false) goto L4;
        int value = 1;
    L5:
        setAdvancedProtectionSubSettingInt("aapm_usb_data_protection", value);
        return;
    L4:
        value = 0;
        goto L5
    }

    private void setAdvancedProtectionSubSettingInt(String key, int value) {
        long identity = Binder.clearCallingIdentity();
        ArrayMap<IBinder, IAdvancedProtectionCallback> r2 = this.mCallbacks;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        this.mStore.storeInt(key, value);     // Catch: Throwable -> L9
        Slog.i(TAG, "Advanced protection: subsetting" + key + " is " + value);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isUsbDataProtectionEnabled() {
        long identity = Binder.clearCallingIdentity();
        boolean r4 = true;
        if (this.mStore.retrieveInt("aapm_usb_data_protection", 1) == 1) goto L7;
        r4 = false;
    L7:
        Binder.restoreCallingIdentity(identity);
        return r4;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void logDialogShown(int featureId, int type, boolean learnMoreClicked) {
        logDialogShown_enforcePermission();
        if (this.mEmitLogs == true) goto L5;
        return;
    L5:
        int hoursSinceEnabled = hoursSinceLastChange();
        FrameworkStatsLog.write(FrameworkStatsLog.ADVANCED_PROTECTION_SUPPORT_DIALOG_DISPLAYED, featureIdToLogEnum(featureId), dialogueTypeToLogEnum(type), learnMoreClicked, hoursSinceEnabled);
        getSharedPreferences().edit().putInt(LAST_DIALOG_FEATURE_ID, featureId).putInt(LAST_DIALOG_TYPE, type).putBoolean(LAST_DIALOG_LEARN_MORE_CLICKED, learnMoreClicked).putInt(LAST_DIALOG_HOURS_SINCE_ENABLED, hoursSinceEnabled).apply();
    }

    private int featureIdToLogEnum(int featureId) {
        switch(featureId) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 1;
    }

    private int dialogueTypeToLogEnum(int type) {
        switch(type) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return 0;
    }

    private void logAdvancedProtectionEnabled(boolean enabled) {
        if (this.mEmitLogs == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append("Advanced protection has been ");
        if (enabled == false) goto L8;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L9:
        r0.append(r1);
        Slog.i(TAG, r0.toString());
        SharedPreferences prefs = getSharedPreferences();
        FrameworkStatsLog.write(FrameworkStatsLog.ADVANCED_PROTECTION_STATE_CHANGED, enabled, hoursSinceLastChange(), featureIdToLogEnum(prefs.getInt(LAST_DIALOG_FEATURE_ID, -1)), dialogueTypeToLogEnum(prefs.getInt(LAST_DIALOG_TYPE, -1)), prefs.getBoolean(LAST_DIALOG_LEARN_MORE_CLICKED, false), prefs.getInt(LAST_DIALOG_HOURS_SINCE_ENABLED, -1));
        prefs.edit().putLong(ENABLED_CHANGE_TIME, System.currentTimeMillis()).apply();
        return;
    L8:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L9
    }

    private int hoursSinceLastChange() {
        long lastChangeTimeMillis = getSharedPreferences().getLong(ENABLED_CHANGE_TIME, -1);
        if (lastChangeTimeMillis == (-1)) goto L6;
        int hoursSinceEnabled = (int) ((System.currentTimeMillis() - lastChangeTimeMillis) / 3600000);
        return hoursSinceEnabled;
    L6:
        return -1;
    }

    public List<AdvancedProtectionFeature> getAdvancedProtectionFeatures() {
        getAdvancedProtectionFeatures_enforcePermission();
        List<AdvancedProtectionFeature> features = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mProviders.size()) goto L6;
        features.addAll(this.mProviders.get(i).getFeatures(this.mContext));
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mHooks.size()) goto L14;
        AdvancedProtectionHook hook = this.mHooks.get(i2);
        if (hook.isAvailable() == false) goto L12;
        features.add(hook.getFeature());
    L12:
        i2 = i2 + 1;
        goto L8
    L14:
        return features;
    }

    private void enforceAdminUser(UserHandle user) {
        UserInfo info = this.mUserManager.getUserInfo(user.getIdentifier());
        if (info.isAdmin() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Only an admin user can manage advanced protection mode");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new AdvancedProtectionShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    public void dump(FileDescriptor fd, final PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        writer.println(TAG);
        writer.println("  isAdvancedProtectionEnabled: " + isAdvancedProtectionEnabledInternal());
        writer.println("  mHooks.size(): " + this.mHooks.size());
        writer.println("  mCallbacks.size(): " + this.mCallbacks.size());
        writer.println("  mProviders.size(): " + this.mProviders.size());
        writer.println("Hooks: ");
        this.mHooks.stream().forEach(new AdvancedProtectionService$$ExternalSyntheticLambda0(writer));
        writer.println("  Providers: ");
        this.mProviders.stream().forEach(new AdvancedProtectionService$$ExternalSyntheticLambda1(this, writer));
        writer.println("  mSharedPreferences: " + getSharedPreferences().getAll());
    }

    private static /* synthetic */ void lambda$dump$0(PrintWriter writer, AdvancedProtectionHook hook) {
        writer.println("    " + hook.getClass().getSimpleName() + " available: " + hook.isAvailable());
    }

    private /* synthetic */ void lambda$dump$2(final PrintWriter writer, AdvancedProtectionProvider provider) {
        writer.println("    " + provider.getClass().getSimpleName());
        provider.getFeatures(this.mContext).stream().forEach(new AdvancedProtectionService$$ExternalSyntheticLambda2(writer));
    }

    private static /* synthetic */ void lambda$dump$1(PrintWriter writer, AdvancedProtectionFeature feature) {
        writer.println("      " + feature.getClass().getSimpleName());
    }

    void sendModeChanged(boolean r4) {
        Message.obtain(this.mHandler, 0, r4 ? 1 : 0, -1).sendToTarget();
    }

    void sendCallbackAdded(boolean r4, IAdvancedProtectionCallback r5) {
        Message.obtain(this.mHandler, 1, r4 ? 1 : 0, -1, r5).sendToTarget();
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences != null) goto L6;
        initSharedPreferences();
    L6:
        return this.mSharedPreferences;
    }

    private synchronized void initSharedPreferences() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mSharedPreferences != null) goto L9;
        Context deviceContext = this.mContext.createDeviceProtectedStorageContext();     // Catch: Throwable -> L7
        File sharedPrefs = new File(Environment.getDataSystemDirectory(), PREFERENCE);     // Catch: Throwable -> L7
        this.mSharedPreferences = deviceContext.getSharedPreferences(sharedPrefs, 0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }
}
