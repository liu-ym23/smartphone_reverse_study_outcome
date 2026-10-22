package com.android.server.job;

import android.net.Network;
import android.util.ArraySet;
import com.android.server.job.controllers.JobStatus;
import com.android.server.job.restrictions.JobRestriction;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface StateChangedListener {
    void onControllerStateChanged(ArraySet<JobStatus> r1);

    void onDeviceIdleStateChanged(boolean r1);

    void onNetworkChanged(JobStatus r1, Network r2);

    void onRestrictedBucketChanged(List<JobStatus> r1);

    void onRestrictionStateChanged(JobRestriction r1, boolean r2);

    void onRunJobNow(JobStatus r1);
}
