package com.android.server.policy;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.SystemClock;
import android.view.Display;
import android.view.animation.LinearInterpolator;
import com.android.server.LocalServices;
import com.android.server.am.HostingRecord;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class BurnInProtectionHelper implements DisplayManager.DisplayListener, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private static final String ACTION_BURN_IN_PROTECTION = "android.internal.policy.action.BURN_IN_PROTECTION";
    private static final long BURNIN_PROTECTION_FIRST_WAKEUP_INTERVAL_MS = 0;
    private static final long BURNIN_PROTECTION_MINIMAL_INTERVAL_MS = 0;
    private static final long BURNIN_PROTECTION_SUBSEQUENT_WAKEUP_INTERVAL_MS = 0;
    public static final int BURN_IN_MAX_RADIUS_DEFAULT = -1;
    private static final int BURN_IN_SHIFT_STEP = 2;
    private static final long CENTERING_ANIMATION_DURATION_MS = 100;
    private static final boolean DEBUG = false;
    private static final String TAG = "BurnInProtection";
    private final AlarmManager mAlarmManager;
    private int mAppliedBurnInXOffset;
    private int mAppliedBurnInYOffset;
    private boolean mBurnInProtectionActive;
    private final PendingIntent mBurnInProtectionIntent;
    private BroadcastReceiver mBurnInProtectionReceiver;
    private final int mBurnInRadiusMaxSquared;
    private final ValueAnimator mCenteringAnimator;
    private final Display mDisplay;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private boolean mFirstUpdate;
    private int mLastBurnInXOffset;
    private int mLastBurnInYOffset;
    private final int mMaxHorizontalBurnInOffset;
    private final int mMaxVerticalBurnInOffset;
    private final int mMinHorizontalBurnInOffset;
    private final int mMinVerticalBurnInOffset;
    private int mXOffsetDirection;
    private int mYOffsetDirection;

    /* JADX INFO: renamed from: -$$Nest$mupdateBurnInProtection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7125$$Nest$mupdateBurnInProtection(BurnInProtectionHelper r0) {
        r0.updateBurnInProtection();
    }

    static {
        BURNIN_PROTECTION_FIRST_WAKEUP_INTERVAL_MS = TimeUnit.MINUTES.toMillis(1);
        BURNIN_PROTECTION_SUBSEQUENT_WAKEUP_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
        BURNIN_PROTECTION_MINIMAL_INTERVAL_MS = TimeUnit.SECONDS.toMillis(10);
    }

    public BurnInProtectionHelper(Context context, int minHorizontalOffset, int maxHorizontalOffset, int minVerticalOffset, int maxVerticalOffset, int maxOffsetRadius) {
        this.mLastBurnInXOffset = 0;
        this.mXOffsetDirection = 1;
        this.mLastBurnInYOffset = 0;
        this.mYOffsetDirection = 1;
        this.mAppliedBurnInXOffset = 0;
        this.mAppliedBurnInYOffset = 0;
        this.mBurnInProtectionReceiver = new AnonymousClass1(this);
        this.mMinHorizontalBurnInOffset = minHorizontalOffset;
        this.mMaxHorizontalBurnInOffset = maxHorizontalOffset;
        this.mMinVerticalBurnInOffset = minVerticalOffset;
        this.mMaxVerticalBurnInOffset = maxVerticalOffset;
        if (maxOffsetRadius == (-1)) goto L5;
        this.mBurnInRadiusMaxSquared = maxOffsetRadius * maxOffsetRadius;
    L6:
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mAlarmManager = (AlarmManager) context.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        context.registerReceiver(this.mBurnInProtectionReceiver, new IntentFilter(ACTION_BURN_IN_PROTECTION));
        Intent intent = new Intent(ACTION_BURN_IN_PROTECTION);
        intent.setPackage(context.getPackageName());
        intent.setFlags(1073741824);
        this.mBurnInProtectionIntent = PendingIntent.getBroadcast(context, 0, intent, AudioFormat.E_AC3);
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        this.mDisplay = displayManager.getDisplay(0);
        displayManager.registerDisplayListener(this, null);
        this.mCenteringAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.mCenteringAnimator.setDuration(CENTERING_ANIMATION_DURATION_MS);
        this.mCenteringAnimator.setInterpolator(new LinearInterpolator());
        this.mCenteringAnimator.addListener(this);
        this.mCenteringAnimator.addUpdateListener(this);
        return;
    L5:
        this.mBurnInRadiusMaxSquared = -1;
        goto L6
    }

    public void startBurnInProtection() {
        if (this.mBurnInProtectionActive == true) goto L6;
        this.mBurnInProtectionActive = true;
        this.mFirstUpdate = true;
        this.mCenteringAnimator.cancel();
        updateBurnInProtection();
        return;
    }

    private void updateBurnInProtection() {
        if (this.mBurnInProtectionActive == true) goto L5;
        this.mAlarmManager.cancel(this.mBurnInProtectionIntent);
        this.mCenteringAnimator.start();
        return;
    L5:
        if (this.mFirstUpdate == false) goto L7;
        long interval = BURNIN_PROTECTION_FIRST_WAKEUP_INTERVAL_MS;
    L9:
        if (this.mFirstUpdate == false) goto L11;
        this.mFirstUpdate = false;
    L12:
        long nowWall = System.currentTimeMillis();
        long nowElapsed = SystemClock.elapsedRealtime();
        long nextWall = BURNIN_PROTECTION_MINIMAL_INTERVAL_MS + nowWall;
        long nextElapsed = (((nextWall - (nextWall % interval)) + interval) - nowWall) + nowElapsed;
        this.mAlarmManager.setExact(3, nextElapsed, this.mBurnInProtectionIntent);
        return;
    L11:
        adjustOffsets();
        this.mAppliedBurnInXOffset = this.mLastBurnInXOffset;
        this.mAppliedBurnInYOffset = this.mLastBurnInYOffset;
        this.mDisplayManagerInternal.setDisplayOffsets(this.mDisplay.getDisplayId(), this.mLastBurnInXOffset, this.mLastBurnInYOffset);
        goto L12
    L7:
        interval = BURNIN_PROTECTION_SUBSEQUENT_WAKEUP_INTERVAL_MS;
        goto L9
    }

    public void cancelBurnInProtection() {
        if (this.mBurnInProtectionActive == false) goto L6;
        this.mBurnInProtectionActive = false;
        updateBurnInProtection();
        return;
    }

    private void adjustOffsets() {
    L2:
        int xChange = this.mXOffsetDirection * 2;
        this.mLastBurnInXOffset += xChange;
        if (this.mLastBurnInXOffset <= this.mMaxHorizontalBurnInOffset) goto L5;
    L6:
        this.mLastBurnInXOffset -= xChange;
        this.mXOffsetDirection *= -1;
        int yChange = this.mYOffsetDirection * 2;
        this.mLastBurnInYOffset += yChange;
        if (this.mLastBurnInYOffset <= this.mMaxVerticalBurnInOffset) goto L9;
    L10:
        this.mLastBurnInYOffset -= yChange;
        this.mYOffsetDirection *= -1;
    L12:
        if (this.mBurnInRadiusMaxSquared == (-1)) goto L15;
        if (((this.mLastBurnInXOffset * this.mLastBurnInXOffset) + (this.mLastBurnInYOffset * this.mLastBurnInYOffset)) > this.mBurnInRadiusMaxSquared) goto L2;
        return;
    L15:
        return;
    L9:
        if (this.mLastBurnInYOffset >= this.mMinVerticalBurnInOffset) goto L12;
    L5:
        if (this.mLastBurnInXOffset >= this.mMinHorizontalBurnInOffset) goto L12;
        goto L6
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + TAG);
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "mBurnInProtectionActive=" + this.mBurnInProtectionActive);
        pw.println(prefix2 + "mHorizontalBurnInOffsetsBounds=(" + this.mMinHorizontalBurnInOffset + ", " + this.mMaxHorizontalBurnInOffset + ")");
        pw.println(prefix2 + "mVerticalBurnInOffsetsBounds=(" + this.mMinVerticalBurnInOffset + ", " + this.mMaxVerticalBurnInOffset + ")");
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix2);
        r0.append("mBurnInRadiusMaxSquared=");
        r0.append(this.mBurnInRadiusMaxSquared);
        pw.println(r0.toString());
        pw.println(prefix2 + "mLastBurnInOffset=(" + this.mLastBurnInXOffset + ", " + this.mLastBurnInYOffset + ")");
        pw.println(prefix2 + "mOfsetChangeDirections=(" + this.mXOffsetDirection + ", " + this.mYOffsetDirection + ")");
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        if (displayId == this.mDisplay.getDisplayId()) goto L5;
        return;
    L5:
        if (this.mDisplay.getState() != 3) goto L7;
    L12:
        startBurnInProtection();
        return;
    L7:
        if (this.mDisplay.getState() == 4) goto L12;
        if (this.mDisplay.getState() == 6) goto L12;
        cancelBurnInProtection();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (animator == this.mCenteringAnimator) goto L5;
        return;
    L5:
        if (this.mBurnInProtectionActive == true) goto L9;
        this.mAppliedBurnInXOffset = 0;
        this.mAppliedBurnInYOffset = 0;
        this.mDisplayManagerInternal.setDisplayOffsets(this.mDisplay.getDisplayId(), 0, 0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.mBurnInProtectionActive == true) goto L6;
        float value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mDisplayManagerInternal.setDisplayOffsets(this.mDisplay.getDisplayId(), (int) (this.mAppliedBurnInXOffset * value), (int) (this.mAppliedBurnInYOffset * value));
        return;
    }
}
