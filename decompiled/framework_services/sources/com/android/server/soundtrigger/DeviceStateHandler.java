package com.android.server.soundtrigger;

import com.android.server.utils.EventLogger;
import com.android.server.utils.PriorityDump;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceStateHandler implements PhoneCallStateHandler.Callback {
    public static final long CALL_INACTIVE_MSG_DELAY_MS = 1000;
    private final Executor mCallbackExecutor;
    private Set<DeviceStateListener> mCallbackSet;
    private final Executor mDelayedNotificationExecutor;
    private final EventLogger mEventLogger;
    private boolean mIsPhoneCallOngoing;
    private final Object mLock;
    private NotificationTask mPhoneStateChangePendingNotify;
    SoundTriggerDeviceState mSoundTriggerDeviceState;
    private int mSoundTriggerPowerSaveMode;

    private static class DeviceStateEvent extends EventLogger.Event {
        final SoundTriggerDeviceState mSoundTriggerDeviceState;

        DeviceStateEvent(SoundTriggerDeviceState soundTriggerDeviceState) {
            this.mSoundTriggerDeviceState = soundTriggerDeviceState;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "DeviceStateChange: " + this.mSoundTriggerDeviceState.name();
        }
    }

    public interface DeviceStateListener {
        void onSoundTriggerDeviceStateUpdate(SoundTriggerDeviceState r1);
    }

    private static class NotificationTask implements Runnable {
        private final CountDownLatch mCancelLatch;
        private final Runnable mRunnable;
        private final long mWaitInMillis;

        NotificationTask(Runnable r, long waitInMillis) {
            this.mCancelLatch = new CountDownLatch(1);
            this.mRunnable = r;
            this.mWaitInMillis = waitInMillis;
        }

        void cancel() {
            this.mCancelLatch.countDown();
        }

        boolean runnableEquals(Runnable runnable) {
            if (this.mRunnable != runnable) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
        L6:
            e = move-exception;
            Thread.currentThread().interrupt();
            throw new AssertionError("Unexpected InterruptedException", e);
        L3:
            if (this.mCancelLatch.await(this.mWaitInMillis, TimeUnit.MILLISECONDS) == true) goto L9;
            this.mRunnable.run();     // Catch: InterruptedException -> L6
            return;
        }
    }

    private static class PhoneCallEvent extends EventLogger.Event {
        final boolean mIsInPhoneCall;

        PhoneCallEvent(boolean isInPhoneCall) {
            this.mIsInPhoneCall = isInPhoneCall;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "PhoneCallChange - inPhoneCall: " + this.mIsInPhoneCall;
        }
    }

    public static final enum SoundTriggerDeviceState extends Enum<SoundTriggerDeviceState> {
        private static final /* synthetic */ SoundTriggerDeviceState[] $VALUES = null;
        public static final SoundTriggerDeviceState CRITICAL = null;
        public static final SoundTriggerDeviceState DISABLE = null;
        public static final SoundTriggerDeviceState ENABLE = null;

        private static /* synthetic */ SoundTriggerDeviceState[] $values() {
            return new SoundTriggerDeviceState[]{DISABLE, CRITICAL, ENABLE};
        }

        private SoundTriggerDeviceState(String r1, int r2) {
            super(r1, r2);
        }

        public static SoundTriggerDeviceState valueOf(String name) {
            return (SoundTriggerDeviceState) Enum.valueOf(SoundTriggerDeviceState.class, name);
        }

        public static SoundTriggerDeviceState[] values() {
            return (SoundTriggerDeviceState[]) $VALUES.clone();
        }

        static {
            DISABLE = new SoundTriggerDeviceState("DISABLE", 0);
            CRITICAL = new SoundTriggerDeviceState(PriorityDump.PRIORITY_ARG_CRITICAL, 1);
            ENABLE = new SoundTriggerDeviceState("ENABLE", 2);
            $VALUES = $values();
        }
    }

    private static class SoundTriggerPowerEvent extends EventLogger.Event {
        final int mSoundTriggerPowerState;

        SoundTriggerPowerEvent(int soundTriggerPowerState) {
            this.mSoundTriggerPowerState = soundTriggerPowerState;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "SoundTriggerPowerChange: " + stateToString();
        }

        private String stateToString() {
            switch(this.mSoundTriggerPowerState) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L9;
            };
        L5:
            return "All disabled";
        L6:
            return "Critical only";
        L7:
            return "All enabled";
        L9:
            return "Unknown power state: " + this.mSoundTriggerPowerState;
        }
    }

    public static /* synthetic */ void $r8$lambda$eB3dX0zZ1hqEZb49BnztDtI9vWg(DeviceStateListener r0, SoundTriggerDeviceState r1) {
        lambda$evaluateStateChange$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$iBPDPb3N-SdXvbaWQfIqTLFiNjk, reason: not valid java name */
    public static /* synthetic */ void m8176$r8$lambda$iBPDPb3NSdXvbaWQfIqTLFiNjk(DeviceStateListener r0, SoundTriggerDeviceState r1) {
        lambda$registerListener$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8177$$Nest$fgetmLock(DeviceStateHandler r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhoneStateChangePendingNotify, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationTask m8178$$Nest$fgetmPhoneStateChangePendingNotify(DeviceStateHandler r0) {
        return r0.mPhoneStateChangePendingNotify;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPhoneStateChangePendingNotify, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8179$$Nest$fputmPhoneStateChangePendingNotify(DeviceStateHandler r0, NotificationTask r1) {
        r0.mPhoneStateChangePendingNotify = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateStateChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8180$$Nest$mevaluateStateChange(DeviceStateHandler r0) {
        r0.evaluateStateChange();
    }

    public void onPowerModeChanged(int soundTriggerPowerSaveMode) {
        this.mEventLogger.enqueue(new SoundTriggerPowerEvent(soundTriggerPowerSaveMode));
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (soundTriggerPowerSaveMode != this.mSoundTriggerPowerSaveMode) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mSoundTriggerPowerSaveMode = soundTriggerPowerSaveMode;     // Catch: Throwable -> L8
        evaluateStateChange();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.soundtrigger.PhoneCallStateHandler.Callback
    public void onPhoneCallStateChanged(boolean isInPhoneCall) {
        this.mEventLogger.enqueue(new PhoneCallEvent(isInPhoneCall));
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsPhoneCallOngoing != isInPhoneCall) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mPhoneStateChangePendingNotify == null) goto L13;
        this.mPhoneStateChangePendingNotify.cancel();     // Catch: Throwable -> L8
        this.mPhoneStateChangePendingNotify = null;     // Catch: Throwable -> L8
    L13:
        this.mIsPhoneCallOngoing = isInPhoneCall;     // Catch: Throwable -> L8
        if (this.mIsPhoneCallOngoing == true) goto L16;
        this.mPhoneStateChangePendingNotify = new NotificationTask(new AnonymousClass1(this), 1000);     // Catch: Throwable -> L8
        this.mDelayedNotificationExecutor.execute(this.mPhoneStateChangePendingNotify);     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        evaluateStateChange();     // Catch: Throwable -> L8
        goto L17
    }

    public DeviceStateHandler(Executor callbackExecutor, EventLogger eventLogger) {
        this.mLock = new Object();
        this.mSoundTriggerDeviceState = SoundTriggerDeviceState.ENABLE;
        this.mSoundTriggerPowerSaveMode = 0;
        this.mIsPhoneCallOngoing = false;
        this.mPhoneStateChangePendingNotify = null;
        this.mCallbackSet = ConcurrentHashMap.newKeySet(4);
        this.mDelayedNotificationExecutor = Executors.newSingleThreadExecutor();
        callbackExecutor.getClass();
        this.mCallbackExecutor = callbackExecutor;
        eventLogger.getClass();
        this.mEventLogger = eventLogger;
    }

    public SoundTriggerDeviceState getDeviceState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SoundTriggerDeviceState r1 = this.mSoundTriggerDeviceState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerListener(final DeviceStateListener callback) {
        final SoundTriggerDeviceState state = getDeviceState();
        this.mCallbackExecutor.execute(new DeviceStateHandler$$ExternalSyntheticLambda0(callback, state));
        this.mCallbackSet.add(callback);
    }

    private static /* synthetic */ void lambda$registerListener$0(DeviceStateListener callback, SoundTriggerDeviceState state) {
        callback.onSoundTriggerDeviceStateUpdate(state);
    }

    public void unregisterListener(DeviceStateListener callback) {
        this.mCallbackSet.remove(callback);
    }

    void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("DeviceState: " + this.mSoundTriggerDeviceState.name());     // Catch: Throwable -> L7
        pw.println("PhoneState: " + this.mIsPhoneCallOngoing);     // Catch: Throwable -> L7
        pw.println("PowerSaveMode: " + this.mSoundTriggerPowerSaveMode);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void evaluateStateChange() {
        SoundTriggerDeviceState newState = computeState();
        if (this.mPhoneStateChangePendingNotify == null) goto L5;
        return;
    L5:
        if (this.mSoundTriggerDeviceState == newState) goto L14;
        this.mSoundTriggerDeviceState = newState;
        this.mEventLogger.enqueue(new DeviceStateEvent(this.mSoundTriggerDeviceState));
        final SoundTriggerDeviceState state = this.mSoundTriggerDeviceState;
        Iterator<DeviceStateListener> r2 = this.mCallbackSet.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        final DeviceStateListener callback = r2.next();
        this.mCallbackExecutor.execute(new DeviceStateHandler$$ExternalSyntheticLambda1(callback, state));
        goto L9
    L11:
        return;
    }

    private static /* synthetic */ void lambda$evaluateStateChange$1(DeviceStateListener callback, SoundTriggerDeviceState state) {
        callback.onSoundTriggerDeviceStateUpdate(state);
    }

    private SoundTriggerDeviceState computeState() {
        if (this.mIsPhoneCallOngoing == false) goto L7;
        return SoundTriggerDeviceState.DISABLE;
    L7:
        switch(this.mSoundTriggerPowerSaveMode) {
            case 0: goto L13;
            case 1: goto L15;
            case 2: goto L14;
            default: goto L9;
        };
    L9:
        throw new IllegalStateException("Received unexpected power state code" + this.mSoundTriggerPowerSaveMode);
    L14:
        return SoundTriggerDeviceState.DISABLE;
    L15:
        return SoundTriggerDeviceState.CRITICAL;
    L13:
        return SoundTriggerDeviceState.ENABLE;
    }
}
