package com.android.server.location.gnss.hal;

import android.location.GnssAntennaInfo;
import android.location.GnssAssistance;
import android.location.GnssCapabilities;
import android.location.GnssMeasurementCorrections;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssSignalType;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.location.GPOStateMachine;
import com.android.server.location.LocationEventsTracker;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.StarLocation;
import com.android.server.location.gnss.GnssConfiguration;
import com.android.server.location.gnss.GnssManagerService;
import com.android.server.location.gnss.GnssPowerStats;
import com.android.server.location.injector.EmergencyHelper;
import com.android.server.location.injector.Injector;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class GnssNative {
    public static final int AGPS_REF_LOCATION_TYPE_GSM_CELLID = 1;
    public static final int AGPS_REF_LOCATION_TYPE_LTE_CELLID = 4;
    public static final int AGPS_REF_LOCATION_TYPE_NR_CELLID = 8;
    public static final int AGPS_REF_LOCATION_TYPE_UMTS_CELLID = 2;
    public static final int AGPS_SETID_TYPE_IMSI = 1;
    public static final int AGPS_SETID_TYPE_MSISDN = 2;
    public static final int AGPS_SETID_TYPE_NONE = 0;
    public static final int GNSS_AIDING_TYPE_ALL = 65535;
    public static final int GNSS_AIDING_TYPE_ALMANAC = 2;
    public static final int GNSS_AIDING_TYPE_CELLDB_INFO = 32768;
    public static final int GNSS_AIDING_TYPE_EPHEMERIS = 1;
    public static final int GNSS_AIDING_TYPE_HEALTH = 64;
    public static final int GNSS_AIDING_TYPE_IONO = 16;
    public static final int GNSS_AIDING_TYPE_POSITION = 4;
    public static final int GNSS_AIDING_TYPE_RTI = 1024;
    public static final int GNSS_AIDING_TYPE_SADATA = 512;
    public static final int GNSS_AIDING_TYPE_SVDIR = 128;
    public static final int GNSS_AIDING_TYPE_SVSTEER = 256;
    public static final int GNSS_AIDING_TYPE_TIME = 8;
    public static final int GNSS_AIDING_TYPE_UTC = 32;
    public static final int GNSS_LOCATION_HAS_ALTITUDE = 2;
    public static final int GNSS_LOCATION_HAS_BEARING = 8;
    public static final int GNSS_LOCATION_HAS_BEARING_ACCURACY = 128;
    public static final int GNSS_LOCATION_HAS_HORIZONTAL_ACCURACY = 16;
    public static final int GNSS_LOCATION_HAS_LAT_LONG = 1;
    public static final int GNSS_LOCATION_HAS_SPEED = 4;
    public static final int GNSS_LOCATION_HAS_SPEED_ACCURACY = 64;
    public static final int GNSS_LOCATION_HAS_VERTICAL_ACCURACY = 32;
    public static final int GNSS_POSITION_MODE_MS_ASSISTED = 2;
    public static final int GNSS_POSITION_MODE_MS_BASED = 1;
    public static final int GNSS_POSITION_MODE_STANDALONE = 0;
    public static final int GNSS_POSITION_RECURRENCE_PERIODIC = 0;
    public static final int GNSS_POSITION_RECURRENCE_SINGLE = 1;
    public static final int GNSS_REALTIME_HAS_TIMESTAMP_NS = 1;
    public static final int GNSS_REALTIME_HAS_TIME_UNCERTAINTY_NS = 2;
    private static final float ITAR_SPEED_LIMIT_METERS_PER_SECOND = 400.0f;
    private static final int POWER_STATS_REQUEST_TIMEOUT_MILLIS = 100;
    private static GnssHal sGnssHal;
    private static boolean sGnssHalInitialized;
    private static GnssNative sInstance;
    private AGpsCallbacks mAGpsCallbacks;
    private AntennaInfoCallbacks[] mAntennaInfoCallbacks;
    private BaseCallbacks[] mBaseCallbacks;
    private GnssCapabilities mCapabilities;
    private final GnssConfiguration mConfiguration;
    private final EmergencyHelper mEmergencyHelper;
    private GeofenceCallbacks mGeofenceCallbacks;
    private GnssAssistanceCallbacks mGnssAssistanceCallbacks;
    private final GnssHal mGnssHal;
    private final Handler mHandler;
    private String mHardwareModelName;
    private int mHardwareYear;
    private boolean mHasFirstFix;
    private volatile boolean mItarSpeedLimitExceeded;
    private GnssPowerStats mLastKnownPowerStats;
    private LocationCallbacks[] mLocationCallbacks;
    private LocationRequestCallbacks mLocationRequestCallbacks;
    private MeasurementCallbacks[] mMeasurementCallbacks;
    private NavigationMessageCallbacks[] mNavigationMessageCallbacks;
    private NmeaCallbacks[] mNmeaCallbacks;
    private NotificationCallbacks mNotificationCallbacks;
    private final List<PowerStatsCallback> mPendingPowerStatsCallbacks;
    private final Object mPowerStatsLock;
    private final Runnable mPowerStatsTimeoutCallback;
    private PsdsCallbacks mPsdsCallbacks;
    private boolean mRegistered;
    private long mStartRealtimeMs;
    private StatusCallbacks[] mStatusCallbacks;
    private SvStatusCallbacks[] mSvStatusCallbacks;
    private TimeCallbacks mTimeCallbacks;
    private int mTopFlags;

    public interface AGpsCallbacks {
        public static final int AGPS_REQUEST_SETID_IMSI = 1;
        public static final int AGPS_REQUEST_SETID_MSISDN = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AgpsSetIdFlags {
        }

        void onReportAGpsStatus(int r1, int r2, byte[] r3);

        void onRequestSetID(int r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AgpsReferenceLocationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AgpsSetIdType {
    }

    public interface AntennaInfoCallbacks {
        void onReportAntennaInfo(List<GnssAntennaInfo> r1);
    }

    public interface BaseCallbacks {
        void onHalRestarted();

        default void onHalStarted() {
        }

        default void onCapabilitiesChanged(GnssCapabilities oldCapabilities, GnssCapabilities newCapabilities) {
        }
    }

    public interface GeofenceCallbacks {
        public static final int GEOFENCE_AVAILABILITY_AVAILABLE = 2;
        public static final int GEOFENCE_AVAILABILITY_UNAVAILABLE = 1;
        public static final int GEOFENCE_STATUS_ERROR_GENERIC = -149;
        public static final int GEOFENCE_STATUS_ERROR_ID_EXISTS = -101;
        public static final int GEOFENCE_STATUS_ERROR_ID_UNKNOWN = -102;
        public static final int GEOFENCE_STATUS_ERROR_INVALID_TRANSITION = -103;
        public static final int GEOFENCE_STATUS_ERROR_TOO_MANY_GEOFENCES = 100;
        public static final int GEOFENCE_STATUS_OPERATION_SUCCESS = 0;
        public static final int GEOFENCE_TRANSITION_ENTERED = 1;
        public static final int GEOFENCE_TRANSITION_EXITED = 2;
        public static final int GEOFENCE_TRANSITION_UNCERTAIN = 4;

        @Retention(RetentionPolicy.SOURCE)
        public @interface GeofenceAvailability {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface GeofenceStatus {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface GeofenceTransition {
        }

        void onReportGeofenceAddStatus(int r1, int r2);

        void onReportGeofencePauseStatus(int r1, int r2);

        void onReportGeofenceRemoveStatus(int r1, int r2);

        void onReportGeofenceResumeStatus(int r1, int r2);

        void onReportGeofenceStatus(int r1, Location r2);

        void onReportGeofenceTransition(int r1, Location r2, int r3, long r4);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GnssAidingTypeFlags {
    }

    public interface GnssAssistanceCallbacks {
        void onRequestGnssAssistanceInject();
    }

    public static class GnssHal {
        protected GnssHal() {
        }

        protected void classInitOnce() {
            GnssNative.m5331$$Nest$smnative_class_init_once();
        }

        protected boolean isSupported() {
            return GnssNative.m5353$$Nest$smnative_is_supported();
        }

        protected void initOnce(GnssNative gnssNative, boolean reinitializeGnssServiceHandle) {
            GnssNative.m5327$$Nest$mnative_init_once(gnssNative, reinitializeGnssServiceHandle);
        }

        protected boolean init() {
            return GnssNative.m5338$$Nest$smnative_init();
        }

        protected void cleanup() {
            GnssNative.m5332$$Nest$smnative_cleanup();
        }

        protected boolean start() {
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "start(): " + StarLocation.getInstance().getActualGnssStatus() + ", " + StarLocation.getInstance().getAospGnssStatus() + ", " + GPOStateMachine.getGpoStateMachine().getCurState());
            if (StarLocation.getInstance().getAospGnssStatus() == true) goto L5;
        L13:
            return true;
        L5:
            if (GPOStateMachine.getGpoStateMachine().getCurState() != 5) goto L7;
        L8:
            boolean ret = GnssNative.m5361$$Nest$smnative_start();
            if (ret == false) goto L11;
            StarLocation.getInstance().setActualGnssStatus(true);
        L11:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GNSS HAL started");
            return ret;
        L7:
            if (GPOStateMachine.getGpoStateMachine().disableFeature() == false) goto L13;
            goto L8
        }

        protected boolean stop() {
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "stop(): " + StarLocation.getInstance().getActualGnssStatus() + ", " + StarLocation.getInstance().getAospGnssStatus() + ", " + GPOStateMachine.getGpoStateMachine().getCurState());
            if (StarLocation.getInstance().getAospGnssStatus() == true) goto L14;
            if (GPOStateMachine.getGpoStateMachine().getCurState() != 0) goto L7;
        L8:
            boolean ret = GnssNative.m5368$$Nest$smnative_stop();
            if (ret == false) goto L11;
            StarLocation.getInstance().setActualGnssStatus(false);
        L11:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GNSS HAL stopped");
            GPOStateMachine sm = GPOStateMachine.getGpoStateMachine();
            Message msg = sm.obtainMessage(8);
            sm.sendMessage(msg);
            return ret;
        L7:
            if (GPOStateMachine.getGpoStateMachine().disableFeature() == true) goto L8;
        L14:
            if (StarLocation.getInstance().getActualGnssStatus() == true) goto L16;
            return true;
        L16:
            if (StarLocation.getInstance().getAospGnssStatus() == true) goto L18;
            return true;
        L18:
            if (GPOStateMachine.getGpoStateMachine().getCurState() == 6) goto L20;
            return true;
        L20:
            if (GnssNative.m5368$$Nest$smnative_stop() == false) goto L22;
            StarLocation.getInstance().setActualGnssStatus(false);
        L22:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GNSS HAL controlled");
            return true;
        }

        protected boolean setPositionMode(int mode, int recurrence, int minInterval, int preferredAccuracy, int preferredTime, boolean lowPowerMode) {
            return GnssNative.m5360$$Nest$smnative_set_position_mode(mode, recurrence, minInterval, preferredAccuracy, preferredTime, lowPowerMode);
        }

        protected String getInternalState() {
            return GnssNative.m5337$$Nest$smnative_get_internal_state();
        }

        protected void deleteAidingData(int flags) {
            GnssNative.m5334$$Nest$smnative_delete_aiding_data(flags);
        }

        protected int readNmea(byte[] buffer, int bufferSize) {
            return GnssNative.m5355$$Nest$smnative_read_nmea(buffer, bufferSize);
        }

        protected void injectLocation(int gnssLocationFlags, double latitude, double longitude, double altitude, float speed, float bearing, float horizontalAccuracy, float verticalAccuracy, float speedAccuracy, float bearingAccuracy, long timestamp, int elapsedRealtimeFlags, long elapsedRealtimeNanos, double elapsedRealtimeUncertaintyNanos) {
            GnssNative.m5342$$Nest$smnative_inject_location(gnssLocationFlags, latitude, longitude, altitude, speed, bearing, horizontalAccuracy, verticalAccuracy, speedAccuracy, bearingAccuracy, timestamp, elapsedRealtimeFlags, elapsedRealtimeNanos, elapsedRealtimeUncertaintyNanos);
        }

        protected void injectBestLocation(int gnssLocationFlags, double latitude, double longitude, double altitude, float speed, float bearing, float horizontalAccuracy, float verticalAccuracy, float speedAccuracy, float bearingAccuracy, long timestamp, int elapsedRealtimeFlags, long elapsedRealtimeNanos, double elapsedRealtimeUncertaintyNanos) {
            GnssNative.m5340$$Nest$smnative_inject_best_location(gnssLocationFlags, latitude, longitude, altitude, speed, bearing, horizontalAccuracy, verticalAccuracy, speedAccuracy, bearingAccuracy, timestamp, elapsedRealtimeFlags, elapsedRealtimeNanos, elapsedRealtimeUncertaintyNanos);
        }

        protected void injectTime(long time, long timeReference, int uncertainty) {
            GnssNative.m5346$$Nest$smnative_inject_time(time, timeReference, uncertainty);
        }

        protected boolean isNavigationMessageCollectionSupported() {
            return GnssNative.m5352$$Nest$smnative_is_navigation_message_supported();
        }

        protected boolean startNavigationMessageCollection() {
            return GnssNative.m5365$$Nest$smnative_start_navigation_message_collection();
        }

        protected boolean stopNavigationMessageCollection() {
            return GnssNative.m5372$$Nest$smnative_stop_navigation_message_collection();
        }

        protected boolean isAntennaInfoSupported() {
            return GnssNative.m5347$$Nest$smnative_is_antenna_info_supported();
        }

        protected boolean startAntennaInfoListening() {
            return GnssNative.m5362$$Nest$smnative_start_antenna_info_listening();
        }

        protected boolean stopAntennaInfoListening() {
            return GnssNative.m5369$$Nest$smnative_stop_antenna_info_listening();
        }

        protected boolean isMeasurementSupported() {
            return GnssNative.m5351$$Nest$smnative_is_measurement_supported();
        }

        protected boolean startMeasurementCollection(boolean enableFullTracking, boolean enableCorrVecOutputs, int intervalMillis) {
            return GnssNative.m5364$$Nest$smnative_start_measurement_collection(enableFullTracking, enableCorrVecOutputs, intervalMillis);
        }

        protected boolean stopMeasurementCollection() {
            return GnssNative.m5371$$Nest$smnative_stop_measurement_collection();
        }

        protected boolean isMeasurementCorrectionsSupported() {
            return GnssNative.m5350$$Nest$smnative_is_measurement_corrections_supported();
        }

        protected boolean injectMeasurementCorrections(GnssMeasurementCorrections corrections) {
            return GnssNative.m5343$$Nest$smnative_inject_measurement_corrections(corrections);
        }

        protected boolean startSvStatusCollection() {
            return GnssNative.m5367$$Nest$smnative_start_sv_status_collection();
        }

        protected boolean stopSvStatusCollection() {
            return GnssNative.m5374$$Nest$smnative_stop_sv_status_collection();
        }

        protected boolean startNmeaMessageCollection() {
            return GnssNative.m5366$$Nest$smnative_start_nmea_message_collection();
        }

        protected boolean stopNmeaMessageCollection() {
            return GnssNative.m5373$$Nest$smnative_stop_nmea_message_collection();
        }

        protected int getBatchSize() {
            return GnssNative.m5336$$Nest$smnative_get_batch_size();
        }

        protected boolean initBatching() {
            return GnssNative.m5339$$Nest$smnative_init_batching();
        }

        protected void cleanupBatching() {
            GnssNative.m5333$$Nest$smnative_cleanup_batching();
        }

        protected boolean startBatch(long periodNanos, float minUpdateDistanceMeters, boolean wakeOnFifoFull) {
            return GnssNative.m5363$$Nest$smnative_start_batch(periodNanos, minUpdateDistanceMeters, wakeOnFifoFull);
        }

        protected void flushBatch() {
            GnssNative.m5335$$Nest$smnative_flush_batch();
        }

        protected void stopBatch() {
            GnssNative.m5370$$Nest$smnative_stop_batch();
        }

        protected boolean isGeofencingSupported() {
            return GnssNative.m5348$$Nest$smnative_is_geofence_supported();
        }

        protected boolean addGeofence(int geofenceId, double latitude, double longitude, double radius, int lastTransition, int monitorTransitions, int notificationResponsiveness, int unknownTimer) {
            return GnssNative.m5328$$Nest$smnative_add_geofence(geofenceId, latitude, longitude, radius, lastTransition, monitorTransitions, notificationResponsiveness, unknownTimer);
        }

        protected boolean resumeGeofence(int geofenceId, int monitorTransitions) {
            return GnssNative.m5358$$Nest$smnative_resume_geofence(geofenceId, monitorTransitions);
        }

        protected boolean pauseGeofence(int geofenceId) {
            return GnssNative.m5354$$Nest$smnative_pause_geofence(geofenceId);
        }

        protected boolean removeGeofence(int geofenceId) {
            return GnssNative.m5356$$Nest$smnative_remove_geofence(geofenceId);
        }

        protected boolean isGnssVisibilityControlSupported() {
            return GnssNative.m5349$$Nest$smnative_is_gnss_visibility_control_supported();
        }

        protected void requestPowerStats() {
            GnssNative.m5357$$Nest$smnative_request_power_stats();
        }

        protected void setAgpsServer(int type, String hostname, int port) {
            GnssNative.m5359$$Nest$smnative_set_agps_server(type, hostname, port);
        }

        protected void setAgpsSetId(int type, String setId) {
            GnssNative.m5329$$Nest$smnative_agps_set_id(type, setId);
        }

        protected void setAgpsReferenceLocationCellId(int type, int mcc, int mnc, int lac, long cid, int tac, int pcid, int arfcn) {
            GnssNative.m5330$$Nest$smnative_agps_set_ref_location_cellid(type, mcc, mnc, lac, cid, tac, pcid, arfcn);
        }

        protected boolean isPsdsSupported() {
            return GnssNative.m5375$$Nest$smnative_supports_psds();
        }

        protected void injectPsdsData(byte[] data, int length, int psdsType) {
            GnssNative.m5345$$Nest$smnative_inject_psds_data(data, length, psdsType);
        }

        protected void injectNiSuplMessageData(byte[] data, int length, int slotIndex) {
            GnssNative.m5344$$Nest$smnative_inject_ni_supl_message_data(data, length, slotIndex);
        }

        protected void injectGnssAssistance(GnssAssistance gnssAssistance) {
            GnssNative.m5341$$Nest$smnative_inject_gnss_assistance(gnssAssistance);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GnssLocationFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GnssPositionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GnssPositionRecurrence {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GnssRealtimeFlags {
    }

    public interface LocationCallbacks {
        void onReportLocation(boolean r1, Location r2);

        void onReportLocations(Location[] r1);
    }

    public interface LocationRequestCallbacks {
        void onRequestLocation(boolean r1, boolean r2);

        void onRequestRefLocation();
    }

    public interface MeasurementCallbacks {
        void onReportMeasurements(GnssMeasurementsEvent r1);
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    private @interface NativeEntryPoint {
    }

    public interface NavigationMessageCallbacks {
        void onReportNavigationMessage(GnssNavigationMessage r1);
    }

    public interface NmeaCallbacks {
        void onReportNmea(long r1);
    }

    public interface NotificationCallbacks {
        void onReportNfwNotification(String r1, byte r2, String r3, byte r4, String r5, byte r6, boolean r7, boolean r8);
    }

    public interface PowerStatsCallback {
        void onReportPowerStats(GnssPowerStats r1);
    }

    public interface PsdsCallbacks {
        void onRequestPsdsDownload(int r1);
    }

    public interface StatusCallbacks {
        public static final int GNSS_STATUS_ENGINE_OFF = 4;
        public static final int GNSS_STATUS_ENGINE_ON = 3;
        public static final int GNSS_STATUS_NONE = 0;
        public static final int GNSS_STATUS_SESSION_BEGIN = 1;
        public static final int GNSS_STATUS_SESSION_END = 2;

        @Retention(RetentionPolicy.SOURCE)
        public @interface GnssStatusValue {
        }

        void onReportFirstFix(int r1);

        void onReportStatus(int r1);
    }

    public interface SvStatusCallbacks {
        void onReportSvStatus(GnssStatus r1);
    }

    public interface TimeCallbacks {
        void onRequestUtcTime();
    }

    /* JADX INFO: renamed from: $r8$lambda$1UCtst-V0Z5j1l14d41SBi1vhdI, reason: not valid java name */
    public static /* synthetic */ void m5310$r8$lambda$1UCtstV0Z5j1l14d41SBi1vhdI(GnssNative r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$6-OuCx2sVq6REAuJkN9ZcRR0v5k, reason: not valid java name */
    public static /* synthetic */ void m5311$r8$lambda$6OuCx2sVq6REAuJkN9ZcRR0v5k(GnssNative r0, int r1, int r2) {
        r0.lambda$reportGeofenceAddStatus$20(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$6CZ016EvoppR0myHpgVyzp5Bsvk(GnssNative r0, int r1, int r2) {
        r0.lambda$reportGeofenceResumeStatus$23(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$7HeWH-P4JlZDYxBciNzC26zFDP0, reason: not valid java name */
    public static /* synthetic */ Boolean m5312$r8$lambda$7HeWHP4JlZDYxBciNzC26zFDP0(GnssNative r0) {
        return r0.lambda$isInEmergencySession$29();
    }

    public static /* synthetic */ void $r8$lambda$9OfI9WbjdopdTa7XLo7_FG8eCNY(GnssNative r0, int r1, Location r2) {
        r0.lambda$reportGeofenceStatus$19(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Bj5rZqoZJ-b2AHkQN3u3bTtbp4o, reason: not valid java name */
    public static /* synthetic */ void m5313$r8$lambda$Bj5rZqoZJb2AHkQN3u3bTtbp4o(GnssNative r0, long r1) {
        r0.lambda$reportNmea$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$DrQ6pDwpbck6J5QJ68XkwthFg1g(GnssNative r0, int r1, int r2) {
        r0.lambda$reportGeofenceRemoveStatus$21(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$DyM9fI_oCQU6wPWWEGEUi43bjls(GnssNative r0, int r1) {
        r0.lambda$psdsDownloadRequest$16(r1);
    }

    public static /* synthetic */ void $r8$lambda$JLHPCBJ657AEK2uIgGkOIn886eQ(Executor r0, PowerStatsCallback r1, GnssPowerStats r2) {
        lambda$requestPowerStats$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$RCS1nU7T_6i40cmDg6b4SolqAcA(Executor r0, PowerStatsCallback r1, GnssPowerStats r2) {
        lambda$requestPowerStats$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Sw7Ri0p-_Ksc23yUe7Bud4ittcA, reason: not valid java name */
    public static /* synthetic */ void m5314$r8$lambda$Sw7Ri0p_Ksc23yUe7Bud4ittcA(GnssNative r0, int r1, int r2, byte[] r3) {
        r0.lambda$reportAGpsStatus$8(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$_9Q4LDyf_3PP5whAQG-pkgMJWrw, reason: not valid java name */
    public static /* synthetic */ void m5315$r8$lambda$_9Q4LDyf_3PP5whAQGpkgMJWrw(GnssNative r0, Location[] r1) {
        r0.lambda$reportLocationBatch$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$eY6TLcwUjMTxvveFp0jW4KLTsmw(GnssNative r0) {
        r0.lambda$requestUtcTime$26();
    }

    /* JADX INFO: renamed from: $r8$lambda$fIb-1WuODbhlBvX2C584sEvC70o, reason: not valid java name */
    public static /* synthetic */ void m5316$r8$lambda$fIb1WuODbhlBvX2C584sEvC70o(GnssNative r0, GnssCapabilities r1, GnssCapabilities r2) {
        r0.lambda$onCapabilitiesChanged$13(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gHBeqniyt2U7tBjl0ACl9Mmg474(AtomicReference r0, CountDownLatch r1, GnssPowerStats r2) {
        lambda$requestPowerStatsBlocking$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$jSpEVClYoI4IbiquX7GCvLW6zZQ(GnssNative r0, GnssNavigationMessage r1) {
        r0.lambda$reportNavigationMessage$12(r1);
    }

    public static /* synthetic */ void $r8$lambda$mVjNxj_SOcFlMPo68wEMjFV4iL8(GnssPowerStats r0, PowerStatsCallback r1) {
        lambda$reportGnssPowerStats$14(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mpe4YBqchYJ0WEhC4ss_4iAeFB4(GnssNative r0, int r1, int r2) {
        r0.lambda$reportGeofencePauseStatus$22(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ozzt7BubswLXd6Vldp5P-euPx3I, reason: not valid java name */
    public static /* synthetic */ void m5317$r8$lambda$ozzt7BubswLXd6Vldp5PeuPx3I(GnssNative r0, boolean r1, boolean r2) {
        r0.lambda$requestLocation$25(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$qNLm-8ijwEsUIu6uCf-cSxNrbGI, reason: not valid java name */
    public static /* synthetic */ void m5318$r8$lambda$qNLm8ijwEsUIu6uCfcSxNrbGI(GnssNative r0, int r1) {
        r0.lambda$reportStatus$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$r4-XSEx0WbVLLqGtTPGCk9LXOno, reason: not valid java name */
    public static /* synthetic */ void m5319$r8$lambda$r4XSEx0WbVLLqGtTPGCk9LXOno(GnssNative r0, GnssMeasurementsEvent r1) {
        r0.lambda$reportMeasurementData$10(r1);
    }

    public static /* synthetic */ void $r8$lambda$tDZXrITcedfj_bhm6YmEyZ_jK6I(GnssNative r0, int r1, int[] r2, float[] r3, float[] r4, float[] r5, float[] r6, float[] r7) {
        r0.lambda$reportSvStatus$7(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$tJ_GNrJuUnQy_S5kfl_kirie9DM(GnssNative r0, List r1) {
        r0.lambda$reportAntennaInfo$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$tVlMxWi8u2f7oDcbmcMSj96pEsA(PowerStatsCallback r0, GnssPowerStats r1) {
        lambda$requestPowerStats$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tXa8kmPlaUMkYPMO5j8S-Hj2gsQ, reason: not valid java name */
    public static /* synthetic */ void m5320$r8$lambda$tXa8kmPlaUMkYPMO5j8SHj2gsQ(GnssNative r0, int r1, Location r2, int r3, long r4) {
        r0.lambda$reportGeofenceTransition$18(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$v3fQArzMmn_IpaYlKQ7-WjyPTiw, reason: not valid java name */
    public static /* synthetic */ void m5321$r8$lambda$v3fQArzMmn_IpaYlKQ7WjyPTiw(GnssNative r0, boolean r1, Location r2) {
        r0.lambda$reportLocation$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$w0KmejZMwiz1ai85dOAflx-dr9g, reason: not valid java name */
    public static /* synthetic */ void m5322$r8$lambda$w0KmejZMwiz1ai85dOAflxdr9g(GnssNative r0, String r1, byte r2, String r3, byte r4, String r5, byte r6, boolean r7, boolean r8) {
        r0.lambda$reportNfwNotification$28(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$wY7FF3NroSSja7MlmP8cicBu1mc(GnssNative r0, int r1) {
        r0.lambda$requestSetID$24(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wZsOr05Gd8h3adeq3xPd8n-vSMs, reason: not valid java name */
    public static /* synthetic */ void m5323$r8$lambda$wZsOr05Gd8h3adeq3xPd8nvSMs(GnssNative r0) {
        r0.lambda$requestRefLocation$27();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGnssHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ GnssHal m5324$$Nest$fgetmGnssHal(GnssNative r0) {
        return r0.mGnssHal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHasFirstFix, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5325$$Nest$fputmHasFirstFix(GnssNative r0, boolean r1) {
        r0.mHasFirstFix = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStartRealtimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5326$$Nest$fputmStartRealtimeMs(GnssNative r0, long r1) {
        r0.mStartRealtimeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnative_init_once, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5327$$Nest$mnative_init_once(GnssNative r0, boolean r1) {
        r0.native_init_once(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_add_geofence, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5328$$Nest$smnative_add_geofence(int r0, double r1, double r3, double r5, int r7, int r8, int r9, int r10) {
        return native_add_geofence(r0, r1, r3, r5, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_agps_set_id, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5329$$Nest$smnative_agps_set_id(int r0, String r1) {
        native_agps_set_id(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_agps_set_ref_location_cellid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5330$$Nest$smnative_agps_set_ref_location_cellid(int r0, int r1, int r2, int r3, long r4, int r6, int r7, int r8) {
        native_agps_set_ref_location_cellid(r0, r1, r2, r3, r4, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_class_init_once, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5331$$Nest$smnative_class_init_once() {
        native_class_init_once();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_cleanup, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5332$$Nest$smnative_cleanup() {
        native_cleanup();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_cleanup_batching, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5333$$Nest$smnative_cleanup_batching() {
        native_cleanup_batching();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_delete_aiding_data, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5334$$Nest$smnative_delete_aiding_data(int r0) {
        native_delete_aiding_data(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_flush_batch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5335$$Nest$smnative_flush_batch() {
        native_flush_batch();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_get_batch_size, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5336$$Nest$smnative_get_batch_size() {
        return native_get_batch_size();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_get_internal_state, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5337$$Nest$smnative_get_internal_state() {
        return native_get_internal_state();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_init, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5338$$Nest$smnative_init() {
        return native_init();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_init_batching, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5339$$Nest$smnative_init_batching() {
        return native_init_batching();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_best_location, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5340$$Nest$smnative_inject_best_location(int r0, double r1, double r3, double r5, float r7, float r8, float r9, float r10, float r11, float r12, long r13, int r15, long r16, double r18) {
        native_inject_best_location(r0, r1, r3, r5, r7, r8, r9, r10, r11, r12, r13, r15, r16, r18);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_gnss_assistance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5341$$Nest$smnative_inject_gnss_assistance(GnssAssistance r0) {
        native_inject_gnss_assistance(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_location, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5342$$Nest$smnative_inject_location(int r0, double r1, double r3, double r5, float r7, float r8, float r9, float r10, float r11, float r12, long r13, int r15, long r16, double r18) {
        native_inject_location(r0, r1, r3, r5, r7, r8, r9, r10, r11, r12, r13, r15, r16, r18);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_measurement_corrections, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5343$$Nest$smnative_inject_measurement_corrections(GnssMeasurementCorrections r0) {
        return native_inject_measurement_corrections(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_ni_supl_message_data, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5344$$Nest$smnative_inject_ni_supl_message_data(byte[] r0, int r1, int r2) {
        native_inject_ni_supl_message_data(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_psds_data, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5345$$Nest$smnative_inject_psds_data(byte[] r0, int r1, int r2) {
        native_inject_psds_data(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_inject_time, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5346$$Nest$smnative_inject_time(long r0, long r2, int r4) {
        native_inject_time(r0, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_antenna_info_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5347$$Nest$smnative_is_antenna_info_supported() {
        return native_is_antenna_info_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_geofence_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5348$$Nest$smnative_is_geofence_supported() {
        return native_is_geofence_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_gnss_visibility_control_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5349$$Nest$smnative_is_gnss_visibility_control_supported() {
        return native_is_gnss_visibility_control_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_measurement_corrections_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5350$$Nest$smnative_is_measurement_corrections_supported() {
        return native_is_measurement_corrections_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_measurement_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5351$$Nest$smnative_is_measurement_supported() {
        return native_is_measurement_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_navigation_message_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5352$$Nest$smnative_is_navigation_message_supported() {
        return native_is_navigation_message_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_is_supported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5353$$Nest$smnative_is_supported() {
        return native_is_supported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_pause_geofence, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5354$$Nest$smnative_pause_geofence(int r0) {
        return native_pause_geofence(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_read_nmea, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5355$$Nest$smnative_read_nmea(byte[] r0, int r1) {
        return native_read_nmea(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_remove_geofence, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5356$$Nest$smnative_remove_geofence(int r0) {
        return native_remove_geofence(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_request_power_stats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5357$$Nest$smnative_request_power_stats() {
        native_request_power_stats();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_resume_geofence, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5358$$Nest$smnative_resume_geofence(int r0, int r1) {
        return native_resume_geofence(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_set_agps_server, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5359$$Nest$smnative_set_agps_server(int r0, String r1, int r2) {
        native_set_agps_server(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_set_position_mode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5360$$Nest$smnative_set_position_mode(int r0, int r1, int r2, int r3, int r4, boolean r5) {
        return native_set_position_mode(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5361$$Nest$smnative_start() {
        return native_start();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_antenna_info_listening, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5362$$Nest$smnative_start_antenna_info_listening() {
        return native_start_antenna_info_listening();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_batch, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5363$$Nest$smnative_start_batch(long r0, float r2, boolean r3) {
        return native_start_batch(r0, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_measurement_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5364$$Nest$smnative_start_measurement_collection(boolean r0, boolean r1, int r2) {
        return native_start_measurement_collection(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_navigation_message_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5365$$Nest$smnative_start_navigation_message_collection() {
        return native_start_navigation_message_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_nmea_message_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5366$$Nest$smnative_start_nmea_message_collection() {
        return native_start_nmea_message_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_start_sv_status_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5367$$Nest$smnative_start_sv_status_collection() {
        return native_start_sv_status_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5368$$Nest$smnative_stop() {
        return native_stop();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_antenna_info_listening, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5369$$Nest$smnative_stop_antenna_info_listening() {
        return native_stop_antenna_info_listening();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_batch, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5370$$Nest$smnative_stop_batch() {
        return native_stop_batch();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_measurement_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5371$$Nest$smnative_stop_measurement_collection() {
        return native_stop_measurement_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_navigation_message_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5372$$Nest$smnative_stop_navigation_message_collection() {
        return native_stop_navigation_message_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_nmea_message_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5373$$Nest$smnative_stop_nmea_message_collection() {
        return native_stop_nmea_message_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_stop_sv_status_collection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5374$$Nest$smnative_stop_sv_status_collection() {
        return native_stop_sv_status_collection();
    }

    /* JADX INFO: renamed from: -$$Nest$smnative_supports_psds, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5375$$Nest$smnative_supports_psds() {
        return native_supports_psds();
    }

    private static native boolean native_add_geofence(int r0, double r1, double r3, double r5, int r7, int r8, int r9, int r10);

    private static native void native_agps_set_id(int r0, String r1);

    private static native void native_agps_set_ref_location_cellid(int r0, int r1, int r2, int r3, long r4, int r6, int r7, int r8);

    private static native void native_class_init_once();

    private static native void native_cleanup();

    private static native void native_cleanup_batching();

    private static native void native_delete_aiding_data(int r0);

    private static native void native_flush_batch();

    private static native int native_get_batch_size();

    private static native String native_get_internal_state();

    private static native boolean native_init();

    private static native boolean native_init_batching();

    private native void native_init_once(boolean r1);

    private static native void native_inject_best_location(int r0, double r1, double r3, double r5, float r7, float r8, float r9, float r10, float r11, float r12, long r13, int r15, long r16, double r18);

    private static native void native_inject_gnss_assistance(GnssAssistance r0);

    private static native void native_inject_location(int r0, double r1, double r3, double r5, float r7, float r8, float r9, float r10, float r11, float r12, long r13, int r15, long r16, double r18);

    private static native boolean native_inject_measurement_corrections(GnssMeasurementCorrections r0);

    private static native void native_inject_ni_supl_message_data(byte[] r0, int r1, int r2);

    private static native void native_inject_psds_data(byte[] r0, int r1, int r2);

    private static native void native_inject_time(long r0, long r2, int r4);

    private static native boolean native_is_antenna_info_supported();

    private static native boolean native_is_geofence_supported();

    private static native boolean native_is_gnss_visibility_control_supported();

    private static native boolean native_is_measurement_corrections_supported();

    private static native boolean native_is_measurement_supported();

    private static native boolean native_is_navigation_message_supported();

    private static native boolean native_is_supported();

    private static native boolean native_pause_geofence(int r0);

    private static native int native_read_nmea(byte[] r0, int r1);

    private static native boolean native_remove_geofence(int r0);

    private static native void native_request_power_stats();

    private static native boolean native_resume_geofence(int r0, int r1);

    private static native void native_set_agps_server(int r0, String r1, int r2);

    private static native boolean native_set_position_mode(int r0, int r1, int r2, int r3, int r4, boolean r5);

    private static native boolean native_start();

    private static native boolean native_start_antenna_info_listening();

    private static native boolean native_start_batch(long r0, float r2, boolean r3);

    private static native boolean native_start_measurement_collection(boolean r0, boolean r1, int r2);

    private static native boolean native_start_navigation_message_collection();

    private static native boolean native_start_nmea_message_collection();

    private static native boolean native_start_sv_status_collection();

    private static native boolean native_stop();

    private static native boolean native_stop_antenna_info_listening();

    private static native boolean native_stop_batch();

    private static native boolean native_stop_measurement_collection();

    private static native boolean native_stop_navigation_message_collection();

    private static native boolean native_stop_nmea_message_collection();

    private static native boolean native_stop_sv_status_collection();

    private static native boolean native_supports_psds();

    public static synchronized void setGnssHalForTest(GnssHal gnssHal) {
        monitor-enter(GnssNative.class);
        gnssHal.getClass();     // Catch: Throwable -> L7
        sGnssHal = gnssHal;     // Catch: Throwable -> L7
        sGnssHalInitialized = false;     // Catch: Throwable -> L7
        sInstance = null;     // Catch: Throwable -> L7
        monitor-exit(GnssNative.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void initializeHal() {
        monitor-enter(GnssNative.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sGnssHalInitialized == false) goto L7;
    L12:
        monitor-exit(GnssNative.class);
        return;
    L7:
        if (sGnssHal != null) goto L11;
        sGnssHal = new GnssHal();     // Catch: Throwable -> L9
    L11:
        sGnssHal.classInitOnce();     // Catch: Throwable -> L9
        sGnssHalInitialized = true;     // Catch: Throwable -> L9
        goto L12
    }

    public static synchronized boolean isSupported() {
        monitor-enter(GnssNative.class);
        initializeHal();     // Catch: Throwable -> L7
        boolean r1 = sGnssHal.isSupported();     // Catch: Throwable -> L7
        monitor-exit(GnssNative.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized GnssNative create(Injector injector, GnssConfiguration configuration) {
        monitor-enter(GnssNative.class);
        Preconditions.checkState(isSupported());     // Catch: Throwable -> L11
        if (sInstance != null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L11
        GnssNative r2 = new GnssNative(sGnssHal, injector, configuration);     // Catch: Throwable -> L11
        sInstance = r2;     // Catch: Throwable -> L11
        monitor-exit(GnssNative.class);
        return r2;
    L7:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        Log.d(GnssManagerService.TAG, "Request for power stats timed out");
        reportGnssPowerStats(null);
    }

    private GnssNative(GnssHal gnssHal, Injector injector, GnssConfiguration configuration) {
        this.mBaseCallbacks = new BaseCallbacks[0];
        this.mStatusCallbacks = new StatusCallbacks[0];
        this.mSvStatusCallbacks = new SvStatusCallbacks[0];
        this.mNmeaCallbacks = new NmeaCallbacks[0];
        this.mLocationCallbacks = new LocationCallbacks[0];
        this.mMeasurementCallbacks = new MeasurementCallbacks[0];
        this.mAntennaInfoCallbacks = new AntennaInfoCallbacks[0];
        this.mNavigationMessageCallbacks = new NavigationMessageCallbacks[0];
        this.mLastKnownPowerStats = null;
        this.mPowerStatsLock = new Object();
        this.mPowerStatsTimeoutCallback = new GnssNative$$ExternalSyntheticLambda10(this);
        this.mPendingPowerStatsCallbacks = new ArrayList();
        this.mCapabilities = new GnssCapabilities.Builder().build();
        this.mHardwareYear = 0;
        this.mHardwareModelName = null;
        this.mStartRealtimeMs = 0;
        this.mHasFirstFix = false;
        gnssHal.getClass();
        this.mGnssHal = gnssHal;
        this.mEmergencyHelper = injector.getEmergencyHelper();
        this.mConfiguration = configuration;
        this.mHandler = FgThread.getHandler();
    }

    public void addBaseCallbacks(BaseCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mBaseCallbacks = (BaseCallbacks[]) ArrayUtils.appendElement(BaseCallbacks.class, this.mBaseCallbacks, callbacks);
    }

    public void addStatusCallbacks(StatusCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mStatusCallbacks = (StatusCallbacks[]) ArrayUtils.appendElement(StatusCallbacks.class, this.mStatusCallbacks, callbacks);
    }

    public void addSvStatusCallbacks(SvStatusCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mSvStatusCallbacks = (SvStatusCallbacks[]) ArrayUtils.appendElement(SvStatusCallbacks.class, this.mSvStatusCallbacks, callbacks);
    }

    public void addNmeaCallbacks(NmeaCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mNmeaCallbacks = (NmeaCallbacks[]) ArrayUtils.appendElement(NmeaCallbacks.class, this.mNmeaCallbacks, callbacks);
    }

    public void addLocationCallbacks(LocationCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mLocationCallbacks = (LocationCallbacks[]) ArrayUtils.appendElement(LocationCallbacks.class, this.mLocationCallbacks, callbacks);
    }

    public void addMeasurementCallbacks(MeasurementCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mMeasurementCallbacks = (MeasurementCallbacks[]) ArrayUtils.appendElement(MeasurementCallbacks.class, this.mMeasurementCallbacks, callbacks);
    }

    public void addAntennaInfoCallbacks(AntennaInfoCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mAntennaInfoCallbacks = (AntennaInfoCallbacks[]) ArrayUtils.appendElement(AntennaInfoCallbacks.class, this.mAntennaInfoCallbacks, callbacks);
    }

    public void addNavigationMessageCallbacks(NavigationMessageCallbacks callbacks) {
        Preconditions.checkState(!this.mRegistered);
        this.mNavigationMessageCallbacks = (NavigationMessageCallbacks[]) ArrayUtils.appendElement(NavigationMessageCallbacks.class, this.mNavigationMessageCallbacks, callbacks);
    }

    public void setGeofenceCallbacks(GeofenceCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mGeofenceCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mGeofenceCallbacks = callbacks;
    }

    public void setTimeCallbacks(TimeCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mTimeCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mTimeCallbacks = callbacks;
    }

    public void setLocationRequestCallbacks(LocationRequestCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mLocationRequestCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mLocationRequestCallbacks = callbacks;
    }

    public void setPsdsCallbacks(PsdsCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mPsdsCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mPsdsCallbacks = callbacks;
    }

    public void setAGpsCallbacks(AGpsCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mAGpsCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mAGpsCallbacks = callbacks;
    }

    public void setNotificationCallbacks(NotificationCallbacks callbacks) {
        boolean r1 = true;
        Preconditions.checkState(!this.mRegistered);
        if (this.mNotificationCallbacks == null) goto L6;
        r1 = false;
    L6:
        Preconditions.checkState(r1);
        callbacks.getClass();
        this.mNotificationCallbacks = callbacks;
    }

    public void setGnssAssistanceCallbacks(GnssAssistanceCallbacks callbacks) {
    }

    public void register() {
        Preconditions.checkState(!this.mRegistered);
        this.mRegistered = true;
        initializeGnss(false);
        Log.i(GnssManagerService.TAG, "gnss hal started");
        int i = 0;
    L4:
        if (i >= this.mBaseCallbacks.length) goto L6;
        this.mBaseCallbacks[i].onHalStarted();
        i = i + 1;
        goto L4
    L6:
        GPOStateMachine.getGpoStateMachine().addListener(new AnonymousClass1(this));
    }

    private void initializeGnss(boolean restart) {
        Preconditions.checkState(this.mRegistered);
        this.mTopFlags = 0;
        this.mGnssHal.initOnce(this, restart);
        if (this.mGnssHal.init() == false) goto L5;
        this.mGnssHal.cleanup();
        Log.i(GnssManagerService.TAG, "gnss hal initialized");
        return;
    L5:
        Log.e(GnssManagerService.TAG, "gnss hal initialization failed");
    }

    public GnssConfiguration getConfiguration() {
        return this.mConfiguration;
    }

    public boolean init() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.init();
    }

    public void cleanup() {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.cleanup();
    }

    public GnssPowerStats getLastKnownPowerStats() {
        return this.mLastKnownPowerStats;
    }

    public GnssCapabilities getCapabilities() {
        return this.mCapabilities;
    }

    public int getHardwareYear() {
        return this.mHardwareYear;
    }

    public String getHardwareModelName() {
        return this.mHardwareModelName;
    }

    public boolean isItarSpeedLimitExceeded() {
        return this.mItarSpeedLimitExceeded;
    }

    public boolean start() {
        Preconditions.checkState(this.mRegistered);
        StarLocation.getInstance().setAospGnssStatus(true);
        return this.mGnssHal.start();
    }

    public boolean stop() {
        Preconditions.checkState(this.mRegistered);
        StarLocation.getInstance().setAospGnssStatus(false);
        return this.mGnssHal.stop();
    }

    public boolean setPositionMode(int mode, int recurrence, int minInterval, int preferredAccuracy, int preferredTime, boolean lowPowerMode) {
        Preconditions.checkState(this.mRegistered);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "setPositionMode, mode: " + mode + ", recurrence: " + recurrence + ", minInterval: " + minInterval + ", preferredAccuracy: " + preferredAccuracy + ", preferredTime: " + preferredTime + ", lowPowerMode: " + lowPowerMode);
        return this.mGnssHal.setPositionMode(mode, recurrence, minInterval, preferredAccuracy, preferredTime, lowPowerMode);
    }

    public String getInternalState() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.getInternalState();
    }

    public void deleteAidingData(int flags) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.deleteAidingData(flags);
    }

    public int readNmea(byte[] buffer, int bufferSize) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.readNmea(buffer, bufferSize);
    }

    public void injectLocation(Location location) {
        Preconditions.checkState(this.mRegistered);
        if (location.hasAccuracy() == false) goto L38;
        int r2 = 2;
        if (location.hasAltitude() == false) goto L7;
        int r1 = 2;
    L8:
        int r3 = r1 | 1;
        if (location.hasSpeed() == false) goto L11;
        int r4 = 4;
    L12:
        int r5 = r3 | r4;
        if (location.hasBearing() == false) goto L15;
        int r6 = 8;
    L16:
        int r7 = r5 | r6;
        if (location.hasAccuracy() == false) goto L19;
        int r8 = 16;
    L20:
        int r9 = r7 | r8;
        if (location.hasVerticalAccuracy() == false) goto L23;
        int r10 = 32;
    L24:
        int r11 = r9 | r10;
        if (location.hasSpeedAccuracy() == false) goto L27;
        int r12 = 64;
    L28:
        int r13 = r11 | r12;
        if (location.hasBearingAccuracy() == false) goto L31;
        int r14 = 128;
    L32:
        int gnssLocationFlags = r13 | r14;
        double latitudeDegrees = location.getLatitude();
        double longitudeDegrees = location.getLongitude();
        double altitudeMeters = location.getAltitude();
        float speedMetersPerSec = location.getSpeed();
        float bearingDegrees = location.getBearing();
        float horizontalAccuracyMeters = location.getAccuracy();
        float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
        float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
        float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
        long timestamp = location.getTime();
        if (location.hasElapsedRealtimeUncertaintyNanos() == true) goto L36;
        r2 = 0;
    L36:
        int elapsedRealtimeFlags = r2 | 1;
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
        this.mGnssHal.injectLocation(gnssLocationFlags, latitudeDegrees, longitudeDegrees, altitudeMeters, speedMetersPerSec, bearingDegrees, horizontalAccuracyMeters, verticalAccuracyMeters, speedAccuracyMetersPerSecond, bearingAccuracyDegrees, timestamp, elapsedRealtimeFlags, elapsedRealtimeNanos, elapsedRealtimeUncertaintyNanos);
        return;
    L31:
        r14 = 0;
        goto L32
    L27:
        r12 = 0;
        goto L28
    L23:
        r10 = 0;
        goto L24
    L19:
        r8 = 0;
        goto L20
    L15:
        r6 = 0;
        goto L16
    L11:
        r4 = 0;
        goto L12
    L7:
        r1 = 0;
        goto L8
    }

    public void injectBestLocation(Location location) {
        Preconditions.checkState(this.mRegistered);
        int r2 = 2;
        if (location.hasAltitude() == false) goto L5;
        int r1 = 2;
    L6:
        int r3 = r1 | 1;
        if (location.hasSpeed() == false) goto L9;
        int r4 = 4;
    L10:
        int r5 = r3 | r4;
        if (location.hasBearing() == false) goto L13;
        int r6 = 8;
    L14:
        int r7 = r5 | r6;
        if (location.hasAccuracy() == false) goto L17;
        int r8 = 16;
    L18:
        int r9 = r7 | r8;
        if (location.hasVerticalAccuracy() == false) goto L21;
        int r10 = 32;
    L22:
        int r11 = r9 | r10;
        if (location.hasSpeedAccuracy() == false) goto L25;
        int r12 = 64;
    L26:
        int r13 = r11 | r12;
        if (location.hasBearingAccuracy() == false) goto L29;
        int r14 = 128;
    L30:
        int gnssLocationFlags = r13 | r14;
        double latitudeDegrees = location.getLatitude();
        double longitudeDegrees = location.getLongitude();
        double altitudeMeters = location.getAltitude();
        float speedMetersPerSec = location.getSpeed();
        float bearingDegrees = location.getBearing();
        float horizontalAccuracyMeters = location.getAccuracy();
        float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
        float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
        float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
        long timestamp = location.getTime();
        if (location.hasElapsedRealtimeUncertaintyNanos() == true) goto L34;
        r2 = 0;
    L34:
        int elapsedRealtimeFlags = r2 | 1;
        long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
        this.mGnssHal.injectBestLocation(gnssLocationFlags, latitudeDegrees, longitudeDegrees, altitudeMeters, speedMetersPerSec, bearingDegrees, horizontalAccuracyMeters, verticalAccuracyMeters, speedAccuracyMetersPerSecond, bearingAccuracyDegrees, timestamp, elapsedRealtimeFlags, elapsedRealtimeNanos, elapsedRealtimeUncertaintyNanos);
        return;
    L29:
        r14 = 0;
        goto L30
    L25:
        r12 = 0;
        goto L26
    L21:
        r10 = 0;
        goto L22
    L17:
        r8 = 0;
        goto L18
    L13:
        r6 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public void injectTime(long time, long timeReference, int uncertainty) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.injectTime(time, timeReference, uncertainty);
    }

    public boolean isNavigationMessageCollectionSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isNavigationMessageCollectionSupported();
    }

    public boolean startNavigationMessageCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startNavigationMessageCollection();
    }

    public boolean stopNavigationMessageCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.stopNavigationMessageCollection();
    }

    public boolean isAntennaInfoSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isAntennaInfoSupported();
    }

    public boolean startAntennaInfoListening() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startAntennaInfoListening();
    }

    public boolean stopAntennaInfoListening() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.stopAntennaInfoListening();
    }

    public boolean isMeasurementSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isMeasurementSupported();
    }

    public boolean startMeasurementCollection(boolean enableFullTracking, boolean enableCorrVecOutputs, int intervalMillis) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startMeasurementCollection(enableFullTracking, enableCorrVecOutputs, intervalMillis);
    }

    public boolean stopMeasurementCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.stopMeasurementCollection();
    }

    public boolean startSvStatusCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startSvStatusCollection();
    }

    public boolean stopSvStatusCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.stopSvStatusCollection();
    }

    public boolean startNmeaMessageCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startNmeaMessageCollection();
    }

    public boolean stopNmeaMessageCollection() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.stopNmeaMessageCollection();
    }

    public boolean isMeasurementCorrectionsSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isMeasurementCorrectionsSupported();
    }

    public boolean injectMeasurementCorrections(GnssMeasurementCorrections corrections) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.injectMeasurementCorrections(corrections);
    }

    public boolean initBatching() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.initBatching();
    }

    public void cleanupBatching() {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.cleanupBatching();
    }

    public boolean startBatch(long periodNanos, float minUpdateDistanceMeters, boolean wakeOnFifoFull) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.startBatch(periodNanos, minUpdateDistanceMeters, wakeOnFifoFull);
    }

    public void flushBatch() {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.flushBatch();
    }

    public void stopBatch() {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.stopBatch();
    }

    public int getBatchSize() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.getBatchSize();
    }

    public boolean isGeofencingSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isGeofencingSupported();
    }

    public boolean addGeofence(int geofenceId, double latitude, double longitude, double radius, int lastTransition, int monitorTransitions, int notificationResponsiveness, int unknownTimer) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.addGeofence(geofenceId, latitude, longitude, radius, lastTransition, monitorTransitions, notificationResponsiveness, unknownTimer);
    }

    public boolean resumeGeofence(int geofenceId, int monitorTransitions) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.resumeGeofence(geofenceId, monitorTransitions);
    }

    public boolean pauseGeofence(int geofenceId) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.pauseGeofence(geofenceId);
    }

    public boolean removeGeofence(int geofenceId) {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.removeGeofence(geofenceId);
    }

    public boolean isGnssVisibilityControlSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isGnssVisibilityControlSupported();
    }

    public void requestPowerStats(final Executor executor, final PowerStatsCallback callback) {
        Preconditions.checkState(this.mRegistered);
        Object r0 = this.mPowerStatsLock;
        monitor-enter(r0);
        this.mPendingPowerStatsCallbacks.add(new GnssNative$$ExternalSyntheticLambda17(executor, callback));     // Catch: Throwable -> L7
        if (this.mPendingPowerStatsCallbacks.size() != 1) goto L9;
        this.mGnssHal.requestPowerStats();     // Catch: Throwable -> L7
        this.mHandler.postDelayed(this.mPowerStatsTimeoutCallback, 100);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$requestPowerStats$3(final Executor executor, final PowerStatsCallback callback, final GnssPowerStats powerStats) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda18(executor, callback, powerStats));
    }

    private static /* synthetic */ void lambda$requestPowerStats$1(PowerStatsCallback callback, GnssPowerStats powerStats) {
        callback.onReportPowerStats(powerStats);
    }

    private static /* synthetic */ void lambda$requestPowerStats$2(Executor executor, final PowerStatsCallback callback, final GnssPowerStats powerStats) throws Exception {
        executor.execute(new GnssNative$$ExternalSyntheticLambda5(callback, powerStats));
    }

    public GnssPowerStats requestPowerStatsBlocking() {
        final AtomicReference<GnssPowerStats> statsWrapper = new AtomicReference();
        final CountDownLatch latch = new CountDownLatch(1);
        requestPowerStats(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new GnssNative$$ExternalSyntheticLambda15(statsWrapper, latch));
        latch.await(100, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
    L8:
        return statsWrapper.get();
    L6:
        Log.d(GnssManagerService.TAG, "Interrupted while waiting for power stats");
        Thread.currentThread().interrupt();
        goto L8
    }

    private static /* synthetic */ void lambda$requestPowerStatsBlocking$4(AtomicReference statsWrapper, CountDownLatch latch, GnssPowerStats powerStats) {
        statsWrapper.set(powerStats);
        latch.countDown();
    }

    public void setAgpsServer(int type, String hostname, int port) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.setAgpsServer(type, hostname, port);
    }

    public void setAgpsSetId(int type, String setId) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.setAgpsSetId(type, setId);
    }

    public void setAgpsReferenceLocationCellId(int type, int mcc, int mnc, int lac, long cid, int tac, int pcid, int arfcn) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.setAgpsReferenceLocationCellId(type, mcc, mnc, lac, cid, tac, pcid, arfcn);
    }

    public boolean isPsdsSupported() {
        Preconditions.checkState(this.mRegistered);
        return this.mGnssHal.isPsdsSupported();
    }

    public void injectPsdsData(byte[] data, int length, int psdsType) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.injectPsdsData(data, length, psdsType);
    }

    public void injectNiSuplMessageData(byte[] data, int length, int slotIndex) {
        Preconditions.checkState(this.mRegistered);
        this.mGnssHal.injectNiSuplMessageData(data, length, slotIndex);
    }

    public void injectGnssAssistance(GnssAssistance assistance) {
    }

    void reportGnssServiceDied() {
        Log.e(GnssManagerService.TAG, "gnss hal died - restarting shortly...");
        FgThread.getExecutor().execute(new GnssNative$$ExternalSyntheticLambda19(this));
    }

    void restartHal() {
        initializeGnss(true);
        Log.e(GnssManagerService.TAG, "gnss hal restarted");
        int i = 0;
    L4:
        if (i >= this.mBaseCallbacks.length) goto L7;
        this.mBaseCallbacks[i].onHalRestarted();
        i = i + 1;
        goto L4
    }

    void reportLocation(final boolean hasLatLong, final Location location) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda26(this, hasLatLong, location));
    }

    private /* synthetic */ void lambda$reportLocation$5(boolean hasLatLong, Location location) throws Exception {
        boolean exceeded = true;
        if (hasLatLong == false) goto L16;
        if (this.mHasFirstFix == true) goto L16;
        this.mHasFirstFix = true;
        int ttff = (int) (SystemClock.elapsedRealtime() - this.mStartRealtimeMs);
        Bundle extras = location.getExtras();
        byte locationSource = 1;
        if (extras == null) goto L9;
        locationSource = extras.getByte(StarLocation.KEY_LOCATION_SOURCE, (byte) 1).byteValue();
    L9:
        if (locationSource != 1) goto L11;
        LocationEventsTracker.getInstance().trackGnssPositioning(8, new int[]{ttff});
    L11:
        int i = 0;
    L13:
        if (i >= this.mStatusCallbacks.length) goto L16;
        this.mStatusCallbacks[i].onReportFirstFix(ttff);
        i = i + 1;
    L16:
        if (location.hasSpeed() == true) goto L18;
    L30:
        boolean exceeded2 = this.mItarSpeedLimitExceeded;
        if (exceeded2 == false) goto L33;
        return;
    L33:
        LocationEventsTracker.getInstance().recordGnssLocation(hasLatLong, location);
        int i2 = 0;
    L35:
        if (i2 >= this.mLocationCallbacks.length) goto L38;
        this.mLocationCallbacks[i2].onReportLocation(hasLatLong, location);
        i2 = i2 + 1;
        goto L35
    L38:
        return;
    L18:
        if (location.getSpeed() > ITAR_SPEED_LIMIT_METERS_PER_SECOND) goto L22;
        exceeded = false;
    L22:
        if (this.mItarSpeedLimitExceeded == true) goto L26;
        if (exceeded == false) goto L26;
        Log.w(GnssManagerService.TAG, "speed nearing ITAR threshold - blocking further GNSS output");
    L29:
        this.mItarSpeedLimitExceeded = exceeded;
    L26:
        if (this.mItarSpeedLimitExceeded == false) goto L29;
        if (exceeded == true) goto L29;
        Log.w(GnssManagerService.TAG, "speed leaving ITAR threshold - allowing further GNSS output");
        goto L29
    }

    void reportStatus(final int gnssStatus) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda0(this, gnssStatus));
    }

    private /* synthetic */ void lambda$reportStatus$6(int gnssStatus) throws Exception {
        if (gnssStatus != 3) goto L6;
        LocationEventsTracker.getInstance().trackGnssPositioning(1, new long[]{System.currentTimeMillis()});
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "gnss engine on");
    L8:
        int i = 0;
    L10:
        if (i >= this.mStatusCallbacks.length) goto L13;
        this.mStatusCallbacks[i].onReportStatus(gnssStatus);
        i = i + 1;
        goto L10
    L13:
        return;
    L6:
        if (gnssStatus != 4) goto L8;
        LocationEventsTracker.getInstance().trackGnssPositioning(2, new long[]{System.currentTimeMillis()});
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "gnss engine off");
        goto L8
    }

    void reportSvStatus(final int svCount, final int[] svidWithFlags, final float[] cn0DbHzs, final float[] elevations, final float[] azimuths, final float[] carrierFrequencies, final float[] basebandCn0DbHzs) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda12(this, svCount, svidWithFlags, cn0DbHzs, elevations, azimuths, carrierFrequencies, basebandCn0DbHzs));
    }

    private /* synthetic */ void lambda$reportSvStatus$7(int svCount, int[] svidWithFlags, float[] cn0DbHzs, float[] elevations, float[] azimuths, float[] carrierFrequencies, float[] basebandCn0DbHzs) throws Exception {
        GnssStatus gnssStatus = GnssStatus.wrap(svCount, svidWithFlags, cn0DbHzs, elevations, azimuths, carrierFrequencies, basebandCn0DbHzs);
        int i = 0;
    L4:
        if (i >= this.mSvStatusCallbacks.length) goto L7;
        this.mSvStatusCallbacks[i].onReportSvStatus(gnssStatus);
        i = i + 1;
        goto L4
    }

    void reportAGpsStatus(final int agpsType, final int agpsStatus, final byte[] suplIpAddr) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda4(this, agpsType, agpsStatus, suplIpAddr));
    }

    private /* synthetic */ void lambda$reportAGpsStatus$8(int agpsType, int agpsStatus, byte[] suplIpAddr) throws Exception {
        this.mAGpsCallbacks.onReportAGpsStatus(agpsType, agpsStatus, suplIpAddr);
    }

    void reportNmea(final long timestamp) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda25(this, timestamp));
    }

    private /* synthetic */ void lambda$reportNmea$9(long timestamp) throws Exception {
        if (this.mItarSpeedLimitExceeded == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mNmeaCallbacks.length) goto L10;
        this.mNmeaCallbacks[i].onReportNmea(timestamp);
        i = i + 1;
        goto L7
    }

    void reportMeasurementData(final GnssMeasurementsEvent event) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda16(this, event));
    }

    private /* synthetic */ void lambda$reportMeasurementData$10(GnssMeasurementsEvent event) throws Exception {
        if (this.mItarSpeedLimitExceeded == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mMeasurementCallbacks.length) goto L10;
        this.mMeasurementCallbacks[i].onReportMeasurements(event);
        i = i + 1;
        goto L7
    }

    void reportAntennaInfo(final List<GnssAntennaInfo> antennaInfos) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda24(this, antennaInfos));
    }

    private /* synthetic */ void lambda$reportAntennaInfo$11(List antennaInfos) throws Exception {
        int i = 0;
    L4:
        if (i >= this.mAntennaInfoCallbacks.length) goto L7;
        this.mAntennaInfoCallbacks[i].onReportAntennaInfo(antennaInfos);
        i = i + 1;
        goto L4
    }

    void reportNavigationMessage(final GnssNavigationMessage event) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda21(this, event));
    }

    private /* synthetic */ void lambda$reportNavigationMessage$12(GnssNavigationMessage event) throws Exception {
        if (this.mItarSpeedLimitExceeded == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mNavigationMessageCallbacks.length) goto L10;
        this.mNavigationMessageCallbacks[i].onReportNavigationMessage(event);
        i = i + 1;
        goto L7
    }

    void setTopHalCapabilities(int capabilities, boolean isAdrCapabilityKnown) {
        this.mTopFlags |= capabilities;
        GnssCapabilities oldCapabilities = this.mCapabilities;
        this.mCapabilities = oldCapabilities.withTopHalFlags(this.mTopFlags, isAdrCapabilityKnown);
        onCapabilitiesChanged(oldCapabilities, this.mCapabilities);
    }

    void setSubHalMeasurementCorrectionsCapabilities(int capabilities) {
        GnssCapabilities oldCapabilities = this.mCapabilities;
        this.mCapabilities = oldCapabilities.withSubHalMeasurementCorrectionsFlags(capabilities);
        onCapabilitiesChanged(oldCapabilities, this.mCapabilities);
    }

    void setSubHalPowerIndicationCapabilities(int capabilities) {
        GnssCapabilities oldCapabilities = this.mCapabilities;
        this.mCapabilities = oldCapabilities.withSubHalPowerFlags(capabilities);
        onCapabilitiesChanged(oldCapabilities, this.mCapabilities);
    }

    void setSignalTypeCapabilities(List<GnssSignalType> signalTypes) {
        GnssCapabilities oldCapabilities = this.mCapabilities;
        this.mCapabilities = oldCapabilities.withSignalTypes(signalTypes);
        onCapabilitiesChanged(oldCapabilities, this.mCapabilities);
    }

    private void onCapabilitiesChanged(final GnssCapabilities oldCapabilities, final GnssCapabilities newCapabilities) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda22(this, newCapabilities, oldCapabilities));
    }

    private /* synthetic */ void lambda$onCapabilitiesChanged$13(GnssCapabilities newCapabilities, GnssCapabilities oldCapabilities) throws Exception {
        if (newCapabilities.equals(oldCapabilities) == false) goto L5;
        return;
    L5:
        Log.i(GnssManagerService.TAG, "gnss capabilities changed to " + newCapabilities);
        int i = 0;
    L7:
        if (i >= this.mBaseCallbacks.length) goto L10;
        this.mBaseCallbacks[i].onCapabilitiesChanged(oldCapabilities, newCapabilities);
        i = i + 1;
        goto L7
    }

    void reportGnssPowerStats(final GnssPowerStats powerStats) {
        Object r0 = this.mPowerStatsLock;
        monitor-enter(r0);
        this.mHandler.removeCallbacks(this.mPowerStatsTimeoutCallback);     // Catch: Throwable -> L7
        if (powerStats == null) goto L9;
        this.mLastKnownPowerStats = powerStats;     // Catch: Throwable -> L7
    L9:
        this.mPendingPowerStatsCallbacks.forEach(new GnssNative$$ExternalSyntheticLambda8(powerStats));     // Catch: Throwable -> L7
        this.mPendingPowerStatsCallbacks.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$reportGnssPowerStats$14(GnssPowerStats powerStats, PowerStatsCallback cb) {
        cb.onReportPowerStats(powerStats);
    }

    void setGnssYearOfHardware(int year) {
        if (year == this.mHardwareYear) goto L5;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "setGnssYearOfHardware: " + year);
    L5:
        this.mHardwareYear = year;
    }

    private void setGnssHardwareModelName(String modelName) {
        if (modelName != null) goto L4;
    L6:
        this.mHardwareModelName = modelName;
        return;
    L4:
        if (modelName.equals(this.mHardwareModelName) == true) goto L6;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "setGnssHardwareModelName: " + modelName);
        goto L6
    }

    void reportLocationBatch(final Location[] locations) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda7(this, locations));
    }

    private /* synthetic */ void lambda$reportLocationBatch$15(Location[] locations) throws Exception {
        int i = 0;
    L4:
        if (i >= this.mLocationCallbacks.length) goto L7;
        this.mLocationCallbacks[i].onReportLocations(locations);
        i = i + 1;
        goto L4
    }

    private /* synthetic */ void lambda$psdsDownloadRequest$16(int psdsType) throws Exception {
        this.mPsdsCallbacks.onRequestPsdsDownload(psdsType);
    }

    void psdsDownloadRequest(final int psdsType) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda13(this, psdsType));
    }

    void gnssAssistanceInjectRequest() {
    }

    private /* synthetic */ void lambda$gnssAssistanceInjectRequest$17() throws Exception {
        this.mGnssAssistanceCallbacks.onRequestGnssAssistanceInject();
    }

    void reportGeofenceTransition(final int geofenceId, final Location location, final int transition, final long transitionTimestamp) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda11(this, geofenceId, location, transition, transitionTimestamp));
    }

    private /* synthetic */ void lambda$reportGeofenceTransition$18(int geofenceId, Location location, int transition, long transitionTimestamp) throws Exception {
        this.mGeofenceCallbacks.onReportGeofenceTransition(geofenceId, location, transition, transitionTimestamp);
    }

    void reportGeofenceStatus(final int status, final Location location) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda3(this, status, location));
    }

    private /* synthetic */ void lambda$reportGeofenceStatus$19(int status, Location location) throws Exception {
        this.mGeofenceCallbacks.onReportGeofenceStatus(status, location);
    }

    void reportGeofenceAddStatus(final int geofenceId, final int status) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda9(this, geofenceId, status));
    }

    private /* synthetic */ void lambda$reportGeofenceAddStatus$20(int geofenceId, int status) throws Exception {
        this.mGeofenceCallbacks.onReportGeofenceAddStatus(geofenceId, status);
    }

    void reportGeofenceRemoveStatus(final int geofenceId, final int status) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda23(this, geofenceId, status));
    }

    private /* synthetic */ void lambda$reportGeofenceRemoveStatus$21(int geofenceId, int status) throws Exception {
        this.mGeofenceCallbacks.onReportGeofenceRemoveStatus(geofenceId, status);
    }

    void reportGeofencePauseStatus(final int geofenceId, final int status) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda1(this, geofenceId, status));
    }

    private /* synthetic */ void lambda$reportGeofencePauseStatus$22(int geofenceId, int status) throws Exception {
        this.mGeofenceCallbacks.onReportGeofencePauseStatus(geofenceId, status);
    }

    void reportGeofenceResumeStatus(final int geofenceId, final int status) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda6(this, geofenceId, status));
    }

    private /* synthetic */ void lambda$reportGeofenceResumeStatus$23(int geofenceId, int status) throws Exception {
        this.mGeofenceCallbacks.onReportGeofenceResumeStatus(geofenceId, status);
    }

    private /* synthetic */ void lambda$requestSetID$24(int flags) throws Exception {
        this.mAGpsCallbacks.onRequestSetID(flags);
    }

    void requestSetID(final int flags) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda29(this, flags));
    }

    void requestLocation(final boolean independentFromGnss, final boolean isUserEmergency) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda14(this, independentFromGnss, isUserEmergency));
    }

    private /* synthetic */ void lambda$requestLocation$25(boolean independentFromGnss, boolean isUserEmergency) throws Exception {
        this.mLocationRequestCallbacks.onRequestLocation(independentFromGnss, isUserEmergency);
    }

    private /* synthetic */ void lambda$requestUtcTime$26() throws Exception {
        this.mTimeCallbacks.onRequestUtcTime();
    }

    void requestUtcTime() {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda20(this));
    }

    void requestRefLocation() {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda27(this));
    }

    private /* synthetic */ void lambda$requestRefLocation$27() throws Exception {
        this.mLocationRequestCallbacks.onRequestRefLocation();
    }

    void reportNfwNotification(final String proxyAppPackageName, final byte protocolStack, final String otherProtocolStackName, final byte requestor, final String requestorId, final byte responseType, final boolean inEmergencyMode, final boolean isCachedLocation) {
        Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda28(this, proxyAppPackageName, protocolStack, otherProtocolStackName, requestor, requestorId, responseType, inEmergencyMode, isCachedLocation));
    }

    private /* synthetic */ void lambda$reportNfwNotification$28(String proxyAppPackageName, byte protocolStack, String otherProtocolStackName, byte requestor, String requestorId, byte responseType, boolean inEmergencyMode, boolean isCachedLocation) throws Exception {
        this.mNotificationCallbacks.onReportNfwNotification(proxyAppPackageName, protocolStack, otherProtocolStackName, requestor, requestorId, responseType, inEmergencyMode, isCachedLocation);
    }

    public boolean isInEmergencySession() {
        return ((Boolean) Binder.withCleanCallingIdentity(new GnssNative$$ExternalSyntheticLambda2(this))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isInEmergencySession$29() throws Exception {
        return Boolean.valueOf(this.mEmergencyHelper.isInEmergency(TimeUnit.SECONDS.toMillis(this.mConfiguration.getEsExtensionSec())));
    }
}
