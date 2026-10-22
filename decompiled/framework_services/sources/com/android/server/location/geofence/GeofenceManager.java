package com.android.server.location.geofence;

import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Geofence;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.util.ArraySet;
import com.android.internal.listeners.ListenerExecutor;
import com.android.server.FgThread;
import com.android.server.PendingIntentUtils;
import com.android.server.location.LocationPermissions;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationPermissionsHelper;
import com.android.server.location.injector.LocationUsageLogger;
import com.android.server.location.injector.SettingsHelper;
import com.android.server.location.injector.UserInfoHelper;
import com.android.server.location.listeners.ListenerMultiplexer;
import com.android.server.location.listeners.ListenerRegistration;
import com.android.server.location.listeners.PendingIntentListenerRegistration;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class GeofenceManager extends ListenerMultiplexer<GeofenceKey, PendingIntent, GeofenceRegistration, LocationRequest> implements LocationListener {
    private static final String ATTRIBUTION_TAG = "GeofencingService";
    private static final long MAX_LOCATION_AGE_MS = 300000;
    private static final long MAX_LOCATION_INTERVAL_MS = 7200000;
    private static final int MAX_SPEED_M_S = 100;
    private static final String TAG = "GeofenceManager";
    private static final long WAKELOCK_TIMEOUT_MS = 30000;
    protected final Context mContext;
    private Location mLastLocation;
    private final SettingsHelper.UserSettingChangedListener mLocationEnabledChangedListener;
    private LocationManager mLocationManager;
    private final SettingsHelper.UserSettingChangedListener mLocationPackageBlacklistChangedListener;
    protected final LocationPermissionsHelper mLocationPermissionsHelper;
    private final LocationPermissionsHelper.LocationPermissionsListener mLocationPermissionsListener;
    protected final LocationUsageLogger mLocationUsageLogger;
    final Object mLock;
    protected final SettingsHelper mSettingsHelper;
    private final UserInfoHelper.UserListener mUserChangedListener;
    protected final UserInfoHelper mUserInfoHelper;

    static class GeofenceKey {
        private final Geofence mGeofence;
        private final PendingIntent mPendingIntent;

        GeofenceKey(PendingIntent pendingIntent, Geofence geofence) {
            pendingIntent.getClass();
            this.mPendingIntent = pendingIntent;
            geofence.getClass();
            this.mGeofence = geofence;
        }

        public PendingIntent getPendingIntent() {
            return this.mPendingIntent;
        }

        public boolean equals(Object o) {
            if ((o instanceof GeofenceKey) == false) goto L10;
            GeofenceKey that = (GeofenceKey) o;
            if (this.mPendingIntent.equals(that.mPendingIntent) == true) goto L7;
            return false;
        L7:
            if (this.mGeofence.equals(that.mGeofence) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return this.mPendingIntent.hashCode();
        }
    }

    protected class GeofenceRegistration extends PendingIntentListenerRegistration<GeofenceKey, PendingIntent> {
        private static final int STATE_INSIDE = 1;
        private static final int STATE_OUTSIDE = 2;
        private static final int STATE_UNKNOWN = 0;
        private Location mCachedLocation;
        private float mCachedLocationDistanceM;
        private final Location mCenter;
        private final Geofence mGeofence;
        private int mGeofenceState;
        private final CallerIdentity mIdentity;
        private boolean mPermitted;
        private final PowerManager.WakeLock mWakeLock;
        final /* synthetic */ GeofenceManager this$0;

        public static /* synthetic */ void $r8$lambda$7mMBbn2ecRaa6NpdKG_IbZdRjss(GeofenceRegistration r0, PendingIntent r1, Intent r2, int r3, String r4, Bundle r5) {
            r0.lambda$sendIntent$2(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$I1d1HHgL1PvVk1ytwCQk8H5rNVg(GeofenceRegistration r0, PendingIntent r1) {
            r0.lambda$onLocationChanged$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$rO9HD1t_XfQ0Ykyc99zfRGtgOZs(GeofenceRegistration r0, PendingIntent r1) {
            r0.lambda$onLocationChanged$1(r1);
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected /* bridge */ /* synthetic */ ListenerMultiplexer getOwner() {
            return getOwner();
        }

        @Override // com.android.server.location.listeners.PendingIntentListenerRegistration
        protected /* bridge */ /* synthetic */ PendingIntent getPendingIntentFromKey(GeofenceKey r1) {
            return getPendingIntentFromKey2(r1);
        }

        GeofenceRegistration(GeofenceManager this$0, Geofence geofence, CallerIdentity identity, PendingIntent pendingIntent) {
            this.this$0 = this$0;
            super(pendingIntent);
            this.mGeofence = geofence;
            this.mIdentity = identity;
            this.mCenter = new Location("");
            this.mCenter.setLatitude(geofence.getLatitude());
            this.mCenter.setLongitude(geofence.getLongitude());
            PowerManager r0 = (PowerManager) this$0.mContext.getSystemService(PowerManager.class);
            r0.getClass();
            this.mWakeLock = r0.newWakeLock(1, "GeofenceManager:" + identity.getPackageName());
            this.mWakeLock.setReferenceCounted(true);
            this.mWakeLock.setWorkSource(identity.addToWorkSource(null));
        }

        public Geofence getGeofence() {
            return this.mGeofence;
        }

        public CallerIdentity getIdentity() {
            return this.mIdentity;
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String getTag() {
            return GeofenceManager.TAG;
        }

        /* JADX INFO: renamed from: getPendingIntentFromKey, reason: avoid collision after fix types in other method */
        protected PendingIntent getPendingIntentFromKey2(GeofenceKey geofenceKey) {
            return geofenceKey.getPendingIntent();
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected GeofenceManager getOwner() {
            return this.this$0;
        }

        @Override // com.android.server.location.listeners.PendingIntentListenerRegistration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            this.mGeofenceState = 0;
            this.mPermitted = this.this$0.mLocationPermissionsHelper.hasLocationPermissions(2, this.mIdentity);
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onActive() {
            Location location = this.this$0.getLastLocation();
            if (location == null) goto L6;
            executeOperation(onLocationChanged(location));
            return;
        }

        boolean isPermitted() {
            return this.mPermitted;
        }

        boolean onLocationPermissionsChanged(String packageName) {
            if (packageName == null) goto L9;
            if (this.mIdentity.getPackageName().equals(packageName) == true) goto L9;
            return false;
        L9:
            return onLocationPermissionsChanged();
        }

        boolean onLocationPermissionsChanged(int uid) {
            if (this.mIdentity.getUid() == uid) goto L5;
            return false;
        L5:
            return onLocationPermissionsChanged();
        }

        private boolean onLocationPermissionsChanged() {
            boolean permitted = this.this$0.mLocationPermissionsHelper.hasLocationPermissions(2, this.mIdentity);
            if (permitted == this.mPermitted) goto L6;
            this.mPermitted = permitted;
            return true;
        L6:
            return false;
        }

        double getDistanceToBoundary(Location location) {
            if (location.equals(this.mCachedLocation) == true) goto L6;
            this.mCachedLocation = location;
            this.mCachedLocationDistanceM = this.mCenter.distanceTo(this.mCachedLocation);
        L6:
            return Math.abs(this.mGeofence.getRadius() - this.mCachedLocationDistanceM);
        }

        ListenerExecutor.ListenerOperation<PendingIntent> onLocationChanged(Location location) {
            if (this.mGeofence.isExpired() == false) goto L6;
            remove();
            return null;
        L6:
            this.mCachedLocation = location;
            this.mCachedLocationDistanceM = this.mCenter.distanceTo(this.mCachedLocation);
            int oldState = this.mGeofenceState;
            float radius = Math.max(this.mGeofence.getRadius(), location.getAccuracy());
            if (this.mCachedLocationDistanceM > radius) goto L12;
            this.mGeofenceState = 1;
            if (oldState != 1) goto L11;
        L16:
            return null;
        L11:
            return new GeofenceManager$GeofenceRegistration$$ExternalSyntheticLambda1(this);
        L12:
            this.mGeofenceState = 2;
            if (oldState != 1) goto L16;
            return new GeofenceManager$GeofenceRegistration$$ExternalSyntheticLambda2(this);
        }

        private /* synthetic */ void lambda$onLocationChanged$0(PendingIntent pendingIntent) throws Exception {
            sendIntent(pendingIntent, true);
        }

        private /* synthetic */ void lambda$onLocationChanged$1(PendingIntent pendingIntent) throws Exception {
            sendIntent(pendingIntent, false);
        }

        private void sendIntent(PendingIntent pendingIntent, boolean entering) {
            Intent intent = new Intent().putExtra("entering", entering);
            this.mWakeLock.acquire(30000);
            PendingIntent pendingIntent2 = pendingIntent;
            pendingIntent2.send(this.this$0.mContext, 0, intent, new GeofenceManager$GeofenceRegistration$$ExternalSyntheticLambda0(this), null, null, PendingIntentUtils.createDontSendToRestrictedAppsBundle(null));     // Catch: PendingIntent.CanceledException -> L7
            return;
        L11:
            this.mWakeLock.release();
            GeofenceManager.access$000(this.this$0, new GeofenceKey(pendingIntent2, this.mGeofence), this);
            return;
        L10:
            pendingIntent2 = pendingIntent;
            goto L11
        }

        private /* synthetic */ void lambda$sendIntent$2(PendingIntent pI, Intent i, int rC, String rD, Bundle rE) {
            this.mWakeLock.release();
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.mIdentity);
            ArraySet<String> flags = new ArraySet(1);
            if (this.mPermitted == true) goto L6;
            flags.add("na");
        L6:
            if (flags.isEmpty() == true) goto L8;
            builder.append(" ");
            builder.append(flags);
        L8:
            builder.append(" ");
            builder.append(this.mGeofence);
            return builder.toString();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-J0nsuo1tUolwx2C_cOjUqlkAqg, reason: not valid java name */
    public static /* synthetic */ boolean m5220$r8$lambda$J0nsuo1tUolwx2C_cOjUqlkAqg(int r0, GeofenceRegistration r1) {
        return lambda$onLocationEnabledChanged$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$6B2TnnJ2FfvtKiOxRuTgN2A6X3I(int r0, GeofenceRegistration r1) {
        return lambda$onUserChanged$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$HGcZosAXD2bXULHzGU5VaOeZGlg(String r0, GeofenceRegistration r1) {
        return lambda$onLocationPermissionsChanged$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TU3whMVF-lZ5HtrUkGLYo5Y-tJg, reason: not valid java name */
    public static /* synthetic */ boolean m5221$r8$lambda$TU3whMVFlZ5HtrUkGLYo5YtJg(PendingIntent r0, GeofenceKey r1) {
        return lambda$removeGeofence$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$eLb-cdUKD6a-o71OACxqdGAlnZk, reason: not valid java name */
    public static /* synthetic */ boolean m5222$r8$lambda$eLbcdUKD6ao71OACxqdGAlnZk(int r0, GeofenceRegistration r1) {
        return lambda$onLocationPermissionsChanged$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$szI4FFLvmc6gmYTYGQ-8D9ebucY, reason: not valid java name */
    public static /* synthetic */ ListenerExecutor.ListenerOperation m5223$r8$lambda$szI4FFLvmc6gmYTYGQ8D9ebucY(Location r0, GeofenceRegistration r1) {
        return lambda$onLocationChanged$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$wu2d6VhxLk3RBfv5LmsUosV1O2A(int r0, GeofenceRegistration r1) {
        return lambda$onLocationPackageBlacklistChanged$4(r0, r1);
    }

    static /* synthetic */ void access$000(GeofenceManager x0, Object x1, ListenerRegistration x2) {
        x0.removeRegistration(x1, x2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean isActive(ListenerRegistration r1) {
        return isActive((GeofenceRegistration) r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ LocationRequest mergeRegistrations(Collection r1) {
        return mergeRegistrations(r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationAdded(GeofenceKey r1, ListenerRegistration r2) {
        onRegistrationAdded(r1, (GeofenceRegistration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationRemoved(GeofenceKey r1, ListenerRegistration r2) {
        onRegistrationRemoved(r1, (GeofenceRegistration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(LocationRequest r1, Collection r2) {
        return registerWithService2(r1, r2);
    }

    public GeofenceManager(Context context, Injector injector) {
        this.mLock = new Object();
        this.mUserChangedListener = new GeofenceManager$$ExternalSyntheticLambda3(this);
        this.mLocationEnabledChangedListener = new GeofenceManager$$ExternalSyntheticLambda4(this);
        this.mLocationPackageBlacklistChangedListener = new GeofenceManager$$ExternalSyntheticLambda5(this);
        this.mLocationPermissionsListener = new AnonymousClass1(this);
        this.mContext = context.createAttributionContext(ATTRIBUTION_TAG);
        this.mUserInfoHelper = injector.getUserInfoHelper();
        this.mSettingsHelper = injector.getSettingsHelper();
        this.mLocationPermissionsHelper = injector.getLocationPermissionsHelper();
        this.mLocationUsageLogger = injector.getLocationUsageLogger();
    }

    private LocationManager getLocationManager() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationManager != null) goto L9;
        LocationManager r1 = (LocationManager) this.mContext.getSystemService(LocationManager.class);     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        this.mLocationManager = r1;     // Catch: Throwable -> L7
    L9:
        LocationManager r2 = this.mLocationManager;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    }

    public void addGeofence(Geofence geofence, PendingIntent pendingIntent, String packageName, String attributionTag) {
        LocationPermissions.enforceCallingOrSelfLocationPermission(this.mContext, 2);
        CallerIdentity identity = CallerIdentity.fromBinder(this.mContext, packageName, attributionTag, AppOpsManager.toReceiverId(pendingIntent));
        long ident = Binder.clearCallingIdentity();
        putRegistration(new GeofenceKey(pendingIntent, geofence), new GeofenceRegistration(this, geofence, identity, pendingIntent));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void removeGeofence(final PendingIntent pendingIntent) {
        long identity = Binder.clearCallingIdentity();
        removeRegistrationIf(new GeofenceManager$$ExternalSyntheticLambda7(pendingIntent));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeGeofence$0(PendingIntent pendingIntent, GeofenceKey key) {
        return key.getPendingIntent().equals(pendingIntent);
    }

    protected boolean isActive(GeofenceRegistration registration) {
        if (registration.isPermitted() == true) goto L5;
    L7:
        return false;
    L5:
        if (isActive(registration.getIdentity()) == false) goto L7;
        return true;
    }

    private boolean isActive(CallerIdentity identity) {
        if (identity.isSystemServer() == false) goto L8;
        if (this.mSettingsHelper.isLocationEnabled(this.mUserInfoHelper.getCurrentUserId()) == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (this.mSettingsHelper.isLocationEnabled(identity.getUserId()) == true) goto L11;
        return false;
    L11:
        if (this.mUserInfoHelper.isVisibleUserId(identity.getUserId()) == true) goto L14;
        return false;
    L14:
        if (this.mSettingsHelper.isLocationPackageBlacklisted(identity.getUserId(), identity.getPackageName()) == false) goto L18;
        return false;
    L18:
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onRegister() {
        this.mUserInfoHelper.addListener(this.mUserChangedListener);
        this.mSettingsHelper.addOnLocationEnabledChangedListener(this.mLocationEnabledChangedListener);
        this.mSettingsHelper.addOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mLocationPermissionsHelper.addListener(this.mLocationPermissionsListener);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onUnregister() {
        this.mUserInfoHelper.removeListener(this.mUserChangedListener);
        this.mSettingsHelper.removeOnLocationEnabledChangedListener(this.mLocationEnabledChangedListener);
        this.mSettingsHelper.removeOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mLocationPermissionsHelper.removeListener(this.mLocationPermissionsListener);
    }

    protected void onRegistrationAdded(GeofenceKey key, GeofenceRegistration registration) {
        this.mLocationUsageLogger.logLocationApiUsage(1, 4, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, false, true, registration.getGeofence(), true);
    }

    protected void onRegistrationRemoved(GeofenceKey key, GeofenceRegistration registration) {
        this.mLocationUsageLogger.logLocationApiUsage(1, 4, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), null, null, false, true, registration.getGeofence(), true);
    }

    /* JADX INFO: renamed from: registerWithService, reason: avoid collision after fix types in other method */
    protected boolean registerWithService2(LocationRequest locationRequest, Collection<GeofenceRegistration> registrations) {
        getLocationManager().requestLocationUpdates("fused", locationRequest, FgThread.getExecutor(), this);
        return true;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        getLocationManager().removeUpdates(this);     // Catch: Throwable -> L7
        this.mLastLocation = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected LocationRequest mergeRegistrations(Collection<GeofenceRegistration> registrations) {
        Location location = getLastLocation();
        long realtimeMs = SystemClock.elapsedRealtime();
        WorkSource workSource = null;
        double minFenceDistanceM = Double.MAX_VALUE;
        Iterator<GeofenceRegistration> r6 = registrations.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        GeofenceRegistration registration = r6.next();
        if (registration.getGeofence().isExpired(realtimeMs) == true) goto L4;
        workSource = registration.getIdentity().addToWorkSource(workSource);
        if (location == null) goto L4;
        double fenceDistanceM = registration.getDistanceToBoundary(location);
        if (fenceDistanceM >= minFenceDistanceM) goto L4;
        minFenceDistanceM = fenceDistanceM;
        goto L4
    L15:
        if (Double.compare(minFenceDistanceM, Double.MAX_VALUE) >= 0) goto L17;
        long intervalMs = (long) Math.min(7200000.0d, Math.max(this.mSettingsHelper.getBackgroundThrottleProximityAlertIntervalMs(), (1000.0d * minFenceDistanceM) / 100.0d));
    L19:
        return new LocationRequest.Builder(intervalMs).setMinUpdateIntervalMillis(0).setHiddenFromAppOps(true).setWorkSource(workSource).build();
    L17:
        intervalMs = this.mSettingsHelper.getBackgroundThrottleProximityAlertIntervalMs();
        goto L19
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(final Location location) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastLocation = location;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        deliverToListeners(new GeofenceManager$$ExternalSyntheticLambda0(location));
        updateService();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ ListenerExecutor.ListenerOperation lambda$onLocationChanged$1(Location location, GeofenceRegistration registration) {
        return registration.onLocationChanged(location);
    }

    Location getLastLocation() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Location location = this.mLastLocation;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (location != null) goto L8;
        location = getLocationManager().getLastLocation();
    L8:
        if (location != null) goto L10;
        return location;
    L10:
        if (location.getElapsedRealtimeAgeMillis() <= 300000) goto L19;
        return null;
    L19:
        return location;
    L13:
        th = move-exception;
        throw th;
    }

    void onUserChanged(final int userId, int change) {
        if (change != 1) goto L5;
    L6:
        updateRegistrations(new GeofenceManager$$ExternalSyntheticLambda8(userId));
        return;
    L5:
        if (change == 4) goto L6;
    }

    private static /* synthetic */ boolean lambda$onUserChanged$2(int userId, GeofenceRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$onLocationEnabledChanged$3(int userId, GeofenceRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    void onLocationEnabledChanged(final int userId) {
        updateRegistrations(new GeofenceManager$$ExternalSyntheticLambda1(userId));
    }

    private static /* synthetic */ boolean lambda$onLocationPackageBlacklistChanged$4(int userId, GeofenceRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    void onLocationPackageBlacklistChanged(final int userId) {
        updateRegistrations(new GeofenceManager$$ExternalSyntheticLambda6(userId));
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$5(String packageName, GeofenceRegistration registration) {
        return registration.onLocationPermissionsChanged(packageName);
    }

    void onLocationPermissionsChanged(final String packageName) {
        updateRegistrations(new GeofenceManager$$ExternalSyntheticLambda9(packageName));
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$6(int uid, GeofenceRegistration registration) {
        return registration.onLocationPermissionsChanged(uid);
    }

    void onLocationPermissionsChanged(final int uid) {
        updateRegistrations(new GeofenceManager$$ExternalSyntheticLambda2(uid));
    }
}
