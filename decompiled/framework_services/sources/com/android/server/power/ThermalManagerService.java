package com.android.server.power;

import android.app.StatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.thermal.TemperatureThreshold;
import android.hardware.thermal.V1_0.IThermal;
import android.hardware.thermal.V1_0.ThermalStatus;
import android.hardware.thermal.V1_1.IThermalCallback;
import android.hardware.thermal.V2_0.IThermalChangedCallback;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Binder;
import android.os.CoolingDevice;
import android.os.Handler;
import android.os.IBinder;
import android.os.IHwBinder;
import android.os.IThermalEventListener;
import android.os.IThermalHeadroomListener;
import android.os.IThermalService;
import android.os.IThermalStatusListener;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.Temperature;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StatsEvent;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.EventLogTags;
import com.android.server.FgThread;
import com.android.server.SystemService;
import com.android.server.UiModeManagerService;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.display.config.SensorData;
import com.android.server.job.controllers.JobStatus;
import com.android.server.utils.PriorityDump;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class ThermalManagerService extends SystemService {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_FORECAST_SECONDS = 10;
    public static final float HEADROOM_CALLBACK_MIN_DIFFERENCE = 0.03f;
    public static final int HEADROOM_CALLBACK_MIN_INTERVAL_MILLIS = 5000;
    public static final float HEADROOM_THRESHOLD_CALLBACK_MIN_DIFFERENCE = 0.01f;
    public static final int MAX_FORECAST_SEC = 60;
    public static final int MIN_FORECAST_SEC = 0;
    private static final String TAG = null;
    private final Context mContext;
    private final AtomicBoolean mHalReady;
    private ThermalHalWrapper mHalWrapper;
    final AtomicBoolean mIsHalSkinForecastSupported;
    private boolean mIsStatusOverride;
    private HeadroomCallbackData mLastHeadroomCallbackData;
    private long mLastHeadroomCallbackTimeMillis;
    private final Object mLock;
    private final RemoteCallbackList<IThermalEventListener> mPerfSkinOptListeners;
    final IThermalService.Stub mService;
    private int mStatus;
    private ArrayMap<String, Temperature> mTemperatureMap;
    final TemperatureWatcher mTemperatureWatcher;
    private final RemoteCallbackList<IThermalEventListener> mThermalEventListeners;
    private final RemoteCallbackList<IThermalHeadroomListener> mThermalHeadroomListeners;
    private final RemoteCallbackList<IThermalStatusListener> mThermalStatusListeners;
    private final ThermalHalWrapper.WrapperThermalChangedCallback mWrapperCallback;

    private static final class HeadroomCallbackData {
        float mForecastHeadroom;
        int mForecastSeconds;
        float mHeadroom;
        float[] mHeadroomThresholds;

        /* JADX INFO: renamed from: -$$Nest$misSignificantDifferentFrom, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7590$$Nest$misSignificantDifferentFrom(HeadroomCallbackData r0, HeadroomCallbackData r1) {
            return r0.isSignificantDifferentFrom(r1);
        }

        HeadroomCallbackData(float headroom, float forecastHeadroom, int forecastSeconds, float[] headroomThresholds) {
            this.mHeadroom = headroom;
            this.mForecastHeadroom = forecastHeadroom;
            this.mForecastSeconds = forecastSeconds;
            this.mHeadroomThresholds = headroomThresholds;
        }

        private boolean isSignificantDifferentFrom(HeadroomCallbackData other) {
            if (other != null) goto L6;
            return true;
        L6:
            if (this.mForecastSeconds == other.mForecastSeconds) goto L9;
            return true;
        L9:
            if (Math.abs(this.mHeadroom - other.mHeadroom) < 0.03f) goto L12;
            return true;
        L12:
            if (Math.abs(this.mForecastHeadroom - other.mForecastHeadroom) < 0.03f) goto L14;
            return true;
        L14:
            int i = 0;
        L16:
            if (i >= this.mHeadroomThresholds.length) goto L24;
            if (Float.isNaN(this.mHeadroomThresholds[i]) != Float.isNaN(other.mHeadroomThresholds[i])) goto L19;
            if (Math.abs(this.mHeadroomThresholds[i] - other.mHeadroomThresholds[i]) >= 0.01f) goto L22;
            i = i + 1;
            goto L16
        L22:
            return true;
        L19:
            return true;
        L24:
            return false;
        }

        public String toString() {
            return "HeadroomCallbackData[mHeadroom=" + this.mHeadroom + ", mForecastHeadroom=" + this.mForecastHeadroom + ", mForecastSeconds=" + this.mForecastSeconds + ", mHeadroomThresholds=" + Arrays.toString(this.mHeadroomThresholds) + "]";
        }
    }

    class TemperatureWatcher {
        private static final float DEGREES_BETWEEN_ZERO_AND_ONE = 30.0f;
        private static final int INACTIVITY_THRESHOLD_MILLIS = 10000;
        private static final int MINIMUM_SAMPLE_COUNT = 3;
        private static final int RING_BUFFER_SIZE = 30;
        private final SparseArray<Float> mCachedHeadrooms;
        private final Runnable mGetAndUpdateTemperatureSamplesRunnable;
        private final Handler mHandler;
        float[] mHeadroomThresholds;
        long mInactivityThresholdMillis;
        private long mLastForecastCallTimeMillis;
        final ArrayMap<String, ArrayList<Sample>> mSamples;
        ArrayMap<String, Float> mSevereThresholds;
        final /* synthetic */ ThermalManagerService this$0;

        static class Sample {
            public float temperature;
            public long time;

            Sample(long time, float temperature) {
                this.time = time;
                this.temperature = temperature;
            }

            public String toString() {
                return "Sample[temperature=" + this.temperature + ", time=" + this.time + "]";
            }
        }

        public static /* synthetic */ void $r8$lambda$UBi4DQBBLPBYQRHEEMFqEv1BLg8(TemperatureWatcher r0) {
            r0.getAndUpdateTemperatureSamples();
        }

        /* JADX INFO: renamed from: $r8$lambda$g0-paZd5RiUyQc5-FmgfXPsGA84, reason: not valid java name */
        public static /* synthetic */ ArrayList m7591$r8$lambda$g0paZd5RiUyQc5FmgfXPsGA84(String r0) {
            return lambda$updateTemperatureSampleLocked$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCachedHeadrooms, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m7592$$Nest$fgetmCachedHeadrooms(TemperatureWatcher r0) {
            return r0.mCachedHeadrooms;
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateTemperatureSampleLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7593$$Nest$mupdateTemperatureSampleLocked(TemperatureWatcher r0, long r1, Temperature r3) {
            r0.updateTemperatureSampleLocked(r1, r3);
        }

        TemperatureWatcher(ThermalManagerService this$0) {
            this.this$0 = this$0;
            this.mInactivityThresholdMillis = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
            this.mHandler = BackgroundThread.getHandler();
            this.mSamples = new ArrayMap();
            this.mCachedHeadrooms = new SparseArray(2);
            this.mSevereThresholds = new ArrayMap();
            this.mHeadroomThresholds = new float[7];
            this.mLastForecastCallTimeMillis = 0;
            this.mGetAndUpdateTemperatureSamplesRunnable = new ThermalManagerService$TemperatureWatcher$$ExternalSyntheticLambda1(this);
        }

        void getAndUpdateThresholds() {
            List<TemperatureThreshold> thresholds = ThermalManagerService.m7570$$Nest$fgetmHalWrapper(this.this$0).getTemperatureThresholds(true, 3);
            ArrayMap<String, ArrayList<Sample>> r1 = this.mSamples;
            monitor-enter(r1);
            Arrays.fill(this.mHeadroomThresholds, Float.NaN);     // Catch: Throwable -> L8
            Iterator<TemperatureThreshold> r2 = thresholds.iterator();     // Catch: Throwable -> L8
        L6:
            if (r2.hasNext() == false) goto L10;
            TemperatureThreshold threshold = r2.next();     // Catch: Throwable -> L8
            updateTemperatureThresholdLocked(threshold, false);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        void updateTemperatureThresholdLocked(TemperatureThreshold threshold, boolean override) {
            if (threshold.hotThrottlingThresholds.length > 3) goto L5;
            return;
        L5:
            float severeThreshold = threshold.hotThrottlingThresholds[3];
            if (Float.isNaN(severeThreshold) == false) goto L8;
            return;
        L8:
            this.mSevereThresholds.put(threshold.name, Float.valueOf(severeThreshold));
            if (override == false) goto L11;
            this.mCachedHeadrooms.clear();
            Arrays.fill(this.mHeadroomThresholds, Float.NaN);
        L11:
            int severity = 1;
        L13:
            if (severity > 6) goto L27;
            if (threshold.hotThrottlingThresholds.length <= severity) goto L25;
            float t = threshold.hotThrottlingThresholds[severity];
            if (Float.isNaN(t) == true) goto L25;
            if (severity != 3) goto L21;
            this.mHeadroomThresholds[severity] = 1.0f;
            goto L25
        L21:
            float headroom = normalizeTemperature(t, severeThreshold);
            if (Float.isNaN(this.mHeadroomThresholds[severity]) == false) goto L24;
            this.mHeadroomThresholds[severity] = headroom;
            goto L25
        L24:
            float lastHeadroom = this.mHeadroomThresholds[severity];
            this.mHeadroomThresholds[severity] = Math.min(lastHeadroom, headroom);
        L25:
            severity = severity + 1;
            goto L13
        }

        private void getAndUpdateTemperatureSamples() {
            ArrayMap<String, ArrayList<Sample>> r0 = this.mSamples;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if ((SystemClock.elapsedRealtime() - this.mLastForecastCallTimeMillis) >= this.mInactivityThresholdMillis) goto L15;
            this.mHandler.postDelayed(this.mGetAndUpdateTemperatureSamplesRunnable, 1000);     // Catch: Throwable -> L10
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
            List<Temperature> temperatures = ThermalManagerService.m7570$$Nest$fgetmHalWrapper(this.this$0).getCurrentTemperatures(true, 3);     // Catch: Throwable -> L10
            Iterator<Temperature> r4 = temperatures.iterator();     // Catch: Throwable -> L10
        L8:
            if (r4.hasNext() == false) goto L12;
            Temperature temperature = r4.next();     // Catch: Throwable -> L10
            updateTemperatureSampleLocked(now, temperature);     // Catch: Throwable -> L10
            goto L8
        L12:
            this.mCachedHeadrooms.clear();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L15:
            this.mSamples.clear();     // Catch: Throwable -> L10
            this.mCachedHeadrooms.clear();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
        }

        private void updateTemperatureSampleLocked(long timeNow, Temperature temperature) {
            if (Float.isNaN(temperature.getValue()) == false) goto L5;
            return;
        L5:
            ArrayList<Sample> samples = this.mSamples.computeIfAbsent(temperature.getName(), new ThermalManagerService$TemperatureWatcher$$ExternalSyntheticLambda0());
            if (samples.size() != 30) goto L8;
            samples.removeFirst();
        L8:
            samples.add(new Sample(timeNow, temperature.getValue()));
        }

        private static /* synthetic */ ArrayList lambda$updateTemperatureSampleLocked$0(String k) {
            return new ArrayList(30);
        }

        float getSlopeOf(List<Sample> samples) {
            long sumTimes = 0;
            float sumTemperatures = 0.0f;
            int s = 0;
        L4:
            if (s >= samples.size()) goto L6;
            Sample sample = samples.get(s);
            sumTimes = sumTimes + sample.time;
            sumTemperatures = sumTemperatures + sample.temperature;
            s = s + 1;
            goto L4
        L6:
            int s2 = samples.size();
            long meanTime = sumTimes / ((long) s2);
            float meanTemperature = sumTemperatures / samples.size();
            long sampleVariance = 0;
            float sampleCovariance = 0.0f;
            int s3 = 0;
        L8:
            if (s3 >= samples.size()) goto L11;
            Sample sample2 = samples.get(s3);
            long timeDelta = sample2.time - meanTime;
            float temperatureDelta = sample2.temperature - meanTemperature;
            sampleVariance = sampleVariance + (timeDelta * timeDelta);
            sampleCovariance = sampleCovariance + (timeDelta * temperatureDelta);
            s3 = s3 + 1;
            goto L8
        L11:
            return sampleCovariance / sampleVariance;
        }

        static float normalizeTemperature(float temperature, float severeThreshold) {
            float zeroNormalized = severeThreshold - DEGREES_BETWEEN_ZERO_AND_ONE;
            if (temperature > zeroNormalized) goto L6;
            return 0.0f;
        L6:
            float delta = temperature - zeroNormalized;
            return delta / DEGREES_BETWEEN_ZERO_AND_ONE;
        }

        float getForecast(int forecastSeconds) {
            ArrayMap<String, ArrayList<Sample>> r3 = this.mSamples;
            monitor-enter(r3);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mSevereThresholds.isEmpty() == false) goto L11;
            Slog.e(ThermalManagerService.m7588$$Nest$sfgetTAG(), "No temperature thresholds found");     // Catch: Throwable -> L9
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 6, Float.NaN, forecastSeconds);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            return Float.NaN;
        L11:
            monitor-exit(r3);     // Catch: Throwable -> L9
            int r4 = 0;
            if (this.this$0.mIsHalSkinForecastSupported.get() == false) goto L35;
            float threshold = -1.0f;
            ArrayMap<String, ArrayList<Sample>> r9 = this.mSamples;
            monitor-enter(r9);
        L19:
            th = move-exception;
            throw th;
        L17:
            if (this.mSevereThresholds.size() != 1) goto L21;
            threshold = this.mSevereThresholds.valueAt(0).floatValue();     // Catch: Throwable -> L19
        L21:
            monitor-exit(r9);     // Catch: Throwable -> L19
            if (threshold <= 0.0f) goto L35;
            float forecastTemperature = ThermalManagerService.m7570$$Nest$fgetmHalWrapper(this.this$0).forecastSkinTemperature(forecastSeconds);     // Catch: Exception -> L26 UnsupportedOperationException -> L28
            return normalizeTemperature(forecastTemperature, threshold);
        L31:
            Slog.wtf(ThermalManagerService.m7588$$Nest$sfgetTAG(), "forecastSkinTemperature returns unsupported");
        L32:
            return Float.NaN;
        L30:
            Slog.e(ThermalManagerService.m7588$$Nest$sfgetTAG(), "forecastSkinTemperature fails");
        L35:
            ArrayMap<String, ArrayList<Sample>> r8 = this.mSamples;
            monitor-enter(r8);
            this.mLastForecastCallTimeMillis = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
            if (this.mHandler.hasCallbacks(this.mGetAndUpdateTemperatureSamplesRunnable) == true) goto L43;
            getAndUpdateTemperatureSamples();     // Catch: Throwable -> L40
        L43:
            if (this.mSamples.isEmpty() == false) goto L48;
            Slog.e(ThermalManagerService.m7588$$Nest$sfgetTAG(), "No temperature samples found");     // Catch: Throwable -> L40
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 5, Float.NaN, forecastSeconds);     // Catch: Throwable -> L40
            monitor-exit(r8);     // Catch: Throwable -> L40
            return Float.NaN;
        L48:
            if (this.mCachedHeadrooms.contains(forecastSeconds) == false) goto L52;
            float headroom = this.mCachedHeadrooms.get(forecastSeconds).floatValue();     // Catch: Throwable -> L40
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 1, headroom, forecastSeconds);     // Catch: Throwable -> L40
            monitor-exit(r8);     // Catch: Throwable -> L40
            return headroom;
        L52:
            float maxNormalized = Float.NaN;
            int noThresholdSampleCount = 0;
            Iterator<Map.Entry<String, ArrayList<Sample>>> r10 = this.mSamples.entrySet().iterator();     // Catch: Throwable -> L40
        L54:
            if (r10.hasNext() == false) goto L84;
            Map.Entry<String, ArrayList<Sample>> entry = r10.next();     // Catch: Throwable -> L40
            String name = entry.getKey();     // Catch: Throwable -> L40
            ArrayList<Sample> samples = entry.getValue();     // Catch: Throwable -> L40
            Float threshold2 = this.mSevereThresholds.get(name);     // Catch: Throwable -> L40
            if (threshold2 == null) goto L57;
            float currentTemperature = ((Sample) samples.getLast()).temperature;     // Catch: Throwable -> L40
            if (samples.size() < 3) goto L61;
            float slope = 0.0f;
            if (forecastSeconds <= 0) goto L77;
            slope = getSlopeOf(samples);     // Catch: Throwable -> L40
        L77:
            float normalized = normalizeTemperature(((forecastSeconds * slope) * 1000.0f) + currentTemperature, threshold2.floatValue());     // Catch: Throwable -> L40
            if (Float.isNaN(maxNormalized) == false) goto L80;
        L81:
            maxNormalized = normalized;
        L82:
            r4 = 0;
            goto L54
        L80:
            if (normalized <= maxNormalized) goto L82;
        L61:
            if (this.mSamples.size() == 1) goto L63;
        L67:
            float normalized2 = normalizeTemperature(currentTemperature, threshold2.floatValue());     // Catch: Throwable -> L40
            if (Float.isNaN(maxNormalized) == true) goto L73;
            if (normalized2 <= maxNormalized) goto L54;
        L73:
            maxNormalized = normalized2;
            goto L54
        L63:
            if (this.mCachedHeadrooms.contains(r4) == false) goto L67;
            float headroom2 = this.mCachedHeadrooms.get(r4).floatValue();     // Catch: Throwable -> L40
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 1, headroom2, r4);     // Catch: Throwable -> L40
            monitor-exit(r8);     // Catch: Throwable -> L40
            return headroom2;
        L57:
            noThresholdSampleCount = noThresholdSampleCount + 1;     // Catch: Throwable -> L40
            Slog.e(ThermalManagerService.m7588$$Nest$sfgetTAG(), "No threshold found for " + name);     // Catch: Throwable -> L40
            goto L54
        L84:
            if (noThresholdSampleCount != this.mSamples.size()) goto L86;
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 6, Float.NaN, forecastSeconds);     // Catch: Throwable -> L40
        L87:
            this.mCachedHeadrooms.put(forecastSeconds, Float.valueOf(maxNormalized));     // Catch: Throwable -> L40
            monitor-exit(r8);     // Catch: Throwable -> L40
            return maxNormalized;
        L86:
            FrameworkStatsLog.write(773, Binder.getCallingUid(), 1, maxNormalized, forecastSeconds);     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            throw th;
        }

        float[] getHeadroomThresholds() {
            ArrayMap<String, ArrayList<Sample>> r0 = this.mSamples;
            monitor-enter(r0);
            float[] r1 = Arrays.copyOf(this.mHeadroomThresholds, this.mHeadroomThresholds.length);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        HeadroomCallbackData getHeadroomCallbackDataLocked() {
            HeadroomCallbackData data = new HeadroomCallbackData(getForecast(0), getForecast(10), 10, Arrays.copyOf(this.mHeadroomThresholds, this.mHeadroomThresholds.length));
            return data;
        }

        Sample createSampleForTesting(long time, float temperature) {
            return new Sample(time, temperature);
        }
    }

    static class ThermalHal10Wrapper extends ThermalHalWrapper {
        private IThermal mThermalHal10;

        /* JADX INFO: renamed from: $r8$lambda$FaZRjZIErdlyicBDRXRiSgwz-Zw, reason: not valid java name */
        public static /* synthetic */ void m7594$r8$lambda$FaZRjZIErdlyicBDRXRiSgwzZw(boolean r0, int r1, List r2, ThermalStatus r3, ArrayList r4) {
            lambda$getCurrentTemperatures$0(r0, r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$mH_U6-8wxuA9LAe5CPT3wIaF2dY, reason: not valid java name */
        public static /* synthetic */ void m7595$r8$lambda$mH_U68wxuA9LAe5CPT3wIaF2dY(boolean r0, int r1, List r2, ThermalStatus r3, ArrayList r4) {
            lambda$getCurrentCoolingDevices$1(r0, r1, r2, r3, r4);
        }

        ThermalHal10Wrapper(ThermalHalWrapper.WrapperThermalChangedCallback callback) {
            this.mThermalHal10 = null;
            this.mCallback = callback;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<Temperature> getCurrentTemperatures(final boolean shouldFilter, final int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<Temperature> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal10 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal10.getTemperatures(new ThermalManagerService$ThermalHal10Wrapper$$ExternalSyntheticLambda1(shouldFilter, type, ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentTemperatures, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentTemperatures$0(boolean shouldFilter, int type, List ret, ThermalStatus status, ArrayList temperatures) {
            if (status.code != 0) goto L14;
            Iterator r0 = temperatures.iterator();
        L6:
            if (r0.hasNext() == false) goto L22;
            android.hardware.thermal.V1_0.Temperature temperature = (android.hardware.thermal.V1_0.Temperature) r0.next();
            if (shouldFilter == false) goto L12;
            if (type != temperature.type) goto L6;
        L12:
            ret.add(new Temperature(temperature.currentValue, temperature.type, temperature.name, 0));
            goto L6
        L22:
            return;
        L14:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get temperatures because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<CoolingDevice> getCurrentCoolingDevices(final boolean shouldFilter, final int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<CoolingDevice> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal10 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal10.getCoolingDevices(new ThermalManagerService$ThermalHal10Wrapper$$ExternalSyntheticLambda0(shouldFilter, type, ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentCoolingDevices$1(boolean shouldFilter, int type, List ret, ThermalStatus status, ArrayList coolingDevices) {
            if (status.code != 0) goto L14;
            Iterator r0 = coolingDevices.iterator();
        L6:
            if (r0.hasNext() == false) goto L22;
            android.hardware.thermal.V1_0.CoolingDevice coolingDevice = (android.hardware.thermal.V1_0.CoolingDevice) r0.next();
            if (shouldFilter == false) goto L12;
            if (type != coolingDevice.type) goto L6;
        L12:
            ret.add(new CoolingDevice((long) coolingDevice.currentValue, coolingDevice.type, coolingDevice.name));
            goto L6
        L22:
            return;
        L14:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get cooling device because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<TemperatureThreshold> getTemperatureThresholds(boolean shouldFilter, int type) {
            return new ArrayList();
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected boolean connectToHal() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            boolean r1 = true;
            this.mThermalHal10 = IThermal.getService(true);     // Catch: Throwable -> L7 Throwable -> L9
            this.mThermalHal10.linkToDeath(new ThermalHalWrapper.DeathRecipient(this), 5612);     // Catch: Throwable -> L7 Throwable -> L9
            Slog.i(ThermalHalWrapper.TAG, "Thermal HAL 1.0 service connected, no thermal call back will be called due to legacy API.");     // Catch: Throwable -> L7 Throwable -> L9
        L12:
            if (this.mThermalHal10 != null) goto L15;
            r1 = false;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        L10:
            Slog.e(ThermalHalWrapper.TAG, "Thermal HAL 1.0 service not connected.");     // Catch: Throwable -> L7
            this.mThermalHal10 = null;     // Catch: Throwable -> L7
            goto L12
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected float forecastSkinTemperature(int forecastSeconds) {
            throw new UnsupportedOperationException("Not supported in Thermal HAL 1.0");
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected void dump(PrintWriter pw, String prefix) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            pw.print(prefix);     // Catch: Throwable -> L7
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
            r1.append("ThermalHAL 1.0 connected: ");     // Catch: Throwable -> L7
            if (this.mThermalHal10 == null) goto L9;
            String r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
        L10:
            r1.append(r2);     // Catch: Throwable -> L7
            pw.println(r1.toString());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class ThermalHal11Wrapper extends ThermalHalWrapper {
        private final IThermalCallback.Stub mThermalCallback11;
        private android.hardware.thermal.V1_1.IThermal mThermalHal11;

        /* JADX INFO: renamed from: $r8$lambda$5LsPU82JIi-nhuQIKNT1-PiRvYI, reason: not valid java name */
        public static /* synthetic */ void m7596$r8$lambda$5LsPU82JIinhuQIKNT1PiRvYI(boolean r0, int r1, List r2, ThermalStatus r3, ArrayList r4) {
            lambda$getCurrentCoolingDevices$1(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$SBC_HdFEJYAv71O5KlqnY1zvKKo(boolean r0, int r1, List r2, ThermalStatus r3, ArrayList r4) {
            lambda$getCurrentTemperatures$0(r0, r1, r2, r3, r4);
        }

        ThermalHal11Wrapper(ThermalHalWrapper.WrapperThermalChangedCallback callback) {
            this.mThermalHal11 = null;
            this.mThermalCallback11 = new AnonymousClass1(this);
            this.mCallback = callback;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<Temperature> getCurrentTemperatures(final boolean shouldFilter, final int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<Temperature> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal11 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal11.getTemperatures(new ThermalManagerService$ThermalHal11Wrapper$$ExternalSyntheticLambda1(shouldFilter, type, ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentTemperatures, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentTemperatures$0(boolean shouldFilter, int type, List ret, ThermalStatus status, ArrayList temperatures) {
            if (status.code != 0) goto L14;
            Iterator r0 = temperatures.iterator();
        L6:
            if (r0.hasNext() == false) goto L22;
            android.hardware.thermal.V1_0.Temperature temperature = (android.hardware.thermal.V1_0.Temperature) r0.next();
            if (shouldFilter == false) goto L12;
            if (type != temperature.type) goto L6;
        L12:
            ret.add(new Temperature(temperature.currentValue, temperature.type, temperature.name, 0));
            goto L6
        L22:
            return;
        L14:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get temperatures because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<CoolingDevice> getCurrentCoolingDevices(final boolean shouldFilter, final int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<CoolingDevice> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal11 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal11.getCoolingDevices(new ThermalManagerService$ThermalHal11Wrapper$$ExternalSyntheticLambda0(shouldFilter, type, ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentCoolingDevices$1(boolean shouldFilter, int type, List ret, ThermalStatus status, ArrayList coolingDevices) {
            if (status.code != 0) goto L14;
            Iterator r0 = coolingDevices.iterator();
        L6:
            if (r0.hasNext() == false) goto L22;
            android.hardware.thermal.V1_0.CoolingDevice coolingDevice = (android.hardware.thermal.V1_0.CoolingDevice) r0.next();
            if (shouldFilter == false) goto L12;
            if (type != coolingDevice.type) goto L6;
        L12:
            ret.add(new CoolingDevice((long) coolingDevice.currentValue, coolingDevice.type, coolingDevice.name));
            goto L6
        L22:
            return;
        L14:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get cooling device because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<TemperatureThreshold> getTemperatureThresholds(boolean shouldFilter, int type) {
            return new ArrayList();
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected boolean connectToHal() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            boolean r1 = true;
            this.mThermalHal11 = android.hardware.thermal.V1_1.IThermal.getService(true);     // Catch: Throwable -> L7 Throwable -> L9
            this.mThermalHal11.linkToDeath(new ThermalHalWrapper.DeathRecipient(this), 5612);     // Catch: Throwable -> L7 Throwable -> L9
            this.mThermalHal11.registerThermalCallback(this.mThermalCallback11);     // Catch: Throwable -> L7 Throwable -> L9
            Slog.i(ThermalHalWrapper.TAG, "Thermal HAL 1.1 service connected, limited thermal functions due to legacy API.");     // Catch: Throwable -> L7 Throwable -> L9
        L12:
            if (this.mThermalHal11 != null) goto L15;
            r1 = false;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        L10:
            Slog.e(ThermalHalWrapper.TAG, "Thermal HAL 1.1 service not connected.");     // Catch: Throwable -> L7
            this.mThermalHal11 = null;     // Catch: Throwable -> L7
            goto L12
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected float forecastSkinTemperature(int forecastSeconds) {
            throw new UnsupportedOperationException("Not supported in Thermal HAL 1.1");
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected void dump(PrintWriter pw, String prefix) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            pw.print(prefix);     // Catch: Throwable -> L7
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
            r1.append("ThermalHAL 1.1 connected: ");     // Catch: Throwable -> L7
            if (this.mThermalHal11 == null) goto L9;
            String r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
        L10:
            r1.append(r2);     // Catch: Throwable -> L7
            pw.println(r1.toString());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class ThermalHal20Wrapper extends ThermalHalWrapper {
        private final IThermalChangedCallback.Stub mThermalCallback20;
        private android.hardware.thermal.V2_0.IThermal mThermalHal20;

        public static /* synthetic */ void $r8$lambda$0QWkWTHrZlAvk1Mz2p8CAztAYhk(List r0, ThermalStatus r1, ArrayList r2) {
            lambda$getCurrentTemperatures$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$CNeDDEmI3mqmSW-V4elBr1jnNWg, reason: not valid java name */
        public static /* synthetic */ void m7597$r8$lambda$CNeDDEmI3mqmSWV4elBr1jnNWg(ThermalHal20Wrapper r0, List r1, ThermalStatus r2, ArrayList r3) {
            r0.lambda$getTemperatureThresholds$2(r1, r2, r3);
        }

        public static /* synthetic */ TemperatureThreshold $r8$lambda$X0z6Uh_PovrmcJVW60Nm1Y957Fc(ThermalHal20Wrapper r0, android.hardware.thermal.V2_0.TemperatureThreshold r1) {
            return r0.convertToAidlTemperatureThreshold(r1);
        }

        public static /* synthetic */ void $r8$lambda$Z4zq_jwjYrRXcqOwq3_aJ_c27Ic(List r0, ThermalStatus r1, ArrayList r2) {
            lambda$getCurrentCoolingDevices$1(r0, r1, r2);
        }

        ThermalHal20Wrapper(ThermalHalWrapper.WrapperThermalChangedCallback callback) {
            this.mThermalHal20 = null;
            this.mThermalCallback20 = new AnonymousClass1(this);
            this.mCallback = callback;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<Temperature> getCurrentTemperatures(boolean shouldFilter, int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<Temperature> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal20 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal20.getCurrentTemperatures(shouldFilter, type, new ThermalManagerService$ThermalHal20Wrapper$$ExternalSyntheticLambda3(ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentTemperatures, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentTemperatures$0(List ret, ThermalStatus status, ArrayList temperatures) {
            if (status.code != 0) goto L12;
            Iterator r0 = temperatures.iterator();
        L6:
            if (r0.hasNext() == false) goto L17;
            android.hardware.thermal.V2_0.Temperature temperature = (android.hardware.thermal.V2_0.Temperature) r0.next();
            if (Temperature.isValidStatus(temperature.throttlingStatus) == true) goto L10;
            Slog.e(ThermalHalWrapper.TAG, "Invalid status data from HAL");
            temperature.throttlingStatus = 0;
        L10:
            ret.add(new Temperature(temperature.value, temperature.type, temperature.name, temperature.throttlingStatus));
            goto L6
        L17:
            return;
        L12:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get temperatures because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<CoolingDevice> getCurrentCoolingDevices(boolean shouldFilter, int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<CoolingDevice> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal20 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal20.getCurrentCoolingDevices(shouldFilter, type, new ThermalManagerService$ThermalHal20Wrapper$$ExternalSyntheticLambda1(ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices, reconnecting...", e);     // Catch: Throwable -> L8
            connectToHal();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getCurrentCoolingDevices$1(List ret, ThermalStatus status, ArrayList coolingDevices) {
            if (status.code != 0) goto L9;
            Iterator r0 = coolingDevices.iterator();
        L6:
            if (r0.hasNext() == false) goto L12;
            android.hardware.thermal.V2_0.CoolingDevice coolingDevice = (android.hardware.thermal.V2_0.CoolingDevice) r0.next();
            ret.add(new CoolingDevice(coolingDevice.value, coolingDevice.type, coolingDevice.name));
            goto L6
        L12:
            return;
        L9:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get cooling device because of HAL error: " + status.debugMessage);
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<TemperatureThreshold> getTemperatureThresholds(boolean shouldFilter, int type) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            final List<TemperatureThreshold> ret = new ArrayList();     // Catch: Throwable -> L8
            if (this.mThermalHal20 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L18:
            this.mThermalHal20.getTemperatureThresholds(shouldFilter, type, new ThermalManagerService$ThermalHal20Wrapper$$ExternalSyntheticLambda2(this, ret));     // Catch: Throwable -> L8 RemoteException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return ret;
        L12:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getTemperatureThresholds, reconnecting...", e);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$getTemperatureThresholds$2(List ret, ThermalStatus status, ArrayList thresholds) {
            if (status.code != 0) goto L5;
            ret.addAll((Collection) thresholds.stream().map(new ThermalManagerService$ThermalHal20Wrapper$$ExternalSyntheticLambda0(this)).collect(Collectors.toList()));
            return;
        L5:
            Slog.e(ThermalHalWrapper.TAG, "Couldn't get temperature thresholds because of HAL error: " + status.debugMessage);
        }

        private TemperatureThreshold convertToAidlTemperatureThreshold(android.hardware.thermal.V2_0.TemperatureThreshold threshold) {
            TemperatureThreshold ret = new TemperatureThreshold();
            ret.name = threshold.name;
            ret.type = threshold.type;
            ret.coldThrottlingThresholds = threshold.coldThrottlingThresholds;
            ret.hotThrottlingThresholds = threshold.hotThrottlingThresholds;
            return ret;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected boolean connectToHal() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            boolean r1 = true;
            this.mThermalHal20 = android.hardware.thermal.V2_0.IThermal.getService(true);     // Catch: Throwable -> L7 Throwable -> L9
            this.mThermalHal20.linkToDeath(new ThermalHalWrapper.DeathRecipient(this), 5612);     // Catch: Throwable -> L7 Throwable -> L9
            this.mThermalHal20.registerThermalChangedCallback(this.mThermalCallback20, false, 0);     // Catch: Throwable -> L7 Throwable -> L9
            Slog.i(ThermalHalWrapper.TAG, "Thermal HAL 2.0 service connected.");     // Catch: Throwable -> L7 Throwable -> L9
        L12:
            if (this.mThermalHal20 != null) goto L15;
            r1 = false;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        L10:
            Slog.e(ThermalHalWrapper.TAG, "Thermal HAL 2.0 service not connected.");     // Catch: Throwable -> L7
            this.mThermalHal20 = null;     // Catch: Throwable -> L7
            goto L12
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected float forecastSkinTemperature(int forecastSeconds) {
            throw new UnsupportedOperationException("Not supported in Thermal HAL 2.0");
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected void dump(PrintWriter pw, String prefix) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            pw.print(prefix);     // Catch: Throwable -> L7
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
            r1.append("ThermalHAL 2.0 connected: ");     // Catch: Throwable -> L7
            if (this.mThermalHal20 == null) goto L9;
            String r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
        L10:
            r1.append(r2);     // Catch: Throwable -> L7
            pw.println(r1.toString());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class ThermalHalAidlWrapper extends ThermalHalWrapper implements IBinder.DeathRecipient {
        private android.hardware.thermal.IThermal mInstance;
        private final android.hardware.thermal.IThermalChangedCallback mThermalCallbackAidl;

        public static /* synthetic */ boolean $r8$lambda$eU14JIDh7_eSiFFdcxpGZaa7E5A(int r0, TemperatureThreshold r1) {
            return lambda$getTemperatureThresholds$0(r0, r1);
        }

        private android.hardware.thermal.IThermal getHalInstance() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            android.hardware.thermal.IThermal r1 = this.mInstance;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        ThermalHalAidlWrapper(ThermalHalWrapper.WrapperThermalChangedCallback callback) {
            this.mInstance = null;
            this.mThermalCallbackAidl = new AnonymousClass1(this);
            this.mCallback = callback;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<Temperature> getCurrentTemperatures(boolean shouldFilter, int type) {
            android.hardware.thermal.IThermal instance = getHalInstance();
            List<Temperature> ret = new ArrayList();
            if (instance != null) goto L40;
            return ret;
        L40:
            if (shouldFilter == false) goto L11;
            android.hardware.thermal.Temperature[] halRet = instance.getTemperaturesWithType(type);     // Catch: RemoteException -> L7 Throwable -> L9
        L13:
            if (halRet != null) goto L15;
            return ret;
        L15:
            int r3 = halRet.length;     // Catch: RemoteException -> L7 Throwable -> L9
            int r5 = 0;
        L16:
            if (r5 >= r3) goto L37;
            android.hardware.thermal.Temperature t = halRet[r5];     // Catch: RemoteException -> L7 Throwable -> L9
            if (Temperature.isValidStatus(t.throttlingStatus) == true) goto L20;
            Slog.e(ThermalHalWrapper.TAG, "Invalid temperature status " + t.throttlingStatus + " received from AIDL HAL");     // Catch: RemoteException -> L7 Throwable -> L9
            t.throttlingStatus = 0;     // Catch: RemoteException -> L7 Throwable -> L9
        L20:
            if (shouldFilter == true) goto L22;
        L24:
            ret.add(new Temperature(t.value, t.type, t.name, t.throttlingStatus));     // Catch: RemoteException -> L7 Throwable -> L9
        L25:
            r5 = r5 + 1;
            goto L16
        L22:
            if (t.type == type) goto L24;
        L37:
            return ret;
        L11:
            halRet = instance.getTemperatures();     // Catch: RemoteException -> L7 Throwable -> L9
        L7:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentTemperatures, reconnecting", e);
            monitor-enter(this.mHalLock);
            connectToHalIfNeededLocked(instance);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices due to invalid status", e);
            goto L37
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<CoolingDevice> getCurrentCoolingDevices(boolean shouldFilter, int type) {
            android.hardware.thermal.IThermal instance = getHalInstance();
            List<CoolingDevice> ret = new ArrayList();
            if (instance != null) goto L40;
            return ret;
        L40:
            if (shouldFilter == false) goto L11;
            android.hardware.thermal.CoolingDevice[] halRet = instance.getCoolingDevicesWithType(type);     // Catch: RemoteException -> L7 Throwable -> L9
        L13:
            if (halRet != null) goto L15;
            return ret;
        L15:
            int r3 = halRet.length;     // Catch: RemoteException -> L7 Throwable -> L9
            int r4 = 0;
        L16:
            if (r4 >= r3) goto L37;
            android.hardware.thermal.CoolingDevice t = halRet[r4];     // Catch: RemoteException -> L7 Throwable -> L9
            if (CoolingDevice.isValidType(t.type) == true) goto L20;
            Slog.e(ThermalHalWrapper.TAG, "Invalid cooling device type " + t.type + " from AIDL HAL");     // Catch: RemoteException -> L7 Throwable -> L9
        L25:
            r4 = r4 + 1;
            goto L16
        L20:
            if (shouldFilter == true) goto L22;
        L24:
            ret.add(new CoolingDevice(t.value, t.type, t.name));     // Catch: RemoteException -> L7 Throwable -> L9
            goto L25
        L22:
            if (t.type == type) goto L24;
        L37:
            return ret;
        L11:
            halRet = instance.getCoolingDevices();     // Catch: RemoteException -> L7 Throwable -> L9
        L7:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices, reconnecting", e);
            monitor-enter(this.mHalLock);
            connectToHalIfNeededLocked(instance);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getCurrentCoolingDevices due to invalid status", e);
            goto L37
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected List<TemperatureThreshold> getTemperatureThresholds(boolean shouldFilter, final int type) {
            android.hardware.thermal.IThermal instance = getHalInstance();
            List<TemperatureThreshold> ret = new ArrayList();
            if (instance != null) goto L32;
            return ret;
        L32:
            if (shouldFilter == false) goto L11;
            TemperatureThreshold[] halRet = instance.getTemperatureThresholdsWithType(type);     // Catch: RemoteException -> L7 Throwable -> L9
        L13:
            if (halRet != null) goto L15;
            return ret;
        L15:
            if (shouldFilter == false) goto L19;
            return (List) Arrays.stream(halRet).filter(new ThermalManagerService$ThermalHalAidlWrapper$$ExternalSyntheticLambda0(type)).collect(Collectors.toList());
        L19:
            return Arrays.asList(halRet);
        L11:
            halRet = instance.getTemperatureThresholds();     // Catch: RemoteException -> L7 Throwable -> L9
        L7:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getTemperatureThresholds, reconnecting...", e);
            monitor-enter(this.mHalLock);
            connectToHalIfNeededLocked(instance);     // Catch: Throwable -> L25
        L29:
            return ret;
        L25:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't getTemperatureThresholds due to invalid status", e);
            goto L29
        }

        private static /* synthetic */ boolean lambda$getTemperatureThresholds$0(int type, TemperatureThreshold t) {
            if (t.type != type) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected float forecastSkinTemperature(int forecastSeconds) {
            android.hardware.thermal.IThermal instance = getHalInstance();
            if (instance != null) goto L16;
            return Float.NaN;
        L16:
            return instance.forecastSkinTemperature(forecastSeconds);
        L7:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't forecastSkinTemperature, reconnecting...", e);
            monitor-enter(this.mHalLock);
            connectToHalIfNeededLocked(instance);     // Catch: Throwable -> L13
            return Float.NaN;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected boolean connectToHal() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            boolean r1 = connectToHalIfNeededLocked(this.mInstance);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        protected boolean connectToHalIfNeededLocked(android.hardware.thermal.IThermal instance) {
            if (instance == this.mInstance) goto L5;
            return true;
        L5:
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService(android.hardware.thermal.IThermal.DESCRIPTOR + "/default"));
            initProxyAndRegisterCallbackLocked(binder);
            if (this.mInstance != null) goto L10;
            return false;
        L10:
            return true;
        }

        void initProxyAndRegisterCallback(IBinder binder) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            initProxyAndRegisterCallbackLocked(binder);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        protected void initProxyAndRegisterCallbackLocked(IBinder binder) {
            if (binder == null) goto L23;
            this.mInstance = android.hardware.thermal.IThermal.Stub.asInterface(binder);
            binder.linkToDeath(this, 0);     // Catch: RemoteException -> L7
        L10:
            if (this.mInstance == null) goto L30;
            Slog.i(ThermalHalWrapper.TAG, "Thermal HAL AIDL service connected with version " + this.mInstance.getInterfaceVersion());     // Catch: RemoteException -> L20
            this.mInstance.registerThermalChangedCallback(this.mThermalCallbackAidl);     // Catch: RemoteException -> L14 Throwable -> L16
        L32:
            return;
        L14:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Unable to connect IThermal AIDL instance", e);
            connectToHal();
            return;
        L16:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Couldn't registerThermalChangedCallback due to invalid status", e);
            return;
        L20:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Unable to read interface version from Thermal HAL", e);
            connectToHal();
            return;
        L30:
            return;
        L7:
            e = move-exception;
            Slog.e(ThermalHalWrapper.TAG, "Unable to connect IThermal AIDL instance", e);
            connectToHal();
            goto L10
        }

        @Override // com.android.server.power.ThermalManagerService.ThermalHalWrapper
        protected void dump(PrintWriter pw, String prefix) {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            pw.print(prefix);     // Catch: Throwable -> L7
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
            r1.append("ThermalHAL AIDL 3  connected: ");     // Catch: Throwable -> L7
            if (this.mInstance == null) goto L9;
            String r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
        L10:
            r1.append(r2);     // Catch: Throwable -> L7
            pw.println(r1.toString());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public synchronized void binderDied() {
            monitor-enter(this);
            Slog.w(ThermalHalWrapper.TAG, "Thermal AIDL HAL died, reconnecting...");     // Catch: Throwable -> L6
            connectToHal();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static abstract class ThermalHalWrapper {
        protected static final String TAG = null;
        protected static final int THERMAL_HAL_DEATH_COOKIE = 5612;
        protected WrapperThermalChangedCallback mCallback;
        protected final Object mHalLock;

        final class DeathRecipient implements IHwBinder.DeathRecipient {
            final /* synthetic */ ThermalHalWrapper this$0;

            DeathRecipient(ThermalHalWrapper this$0) {
                this.this$0 = this$0;
            }

            public void serviceDied(long cookie) {
                if (cookie != 5612) goto L12;
                Slog.e(ThermalHalWrapper.TAG, "Thermal HAL service died cookie: " + cookie);
                Object r0 = this.this$0.mHalLock;
                monitor-enter(r0);
                this.this$0.connectToHal();     // Catch: Throwable -> L9
                this.this$0.resendCurrentTemperatures();     // Catch: Throwable -> L9
                monitor-exit(r0);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }
        }

        interface WrapperThermalChangedCallback {
            void onTemperatureChanged(Temperature r1);

            void onThresholdChanged(TemperatureThreshold r1);
        }

        protected abstract boolean connectToHal();

        protected abstract void dump(PrintWriter r1, String r2);

        protected abstract float forecastSkinTemperature(int r1);

        protected abstract List<CoolingDevice> getCurrentCoolingDevices(boolean r1, int r2);

        protected abstract List<Temperature> getCurrentTemperatures(boolean r1, int r2);

        protected abstract List<TemperatureThreshold> getTemperatureThresholds(boolean r1, int r2);

        ThermalHalWrapper() {
            this.mHalLock = new Object();
        }

        static {
            TAG = ThermalHalWrapper.class.getSimpleName();
        }

        protected void setCallback(WrapperThermalChangedCallback cb) {
            this.mCallback = cb;
        }

        protected void resendCurrentTemperatures() {
            Object r0 = this.mHalLock;
            monitor-enter(r0);
            List<Temperature> temperatures = getCurrentTemperatures(false, 0);     // Catch: Throwable -> L8
            int count = temperatures.size();     // Catch: Throwable -> L8
            int i = 0;
        L6:
            if (i >= count) goto L11;
            this.mCallback.onTemperatureChanged(temperatures.get(i));     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L6
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    class ThermalShellCommand extends ShellCommand {
        final /* synthetic */ ThermalManagerService this$0;

        ThermalShellCommand(ThermalManagerService this$0) {
            this.this$0 = this$0;
        }

        public int onCommand(String cmd) {
            if (cmd == null) goto L4;
            String r0 = cmd;
        L6:
            switch(r0.hashCode()) {
                case -1114874181: goto L18;
                case -61558984: goto L15;
                case 108404047: goto L12;
                case 385515795: goto L9;
                default: goto L20;
            };
        L20:
            byte r1 = -1;
        L21:
            switch(r1) {
                case 0: goto L31;
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L25;
                default: goto L23;
            };
        L23:
            return handleDefaultCommands(cmd);
        L25:
            return runHeadroom();
        L27:
            return runReset();
        L29:
            return runOverrideStatus();
        L31:
            return runInjectTemperature();
        L9:
            if (r0.equals("override-status") == false) goto L20;
            r1 = 1;
            goto L21
        L12:
            if (r0.equals("reset") == false) goto L20;
            r1 = 2;
            goto L21
        L15:
            if (r0.equals("inject-temperature") == false) goto L20;
            r1 = 0;
            goto L21
        L18:
            if (r0.equals("headroom") == false) goto L20;
            r1 = 3;
            goto L21
        L4:
            r0 = "";
            goto L6
        }

        private int runReset() {
            long token = Binder.clearCallingIdentity();
            Object r2 = ThermalManagerService.m7571$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            ThermalManagerService.m7578$$Nest$fputmIsStatusOverride(this.this$0, false);     // Catch: Throwable -> L9
            ThermalManagerService.m7582$$Nest$monTemperatureMapChangedLocked(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return 0;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private int runInjectTemperature() {
            long token = Binder.clearCallingIdentity();
            PrintWriter pw = getOutPrintWriter();     // Catch: Throwable -> L9
            String typeName = getNextArgRequired();     // Catch: Throwable -> L9
            String r0 = typeName.toUpperCase();     // Catch: Throwable -> L9
            byte r6 = 2;
            switch(r0.hashCode()) {
                case -1905220446: goto L69;
                case -1290540065: goto L66;
                case -697981146: goto L63;
                case -174162312: goto L60;
                case 66952: goto L57;
                case 70796: goto L54;
                case 77523: goto L51;
                case 82279: goto L48;
                case 83289: goto L45;
                case 2461479: goto L42;
                case 2547069: goto L39;
                case 2664213: goto L36;
                case 73532170: goto L33;
                case 386661166: goto L30;
                case 386742765: goto L27;
                case 433141802: goto L24;
                case 443104892: goto L21;
                case 864826154: goto L18;
                case 869307255: goto L15;
                case 1359385925: goto L12;
                case 1980544805: goto L7;
                default: goto L71;
            };     // Catch: Throwable -> L9
        L71:
            byte r1 = -1;
        L72:
            switch(r1) {
                case 0: goto L96;
                case 1: goto L95;
                case 2: goto L94;
                case 3: goto L93;
                case 4: goto L92;
                case 5: goto L91;
                case 6: goto L90;
                case 7: goto L89;
                case 8: goto L88;
                case 9: goto L87;
                case 10: goto L86;
                case 11: goto L85;
                case 12: goto L84;
                case 13: goto L83;
                case 14: goto L82;
                case 15: goto L81;
                case 16: goto L80;
                case 17: goto L79;
                case 18: goto L78;
                case 19: goto L77;
                case 20: goto L76;
                default: goto L73;
            };     // Catch: Throwable -> L9
        L73:
            pw.println("Invalid temperature type: " + typeName);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return -1;
        L76:
            int type = 19;
        L97:
            String throttleName = getNextArgRequired();     // Catch: Throwable -> L9
            String r2 = throttleName.toUpperCase();     // Catch: Throwable -> L9
            switch(r2.hashCode()) {
                case -1852393868: goto L119;
                case -1560189025: goto L116;
                case 2402104: goto L113;
                case 72432886: goto L110;
                case 120640881: goto L107;
                case 163769603: goto L104;
                case 613283414: goto L101;
                default: goto L121;
            };     // Catch: Throwable -> L9
        L121:
            r6 = -1;
        L122:
            switch(r6) {
                case 0: goto L132;
                case 1: goto L131;
                case 2: goto L130;
                case 3: goto L129;
                case 4: goto L128;
                case 5: goto L127;
                case 6: goto L126;
                default: goto L123;
            };     // Catch: Throwable -> L9
        L123:
            pw.println("Invalid throttle status: " + throttleName);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return -1;
        L126:
            int throttle = 6;
        L133:
            String name = getNextArgRequired();     // Catch: Throwable -> L9
            float value = 28.0f;
            String valueStr = getNextArg();     // Catch: Throwable -> L9 RuntimeException -> L139
            if (valueStr == null) goto L142;
            value = Float.parseFloat(valueStr);     // Catch: Throwable -> L9 RuntimeException -> L139
            goto L142
        L142:
            ThermalManagerService.m7581$$Nest$monTemperatureChanged(this.this$0, new Temperature(value, type, name, throttle), true);     // Catch: Throwable -> L145
            Binder.restoreCallingIdentity(token);
            return 0;
        L139:
            ex = move-exception;
            pw.println("Error: " + ex.toString());     // Catch: Throwable -> L145
            Binder.restoreCallingIdentity(token);
            return -1;
        L145:
            ex = th;
        L151:
            Binder.restoreCallingIdentity(token);
            throw ex;
        L127:
            throttle = 5;
            goto L133
        L128:
            throttle = 4;
            goto L133
        L129:
            throttle = 3;
            goto L133
        L130:
            throttle = 2;
            goto L133
        L131:
            throttle = 1;
            goto L133
        L132:
            throttle = 0;
            goto L133
        L101:
            if (r2.equals("SHUTDOWN") == false) goto L121;
            r6 = 6;
            goto L122
        L104:
            if (r2.equals("MODERATE") == false) goto L121;
        L107:
            if (r2.equals("EMERGENCY") == false) goto L121;
            r6 = 5;
            goto L122
        L110:
            if (r2.equals("LIGHT") == false) goto L121;
            r6 = 1;
            goto L122
        L113:
            if (r2.equals("NONE") == false) goto L121;
            r6 = 0;
            goto L122
        L116:
            if (r2.equals(PriorityDump.PRIORITY_ARG_CRITICAL) == false) goto L121;
            r6 = 4;
            goto L122
        L119:
            if (r2.equals("SEVERE") == false) goto L121;
            r6 = 3;
            goto L122
        L77:
            type = 18;
            goto L97
        L78:
            type = 17;
            goto L97
        L79:
            type = 16;
            goto L97
        L80:
            type = 15;
            goto L97
        L81:
            type = 14;
            goto L97
        L82:
            type = 13;
            goto L97
        L83:
            type = 12;
            goto L97
        L84:
            type = 11;
            goto L97
        L85:
            type = 10;
            goto L97
        L86:
            type = 9;
            goto L97
        L87:
            type = 8;
            goto L97
        L88:
            type = 7;
            goto L97
        L89:
            type = 6;
            goto L97
        L90:
            type = 5;
            goto L97
        L91:
            type = 4;
            goto L97
        L92:
            type = 3;
            goto L97
        L93:
            type = 2;
            goto L97
        L94:
            type = 1;
            goto L97
        L95:
            type = 0;
            goto L97
        L96:
            type = -1;
            goto L97
        L7:
            if (r0.equals("CAMERA") == false) goto L71;
            r1 = 16;
            goto L72
        L12:
            if (r0.equals("BCL_CURRENT") == false) goto L71;
            r1 = 8;
            goto L72
        L15:
            if (r0.equals("POWER_AMPLIFIER") == false) goto L71;
            r1 = 6;
            goto L72
        L18:
            if (r0.equals("BCL_VOLTAGE") == false) goto L71;
            r1 = 7;
            goto L72
        L21:
            if (r0.equals("USB_PORT") == false) goto L71;
            r1 = 5;
            goto L72
        L24:
            if (r0.equals("UNKNOWN") == false) goto L71;
            r1 = 0;
            goto L72
        L27:
            if (r0.equals("BATTERY") == false) goto L71;
            r1 = 3;
            goto L72
        L30:
            if (r0.equals("BCL_PERCENTAGE") == false) goto L71;
            r1 = 9;
            goto L72
        L33:
            if (r0.equals("MODEM") == false) goto L71;
            r1 = 13;
            goto L72
        L36:
            if (r0.equals("WIFI") == false) goto L71;
            r1 = 15;
            goto L72
        L39:
            if (r0.equals(SensorData.TEMPERATURE_TYPE_SKIN) == false) goto L71;
            r1 = 4;
            goto L72
        L42:
            if (r0.equals("POGO") == false) goto L71;
            r1 = ParameterName.BLACK_STRETCH;
            goto L72
        L45:
            if (r0.equals("TPU") == false) goto L71;
            r1 = 11;
            goto L72
        L48:
            if (r0.equals("SOC") == false) goto L71;
            r1 = 14;
            goto L72
        L51:
            if (r0.equals("NPU") == false) goto L71;
            r1 = 10;
            goto L72
        L54:
            if (r0.equals("GPU") == false) goto L71;
            r1 = 2;
            goto L72
        L57:
            if (r0.equals("CPU") == false) goto L71;
            r1 = 1;
            goto L72
        L60:
            if (r0.equals("AMBIENT") == false) goto L71;
            r1 = ParameterName.FILM_MODE;
            goto L72
        L63:
            if (r0.equals("FLASHLIGHT") == false) goto L71;
            r1 = ParameterName.DE_CONTOUR;
            goto L72
        L66:
            if (r0.equals("SPEAKER") == false) goto L71;
            r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
            goto L72
        L69:
            if (r0.equals(SensorData.TEMPERATURE_TYPE_DISPLAY) == false) goto L71;
            r1 = 12;
        L9:
            ex = th;
            goto L151
        }

        private int runOverrideStatus() {
            long token = Binder.clearCallingIdentity();
            PrintWriter pw = getOutPrintWriter();     // Catch: Throwable -> L11
            int status = Integer.parseInt(getNextArgRequired());     // Catch: Throwable -> L11 RuntimeException -> L22
        L7:
            if (Temperature.isValidStatus(status) == true) goto L13;
            pw.println("Invalid status: " + status);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return -1;
        L13:
            Object r3 = ThermalManagerService.m7571$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L11
            monitor-enter(r3);     // Catch: Throwable -> L11
            ThermalManagerService.m7578$$Nest$fputmIsStatusOverride(this.this$0, true);     // Catch: Throwable -> L19
            ThermalManagerService.m7587$$Nest$msetStatusLocked(this.this$0, status);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return 0;
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L22:
            ex = move-exception;
            pw.println("Error: " + ex.toString());     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return -1;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private int runHeadroom() {
            long token = Binder.clearCallingIdentity();
            PrintWriter pw = getOutPrintWriter();     // Catch: Throwable -> L11
            int forecastSecs = Integer.parseInt(getNextArgRequired());     // Catch: Throwable -> L11 RuntimeException -> L23
        L7:
            if (ThermalManagerService.m7569$$Nest$fgetmHalReady(this.this$0).get() == true) goto L13;
            pw.println("Error: thermal HAL is not ready");     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return -1;
        L13:
            if (forecastSecs >= 0) goto L15;
        L20:
            pw.println("Error: forecast second input should be in range [0,60]");     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return -1;
        L15:
            if (forecastSecs > 60) goto L20;
            float headroom = this.this$0.mTemperatureWatcher.getForecast(forecastSecs);     // Catch: Throwable -> L11
            pw.println("Headroom in " + forecastSecs + " seconds: " + headroom);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return 0;
        L23:
            ex = move-exception;
            pw.println("Error: " + ex);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return -1;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Thermal service (thermalservice) commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println("");
            pw.println("  inject-temperature TYPE STATUS NAME [VALUE]");
            pw.println("    injects a new temperature sample for the specified device.");
            pw.println("    type and status strings follow the names in android.os.Temperature.");
            pw.println("  override-status STATUS");
            pw.println("    sets and locks the thermal status of the device to STATUS.");
            pw.println("    status code is defined in android.os.Temperature.");
            pw.println("  reset");
            pw.println("    unlocks the thermal status of the device.");
            pw.println("  headroom FORECAST_SECONDS");
            pw.println("    gets the thermal headroom forecast in specified seconds, from [0,60].");
            pw.println();
        }
    }

    private static final class ThermalStatusListenerInfo {
        final String mPackageName;
        final int mUid;

        ThermalStatusListenerInfo(int uid, String packageName) {
            this.mUid = uid;
            this.mPackageName = packageName;
        }
    }

    public static /* synthetic */ void $r8$lambda$ASkelQx7ObZp39DIf07s31z7EbQ(IThermalEventListener r0, Temperature r1) {
        lambda$postEventListenerLocked$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$AtFHHYzDaNwuSnQLn-Gyka2zSqc, reason: not valid java name */
    public static /* synthetic */ void m7568$r8$lambda$AtFHHYzDaNwuSnQLnGyka2zSqc(ThermalManagerService r0, IThermalStatusListener r1, int r2, String r3) {
        r0.lambda$postStatusListenerLocked$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$TCx0uaDSfF1I7RIW8ROHoyvcWaU(HeadroomCallbackData r0, IThermalHeadroomListener r1) {
        lambda$postHeadroomListenerLocked$1(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$z9NcPtwTeHlS7upCK3afprPBUug(ThermalManagerService r0, int r1, List r2) {
        return r0.onPullAtom(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHalReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m7569$$Nest$fgetmHalReady(ThermalManagerService r0) {
        return r0.mHalReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHalWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ ThermalHalWrapper m7570$$Nest$fgetmHalWrapper(ThermalManagerService r0) {
        return r0.mHalWrapper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7571$$Nest$fgetmLock(ThermalManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPerfSkinOptListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m7572$$Nest$fgetmPerfSkinOptListeners(ThermalManagerService r0) {
        return r0.mPerfSkinOptListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7573$$Nest$fgetmStatus(ThermalManagerService r0) {
        return r0.mStatus;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTemperatureMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7574$$Nest$fgetmTemperatureMap(ThermalManagerService r0) {
        return r0.mTemperatureMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThermalEventListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m7575$$Nest$fgetmThermalEventListeners(ThermalManagerService r0) {
        return r0.mThermalEventListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThermalHeadroomListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m7576$$Nest$fgetmThermalHeadroomListeners(ThermalManagerService r0) {
        return r0.mThermalHeadroomListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThermalStatusListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m7577$$Nest$fgetmThermalStatusListeners(ThermalManagerService r0) {
        return r0.mThermalStatusListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsStatusOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7578$$Nest$fputmIsStatusOverride(ThermalManagerService r0, boolean r1) {
        r0.mIsStatusOverride = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAndNotifyHeadroomListenersLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7579$$Nest$mcheckAndNotifyHeadroomListenersLocked(ThermalManagerService r0, HeadroomCallbackData r1) {
        r0.checkAndNotifyHeadroomListenersLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateThermalStatusListenerInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ ThermalStatusListenerInfo m7580$$Nest$mcreateThermalStatusListenerInfo(ThermalManagerService r0, int r1) {
        return r0.createThermalStatusListenerInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTemperatureChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7581$$Nest$monTemperatureChanged(ThermalManagerService r0, Temperature r1, boolean r2) {
        r0.onTemperatureChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monTemperatureMapChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7582$$Nest$monTemperatureMapChangedLocked(ThermalManagerService r0) {
        r0.onTemperatureMapChangedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mpostEventListenerCurrentTemperaturesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7583$$Nest$mpostEventListenerCurrentTemperaturesLocked(ThermalManagerService r0, IThermalEventListener r1, Integer r2) {
        r0.postEventListenerCurrentTemperaturesLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostEventListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7584$$Nest$mpostEventListenerLocked(ThermalManagerService r0, Temperature r1, IThermalEventListener r2, Integer r3) {
        r0.postEventListenerLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostHeadroomListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7585$$Nest$mpostHeadroomListenerLocked(ThermalManagerService r0, IThermalHeadroomListener r1, HeadroomCallbackData r2) {
        r0.postHeadroomListenerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostStatusListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7586$$Nest$mpostStatusListenerLocked(ThermalManagerService r0, IThermalStatusListener r1, int r2, String r3) {
        r0.postStatusListenerLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetStatusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7587$$Nest$msetStatusLocked(ThermalManagerService r0, int r1) {
        r0.setStatusLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7588$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smthermalSeverityToStatsdStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7589$$Nest$smthermalSeverityToStatsdStatus(int r0) {
        return thermalSeverityToStatsdStatus(r0);
    }

    static {
        TAG = ThermalManagerService.class.getSimpleName();
    }

    public ThermalManagerService(Context context) {
        this(context, null);
    }

    ThermalManagerService(Context context, ThermalHalWrapper halWrapper) {
        super(context);
        this.mLock = new Object();
        this.mThermalEventListeners = new RemoteCallbackList();
        this.mPerfSkinOptListeners = new RemoteCallbackList();
        this.mThermalStatusListeners = new RemoteCallbackList();
        this.mThermalHeadroomListeners = new RemoteCallbackList();
        this.mLastHeadroomCallbackData = null;
        this.mTemperatureMap = new ArrayMap();
        this.mHalReady = new AtomicBoolean();
        this.mIsHalSkinForecastSupported = new AtomicBoolean(false);
        this.mWrapperCallback = new AnonymousClass1(this);
        this.mService = new AnonymousClass2(this);
        this.mContext = context;
        this.mHalWrapper = halWrapper;
        if (halWrapper == null) goto L5;
        halWrapper.setCallback(this.mWrapperCallback);
    L5:
        this.mStatus = 0;
        this.mTemperatureWatcher = new TemperatureWatcher(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("thermalservice", this.mService);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        onActivityManagerReady();
    L6:
        if (phase != 1000) goto L9;
        registerStatsCallbacks();
        return;
    }

    private void onActivityManagerReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mHalWrapper == null) goto L7;
        boolean halConnected = true;
    L8:
        if (halConnected == true) goto L12;
        this.mHalWrapper = new ThermalHalAidlWrapper(this.mWrapperCallback);     // Catch: Throwable -> L10
        halConnected = this.mHalWrapper.connectToHal();     // Catch: Throwable -> L10
    L12:
        if (halConnected == true) goto L14;
        this.mHalWrapper = new ThermalHal20Wrapper(this.mWrapperCallback);     // Catch: Throwable -> L10
        halConnected = this.mHalWrapper.connectToHal();     // Catch: Throwable -> L10
    L14:
        if (halConnected == true) goto L16;
        this.mHalWrapper = new ThermalHal11Wrapper(this.mWrapperCallback);     // Catch: Throwable -> L10
        halConnected = this.mHalWrapper.connectToHal();     // Catch: Throwable -> L10
    L16:
        if (halConnected == true) goto L18;
        this.mHalWrapper = new ThermalHal10Wrapper(this.mWrapperCallback);     // Catch: Throwable -> L10
        halConnected = this.mHalWrapper.connectToHal();     // Catch: Throwable -> L10
    L18:
        if (halConnected == true) goto L22;
        Slog.w(TAG, "No Thermal HAL service on this device");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L22:
        List<Temperature> temperatures = this.mHalWrapper.getCurrentTemperatures(false, 0);     // Catch: Throwable -> L10
        int count = temperatures.size();     // Catch: Throwable -> L10
        if (count != 0) goto L25;
        Slog.w(TAG, "Thermal HAL reported invalid data, abort connection");     // Catch: Throwable -> L10
    L25:
        int i = 0;
    L26:
        if (i >= count) goto L28;
        onTemperatureChanged(temperatures.get(i), false);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L26
    L28:
        onTemperatureMapChangedLocked();     // Catch: Throwable -> L10
        this.mTemperatureWatcher.getAndUpdateThresholds();     // Catch: Throwable -> L10
        ArrayMap<String, ArrayList<TemperatureWatcher.Sample>> r6 = this.mTemperatureWatcher.mSamples;     // Catch: Throwable -> L10
        monitor-enter(r6);     // Catch: Throwable -> L10
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L31:
        if (this.mTemperatureWatcher.mSevereThresholds.size() == 1) goto L48;
    L38:
        monitor-exit(r6);     // Catch: Throwable -> L34
        this.mHalReady.set(true);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L48:
        this.mIsHalSkinForecastSupported.set(false);     // Catch: Throwable -> L34 UnsupportedOperationException -> L36
    L37:
        Slog.i(TAG, "Thermal HAL does not support forecastSkinTemperature");     // Catch: Throwable -> L34
        goto L38
    L7:
        halConnected = false;
        goto L8
    }

    private void postStatusListenerLocked(final IThermalStatusListener listener, final int listenerUid, final String listenerPackageName) {
        boolean thermalCallbackQueued = FgThread.getHandler().post(new ThermalManagerService$$ExternalSyntheticLambda0(this, listener, listenerUid, listenerPackageName));
        if (thermalCallbackQueued == true) goto L6;
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteThermalStatusCallbackFailed("callback_queue_fail", this.mStatus, listenerUid, listenerPackageName, "queue_post_failed");
        Slog.e(TAG, "Thermal status callback failed to queue");
        return;
    }

    private /* synthetic */ void lambda$postStatusListenerLocked$0(IThermalStatusListener listener, int listenerUid, String listenerPackageName) {
        listener.onStatusChange(this.mStatus);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteThermalStatusCallbackFailed("callback_fail", this.mStatus, listenerUid, listenerPackageName, e.getClass().getSimpleName());
        Slog.e(TAG, "Thermal status callback failed to call", e);
    }

    private ThermalStatusListenerInfo createThermalStatusListenerInfo(int uid) {
        PackageManager packageManager = this.mContext.getPackageManager();
        String packageName = "uid:" + uid;
        if (packageManager == null) goto L19;
        String[] packageNames = packageManager.getPackagesForUid(uid);     // Catch: RuntimeException -> L9
        if (packageNames != null) goto L7;
    L11:
        String nameForUid = packageManager.getNameForUid(uid);     // Catch: RuntimeException -> L9
        if (nameForUid != null) goto L14;
    L20:
        goto L19
    L14:
        if (nameForUid.isEmpty() == true) goto L20;
        packageName = nameForUid;
        goto L20
    L7:
        if (packageNames.length <= 0) goto L11;
        packageName = packageNames[0];     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        Slog.w(TAG, "Failed to resolve package name for thermal status listener uid=" + uid, e);
    L19:
        return new ThermalStatusListenerInfo(uid, packageName);
    }

    private void notifyStatusListenersLocked() {
        int length = this.mThermalStatusListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= length) goto L22;
        IThermalStatusListener listener = (IThermalStatusListener) this.mThermalStatusListeners.getBroadcastItem(i);     // Catch: Throwable -> L7
        Object cookie = this.mThermalStatusListeners.getBroadcastCookie(i);     // Catch: Throwable -> L7
        if ((cookie instanceof ThermalStatusListenerInfo) == false) goto L9;
        ThermalStatusListenerInfo listenerInfo = (ThermalStatusListenerInfo) cookie;     // Catch: Throwable -> L7
    L11:
        if (listenerInfo == null) goto L13;
        int r5 = listenerInfo.mUid;     // Catch: Throwable -> L7
    L15:
        if (listenerInfo == null) goto L17;
        String r6 = listenerInfo.mPackageName;     // Catch: Throwable -> L7
    L18:
        postStatusListenerLocked(listener, r5, r6);     // Catch: Throwable -> L7
        i = i + 1;
        goto L3
    L17:
        r6 = "unknown";
        goto L18
    L13:
        r5 = -1;
        goto L15
    L9:
        listenerInfo = null;
    L7:
        th = move-exception;
        this.mThermalStatusListeners.finishBroadcast();
        throw th;
    L22:
        this.mThermalStatusListeners.finishBroadcast();
    }

    private void postHeadroomListenerLocked(final IThermalHeadroomListener listener, final HeadroomCallbackData data) {
        if (this.mHalReady.get() == true) goto L5;
        return;
    L5:
        boolean thermalCallbackQueued = FgThread.getHandler().post(new ThermalManagerService$$ExternalSyntheticLambda2(data, listener));
        if (thermalCallbackQueued == true) goto L9;
        Slog.e(TAG, "Thermal headroom callback failed to queue");
        return;
    }

    private static /* synthetic */ void lambda$postHeadroomListenerLocked$1(HeadroomCallbackData data, IThermalHeadroomListener listener) {
    L7:
        e = move-exception;
        Slog.e(TAG, "Thermal headroom callback failed to call", e);
        return;
    L3:
        if (Float.isNaN(data.mHeadroom) == false) goto L5;
        return;
    L5:
        listener.onHeadroomChange(data.mHeadroom, data.mForecastHeadroom, data.mForecastSeconds, data.mHeadroomThresholds);     // Catch: Throwable -> L7
    }

    private void checkAndNotifyHeadroomListenersLocked(HeadroomCallbackData data) {
        if (HeadroomCallbackData.m7590$$Nest$misSignificantDifferentFrom(data, this.mLastHeadroomCallbackData) == false) goto L5;
    L7:
        this.mLastHeadroomCallbackTimeMillis = System.currentTimeMillis();
        this.mLastHeadroomCallbackData = data;
        int length = this.mThermalHeadroomListeners.beginBroadcast();
        int i = 0;
    L8:
        if (i >= length) goto L14;
        IThermalHeadroomListener listener = (IThermalHeadroomListener) this.mThermalHeadroomListeners.getBroadcastItem(i);     // Catch: Throwable -> L11
        postHeadroomListenerLocked(listener, data);     // Catch: Throwable -> L11
        i = i + 1;
    L11:
        th = move-exception;
        this.mThermalHeadroomListeners.finishBroadcast();
        throw th;
    L14:
        this.mThermalHeadroomListeners.finishBroadcast();
        return;
    L5:
        if (System.currentTimeMillis() >= (this.mLastHeadroomCallbackTimeMillis + 5000)) goto L7;
    }

    private void onTemperatureMapChangedLocked() {
        int newStatus = 0;
        int count = this.mTemperatureMap.size();
        int i = 0;
    L3:
        if (i >= count) goto L13;
        Temperature t = this.mTemperatureMap.valueAt(i);
        if (t.getType() != 3) goto L11;
        if (t.getStatus() < newStatus) goto L11;
        if ("perf_skin_opt".equals(t.getName()) == true) goto L11;
        newStatus = t.getStatus();
    L11:
        i = i + 1;
        goto L3
    L13:
        if (this.mIsStatusOverride == true) goto L21;
        setStatusLocked(newStatus);
        return;
    }

    private void setStatusLocked(int newStatus) {
        if (newStatus == this.mStatus) goto L6;
        Trace.traceCounter(131072, "ThermalManagerService.status", newStatus);
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteThermalStatusChanged(newStatus, this.mStatus);
        this.mStatus = newStatus;
        notifyStatusListenersLocked();
        return;
    }

    private void postEventListenerCurrentTemperaturesLocked(IThermalEventListener listener, Integer type) {
        int count = this.mTemperatureMap.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        postEventListenerLocked(this.mTemperatureMap.valueAt(i), listener, type);
        i = i + 1;
        goto L3
    }

    private void postEventListenerLocked(final Temperature temperature, final IThermalEventListener listener, Integer type) {
        if (type != null) goto L4;
    L6:
        boolean thermalCallbackQueued = FgThread.getHandler().post(new ThermalManagerService$$ExternalSyntheticLambda1(listener, temperature));
        if (thermalCallbackQueued == true) goto L10;
        Slog.e(TAG, "Thermal event callback failed to queue");
        return;
    L10:
        return;
    L4:
        if (type.intValue() == temperature.getType()) goto L6;
    }

    private static /* synthetic */ void lambda$postEventListenerLocked$2(IThermalEventListener listener, Temperature temperature) {
        listener.notifyThrottling(temperature);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Thermal event callback failed to call", e);
    }

    private void notifyEventListenersLocked(Temperature temperature) {
        if (temperature.getType() == 3) goto L5;
    L14:
        int length = this.mThermalEventListeners.beginBroadcast();
        int i = 0;
    L15:
        if (i >= length) goto L21;
        IThermalEventListener listener = (IThermalEventListener) this.mThermalEventListeners.getBroadcastItem(i);     // Catch: Throwable -> L18
        Integer type = (Integer) this.mThermalEventListeners.getBroadcastCookie(i);     // Catch: Throwable -> L18
        postEventListenerLocked(temperature, listener, type);     // Catch: Throwable -> L18
        i = i + 1;
    L18:
        th = move-exception;
        this.mThermalEventListeners.finishBroadcast();
        throw th;
    L21:
        this.mThermalEventListeners.finishBroadcast();
    L22:
        EventLog.writeEvent(EventLogTags.THERMAL_CHANGED, new Object[]{temperature.getName(), Integer.valueOf(temperature.getType()), Float.valueOf(temperature.getValue()), Integer.valueOf(temperature.getStatus()), Integer.valueOf(this.mStatus)});
        return;
    L5:
        if ("perf_skin_opt".equals(temperature.getName()) == false) goto L14;
        int length2 = this.mPerfSkinOptListeners.beginBroadcast();
        int i2 = 0;
    L7:
        if (i2 >= length2) goto L13;
        IThermalEventListener listener2 = (IThermalEventListener) this.mPerfSkinOptListeners.getBroadcastItem(i2);     // Catch: Throwable -> L10
        postEventListenerLocked(temperature, listener2, null);     // Catch: Throwable -> L10
        i2 = i2 + 1;
    L10:
        th = move-exception;
        this.mPerfSkinOptListeners.finishBroadcast();
        throw th;
    L13:
        this.mPerfSkinOptListeners.finishBroadcast();
        goto L22
    }

    private void shutdownIfNeeded(Temperature temperature) {
        if (temperature.getStatus() == 6) goto L5;
        return;
    L5:
        PowerManager powerManager = (PowerManager) getContext().getSystemService(PowerManager.class);
        switch(temperature.getType()) {
            case 0: goto L9;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L9;
            case 9: goto L9;
            default: goto L12;
        };
    L8:
        powerManager.shutdown(false, "thermal,battery", false);
        return;
    L9:
        powerManager.shutdown(false, "thermal", false);
        return;
    }

    private void onTemperatureChanged(Temperature temperature, boolean sendCallback) {
        shutdownIfNeeded(temperature);
        Object r0 = this.mLock;
        monitor-enter(r0);
        Temperature old = this.mTemperatureMap.put(temperature.getName(), temperature);     // Catch: Throwable -> L9
        if (old == null) goto L11;
        if (old.getStatus() != temperature.getStatus()) goto L11;
    L13:
        if ("perf_skin_opt".equals(temperature.getName()) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        if (sendCallback == false) goto L18;
        onTemperatureMapChangedLocked();     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (sendCallback == true) goto L21;
        return;
    L21:
        if (temperature.getType() != 3) goto L45;
        ArrayMap<String, ArrayList<TemperatureWatcher.Sample>> r1 = this.mTemperatureWatcher.mSamples;
        monitor-enter(r1);
        TemperatureWatcher.m7593$$Nest$mupdateTemperatureSampleLocked(this.mTemperatureWatcher, System.currentTimeMillis(), temperature);     // Catch: Throwable -> L34
        TemperatureWatcher.m7592$$Nest$fgetmCachedHeadrooms(this.mTemperatureWatcher).clear();     // Catch: Throwable -> L34
        HeadroomCallbackData data = this.mTemperatureWatcher.getHeadroomCallbackDataLocked();     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
        Object r2 = this.mLock;
        monitor-enter(r2);
        checkAndNotifyHeadroomListenersLocked(data);     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    L45:
        return;
    L11:
        notifyEventListenersLocked(temperature);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void registerStatsCallbacks() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        if (statsManager == null) goto L6;
        statsManager.setPullAtomCallback(FrameworkStatsLog.THERMAL_HEADROOM_THRESHOLDS, null, ConcurrentUtils.DIRECT_EXECUTOR, new ThermalManagerService$$ExternalSyntheticLambda3(this));
        return;
    }

    private int onPullAtom(int atomTag, List<StatsEvent> data) {
        if (atomTag != 10201) goto L12;
        ArrayMap<String, ArrayList<TemperatureWatcher.Sample>> r1 = this.mTemperatureWatcher.mSamples;
        monitor-enter(r1);
        float[] thresholds = Arrays.copyOf(this.mTemperatureWatcher.mHeadroomThresholds, this.mTemperatureWatcher.mHeadroomThresholds.length);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.THERMAL_HEADROOM_THRESHOLDS, thresholds));
        return 0;
    L9:
        th = move-exception;
        throw th;
    L12:
        return 0;
    }

    private static int thermalSeverityToStatsdStatus(int severity) {
        switch(severity) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    }

    private static void dumpItemsLocked(PrintWriter pw, String prefix, Collection<?> items) {
        Iterator<?> r0 = items.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        pw.println(prefix + r0.next().toString());
        goto L4
    }

    private static void dumpTemperatureThresholds(PrintWriter pw, String prefix, List<TemperatureThreshold> thresholds) {
        Iterator<TemperatureThreshold> r0 = thresholds.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        TemperatureThreshold threshold = r0.next();
        pw.println(prefix + "TemperatureThreshold{mType=" + threshold.type + ", mName=" + threshold.name + ", mHotThrottlingThresholds=" + Arrays.toString(threshold.hotThrottlingThresholds) + ", mColdThrottlingThresholds=" + Arrays.toString(threshold.coldThrottlingThresholds) + "}");
        goto L4
    }

    void dumpInternal(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(getContext(), TAG, pw) == true) goto L5;
        return;
    L5:
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        pw.println("IsStatusOverride: " + this.mIsStatusOverride);     // Catch: Throwable -> L11
        pw.println("ThermalEventListeners:");     // Catch: Throwable -> L11
        this.mThermalEventListeners.dump(pw, "\t");     // Catch: Throwable -> L11
        pw.println("PerfSkinOptListeners:");     // Catch: Throwable -> L11
        this.mPerfSkinOptListeners.dump(pw, "\t");     // Catch: Throwable -> L11
        pw.println("ThermalStatusListeners:");     // Catch: Throwable -> L11
        this.mThermalStatusListeners.dump(pw, "\t");     // Catch: Throwable -> L11
        pw.println("Thermal Status: " + this.mStatus);     // Catch: Throwable -> L11
        pw.println("Cached temperatures:");     // Catch: Throwable -> L11
        dumpItemsLocked(pw, "\t", this.mTemperatureMap.values());     // Catch: Throwable -> L11
        pw.println("HAL Ready: " + this.mHalReady.get());     // Catch: Throwable -> L11
        if (this.mHalReady.get() == false) goto L13;
        pw.println("HAL connection:");     // Catch: Throwable -> L11
        this.mHalWrapper.dump(pw, "\t");     // Catch: Throwable -> L11
        pw.println("Current temperatures from HAL:");     // Catch: Throwable -> L11
        dumpItemsLocked(pw, "\t", this.mHalWrapper.getCurrentTemperatures(false, 0));     // Catch: Throwable -> L11
        pw.println("Current cooling devices from HAL:");     // Catch: Throwable -> L11
        dumpItemsLocked(pw, "\t", this.mHalWrapper.getCurrentCoolingDevices(false, 0));     // Catch: Throwable -> L11
        pw.println("Temperature static thresholds from HAL:");     // Catch: Throwable -> L11
        dumpTemperatureThresholds(pw, "\t", this.mHalWrapper.getTemperatureThresholds(false, 0));     // Catch: Throwable -> L11
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        ArrayMap<String, ArrayList<TemperatureWatcher.Sample>> r3 = this.mTemperatureWatcher.mSamples;     // Catch: Throwable -> L23
        monitor-enter(r3);     // Catch: Throwable -> L23
        pw.println("Temperature headroom thresholds:");     // Catch: Throwable -> L20
        pw.println(Arrays.toString(this.mTemperatureWatcher.mHeadroomThresholds));     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(token);
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
