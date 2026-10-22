package com.android.server.display;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.FloatProperty;
import android.util.Slog;
import android.view.animation.Interpolator;
import com.android.server.display.utils.CubicBezierInterpolator;
import com.android.server.power.PowerManagerServiceSmtEx;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class RampAnimatorSmtEx<T> {
    private boolean DEBUG;
    private final Interpolator DEFAULT_INTERPOLATOR;
    private final float EPSILON;
    private final int EVENT_VALUE_ANIMATE_START;
    private final int EVENT_VALUE_ANIMATE_STOP;
    private ValueAnimator mAnimatorByteDance;
    private volatile float mCurrentValue;
    private float mFromBrightness;
    private final T mObject;
    private final FloatProperty<T> mProperty;
    private RampAnimator mRampAnimator;
    private Handler mSubWorkHander;
    private volatile float mTargetValue;
    private float mTempBrightness;
    private float mToBrightness;
    private Message mValueAnimateMessage;
    private HandlerThread mValueAnimateWorkThread;

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimatorByteDance, reason: not valid java name */
    static /* bridge */ /* synthetic */ ValueAnimator m3884$$Nest$fgetmAnimatorByteDance(RampAnimatorSmtEx r0) {
        return r0.mAnimatorByteDance;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3885$$Nest$fgetmCurrentValue(RampAnimatorSmtEx r0) {
        return r0.mCurrentValue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObject, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3886$$Nest$fgetmObject(RampAnimatorSmtEx r0) {
        return r0.mObject;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ FloatProperty m3887$$Nest$fgetmProperty(RampAnimatorSmtEx r0) {
        return r0.mProperty;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTargetValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3888$$Nest$fgetmTargetValue(RampAnimatorSmtEx r0) {
        return r0.mTargetValue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3889$$Nest$fgetmTempBrightness(RampAnimatorSmtEx r0) {
        return r0.mTempBrightness;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAnimatorByteDance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3890$$Nest$fputmAnimatorByteDance(RampAnimatorSmtEx r0, ValueAnimator r1) {
        r0.mAnimatorByteDance = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3891$$Nest$fputmCurrentValue(RampAnimatorSmtEx r0, float r1) {
        r0.mCurrentValue = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTempBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3892$$Nest$fputmTempBrightness(RampAnimatorSmtEx r0, float r1) {
        r0.mTempBrightness = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mbrightnessValueAnimation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3893$$Nest$mbrightnessValueAnimation(RampAnimatorSmtEx r0, int r1, float r2, float r3) {
        r0.brightnessValueAnimation(r1, r2, r3);
    }

    public RampAnimatorSmtEx(T object, FloatProperty<T> property, RampAnimator rampAnimator) {
        this.DEBUG = true;
        this.mFromBrightness = -1.0f;
        this.mToBrightness = -1.0f;
        this.mTempBrightness = -1.0f;
        this.EVENT_VALUE_ANIMATE_START = 1;
        this.EVENT_VALUE_ANIMATE_STOP = 2;
        this.EPSILON = 0.001f;
        this.DEFAULT_INTERPOLATOR = new CubicBezierInterpolator(0.0f, 0.0f, 0.62f, 1.0f);
        this.mObject = object;
        this.mProperty = property;
        if (PowerManagerServiceSmtEx.BRIGHTNESS.equals(property) == false) goto L5;
        initWorkThread();
    L5:
        this.mRampAnimator = rampAnimator;
    }

    public void setBrightnessGradient(int durationMillions, float fromBrightness, float toBrightness) {
        if (this.DEBUG == false) goto L5;
        Slog.d("AutoBC", "setBrightnessGradient-->durationMillions = " + durationMillions + ", fromBrightness = " + fromBrightness + ", toBrightness = " + toBrightness);
    L5:
        boolean r0 = false;
        if (durationMillions >= 0) goto L8;
        boolean r2 = true;
    L10:
        if (fromBrightness >= 0.0f) goto L12;
        boolean r4 = true;
    L13:
        boolean r3 = r2 | r4;
        if (toBrightness >= 0.0f) goto L17;
        r0 = true;
    L17:
        if ((r0 | r3) == false) goto L19;
        return;
    L19:
        this.mTargetValue = toBrightness;
        this.mCurrentValue = fromBrightness;
        this.mTempBrightness = -1.0f;
        if (this.mSubWorkHander == null) goto L23;
        this.mValueAnimateMessage = this.mSubWorkHander.obtainMessage();
        this.mValueAnimateMessage.what = 1;
        this.mValueAnimateMessage.arg1 = Float.floatToIntBits(fromBrightness);
        this.mValueAnimateMessage.arg2 = Float.floatToIntBits(toBrightness);
        this.mValueAnimateMessage.obj = Integer.valueOf(durationMillions);
        this.mSubWorkHander.removeMessages(this.mValueAnimateMessage.what);
        this.mSubWorkHander.sendMessage(this.mValueAnimateMessage);
        return;
    L23:
        return;
    L12:
        r4 = false;
        goto L13
    L8:
        r2 = false;
        goto L10
    }

    public void setTargetValue(float target) {
        this.mCurrentValue = target;
        this.mTargetValue = target;
        this.mValueAnimateMessage = this.mSubWorkHander.obtainMessage();
        this.mValueAnimateMessage.what = 2;
        this.mSubWorkHander.removeMessages(this.mValueAnimateMessage.what);
        this.mSubWorkHander.sendMessage(this.mValueAnimateMessage);
    }

    public void setTempBrightValue(float target) {
        this.mTempBrightness = target;
    }

    public ValueAnimator getAnimatorByteDance() {
        return this.mAnimatorByteDance;
    }

    private void initWorkThread() {
        Slog.d("AutoBC", "initWorkThread");
        if (this.mValueAnimateWorkThread != null) goto L6;
        this.mValueAnimateWorkThread = new HandlerThread("AutoBrightnessController work thread");
        this.mValueAnimateWorkThread.start();
        final Looper r1 = this.mValueAnimateWorkThread.getLooper();
        this.mSubWorkHander = new AnonymousClass1(this, r1);
        return;
    }

    public static float floatDiffAbs(float a, float b) {
        BigDecimal aBigDecimalValue = new BigDecimal(a).setScale(3, 4);
        BigDecimal bBigDecimalValue = new BigDecimal(b).setScale(3, 4);
        return Math.abs(aBigDecimalValue.subtract(bBigDecimalValue).floatValue());
    }

    private void brightnessValueAnimation(int durationMillions, float fromBrightness, float toBrightness) {
        if (this.mAnimatorByteDance != null) goto L5;
    L26:
        this.mAnimatorByteDance = ValueAnimator.ofFloat(new float[]{fromBrightness, toBrightness});
        this.mAnimatorByteDance.setDuration(durationMillions);
        this.mAnimatorByteDance.setInterpolator(this.DEFAULT_INTERPOLATOR);
        this.mAnimatorByteDance.addUpdateListener(new AnonymousClass2(this));
        this.mAnimatorByteDance.start();
        return;
    L5:
        if (this.mAnimatorByteDance.isRunning() == false) goto L25;
        float screenBrightness = ((Float) this.mProperty.get(this.mObject)).floatValue();
        Slog.d("AutoBC", "brightnessValueAnimation has running " + String.valueOf(screenBrightness));
        if (Math.abs(screenBrightness - (-1.0f)) < 0.001f) goto L24;
        float max = Float.max(fromBrightness, toBrightness);
        float min = Float.min(fromBrightness, screenBrightness);
        if (Math.abs(max - toBrightness) >= 0.001f) goto L18;
        if (Math.abs(min - fromBrightness) >= 0.001f) goto L16;
        float max2 = Float.max(screenBrightness, toBrightness);
        if (Math.abs(max2 - toBrightness) >= 0.001f) goto L24;
        fromBrightness = screenBrightness;
        goto L24
    L16:
        fromBrightness = screenBrightness;
        goto L24
    L18:
        if (Math.abs(min - screenBrightness) >= 0.001f) goto L23;
        float min2 = Float.min(screenBrightness, toBrightness);
        if (Math.abs(min2 - toBrightness) >= 0.001f) goto L24;
        fromBrightness = screenBrightness;
        goto L24
    L23:
        fromBrightness = screenBrightness;
    L24:
        this.mAnimatorByteDance.cancel();
    L25:
        this.mAnimatorByteDance.removeAllUpdateListeners();
        goto L26
    }

    public void setCurrentValue(float cur) {
        this.mRampAnimator.mFirstTime = false;
        this.mCurrentValue = cur;
        if (PowerManagerServiceSmtEx.BRIGHTNESS.equals(this.mProperty) == false) goto L6;
        this.mRampAnimator.getSmtEx().setTempBrightValue(cur);
        return;
    }

    public void setValue(float target) {
        this.mRampAnimator.mAnimating = false;
        this.mCurrentValue = target;
        this.mTargetValue = target;
        this.mProperty.setValue(this.mObject, target);
        if (PowerManagerServiceSmtEx.BRIGHTNESS.equals(this.mProperty) == false) goto L6;
        this.mRampAnimator.getSmtEx().setTargetValue(target);
        return;
    }

    public void stop() {
        setValue(this.mCurrentValue);
    }
}
