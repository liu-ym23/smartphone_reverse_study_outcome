package com.android.server.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.obric.cae.libs.utils.EncryptUtil;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class StarLocation {
    private static final String ATTRIBUTION_TAG = null;
    private static final String CTS_GNSS_TEST_PACKAGE = "android.location.cts.gnss";
    private static final String INNER_TAG = "util";
    public static final String KEY_LOCATION_SOURCE = "source";
    public static final byte MASK_LOCATION_SOURCE_GNSS = 1;
    public static final byte MASK_LOCATION_SOURCE_GPO = 2;
    private static final int MAX_FINE_NLP_ACCURACY = 50;
    private static final int MAX_IGNORE_FAKE_NLP_LOCATION_COUNT = 3;
    private static final int MAX_LISTEN_STEPS_COUNT = 50;
    private static final int MIN_COARSE_NLP_ACCURACY = 150;
    private static final String MODULE = null;
    private static final String TAG = null;
    private static final long TIME_NLP_LOCATION_VALID = 60000;
    private static final String ZPP_CLOUD_ENABLE = "zpp_cloud_enable";
    private static final String sEncryptedKey = null;
    private static volatile StarLocation sInstance;
    private boolean DEBUG;
    private final AtomicBoolean mActualGnssStatus;
    private final AtomicBoolean mAospGnssStatus;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private final AtomicInteger mCurrentSteps;
    private final ExecutorService mExecutor;
    private GPOStateMachine mGpoStateMachine;
    private final AtomicInteger mIgnoreFakeNlpLocation;
    private final AtomicBoolean mIsIdleMode;
    private final AtomicBoolean mIsNetworkValid;
    private final AtomicReference<Location> mLastCoarseNlpLocation;
    private Location mLastNlp2GlpLocation;
    private final AtomicLong mLastNlp2GlpTime;
    private final AtomicLong mLastOutsideTime;
    private final AtomicInteger mLastSteps;
    private final AtomicLong mLastWalkTime;
    private LocationManager mLocationManager;
    private final LocationListener mNetworkLocationListener;
    private SensorManager mSensorManager;
    private Sensor mUserStepsCounter;
    private final AtomicBoolean mZppCloudEnabled;

    /* JADX INFO: renamed from: $r8$lambda$GA6jTw1U-TOOIjozYNqZHEoyhEc, reason: not valid java name */
    public static /* synthetic */ void m5147$r8$lambda$GA6jTw1UTOOIjozYNqZHEoyhEc(StarLocation r0) {
        r0.lambda$unregisterNetworkLocationUpdates$2();
    }

    public static /* synthetic */ void $r8$lambda$Y20E4ediChjUQJHV5uwl1zYEZbk(StarLocation r0, Location r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$whJpgtWtZCwc6Ke33r7M9h2oGbk(StarLocation r0) {
        return r0.lambda$registerNetworkLocationUpdates$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentSteps, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m5148$$Nest$fgetmCurrentSteps(StarLocation r0) {
        return r0.mCurrentSteps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsNetworkValid, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m5149$$Nest$fgetmIsNetworkValid(StarLocation r0) {
        return r0.mIsNetworkValid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastOutsideTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicLong m5150$$Nest$fgetmLastOutsideTime(StarLocation r0) {
        return r0.mLastOutsideTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastSteps, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m5151$$Nest$fgetmLastSteps(StarLocation r0) {
        return r0.mLastSteps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastWalkTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicLong m5152$$Nest$fgetmLastWalkTime(StarLocation r0) {
        return r0.mLastWalkTime;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateZppCloudEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5153$$Nest$mupdateZppCloudEnable(StarLocation r0) {
        r0.updateZppCloudEnable();
    }

    static {
        MODULE = StarLocation.class.getSimpleName();
        ATTRIBUTION_TAG = "Fwk-" + MODULE;
        TAG = ATTRIBUTION_TAG + "\t";
        sEncryptedKey = SystemProperties.get("ro.os.ota.version", "default");
    }

    public static synchronized StarLocation getInstance() {
        monitor-enter(StarLocation.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new StarLocation();     // Catch: Throwable -> L7
    L9:
        StarLocation r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(StarLocation.class);
        return r1;
    }

    private StarLocation() {
        this.DEBUG = Log.isLoggable(MODULE, 3);
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mIsNetworkValid = new AtomicBoolean(false);
        this.mLastNlp2GlpTime = new AtomicLong(0);
        this.mLastOutsideTime = new AtomicLong(0);
        this.mCurrentSteps = new AtomicInteger(0);
        this.mLastSteps = new AtomicInteger(0);
        this.mLastWalkTime = new AtomicLong(0);
        this.mIsIdleMode = new AtomicBoolean(false);
        this.mAospGnssStatus = new AtomicBoolean(false);
        this.mActualGnssStatus = new AtomicBoolean(false);
        this.mZppCloudEnabled = new AtomicBoolean(false);
        this.mLastCoarseNlpLocation = new AtomicReference(null);
        this.mIgnoreFakeNlpLocation = new AtomicInteger(0);
        this.mLastNlp2GlpLocation = null;
        this.mNetworkLocationListener = new StarLocation$$ExternalSyntheticLambda0(this);
    }

    public synchronized void enableDebug(boolean enable) {
        monitor-enter(this);
        this.DEBUG = enable;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void initOnce(Context context) {
        this.mContext = context.createAttributionContext(ATTRIBUTION_TAG);
        initNetworkInfo();
        LocationLogsRecorder.getInstance().initOnce();
        this.mGpoStateMachine = GPOStateMachine.getGpoStateMachine();
        this.mGpoStateMachine.start();
        initSensor();
        LocationCldReport.getInstance().initCldReport(this.mContext);
        CaeLocationManager.getInstance().init();
        initZppCloudEnable();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void initNetworkInfo() {
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mConnectivityManager.registerDefaultNetworkCallback(new AnonymousClass1(this));
        this.mIsNetworkValid.set(checkNetworkValid());
    }

    public boolean isNetworkValid() {
        return this.mIsNetworkValid.get();
    }

    public boolean isZppEnabled() {
        if (this.mZppCloudEnabled.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (CaeLocationManager.getInstance().isServiceConnected() == false) goto L7;
        return true;
    }

    public boolean checkZppProviderValid(String provider) {
        if (provider != null) goto L4;
    L10:
        return false;
    L4:
        if ("gps".equals(provider) == false) goto L6;
    L9:
        return true;
    L6:
        if ("network".equals(provider) == true) goto L9;
        if ("fused".equals(provider) == false) goto L10;
        goto L9
    }

    public boolean checkPackageEnabled(String pkgName) {
        return CaeLocationManager.getInstance().checkPackageEnabled(pkgName);
    }

    public Location getLastKnownLocationFromZpp(int userId, String provider) {
        return CaeLocationManager.getInstance().getLastKnownLocationFromZpp(userId, provider);
    }

    private void initZppCloudEnable() {
        Uri uriZppCloudEnable = Settings.Global.getUriFor(ZPP_CLOUD_ENABLE);     // Catch: Exception -> L7
        if (uriZppCloudEnable != null) goto L9;
        this.mZppCloudEnabled.set(false);     // Catch: Exception -> L7
        loge(INNER_TAG, "uriZppCloudEnable is null, initZppCloudEnable failed.");     // Catch: Exception -> L7
        return;
    L9:
        final Handler r5 = null;
        this.mContext.getContentResolver().registerContentObserver(uriZppCloudEnable, false, new AnonymousClass2(this, r5));     // Catch: Exception -> L7
        updateZppCloudEnable();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        this.mZppCloudEnabled.set(false);
        loge(INNER_TAG, "initZppCloudEnable failed: " + e);
    }

    private void updateZppCloudEnable() {
        String enable = Settings.Global.getString(this.mContext.getContentResolver(), ZPP_CLOUD_ENABLE);     // Catch: Exception -> L8
        if (TextUtils.isEmpty(enable) == true) goto L11;
        if ("True".equalsIgnoreCase(enable) == false) goto L11;
        this.mZppCloudEnabled.set(true);     // Catch: Exception -> L8
    L19:
        return;
    L11:
        if (TextUtils.isEmpty(enable) == false) goto L13;
    L15:
        this.mZppCloudEnabled.set(false);     // Catch: Exception -> L8
        goto L19
    L13:
        if ("False".equalsIgnoreCase(enable) == false) goto L15;
        this.mZppCloudEnabled.set(false);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        this.mZppCloudEnabled.set(false);
        loge(INNER_TAG, "updateZppCloudEnable failed: " + e);
    }

    public boolean checkNetworkValid() {
        if (this.mConnectivityManager != null) goto L8;
        loge(INNER_TAG, "ConnectivityManager is null, network is invalid.");
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (this.mConnectivityManager != null) goto L8;
        loge(INNER_TAG, "ConnectivityManager is still null after re-initialization.");
        return false;
    L8:
        Network activeNetwork = this.mConnectivityManager.getActiveNetwork();
        if (activeNetwork != null) goto L12;
        logi(INNER_TAG, "No active network found.");
        return false;
    L12:
        NetworkCapabilities capabilities = this.mConnectivityManager.getNetworkCapabilities(activeNetwork);
        if (capabilities != null) goto L17;
        logi(INNER_TAG, "NetworkCapabilities is null.");
        return false;
    L17:
        if (capabilities.hasCapability(12) == true) goto L19;
        return false;
    L19:
        if (capabilities.hasCapability(16) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public void initLocation() {
        logi(INNER_TAG, "initLocation");
        this.mLocationManager = (LocationManager) this.mContext.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
        this.mLocationManager.registerGnssStatusCallback(this.mExecutor, new AnonymousClass3(this));
        this.mLocationManager.addNmeaListener(this.mExecutor, new AnonymousClass4(this));
    }

    public long getLastOutsideTime() {
        return this.mLastOutsideTime.get();
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mUserStepsCounter = this.mSensorManager.getDefaultSensor(19, false);
        this.mSensorManager.registerListener(new AnonymousClass5(this), this.mUserStepsCounter, 0);
    }

    public long getLastWalkTime() {
        return this.mLastWalkTime.get();
    }

    public void updateLastSteps() {
        this.mLastSteps.set(this.mCurrentSteps.get());
    }

    public synchronized boolean isCacheNlpLocationValid() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mLastNlp2GlpLocation != null) goto L6;
    L13:
        boolean r0 = false;
    L14:
        monitor-exit(this);
        return r0;
    L6:
        if (this.mLastNlp2GlpTime.get() == 0) goto L13;
        if ((SystemClock.elapsedRealtime() - this.mLastNlp2GlpTime.get()) > 60000) goto L13;
        r0 = true;
        goto L14
    }

    public synchronized Location getCachedNlpLocation() {
        monitor-enter(this);
        Location r0 = this.mLastNlp2GlpLocation;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0(Location location) {
        monitor-enter(this);
        if (location == null) goto L20;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (location.isComplete() == false) goto L20;
        if (isFakeFineNlpLocation(location) == true) goto L17;
        if (location.getAccuracy() > 50.0f) goto L17;
        this.mLastNlp2GlpTime.set(SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        convertNlp2Glp(location);     // Catch: Throwable -> L15
        Message msg = this.mGpoStateMachine.obtainMessage(5, this.mLastNlp2GlpLocation);     // Catch: Throwable -> L15
        this.mGpoStateMachine.sendMessage(msg);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L17:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GPO ignore nlp " + location.toString());     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    public boolean registerNetworkLocationUpdates() {
        if (isNetworkValid() == true) goto L5;
        return false;
    L5:
        if (this.mLocationManager.isProviderEnabled("network") == true) goto L8;
        return false;
    L8:
        return ((Boolean) Binder.withCleanCallingIdentity(new StarLocation$$ExternalSyntheticLambda2(this))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$registerNetworkLocationUpdates$1() throws Exception {
        logv(INNER_TAG, "request NLP.");
        this.mLocationManager.requestLocationUpdates("network", 1000, 0.0f, this.mExecutor, this.mNetworkLocationListener);
        return true;
    }

    public void unregisterNetworkLocationUpdates() {
        Binder.withCleanCallingIdentity(new StarLocation$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$unregisterNetworkLocationUpdates$2() throws Exception {
        this.mLocationManager.removeUpdates(this.mNetworkLocationListener);
    }

    public boolean updateLastCoarseNlpLocation(Location location) {
        if (location != null) goto L5;
    L25:
        return false;
    L5:
        if (location.isComplete() == false) goto L25;
        if ("network".equals(location.getProvider()) == false) goto L25;
        if (location.getAccuracy() < 150.0f) goto L14;
        this.mIgnoreFakeNlpLocation.set(0);
        this.mLastCoarseNlpLocation.set(new Location(location));
        return false;
    L14:
        if (location.getAccuracy() <= 50.0f) goto L16;
    L24:
        return false;
    L16:
        if (isFakeFineNlpLocation(location) == true) goto L18;
        this.mIgnoreFakeNlpLocation.set(0);
        this.mLastCoarseNlpLocation.set(null);
        goto L24
    L18:
        if (this.mIgnoreFakeNlpLocation.incrementAndGet() <= 3) goto L21;
        this.mIgnoreFakeNlpLocation.set(0);
        this.mLastCoarseNlpLocation.set(null);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "pass fake nlp " + location.toString());
        return false;
    L21:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "ignore fake nlp " + location.toString() + ", count: " + this.mIgnoreFakeNlpLocation.get());
        return true;
    }

    private boolean isFakeFineNlpLocation(Location location) {
        Location last = this.mLastCoarseNlpLocation.get();
        if (last != null) goto L5;
        return false;
    L5:
        if (last.distanceTo(location) >= 50.0f) goto L10;
        return true;
    L10:
        return false;
    }

    public synchronized void convertNlp2Glp(Location nLocation) {
        monitor-enter(this);
        Location gLocation = new Location("gps");     // Catch: Throwable -> L6
        gLocation.setLatitude(nLocation.getLatitude());     // Catch: Throwable -> L6
        gLocation.setLongitude(nLocation.getLongitude());     // Catch: Throwable -> L6
        gLocation.setAccuracy(nLocation.getAccuracy());     // Catch: Throwable -> L6
        gLocation.setAltitude(nLocation.getAltitude());     // Catch: Throwable -> L6
        gLocation.setSpeed(nLocation.getSpeed());     // Catch: Throwable -> L6
        gLocation.setTime(System.currentTimeMillis());     // Catch: Throwable -> L6
        gLocation.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());     // Catch: Throwable -> L6
        Bundle bundle = gLocation.getExtras();     // Catch: Throwable -> L6
        if (bundle != null) goto L8;
        bundle = new Bundle();     // Catch: Throwable -> L6
    L8:
        bundle.putByte(KEY_LOCATION_SOURCE, (byte) 2);     // Catch: Throwable -> L6
        gLocation.setExtras(bundle);     // Catch: Throwable -> L6
        this.mLastNlp2GlpLocation = gLocation;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setAospGnssStatus(boolean status) {
        monitor-enter(this);
        this.mAospGnssStatus.set(status);     // Catch: Throwable -> L6
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "AOSP GNSS status changed: " + status);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getAospGnssStatus() {
        monitor-enter(this);
        boolean r0 = this.mAospGnssStatus.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setActualGnssStatus(boolean status) {
        monitor-enter(this);
        this.mActualGnssStatus.set(status);     // Catch: Throwable -> L6
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "Actual GNSS status changed: " + status);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getActualGnssStatus() {
        monitor-enter(this);
        boolean r0 = this.mActualGnssStatus.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String getCurrentTime() {
        long mNow = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(mNow);
        sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{c, c, c, c, c, c}));
        return sb.toString();
    }

    public String getEncryptedKey() {
        return sEncryptedKey;
    }

    public boolean isCtsGnssTestCaller(int uid, int pid) {
        if (this.mContext != null) goto L5;
        return false;
    L5:
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages != null) goto L8;
        return false;
    L8:
        int r2 = packages.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        String packageName = packages[r3];
        if (CTS_GNSS_TEST_PACKAGE.equals(packageName) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    public String encryptLogs(String message) {
        return EncryptUtil.encrypt(MODULE, message, sEncryptedKey, true);
    }

    public String decryptLogs(String message) {
        return EncryptUtil.decrypt(MODULE, message, sEncryptedKey, true);
    }

    public void loge(String tag, String message) {
        Log.e(TAG, formatLogMessage(tag, message));
    }

    public void logi(String tag, String message) {
        Log.i(TAG, formatLogMessage(tag, message));
    }

    public void logw(String tag, String message) {
        Log.w(TAG, formatLogMessage(tag, message));
    }

    public void logd(String tag, String message) {
        if (this.DEBUG == false) goto L6;
        Log.d(TAG, formatLogMessage(tag, message));
        return;
    }

    public void logv(String tag, String message) {
        if (this.DEBUG == false) goto L6;
        Log.v(TAG, formatLogMessage(tag, message));
        return;
    }

    private String formatLogMessage(String tag, String msg) {
        if (tag != null) goto L4;
        tag = "";
    L4:
        if (msg != null) goto L7;
        msg = "";
    L7:
        return "<" + tag + "> " + msg;
    }
}
