package com.android.server.job.controllers;

import android.app.job.JobInfo;
import android.os.PersistableBundle;
import com.android.server.job.JobSchedulerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricJobCondition {
    public static final String CONSTRAINT_BUSINESS_KEY = "obric_business";
    private static final String TAG = "ObricJobCondition";
    final JobStatus mJobStatus;
    final ArrayList<ObricJobResourceController.TrackingInstance> mMyTrackings;
    final int mRequiredConstraints;
    final HashMap<String, Object> mRequiredValueMap;
    int mSatisfiedConstraints;

    public ObricJobCondition(JobStatus jobStatus, Map<String, ObricJobResourceController.ResourceCtrl> map) {
        this.mSatisfiedConstraints = 0;
        this.mRequiredValueMap = new HashMap();
        this.mMyTrackings = new ArrayList();
        int bitValue = 0;
        this.mJobStatus = jobStatus;
        PersistableBundle extras = jobStatus.getJob().getExtras();
        if (extras == null) goto L11;
        Iterator<String> r2 = extras.keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String str = r2.next();
        if (map.containsKey(str) == false) goto L6;
        bitValue = bitValue | map.get(str).getKeyBit();
        this.mRequiredValueMap.put(str, extras.get(str));
    L11:
        this.mRequiredConstraints = bitValue;
    }

    void addTracker(ObricJobResourceController.TrackingInstance trackingInstance) {
        this.mMyTrackings.add(trackingInstance);
    }

    void detachLocked(boolean needTracking) {
        int size = this.mMyTrackings.size();
        int i = 0;
    L3:
        if (i >= size) goto L9;
        ObricJobResourceController.TrackingInstance trackingInstance = this.mMyTrackings.get(i);
        trackingInstance.mJobs.remove(this);
        if (trackingInstance.mJobs.isEmpty() == false) goto L8;
        if (needTracking == true) goto L8;
        trackingInstance.detachLocked();
    L8:
        i = i + 1;
        goto L3
    }

    boolean setInnerConstraintSatisfied(int bit, boolean isSatisfied) {
        if ((this.mSatisfiedConstraints & bit) == 0) goto L5;
        boolean lastSatisfied = true;
    L6:
        if (lastSatisfied != isSatisfied) goto L8;
        return false;
    L8:
        if (isSatisfied == false) goto L10;
        this.mSatisfiedConstraints |= bit;
    L11:
        return true;
    L10:
        this.mSatisfiedConstraints &= ~bit;
        goto L11
    L5:
        lastSatisfied = false;
        goto L6
    }

    void ignoreBusinessConstraint() {
        this.mSatisfiedConstraints = this.mRequiredConstraints;
    }

    boolean isObricJobReady() {
        if ((this.mSatisfiedConstraints & this.mRequiredConstraints) != this.mRequiredConstraints) goto L5;
        return true;
    L5:
        return false;
    }

    boolean setBusinessConstraintSatisfied(boolean satisfied) {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        return this.mJobStatus.setObricBusinessConstraintSatisfied(now, satisfied);
    }

    public String toString() {
        return "obricJobStatus{mJobStatus=" + this.mJobStatus.toShortString() + '}';
    }

    static int initObricConstraints(JobInfo jobInfo) {
        if (jobInfo.getExtras() != null) goto L5;
        return 0;
    L5:
        if (jobInfo.getExtras().getBoolean(CONSTRAINT_BUSINESS_KEY) == false) goto L10;
        return 512;
    L10:
        return 0;
    }
}
