package com.android.server.location.gnss;

import android.R;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.pm.Settings;
import com.android.server.power.teardown.hwteardown.HwTeardownResult;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class GnssVisibilityControl {
    private static final int ARRAY_MAP_INITIAL_CAPACITY_PROXY_APPS_STATE = 5;
    private static final boolean DEBUG = false;
    private static final long EMERGENCY_EXTENSION_FOR_MISMATCH = 128000;
    private static final long LOCATION_ICON_DISPLAY_DURATION_MILLIS = 5000;
    private static final String LOCATION_PERMISSION_NAME = "android.permission.ACCESS_FINE_LOCATION";
    private static final String[] NO_LOCATION_ENABLED_PROXY_APPS = null;
    private static final long ON_GPS_ENABLED_CHANGED_TIMEOUT_MILLIS = 3000;
    private static final String TAG = "GnssVisibilityControl";
    private static final String WAKELOCK_KEY = "GnssVisibilityControl";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 60000;
    private final AppOpsManager mAppOps;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mIsGpsEnabled;
    private final GpsNetInitiatedHandler mNiHandler;
    private PackageManager.OnPermissionsChangedListener mOnPermissionsChangedListener;
    private final PackageManager mPackageManager;
    private ArrayMap<String, ProxyAppState> mProxyAppsState;
    private final PowerManager.WakeLock mWakeLock;

    private static class NfwNotification {
        private static final byte NFW_RESPONSE_TYPE_ACCEPTED_LOCATION_PROVIDED = 2;
        private static final byte NFW_RESPONSE_TYPE_ACCEPTED_NO_LOCATION_PROVIDED = 1;
        private static final byte NFW_RESPONSE_TYPE_REJECTED = 0;
        private final boolean mInEmergencyMode;
        private final boolean mIsCachedLocation;
        private final String mOtherProtocolStackName;
        private final byte mProtocolStack;
        private final String mProxyAppPackageName;
        private final byte mRequestor;
        private final String mRequestorId;
        private final byte mResponseType;

        /* JADX INFO: renamed from: -$$Nest$fgetmInEmergencyMode, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5292$$Nest$fgetmInEmergencyMode(NfwNotification r0) {
            return r0.mInEmergencyMode;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsCachedLocation, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5293$$Nest$fgetmIsCachedLocation(NfwNotification r0) {
            return r0.mIsCachedLocation;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOtherProtocolStackName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5294$$Nest$fgetmOtherProtocolStackName(NfwNotification r0) {
            return r0.mOtherProtocolStackName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProtocolStack, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte m5295$$Nest$fgetmProtocolStack(NfwNotification r0) {
            return r0.mProtocolStack;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProxyAppPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5296$$Nest$fgetmProxyAppPackageName(NfwNotification r0) {
            return r0.mProxyAppPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestor, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte m5297$$Nest$fgetmRequestor(NfwNotification r0) {
            return r0.mRequestor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestorId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5298$$Nest$fgetmRequestorId(NfwNotification r0) {
            return r0.mRequestorId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResponseType, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte m5299$$Nest$fgetmResponseType(NfwNotification r0) {
            return r0.mResponseType;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetResponseTypeAsString, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5300$$Nest$mgetResponseTypeAsString(NfwNotification r0) {
            return r0.getResponseTypeAsString();
        }

        /* JADX INFO: renamed from: -$$Nest$misEmergencyRequestNotification, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5301$$Nest$misEmergencyRequestNotification(NfwNotification r0) {
            return r0.isEmergencyRequestNotification();
        }

        /* JADX INFO: renamed from: -$$Nest$misLocationProvided, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5302$$Nest$misLocationProvided(NfwNotification r0) {
            return r0.isLocationProvided();
        }

        /* JADX INFO: renamed from: -$$Nest$misRequestAccepted, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5303$$Nest$misRequestAccepted(NfwNotification r0) {
            return r0.isRequestAccepted();
        }

        /* JADX INFO: renamed from: -$$Nest$misRequestAttributedToProxyApp, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5304$$Nest$misRequestAttributedToProxyApp(NfwNotification r0) {
            return r0.isRequestAttributedToProxyApp();
        }

        /* synthetic */ NfwNotification(String r1, byte r2, String r3, byte r4, String r5, byte r6, boolean r7, boolean r8, GnssVisibilityControlIA r9) {
            this(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        private NfwNotification(String proxyAppPackageName, byte protocolStack, String otherProtocolStackName, byte requestor, String requestorId, byte responseType, boolean inEmergencyMode, boolean isCachedLocation) {
            this.mProxyAppPackageName = proxyAppPackageName;
            this.mProtocolStack = protocolStack;
            this.mOtherProtocolStackName = otherProtocolStackName;
            this.mRequestor = requestor;
            this.mRequestorId = requestorId;
            this.mResponseType = responseType;
            this.mInEmergencyMode = inEmergencyMode;
            this.mIsCachedLocation = isCachedLocation;
        }

        public String toString() {
            return String.format("{proxyAppPackageName: %s, protocolStack: %d, otherProtocolStackName: %s, requestor: %d, requestorId: %s, responseType: %s, inEmergencyMode: %b, isCachedLocation: %b}", new Object[]{this.mProxyAppPackageName, Byte.valueOf(this.mProtocolStack), this.mOtherProtocolStackName, Byte.valueOf(this.mRequestor), this.mRequestorId, getResponseTypeAsString(), Boolean.valueOf(this.mInEmergencyMode), Boolean.valueOf(this.mIsCachedLocation)});
        }

        private String getResponseTypeAsString() {
            switch(this.mResponseType) {
                case 0: goto L10;
                case 1: goto L8;
                case 2: goto L6;
                default: goto L4;
            };
        L4:
            return "<Unknown>";
        L6:
            return "ACCEPTED_LOCATION_PROVIDED";
        L8:
            return "ACCEPTED_NO_LOCATION_PROVIDED";
        L10:
            return "REJECTED";
        }

        private boolean isRequestAccepted() {
            if (this.mResponseType == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isLocationProvided() {
            if (this.mResponseType != 2) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isRequestAttributedToProxyApp() {
            return !TextUtils.isEmpty(this.mProxyAppPackageName);
        }

        private boolean isEmergencyRequestNotification() {
            if (this.mInEmergencyMode == true) goto L5;
        L7:
            return false;
        L5:
            if (isRequestAttributedToProxyApp() == true) goto L7;
            return true;
        }
    }

    private static final class ProxyAppState {
        private boolean mHasLocationPermission;
        private boolean mIsLocationIconOn;

        /* JADX INFO: renamed from: -$$Nest$fgetmHasLocationPermission, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5305$$Nest$fgetmHasLocationPermission(ProxyAppState r0) {
            return r0.mHasLocationPermission;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsLocationIconOn, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5306$$Nest$fgetmIsLocationIconOn(ProxyAppState r0) {
            return r0.mIsLocationIconOn;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmHasLocationPermission, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5307$$Nest$fputmHasLocationPermission(ProxyAppState r0, boolean r1) {
            r0.mHasLocationPermission = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsLocationIconOn, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5308$$Nest$fputmIsLocationIconOn(ProxyAppState r0, boolean r1) {
            r0.mIsLocationIconOn = r1;
        }

        /* synthetic */ ProxyAppState(boolean r1, GnssVisibilityControlIA r2) {
            this(r1);
        }

        private ProxyAppState(boolean hasLocationPermission) {
            this.mHasLocationPermission = hasLocationPermission;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-C_A0LLAtzxFw2GtgzhvWwBB6Yo, reason: not valid java name */
    public static /* synthetic */ void m5289$r8$lambda$C_A0LLAtzxFw2GtgzhvWwBB6Yo(GnssVisibilityControl r0, List r1) {
        r0.lambda$onConfigurationUpdated$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$5V8vH4biFgXoRqyBM_TUEfXREpQ(GnssVisibilityControl r0, int r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$A4UYQAFA7LXTt1VW4nIMDckqXBE(GnssVisibilityControl r0, String r1) {
        r0.lambda$showLocationIcon$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$KqWp3vHGQ6ypxlUxXJaA5Vl0Yw0(GnssVisibilityControl r0, String r1, byte r2, String r3, byte r4, String r5, byte r6, boolean r7, boolean r8) {
        r0.lambda$reportNfwNotification$3(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$QSIGEde0V8a2umZ6weceH27oZBU(GnssVisibilityControl r0, Runnable r1) {
        r0.lambda$runEventAndReleaseWakeLock$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$UFJaGDOfHy8H_6ZhRklIms-8o_A, reason: not valid java name */
    public static /* synthetic */ void m5290$r8$lambda$UFJaGDOfHy8H_6ZhRklIms8o_A(GnssVisibilityControl r0, boolean r1) {
        r0.lambda$onGpsEnabledChanged$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$dJecQTgcsVi1z20DN2Mq2OZgcLo(GnssVisibilityControl r0) {
        r0.handleInitialize();
    }

    public static /* synthetic */ void $r8$lambda$k9aTnhnlZs2XpRypViwGipDiKWo(GnssVisibilityControl r0, int r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleProxyAppPackageUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5291$$Nest$mhandleProxyAppPackageUpdate(GnssVisibilityControl r0, String r1, String r2) {
        r0.handleProxyAppPackageUpdate(r1, r2);
    }

    private native boolean native_enable_nfw_location_access(String[] r1);

    static {
        DEBUG = Log.isLoggable("GnssVisibilityControl", 3);
        NO_LOCATION_ENABLED_PROXY_APPS = new String[0];
    }

    private /* synthetic */ void lambda$new$0(int uid) {
        handlePermissionsChanged(uid);
    }

    private /* synthetic */ void lambda$new$1(final int uid) {
        runOnHandler(new GnssVisibilityControl$$ExternalSyntheticLambda5(this, uid));
    }

    GnssVisibilityControl(Context context, Looper looper, GpsNetInitiatedHandler niHandler) {
        this.mProxyAppsState = new ArrayMap(5);
        this.mOnPermissionsChangedListener = new GnssVisibilityControl$$ExternalSyntheticLambda3(this);
        this.mContext = context;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.mWakeLock = powerManager.newWakeLock(1, "GnssVisibilityControl");
        this.mHandler = new Handler(looper);
        this.mNiHandler = niHandler;
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mPackageManager = this.mContext.getPackageManager();
        runOnHandler(new GnssVisibilityControl$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$onGpsEnabledChanged$2(boolean isEnabled) {
        handleGpsEnabledChanged(isEnabled);
    }

    void onGpsEnabledChanged(final boolean isEnabled) {
        if (this.mHandler.runWithScissors(new GnssVisibilityControl$$ExternalSyntheticLambda0(this, isEnabled), 3000) == false) goto L5;
        return;
    L5:
        if (isEnabled == true) goto L8;
        Log.w("GnssVisibilityControl", "Native call to disable non-framework location access in GNSS HAL may get executed after native_cleanup().");
        return;
    }

    private /* synthetic */ void lambda$reportNfwNotification$3(String proxyAppPackageName, byte protocolStack, String otherProtocolStackName, byte requestor, String requestorId, byte responseType, boolean inEmergencyMode, boolean isCachedLocation) {
        handleNfwNotification(new NfwNotification(proxyAppPackageName, protocolStack, otherProtocolStackName, requestor, requestorId, responseType, inEmergencyMode, isCachedLocation, null));
    }

    void reportNfwNotification(final String proxyAppPackageName, final byte protocolStack, final String otherProtocolStackName, final byte requestor, final String requestorId, final byte responseType, final boolean inEmergencyMode, final boolean isCachedLocation) {
        runOnHandler(new GnssVisibilityControl$$ExternalSyntheticLambda2(this, proxyAppPackageName, protocolStack, otherProtocolStackName, requestor, requestorId, responseType, inEmergencyMode, isCachedLocation));
    }

    void onConfigurationUpdated(GnssConfiguration configuration) {
        final List<String> nfwLocationAccessProxyApps = configuration.getProxyApps();
        runOnHandler(new GnssVisibilityControl$$ExternalSyntheticLambda1(this, nfwLocationAccessProxyApps));
    }

    private /* synthetic */ void lambda$onConfigurationUpdated$4(List nfwLocationAccessProxyApps) {
        handleUpdateProxyApps(nfwLocationAccessProxyApps);
    }

    private void handleInitialize() {
        listenForProxyAppsPackageUpdates();
    }

    private void listenForProxyAppsPackageUpdates() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.ALL, intentFilter, null, this.mHandler);
    }

    private void handleProxyAppPackageUpdate(String pkgName, String action) {
        ProxyAppState proxyAppState = this.mProxyAppsState.get(pkgName);
        if (proxyAppState != null) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Log.d("GnssVisibilityControl", "Proxy app " + pkgName + " package changed: " + action);
    L8:
        boolean updatedLocationPermission = shouldEnableLocationPermissionInGnssHal(pkgName);
        if (ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(proxyAppState) == updatedLocationPermission) goto L12;
        Log.i("GnssVisibilityControl", "Proxy app " + pkgName + " location permission changed. IsLocationPermissionEnabled: " + updatedLocationPermission);
        ProxyAppState.m5307$$Nest$fputmHasLocationPermission(proxyAppState, updatedLocationPermission);
        updateNfwLocationAccessProxyAppsInGnssHal();
        return;
    }

    private void handleUpdateProxyApps(List<String> nfwLocationAccessProxyApps) {
        if (isProxyAppListUpdated(nfwLocationAccessProxyApps) == true) goto L6;
        return;
    L6:
        if (nfwLocationAccessProxyApps.isEmpty() == false) goto L12;
        if (this.mProxyAppsState.isEmpty() == true) goto L22;
        this.mPackageManager.removeOnPermissionsChangeListener(this.mOnPermissionsChangedListener);
        resetProxyAppsState();
        updateNfwLocationAccessProxyAppsInGnssHal();
        return;
    L22:
        return;
    L12:
        if (this.mProxyAppsState.isEmpty() == false) goto L14;
        this.mPackageManager.addOnPermissionsChangeListener(this.mOnPermissionsChangedListener);
    L15:
        Iterator<String> r0 = nfwLocationAccessProxyApps.iterator();
    L17:
        if (r0.hasNext() == false) goto L19;
        String proxyAppPkgName = r0.next();
        ProxyAppState proxyAppState = new ProxyAppState(shouldEnableLocationPermissionInGnssHal(proxyAppPkgName), null);
        this.mProxyAppsState.put(proxyAppPkgName, proxyAppState);
        goto L17
    L19:
        updateNfwLocationAccessProxyAppsInGnssHal();
        return;
    L14:
        resetProxyAppsState();
        goto L15
    }

    private void resetProxyAppsState() {
        Iterator<Map.Entry<String, ProxyAppState>> r0 = this.mProxyAppsState.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, ProxyAppState> entry = r0.next();
        ProxyAppState proxyAppState = entry.getValue();
        if (ProxyAppState.m5306$$Nest$fgetmIsLocationIconOn(proxyAppState) == false) goto L4;
        this.mHandler.removeCallbacksAndMessages(proxyAppState);
        ApplicationInfo proxyAppInfo = getProxyAppInfo(entry.getKey());
        if (proxyAppInfo == null) goto L4;
        clearLocationIcon(proxyAppState, proxyAppInfo.uid, entry.getKey());
        goto L4
    L12:
        this.mProxyAppsState.clear();
    }

    private boolean isProxyAppListUpdated(List<String> nfwLocationAccessProxyApps) {
        if (nfwLocationAccessProxyApps.size() == this.mProxyAppsState.size()) goto L5;
        return true;
    L5:
        Iterator<String> r0 = nfwLocationAccessProxyApps.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String nfwLocationAccessProxyApp = r0.next();
        if (this.mProxyAppsState.containsKey(nfwLocationAccessProxyApp) == true) goto L7;
        return true;
    L12:
        return false;
    }

    private void handleGpsEnabledChanged(boolean isGpsEnabled) {
        if (DEBUG == false) goto L5;
        Log.d("GnssVisibilityControl", "handleGpsEnabledChanged, mIsGpsEnabled: " + this.mIsGpsEnabled + ", isGpsEnabled: " + isGpsEnabled);
    L5:
        this.mIsGpsEnabled = isGpsEnabled;
        if (this.mIsGpsEnabled == true) goto L9;
        disableNfwLocationAccess();
        return;
    L9:
        setNfwLocationAccessProxyAppsInGnssHal(getLocationPermissionEnabledProxyApps());
    }

    private void disableNfwLocationAccess() {
        setNfwLocationAccessProxyAppsInGnssHal(NO_LOCATION_ENABLED_PROXY_APPS);
    }

    private void handlePermissionsChanged(int uid) {
        if (this.mProxyAppsState.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ProxyAppState>> r0 = this.mProxyAppsState.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        Map.Entry<String, ProxyAppState> entry = r0.next();
        String proxyAppPkgName = entry.getKey();
        ApplicationInfo proxyAppInfo = getProxyAppInfo(proxyAppPkgName);
        if (proxyAppInfo == null) goto L7;
        if (proxyAppInfo.uid != uid) goto L7;
        boolean isLocationPermissionEnabled = shouldEnableLocationPermissionInGnssHal(proxyAppPkgName);
        ProxyAppState proxyAppState = entry.getValue();
        if (isLocationPermissionEnabled == ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(proxyAppState)) goto L24;
        Log.i("GnssVisibilityControl", "Proxy app " + proxyAppPkgName + " location permission changed. IsLocationPermissionEnabled: " + isLocationPermissionEnabled);
        ProxyAppState.m5307$$Nest$fputmHasLocationPermission(proxyAppState, isLocationPermissionEnabled);
        updateNfwLocationAccessProxyAppsInGnssHal();
        return;
    L24:
        return;
    }

    private ApplicationInfo getProxyAppInfo(String proxyAppPkgName) {
        return this.mPackageManager.getApplicationInfo(proxyAppPkgName, 0);
    L6:
        if (DEBUG == false) goto L12;
        Log.d("GnssVisibilityControl", "Proxy app " + proxyAppPkgName + " is not found.");
        return null;
    L12:
        return null;
    }

    private boolean shouldEnableLocationPermissionInGnssHal(String proxyAppPkgName) {
        if (isProxyAppInstalled(proxyAppPkgName) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasLocationPermission(proxyAppPkgName) == false) goto L7;
        return true;
    }

    private boolean isProxyAppInstalled(String pkgName) {
        ApplicationInfo proxyAppInfo = getProxyAppInfo(pkgName);
        if (proxyAppInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (proxyAppInfo.enabled == false) goto L7;
        return true;
    }

    private boolean hasLocationPermission(String pkgName) {
        if (this.mPackageManager.checkPermission(LOCATION_PERMISSION_NAME, pkgName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateNfwLocationAccessProxyAppsInGnssHal() {
        if (this.mIsGpsEnabled == true) goto L5;
        return;
    L5:
        setNfwLocationAccessProxyAppsInGnssHal(getLocationPermissionEnabledProxyApps());
    }

    private void setNfwLocationAccessProxyAppsInGnssHal(String[] locationPermissionEnabledProxyApps) {
        String proxyAppsStr = Arrays.toString(locationPermissionEnabledProxyApps);
        Log.i("GnssVisibilityControl", "Updating non-framework location access proxy apps in the GNSS HAL to: " + proxyAppsStr);
        boolean result = native_enable_nfw_location_access(locationPermissionEnabledProxyApps);
        if (result == true) goto L6;
        Log.e("GnssVisibilityControl", "Failed to update non-framework location access proxy apps in the GNSS HAL to: " + proxyAppsStr);
        return;
    }

    private String[] getLocationPermissionEnabledProxyApps() {
        int countLocationPermissionEnabledProxyApps = 0;
        Iterator<ProxyAppState> r1 = this.mProxyAppsState.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ProxyAppState proxyAppState = r1.next();
        if (ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(proxyAppState) == false) goto L4;
        countLocationPermissionEnabledProxyApps = countLocationPermissionEnabledProxyApps + 1;
        goto L4
    L9:
        int i = 0;
        String[] locationPermissionEnabledProxyApps = new String[countLocationPermissionEnabledProxyApps];
        Iterator<Map.Entry<String, ProxyAppState>> r3 = this.mProxyAppsState.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Map.Entry<String, ProxyAppState> entry = r3.next();
        String proxyApp = entry.getKey();
        if (ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(entry.getValue()) == false) goto L11;
        locationPermissionEnabledProxyApps[i] = proxyApp;
        i = i + 1;
        goto L11
    L16:
        return locationPermissionEnabledProxyApps;
    }

    public boolean hasLocationPermissionEnabledProxyApps() {
        if (getLocationPermissionEnabledProxyApps().length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void handleNfwNotification(NfwNotification nfwNotification) {
        if (DEBUG == false) goto L6;
        Log.d("GnssVisibilityControl", "Non-framework location access notification: " + nfwNotification);
    L6:
        if (NfwNotification.m5301$$Nest$misEmergencyRequestNotification(nfwNotification) == false) goto L9;
        handleEmergencyNfwNotification(nfwNotification);
        return;
    L9:
        String proxyAppPkgName = NfwNotification.m5296$$Nest$fgetmProxyAppPackageName(nfwNotification);
        ProxyAppState proxyAppState = this.mProxyAppsState.get(proxyAppPkgName);
        boolean isLocationRequestAccepted = NfwNotification.m5303$$Nest$misRequestAccepted(nfwNotification);
        boolean isPermissionMismatched = isPermissionMismatched(proxyAppState, nfwNotification);
        logEvent(nfwNotification, isPermissionMismatched);
        if (NfwNotification.m5304$$Nest$misRequestAttributedToProxyApp(nfwNotification) == true) goto L18;
        if (isLocationRequestAccepted == false) goto L13;
        Log.e("GnssVisibilityControl", "ProxyAppPackageName field is not set. AppOps service not notified for notification: " + nfwNotification);
        return;
    L13:
        if (DEBUG == false) goto L31;
        Log.d("GnssVisibilityControl", "Non-framework location request rejected. ProxyAppPackageName field is not set in the notification: " + nfwNotification + ". Number of configured proxy apps: " + this.mProxyAppsState.size());
        return;
    L31:
        return;
    L18:
        if (proxyAppState != null) goto L21;
        Log.w("GnssVisibilityControl", "Could not find proxy app " + proxyAppPkgName + " in the value specified for config parameter: NFW_PROXY_APPS. AppOps service not notified for notification: " + nfwNotification);
        return;
    L21:
        ApplicationInfo proxyAppInfo = getProxyAppInfo(proxyAppPkgName);
        if (proxyAppInfo != null) goto L26;
        Log.e("GnssVisibilityControl", "Proxy app " + proxyAppPkgName + " is not found. AppOps service not notified for notification: " + nfwNotification);
        return;
    L26:
        if (NfwNotification.m5302$$Nest$misLocationProvided(nfwNotification) == false) goto L28;
        showLocationIcon(proxyAppState, nfwNotification, proxyAppInfo.uid, proxyAppPkgName);
        this.mAppOps.noteOpNoThrow(1, proxyAppInfo.uid, proxyAppPkgName);
    L28:
        if (isPermissionMismatched == false) goto L32;
        Log.w("GnssVisibilityControl", "Permission mismatch. Proxy app " + proxyAppPkgName + " location permission is set to " + ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(proxyAppState) + " and GNSS HAL enabled is set to " + this.mIsGpsEnabled + " but GNSS non-framework location access response type is " + NfwNotification.m5300$$Nest$mgetResponseTypeAsString(nfwNotification) + " for notification: " + nfwNotification);
        return;
    }

    private boolean isPermissionMismatched(ProxyAppState proxyAppState, NfwNotification nfwNotification) {
        boolean isLocationRequestAccepted = NfwNotification.m5303$$Nest$misRequestAccepted(nfwNotification);
        if (proxyAppState == null) goto L12;
        if (this.mIsGpsEnabled == false) goto L12;
        if (ProxyAppState.m5305$$Nest$fgetmHasLocationPermission(proxyAppState) == isLocationRequestAccepted) goto L10;
        return true;
    L10:
        return false;
    L12:
        return isLocationRequestAccepted;
    }

    private void showLocationIcon(ProxyAppState proxyAppState, NfwNotification nfwNotification, int uid, final String proxyAppPkgName) {
        boolean isLocationIconOn = ProxyAppState.m5306$$Nest$fgetmIsLocationIconOn(proxyAppState);
        if (isLocationIconOn == false) goto L5;
        this.mHandler.removeCallbacksAndMessages(proxyAppState);
    L11:
        if (DEBUG == false) goto L18;
        StringBuilder r2 = new StringBuilder();
        r2.append("Location icon on. ");
        if (isLocationIconOn == false) goto L15;
        String r3 = "Extending";
    L16:
        r2.append(r3);
        r2.append(" icon display timer. Uid: ");
        r2.append(uid);
        r2.append(", proxyAppPkgName: ");
        r2.append(proxyAppPkgName);
        Log.d("GnssVisibilityControl", r2.toString());
        goto L18
    L15:
        r3 = HwTeardownResult.COMPONENT_SETTING;
    L18:
        if (this.mHandler.postDelayed(new GnssVisibilityControl$$ExternalSyntheticLambda6(this, proxyAppPkgName), proxyAppState, LOCATION_ICON_DISPLAY_DURATION_MILLIS) == true) goto L21;
        clearLocationIcon(proxyAppState, uid, proxyAppPkgName);
        Log.w("GnssVisibilityControl", "Failed to show location icon for the full duration for notification: " + nfwNotification);
        return;
    L21:
        return;
    L5:
        if (updateLocationIcon(true, uid, proxyAppPkgName) == true) goto L8;
        Log.w("GnssVisibilityControl", "Failed to show Location icon for notification: " + nfwNotification);
        return;
    L8:
        ProxyAppState.m5308$$Nest$fputmIsLocationIconOn(proxyAppState, true);
        goto L11
    }

    private /* synthetic */ void lambda$showLocationIcon$5(String proxyAppPkgName) {
        handleLocationIconTimeout(proxyAppPkgName);
    }

    private void handleLocationIconTimeout(String proxyAppPkgName) {
        ApplicationInfo proxyAppInfo = getProxyAppInfo(proxyAppPkgName);
        if (proxyAppInfo == null) goto L6;
        clearLocationIcon(this.mProxyAppsState.get(proxyAppPkgName), proxyAppInfo.uid, proxyAppPkgName);
        return;
    }

    private void clearLocationIcon(ProxyAppState proxyAppState, int uid, String proxyAppPkgName) {
        updateLocationIcon(false, uid, proxyAppPkgName);
        if (proxyAppState == null) goto L6;
        ProxyAppState.m5308$$Nest$fputmIsLocationIconOn(proxyAppState, false);
    L6:
        if (DEBUG == false) goto L9;
        Log.d("GnssVisibilityControl", "Location icon off. Uid: " + uid + ", proxyAppPkgName: " + proxyAppPkgName);
        return;
    }

    private boolean updateLocationIcon(boolean displayLocationIcon, int uid, String proxyAppPkgName) {
        if (displayLocationIcon == true) goto L5;
        this.mAppOps.finishOp(41, uid, proxyAppPkgName);
        this.mAppOps.finishOp(42, uid, proxyAppPkgName);
        return true;
    L5:
        if (this.mAppOps.startOpNoThrow(41, uid, proxyAppPkgName) == 0) goto L8;
        return false;
    L8:
        if (this.mAppOps.startOpNoThrow(42, uid, proxyAppPkgName) == 0) goto L14;
        this.mAppOps.finishOp(41, uid, proxyAppPkgName);
        return false;
    L14:
        return true;
    }

    private void handleEmergencyNfwNotification(NfwNotification nfwNotification) {
        boolean isPermissionMismatched = false;
        if (NfwNotification.m5303$$Nest$misRequestAccepted(nfwNotification) == true) goto L6;
        Log.e("GnssVisibilityControl", "Emergency non-framework location request incorrectly rejected. Notification: " + nfwNotification);
        isPermissionMismatched = true;
    L6:
        if (this.mNiHandler.getInEmergency(EMERGENCY_EXTENSION_FOR_MISMATCH) == true) goto L8;
        Log.w("GnssVisibilityControl", "Emergency state mismatch. Device currently not in user initiated emergency session. Notification: " + nfwNotification);
        isPermissionMismatched = true;
    L8:
        logEvent(nfwNotification, isPermissionMismatched);
        if (NfwNotification.m5302$$Nest$misLocationProvided(nfwNotification) == false) goto L12;
        postEmergencyLocationUserNotification(nfwNotification);
        return;
    }

    private void postEmergencyLocationUserNotification(NfwNotification nfwNotification) {
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (notificationManager != null) goto L6;
        Log.w("GnssVisibilityControl", "Could not notify user of emergency location request. Notification: " + nfwNotification);
        return;
    L6:
        notificationManager.notifyAsUser(null, 0, createEmergencyLocationUserNotification(this.mContext), UserHandle.ALL);
    }

    private static Notification createEmergencyLocationUserNotification(Context context) {
        String firstLineText = context.getString(R.string.indeterminate_progress_44);
        String secondLineText = context.getString(R.string.indeterminate_progress_21);
        String accessibilityServicesText = firstLineText + " (" + secondLineText + ")";
        return new Notification.Builder(context, "NETWORK_STATUS").setSmallIcon(17305216).setWhen(0).setOngoing(false).setAutoCancel(true).setColor(context.getColor(R.color.system_notification_accent_color)).setDefaults(0).setTicker(accessibilityServicesText).setContentTitle(firstLineText).setContentText(secondLineText).build();
    }

    private void logEvent(NfwNotification notification, boolean isPermissionMismatched) {
        FrameworkStatsLog.write(131, NfwNotification.m5296$$Nest$fgetmProxyAppPackageName(notification), NfwNotification.m5295$$Nest$fgetmProtocolStack(notification), NfwNotification.m5294$$Nest$fgetmOtherProtocolStackName(notification), NfwNotification.m5297$$Nest$fgetmRequestor(notification), NfwNotification.m5298$$Nest$fgetmRequestorId(notification), NfwNotification.m5299$$Nest$fgetmResponseType(notification), NfwNotification.m5292$$Nest$fgetmInEmergencyMode(notification), NfwNotification.m5293$$Nest$fgetmIsCachedLocation(notification), isPermissionMismatched);
    }

    private void runOnHandler(Runnable event) {
        this.mWakeLock.acquire(60000);
        if (this.mHandler.post(runEventAndReleaseWakeLock(event)) == true) goto L6;
        this.mWakeLock.release();
        return;
    }

    private Runnable runEventAndReleaseWakeLock(final Runnable event) {
        return new GnssVisibilityControl$$ExternalSyntheticLambda7(this, event);
    }

    private /* synthetic */ void lambda$runEventAndReleaseWakeLock$6(Runnable event) {
        event.run();     // Catch: Throwable -> L5
        this.mWakeLock.release();
        return;
    L5:
        th = move-exception;
        this.mWakeLock.release();
        throw th;
    }
}
