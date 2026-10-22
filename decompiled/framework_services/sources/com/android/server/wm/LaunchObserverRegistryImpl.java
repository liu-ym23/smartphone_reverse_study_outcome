package com.android.server.wm;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.android.internal.util.function.pooled.PooledLambda;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class LaunchObserverRegistryImpl extends ActivityMetricsLaunchObserver implements ActivityMetricsLaunchObserverRegistry {
    private final Handler mHandler;
    private final ArrayList<ActivityMetricsLaunchObserver> mList;

    public static /* synthetic */ void $r8$lambda$43NtWuC87LQ3fIhORDtk6FguY_c(LaunchObserverRegistryImpl r0, Intent r1, long r2) {
        r0.handleOnIntentStarted(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$F9z4OJPJG8S6kWyjlSmFdBIxGAs(LaunchObserverRegistryImpl r0, long r1, long r3) {
        r0.handleOnReportFullyDrawn(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$HB46khtoGy2-lvZU6F6JCBo3THQ, reason: not valid java name */
    public static /* synthetic */ void m10038$r8$lambda$HB46khtoGy2lvZU6F6JCBo3THQ(LaunchObserverRegistryImpl r0, long r1, ComponentName r3, int r4, int r5) {
        r0.handleOnActivityLaunched(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$K44Q-L066e13h8I3JRSoRtnlKPw, reason: not valid java name */
    public static /* synthetic */ void m10039$r8$lambda$K44QL066e13h8I3JRSoRtnlKPw(LaunchObserverRegistryImpl r0, long r1, ComponentName r3, long r4, int r6) {
        r0.handleOnActivityLaunchFinished(r1, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$VjnsHxQ17s33Ve2W0ONnSSmEh5s(LaunchObserverRegistryImpl r0, ActivityMetricsLaunchObserver r1) {
        r0.handleUnregisterLaunchObserver(r1);
    }

    public static /* synthetic */ void $r8$lambda$WAwiYJjN5w8ZP4Z6UfWTV2cYDO0(LaunchObserverRegistryImpl r0, long r1) {
        r0.handleOnActivityLaunchCancelled(r1);
    }

    public static /* synthetic */ void $r8$lambda$hBA82PxWd8FHKBvtMNEM9LhwKjI(LaunchObserverRegistryImpl r0, long r1) {
        r0.handleOnIntentFailed(r1);
    }

    public static /* synthetic */ void $r8$lambda$ic9ginTismFOXJUj86YxV2Pnmpw(LaunchObserverRegistryImpl r0, ActivityMetricsLaunchObserver r1) {
        r0.handleRegisterLaunchObserver(r1);
    }

    public LaunchObserverRegistryImpl(Looper looper) {
        this.mList = new ArrayList();
        this.mHandler = new Handler(looper);
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserverRegistry
    public void registerLaunchObserver(ActivityMetricsLaunchObserver launchObserver) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda1(), this, launchObserver));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserverRegistry
    public void unregisterLaunchObserver(ActivityMetricsLaunchObserver launchObserver) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda0(), this, launchObserver));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onIntentStarted(Intent intent, long timestampNs) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda5(), this, intent, Long.valueOf(timestampNs)));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onIntentFailed(long id) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda7(), this, Long.valueOf(id)));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onActivityLaunched(long id, ComponentName name, int temperature, int userId) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda3(), this, Long.valueOf(id), name, Integer.valueOf(temperature), Integer.valueOf(userId)));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onActivityLaunchCancelled(long id) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda6(), this, Long.valueOf(id)));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onActivityLaunchFinished(long id, ComponentName name, long timestampNs, int launchMode) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda4(), this, Long.valueOf(id), name, Long.valueOf(timestampNs), Integer.valueOf(launchMode)));
    }

    @Override // com.android.server.wm.ActivityMetricsLaunchObserver
    public void onReportFullyDrawn(long id, long timestampNs) {
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new LaunchObserverRegistryImpl$$ExternalSyntheticLambda2(), this, Long.valueOf(id), Long.valueOf(timestampNs)));
    }

    private void handleRegisterLaunchObserver(ActivityMetricsLaunchObserver observer) {
        this.mList.add(observer);
    }

    private void handleUnregisterLaunchObserver(ActivityMetricsLaunchObserver observer) {
        this.mList.remove(observer);
    }

    private void handleOnIntentStarted(Intent intent, long timestampNs) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onIntentStarted(intent, timestampNs);
        i = i + 1;
        goto L4
    }

    private void handleOnIntentFailed(long id) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onIntentFailed(id);
        i = i + 1;
        goto L4
    }

    private void handleOnActivityLaunched(long id, ComponentName name, int temperature, int userId) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onActivityLaunched(id, name, temperature, userId);
        i = i + 1;
        goto L4
    }

    private void handleOnActivityLaunchCancelled(long id) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onActivityLaunchCancelled(id);
        i = i + 1;
        goto L4
    }

    private void handleOnActivityLaunchFinished(long id, ComponentName name, long timestampNs, int launchMode) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onActivityLaunchFinished(id, name, timestampNs, launchMode);
        i = i + 1;
        goto L4
    }

    private void handleOnReportFullyDrawn(long id, long timestampNs) {
        int i = 0;
    L4:
        if (i >= this.mList.size()) goto L7;
        this.mList.get(i).onReportFullyDrawn(id, timestampNs);
        i = i + 1;
        goto L4
    }
}
