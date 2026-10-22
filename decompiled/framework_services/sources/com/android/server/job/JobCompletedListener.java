package com.android.server.job;

import com.android.server.job.controllers.JobStatus;

/* JADX INFO: loaded from: classes2.dex */
public interface JobCompletedListener {
    void onJobCompletedLocked(JobStatus r1, int r2, int r3, boolean r4);
}
