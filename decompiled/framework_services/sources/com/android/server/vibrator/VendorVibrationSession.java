package com.android.server.vibrator;

import android.media.AudioAttributes;
import android.os.CancellationSignal;
import android.os.CombinedVibration;
import android.os.Handler;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.VibrationAttributes;
import android.os.vibrator.IVibrationSession;
import android.os.vibrator.IVibrationSessionCallback;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
final class VendorVibrationSession extends IVibrationSession.Stub implements VibrationSession, CancellationSignal.OnCancelListener, IBinder.DeathRecipient {
    private static final boolean DEBUG = false;
    private static final String TAG = "VendorVibrationSession";
    private final VendorCallbackWrapper mCallback;
    private final VibrationSession.CallerInfo mCallerInfo;
    private final ICancellationSignal mCancellationSignal;
    private VibrationStepConductor mConductor;
    private final long mCreateTime;
    private final long mCreateUptime;
    private final DeviceAdapter mDeviceAdapter;
    private VibrationSession.Status mEndStatusRequest;
    private long mEndTime;
    private long mEndUptime;
    private boolean mEndedByVendor;
    private final Handler mHandler;
    private final Object mLock;
    private final VibratorManagerHooks mManagerHooks;
    private final long mSessionId;
    private long mStartTime;
    private VibrationSession.Status mStatus;
    private final List<VibrationSession.DebugInfo> mVibrations;
    private final int[] mVibratorIds;

