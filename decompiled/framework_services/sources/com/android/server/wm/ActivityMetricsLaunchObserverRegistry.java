package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface ActivityMetricsLaunchObserverRegistry {
    void registerLaunchObserver(ActivityMetricsLaunchObserver r1);

    void unregisterLaunchObserver(ActivityMetricsLaunchObserver r1);
}
