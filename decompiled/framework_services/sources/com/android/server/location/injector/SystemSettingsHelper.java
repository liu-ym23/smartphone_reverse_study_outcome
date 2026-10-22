package com.android.server.location.injector;

import android.app.ActivityManager;
import android.app.doppelganger.DoppelgangerManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.PackageTagsList;
import android.os.RemoteException;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.SystemConfig;
import com.android.server.am.ProcessList;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.LocationManagerService;
import java.io.FileDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class SystemSettingsHelper extends SettingsHelper {
    private static final long DEFAULT_BACKGROUND_THROTTLE_INTERVAL_MS = 1800000;
    private static final long DEFAULT_BACKGROUND_THROTTLE_PROXIMITY_ALERT_INTERVAL_MS = 1800000;
    private static final float DEFAULT_COARSE_LOCATION_ACCURACY_M = 2000.0f;
    private static final String LOCATION_PACKAGE_ALLOWLIST = "locationPackagePrefixWhitelist";
    private static final String LOCATION_PACKAGE_DENYLIST = "locationPackagePrefixBlacklist";
    private final PackageTagsListSetting mAdasPackageAllowlist;
    private final LongGlobalSetting mBackgroundThrottleIntervalMs;
    private final StringSetCachedGlobalSetting mBackgroundThrottlePackageWhitelist;
    private final Context mContext;
    private final BooleanGlobalSetting mGnssMeasurementFullTracking;
    private final PackageTagsListSetting mIgnoreSettingsPackageAllowlist;
    private final IntegerSecureSetting mLocationMode;
    private final StringListCachedSecureSetting mLocationPackageBlacklist;
    private final StringListCachedSecureSetting mLocationPackageWhitelist;

    private static class BooleanGlobalSetting extends ObservingSetting {
        private final Context mContext;
        private final String mSettingName;

        BooleanGlobalSetting(Context context, String settingName, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mSettingName = settingName;
        }

        public void register() {
            register(this.mContext, Settings.Global.getUriFor(this.mSettingName));
        }

        public boolean getValue(boolean defaultValue) {
            long identity = Binder.clearCallingIdentity();
            ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L12
            String r3 = this.mSettingName;     // Catch: Throwable -> L12
            boolean r4 = false;
            if (defaultValue == false) goto L6;
            int r6 = 1;
        L7:
            if (Settings.Global.getInt(r2, r3, r6) == 0) goto L10;
            r4 = true;
        L10:
            Binder.restoreCallingIdentity(identity);
            return r4;
        L6:
            r6 = 0;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static class DeviceConfigSetting implements DeviceConfig.OnPropertiesChangedListener {
        private final CopyOnWriteArrayList<SettingsHelper.GlobalSettingChangedListener> mListeners;
        protected final String mName;
        private boolean mRegistered;

        DeviceConfigSetting(String name) {
            this.mName = name;
            this.mListeners = new CopyOnWriteArrayList();
        }

        protected synchronized boolean isRegistered() {
            monitor-enter(this);
            boolean r0 = this.mRegistered;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        protected synchronized void register() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mRegistered == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            DeviceConfig.addOnPropertiesChangedListener(LocationLogsRecorder.KEY_FILE_LOCATION, FgThread.getExecutor(), this);     // Catch: Throwable -> L10
            this.mRegistered = true;     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        public void addListener(SettingsHelper.GlobalSettingChangedListener listener) {
            this.mListeners.add(listener);
        }

        public void removeListener(SettingsHelper.GlobalSettingChangedListener listener) {
            this.mListeners.remove(listener);
        }

        public final void onPropertiesChanged(DeviceConfig.Properties properties) {
            if (properties.getKeyset().contains(this.mName) == true) goto L5;
            return;
        L5:
            onPropertiesChanged();
        }

        public void onPropertiesChanged() {
            if (LocationManagerService.D == false) goto L5;
            Log.d(LocationManagerService.TAG, "location device config setting changed: " + this.mName);
        L5:
            Iterator<SettingsHelper.GlobalSettingChangedListener> r0 = this.mListeners.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            SettingsHelper.UserSettingChangedListener listener = r0.next();
            listener.onSettingChanged(-1);
            goto L7
        }
    }

    private static class IntegerSecureSetting extends ObservingSetting {
        private final Context mContext;
        private final String mSettingName;

        IntegerSecureSetting(Context context, String settingName, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mSettingName = settingName;
        }

        void register() {
            register(this.mContext, Settings.Secure.getUriFor(this.mSettingName));
        }

        public int getValueForUser(int defaultValue, int userId) {
            long identity = Binder.clearCallingIdentity();
            int r2 = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), this.mSettingName, defaultValue, userId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static class LongGlobalSetting extends ObservingSetting {
        private final Context mContext;
        private final String mSettingName;

        LongGlobalSetting(Context context, String settingName, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mSettingName = settingName;
        }

        public void register() {
            register(this.mContext, Settings.Global.getUriFor(this.mSettingName));
        }

        public long getValue(long defaultValue) {
            long identity = Binder.clearCallingIdentity();
            long r2 = Settings.Global.getLong(this.mContext.getContentResolver(), this.mSettingName, defaultValue);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private static abstract class ObservingSetting extends ContentObserver {
        private final CopyOnWriteArrayList<SettingsHelper.UserSettingChangedListener> mListeners;
        private boolean mRegistered;

        ObservingSetting(Handler handler) {
            super(handler);
            this.mListeners = new CopyOnWriteArrayList();
        }

        protected synchronized boolean isRegistered() {
            monitor-enter(this);
            boolean r0 = this.mRegistered;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        protected synchronized void register(Context context, Uri uri) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mRegistered == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            context.getContentResolver().registerContentObserver(uri, false, this, -1);     // Catch: Throwable -> L10
            this.mRegistered = true;     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        public void addListener(SettingsHelper.UserSettingChangedListener listener) {
            this.mListeners.add(listener);
        }

        public void removeListener(SettingsHelper.UserSettingChangedListener listener) {
            this.mListeners.remove(listener);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (LocationManagerService.D == false) goto L5;
            Log.d(LocationManagerService.TAG, "location setting changed [u" + userId + "]: " + uri);
        L5:
            Iterator<SettingsHelper.UserSettingChangedListener> r0 = this.mListeners.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            SettingsHelper.UserSettingChangedListener listener = r0.next();
            listener.onSettingChanged(userId);
            goto L7
        L9:
            String path = uri.getLastPathSegment();
            if (path != null) goto L12;
            return;
        L12:
            if (path.startsWith("location_mode") == true) goto L14;
            return;
        L14:
            if (DoppelgangerManager.isActive() == false) goto L23;
            Iterator<SettingsHelper.UserSettingChangedListener> r1 = this.mListeners.iterator();
        L17:
            if (r1.hasNext() == false) goto L24;
            SettingsHelper.UserSettingChangedListener listener2 = r1.next();
            listener2.onSettingChanged(10);
            goto L17
        L24:
            return;
        }
    }

    private static class PackageTagsListSetting extends DeviceConfigSetting {
        private final Supplier<ArrayMap<String, ArraySet<String>>> mBaseValuesSupplier;
        private PackageTagsList mCachedValue;
        private boolean mValid;

        PackageTagsListSetting(String name, Supplier<ArrayMap<String, ArraySet<String>>> baseValuesSupplier) {
            super(name);
            this.mBaseValuesSupplier = baseValuesSupplier;
        }

        public synchronized PackageTagsList getValue() {
            monitor-enter(this);
            PackageTagsList value = this.mCachedValue;     // Catch: Throwable -> L37
            if (this.mValid == true) goto L42;
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L37
            PackageTagsList.Builder builder = new PackageTagsList.Builder().add(this.mBaseValuesSupplier.get());     // Catch: Throwable -> L39
            String setting = DeviceConfig.getProperty(LocationLogsRecorder.KEY_FILE_LOCATION, this.mName);     // Catch: Throwable -> L39
            if (TextUtils.isEmpty(setting) == false) goto L48;
        L32:
            value = builder.build();     // Catch: Throwable -> L39
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L37
            if (isRegistered() == false) goto L42;
            this.mValid = true;     // Catch: Throwable -> L37
            this.mCachedValue = value;     // Catch: Throwable -> L37
            goto L42
        L48:
            String[] r6 = setting.split(",");     // Catch: Throwable -> L18
            int r8 = r6.length;     // Catch: Throwable -> L18
            char r9 = 0;
            int r10 = 0;
        L11:
            if (r10 >= r8) goto L32;
            String packageAndTags = r6[r10];     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(packageAndTags) == true) goto L31;
            String[] packageThenTags = packageAndTags.split(";");     // Catch: Throwable -> L18
            String packageName = packageThenTags[r9];     // Catch: Throwable -> L18
            if (packageThenTags.length != 1) goto L20;
            builder.add(packageName);     // Catch: Throwable -> L18
            goto L31
        L20:
            int i = 1;
        L22:
            if (i >= packageThenTags.length) goto L31;
            String attributionTag = packageThenTags[i];     // Catch: Throwable -> L18
            if ("null".equals(attributionTag) == false) goto L27;
            attributionTag = null;
        L27:
            if (SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER.equals(attributionTag) == false) goto L29;
            builder.add(packageName);     // Catch: Throwable -> L18
        L30:
            i = i + 1;
            goto L22
        L29:
            builder.add(packageName, attributionTag);     // Catch: Throwable -> L18
        L31:
            r10 = r10 + 1;
            r9 = 0;
        L18:
            th = th;
        L40:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L37
            throw th;     // Catch: Throwable -> L37
        L39:
            th = th;
        L42:
            monitor-exit(this);
            return value;
        L37:
            th = move-exception;
            throw th;
        }

        public synchronized void invalidate() {
            monitor-enter(this);
            this.mValid = false;     // Catch: Throwable -> L7
            this.mCachedValue = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.injector.SystemSettingsHelper.DeviceConfigSetting
        public void onPropertiesChanged() {
            invalidate();
            super.onPropertiesChanged();
        }
    }

    private static class StringListCachedSecureSetting extends ObservingSetting {
        private int mCachedUserId;
        private List<String> mCachedValue;
        private final Context mContext;
        private final String mSettingName;

        StringListCachedSecureSetting(Context context, String settingName, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mSettingName = settingName;
            this.mCachedUserId = ProcessList.INVALID_ADJ;
        }

        public void register() {
            register(this.mContext, Settings.Secure.getUriFor(this.mSettingName));
        }

        public synchronized List<String> getValueForUser(int userId) {
            monitor-enter(this);
            if (userId == (-10000)) goto L6;
            boolean r0 = true;
        L30:
            Preconditions.checkArgument(r0);     // Catch: Throwable -> L21
            List<String> value = this.mCachedValue;     // Catch: Throwable -> L21
            if (userId == this.mCachedUserId) goto L26;
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L21
            String setting = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), this.mSettingName, userId);     // Catch: Throwable -> L23
            if (TextUtils.isEmpty(setting) == true) goto L33;
            value = Arrays.asList(setting.split(","));     // Catch: Throwable -> L23
        L18:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L21
            if (isRegistered() == false) goto L26;
            this.mCachedUserId = userId;     // Catch: Throwable -> L21
            this.mCachedValue = value;     // Catch: Throwable -> L21
            goto L26
        L33:
            value = Collections.emptyList();     // Catch: Throwable -> L14
        L14:
            th = th;
        L24:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L21
            throw th;     // Catch: Throwable -> L21
        L23:
            th = th;
        L26:
            monitor-exit(this);
            return value;
        L21:
            th = move-exception;
            throw th;
        L6:
            r0 = false;
            goto L30
        }

        public synchronized void invalidateForUser(int userId) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mCachedUserId != userId) goto L9;
            this.mCachedUserId = ProcessList.INVALID_ADJ;     // Catch: Throwable -> L7
            this.mCachedValue = null;     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }

        @Override // com.android.server.location.injector.SystemSettingsHelper.ObservingSetting, android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            invalidateForUser(userId);
            super.onChange(selfChange, uri, userId);
        }
    }

    private static class StringSetCachedGlobalSetting extends ObservingSetting {
        private final Supplier<ArraySet<String>> mBaseValuesSupplier;
        private ArraySet<String> mCachedValue;
        private final Context mContext;
        private final String mSettingName;
        private boolean mValid;

        StringSetCachedGlobalSetting(Context context, String settingName, Supplier<ArraySet<String>> baseValuesSupplier, Handler handler) {
            super(handler);
            this.mContext = context;
            this.mSettingName = settingName;
            this.mBaseValuesSupplier = baseValuesSupplier;
            this.mValid = false;
        }

        public void register() {
            register(this.mContext, Settings.Global.getUriFor(this.mSettingName));
        }

        public synchronized Set<String> getValue() {
            monitor-enter(this);
            ArraySet<String> value = this.mCachedValue;     // Catch: Throwable -> L15
            if (this.mValid == true) goto L20;
            long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L15
            value = new ArraySet(this.mBaseValuesSupplier.get());     // Catch: Throwable -> L17
            String setting = Settings.Global.getString(this.mContext.getContentResolver(), this.mSettingName);     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(setting) == false) goto L24;
        L12:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L15
            if (isRegistered() == false) goto L20;
            this.mValid = true;     // Catch: Throwable -> L15
            this.mCachedValue = value;     // Catch: Throwable -> L15
            goto L20
        L24:
            value.addAll(Arrays.asList(setting.split(",")));     // Catch: Throwable -> L10
        L10:
            th = th;
        L18:
            Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L17:
            th = th;
        L20:
            monitor-exit(this);
            return value;
        L15:
            th = move-exception;
            throw th;
        }

        public synchronized void invalidate() {
            monitor-enter(this);
            this.mValid = false;     // Catch: Throwable -> L7
            this.mCachedValue = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.injector.SystemSettingsHelper.ObservingSetting, android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            invalidate();
            super.onChange(selfChange, uri, userId);
        }
    }

    public static /* synthetic */ ArraySet $r8$lambda$D5hSJ3ILCWeTxjNZR6hpkxtM3qo() {
        return lambda$new$0();
    }

    public static /* synthetic */ ArrayMap $r8$lambda$UcXev39VEZjQnyg0eNXvTO_rGi8() {
        return lambda$new$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$_hBfffMRVuv6KUot7q35h9_0K-U, reason: not valid java name */
    public static /* synthetic */ ArrayMap m5379$r8$lambda$_hBfffMRVuv6KUot7q35h9_0KU() {
        return lambda$new$2();
    }

    public SystemSettingsHelper(Context context) {
        this.mContext = context;
        this.mLocationMode = new IntegerSecureSetting(context, "location_mode", FgThread.getHandler());
        this.mBackgroundThrottleIntervalMs = new LongGlobalSetting(context, "location_background_throttle_interval_ms", FgThread.getHandler());
        this.mGnssMeasurementFullTracking = new BooleanGlobalSetting(context, "enable_gnss_raw_meas_full_tracking", FgThread.getHandler());
        this.mLocationPackageBlacklist = new StringListCachedSecureSetting(context, LOCATION_PACKAGE_DENYLIST, FgThread.getHandler());
        this.mLocationPackageWhitelist = new StringListCachedSecureSetting(context, LOCATION_PACKAGE_ALLOWLIST, FgThread.getHandler());
        this.mBackgroundThrottlePackageWhitelist = new StringSetCachedGlobalSetting(context, "location_background_throttle_package_whitelist", new SystemSettingsHelper$$ExternalSyntheticLambda0(), FgThread.getHandler());
        this.mAdasPackageAllowlist = new PackageTagsListSetting("adas_settings_allowlist", new SystemSettingsHelper$$ExternalSyntheticLambda1());
        this.mIgnoreSettingsPackageAllowlist = new PackageTagsListSetting("ignore_settings_allowlist", new SystemSettingsHelper$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ ArraySet lambda$new$0() {
        return SystemConfig.getInstance().getAllowUnthrottledLocation();
    }

    private static /* synthetic */ ArrayMap lambda$new$1() {
        return SystemConfig.getInstance().getAllowAdasLocationSettings();
    }

    private static /* synthetic */ ArrayMap lambda$new$2() {
        return SystemConfig.getInstance().getAllowIgnoreLocationSettings();
    }

    public void onSystemReady() {
        this.mLocationMode.register();
        this.mBackgroundThrottleIntervalMs.register();
        this.mLocationPackageBlacklist.register();
        this.mLocationPackageWhitelist.register();
        this.mBackgroundThrottlePackageWhitelist.register();
        this.mIgnoreSettingsPackageAllowlist.register();
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public boolean isLocationEnabled(int userId) {
        if (this.mLocationMode.getValueForUser(0, userId) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void setLocationEnabled(boolean enabled, int userId) {
        long identity = Binder.clearCallingIdentity();
        ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L10
        if (enabled == false) goto L6;
        int r4 = 3;
    L7:
        Settings.Secure.putIntForUser(r2, "location_mode", r4, userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addOnLocationEnabledChangedListener(SettingsHelper.UserSettingChangedListener listener) {
        this.mLocationMode.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeOnLocationEnabledChangedListener(SettingsHelper.UserSettingChangedListener listener) {
        this.mLocationMode.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public long getBackgroundThrottleIntervalMs() {
        return this.mBackgroundThrottleIntervalMs.getValue(1800000);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addOnBackgroundThrottleIntervalChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mBackgroundThrottleIntervalMs.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeOnBackgroundThrottleIntervalChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mBackgroundThrottleIntervalMs.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public boolean isLocationPackageBlacklisted(int userId, String packageName) {
        List<String> locationPackageBlacklist = this.mLocationPackageBlacklist.getValueForUser(userId);
        if (locationPackageBlacklist.isEmpty() == false) goto L5;
        return false;
    L5:
        List<String> locationPackageWhitelist = this.mLocationPackageWhitelist.getValueForUser(userId);
        Iterator<String> r3 = locationPackageWhitelist.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        String locationWhitelistPackage = r3.next();
        if (packageName.startsWith(locationWhitelistPackage) == false) goto L7;
        return false;
    L12:
        Iterator<String> r4 = locationPackageBlacklist.iterator();
    L14:
        if (r4.hasNext() == false) goto L20;
        String locationBlacklistPackage = r4.next();
        if (packageName.startsWith(locationBlacklistPackage) == false) goto L14;
        return true;
    L20:
        return false;
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addOnLocationPackageBlacklistChangedListener(SettingsHelper.UserSettingChangedListener listener) {
        this.mLocationPackageBlacklist.addListener(listener);
        this.mLocationPackageWhitelist.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeOnLocationPackageBlacklistChangedListener(SettingsHelper.UserSettingChangedListener listener) {
        this.mLocationPackageBlacklist.removeListener(listener);
        this.mLocationPackageWhitelist.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public Set<String> getBackgroundThrottlePackageWhitelist() {
        return this.mBackgroundThrottlePackageWhitelist.getValue();
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addOnBackgroundThrottlePackageWhitelistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mBackgroundThrottlePackageWhitelist.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeOnBackgroundThrottlePackageWhitelistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mBackgroundThrottlePackageWhitelist.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public boolean isGnssMeasurementsFullTrackingEnabled() {
        return this.mGnssMeasurementFullTracking.getValue(false);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addOnGnssMeasurementsFullTrackingEnabledChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mGnssMeasurementFullTracking.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeOnGnssMeasurementsFullTrackingEnabledChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mGnssMeasurementFullTracking.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public PackageTagsList getAdasAllowlist() {
        return this.mAdasPackageAllowlist.getValue();
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addAdasAllowlistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mAdasPackageAllowlist.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeAdasAllowlistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mAdasPackageAllowlist.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public PackageTagsList getIgnoreSettingsAllowlist() {
        return this.mIgnoreSettingsPackageAllowlist.getValue();
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void addIgnoreSettingsAllowlistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mIgnoreSettingsPackageAllowlist.addListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void removeIgnoreSettingsAllowlistChangedListener(SettingsHelper.GlobalSettingChangedListener listener) {
        this.mIgnoreSettingsPackageAllowlist.removeListener(listener);
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public long getBackgroundThrottleProximityAlertIntervalMs() {
        long identity = Binder.clearCallingIdentity();
        long r2 = Settings.Global.getLong(this.mContext.getContentResolver(), "location_background_throttle_proximity_alert_interval_ms", 1800000);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public float getCoarseLocationAccuracyM() {
        long identity = Binder.clearCallingIdentity();
        ContentResolver cr = this.mContext.getContentResolver();
        float r3 = Settings.Secure.getFloatForUser(cr, "locationCoarseAccuracy", DEFAULT_COARSE_LOCATION_ACCURACY_M, cr.getUserId());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    @Override // com.android.server.location.injector.SettingsHelper
    public void dump(FileDescriptor fd, IndentingPrintWriter ipw, String[] args) {
        int[] userIds = ActivityManager.getService().getRunningUserIds();     // Catch: RemoteException -> L50
        ipw.print("Location Setting: ");
        ipw.increaseIndent();
        int r3 = 0;
        if (userIds.length <= 1) goto L9;
        ipw.println();
        int r1 = userIds.length;
        int r4 = 0;
    L7:
        if (r4 >= r1) goto L10;
        int userId = userIds[r4];
        ipw.print("[u");
        ipw.print(userId);
        ipw.print("] ");
        ipw.println(isLocationEnabled(userId));
        r4 = r4 + 1;
    L10:
        ipw.decreaseIndent();
        ipw.println("Location Allow/Deny Packages:");
        ipw.increaseIndent();
        if (userIds.length <= 1) goto L28;
        int r2 = userIds.length;
    L14:
        if (r3 >= r2) goto L36;
        int userId2 = userIds[r3];
        List<String> locationPackageBlacklist = this.mLocationPackageBlacklist.getValueForUser(userId2);
        if (locationPackageBlacklist.isEmpty() == true) goto L27;
        ipw.print("user ");
        ipw.print(userId2);
        ipw.println(":");
        ipw.increaseIndent();
        Iterator<String> r7 = locationPackageBlacklist.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        String packageName = r7.next();
        ipw.print("[deny] ");
        ipw.println(packageName);
        goto L20
    L22:
        List<String> locationPackageWhitelist = this.mLocationPackageWhitelist.getValueForUser(userId2);
        Iterator<String> r8 = locationPackageWhitelist.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        String packageName2 = r8.next();
        ipw.print("[allow] ");
        ipw.println(packageName2);
        goto L24
    L26:
        ipw.decreaseIndent();
    L27:
        r3 = r3 + 1;
    L36:
        ipw.decreaseIndent();
        Set<String> backgroundThrottlePackageWhitelist = this.mBackgroundThrottlePackageWhitelist.getValue();
        if (backgroundThrottlePackageWhitelist.isEmpty() == true) goto L43;
        ipw.println("Throttling Allow Packages:");
        ipw.increaseIndent();
        Iterator<String> r5 = backgroundThrottlePackageWhitelist.iterator();
    L40:
        if (r5.hasNext() == false) goto L42;
        String packageName3 = r5.next();
        ipw.println(packageName3);
        goto L40
    L42:
        ipw.decreaseIndent();
    L43:
        PackageTagsList ignoreSettingsAllowlist = this.mIgnoreSettingsPackageAllowlist.getValue();
        if (ignoreSettingsAllowlist.isEmpty() == true) goto L46;
        ipw.println("Emergency Bypass Allow Packages:");
        ipw.increaseIndent();
        ignoreSettingsAllowlist.dump(ipw);
        ipw.decreaseIndent();
    L46:
        PackageTagsList adasPackageAllowlist = this.mAdasPackageAllowlist.getValue();
        if (adasPackageAllowlist.isEmpty() == true) goto L64;
        ipw.println("ADAS Bypass Allow Packages:");
        ipw.increaseIndent();
        adasPackageAllowlist.dump(ipw);
        ipw.decreaseIndent();
        return;
    L64:
        return;
    L28:
        Iterator<String> r6 = this.mLocationPackageBlacklist.getValueForUser(userIds[0]).iterator();
    L30:
        if (r6.hasNext() == false) goto L32;
        String packageName4 = r6.next();
        ipw.print("[deny] ");
        ipw.println(packageName4);
        goto L30
    L32:
        List<String> locationPackageWhitelist2 = this.mLocationPackageWhitelist.getValueForUser(userIds[0]);
        Iterator<String> r9 = locationPackageWhitelist2.iterator();
    L34:
        if (r9.hasNext() == false) goto L36;
        String packageName5 = r9.next();
        ipw.print("[allow] ");
        ipw.println(packageName5);
        goto L34
    L9:
        ipw.println(isLocationEnabled(userIds[0]));
    L50:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }
}
