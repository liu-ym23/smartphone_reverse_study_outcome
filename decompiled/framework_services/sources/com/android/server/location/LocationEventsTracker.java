package com.android.server.location;

import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationRequest;
import android.location.LocationResult;
import android.location.util.identity.CallerIdentity;
import android.util.EventsUtils;
import com.android.server.ISmtResourceControl;
import com.android.server.pm.PackageManagerService;
import com.bytedance.location.AppLocationUsage;
import com.bytedance.location.GnssPositioning;
import com.bytedance.location.LocationProto;
import com.bytedance.location.LocationProtoData;
import com.bytedance.location.LocationUiOnOffTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class LocationEventsTracker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int IAL_ERROR_CODE_INACTIVE = 4;
    private static final int IAL_ERROR_CODE_MOCK = 3;
    private static final int IAL_ERROR_CODE_NO_ERROR = 0;
    private static final int IAL_ERROR_CODE_NO_NETWORK = 2;
    private static final int IAL_ERROR_CODE_SHORT_POSITION_TIME = 1;
    public static final int IGP_END_TIMESTAMP = 2;
    private static final int IGP_ERROR_CODE_NO_ERROR = 0;
    private static final int IGP_ERROR_CODE_NO_NETWORK = 4;
    private static final int IGP_ERROR_CODE_NO_SIGNAL = 2;
    private static final int IGP_ERROR_CODE_SHORT_POSITION_TIME = 1;
    private static final int IGP_ERROR_CODE_WEAK_SIGNAL = 3;
    public static final int IGP_GLP_TTFF = 8;
    public static final int IGP_GNSS_ERROR_CODE = 10;
    public static final int IGP_GNSS_FIX_CNT = 7;
    public static final int IGP_GNSS_REPORT_INTERVAL = 6;
    public static final int IGP_GNSS_TTFF_CN0 = 9;
    public static final int IGP_LOSE_LOCATION_CN0 = 12;
    public static final int IGP_LOSE_LOCATION_TIMESTAMP = 11;
    public static final int IGP_NMEA_RMC = 15;
    public static final int IGP_NO_GNSS_SIGNAL_TIME = 3;
    public static final int IGP_RESUME_LOCATION_CN0 = 14;
    public static final int IGP_RESUME_LOCATION_TIMESTAMP = 13;
    public static final int IGP_START_TIMESTAMP = 1;
    public static final int IGP_STRONG_GNSS_SIGNAL_TIME = 5;
    public static final int IGP_WEAK_GNSS_SIGNAL_TIME = 4;
    private static final int MAX_NORMAL_STANDALONE_TIME = 40000;
    private static final int MIN_NORMAL_AGNSS_TIME = 4000;
    private static final int MIN_NORMAL_NLP_TIME = 2000;
    private static final String TAG = null;
    private static LocationEventsTracker sInstance;
    private final ConcurrentHashMap<Integer, AppTrackingState> mAppTrackingStates;
    private GnssStatus mCurGnssStatus;
    private final AtomicInteger mGnssFixCnt;
    private final Object mGnssLock;
    private final GnssPositioning.Builder mGnssPositioning;
    private final AtomicBoolean mIsAGnssStarted;
    private final LocationProtoData.Builder mLocationProtoData;
    private final ConcurrentHashMap<Integer, Boolean> mLocationUiMap;
    private final AtomicBoolean mLoseLocation;
    private final AtomicLong mNoSignalCnt;
    private final StarLocation mStarLocation;
    private final AtomicLong mStrongSignalCnt;
    private final AtomicLong mWeakSignalCnt;

    private static class AppTrackingState {
        final AtomicLong activeTime;
        final AtomicLong foregroundTime;
        volatile boolean isActive;
        volatile boolean isForeground;
        volatile long lastActiveStart;
        volatile long lastForegroundStart;
        final AppLocationUsage.Builder mAppLocationUsage;

        /* synthetic */ AppTrackingState(LocationEventsTrackerIA r1) {
            this();
        }

        private AppTrackingState() {
            this.activeTime = new AtomicLong(0);
            this.foregroundTime = new AtomicLong(0);
            this.mAppLocationUsage = AppLocationUsage.newBuilder();
        }
    }

    public static /* synthetic */ AppTrackingState $r8$lambda$gei69tljAVjzRMtLgd6jK4wr6JE(Integer r0) {
        return lambda$recordAppLocationRequest$0(r0);
    }

    static {
        TAG = LocationEventsTracker.class.getSimpleName();
    }

    public static synchronized LocationEventsTracker getInstance() {
        monitor-enter(LocationEventsTracker.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new LocationEventsTracker();     // Catch: Throwable -> L7
    L9:
        LocationEventsTracker r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(LocationEventsTracker.class);
        return r1;
    }

    private LocationEventsTracker() {
        this.mLocationProtoData = LocationProtoData.newBuilder();
        this.mGnssPositioning = GnssPositioning.newBuilder();
        this.mLocationUiMap = new ConcurrentHashMap();
        this.mAppTrackingStates = new ConcurrentHashMap();
        this.mLoseLocation = new AtomicBoolean(false);
        this.mIsAGnssStarted = new AtomicBoolean(false);
        this.mNoSignalCnt = new AtomicLong(0);
        this.mWeakSignalCnt = new AtomicLong(0);
        this.mStrongSignalCnt = new AtomicLong(0);
        this.mGnssFixCnt = new AtomicInteger(0);
        this.mStarLocation = StarLocation.getInstance();
        this.mGnssLock = new Object();
    }

    public void trackLocationUiOnOffTime(boolean on, int userId, long timestamp) {
        Boolean isOn = this.mLocationUiMap.get(Integer.valueOf(userId));
        if (isOn != null) goto L5;
    L7:
        this.mLocationUiMap.put(Integer.valueOf(userId), Boolean.valueOf(on));
        LocationUiOnOffTime.Builder mLocationUiOnOffTime = LocationUiOnOffTime.newBuilder();
        mLocationUiOnOffTime.setUiOn(on).setUserId(userId).setTimestamp(timestamp);
        LocationProtoData.Builder mUiLocationProtoData = LocationProtoData.newBuilder();
        mUiLocationProtoData.setLocationUiOnOffTime(mLocationUiOnOffTime);
        LocationProto.Builder mLocationProto = LocationProto.newBuilder();
        mLocationProto.addLocationProto(mUiLocationProtoData);
        EventsUtils.writePbEvent(timestamp, 18, mLocationProto.build().toByteArray());     // Catch: RuntimeException -> L10
        this.mStarLocation.logv(TAG, "trackLocationUiOnOffTime: " + mLocationProto.build().toString());     // Catch: RuntimeException -> L10
    L12:
        mUiLocationProtoData.clear();
        return;
    L10:
        e = move-exception;
        this.mStarLocation.loge(TAG, "writePbEvent failed: " + e);
        goto L12
    L5:
        if (isOn.booleanValue() != on) goto L7;
    }

    public void trackGnssPositioning(int index, long... args) {
        int r0 = 0;
        Object r4 = this.mGnssLock;
        monitor-enter(r4);
        switch(index) {
            case 1: goto L36;
            case 2: goto L10;
            case 11: goto L9;
            default: goto L6;
        };
    L6:
        this.mStarLocation.logv(TAG, "trackGnssPositioning, index: " + index + " not supported here.");     // Catch: Throwable -> L7
    L41:
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L9:
        this.mLoseLocation.set(true);     // Catch: Throwable -> L7
        this.mGnssPositioning.addLoseLocationTimestamp(args[0]);     // Catch: Throwable -> L7
        trackGnssPositioningLocal(12, new int[0]);     // Catch: Throwable -> L7
        goto L41
    L10:
        this.mGnssPositioning.setStopTimestamp(args[0]);     // Catch: Throwable -> L7
        int interval = this.mGnssPositioning.getGnssReportInterval();     // Catch: Throwable -> L7
        trackGnssPositioningLocal(3, new long[]{this.mNoSignalCnt.get() * ((long) interval)});     // Catch: Throwable -> L7
        trackGnssPositioningLocal(4, new long[]{this.mWeakSignalCnt.get() * ((long) interval)});     // Catch: Throwable -> L7
        trackGnssPositioningLocal(5, new long[]{this.mStrongSignalCnt.get() * ((long) interval)});     // Catch: Throwable -> L7
        trackGnssPositioningLocal(7, new int[]{this.mGnssFixCnt.get()});     // Catch: Throwable -> L7
        if (this.mGnssFixCnt.get() != 0) goto L30;
        float totalSignalCnt = (this.mNoSignalCnt.get() + this.mWeakSignalCnt.get()) + this.mStrongSignalCnt.get();     // Catch: Throwable -> L7
        float noSignalRatio = this.mNoSignalCnt.get() / totalSignalCnt;     // Catch: Throwable -> L7
        float strongSignalRatio = this.mStrongSignalCnt.get() / totalSignalCnt;     // Catch: Throwable -> L7
        if (noSignalRatio >= 0.5f) goto L20;
        if (strongSignalRatio <= 0.3f) goto L20;
        if (strongSignalRatio >= 0.7f) goto L21;
        trackGnssPositioningLocal(10, new int[]{3});     // Catch: Throwable -> L7
    L21:
        long durationMillis = this.mGnssPositioning.getStopTimestamp() - this.mGnssPositioning.getStartTimestamp();     // Catch: Throwable -> L7
        if (durationMillis > 4000) goto L25;
        trackGnssPositioningLocal(10, new int[]{1});     // Catch: Throwable -> L7
    L25:
        if (((this.mNoSignalCnt.get() + this.mWeakSignalCnt.get()) + this.mStrongSignalCnt.get()) != 0) goto L28;
        this.mGnssPositioning.setNoGnssSignalTime(durationMillis);     // Catch: Throwable -> L7
        trackGnssPositioningLocal(10, new int[]{2});     // Catch: Throwable -> L7
    L28:
        if (this.mCurGnssStatus != null) goto L30;
        this.mGnssPositioning.setNoGnssSignalTime(durationMillis);     // Catch: Throwable -> L7
        trackGnssPositioningLocal(10, new int[]{1});     // Catch: Throwable -> L7
    L20:
        trackGnssPositioningLocal(10, new int[]{2});     // Catch: Throwable -> L7
    L30:
        this.mLocationProtoData.setGnssPositioning(this.mGnssPositioning);     // Catch: Throwable -> L7
        LocationProto.Builder mLocationProto = LocationProto.newBuilder();     // Catch: Throwable -> L7
        mLocationProto.addLocationProto(this.mLocationProtoData);     // Catch: Throwable -> L7
        EventsUtils.writePbEvent(args[0], 18, mLocationProto.build().toByteArray());     // Catch: Throwable -> L7 RuntimeException -> L33
        this.mStarLocation.logv(TAG, "track GnssPositioning: " + mLocationProto.build().toString());     // Catch: Throwable -> L7 RuntimeException -> L33
    L35:
        clearGnssPositioning();     // Catch: Throwable -> L7
        goto L41
    L33:
        e = move-exception;
        this.mStarLocation.loge(TAG, "writePbEvent failed: " + e);     // Catch: Throwable -> L7
        goto L35
    L36:
        this.mGnssPositioning.setStartTimestamp(args[0]);     // Catch: Throwable -> L7
        if (this.mStarLocation.isNetworkValid() == true) goto L40;
        r0 = 4;
    L40:
        trackGnssPositioningLocal(10, new int[]{r0});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void recordGnssStatus(GnssStatus gnssStatus, int visibleSvCnt) {
        Object r0 = this.mGnssLock;
        monitor-enter(r0);
        this.mCurGnssStatus = gnssStatus;     // Catch: Throwable -> L8
        if (visibleSvCnt <= 3) goto L10;
        if (visibleSvCnt >= 8) goto L10;
        this.mWeakSignalCnt.incrementAndGet();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (visibleSvCnt < 8) goto L12;
        this.mStrongSignalCnt.incrementAndGet();     // Catch: Throwable -> L8
        goto L13
    L12:
        this.mNoSignalCnt.incrementAndGet();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void recordGnssLocation(boolean hasLatLong, Location location) {
        if (hasLatLong == false) goto L11;
        if (location != null) goto L6;
        return;
    L6:
        if (location.isComplete() == false) goto L13;
        this.mGnssFixCnt.incrementAndGet();
        if (this.mLoseLocation.get() == false) goto L14;
        trackGnssPositioningLocal(13, new long[]{System.currentTimeMillis()});
        this.mLoseLocation.set(false);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void clearGnssPositioning() {
        this.mNoSignalCnt.set(0);
        this.mWeakSignalCnt.set(0);
        this.mStrongSignalCnt.set(0);
        this.mGnssFixCnt.set(0);
        this.mLoseLocation.set(false);
        Object r0 = this.mGnssLock;
        monitor-enter(r0);
        this.mGnssPositioning.clear();     // Catch: Throwable -> L7
        this.mLocationProtoData.clear();     // Catch: Throwable -> L7
        this.mCurGnssStatus = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void trackGnssPositioningLocal(int index, int... args) {
        Object r0 = this.mGnssLock;
        monitor-enter(r0);
        switch(index) {
            case 7: goto L92;
            case 8: goto L6;
            case 9: goto L81;
            case 10: goto L79;
            case 11: goto L6;
            case 12: goto L45;
            case 13: goto L6;
            case 14: goto L10;
            default: goto L6;
        };
    L6:
        this.mStarLocation.logv(TAG, "trackGnssPositioningLocal, index: " + index + " not supported here.");     // Catch: Throwable -> L7
    L93:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L79:
        this.mGnssPositioning.setGnssErrorCode(args[0]);     // Catch: Throwable -> L7
        goto L93
    L92:
        this.mGnssPositioning.setGnssFixCnt(args[0]);     // Catch: Throwable -> L7
        goto L93
    L10:
        if (this.mCurGnssStatus != null) goto L15;
        this.mStarLocation.logv(TAG, "Not yet get GnssStatus, index: " + index);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L15:
        if (this.mGnssPositioning.getResumeLocationCn0Count() <= 0) goto L17;
        this.mGnssPositioning.addResumeLocationCn0(0.0f);     // Catch: Throwable -> L7
    L17:
        String resumeInfo = "resume location, record the latest SV status:\n";
        int SvCount2 = this.mCurGnssStatus.getSatelliteCount();     // Catch: Throwable -> L7
        int i = 0;
    L18:
        if (i >= SvCount2) goto L43;
        float cn0 = this.mCurGnssStatus.getCn0DbHz(i);     // Catch: Throwable -> L7
        if (cn0 <= 0.0f) goto L42;
        this.mGnssPositioning.addResumeLocationCn0(cn0);     // Catch: Throwable -> L7
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L7
        r6.append(resumeInfo);     // Catch: Throwable -> L7
        r6.append("svid: ");     // Catch: Throwable -> L7
        r6.append(this.mCurGnssStatus.getSvid(i));     // Catch: Throwable -> L7
        r6.append(" cn0: ");     // Catch: Throwable -> L7
        r6.append(this.mCurGnssStatus.getCn0DbHz(i));     // Catch: Throwable -> L7
        r6.append(" elev: ");     // Catch: Throwable -> L7
        r6.append(this.mCurGnssStatus.getElevationDegrees(i));     // Catch: Throwable -> L7
        r6.append(" azimuth: ");     // Catch: Throwable -> L7
        r6.append(this.mCurGnssStatus.getAzimuthDegrees(i));     // Catch: Throwable -> L7
        r6.append(" carrier frequency: ");     // Catch: Throwable -> L7
        r6.append(this.mCurGnssStatus.getCarrierFrequencyHz(i));     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasEphemerisData(i) == false) goto L24;
        String r7 = " E";
    L25:
        r6.append(r7);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasAlmanacData(i) == false) goto L28;
        String r8 = " A";
    L29:
        r6.append(r8);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.usedInFix(i) == false) goto L32;
        String r9 = "U";
    L33:
        r6.append(r9);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasCarrierFrequencyHz(i) == false) goto L36;
        String r10 = "F";
    L37:
        r6.append(r10);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasBasebandCn0DbHz(i) == false) goto L40;
        String r11 = "B";
    L41:
        r6.append(r11);     // Catch: Throwable -> L7
        resumeInfo = r6.toString();     // Catch: Throwable -> L7
        goto L42
    L40:
        r11 = "";
        goto L41
    L36:
        r10 = "";
        goto L37
    L32:
        r9 = "";
        goto L33
    L28:
        r8 = "  ";
        goto L29
    L24:
        r7 = "  ";
    L42:
        i = i + 1;     // Catch: Throwable -> L7
        goto L18
    L43:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, resumeInfo);     // Catch: Throwable -> L7
        goto L93
    L45:
        if (this.mCurGnssStatus != null) goto L50;
        this.mStarLocation.logv(TAG, "Not yet get GnssStatus, index: " + index);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L50:
        if (this.mGnssPositioning.getLoseLocationCn0Count() <= 0) goto L52;
        this.mGnssPositioning.addLoseLocationCn0(0.0f);     // Catch: Throwable -> L7
    L52:
        String loseInfo = "lose location, record the latest SV status:\n";
        int SvCount1 = this.mCurGnssStatus.getSatelliteCount();     // Catch: Throwable -> L7
        int i2 = 0;
    L53:
        if (i2 >= SvCount1) goto L78;
        float cn1 = this.mCurGnssStatus.getCn0DbHz(i2);     // Catch: Throwable -> L7
        if (cn1 <= 0.0f) goto L57;
        this.mGnssPositioning.addLoseLocationCn0(cn1);     // Catch: Throwable -> L7
    L57:
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L7
        r12.append(loseInfo);     // Catch: Throwable -> L7
        r12.append("svid: ");     // Catch: Throwable -> L7
        r12.append(this.mCurGnssStatus.getSvid(i2));     // Catch: Throwable -> L7
        r12.append(" cn0: ");     // Catch: Throwable -> L7
        r12.append(this.mCurGnssStatus.getCn0DbHz(i2));     // Catch: Throwable -> L7
        r12.append(" elev: ");     // Catch: Throwable -> L7
        r12.append(this.mCurGnssStatus.getElevationDegrees(i2));     // Catch: Throwable -> L7
        r12.append(" azimuth: ");     // Catch: Throwable -> L7
        r12.append(this.mCurGnssStatus.getAzimuthDegrees(i2));     // Catch: Throwable -> L7
        r12.append(" carrier frequency: ");     // Catch: Throwable -> L7
        r12.append(this.mCurGnssStatus.getCarrierFrequencyHz(i2));     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasEphemerisData(i2) == false) goto L60;
        String r13 = " E";
    L61:
        r12.append(r13);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasAlmanacData(i2) == false) goto L64;
        String r14 = " A";
    L65:
        r12.append(r14);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.usedInFix(i2) == false) goto L68;
        String r15 = "U";
    L69:
        r12.append(r15);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasCarrierFrequencyHz(i2) == false) goto L72;
        String r16 = "F";
    L73:
        r12.append(r16);     // Catch: Throwable -> L7
        if (this.mCurGnssStatus.hasBasebandCn0DbHz(i2) == false) goto L76;
        String r17 = "B";
    L77:
        r12.append(r17);     // Catch: Throwable -> L7
        loseInfo = r12.toString();     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L53
    L76:
        r17 = "";
        goto L77
    L72:
        r16 = "";
        goto L73
    L68:
        r15 = "";
        goto L69
    L64:
        r14 = "  ";
        goto L65
    L60:
        r13 = "  ";
        goto L61
    L78:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, loseInfo);     // Catch: Throwable -> L7
        goto L93
    L81:
        if (this.mCurGnssStatus != null) goto L85;
        this.mStarLocation.logv(TAG, "Not yet get GnssStatus, index: " + index);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L85:
        int SvCount = this.mCurGnssStatus.getSatelliteCount();     // Catch: Throwable -> L7
        int i3 = 0;
    L86:
        if (i3 >= SvCount) goto L93;
        float cn2 = this.mCurGnssStatus.getCn0DbHz(i3);     // Catch: Throwable -> L7
        if (cn2 <= 0.0f) goto L90;
        this.mGnssPositioning.addGnssTtffCn0(cn2);     // Catch: Throwable -> L7
    L90:
        i3 = i3 + 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void trackGnssPositioningLocal(int index, long... args) {
        Object r0 = this.mGnssLock;
        monitor-enter(r0);
        switch(index) {
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 13: goto L9;
            default: goto L6;
        };
    L6:
        this.mStarLocation.logv(TAG, "trackGnssPositioningLocal, index: " + index + " not supported here.");     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mGnssPositioning.addResumeLocationTimestamp(args[0]);     // Catch: Throwable -> L7
        trackGnssPositioningLocal(14, new int[0]);     // Catch: Throwable -> L7
        goto L13
    L10:
        this.mGnssPositioning.setStrongGnssSignalTime(args[0]);     // Catch: Throwable -> L7
        goto L13
    L11:
        this.mGnssPositioning.setWeakGnssSignalTime(args[0]);     // Catch: Throwable -> L7
        goto L13
    L12:
        this.mGnssPositioning.setNoGnssSignalTime(args[0]);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void trackGnssPositioning(int index, int... args) {
        Object r0 = this.mGnssLock;
        monitor-enter(r0);
        switch(index) {
            case 6: goto L17;
            case 7: goto L6;
            case 8: goto L9;
            default: goto L6;
        };
    L6:
        this.mStarLocation.logv(TAG, "trackGnssPositioning, index: " + index + " not supported here.");     // Catch: Throwable -> L7
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mGnssPositioning.setGlpTtff(args[0]);     // Catch: Throwable -> L7
        trackGnssPositioningLocal(9, new int[0]);     // Catch: Throwable -> L7
        if (args[0] <= MIN_NORMAL_AGNSS_TIME) goto L25;
        if (this.mIsAGnssStarted.get() == true) goto L25;
        if (args[0] >= 40000) goto L25;
        trackGnssPositioningLocal(10, new int[]{4});     // Catch: Throwable -> L7
        goto L25
    L17:
        if (this.mGnssPositioning.hasStartTimestamp() == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L20:
        GnssPositioning.Builder r2 = this.mGnssPositioning;     // Catch: Throwable -> L7
        int r4 = 1000;
        if (args[0] < 1000) goto L24;
        r4 = args[0];     // Catch: Throwable -> L7
    L24:
        r2.setGnssReportInterval(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void trackGnssPositioning(int index, String... args) {
        switch(index) {
            case 15: goto L5;
            default: goto L3;
        };
    L3:
        this.mStarLocation.logv(TAG, "trackGnssPositioning, index: " + index + " not supported here.");
        return;
    L5:
        if (this.mGnssFixCnt.get() != 0) goto L7;
        return;
    L7:
        String mNmeaRMC = extractValidRmc(args[0]);
        if (mNmeaRMC != null) goto L10;
        return;
    L10:
        if (mNmeaRMC.isEmpty() == true) goto L23;
        Object r1 = this.mGnssLock;
        monitor-enter(r1);
        this.mGnssPositioning.addNmeaRmc(mNmeaRMC);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private String extractValidRmc(String nmeaData) {
        String[] rmcTypes = {"$GNRMC", "$GPRMC", "$BDRMC"};
        int r1 = rmcTypes.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L16;
        String type = rmcTypes[r2];
        int startIndex = nmeaData.indexOf(type);
        if (startIndex == (-1)) goto L15;
        int endIndex = nmeaData.indexOf("$", startIndex + 1);
        if (endIndex != (-1)) goto L9;
        String candidate = nmeaData.substring(startIndex);
    L10:
        String[] fields = candidate.split(",");
        if (fields.length < 3) goto L15;
        if ("A".equals(fields[2]) == false) goto L15;
        return candidate;
    L9:
        candidate = nmeaData.substring(startIndex, endIndex);
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return "";
    }

    public void recordAppLocationRequest(String name, boolean isMock, CallerIdentity identity, LocationRequest request) {
        if ("passive".equals(name) == false) goto L5;
        return;
    L5:
        if ("passive".equals(request.getProvider()) == false) goto L7;
        return;
    L7:
        if (request.getIntervalMillis() == Long.MAX_VALUE) goto L35;
        long timestamp = System.currentTimeMillis();
        this.mIsAGnssStarted.set(this.mStarLocation.isNetworkValid());
        int hashCode = identity.getListenerId().hashCode();
        String packageName = identity.getPackageName();
        String attributionTag = identity.getAttributionTag();
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L15;
        if (attributionTag == null) goto L15;
        if (attributionTag.isEmpty() == true) goto L15;
        packageName = packageName + "[" + attributionTag + "]";
    L15:
        long interval = request.getIntervalMillis();
        AppTrackingState appTrackingState = this.mAppTrackingStates.computeIfAbsent(Integer.valueOf(hashCode), new LocationEventsTracker$$ExternalSyntheticLambda0());
        appTrackingState.mAppLocationUsage.setStartTimestamp(timestamp).setAppPackageName(packageName).setRequestInterval(interval).setLocationProvider(name).setErrorCode(0);
        if (isMock == false) goto L19;
        appTrackingState.mAppLocationUsage.setLocationProvider("mock").setErrorCode(3);
        return;
    L19:
        if ("network".equals(appTrackingState.mAppLocationUsage.getLocationProvider()) == false) goto L24;
        if (this.mStarLocation.isNetworkValid() == true) goto L24;
        appTrackingState.mAppLocationUsage.setErrorCode(2);
        return;
    L24:
        if ("gps".equals(appTrackingState.mAppLocationUsage.getLocationProvider()) == true) goto L26;
        return;
    L26:
        if (this.mIsAGnssStarted.get() == true) goto L33;
        appTrackingState.mAppLocationUsage.setErrorCode(2);
        return;
    L33:
        return;
    }

    private static /* synthetic */ AppTrackingState lambda$recordAppLocationRequest$0(Integer k) {
        return new AppTrackingState(null);
    }

    public void recordRegistrationActive(CallerIdentity identity, boolean active) {
        int hashCode = identity.getListenerId().hashCode();
        AppTrackingState appTrackingState = this.mAppTrackingStates.get(Integer.valueOf(hashCode));
        if (appTrackingState != null) goto L5;
        return;
    L5:
        if (appTrackingState.isActive == active) goto L13;
        if (active == false) goto L9;
        appTrackingState.lastActiveStart = System.currentTimeMillis();
        appTrackingState.isActive = true;
        return;
    L9:
        appTrackingState.activeTime.addAndGet(System.currentTimeMillis() - appTrackingState.lastActiveStart);
        appTrackingState.isActive = false;
        return;
    }

    public void recordRegistrationForeground(CallerIdentity identity, boolean foreground) {
        int hashCode = identity.getListenerId().hashCode();
        AppTrackingState appTrackingState = this.mAppTrackingStates.get(Integer.valueOf(hashCode));
        if (appTrackingState != null) goto L5;
        return;
    L5:
        if (appTrackingState.isForeground == foreground) goto L13;
        if (foreground == false) goto L9;
        appTrackingState.lastForegroundStart = System.currentTimeMillis();
        appTrackingState.isForeground = true;
        return;
    L9:
        appTrackingState.foregroundTime.addAndGet(System.currentTimeMillis() - appTrackingState.lastForegroundStart);
        appTrackingState.isForeground = false;
        return;
    }

    public void removeAppLocationRequest(CallerIdentity identity) {
        int hashCode = identity.getListenerId().hashCode();
        AppTrackingState appTrackingState = this.mAppTrackingStates.get(Integer.valueOf(hashCode));
        if (appTrackingState != null) goto L5;
        return;
    L5:
        if (appTrackingState.mAppLocationUsage == null) goto L70;
        long now = System.currentTimeMillis();
        appTrackingState.mAppLocationUsage.setStopTimestamp(now);
        appTrackingState.mAppLocationUsage.setTotalTime(now - appTrackingState.mAppLocationUsage.getStartTimestamp());
        if (appTrackingState.isActive == false) goto L10;
        appTrackingState.activeTime.addAndGet(now - appTrackingState.lastActiveStart);
    L10:
        appTrackingState.mAppLocationUsage.setActiveTime(appTrackingState.activeTime.get());
        if (appTrackingState.isForeground == false) goto L13;
        appTrackingState.foregroundTime.addAndGet(now - appTrackingState.lastForegroundStart);
    L13:
        appTrackingState.mAppLocationUsage.setForegroundTime(appTrackingState.foregroundTime.get());
        long interval = appTrackingState.mAppLocationUsage.getRequestInterval();
        long act_interval = 1000;
        if (interval <= 1000) goto L18;
        act_interval = interval;
    L18:
        if (appTrackingState.mAppLocationUsage.hasAppTtff() == false) goto L33;
        if ("gps".equals(appTrackingState.mAppLocationUsage.getLocationProvider()) == false) goto L49;
        if (((now - appTrackingState.mAppLocationUsage.getStartTimestamp()) - appTrackingState.mAppLocationUsage.getAppTtff()) < (3 * act_interval)) goto L24;
        appTrackingState.mAppLocationUsage.setHasNavReq(true);
    L26:
        if (appTrackingState.mAppLocationUsage.getAppTtff() < 4000) goto L49;
        if (appTrackingState.mAppLocationUsage.getAppTtff() >= 40000) goto L49;
        if (this.mIsAGnssStarted.get() == true) goto L49;
        appTrackingState.mAppLocationUsage.setErrorCode(2);
        goto L49
    L24:
        appTrackingState.mAppLocationUsage.setHasNavReq(false);
    L49:
        if ((appTrackingState.mAppLocationUsage.getActiveTime() / appTrackingState.mAppLocationUsage.getTotalTime()) >= 0.5f) goto L51;
        appTrackingState.mAppLocationUsage.setErrorCode(4);
    L51:
        Object r10 = this.mGnssLock;
        monitor-enter(r10);
        this.mLocationProtoData.setAppLocationUsage(appTrackingState.mAppLocationUsage);     // Catch: Throwable -> L56
        LocationProto.Builder mLocationProto = LocationProto.newBuilder();     // Catch: Throwable -> L56
        mLocationProto.addLocationProto(this.mLocationProtoData);     // Catch: Throwable -> L56
        EventsUtils.writePbEvent(now, 18, mLocationProto.build().toByteArray());     // Catch: Throwable -> L56 RuntimeException -> L58
        this.mStarLocation.logv(TAG, "track AppLocationUsage: " + mLocationProto.build().toString());     // Catch: Throwable -> L56 RuntimeException -> L58
    L60:
        this.mAppTrackingStates.remove(Integer.valueOf(hashCode));     // Catch: Throwable -> L56
        this.mLocationProtoData.clear();     // Catch: Throwable -> L56
        monitor-exit(r10);     // Catch: Throwable -> L56
        return;
    L58:
        e = move-exception;
        this.mStarLocation.loge(TAG, "writePbEvent failed: " + e);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    L33:
        if ("network".equals(appTrackingState.mAppLocationUsage.getLocationProvider()) == false) goto L41;
        if (this.mStarLocation.isNetworkValid() == true) goto L38;
        appTrackingState.mAppLocationUsage.setErrorCode(2);
        goto L49
    L38:
        if (appTrackingState.mAppLocationUsage.getTotalTime() > ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L49;
        appTrackingState.mAppLocationUsage.setErrorCode(1);
        goto L49
    L41:
        if ("gps".equals(appTrackingState.mAppLocationUsage.getLocationProvider()) == false) goto L49;
        if (this.mIsAGnssStarted.get() == true) goto L46;
        appTrackingState.mAppLocationUsage.setErrorCode(2);
        goto L49
    L46:
        if (appTrackingState.mAppLocationUsage.getTotalTime() > 4000) goto L49;
        appTrackingState.mAppLocationUsage.setErrorCode(1);
        goto L49
    }

    public void recordLocationDeliever(CallerIdentity identity, LocationResult deliverLocationResult) {
        int hashCode = identity.getListenerId().hashCode();
        AppTrackingState appTrackingState = this.mAppTrackingStates.get(Integer.valueOf(hashCode));
        if (appTrackingState != null) goto L5;
        return;
    L5:
        if (appTrackingState.mAppLocationUsage == null) goto L13;
        int receivedCount = appTrackingState.mAppLocationUsage.getLocationReceived();
        if (receivedCount != 0) goto L10;
        appTrackingState.mAppLocationUsage.setAppTtff(System.currentTimeMillis() - appTrackingState.mAppLocationUsage.getStartTimestamp());
    L10:
        appTrackingState.mAppLocationUsage.setLocationReceived(deliverLocationResult.size() + receivedCount);
        return;
    }
}
