package com.android.server.power;

import android.R;
import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenUndimDetector {
    private static final boolean DEBUG = false;
    static final String KEY_KEEP_SCREEN_ON_ENABLED = "keep_screen_on_enabled";
    static final String KEY_KEEP_SCREEN_ON_FOR_MILLIS = "keep_screen_on_for_millis";
    static final String KEY_MAX_DURATION_BETWEEN_UNDIMS_MILLIS = "max_duration_between_undims_millis";
    static final String KEY_UNDIMS_REQUIRED = "undims_required";
    private static final int OUTCOME_POWER_BUTTON = 1;
    private static final int OUTCOME_TIMEOUT = 2;
    private static final String TAG = "ScreenUndimDetector";
    private static final String UNDIM_DETECTOR_WAKE_LOCK = "UndimDetectorWakeLock";
    private InternalClock mClock;
    private Context mContext;
    int mCurrentScreenPolicy;
    private long mInteractionAfterUndimTime;
    private boolean mKeepScreenOnEnabled;
    private long mKeepScreenOnForMillis;
    private long mMaxDurationBetweenUndimsMillis;
    int mUndimCounter;
    long mUndimCounterStartedMillis;
    private long mUndimOccurredTime;
    private int mUndimsRequired;
    PowerManager.WakeLock mWakeLock;

    static class InternalClock {
        InternalClock() {
        }

        public long getCurrentTime() {
            return SystemClock.elapsedRealtime();
        }
    }

    public static /* synthetic */ void $r8$lambda$l8r9IiUhjtawcWAERzTlYOAykvg(ScreenUndimDetector r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$0(r1);
    }

    public ScreenUndimDetector() {
        this.mUndimCounter = 0;
        this.mUndimOccurredTime = -1;
        this.mInteractionAfterUndimTime = -1;
        this.mClock = new InternalClock();
    }

    ScreenUndimDetector(InternalClock clock) {
        this.mUndimCounter = 0;
        this.mUndimOccurredTime = -1;
        this.mInteractionAfterUndimTime = -1;
        this.mClock = clock;
    }

    public void systemReady(Context context) {
        this.mContext = context;
        readValuesFromDeviceConfig();
        DeviceConfig.addOnPropertiesChangedListener("attention_manager_service", this.mContext.getMainExecutor(), new ScreenUndimDetector$$ExternalSyntheticLambda0(this));
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mWakeLock = powerManager.newWakeLock(536870922, UNDIM_DETECTOR_WAKE_LOCK);
    }

    private /* synthetic */ void lambda$systemReady$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    public void recordScreenPolicy(int displayGroupId, int newPolicy) {
        if (displayGroupId == 0) goto L4;
        return;
    L4:
        if (newPolicy == this.mCurrentScreenPolicy) goto L43;
        int currentPolicy = this.mCurrentScreenPolicy;
        this.mCurrentScreenPolicy = newPolicy;
        if (this.mKeepScreenOnEnabled == true) goto L10;
        return;
    L10:
        switch(currentPolicy) {
            case 2: goto L18;
            case 3: goto L12;
            default: goto L39;
        };
    L12:
        if (newPolicy == 0) goto L14;
        if (newPolicy == 1) goto L14;
    L15:
        if (newPolicy == 2) goto L37;
        reset();
        return;
    L37:
        return;
    L14:
        checkAndLogUndim(1);
        goto L15
    L39:
        return;
    L18:
        if (newPolicy != 3) goto L31;
        long now = this.mClock.getCurrentTime();
        long timeElapsedSinceFirstUndim = now - this.mUndimCounterStartedMillis;
        if (timeElapsedSinceFirstUndim < this.mMaxDurationBetweenUndimsMillis) goto L23;
        reset();
    L23:
        if (this.mUndimCounter != 0) goto L25;
        this.mUndimCounterStartedMillis = now;
    L25:
        this.mUndimCounter++;
        if (this.mUndimCounter < this.mUndimsRequired) goto L41;
        reset();
        if (this.mWakeLock == null) goto L42;
        this.mUndimOccurredTime = this.mClock.getCurrentTime();
        this.mWakeLock.acquire(this.mKeepScreenOnForMillis);
        return;
    L42:
        return;
    L41:
        return;
    L31:
        if (newPolicy == 0) goto L33;
        if (newPolicy == 1) goto L33;
    L34:
        reset();
        return;
    L33:
        checkAndLogUndim(2);
        goto L34
    }

    void reset() {
        this.mUndimCounter = 0;
        this.mUndimCounterStartedMillis = 0;
        if (this.mWakeLock != null) goto L5;
        return;
    L5:
        if (this.mWakeLock.isHeld() == false) goto L9;
        this.mWakeLock.release();
        return;
    }

    private boolean readKeepScreenOnEnabled() {
        boolean defaultKeepScreenOnEnabled = this.mContext.getResources().getBoolean(R.bool.config_defaultWindowFeatureOptionsPanel);
        return DeviceConfig.getBoolean("attention_manager_service", KEY_KEEP_SCREEN_ON_ENABLED, defaultKeepScreenOnEnabled);
    }

    private long readKeepScreenOnForMillis() {
        long defaultKeepScreenOnDuration = this.mContext.getResources().getInteger(R.integer.config_demo_pointing_aligned_duration_millis);
        return DeviceConfig.getLong("attention_manager_service", KEY_KEEP_SCREEN_ON_FOR_MILLIS, defaultKeepScreenOnDuration);
    }

    private int readUndimsRequired() {
        int defaultUndimsRequired = this.mContext.getResources().getInteger(R.integer.config_displayWhiteBalanceBrightnessSensorRate);
        int undimsRequired = DeviceConfig.getInt("attention_manager_service", KEY_UNDIMS_REQUIRED, defaultUndimsRequired);
        if (undimsRequired >= 1) goto L5;
    L8:
        Slog.e(TAG, "Provided undimsRequired=" + undimsRequired + " is not allowed [1, 5]; using the default=" + defaultUndimsRequired);
        return defaultUndimsRequired;
    L5:
        if (undimsRequired > 5) goto L8;
        return undimsRequired;
    }

    private long readMaxDurationBetweenUndimsMillis() {
        long defaultMaxDurationBetweenUndimsMillis = this.mContext.getResources().getInteger(R.integer.config_defaultPictureInPictureGravity);
        return DeviceConfig.getLong("attention_manager_service", KEY_MAX_DURATION_BETWEEN_UNDIMS_MILLIS, defaultMaxDurationBetweenUndimsMillis);
    }

    private void onDeviceConfigChange(Set<String> keys) {
        Iterator<String> r0 = keys.iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        String key = r0.next();
        Slog.i(TAG, "onDeviceConfigChange; key=" + key);
        switch(key.hashCode()) {
            case -2114725254: goto L18;
            case -1871288230: goto L15;
            case 352003779: goto L12;
            case 1709324730: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L23;
            case 2: goto L23;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        Slog.i(TAG, "Ignoring change on " + key);
        goto L4
    L23:
        readValuesFromDeviceConfig();
        return;
    L9:
        if (key.equals(KEY_MAX_DURATION_BETWEEN_UNDIMS_MILLIS) == false) goto L20;
        r2 = 3;
        goto L21
    L12:
        if (key.equals(KEY_KEEP_SCREEN_ON_FOR_MILLIS) == false) goto L20;
        r2 = 1;
        goto L21
    L15:
        if (key.equals(KEY_KEEP_SCREEN_ON_ENABLED) == false) goto L20;
        r2 = 0;
        goto L21
    L18:
        if (key.equals(KEY_UNDIMS_REQUIRED) == false) goto L20;
        r2 = 2;
        goto L21
    }

    void readValuesFromDeviceConfig() {
        this.mKeepScreenOnEnabled = readKeepScreenOnEnabled();
        this.mKeepScreenOnForMillis = readKeepScreenOnForMillis();
        this.mUndimsRequired = readUndimsRequired();
        this.mMaxDurationBetweenUndimsMillis = readMaxDurationBetweenUndimsMillis();
        Slog.i(TAG, "readValuesFromDeviceConfig():\nmKeepScreenOnForMillis=" + this.mKeepScreenOnForMillis + "\nmKeepScreenOnEnabled=" + this.mKeepScreenOnEnabled + "\nmUndimsRequired=" + this.mUndimsRequired + "\nmMaxDurationBetweenUndimsMillis=" + this.mMaxDurationBetweenUndimsMillis);
    }

    public void userActivity(int displayGroupId) {
        if (displayGroupId == 0) goto L5;
        return;
    L5:
        if (this.mUndimOccurredTime != 1) goto L7;
        return;
    L7:
        if (this.mInteractionAfterUndimTime != (-1)) goto L11;
        this.mInteractionAfterUndimTime = this.mClock.getCurrentTime();
        return;
    }

    private void checkAndLogUndim(int outcome) {
        if (this.mUndimOccurredTime == (-1)) goto L10;
        long now = this.mClock.getCurrentTime();
        long r8 = now - this.mUndimOccurredTime;
        if (this.mInteractionAfterUndimTime == (-1)) goto L7;
        long r10 = now - this.mInteractionAfterUndimTime;
    L8:
        FrameworkStatsLog.write(365, outcome, r8, r10);
        this.mUndimOccurredTime = -1;
        this.mInteractionAfterUndimTime = -1;
        return;
    L7:
        r10 = -1;
        goto L8
    }
}
