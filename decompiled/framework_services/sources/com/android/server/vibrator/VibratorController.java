package com.android.server.vibrator;

import android.os.Binder;
import android.os.IVibratorStateListener;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.Trace;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.PwlePoint;
import android.os.vibrator.RampSegment;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import libcore.util.NativeAllocationRegistry;

/* JADX INFO: loaded from: classes3.dex */
final class VibratorController {
    private static final String TAG = "VibratorController";
    private volatile float mCurrentAmplitude;
    private volatile VibratorState mCurrentState;
    private final Object mLock;
    private final NativeWrapper mNativeWrapper;
    private volatile VibratorInfo mVibratorInfo;
    private volatile boolean mVibratorInfoLoadSuccessful;
    private final RemoteCallbackList<IVibratorStateListener> mVibratorStateListeners;

    public static class NativeWrapper {
        private long mNativePtr;

        private static native void alwaysOnDisable(long r0, long r2);

        private static native void alwaysOnEnable(long r0, long r2, long r4, long r6);

        private static native boolean getInfo(long r0, VibratorInfo.Builder r2);

        private static native long getNativeFinalizer();

        private static native boolean isAvailable(long r0);

        private static native long nativeInit(int r0, OnVibrationCompleteListener r1);

        private static native void off(long r0);

        private static native long on(long r0, long r2, long r4, long r6);

        private static native long performComposedEffect(long r0, PrimitiveSegment[] r2, long r3, long r5);

        private static native long performEffect(long r0, long r2, long r4, long r6, long r8);

        private static native long performPwleEffect(long r0, RampSegment[] r2, int r3, long r4, long r6);

        private static native long performPwleV2Effect(long r0, PwlePoint[] r2, long r3, long r5);

        private static native long performVendorEffect(long r0, Parcel r2, long r3, float r5, float r6, long r7, long r9);

        private static native void setAmplitude(long r0, float r2);

        private static native void setExternalControl(long r0, boolean r2);

        public NativeWrapper() {
            this.mNativePtr = 0;
        }

        public void init(int vibratorId, OnVibrationCompleteListener listener) {
            this.mNativePtr = nativeInit(vibratorId, listener);
            long finalizerPtr = getNativeFinalizer();
            if (finalizerPtr == 0) goto L6;
            NativeAllocationRegistry registry = NativeAllocationRegistry.createMalloced(VibratorController.class.getClassLoader(), finalizerPtr);
            registry.registerNativeAllocation(this, this.mNativePtr);
            return;
        }

        public boolean isAvailable() {
            return isAvailable(this.mNativePtr);
        }

        public long on(long milliseconds, long vibrationId, long stepId) {
            return on(this.mNativePtr, milliseconds, vibrationId, stepId);
        }

        public void off() {
            off(this.mNativePtr);
        }

        public void setAmplitude(float amplitude) {
            setAmplitude(this.mNativePtr, amplitude);
        }

        public long perform(long effect, long strength, long vibrationId, long stepId) {
            return performEffect(this.mNativePtr, effect, strength, vibrationId, stepId);
        }

        public long performVendorEffect(Parcel vendorData, long strength, float scale, float adaptiveScale, long vibrationId, long stepId) {
            return performVendorEffect(this.mNativePtr, vendorData, strength, scale, adaptiveScale, vibrationId, stepId);
        }

        public long compose(PrimitiveSegment[] primitives, long vibrationId, long stepId) {
            return performComposedEffect(this.mNativePtr, primitives, vibrationId, stepId);
        }

        public long composePwle(RampSegment[] primitives, int braking, long vibrationId, long stepId) {
            return performPwleEffect(this.mNativePtr, primitives, braking, vibrationId, stepId);
        }

        public long composePwleV2(PwlePoint[] pwlePoints, long vibrationId, long stepId) {
            return performPwleV2Effect(this.mNativePtr, pwlePoints, vibrationId, stepId);
        }

        public void setExternalControl(boolean enabled) {
            setExternalControl(this.mNativePtr, enabled);
        }

        public void alwaysOnEnable(long id, long effect, long strength) {
            alwaysOnEnable(this.mNativePtr, id, effect, strength);
        }

        public void alwaysOnDisable(long id) {
            alwaysOnDisable(this.mNativePtr, id);
        }

        public boolean getInfo(VibratorInfo.Builder infoBuilder) {
            return getInfo(this.mNativePtr, infoBuilder);
        }
    }

    public interface OnVibrationCompleteListener {
        void onComplete(int r1, long r2, long r4);
    }

