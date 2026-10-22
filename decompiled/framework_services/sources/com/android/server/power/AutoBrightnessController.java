package com.android.server.power;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerSmtEx;
import android.app.IActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManagerInternal;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import android.util.Slog;
import android.util.Spline;
import android.view.WindowManager;
import com.android.server.am.HostingRecord;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class AutoBrightnessController {
    private static final boolean DBG = false;
    private static final boolean DBG_REALESE = true;
    private static final String DEBUG_PROPERTY = "persist.sm.auto.bri.debug";
    private static final String DEBUG_PROPERTY_CHANGE_SIZE = "persist.sm.auto.bri.change.size";
    private static final String DEBUG_PROPERTY_DATA_SIZE = "persist.sm.auto.bri.data.size";
    private static final String DEFAULT_COLOR = "black";
    private static final long DIM_LUX_DELAY = 3000;
    private static final float EPSILON = 0.001f;
    private static final int EVENT_ACTIVITY_CHANGED = 1;
    private static final int INVALIDE_BRIGHTNESS = -1;
    private static final int LIGHT_SENSOR_RATE_MILLIS = 0;
    private static final int LUX_DECREASE = 2;
    private static final int LUX_INCREASE = 1;
    private static final int LUX_TREND_DEFAULT = 0;
    private static final int LUX_TREND_RATE_DECREASE = 2;
    private static final int LUX_TREND_RATE_DEFAULT = 2;
    private static final int LUX_TREND_RATE_INCREASE = 2;
    private static final int MAX_DIFFERENCE = 9;
    private static final int NUM_OF_MEASURED_LUX = 10;
    private static final int SENSOR_POLL_TIME = 3;
    private static final String SLEEP_MODE = "sleepmode";
    private static final String SLEEP_MODE_CHANGED = "com.bytedanceos.action.SLEEP_MODE_CHANGED";
    private static final int STATE_AUTO = 0;
    private static final int STATE_MANUAL = 1;
    private static final int STATE_STABLE = 3;
    private static final int STATE_WAIT = 2;
    private static final String TAG = "AutoBC";
    private static float mCurrentLux;
    private static AutoBrightnessController sMe;
    private float[] highs;
    private float[] lows;
    private ActivityManager mActivityManager;
    private IActivityManager mActivityManagerService;
    private final ActivityManagerSmtEx.ActivityObserver mActivityObserver;
    private HandlerThread mAutoBCWorkThread;
    private final ContentObserver mBrightnessModeObserver;
    private AutoBrightnessCallBack mCallBack;
    private float[][] mChangingMechanism;
    private String mColor;
    private ConfigurationReceiver mConfigurationReceiver;
    private Context mContext;
    private AutoBrightnessDebugView mDebugView;
    private int mDesiredPolicy;
    private int[][] mExtendLuxs;
    private boolean mFirstLux;
    private long mFirstLuxsTime;
    private boolean mFirstStart;
    private float mFormerBright;
    private AutoBrightnessControllerHandler mHandler;
    private boolean mIsAutoBriEnabled;
    private boolean mIsGameModeEnable;
    private boolean mIsRegistered;
    private boolean mIsScreenOn;
    private int mLastReqBrightLevel;
    private float mLastReqBrightness;
    private Sensor mLightSensor;
    private long mLightSensorChangeTime;
    private final SensorEventListener mLightSensorListener;
    private int mLuxChangeTrend;
    private LuxConfiguration mLuxConfiguration;
    private int[] mLuxes;
    private LuxStabilizer mLuxesStabilizer;
    private int mNextBrightnessLevel;
    private int mOrientation;
    private int[] mOriginLuxs;
    private float[] mOriginValues;
    private PackageManager mPackageManager;
    private boolean mProximityPositive;
    private ProximitySensorHelper mProximitySensorHelper;
    private Spline mScreenAutoBrightnessSpline;
    private ProximitySensorHelper.SensorCallBack mSensorCallBack;
    private SensorManager mSensorManager;
    private boolean mSleepModeUnregist;
    private final StateDetail mStateDetail;
    private Handler mSubWorkHander;
    private SensorHandleTask mTask;
    private float[] mValues;
    private float minimumBacklight;
    private int minimumBacklightInt;

    public interface AutoBrightnessCallBack {
        void onAutoBrightnessModeChange(boolean r1);

        void requestAutoBrightness(float r1, int r2);

        void setBrightnessGradient(int r1, float r2, float r3);

        void setBrightnessGradientEnd();
    }

    private final class AutoBrightnessControllerHandler extends Handler {
        private static final int MSG_ID_ADJUST = 2;
        private static final int MSG_ID_BOOTCOMPLETED = 3;
        private static final int MSG_ID_HANDLE_LUX_CHANGE = 4;
        private static final int MSG_ID_HIDE_DEBUG_VIEW = 7;
        private static final int MSG_ID_INIT_BRIGHTNESS = 9;
        private static final int MSG_ID_LUX_IS_STABLE = 5;
        private static final int MSG_ID_POLICY_CHANGE = 12;
        private static final int MSG_ID_SCREEN_STATE_CHANGE = 8;
        private static final int MSG_ID_SHOW_DEBUG_VIEW = 6;
        private static final int MSG_ID_SLEEP_MODE = 11;
        private static final int MSG_ID_START_AUTO_BRIGHTNESS = 0;
        private static final int MSG_ID_STOP_AUTO_BRIGHTNESS = 1;
        private static final int MSG_ID_USE_AUTO_BRIGHTNESS = 10;
        private int mPendingUserSetBrightness;
        final /* synthetic */ AutoBrightnessController this$0;

        public AutoBrightnessControllerHandler(AutoBrightnessController r1, Looper looper) {
            this.this$0 = r1;
            super(looper, null);
            this.mPendingUserSetBrightness = -1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean useAutoBrightness = true;
            switch(msg.what) {
                case 0: goto L72;
                case 1: goto L68;
                case 2: goto L65;
                case 3: goto L50;
                case 4: goto L43;
                case 5: goto L38;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L22;
                case 9: goto L17;
                case 10: goto L8;
                case 11: goto L6;
                case 12: goto L5;
                default: goto L4;
            };
        L4:
            Slog.e(AutoBrightnessController.TAG, "Unkown message");
            return;
        L5:
            AutoBrightnessController.m7363$$Nest$mhandlePolicyChanged(this.this$0, msg.arg1);
            return;
        L6:
            AutoBrightnessController.m7364$$Nest$mhandleSleepMode(this.this$0, msg.obj);
            return;
        L17:
            float brightness = Float.intBitsToFloat(msg.arg1);
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L20;
            AutoBrightnessController.m7378$$Nest$smlog("The initBrightness lux value is : " + brightness);
        L20:
            AutoBrightnessController.m7367$$Nest$mrequestAutoBrightness(this.this$0, brightness, 0);
            return;
        L35:
            hideDebugView();
            return;
        L36:
            showDebugView();
            return;
        L8:
            if (msg.arg1 > 0) goto L12;
            useAutoBrightness = false;
        L12:
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L14;
            AutoBrightnessController.m7378$$Nest$smlog("MSG_ID_USE_AUTO_BRIGHTNESS useAutoBrightness = " + useAutoBrightness);
        L14:
            if (useAutoBrightness == false) goto L16;
            AutoBrightnessController.m7366$$Nest$mregisterSensorListener(this.this$0);
            return;
        L16:
            AutoBrightnessController.m7373$$Nest$munregisterSensorListener(this.this$0);
            return;
        L22:
            if (msg.arg1 <= 0) goto L24;
            boolean screenOn = true;
        L26:
            if (AutoBrightnessController.m7326$$Nest$fgetmIsScreenOn(this.this$0) == screenOn) goto L88;
            AutoBrightnessController.m7347$$Nest$fputmIsScreenOn(this.this$0, screenOn);
            if (AutoBrightnessController.m7326$$Nest$fgetmIsScreenOn(this.this$0) == true) goto L30;
            StateDetail.m7386$$Nest$mresetToDefault(AutoBrightnessController.m7336$$Nest$fgetmStateDetail(this.this$0), "\"screen off\"");
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L91;
            AutoBrightnessController.m7373$$Nest$munregisterSensorListener(this.this$0);
            AutoBrightnessController.m7348$$Nest$fputmLastReqBrightness(this.this$0, -1.0f);
            AutoBrightnessController.m7342$$Nest$fputmFirstLux(this.this$0, false);
            AutoBrightnessController.m7372$$Nest$msetIntArrayForSetting(this.this$0, "auto_brightness_lux", AutoBrightnessController.m7332$$Nest$fgetmOriginLuxs(this.this$0));
            AutoBrightnessController.m7370$$Nest$msetBrightnessGradientEnd(this.this$0);
            return;
        L91:
            return;
        L30:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L89;
            AutoBrightnessController.m7342$$Nest$fputmFirstLux(this.this$0, true);
            AutoBrightnessController.m7356$$Nest$mcalibrationBrightnessArray(this.this$0, AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0));
            AutoBrightnessController.m7366$$Nest$mregisterSensorListener(this.this$0);
            AutoBrightnessController.m7343$$Nest$fputmFirstLuxsTime(this.this$0, SystemClock.uptimeMillis());
            return;
        L89:
            return;
        L88:
            return;
        L24:
            screenOn = false;
            goto L26
        L38:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == true) goto L40;
            return;
        L40:
            if (this.mPendingUserSetBrightness == (-1)) goto L96;
            this.mPendingUserSetBrightness = -1;
            return;
        L96:
            return;
        L43:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L105;
            Bundle bundle = msg.getData();
            if (bundle != null) goto L48;
            return;
        L48:
            int when = bundle.getInt("time");
            float lux = bundle.getFloat("lux");
            AutoBrightnessController.m7331$$Nest$fgetmLuxesStabilizer(this.this$0).add(when, lux);
            AutoBrightnessController.m7362$$Nest$mhandleLuxChange(this.this$0, lux);
            return;
        L105:
            return;
        L50:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L60;
            String schemeHashCode = Settings.System.getStringForUser(AutoBrightnessController.m7318$$Nest$fgetmContext(this.this$0).getContentResolver(), "auto_brightness_scheme_hashcode", -2);
            String oriSchemeHashCode = String.valueOf((Arrays.toString(AutoBrightnessController.m7332$$Nest$fgetmOriginLuxs(this.this$0)) + Arrays.toString(AutoBrightnessController.m7333$$Nest$fgetmOriginValues(this.this$0))).hashCode());
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L54;
            AutoBrightnessController.m7378$$Nest$smlog("oriSchemeHashCode=" + oriSchemeHashCode + ",schemeHashCode=" + schemeHashCode);
        L54:
            if (oriSchemeHashCode != null) goto L56;
        L58:
            AutoBrightnessController.m7348$$Nest$fputmLastReqBrightness(this.this$0, -1.0f);
            goto L60
        L56:
            if (oriSchemeHashCode.equals(schemeHashCode) == true) goto L58;
            Settings.System.putStringForUser(AutoBrightnessController.m7318$$Nest$fgetmContext(this.this$0).getContentResolver(), "auto_brightness_scheme_hashcode", oriSchemeHashCode, -2);
            AutoBrightnessController.m7369$$Nest$mrestoreLuxandValue(this.this$0);
        L60:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == true) goto L62;
            return;
        L62:
            if (SystemProperties.getBoolean(AutoBrightnessController.DEBUG_PROPERTY, false) == false) goto L100;
            showDebugView();
            return;
        L100:
            return;
        L65:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L102;
            AutoBrightnessController.m7360$$Nest$mhandleAdjust(this.this$0, AutoBrightnessController.m7375$$Nest$sfgetmCurrentLux(), Float.intBitsToFloat(msg.arg1));
            return;
        L102:
            return;
        L68:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == true) goto L70;
            return;
        L70:
            AutoBrightnessController.m7345$$Nest$fputmIsAutoBriEnabled(this.this$0, false);
            StateDetail.m7386$$Nest$mresetToDefault(AutoBrightnessController.m7336$$Nest$fgetmStateDetail(this.this$0), "\"stop auto\"");
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).removeMessages(2);
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).removeMessages(4);
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).removeMessages(5);
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(7);
            AutoBrightnessController.m7373$$Nest$munregisterSensorListener(this.this$0);
            AutoBrightnessController.m7315$$Nest$fgetmCallBack(this.this$0).onAutoBrightnessModeChange(false);
            AutoBrightnessController.m7348$$Nest$fputmLastReqBrightness(this.this$0, -1.0f);
            AutoBrightnessController.m7372$$Nest$msetIntArrayForSetting(this.this$0, "auto_brightness_lux", AutoBrightnessController.m7332$$Nest$fgetmOriginLuxs(this.this$0));
            AutoBrightnessController.m7371$$Nest$msetFloatArrayForSetting(this.this$0, "auto_brightness_backlight", AutoBrightnessController.m7333$$Nest$fgetmOriginValues(this.this$0));
            AutoBrightnessController.m7352$$Nest$fputmScreenAutoBrightnessSpline(this.this$0, null);
            AutoBrightnessController.m7346$$Nest$fputmIsGameModeEnable(this.this$0, this.this$0.isGameModeEnable());
            return;
        L72:
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == false) goto L74;
            return;
        L74:
            StateDetail.m7386$$Nest$mresetToDefault(AutoBrightnessController.m7336$$Nest$fgetmStateDetail(this.this$0), "\"start auto\"");
            AutoBrightnessController.m7350$$Nest$fputmLuxes(this.this$0, AutoBrightnessController.m7359$$Nest$mgetIntArrayForSetting(this.this$0, "auto_brightness_lux"));
            AutoBrightnessController.m7353$$Nest$fputmValues(this.this$0, AutoBrightnessController.m7358$$Nest$mgetFloatArrayForSetting(this.this$0, "auto_brightness_backlight"));
            AutoBrightnessController.m7365$$Nest$minitLuxandValue(this.this$0);
            AutoBrightnessController.m7352$$Nest$fputmScreenAutoBrightnessSpline(this.this$0, AutoBrightnessController.m7377$$Nest$smcreateAutoBrightnessSpline(AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0), AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0)));
            if (AutoBrightnessController.m7335$$Nest$fgetmScreenAutoBrightnessSpline(this.this$0) != null) goto L77;
            AutoBrightnessController.m7368$$Nest$mresetAutoBrightnessMap(this.this$0);
        L77:
            AutoBrightnessController.m7345$$Nest$fputmIsAutoBriEnabled(this.this$0, true);
            AutoBrightnessController.m7366$$Nest$mregisterSensorListener(this.this$0);
            AutoBrightnessController.m7315$$Nest$fgetmCallBack(this.this$0).onAutoBrightnessModeChange(true);
            if (SystemProperties.getBoolean(AutoBrightnessController.DEBUG_PROPERTY, false) == false) goto L80;
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(6);
        L80:
            AutoBrightnessController.m7346$$Nest$fputmIsGameModeEnable(this.this$0, this.this$0.isGameModeEnable());
        }

        private void showDebugView() {
            if (AutoBrightnessController.m7324$$Nest$fgetmIsAutoBriEnabled(this.this$0) == true) goto L5;
        L12:
            AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0).updateLuxBrightnessData(AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0), AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0));
            return;
        L5:
            if (AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0) != null) goto L12;
            WindowManager.LayoutParams params = new WindowManager.LayoutParams(-1, -1, 2006, 1280, -3);
            WindowManager wm = (WindowManager) AutoBrightnessController.m7318$$Nest$fgetmContext(this.this$0).getSystemService("window");
            AutoBrightnessController.m7341$$Nest$fputmDebugView(this.this$0, new AutoBrightnessDebugView(AutoBrightnessController.m7318$$Nest$fgetmContext(this.this$0)));
            if (wm == null) goto L10;
            wm.addView(AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0), params);
        L10:
            AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0).updateLuxBrightnessData(AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0), AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0));
        }

        private void hideDebugView() {
            if (AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0) == null) goto L6;
            WindowManager wm = (WindowManager) AutoBrightnessController.m7318$$Nest$fgetmContext(this.this$0).getSystemService("window");
            wm.removeView(AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0));
            AutoBrightnessController.m7341$$Nest$fputmDebugView(this.this$0, null);
            return;
        }
    }

    private class ConfigurationReceiver extends BroadcastReceiver {
        final /* synthetic */ AutoBrightnessController this$0;

        /* synthetic */ ConfigurationReceiver(AutoBrightnessController r1, AutoBrightnessControllerIA r2) {
            this(r1);
        }

        private ConfigurationReceiver(AutoBrightnessController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context content, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CONFIGURATION_CHANGED") == false) goto L6;
            AutoBrightnessController.m7346$$Nest$fputmIsGameModeEnable(this.this$0, this.this$0.isGameModeEnable());
            return;
        L6:
            if (AutoBrightnessController.SLEEP_MODE_CHANGED.equals(action) == false) goto L10;
            Object obj = intent.getExtra(AutoBrightnessController.SLEEP_MODE);
            Message msg = AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).obtainMessage(11);
            msg.obj = obj;
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).sendMessage(msg);
            return;
        }
    }

    private class LuxConfiguration {
        private int highsID;
        private int lowsID;
        private int mChangingID;
        private float[][] mChangingMechanismConfig;
        private Context mContext;
        private int mExtendID;
        private int[][] mExtendLuxsConfig;
        private int[] mOriginLuxsConfig;
        private int mOriginLuxsID;
        private float[] mOriginValueConfig;
        private int mOriginValueID;
        final /* synthetic */ AutoBrightnessController this$0;

        /* synthetic */ LuxConfiguration(AutoBrightnessController r1, Context r2, AutoBrightnessControllerIA r3) {
            this(r1, r2);
        }

        private LuxConfiguration(AutoBrightnessController r1, Context context) {
            this.this$0 = r1;
            this.mContext = context;
            initColorConfig();
        }

        private void initColorConfig() {
            AutoBrightnessController.m7340$$Nest$fputmColor(this.this$0, AutoBrightnessController.DEFAULT_COLOR);
            String r0 = AutoBrightnessController.m7317$$Nest$fgetmColor(this.this$0);
            switch(r0.hashCode()) {
                case -1116426035: goto L15;
                case 3027034: goto L12;
                case 93818879: goto L9;
                case 113101865: goto L6;
                default: goto L17;
            };
        L17:
            byte r1 = -1;
        L19:
            switch(r1) {
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                default: goto L20;
            };
        L20:
            this.mOriginLuxsID = R.array.config_allowedSecureInstantAppSettings;
            this.mOriginValueID = R.array.config_allowedGlobalInstantAppSettings;
            this.lowsID = R.array.config_ambientBrighteningThresholds;
            this.highsID = R.array.config_allowedSystemInstantAppSettings;
            this.mExtendID = R.array.config_ambientThresholdLevels;
            this.mChangingID = R.array.config_ambientDarkeningThresholds;
            return;
        L21:
            this.mOriginLuxsID = 17236280;
            this.mOriginValueID = 17236279;
            this.lowsID = 17236282;
            this.highsID = 17236281;
            this.mExtendID = 17236284;
            this.mChangingID = 17236283;
            return;
        L22:
            this.mOriginLuxsID = R.array.config_angleAllowList;
            this.mOriginValueID = R.array.config_ambientThresholdsOfPeakRefreshRate;
            this.lowsID = R.array.config_autoBrightnessDisplayValuesNits;
            this.highsID = R.array.config_autoBrightnessButtonBacklightValues;
            this.mExtendID = R.array.config_autoBrightnessLcdBacklightValues;
            this.mChangingID = R.array.config_autoBrightnessDisplayValuesNitsIdle;
            return;
        L23:
            this.mOriginLuxsID = 17236319;
            this.mOriginValueID = 17236318;
            this.lowsID = 17236321;
            this.highsID = 17236320;
            this.mExtendID = 17236323;
            this.mChangingID = 17236322;
            return;
        L24:
            this.mOriginLuxsID = R.array.config_allowedSecureInstantAppSettings;
            this.mOriginValueID = R.array.config_allowedGlobalInstantAppSettings;
            this.lowsID = R.array.config_ambientBrighteningThresholds;
            this.highsID = R.array.config_allowedSystemInstantAppSettings;
            this.mExtendID = R.array.config_ambientThresholdLevels;
            this.mChangingID = R.array.config_ambientDarkeningThresholds;
            return;
        L6:
            if (r0.equals("white") == false) goto L17;
            r1 = 1;
            goto L19
        L9:
            if (r0.equals(AutoBrightnessController.DEFAULT_COLOR) == false) goto L17;
            r1 = 0;
            goto L19
        L12:
            if (r0.equals("blue") == false) goto L17;
            r1 = 2;
            goto L19
        L15:
            if (r0.equals("wine-red") == false) goto L17;
            r1 = 3;
            goto L19
        }

        public int[] getAutoBrightnessLevel() {
            this.mOriginLuxsConfig = this.mContext.getResources().getIntArray(this.mOriginLuxsID);
            return this.mOriginLuxsConfig;
        }

        public float[] getAutoBrightnessLcdBacklightValues() {
            String[] originValueIDStr = this.mContext.getResources().getStringArray(this.mOriginValueID);
            float[] originValueIDFloat = new float[originValueIDStr.length];
            int i = 0;
        L4:
            if (i >= originValueIDStr.length) goto L6;
            originValueIDFloat[i] = Float.parseFloat(originValueIDStr[i]);
            i = i + 1;
            goto L4
        L6:
            this.mOriginValueConfig = originValueIDFloat;
            return originValueIDFloat;
        }

        public float[] getAutoBrightnessLowSpec() {
            String[] lowSpecStr = this.mContext.getResources().getStringArray(this.lowsID);
            float[] lowSpecFloat = new float[lowSpecStr.length];
            int i = 0;
        L4:
            if (i >= lowSpecStr.length) goto L7;
            lowSpecFloat[i] = Float.parseFloat(lowSpecStr[i]);
            i = i + 1;
            goto L4
        L7:
            return lowSpecFloat;
        }

        public float[] getAutoBrightnessHighSpec() {
            String[] highSpecStr = this.mContext.getResources().getStringArray(this.highsID);
            float[] highSpecFloat = new float[highSpecStr.length];
            int i = 0;
        L4:
            if (i >= highSpecStr.length) goto L7;
            highSpecFloat[i] = Float.parseFloat(highSpecStr[i]);
            i = i + 1;
            goto L4
        L7:
            return highSpecFloat;
        }

        public int[][] getAutobrightnessExtend() {
            this.mExtendLuxsConfig = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.mOriginValueConfig.length, this.mOriginLuxsConfig.length});
            String[] extendLuxs = this.mContext.getResources().getStringArray(this.mExtendID);
            if (extendLuxs.length == this.mOriginValueConfig.length) goto L6;
            Slog.e(AutoBrightnessController.TAG, "extendLuxs length is not match,length=" + this.mExtendLuxsConfig.length);
            return null;
        L6:
            int i = 0;
        L8:
            if (i >= extendLuxs.length) goto L18;
            String[] items = extendLuxs[i].split(",");
            int j = 0;
        L11:
            if (j >= items.length) goto L16;
            this.mExtendLuxsConfig[i][j] = Integer.parseInt(items[j]);     // Catch: NumberFormatException -> L14
            j = j + 1;
        L15:
            return null;
        L16:
            i = i + 1;
            goto L8
        L18:
            return this.mExtendLuxsConfig;
        }

        public float[][] getAutobrightnessChangingMechanism() {
            String[] changingMechanism = this.mContext.getResources().getStringArray(this.mChangingID);
            String[] column = changingMechanism[0].split(",");
            this.mChangingMechanismConfig = (float[][]) Array.newInstance(Float.TYPE, new int[]{changingMechanism.length, column.length});
            int i = 0;
        L4:
            if (i >= changingMechanism.length) goto L15;
            String[] items = changingMechanism[i].split(",");
            int j = 0;
        L7:
            if (j >= items.length) goto L13;
            this.mChangingMechanismConfig[i][j] = Float.parseFloat(items[j]);     // Catch: NumberFormatException -> L10
            j = j + 1;
        L11:
            return null;
        L13:
            i = i + 1;
            goto L4
        L15:
            return this.mChangingMechanismConfig;
        }
    }

    private final class LuxStabilizer {
        private static final int MIN_JUMP_LUX_DIFF = 200;
        private int mMaxSizeOfMeasuredLuxues;
        private ArrayDeque<Float> mMeasuredLuxes;
        private float mStabilizedLux;
        private int mStabilizedLuxUpdateTime;
        private int mmLastLuxChangeTime;
        final /* synthetic */ AutoBrightnessController this$0;

        public LuxStabilizer(AutoBrightnessController r2, int sizeOfLuxes) {
            this.this$0 = r2;
            this.mMaxSizeOfMeasuredLuxues = sizeOfLuxes;
            this.mMeasuredLuxes = new ArrayDeque(this.mMaxSizeOfMeasuredLuxues);
        }

        public void add(int when, float lux) {
            int oriSize = this.mMeasuredLuxes.size();
            if (this.mMeasuredLuxes.isEmpty() == true) goto L15;
            float stabilizedLux = getStabilizedLux();
            float luxChange = Math.abs(lux - stabilizedLux);
            if (luxChange <= 200.0f) goto L10;
            if (luxChange <= stabilizedLux) goto L10;
            this.mMeasuredLuxes.clear();
            this.mStabilizedLuxUpdateTime = 0;
        L10:
            if ((when - this.mmLastLuxChangeTime) <= 1) goto L15;
            int i = 0;
        L13:
            if (i >= ((when - this.mmLastLuxChangeTime) - 1)) goto L15;
            float idleLux = this.mMeasuredLuxes.getLast().floatValue();
            this.mMeasuredLuxes.addLast(Float.valueOf(idleLux));
            i = i + 1;
        L15:
            this.mMeasuredLuxes.addLast(Float.valueOf(lux));
            this.mmLastLuxChangeTime = when;
            if (oriSize >= this.mMaxSizeOfMeasuredLuxues) goto L21;
            if (this.mMeasuredLuxes.size() < this.mMaxSizeOfMeasuredLuxues) goto L21;
            Message msg = AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).obtainMessage(5);
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).sendMessageAtFrontOfQueue(msg);
        L21:
            if (this.mMeasuredLuxes.size() <= this.mMaxSizeOfMeasuredLuxues) goto L23;
            this.mMeasuredLuxes.removeFirst();
            goto L21
        }

        private float getAvgLux() {
            float sum = 0.0f;
            Iterator<Float> r1 = this.mMeasuredLuxes.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            float lux = r1.next().floatValue();
            sum = sum + lux;
            goto L4
        L7:
            if (sum != 0.0f) goto L10;
            return 0.0f;
        L10:
            return sum / this.mMeasuredLuxes.size();
        }

        public float getStabilizedLux() {
            float avgLux = getAvgLux();
            int nowInSec = (int) (SystemClock.uptimeMillis() / 1000);
            if (this.mMeasuredLuxes.size() >= this.mMaxSizeOfMeasuredLuxues) goto L5;
            this.mStabilizedLuxUpdateTime = nowInSec;
            this.mStabilizedLux = avgLux;
        L11:
            float absDiff = this.mStabilizedLux;
            return absDiff;
        L5:
            float absDiff2 = Math.abs(this.mStabilizedLux - avgLux);
            if (absDiff2 <= (((double) this.mStabilizedLux) * 0.5d)) goto L9;
            this.mStabilizedLuxUpdateTime = nowInSec;
            this.mStabilizedLux = avgLux;
            goto L11
        L9:
            if ((nowInSec - this.mStabilizedLuxUpdateTime) <= this.mMeasuredLuxes.size()) goto L11;
            this.mStabilizedLuxUpdateTime = nowInSec;
            this.mStabilizedLux = (this.mStabilizedLux + avgLux) / 2.0f;
            goto L11
        }

        public void handleLuxChangeIdle() {
            if (this.mMeasuredLuxes.isEmpty() == false) goto L5;
            return;
        L5:
            if (AutoBrightnessController.m7334$$Nest$fgetmProximityPositive(this.this$0) == true) goto L9;
            int upTimeInSecond = (int) (SystemClock.uptimeMillis() / 1000);
            add(upTimeInSecond - 1, this.mMeasuredLuxes.getLast().floatValue());
            return;
        }

        public boolean isLuxStable() {
            if (this.mMeasuredLuxes.size() != 10) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class ProximitySensorHelper {
        private static final int PROXIMITY_NEGATIVE = 0;
        private static final int PROXIMITY_POSITIVE = 1;
        private static final int PROXIMITY_UNKNOWN = -1;
        private static final float TYPICAL_PROXIMITY_THRESHOLD = 5.0f;
        private SensorCallBack mCallBack;
        private int mProximity;
        private Sensor mProximitySensor;
        private boolean mProximitySensorEnabled;
        private final SensorEventListener mProximitySensorListener;
        private float mProximityThreshold;
        private SensorManager mSensorManager;

        public interface SensorCallBack {
            void onStateChanged(long r1, boolean r3);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximitySensorEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7379$$Nest$fgetmProximitySensorEnabled(ProximitySensorHelper r0) {
            return r0.mProximitySensorEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximityThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m7380$$Nest$fgetmProximityThreshold(ProximitySensorHelper r0) {
            return r0.mProximityThreshold;
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleProximitySensorEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7381$$Nest$mhandleProximitySensorEvent(ProximitySensorHelper r0, long r1, boolean r3) {
            r0.handleProximitySensorEvent(r1, r3);
        }

        public ProximitySensorHelper(SensorManager sensorManager) {
            this.mProximitySensorEnabled = false;
            this.mProximitySensorListener = new AnonymousClass1(this);
            this.mSensorManager = sensorManager;
            this.mProximitySensor = this.mSensorManager.getDefaultSensor(8);
            if (this.mProximitySensor == null) goto L6;
            this.mProximityThreshold = Math.min(this.mProximitySensor.getMaximumRange(), TYPICAL_PROXIMITY_THRESHOLD);
            return;
        }

        public void setProximitySensorEnabled(boolean enable) {
            if (enable == false) goto L8;
            if (this.mProximitySensorEnabled == true) goto L11;
            this.mProximitySensorEnabled = true;
            this.mProximity = -1;
            this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximitySensor, 3);
            return;
        L11:
            return;
        L8:
            if (this.mProximitySensorEnabled == false) goto L13;
            this.mProximitySensorEnabled = false;
            this.mProximity = -1;
            this.mSensorManager.unregisterListener(this.mProximitySensorListener);
            return;
        }

        public void setCallBack(SensorCallBack callBack) {
            this.mCallBack = callBack;
        }

        private void triggerCallBack(long time, boolean positive) {
            if (this.mCallBack == null) goto L6;
            this.mCallBack.onStateChanged(time, positive);
            return;
        }

        private void handleProximitySensorEvent(long time, boolean positive) {
            if (positive == false) goto L7;
            if (this.mProximity == 1) goto L10;
            this.mProximity = 1;
            triggerCallBack(time, positive);
            return;
        L10:
            return;
        L7:
            if (this.mProximity == 0) goto L12;
            this.mProximity = 0;
            triggerCallBack(time, positive);
            return;
        }
    }

    private class SensorData {
        private float lux;
        private float time;

        public SensorData(AutoBrightnessController r1, float time, float lux) {
            this.time = time;
            this.lux = lux;
        }

        public float getTime() {
            return this.time;
        }

        public float getLux() {
            return this.lux;
        }
    }

    class SensorHandleTask {
        private final int mChangeDataMaxSize;
        private final int mDataMaxSize;
        private ArrayDeque<SensorData> sensorChangeDatas;
        private ArrayDeque<SensorData> sensorDatas;
        final /* synthetic */ AutoBrightnessController this$0;

        /* JADX INFO: renamed from: -$$Nest$mclearData, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7382$$Nest$mclearData(SensorHandleTask r0) {
            r0.clearData();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetSensorAvg, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m7383$$Nest$mgetSensorAvg(SensorHandleTask r0) {
            return r0.getSensorAvg();
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleData, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7384$$Nest$mhandleData(SensorHandleTask r0, SensorData r1) {
            r0.handleData(r1);
        }

        public SensorHandleTask(AutoBrightnessController this$0) {
            this.this$0 = this$0;
            this.sensorDatas = new ArrayDeque();
            this.sensorChangeDatas = new ArrayDeque();
            this.mDataMaxSize = 7;
            this.mChangeDataMaxSize = 100;
        }

        private void handleData(SensorData data) {
            if (AutoBrightnessController.m7320$$Nest$fgetmFirstLux(this.this$0) == false) goto L6;
            if (data == null) goto L6;
            AutoBrightnessController.m7342$$Nest$fputmFirstLux(this.this$0, false);
            AutoBrightnessController.m7355$$Nest$mautoAdjustBrightnessFirstly(this.this$0, data.getLux());
        L6:
            this.sensorDatas.addFirst(data);
            this.sensorChangeDatas.addFirst(data);
            if (getTimeInterval(this.sensorDatas) >= 0.5f) goto L10;
            Slog.d(AutoBrightnessController.TAG, "sensor data time is not enough.");
            return;
        L10:
            this.sensorDatas.removeLast();
            if (getTimeInterval(this.sensorChangeDatas) <= 10.0f) goto L14;
            this.sensorChangeDatas.removeLast();
        L14:
            if (Math.abs(AutoBrightnessController.m7328$$Nest$fgetmLastReqBrightness(this.this$0) - (-1.0f)) < AutoBrightnessController.EPSILON) goto L16;
        L20:
            float avg = getSensorAvg();
            if (AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0) == null) goto L23;
            AutoBrightnessController.m7319$$Nest$fgetmDebugView(this.this$0).updateAvgLuxData(avg);
        L23:
            boolean isMatchBrightness = isLuxMatchBrightness(avg);
            boolean canSwitchToNextLevel = !isMatchBrightness;
            if (canSwitchToNextLevel == true) goto L26;
            AutoBrightnessController.m7378$$Nest$smlog("can not switch to next level, avg=" + avg + ",isMatchBrightness=" + isMatchBrightness);
        L26:
            if (canSwitchToNextLevel == false) goto L29;
            switchToNextLevel((int) (SystemClock.uptimeMillis() / 1000), avg);
            return;
        L29:
            return;
        L16:
            if (getTimeInterval(this.sensorDatas) < 1.0f) goto L20;
            AutoBrightnessController.m7348$$Nest$fputmLastReqBrightness(this.this$0, this.this$0.getCurrentBrightness());
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L20;
            AutoBrightnessController.m7378$$Nest$smlog("handleData get current brightness mLastReqBrightness ==" + AutoBrightnessController.m7328$$Nest$fgetmLastReqBrightness(this.this$0));
            goto L20
        }

        private void clearData() {
            this.sensorDatas.clear();
            this.sensorChangeDatas.clear();
        }

        private float getTimeInterval(ArrayDeque<SensorData> data) {
            float timeInterval = data.getFirst().getTime() - data.getLast().getTime();
            if (timeInterval >= 0.0f) goto L5;
            Slog.e(AutoBrightnessController.TAG, "getTimeInterval error,timeInterval:" + timeInterval);
        L5:
            return timeInterval;
        }

        private float getSensorAvg() {
            this.sensorDatas.size();
            float sum = 0.0f;
            int sumSize = 0;
            Iterator<SensorData> r3 = this.sensorDatas.iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            SensorData data = r3.next();
            if (sumSize > 7) goto L10;
            sum = sum + data.getLux();
            sumSize = sumSize + 1;
        L10:
            if (sum != 0.0f) goto L12;
            return 0.0f;
        L12:
            float ret = sum / sumSize;
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L15;
            Slog.d(AutoBrightnessController.TAG, "getSensorAvg sum:" + sum + ",size:" + sumSize + ",ret:" + ret + ",sensorChangeDatas=" + this.sensorChangeDatas.size());
        L15:
            return ret;
        }

        private boolean isLuxMatchBrightness(float avg) {
            int index = AutoBrightnessController.m7357$$Nest$mgetBrightnessIndexFromLux(this.this$0, avg);
            if (index >= 0) goto L5;
            boolean r17 = false;
        L87:
            Slog.e(AutoBrightnessController.TAG, "out of mValues array index." + Log.getStackTraceString(new Throwable()));
            AutoBrightnessController.m7368$$Nest$mresetAutoBrightnessMap(this.this$0);
            return r17;
        L5:
            if (index < AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0).length) goto L7;
            r17 = false;
            goto L87
        L7:
            float cfgBrightness = AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0)[index];
            float currentBrightness = this.this$0.getCurrentBrightness();
            boolean r8 = true;
            if (AutoBrightnessController.m7322$$Nest$fgetmFirstStart(this.this$0) == false) goto L10;
            float computationTime = AutoBrightnessController.m7316$$Nest$fgetmChangingMechanism(this.this$0)[9][1];
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).postDelayed(new AnonymousClass1(this), (long) (1000.0f * computationTime));
        L14:
            float interValTime = getTimeInterval(this.sensorChangeDatas);
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L18;
            AutoBrightnessController.m7378$$Nest$smlog("computationTime =" + computationTime + ",interValTime=" + interValTime);
        L18:
            if (interValTime >= computationTime) goto L20;
            return true;
        L20:
            SensorData tmpSensorData = this.sensorChangeDatas.getFirst();
            int computationSize = 0;
            if (index != 0) goto L38;
            Iterator<SensorData> r14 = this.sensorChangeDatas.iterator();
        L24:
            if (r14.hasNext() == false) goto L36;
            SensorData data = r14.next();
            if (computationSize > 100) goto L27;
            boolean r18 = false;
            if (data.getLux() >= AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0)[index]) goto L30;
            if ((tmpSensorData.getTime() - data.getTime()) > computationTime) goto L37;
            computationSize = computationSize + 1;
        L37:
            boolean r16 = true;
        L79:
            if (currentBrightness != cfgBrightness) goto L81;
            boolean result = r16;
        L82:
            if (result == false) goto L84;
            AutoBrightnessController.m7378$$Nest$smlog("isLuxMatchBrightness  cfgBrightness:" + cfgBrightness + ",currentBrightness:" + currentBrightness);
        L84:
            return result;
        L81:
            result = r18;
            goto L82
        L30:
            AutoBrightnessController.m7378$$Nest$smlog("one lux is not match,lux:" + data.getLux() + ",index=" + index);
            return true;
        L27:
            r18 = false;
            goto L37
        L36:
            r18 = false;
            goto L37
        L38:
            r18 = false;
            if (index != (AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0).length - 1)) goto L56;
            Iterator<SensorData> r3 = this.sensorChangeDatas.iterator();
        L42:
            if (r3.hasNext() == false) goto L54;
            SensorData data2 = r3.next();
            if (computationSize > 100) goto L45;
            r16 = r8;
            if (data2.getLux() < AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0)[index - 1]) goto L48;
            if ((tmpSensorData.getTime() - data2.getTime()) > computationTime) goto L79;
            computationSize = computationSize + 1;
            r8 = r16;
            goto L42
        L48:
            AutoBrightnessController.m7378$$Nest$smlog("one lux is not match,lux:" + data2.getLux() + ",index=" + index);
            return r16;
        L45:
            r16 = r8;
            goto L79
        L54:
            r16 = r8;
            goto L79
        L56:
            r16 = true;
            if (index > 0) goto L59;
        L85:
            return true;
        L59:
            if (index >= (AutoBrightnessController.m7339$$Nest$fgetmValues(this.this$0).length - 1)) goto L85;
            Iterator<SensorData> r4 = this.sensorChangeDatas.iterator();
        L62:
            if (r4.hasNext() == false) goto L79;
            SensorData data3 = r4.next();
            if (computationSize > 100) goto L79;
            if (data3.getLux() < AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0)[index - 1]) goto L75;
            if (data3.getLux() >= AutoBrightnessController.m7330$$Nest$fgetmLuxes(this.this$0)[index]) goto L75;
            if ((tmpSensorData.getTime() - data3.getTime()) > computationTime) goto L79;
            computationSize = computationSize + 1;
        L75:
            AutoBrightnessController.m7378$$Nest$smlog("one lux is not match,lux:" + data3.getLux() + ",index=" + index);
            return true;
        L10:
            int difference = (index - AutoBrightnessController.m7327$$Nest$fgetmLastReqBrightLevel(this.this$0)) + 9;
            if (difference < AutoBrightnessController.m7316$$Nest$fgetmChangingMechanism(this.this$0).length) goto L13;
            difference = AutoBrightnessController.m7316$$Nest$fgetmChangingMechanism(this.this$0).length - 1;
        L13:
            computationTime = AutoBrightnessController.m7316$$Nest$fgetmChangingMechanism(this.this$0)[difference][1];
            goto L14
        }

        private void switchToNextLevel(int uptimeInSecond, float lux) {
            if (AutoBrightnessController.m7374$$Nest$sfgetDBG() == false) goto L5;
            AutoBrightnessController.m7378$$Nest$smlog("switchToNextLevel uptimeInSecond:" + uptimeInSecond + ",lux:" + lux);
        L5:
            Message msg = AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).obtainMessage(4);
            Bundle bundle = new Bundle();
            bundle.putInt("time", uptimeInSecond);
            bundle.putFloat("lux", lux);
            msg.setData(bundle);
            AutoBrightnessController.m7323$$Nest$fgetmHandler(this.this$0).sendMessage(msg);
        }
    }

    @interface State {
    }

    private class StateDetail {
        private static final int LEVEL_DIFF = 2;
        private static final long LUX_CHANGE_TIME_MS = 5000;
        private static final long STABLE_TO_AUTO_MS = 86400000;
        private static final long WAIT_FOR_ADJ_MS = 60000;
        private float mRecordLux;
        private long mRecordTime;
        private int mState;
        final /* synthetic */ AutoBrightnessController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7385$$Nest$fgetmState(StateDetail r0) {
            return r0.mState;
        }

        /* JADX INFO: renamed from: -$$Nest$mresetToDefault, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7386$$Nest$mresetToDefault(StateDetail r0, String r1) {
            r0.resetToDefault(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateStateWhenAdjust, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7387$$Nest$mupdateStateWhenAdjust(StateDetail r0, long r1, float r3, boolean r4) {
            r0.updateStateWhenAdjust(r1, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateStateWithLux, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7388$$Nest$mupdateStateWithLux(StateDetail r0, long r1, float r3) {
            r0.updateStateWithLux(r1, r3);
        }

        /* synthetic */ StateDetail(AutoBrightnessController r1, AutoBrightnessControllerIA r2) {
            this(r1);
        }

        private StateDetail(AutoBrightnessController r1) {
            this.this$0 = r1;
            resetToDefault("\"init this field\"");
        }

        private void resetToDefault(String reason) {
            int oldState = this.mState;
            this.mState = 0;
            this.mRecordTime = SystemClock.uptimeMillis();
            this.mRecordLux = -1.0f;
            Slog.d(AutoBrightnessController.TAG, "resetToDefault: " + stateToString(oldState) + "->" + stateToString(this.mState) + ", reason=" + reason);
        }

        private void updateStateWhenAdjust(long timeInMs, float lux, boolean isOverflow) {
            int oldState = this.mState;
            String logReason = null;
            if (this.mState != 0) goto L7;
            if (isOverflow == false) goto L16;
            this.mState = 1;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"adjust overflow\"";
        L16:
            if (this.mState == oldState) goto L19;
            Slog.d(AutoBrightnessController.TAG, "updateStateWhenAdjust: " + stateToString(oldState) + "->" + stateToString(this.mState) + ", reason=" + logReason);
            return;
        L19:
            return;
        L7:
            if (this.mState != 1) goto L12;
            if (isOverflow == false) goto L10;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            goto L16
        L10:
            this.mState = 0;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"adjust within threshold\"";
            goto L16
        L12:
            if (this.mState != 2) goto L16;
            this.mState = 3;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"adjust once again\"";
            goto L16
        }

        private void updateStateWithLux(long timeInMs, float lux) {
            int oldState = this.mState;
            String logReason = null;
            if (this.mState != 0) goto L6;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
        L25:
            if (this.mState == oldState) goto L28;
            Slog.d(AutoBrightnessController.TAG, "updateStateWithLux: " + stateToString(oldState) + "->" + stateToString(this.mState) + ", reason=" + logReason);
            return;
        L28:
            return;
        L6:
            if (this.mState != 1) goto L14;
            if (Math.abs(AutoBrightnessController.m7357$$Nest$mgetBrightnessIndexFromLux(this.this$0, lux) - AutoBrightnessController.m7357$$Nest$mgetBrightnessIndexFromLux(this.this$0, this.mRecordLux)) >= 2) goto L11;
            this.mRecordTime = timeInMs;
            goto L25
        L11:
            if ((timeInMs - this.mRecordTime) <= LUX_CHANGE_TIME_MS) goto L25;
            this.mState = 2;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"lux has changed indeed\"";
            goto L25
        L14:
            if (this.mState != 2) goto L20;
            if ((timeInMs - this.mRecordTime) <= 60000) goto L18;
            this.mState = 0;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"wait but no adjustment\"";
            goto L25
        L18:
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            goto L25
        L20:
            if (this.mState != 3) goto L25;
            if ((timeInMs - this.mRecordTime) <= 86400000) goto L25;
            this.mState = 0;
            this.mRecordTime = timeInMs;
            this.mRecordLux = lux;
            logReason = "\"stable more than one day\"";
            goto L25
        }

        public String toString() {
            return "StateDetail{mState=" + stateToString(this.mState) + ", mRecordTime=" + this.mRecordTime + ", mRecordLux=" + this.mRecordLux + ", level=" + AutoBrightnessController.m7357$$Nest$mgetBrightnessIndexFromLux(this.this$0, this.mRecordLux) + "}";
        }

        private String stateToString(int state) {
            if (state != 0) goto L6;
            return "AUTO";
        L6:
            if (state != 1) goto L10;
            return "MANUAL";
        L10:
            if (state != 2) goto L14;
            return "WAIT";
        L14:
            if (state != 3) goto L18;
            return "STABLE";
        L18:
            throw new IllegalArgumentException(String.valueOf(state));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallBack, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutoBrightnessCallBack m7315$$Nest$fgetmCallBack(AutoBrightnessController r0) {
        return r0.mCallBack;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChangingMechanism, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[][] m7316$$Nest$fgetmChangingMechanism(AutoBrightnessController r0) {
        return r0.mChangingMechanism;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmColor, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7317$$Nest$fgetmColor(AutoBrightnessController r0) {
        return r0.mColor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7318$$Nest$fgetmContext(AutoBrightnessController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebugView, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutoBrightnessDebugView m7319$$Nest$fgetmDebugView(AutoBrightnessController r0) {
        return r0.mDebugView;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFirstLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7320$$Nest$fgetmFirstLux(AutoBrightnessController r0) {
        return r0.mFirstLux;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFirstLuxsTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7321$$Nest$fgetmFirstLuxsTime(AutoBrightnessController r2) {
        return r2.mFirstLuxsTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFirstStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7322$$Nest$fgetmFirstStart(AutoBrightnessController r0) {
        return r0.mFirstStart;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutoBrightnessControllerHandler m7323$$Nest$fgetmHandler(AutoBrightnessController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsAutoBriEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7324$$Nest$fgetmIsAutoBriEnabled(AutoBrightnessController r0) {
        return r0.mIsAutoBriEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsGameModeEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7325$$Nest$fgetmIsGameModeEnable(AutoBrightnessController r0) {
        return r0.mIsGameModeEnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7326$$Nest$fgetmIsScreenOn(AutoBrightnessController r0) {
        return r0.mIsScreenOn;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastReqBrightLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7327$$Nest$fgetmLastReqBrightLevel(AutoBrightnessController r0) {
        return r0.mLastReqBrightLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastReqBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m7328$$Nest$fgetmLastReqBrightness(AutoBrightnessController r0) {
        return r0.mLastReqBrightness;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightSensorChangeTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7329$$Nest$fgetmLightSensorChangeTime(AutoBrightnessController r2) {
        return r2.mLightSensorChangeTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLuxes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7330$$Nest$fgetmLuxes(AutoBrightnessController r0) {
        return r0.mLuxes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLuxesStabilizer, reason: not valid java name */
    static /* bridge */ /* synthetic */ LuxStabilizer m7331$$Nest$fgetmLuxesStabilizer(AutoBrightnessController r0) {
        return r0.mLuxesStabilizer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOriginLuxs, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7332$$Nest$fgetmOriginLuxs(AutoBrightnessController r0) {
        return r0.mOriginLuxs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOriginValues, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[] m7333$$Nest$fgetmOriginValues(AutoBrightnessController r0) {
        return r0.mOriginValues;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProximityPositive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7334$$Nest$fgetmProximityPositive(AutoBrightnessController r0) {
        return r0.mProximityPositive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenAutoBrightnessSpline, reason: not valid java name */
    static /* bridge */ /* synthetic */ Spline m7335$$Nest$fgetmScreenAutoBrightnessSpline(AutoBrightnessController r0) {
        return r0.mScreenAutoBrightnessSpline;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStateDetail, reason: not valid java name */
    static /* bridge */ /* synthetic */ StateDetail m7336$$Nest$fgetmStateDetail(AutoBrightnessController r0) {
        return r0.mStateDetail;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSubWorkHander, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7337$$Nest$fgetmSubWorkHander(AutoBrightnessController r0) {
        return r0.mSubWorkHander;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorHandleTask m7338$$Nest$fgetmTask(AutoBrightnessController r0) {
        return r0.mTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmValues, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[] m7339$$Nest$fgetmValues(AutoBrightnessController r0) {
        return r0.mValues;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmColor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7340$$Nest$fputmColor(AutoBrightnessController r0, String r1) {
        r0.mColor = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDebugView, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7341$$Nest$fputmDebugView(AutoBrightnessController r0, AutoBrightnessDebugView r1) {
        r0.mDebugView = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFirstLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7342$$Nest$fputmFirstLux(AutoBrightnessController r0, boolean r1) {
        r0.mFirstLux = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFirstLuxsTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7343$$Nest$fputmFirstLuxsTime(AutoBrightnessController r0, long r1) {
        r0.mFirstLuxsTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFirstStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7344$$Nest$fputmFirstStart(AutoBrightnessController r0, boolean r1) {
        r0.mFirstStart = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsAutoBriEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7345$$Nest$fputmIsAutoBriEnabled(AutoBrightnessController r0, boolean r1) {
        r0.mIsAutoBriEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsGameModeEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7346$$Nest$fputmIsGameModeEnable(AutoBrightnessController r0, boolean r1) {
        r0.mIsGameModeEnable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7347$$Nest$fputmIsScreenOn(AutoBrightnessController r0, boolean r1) {
        r0.mIsScreenOn = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastReqBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7348$$Nest$fputmLastReqBrightness(AutoBrightnessController r0, float r1) {
        r0.mLastReqBrightness = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLightSensorChangeTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7349$$Nest$fputmLightSensorChangeTime(AutoBrightnessController r0, long r1) {
        r0.mLightSensorChangeTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLuxes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7350$$Nest$fputmLuxes(AutoBrightnessController r0, int[] r1) {
        r0.mLuxes = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProximityPositive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7351$$Nest$fputmProximityPositive(AutoBrightnessController r0, boolean r1) {
        r0.mProximityPositive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScreenAutoBrightnessSpline, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7352$$Nest$fputmScreenAutoBrightnessSpline(AutoBrightnessController r0, Spline r1) {
        r0.mScreenAutoBrightnessSpline = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmValues, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7353$$Nest$fputmValues(AutoBrightnessController r0, float[] r1) {
        r0.mValues = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$madjustLuxExtend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7354$$Nest$madjustLuxExtend(AutoBrightnessController r0, int r1) {
        r0.adjustLuxExtend(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mautoAdjustBrightnessFirstly, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7355$$Nest$mautoAdjustBrightnessFirstly(AutoBrightnessController r0, float r1) {
        r0.autoAdjustBrightnessFirstly(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcalibrationBrightnessArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7356$$Nest$mcalibrationBrightnessArray(AutoBrightnessController r0, float[] r1) {
        r0.calibrationBrightnessArray(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBrightnessIndexFromLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7357$$Nest$mgetBrightnessIndexFromLux(AutoBrightnessController r0, float r1) {
        return r0.getBrightnessIndexFromLux(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFloatArrayForSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float[] m7358$$Nest$mgetFloatArrayForSetting(AutoBrightnessController r0, String r1) {
        return r0.getFloatArrayForSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIntArrayForSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7359$$Nest$mgetIntArrayForSetting(AutoBrightnessController r0, String r1) {
        return r0.getIntArrayForSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAdjust, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7360$$Nest$mhandleAdjust(AutoBrightnessController r0, float r1, float r2) {
        r0.handleAdjust(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBrightnessModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7361$$Nest$mhandleBrightnessModeChanged(AutoBrightnessController r0) {
        r0.handleBrightnessModeChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleLuxChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7362$$Nest$mhandleLuxChange(AutoBrightnessController r0, float r1) {
        r0.handleLuxChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePolicyChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7363$$Nest$mhandlePolicyChanged(AutoBrightnessController r0, int r1) {
        r0.handlePolicyChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSleepMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7364$$Nest$mhandleSleepMode(AutoBrightnessController r0, Object r1) {
        r0.handleSleepMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minitLuxandValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7365$$Nest$minitLuxandValue(AutoBrightnessController r0) {
        r0.initLuxandValue();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterSensorListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7366$$Nest$mregisterSensorListener(AutoBrightnessController r0) {
        r0.registerSensorListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestAutoBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7367$$Nest$mrequestAutoBrightness(AutoBrightnessController r0, float r1, int r2) {
        r0.requestAutoBrightness(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetAutoBrightnessMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7368$$Nest$mresetAutoBrightnessMap(AutoBrightnessController r0) {
        r0.resetAutoBrightnessMap();
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreLuxandValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7369$$Nest$mrestoreLuxandValue(AutoBrightnessController r0) {
        r0.restoreLuxandValue();
    }

    /* JADX INFO: renamed from: -$$Nest$msetBrightnessGradientEnd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7370$$Nest$msetBrightnessGradientEnd(AutoBrightnessController r0) {
        r0.setBrightnessGradientEnd();
    }

    /* JADX INFO: renamed from: -$$Nest$msetFloatArrayForSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7371$$Nest$msetFloatArrayForSetting(AutoBrightnessController r0, String r1, float[] r2) {
        r0.setFloatArrayForSetting(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetIntArrayForSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7372$$Nest$msetIntArrayForSetting(AutoBrightnessController r0, String r1, int[] r2) {
        r0.setIntArrayForSetting(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterSensorListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7373$$Nest$munregisterSensorListener(AutoBrightnessController r0) {
        r0.unregisterSensorListener();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDBG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7374$$Nest$sfgetDBG() {
        return DBG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmCurrentLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m7375$$Nest$sfgetmCurrentLux() {
        return mCurrentLux;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputmCurrentLux, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7376$$Nest$sfputmCurrentLux(float r0) {
        mCurrentLux = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateAutoBrightnessSpline, reason: not valid java name */
    static /* bridge */ /* synthetic */ Spline m7377$$Nest$smcreateAutoBrightnessSpline(int[] r0, float[] r1) {
        return createAutoBrightnessSpline(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smlog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7378$$Nest$smlog(String r0) {
        log(r0);
    }

    static {
        DBG = Log.isLoggable(TAG, 3);
        mCurrentLux = 0.0f;
    }

    private void calibrationBrightnessArray(float[] array) {
        if (array != null) goto L6;
        Slog.e(TAG, "calibration array is null.");
        return;
    L6:
        int len = array.length;
        if (len == this.lows.length) goto L10;
        Slog.e(TAG, "calibrationBrightnessArray error,len not equal lows[] length.");
        return;
    L10:
        int first_cali_level = -1;
        int i = 0;
    L11:
        if (i >= len) goto L17;
        if (array[i] > this.highs[i]) goto L14;
        i = i + 1;
        goto L11
    L14:
        first_cali_level = i;
    L17:
        if (first_cali_level != (-1)) goto L24;
        int i2 = len - 1;
    L19:
        if (i2 <= (-1)) goto L24;
        if (array[i2] < this.lows[i2]) goto L22;
        i2 = i2 - 1;
        goto L19
    L22:
        first_cali_level = i2;
    L24:
        if (first_cali_level != (-1)) goto L26;
    L48:
        int i3 = 0;
    L49:
        if (i3 >= len) goto L52;
        array[i3] = constrain(array[i3], this.lows[i3], this.highs[i3], this.mOriginValues[i3]);
        i3 = i3 + 1;
        goto L49
    L52:
        if (this.mDebugView == null) goto L70;
        this.mDebugView.updateLuxBrightnessData(this.mLuxes, this.mValues);
        return;
    L70:
        return;
    L26:
        if (array[first_cali_level] <= this.highs[first_cali_level]) goto L38;
        array[first_cali_level] = this.highs[first_cali_level];
        int i4 = 0;
    L28:
        if (i4 >= len) goto L48;
        if (i4 == first_cali_level) goto L36;
        array[i4] = this.mOriginValues[i4];
        if (i4 <= first_cali_level) goto L36;
        if (array[i4] >= array[first_cali_level]) goto L36;
        array[i4] = array[first_cali_level];
    L36:
        i4 = i4 + 1;
        goto L28
    L38:
        array[first_cali_level] = this.lows[first_cali_level];
        int i5 = 0;
    L39:
        if (i5 >= len) goto L48;
        if (i5 == first_cali_level) goto L47;
        array[i5] = this.mOriginValues[i5];
        if (i5 >= first_cali_level) goto L47;
        if (array[i5] <= array[first_cali_level]) goto L47;
        array[i5] = array[first_cali_level];
    L47:
        i5 = i5 + 1;
        goto L39
    }

    private float constrain(float value, float low, float high, float def) {
        float min = Math.min(value, low);
        float max = Math.max(value, high);
        if (Math.abs(min - low) < EPSILON) goto L5;
    L7:
        return def;
    L5:
        if (Math.abs(max - high) >= EPSILON) goto L7;
        return value;
    }

    public boolean isGameModeEnable() {
        return false;
    }

    public static boolean isGameMode() {
        return false;
    }

    public static AutoBrightnessController init(Looper looper, Context context, SensorManager sensorManager, AutoBrightnessCallBack callBack) {
        if (sMe != null) goto L6;
        sMe = new AutoBrightnessController(looper, context, sensorManager, callBack);
    L6:
        return sMe;
    }

    private AutoBrightnessController(Looper looper, Context context, SensorManager sensorManager, AutoBrightnessCallBack callBack) {
        AutoBrightnessControllerIA r1 = null;
        this.mStateDetail = new StateDetail(this, r1);
        this.mIsScreenOn = true;
        this.mIsRegistered = false;
        this.mOrientation = 0;
        this.mProximityPositive = false;
        this.mLastReqBrightness = -1.0f;
        this.mLastReqBrightLevel = 0;
        this.mFirstStart = false;
        this.mFirstLux = false;
        this.mLuxesStabilizer = new LuxStabilizer(this, 10);
        this.mTask = new SensorHandleTask(this);
        this.mFirstLuxsTime = 0;
        this.minimumBacklight = 0.04f;
        this.minimumBacklightInt = 10;
        this.mDesiredPolicy = 3;
        this.mSleepModeUnregist = false;
        this.mSensorCallBack = new AnonymousClass1(this);
        final AutoBrightnessControllerHandler r3 = this.mHandler;
        this.mBrightnessModeObserver = new AnonymousClass2(this, r3);
        this.mLightSensorListener = new AnonymousClass3(this);
        this.mNextBrightnessLevel = 15;
        this.mLuxChangeTrend = 0;
        this.mActivityObserver = new AnonymousClass5(this);
        this.mContext = context;
        this.mHandler = new AutoBrightnessControllerHandler(this, looper);
        this.mSensorManager = sensorManager;
        this.mLightSensor = this.mSensorManager.getDefaultSensor(5);
        this.mCallBack = callBack;
        this.mLuxConfiguration = new LuxConfiguration(this, this.mContext, r1);
        this.mOriginLuxs = this.mLuxConfiguration.getAutoBrightnessLevel();
        this.mOriginValues = this.mLuxConfiguration.getAutoBrightnessLcdBacklightValues();
        this.lows = this.mLuxConfiguration.getAutoBrightnessLowSpec();
        this.highs = this.mLuxConfiguration.getAutoBrightnessHighSpec();
        this.mExtendLuxs = this.mLuxConfiguration.getAutobrightnessExtend();
        this.mChangingMechanism = this.mLuxConfiguration.getAutobrightnessChangingMechanism();
        initLuxandValue();
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mPackageManager = context.getPackageManager();
        this.mActivityManagerService = IActivityManager.Stub.asInterface(ServiceManager.getService(HostingRecord.HOSTING_TYPE_ACTIVITY));
        initWorkThread();
        this.minimumBacklightInt = this.mContext.getResources().getInteger(R.integer.config_showOperatorNameDefault);
    }

    private void initLuxandValue() {
        if (this.mOriginLuxs != null) goto L5;
        return;
    L5:
        if (this.mOriginValues != null) goto L7;
        return;
    L7:
        if (this.mLuxes != null) goto L9;
    L14:
        this.mLuxes = Arrays.copyOf(this.mOriginLuxs, this.mOriginLuxs.length);
        this.mValues = Arrays.copyOf(this.mOriginValues, this.mOriginValues.length);
        return;
    L9:
        if (this.mValues == null) goto L14;
        if (this.mLuxes.length != this.mOriginLuxs.length) goto L14;
        if (this.mValues.length != this.mOriginValues.length) goto L14;
    }

    private void restoreLuxandValue() {
        this.mLuxes = Arrays.copyOf(this.mOriginLuxs, this.mOriginLuxs.length);
        this.mValues = Arrays.copyOf(this.mOriginValues, this.mOriginValues.length);
        setIntArrayForSetting("auto_brightness_lux", this.mOriginLuxs);
        setFloatArrayForSetting("auto_brightness_backlight", this.mOriginValues);
    }

    public void activate() {
        ContentResolver resolver = this.mContext.getContentResolver();
        resolver.registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), false, this.mBrightnessModeObserver, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("game_mode_lock_auto_brightness_enable"), false, this.mBrightnessModeObserver, -1);
        if (isAutoBrightnessBySetting() == false) goto L6;
        startAutoBrightness();
        return;
    }

    public void onScreenStateChange(boolean r4) {
        Message r0 = this.mHandler.obtainMessage(8, r4 ? 1 : 0, -1);
        this.mHandler.sendMessage(r0);
    }

    public void setDesiredPolicy(int desiredPolicy) {
        Message msg = this.mHandler.obtainMessage(12, desiredPolicy, -1);
        this.mHandler.sendMessage(msg);
    }

    public boolean isBrightOrDim(int policy) {
        if (policy != 3) goto L5;
    L8:
        return true;
    L5:
        if (policy == 2) goto L8;
        return false;
    }

    private void handlePolicyChanged(int desiredPolicy) {
        if (this.mDesiredPolicy == desiredPolicy) goto L12;
        log("handlePolicyChanged:" + DisplayManagerInternal.DisplayPowerRequest.policyToString(this.mDesiredPolicy) + "->" + DisplayManagerInternal.DisplayPowerRequest.policyToString(desiredPolicy) + ",auto=" + this.mIsAutoBriEnabled + " unregist=" + this.mSleepModeUnregist);
        this.mDesiredPolicy = desiredPolicy;
        if (this.mIsAutoBriEnabled == true) goto L7;
        return;
    L7:
        if (this.mSleepModeUnregist == true) goto L9;
        return;
    L9:
        if (isBrightOrDim(desiredPolicy) == false) goto L15;
        this.mSleepModeUnregist = false;
        registerSensorListener();
        return;
    L15:
        return;
    }

    private void handleSleepMode(Object obj) {
        log("handleSleepMode obj=" + obj + " auto=" + this.mIsAutoBriEnabled + " policy=" + DisplayManagerInternal.DisplayPowerRequest.policyToString(this.mDesiredPolicy));
        if (obj != null) goto L5;
        return;
    L5:
        if ((obj instanceof Boolean) == false) goto L15;
        boolean sleepMode = ((Boolean) obj).booleanValue();
        if (sleepMode == true) goto L9;
        return;
    L9:
        if (this.mIsAutoBriEnabled == true) goto L11;
        return;
    L11:
        if (isBrightOrDim(this.mDesiredPolicy) == true) goto L18;
        this.mSleepModeUnregist = true;
        unregisterSensorListener();
        return;
    L18:
        return;
    }

    public void registerReceiver() {
        this.mConfigurationReceiver = new ConfigurationReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        filter.addAction(SLEEP_MODE_CHANGED);
        this.mContext.registerReceiver(this.mConfigurationReceiver, filter);
    }

    public void autoBrightnessStateChange(boolean r4, boolean r5) {
        if (r4 == true) goto L4;
        return;
    L4:
        if (this.mIsAutoBriEnabled == true) goto L6;
        return;
    L6:
        if (DBG == false) goto L8;
        log("useAutoBrightness = " + r5);
    L8:
        this.mHandler.removeMessages(10);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10, r5 ? 1 : 0, -1));
    }

    private int[] getIntArrayForSetting(String setting) {
        String value = Settings.System.getStringForUser(this.mContext.getContentResolver(), setting, -2);
        if (value != null) goto L5;
        return null;
    L5:
        String[] items = value.split(",");
        if (items != null) goto L8;
    L19:
        return null;
    L8:
        if (items.length == 0) goto L19;
        int[] values = new int[items.length];
        int i = 0;
    L12:
        if (i >= items.length) goto L18;
        values[i] = Integer.parseInt(items[i]);     // Catch: NumberFormatException -> L15
        i = i + 1;
    L16:
        return null;
    L18:
        return values;
    }

    private void setIntArrayForSetting(String setting, int[] array) {
        if (array != null) goto L4;
        return;
    L4:
        if (array.length == 0) goto L14;
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        int i = 1;
    L8:
        if (i >= array.length) goto L10;
        sb.append(",");
        sb.append(array[i]);
        i = i + 1;
        goto L8
    L10:
        Settings.System.putStringForUser(this.mContext.getContentResolver(), setting, sb.toString(), -2);
        return;
    }

    private float[] getFloatArrayForSetting(String setting) {
        String value = Settings.System.getStringForUser(this.mContext.getContentResolver(), setting, -2);
        if (value != null) goto L5;
        return null;
    L5:
        String[] items = value.split(",");
        if (items != null) goto L8;
    L19:
        return null;
    L8:
        if (items.length == 0) goto L19;
        float[] values = new float[items.length];
        int i = 0;
    L12:
        if (i >= items.length) goto L18;
        values[i] = Float.parseFloat(items[i]);     // Catch: NumberFormatException -> L15
        i = i + 1;
    L16:
        return null;
    L18:
        return values;
    }

    private void setFloatArrayForSetting(String setting, float[] array) {
        if (array != null) goto L4;
        return;
    L4:
        if (array.length == 0) goto L14;
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        int i = 1;
    L8:
        if (i >= array.length) goto L10;
        sb.append(",");
        sb.append(array[i]);
        i = i + 1;
        goto L8
    L10:
        Settings.System.putStringForUser(this.mContext.getContentResolver(), setting, sb.toString(), -2);
        return;
    }

    private static int clampAbsoluteBrightness(int value) {
        return clamp(value, 0, 255);
    }

    private static int clamp(int value, int min, int max) {
        if (value > min) goto L4;
        return min;
    L4:
        if (value < max) goto L6;
        return max;
    L6:
        return value;
    }

    private static float clampAbsoluteBrightnessFloat(float value) {
        return clampFloat(Math.abs(value), 0.0f, 1.0f);
    }

    private static float clampFloat(float value, float min, float max) {
        if (Float.isNaN(value) == false) goto L7;
        return Float.NaN;
    L7:
        if (Math.abs(value - min) >= EPSILON) goto L10;
        return min;
    L10:
        if (Math.abs(max - value) >= EPSILON) goto L13;
        return max;
    L13:
        if (min >= Math.abs(value)) goto L19;
        if (max <= Math.abs(value)) goto L19;
        return Math.abs(value);
    L19:
        if (Math.abs(value) <= max) goto L21;
        return max;
    L21:
        return 0.0f;
    }

    private static float normalizeAbsoluteBrightness(float value) {
        return clampAbsoluteBrightnessFloat(value);
    }

    private static Spline createAutoBrightnessSpline(int[] lux, float[] brightness) {
        if (lux.length >= 2) goto L5;
    L16:
        return null;
    L5:
        if (lux.length != (brightness.length - 1)) goto L16;
        int n = brightness.length;     // Catch: IllegalArgumentException -> L10
        float[] x = new float[n];     // Catch: IllegalArgumentException -> L10
        float[] y = new float[n];     // Catch: IllegalArgumentException -> L10
        y[0] = normalizeAbsoluteBrightness(brightness[0]);     // Catch: IllegalArgumentException -> L10
        int i = 1;
    L8:
        if (i >= n) goto L12;
        x[i] = lux[i - 1];     // Catch: IllegalArgumentException -> L10
        y[i] = normalizeAbsoluteBrightness(brightness[i]);     // Catch: IllegalArgumentException -> L10
        i = i + 1;     // Catch: IllegalArgumentException -> L10
        goto L8
    L12:
        Spline spline = Spline.createMonotoneCubicSpline(x, y);     // Catch: IllegalArgumentException -> L10
        return spline;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Failed to create spline due to " + ex);
        return null;
    }

    private void registerSensorListener() {
        log("registerSensorListener old:" + this.mIsRegistered);
        if (this.mIsRegistered == false) goto L6;
        return;
    L6:
        if (getOrientation() == 2) goto L8;
    L10:
        this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, 0, this.mHandler);
        this.mIsRegistered = true;
        registerActivityObserver();
        return;
    L8:
        if (DBG == false) goto L10;
        log("start ProximitySensor...");
        goto L10
    }

    private void unregisterSensorListener() {
        log("unregisterSensorListener() old:" + this.mIsRegistered);
        if (this.mIsRegistered == true) goto L5;
        return;
    L5:
        SensorHandleTask.m7382$$Nest$mclearData(this.mTask);
        if (getOrientation() == 2) goto L8;
    L10:
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        this.mIsRegistered = false;
        unregisterActivityObserver();
        return;
    L8:
        if (DBG == false) goto L10;
        log("stop ProximitySensor...");
        goto L10
    }

    private void startAutoBrightness() {
        this.mHandler.sendEmptyMessage(0);
    }

    private void stopAutoBrightness() {
        this.mHandler.sendEmptyMessage(1);
    }

    private int getOrientation() {
        this.mOrientation = this.mContext.getResources().getConfiguration().orientation;
        return this.mOrientation;
    }

    private void handleLuxChange(float lux) {
        if (this.mHandler.hasMessages(2) == false) goto L5;
        return;
    L5:
        StateDetail.m7388$$Nest$mupdateStateWithLux(this.mStateDetail, SystemClock.uptimeMillis(), lux);
        if (StateDetail.m7385$$Nest$fgetmState(this.mStateDetail) != 3) goto L8;
        return;
    L8:
        if (StateDetail.m7385$$Nest$fgetmState(this.mStateDetail) == 1) goto L43;
        int level = getBrightnessIndexFromLux(lux);
        if (level >= 0) goto L13;
    L39:
        Slog.e(TAG, "out of mValues array index." + Log.getStackTraceString(new Throwable()));
        resetAutoBrightnessMap();
        return;
    L13:
        if (level >= this.mValues.length) goto L39;
        float brightness = this.mValues[level];
        float fromBrightness = getCurrentBrightness();
        this.mLastReqBrightLevel = getBrightnessIndexFromValues(fromBrightness);
        if (DBG == false) goto L18;
        log("handleLuxChange  getBrightnessFromLux:" + brightness + ", mLastReqBrightness:" + this.mLastReqBrightness);
    L18:
        float brightnessChange = Math.abs(this.mLastReqBrightness - brightness);
        if (brightnessChange >= EPSILON) goto L22;
        return;
    L22:
        if (this.mFirstStart == false) goto L24;
        int trendChange = 9;
        this.mFirstStart = false;
    L30:
        float rate = this.mChangingMechanism[trendChange][2];
        if (rate == 0.0f) goto L33;
        log("handleLuxChange  last_level:" + this.mLastReqBrightLevel + ",to_level:" + level + ",trendChange:" + trendChange + ",brightnessChange:" + brightnessChange + ",rate:" + rate + ",Avg lux:" + lux + ",mLastReqBrightness:" + this.mLastReqBrightness + ",From brightness: " + fromBrightness + ",Target brightness:" + brightness);
        setBrightnessGradient((int) (1000.0f * rate), fromBrightness, brightness);
    L33:
        this.mLastReqBrightness = brightness;
        adjustLuxExtend(level);
        if (this.mDebugView == null) goto L42;
        this.mDebugView.updateReqestedBrightnessData(brightness);
        this.mDebugView.updateLuxBrightnessData(this.mLuxes, this.mValues);
        return;
    L42:
        return;
    L24:
        int trendChange2 = (level - this.mLastReqBrightLevel) + 9;
        if (trendChange2 >= 0) goto L27;
    L37:
        Slog.e(TAG, "out of mValues array index." + Log.getStackTraceString(new Throwable()));
        resetAutoBrightnessMap();
        return;
    L27:
        if (trendChange2 >= this.mChangingMechanism.length) goto L37;
        trendChange = trendChange2;
        goto L30
    }

    private int getBrightnessIndexFromLux(float lux) {
        int index = 0;
        int i = 0;
    L4:
        if (i >= this.mLuxes.length) goto L12;
        if (lux < this.mLuxes[i]) goto L7;
        index = this.mLuxes.length;
        i = i + 1;
        goto L4
    L7:
        int index2 = i;
        return index2;
    L12:
        return index;
    }

    private int getBrightnessIndexFromValues(float brightness) {
        float brightnessAbs = Math.abs(brightness);
        int i = 0;
    L4:
        if (i >= this.mValues.length) goto L12;
        float max = Math.max(brightnessAbs, this.mValues[i]);
        if (Math.abs(max - this.mValues[i]) < EPSILON) goto L7;
        i = i + 1;
        goto L4
    L7:
        int index = i;
        return index;
    L12:
        return 0;
    }

    private void autoAdjustBrightnessFirstly(float lux) {
        int level = getBrightnessIndexFromLux(lux);
        float brightness = this.mValues[level];
        this.mLastReqBrightness = brightness;
        adjustLuxExtend(level);
        log("The lux value is : " + lux + ", brightness is : " + brightness);
        Message msg = this.mHandler.obtainMessage(9, Float.floatToIntBits(brightness), 0);
        this.mHandler.sendMessage(msg);
    }

    private void requestAutoBrightness(float autoBrightness, int rate) {
        log("requestAutoBrightness(autoBrightness): " + autoBrightness);
        this.mCallBack.requestAutoBrightness(autoBrightness, rate);
    }

    private void setBrightnessGradient(int durationMillions, float fromBrightness, float toBrightness) {
        if (DBG == false) goto L6;
        log("setBrightnessGradient(autoBrightness): " + durationMillions + "," + fromBrightness + "," + toBrightness);
    L6:
        if (this.mIsScreenOn == false) goto L9;
        this.mCallBack.setBrightnessGradient(durationMillions, fromBrightness, toBrightness);
        return;
    }

    private void setBrightnessGradientEnd() {
        this.mCallBack.setBrightnessGradientEnd();
    }

    private boolean adjustArrays(float lux, float brightness) {
        log("adjustArrays lux: " + lux + ",brightness: " + brightness);
        int index = getBrightnessIndexFromLux(lux);
        if (index >= 0) goto L5;
    L6:
        Slog.e(TAG, "out of mValues array index.");
        resetAutoBrightnessMap();
    L7:
        float r5 = Math.abs(brightness - this.mValues[index]);
        float r6 = EPSILON;
        boolean isAdjustOverflow = false;
        if (r5 >= EPSILON) goto L12;
        log("adjustArrays brightness equal mValues " + index);
        return false;
    L12:
        if (Math.abs(brightness - this.mOriginValues[index]) >= EPSILON) goto L15;
        this.mValues = Arrays.copyOf(this.mOriginValues, this.mOriginValues.length);
        return false;
    L15:
        int r8 = 1;
        if (brightness >= this.lows[index]) goto L18;
    L19:
        isAdjustOverflow = true;
    L20:
        Slog.d(TAG, "adjustArrays: b=" + brightness + ", l=" + this.lows[index] + ", h=" + this.highs[index]);
        float max2 = Math.max(brightness, this.mOriginValues[index]);
        boolean increase_orig_based = false;
        if (Math.abs(max2 - this.mOriginValues[index]) < EPSILON) goto L24;
        increase_orig_based = true;
    L24:
        if (increase_orig_based == false) goto L37;
        float f = brightness - this.mOriginValues[index];
        float ajust_ratio = f / (this.highs[index] - this.mOriginValues[index]);
        if (ajust_ratio >= 1.0f) goto L35;
        this.mValues[index] = brightness;
        int i = 0;
    L29:
        if (i >= this.mValues.length) goto L34;
        if (i == index) goto L33;
        this.mValues[i] = ((this.highs[i] - this.mOriginValues[i]) * ajust_ratio) + this.mOriginValues[i];
    L33:
        i = i + 1;
        r6 = r6;
        goto L29
    L34:
        float r16 = r6;
    L53:
        if (ajust_ratio < 1.0f) goto L75;
        boolean isIncrease = false;
        float max3 = Math.max(brightness, this.mValues[index]);
        if (Math.abs(max3 - this.mValues[index]) < r16) goto L58;
        isIncrease = true;
    L58:
        if (isIncrease == false) goto L66;
        float[] r12 = this.mValues;
        float changeValue = this.highs[index];
        r12[index] = changeValue;
    L60:
        index = index + 1;
        if (index >= this.mValues.length) goto L73;
        if (this.mValues[index] >= changeValue) goto L60;
        this.mValues[index] = changeValue;
    L73:
        if (DBG == false) goto L75;
        log("adjustArrays print mValues");
        goto L75
    L66:
        float[] r13 = this.mValues;
        float changeValue2 = this.lows[index];
        r13[index] = changeValue2;
        int index2 = index - 1;
    L67:
        if (index2 < 0) goto L73;
        if (this.mValues[index2] <= changeValue2) goto L71;
        this.mValues[index2] = changeValue2;
    L71:
        index2 = index2 - 1;
    L75:
        int i2 = 0;
    L77:
        if (i2 >= (this.mValues.length - 1)) goto L82;
        if (this.mValues[i2] > this.mValues[i2 + 1]) goto L80;
        i2 = i2 + 1;
        goto L77
    L80:
        Slog.e(TAG, "adjustArrays error,reset array.");
        resetAutoBrightnessMap();
    L82:
        return isAdjustOverflow;
    L35:
        r16 = 0.001f;
        goto L53
    L37:
        r16 = 0.001f;
        float f2 = this.mOriginValues[index] - brightness;
        ajust_ratio = f2 / (this.mOriginValues[index] - this.lows[index]);
        if (ajust_ratio >= 1.0f) goto L53;
        this.mValues[index] = brightness;
        int i3 = 0;
    L41:
        if (i3 >= (this.mValues.length - r8)) goto L53;
        if (i3 != index) goto L44;
        int r17 = r8;
    L49:
        i3 = i3 + 1;
        r8 = r17;
        goto L41
    L44:
        r17 = r8;
        this.mValues[i3] = this.mOriginValues[i3] - ((this.mOriginValues[i3] - this.lows[i3]) * ajust_ratio);
        if (i3 <= index) goto L49;
        if (this.mValues[i3] >= this.lows[i3]) goto L49;
        this.mValues[i3] = this.lows[i3];
        goto L49
    L18:
        if (brightness <= this.highs[index]) goto L20;
    L5:
        if (index < this.mValues.length) goto L7;
        goto L6
    }

    public void requestAdjust(float newBrightness) {
        float bright = getCurrentBrightness();
        if (Math.abs(newBrightness - bright) >= EPSILON) goto L5;
        return;
    L5:
        this.mFormerBright = bright;
        this.mHandler.removeMessages(2);
        Message msg = this.mHandler.obtainMessage(2, Float.floatToIntBits(newBrightness), 0);
        this.mHandler.sendMessage(msg);
    }

    private void resetAutoBrightnessMap() {
        Slog.d(TAG, "Reset auto brightness map due to current wrong map:");
        dumpArraysIntoLogcat();
        this.mScreenAutoBrightnessSpline = createAutoBrightnessSpline(this.mOriginLuxs, this.mOriginValues);
        this.mLuxes = Arrays.copyOf(this.mOriginLuxs, this.mOriginLuxs.length);
        this.mValues = Arrays.copyOf(this.mOriginValues, this.mOriginValues.length);
        setIntArrayForSetting("auto_brightness_lux", this.mOriginLuxs);
        setFloatArrayForSetting("auto_brightness_backlight", this.mOriginValues);
    }

    private void adjustLuxExtend(int level) {
        if (this.mExtendLuxs[level].length != this.mLuxes.length) goto L5;
        this.mLuxes = Arrays.copyOf(this.mExtendLuxs[level], this.mExtendLuxs[level].length);
    L5:
        this.mLastReqBrightLevel = level;
    }

    private void handleAdjust(float lux, float brightness) {
        boolean isAdjustOverflow = adjustArrays(lux, brightness);
        StateDetail.m7387$$Nest$mupdateStateWhenAdjust(this.mStateDetail, SystemClock.uptimeMillis(), lux, isAdjustOverflow);
        this.mScreenAutoBrightnessSpline = createAutoBrightnessSpline(this.mLuxes, this.mValues);
        float[] brightValues = Arrays.copyOf(this.mValues, this.mValues.length);
        calibrationBrightnessArray(brightValues);
        setIntArrayForSetting("auto_brightness_lux", this.mLuxes);
        setFloatArrayForSetting("auto_brightness_backlight", brightValues);
    }

    private boolean isWifiOn() {
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        if (wifiManager == null) goto L10;
        WifiInfo w = wifiManager.getConnectionInfo();
        if (w != null) goto L7;
        return false;
    L7:
        if (w.getNetworkId() == (-1)) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private void handleBrightnessModeChanged() {
        if (isAutoBrightnessBySetting() == false) goto L5;
        this.mFirstStart = true;
        startAutoBrightness();
        return;
    L5:
        stopAutoBrightness();
    }

    private boolean isAutoBrightnessBySetting() {
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness_mode", 0, -2) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void bootCompleted() {
        this.mHandler.sendEmptyMessage(3);
    }

    private static void log(String msg) {
        Slog.d(TAG, msg);
    }

    private void dumpArraysIntoLogcat() {
        StringBuilder sbLuxes = new StringBuilder();
        sbLuxes.append("[  ");
        int i = 0;
    L4:
        if (i >= this.mLuxes.length) goto L6;
        sbLuxes.append(this.mLuxes[i]);
        sbLuxes.append(", ");
        i = i + 1;
        goto L4
    L6:
        sbLuxes.append("].");
        StringBuilder sbValues = new StringBuilder();
        sbValues.append("[");
        int i2 = 0;
    L8:
        if (i2 >= this.mValues.length) goto L10;
        sbValues.append(this.mValues[i2]);
        sbValues.append(", ");
        i2 = i2 + 1;
        goto L8
    L10:
        sbValues.append("].");
        Slog.e(TAG, "!!!Create spline failed!!! mLuxes=" + sbLuxes + "mValues=" + sbValues);
    }

    public void dump(PrintWriter pw) {
        pw.println();
        pw.println("AutoBrightnessController: ");
        pw.println("map lux to brightness is as below ");
        pw.println("    0 -> " + this.mValues[0]);
        int i = 0;
    L4:
        if (i >= this.mLuxes.length) goto L7;
        pw.println("    " + this.mLuxes[i] + " -> " + this.mValues[i + 1]);
        i = i + 1;
        goto L4
    L7:
        if (this.mScreenAutoBrightnessSpline == null) goto L9;
        float mLatestLux = this.mLuxesStabilizer.getStabilizedLux();
        int brightness = (int) (this.mScreenAutoBrightnessSpline.interpolate(mLatestLux) * 255.0f);
        pw.println("current state : " + mLatestLux + " -> " + brightness);
    L9:
        pw.println("    mStateDetail=" + this.mStateDetail);
        if (this.mIsAutoBriEnabled == true) goto L12;
    L14:
        this.mHandler.sendEmptyMessage(7);
        return;
    L12:
        if (SystemProperties.getBoolean(DEBUG_PROPERTY, false) == false) goto L14;
        this.mHandler.sendEmptyMessage(6);
    }

    private void initWorkThread() {
        if (this.mAutoBCWorkThread != null) goto L6;
        this.mAutoBCWorkThread = new HandlerThread("AutoBrightnessController work thread");
        this.mAutoBCWorkThread.start();
        final Looper r1 = this.mAutoBCWorkThread.getLooper();
        this.mSubWorkHander = new AnonymousClass4(this, r1);
        return;
    }

    private void registerActivityObserver() {
        ActivityManager.getSmtEx().registerActivityObserver(this.mActivityObserver);
    }

    private void unregisterActivityObserver() {
        ActivityManager.getSmtEx().unregisterActivityObserver(this.mActivityObserver);
    }

    float getCurrentBrightness() {
        int brightness = Settings.System.getIntForUser(this.mContext.getContentResolver(), "screen_brightness", this.minimumBacklightInt, -2);
        float brightnessFloat = brightness / 255.0f;
        return brightnessFloat;
    }
}
