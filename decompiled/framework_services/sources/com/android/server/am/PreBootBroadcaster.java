package com.android.server.am;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.ProgressReporter;
import com.android.server.LocalServices;
import com.android.server.UiThread;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreBootBroadcaster extends IIntentReceiver.Stub {
    private static final int MSG_HIDE = 2;
    private static final int MSG_SHOW = 1;
    private static final String TAG = "PreBootBroadcaster";
    private Handler mHandler;
    private int mIndex;
    private final Intent mIntent;
    private final ProgressReporter mProgress;
    private final boolean mQuiet;
    private final ActivityManagerService mService;
    private final List<ResolveInfo> mTargets;
    private final int mUserId;

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1551$$Nest$fgetmService(PreBootBroadcaster r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1552$$Nest$fgetmUserId(PreBootBroadcaster r0) {
        return r0.mUserId;
    }

    public abstract void onFinished();

    public PreBootBroadcaster(ActivityManagerService service, int userId, ProgressReporter progress, boolean quiet) {
        this.mIndex = 0;
        final Looper r1 = UiThread.get().getLooper();
        final Handler.Callback r2 = null;
        final boolean r3 = true;
        this.mHandler = new AnonymousClass1(this, r1, r2, r3);
        this.mService = service;
        this.mUserId = userId;
        this.mProgress = progress;
        this.mQuiet = quiet;
        this.mIntent = new Intent("android.intent.action.PRE_BOOT_COMPLETED");
        this.mIntent.addFlags(33554688);
        this.mTargets = this.mService.mContext.getPackageManager().queryBroadcastReceiversAsUser(this.mIntent, 1048576, UserHandle.of(userId));
    }

    public void sendNext() {
        if (this.mIndex < this.mTargets.size()) goto L7;
        this.mHandler.obtainMessage(2).sendToTarget();
        onFinished();
        return;
    L7:
        if (this.mService.isUserRunning(this.mUserId, 0) == true) goto L11;
        Slog.i(TAG, "User " + this.mUserId + " is no longer running; skipping remaining receivers");
        this.mHandler.obtainMessage(2).sendToTarget();
        onFinished();
        return;
    L11:
        if (this.mQuiet == true) goto L13;
        this.mHandler.obtainMessage(1, this.mTargets.size(), this.mIndex).sendToTarget();
    L13:
        List<ResolveInfo> r0 = this.mTargets;
        int r1 = this.mIndex;
        this.mIndex = r1 + 1;
        ResolveInfo ri = r0.get(r1);
        ComponentName componentName = ri.activityInfo.getComponentName();
        if (this.mProgress == null) goto L16;
        CharSequence label = ri.activityInfo.loadLabel(this.mService.mContext.getPackageManager());
        this.mProgress.setProgress(this.mIndex, this.mTargets.size(), this.mService.mContext.getString(R.string.app_info, new Object[]{label}));
    L16:
        Slog.i(TAG, "Pre-boot of " + componentName.toShortString() + " for user " + this.mUserId);
        EventLogTags.writeAmPreBoot(this.mUserId, componentName.getPackageName());
        this.mIntent.setComponent(componentName);
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (amInternal == null) goto L19;
        long duration = amInternal.getBootTimeTempAllowListDuration();
        long duration2 = duration;
    L20:
        BroadcastOptions bOptions = BroadcastOptions.makeBasic();
        bOptions.setTemporaryAppAllowlist(duration2, 0, 201, "");
        ActivityManagerService r3 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mService.broadcastIntentLocked(null, null, null, this.mIntent, null, this, 0, null, null, null, null, null, -1, bOptions.toBundle(), true, false, ActivityManagerService.MY_PID, 1000, Binder.getCallingUid(), Binder.getCallingPid(), this.mUserId);     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L28:
        th = th;
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L28
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L30:
        th = th;
        goto L32
    L19:
        duration2 = 10000;
        goto L20
    }

    public void performReceive(Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, int sendingUser) {
        sendNext();
    }
}
