package com.android.server.timedetector;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.time.TimeCapabilities;
import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.timedetector.TimeDetectorHelper;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.IUserRestrictionsListener;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.timezonedetector.StateChangeListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
final class ServiceConfigAccessorImpl implements ServiceConfigAccessor {
    private static final int[] DEFAULT_AUTOMATIC_TIME_ORIGIN_PRIORITIES = null;
    private static final Set<String> SERVER_FLAGS_KEYS_TO_WATCH = null;
    private static final Object SLOCK = null;
    private static final int SYSTEM_CLOCK_CONFIRMATION_THRESHOLD_MILLIS = 1000;
    private static ServiceConfigAccessor sInstance;
    private final ConfigOriginPrioritiesSupplier mConfigOriginPrioritiesSupplier;
    private final List<StateChangeListener> mConfigurationInternalListeners;
    private final Context mContext;
    private final ContentResolver mCr;
    private final ServerFlags mServerFlags;
    private final ServerFlagsOriginPrioritiesSupplier mServerFlagsOriginPrioritiesSupplier;
    private final int mSystemClockUpdateThresholdMillis;
    private final UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.server.timedetector.ServiceConfigAccessorImpl$3, reason: invalid class name */
    class AnonymousClass3 extends IUserRestrictionsListener.Stub {
        final /* synthetic */ ServiceConfigAccessorImpl this$0;
        final /* synthetic */ Handler val$mainThreadHandler;

        public static /* synthetic */ void $r8$lambda$QhQzZpHDNys2C73KpTK4fmrmOEo(AnonymousClass3 r0, int r1, Bundle r2, Bundle r3) {
            r0.lambda$onUserRestrictionsChanged$0(r1, r2, r3);
        }

        AnonymousClass3(ServiceConfigAccessorImpl this$0, Handler r2) {
            this.this$0 = this$0;
            this.val$mainThreadHandler = r2;
        }

        public void onUserRestrictionsChanged(final int userId, final Bundle newRestrictions, final Bundle prevRestrictions) {
            this.val$mainThreadHandler.post(new ServiceConfigAccessorImpl$3$$ExternalSyntheticLambda0(this, userId, newRestrictions, prevRestrictions));
        }

        private /* synthetic */ void lambda$onUserRestrictionsChanged$0(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
            ServiceConfigAccessorImpl.m8556$$Nest$mhandleUserRestrictionsChangeOnMainThread(this.this$0, userId, newRestrictions, prevRestrictions);
        }
    }

    private static abstract class BaseOriginPrioritiesSupplier implements Supplier<int[]> {
        private int[] mLastPriorityInts;
        private String[] mLastPriorityStrings;

        /* synthetic */ BaseOriginPrioritiesSupplier(ServiceConfigAccessorImplIA r1) {
            this();
        }

        protected abstract String[] lookupPriorityStrings();

