package com.android.server.dreams;

import android.R;
import android.app.ActivityTaskManager;
import android.app.BroadcastOptions;
import android.app.IAppTask;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.service.dreams.DreamService;
import android.service.dreams.IDreamService;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class DreamController {
    private static final String DREAMING_DELIVERY_GROUP_KEY = null;
    private static final String DREAMING_DELIVERY_GROUP_NAMESPACE = null;
    private static final int DREAM_CONNECTION_TIMEOUT = 5000;
    private static final int DREAM_FINISH_TIMEOUT = 5000;
    private static final String EXTRA_REASON_KEY = "reason";
    private static final String EXTRA_REASON_VALUE = "dream";
    private static final String TAG = "DreamController";
    private final ActivityTaskManager mActivityTaskManager;
    private final Intent mCloseNotificationShadeIntent;
    private final Bundle mCloseNotificationShadeOptions;
    private final Context mContext;
    private DreamRecord mCurrentDream;
    private final Intent mDreamingStartedIntent;
    private final Bundle mDreamingStartedStoppedOptions;
    private final Intent mDreamingStoppedIntent;
    private final Handler mHandler;
    private final Listener mListener;
    private final PowerManager mPowerManager;
    private final ArrayList<DreamRecord> mPreviousDreams;
    private final boolean mResetScreenTimeoutOnUnexpectedDreamExit;
    private boolean mSentStartBroadcast;

    private final class DreamRecord implements IBinder.DeathRecipient, ServiceConnection {
        public IAppTask mAppTask;
        public boolean mBound;
        public final boolean mCanDoze;
        public boolean mConnected;
        private boolean mDreamIsObscured;
        private long mDreamStartTime;
        private final IRemoteCallback mDreamingStartedCallback;
        public final boolean mIsPreviewMode;
        public final ComponentName mName;
        private final Runnable mReleaseWakeLockIfNeeded;
        public IDreamService mService;
        private final Runnable mStopPreviousDreamsIfNeeded;
        private String mStopReason;
        private final Runnable mStopStubbornDreamRunnable;
        private final Runnable mStopUnconnectedDreamRunnable;
        public final Binder mToken;
        public final int mUserId;
        public PowerManager.WakeLock mWakeLock;
        public boolean mWakingGently;
        final /* synthetic */ DreamController this$0;

        public static /* synthetic */ void $r8$lambda$0dZk_9NvDR3x53aKK_IeEsJQuSk(DreamRecord r0, IBinder r1) {
            r0.lambda$onServiceConnected$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$Skr7f1qhnwF4vzCPd5Ay9Te7IWU(DreamRecord r0) {
            r0.lambda$new$1();
        }

        public static /* synthetic */ void $r8$lambda$X0EFHI4eKxvwQqFLtcNIA3oV6dA(DreamRecord r0) {
            r0.lambda$onServiceDisconnected$4();
        }

        public static /* synthetic */ void $r8$lambda$geq5JavYTREAgfuv_JBWhoPZgeA(DreamRecord r0) {
            r0.lambda$new$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$lRUHH2HyR-uXlQCXn_ZiXFC2rTE, reason: not valid java name */
        public static /* synthetic */ void m4161$r8$lambda$lRUHH2HyRuXlQCXn_ZiXFC2rTE(DreamRecord r0) {
            r0.lambda$binderDied$2();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDreamStartTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m4162$$Nest$fgetmDreamStartTime(DreamRecord r2) {
            return r2.mDreamStartTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDreamingStartedCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IRemoteCallback m4163$$Nest$fgetmDreamingStartedCallback(DreamRecord r0) {
            return r0.mDreamingStartedCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReleaseWakeLockIfNeeded, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m4164$$Nest$fgetmReleaseWakeLockIfNeeded(DreamRecord r0) {
            return r0.mReleaseWakeLockIfNeeded;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStopPreviousDreamsIfNeeded, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m4165$$Nest$fgetmStopPreviousDreamsIfNeeded(DreamRecord r0) {
            return r0.mStopPreviousDreamsIfNeeded;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStopReason, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4166$$Nest$fgetmStopReason(DreamRecord r0) {
            return r0.mStopReason;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStopStubbornDreamRunnable, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m4167$$Nest$fgetmStopStubbornDreamRunnable(DreamRecord r0) {
            return r0.mStopStubbornDreamRunnable;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStopUnconnectedDreamRunnable, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m4168$$Nest$fgetmStopUnconnectedDreamRunnable(DreamRecord r0) {
            return r0.mStopUnconnectedDreamRunnable;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDreamIsObscured, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4169$$Nest$fputmDreamIsObscured(DreamRecord r0, boolean r1) {
            r0.mDreamIsObscured = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDreamStartTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4170$$Nest$fputmDreamStartTime(DreamRecord r0, long r1) {
            r0.mDreamStartTime = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmStopReason, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4171$$Nest$fputmStopReason(DreamRecord r0, String r1) {
            r0.mStopReason = r1;
        }

        private /* synthetic */ void lambda$new$0() {
            if (this.mBound == true) goto L5;
            return;
        L5:
            if (this.mConnected == true) goto L9;
            Slog.w(DreamController.TAG, "Bound dream did not connect in the time allotted");
            this.this$0.stopDream(true, "slow to connect");
            return;
        }

        private /* synthetic */ void lambda$new$1() {
            Slog.w(DreamController.TAG, "Stubborn dream did not finish itself in the time allotted");
            this.this$0.stopDream(true, "slow to finish");
            this.mStopReason = null;
        }

        DreamRecord(DreamController r4, Binder token, ComponentName name, boolean isPreviewMode, boolean canDoze, int userId, PowerManager.WakeLock wakeLock) {
            this.this$0 = r4;
            this.mStopPreviousDreamsIfNeeded = new DreamController$DreamRecord$$ExternalSyntheticLambda1(this);
            this.mReleaseWakeLockIfNeeded = new DreamController$DreamRecord$$ExternalSyntheticLambda2(this);
            this.mStopUnconnectedDreamRunnable = new DreamController$DreamRecord$$ExternalSyntheticLambda3(this);
            this.mStopStubbornDreamRunnable = new DreamController$DreamRecord$$ExternalSyntheticLambda4(this);
            this.mDreamingStartedCallback = new AnonymousClass1(this);
            this.mToken = token;
            this.mName = name;
            this.mIsPreviewMode = isPreviewMode;
            this.mCanDoze = canDoze;
            this.mUserId = userId;
            this.mWakeLock = wakeLock;
            if (this.mWakeLock == null) goto L5;
            this.mWakeLock.acquire();
        L5:
            DreamController.m4156$$Nest$fgetmHandler(r4).postDelayed(this.mReleaseWakeLockIfNeeded, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            DreamController.m4156$$Nest$fgetmHandler(this.this$0).post(new DreamController$DreamRecord$$ExternalSyntheticLambda6(this));
        }

        private /* synthetic */ void lambda$binderDied$2() {
            this.mService = null;
            if (DreamController.m4155$$Nest$fgetmCurrentDream(this.this$0) == this) goto L5;
            return;
        L5:
            if (DreamController.m4157$$Nest$fgetmResetScreenTimeoutOnUnexpectedDreamExit(this.this$0) == false) goto L7;
            DreamController.m4159$$Nest$mresetScreenTimeout(this.this$0);
        L7:
            this.this$0.stopDream(true, "binder died");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, final IBinder service) {
            DreamController.m4156$$Nest$fgetmHandler(this.this$0).post(new DreamController$DreamRecord$$ExternalSyntheticLambda0(this, service));
        }

        private /* synthetic */ void lambda$onServiceConnected$3(IBinder service) {
            this.mConnected = true;
            if (DreamController.m4155$$Nest$fgetmCurrentDream(this.this$0) == this) goto L5;
        L7:
            releaseWakeLockIfNeeded();
            return;
        L5:
            if (this.mService != null) goto L7;
            DreamController.m4158$$Nest$mattach(this.this$0, IDreamService.Stub.asInterface(service));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            DreamController.m4156$$Nest$fgetmHandler(this.this$0).post(new DreamController$DreamRecord$$ExternalSyntheticLambda5(this));
        }

        private /* synthetic */ void lambda$onServiceDisconnected$4() {
            this.mService = null;
            if (DreamController.m4155$$Nest$fgetmCurrentDream(this.this$0) == this) goto L5;
            return;
        L5:
            if (DreamController.m4157$$Nest$fgetmResetScreenTimeoutOnUnexpectedDreamExit(this.this$0) == false) goto L7;
            DreamController.m4159$$Nest$mresetScreenTimeout(this.this$0);
        L7:
            this.this$0.stopDream(true, "service disconnected");
        }

        void stopPreviousDreamsIfNeeded() {
            if (DreamController.m4155$$Nest$fgetmCurrentDream(this.this$0) != this) goto L6;
            DreamController.m4160$$Nest$mstopPreviousDreams(this.this$0);
            return;
        }

        void releaseWakeLockIfNeeded() {
            if (this.mWakeLock == null) goto L6;
            this.mWakeLock.release();
            this.mWakeLock = null;
            DreamController.m4156$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mReleaseWakeLockIfNeeded);
            return;
        }

        boolean dreamIsFrontmost() {
            return !this.mDreamIsObscured;
        }
    }

    public interface Listener {
        void onDreamStarted(Binder r1);

        void onDreamStopped(Binder r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentDream, reason: not valid java name */
    static /* bridge */ /* synthetic */ DreamRecord m4155$$Nest$fgetmCurrentDream(DreamController r0) {
        return r0.mCurrentDream;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4156$$Nest$fgetmHandler(DreamController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResetScreenTimeoutOnUnexpectedDreamExit, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4157$$Nest$fgetmResetScreenTimeoutOnUnexpectedDreamExit(DreamController r0) {
        return r0.mResetScreenTimeoutOnUnexpectedDreamExit;
    }

    /* JADX INFO: renamed from: -$$Nest$mattach, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4158$$Nest$mattach(DreamController r0, IDreamService r1) {
        r0.attach(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetScreenTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4159$$Nest$mresetScreenTimeout(DreamController r0) {
        r0.resetScreenTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopPreviousDreams, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4160$$Nest$mstopPreviousDreams(DreamController r0) {
        r0.stopPreviousDreams();
    }

    static {
        DREAMING_DELIVERY_GROUP_NAMESPACE = UUID.randomUUID().toString();
        DREAMING_DELIVERY_GROUP_KEY = UUID.randomUUID().toString();
    }

    public DreamController(Context context, Handler handler, Listener listener) {
        this.mDreamingStartedIntent = new Intent("android.intent.action.DREAMING_STARTED").addFlags(1342177280);
        this.mDreamingStoppedIntent = new Intent("android.intent.action.DREAMING_STOPPED").addFlags(1342177280);
        this.mDreamingStartedStoppedOptions = createDreamingStartedStoppedOptions();
        this.mSentStartBroadcast = false;
        this.mPreviousDreams = new ArrayList();
        this.mContext = context;
        this.mHandler = handler;
        this.mListener = listener;
        this.mActivityTaskManager = (ActivityTaskManager) this.mContext.getSystemService(ActivityTaskManager.class);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mCloseNotificationShadeIntent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.mCloseNotificationShadeIntent.putExtra("reason", EXTRA_REASON_VALUE);
        this.mCloseNotificationShadeIntent.addFlags(268435456);
        this.mCloseNotificationShadeOptions = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeliveryGroupMatchingKey("android.intent.action.CLOSE_SYSTEM_DIALOGS", EXTRA_REASON_VALUE).setDeferralPolicy(2).toBundle();
        this.mResetScreenTimeoutOnUnexpectedDreamExit = context.getResources().getBoolean(R.bool.config_satellite_modem_support_concurrent_tn_scanning);
    }

    private Bundle createDreamingStartedStoppedOptions() {
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setDeliveryGroupPolicy(1);
        options.setDeliveryGroupMatchingKey(DREAMING_DELIVERY_GROUP_NAMESPACE, DREAMING_DELIVERY_GROUP_KEY);
        options.setDeferralPolicy(2);
        return options.toBundle();
    }

    public void dump(PrintWriter pw) {
        pw.println("Dreamland:");
        if (this.mCurrentDream == null) goto L5;
        pw.println("  mCurrentDream:");
        pw.println("    mToken=" + this.mCurrentDream.mToken);
        pw.println("    mName=" + this.mCurrentDream.mName);
        pw.println("    mIsPreviewMode=" + this.mCurrentDream.mIsPreviewMode);
        pw.println("    mCanDoze=" + this.mCurrentDream.mCanDoze);
        pw.println("    mUserId=" + this.mCurrentDream.mUserId);
        pw.println("    mBound=" + this.mCurrentDream.mBound);
        pw.println("    mService=" + this.mCurrentDream.mService);
        pw.println("    mWakingGently=" + this.mCurrentDream.mWakingGently);
    L6:
        pw.println("  mSentStartBroadcast=" + this.mSentStartBroadcast);
        return;
    L5:
        pw.println("  mCurrentDream: null");
        goto L6
    }

    public void startDream(Binder token, ComponentName name, boolean isPreviewMode, boolean canDoze, int userId, PowerManager.WakeLock wakeLock, ComponentName overlayComponentName, String reason) {
        Trace.traceBegin(131072, "startDream");
        this.mContext.sendBroadcastAsUser(this.mCloseNotificationShadeIntent, UserHandle.ALL, null, this.mCloseNotificationShadeOptions);     // Catch: Throwable -> L40
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L40
        r0.append("Starting dream: name=");     // Catch: Throwable -> L40
        r0.append(name);     // Catch: Throwable -> L40
        r0.append(", isPreviewMode=");     // Catch: Throwable -> L40
        r0.append(isPreviewMode);     // Catch: Throwable -> L40
        r0.append(", canDoze=");     // Catch: Throwable -> L40
        r0.append(canDoze);     // Catch: Throwable -> L40
        r0.append(", userId=");     // Catch: Throwable -> L40
        r0.append(userId);     // Catch: Throwable -> L40
        r0.append(", reason='");     // Catch: Throwable -> L40
        r0.append(reason);     // Catch: Throwable -> L10
        r0.append("'");     // Catch: Throwable -> L10
        Slog.i(TAG, r0.toString());     // Catch: Throwable -> L10
        DreamRecord oldDream = this.mCurrentDream;     // Catch: Throwable -> L10
        this.mCurrentDream = new DreamRecord(this, token, name, isPreviewMode, canDoze, userId, wakeLock);     // Catch: Throwable -> L10
        if (oldDream != null) goto L8;
    L13:
        DreamRecord.m4170$$Nest$fputmDreamStartTime(this.mCurrentDream, SystemClock.elapsedRealtime());     // Catch: Throwable -> L10
        Context r1 = this.mContext;     // Catch: Throwable -> L10
        if (this.mCurrentDream.mCanDoze == false) goto L16;
        int r4 = FrameworkStatsLog.EXCLUSION_RECT_STATE_CHANGED;
    L17:
        MetricsLogger.visible(r1, r4);     // Catch: Throwable -> L10
        Intent intent = new Intent("android.service.dreams.DreamService");     // Catch: Throwable -> L10
        intent.setComponent(name);     // Catch: Throwable -> L10
        intent.addFlags(8388608);     // Catch: Throwable -> L10
        DreamService.setDreamOverlayComponent(intent, overlayComponentName);     // Catch: Throwable -> L25
    L27:
        ex = move-exception;
        Slog.e(TAG, "Unable to bind dream service: " + intent, ex);     // Catch: Throwable -> L25
        stopDream(true, "unable to bind service: SecExp.");     // Catch: Throwable -> L25
        Trace.traceEnd(131072);
        return;
    L21:
        if (this.mContext.bindServiceAsUser(intent, this.mCurrentDream, AudioFormat.AAC_MAIN, new UserHandle(userId)) == true) goto L31;
        Slog.e(TAG, "Unable to bind dream service: " + intent);     // Catch: Throwable -> L25 SecurityException -> L27
        stopDream(true, "bindService failed");     // Catch: Throwable -> L25 SecurityException -> L27
        Trace.traceEnd(131072);
        return;
    L31:
        if (this.mCurrentDream == null) goto L33;
        this.mCurrentDream.mBound = true;     // Catch: Throwable -> L25
    L33:
        this.mHandler.postDelayed(DreamRecord.m4168$$Nest$fgetmStopUnconnectedDreamRunnable(this.mCurrentDream), 5000);     // Catch: Throwable -> L25
        Trace.traceEnd(131072);
        return;
    L25:
        ex = th;
    L42:
        Trace.traceEnd(131072);
        throw ex;
    L16:
        r4 = 222;
        goto L17
    L8:
        if (Objects.equals(oldDream.mName, this.mCurrentDream.mName) == false) goto L12;
        stopDreamInstance(true, "restarting same dream", oldDream);     // Catch: Throwable -> L10
        goto L13
    L12:
        this.mPreviousDreams.add(oldDream);     // Catch: Throwable -> L10
    L10:
        ex = th;
    L40:
        ex = th;
        goto L42
    }

    void setDreamAppTask(Binder dreamToken, IAppTask appTask) {
        if (this.mCurrentDream != null) goto L5;
    L11:
        Slog.e(TAG, "Illegal dream activity start. mCurrentDream.mToken = " + this.mCurrentDream.mToken + ", illegal dreamToken = " + dreamToken + ". Ending this dream activity.");
        appTask.finishAndRemoveTask();     // Catch: Throwable -> L14
        return;
    L15:
        Slog.e(TAG, "Unable to stop illegal dream activity.");
        return;
    L5:
        if (this.mCurrentDream.mToken != dreamToken) goto L11;
        if (this.mCurrentDream.mAppTask != null) goto L11;
        this.mCurrentDream.mAppTask = appTask;
    }

    void setDreamIsObscured(boolean isObscured) {
        if (this.mCurrentDream == null) goto L6;
        DreamRecord.m4169$$Nest$fputmDreamIsObscured(this.mCurrentDream, isObscured);
        return;
    }

    boolean dreamIsFrontmost() {
        if (this.mCurrentDream != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mCurrentDream.dreamIsFrontmost() == false) goto L7;
        return true;
    }

    private void resetScreenTimeout() {
        Slog.i(TAG, "Resetting screen timeout");
        long time = SystemClock.uptimeMillis();
        this.mPowerManager.userActivity(time, 0, 1);
    }

    public void stopDream(boolean immediate, String reason) {
        stopPreviousDreams();
        stopDreamInstance(immediate, reason, this.mCurrentDream);
    }

    public boolean bringDreamToFront() {
        if (this.mCurrentDream != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mCurrentDream.mService == null) goto L13;
        this.mCurrentDream.mService.comeToFront();     // Catch: RemoteException -> L10
        return true;
    L10:
        e = move-exception;
        Slog.e(TAG, "Error asking dream to come to the front", e);
        return false;
    }

    private void stopDreamInstance(boolean immediate, String reason, DreamRecord dream) {
        if (dream != null) goto L5;
        return;
    L5:
        Trace.traceBegin(131072, "stopDream");
        if (immediate == false) goto L65;
    L20:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L17
        r1.append("Stopping dream: name=");     // Catch: Throwable -> L17
        r1.append(dream.mName);     // Catch: Throwable -> L17
        r1.append(", isPreviewMode=");     // Catch: Throwable -> L17
        r1.append(dream.mIsPreviewMode);     // Catch: Throwable -> L17
        r1.append(", canDoze=");     // Catch: Throwable -> L17
        r1.append(dream.mCanDoze);     // Catch: Throwable -> L17
        r1.append(", userId=");     // Catch: Throwable -> L17
        r1.append(dream.mUserId);     // Catch: Throwable -> L17
        r1.append(", reason='");     // Catch: Throwable -> L17
        r1.append(reason);     // Catch: Throwable -> L17
        r1.append("'");     // Catch: Throwable -> L17
        if (DreamRecord.m4166$$Nest$fgetmStopReason(dream) != null) goto L23;
        String r4 = "";
    L24:
        r1.append(r4);     // Catch: Throwable -> L17
        Slog.i(TAG, r1.toString());     // Catch: Throwable -> L17
        Context r2 = this.mContext;     // Catch: Throwable -> L17
        if (dream.mCanDoze == false) goto L27;
        int r5 = FrameworkStatsLog.EXCLUSION_RECT_STATE_CHANGED;
    L28:
        MetricsLogger.hidden(r2, r5);     // Catch: Throwable -> L17
        Context r3 = this.mContext;     // Catch: Throwable -> L17
        if (dream.mCanDoze == false) goto L31;
        String r6 = "dozing_minutes";
    L32:
        MetricsLogger.histogram(r3, r6, (int) ((SystemClock.elapsedRealtime() - DreamRecord.m4162$$Nest$fgetmDreamStartTime(dream)) / 60000));     // Catch: Throwable -> L17
        this.mHandler.removeCallbacks(DreamRecord.m4168$$Nest$fgetmStopUnconnectedDreamRunnable(dream));     // Catch: Throwable -> L17
        this.mHandler.removeCallbacks(DreamRecord.m4167$$Nest$fgetmStopStubbornDreamRunnable(dream));     // Catch: Throwable -> L17
        if (dream.mService == null) goto L43;
        dream.mService.detach();     // Catch: Throwable -> L17 RemoteException -> L37
    L66:
        dream.mService.asBinder().unlinkToDeath(dream, 0);     // Catch: Throwable -> L17 NoSuchElementException -> L40
    L41:
        dream.mService = null;     // Catch: Throwable -> L17
    L43:
        if (dream.mBound == false) goto L45;
        this.mContext.unbindService(dream);     // Catch: Throwable -> L17
    L45:
        dream.releaseWakeLockIfNeeded();     // Catch: Throwable -> L17
        if (dream != this.mCurrentDream) goto L59;
        this.mCurrentDream = null;     // Catch: Throwable -> L17
        if (this.mSentStartBroadcast == false) goto L51;
        this.mContext.sendBroadcastAsUser(this.mDreamingStoppedIntent, UserHandle.ALL, null, this.mDreamingStartedStoppedOptions);     // Catch: Throwable -> L17
        this.mSentStartBroadcast = false;     // Catch: Throwable -> L17
    L51:
        if (this.mCurrentDream != null) goto L53;
    L58:
        this.mListener.onDreamStopped(dream.mToken);     // Catch: Throwable -> L17
        goto L59
    L53:
        if (this.mCurrentDream.mAppTask == null) goto L58;
        this.mCurrentDream.mAppTask.finishAndRemoveTask();     // Catch: Throwable -> L17 Throwable -> L56
    L17:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    L57:
        Slog.e(TAG, "Unable to stop dream activity.");     // Catch: Throwable -> L17
    L59:
        Trace.traceEnd(131072);
        return;
    L31:
        r6 = "dreaming_minutes";
        goto L32
    L27:
        r5 = 222;
        goto L28
    L23:
        r4 = "(from '" + DreamRecord.m4166$$Nest$fgetmStopReason(dream) + "')";     // Catch: Throwable -> L17
        goto L24
    L65:
        if (dream.mWakingGently == false) goto L12;
        Trace.traceEnd(131072);
        return;
    L12:
        if (dream.mService == null) goto L20;
        dream.mWakingGently = true;     // Catch: Throwable -> L17
        DreamRecord.m4171$$Nest$fputmStopReason(dream, reason);     // Catch: Throwable -> L17 RemoteException -> L19
        dream.mService.wakeUp();     // Catch: Throwable -> L17 RemoteException -> L19
        this.mHandler.postDelayed(DreamRecord.m4167$$Nest$fgetmStopStubbornDreamRunnable(dream), 5000);     // Catch: Throwable -> L17 RemoteException -> L19
        Trace.traceEnd(131072);
    }

    private void stopPreviousDreams() {
        if (this.mPreviousDreams.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<DreamRecord> it = this.mPreviousDreams.iterator();
    L7:
        if (it.hasNext() == false) goto L10;
        stopDreamInstance(true, "stop previous dream", it.next());
        it.remove();
        goto L7
    }

    private void attach(IDreamService service) {
        service.asBinder().linkToDeath(this.mCurrentDream, 0);     // Catch: RemoteException -> L10
        service.attach(this.mCurrentDream.mToken, this.mCurrentDream.mCanDoze, this.mCurrentDream.mIsPreviewMode, DreamRecord.m4163$$Nest$fgetmDreamingStartedCallback(this.mCurrentDream));     // Catch: RemoteException -> L10
        this.mCurrentDream.mService = service;
        if (this.mCurrentDream.mIsPreviewMode == false) goto L7;
        return;
    L7:
        if (this.mSentStartBroadcast == true) goto L16;
        this.mContext.sendBroadcastAsUser(this.mDreamingStartedIntent, UserHandle.ALL, null, this.mDreamingStartedStoppedOptions);
        this.mListener.onDreamStarted(this.mCurrentDream.mToken);
        this.mSentStartBroadcast = true;
        return;
    L16:
        return;
    L10:
        ex = move-exception;
        Slog.e(TAG, "The dream service died unexpectedly.", ex);
        stopDream(true, "attach failed");
    }

    public void setWindowsBackgroundDrawable(int value) {
        if (this.mCurrentDream != null) goto L5;
        return;
    L5:
        if (this.mCurrentDream.mService == null) goto L14;
        this.mCurrentDream.mService.setWindowBackgroundDrawable(value);     // Catch: RemoteException -> L8
        return;
    L8:
        ex = move-exception;
        Slog.e(TAG, "The dream service died unexpectedly.", ex);
        return;
    }
}
