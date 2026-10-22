package com.android.server.display;

import android.content.Context;
import android.os.Handler;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.FloatProperty;
import android.util.Slog;
import android.view.Choreographer;
import android.view.Display;
import com.android.internal.os.BackgroundThread;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class DisplayPowerState {
    public static final FloatProperty<DisplayPowerState> COLOR_FADE_LEVEL = null;
    private static String COUNTER_COLOR_FADE = null;
    private static final boolean DEBUG = false;
    public static final FloatProperty<DisplayPowerState> SCREEN_BRIGHTNESS_FLOAT = null;
    public static final FloatProperty<DisplayPowerState> SCREEN_SDR_BRIGHTNESS_FLOAT = null;
    private static final String TAG = "DisplayPowerState";
    private int mAodLevel;
    private Executor mAsyncDestroyExecutor;
    private final DisplayBlanker mBlanker;
    private final Choreographer mChoreographer;
    private Runnable mCleanListener;
    private final ColorFade mColorFade;
    private boolean mColorFadeDrawPending;
    final Runnable mColorFadeDrawRunnable;
    private float mColorFadeLevel;
    private boolean mColorFadePrepared;
    private boolean mColorFadeReady;
    private final int mDisplayId;
    private IExtDisplayPowerState mExt;
    private final Handler mHandler;
    private final PhotonicModulator mPhotonicModulator;
    private float mScreenBrightness;
    private boolean mScreenReady;
    private int mScreenState;
    private boolean mScreenUpdatePending;
    private final Runnable mScreenUpdateRunnable;
    private float mSdrScreenBrightness;
    private volatile boolean mStopped;

    private final class PhotonicModulator extends Thread {
        private static final float INITIAL_BACKLIGHT_FLOAT = Float.NaN;
        private static final int INITIAL_SCREEN_STATE = 0;
        private int mActualAodLevel;
        private float mActualBacklight;
        private float mActualSdrBacklight;
        private int mActualState;
        private boolean mBacklightChangeInProgress;
        private final Object mLock;
        private int mPendingAodLevel;
        private float mPendingBacklight;
        private float mPendingSdrBacklight;
        private int mPendingState;
        private boolean mStateChangeInProgress;
        final /* synthetic */ DisplayPowerState this$0;

        public PhotonicModulator(DisplayPowerState r2) {
            this.this$0 = r2;
            super("PhotonicModulator");
            this.mLock = new Object();
            this.mPendingState = 0;
            this.mPendingBacklight = Float.NaN;
            this.mPendingSdrBacklight = Float.NaN;
            this.mActualState = 0;
            this.mActualBacklight = Float.NaN;
            this.mActualSdrBacklight = Float.NaN;
            this.mPendingAodLevel = -1;
            this.mActualAodLevel = -1;
        }

        public boolean setState(int state, float brightnessState, float sdrBrightnessState) {
            return setState(state, brightnessState, sdrBrightnessState, -1);
        }

        public boolean setState(int state, float brightnessState, float sdrBrightnessState, int aodLevel) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r2 = false;
            if (state == this.mPendingState) goto L7;
            boolean stateChanged = true;
        L9:
            if (brightnessState != this.mPendingBacklight) goto L18;
            if (sdrBrightnessState != this.mPendingSdrBacklight) goto L18;
            if (aodLevel != this.mPendingAodLevel) goto L18;
            boolean backlightChanged = false;
        L20:
            if (stateChanged == true) goto L23;
            if (backlightChanged == true) goto L23;
        L49:
            boolean changeInProgress = this.mStateChangeInProgress;     // Catch: Throwable -> L16
            if (changeInProgress == true) goto L52;
            r2 = true;
        L52:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r2;
        L23:
            if (DisplayPowerState.m3796$$Nest$sfgetDEBUG() == false) goto L25;
            Slog.d(DisplayPowerState.TAG, "Requesting new screen state: state=" + Display.stateToString(state) + ", backlight=" + brightnessState);     // Catch: Throwable -> L16
        L25:
            this.mPendingState = state;     // Catch: Throwable -> L16
            this.mPendingBacklight = brightnessState;     // Catch: Throwable -> L16
            this.mPendingSdrBacklight = sdrBrightnessState;     // Catch: Throwable -> L16
            this.mPendingAodLevel = aodLevel;     // Catch: Throwable -> L16
            if (this.mStateChangeInProgress == true) goto L31;
            if (this.mBacklightChangeInProgress == true) goto L31;
            boolean changeInProgress2 = false;
        L33:
            if (stateChanged == true) goto L38;
            if (this.mStateChangeInProgress == true) goto L38;
            boolean r6 = false;
        L39:
            this.mStateChangeInProgress = r6;     // Catch: Throwable -> L16
            if (backlightChanged == true) goto L45;
            if (this.mBacklightChangeInProgress == true) goto L45;
            boolean r7 = false;
        L46:
            this.mBacklightChangeInProgress = r7;     // Catch: Throwable -> L16
            if (changeInProgress2 == true) goto L49;
            this.mLock.notifyAll();     // Catch: Throwable -> L16
        L45:
            r7 = true;
        L38:
            r6 = true;
        L31:
            changeInProgress2 = true;
        L18:
            backlightChanged = true;
            goto L20
        L7:
            stateChanged = false;
        L16:
            th = move-exception;
            throw th;
        }

        public void dump(PrintWriter pw) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            pw.println();     // Catch: Throwable -> L7
            pw.println("Photonic Modulator State:");     // Catch: Throwable -> L7
            pw.println("  mPendingState=" + Display.stateToString(this.mPendingState));     // Catch: Throwable -> L7
            pw.println("  mPendingBacklight=" + this.mPendingBacklight);     // Catch: Throwable -> L7
            pw.println("  mPendingSdrBacklight=" + this.mPendingSdrBacklight);     // Catch: Throwable -> L7
            pw.println("  mActualState=" + Display.stateToString(this.mActualState));     // Catch: Throwable -> L7
            pw.println("  mActualBacklight=" + this.mActualBacklight);     // Catch: Throwable -> L7
            pw.println("  mActualSdrBacklight=" + this.mActualSdrBacklight);     // Catch: Throwable -> L7
            pw.println("  mStateChangeInProgress=" + this.mStateChangeInProgress);     // Catch: Throwable -> L7
            pw.println("  mBacklightChangeInProgress=" + this.mBacklightChangeInProgress);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            Object r1 = this.mLock;
            monitor-enter(r1);
            int state = this.mPendingState;     // Catch: Throwable -> L16
            boolean changed = true;
            if (state == this.mActualState) goto L7;
            boolean r0 = true;
        L8:
            boolean stateChanged = r0;
            float brightnessState = this.mPendingBacklight;     // Catch: Throwable -> L16
            float sdrBrightnessState = this.mPendingSdrBacklight;     // Catch: Throwable -> L16
            int aodLevel = this.mPendingAodLevel;     // Catch: Throwable -> L16
            if (brightnessState != this.mActualBacklight) goto L18;
            if (sdrBrightnessState != this.mActualSdrBacklight) goto L18;
            if (aodLevel != this.mActualAodLevel) goto L18;
            boolean r2 = false;
        L19:
            boolean backlightChanged = r2;
            if (stateChanged == true) goto L22;
            DisplayPowerState.m3794$$Nest$mpostScreenUpdateThreadSafe(this.this$0);     // Catch: Throwable -> L16
            this.mStateChangeInProgress = false;     // Catch: Throwable -> L16
        L22:
            if (backlightChanged == true) goto L24;
            this.mBacklightChangeInProgress = false;     // Catch: Throwable -> L16
        L24:
            if (state != 0) goto L26;
        L28:
            boolean r3 = false;
        L29:
            boolean valid = r3;
            if (stateChanged == true) goto L34;
            if (backlightChanged == true) goto L34;
            changed = false;
        L34:
            if (valid == false) goto L43;
            if (changed == false) goto L43;
            this.mActualState = state;     // Catch: Throwable -> L16
            this.mActualBacklight = brightnessState;     // Catch: Throwable -> L16
            this.mActualSdrBacklight = sdrBrightnessState;     // Catch: Throwable -> L16
            this.mActualAodLevel = aodLevel;     // Catch: Throwable -> L16
            monitor-exit(r1);     // Catch: Throwable -> L16
            if (DisplayPowerState.m3796$$Nest$sfgetDEBUG() == false) goto L42;
            Slog.d(DisplayPowerState.TAG, "Updating screen state: id=" + DisplayPowerState.m3782$$Nest$fgetmDisplayId(this.this$0) + ", state=" + Display.stateToString(state) + ", backlight=" + brightnessState + ", sdrBacklight=" + sdrBrightnessState);
        L42:
            DisplayPowerState.m3778$$Nest$fgetmBlanker(this.this$0).requestDisplayState(DisplayPowerState.m3782$$Nest$fgetmDisplayId(this.this$0), state, brightnessState, sdrBrightnessState, aodLevel);
        L43:
            this.mStateChangeInProgress = false;     // Catch: Throwable -> L16
            this.mBacklightChangeInProgress = false;     // Catch: Throwable -> L16
            this.mLock.wait();     // Catch: Throwable -> L16 InterruptedException -> L46
        L51:
            monitor-exit(r1);     // Catch: Throwable -> L16
            goto L2
        L48:
            if (DisplayPowerState.m3788$$Nest$fgetmStopped(this.this$0) == false) goto L51;
            return;
        L26:
            if (Float.isNaN(brightnessState) == true) goto L28;
            r3 = true;
        L18:
            r2 = true;
            goto L19
        L7:
            r0 = false;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAodLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3777$$Nest$fgetmAodLevel(DisplayPowerState r0) {
        return r0.mAodLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBlanker, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayBlanker m3778$$Nest$fgetmBlanker(DisplayPowerState r0) {
        return r0.mBlanker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmColorFade, reason: not valid java name */
    static /* bridge */ /* synthetic */ ColorFade m3779$$Nest$fgetmColorFade(DisplayPowerState r0) {
        return r0.mColorFade;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmColorFadeLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3780$$Nest$fgetmColorFadeLevel(DisplayPowerState r0) {
        return r0.mColorFadeLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmColorFadePrepared, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3781$$Nest$fgetmColorFadePrepared(DisplayPowerState r0) {
        return r0.mColorFadePrepared;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3782$$Nest$fgetmDisplayId(DisplayPowerState r0) {
        return r0.mDisplayId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtDisplayPowerState m3783$$Nest$fgetmExt(DisplayPowerState r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhotonicModulator, reason: not valid java name */
    static /* bridge */ /* synthetic */ PhotonicModulator m3784$$Nest$fgetmPhotonicModulator(DisplayPowerState r0) {
        return r0.mPhotonicModulator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3785$$Nest$fgetmScreenBrightness(DisplayPowerState r0) {
        return r0.mScreenBrightness;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3786$$Nest$fgetmScreenState(DisplayPowerState r0) {
        return r0.mScreenState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSdrScreenBrightness, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3787$$Nest$fgetmSdrScreenBrightness(DisplayPowerState r0) {
        return r0.mSdrScreenBrightness;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3788$$Nest$fgetmStopped(DisplayPowerState r0) {
        return r0.mStopped;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmColorFadeDrawPending, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3789$$Nest$fputmColorFadeDrawPending(DisplayPowerState r0, boolean r1) {
        r0.mColorFadeDrawPending = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmColorFadeReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3790$$Nest$fputmColorFadeReady(DisplayPowerState r0, boolean r1) {
        r0.mColorFadeReady = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScreenReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3791$$Nest$fputmScreenReady(DisplayPowerState r0, boolean r1) {
        r0.mScreenReady = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScreenUpdatePending, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3792$$Nest$fputmScreenUpdatePending(DisplayPowerState r0, boolean r1) {
        r0.mScreenUpdatePending = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeCleanListenerIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3793$$Nest$minvokeCleanListenerIfNeeded(DisplayPowerState r0) {
        r0.invokeCleanListenerIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$mpostScreenUpdateThreadSafe, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3794$$Nest$mpostScreenUpdateThreadSafe(DisplayPowerState r0) {
        r0.postScreenUpdateThreadSafe();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCOUNTER_COLOR_FADE, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3795$$Nest$sfgetCOUNTER_COLOR_FADE() {
        return COUNTER_COLOR_FADE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3796$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        COUNTER_COLOR_FADE = "ColorFadeLevel";
        final String r1 = "electronBeamLevel";
        COLOR_FADE_LEVEL = new AnonymousClass1(r1);
        final String r2 = "screenBrightnessFloat";
        SCREEN_BRIGHTNESS_FLOAT = new AnonymousClass2(r2);
        final String r3 = "sdrScreenBrightnessFloat";
        SCREEN_SDR_BRIGHTNESS_FLOAT = new AnonymousClass3(r3);
    }

    DisplayPowerState(DisplayBlanker blanker, ColorFade colorFade, int displayId, int displayState) {
        this(blanker, colorFade, displayId, displayState, BackgroundThread.getExecutor());
    }

    DisplayPowerState(DisplayBlanker blanker, ColorFade colorFade, int displayId, int displayState, Executor asyncDestroyExecutor) {
        this.mScreenUpdateRunnable = new AnonymousClass4(this);
        this.mColorFadeDrawRunnable = new AnonymousClass5(this);
        this.mAodLevel = -1;
        this.mExt = (IExtDisplayPowerState) ExtImplFactory.getImpl(IExtDisplayPowerState.class, new Object[]{this});
        this.mHandler = new Handler(true);
        this.mChoreographer = Choreographer.getInstance();
        this.mBlanker = blanker;
        this.mColorFade = colorFade;
        this.mPhotonicModulator = new PhotonicModulator(this);
        this.mPhotonicModulator.start();
        this.mDisplayId = displayId;
        this.mAsyncDestroyExecutor = asyncDestroyExecutor;
        this.mScreenState = displayState;
        if (displayState == 1) goto L5;
        float r2 = 1.0f;
    L6:
        this.mScreenBrightness = r2;
        this.mSdrScreenBrightness = this.mScreenBrightness;
        scheduleScreenUpdate();
        this.mColorFadePrepared = false;
        this.mColorFadeLevel = 1.0f;
        this.mColorFadeReady = true;
        this.mExt.init(displayId);
        return;
    L5:
        r2 = -1.0f;
        goto L6
    }

    public void setScreenState(int state, int reason) {
        if (this.mScreenState != state) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.w(TAG, "setScreenState: state=" + Display.stateToString(state) + "; reason=" + Display.stateReasonToString(reason));
    L7:
        this.mExt.setScreenState(state, reason);
        this.mScreenState = state;
        this.mScreenReady = false;
        scheduleScreenUpdate();
    }

    public int getScreenState() {
        return this.mScreenState;
    }

    public void setSdrScreenBrightness(float brightness) {
        if (this.mSdrScreenBrightness != brightness) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "setSdrScreenBrightness: brightness=" + brightness);
    L7:
        this.mSdrScreenBrightness = brightness;
        if (this.mScreenState == 1) goto L12;
        this.mScreenReady = false;
        scheduleScreenUpdate();
        return;
    }

    public float getSdrScreenBrightness() {
        return this.mSdrScreenBrightness;
    }

    public void setScreenBrightness(float brightness) {
        if (this.mScreenBrightness != brightness) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "setScreenBrightness: brightness=" + brightness);
    L7:
        this.mScreenBrightness = brightness;
        if (this.mScreenState == 1) goto L12;
        this.mScreenReady = false;
        scheduleScreenUpdate();
        return;
    }

    public float getScreenBrightness() {
        return this.mScreenBrightness;
    }

    public boolean prepareColorFade(Context context, int mode) {
        if (this.mColorFade != null) goto L5;
    L9:
        this.mColorFadePrepared = false;
        this.mColorFadeReady = true;
        return false;
    L5:
        if (this.mColorFade.prepare(context, mode) == false) goto L9;
        this.mColorFadePrepared = true;
        this.mColorFadeReady = false;
        scheduleColorFadeDraw();
        return true;
    }

    public void dismissColorFade() {
        Trace.traceCounter(131072, COUNTER_COLOR_FADE, 100);
        if (this.mColorFade == null) goto L5;
        this.mColorFade.dismiss();
    L5:
        this.mColorFadePrepared = false;
        this.mColorFadeReady = true;
    }

    public void dismissColorFadeResources() {
        if (this.mColorFade == null) goto L6;
        this.mColorFade.dismissResources();
        return;
    }

    public void setColorFadeLevel(float level) {
        if (this.mColorFadeLevel != level) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "setColorFadeLevel: level=" + level);
    L7:
        this.mExt.setColorFadeLevel(level);
        this.mColorFadeLevel = level;
        if (this.mScreenState == 1) goto L11;
        this.mScreenReady = false;
        scheduleScreenUpdate();
    L11:
        if (this.mColorFadePrepared == false) goto L15;
        this.mColorFadeReady = false;
        scheduleColorFadeDraw();
        return;
    }

    public float getColorFadeLevel() {
        return this.mColorFadeLevel;
    }

    public boolean waitUntilClean(Runnable listener) {
        if (this.mScreenReady == true) goto L5;
    L9:
        this.mCleanListener = listener;
        return false;
    L5:
        if (this.mColorFadeReady == false) goto L9;
        this.mCleanListener = null;
        return true;
    }

    public void stop() {
        this.mStopped = true;
        this.mPhotonicModulator.interrupt();
        this.mColorFadePrepared = false;
        this.mColorFadeReady = true;
        if (this.mColorFade == null) goto L5;
        Executor r0 = this.mAsyncDestroyExecutor;
        final ColorFade r1 = this.mColorFade;
        r1.getClass();
        r0.execute(new DisplayPowerState$$ExternalSyntheticLambda0(r1));
    L5:
        this.mCleanListener = null;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void dump(PrintWriter pw) {
        pw.println("Display Power State:");
        pw.println("  mStopped=" + this.mStopped);
        pw.println("  mScreenState=" + Display.stateToString(this.mScreenState));
        pw.println("  mScreenBrightness=" + this.mScreenBrightness);
        pw.println("  mSdrScreenBrightness=" + this.mSdrScreenBrightness);
        pw.println("  mScreenReady=" + this.mScreenReady);
        pw.println("  mScreenUpdatePending=" + this.mScreenUpdatePending);
        pw.println("  mColorFadePrepared=" + this.mColorFadePrepared);
        pw.println("  mColorFadeLevel=" + this.mColorFadeLevel);
        pw.println("  mColorFadeReady=" + this.mColorFadeReady);
        pw.println("  mColorFadeDrawPending=" + this.mColorFadeDrawPending);
        this.mPhotonicModulator.dump(pw);
        if (this.mColorFade == null) goto L6;
        this.mColorFade.dump(pw);
        return;
    }

    void resetScreenState() {
        this.mScreenState = 0;
        this.mScreenReady = false;
    }

    private void scheduleScreenUpdate() {
        if (this.mScreenUpdatePending == true) goto L6;
        this.mScreenUpdatePending = true;
        postScreenUpdateThreadSafe();
        return;
    }

    private void postScreenUpdateThreadSafe() {
        this.mHandler.removeCallbacks(this.mScreenUpdateRunnable);
        this.mHandler.post(this.mScreenUpdateRunnable);
    }

    private void scheduleColorFadeDraw() {
        if (this.mColorFadeDrawPending == true) goto L6;
        this.mColorFadeDrawPending = true;
        this.mChoreographer.postCallback(3, this.mColorFadeDrawRunnable, null);
        return;
    }

    private void invokeCleanListenerIfNeeded() {
        Runnable listener = this.mCleanListener;
        if (listener != null) goto L5;
        return;
    L5:
        if (this.mScreenReady == true) goto L7;
        return;
    L7:
        if (this.mColorFadeReady == false) goto L12;
        this.mCleanListener = null;
        listener.run();
        return;
    }

    public void setAodLevel(int aodLevel) {
        if (this.mAodLevel == aodLevel) goto L8;
        Slog.d(TAG, "setAodLevel: aodLevel=" + aodLevel);
        this.mAodLevel = aodLevel;
        if (this.mScreenState == 1) goto L9;
        this.mScreenReady = false;
        scheduleScreenUpdate();
        return;
    L9:
        return;
    }
}