    /* JADX INFO: renamed from: com.android.server.vibrator.VendorVibrationSession$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$vibrator$VibrationSession$Status = null;

        static {
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status = new int[VibrationSession.Status.values().length];
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.FINISHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L124:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_UNSUPPORTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L132:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BINDER_DIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L142:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_APP_OPS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L98:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L104:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_SUPERSEDED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L126:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_FOREGROUND_USER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L140:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_SCREEN_OFF.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L146:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_SETTINGS_UPDATE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L94:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.CANCELLED_BY_UNKNOWN_REASON.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L116:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_APP_OPS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L134:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_BACKGROUND.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L138:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_EXTERNAL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L150:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_ONGOING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L110:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_POWER.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L122:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_SETTINGS.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L130:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_HIGHER_IMPORTANCE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
        L144:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_RINGER_MODE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L56
        L100:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FROM_VIRTUAL_DEVICE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L59
        L114:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_SUPERSEDED.ordinal()] = 20;     // Catch: NoSuchFieldError -> L62
        L120:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_MISSING_PERMISSION.ordinal()] = 21;     // Catch: NoSuchFieldError -> L65
        L136:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ON_WIRELESS_CHARGER.ordinal()] = 22;     // Catch: NoSuchFieldError -> L68
        L152:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.UNKNOWN.ordinal()] = 23;     // Catch: NoSuchFieldError -> L71
        L108:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ERROR_APP_OPS.ordinal()] = 24;     // Catch: NoSuchFieldError -> L74
        L112:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ERROR_CANCELLING.ordinal()] = 25;     // Catch: NoSuchFieldError -> L77
        L128:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ERROR_SCHEDULING.ordinal()] = 26;     // Catch: NoSuchFieldError -> L80
        L148:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ERROR_TOKEN.ordinal()] = 27;     // Catch: NoSuchFieldError -> L83
        L96:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.FORWARDED_TO_INPUT_DEVICES.ordinal()] = 28;     // Catch: NoSuchFieldError -> L86
        L106:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.FINISHED_UNEXPECTED.ordinal()] = 29;     // Catch: NoSuchFieldError -> L89
        L118:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.RUNNING.ordinal()] = 30;     // Catch: NoSuchFieldError -> L92
            return;
        }
    }

    static final class DebugInfoImpl implements VibrationSession.DebugInfo {
        private final VibrationSession.CallerInfo mCallerInfo;
        private final long mCreateTime;
        private final long mCreateUptime;
        private final long mDurationMs;
        private final long mEndTime;
        private final boolean mEndedByVendor;
        private final long mStartTime;
        private final VibrationSession.Status mStatus;
        private final List<VibrationSession.DebugInfo> mVibrations;

        DebugInfoImpl(VibrationSession.Status status, VibrationSession.CallerInfo callerInfo, long createUptime, long createTime, long startTime, long endUptime, long endTime, boolean endedByVendor, List<VibrationSession.DebugInfo> vibrations) {
            this.mStatus = status;
            this.mCallerInfo = callerInfo;
            this.mCreateUptime = createUptime;
            this.mCreateTime = createTime;
            this.mStartTime = startTime;
            this.mEndTime = endTime;
            this.mEndedByVendor = endedByVendor;
            if (endUptime <= 0) goto L5;
            long r10 = endUptime - createUptime;
        L6:
            this.mDurationMs = r10;
            if (vibrations != null) goto L9;
            ArrayList r11 = new ArrayList();
        L10:
            this.mVibrations = r11;
            return;
        L9:
            r11 = new ArrayList(vibrations);
            goto L10
        L5:
            r10 = -1;
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public VibrationSession.Status getStatus() {
            return this.mStatus;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public long getCreateUptimeMillis() {
            return this.mCreateUptime;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public VibrationSession.CallerInfo getCallerInfo() {
            return this.mCallerInfo;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public Object getDumpAggregationKey() {
            return null;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void logMetrics(VibratorFrameworkStatsLogger statsLogger) {
            if (this.mStartTime <= 0) goto L7;
            statsLogger.logVibrationVendorSessionStarted(this.mCallerInfo.uid);
            statsLogger.logVibrationVendorSessionVibrations(this.mCallerInfo.uid, this.mVibrations.size());
            if (this.mEndedByVendor == true) goto L7;
            statsLogger.logVibrationVendorSessionInterrupted(this.mCallerInfo.uid);
        L7:
            Iterator<VibrationSession.DebugInfo> r0 = this.mVibrations.iterator();
        L9:
            if (r0.hasNext() == false) goto L11;
            VibrationSession.DebugInfo vibration = r0.next();
            vibration.logMetrics(statsLogger);
            goto L9
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dump(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1112396529666L, this.mEndTime);
            proto.write(1112396529671L, this.mDurationMs);
            proto.write(1159641169928L, this.mStatus.ordinal());
            long attrsToken = proto.start(1146756268037L);
            VibrationAttributes attrs = this.mCallerInfo.attrs;
            proto.write(1120986464257L, attrs.getUsage());
            proto.write(1120986464258L, attrs.getAudioUsage());
            proto.write(1120986464259L, attrs.getFlags());
            proto.end(attrsToken);
            proto.end(token);
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dump(IndentingPrintWriter pw) {
            pw.println("VibrationSession:");
            pw.increaseIndent();
            pw.println("status = " + this.mStatus.name().toLowerCase(Locale.ROOT));
            pw.println("durationMs = " + this.mDurationMs);
            pw.println("createTime = " + VibrationSession.DebugInfo.formatTime(this.mCreateTime, true));
            pw.println("startTime = " + VibrationSession.DebugInfo.formatTime(this.mStartTime, true));
            StringBuilder r0 = new StringBuilder();
            r0.append("endTime = ");
            if (this.mEndTime != 0) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            pw.println(r0.toString());
            pw.println("callerInfo = " + this.mCallerInfo);
            pw.println("vibrations:");
            pw.increaseIndent();
            Iterator<VibrationSession.DebugInfo> r2 = this.mVibrations.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            VibrationSession.DebugInfo vibration = r2.next();
            vibration.dump(pw);
            goto L8
        L10:
            pw.decreaseIndent();
            pw.decreaseIndent();
            return;
        L5:
            r1 = VibrationSession.DebugInfo.formatTime(this.mEndTime, true);
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dumpCompact(IndentingPrintWriter pw) {
            Locale r0 = Locale.ROOT;
            String r4 = VibrationSession.DebugInfo.formatTime(this.mCreateTime, true);
            String r6 = this.mStatus.name().toLowerCase(Locale.ROOT);
            Long r7 = Long.valueOf(this.mDurationMs);
            String audioUsageStr = "";
            if (this.mStartTime != 0) goto L5;
            String r1 = "";
        L7:
            if (this.mEndTime != 0) goto L9;
            String r9 = "";
        L10:
            String timingsStr = String.format(r0, "%s | %8s | %20s | duration: %5dms | start: %12s | end: %12s", new Object[]{r4, "session", r6, r7, r1, r9});
            String paramStr = String.format(Locale.ROOT, " | flags: %4s | usage: %s", new Object[]{Long.toBinaryString(this.mCallerInfo.attrs.getFlags()), this.mCallerInfo.attrs.usageToString()});
            if (this.mCallerInfo.attrs.getOriginalAudioUsage() == 0) goto L14;
            audioUsageStr = " | audioUsage=" + AudioAttributes.usageToString(this.mCallerInfo.attrs.getOriginalAudioUsage());
        L14:
            String callerStr = String.format(Locale.ROOT, " | %s (uid=%d, deviceId=%d) | reason: %s", new Object[]{this.mCallerInfo.opPkg, Integer.valueOf(this.mCallerInfo.uid), Integer.valueOf(this.mCallerInfo.deviceId), this.mCallerInfo.reason});
            pw.println(timingsStr + paramStr + audioUsageStr + callerStr);
            pw.increaseIndent();
            Iterator<VibrationSession.DebugInfo> r5 = this.mVibrations.iterator();
        L16:
            if (r5.hasNext() == false) goto L18;
            VibrationSession.DebugInfo vibration = r5.next();
            vibration.dumpCompact(pw);
            goto L16
        L18:
            pw.decreaseIndent();
            return;
        L9:
            r9 = VibrationSession.DebugInfo.formatTime(this.mEndTime, false);
            goto L10
        L5:
            r1 = VibrationSession.DebugInfo.formatTime(this.mStartTime, false);
            goto L7
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("createTime: ");
            r0.append(VibrationSession.DebugInfo.formatTime(this.mCreateTime, true));
            r0.append(", startTime: ");
            r0.append(VibrationSession.DebugInfo.formatTime(this.mStartTime, true));
            r0.append(", endTime: ");
            if (this.mEndTime != 0) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            r0.append(", durationMs: ");
            r0.append(this.mDurationMs);
            r0.append(", status: ");
            r0.append(this.mStatus.name().toLowerCase(Locale.ROOT));
            r0.append(", callerInfo: ");
            r0.append(this.mCallerInfo);
            r0.append(", vibrations: ");
            r0.append(this.mVibrations);
            return r0.toString();
        L5:
            r1 = VibrationSession.DebugInfo.formatTime(this.mEndTime, true);
            goto L6
        }
    }

    private static final class VendorCallbackWrapper {
        private final IVibrationSessionCallback mCallback;
        private final Handler mHandler;
        private boolean mIsFinished;
        private boolean mIsFinishing;
        private boolean mIsStarted;

        public static /* synthetic */ void $r8$lambda$DzFVzhnn9_Dg1V8XR9BzA5RP8LY(VendorCallbackWrapper r0, IVibrationSession r1) {
            r0.lambda$notifyStarted$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$OCz4DcuEH-TvDslMxr5ilStYYs4, reason: not valid java name */
        public static /* synthetic */ void m9285$r8$lambda$OCz4DcuEHTvDslMxr5ilStYYs4(VendorCallbackWrapper r0) {
            r0.lambda$notifyFinishing$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$X_vfAw8b320msHKFfyL3-r3ZSgw, reason: not valid java name */
        public static /* synthetic */ void m9286$r8$lambda$X_vfAw8b320msHKFfyL3r3ZSgw(VendorCallbackWrapper r0, VibrationSession.Status r1) {
            r0.lambda$notifyFinished$2(r1);
        }

        VendorCallbackWrapper(IVibrationSessionCallback callback, Handler handler) {
            this.mCallback = callback;
            this.mHandler = handler;
        }

        synchronized IBinder getBinderToken() {
            monitor-enter(this);
            IBinder r0 = this.mCallback.asBinder();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean linkToDeath(IBinder.DeathRecipient recipient) {
            monitor-enter(this);
            this.mCallback.asBinder().linkToDeath(recipient, 0);     // Catch: Throwable -> L8 RemoteException -> L10
            monitor-exit(this);
            return true;
        L10:
            e = move-exception;
            Slog.e(VendorVibrationSession.TAG, "Error linking session to token death", e);     // Catch: Throwable -> L8
            return false;
        L8:
            th = move-exception;
            throw th;
        }

        synchronized void unlinkToDeath(IBinder.DeathRecipient recipient) {
            monitor-enter(this);
            this.mCallback.asBinder().unlinkToDeath(recipient, 0);     // Catch: Throwable -> L5 NoSuchElementException -> L7
        L9:
            monitor-exit(this);
            return;
        L7:
            e = move-exception;
            Slog.wtf(VendorVibrationSession.TAG, "Failed to unlink session to token death", e);     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            throw th;
        }

        synchronized void notifyStarted(final IVibrationSession session) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsStarted == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.mIsStarted = true;     // Catch: Throwable -> L11
            this.mHandler.post(new VendorVibrationSession$VendorCallbackWrapper$$ExternalSyntheticLambda0(this, session));     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        private /* synthetic */ void lambda$notifyStarted$0(IVibrationSession session) {
            this.mCallback.onStarted(session);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(VendorVibrationSession.TAG, "Error notifying vendor session started", e);
        }

        synchronized void notifyFinishing() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsStarted == true) goto L6;
        L15:
            monitor-exit(this);
            return;
        L6:
            if (this.mIsFinishing == true) goto L15;
            if (this.mIsFinished == true) goto L15;
            this.mIsFinishing = true;     // Catch: Throwable -> L13
            this.mHandler.post(new VendorVibrationSession$VendorCallbackWrapper$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L13
            monitor-exit(this);
        }

        private /* synthetic */ void lambda$notifyFinishing$1() {
            this.mCallback.onFinishing();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(VendorVibrationSession.TAG, "Error notifying vendor session is finishing", e);
        }

        synchronized void notifyFinished(final VibrationSession.Status status) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsFinished == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.mIsFinished = true;     // Catch: Throwable -> L11
            this.mHandler.post(new VendorVibrationSession$VendorCallbackWrapper$$ExternalSyntheticLambda1(this, status));     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        private /* synthetic */ void lambda$notifyFinished$2(VibrationSession.Status status) {
            this.mCallback.onFinished(toSessionStatus(status));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(VendorVibrationSession.TAG, "Error notifying vendor session finished", e);
        }

        private static int toSessionStatus(VibrationSession.Status status) {
            switch(AnonymousClass1.$SwitchMap$com$android$server$vibrator$VibrationSession$Status[status.ordinal()]) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L8;
                case 7: goto L8;
                case 8: goto L8;
                case 9: goto L8;
                case 10: goto L8;
                case 11: goto L7;
                case 12: goto L7;
                case 13: goto L7;
                case 14: goto L7;
                case 15: goto L7;
                case 16: goto L7;
                case 17: goto L7;
                case 18: goto L7;
                case 19: goto L7;
                case 20: goto L7;
                case 21: goto L7;
                case 22: goto L7;
                case 23: goto L6;
                case 24: goto L6;
                case 25: goto L6;
                case 26: goto L6;
                case 27: goto L6;
                case 28: goto L6;
                case 29: goto L6;
                case 30: goto L6;
                default: goto L5;
            };
        L6:
            return 5;
        L7:
            return 2;
        L8:
            return 4;
        L9:
            return 3;
        L10:
            return 1;
        L5:
            throw new RuntimeException(null, null);
        }
    }

