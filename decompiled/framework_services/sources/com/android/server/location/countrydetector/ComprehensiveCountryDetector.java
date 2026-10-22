package com.android.server.location.countrydetector;

import android.content.Context;
import android.location.Country;
import android.location.CountryListener;
import android.location.Geocoder;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.autofill.HintsHelper;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class ComprehensiveCountryDetector extends CountryDetectorBase {
    static final boolean DEBUG = false;
    private static final long LOCATION_REFRESH_INTERVAL = 86400000;
    private static final int MAX_LENGTH_DEBUG_LOGS = 20;
    private static final String TAG = "CountryDetector";
    private int mCountServiceStateChanges;
    private Country mCountry;
    private Country mCountryFromLocation;
    private final ConcurrentLinkedQueue<Country> mDebugLogs;
    private Country mLastCountryAddedToLogs;
    private CountryListener mLocationBasedCountryDetectionListener;
    protected CountryDetectorBase mLocationBasedCountryDetector;
    protected Timer mLocationRefreshTimer;
    private final Object mObject;
    private PhoneStateListener mPhoneStateListener;
    private long mStartTime;
    private long mStopTime;
    private boolean mStopped;
    private final TelephonyManager mTelephonyManager;
    private int mTotalCountServiceStateChanges;
    private long mTotalTime;

    /* JADX INFO: renamed from: -$$Nest$fgetmCountServiceStateChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5208$$Nest$fgetmCountServiceStateChanges(ComprehensiveCountryDetector r0) {
        return r0.mCountServiceStateChanges;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTotalCountServiceStateChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5209$$Nest$fgetmTotalCountServiceStateChanges(ComprehensiveCountryDetector r0) {
        return r0.mTotalCountServiceStateChanges;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCountServiceStateChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5210$$Nest$fputmCountServiceStateChanges(ComprehensiveCountryDetector r0, int r1) {
        r0.mCountServiceStateChanges = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCountryFromLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5211$$Nest$fputmCountryFromLocation(ComprehensiveCountryDetector r0, Country r1) {
        r0.mCountryFromLocation = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTotalCountServiceStateChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5212$$Nest$fputmTotalCountServiceStateChanges(ComprehensiveCountryDetector r0, int r1) {
        r0.mTotalCountServiceStateChanges = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdetectCountry, reason: not valid java name */
    static /* bridge */ /* synthetic */ Country m5213$$Nest$mdetectCountry(ComprehensiveCountryDetector r0, boolean r1, boolean r2) {
        return r0.detectCountry(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misNetworkCountryCodeAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5214$$Nest$misNetworkCountryCodeAvailable(ComprehensiveCountryDetector r0) {
        return r0.isNetworkCountryCodeAvailable();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopLocationBasedDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5215$$Nest$mstopLocationBasedDetector(ComprehensiveCountryDetector r0) {
        r0.stopLocationBasedDetector();
    }

    public ComprehensiveCountryDetector(Context context) {
        super(context);
        this.mStopped = false;
        this.mDebugLogs = new ConcurrentLinkedQueue();
        this.mObject = new Object();
        this.mLocationBasedCountryDetectionListener = new AnonymousClass1(this);
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
    }

    @Override // com.android.server.location.countrydetector.CountryDetectorBase
    public Country detectCountry() {
        return detectCountry(false, !this.mStopped);
    }

    @Override // com.android.server.location.countrydetector.CountryDetectorBase
    public void stop() {
        Slog.i(TAG, "Stop the detector.");
        cancelLocationRefresh();
        removePhoneStateListener();
        stopLocationBasedDetector();
        this.mListener = null;
        this.mStopped = true;
    }

    private Country getCountry() {
        Country result = getNetworkBasedCountry();
        if (result != null) goto L5;
        result = getLastKnownLocationBasedCountry();
    L5:
        if (result != null) goto L7;
        result = getSimBasedCountry();
    L7:
        if (result != null) goto L9;
        result = getLocaleCountry();
    L9:
        addToLogs(result);
        return result;
    }

    private void addToLogs(Country country) {
        if (country != null) goto L4;
        return;
    L4:
        Object r0 = this.mObject;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mLastCountryAddedToLogs != null) goto L9;
    L14:
        this.mLastCountryAddedToLogs = country;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.mDebugLogs.size() < 20) goto L19;
        this.mDebugLogs.poll();
    L19:
        this.mDebugLogs.add(country);
        return;
    L9:
        if (this.mLastCountryAddedToLogs.equals(country) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private boolean isNetworkCountryCodeAvailable() {
        int phoneType = this.mTelephonyManager.getPhoneType();
        if (phoneType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    protected Country getNetworkBasedCountry() {
        if (isNetworkCountryCodeAvailable() == false) goto L8;
        String countryIso = this.mTelephonyManager.getNetworkCountryIso();
        if (TextUtils.isEmpty(countryIso) == false) goto L7;
        return null;
    L7:
        return new Country(countryIso, 0);
    L8:
        return null;
    }

    protected Country getLastKnownLocationBasedCountry() {
        return this.mCountryFromLocation;
    }

    protected Country getSimBasedCountry() {
        String countryIso = this.mTelephonyManager.getSimCountryIso();
        if (TextUtils.isEmpty(countryIso) == false) goto L5;
        return null;
    L5:
        return new Country(countryIso, 2);
    }

    protected Country getLocaleCountry() {
        Locale defaultLocale = Locale.getDefault();
        if (defaultLocale != null) goto L5;
        return null;
    L5:
        return new Country(defaultLocale.getCountry(), 3);
    }

    private Country detectCountry(boolean notifyChange, boolean startLocationBasedDetection) {
        Country country = getCountry();
        if (this.mCountry == null) goto L5;
        Country r1 = new Country(this.mCountry);
    L6:
        runAfterDetectionAsync(r1, country, notifyChange, startLocationBasedDetection);
        this.mCountry = country;
        return this.mCountry;
    L5:
        r1 = this.mCountry;
        goto L6
    }

    protected void runAfterDetectionAsync(final Country country, final Country detectedCountry, final boolean notifyChange, final boolean startLocationBasedDetection) {
        this.mHandler.post(new AnonymousClass2(this, country, detectedCountry, notifyChange, startLocationBasedDetection));
    }

    @Override // com.android.server.location.countrydetector.CountryDetectorBase
    public void setCountryListener(CountryListener listener) {
        CountryListener prevListener = this.mListener;
        this.mListener = listener;
        if (this.mListener != null) goto L5;
        removePhoneStateListener();
        stopLocationBasedDetector();
        cancelLocationRefresh();
        this.mStopTime = SystemClock.elapsedRealtime();
        this.mTotalTime += this.mStopTime;
        return;
    L5:
        if (prevListener != null) goto L9;
        addPhoneStateListener();
        detectCountry(false, true);
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStopTime = 0;
        this.mCountServiceStateChanges = 0;
        return;
    }

    void runAfterDetection(Country country, Country detectedCountry, boolean notifyChange, boolean startLocationBasedDetection) {
        if (notifyChange == false) goto L5;
        notifyIfCountryChanged(country, detectedCountry);
    L5:
        if (startLocationBasedDetection == false) goto L18;
        if (detectedCountry == null) goto L10;
        if (detectedCountry.getSource() <= 1) goto L18;
    L10:
        if (isAirplaneModeOff() == true) goto L14;
        if (isWifiOn() == false) goto L18;
    L14:
        if (this.mListener == null) goto L18;
        if (isGeoCoderImplemented() == false) goto L18;
        startLocationBasedDetector(this.mLocationBasedCountryDetectionListener);
    L18:
        if (detectedCountry != null) goto L20;
    L23:
        scheduleLocationRefresh();
        return;
    L20:
        if (detectedCountry.getSource() >= 1) goto L23;
        cancelLocationRefresh();
        stopLocationBasedDetector();
    }

    private synchronized void startLocationBasedDetector(CountryListener listener) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationBasedCountryDetector == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mLocationBasedCountryDetector = createLocationBasedCountryDetector();     // Catch: Throwable -> L10
        this.mLocationBasedCountryDetector.setCountryListener(listener);     // Catch: Throwable -> L10
        this.mLocationBasedCountryDetector.detectCountry();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private synchronized void stopLocationBasedDetector() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationBasedCountryDetector == null) goto L9;
        this.mLocationBasedCountryDetector.stop();     // Catch: Throwable -> L7
        this.mLocationBasedCountryDetector = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    protected CountryDetectorBase createLocationBasedCountryDetector() {
        return new LocationBasedCountryDetector(this.mContext);
    }

    protected boolean isAirplaneModeOff() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    protected boolean isWifiOn() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "wifi_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void notifyIfCountryChanged(Country country, Country detectedCountry) {
        if (detectedCountry != null) goto L4;
        return;
    L4:
        if (this.mListener == null) goto L11;
        if (country != null) goto L7;
    L8:
        notifyListener(detectedCountry);
        return;
    L7:
        if (country.equals(detectedCountry) == false) goto L8;
        return;
    }

    private synchronized void scheduleLocationRefresh() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationRefreshTimer == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mLocationRefreshTimer = new Timer();     // Catch: Throwable -> L10
        this.mLocationRefreshTimer.schedule(new AnonymousClass3(this), 86400000);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private synchronized void cancelLocationRefresh() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationRefreshTimer == null) goto L9;
        this.mLocationRefreshTimer.cancel();     // Catch: Throwable -> L7
        this.mLocationRefreshTimer = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    protected synchronized void addPhoneStateListener() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mPhoneStateListener != null) goto L9;
        this.mPhoneStateListener = new AnonymousClass4(this);     // Catch: Throwable -> L7
        this.mTelephonyManager.listen(this.mPhoneStateListener, 1);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    protected synchronized void removePhoneStateListener() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mPhoneStateListener == null) goto L9;
        this.mTelephonyManager.listen(this.mPhoneStateListener, 0);     // Catch: Throwable -> L7
        this.mPhoneStateListener = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    protected boolean isGeoCoderImplemented() {
        return Geocoder.isPresent();
    }

    public String toString() {
        long currentTime = SystemClock.elapsedRealtime();
        long currentSessionLength = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("ComprehensiveCountryDetector{");
        if (this.mStopTime != 0) goto L5;
        currentSessionLength = currentTime - this.mStartTime;
        sb.append("timeRunning=" + currentSessionLength + ", ");
    L6:
        sb.append("totalCountServiceStateChanges=" + this.mTotalCountServiceStateChanges + ", ");
        sb.append("currentCountServiceStateChanges=" + this.mCountServiceStateChanges + ", ");
        sb.append("totalTime=" + (this.mTotalTime + currentSessionLength) + ", ");
        sb.append("currentTime=" + currentTime + ", ");
        sb.append("countries=");
        Iterator<Country> r5 = this.mDebugLogs.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Country country = r5.next();
        sb.append("\n   " + country.toString());
        goto L8
    L10:
        sb.append("}");
        return sb.toString();
    L5:
        sb.append("lastRunTimeLength=" + (this.mStopTime - this.mStartTime) + ", ");
        goto L6
    }
}
