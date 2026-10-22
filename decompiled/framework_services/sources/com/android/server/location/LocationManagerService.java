package com.android.server.location;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.app.compat.CompatChanges;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Geofence;
import android.location.GnssAntennaInfo;
import android.location.GnssCapabilities;
import android.location.GnssMeasurementCorrections;
import android.location.GnssMeasurementRequest;
import android.location.IGnssAntennaInfoListener;
import android.location.IGnssMeasurementsListener;
import android.location.IGnssNavigationMessageListener;
import android.location.IGnssNmeaListener;
import android.location.IGnssStatusListener;
import android.location.ILocationCallback;
import android.location.ILocationListener;
import android.location.ILocationManager;
import android.location.LastLocationRequest;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationManagerInternal;
import android.location.LocationProvider;
import android.location.LocationRequest;
import android.location.LocationTime;
import android.location.provider.ForwardGeocodeRequest;
import android.location.provider.IGeocodeCallback;
import android.location.provider.IProviderRequestListener;
import android.location.provider.ProviderProperties;
import android.location.provider.ReverseGeocodeRequest;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.ICancellationSignal;
import android.os.PackageTagsList;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.WorkSource;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.location.eventlog.LocationEventLog;
import com.android.server.location.fudger.LocationFudgerCache;
import com.android.server.location.geofence.GeofenceManager;
import com.android.server.location.geofence.GeofenceProxy;
import com.android.server.location.gnss.GnssConfiguration;
import com.android.server.location.gnss.GnssLocationProvider;
import com.android.server.location.gnss.GnssManagerService;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.injector.AlarmHelper;
import com.android.server.location.injector.AppForegroundHelper;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.DeviceIdleHelper;
import com.android.server.location.injector.DeviceStationaryHelper;
import com.android.server.location.injector.EmergencyHelper;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationPermissionsHelper;
import com.android.server.location.injector.LocationPowerSaveModeHelper;
import com.android.server.location.injector.LocationUsageLogger;
import com.android.server.location.injector.PackageResetHelper;
import com.android.server.location.injector.ScreenInteractiveHelper;
import com.android.server.location.injector.SettingsHelper;
import com.android.server.location.injector.SystemAlarmHelper;
import com.android.server.location.injector.SystemAppForegroundHelper;
import com.android.server.location.injector.SystemAppOpsHelper;
import com.android.server.location.injector.SystemDeviceIdleHelper;
import com.android.server.location.injector.SystemDeviceStationaryHelper;
import com.android.server.location.injector.SystemEmergencyHelper;
import com.android.server.location.injector.SystemLocationPermissionsHelper;
import com.android.server.location.injector.SystemLocationPowerSaveModeHelper;
import com.android.server.location.injector.SystemPackageResetHelper;
import com.android.server.location.injector.SystemScreenInteractiveHelper;
import com.android.server.location.injector.SystemSettingsHelper;
import com.android.server.location.injector.SystemUserInfoHelper;
import com.android.server.location.injector.UserInfoHelper;
import com.android.server.location.provider.AbstractLocationProvider;
import com.android.server.location.provider.LocationProviderManager;
import com.android.server.location.provider.MockLocationProvider;
import com.android.server.location.provider.PassiveLocationProvider;
import com.android.server.location.provider.PassiveLocationProviderManager;
import com.android.server.location.provider.StationaryThrottlingLocationProvider;
import com.android.server.location.provider.proxy.ProxyGeocodeProvider;
import com.android.server.location.provider.proxy.ProxyLocationProvider;
import com.android.server.location.provider.proxy.ProxyPopulationDensityProvider;
import com.android.server.location.settings.LocationSettings;
import com.android.server.location.settings.LocationUserSettings;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class LocationManagerService extends ILocationManager.Stub implements LocationProviderManager.StateChangedListener {
    private static final String ATTRIBUTION_TAG = "LocationService";
    public static boolean D = false;
    public static final String TAG = "LocationManagerService";
    private String mComboNlpPackageName;
    private String mComboNlpReadyMarker;
    private String mComboNlpScreenMarker;
    private final Context mContext;
    private ILocationListener mDeprecatedGnssBatchingListener;
    private final Object mDeprecatedGnssBatchingLock;
    private String mExtraLocationControllerPackage;
    private boolean mExtraLocationControllerPackageEnabled;
    private ProxyGeocodeProvider mGeocodeProvider;
    private final GeofenceManager mGeofenceManager;
    private volatile GnssManagerService mGnssManagerService;
    private final Injector mInjector;
    private final LocalService mLocalService;
    private LocationFudgerCache mLocationFudgerCache;
    LocationManagerInternal.LocationPackageTagsListener mLocationTagsChangedListener;
    final Object mLock;
    private final PassiveLocationProviderManager mPassiveManager;
    private ProxyPopulationDensityProvider mPopulationDensityProvider;
    final CopyOnWriteArrayList<LocationProviderManager> mProviderManagers;

    public static class Lifecycle extends SystemService {
        private final LocationManagerService mService;
        private final SystemInjector mSystemInjector;
        private final LifecycleUserInfoHelper mUserInfoHelper;

        private static class LifecycleUserInfoHelper extends SystemUserInfoHelper {
            LifecycleUserInfoHelper(Context context) {
                super(context);
            }

            void onUserStarted(int userId) {
                dispatchOnUserStarted(userId);
            }

            void onUserStopped(int userId) {
                dispatchOnUserStopped(userId);
            }

            void onCurrentUserChanged(int fromUserId, int toUserId) {
                dispatchOnCurrentUserChanged(fromUserId, toUserId);
            }
        }

        public Lifecycle(Context context) {
            super(context);
            this.mUserInfoHelper = new LifecycleUserInfoHelper(context);
            this.mSystemInjector = new SystemInjector(context, this.mUserInfoHelper);
            this.mService = new LocationManagerService(context, this.mSystemInjector);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService(LocationLogsRecorder.KEY_FILE_LOCATION, this.mService);
            LocationManager.invalidateLocalLocationEnabledCaches();
            LocationManager.disableLocalLocationEnabledCaches();
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            this.mSystemInjector.onSystemReady();
            this.mService.onSystemReady();
            return;
        L6:
            if (phase != 600) goto L10;
            this.mService.onSystemThirdPartyAppsCanStart();
            StarLocation.getInstance().initLocation();
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            this.mUserInfoHelper.onUserStarted(user.getUserIdentifier());
            LocationManagerService.m5146$$Nest$mlogLocationEnabledState(this.mService);
            LocationManagerService.m5145$$Nest$mlogEmergencyState(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            this.mUserInfoHelper.onCurrentUserChanged(from.getUserIdentifier(), to.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            this.mUserInfoHelper.onUserStopped(user.getUserIdentifier());
        }
    }

    private class LocalService extends LocationManagerInternal {
        final /* synthetic */ LocationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$zOgkdbQhX97ia_6zLR94eXWADOo(LocationManagerInternal.LocationPackageTagsListener r0, int r1, PackageTagsList r2) {
            lambda$setLocationPackageTagsListener$0(r0, r1, r2);
        }

        LocalService(LocationManagerService r1) {
            this.this$0 = r1;
        }

        public boolean isProviderEnabledForUser(String provider, int userId) {
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "isProviderEnabledForUser", null);
            LocationProviderManager manager = this.this$0.getLocationProviderManager(provider);
            if (manager != null) goto L7;
            return false;
        L7:
            return manager.isEnabled(userId2);
        }

        public void addProviderEnabledListener(String provider, LocationManagerInternal.ProviderEnabledListener listener) {
            LocationProviderManager manager = this.this$0.getLocationProviderManager(provider);
            manager.getClass();
            manager.addEnabledListener(listener);
        }

        public void removeProviderEnabledListener(String provider, LocationManagerInternal.ProviderEnabledListener listener) {
            LocationProviderManager manager = this.this$0.getLocationProviderManager(provider);
            manager.getClass();
            manager.removeEnabledListener(listener);
        }

        public boolean isProvider(String provider, CallerIdentity identity) {
            Iterator<LocationProviderManager> r0 = this.this$0.mProviderManagers.iterator();
        L4:
            if (r0.hasNext() == false) goto L17;
            LocationProviderManager manager = r0.next();
            if (provider == null) goto L11;
            if (provider.equals(manager.getName()) == false) goto L4;
        L11:
            if (identity.equals(manager.getProviderIdentity()) == false) goto L4;
            if (manager.isVisibleToCaller() == false) goto L4;
            return true;
        L17:
            return false;
        }

        public LocationTime getGnssTimeMillis() {
            LocationProviderManager gpsManager = this.this$0.getLocationProviderManager("gps");
            if (gpsManager != null) goto L5;
            return null;
        L5:
            Location location = gpsManager.getLastLocationUnsafe(-1, 2, false, Long.MAX_VALUE);
            if (location != null) goto L9;
            return null;
        L9:
            return new LocationTime(location.getTime(), location.getElapsedRealtimeNanos());
        }

        public void setLocationPackageTagsListener(final LocationManagerInternal.LocationPackageTagsListener listener) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.mLocationTagsChangedListener = listener;     // Catch: Throwable -> L12
            if (listener == null) goto L22;
            ArraySet<Integer> uids = new ArraySet(this.this$0.mProviderManagers.size());     // Catch: Throwable -> L12
            Iterator<LocationProviderManager> r2 = this.this$0.mProviderManagers.iterator();     // Catch: Throwable -> L12
        L8:
            if (r2.hasNext() == false) goto L15;
            LocationProviderManager manager = r2.next();     // Catch: Throwable -> L12
            CallerIdentity identity = manager.getProviderIdentity();     // Catch: Throwable -> L12
            if (identity == null) goto L8;
            uids.add(Integer.valueOf(identity.getUid()));     // Catch: Throwable -> L12
            goto L8
        L15:
            Iterator<Integer> r3 = uids.iterator();     // Catch: Throwable -> L12
        L17:
            if (r3.hasNext() == false) goto L22;
            final int uid = r3.next().intValue();     // Catch: Throwable -> L12
            final PackageTagsList tags = this.this$0.calculateAppOpsLocationSourceTags(uid);     // Catch: Throwable -> L12
            if (tags.isEmpty() == true) goto L17;
            FgThread.getHandler().post(new LocationManagerService$LocalService$$ExternalSyntheticLambda0(listener, uid, tags));     // Catch: Throwable -> L12
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$setLocationPackageTagsListener$0(LocationManagerInternal.LocationPackageTagsListener listener, int uid, PackageTagsList tags) {
            listener.onLocationPackageTagsChanged(uid, tags);
        }
    }

    private static final class SystemInjector implements Injector {
        private final AlarmHelper mAlarmHelper;
        private final SystemAppForegroundHelper mAppForegroundHelper;
        private final SystemAppOpsHelper mAppOpsHelper;
        private final Context mContext;
        private final SystemDeviceIdleHelper mDeviceIdleHelper;
        private final SystemDeviceStationaryHelper mDeviceStationaryHelper;
        private SystemEmergencyHelper mEmergencyCallHelper;
        private final SystemLocationPermissionsHelper mLocationPermissionsHelper;
        private final SystemLocationPowerSaveModeHelper mLocationPowerSaveModeHelper;
        private final LocationSettings mLocationSettings;
        private final LocationUsageLogger mLocationUsageLogger;
        private final PackageResetHelper mPackageResetHelper;
        private final SystemScreenInteractiveHelper mScreenInteractiveHelper;
        private final SystemSettingsHelper mSettingsHelper;
        private boolean mSystemReady;
        private final SystemUserInfoHelper mUserInfoHelper;

        SystemInjector(Context context, SystemUserInfoHelper userInfoHelper) {
            this.mContext = context;
            this.mUserInfoHelper = userInfoHelper;
            this.mLocationSettings = new LocationSettings(context);
            this.mAlarmHelper = new SystemAlarmHelper(context);
            this.mAppOpsHelper = new SystemAppOpsHelper(context);
            this.mLocationPermissionsHelper = new SystemLocationPermissionsHelper(context, this.mAppOpsHelper);
            this.mSettingsHelper = new SystemSettingsHelper(context);
            this.mAppForegroundHelper = new SystemAppForegroundHelper(context);
            this.mLocationPowerSaveModeHelper = new SystemLocationPowerSaveModeHelper(context);
            this.mScreenInteractiveHelper = new SystemScreenInteractiveHelper(context);
            this.mDeviceStationaryHelper = new SystemDeviceStationaryHelper();
            this.mDeviceIdleHelper = new SystemDeviceIdleHelper(context);
            this.mLocationUsageLogger = new LocationUsageLogger();
            this.mPackageResetHelper = new SystemPackageResetHelper(context);
        }

        synchronized void onSystemReady() {
            monitor-enter(this);
            this.mUserInfoHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mAppOpsHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mLocationPermissionsHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mSettingsHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mAppForegroundHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mLocationPowerSaveModeHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mScreenInteractiveHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mDeviceStationaryHelper.onSystemReady();     // Catch: Throwable -> L6
            this.mDeviceIdleHelper.onSystemReady();     // Catch: Throwable -> L6
            if (this.mEmergencyCallHelper == null) goto L8;
            this.mEmergencyCallHelper.onSystemReady();     // Catch: Throwable -> L6
        L8:
            this.mSystemReady = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.injector.Injector
        public UserInfoHelper getUserInfoHelper() {
            return this.mUserInfoHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public LocationSettings getLocationSettings() {
            return this.mLocationSettings;
        }

        @Override // com.android.server.location.injector.Injector
        public AlarmHelper getAlarmHelper() {
            return this.mAlarmHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public AppOpsHelper getAppOpsHelper() {
            return this.mAppOpsHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public LocationPermissionsHelper getLocationPermissionsHelper() {
            return this.mLocationPermissionsHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public SettingsHelper getSettingsHelper() {
            return this.mSettingsHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public AppForegroundHelper getAppForegroundHelper() {
            return this.mAppForegroundHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public LocationPowerSaveModeHelper getLocationPowerSaveModeHelper() {
            return this.mLocationPowerSaveModeHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public ScreenInteractiveHelper getScreenInteractiveHelper() {
            return this.mScreenInteractiveHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public DeviceStationaryHelper getDeviceStationaryHelper() {
            return this.mDeviceStationaryHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public DeviceIdleHelper getDeviceIdleHelper() {
            return this.mDeviceIdleHelper;
        }

        @Override // com.android.server.location.injector.Injector
        public synchronized EmergencyHelper getEmergencyHelper() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mEmergencyCallHelper != null) goto L10;
            this.mEmergencyCallHelper = new SystemEmergencyHelper(this.mContext);     // Catch: Throwable -> L8
            if (this.mSystemReady == false) goto L10;
            this.mEmergencyCallHelper.onSystemReady();     // Catch: Throwable -> L8
        L10:
            SystemEmergencyHelper r0 = this.mEmergencyCallHelper;     // Catch: Throwable -> L8
            monitor-exit(this);
            return r0;
        }

        @Override // com.android.server.location.injector.Injector
        public LocationUsageLogger getLocationUsageLogger() {
            return this.mLocationUsageLogger;
        }

        @Override // com.android.server.location.injector.Injector
        public PackageResetHelper getPackageResetHelper() {
            return this.mPackageResetHelper;
        }
    }

    public static /* synthetic */ void $r8$lambda$4pXLUGdc1ZZk6PGd2_mM71U3nsY(LocationManagerService r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ String[] $r8$lambda$6MROPOjvUM8LNGJwGMKCH7A0R0s(LocationManagerService r0, int r1) {
        return r0.lambda$new$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$6c2pN5bSGWwMbCJXYQGSIqoMNSk(LocationManagerService r0, int r1) {
        r0.onLocationModeChanged(r1);
    }

    public static /* synthetic */ String[] $r8$lambda$F5OljuzcjvDlFwBQ9pGN3AoBIp8(LocationManagerService r0, int r1) {
        return r0.lambda$new$3(r1);
    }

    public static /* synthetic */ LocationUserSettings $r8$lambda$NYJFEmGPRFlTUcx40AYXqS5JJEk(boolean r0, LocationUserSettings r1) {
        return lambda$setAdasGnssLocationEnabledForUser$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$TAWQqGQwAPdcArzax5yh_01u9oM(LocationManagerService r0) {
        r0.onEmergencyStateChanged();
    }

    public static /* synthetic */ void $r8$lambda$ZCbzyxB3CueH3y4nKqrLrxUVRZk(LocationManagerService r0, int r1, LocationUserSettings r2, LocationUserSettings r3) {
        r0.onLocationUserSettingsChanged(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$b8M_HdyVjo8K58Kq92prpn865fg(LocationManagerService r0) {
        r0.lambda$new$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$eyTQ4ijUbfA4AoGXfSy3i0Mr-d8, reason: not valid java name */
    public static /* synthetic */ void m5142$r8$lambda$eyTQ4ijUbfA4AoGXfSy3i0Mrd8(LocationManagerService r0, int r1, int r2) {
        r0.lambda$new$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kwp4RhvxNBiY1jhPHD3YdojaxUw(LocationManagerInternal.LocationPackageTagsListener r0, int r1, PackageTagsList r2) {
        lambda$onStateChanged$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$nPBMjpla8mzhPFk-pAdPm6o8AMI, reason: not valid java name */
    public static /* synthetic */ void m5143$r8$lambda$nPBMjpla8mzhPFkpAdPm6o8AMI(LocationManagerInternal.LocationPackageTagsListener r0, int r1, PackageTagsList r2) {
        lambda$onStateChanged$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ujQuQQ3Bc3ydTqqn2V1w-z0TnO4, reason: not valid java name */
    public static /* synthetic */ void m5144$r8$lambda$ujQuQQ3Bc3ydTqqn2V1wz0TnO4(LocationManagerService r0, String r1, int r2, String r3, String r4, int r5, int r6) {
        r0.lambda$onSystemReady$5(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogEmergencyState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5145$$Nest$mlogEmergencyState(LocationManagerService r0) {
        r0.logEmergencyState();
    }

    /* JADX INFO: renamed from: -$$Nest$mlogLocationEnabledState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5146$$Nest$mlogLocationEnabledState(LocationManagerService r0) {
        r0.logLocationEnabledState();
    }

    static {
        D = Log.isLoggable(TAG, 3);
    }

    LocationManagerService(Context context, Injector injector) {
        this.mLock = new Object();
        this.mGnssManagerService = null;
        this.mPopulationDensityProvider = null;
        this.mLocationFudgerCache = null;
        this.mDeprecatedGnssBatchingLock = new Object();
        this.mProviderManagers = new CopyOnWriteArrayList();
        this.mContext = context.createAttributionContext(ATTRIBUTION_TAG);
        this.mInjector = injector;
        this.mLocalService = new LocalService(this);
        LocalServices.addService(LocationManagerInternal.class, this.mLocalService);
        this.mGeofenceManager = new GeofenceManager(this.mContext, injector);
        this.mInjector.getLocationSettings().registerLocationUserSettingsListener(new LocationManagerService$$ExternalSyntheticLambda5(this));
        this.mInjector.getSettingsHelper().addOnLocationEnabledChangedListener(new LocationManagerService$$ExternalSyntheticLambda6(this));
        this.mInjector.getSettingsHelper().addAdasAllowlistChangedListener(new LocationManagerService$$ExternalSyntheticLambda7(this));
        this.mInjector.getSettingsHelper().addIgnoreSettingsAllowlistChangedListener(new LocationManagerService$$ExternalSyntheticLambda8(this));
        this.mInjector.getUserInfoHelper().addListener(new LocationManagerService$$ExternalSyntheticLambda9(this));
        this.mInjector.getEmergencyHelper().addOnEmergencyStateChangedListener(new LocationManagerService$$ExternalSyntheticLambda10(this));
        this.mPassiveManager = new PassiveLocationProviderManager(this.mContext, injector);
        addLocationProviderManager(this.mPassiveManager, new PassiveLocationProvider(this.mContext));
        LegacyPermissionManagerInternal permissionManagerInternal = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        permissionManagerInternal.setLocationPackagesProvider(new LocationManagerService$$ExternalSyntheticLambda11(this));
        permissionManagerInternal.setLocationExtraPackagesProvider(new LocationManagerService$$ExternalSyntheticLambda12(this));
        StarLocation.getInstance().initOnce(this.mContext);
    }

    private /* synthetic */ void lambda$new$0() {
        refreshAppOpsRestrictions(-1);
    }

    private /* synthetic */ void lambda$new$1() {
        refreshAppOpsRestrictions(-1);
    }

    private /* synthetic */ void lambda$new$2(int userId, int change) {
        if (change != 2) goto L6;
        refreshAppOpsRestrictions(userId);
        return;
    }

    private /* synthetic */ String[] lambda$new$3(int userId) {
        return this.mContext.getResources().getStringArray(R.array.config_notificationFallbackVibeWaveform);
    }

    private /* synthetic */ String[] lambda$new$4(int userId) {
        return this.mContext.getResources().getStringArray(R.array.config_notificationFallbackVibePattern);
    }

    LocationProviderManager getLocationProviderManager(String providerName) {
        if (providerName != null) goto L5;
        return null;
    L5:
        Iterator<LocationProviderManager> r1 = this.mProviderManagers.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        LocationProviderManager manager = r1.next();
        if (providerName.equals(manager.getName()) == false) goto L7;
        if (manager.isVisibleToCaller() == true) goto L13;
        return null;
    L13:
        return manager;
    L15:
        return null;
    }

    private LocationProviderManager getOrAddLocationProviderManager(String providerName) {
        CopyOnWriteArrayList<LocationProviderManager> r0 = this.mProviderManagers;
        monitor-enter(r0);
        Iterator<LocationProviderManager> r1 = this.mProviderManagers.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L14;
        LocationProviderManager manager = r1.next();     // Catch: Throwable -> L11
        if (providerName.equals(manager.getName()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return manager;
    L14:
        LocationProviderManager manager2 = new LocationProviderManager(this.mContext, this.mInjector, providerName, this.mPassiveManager);     // Catch: Throwable -> L11
        addLocationProviderManager(manager2, null);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return manager2;
    L11:
        th = move-exception;
        throw th;
    }

    void addLocationProviderManager(LocationProviderManager manager, AbstractLocationProvider realProvider) {
        CopyOnWriteArrayList<LocationProviderManager> r0 = this.mProviderManagers;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (getLocationProviderManager(manager.getName()) != null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L22
        manager.startManager(this);     // Catch: Throwable -> L22
        if (realProvider != null) goto L11;
    L25:
        this.mProviderManagers.add(manager);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L11:
        if (manager != this.mPassiveManager) goto L13;
    L24:
        manager.setRealProvider(realProvider);     // Catch: Throwable -> L22
        goto L25
    L13:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == false) goto L15;
        int defaultStationaryThrottlingSetting = 0;
    L17:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "location_enable_stationary_throttle", defaultStationaryThrottlingSetting) != 0) goto L20;
    L20:
        if (0 == 0) goto L24;
        realProvider = new StationaryThrottlingLocationProvider(manager.getName(), this.mInjector, realProvider);     // Catch: Throwable -> L22
        goto L24
    L15:
        defaultStationaryThrottlingSetting = 1;
        goto L17
    L7:
        r1 = false;
        goto L8
    }

    protected void setProxyPopulationDensityProvider(ProxyPopulationDensityProvider provider) {
        this.mPopulationDensityProvider = provider;
    }

    protected void setLocationFudgerCache(LocationFudgerCache cache) {
        this.mLocationFudgerCache = cache;
        Iterator<LocationProviderManager> r0 = this.mProviderManagers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationProviderManager manager = r0.next();
        manager.setLocationFudgerCache(cache);
        goto L4
    }

    private void removeLocationProviderManager(LocationProviderManager manager) {
        CopyOnWriteArrayList<LocationProviderManager> r0 = this.mProviderManagers;
        monitor-enter(r0);
        boolean removed = this.mProviderManagers.remove(manager);     // Catch: Throwable -> L7
        Preconditions.checkArgument(removed);     // Catch: Throwable -> L7
        manager.setMockProvider(null);     // Catch: Throwable -> L7
        manager.setRealProvider(null);     // Catch: Throwable -> L7
        manager.stopManager();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onSystemReady() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOps.getClass();
        appOps.startWatchingNoted(new int[]{1, 0}, new LocationManagerService$$ExternalSyntheticLambda2(this));
        return;
    }

    private /* synthetic */ void lambda$onSystemReady$5(String code, int uid, String packageName, String attributionTag, int flags, int result) {
        if (isLocationEnabledForUser(UserHandle.getUserId(uid)) == true) goto L6;
        Log.w(TAG, "location noteOp with location off - " + CallerIdentity.forTest(uid, 0, packageName, attributionTag));
        return;
    }

    void onSystemThirdPartyAppsCanStart() {
        ProxyLocationProvider networkProvider = ProxyLocationProvider.create(this.mContext, "network", "com.android.location.service.v3.NetworkLocationProvider", R.bool.config_enablePrimaryLocationTimeZoneProvider, R.string.config_secondaryHomePackage);
        if (networkProvider == null) goto L5;
        LocationProviderManager networkManager = new LocationProviderManager(this.mContext, this.mInjector, "network", this.mPassiveManager);
        addLocationProviderManager(networkManager, networkProvider);
    L6:
        char r6 = 0;
        char r4 = 1;
        Preconditions.checkState(!this.mContext.getPackageManager().queryIntentServicesAsUser(new Intent("com.android.location.service.FusedLocationProvider"), 1572864, 0).isEmpty(), "Unable to find a direct boot aware fused location provider");
        ProxyLocationProvider fusedProvider = ProxyLocationProvider.create(this.mContext, "fused", "com.android.location.service.FusedLocationProvider", R.bool.config_enableGnssAssistanceOverlay, R.string.config_pointing_ui_class, R.bool.config_handleVolumeAliasesUsingVolumeGroups);
        if (fusedProvider == null) goto L9;
        LocationProviderManager fusedManager = new LocationProviderManager(this.mContext, this.mInjector, "fused", this.mPassiveManager);
        addLocationProviderManager(fusedManager, fusedProvider);
    L10:
        boolean hasLocationFeature = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location");
        if (hasLocationFeature == true) goto L13;
    L21:
        this.mGeocodeProvider = ProxyGeocodeProvider.createAndRegister(this.mContext);
        if (this.mGeocodeProvider != null) goto L24;
        Log.e(TAG, "no geocoder provider found");
    L24:
        this.mComboNlpPackageName = this.mContext.getResources().getString(R.string.config_defaultQrCodeComponent);
        if (this.mComboNlpPackageName == null) goto L27;
        this.mComboNlpReadyMarker = this.mComboNlpPackageName + ".nlp:ready";
        this.mComboNlpScreenMarker = this.mComboNlpPackageName + ".nlp:screen";
    L27:
        long startTime = System.currentTimeMillis();
        setProxyPopulationDensityProvider(ProxyPopulationDensityProvider.createAndRegister(this.mContext));
        int duration = (int) (System.currentTimeMillis() - startTime);
        if (this.mPopulationDensityProvider != null) goto L31;
        Log.e(TAG, "no population density provider found");
    L31:
        if (this.mPopulationDensityProvider != null) goto L33;
        boolean r10 = true;
    L34:
        FrameworkStatsLog.write(1002, r10, duration);
        if (this.mPopulationDensityProvider == null) goto L37;
        setLocationFudgerCache(new LocationFudgerCache(this.mPopulationDensityProvider));
    L37:
        HardwareActivityRecognitionProxy hardwareActivityRecognitionProxy = HardwareActivityRecognitionProxy.createAndRegister(this.mContext);
        if (hardwareActivityRecognitionProxy != null) goto L41;
        Log.e(TAG, "unable to bind ActivityRecognitionProxy");
    L41:
        if (this.mGnssManagerService == null) goto L45;
        GeofenceProxy provider = GeofenceProxy.createAndBind(this.mContext, this.mGnssManagerService.getGnssGeofenceProxy());
        if (provider != null) goto L45;
        Log.e(TAG, "unable to bind to GeofenceProxy");
    L45:
        String[] testProviderStrings = this.mContext.getResources().getStringArray(R.array.cross_profile_apps);
        int r8 = testProviderStrings.length;
        int r9 = 0;
    L46:
        if (r9 >= r8) goto L48;
        String testProviderString = testProviderStrings[r9];
        String[] fragments = testProviderString.split(",");
        String name = fragments[r6].trim();
        ProviderProperties properties = new ProviderProperties.Builder().setHasNetworkRequirement(Boolean.parseBoolean(fragments[r4])).setHasSatelliteRequirement(Boolean.parseBoolean(fragments[2])).setHasCellRequirement(Boolean.parseBoolean(fragments[3])).setHasMonetaryCost(Boolean.parseBoolean(fragments[4])).setHasAltitudeSupport(Boolean.parseBoolean(fragments[5])).setHasSpeedSupport(Boolean.parseBoolean(fragments[6])).setHasBearingSupport(Boolean.parseBoolean(fragments[7])).setPowerUsage(Integer.parseInt(fragments[8])).setAccuracy(Integer.parseInt(fragments[9])).build();
        LocationProviderManager manager = getOrAddLocationProviderManager(name);
        manager.setMockProvider(new MockLocationProvider(properties, CallerIdentity.fromContext(this.mContext), Collections.emptySet()));
        r9 = r9 + 1;
        r4 = 1;
        r6 = 0;
        goto L46
    L48:
        return;
    L33:
        r10 = false;
        goto L34
    L13:
        if (GnssNative.isSupported() == false) goto L21;
        GnssConfiguration gnssConfiguration = new GnssConfiguration(this.mContext);
        GnssNative gnssNative = GnssNative.create(this.mInjector, gnssConfiguration);
        this.mGnssManagerService = new GnssManagerService(this.mContext, this.mInjector, gnssNative);
        this.mGnssManagerService.onSystemReady();
        boolean useGnssHardwareProvider = this.mContext.getResources().getBoolean(R.bool.config_use_voip_mode_for_ims);
        AbstractLocationProvider gnssProvider = null;
        if (useGnssHardwareProvider == true) goto L17;
        gnssProvider = ProxyLocationProvider.create(this.mContext, "gps", "android.location.provider.action.GNSS_PROVIDER", R.bool.config_enableLockScreenRotation, R.string.config_primaryLocationTimeZoneProviderPackageName, R.bool.config_hasPermanentDpad);
    L17:
        if (gnssProvider != null) goto L19;
        gnssProvider = this.mGnssManagerService.getGnssLocationProvider();
    L20:
        LocationProviderManager gnssManager = new LocationProviderManager(this.mContext, this.mInjector, "gps", this.mPassiveManager);
        addLocationProviderManager(gnssManager, gnssProvider);
        goto L21
    L19:
        LocationProviderManager gnssHardwareManager = new LocationProviderManager(this.mContext, this.mInjector, "gps_hardware", null, Collections.singletonList("android.permission.LOCATION_HARDWARE"));
        addLocationProviderManager(gnssHardwareManager, this.mGnssManagerService.getGnssLocationProvider());
        goto L20
    L9:
        Log.wtf(TAG, "no fused location provider found");
        goto L10
    L5:
        Log.w(TAG, "no network location provider found");
        goto L6
    }

    private void onLocationUserSettingsChanged(int userId, LocationUserSettings oldSettings, LocationUserSettings newSettings) {
        if (oldSettings.isAdasGnssLocationEnabled() == newSettings.isAdasGnssLocationEnabled()) goto L9;
        boolean enabled = newSettings.isAdasGnssLocationEnabled();
        if (D == false) goto L7;
        Log.d(TAG, "[u" + userId + "] adas gnss location enabled = " + enabled);
    L7:
        LocationEventLog.EVENT_LOG.logAdasLocationEnabled(userId, enabled);
        Intent intent = new Intent("android.location.action.ADAS_GNSS_ENABLED_CHANGED").putExtra("android.location.extra.ADAS_GNSS_ENABLED", enabled).addFlags(1073741824).addFlags(268435456);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
        return;
    }

    private void onLocationModeChanged(int userId) {
        boolean enabled = this.mInjector.getSettingsHelper().isLocationEnabled(userId);
        LocationManager.invalidateLocalLocationEnabledCaches();
        if (D == false) goto L5;
        Log.d(TAG, "[u" + userId + "] location enabled = " + enabled);
    L5:
        LocationEventsTracker.getInstance().trackLocationUiOnOffTime(enabled, userId, System.currentTimeMillis());
        LocationEventLog.EVENT_LOG.logLocationEnabled(userId, enabled);
        logLocationEnabledState();
        Intent intent = new Intent("android.location.MODE_CHANGED").putExtra("android.location.extra.LOCATION_ENABLED", enabled).addFlags(1073741824).addFlags(268435456);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
        refreshAppOpsRestrictions(userId);
    }

    private void onEmergencyStateChanged() {
        logEmergencyState();
    }

    private void logEmergencyState() {
        boolean isInEmergency = this.mInjector.getEmergencyHelper().isInEmergency(Long.MIN_VALUE);
        this.mInjector.getLocationUsageLogger().logEmergencyStateChanged(isInEmergency);
    }

    private void logLocationEnabledState() {
        boolean locationEnabled = false;
        int[] runningUserIds = this.mInjector.getUserInfoHelper().getRunningUserIds();
        int r2 = runningUserIds.length;
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        int userId = runningUserIds[r3];
        locationEnabled = this.mInjector.getSettingsHelper().isLocationEnabled(userId);
        if (locationEnabled == true) goto L9;
        r3 = r3 + 1;
    L9:
        this.mInjector.getLocationUsageLogger().logLocationEnabledStateChanged(locationEnabled);
    }

    public int getGnssYearOfHardware() {
        if (this.mGnssManagerService != null) goto L6;
        return 0;
    L6:
        return this.mGnssManagerService.getGnssYearOfHardware();
    }

    public String getGnssHardwareModelName() {
        if (this.mGnssManagerService != null) goto L6;
        return "";
    L6:
        return this.mGnssManagerService.getGnssHardwareModelName();
    }

    public int getGnssBatchSize() {
        if (this.mGnssManagerService != null) goto L6;
        return 0;
    L6:
        return this.mGnssManagerService.getGnssBatchSize();
    }

    public void startGnssBatch(long periodNanos, ILocationListener listener, String packageName, String attributionTag, String listenerId) {
        startGnssBatch_enforcePermission();
        if (this.mGnssManagerService != null) goto L5;
        return;
    L5:
        long intervalMs = TimeUnit.NANOSECONDS.toMillis(periodNanos);
        Object r3 = this.mDeprecatedGnssBatchingLock;
        monitor-enter(r3);
        stopGnssBatch();     // Catch: Throwable -> L10
        registerLocationListener("gps", new LocationRequest.Builder(intervalMs).setMaxUpdateDelayMillis(((long) this.mGnssManagerService.getGnssBatchSize()) * intervalMs).setHiddenFromAppOps(true).build(), listener, packageName, attributionTag, listenerId);     // Catch: Throwable -> L10
        this.mDeprecatedGnssBatchingListener = listener;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void flushGnssBatch() {
        flushGnssBatch_enforcePermission();
        if (this.mGnssManagerService != null) goto L5;
        return;
    L5:
        Object r0 = this.mDeprecatedGnssBatchingLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mDeprecatedGnssBatchingListener == null) goto L12;
        requestListenerFlush("gps", this.mDeprecatedGnssBatchingListener, 0);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void stopGnssBatch() {
        stopGnssBatch_enforcePermission();
        if (this.mGnssManagerService != null) goto L5;
        return;
    L5:
        Object r0 = this.mDeprecatedGnssBatchingLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mDeprecatedGnssBatchingListener == null) goto L12;
        ILocationListener listener = this.mDeprecatedGnssBatchingListener;     // Catch: Throwable -> L10
        this.mDeprecatedGnssBatchingListener = null;     // Catch: Throwable -> L10
        unregisterLocationListener(listener);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public boolean hasProvider(String provider) {
        if (getLocationProviderManager(provider) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public List<String> getAllProviders() {
        ArrayList<String> providers = new ArrayList(this.mProviderManagers.size());
        Iterator<LocationProviderManager> r1 = this.mProviderManagers.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        LocationProviderManager manager = r1.next();
        if (manager.isVisibleToCaller() == false) goto L4;
        providers.add(manager.getName());
        goto L4
    L9:
        return providers;
    }

    public List<String> getProviders(Criteria criteria, boolean enabledOnly) {
        if (LocationPermissions.checkCallingOrSelfLocationPermission(this.mContext, 1) == false) goto L5;
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<String> providers = new ArrayList(this.mProviderManagers.size());     // Catch: Throwable -> L18
        Iterator<LocationProviderManager> r2 = this.mProviderManagers.iterator();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L26;
        LocationProviderManager manager = r2.next();     // Catch: Throwable -> L18
        if (manager.isVisibleToCaller() == false) goto L10;
        String name = manager.getName();     // Catch: Throwable -> L18
        if (enabledOnly == false) goto L20;
        if (manager.isEnabled(UserHandle.getCallingUserId()) == false) goto L10;
    L20:
        if (criteria == null) goto L24;
        if (LocationProvider.propertiesMeetCriteria(name, manager.getProperties(), criteria) == false) goto L10;
    L24:
        providers.add(name);     // Catch: Throwable -> L18
        goto L10
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return providers;
    L18:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    public String getBestProvider(Criteria criteria, boolean enabledOnly) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<String> providers = getProviders(criteria, enabledOnly);     // Catch: Throwable -> L7
        if (providers.isEmpty() == false) goto L9;
        providers = getProviders(null, enabledOnly);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (providers.isEmpty() == false) goto L13;
        return null;
    L13:
        if (providers.contains("fused") == false) goto L17;
        return "fused";
    L17:
        if (providers.contains("gps") == false) goto L21;
        return "gps";
    L21:
        if (providers.contains("network") == false) goto L25;
        return "network";
    L25:
        return providers.get(0);
    L7:
        th = move-exception;
        throw th;
    }

    public String[] getBackgroundThrottlingWhitelist() {
        return (String[]) this.mInjector.getSettingsHelper().getBackgroundThrottlePackageWhitelist().toArray(new String[0]);
    }

    public PackageTagsList getIgnoreSettingsAllowlist() {
        return this.mInjector.getSettingsHelper().getIgnoreSettingsAllowlist();
    }

    public PackageTagsList getAdasAllowlist() {
        return this.mInjector.getSettingsHelper().getAdasAllowlist();
    }

    public ICancellationSignal getCurrentLocation(String provider, LocationRequest request, ILocationCallback consumer, String packageName, String attributionTag, String listenerId) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        int permissionLevel = LocationPermissions.getPermissionLevel(this.mContext, identity.getUid(), identity.getPid());
        boolean r2 = true;
        if (permissionLevel != 0) goto L9;
        if (this.mContext.checkCallingPermission("android.permission.LOCATION_BYPASS") == 0) goto L7;
        LocationPermissions.enforceLocationPermission(identity.getUid(), permissionLevel, 1);
        goto L9
    L7:
        permissionLevel = 2;
    L9:
        if (identity.getPid() != Process.myPid()) goto L13;
        if (attributionTag != null) goto L13;
        boolean r3 = false;
    L14:
        Preconditions.checkState(r3);
        LocationRequest request2 = validateLocationRequest(provider, request, identity);
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager != null) goto L18;
        r2 = false;
    L18:
        Preconditions.checkArgument(r2, "provider \"" + provider + "\" does not exist");
        return manager.getCurrentLocation(request2, identity, permissionLevel, consumer);
    L13:
        r3 = true;
        goto L14
    }

    public void registerLocationListener(String provider, LocationRequest request, ILocationListener listener, String packageName, String attributionTag, String listenerId) {
        ActivityManagerInternal managerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (managerInternal == null) goto L5;
        managerInternal.logFgsApiBegin(3, Binder.getCallingUid(), Binder.getCallingPid());
    L5:
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, listenerId);
        int permissionLevel = LocationPermissions.getPermissionLevel(this.mContext, identity.getUid(), identity.getPid());
        boolean r3 = true;
        if (permissionLevel != 0) goto L12;
        if (this.mContext.checkCallingPermission("android.permission.LOCATION_BYPASS") == 0) goto L10;
        LocationPermissions.enforceLocationPermission(identity.getUid(), permissionLevel, 1);
        goto L12
    L10:
        permissionLevel = 2;
    L12:
        if (identity.getPid() != Process.myPid()) goto L15;
        if (attributionTag != null) goto L15;
        Log.w(TAG, "system location request with no attribution tag", new IllegalArgumentException());
    L15:
        LocationRequest request2 = validateLocationRequest(provider, request, identity);
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager != null) goto L19;
        r3 = false;
    L19:
        Preconditions.checkArgument(r3, "provider \"" + provider + "\" does not exist");
        manager.registerLocationRequest(request2, identity, permissionLevel, listener);
    }

    public void registerLocationPendingIntent(String provider, LocationRequest request, PendingIntent pendingIntent, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, AppOpsManager.toReceiverId(pendingIntent));
        int permissionLevel = LocationPermissions.getPermissionLevel(this.mContext, identity.getUid(), identity.getPid());
        boolean r2 = true;
        if (permissionLevel != 0) goto L9;
        if (this.mContext.checkCallingPermission("android.permission.LOCATION_BYPASS") == 0) goto L7;
        LocationPermissions.enforceLocationPermission(identity.getUid(), permissionLevel, 1);
        goto L9
    L7:
        permissionLevel = 2;
    L9:
        if (identity.getPid() != Process.myPid()) goto L13;
        if (attributionTag != null) goto L13;
        boolean r3 = false;
    L14:
        Preconditions.checkArgument(r3);
        if (CompatChanges.isChangeEnabled(169887240, identity.getUid()) == true) goto L17;
    L32:
        LocationRequest request2 = validateLocationRequest(provider, request, identity);
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager != null) goto L36;
        r2 = false;
    L36:
        Preconditions.checkArgument(r2, "provider \"" + provider + "\" does not exist");
        manager.registerLocationRequest(request2, identity, permissionLevel, pendingIntent);
        return;
    L17:
        if (request.isLowPower() == false) goto L19;
    L26:
        boolean usesSystemApi = true;
    L28:
        if (usesSystemApi == false) goto L32;
        throw new SecurityException("PendingIntent location requests may not use system APIs: " + request);
    L19:
        if (request.isHiddenFromAppOps() == true) goto L26;
        if (request.isLocationSettingsIgnored() == true) goto L26;
        if (request.getWorkSource().isEmpty() == false) goto L26;
        usesSystemApi = false;
    L13:
        r3 = true;
        goto L14
    }

    private LocationRequest validateLocationRequest(String provider, LocationRequest request, CallerIdentity identity) {
        if (request.getWorkSource().isEmpty() == true) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", "setting a work source requires android.permission.UPDATE_DEVICE_STATS");
    L5:
        LocationRequest.Builder sanitized = new LocationRequest.Builder(request);
        if (CompatChanges.isChangeEnabled(168936375, Binder.getCallingUid()) == false) goto L8;
    L10:
        WorkSource workSource = new WorkSource(request.getWorkSource());
        if (workSource.size() > 0) goto L13;
    L15:
        List<WorkSource.WorkChain> workChains = workSource.getWorkChains();
        if (workChains != null) goto L18;
    L23:
        if (workSource.isEmpty() == false) goto L25;
        identity.addToWorkSource(workSource);
    L25:
        sanitized.setWorkSource(workSource);
        LocationRequest request2 = sanitized.build();
        boolean isLocationProvider = this.mLocalService.isProvider(null, identity);
        if (request2.isLowPower() == false) goto L31;
        if (CompatChanges.isChangeEnabled(168936375, identity.getUid()) == false) goto L31;
        this.mContext.enforceCallingOrSelfPermission("android.permission.LOCATION_HARDWARE", "low power request requires android.permission.LOCATION_HARDWARE");
    L31:
        if (request2.isHiddenFromAppOps() == false) goto L34;
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_APP_OPS_STATS", "hiding from app ops requires android.permission.UPDATE_APP_OPS_STATS");
    L34:
        if (request2.isAdasGnssBypass() == false) goto L46;
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L44;
        if ("gps".equals(provider) == false) goto L42;
        if (isLocationProvider == true) goto L46;
        LocationPermissions.enforceCallingOrSelfBypassPermission(this.mContext);
        goto L46
    L42:
        throw new IllegalArgumentException("adas gnss bypass requests are only allowed on the \"gps\" provider");
    L44:
        throw new IllegalArgumentException("adas gnss bypass requests are only allowed on automotive devices");
    L46:
        if (request2.isLocationSettingsIgnored() == false) goto L49;
        if (isLocationProvider == true) goto L49;
        LocationPermissions.enforceCallingOrSelfBypassPermission(this.mContext);
    L49:
        return request2;
    L18:
        if (workChains.isEmpty() == true) goto L23;
        if (workChains.get(0).getAttributionTag() != null) goto L23;
        Log.w(TAG, "received (and ignoring) illegal worksource with no attribution tag");
        workSource.clear();
        goto L23
    L13:
        if (workSource.getPackageName(0) != null) goto L15;
        Log.w(TAG, "received (and ignoring) illegal worksource with no package name");
        workSource.clear();
        goto L23
    L8:
        if (this.mContext.checkCallingPermission("android.permission.LOCATION_HARDWARE") == 0) goto L10;
        sanitized.setLowPower(false);
        goto L10
    }

    public void requestListenerFlush(String provider, ILocationListener listener, int requestCode) {
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "provider \"" + provider + "\" does not exist");
        listener.getClass();
        manager.flush(listener, requestCode);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void requestPendingIntentFlush(String provider, PendingIntent pendingIntent, int requestCode) {
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "provider \"" + provider + "\" does not exist");
        pendingIntent.getClass();
        manager.flush(pendingIntent, requestCode);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void unregisterLocationListener(ILocationListener listener) {
        ActivityManagerInternal managerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (managerInternal == null) goto L5;
        managerInternal.logFgsApiEnd(3, Binder.getCallingUid(), Binder.getCallingPid());
    L5:
        Iterator<LocationProviderManager> r1 = this.mProviderManagers.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        LocationProviderManager manager = r1.next();
        manager.unregisterLocationRequest(listener);
        goto L7
    }

    public void unregisterLocationPendingIntent(PendingIntent pendingIntent) {
        Iterator<LocationProviderManager> r0 = this.mProviderManagers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationProviderManager manager = r0.next();
        manager.unregisterLocationRequest(pendingIntent);
        goto L4
    }

    public Location getLastLocation(String provider, LastLocationRequest request, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag);
        int permissionLevel = LocationPermissions.getPermissionLevel(this.mContext, identity.getUid(), identity.getPid());
        boolean r2 = true;
        if (permissionLevel != 0) goto L9;
        if (this.mContext.checkCallingPermission("android.permission.LOCATION_BYPASS") == 0) goto L7;
        LocationPermissions.enforceLocationPermission(identity.getUid(), permissionLevel, 1);
        goto L9
    L7:
        permissionLevel = 2;
    L9:
        if (identity.getPid() != Process.myPid()) goto L13;
        if (attributionTag != null) goto L13;
        r2 = false;
    L13:
        Preconditions.checkArgument(r2);
        LastLocationRequest request2 = validateLastLocationRequest(provider, request, identity);
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager != null) goto L18;
        return null;
    L18:
        return manager.getLastLocation(request2, identity, permissionLevel);
    }

    private LastLocationRequest validateLastLocationRequest(String provider, LastLocationRequest request, CallerIdentity identity) {
        LastLocationRequest.Builder sanitized = new LastLocationRequest.Builder(request);
        LastLocationRequest request2 = sanitized.build();
        boolean isLocationProvider = this.mLocalService.isProvider(null, identity);
        if (request2.isHiddenFromAppOps() == false) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_APP_OPS_STATS", "hiding from app ops requires android.permission.UPDATE_APP_OPS_STATS");
    L6:
        if (request2.isAdasGnssBypass() == false) goto L18;
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L16;
        if ("gps".equals(provider) == false) goto L14;
        if (isLocationProvider == true) goto L18;
        LocationPermissions.enforceCallingOrSelfBypassPermission(this.mContext);
        goto L18
    L14:
        throw new IllegalArgumentException("adas gnss bypass requests are only allowed on the \"gps\" provider");
    L16:
        throw new IllegalArgumentException("adas gnss bypass requests are only allowed on automotive devices");
    L18:
        if (request2.isLocationSettingsIgnored() == false) goto L21;
        if (isLocationProvider == true) goto L21;
        LocationPermissions.enforceCallingOrSelfBypassPermission(this.mContext);
    L21:
        return request2;
    }

    public LocationTime getGnssTimeMillis() {
        return this.mLocalService.getGnssTimeMillis();
    }

    public void injectLocation(Location location) {
        super.injectLocation_enforcePermission();
        Preconditions.checkArgument(location.isComplete());
        int userId = UserHandle.getCallingUserId();
        LocationProviderManager manager = getLocationProviderManager(location.getProvider());
        if (manager != null) goto L5;
        return;
    L5:
        if (manager.isEnabled(userId) == false) goto L9;
        location.getClass();
        manager.injectLastLocation(location, userId);
        return;
    }

    public void requestGeofence(Geofence geofence, PendingIntent intent, String packageName, String attributionTag) {
        this.mGeofenceManager.addGeofence(geofence, intent, packageName, attributionTag);
    }

    public void removeGeofence(PendingIntent pendingIntent) {
        this.mGeofenceManager.removeGeofence(pendingIntent);
    }

    public void registerGnssStatusCallback(IGnssStatusListener listener, String packageName, String attributionTag, String listenerId) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.registerGnssStatusCallback(listener, packageName, attributionTag, listenerId);
        return;
    }

    public void unregisterGnssStatusCallback(IGnssStatusListener listener) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.unregisterGnssStatusCallback(listener);
        return;
    }

    public void registerGnssNmeaCallback(IGnssNmeaListener listener, String packageName, String attributionTag, String listenerId) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.registerGnssNmeaCallback(listener, packageName, attributionTag, listenerId);
        return;
    }

    public void unregisterGnssNmeaCallback(IGnssNmeaListener listener) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.unregisterGnssNmeaCallback(listener);
        return;
    }

    public void addGnssMeasurementsListener(GnssMeasurementRequest request, IGnssMeasurementsListener listener, String packageName, String attributionTag, String listenerId) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.addGnssMeasurementsListener(request, listener, packageName, attributionTag, listenerId);
        return;
    }

    public void removeGnssMeasurementsListener(IGnssMeasurementsListener listener) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.removeGnssMeasurementsListener(listener);
        return;
    }

    public void addGnssAntennaInfoListener(IGnssAntennaInfoListener listener, String packageName, String attributionTag, String listenerId) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.addGnssAntennaInfoListener(listener, packageName, attributionTag, listenerId);
        return;
    }

    public void removeGnssAntennaInfoListener(IGnssAntennaInfoListener listener) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.removeGnssAntennaInfoListener(listener);
        return;
    }

    public void addProviderRequestListener(IProviderRequestListener listener) {
        addProviderRequestListener_enforcePermission();
        Iterator<LocationProviderManager> r0 = this.mProviderManagers.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        LocationProviderManager manager = r0.next();
        if (manager.isVisibleToCaller() == false) goto L4;
        manager.addProviderRequestListener(listener);
        goto L4
    }

    public void removeProviderRequestListener(IProviderRequestListener listener) {
        Iterator<LocationProviderManager> r0 = this.mProviderManagers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationProviderManager manager = r0.next();
        manager.removeProviderRequestListener(listener);
        goto L4
    }

    public void injectGnssMeasurementCorrections(GnssMeasurementCorrections corrections) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.injectGnssMeasurementCorrections(corrections);
        return;
    }

    public GnssCapabilities getGnssCapabilities() {
        if (this.mGnssManagerService != null) goto L6;
        return new GnssCapabilities.Builder().build();
    L6:
        return this.mGnssManagerService.getGnssCapabilities();
    }

    public List<GnssAntennaInfo> getGnssAntennaInfos() {
        if (this.mGnssManagerService != null) goto L6;
        return null;
    L6:
        return this.mGnssManagerService.getGnssAntennaInfos();
    }

    public void addGnssNavigationMessageListener(IGnssNavigationMessageListener listener, String packageName, String attributionTag, String listenerId) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.addGnssNavigationMessageListener(listener, packageName, attributionTag, listenerId);
        return;
    }

    public void removeGnssNavigationMessageListener(IGnssNavigationMessageListener listener) {
        if (this.mGnssManagerService == null) goto L6;
        this.mGnssManagerService.removeGnssNavigationMessageListener(listener);
        return;
    }

    public void sendExtraCommand(String provider, String command, Bundle extras) {
        LocationPermissions.enforceCallingOrSelfLocationPermission(this.mContext, 1);
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", null);
        provider.getClass();
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L5;
        int r2 = Binder.getCallingUid();
        int r3 = Binder.getCallingPid();
        command.getClass();
        manager.sendExtraCommand(r2, r3, command, extras);
    L5:
        this.mInjector.getLocationUsageLogger().logLocationApiUsage(0, 5, provider);
        this.mInjector.getLocationUsageLogger().logLocationApiUsage(1, 5, provider);
    }

    public ProviderProperties getProviderProperties(String provider) {
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "provider \"" + provider + "\" does not exist");
        return manager.getProperties();
    L5:
        r1 = false;
        goto L6
    }

    public boolean isProviderPackage(String provider, String packageName, String attributionTag) {
        isProviderPackage_enforcePermission();
        Iterator<LocationProviderManager> r0 = this.mProviderManagers.iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        LocationProviderManager manager = r0.next();
        if (provider == null) goto L10;
        if (provider.equals(manager.getName()) == false) goto L4;
    L10:
        CallerIdentity identity = manager.getProviderIdentity();
        if (identity == null) goto L4;
        if (identity.getPackageName().equals(packageName) == false) goto L4;
        if (attributionTag == null) goto L18;
        if (Objects.equals(identity.getAttributionTag(), attributionTag) == false) goto L4;
        return true;
    L18:
        return true;
    L21:
        return false;
    }

    public List<String> getProviderPackages(String provider) {
        getProviderPackages_enforcePermission();
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L5;
        CallerIdentity identity = manager.getProviderIdentity();
        if (identity != null) goto L11;
        return Collections.emptyList();
    L11:
        return Collections.singletonList(identity.getPackageName());
    L5:
        return Collections.emptyList();
    }

    public void setExtraLocationControllerPackage(String packageName) {
        super.setExtraLocationControllerPackage_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mExtraLocationControllerPackage = packageName;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String getExtraLocationControllerPackage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mExtraLocationControllerPackage;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setExtraLocationControllerPackageEnabled(boolean enabled) {
        super.setExtraLocationControllerPackageEnabled_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mExtraLocationControllerPackageEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isExtraLocationControllerPackageEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mExtraLocationControllerPackageEnabled == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mExtraLocationControllerPackage == null) goto L11;
        r1 = true;
        goto L12
    }

    public void setLocationEnabledForUser(boolean enabled, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "setLocationEnabledForUser", null);
        this.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_SECURE_SETTINGS", null);
        LocationManager.invalidateLocalLocationEnabledCaches();
        this.mInjector.getSettingsHelper().setLocationEnabled(enabled, userId2);
    }

    public boolean isLocationEnabledForUser(int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "isLocationEnabledForUser", null);
        return this.mInjector.getSettingsHelper().isLocationEnabled(userId2);
    }

    public void setAdasGnssLocationEnabledForUser(final boolean enabled, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "setAdasGnssLocationEnabledForUser", null);
        LocationPermissions.enforceCallingOrSelfBypassPermission(this.mContext);
        this.mInjector.getLocationSettings().updateUserSettings(userId2, new LocationManagerService$$ExternalSyntheticLambda0(enabled));
    }

    private static /* synthetic */ LocationUserSettings lambda$setAdasGnssLocationEnabledForUser$6(boolean enabled, LocationUserSettings settings) {
        return settings.withAdasGnssLocationEnabled(enabled);
    }

    public boolean isAdasGnssLocationEnabledForUser(int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "isAdasGnssLocationEnabledForUser", null);
        return this.mInjector.getLocationSettings().getUserSettings(userId2).isAdasGnssLocationEnabled();
    }

    public boolean isProviderEnabledForUser(String provider, int userId) {
        return this.mLocalService.isProviderEnabledForUser(provider, userId);
    }

    public void setAutomotiveGnssSuspended(boolean suspended) {
        super.setAutomotiveGnssSuspended_enforcePermission();
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L9;
        if (this.mGnssManagerService == null) goto L10;
        this.mGnssManagerService.setAutomotiveGnssSuspended(suspended);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("setAutomotiveGnssSuspended only allowed on automotive devices");
    }

    public boolean isAutomotiveGnssSuspended() {
        super.isAutomotiveGnssSuspended_enforcePermission();
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L11;
        if (this.mGnssManagerService != null) goto L7;
        return false;
    L7:
        return this.mGnssManagerService.isAutomotiveGnssSuspended();
    L11:
        throw new IllegalStateException("isAutomotiveGnssSuspended only allowed on automotive devices");
    }

    public boolean isGeocodeAvailable() {
        if (this.mGeocodeProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void reverseGeocode(ReverseGeocodeRequest request, IGeocodeCallback callback) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, request.getCallingPackage(), request.getCallingAttributionTag());
        if (identity.getUid() != request.getCallingUid()) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1);
        if (this.mGeocodeProvider == null) goto L14;
        this.mGeocodeProvider.reverseGeocode(request, callback);
        return;
    L14:
        callback.onError(null);     // Catch: RemoteException -> L12
        return;
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void forwardGeocode(ForwardGeocodeRequest request, IGeocodeCallback callback) {
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, request.getCallingPackage(), request.getCallingAttributionTag());
        if (identity.getUid() != request.getCallingUid()) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1);
        if (this.mGeocodeProvider == null) goto L14;
        this.mGeocodeProvider.forwardGeocode(request, callback);
        return;
    L14:
        callback.onError(null);     // Catch: RemoteException -> L12
        return;
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void addTestProvider(String provider, ProviderProperties properties, List<String> extraAttributionTags, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinderUnsafe(packageName, attributionTag);
        if (this.mInjector.getAppOpsHelper().noteOp(58, identity) == true) goto L5;
        return;
    L5:
        LocationProviderManager manager = getOrAddLocationProviderManager(provider);
        manager.setMockProvider(new MockLocationProvider(properties, identity, new ArraySet(extraAttributionTags)));
    }

    public void removeTestProvider(String provider, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinderUnsafe(packageName, attributionTag);
        if (this.mInjector.getAppOpsHelper().noteOp(58, identity) == true) goto L5;
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        LocationProviderManager manager = getLocationProviderManager(provider);     // Catch: Throwable -> L11
        if (manager != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        manager.setMockProvider(null);     // Catch: Throwable -> L11
        if (manager.hasProvider() == true) goto L16;
        removeLocationProviderManager(manager);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void setTestProviderLocation(String provider, Location location, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinderUnsafe(packageName, attributionTag);
        if (this.mInjector.getAppOpsHelper().noteOp(58, identity) == true) goto L5;
        return;
    L5:
        Preconditions.checkArgument(location.isComplete(), "incomplete location object, missing timestamp or accuracy?");
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L10;
        manager.setMockProviderLocation(location);
        return;
    L10:
        throw new IllegalArgumentException("provider doesn't exist: " + provider);
    }

    public void setTestProviderEnabled(String provider, boolean enabled, String packageName, String attributionTag) {
        CallerIdentity identity = CallerIdentity.fromBinderUnsafe(packageName, attributionTag);
        if (this.mInjector.getAppOpsHelper().noteOp(58, identity) == true) goto L5;
        return;
    L5:
        LocationProviderManager manager = getLocationProviderManager(provider);
        if (manager == null) goto L10;
        manager.setMockProviderAllowed(enabled);
        return;
    L10:
        throw new IllegalArgumentException("provider doesn't exist: " + provider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
        return new LocationShellCommand(this.mContext, this).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        final IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        boolean needDecrypt = false;
        if (args.length <= 0) goto L17;
        LocationProviderManager manager = getLocationProviderManager(args[0]);
        if (manager == null) goto L12;
        ipw.println("Provider:");
        ipw.increaseIndent();
        manager.dump(fd, ipw, args);
        ipw.decreaseIndent();
        ipw.println("Event Log:");
        ipw.increaseIndent();
        LocationEventLog.EVENT_LOG.iterate(new LocationManagerService$$ExternalSyntheticLambda1(ipw), manager.getName());
        ipw.decreaseIndent();
        return;
    L12:
        if ("--gnssmetrics".equals(args[0]) == false) goto L17;
        if (this.mGnssManagerService == null) goto L67;
        this.mGnssManagerService.dump(fd, ipw, args);
        return;
    L67:
        return;
    L17:
        ipw.println("Location Manager State:");
        ipw.increaseIndent();
        ipw.println("User Info:");
        ipw.increaseIndent();
        this.mInjector.getUserInfoHelper().dump(fd, ipw, args);
        ipw.decreaseIndent();
        ipw.println("Location Settings:");
        ipw.increaseIndent();
        this.mInjector.getSettingsHelper().dump(fd, ipw, args);
        this.mInjector.getLocationSettings().dump(fd, ipw, args);
        ipw.decreaseIndent();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L20:
        if (this.mExtraLocationControllerPackage == null) goto L28;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L24
        r3.append("Location Controller Extra Package: ");     // Catch: Throwable -> L24
        r3.append(this.mExtraLocationControllerPackage);     // Catch: Throwable -> L24
        if (this.mExtraLocationControllerPackageEnabled == false) goto L26;
        String r4 = " [enabled]";
    L27:
        r3.append(r4);     // Catch: Throwable -> L24
        ipw.println(r3.toString());     // Catch: Throwable -> L24
        goto L28
    L26:
        r4 = " [disabled]";
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L24
        ipw.println("Location Providers:");
        ipw.increaseIndent();
        Iterator<LocationProviderManager> r2 = this.mProviderManagers.iterator();
    L31:
        if (r2.hasNext() == false) goto L33;
        r2.next().dump(fd, ipw, args);
        goto L31
    L33:
        ipw.decreaseIndent();
        ipw.println("Historical Aggregate Location Provider Data:");
        ipw.increaseIndent();
        ArrayMap<String, ArrayMap<CallerIdentity, LocationEventLog.AggregateStats>> aggregateStats = LocationEventLog.EVENT_LOG.copyAggregateStats();
        int i = 0;
    L35:
        if (i >= aggregateStats.size()) goto L41;
        ipw.print(aggregateStats.keyAt(i));
        ipw.println(":");
        ipw.increaseIndent();
        ArrayMap<CallerIdentity, LocationEventLog.AggregateStats> providerStats = aggregateStats.valueAt(i);
        int j = 0;
    L38:
        if (j >= providerStats.size()) goto L40;
        ipw.print(providerStats.keyAt(j));
        ipw.print(": ");
        providerStats.valueAt(j).updateTotals();
        ipw.println(providerStats.valueAt(j));
        j = j + 1;
        goto L38
    L40:
        ipw.decreaseIndent();
        i = i + 1;
        goto L35
    L41:
        ipw.decreaseIndent();
        ipw.println("Historical Aggregate Gnss Measurement Provider Data:");
        ipw.increaseIndent();
        ArrayMap<CallerIdentity, LocationEventLog.GnssMeasurementAggregateStats> gnssAggregateStats = LocationEventLog.EVENT_LOG.copyGnssMeasurementAggregateStats();
        int i2 = 0;
    L43:
        if (i2 >= gnssAggregateStats.size()) goto L45;
        ipw.print(gnssAggregateStats.keyAt(i2));
        ipw.print(": ");
        gnssAggregateStats.valueAt(i2).updateTotals();
        ipw.println(gnssAggregateStats.valueAt(i2));
        i2 = i2 + 1;
        goto L43
    L45:
        ipw.decreaseIndent();
        if (this.mGnssManagerService == null) goto L48;
        ipw.println("GNSS Manager:");
        ipw.increaseIndent();
        this.mGnssManagerService.dump(fd, ipw, args);
        ipw.decreaseIndent();
    L48:
        ipw.println("Geofence Manager:");
        ipw.increaseIndent();
        this.mGeofenceManager.dump(fd, ipw, args);
        ipw.decreaseIndent();
        ipw.println("Event Log:");
        ipw.increaseIndent();
        LocationEventLog.EVENT_LOG.iterate(new LocationManagerService$$ExternalSyntheticLambda1(ipw));
        ipw.decreaseIndent();
        if (args.length <= 0) goto L53;
        if ("--NoFilesDump".equalsIgnoreCase(args[0]) == false) goto L53;
        return;
    L53:
        if (args.length > 0) goto L55;
    L57:
        StarLocation.getInstance();
        ipw.println("Current NMEA Info:");
        ipw.increaseIndent();
        LocationLogsRecorder.getInstance().dumpFileContent(LocationLogsRecorder.KEY_FILE_NMEA, needDecrypt, ipw);
        ipw.decreaseIndent();
        ipw.println("\nCurrent Location Info:");
        ipw.increaseIndent();
        LocationLogsRecorder.getInstance().dumpFileContent(LocationLogsRecorder.KEY_FILE_LOCATION, needDecrypt, ipw);
        ipw.decreaseIndent();
        ipw.println("Current Gnss Info:");
        ipw.increaseIndent();
        LocationLogsRecorder.getInstance().dumpFileContent(LocationLogsRecorder.KEY_FILE_GNSS, needDecrypt, ipw);
        ipw.decreaseIndent();
        return;
    L55:
        if ("--NeedDecrypt".equalsIgnoreCase(args[0]) == false) goto L57;
        needDecrypt = true;
        goto L57
    }

    @Override // com.android.server.location.provider.LocationProviderManager.StateChangedListener
    public void onStateChanged(String provider, AbstractLocationProvider.State oldState, AbstractLocationProvider.State newState) {
        if (Objects.equals(oldState.identity, newState.identity) == true) goto L6;
        refreshAppOpsRestrictions(-1);
    L6:
        if (oldState.extraAttributionTags.equals(newState.extraAttributionTags) == true) goto L8;
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        final LocationManagerInternal.LocationPackageTagsListener listener = this.mLocationTagsChangedListener;     // Catch: Throwable -> L16
        if (listener != null) goto L14;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L14:
        if (oldState.identity == null) goto L18;
        final int oldUid = oldState.identity.getUid();     // Catch: Throwable -> L16
    L20:
        if (newState.identity == null) goto L22;
        final int newUid = newState.identity.getUid();     // Catch: Throwable -> L16
    L23:
        if (oldUid == (-1)) goto L25;
        final PackageTagsList tags = calculateAppOpsLocationSourceTags(oldUid);     // Catch: Throwable -> L16
        FgThread.getHandler().post(new LocationManagerService$$ExternalSyntheticLambda3(listener, oldUid, tags));     // Catch: Throwable -> L16
    L25:
        if (newUid == (-1)) goto L28;
        if (newUid == oldUid) goto L28;
        final PackageTagsList tags2 = calculateAppOpsLocationSourceTags(newUid);     // Catch: Throwable -> L16
        FgThread.getHandler().post(new LocationManagerService$$ExternalSyntheticLambda4(listener, newUid, tags2));     // Catch: Throwable -> L16
        goto L28
    L22:
        newUid = -1;
        goto L23
    L18:
        oldUid = -1;
    L16:
        th = move-exception;
        throw th;
    L8:
        if (Objects.equals(oldState.identity, newState.identity) == false) goto L9;
    }

    private static /* synthetic */ void lambda$onStateChanged$7(LocationManagerInternal.LocationPackageTagsListener listener, int oldUid, PackageTagsList tags) {
        listener.onLocationPackageTagsChanged(oldUid, tags);
    }

    private static /* synthetic */ void lambda$onStateChanged$8(LocationManagerInternal.LocationPackageTagsListener listener, int newUid, PackageTagsList tags) {
        listener.onLocationPackageTagsChanged(newUid, tags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshAppOpsRestrictions(int userId) {
        if (userId != (-1)) goto L10;
        int[] runningUserIds = this.mInjector.getUserInfoHelper().getRunningUserIds();
        int i = 0;
    L6:
        if (i >= runningUserIds.length) goto L9;
        refreshAppOpsRestrictions(runningUserIds[i]);
        i = i + 1;
        goto L6
    L9:
        return;
    L10:
        if (userId < 0) goto L12;
        boolean r0 = true;
    L13:
        Preconditions.checkArgument(r0);
        boolean enabled = this.mInjector.getSettingsHelper().isLocationEnabled(userId);
        if (enabled == true) goto L23;
        PackageTagsList.Builder builder = new PackageTagsList.Builder();
        Iterator<LocationProviderManager> r3 = this.mProviderManagers.iterator();
    L17:
        if (r3.hasNext() == false) goto L22;
        LocationProviderManager manager = r3.next();
        CallerIdentity identity = manager.getProviderIdentity();
        if (identity == null) goto L17;
        builder.add(identity.getPackageName(), identity.getAttributionTag());
        goto L17
    L22:
        builder.add(this.mInjector.getSettingsHelper().getIgnoreSettingsAllowlist());
        builder.add(this.mInjector.getSettingsHelper().getAdasAllowlist());
        PackageTagsList allowedPackages = builder.build();
        PackageTagsList allowedPackages2 = allowedPackages;
    L24:
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOpsManager.getClass();
        appOpsManager.setUserRestrictionForUser(0, !enabled, this, allowedPackages2, userId);
        appOpsManager.setUserRestrictionForUser(1, !enabled, this, allowedPackages2, userId);
        return;
    L23:
        allowedPackages2 = null;
        goto L24
    L12:
        r0 = false;
        goto L13
    }

    PackageTagsList calculateAppOpsLocationSourceTags(int uid) {
        PackageTagsList.Builder builder = new PackageTagsList.Builder();
        Iterator<LocationProviderManager> r1 = this.mProviderManagers.iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        LocationProviderManager manager = r1.next();
        AbstractLocationProvider.State managerState = manager.getState();
        if (managerState.identity == null) goto L4;
        if (managerState.identity.getUid() != uid) goto L4;
        builder.add(managerState.identity.getPackageName(), managerState.extraAttributionTags);
        if (managerState.extraAttributionTags.isEmpty() == true) goto L17;
        if (managerState.identity.getAttributionTag() != null) goto L17;
        Log.e(TAG, manager.getName() + " provider has specified a null attribution tag and a non-empty set of extra attribution tags - dropping the null attribution tag");
    L17:
        builder.add(managerState.identity.getPackageName(), managerState.identity.getAttributionTag());
        goto L4
    L20:
        return builder.build();
    }

    public synchronized void enableGpsVerbosLogs(boolean enable) {
        monitor-enter(this);
        Log.d(TAG, "set gps log: " + enable);     // Catch: Throwable -> L6
        D = enable;     // Catch: Throwable -> L6
        GnssLocationProvider.enableGnssLocationProviderLogs(enable);     // Catch: Throwable -> L6
        StarLocation.getInstance().enableDebug(enable);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
