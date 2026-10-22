package com.android.server.policy;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.android.internal.os.Clock;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
class WindowWakeUpPolicy {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowWakeUpPolicy";
    private final boolean mAllowTheaterModeWakeFromCameraLens;
    private final boolean mAllowTheaterModeWakeFromKey;
    private final boolean mAllowTheaterModeWakeFromLidSwitch;
    private final boolean mAllowTheaterModeWakeFromMotion;
    private final boolean mAllowTheaterModeWakeFromPowerKey;
    private final boolean mAllowTheaterModeWakeFromWakeGesture;
    private final Clock mClock;
    private final Context mContext;
    private WindowWakeUpPolicyInternal.InputWakeUpDelegate mInputWakeUpDelegate;
    private final PowerManager mPowerManager;
    private final WindowManager mWindowManager;

    private final class LocalService implements WindowWakeUpPolicyInternal {
        final /* synthetic */ WindowWakeUpPolicy this$0;

        /* synthetic */ LocalService(WindowWakeUpPolicy r1, WindowWakeUpPolicyIA r2) {
            this(r1);
        }

        private LocalService(WindowWakeUpPolicy r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.policy.WindowWakeUpPolicyInternal
        public void setInputWakeUpDelegate(WindowWakeUpPolicyInternal.InputWakeUpDelegate delegate) {
            WindowWakeUpPolicy.m7284$$Nest$fputmInputWakeUpDelegate(this.this$0, delegate);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInputWakeUpDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7284$$Nest$fputmInputWakeUpDelegate(WindowWakeUpPolicy r0, WindowWakeUpPolicyInternal.InputWakeUpDelegate r1) {
        r0.mInputWakeUpDelegate = r1;
    }

    WindowWakeUpPolicy(Context context) {
        this(context, Clock.SYSTEM_CLOCK);
    }

    WindowWakeUpPolicy(Context context, Clock clock) {
        this.mContext = context;
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mWindowManager = (WindowManager) context.getSystemService(WindowManager.class);
        this.mClock = clock;
        Resources res = context.getResources();
        this.mAllowTheaterModeWakeFromKey = res.getBoolean(R.bool.config_allowTheaterModeWakeFromKey);
        if (this.mAllowTheaterModeWakeFromKey == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        this.mAllowTheaterModeWakeFromPowerKey = r1;
        this.mAllowTheaterModeWakeFromMotion = res.getBoolean(R.bool.config_allowTheaterModeWakeFromMotion);
        this.mAllowTheaterModeWakeFromCameraLens = res.getBoolean(R.bool.config_allowTheaterModeWakeFromCameraLens);
        this.mAllowTheaterModeWakeFromLidSwitch = res.getBoolean(R.bool.config_allowTheaterModeWakeFromLidSwitch);
        this.mAllowTheaterModeWakeFromWakeGesture = res.getBoolean(R.bool.config_allowTheaterModeWakeFromGesture);
        LocalServices.addService(WindowWakeUpPolicyInternal.class, new LocalService(this, null));
        return;
    L5:
        if (res.getBoolean(R.bool.config_allowTheaterModeWakeFromPowerKey) == true) goto L8;
        r1 = false;
        goto L9
    }

    boolean wakeUpFromKey(int displayId, long eventTime, int keyCode, boolean isDown) {
        if (keyCode != 26) goto L5;
        boolean wakeAllowedDuringTheaterMode = this.mAllowTheaterModeWakeFromPowerKey;
    L7:
        if (canWakeUp(wakeAllowedDuringTheaterMode) == true) goto L11;
        return false;
    L11:
        if (this.mInputWakeUpDelegate != null) goto L13;
    L16:
        if (keyCode != 26) goto L18;
        int r8 = 1;
    L19:
        if (keyCode != 26) goto L22;
        String r0 = "POWER";
    L23:
        wakeUp(displayId, eventTime, r8, r0);
        return true;
    L22:
        r0 = "KEY";
        goto L23
    L18:
        r8 = 6;
        goto L19
    L13:
        if (this.mInputWakeUpDelegate.wakeUpFromKey(eventTime, keyCode, isDown) == false) goto L16;
        return true;
    L5:
        wakeAllowedDuringTheaterMode = this.mAllowTheaterModeWakeFromKey;
        goto L7
    }

    boolean wakeUpFromMotion(int displayId, long eventTime, int source, boolean isDown, boolean deviceGoingToSleep) {
        if (canWakeUp(this.mAllowTheaterModeWakeFromMotion) == true) goto L7;
        return false;
    L7:
        if (this.mInputWakeUpDelegate == null) goto L11;
        long eventTime2 = eventTime;
        if (this.mInputWakeUpDelegate.wakeUpFromMotion(eventTime2, source, isDown, deviceGoingToSleep) == false) goto L12;
        return true;
    L12:
        wakeUp(displayId, eventTime2, 7, "MOTION");
        return true;
    L11:
        eventTime2 = eventTime;
        goto L12
    }

    boolean wakeUpFromCameraCover(long eventTime) {
        if (canWakeUp(this.mAllowTheaterModeWakeFromCameraLens) == true) goto L6;
        return false;
    L6:
        wakeUp(eventTime, 5, "CAMERA_COVER");
        return true;
    }

    boolean wakeUpFromLid() {
        if (canWakeUp(this.mAllowTheaterModeWakeFromLidSwitch) == true) goto L6;
        return false;
    L6:
        wakeUp(this.mClock.uptimeMillis(), 9, "LID");
        return true;
    }

    boolean wakeUpFromPowerKeyCameraGesture() {
        if (canWakeUp(this.mAllowTheaterModeWakeFromPowerKey) == true) goto L6;
        return false;
    L6:
        wakeUp(this.mClock.uptimeMillis(), 5, "CAMERA_GESTURE_PREVENT_LOCK");
        return true;
    }

    boolean wakeUpFromWakeGesture() {
        if (canWakeUp(this.mAllowTheaterModeWakeFromWakeGesture) == true) goto L6;
        return false;
    L6:
        wakeUp(this.mClock.uptimeMillis(), 4, "GESTURE");
        return true;
    }

    private boolean canWakeUp(boolean wakeInTheaterMode) {
        if (isDefaultDisplayOn() == false) goto L6;
        return true;
    L6:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "theater_mode_on", 0) != 1) goto L8;
        boolean isTheaterModeEnabled = true;
    L9:
        if (wakeInTheaterMode == true) goto L14;
        if (isTheaterModeEnabled == true) goto L13;
        return true;
    L13:
        return false;
    L14:
        return true;
    L8:
        isTheaterModeEnabled = false;
        goto L9
    }

    private boolean isDefaultDisplayOn() {
        return Display.isOnState(this.mWindowManager.getDefaultDisplay().getState());
    }

    private void wakeUp(long wakeTime, int reason, String details) {
        this.mPowerManager.wakeUp(wakeTime, reason, "android.policy:" + details);
    }

    private void wakeUp(int displayId, long wakeTime, int reason, String details) {
        if (displayId != (-1)) goto L5;
        int r0 = 0;
    L6:
        int displayIdToWake = r0;
        this.mPowerManager.wakeUp(wakeTime, reason, "android.policy:" + details, displayIdToWake);
        return;
    L5:
        r0 = displayId;
        goto L6
    }
}