    interface VibratorManagerHooks {
        void endSession(long r1, boolean r3);

        void onSessionReleased(long r1);

        void vibrate(long r1, VibrationSession.CallerInfo r3, CombinedVibration r4);
    }

    public static /* synthetic */ void $r8$lambda$78TjSb2_FhS6sp1cocyHsPZXfZA(VendorVibrationSession r0, VibrationSession.Status r1) {
        r0.lambda$notifySessionCallback$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$f9RRA3cYCdyJ3XVf10yBdu8rqz4(VendorVibrationSession r0) {
        r0.lambda$notifyStart$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$gw-uv4r3BzWmx_x5j7utc0ENh5U, reason: not valid java name */
    public static /* synthetic */ void m9284$r8$lambda$gwuv4r3BzWmx_x5j7utc0ENh5U(VendorVibrationSession r0, boolean r1) {
        r0.lambda$requestEndSession$2(r1);
    }

    static {
        DEBUG = VibratorDebugUtils.isDebuggable(TAG);
    }

    VendorVibrationSession(VibrationSession.CallerInfo callerInfo, Handler handler, VibratorManagerHooks managerHooks, DeviceAdapter deviceAdapter, IVibrationSessionCallback callback) {
        this.mLock = new Object();
        this.mSessionId = VibrationSession.nextSessionId();
        this.mCancellationSignal = CancellationSignal.createTransport();
        this.mVibrations = new ArrayList();
        this.mStatus = VibrationSession.Status.RUNNING;
        this.mCreateUptime = SystemClock.uptimeMillis();
        this.mCreateTime = System.currentTimeMillis();
        this.mVibratorIds = deviceAdapter.getAvailableVibratorIds();
        this.mHandler = handler;
        this.mCallback = new VendorCallbackWrapper(callback, handler);
        this.mCallerInfo = callerInfo;
        this.mManagerHooks = managerHooks;
        this.mDeviceAdapter = deviceAdapter;
        CancellationSignal.fromTransport(this.mCancellationSignal).setOnCancelListener(this);
    }

    public void vibrate(CombinedVibration vibration, String reason) {
        VibrationSession.CallerInfo vibrationCallerInfo = new VibrationSession.CallerInfo(this.mCallerInfo.attrs, this.mCallerInfo.uid, this.mCallerInfo.deviceId, this.mCallerInfo.opPkg, reason);
        this.mManagerHooks.vibrate(this.mSessionId, vibrationCallerInfo, vibration);
    }

    public void finishSession() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session finish requested, ending vibration session...");
    L5:
        requestEndSession(VibrationSession.Status.FINISHED, false, true);
    }

    public void cancelSession() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session cancel requested, aborting vibration session...");
    L5:
        requestEndSession(VibrationSession.Status.CANCELLED_BY_USER, true, true);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getSessionId() {
        return this.mSessionId;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public long getCreateUptimeMillis() {
        return this.mCreateUptime;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean isRepeating() {
        return false;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public VibrationSession.CallerInfo getCallerInfo() {
        return this.mCallerInfo;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public IBinder getCallerToken() {
        return this.mCallback.getBinderToken();
    }

    @Override // com.android.server.vibrator.VibrationSession
    public VibrationSession.DebugInfo getDebugInfo() {
        Object r2 = this.mLock;
        monitor-enter(r2);
        DebugInfoImpl r3 = new DebugInfoImpl(this.mStatus, this.mCallerInfo, this.mCreateUptime, this.mCreateTime, this.mStartTime, this.mEndUptime, this.mEndTime, this.mEndedByVendor, this.mVibrations);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean wasEndRequested() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mEndStatusRequest == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session cancellation signal received, aborting vibration session...");
    L5:
        requestEndSession(VibrationSession.Status.CANCELLED_BY_USER, true, true);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session binder died, aborting vibration session...");
    L5:
        requestEndSession(VibrationSession.Status.CANCELLED_BINDER_DIED, true, false);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public boolean linkToDeath() {
        return this.mCallback.linkToDeath(this);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void unlinkToDeath() {
        this.mCallback.unlinkToDeath(this);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void requestEnd(VibrationSession.Status status, VibrationSession.CallerInfo endedBy, boolean immediate) {
        requestEndSession(status, true, false);
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifyVibratorCallback(int vibratorId, long vibrationId, long stepId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Vibration callback received for vibration " + vibrationId + " step " + stepId + " on vibrator " + vibratorId + ", ignoring...");
        return;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySyncedVibratorsCallback(long vibrationId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Synced vibration callback received for vibration " + vibrationId + ", ignoring...");
        return;
    }

    @Override // com.android.server.vibrator.VibrationSession
    public void notifySessionCallback() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session callback received, ending vibration session...");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyEndRequestLocked(VibrationSession.Status.CANCELLED_BY_UNKNOWN_REASON, false);     // Catch: Throwable -> L10
        maybeSetStatusToRequestedLocked();     // Catch: Throwable -> L10
        clearVibrationConductor();     // Catch: Throwable -> L10
        final VibrationSession.Status endStatus = this.mStatus;     // Catch: Throwable -> L10
        this.mHandler.post(new VendorVibrationSession$$ExternalSyntheticLambda2(this, endStatus));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notifySessionCallback$0(VibrationSession.Status endStatus) {
        this.mManagerHooks.onSessionReleased(this.mSessionId);
        this.mCallback.notifyFinished(endStatus);
    }

    public String toString() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
        r1.append("createTime: ");     // Catch: Throwable -> L15
        r1.append(VibrationSession.DebugInfo.formatTime(this.mCreateTime, true));     // Catch: Throwable -> L15
        r1.append(", startTime: ");     // Catch: Throwable -> L15
        String r3 = null;
        if (this.mStartTime != 0) goto L7;
        String r2 = null;
    L8:
        r1.append(r2);     // Catch: Throwable -> L15
        r1.append(", endTime: ");     // Catch: Throwable -> L15
        if (this.mEndTime == 0) goto L12;
        r3 = VibrationSession.DebugInfo.formatTime(this.mEndTime, true);     // Catch: Throwable -> L15
    L12:
        r1.append(r3);     // Catch: Throwable -> L15
        r1.append(", status: ");     // Catch: Throwable -> L15
        r1.append(this.mStatus.name().toLowerCase(Locale.ROOT));     // Catch: Throwable -> L15
        r1.append(", callerInfo: ");     // Catch: Throwable -> L15
        r1.append(this.mCallerInfo);     // Catch: Throwable -> L15
        r1.append(", vibratorIds: ");     // Catch: Throwable -> L15
        r1.append(Arrays.toString(this.mVibratorIds));     // Catch: Throwable -> L15
        r1.append(", vibrations: ");     // Catch: Throwable -> L15
        r1.append(this.mVibrations);     // Catch: Throwable -> L15
        String r4 = r1.toString();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r4;
    L7:
        r2 = VibrationSession.DebugInfo.formatTime(this.mStartTime, true);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public VibrationSession.Status getStatus() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VibrationSession.Status r1 = this.mStatus;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isStarted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mStartTime <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean isEnded() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mEndTime <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public int[] getVibratorIds() {
        return this.mVibratorIds;
    }

    public List<VibrationSession.DebugInfo> getVibrations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mVibrations);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ICancellationSignal getCancellationSignal() {
        return this.mCancellationSignal;
    }

    public void notifyStart() {
        boolean isAlreadyEnded = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isEnded() == false) goto L8;
        isAlreadyEnded = true;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (isAlreadyEnded == true) goto L16;
        return;
    L16:
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "Session already ended after starting the HAL, aborting...");
    L18:
        this.mHandler.post(new VendorVibrationSession$$ExternalSyntheticLambda1(this));
        return;
    L8:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "Session started at the HAL");     // Catch: Throwable -> L10
    L12:
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        this.mCallback.notifyStarted(this);     // Catch: Throwable -> L10
        goto L13
    }

    private /* synthetic */ void lambda$notifyStart$1() {
        this.mManagerHooks.endSession(this.mSessionId, true);
    }

    public void notifyVibrationAttempt(VibrationSession.DebugInfo vibrationDebugInfo) {
        this.mVibrations.add(vibrationDebugInfo);
    }

    public VibrationStepConductor clearVibrationConductor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VibrationStepConductor conductor = this.mConductor;     // Catch: Throwable -> L7
        if (conductor == null) goto L9;
        this.mVibrations.add(conductor.getVibration().getDebugInfo());     // Catch: Throwable -> L7
    L9:
        this.mConductor = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return conductor;
    L7:
        th = move-exception;
        throw th;
    }

    public DeviceAdapter getDeviceAdapter() {
        return this.mDeviceAdapter;
    }

    public boolean maybeSetVibrationConductor(VibrationStepConductor conductor) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConductor != null) goto L7;
        this.mConductor = conductor;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L7:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Session still dispatching previous vibration, new vibration " + conductor.getVibration().id + " ignored");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    }

    private void requestEndSession(VibrationSession.Status status, final boolean shouldAbort, boolean isVendorRequest) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Session end request received with status " + status);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyEndRequestLocked(status, isVendorRequest);     // Catch: Throwable -> L14
        if (isEnded() == false) goto L10;
    L17:
        maybeSetStatusToRequestedLocked();     // Catch: Throwable -> L14
        this.mCallback.notifyFinished(this.mStatus);     // Catch: Throwable -> L14
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        if (isStarted() == false) goto L17;
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Requesting HAL session end with abort=" + shouldAbort);     // Catch: Throwable -> L14
    L16:
        this.mHandler.post(new VendorVibrationSession$$ExternalSyntheticLambda0(this, shouldAbort));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$requestEndSession$2(boolean shouldAbort) {
        this.mManagerHooks.endSession(this.mSessionId, shouldAbort);
    }

    private void notifyEndRequestLocked(VibrationSession.Status status, boolean isVendorRequest) {
        if (this.mEndStatusRequest == null) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Session end request accepted for status " + status);
    L8:
        this.mEndStatusRequest = status;
        this.mEndedByVendor = isVendorRequest;
        this.mCallback.notifyFinishing();
        if (this.mConductor == null) goto L16;
        VibrationStepConductor r0 = this.mConductor;
        Vibration.EndInfo r1 = new Vibration.EndInfo(status);
        if (status == VibrationSession.Status.FINISHED) goto L13;
        boolean r2 = true;
    L14:
        r0.notifyCancelled(r1, r2);
        return;
    L13:
        r2 = false;
        goto L14
    }

    private void maybeSetStatusToRequestedLocked() {
        if (isEnded() == false) goto L6;
        return;
    L6:
        if (this.mEndStatusRequest != null) goto L9;
        return;
    L9:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Session end request applied for status " + this.mEndStatusRequest);
    L11:
        this.mStatus = this.mEndStatusRequest;
        this.mEndTime = System.currentTimeMillis();
        this.mEndUptime = SystemClock.uptimeMillis();
    }
}
