package com.android.server.display;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.input.HostUsiVersion;
import android.os.Environment;
import android.text.TextUtils;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Spline;
import android.view.DisplayAddress;
import android.view.SurfaceControl;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.server.display.config.AutoBrightness;
import com.android.server.display.config.BlockingZoneConfig;
import com.android.server.display.config.BrightnessLimitMap;
import com.android.server.display.config.BrightnessThrottlingMap;
import com.android.server.display.config.BrightnessThrottlingPoint;
import com.android.server.display.config.Density;
import com.android.server.display.config.DisplayBrightnessMappingConfig;
import com.android.server.display.config.DisplayBrightnessPoint;
import com.android.server.display.config.DisplayConfiguration;
import com.android.server.display.config.DisplayQuirks;
import com.android.server.display.config.EvenDimmerBrightnessData;
import com.android.server.display.config.FullScreenAodMode;
import com.android.server.display.config.HdrBrightnessData;
import com.android.server.display.config.HighBrightnessMode;
import com.android.server.display.config.HighBrightnessModeData;
import com.android.server.display.config.HysteresisLevels;
import com.android.server.display.config.IdleScreenRefreshRateTimeout;
import com.android.server.display.config.IdleScreenRefreshRateTimeoutLuxThresholdPoint;
import com.android.server.display.config.IdleScreenRefreshRateTimeoutLuxThresholds;
import com.android.server.display.config.IntegerArray;
import com.android.server.display.config.LuxThrottling;
import com.android.server.display.config.NitsMap;
import com.android.server.display.config.NonNegativeFloatToFloatPoint;
import com.android.server.display.config.Point;
import com.android.server.display.config.PowerThrottlingConfig;
import com.android.server.display.config.PowerThrottlingMap;
import com.android.server.display.config.PowerThrottlingPoint;
import com.android.server.display.config.PredefinedBrightnessLimitNames;
import com.android.server.display.config.RefreshRateConfigs;
import com.android.server.display.config.RefreshRateData;
import com.android.server.display.config.RefreshRateRange;
import com.android.server.display.config.RefreshRateThrottlingMap;
import com.android.server.display.config.RefreshRateThrottlingPoint;
import com.android.server.display.config.RefreshRateZone;
import com.android.server.display.config.SensorData;
import com.android.server.display.config.ThermalStatus;
import com.android.server.display.config.ThermalThrottling;
import com.android.server.display.config.UsiVersion;
import com.android.server.display.config.XmlParser;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.utils.DebugUtils;
import com.android.server.display.utils.DeviceConfigParsingUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayDeviceConfig {
    private static final int AMBIENT_LIGHT_LONG_HORIZON_MILLIS = 10000;
    private static final int AMBIENT_LIGHT_SHORT_HORIZON_MILLIS = 2000;
    static final float BRIGHTNESS_DEFAULT = 0.5f;
    private static final String CONFIG_FILE_FORMAT = "display_%s.xml";
    private static final boolean DEBUG = false;
    private static final float[] DEFAULT_BRIGHTNESS_THRESHOLDS = null;
    private static final String DEFAULT_CONFIG_FILE = "default.xml";
    private static final String DEFAULT_CONFIG_FILE_WITH_UIMODE_FORMAT = "default_%s.xml";
    private static final int DEFAULT_HIGH_REFRESH_RATE = 0;
    public static final String DEFAULT_ID = "default";
    private static final int DEFAULT_IDLE_STYLUS_TIMEOUT_MILLIS = 0;
    public static final int DEFAULT_LOW_REFRESH_RATE = 60;
    private static final String DISPLAY_CONFIG_DIR = "displayconfig";
    private static final String ETC_DIR = "etc";
    static final float HDR_PERCENT_OF_SCREEN_REQUIRED_DEFAULT = 0.5f;
    public static final float HIGH_BRIGHTNESS_MODE_UNSUPPORTED = Float.NaN;
    private static final int INTERPOLATION_DEFAULT = 0;
    private static final int INTERPOLATION_LINEAR = 1;
    private static final int INVALID_AUTO_BRIGHTNESS_LIGHT_DEBOUNCE = -1;
    public static final float INVALID_BRIGHTNESS_IN_CONFIG = -2.0f;
    private static final int KEEP_CURRENT_BRIGHTNESS = -1;
    private static final int MAX_SPACED_ELEMENTS = 120;
    private static final String NO_SUFFIX_FORMAT = "%d";
    private static final String PORT_SUFFIX_FORMAT = "port_%d";
    public static final String QUIRK_CAN_SET_BRIGHTNESS_VIA_HWC = "canSetBrightnessViaHwc";
    private static final long STABLE_FLAG = 4611686018427387904L;
    private static final String STABLE_ID_SUFFIX_FORMAT = "id_%d";
    private static final String TAG = "DisplayDeviceConfig";
    private HysteresisLevels mAmbientBrightnessHysteresis;
    private HysteresisLevels mAmbientBrightnessIdleHysteresis;
    private int mAmbientHorizonLong;
    private int mAmbientHorizonShort;
    private SensorData mAmbientLightSensor;
    private boolean mAutoBrightnessAvailable;
    private long mAutoBrightnessBrighteningLightDebounce;
    private long mAutoBrightnessBrighteningLightDebounceIdle;
    private long mAutoBrightnessDarkeningLightDebounce;
    private long mAutoBrightnessDarkeningLightDebounceIdle;
    private float[] mBacklight;
    private float mBacklightMaximum;
    private float mBacklightMinimum;
    private Spline mBacklightToBrightnessSpline;
    private Spline mBacklightToNitsSpline;
    private float[] mBrightness;
    private float mBrightnessCapForWearBedtimeMode;
    private float mBrightnessDefault;
    private float mBrightnessDim;
    private long mBrightnessRampDecreaseMaxIdleMillis;
    private long mBrightnessRampDecreaseMaxMillis;
    private float mBrightnessRampFastDecrease;
    private float mBrightnessRampFastIncrease;
    private long mBrightnessRampIncreaseMaxIdleMillis;
    private long mBrightnessRampIncreaseMaxMillis;
    private float mBrightnessRampSlowDecrease;
    private float mBrightnessRampSlowDecreaseIdle;
    private float mBrightnessRampSlowIncrease;
    private float mBrightnessRampSlowIncreaseIdle;
    private Spline mBrightnessToBacklightSpline;
    private final Context mContext;
    private boolean mDdcAutoBrightnessAvailable;
    private float mDefaultDozeBrightness;
    private int mDefaultHighBlockingZoneRefreshRate;
    private int mDefaultLowBlockingZoneRefreshRate;
    private DensityMapping mDensityMapping;
    private DisplayBrightnessMappingConfig mDisplayBrightnessMapping;
    private float[] mDozeBrightnessSensorValueToBrightness;
    public EvenDimmerBrightnessData mEvenDimmerBrightnessData;
    private final DisplayManagerFlags mFlags;
    private FullScreenAodMode mFullScreenAodConfig;
    private HighBrightnessModeData mHbmData;
    private HdrBrightnessData mHdrBrightnessData;
    private float[] mHighAmbientBrightnessThresholds;
    private String mHighBlockingZoneThermalMapId;
    private float[] mHighDisplayBrightnessThresholds;
    private HostUsiVersion mHostUsiVersion;
    private List<IdleScreenRefreshRateTimeoutLuxThresholdPoint> mIdleScreenRefreshRateTimeoutLuxThresholds;
    private int mIdleStylusTimeoutMillis;
    private int mInterpolationType;
    private String mLoadedFrom;
    private float[] mLowAmbientBrightnessThresholds;
    private String mLowBlockingZoneThermalMapId;
    private float[] mLowDisplayBrightnessThresholds;
    private final Map<BrightnessLimitMapType, Map<Float, Float>> mLuxThrottlingData;
    private String mName;
    private float[] mNits;
    private Spline mNitsToBacklightSpline;
    private PowerThrottlingConfigData mPowerThrottlingConfigData;
    private final Map<String, PowerThrottlingData> mPowerThrottlingDataMapByThrottlingId;
    private SensorData mProximitySensor;
    private List<String> mQuirks;
    private float[] mRawBacklight;
    private float[] mRawNits;
    private RefreshRateData mRefreshRateData;
    private final List<DisplayManagerInternal.RefreshRateLimitation> mRefreshRateLimitations;
    private final Map<String, SparseArray<SurfaceControl.RefreshRateRange>> mRefreshRateThrottlingMap;
    private final Map<String, SurfaceControl.RefreshRateRange> mRefreshRateZoneProfiles;
    private HysteresisLevels mScreenBrightnessHysteresis;
    private HysteresisLevels mScreenBrightnessIdleHysteresis;
    private SensorData mScreenOffBrightnessSensor;
    private int[] mScreenOffBrightnessSensorValueToLux;
    private SensorData mTempSensor;
    private final Map<String, ThermalBrightnessThrottlingData> mThermalBrightnessThrottlingDataMapByThrottlingId;
    private boolean mVrrSupportEnabled;

    /* JADX INFO: renamed from: com.android.server.display.DisplayDeviceConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$display$config$PredefinedBrightnessLimitNames = null;
        static final /* synthetic */ int[] $SwitchMap$com$android$server$display$config$ThermalStatus = null;

        static {
            $SwitchMap$com$android$server$display$config$PredefinedBrightnessLimitNames = new int[PredefinedBrightnessLimitNames.values().length];
            $SwitchMap$com$android$server$display$config$PredefinedBrightnessLimitNames[PredefinedBrightnessLimitNames._default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L47:
            $SwitchMap$com$android$server$display$config$PredefinedBrightnessLimitNames[PredefinedBrightnessLimitNames.adaptive.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L10:
            $SwitchMap$com$android$server$display$config$ThermalStatus = new int[ThermalStatus.values().length];
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.none.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L49:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.light.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L45:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.moderate.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L33:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.severe.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L35:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.critical.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L41:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.emergency.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L37:
            $SwitchMap$com$android$server$display$config$ThermalStatus[ThermalStatus.shutdown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    public static final enum BrightnessLimitMapType extends Enum<BrightnessLimitMapType> {
        private static final /* synthetic */ BrightnessLimitMapType[] $VALUES = null;
        public static final BrightnessLimitMapType ADAPTIVE = null;
        public static final BrightnessLimitMapType DEFAULT = null;

        /* JADX INFO: renamed from: -$$Nest$smconvert, reason: not valid java name */
        static /* bridge */ /* synthetic */ BrightnessLimitMapType m3613$$Nest$smconvert(PredefinedBrightnessLimitNames r0) {
            return convert(r0);
        }

        private static /* synthetic */ BrightnessLimitMapType[] $values() {
            return new BrightnessLimitMapType[]{DEFAULT, ADAPTIVE};
        }

        private BrightnessLimitMapType(String r1, int r2) {
            super(r1, r2);
        }

        public static BrightnessLimitMapType valueOf(String name) {
            return (BrightnessLimitMapType) Enum.valueOf(BrightnessLimitMapType.class, name);
        }

        public static BrightnessLimitMapType[] values() {
            return (BrightnessLimitMapType[]) $VALUES.clone();
        }

        static {
            DEFAULT = new BrightnessLimitMapType("DEFAULT", 0);
            ADAPTIVE = new BrightnessLimitMapType("ADAPTIVE", 1);
            $VALUES = $values();
        }

        private static BrightnessLimitMapType convert(PredefinedBrightnessLimitNames type) {
            switch(AnonymousClass1.$SwitchMap$com$android$server$display$config$PredefinedBrightnessLimitNames[type.ordinal()]) {
                case 1: goto L9;
                case 2: goto L7;
                default: goto L4;
            };
        L4:
            return null;
        L7:
            return ADAPTIVE;
        L9:
            return DEFAULT;
        }
    }

    public static class PowerThrottlingConfigData {
        public final float brightnessLowestCapAllowed;
        public final float customAnimationRate;
        public final int pollingWindowMaxMillis;
        public final int pollingWindowMinMillis;

        public PowerThrottlingConfigData(float brightnessLowestCapAllowed, float customAnimationRate, int pollingWindowMaxMillis, int pollingWindowMinMillis) {
            this.brightnessLowestCapAllowed = brightnessLowestCapAllowed;
            this.customAnimationRate = customAnimationRate;
            this.pollingWindowMaxMillis = pollingWindowMaxMillis;
            this.pollingWindowMinMillis = pollingWindowMinMillis;
        }

        public String toString() {
            return "PowerThrottlingConfigData{brightnessLowestCapAllowed: " + this.brightnessLowestCapAllowed + ", customAnimationRate: " + this.customAnimationRate + ", pollingWindowMaxMillis: " + this.pollingWindowMaxMillis + ", pollingWindowMinMillis: " + this.pollingWindowMinMillis + "} ";
        }
    }

    public static class PowerThrottlingData {
        public List<ThrottlingLevel> throttlingLevels;

        public static class ThrottlingLevel {
            public float powerQuotaMilliWatts;
            public int thermalStatus;

            public ThrottlingLevel(int thermalStatus, float powerQuotaMilliWatts) {
                this.thermalStatus = thermalStatus;
                this.powerQuotaMilliWatts = powerQuotaMilliWatts;
            }

            public String toString() {
                return "[" + this.thermalStatus + "," + this.powerQuotaMilliWatts + "]";
            }

            public boolean equals(Object obj) {
                if ((obj instanceof ThrottlingLevel) == true) goto L5;
                return false;
            L5:
                ThrottlingLevel otherThrottlingLevel = (ThrottlingLevel) obj;
                if (otherThrottlingLevel.thermalStatus == this.thermalStatus) goto L8;
                return false;
            L8:
                if (otherThrottlingLevel.powerQuotaMilliWatts != this.powerQuotaMilliWatts) goto L12;
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                int result = (1 * 31) + this.thermalStatus;
                return (result * 31) + Float.hashCode(this.powerQuotaMilliWatts);
            }
        }

        public static PowerThrottlingData create(List<ThrottlingLevel> throttlingLevels) {
            if (throttlingLevels != null) goto L5;
        L20:
            Slog.e(DisplayDeviceConfig.TAG, "PowerThrottlingData received null or empty throttling levels");
            return null;
        L5:
            if (throttlingLevels.size() == 0) goto L20;
            ThrottlingLevel prevLevel = throttlingLevels.get(0);
            int numLevels = throttlingLevels.size();
            int i = 1;
        L8:
            if (i >= numLevels) goto L19;
            ThrottlingLevel thisLevel = throttlingLevels.get(i);
            if (thisLevel.thermalStatus <= prevLevel.thermalStatus) goto L11;
            if (thisLevel.powerQuotaMilliWatts >= prevLevel.powerQuotaMilliWatts) goto L15;
            prevLevel = thisLevel;
            i = i + 1;
            goto L8
        L15:
            Slog.e(DisplayDeviceConfig.TAG, "powerThrottlingMap must be strictly decreasing, ignoring configuration. powerQuotaMilliWatts " + thisLevel.powerQuotaMilliWatts + " >= " + prevLevel.powerQuotaMilliWatts);
            return null;
        L11:
            Slog.e(DisplayDeviceConfig.TAG, "powerThrottlingMap must be strictly increasing, ignoring configuration. ThermalStatus " + thisLevel.thermalStatus + " <= " + prevLevel.thermalStatus);
            return null;
        L19:
            return new PowerThrottlingData(throttlingLevels);
        }

        public String toString() {
            return "PowerThrottlingData{throttlingLevels:" + this.throttlingLevels + "} ";
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof PowerThrottlingData) == true) goto L9;
            return false;
        L9:
            PowerThrottlingData otherData = (PowerThrottlingData) obj;
            return this.throttlingLevels.equals(otherData.throttlingLevels);
        }

        public int hashCode() {
            return this.throttlingLevels.hashCode();
        }

        PowerThrottlingData(List<ThrottlingLevel> inLevels) {
            this.throttlingLevels = new ArrayList(inLevels.size());
            Iterator<ThrottlingLevel> r0 = inLevels.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ThrottlingLevel level = r0.next();
            this.throttlingLevels.add(new ThrottlingLevel(level.thermalStatus, level.powerQuotaMilliWatts));
            goto L4
        }
    }

    public static class ThermalBrightnessThrottlingData {
        public List<ThrottlingLevel> throttlingLevels;

        public static class ThrottlingLevel {
            public float brightness;
            public int thermalStatus;

            public ThrottlingLevel(int thermalStatus, float brightness) {
                this.thermalStatus = thermalStatus;
                this.brightness = brightness;
            }

            public String toString() {
                return "[" + this.thermalStatus + "," + this.brightness + "]";
            }

            public boolean equals(Object obj) {
                if ((obj instanceof ThrottlingLevel) == true) goto L5;
                return false;
            L5:
                ThrottlingLevel otherThrottlingLevel = (ThrottlingLevel) obj;
                if (otherThrottlingLevel.thermalStatus == this.thermalStatus) goto L8;
                return false;
            L8:
                if (otherThrottlingLevel.brightness != this.brightness) goto L12;
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                int result = (1 * 31) + this.thermalStatus;
                return (result * 31) + Float.hashCode(this.brightness);
            }
        }

        public static ThermalBrightnessThrottlingData create(List<ThrottlingLevel> throttlingLevels) {
            if (throttlingLevels != null) goto L5;
        L28:
            Slog.e(DisplayDeviceConfig.TAG, "BrightnessThrottlingData received null or empty throttling levels");
            return null;
        L5:
            if (throttlingLevels.size() == 0) goto L28;
            ThrottlingLevel prevLevel = throttlingLevels.get(0);
            int numLevels = throttlingLevels.size();
            int i = 1;
        L8:
            if (i >= numLevels) goto L18;
            ThrottlingLevel thisLevel = throttlingLevels.get(i);
            if (thisLevel.thermalStatus <= prevLevel.thermalStatus) goto L11;
            if (thisLevel.brightness >= prevLevel.brightness) goto L15;
            prevLevel = thisLevel;
            i = i + 1;
            goto L8
        L15:
            Slog.e(DisplayDeviceConfig.TAG, "brightnessThrottlingMap must be strictly decreasing, ignoring configuration. Brightness " + thisLevel.brightness + " >= " + thisLevel.brightness);
            return null;
        L11:
            Slog.e(DisplayDeviceConfig.TAG, "brightnessThrottlingMap must be strictly increasing, ignoring configuration. ThermalStatus " + thisLevel.thermalStatus + " <= " + prevLevel.thermalStatus);
            return null;
        L18:
            Iterator<ThrottlingLevel> r4 = throttlingLevels.iterator();
        L20:
            if (r4.hasNext() == false) goto L27;
            ThrottlingLevel level = r4.next();
            if (level.brightness <= 1.0f) goto L20;
            Slog.e(DisplayDeviceConfig.TAG, "brightnessThrottlingMap contains a brightness value exceeding system max. Brightness " + level.brightness + " > 1.0");
            return null;
        L27:
            return new ThermalBrightnessThrottlingData(throttlingLevels);
        }

        public String toString() {
            return "ThermalBrightnessThrottlingData{throttlingLevels:" + this.throttlingLevels + "} ";
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof ThermalBrightnessThrottlingData) == true) goto L9;
            return false;
        L9:
            ThermalBrightnessThrottlingData otherData = (ThermalBrightnessThrottlingData) obj;
            return this.throttlingLevels.equals(otherData.throttlingLevels);
        }

        public int hashCode() {
            return this.throttlingLevels.hashCode();
        }

        ThermalBrightnessThrottlingData(List<ThrottlingLevel> inLevels) {
            this.throttlingLevels = new ArrayList(inLevels.size());
            Iterator<ThrottlingLevel> r0 = inLevels.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ThrottlingLevel level = r0.next();
            this.throttlingLevels.add(new ThrottlingLevel(level.thermalStatus, level.brightness));
            goto L4
        }
    }

    public static /* synthetic */ Float $r8$lambda$kvaggoREB46PbgPpqpZy8K1UmjQ(DisplayDeviceConfig r0, HighBrightnessMode r1) {
        return r0.lambda$initFromFile$0(r1);
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        DEFAULT_BRIGHTNESS_THRESHOLDS = new float[0];
    }

    public DisplayDeviceConfig(Context context, DisplayManagerFlags flags) {
        this.mRefreshRateLimitations = new ArrayList(2);
        this.mIdleStylusTimeoutMillis = 0;
        this.mBacklightMinimum = Float.NaN;
        this.mBacklightMaximum = Float.NaN;
        this.mBrightnessDefault = Float.NaN;
        this.mBrightnessDim = Float.NaN;
        this.mBrightnessRampFastDecrease = Float.NaN;
        this.mBrightnessRampFastIncrease = Float.NaN;
        this.mBrightnessRampSlowDecrease = Float.NaN;
        this.mBrightnessRampSlowIncrease = Float.NaN;
        this.mBrightnessRampSlowDecreaseIdle = Float.NaN;
        this.mBrightnessRampSlowIncreaseIdle = Float.NaN;
        this.mBrightnessRampDecreaseMaxMillis = 0;
        this.mBrightnessRampIncreaseMaxMillis = 0;
        this.mBrightnessRampDecreaseMaxIdleMillis = 0;
        this.mBrightnessRampIncreaseMaxIdleMillis = 0;
        this.mAmbientHorizonLong = 10000;
        this.mAmbientHorizonShort = 2000;
        this.mScreenBrightnessHysteresis = HysteresisLevels.loadDisplayBrightnessConfig(null, null);
        this.mScreenBrightnessIdleHysteresis = HysteresisLevels.loadDisplayBrightnessIdleConfig(null, null);
        this.mAmbientBrightnessHysteresis = HysteresisLevels.loadAmbientBrightnessConfig(null, null);
        this.mAmbientBrightnessIdleHysteresis = HysteresisLevels.loadAmbientBrightnessIdleConfig(null, null);
        this.mLoadedFrom = null;
        this.mAutoBrightnessBrighteningLightDebounce = -1;
        this.mAutoBrightnessDarkeningLightDebounce = -1;
        this.mAutoBrightnessBrighteningLightDebounceIdle = -1;
        this.mAutoBrightnessDarkeningLightDebounceIdle = -1;
        this.mAutoBrightnessAvailable = false;
        this.mDdcAutoBrightnessAvailable = true;
        this.mDefaultHighBlockingZoneRefreshRate = 0;
        this.mDefaultLowBlockingZoneRefreshRate = 60;
        this.mRefreshRateZoneProfiles = new HashMap();
        this.mLowDisplayBrightnessThresholds = DEFAULT_BRIGHTNESS_THRESHOLDS;
        this.mLowAmbientBrightnessThresholds = DEFAULT_BRIGHTNESS_THRESHOLDS;
        this.mHighDisplayBrightnessThresholds = DEFAULT_BRIGHTNESS_THRESHOLDS;
        this.mHighAmbientBrightnessThresholds = DEFAULT_BRIGHTNESS_THRESHOLDS;
        this.mLowBlockingZoneThermalMapId = null;
        this.mHighBlockingZoneThermalMapId = null;
        this.mThermalBrightnessThrottlingDataMapByThrottlingId = new HashMap();
        this.mPowerThrottlingDataMapByThrottlingId = new HashMap();
        this.mRefreshRateThrottlingMap = new HashMap();
        this.mLuxThrottlingData = new HashMap();
        this.mIdleScreenRefreshRateTimeoutLuxThresholds = new ArrayList();
        this.mRefreshRateData = RefreshRateData.DEFAULT_REFRESH_RATE_DATA;
        this.mContext = context;
        this.mFlags = flags;
    }

    public static DisplayDeviceConfig create(Context context, long physicalDisplayId, boolean isFirstDisplay, DisplayManagerFlags flags) {
        DisplayDeviceConfig config = createWithoutDefaultValues(context, physicalDisplayId, isFirstDisplay, flags);
        config.copyUninitializedValuesFromSecondaryConfig(loadDefaultConfigurationXml(context));
        return config;
    }

    public static DisplayDeviceConfig create(Context context, boolean useConfigXml, DisplayManagerFlags flags) {
        if (useConfigXml == false) goto L4;
        DisplayDeviceConfig config = getConfigFromGlobalXml(context, flags);
        return config;
    L4:
        DisplayDeviceConfig config2 = getConfigFromPmValues(context, flags);
        return config2;
    }

    private static DisplayDeviceConfig createWithoutDefaultValues(Context context, long physicalDisplayId, boolean isFirstDisplay, DisplayManagerFlags flags) {
        DisplayDeviceConfig config = loadConfigFromDirectory(context, Environment.getProductDirectory(), physicalDisplayId, flags);
        if (config == null) goto L5;
        return config;
    L5:
        DisplayDeviceConfig config2 = loadConfigFromDirectory(context, Environment.getVendorDirectory(), physicalDisplayId, flags);
        if (config2 == null) goto L8;
        return config2;
    L8:
        Slog.w(TAG, "createWithoutDefaultValues: physicalDisplayId=" + physicalDisplayId + " isFirstDisplay=" + isFirstDisplay);
        return create(context, isFirstDisplay, flags);
    }

    private static DisplayConfiguration loadDefaultConfigurationXml(Context context) {
        List<File> defaultXmlLocations = new ArrayList();
        defaultXmlLocations.add(Environment.buildPath(Environment.getProductDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, DEFAULT_CONFIG_FILE}));
        defaultXmlLocations.add(Environment.buildPath(Environment.getVendorDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, DEFAULT_CONFIG_FILE}));
        int uiModeType = context.getResources().getInteger(R.integer.config_displayWhiteBalanceBrightnessFilterHorizon);
        String uiModeTypeStr = Configuration.getUiModeTypeString(uiModeType);
        if (uiModeTypeStr == null) goto L5;
        defaultXmlLocations.add(Environment.buildPath(Environment.getRootDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, String.format(DEFAULT_CONFIG_FILE_WITH_UIMODE_FORMAT, new Object[]{uiModeTypeStr})}));
    L5:
        defaultXmlLocations.add(Environment.buildPath(Environment.getRootDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, DEFAULT_CONFIG_FILE}));
        File configFile = getFirstExistingFile(defaultXmlLocations);
        if (configFile != null) goto L9;
        return null;
    L9:
        DisplayConfiguration defaultConfig = null;
        InputStream in = new BufferedInputStream(new FileInputStream(configFile));     // Catch: Throwable -> L19
        defaultConfig = XmlParser.read(in);     // Catch: Throwable -> L15
        if (defaultConfig != null) goto L17;
        Slog.i(TAG, "Default DisplayDeviceConfig file is null");     // Catch: Throwable -> L15
    L17:
        in.close();     // Catch: Throwable -> L19 Throwable -> L19 Throwable -> L19
    L27:
        return defaultConfig;
    L15:
        th = move-exception;
        in.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L19 Throwable -> L19 Throwable -> L19
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19 Throwable -> L19 Throwable -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Encountered an error while reading/parsing display config file: " + configFile, e);
        goto L27
    }

    private static File getFirstExistingFile(Collection<File> files) {
        Iterator<File> r0 = files.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        File file = r0.next();
        if (file.exists() == false) goto L4;
        if (file.isFile() == false) goto L4;
        return file;
    L11:
        return null;
    }

    private static DisplayDeviceConfig loadConfigFromDirectory(Context context, File baseDirectory, long physicalDisplayId, DisplayManagerFlags flags) {
        DisplayDeviceConfig config = getConfigFromSuffix(context, baseDirectory, STABLE_ID_SUFFIX_FORMAT, physicalDisplayId, flags);
        if (config == null) goto L5;
        return config;
    L5:
        long withoutStableFlag = physicalDisplayId & (-4611686018427387905L);
        DisplayDeviceConfig config2 = getConfigFromSuffix(context, baseDirectory, NO_SUFFIX_FORMAT, withoutStableFlag, flags);
        if (config2 == null) goto L8;
        return config2;
    L8:
        DisplayAddress.Physical physicalAddress = DisplayAddress.fromPhysicalDisplayId(physicalDisplayId);
        int port = physicalAddress.getPort();
        return getConfigFromSuffix(context, baseDirectory, PORT_SUFFIX_FORMAT, port, flags);
    }

    public String getName() {
        return this.mName;
    }

    public float[] getNits() {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.nits;
    L7:
        return this.mNits;
    }

    public float[] getBacklight() {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.backlight;
    L7:
        return this.mBacklight;
    }

    public float getBacklightFromBrightness(float brightness) {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.brightnessToBacklight.interpolate(brightness);
    L7:
        return this.mBrightnessToBacklightSpline.interpolate(brightness);
    }

    public float getBrightnessFromBacklight(float backlight) {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.backlightToBrightness.interpolate(backlight);
    L7:
        return this.mBacklightToBrightnessSpline.interpolate(backlight);
    }

    private Spline getBacklightToBrightnessSpline() {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.backlightToBrightness;
    L7:
        return this.mBacklightToBrightnessSpline;
    }

    public float getNitsFromBacklight(float backlight) {
        if (this.mEvenDimmerBrightnessData == null) goto L10;
        if (this.mEvenDimmerBrightnessData.backlightToNits != null) goto L7;
        return -1.0f;
    L7:
        float backlight2 = Math.max(backlight, this.mBacklightMinimum);
        return this.mEvenDimmerBrightnessData.backlightToNits.interpolate(backlight2);
    L10:
        if (this.mBacklightToNitsSpline != null) goto L12;
        return -1.0f;
    L12:
        float backlight3 = Math.max(backlight, this.mBacklightMinimum);
        return this.mBacklightToNitsSpline.interpolate(backlight3);
    }

    public float getBacklightFromNits(float nits) {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.nitsToBacklight.interpolate(nits);
    L7:
        return this.mNitsToBacklightSpline.interpolate(nits);
    }

    private Spline getNitsToBacklightSpline() {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.nitsToBacklight;
    L7:
        return this.mNitsToBacklightSpline;
    }

    public float getMinNitsFromLux(float lux) {
        if (this.mEvenDimmerBrightnessData != null) goto L7;
        return -1.0f;
    L7:
        return this.mEvenDimmerBrightnessData.minLuxToNits.interpolate(lux);
    }

    public float getEvenDimmerTransitionPoint() {
        if (this.mEvenDimmerBrightnessData != null) goto L7;
        return 0.0f;
    L7:
        return this.mEvenDimmerBrightnessData.transitionPoint;
    }

    public boolean hasSdrToHdrRatioSpline() {
        if (this.mHbmData != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHbmData.sdrToHdrRatioSpline == null) goto L7;
        return true;
    }

    public float getHdrBrightnessFromSdr(float brightness, float maxDesiredHdrSdrRatio) {
        if (this.mHbmData == null) goto L5;
        Spline sdrToHdrSpline = this.mHbmData.sdrToHdrRatioSpline;
    L7:
        return getHdrBrightnessFromSdr(brightness, maxDesiredHdrSdrRatio, sdrToHdrSpline);
    L5:
        sdrToHdrSpline = null;
        goto L7
    }

    public float getHdrBrightnessFromSdr(float brightness, float maxDesiredHdrSdrRatio, Spline sdrToHdrSpline) {
        if (sdrToHdrSpline != null) goto L5;
        return -1.0f;
    L5:
        float backlight = getBacklightFromBrightness(brightness);
        float nits = getNitsFromBacklight(backlight);
        if (nits != (-1.0f)) goto L8;
        return -1.0f;
    L8:
        float ratio = Math.min(sdrToHdrSpline.interpolate(nits), maxDesiredHdrSdrRatio);
        float hdrNits = nits * ratio;
        if (getNitsToBacklightSpline() != null) goto L11;
        return -1.0f;
    L11:
        float hdrBacklight = Math.max(this.mBacklightMinimum, Math.min(this.mBacklightMaximum, getBacklightFromNits(hdrNits)));
        float hdrBrightness = getBrightnessFromBacklight(hdrBacklight);
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "getHdrBrightnessFromSdr: sdr brightness " + brightness + " backlight " + backlight + " nits " + nits + " ratio " + ratio + " hdrNits " + hdrNits + " hdrBacklight " + hdrBacklight + " hdrBrightness " + hdrBrightness);
    L14:
        return hdrBrightness;
    }

    public float[] getBrightness() {
        if (this.mEvenDimmerBrightnessData == null) goto L7;
        return this.mEvenDimmerBrightnessData.brightness;
    L7:
        return this.mBrightness;
    }

    public float getBrightnessMinimum() {
        return getBrightnessFromBacklight(this.mBacklightMinimum);
    }

    public float getBrightnessMaximum() {
        return getBrightnessFromBacklight(this.mBacklightMaximum);
    }

    public float getBrightnessDefault() {
        return this.mBrightnessDefault;
    }

    public float getBrightnessDim() {
        return this.mBrightnessDim;
    }

    public float getBrightnessRampFastDecrease() {
        return this.mBrightnessRampFastDecrease;
    }

    public float getBrightnessRampFastIncrease() {
        return this.mBrightnessRampFastIncrease;
    }

    public float getBrightnessRampSlowDecrease() {
        return this.mBrightnessRampSlowDecrease;
    }

    public float getBrightnessRampSlowIncrease() {
        return this.mBrightnessRampSlowIncrease;
    }

    public float getBrightnessRampSlowDecreaseIdle() {
        return this.mBrightnessRampSlowDecreaseIdle;
    }

    public float getBrightnessRampSlowIncreaseIdle() {
        return this.mBrightnessRampSlowIncreaseIdle;
    }

    public long getBrightnessRampDecreaseMaxMillis() {
        return this.mBrightnessRampDecreaseMaxMillis;
    }

    public long getBrightnessRampIncreaseMaxMillis() {
        return this.mBrightnessRampIncreaseMaxMillis;
    }

    public long getBrightnessRampDecreaseMaxIdleMillis() {
        return this.mBrightnessRampDecreaseMaxIdleMillis;
    }

    public long getBrightnessRampIncreaseMaxIdleMillis() {
        return this.mBrightnessRampIncreaseMaxIdleMillis;
    }

    public int getAmbientHorizonLong() {
        return this.mAmbientHorizonLong;
    }

    public int getAmbientHorizonShort() {
        return this.mAmbientHorizonShort;
    }

    public HysteresisLevels getAmbientBrightnessHysteresis() {
        return this.mAmbientBrightnessHysteresis;
    }

    public HysteresisLevels getAmbientBrightnessIdleHysteresis() {
        return this.mAmbientBrightnessIdleHysteresis;
    }

    public HysteresisLevels getScreenBrightnessHysteresis() {
        return this.mScreenBrightnessHysteresis;
    }

    public HysteresisLevels getScreenBrightnessIdleHysteresis() {
        return this.mScreenBrightnessIdleHysteresis;
    }

    public SensorData getAmbientLightSensor() {
        return this.mAmbientLightSensor;
    }

    public SensorData getScreenOffBrightnessSensor() {
        return this.mScreenOffBrightnessSensor;
    }

    public SensorData getProximitySensor() {
        return this.mProximitySensor;
    }

    public SensorData getTempSensor() {
        return this.mTempSensor;
    }

    boolean isAutoBrightnessAvailable() {
        return this.mAutoBrightnessAvailable;
    }

    public boolean hasQuirk(String quirkValue) {
        if (this.mQuirks != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mQuirks.contains(quirkValue) == false) goto L7;
        return true;
    }

    public HighBrightnessModeData getHighBrightnessModeData() {
        if (this.mHbmData != null) goto L5;
        return null;
    L5:
        if (this.mHbmData.isHighBrightnessModeEnabled == true) goto L8;
        return null;
    L8:
        return this.mHbmData;
    }

    public PowerThrottlingConfigData getPowerThrottlingConfigData() {
        return this.mPowerThrottlingConfigData;
    }

    public Map<BrightnessLimitMapType, Map<Float, Float>> getLuxThrottlingData() {
        return this.mLuxThrottlingData;
    }

    public List<DisplayManagerInternal.RefreshRateLimitation> getRefreshRateLimitations() {
        return this.mRefreshRateLimitations;
    }

    public DensityMapping getDensityMapping() {
        return this.mDensityMapping;
    }

    public Map<String, ThermalBrightnessThrottlingData> getThermalBrightnessThrottlingDataMapByThrottlingId() {
        return this.mThermalBrightnessThrottlingDataMapByThrottlingId;
    }

    public SparseArray<SurfaceControl.RefreshRateRange> getThermalRefreshRateThrottlingData(String id) {
        if (id != null) goto L4;
        String key = "default";
    L6:
        return this.mRefreshRateThrottlingMap.get(key);
    L4:
        key = id;
        goto L6
    }

    public Map<String, PowerThrottlingData> getPowerThrottlingDataMapByThrottlingId() {
        return this.mPowerThrottlingDataMapByThrottlingId;
    }

    public long getAutoBrightnessDarkeningLightDebounce() {
        return this.mAutoBrightnessDarkeningLightDebounce;
    }

    public long getAutoBrightnessBrighteningLightDebounce() {
        return this.mAutoBrightnessBrighteningLightDebounce;
    }

    public long getAutoBrightnessDarkeningLightDebounceIdle() {
        return this.mAutoBrightnessDarkeningLightDebounceIdle;
    }

    public long getAutoBrightnessBrighteningLightDebounceIdle() {
        return this.mAutoBrightnessBrighteningLightDebounceIdle;
    }

    public float[] getAutoBrightnessBrighteningLevelsLux(int mode, int preset) {
        if (this.mDisplayBrightnessMapping != null) goto L7;
        return null;
    L7:
        return this.mDisplayBrightnessMapping.getLuxArray(mode, preset);
    }

    public float[] getAutoBrightnessBrighteningLevelsNits() {
        if (this.mDisplayBrightnessMapping != null) goto L7;
        return null;
    L7:
        return this.mDisplayBrightnessMapping.getNitsArray();
    }

    public float[] getAutoBrightnessBrighteningLevels(int mode, int preset) {
        if (this.mDisplayBrightnessMapping != null) goto L7;
        return null;
    L7:
        return this.mDisplayBrightnessMapping.getBrightnessArray(mode, preset);
    }

    public RefreshRateData getRefreshRateData() {
        return this.mRefreshRateData;
    }

    public int getDefaultHighBlockingZoneRefreshRate() {
        return this.mDefaultHighBlockingZoneRefreshRate;
    }

    public int getDefaultLowBlockingZoneRefreshRate() {
        return this.mDefaultLowBlockingZoneRefreshRate;
    }

    public HdrBrightnessData getHdrBrightnessData() {
        return this.mHdrBrightnessData;
    }

    public SurfaceControl.RefreshRateRange getRefreshRange(String id) {
        if (TextUtils.isEmpty(id) == false) goto L7;
        return null;
    L7:
        return this.mRefreshRateZoneProfiles.get(id);
    }

    Map<String, SurfaceControl.RefreshRateRange> getRefreshRangeProfiles() {
        return this.mRefreshRateZoneProfiles;
    }

    public float[] getLowDisplayBrightnessThresholds() {
        return this.mLowDisplayBrightnessThresholds;
    }

    public float[] getLowAmbientBrightnessThresholds() {
        return this.mLowAmbientBrightnessThresholds;
    }

    public SparseArray<SurfaceControl.RefreshRateRange> getLowBlockingZoneThermalMap() {
        return getThermalRefreshRateThrottlingData(this.mLowBlockingZoneThermalMapId);
    }

    public float[] getHighDisplayBrightnessThresholds() {
        return this.mHighDisplayBrightnessThresholds;
    }

    public float[] getHighAmbientBrightnessThresholds() {
        return this.mHighAmbientBrightnessThresholds;
    }

    public SparseArray<SurfaceControl.RefreshRateRange> getHighBlockingZoneThermalMap() {
        return getThermalRefreshRateThrottlingData(this.mHighBlockingZoneThermalMapId);
    }

    public int[] getScreenOffBrightnessSensorValueToLux() {
        return this.mScreenOffBrightnessSensorValueToLux;
    }

    public HostUsiVersion getHostUsiVersion() {
        return this.mHostUsiVersion;
    }

    public boolean isEvenDimmerAvailable() {
        if (this.mEvenDimmerBrightnessData == null) goto L5;
        return true;
    L5:
        return false;
    }

    public float getBrightnessCapForWearBedtimeMode() {
        return this.mBrightnessCapForWearBedtimeMode;
    }

    public boolean isVrrSupportEnabled() {
        return this.mVrrSupportEnabled;
    }

    public float[] getDozeBrightnessSensorValueToBrightness() {
        return this.mDozeBrightnessSensorValueToBrightness;
    }

    public float getDefaultDozeBrightness() {
        return this.mDefaultDozeBrightness;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DisplayDeviceConfig{mLoadedFrom=");
        r0.append(this.mLoadedFrom);
        r0.append("\nmBacklight=");
        r0.append(getSpacedElementsAsString(this.mBacklight, 50));
        r0.append("\nmNits=");
        r0.append(getSpacedElementsAsString(this.mNits, 50));
        r0.append("\nmRawBacklight=");
        r0.append(getSpacedElementsAsString(this.mRawBacklight, 50));
        r0.append("\nmRawNits=");
        r0.append(getSpacedElementsAsString(this.mRawNits, 50));
        r0.append("\nmInterpolationType=");
        r0.append(this.mInterpolationType);
        r0.append("\nmBrightness=");
        r0.append(getSpacedElementsAsString(this.mBrightness, 50));
        r0.append("\nmBrightnessToBacklightSpline=");
        String r4 = "null";
        if (this.mBrightnessToBacklightSpline == null) goto L5;
        String r1 = this.mBrightnessToBacklightSpline.toString(false, 50);
    L6:
        r0.append(r1);
        r0.append("\nmBacklightToBrightnessSpline=");
        if (this.mBacklightToBrightnessSpline == null) goto L9;
        String r2 = this.mBacklightToBrightnessSpline.toString(false, 50);
    L10:
        r0.append(r2);
        r0.append("\nmNitsToBacklightSpline=");
        if (this.mNitsToBacklightSpline == null) goto L13;
        String r3 = this.mNitsToBacklightSpline.toString(false, 50);
    L14:
        r0.append(r3);
        r0.append("\n, mBacklightMinimum=");
        r0.append(this.mBacklightMinimum);
        r0.append(", mBacklightMaximum=");
        r0.append(this.mBacklightMaximum);
        r0.append(", mBrightnessDefault=");
        r0.append(this.mBrightnessDefault);
        r0.append(", mBrightnessDim=");
        r0.append(this.mBrightnessDim);
        r0.append(", mQuirks=");
        r0.append(this.mQuirks);
        r0.append("\nmLuxThrottlingData=");
        r0.append(this.mLuxThrottlingData);
        r0.append(", mHbmData=");
        r0.append(this.mHbmData);
        r0.append(", mThermalBrightnessThrottlingDataMapByThrottlingId=");
        r0.append(this.mThermalBrightnessThrottlingDataMapByThrottlingId);
        r0.append("\n, mPowerThrottlingDataMapByThrottlingId=");
        r0.append(this.mPowerThrottlingDataMapByThrottlingId);
        r0.append("\nmBrightnessRampFastDecrease=");
        r0.append(this.mBrightnessRampFastDecrease);
        r0.append(", mBrightnessRampFastIncrease=");
        r0.append(this.mBrightnessRampFastIncrease);
        r0.append(", mBrightnessRampSlowDecrease=");
        r0.append(this.mBrightnessRampSlowDecrease);
        r0.append(", mBrightnessRampSlowIncrease=");
        r0.append(this.mBrightnessRampSlowIncrease);
        r0.append(", mBrightnessRampSlowDecreaseIdle=");
        r0.append(this.mBrightnessRampSlowDecreaseIdle);
        r0.append(", mBrightnessRampSlowIncreaseIdle=");
        r0.append(this.mBrightnessRampSlowIncreaseIdle);
        r0.append(", mBrightnessRampDecreaseMaxMillis=");
        r0.append(this.mBrightnessRampDecreaseMaxMillis);
        r0.append(", mBrightnessRampIncreaseMaxMillis=");
        r0.append(this.mBrightnessRampIncreaseMaxMillis);
        r0.append(", mBrightnessRampDecreaseMaxIdleMillis=");
        r0.append(this.mBrightnessRampDecreaseMaxIdleMillis);
        r0.append(", mBrightnessRampIncreaseMaxIdleMillis=");
        r0.append(this.mBrightnessRampIncreaseMaxIdleMillis);
        r0.append("\nmAmbientHorizonLong=");
        r0.append(this.mAmbientHorizonLong);
        r0.append(", mAmbientHorizonShort=");
        r0.append(this.mAmbientHorizonShort);
        r0.append("\nmAmbientBrightnessHysteresis=");
        r0.append(this.mAmbientBrightnessHysteresis);
        r0.append("\nmAmbientIdleHysteresis=");
        r0.append(this.mAmbientBrightnessIdleHysteresis);
        r0.append("\nmScreenBrightnessHysteresis=");
        r0.append(this.mScreenBrightnessHysteresis);
        r0.append("\nmScreenBrightnessIdleHysteresis=");
        r0.append(this.mScreenBrightnessIdleHysteresis);
        r0.append("\nmAmbientLightSensor=");
        r0.append(this.mAmbientLightSensor);
        r0.append(", mScreenOffBrightnessSensor=");
        r0.append(this.mScreenOffBrightnessSensor);
        r0.append(", mProximitySensor=");
        r0.append(this.mProximitySensor);
        r0.append(", mTempSensor=");
        r0.append(this.mTempSensor);
        r0.append(", mRefreshRateLimitations= ");
        r0.append(Arrays.toString(this.mRefreshRateLimitations.toArray()));
        r0.append(", mDensityMapping= ");
        r0.append(this.mDensityMapping);
        r0.append(", mAutoBrightnessBrighteningLightDebounce= ");
        r0.append(this.mAutoBrightnessBrighteningLightDebounce);
        r0.append(", mAutoBrightnessDarkeningLightDebounce= ");
        r0.append(this.mAutoBrightnessDarkeningLightDebounce);
        r0.append(", mAutoBrightnessBrighteningLightDebounceIdle= ");
        r0.append(this.mAutoBrightnessBrighteningLightDebounceIdle);
        r0.append(", mAutoBrightnessDarkeningLightDebounceIdle= ");
        r0.append(this.mAutoBrightnessDarkeningLightDebounceIdle);
        r0.append(", mDisplayBrightnessMapping= ");
        r0.append(this.mDisplayBrightnessMapping);
        r0.append(", mDdcAutoBrightnessAvailable= ");
        r0.append(this.mDdcAutoBrightnessAvailable);
        r0.append(", mAutoBrightnessAvailable= ");
        r0.append(this.mAutoBrightnessAvailable);
        r0.append(", mIdleStylusTimeoutMillis= ");
        r0.append(this.mIdleStylusTimeoutMillis);
        r0.append("\nmDefaultLowBlockingZoneRefreshRate= ");
        r0.append(this.mDefaultLowBlockingZoneRefreshRate);
        r0.append(", mDefaultHighBlockingZoneRefreshRate= ");
        r0.append(this.mDefaultHighBlockingZoneRefreshRate);
        r0.append(", mRefreshRateData= ");
        r0.append(this.mRefreshRateData);
        r0.append(", mRefreshRateZoneProfiles= ");
        r0.append(this.mRefreshRateZoneProfiles);
        r0.append(", mRefreshRateThrottlingMap= ");
        r0.append(this.mRefreshRateThrottlingMap);
        r0.append(", mLowBlockingZoneThermalMapId= ");
        r0.append(this.mLowBlockingZoneThermalMapId);
        r0.append(", mHighBlockingZoneThermalMapId= ");
        r0.append(this.mHighBlockingZoneThermalMapId);
        r0.append("\nmLowDisplayBrightnessThresholds= ");
        r0.append(Arrays.toString(this.mLowDisplayBrightnessThresholds));
        r0.append(", mLowAmbientBrightnessThresholds= ");
        r0.append(Arrays.toString(this.mLowAmbientBrightnessThresholds));
        r0.append(", mHighDisplayBrightnessThresholds= ");
        r0.append(Arrays.toString(this.mHighDisplayBrightnessThresholds));
        r0.append(", mHighAmbientBrightnessThresholds= ");
        r0.append(Arrays.toString(this.mHighAmbientBrightnessThresholds));
        r0.append("\nmScreenOffBrightnessSensorValueToLux= ");
        r0.append(Arrays.toString(this.mScreenOffBrightnessSensorValueToLux));
        r0.append("\nmUsiVersion= ");
        r0.append(this.mHostUsiVersion);
        r0.append("\nmHdrBrightnessData= ");
        r0.append(this.mHdrBrightnessData);
        r0.append("\nmBrightnessCapForWearBedtimeMode= ");
        r0.append(this.mBrightnessCapForWearBedtimeMode);
        r0.append("\nmEvenDimmerBrightnessData:");
        if (this.mEvenDimmerBrightnessData == null) goto L18;
        r4 = this.mEvenDimmerBrightnessData.toString();
    L18:
        r0.append(r4);
        r0.append("\nmVrrSupported= ");
        r0.append(this.mVrrSupportEnabled);
        r0.append("\nmDozeBrightnessSensorValueToBrightness= ");
        r0.append(Arrays.toString(this.mDozeBrightnessSensorValueToBrightness));
        r0.append("\nmDefaultDozeBrightness= ");
        r0.append(this.mDefaultDozeBrightness);
        r0.append("\n}");
        return r0.toString();
    L13:
        r3 = "null";
        goto L14
    L9:
        r2 = "null";
        goto L10
    L5:
        r1 = "null";
        goto L6
    }

    private static DisplayDeviceConfig getConfigFromSuffix(Context context, File baseDirectory, String suffixFormat, long idNumber, DisplayManagerFlags flags) {
        String suffix = String.format(Locale.ROOT, suffixFormat, new Object[]{Long.valueOf(idNumber)});
        String filename = String.format(Locale.ROOT, CONFIG_FILE_FORMAT, new Object[]{suffix});
        File filePath = Environment.buildPath(baseDirectory, new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, filename});
        DisplayDeviceConfig config = new DisplayDeviceConfig(context, flags);
        if (config.initFromFile(filePath) == false) goto L5;
        return config;
    L5:
        return null;
    }

    private static DisplayDeviceConfig getConfigFromGlobalXml(Context context, DisplayManagerFlags flags) {
        DisplayDeviceConfig config = new DisplayDeviceConfig(context, flags);
        config.initFromGlobalXml();
        return config;
    }

    private static DisplayDeviceConfig getConfigFromPmValues(Context context, DisplayManagerFlags flags) {
        DisplayDeviceConfig config = new DisplayDeviceConfig(context, flags);
        config.initFromDefaultValues();
        return config;
    }

    public boolean initFromFile(File configFile) {
        if (configFile.exists() == true) goto L7;
        Slog.w(TAG, "initFromFile: configFile=" + configFile + " is not exist");
        return false;
    L7:
        if (configFile.isFile() == true) goto L42;
        Slog.e(TAG, "Display configuration is not a file: " + configFile + ", skipping");
        return false;
    L42:
        InputStream in = new BufferedInputStream(new FileInputStream(configFile));     // Catch: Throwable -> L30
        DisplayConfiguration config = XmlParser.read(in);     // Catch: Throwable -> L19
        if (config == null) goto L27;
        loadName(config);     // Catch: Throwable -> L19
        loadDensityMapping(config);     // Catch: Throwable -> L19
        loadBrightnessDefaultFromDdcXml(config);     // Catch: Throwable -> L19
        loadBrightnessConstraintsFromConfigXml();     // Catch: Throwable -> L19
        if (this.mFlags.isEvenDimmerEnabled() == true) goto L17;
    L21:
        this.mFullScreenAodConfig = config.getFullScreenAod();     // Catch: Throwable -> L19
        loadBrightnessMap(config);     // Catch: Throwable -> L19
        loadThermalThrottlingConfig(config);     // Catch: Throwable -> L19
        loadPowerThrottlingConfigData(config);     // Catch: Throwable -> L19
        Function<HighBrightnessMode, Float> transitionPointProvider = new DisplayDeviceConfig$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L19
        this.mHbmData = HighBrightnessModeData.loadHighBrightnessModeData(config, transitionPointProvider);     // Catch: Throwable -> L19
        if (this.mHbmData.isHighBrightnessModeEnabled == true) goto L24;
    L26:
        loadLuxThrottling(config);     // Catch: Throwable -> L19
        loadQuirks(config);     // Catch: Throwable -> L19
        loadBrightnessRamps(config);     // Catch: Throwable -> L19
        this.mAmbientLightSensor = SensorData.loadAmbientLightSensorConfig(config, this.mContext.getResources());     // Catch: Throwable -> L19
        this.mScreenOffBrightnessSensor = SensorData.loadScreenOffBrightnessSensorConfig(config);     // Catch: Throwable -> L19
        this.mProximitySensor = SensorData.loadProxSensorConfig(this.mFlags, config);     // Catch: Throwable -> L19
        this.mTempSensor = SensorData.loadTempSensorConfig(this.mFlags, config);     // Catch: Throwable -> L19
        this.mRefreshRateData = RefreshRateData.loadRefreshRateData(config, this.mContext.getResources());     // Catch: Throwable -> L19
        loadAmbientHorizonFromDdc(config);     // Catch: Throwable -> L19
        loadBrightnessChangeThresholds(config);     // Catch: Throwable -> L19
        loadAutoBrightnessConfigValues(config);     // Catch: Throwable -> L19
        loadRefreshRateSetting(config);     // Catch: Throwable -> L19
        loadScreenOffBrightnessSensorValueToLuxFromDdc(config);     // Catch: Throwable -> L19
        loadUsiVersion(config);     // Catch: Throwable -> L19
        this.mHdrBrightnessData = HdrBrightnessData.loadConfig(config, transitionPointProvider);     // Catch: Throwable -> L19
        loadBrightnessCapForWearBedtimeMode(config);     // Catch: Throwable -> L19
        loadIdleScreenRefreshRateTimeoutConfigs(config);     // Catch: Throwable -> L19
        this.mVrrSupportEnabled = config.getSupportsVrr();     // Catch: Throwable -> L19
        loadDozeBrightness(config);     // Catch: Throwable -> L19
    L28:
        in.close();     // Catch: Throwable -> L30 Throwable -> L30 Throwable -> L30
    L38:
        this.mLoadedFrom = configFile.toString();
        return true;
    L24:
        if (this.mHbmData.refreshRateLimit == null) goto L26;
        this.mRefreshRateLimitations.add(new DisplayManagerInternal.RefreshRateLimitation(1, this.mHbmData.refreshRateLimit));     // Catch: Throwable -> L19
        goto L26
    L17:
        if (this.mContext.getResources().getBoolean(R.bool.config_fingerprintSupportsGestures) == false) goto L21;
        this.mEvenDimmerBrightnessData = EvenDimmerBrightnessData.loadConfig(config);     // Catch: Throwable -> L19
        goto L21
    L27:
        Slog.w(TAG, "DisplayDeviceConfig file is null");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        in.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Throwable -> L30 Throwable -> L30 Throwable -> L30
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30 Throwable -> L30 Throwable -> L30
    L30:
        e = move-exception;
        Slog.e(TAG, "Encountered an error while reading/parsing display config file: " + configFile, e);
        goto L38
    }

    private /* synthetic */ Float lambda$initFromFile$0(HighBrightnessMode hbm) {
        float transitionPointBacklightScale = hbm.getTransitionPoint_all().floatValue();
        if (transitionPointBacklightScale >= this.mBacklightMaximum) goto L7;
        return Float.valueOf(getBrightnessFromBacklight(transitionPointBacklightScale));
    L7:
        throw new IllegalArgumentException("HBM transition point invalid. " + transitionPointBacklightScale + " is not less than " + this.mBacklightMaximum);
    }

    private void initFromGlobalXml() {
        loadBrightnessDefaultFromConfigXml();
        loadBrightnessConstraintsFromConfigXml();
        loadBrightnessMapFromConfigXml();
        loadBrightnessRampsFromConfigXml();
        this.mAmbientLightSensor = SensorData.loadAmbientLightSensorConfig(this.mContext.getResources());
        this.mProximitySensor = SensorData.loadSensorUnspecifiedConfig();
        this.mTempSensor = SensorData.loadTempSensorUnspecifiedConfig();
        this.mRefreshRateData = RefreshRateData.loadRefreshRateData(null, this.mContext.getResources());
        loadBrightnessChangeThresholdsFromXml();
        loadAutoBrightnessConfigsFromConfigXml();
        loadAutoBrightnessAvailableFromConfigXml();
        loadRefreshRateSetting(null);
        loadBrightnessCapForWearBedtimeModeFromConfigXml();
        loadIdleScreenRefreshRateTimeoutConfigs(null);
        loadDozeBrightness(null);
        this.mLoadedFrom = "<config.xml>";
    }

    private void initFromDefaultValues() {
        this.mLoadedFrom = "Static values";
        this.mBacklightMinimum = 0.0f;
        this.mBacklightMaximum = 1.0f;
        this.mBrightnessDefault = 0.5f;
        this.mBrightnessDim = -1.0f;
        this.mBrightnessRampFastDecrease = 1.0f;
        this.mBrightnessRampFastIncrease = 1.0f;
        this.mBrightnessRampSlowDecrease = 1.0f;
        this.mBrightnessRampSlowIncrease = 1.0f;
        this.mBrightnessRampSlowDecreaseIdle = 1.0f;
        this.mBrightnessRampSlowIncreaseIdle = 1.0f;
        this.mBrightnessRampDecreaseMaxMillis = 0;
        this.mBrightnessRampIncreaseMaxMillis = 0;
        this.mBrightnessRampDecreaseMaxIdleMillis = 0;
        this.mBrightnessRampIncreaseMaxIdleMillis = 0;
        setSimpleMappingStrategyValues();
        this.mAmbientLightSensor = SensorData.loadAmbientLightSensorConfig(this.mContext.getResources());
        this.mProximitySensor = SensorData.loadSensorUnspecifiedConfig();
        this.mTempSensor = SensorData.loadTempSensorUnspecifiedConfig();
        loadAutoBrightnessAvailableFromConfigXml();
    }

    private void copyUninitializedValuesFromSecondaryConfig(DisplayConfiguration defaultConfig) {
        if (defaultConfig != null) goto L5;
        return;
    L5:
        if (this.mDensityMapping != null) goto L8;
        loadDensityMapping(defaultConfig);
        return;
    }

    private void loadName(DisplayConfiguration config) {
        this.mName = config.getName();
    }

    private void loadDensityMapping(DisplayConfiguration config) {
        if (config.getDensityMapping() != null) goto L5;
        return;
    L5:
        List<Density> entriesFromXml = config.getDensityMapping().getDensity();
        DensityMapping.Entry[] entries = new DensityMapping.Entry[entriesFromXml.size()];
        int i = 0;
    L7:
        if (i >= entriesFromXml.size()) goto L9;
        Density density = entriesFromXml.get(i);
        entries[i] = new DensityMapping.Entry(density.getWidth().intValue(), density.getHeight().intValue(), density.getDensity().intValue());
        i = i + 1;
        goto L7
    L9:
        this.mDensityMapping = DensityMapping.createByOwning(entries);
    }

    private void loadBrightnessDefaultFromDdcXml(DisplayConfiguration config) {
        if (config == null) goto L8;
        BigDecimal configBrightnessDefault = config.getScreenBrightnessDefault();
        if (configBrightnessDefault == null) goto L6;
        this.mBrightnessDefault = configBrightnessDefault.floatValue();
        return;
    L6:
        loadBrightnessDefaultFromConfigXml();
        return;
    }

    private void loadBrightnessDefaultFromConfigXml() {
        float def = this.mContext.getResources().getFloat(R.dimen.edit_text_inset_horizontal_material);
        if (def != (-2.0f)) goto L5;
        this.mBrightnessDefault = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_shortPressOnPowerBehavior));
        return;
    L5:
        this.mBrightnessDefault = def;
    }

    private void loadBrightnessConstraintsFromConfigXml() {
        float min = this.mContext.getResources().getFloat(R.dimen.emphasized_button_stroke_width);
        float max = this.mContext.getResources().getFloat(R.dimen.edit_text_inset_top_material);
        if (min != (-2.0f)) goto L5;
    L8:
        this.mBacklightMinimum = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_showOperatorNameDefault));
        this.mBacklightMaximum = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_shortPressOnSleepBehavior));
    L9:
        float dim = this.mContext.getResources().getFloat(R.dimen.dropdownitem_text_padding_left);
        if (dim != (-2.0f)) goto L12;
        this.mBrightnessDim = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_selected_udfps_touch_detection));
        return;
    L12:
        this.mBrightnessDim = dim;
        return;
    L5:
        if (max == (-2.0f)) goto L8;
        this.mBacklightMinimum = min;
        this.mBacklightMaximum = max;
        goto L9
    }

    private void loadBrightnessMap(DisplayConfiguration config) {
        NitsMap map = config.getScreenBrightnessMap();
        if (map != null) goto L6;
        loadBrightnessMapFromConfigXml();
        return;
    L6:
        List<Point> points = map.getPoint();
        int size = points.size();
        float[] nits = new float[size];
        float[] backlight = new float[size];
        this.mInterpolationType = convertInterpolationType(map.getInterpolation());
        int i = 0;
        Iterator<Point> r6 = points.iterator();
    L8:
        if (r6.hasNext() == false) goto L20;
        Point point = r6.next();
        nits[i] = point.getNits().floatValue();
        backlight[i] = point.getValue().floatValue();
        if (i <= 0) goto L19;
        if (nits[i] < nits[i - 1]) goto L13;
        if (backlight[i] >= backlight[i - 1]) goto L19;
        Slog.e(TAG, "screenBrightnessMap must be non-decreasing, ignoring rest  of configuration. Value: " + backlight[i] + " < " + backlight[i - 1]);
        return;
    L13:
        Slog.e(TAG, "screenBrightnessMap must be non-decreasing, ignoring rest  of configuration. Nits: " + nits[i] + " < " + nits[i - 1]);
        return;
    L19:
        i = i + 1;
        goto L8
    L20:
        this.mRawNits = nits;
        this.mRawBacklight = backlight;
        constrainNitsAndBacklightArrays();
    }

    private void loadThermalThrottlingConfig(DisplayConfiguration config) {
        ThermalThrottling throttlingConfig = config.getThermalThrottling();
        if (throttlingConfig != null) goto L6;
        Slog.i(TAG, "No thermal throttling config found");
        return;
    L6:
        loadThermalBrightnessThrottlingMaps(throttlingConfig);
        loadThermalRefreshRateThrottlingMap(throttlingConfig);
    }

    private void loadThermalBrightnessThrottlingMaps(ThermalThrottling throttlingConfig) {
        List<BrightnessThrottlingMap> maps = throttlingConfig.getBrightnessThrottlingMap();
        if (maps != null) goto L5;
    L29:
        Slog.i(TAG, "No brightness throttling map found");
        return;
    L5:
        if (maps.isEmpty() == true) goto L29;
        Iterator<BrightnessThrottlingMap> r1 = maps.iterator();
    L9:
        if (r1.hasNext() == false) goto L28;
        BrightnessThrottlingMap map = r1.next();
        List<BrightnessThrottlingPoint> points = map.getBrightnessThrottlingPoint();
        List<ThermalBrightnessThrottlingData.ThrottlingLevel> throttlingLevels = new ArrayList(points.size());
        boolean badConfig = false;
        Iterator<BrightnessThrottlingPoint> r6 = points.iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        BrightnessThrottlingPoint point = r6.next();
        ThermalStatus status = point.getThermalStatus();
        if (thermalStatusIsValid(status) == false) goto L15;
        throttlingLevels.add(new ThermalBrightnessThrottlingData.ThrottlingLevel(convertThermalStatus(status), point.getBrightness().floatValue()));
        goto L12
    L15:
        badConfig = true;
    L17:
        if (badConfig == true) goto L9;
        if (map.getId() != null) goto L21;
        String id = "default";
    L23:
        if (this.mThermalBrightnessThrottlingDataMapByThrottlingId.containsKey(id) == true) goto L26;
        this.mThermalBrightnessThrottlingDataMapByThrottlingId.put(id, ThermalBrightnessThrottlingData.create(throttlingLevels));
        goto L9
    L26:
        throw new RuntimeException("Brightness throttling data with ID " + id + " already exists");
    L21:
        id = map.getId();
        goto L23
    }

    private void loadThermalRefreshRateThrottlingMap(ThermalThrottling throttlingConfig) {
        List<RefreshRateThrottlingMap> maps = throttlingConfig.getRefreshRateThrottlingMap();
        if (maps != null) goto L5;
    L37:
        Slog.w(TAG, "RefreshRateThrottling: map not found");
        return;
    L5:
        if (maps.isEmpty() == true) goto L37;
        Iterator<RefreshRateThrottlingMap> r2 = maps.iterator();
    L9:
        if (r2.hasNext() == false) goto L36;
        RefreshRateThrottlingMap map = r2.next();
        List<RefreshRateThrottlingPoint> points = map.getRefreshRateThrottlingPoint();
        if (map.getId() != null) goto L13;
        String id = "default";
    L14:
        if (points == null) goto L35;
        if (points.isEmpty() == true) goto L35;
        if (this.mRefreshRateThrottlingMap.containsKey(id) == true) goto L20;
        SparseArray<SurfaceControl.RefreshRateRange> refreshRates = new SparseArray();
        Iterator<RefreshRateThrottlingPoint> r7 = points.iterator();
    L23:
        if (r7.hasNext() == false) goto L32;
        RefreshRateThrottlingPoint point = r7.next();
        ThermalStatus status = point.getThermalStatus();
        if (thermalStatusIsValid(status) == false) goto L26;
        int thermalStatusInt = convertThermalStatus(status);
        if (refreshRates.contains(thermalStatusInt) == true) goto L29;
        refreshRates.put(thermalStatusInt, new SurfaceControl.RefreshRateRange(point.getRefreshRateRange().getMinimum().floatValue(), point.getRefreshRateRange().getMaximum().floatValue()));
        goto L23
    L29:
        Slog.wtf(TAG, "RefreshRateThrottling: thermalStatus=" + status.getRawName() + " is already in the map, mapId=" + id);
        goto L23
    L26:
        Slog.wtf(TAG, "RefreshRateThrottling: Invalid thermalStatus=" + status.getRawName() + ",mapId=" + id);
        goto L23
    L32:
        if (refreshRates.size() == 0) goto L33;
        this.mRefreshRateThrottlingMap.put(id, refreshRates);
        goto L9
    L33:
        Slog.w(TAG, "RefreshRateThrottling: no valid throttling points found for map, mapId=" + id);
        goto L9
    L20:
        Slog.wtf(TAG, "RefreshRateThrottling: map already exists, mapId=" + id);
    L35:
        Slog.w(TAG, "RefreshRateThrottling: points not found for mapId=" + id);
        goto L9
    L13:
        id = map.getId();
        goto L14
    }

    private boolean loadPowerThrottlingMaps(PowerThrottlingConfig throttlingConfig) {
        List<PowerThrottlingMap> maps = throttlingConfig.getPowerThrottlingMap();
        if (maps != null) goto L5;
    L30:
        Slog.i(TAG, "No power throttling map found");
        return false;
    L5:
        if (maps.isEmpty() == true) goto L30;
        Iterator<PowerThrottlingMap> r1 = maps.iterator();
    L9:
        if (r1.hasNext() == false) goto L28;
        PowerThrottlingMap map = r1.next();
        List<PowerThrottlingPoint> points = map.getPowerThrottlingPoint();
        List<PowerThrottlingData.ThrottlingLevel> throttlingLevels = new ArrayList(points.size());
        boolean badConfig = false;
        Iterator<PowerThrottlingPoint> r6 = points.iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        PowerThrottlingPoint point = r6.next();
        ThermalStatus status = point.getThermalStatus();
        if (thermalStatusIsValid(status) == false) goto L15;
        throttlingLevels.add(new PowerThrottlingData.ThrottlingLevel(convertThermalStatus(status), point.getPowerQuotaMilliWatts().floatValue()));
        goto L12
    L15:
        badConfig = true;
    L17:
        if (badConfig == true) goto L9;
        if (map.getId() != null) goto L21;
        String id = "default";
    L23:
        if (this.mPowerThrottlingDataMapByThrottlingId.containsKey(id) == true) goto L26;
        this.mPowerThrottlingDataMapByThrottlingId.put(id, PowerThrottlingData.create(throttlingLevels));
        goto L9
    L26:
        throw new RuntimeException("Power throttling data with ID " + id + " already exists");
    L21:
        id = map.getId();
        goto L23
    L28:
        return true;
    }

    private void loadPowerThrottlingConfigData(DisplayConfiguration config) {
        PowerThrottlingConfig powerThrottlingCfg = config.getPowerThrottlingConfig();
        if (powerThrottlingCfg != null) goto L6;
        return;
    L6:
        if (loadPowerThrottlingMaps(powerThrottlingCfg) == true) goto L8;
        return;
    L8:
        float lowestBrightnessCap = powerThrottlingCfg.getBrightnessLowestCapAllowed().floatValue();
        float customAnimationRate = powerThrottlingCfg.getCustomAnimationRate().floatValue();
        int pollingWindowMaxMillis = powerThrottlingCfg.getPollingWindowMaxMillis().intValue();
        int pollingWindowMinMillis = powerThrottlingCfg.getPollingWindowMinMillis().intValue();
        this.mPowerThrottlingConfigData = new PowerThrottlingConfigData(lowestBrightnessCap, customAnimationRate, pollingWindowMaxMillis, pollingWindowMinMillis);
    }

    private void loadRefreshRateSetting(DisplayConfiguration config) {
        BlockingZoneConfig higherBlockingZoneConfig = null;
        if (config != null) goto L5;
        RefreshRateConfigs refreshRateConfigs = null;
    L6:
        if (refreshRateConfigs != null) goto L8;
        BlockingZoneConfig lowerBlockingZoneConfig = null;
    L10:
        if (refreshRateConfigs == null) goto L13;
        higherBlockingZoneConfig = refreshRateConfigs.getHigherBlockingZoneConfigs();
    L13:
        loadLowerRefreshRateBlockingZones(lowerBlockingZoneConfig);
        loadHigherRefreshRateBlockingZones(higherBlockingZoneConfig);
        loadRefreshRateZoneProfiles(refreshRateConfigs);
        return;
    L8:
        lowerBlockingZoneConfig = refreshRateConfigs.getLowerBlockingZoneConfigs();
        goto L10
    L5:
        refreshRateConfigs = config.getRefreshRate();
        goto L6
    }

    private void loadRefreshRateZoneProfiles(RefreshRateConfigs refreshRateConfigs) {
        if (refreshRateConfigs != null) goto L4;
        return;
    L4:
        if (refreshRateConfigs.getRefreshRateZoneProfiles() == null) goto L13;
        Iterator<RefreshRateZone> r0 = refreshRateConfigs.getRefreshRateZoneProfiles().getRefreshRateZoneProfile().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        RefreshRateZone zone = r0.next();
        RefreshRateRange range = zone.getRefreshRateRange();
        this.mRefreshRateZoneProfiles.put(zone.getId(), new SurfaceControl.RefreshRateRange(range.getMinimum().floatValue(), range.getMaximum().floatValue()));
        goto L8
    L10:
        return;
    }

    private void loadLowerRefreshRateBlockingZones(BlockingZoneConfig lowerBlockingZoneConfig) {
        if (lowerBlockingZoneConfig == null) goto L4;
        this.mLowBlockingZoneThermalMapId = lowerBlockingZoneConfig.getRefreshRateThermalThrottlingId();
    L4:
        loadLowerBlockingZoneDefaultRefreshRate(lowerBlockingZoneConfig);
        loadLowerBrightnessThresholds(lowerBlockingZoneConfig);
    }

    private void loadHigherRefreshRateBlockingZones(BlockingZoneConfig upperBlockingZoneConfig) {
        if (upperBlockingZoneConfig == null) goto L4;
        this.mHighBlockingZoneThermalMapId = upperBlockingZoneConfig.getRefreshRateThermalThrottlingId();
    L4:
        loadHigherBlockingZoneDefaultRefreshRate(upperBlockingZoneConfig);
        loadHigherBrightnessThresholds(upperBlockingZoneConfig);
    }

    private void loadHigherBlockingZoneDefaultRefreshRate(BlockingZoneConfig upperBlockingZoneConfig) {
        if (upperBlockingZoneConfig != null) goto L4;
        this.mDefaultHighBlockingZoneRefreshRate = this.mContext.getResources().getInteger(R.integer.config_jobSchedulerUserGracePeriod);
        return;
    L4:
        this.mDefaultHighBlockingZoneRefreshRate = upperBlockingZoneConfig.getDefaultRefreshRate().intValue();
    }

    private void loadLowerBlockingZoneDefaultRefreshRate(BlockingZoneConfig lowerBlockingZoneConfig) {
        if (lowerBlockingZoneConfig != null) goto L4;
        this.mDefaultLowBlockingZoneRefreshRate = this.mContext.getResources().getInteger(R.integer.config_deviceStateConcurrentRearDisplay);
        return;
    L4:
        this.mDefaultLowBlockingZoneRefreshRate = lowerBlockingZoneConfig.getDefaultRefreshRate().intValue();
    }

    private void loadLowerBrightnessThresholds(BlockingZoneConfig lowerBlockingZoneConfig) {
        if (lowerBlockingZoneConfig != null) goto L11;
        int[] lowDisplayBrightnessThresholdsInt = this.mContext.getResources().getIntArray(R.array.config_defaultAllowlistLaunchOnPrivateDisplayPackages);
        int[] lowAmbientBrightnessThresholdsInt = this.mContext.getResources().getIntArray(R.array.config_backupHealthConnectDataAndSettingsKnownSigners);
        if (lowDisplayBrightnessThresholdsInt == null) goto L10;
        if (lowAmbientBrightnessThresholdsInt == null) goto L10;
        if (lowDisplayBrightnessThresholdsInt.length != lowAmbientBrightnessThresholdsInt.length) goto L10;
        this.mLowDisplayBrightnessThresholds = DeviceConfigParsingUtils.displayBrightnessThresholdsIntToFloat(lowDisplayBrightnessThresholdsInt);
        this.mLowAmbientBrightnessThresholds = DeviceConfigParsingUtils.ambientBrightnessThresholdsIntToFloat(lowAmbientBrightnessThresholdsInt);
        return;
    L10:
        throw new RuntimeException("display low brightness threshold array and ambient brightness threshold array have different length: lowDisplayBrightnessThresholdsInt=" + Arrays.toString(lowDisplayBrightnessThresholdsInt) + ", lowAmbientBrightnessThresholdsInt=" + Arrays.toString(lowAmbientBrightnessThresholdsInt));
    L11:
        List<DisplayBrightnessPoint> lowerThresholdDisplayBrightnessPoints = lowerBlockingZoneConfig.getBlockingZoneThreshold().getDisplayBrightnessPoint();
        int size = lowerThresholdDisplayBrightnessPoints.size();
        this.mLowDisplayBrightnessThresholds = new float[size];
        this.mLowAmbientBrightnessThresholds = new float[size];
        int i = 0;
    L12:
        if (i >= size) goto L22;
        float thresholdNits = lowerThresholdDisplayBrightnessPoints.get(i).getNits().floatValue();
        if (thresholdNits >= 0.0f) goto L16;
        this.mLowDisplayBrightnessThresholds[i] = thresholdNits;
    L17:
        this.mLowAmbientBrightnessThresholds[i] = lowerThresholdDisplayBrightnessPoints.get(i).getLux().floatValue();
        i = i + 1;
        goto L12
    L16:
        float thresholdBacklight = getBacklightFromNits(thresholdNits);
        this.mLowDisplayBrightnessThresholds[i] = getBrightnessFromBacklight(thresholdBacklight);
        goto L17
    }

    private void loadHigherBrightnessThresholds(BlockingZoneConfig blockingZoneConfig) {
        if (blockingZoneConfig != null) goto L11;
        int[] highDisplayBrightnessThresholdsInt = this.mContext.getResources().getIntArray(R.array.config_networkNotifySwitches);
        int[] highAmbientBrightnessThresholdsInt = this.mContext.getResources().getIntArray(R.array.config_mobile_tcp_buffers);
        if (highDisplayBrightnessThresholdsInt == null) goto L10;
        if (highAmbientBrightnessThresholdsInt == null) goto L10;
        if (highDisplayBrightnessThresholdsInt.length != highAmbientBrightnessThresholdsInt.length) goto L10;
        this.mHighDisplayBrightnessThresholds = DeviceConfigParsingUtils.displayBrightnessThresholdsIntToFloat(highDisplayBrightnessThresholdsInt);
        this.mHighAmbientBrightnessThresholds = DeviceConfigParsingUtils.ambientBrightnessThresholdsIntToFloat(highAmbientBrightnessThresholdsInt);
        return;
    L10:
        throw new RuntimeException("display high brightness threshold array and ambient brightness threshold array have different length: highDisplayBrightnessThresholdsInt=" + Arrays.toString(highDisplayBrightnessThresholdsInt) + ", highAmbientBrightnessThresholdsInt=" + Arrays.toString(highAmbientBrightnessThresholdsInt));
    L11:
        List<DisplayBrightnessPoint> higherThresholdDisplayBrightnessPoints = blockingZoneConfig.getBlockingZoneThreshold().getDisplayBrightnessPoint();
        int size = higherThresholdDisplayBrightnessPoints.size();
        this.mHighDisplayBrightnessThresholds = new float[size];
        this.mHighAmbientBrightnessThresholds = new float[size];
        int i = 0;
    L12:
        if (i >= size) goto L22;
        float thresholdNits = higherThresholdDisplayBrightnessPoints.get(i).getNits().floatValue();
        if (thresholdNits >= 0.0f) goto L16;
        this.mHighDisplayBrightnessThresholds[i] = thresholdNits;
    L17:
        this.mHighAmbientBrightnessThresholds[i] = higherThresholdDisplayBrightnessPoints.get(i).getLux().floatValue();
        i = i + 1;
        goto L12
    L16:
        float thresholdBacklight = getBacklightFromNits(thresholdNits);
        this.mHighDisplayBrightnessThresholds[i] = getBrightnessFromBacklight(thresholdBacklight);
        goto L17
    }

    private void loadAutoBrightnessConfigValues(DisplayConfiguration config) {
        AutoBrightness autoBrightness = config.getAutoBrightness();
        loadAutoBrightnessBrighteningLightDebounce(autoBrightness);
        loadAutoBrightnessDarkeningLightDebounce(autoBrightness);
        loadAutoBrightnessBrighteningLightDebounceIdle(autoBrightness);
        loadAutoBrightnessDarkeningLightDebounceIdle(autoBrightness);
        this.mDisplayBrightnessMapping = new DisplayBrightnessMappingConfig(this.mContext, this.mFlags, autoBrightness, getBacklightToBrightnessSpline());
        loadIdleStylusTimeoutMillis(autoBrightness);
        loadEnableAutoBrightness(autoBrightness);
    }

    public int getIdleStylusTimeoutMillis() {
        return this.mIdleStylusTimeoutMillis;
    }

    private void loadAutoBrightnessBrighteningLightDebounce(AutoBrightness autoBrightnessConfig) {
        if (autoBrightnessConfig != null) goto L4;
    L7:
        this.mAutoBrightnessBrighteningLightDebounce = this.mContext.getResources().getInteger(R.integer.config_batterySaver_full_locationMode);
        return;
    L4:
        if (autoBrightnessConfig.getBrighteningLightDebounceMillis() == null) goto L7;
        this.mAutoBrightnessBrighteningLightDebounce = autoBrightnessConfig.getBrighteningLightDebounceMillis().intValue();
    }

    private void loadAutoBrightnessDarkeningLightDebounce(AutoBrightness autoBrightnessConfig) {
        if (autoBrightnessConfig != null) goto L4;
    L7:
        this.mAutoBrightnessDarkeningLightDebounce = this.mContext.getResources().getInteger(R.integer.config_batterySaver_full_soundTriggerMode);
        return;
    L4:
        if (autoBrightnessConfig.getDarkeningLightDebounceMillis() == null) goto L7;
        this.mAutoBrightnessDarkeningLightDebounce = autoBrightnessConfig.getDarkeningLightDebounceMillis().intValue();
    }

    private void loadAutoBrightnessBrighteningLightDebounceIdle(AutoBrightness autoBrightnessConfig) {
        if (autoBrightnessConfig != null) goto L4;
    L7:
        this.mAutoBrightnessBrighteningLightDebounceIdle = this.mAutoBrightnessBrighteningLightDebounce;
        return;
    L4:
        if (autoBrightnessConfig.getBrighteningLightDebounceIdleMillis() == null) goto L7;
        this.mAutoBrightnessBrighteningLightDebounceIdle = autoBrightnessConfig.getBrighteningLightDebounceIdleMillis().intValue();
    }

    private void loadAutoBrightnessDarkeningLightDebounceIdle(AutoBrightness autoBrightnessConfig) {
        if (autoBrightnessConfig != null) goto L4;
    L7:
        this.mAutoBrightnessDarkeningLightDebounceIdle = this.mAutoBrightnessDarkeningLightDebounce;
        return;
    L4:
        if (autoBrightnessConfig.getDarkeningLightDebounceIdleMillis() == null) goto L7;
        this.mAutoBrightnessDarkeningLightDebounceIdle = autoBrightnessConfig.getDarkeningLightDebounceIdleMillis().intValue();
    }

    private void loadAutoBrightnessAvailableFromConfigXml() {
        this.mAutoBrightnessAvailable = this.mContext.getResources().getBoolean(R.bool.config_batterySaverStickyBehaviourDisabled);
    }

    private void loadBrightnessMapFromConfigXml() {
        Resources res = this.mContext.getResources();
        float[] sysNits = BrightnessMappingStrategy.getFloatArray(res.obtainTypedArray(R.array.config_tether_bluetooth_regexs));
        int[] sysBrightness = res.getIntArray(R.array.config_testLocationProviders);
        float[] sysBrightnessFloat = new float[sysBrightness.length];
        int i = 0;
    L4:
        if (i >= sysBrightness.length) goto L6;
        sysBrightnessFloat[i] = BrightnessSynchronizer.brightnessIntToFloat(sysBrightness[i]);
        i = i + 1;
        goto L4
    L6:
        int i2 = sysBrightnessFloat.length;
        if (i2 != 0) goto L9;
    L13:
        setSimpleMappingStrategyValues();
        return;
    L9:
        if (sysNits.length == 0) goto L13;
        this.mRawNits = sysNits;
        this.mRawBacklight = sysBrightnessFloat;
        constrainNitsAndBacklightArrays();
    }

    private void setSimpleMappingStrategyValues() {
        this.mNits = null;
        this.mBacklight = null;
        float[] simpleMappingStrategyArray = {0.0f, 1.0f};
        this.mBrightnessToBacklightSpline = Spline.createSpline(simpleMappingStrategyArray, simpleMappingStrategyArray);
        this.mBacklightToBrightnessSpline = Spline.createSpline(simpleMappingStrategyArray, simpleMappingStrategyArray);
    }

    private void constrainNitsAndBacklightArrays() {
        if (this.mRawBacklight[0] > this.mBacklightMinimum) goto L36;
        if (this.mRawBacklight[this.mRawBacklight.length - 1] < this.mBacklightMaximum) goto L36;
        if (this.mBacklightMinimum > this.mBacklightMaximum) goto L36;
        float[] newNits = new float[this.mRawBacklight.length];
        float[] newBacklight = new float[this.mRawBacklight.length];
        int newStart = 0;
        int i = 0;
    L10:
        if (i >= (this.mRawBacklight.length - 1)) goto L15;
        if (this.mRawBacklight[i + 1] > this.mBacklightMinimum) goto L13;
        i = i + 1;
        goto L10
    L13:
        newStart = i;
    L15:
        int i2 = 0;
        int newIndex = 0;
        int i3 = newStart;
    L17:
        if (i3 >= this.mRawBacklight.length) goto L33;
        if (i2 != 0) goto L33;
        newIndex = i3 - newStart;
        if (this.mRawBacklight[i3] < this.mBacklightMaximum) goto L22;
    L25:
        int r8 = 1;
    L26:
        i2 = r8;
        if (newIndex != 0) goto L29;
        float newBacklightVal = MathUtils.max(this.mRawBacklight[i3], this.mBacklightMinimum);
        float newNitsVal = rawBacklightToNits(i3, newBacklightVal);
    L32:
        newBacklight[newIndex] = newBacklightVal;
        newNits[newIndex] = newNitsVal;
        i3 = i3 + 1;
        goto L17
    L29:
        if (i2 == 0) goto L31;
        newBacklightVal = MathUtils.min(this.mRawBacklight[i3], this.mBacklightMaximum);
        newNitsVal = rawBacklightToNits(i3 - 1, newBacklightVal);
        goto L32
    L31:
        newBacklightVal = this.mRawBacklight[i3];
        newNitsVal = this.mRawNits[i3];
        goto L32
    L22:
        if (i3 >= (this.mRawBacklight.length - 1)) goto L25;
        r8 = 0;
    L33:
        this.mBacklight = Arrays.copyOf(newBacklight, newIndex + 1);
        this.mNits = Arrays.copyOf(newNits, newIndex + 1);
        createBacklightConversionSplines();
        return;
    L36:
        throw new IllegalStateException("Min or max values are invalid; raw min=" + this.mRawBacklight[0] + "; raw max=" + this.mRawBacklight[this.mRawBacklight.length - 1] + "; backlight min=" + this.mBacklightMinimum + "; backlight max=" + this.mBacklightMaximum);
    }

    private float rawBacklightToNits(int i, float backlight) {
        return MathUtils.map(this.mRawBacklight[i], this.mRawBacklight[i + 1], this.mRawNits[i], this.mRawNits[i + 1], backlight);
    }

    private void createBacklightConversionSplines() {
        this.mBrightness = new float[this.mBacklight.length];
        int i = 0;
    L4:
        if (i >= this.mBrightness.length) goto L6;
        this.mBrightness[i] = MathUtils.map(this.mBacklight[0], this.mBacklight[this.mBacklight.length - 1], 0.0f, 1.0f, this.mBacklight[i]);
        i = i + 1;
        goto L4
    L6:
        int i2 = this.mInterpolationType;
        if (i2 != 1) goto L9;
        Spline r0 = Spline.createLinearSpline(this.mBrightness, this.mBacklight);
    L10:
        this.mBrightnessToBacklightSpline = r0;
        if (this.mInterpolationType != 1) goto L13;
        Spline r1 = Spline.createLinearSpline(this.mBacklight, this.mBrightness);
    L14:
        this.mBacklightToBrightnessSpline = r1;
        if (this.mInterpolationType != 1) goto L17;
        Spline r2 = Spline.createLinearSpline(this.mBacklight, this.mNits);
    L18:
        this.mBacklightToNitsSpline = r2;
        if (this.mInterpolationType != 1) goto L21;
        Spline r3 = Spline.createLinearSpline(this.mNits, this.mBacklight);
    L22:
        this.mNitsToBacklightSpline = r3;
        return;
    L21:
        r3 = Spline.createSpline(this.mNits, this.mBacklight);
        goto L22
    L17:
        r2 = Spline.createSpline(this.mBacklight, this.mNits);
        goto L18
    L13:
        r1 = Spline.createSpline(this.mBacklight, this.mBrightness);
        goto L14
    L9:
        r0 = Spline.createSpline(this.mBrightness, this.mBacklight);
        goto L10
    }

    private void loadQuirks(DisplayConfiguration config) {
        DisplayQuirks quirks = config.getQuirks();
        if (quirks == null) goto L6;
        this.mQuirks = new ArrayList(quirks.getQuirk());
        return;
    }

    private void loadLuxThrottling(DisplayConfiguration config) {
        LuxThrottling cfg = config.getLuxThrottling();
        if (cfg == null) goto L33;
        HighBrightnessMode hbm = config.getHighBrightnessMode();
        if (hbm == null) goto L7;
        float hbmTransitionPoint = hbm.getTransitionPoint_all().floatValue();
    L8:
        List<BrightnessLimitMap> limitMaps = cfg.getBrightnessLimitMap();
        Iterator<BrightnessLimitMap> r5 = limitMaps.iterator();
    L10:
        if (r5.hasNext() == false) goto L52;
        BrightnessLimitMap map = r5.next();
        PredefinedBrightnessLimitNames type = map.getType();
        BrightnessLimitMapType mappedType = BrightnessLimitMapType.m3613$$Nest$smconvert(type);
        if (mappedType == null) goto L13;
        if (this.mLuxThrottlingData.containsKey(mappedType) == true) goto L16;
        Map<Float, Float> luxToTransitionPointMap = new HashMap();
        List<NonNegativeFloatToFloatPoint> points = map.getMap().getPoint();
        Iterator<NonNegativeFloatToFloatPoint> r12 = points.iterator();
    L19:
        if (r12.hasNext() == false) goto L27;
        NonNegativeFloatToFloatPoint point = r12.next();
        float lux = point.getFirst().floatValue();
        float maxBacklight = point.getSecond().floatValue();
        cfg = cfg;
        if (maxBacklight > hbmTransitionPoint) goto L22;
        HighBrightnessMode hbm2 = hbm;
        float hbmTransitionPoint2 = hbmTransitionPoint;
        if (luxToTransitionPointMap.containsKey(Float.valueOf(lux)) == true) goto L25;
        luxToTransitionPointMap.put(Float.valueOf(lux), Float.valueOf(getBrightnessFromBacklight(maxBacklight)));
        hbm = hbm2;
        hbmTransitionPoint = hbmTransitionPoint2;
        goto L19
    L25:
        Slog.wtf(TAG, "Invalid NBM config: duplicate lux key. type=" + type + "; lux=" + lux);
        hbm = hbm2;
        hbmTransitionPoint = hbmTransitionPoint2;
        goto L19
    L22:
        Slog.wtf(TAG, "Invalid NBM config: maxBacklight is greater than hbm.transitionPoint. type=" + type + "; lux=" + lux + "; maxBacklight=" + maxBacklight);
        hbm = hbm;
        hbmTransitionPoint = hbmTransitionPoint;
        goto L19
    L27:
        LuxThrottling cfg2 = cfg;
        HighBrightnessMode hbm3 = hbm;
        float hbmTransitionPoint3 = hbmTransitionPoint;
        if (luxToTransitionPointMap.isEmpty() == true) goto L30;
        this.mLuxThrottlingData.put(mappedType, luxToTransitionPointMap);
    L30:
        hbm = hbm3;
        cfg = cfg2;
        hbmTransitionPoint = hbmTransitionPoint3;
        goto L10
    L16:
        Slog.wtf(TAG, "Invalid NBM config: duplicate map type=" + mappedType);
        goto L10
    L13:
        Slog.wtf(TAG, "Invalid NBM config: unsupported map type=" + type);
        goto L10
    L52:
        return;
    L7:
        hbmTransitionPoint = 1.0f;
        goto L8
    }

    private void loadBrightnessRamps(DisplayConfiguration config) {
        loadBrightnessRampsInteractive(config);
        loadBrightnessRampsIdle(config);
    }

    private void loadBrightnessRampsInteractive(DisplayConfiguration config) {
        BigDecimal fastDownDecimal = config.getScreenBrightnessRampFastDecrease();
        BigDecimal fastUpDecimal = config.getScreenBrightnessRampFastIncrease();
        BigDecimal slowDownDecimal = config.getScreenBrightnessRampSlowDecrease();
        BigDecimal slowUpDecimal = config.getScreenBrightnessRampSlowIncrease();
        if (fastDownDecimal == null) goto L8;
        if (fastUpDecimal == null) goto L8;
        if (slowDownDecimal == null) goto L8;
        if (slowUpDecimal == null) goto L8;
        this.mBrightnessRampFastDecrease = fastDownDecimal.floatValue();
        this.mBrightnessRampFastIncrease = fastUpDecimal.floatValue();
        this.mBrightnessRampSlowDecrease = slowDownDecimal.floatValue();
        this.mBrightnessRampSlowIncrease = slowUpDecimal.floatValue();
    L14:
        BigInteger increaseMax = config.getScreenBrightnessRampIncreaseMaxMillis();
        if (increaseMax == null) goto L17;
        this.mBrightnessRampIncreaseMaxMillis = increaseMax.intValue();
    L17:
        BigInteger decreaseMax = config.getScreenBrightnessRampDecreaseMaxMillis();
        if (decreaseMax == null) goto L21;
        this.mBrightnessRampDecreaseMaxMillis = decreaseMax.intValue();
        return;
    L21:
        return;
    L8:
        if (fastDownDecimal != null) goto L12;
        if (fastUpDecimal != null) goto L12;
        if (slowDownDecimal != null) goto L12;
        if (slowUpDecimal != null) goto L12;
    L13:
        loadBrightnessRampsFromConfigXml();
    L12:
        Slog.w(TAG, "Per display brightness ramp values ignored because not all values are present in display device config");
        goto L13
    }

    private void loadBrightnessRampsIdle(DisplayConfiguration config) {
        BigDecimal slowDownDecimalIdle = config.getScreenBrightnessRampSlowDecreaseIdle();
        BigDecimal slowUpDecimalIdle = config.getScreenBrightnessRampSlowIncreaseIdle();
        if (slowDownDecimalIdle == null) goto L6;
        if (slowUpDecimalIdle == null) goto L6;
        this.mBrightnessRampSlowDecreaseIdle = slowDownDecimalIdle.floatValue();
        this.mBrightnessRampSlowIncreaseIdle = slowUpDecimalIdle.floatValue();
    L10:
        BigInteger increaseMaxIdle = config.getScreenBrightnessRampIncreaseMaxIdleMillis();
        if (increaseMaxIdle == null) goto L13;
        this.mBrightnessRampIncreaseMaxIdleMillis = increaseMaxIdle.intValue();
    L14:
        BigInteger decreaseMaxIdle = config.getScreenBrightnessRampDecreaseMaxIdleMillis();
        if (decreaseMaxIdle == null) goto L17;
        this.mBrightnessRampDecreaseMaxIdleMillis = decreaseMaxIdle.intValue();
        return;
    L17:
        this.mBrightnessRampDecreaseMaxIdleMillis = this.mBrightnessRampDecreaseMaxMillis;
        return;
    L13:
        this.mBrightnessRampIncreaseMaxIdleMillis = this.mBrightnessRampIncreaseMaxMillis;
    L6:
        if (slowDownDecimalIdle != null) goto L8;
        if (slowUpDecimalIdle != null) goto L8;
    L9:
        this.mBrightnessRampSlowDecreaseIdle = this.mBrightnessRampSlowDecrease;
        this.mBrightnessRampSlowIncreaseIdle = this.mBrightnessRampSlowIncrease;
    L8:
        Slog.w(TAG, "Per display idle brightness ramp values ignored because not all values are present in display device config");
        goto L9
    }

    private void loadBrightnessRampsFromConfigXml() {
        this.mBrightnessRampFastIncrease = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_carDockRotation));
        this.mBrightnessRampSlowIncrease = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_cdma_3waycall_flash_delay));
        this.mBrightnessRampFastDecrease = this.mBrightnessRampFastIncrease;
        this.mBrightnessRampSlowDecrease = this.mBrightnessRampSlowIncrease;
    }

    private void loadAutoBrightnessConfigsFromConfigXml() {
        this.mDisplayBrightnessMapping = new DisplayBrightnessMappingConfig(this.mContext, this.mFlags, null, getBacklightToBrightnessSpline());
    }

    private void loadBrightnessChangeThresholdsFromXml() {
        loadBrightnessChangeThresholds(null);
    }

    private void loadBrightnessChangeThresholds(DisplayConfiguration config) {
        Resources res = this.mContext.getResources();
        this.mScreenBrightnessHysteresis = HysteresisLevels.loadDisplayBrightnessConfig(config, res);
        this.mScreenBrightnessIdleHysteresis = HysteresisLevels.loadDisplayBrightnessIdleConfig(config, res);
        this.mAmbientBrightnessHysteresis = HysteresisLevels.loadAmbientBrightnessConfig(config, res);
        this.mAmbientBrightnessIdleHysteresis = HysteresisLevels.loadAmbientBrightnessIdleConfig(config, res);
    }

    private boolean thermalStatusIsValid(ThermalStatus value) {
        if (value != null) goto L6;
        return false;
    L6:
        switch(AnonymousClass1.$SwitchMap$com$android$server$display$config$ThermalStatus[value.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        return true;
    }

    static int convertThermalStatus(ThermalStatus value) {
        if (value != null) goto L6;
        return 0;
    L6:
        switch(AnonymousClass1.$SwitchMap$com$android$server$display$config$ThermalStatus[value.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        Slog.wtf(TAG, "Unexpected Thermal Status: " + value);
        return 0;
    L9:
        return 6;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 3;
    L17:
        return 2;
    L19:
        return 1;
    L21:
        return 0;
    }

    private int convertInterpolationType(String value) {
        if (TextUtils.isEmpty(value) == false) goto L6;
        return 0;
    L6:
        if ("linear".equals(value) == false) goto L9;
        return 1;
    L9:
        Slog.wtf(TAG, "Unexpected Interpolation Type: " + value);
        return 0;
    }

    private void loadAmbientHorizonFromDdc(DisplayConfiguration config) {
        BigInteger configLongHorizon = config.getAmbientLightHorizonLong();
        if (configLongHorizon == null) goto L5;
        this.mAmbientHorizonLong = configLongHorizon.intValue();
    L5:
        BigInteger configShortHorizon = config.getAmbientLightHorizonShort();
        if (configShortHorizon == null) goto L9;
        this.mAmbientHorizonShort = configShortHorizon.intValue();
        return;
    }

    private void loadIdleScreenRefreshRateTimeoutConfigs(DisplayConfiguration config) {
        if (this.mFlags.isIdleScreenRefreshRateTimeoutEnabled() == false) goto L9;
        if (config != null) goto L6;
        return;
    L6:
        if (config.getIdleScreenRefreshRateTimeout() == null) goto L11;
        validateIdleScreenRefreshRateTimeoutConfig(config.getIdleScreenRefreshRateTimeout());
        this.mIdleScreenRefreshRateTimeoutLuxThresholds = config.getIdleScreenRefreshRateTimeout().getLuxThresholds().getPoint();
        return;
    L11:
        return;
    }

    private void loadDozeBrightness(DisplayConfiguration config) {
        if (this.mFlags.isDozeBrightnessFloatEnabled() == false) goto L16;
        if (config == null) goto L16;
        if (config.getDozeBrightnessSensorValueToBrightness() == null) goto L16;
        List<BigDecimal> values = config.getDozeBrightnessSensorValueToBrightness().getItem();
        this.mDozeBrightnessSensorValueToBrightness = new float[values.size()];
        int i = 0;
    L9:
        if (i >= values.size()) goto L16;
        float backlight = values.get(i).floatValue();
        if (backlight == (-1.0f)) goto L13;
        this.mDozeBrightnessSensorValueToBrightness[i] = getBrightnessFromBacklight(backlight);
    L14:
        i = i + 1;
        goto L9
    L13:
        this.mDozeBrightnessSensorValueToBrightness[i] = -1.0f;
    L16:
        if (this.mFlags.isDozeBrightnessFloatEnabled() == false) goto L21;
        if (config == null) goto L21;
        if (config.getDefaultDozeBrightness() == null) goto L21;
        this.mDefaultDozeBrightness = getBrightnessFromBacklight(config.getDefaultDozeBrightness().floatValue());
        return;
    L21:
        this.mDefaultDozeBrightness = this.mContext.getResources().getFloat(R.dimen.dropdownitem_text_padding_right);
        if (this.mDefaultDozeBrightness != (-2.0f)) goto L29;
        this.mDefaultDozeBrightness = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_settingsKeyBehavior));
        return;
    }

    private void validateIdleScreenRefreshRateTimeoutConfig(IdleScreenRefreshRateTimeout idleScreenRefreshRateTimeoutConfig) {
        IdleScreenRefreshRateTimeoutLuxThresholds idleScreenRefreshRateTimeoutLuxThresholds = idleScreenRefreshRateTimeoutConfig.getLuxThresholds();
        if (idleScreenRefreshRateTimeoutLuxThresholds == null) goto L16;
        int previousLux = -1;
        Iterator<IdleScreenRefreshRateTimeoutLuxThresholdPoint> r2 = idleScreenRefreshRateTimeoutLuxThresholds.getPoint().iterator();
    L6:
        if (r2.hasNext() == false) goto L20;
        IdleScreenRefreshRateTimeoutLuxThresholdPoint point = r2.next();
        int newLux = point.getLux().intValue();
        if (previousLux >= newLux) goto L15;
        int timeout = point.getTimeout().intValue();
        if (timeout < 0) goto L13;
        previousLux = newLux;
        goto L6
    L13:
        throw new RuntimeException("The timeout value cannot be negative in idle screen refresh rate timeout config");
    L15:
        throw new RuntimeException("Lux values should be in ascending order in the idle screen refresh rate timeout config");
    L20:
        return;
    }

    public List<IdleScreenRefreshRateTimeoutLuxThresholdPoint> getIdleScreenRefreshRateTimeoutLuxThresholdPoint() {
        return this.mIdleScreenRefreshRateTimeoutLuxThresholds;
    }

    public static float[] getFloatArray(TypedArray array, float defaultValue) {
        int n = array.length();
        float[] vals = new float[n];
        int i = 0;
    L3:
        if (i >= n) goto L5;
        vals[i] = array.getFloat(i, defaultValue);
        i = i + 1;
        goto L3
    L5:
        array.recycle();
        return vals;
    }

    public static float[] getLuxLevels(int[] lux) {
        float[] levels = new float[lux.length + 1];
        int i = 0;
    L4:
        if (i >= lux.length) goto L7;
        levels[i + 1] = lux[i];
        i = i + 1;
        goto L4
    L7:
        return levels;
    }

    private void loadIdleStylusTimeoutMillis(AutoBrightness autoBrightness) {
        if (autoBrightness != null) goto L4;
        return;
    L4:
        BigInteger idleStylusTimeoutMillis = autoBrightness.getIdleStylusTimeoutMillis();
        if (idleStylusTimeoutMillis == null) goto L8;
        this.mIdleStylusTimeoutMillis = idleStylusTimeoutMillis.intValue();
        return;
    }

    private void loadEnableAutoBrightness(AutoBrightness autobrightness) {
        boolean r0 = true;
        this.mDdcAutoBrightnessAvailable = true;
        if (autobrightness == null) goto L6;
        this.mDdcAutoBrightnessAvailable = autobrightness.getEnabled();
    L6:
        if (this.mContext.getResources().getBoolean(R.bool.config_batterySaverStickyBehaviourDisabled) == true) goto L8;
    L10:
        r0 = false;
    L11:
        this.mAutoBrightnessAvailable = r0;
        return;
    L8:
        if (this.mDdcAutoBrightnessAvailable == false) goto L10;
        goto L10
    }

    private void loadScreenOffBrightnessSensorValueToLuxFromDdc(DisplayConfiguration config) {
        IntegerArray sensorValueToLux = config.getScreenOffBrightnessSensorValueToLux();
        if (sensorValueToLux != null) goto L5;
        return;
    L5:
        List<BigInteger> items = sensorValueToLux.getItem();
        this.mScreenOffBrightnessSensorValueToLux = new int[items.size()];
        int i = 0;
    L7:
        if (i >= items.size()) goto L10;
        this.mScreenOffBrightnessSensorValueToLux[i] = items.get(i).intValue();
        i = i + 1;
        goto L7
    }

    private void loadUsiVersion(DisplayConfiguration config) {
        UsiVersion usiVersion = config.getUsiVersion();
        if (usiVersion == null) goto L5;
        HostUsiVersion r1 = new HostUsiVersion(usiVersion.getMajorVersion().intValue(), usiVersion.getMinorVersion().intValue());
    L6:
        this.mHostUsiVersion = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private void loadBrightnessCapForWearBedtimeMode(DisplayConfiguration config) {
        if (config == null) goto L8;
        BigDecimal configBrightnessCap = config.getScreenBrightnessCapForWearBedtimeMode();
        if (configBrightnessCap == null) goto L6;
        this.mBrightnessCapForWearBedtimeMode = configBrightnessCap.floatValue();
        return;
    L6:
        loadBrightnessCapForWearBedtimeModeFromConfigXml();
        return;
    }

    private void loadBrightnessCapForWearBedtimeModeFromConfigXml() {
        this.mBrightnessCapForWearBedtimeMode = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_screenshotChordKeyTimeout));
    }

    public static String getSpacedElementsAsString(float[] array, int step) {
        if (array != null) goto L4;
        return "[]";
    L4:
        if (array.length == 0) goto L24;
        int n = array.length;
        int newStep = Math.max(step, n / 120);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
    L7:
        if (i >= n) goto L17;
        if (i != 0) goto L10;
    L13:
        if (i == 0) goto L15;
        sb.append(", ");
    L15:
        sb.append(array[i]);
    L16:
        i = i + 1;
        goto L7
    L10:
        if (i == (n - 1)) goto L13;
        if ((i % newStep) != 0) goto L16;
    L17:
        sb.append("]");
        return sb.toString();
    L24:
        return "[]";
    }

    public DisplayBrightnessMappingConfig getDisplayBrightnessMapping() {
        return this.mDisplayBrightnessMapping;
    }

    public FullScreenAodMode getFullScreenAodConfig() {
        return this.mFullScreenAodConfig;
    }
}