    private static final enum VibratorState extends Enum<VibratorState> {
        private static final /* synthetic */ VibratorState[] $VALUES = null;
        public static final VibratorState IDLE = null;
        public static final VibratorState UNDER_EXTERNAL_CONTROL = null;
        public static final VibratorState VIBRATING = null;

        private static /* synthetic */ VibratorState[] $values() {
            return new VibratorState[]{IDLE, VIBRATING, UNDER_EXTERNAL_CONTROL};
        }

        private VibratorState(String r1, int r2) {
            super(r1, r2);
        }

        public static VibratorState valueOf(String name) {
            return (VibratorState) Enum.valueOf(VibratorState.class, name);
        }

        public static VibratorState[] values() {
            return (VibratorState[]) $VALUES.clone();
        }

        static {
            IDLE = new VibratorState("IDLE", 0);
            VIBRATING = new VibratorState("VIBRATING", 1);
            UNDER_EXTERNAL_CONTROL = new VibratorState("UNDER_EXTERNAL_CONTROL", 2);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ void $r8$lambda$SXJ48rSkhfxUkD7g1Dv0zSk83NY(VibratorController r0, boolean r1, IVibratorStateListener r2) {
        r0.lambda$updateStateAndNotifyListenersLocked$0(r1, r2);
    }

    VibratorController(int vibratorId, OnVibrationCompleteListener listener) {
        this(vibratorId, listener, new NativeWrapper());
    }

    VibratorController(int vibratorId, OnVibrationCompleteListener listener, NativeWrapper nativeWrapper) {
        this.mLock = new Object();
        this.mVibratorStateListeners = new RemoteCallbackList();
        this.mNativeWrapper = nativeWrapper;
        this.mNativeWrapper.init(vibratorId, listener);
        VibratorInfo.Builder vibratorInfoBuilder = new VibratorInfo.Builder(vibratorId);
        this.mVibratorInfoLoadSuccessful = this.mNativeWrapper.getInfo(vibratorInfoBuilder);
        this.mVibratorInfo = vibratorInfoBuilder.build();
        this.mCurrentState = VibratorState.IDLE;
        if (this.mVibratorInfoLoadSuccessful == true) goto L6;
        Slog.e(TAG, "Vibrator controller initialization failed to load some HAL info for vibrator " + vibratorId);
        return;
    }

    public boolean registerVibratorStateListener(IVibratorStateListener listener) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (this.mVibratorStateListeners.register(listener) == true) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return false;
    L12:
        notifyStateListener(listener, isVibrating(this.mCurrentState));     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return true;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean unregisterVibratorStateListener(IVibratorStateListener listener) {
        long token = Binder.clearCallingIdentity();
        boolean r2 = this.mVibratorStateListeners.unregister(listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void reloadVibratorInfoIfNeeded() {
        Trace.traceBegin(8388608, "VibratorController#reloadVibratorInfoIfNeeded");
    L24:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L4:
        if (this.mVibratorInfoLoadSuccessful == false) goto L7;
        Trace.traceEnd(8388608);
        return;
    L7:
        Object r0 = this.mLock;     // Catch: Throwable -> L24
        monitor-enter(r0);     // Catch: Throwable -> L24
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L10:
        if (this.mVibratorInfoLoadSuccessful == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
        Trace.traceEnd(8388608);
        return;
    L16:
        int vibratorId = this.mVibratorInfo.getId();     // Catch: Throwable -> L14
        VibratorInfo.Builder vibratorInfoBuilder = new VibratorInfo.Builder(vibratorId);     // Catch: Throwable -> L14
        this.mVibratorInfoLoadSuccessful = this.mNativeWrapper.getInfo(vibratorInfoBuilder);     // Catch: Throwable -> L14
        this.mVibratorInfo = vibratorInfoBuilder.build();     // Catch: Throwable -> L14
        if (this.mVibratorInfoLoadSuccessful == true) goto L19;
        Slog.e(TAG, "Failed retry of HAL getInfo for vibrator " + vibratorId);     // Catch: Throwable -> L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L14
        Trace.traceEnd(8388608);
    }

    boolean isVibratorInfoLoadSuccessful() {
        return this.mVibratorInfoLoadSuccessful;
    }

    public VibratorInfo getVibratorInfo() {
        return this.mVibratorInfo;
    }

    public boolean isVibrating() {
        return isVibrating(this.mCurrentState);
    }

    public float getCurrentAmplitude() {
        return this.mCurrentAmplitude;
    }

    public boolean hasCapability(long capability) {
        return this.mVibratorInfo.hasCapability(capability);
    }

    public boolean isAvailable() {
        Trace.traceBegin(8388608, "VibratorController#isAvailable");
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        boolean r3 = this.mNativeWrapper.isAvailable();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public void setExternalControl(boolean externalControl) {
        if (externalControl == false) goto L4;
        String r0 = "VibratorController#enableExternalControl";
    L5:
        Trace.traceBegin(8388608, r0);
    L13:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L7:
        if (this.mVibratorInfo.hasCapability(8) == true) goto L11;
        Trace.traceEnd(8388608);
        return;
    L11:
        if (externalControl == false) goto L15;
        VibratorState newState = VibratorState.UNDER_EXTERNAL_CONTROL;     // Catch: Throwable -> L13
    L16:
        Object r3 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r3);     // Catch: Throwable -> L13
        this.mNativeWrapper.setExternalControl(externalControl);     // Catch: Throwable -> L22
        updateStateAndNotifyListenersLocked(newState);     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        Trace.traceEnd(8388608);
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L15:
        newState = VibratorState.IDLE;     // Catch: Throwable -> L13
        goto L16
    L4:
        r0 = "VibratorController#disableExternalControl";
        goto L5
    }

    public void updateAlwaysOn(int id, PrebakedSegment prebaked) {
        Trace.traceBegin(8388608, "VibratorController#updateAlwaysOn");
    L19:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L4:
        if (this.mVibratorInfo.hasCapability(64) == true) goto L7;
        Trace.traceEnd(8388608);
        return;
    L7:
        Object r3 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r3);     // Catch: Throwable -> L19
        if (prebaked != null) goto L13;
        this.mNativeWrapper.alwaysOnDisable(id);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L11
        Trace.traceEnd(8388608);
        return;
    L13:
        this.mNativeWrapper.alwaysOnEnable(id, prebaked.getEffectId(), prebaked.getEffectStrength());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    }

    public void setAmplitude(float amplitude) {
        Trace.traceBegin(8388608, "VibratorController#setAmplitude");
        Object r0 = this.mLock;     // Catch: Throwable -> L18
        monitor-enter(r0);     // Catch: Throwable -> L18
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (this.mVibratorInfo.hasCapability(4) == false) goto L11;
        Slog.d(TAG, "setAmplitude=" + amplitude);     // Catch: Throwable -> L8
        this.mNativeWrapper.setAmplitude(amplitude);     // Catch: Throwable -> L8
    L11:
        if (this.mCurrentState != VibratorState.VIBRATING) goto L13;
        this.mCurrentAmplitude = amplitude;     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Trace.traceEnd(8388608);
        return;
    L18:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public long on(long milliseconds, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on");
        Object r3 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        long duration = this.mNativeWrapper.on(milliseconds, vibrationId, stepId);     // Catch: Throwable -> L8
        if (duration <= 0) goto L10;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L8
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L8
        Trace.traceEnd(8388608);
        return duration;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public long on(VibrationEffect.VendorEffect vendorEffect, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on (vendor)");
        Object r3 = this.mLock;
        monitor-enter(r3);
        Parcel vendorData = Parcel.obtain();     // Catch: Throwable -> L16
        vendorEffect.getVendorData().writeToParcel(vendorData, 0);     // Catch: Throwable -> L10
        vendorData.setDataPosition(0);     // Catch: Throwable -> L10
        long duration = this.mNativeWrapper.performVendorEffect(vendorData, vendorEffect.getEffectStrength(), vendorEffect.getScale(), vendorEffect.getAdaptiveScale(), vibrationId, stepId);     // Catch: Throwable -> L10
        if (duration <= 0) goto L13;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L10
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L10
    L13:
        vendorData.recycle();     // Catch: Throwable -> L16
        Trace.traceEnd(8388608);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        return duration;
    L10:
        th = move-exception;
        vendorData.recycle();     // Catch: Throwable -> L16
        Trace.traceEnd(8388608);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public long on(PrebakedSegment prebaked, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on (Prebaked)");
        Object r3 = this.mLock;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        Slog.d(TAG, "on perform id=" + prebaked.getEffectId() + " Strength=" + prebaked.getEffectStrength());     // Catch: Throwable -> L8
        long duration = this.mNativeWrapper.perform((long) prebaked.getEffectId(), (long) prebaked.getEffectStrength(), vibrationId, stepId);     // Catch: Throwable -> L8
        if (duration <= 0) goto L10;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L8
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L8
        Trace.traceEnd(8388608);
        return duration;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public long on(PrimitiveSegment[] primitives, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on (Primitive)");
    L20:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L5:
        if (this.mVibratorInfo.hasCapability(32) == true) goto L8;
        Trace.traceEnd(8388608);
        return 0;
    L8:
        Object r5 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r5);     // Catch: Throwable -> L20
        long duration = this.mNativeWrapper.compose(primitives, vibrationId, stepId);     // Catch: Throwable -> L13
        if (duration <= 0) goto L15;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L13
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return duration;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    }

    public long on(RampSegment[] primitives, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on (PWLE)");
    L20:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L5:
        if (this.mVibratorInfo.hasCapability(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == true) goto L8;
        Trace.traceEnd(8388608);
        return 0;
    L8:
        Object r6 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r6);     // Catch: Throwable -> L20
        int braking = this.mVibratorInfo.getDefaultBraking();     // Catch: Throwable -> L13
        long duration = this.mNativeWrapper.composePwle(primitives, braking, vibrationId, stepId);     // Catch: Throwable -> L13
        if (duration <= 0) goto L15;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L13
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r6);     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return duration;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    }

    public long on(PwlePoint[] pwlePoints, long vibrationId, long stepId) {
        Trace.traceBegin(8388608, "VibratorController#on (PWLE v2)");
    L20:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L5:
        if (this.mVibratorInfo.hasCapability(4096) == true) goto L8;
        Trace.traceEnd(8388608);
        return 0;
    L8:
        Object r5 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r5);     // Catch: Throwable -> L20
        long duration = this.mNativeWrapper.composePwleV2(pwlePoints, vibrationId, stepId);     // Catch: Throwable -> L13
        if (duration <= 0) goto L15;
        this.mCurrentAmplitude = -1.0f;     // Catch: Throwable -> L13
        updateStateAndNotifyListenersLocked(VibratorState.VIBRATING);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return duration;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    }

    public void off() {
        Trace.traceBegin(8388608, "VibratorController#off");
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        this.mNativeWrapper.off();     // Catch: Throwable -> L9
        this.mCurrentAmplitude = 0.0f;     // Catch: Throwable -> L9
        updateStateAndNotifyListenersLocked(VibratorState.IDLE);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Trace.traceEnd(8388608);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public void reset() {
        setExternalControl(false);
        off();
    }

    public String toString() {
        return "VibratorController{mVibratorInfo=" + this.mVibratorInfo + ", mVibratorInfoLoadSuccessful=" + this.mVibratorInfoLoadSuccessful + ", mCurrentState=" + this.mCurrentState.name() + ", mCurrentAmplitude=" + this.mCurrentAmplitude + ", mVibratorStateListeners count=" + this.mVibratorStateListeners.getRegisteredCallbackCount() + '}';
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("Vibrator (id=" + this.mVibratorInfo.getId() + "):");
        pw.increaseIndent();
        pw.println("currentState = " + this.mCurrentState.name());
        pw.println("currentAmplitude = " + this.mCurrentAmplitude);
        pw.println("vibratorInfoLoadSuccessful = " + this.mVibratorInfoLoadSuccessful);
        pw.println("vibratorStateListener size = " + this.mVibratorStateListeners.getRegisteredCallbackCount());
        this.mVibratorInfo.dump(pw);
        pw.decreaseIndent();
    }

    private void updateStateAndNotifyListenersLocked(VibratorState state) {
        boolean previousIsVibrating = isVibrating(this.mCurrentState);
        final boolean newIsVibrating = isVibrating(state);
        this.mCurrentState = state;
        if (previousIsVibrating == newIsVibrating) goto L6;
        this.mVibratorStateListeners.broadcast(new VibratorController$$ExternalSyntheticLambda0(this, newIsVibrating));
        return;
    }

    private /* synthetic */ void lambda$updateStateAndNotifyListenersLocked$0(boolean newIsVibrating, IVibratorStateListener listener) {
        notifyStateListener(listener, newIsVibrating);
    }

    private void notifyStateListener(IVibratorStateListener listener, boolean isVibrating) {
        listener.onVibrating(isVibrating);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Vibrator state listener failed to call", e);
    }

    private static boolean isVibrating(VibratorState state) {
        if (state == VibratorState.IDLE) goto L5;
        return true;
    L5:
        return false;
    }
}
