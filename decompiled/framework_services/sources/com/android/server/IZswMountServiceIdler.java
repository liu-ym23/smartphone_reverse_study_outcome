package com.android.server;

import android.app.job.JobInfo;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IZswMountServiceIdler {
    boolean shouldPerformIdleMaintenance(Context r1);

    boolean useZteIdleMaintence(JobInfo.Builder r1);
}