        private BaseOriginPrioritiesSupplier() {
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ int[] get() {
            return get2();
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public int[] get2() {
            String[] priorityStrings = lookupPriorityStrings();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (Arrays.equals(this.mLastPriorityStrings, priorityStrings) == false) goto L11;
            int[] r1 = this.mLastPriorityInts;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r1;
        L11:
            int[] priorityInts = null;
            if (priorityStrings != null) goto L14;
        L27:
            this.mLastPriorityStrings = priorityStrings;     // Catch: Throwable -> L9
            this.mLastPriorityInts = priorityInts;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return priorityInts;
        L14:
            priorityInts = new int[priorityStrings.length];     // Catch: Throwable -> L9
            int i = 0;
        L33:
            if (i >= priorityInts.length) goto L27;
            String priorityString = priorityStrings[i];     // Catch: Throwable -> L9 IllegalArgumentException -> L23
            if (priorityString == null) goto L20;
            boolean r4 = true;
        L21:
            Preconditions.checkArgument(r4);     // Catch: Throwable -> L9 IllegalArgumentException -> L23
            priorityInts[i] = TimeDetectorStrategy.stringToOrigin(priorityString.trim());     // Catch: Throwable -> L9 IllegalArgumentException -> L23
            i = i + 1;
            goto L33
        L20:
            r4 = false;
        L26:
            priorityInts = null;
            goto L27
        }
    }

    private static class ConfigOriginPrioritiesSupplier extends BaseOriginPrioritiesSupplier {
        private final Context mContext;

        /* synthetic */ ConfigOriginPrioritiesSupplier(Context r1, ServiceConfigAccessorImplIA r2) {
            this(r1);
        }

        private ConfigOriginPrioritiesSupplier(Context context) {
            super(null);
            context.getClass();
            this.mContext = context;
        }

        @Override // com.android.server.timedetector.ServiceConfigAccessorImpl.BaseOriginPrioritiesSupplier
        protected String[] lookupPriorityStrings() {
            return this.mContext.getResources().getStringArray(R.array.config_cameraPrivacyLightAlsLuxThresholds);
        }
    }

    private static class ServerFlagsOriginPrioritiesSupplier extends BaseOriginPrioritiesSupplier {
        private final ServerFlags mServerFlags;

        /* synthetic */ ServerFlagsOriginPrioritiesSupplier(ServerFlags r1, ServiceConfigAccessorImplIA r2) {
            this(r1);
        }

        private ServerFlagsOriginPrioritiesSupplier(ServerFlags serverFlags) {
            super(null);
            serverFlags.getClass();
            this.mServerFlags = serverFlags;
        }

        @Override // com.android.server.timedetector.ServiceConfigAccessorImpl.BaseOriginPrioritiesSupplier
        protected String[] lookupPriorityStrings() {
            Optional<String[]> priorityStrings = this.mServerFlags.getOptionalStringArray(ServerFlags.KEY_TIME_DETECTOR_ORIGIN_PRIORITIES_OVERRIDE);
            return priorityStrings.orElse(null);
        }
    }

    public static /* synthetic */ void $r8$lambda$nptVIKX1svyx1Casf3_He0845j0(ServiceConfigAccessorImpl r0) {
        r0.handleConfigurationInternalChangeOnMainThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleConfigurationInternalChangeOnMainThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8555$$Nest$mhandleConfigurationInternalChangeOnMainThread(ServiceConfigAccessorImpl r0) {
        r0.handleConfigurationInternalChangeOnMainThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUserRestrictionsChangeOnMainThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8556$$Nest$mhandleUserRestrictionsChangeOnMainThread(ServiceConfigAccessorImpl r0, int r1, Bundle r2, Bundle r3) {
        r0.handleUserRestrictionsChangeOnMainThread(r1, r2, r3);
    }

    static {
        DEFAULT_AUTOMATIC_TIME_ORIGIN_PRIORITIES = new int[]{1, 3};
        SERVER_FLAGS_KEYS_TO_WATCH = Set.of(ServerFlags.KEY_TIME_DETECTOR_LOWER_BOUND_MILLIS_OVERRIDE, ServerFlags.KEY_TIME_DETECTOR_ORIGIN_PRIORITIES_OVERRIDE);
        SLOCK = new Object();
    }

    private ServiceConfigAccessorImpl(Context context) {
        this.mConfigurationInternalListeners = new ArrayList();
        context.getClass();
        this.mContext = context;
        this.mCr = context.getContentResolver();
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mServerFlags = ServerFlags.getInstance(this.mContext);
        ServiceConfigAccessorImplIA r1 = null;
        this.mConfigOriginPrioritiesSupplier = new ConfigOriginPrioritiesSupplier(context, r1);
        this.mServerFlagsOriginPrioritiesSupplier = new ServerFlagsOriginPrioritiesSupplier(this.mServerFlags, r1);
        this.mSystemClockUpdateThresholdMillis = context.getResources().getInteger(R.integer.config_virtualDisplayLimitPerPackage);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_SWITCHED");
        this.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, null);
        final Handler mainThreadHandler = this.mContext.getMainThreadHandler();
        ContentResolver contentResolver = this.mContext.getContentResolver();
        ContentObserver contentObserver = new AnonymousClass2(this, mainThreadHandler);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("auto_time"), true, contentObserver);
        this.mServerFlags.addListener(new ServiceConfigAccessorImpl$$ExternalSyntheticLambda0(this), SERVER_FLAGS_KEYS_TO_WATCH);
        this.mUserManager.addUserRestrictionsListener(new AnonymousClass3(this, mainThreadHandler));
    }

    static ServiceConfigAccessor getInstance(Context context) {
        Object r0 = SLOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ServiceConfigAccessorImpl(context);     // Catch: Throwable -> L7
    L9:
        ServiceConfigAccessor r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    private void handleConfigurationInternalChangeOnMainThread() {
        monitor-enter(this);
        List<StateChangeListener> configurationInternalListeners = new ArrayList(this.mConfigurationInternalListeners);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator<StateChangeListener> r1 = configurationInternalListeners.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        StateChangeListener changeListener = r1.next();
        changeListener.onChange();
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleUserRestrictionsChangeOnMainThread(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
        handleConfigurationInternalChangeOnMainThread();
    }

    @Override // com.android.server.timedetector.ServiceConfigAccessor
    public synchronized void addConfigurationInternalChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        List<StateChangeListener> r0 = this.mConfigurationInternalListeners;     // Catch: Throwable -> L6
        listener.getClass();     // Catch: Throwable -> L6
        r0.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.ServiceConfigAccessor
    public synchronized void removeConfigurationInternalChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        List<StateChangeListener> r0 = this.mConfigurationInternalListeners;     // Catch: Throwable -> L6
        listener.getClass();     // Catch: Throwable -> L6
        r0.remove(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.ServiceConfigAccessor
    public synchronized ConfigurationInternal getCurrentUserConfigurationInternal() {
        monitor-enter(this);
        int currentUserId = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentUserId();     // Catch: Throwable -> L6
        ConfigurationInternal r1 = getConfigurationInternal(currentUserId);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.ServiceConfigAccessor
    public synchronized boolean updateConfiguration(int userId, TimeConfiguration requestedConfiguration, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
        requestedConfiguration.getClass();     // Catch: Throwable -> L12
        TimeCapabilitiesAndConfig capabilitiesAndConfig = getConfigurationInternal(userId).createCapabilitiesAndConfig(bypassUserPolicyChecks);     // Catch: Throwable -> L12
        TimeCapabilities capabilities = capabilitiesAndConfig.getCapabilities();     // Catch: Throwable -> L12
        TimeConfiguration oldConfiguration = capabilitiesAndConfig.getConfiguration();     // Catch: Throwable -> L12
        TimeConfiguration newConfiguration = capabilities.tryApplyConfigChanges(oldConfiguration, requestedConfiguration);     // Catch: Throwable -> L12
        if (newConfiguration != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        storeConfiguration(userId, newConfiguration);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    private void storeConfiguration(int userId, TimeConfiguration configuration) {
        configuration.getClass();
        if (isAutoDetectionSupported() == false) goto L6;
        boolean autoDetectionEnabled = configuration.isAutoDetectionEnabled();
        setAutoDetectionEnabledIfRequired(autoDetectionEnabled);
        return;
    }

    @Override // com.android.server.timedetector.ServiceConfigAccessor
    public synchronized ConfigurationInternal getConfigurationInternal(int userId) {
        monitor-enter(this);
        TimeDetectorHelper timeDetectorHelper = TimeDetectorHelper.INSTANCE;     // Catch: Throwable -> L6
        ConfigurationInternal r1 = new ConfigurationInternal.Builder(userId).setUserConfigAllowed(isUserConfigAllowed(userId)).setAutoDetectionSupported(isAutoDetectionSupported()).setAutoDetectionEnabledSetting(getAutoDetectionEnabledSetting()).setSystemClockUpdateThresholdMillis(getSystemClockUpdateThresholdMillis()).setSystemClockConfidenceThresholdMillis(getSystemClockConfidenceUpgradeThresholdMillis()).setAutoSuggestionLowerBound(getAutoSuggestionLowerBound()).setManualSuggestionLowerBound(timeDetectorHelper.getManualSuggestionLowerBound()).setSuggestionUpperBound(timeDetectorHelper.getSuggestionUpperBound()).setOriginPriorities(getOriginPriorities()).build();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    private void setAutoDetectionEnabledIfRequired(boolean r3) {
        if (getAutoDetectionEnabledSetting() == r3) goto L6;
        Settings.Global.putInt(this.mCr, "auto_time", r3 ? 1 : 0);
        return;
    }

    private boolean isUserConfigAllowed(int userId) {
        UserHandle userHandle = UserHandle.of(userId);
        return !this.mUserManager.hasUserRestriction("no_config_date_time", userHandle);
    }

    private boolean getAutoDetectionEnabledSetting() {
        if (Settings.Global.getInt(this.mCr, "auto_time", 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isAutoDetectionSupported() {
        int[] originsSupported = getOriginPriorities();
        int r1 = originsSupported.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        int originSupported = originsSupported[r3];
        if (originSupported == 3) goto L16;
        if (originSupported == 5) goto L16;
        if (originSupported == 4) goto L16;
        if (originSupported != 1) goto L15;
        boolean deviceHasTelephony = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
        if (deviceHasTelephony == false) goto L15;
        return true;
    L15:
        r3 = r3 + 1;
    L16:
        return true;
    L17:
        return false;
    }

    private int getSystemClockUpdateThresholdMillis() {
        return this.mSystemClockUpdateThresholdMillis;
    }

    private int getSystemClockConfidenceUpgradeThresholdMillis() {
        return 1000;
    }

    private Instant getAutoSuggestionLowerBound() {
        return this.mServerFlags.getOptionalInstant(ServerFlags.KEY_TIME_DETECTOR_LOWER_BOUND_MILLIS_OVERRIDE).orElse(TimeDetectorHelper.INSTANCE.getAutoSuggestionLowerBoundDefault());
    }

    private int[] getOriginPriorities() {
        int[] serverFlagsValue = this.mServerFlagsOriginPrioritiesSupplier.get2();
        if (serverFlagsValue == null) goto L5;
        return serverFlagsValue;
    L5:
        int[] configValue = this.mConfigOriginPrioritiesSupplier.get2();
        if (configValue == null) goto L9;
        return configValue;
    L9:
        return DEFAULT_AUTOMATIC_TIME_ORIGIN_PRIORITIES;
    }
}
