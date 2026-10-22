package com.android.server.wm;

import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.RefreshCallbackItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class ActivityRefresher {
    private static final long REFRESH_CALLBACK_TIMEOUT_MS = 2000;
    private final ArrayList<Evaluator> mEvaluators;
    private final Handler mHandler;
    private final WindowManagerService mWmService;

    interface Evaluator {
        boolean shouldRefreshActivity(ActivityRecord r1, Configuration r2, Configuration r3);
    }

    public static /* synthetic */ void $r8$lambda$WDYeu8LhQV7CvDT_5B8bMM1qFDw(ActivityRefresher r0, ActivityRecord r1) {
        r0.lambda$onActivityConfigurationChanging$0(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ZwO7VpmwnP9FlPRmGMzyHmcJCmE(ActivityRecord r0, Configuration r1, Configuration r2, Object r3) {
        return lambda$shouldRefreshActivity$1(r0, r1, r2, r3);
    }

    ActivityRefresher(WindowManagerService wmService, Handler handler) {
        this.mEvaluators = new ArrayList();
        this.mWmService = wmService;
        this.mHandler = handler;
    }

    void addEvaluator(Evaluator evaluator) {
        this.mEvaluators.add(evaluator);
    }

    void removeEvaluator(Evaluator evaluator) {
        this.mEvaluators.remove(evaluator);
    }

    void onActivityConfigurationChanging(final ActivityRecord activity, Configuration newConfig, Configuration lastReportedConfig) {
        if (shouldRefreshActivity(activity, newConfig, lastReportedConfig) == true) goto L6;
        return;
    L6:
        if (this.mWmService.mAppCompatConfiguration.isCameraCompatRefreshCycleThroughStopEnabled() == true) goto L8;
    L10:
        boolean cycleThroughStop = false;
    L11:
        activity.mAppCompatController.getCameraOverrides().setIsRefreshRequested(true);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L14;
        String protoLogParam0 = String.valueOf(activity);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, 7211222997110112110L, 0, new Object[]{protoLogParam0});
    L14:
        IBinder r4 = activity.token;
        if (cycleThroughStop == false) goto L17;
        int r5 = 5;
    L27:
        boolean isSuccessful = activity.mAtmService.getLifecycleManager().scheduleTransactionItems(activity.app.getThread(), new ClientTransactionItem[]{new RefreshCallbackItem(r4, r5), new ResumeActivityItem(activity.token, false, false)});     // Catch: RemoteException -> L21
    L23:
        if (isSuccessful == false) goto L25;
        this.mHandler.postDelayed(new ActivityRefresher$$ExternalSyntheticLambda1(this, activity), 2000);
        return;
    L25:
        activity.mAppCompatController.getCameraOverrides().setIsRefreshRequested(false);
        return;
    L22:
        isSuccessful = false;
        goto L23
    L17:
        r5 = 4;
        goto L27
    L8:
        if (activity.mAppCompatController.getCameraOverrides().shouldRefreshActivityViaPauseForCameraCompat() == true) goto L10;
        cycleThroughStop = true;
        goto L11
    }

    private /* synthetic */ void lambda$onActivityConfigurationChanging$0(ActivityRecord activity) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        onActivityRefreshed(activity);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean isActivityRefreshing(ActivityRecord activity) {
        return activity.mAppCompatController.getCameraOverrides().isRefreshRequested();
    }

    void onActivityRefreshed(ActivityRecord activity) {
        activity.mAppCompatController.getCameraOverrides().setIsRefreshRequested(false);
    }

    private boolean shouldRefreshActivity(final ActivityRecord activity, final Configuration newConfig, final Configuration lastReportedConfig) {
        if (this.mWmService.mAppCompatConfiguration.isCameraCompatRefreshEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (activity.mAppCompatController.getCameraOverrides().shouldRefreshActivityForCameraCompat() == false) goto L9;
        if (ArrayUtils.find(this.mEvaluators.toArray(), new ActivityRefresher$$ExternalSyntheticLambda0(activity, newConfig, lastReportedConfig)) == null) goto L9;
        return true;
    }

    private static /* synthetic */ boolean lambda$shouldRefreshActivity$1(ActivityRecord activity, Configuration newConfig, Configuration lastReportedConfig, Object evaluator) {
        return ((Evaluator) evaluator).shouldRefreshActivity(activity, newConfig, lastReportedConfig);
    }
}
