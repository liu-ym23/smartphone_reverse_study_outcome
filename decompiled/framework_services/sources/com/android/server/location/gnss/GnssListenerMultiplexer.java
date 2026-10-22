package com.android.server.location.gnss;

import android.location.LocationManagerInternal;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.util.ArraySet;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.location.injector.AppForegroundHelper;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationPermissionsHelper;
import com.android.server.location.injector.PackageResetHelper;
import com.android.server.location.injector.SettingsHelper;
import com.android.server.location.injector.UserInfoHelper;
import com.android.server.location.listeners.BinderListenerRegistration;
import com.android.server.location.listeners.ListenerMultiplexer;
import com.android.server.location.listeners.ListenerRegistration;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GnssListenerMultiplexer<TRequest, TListener extends IInterface, TMergedRegistration> extends ListenerMultiplexer<IBinder, TListener, GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration, TMergedRegistration> {
    private final AppForegroundHelper.AppForegroundListener mAppForegroundChangedListener;
    protected final AppForegroundHelper mAppForegroundHelper;
    private final SettingsHelper.GlobalSettingChangedListener mBackgroundThrottlePackageWhitelistChangedListener;
    protected final LocationManagerInternal mLocationManagerInternal;
    private final SettingsHelper.UserSettingChangedListener mLocationPackageBlacklistChangedListener;
    protected final LocationPermissionsHelper mLocationPermissionsHelper;
    private final LocationPermissionsHelper.LocationPermissionsListener mLocationPermissionsListener;
    private final PackageResetHelper mPackageResetHelper;
    private final PackageResetHelper.Responder mPackageResetResponder;
    private final LocationManagerInternal.ProviderEnabledListener mProviderEnabledChangedListener;
    protected final SettingsHelper mSettingsHelper;
    private final UserInfoHelper.UserListener mUserChangedListener;
    protected final UserInfoHelper mUserInfoHelper;

    protected class GnssListenerRegistration extends BinderListenerRegistration<IBinder, TListener> {
        private boolean mForeground;
        private final CallerIdentity mIdentity;
        private boolean mPermitted;
        private final TRequest mRequest;
        final /* synthetic */ GnssListenerMultiplexer this$0;

        @Override // com.android.server.location.listeners.BinderListenerRegistration
        protected /* bridge */ /* synthetic */ IBinder getBinderFromKey(IBinder r1) {
            return getBinderFromKey2(r1);
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected /* bridge */ /* synthetic */ ListenerMultiplexer getOwner() {
            return getOwner();
        }

        protected GnssListenerRegistration(GnssListenerMultiplexer this$0, TRequest request, CallerIdentity identity, TListener listener) {
            this.this$0 = this$0;
            if (identity.isMyProcess() == false) goto L5;
            Executor r0 = FgThread.getExecutor();
        L6:
            super(r0, listener);
            this.mRequest = request;
            this.mIdentity = identity;
            return;
        L5:
            r0 = ConcurrentUtils.DIRECT_EXECUTOR;
            goto L6
        }

        public final TRequest getRequest() {
            return this.mRequest;
        }

        public final CallerIdentity getIdentity() {
            return this.mIdentity;
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String getTag() {
            return GnssManagerService.TAG;
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration> getOwner() {
            return this.this$0;
        }

        /* JADX INFO: renamed from: getBinderFromKey, reason: avoid collision after fix types in other method */
        protected IBinder getBinderFromKey2(IBinder key) {
            return key;
        }

        public boolean isForeground() {
            return this.mForeground;
        }

        boolean isPermitted() {
            return this.mPermitted;
        }

        @Override // com.android.server.location.listeners.BinderListenerRegistration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            this.mPermitted = this.this$0.mLocationPermissionsHelper.hasLocationPermissions(2, this.mIdentity);
            this.mForeground = this.this$0.mAppForegroundHelper.isAppForeground(this.mIdentity.getUid());
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

        boolean onForegroundChanged(int uid, boolean foreground) {
            if (this.mIdentity.getUid() == uid) goto L5;
            return false;
        L5:
            if (foreground == this.mForeground) goto L10;
            this.mForeground = foreground;
            return true;
        L10:
            return false;
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.mIdentity);
            ArraySet<String> flags = new ArraySet(2);
            if (this.mForeground == true) goto L6;
            flags.add("bg");
        L6:
            if (this.mPermitted == true) goto L9;
            flags.add("na");
        L9:
            if (flags.isEmpty() == true) goto L12;
            builder.append(" ");
            builder.append(flags);
        L12:
            if (this.mRequest == null) goto L15;
            builder.append(" ");
            builder.append(this.mRequest);
        L15:
            return builder.toString();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$DP_3o6449h75hpTu5h4gQl-566c, reason: not valid java name */
    public static /* synthetic */ void m5227$r8$lambda$DP_3o6449h75hpTu5h4gQl566c(GnssListenerMultiplexer r0, String r1, int r2, boolean r3) {
        r0.onProviderEnabledChanged(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$F7qMCxA9BEm9xINNk_FaWcBbaYQ(GnssListenerMultiplexer r0) {
        r0.onBackgroundThrottlePackageAllowlistChanged();
    }

    public static /* synthetic */ boolean $r8$lambda$G2kqDLkfuxQMtoPsbj2WpYf8X5s(int r0, boolean r1, GnssListenerRegistration r2) {
        return lambda$onAppForegroundChanged$6(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$GFjaYMHIY9yPjfN0Ny6zx6UyQyc(int r0, GnssListenerRegistration r1) {
        return lambda$onLocationPackageDenylistChanged$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ir6o9zTQ-nThO5Rmk2iB9poSwfg, reason: not valid java name */
    public static /* synthetic */ boolean m5228$r8$lambda$Ir6o9zTQnThO5Rmk2iB9poSwfg(String r0, GnssListenerRegistration r1) {
        return lambda$isResetableForPackage$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ObDPTmgim9qTVfEa38gtD_Ho54g(GnssListenerMultiplexer r0, int r1) {
        r0.onLocationPackageDenylistChanged(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$Q8P1yRWm864Gac_NXSvr9Yme4X8(int r0, GnssListenerRegistration r1) {
        return lambda$onLocationPermissionsChanged$5(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$QTZVBBfkPUk5LF3CN6mQN_Qyt4U(GnssListenerRegistration r0) {
        return lambda$onBackgroundThrottlePackageAllowlistChanged$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$X_Bw_3-u1bwfD5_wESIzJ_HaiTU, reason: not valid java name */
    public static /* synthetic */ void m5229$r8$lambda$X_Bw_3u1bwfD5_wESIzJ_HaiTU(GnssListenerMultiplexer r0, int r1, int r2) {
        r0.onUserChanged(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$_Gfvn5VW9-dlsJfSAPdr0oFIo4s, reason: not valid java name */
    public static /* synthetic */ void m5230$r8$lambda$_Gfvn5VW9dlsJfSAPdr0oFIo4s(GnssListenerMultiplexer r0, int r1, boolean r2) {
        r0.onAppForegroundChanged(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$gG9Lmf6uGtiL-AFh46_ObPaJ6-s, reason: not valid java name */
    public static /* synthetic */ boolean m5231$r8$lambda$gG9Lmf6uGtiLAFh46_ObPaJ6s(String r0, GnssListenerRegistration r1) {
        return lambda$onLocationPermissionsChanged$4(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$jxHYIWllUIEh1GMIVHr2qV5A81s(int r0, GnssListenerRegistration r1) {
        return lambda$onProviderEnabledChanged$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$vClVXMxjAdDAtrJys9N7YbiTEH0(int r0, GnssListenerRegistration r1) {
        return lambda$onUserChanged$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$vTTdgGmunMW7m6DFokt_QlVxjDg(String r0, GnssListenerRegistration r1) {
        return lambda$onPackageReset$7(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misResetableForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5232$$Nest$misResetableForPackage(GnssListenerMultiplexer r0, String r1) {
        return r0.isResetableForPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLocationPermissionsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5233$$Nest$monLocationPermissionsChanged(GnssListenerMultiplexer r0, int r1) {
        r0.onLocationPermissionsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLocationPermissionsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5234$$Nest$monLocationPermissionsChanged(GnssListenerMultiplexer r0, String r1) {
        r0.onLocationPermissionsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageReset, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5235$$Nest$monPackageReset(GnssListenerMultiplexer r0, String r1) {
        r0.onPackageReset(r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean isActive(ListenerRegistration r1) {
        return isActive((GnssListenerRegistration) r1);
    }

    protected GnssListenerMultiplexer(Injector injector) {
        this.mUserChangedListener = new GnssListenerMultiplexer$$ExternalSyntheticLambda0(this);
        this.mProviderEnabledChangedListener = new GnssListenerMultiplexer$$ExternalSyntheticLambda1(this);
        this.mBackgroundThrottlePackageWhitelistChangedListener = new GnssListenerMultiplexer$$ExternalSyntheticLambda2(this);
        this.mLocationPackageBlacklistChangedListener = new GnssListenerMultiplexer$$ExternalSyntheticLambda3(this);
        this.mLocationPermissionsListener = new AnonymousClass1(this);
        this.mAppForegroundChangedListener = new GnssListenerMultiplexer$$ExternalSyntheticLambda4(this);
        this.mPackageResetResponder = new AnonymousClass2(this);
        this.mUserInfoHelper = injector.getUserInfoHelper();
        this.mSettingsHelper = injector.getSettingsHelper();
        this.mLocationPermissionsHelper = injector.getLocationPermissionsHelper();
        this.mAppForegroundHelper = injector.getAppForegroundHelper();
        this.mPackageResetHelper = injector.getPackageResetHelper();
        LocationManagerInternal r0 = (LocationManagerInternal) LocalServices.getService(LocationManagerInternal.class);
        r0.getClass();
        this.mLocationManagerInternal = r0;
    }

    public boolean isSupported() {
        return true;
    }

    protected void addListener(CallerIdentity identity, TListener listener) {
        addListener(null, identity, listener);
    }

    protected void addListener(TRequest request, CallerIdentity callerIdentity, TListener listener) {
        long identity = Binder.clearCallingIdentity();
        putRegistration(listener.asBinder(), createRegistration(request, callerIdentity, listener));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    protected GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration createRegistration(TRequest request, CallerIdentity callerIdentity, TListener listener) {
        return new GnssListenerRegistration(this, request, callerIdentity, listener);
    }

    public void removeListener(TListener listener) {
        long identity = Binder.clearCallingIdentity();
        removeRegistration(listener.asBinder());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    protected boolean isActive(GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration registration) {
        if (isSupported() == true) goto L5;
        return false;
    L5:
        CallerIdentity identity = registration.getIdentity();
        if (registration.isPermitted() == true) goto L8;
        return false;
    L8:
        if (registration.isForeground() == true) goto L12;
        if (isBackgroundRestrictionExempt(identity) == true) goto L12;
        return false;
    L12:
        if (isActive(identity) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean isActive(CallerIdentity identity) {
        if (identity.isSystemServer() == false) goto L8;
        if (this.mLocationManagerInternal.isProviderEnabledForUser("gps", this.mUserInfoHelper.getCurrentUserId()) == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (this.mLocationManagerInternal.isProviderEnabledForUser("gps", identity.getUserId()) == true) goto L11;
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

    private boolean isBackgroundRestrictionExempt(CallerIdentity identity) {
        if (identity.getUid() != 1000) goto L6;
        return true;
    L6:
        if (this.mSettingsHelper.getBackgroundThrottlePackageWhitelist().contains(identity.getPackageName()) == false) goto L9;
        return true;
    L9:
        return this.mLocationManagerInternal.isProvider(null, identity);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected TMergedRegistration mergeRegistrations(Collection<GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration> gnssListenerRegistrations) {
        if (Build.IS_DEBUGGABLE == false) goto L12;
        Iterator<GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration> r0 = gnssListenerRegistrations.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        GnssListenerMultiplexer<TRequest, TListener, TMergedRegistration>.GnssListenerRegistration registration = r0.next();
        if (registration.getRequest() != null) goto L10;
        boolean r2 = true;
    L11:
        Preconditions.checkState(r2);
        goto L6
    L10:
        r2 = false;
        goto L11
    L17:
        return null;
    L12:
        return null;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onRegister() {
        if (isSupported() == true) goto L5;
        return;
    L5:
        this.mUserInfoHelper.addListener(this.mUserChangedListener);
        this.mLocationManagerInternal.addProviderEnabledListener("gps", this.mProviderEnabledChangedListener);
        this.mSettingsHelper.addOnBackgroundThrottlePackageWhitelistChangedListener(this.mBackgroundThrottlePackageWhitelistChangedListener);
        this.mSettingsHelper.addOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mLocationPermissionsHelper.addListener(this.mLocationPermissionsListener);
        this.mAppForegroundHelper.addListener(this.mAppForegroundChangedListener);
        this.mPackageResetHelper.register(this.mPackageResetResponder);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onUnregister() {
        if (isSupported() == true) goto L5;
        return;
    L5:
        this.mUserInfoHelper.removeListener(this.mUserChangedListener);
        this.mLocationManagerInternal.removeProviderEnabledListener("gps", this.mProviderEnabledChangedListener);
        this.mSettingsHelper.removeOnBackgroundThrottlePackageWhitelistChangedListener(this.mBackgroundThrottlePackageWhitelistChangedListener);
        this.mSettingsHelper.removeOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mLocationPermissionsHelper.removeListener(this.mLocationPermissionsListener);
        this.mAppForegroundHelper.removeListener(this.mAppForegroundChangedListener);
        this.mPackageResetHelper.unregister(this.mPackageResetResponder);
    }

    private void onUserChanged(final int userId, int change) {
        if (change != 1) goto L5;
    L6:
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda8(userId));
        return;
    L5:
        if (change == 4) goto L6;
    }

    private static /* synthetic */ boolean lambda$onUserChanged$0(int userId, GnssListenerRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void onProviderEnabledChanged(String provider, final int userId, boolean enabled) {
        Preconditions.checkState("gps".equals(provider));
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda5(userId));
    }

    private static /* synthetic */ boolean lambda$onProviderEnabledChanged$1(int userId, GnssListenerRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$onBackgroundThrottlePackageAllowlistChanged$2(GnssListenerRegistration registration) {
        return true;
    }

    private void onBackgroundThrottlePackageAllowlistChanged() {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda10());
    }

    private static /* synthetic */ boolean lambda$onLocationPackageDenylistChanged$3(int userId, GnssListenerRegistration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void onLocationPackageDenylistChanged(final int userId) {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda13(userId));
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$4(String packageName, GnssListenerRegistration registration) {
        return registration.onLocationPermissionsChanged(packageName);
    }

    private void onLocationPermissionsChanged(final String packageName) {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda6(packageName));
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$5(int uid, GnssListenerRegistration registration) {
        return registration.onLocationPermissionsChanged(uid);
    }

    private void onLocationPermissionsChanged(final int uid) {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda7(uid));
    }

    private static /* synthetic */ boolean lambda$onAppForegroundChanged$6(int uid, boolean foreground, GnssListenerRegistration registration) {
        return registration.onForegroundChanged(uid, foreground);
    }

    private void onAppForegroundChanged(final int uid, final boolean foreground) {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda9(uid, foreground));
    }

    private void onPackageReset(final String packageName) {
        updateRegistrations(new GnssListenerMultiplexer$$ExternalSyntheticLambda12(packageName));
    }

    private static /* synthetic */ boolean lambda$onPackageReset$7(String packageName, GnssListenerRegistration registration) {
        if (registration.getIdentity().getPackageName().equals(packageName) == false) goto L7;
        registration.remove();
        return false;
    L7:
        return false;
    }

    private boolean isResetableForPackage(final String packageName) {
        return findRegistration(new GnssListenerMultiplexer$$ExternalSyntheticLambda11(packageName));
    }

    private static /* synthetic */ boolean lambda$isResetableForPackage$8(String packageName, GnssListenerRegistration registration) {
        return registration.getIdentity().getPackageName().equals(packageName);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected String getServiceState() {
        if (isSupported() == true) goto L7;
        return "unsupported";
    L7:
        return super.getServiceState();
    }
}
