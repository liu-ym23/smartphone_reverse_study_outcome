package com.android.server.display;

import android.content.Context;
import android.database.ContentObserver;
import android.hardware.display.BrightnessInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.util.MathUtils;
import android.util.Slog;
import android.util.TimeUtils;
import android.view.SurfaceControlHdrLayerInfoListener;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.display.config.HighBrightnessModeData;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class HighBrightnessModeController {
    private static final boolean DEBUG = false;
    private static final float DEFAULT_MAX_DESIRED_HDR_SDR_RATIO = 1.0f;
    static final float HBM_TRANSITION_POINT_INVALID = Float.POSITIVE_INFINITY;
    private static final String TAG = "HighBrightnessModeController";
    private float mAmbientLux;
    protected float mBrightness;
    private final float mBrightnessMax;
    private final float mBrightnessMin;
    private final DisplayManagerService.Clock mClock;
    private final Context mContext;
    private int mDisplayStatsId;
    private IExtHighBrightnessModeController mExt;
    protected boolean mForceHbmChangeCallback;
    private final Handler mHandler;
    private final Runnable mHbmChangeCallback;
    protected HighBrightnessModeData mHbmData;
    private int mHbmMode;
    private int mHbmStatsState;
    private boolean mHdrBoostDisabled;
    protected HdrBrightnessDeviceConfig mHdrBrightnessCfg;
    private HdrListener mHdrListener;
    protected int mHeight;
    protected HighBrightnessModeMetadata mHighBrightnessModeMetadata;
    private final Injector mInjector;
    protected boolean mIsAutoBrightnessEnabled;
    private boolean mIsAutoBrightnessOffByState;
    protected boolean mIsBlockedByLowPowerMode;
    boolean mIsHdrLayerPresent;
    protected boolean mIsInAllowedAmbientRange;
    protected boolean mIsTimeAvailable;
    protected float mMaxDesiredHdrSdrRatio;
    private final Runnable mRecalcRunnable;
    protected IBinder mRegisteredDisplayToken;
    private final SettingsObserver mSettingsObserver;
    protected int mThrottlingReason;
    protected float mUnthrottledBrightness;
    protected int mWidth;

    public interface HdrBrightnessDeviceConfig {
        float getHdrBrightnessFromSdr(float r1, float r2);
    }

    class HdrListener extends SurfaceControlHdrLayerInfoListener {
        final /* synthetic */ HighBrightnessModeController this$0;

        public static /* synthetic */ void $r8$lambda$xpwRv1TYX2mZIjLkH6jXYgHSjsk(HdrListener r0, IBinder r1, int r2, int r3, int r4, int r5, float r6) {
            r0.lambda$onHdrInfoChanged$0(r1, r2, r3, r4, r5, r6);
        }

        HdrListener(HighBrightnessModeController this$0) {
            this.this$0 = this$0;
        }

        public void onHdrInfoChanged(final IBinder displayToken, final int numberOfHdrLayers, final int maxW, final int maxH, final int flags, final float maxDesiredHdrSdrRatio) {
            HighBrightnessModeController.m3818$$Nest$fgetmHandler(this.this$0).post(new HighBrightnessModeController$HdrListener$$ExternalSyntheticLambda0(this, displayToken, numberOfHdrLayers, maxW, maxH, flags, maxDesiredHdrSdrRatio));
        }

        private /* synthetic */ void lambda$onHdrInfoChanged$0(IBinder displayToken, int numberOfHdrLayers, int maxW, int maxH, int flags, float maxDesiredHdrSdrRatio) {
            Trace.traceBegin(131072, "HBMController#onHdrInfoChanged");
            HighBrightnessModeController.m3817$$Nest$fgetmExt(this.this$0).onHdrInfoChanged(displayToken, numberOfHdrLayers, maxW, maxH, flags, maxDesiredHdrSdrRatio);
            HighBrightnessModeController r0 = this.this$0;
            if (numberOfHdrLayers > 0) goto L5;
        L7:
            boolean r4 = false;
        L8:
            r0.mIsHdrLayerPresent = r4;
            if (this.this$0.mIsHdrLayerPresent == true) goto L11;
        L13:
            float candidateDesiredHdrSdrRatio = 1.0f;
        L15:
            if (candidateDesiredHdrSdrRatio >= 1.0f) goto L18;
            Slog.w(HighBrightnessModeController.TAG, "Ignoring invalid desired HDR/SDR Ratio: " + candidateDesiredHdrSdrRatio);
            candidateDesiredHdrSdrRatio = 1.0f;
        L18:
            if (BrightnessSynchronizer.floatEquals(this.this$0.mMaxDesiredHdrSdrRatio, candidateDesiredHdrSdrRatio) == true) goto L20;
            this.this$0.mForceHbmChangeCallback = true;
            this.this$0.mMaxDesiredHdrSdrRatio = candidateDesiredHdrSdrRatio;
        L20:
            this.this$0.onBrightnessChanged(this.this$0.mBrightness, this.this$0.mUnthrottledBrightness, this.this$0.mThrottlingReason);
            Trace.traceEnd(131072);
            return;
        L11:
            if (this.this$0.mHdrBrightnessCfg == null) goto L13;
            candidateDesiredHdrSdrRatio = maxDesiredHdrSdrRatio;
            goto L15
        L5:
            if ((maxW * maxH) < ((this.this$0.mWidth * this.this$0.mHeight) * this.this$0.mHbmData.minimumHdrPercentOfScreen)) goto L7;
            r4 = true;
            goto L8
        }
    }

    public static class Injector {
        public Injector() {
        }

        public DisplayManagerService.Clock getClock() {
            return new HighBrightnessModeController$Injector$$ExternalSyntheticLambda0();
        }

        public void reportHbmStateChange(int display, int state, int reason) {
            FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED, display, state, reason);
        }
    }

    private final class SettingsObserver extends ContentObserver {
        private final Uri mLowPowerModeSetting;
        private boolean mStarted;
        final /* synthetic */ HighBrightnessModeController this$0;

        SettingsObserver(HighBrightnessModeController r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
            this.mLowPowerModeSetting = Settings.Global.getUriFor("low_power");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            updateLowPower();
        }

        void startObserving() {
            if (this.mStarted == true) goto L6;
            HighBrightnessModeController.m3816$$Nest$fgetmContext(this.this$0).getContentResolver().registerContentObserver(this.mLowPowerModeSetting, false, this, -1);
            this.mStarted = true;
            updateLowPower();
            return;
        }

        void stopObserving() {
            this.this$0.mIsBlockedByLowPowerMode = false;
            if (this.mStarted == false) goto L6;
            HighBrightnessModeController.m3816$$Nest$fgetmContext(this.this$0).getContentResolver().unregisterContentObserver(this);
            this.mStarted = false;
            return;
        }

        private void updateLowPower() {
            boolean isLowPowerMode = isLowPowerMode();
            if (isLowPowerMode != this.this$0.mIsBlockedByLowPowerMode) goto L6;
            return;
        L6:
            if (HighBrightnessModeController.m3820$$Nest$sfgetDEBUG() == false) goto L8;
            Slog.d(HighBrightnessModeController.TAG, "Settings.Global.LOW_POWER_MODE enabled: " + isLowPowerMode);
        L8:
            this.this$0.mIsBlockedByLowPowerMode = isLowPowerMode;
            HighBrightnessModeController.m3819$$Nest$mupdateHbmMode(this.this$0);
        }

        private boolean isLowPowerMode() {
            if (Settings.Global.getInt(HighBrightnessModeController.m3816$$Nest$fgetmContext(this.this$0).getContentResolver(), "low_power", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static /* synthetic */ void $r8$lambda$Ch4tw554EqFz0NWU9cX3C2f2K7s(HighBrightnessModeController r0) {
        r0.recalculateTimeAllowance();
    }

    public static /* synthetic */ void $r8$lambda$P9bufWROwnLfROHxW5qwb2tgs3M(HighBrightnessModeController r0, PrintWriter r1) {
        r0.lambda$dump$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3816$$Nest$fgetmContext(HighBrightnessModeController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtHighBrightnessModeController m3817$$Nest$fgetmExt(HighBrightnessModeController r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3818$$Nest$fgetmHandler(HighBrightnessModeController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateHbmMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3819$$Nest$mupdateHbmMode(HighBrightnessModeController r0) {
        r0.updateHbmMode();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3820$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    HighBrightnessModeController(Handler handler, int width, int height, IBinder displayToken, String displayUniqueId, float brightnessMin, float brightnessMax, HighBrightnessModeData hbmData, HdrBrightnessDeviceConfig hdrBrightnessCfg, Runnable hbmChangeCallback, HighBrightnessModeMetadata hbmMetadata, Context context) {
        this(new Injector(), handler, width, height, displayToken, displayUniqueId, brightnessMin, brightnessMax, hbmData, hdrBrightnessCfg, hbmChangeCallback, hbmMetadata, context);
    }

    HighBrightnessModeController(Injector injector, Handler handler, int width, int height, IBinder displayToken, String displayUniqueId, float brightnessMin, float brightnessMax, HighBrightnessModeData hbmData, HdrBrightnessDeviceConfig hdrBrightnessCfg, Runnable hbmChangeCallback, HighBrightnessModeMetadata hbmMetadata, Context context) {
        this.mIsInAllowedAmbientRange = false;
        this.mIsTimeAvailable = false;
        this.mIsAutoBrightnessEnabled = false;
        this.mIsAutoBrightnessOffByState = false;
        this.mThrottlingReason = 0;
        this.mHbmMode = 0;
        this.mIsHdrLayerPresent = false;
        this.mMaxDesiredHdrSdrRatio = 1.0f;
        this.mForceHbmChangeCallback = false;
        this.mIsBlockedByLowPowerMode = false;
        this.mHbmStatsState = 1;
        this.mHdrBoostDisabled = false;
        this.mExt = (IExtHighBrightnessModeController) ExtImplFactory.getImpl(IExtHighBrightnessModeController.class, new Object[]{this});
        this.mInjector = injector;
        this.mContext = context;
        this.mClock = injector.getClock();
        this.mHandler = handler;
        this.mBrightness = brightnessMin;
        this.mBrightnessMin = brightnessMin;
        this.mBrightnessMax = brightnessMax;
        this.mHbmChangeCallback = hbmChangeCallback;
        this.mHighBrightnessModeMetadata = hbmMetadata;
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mRecalcRunnable = new HighBrightnessModeController$$ExternalSyntheticLambda1(this);
        this.mHdrListener = new HdrListener(this);
        resetHbmData(width, height, displayToken, displayUniqueId, hbmData, hdrBrightnessCfg);
    }

    void setAutoBrightnessEnabled(int state) {
        boolean r1 = true;
        if (state != 1) goto L5;
        boolean isEnabled = true;
    L7:
        if (state == 3) goto L10;
        r1 = false;
    L10:
        this.mIsAutoBrightnessOffByState = r1;
        if (deviceSupportsHbm() == true) goto L13;
        return;
    L13:
        if (isEnabled != this.mIsAutoBrightnessEnabled) goto L16;
        return;
    L16:
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "setAutoBrightnessEnabled( " + isEnabled + " )");
    L18:
        this.mExt.setAutoBrightnessEnabled(state);
        this.mIsAutoBrightnessEnabled = isEnabled;
        this.mIsInAllowedAmbientRange = false;
        recalculateTimeAllowance();
        return;
    L5:
        isEnabled = false;
        goto L7
    }

    float getCurrentBrightnessMin() {
        return this.mBrightnessMin;
    }

    float getCurrentBrightnessMax() {
        if (deviceSupportsHbm() == false) goto L10;
        if (isHbmCurrentlyAllowed() == true) goto L10;
        return this.mHbmData.transitionPoint;
    L10:
        return this.mBrightnessMax;
    }

    float getNormalBrightnessMax() {
        if (deviceSupportsHbm() == false) goto L6;
        return this.mHbmData.transitionPoint;
    L6:
        return this.mBrightnessMax;
    }

    float getHdrBrightnessValue() {
        if (this.mHdrBrightnessCfg == null) goto L8;
        float hdrBrightness = this.mHdrBrightnessCfg.getHdrBrightnessFromSdr(this.mBrightness, this.mMaxDesiredHdrSdrRatio);
        if (hdrBrightness == (-1.0f)) goto L8;
        return hdrBrightness;
    L8:
        return MathUtils.map(getCurrentBrightnessMin(), getCurrentBrightnessMax(), this.mBrightnessMin, this.mBrightnessMax, this.mBrightness);
    }

    void onAmbientLuxChange(float ambientLux) {
        this.mAmbientLux = ambientLux;
        if (deviceSupportsHbm() == true) goto L5;
        return;
    L5:
        if (this.mIsAutoBrightnessEnabled == true) goto L8;
        return;
    L8:
        if (ambientLux < this.mHbmData.minimumLux) goto L10;
        boolean isHighLux = true;
    L12:
        if (isHighLux == this.mIsInAllowedAmbientRange) goto L16;
        this.mIsInAllowedAmbientRange = isHighLux;
        recalculateTimeAllowance();
        return;
    L16:
        return;
    L10:
        isHighLux = false;
        goto L12
    }

    void onBrightnessChanged(float brightness, float unthrottledBrightness, int throttlingReason) {
        if (deviceSupportsHbm() == true) goto L5;
        return;
    L5:
        this.mBrightness = brightness;
        this.mUnthrottledBrightness = unthrottledBrightness;
        this.mThrottlingReason = throttlingReason;
        long runningStartTime = this.mHighBrightnessModeMetadata.getRunningStartTimeMillis();
        boolean shouldHbmDrainAvailableTime = false;
        if (runningStartTime == (-1)) goto L8;
        boolean wasHbmDrainingAvailableTime = true;
    L10:
        if (this.mBrightness > this.mHbmData.transitionPoint) goto L12;
    L14:
        if (wasHbmDrainingAvailableTime == shouldHbmDrainAvailableTime) goto L22;
        long currentTime = this.mClock.uptimeMillis();
        if (shouldHbmDrainAvailableTime == false) goto L18;
        this.mHighBrightnessModeMetadata.setRunningStartTimeMillis(currentTime);
        goto L22
    L18:
        HbmEvent hbmEvent = new HbmEvent(runningStartTime, currentTime);
        this.mHighBrightnessModeMetadata.addHbmEvent(hbmEvent);
        this.mHighBrightnessModeMetadata.setRunningStartTimeMillis(-1);
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "New HBM event: " + this.mHighBrightnessModeMetadata.getHbmEventQueue().peekFirst());
    L21:
        this.mExt.onBrightnessChanged(brightness, unthrottledBrightness, throttlingReason);
    L22:
        recalculateTimeAllowance();
        return;
    L12:
        if (this.mIsHdrLayerPresent == true) goto L14;
        shouldHbmDrainAvailableTime = true;
        goto L14
    L8:
        wasHbmDrainingAvailableTime = false;
        goto L10
    }

    int getHighBrightnessMode() {
        return this.mHbmMode;
    }

    float getTransitionPoint() {
        if (deviceSupportsHbm() == true) goto L5;
        return HBM_TRANSITION_POINT_INVALID;
    L5:
        return this.mHbmData.transitionPoint;
    }

    void stop() {
        registerHdrListener(null);
        this.mSettingsObserver.stopObserving();
    }

    void setHighBrightnessModeMetadata(HighBrightnessModeMetadata hbmInfo) {
        this.mHighBrightnessModeMetadata = hbmInfo;
    }

    void resetHbmData(int width, int height, IBinder displayToken, String displayUniqueId, HighBrightnessModeData hbmData, HdrBrightnessDeviceConfig hdrBrightnessCfg) {
        this.mWidth = width;
        this.mHeight = height;
        this.mHbmData = hbmData;
        this.mHdrBrightnessCfg = hdrBrightnessCfg;
        this.mDisplayStatsId = displayUniqueId.hashCode();
        unregisterHdrListener();
        this.mSettingsObserver.stopObserving();
        if (deviceSupportsHbm() == false) goto L8;
        registerHdrListener(displayToken);
        recalculateTimeAllowance();
        if (this.mHbmData.allowInLowPowerMode == true) goto L9;
        this.mIsBlockedByLowPowerMode = false;
        this.mSettingsObserver.startObserving();
        return;
    L9:
        return;
    }

    private /* synthetic */ void lambda$dump$0(PrintWriter pw) {
        dumpLocal(pw);
    }

    void dump(final PrintWriter pw) {
        this.mHandler.runWithScissors(new HighBrightnessModeController$$ExternalSyntheticLambda0(this, pw), 1000);
    }

    HdrListener getHdrListener() {
        return this.mHdrListener;
    }

    private void dumpLocal(PrintWriter pw) {
        pw.println("HighBrightnessModeController:");
        pw.println("  mBrightness=" + this.mBrightness);
        pw.println("  mUnthrottledBrightness=" + this.mUnthrottledBrightness);
        pw.println("  mThrottlingReason=" + BrightnessInfo.briMaxReasonToString(this.mThrottlingReason));
        pw.println("  mCurrentMin=" + getCurrentBrightnessMin());
        pw.println("  mCurrentMax=" + getCurrentBrightnessMax());
        StringBuilder r0 = new StringBuilder();
        r0.append("  mHbmMode=");
        r0.append(BrightnessInfo.hbmToString(this.mHbmMode));
        String r3 = "";
        if (this.mHbmMode != 2) goto L5;
        String r1 = "(" + getHdrBrightnessValue() + ")";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("  mHbmStatsState=" + hbmStatsStateToString(this.mHbmStatsState));
        pw.println("  mHbmData=" + this.mHbmData);
        StringBuilder r2 = new StringBuilder();
        r2.append("  mAmbientLux=");
        r2.append(this.mAmbientLux);
        if (this.mIsAutoBrightnessEnabled == true) goto L10;
        r3 = " (old/invalid)";
    L10:
        r2.append(r3);
        pw.println(r2.toString());
        pw.println("  mIsInAllowedAmbientRange=" + this.mIsInAllowedAmbientRange);
        pw.println("  mIsAutoBrightnessEnabled=" + this.mIsAutoBrightnessEnabled);
        pw.println("  mIsAutoBrightnessOffByState=" + this.mIsAutoBrightnessOffByState);
        pw.println("  mIsHdrLayerPresent=" + this.mIsHdrLayerPresent);
        pw.println("  mBrightnessMin=" + this.mBrightnessMin);
        pw.println("  mBrightnessMax=" + this.mBrightnessMax);
        pw.println("  remainingTime=" + calculateRemainingTime(this.mClock.uptimeMillis()));
        pw.println("  mIsTimeAvailable= " + this.mIsTimeAvailable);
        pw.println("  mIsBlockedByLowPowerMode=" + this.mIsBlockedByLowPowerMode);
        pw.println("  width*height=" + this.mWidth + SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER + this.mHeight);
        StringBuilder r4 = new StringBuilder();
        r4.append("  mHdrBoostDisabled=");
        r4.append(this.mHdrBoostDisabled);
        pw.println(r4.toString());
        if (this.mHighBrightnessModeMetadata == null) goto L23;
        pw.println("  mRunningStartTimeMillis=" + TimeUtils.formatUptime(this.mHighBrightnessModeMetadata.getRunningStartTimeMillis()));
        pw.println("  mEvents=");
        long currentTime = this.mClock.uptimeMillis();
        long lastStartTime = currentTime;
        long runningStartTimeMillis = this.mHighBrightnessModeMetadata.getRunningStartTimeMillis();
        if (runningStartTimeMillis == (-1)) goto L15;
        lastStartTime = dumpHbmEvent(pw, new HbmEvent(runningStartTimeMillis, currentTime));
    L15:
        Iterator<HbmEvent> r6 = this.mHighBrightnessModeMetadata.getHbmEventQueue().iterator();
    L17:
        if (r6.hasNext() == false) goto L28;
        HbmEvent event = r6.next();
        if (lastStartTime <= event.getEndTimeMillis()) goto L21;
        pw.println("    event: [normal brightness]: " + TimeUtils.formatDuration(lastStartTime - event.getEndTimeMillis()));
    L21:
        lastStartTime = dumpHbmEvent(pw, event);
        goto L17
    L28:
        return;
    L23:
        pw.println("  mHighBrightnessModeMetadata=null");
        return;
    L5:
        r1 = "";
        goto L6
    }

    private long dumpHbmEvent(PrintWriter pw, HbmEvent event) {
        long duration = event.getEndTimeMillis() - event.getStartTimeMillis();
        pw.println("    event: [" + TimeUtils.formatUptime(event.getStartTimeMillis()) + ", " + TimeUtils.formatUptime(event.getEndTimeMillis()) + "] (" + TimeUtils.formatDuration(duration) + ")");
        return event.getStartTimeMillis();
    }

    boolean isHbmCurrentlyAllowed() {
        if (this.mIsHdrLayerPresent == false) goto L5;
    L13:
        return false;
    L5:
        if (this.mIsAutoBrightnessEnabled == false) goto L13;
        if (this.mIsTimeAvailable == false) goto L13;
        if (this.mIsInAllowedAmbientRange == false) goto L13;
        if (this.mIsBlockedByLowPowerMode == true) goto L13;
        return true;
    }

    boolean deviceSupportsHbm() {
        if (this.mHbmData != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHighBrightnessModeMetadata == null) goto L7;
        return true;
    }

    void disableHdrBoost() {
        this.mHdrBoostDisabled = true;
        unregisterHdrListener();
    }

    void onHdrBoostApplied(boolean applied) {
        if (this.mHdrBoostDisabled == false) goto L6;
        this.mIsHdrLayerPresent = applied;
        return;
    }

    private long calculateRemainingTime(long currentTime) {
        if (deviceSupportsHbm() == true) goto L5;
        return 0;
    L5:
        long timeAlreadyUsed = 0;
        long runningStartTimeMillis = this.mHighBrightnessModeMetadata.getRunningStartTimeMillis();
        if (runningStartTimeMillis <= 0) goto L12;
        if (runningStartTimeMillis <= currentTime) goto L10;
        Slog.e(TAG, "Start time set to the future. curr: " + currentTime + ", start: " + runningStartTimeMillis);
        this.mHighBrightnessModeMetadata.setRunningStartTimeMillis(currentTime);
        runningStartTimeMillis = currentTime;
    L10:
        timeAlreadyUsed = currentTime - runningStartTimeMillis;
    L12:
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Time already used after current session: " + timeAlreadyUsed);
    L14:
        long windowstartTimeMillis = currentTime - this.mHbmData.timeWindowMillis;
        Iterator<HbmEvent> it = this.mHighBrightnessModeMetadata.getHbmEventQueue().iterator();
    L16:
        if (it.hasNext() == false) goto L22;
        HbmEvent event = it.next();
        if (event.getEndTimeMillis() < windowstartTimeMillis) goto L19;
        long startTimeMillis = Math.max(event.getStartTimeMillis(), windowstartTimeMillis);
        timeAlreadyUsed = timeAlreadyUsed + (event.getEndTimeMillis() - startTimeMillis);
        goto L16
    L19:
        it.remove();
        goto L16
    L22:
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Time already used after all sessions: " + timeAlreadyUsed);
    L25:
        return Math.max(0, this.mHbmData.timeMaxMillis - timeAlreadyUsed);
    }

    private void recalculateTimeAllowance() {
        long currentTime = this.mClock.uptimeMillis();
        long remainingTime = calculateRemainingTime(currentTime);
        boolean r2 = false;
        if (remainingTime < this.mHbmData.timeMinMillis) goto L5;
        boolean isAllowedWithoutRestrictions = true;
    L6:
        if (isAllowedWithoutRestrictions == false) goto L8;
    L12:
        boolean isOnlyAllowedToStayOn = false;
    L13:
        if (isAllowedWithoutRestrictions == true) goto L15;
        if (isOnlyAllowedToStayOn == true) goto L15;
    L16:
        this.mIsTimeAvailable = r2;
        ArrayDeque<HbmEvent> hbmEvents = this.mHighBrightnessModeMetadata.getHbmEventQueue();
        if (this.mBrightness <= this.mHbmData.transitionPoint) goto L20;
        long nextTimeout = currentTime + remainingTime;
        long nextTimeout2 = nextTimeout;
    L26:
        if (DEBUG == false) goto L32;
        StringBuilder r3 = new StringBuilder();
        r3.append("HBM recalculated.  IsAllowedWithoutRestrictions: ");
        r3.append(isAllowedWithoutRestrictions);
        r3.append(", isOnlyAllowedToStayOn: ");
        r3.append(isOnlyAllowedToStayOn);
        r3.append(", remainingAllowedTime: ");
        r3.append(remainingTime);
        r3.append(", isLuxHigh: ");
        r3.append(this.mIsInAllowedAmbientRange);
        r3.append(", isHBMCurrentlyAllowed: ");
        r3.append(isHbmCurrentlyAllowed());
        r3.append(", isHdrLayerPresent: ");
        r3.append(this.mIsHdrLayerPresent);
        r3.append(", mMaxDesiredHdrSdrRatio: ");
        r3.append(this.mMaxDesiredHdrSdrRatio);
        r3.append(", isAutoBrightnessEnabled: ");
        r3.append(this.mIsAutoBrightnessEnabled);
        r3.append(", mIsTimeAvailable: ");
        r3.append(this.mIsTimeAvailable);
        r3.append(", mIsInAllowedAmbientRange: ");
        r3.append(this.mIsInAllowedAmbientRange);
        r3.append(", mIsBlockedByLowPowerMode: ");
        r3.append(this.mIsBlockedByLowPowerMode);
        r3.append(", mBrightness: ");
        r3.append(this.mBrightness);
        r3.append(", mUnthrottledBrightness: ");
        r3.append(this.mUnthrottledBrightness);
        r3.append(", mThrottlingReason: ");
        r3.append(BrightnessInfo.briMaxReasonToString(this.mThrottlingReason));
        r3.append(", RunningStartTimeMillis: ");
        r3.append(this.mHighBrightnessModeMetadata.getRunningStartTimeMillis());
        r3.append(", nextTimeout: ");
        if (nextTimeout2 == (-1)) goto L30;
        long r14 = nextTimeout2 - currentTime;
    L31:
        r3.append(r14);
        r3.append(", events: ");
        r3.append(hbmEvents);
        Slog.d(TAG, r3.toString());
        goto L32
    L30:
        r14 = -1;
    L32:
        this.mExt.recalculateTimeAllowance(isAllowedWithoutRestrictions, isOnlyAllowedToStayOn, remainingTime, currentTime, nextTimeout2);
        if (nextTimeout2 == (-1)) goto L35;
        this.mHandler.removeCallbacks(this.mRecalcRunnable);
        this.mHandler.postAtTime(this.mRecalcRunnable, 1 + nextTimeout2);
    L35:
        updateHbmMode();
        return;
    L20:
        if (this.mIsTimeAvailable == false) goto L22;
    L24:
        nextTimeout2 = -1;
        goto L26
    L22:
        if (hbmEvents.size() <= 0) goto L24;
        long windowstartTimeMillis = currentTime - this.mHbmData.timeWindowMillis;
        HbmEvent lastEvent = hbmEvents.peekLast();
        long r13 = Math.max(windowstartTimeMillis, lastEvent.getStartTimeMillis());
        long nextTimeout3 = this.mHbmData.timeMinMillis;
        long startTimePlusMinMillis = r13 + nextTimeout3;
        long timeWhenMinIsGainedBack = ((startTimePlusMinMillis - windowstartTimeMillis) + currentTime) - remainingTime;
        nextTimeout2 = timeWhenMinIsGainedBack;
    L15:
        r2 = true;
        goto L16
    L8:
        if (remainingTime <= 0) goto L12;
        if (this.mBrightness <= this.mHbmData.transitionPoint) goto L12;
        isOnlyAllowedToStayOn = true;
        goto L13
    L5:
        isAllowedWithoutRestrictions = false;
        goto L6
    }

    private void updateHbmMode() {
        int newHbmMode = calculateHighBrightnessMode();
        updateHbmStats(newHbmMode);
        if (this.mHbmMode == newHbmMode) goto L5;
    L6:
        this.mForceHbmChangeCallback = false;
        this.mHbmMode = newHbmMode;
        this.mHbmChangeCallback.run();
        return;
    L5:
        if (this.mForceHbmChangeCallback == true) goto L6;
    }

    private void updateHbmStats(int newMode) {
        int state = 1;
        boolean newHbmSv = true;
        if (newMode == 2) goto L5;
    L7:
        if (newMode == 1) goto L9;
    L12:
        if (state != this.mHbmStatsState) goto L14;
        return;
    L14:
        int reason = 0;
        if (this.mHbmStatsState != 3) goto L17;
        boolean oldHbmSv = true;
    L18:
        if (state == 3) goto L21;
        newHbmSv = false;
    L21:
        if (oldHbmSv == false) goto L49;
        if (newHbmSv == true) goto L49;
        if (this.mIsAutoBrightnessEnabled == true) goto L29;
        if (this.mIsAutoBrightnessOffByState == false) goto L29;
        reason = 6;
    L29:
        if (this.mIsAutoBrightnessEnabled == true) goto L32;
        reason = 7;
        goto L49
    L32:
        if (this.mIsInAllowedAmbientRange == true) goto L35;
        reason = 1;
        goto L49
    L35:
        if (this.mIsTimeAvailable == true) goto L38;
        reason = 2;
        goto L49
    L38:
        if (isThermalThrottlingActive() == false) goto L41;
        reason = 3;
        goto L49
    L41:
        if (this.mIsHdrLayerPresent == false) goto L44;
        reason = 4;
        goto L49
    L44:
        if (this.mIsBlockedByLowPowerMode == false) goto L47;
        reason = 5;
        goto L49
    L47:
        if (this.mBrightness > this.mHbmData.transitionPoint) goto L49;
        reason = 9;
    L49:
        this.mInjector.reportHbmStateChange(this.mDisplayStatsId, state, reason);
        this.mHbmStatsState = state;
        return;
    L17:
        oldHbmSv = false;
        goto L18
    L9:
        if (this.mBrightness <= this.mHbmData.transitionPoint) goto L12;
        state = 3;
        goto L12
    L5:
        if (getHdrBrightnessValue() <= this.mHbmData.transitionPoint) goto L7;
        state = 2;
        goto L12
    }

    boolean isThermalThrottlingActive() {
        if (this.mUnthrottledBrightness > this.mHbmData.transitionPoint) goto L5;
    L9:
        return false;
    L5:
        if (this.mBrightness > this.mHbmData.transitionPoint) goto L9;
        if (this.mThrottlingReason != 1) goto L9;
        return true;
    }

    private String hbmStatsStateToString(int hbmStatsState) {
        switch(hbmStatsState) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "HBM_ON_SUNLIGHT";
    L7:
        return "HBM_ON_HDR";
    L9:
        return "HBM_OFF";
    L4:
        return String.valueOf(hbmStatsState);
    }

    private int calculateHighBrightnessMode() {
        if (deviceSupportsHbm() == true) goto L6;
        return 0;
    L6:
        if (this.mIsHdrLayerPresent == false) goto L10;
        return 2;
    L10:
        if (this.mExt.isHdrLayerPresentExit(this.mIsHdrLayerPresent) == false) goto L14;
        return 1000;
    L14:
        if (isHbmCurrentlyAllowed() == false) goto L17;
        return 1;
    L17:
        return 0;
    }

    private void registerHdrListener(IBinder displayToken) {
        if (this.mHdrBoostDisabled == false) goto L6;
        return;
    L6:
        if (this.mRegisteredDisplayToken != displayToken) goto L8;
        return;
    L8:
        unregisterHdrListener();
        this.mRegisteredDisplayToken = displayToken;
        if (this.mRegisteredDisplayToken == null) goto L12;
        this.mHdrListener.register(this.mRegisteredDisplayToken);
        return;
    }

    private void unregisterHdrListener() {
        if (this.mRegisteredDisplayToken == null) goto L6;
        this.mHdrListener.unregister(this.mRegisteredDisplayToken);
        this.mIsHdrLayerPresent = false;
        this.mExt.setHdrLayerPresentExit(false);
        return;
    }

    public IExtHighBrightnessModeController getExt() {
        return this.mExt;
    }

    public void setHdrLayerPresentExit(boolean isHdrLayerPresentExit) {
        this.mExt.setHdrLayerPresentExit(isHdrLayerPresentExit);
    }
}
