package com.android.server.wm;

import android.content.ComponentName;
import android.content.Intent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityMetricsLaunchObserver {
    public static final int TEMPERATURE_COLD = 1;
    public static final int TEMPERATURE_HOT = 3;
    public static final int TEMPERATURE_WARM = 2;

    @Retention(RetentionPolicy.SOURCE)
    @interface Temperature {
    }

    public ActivityMetricsLaunchObserver() {
    }

    public void onIntentStarted(Intent intent, long timestampNanos) {
    }

    public void onIntentFailed(long id) {
    }

    public void onActivityLaunched(long id, ComponentName name, int temperature, int userId) {
    }

    public void onActivityLaunchCancelled(long id) {
    }

    public void onActivityLaunchFinished(long id, ComponentName name, long timestampNanos, int launchMode) {
    }

    public void onReportFullyDrawn(long id, long timestampNanos) {
    }
}
