package com.android.server.backup;

/* JADX INFO: loaded from: classes.dex */
public class JobIdManager {
    public JobIdManager() {
    }

    public static int getJobIdForUserId(int minJobId, int maxJobId, int userId) {
        if ((minJobId + userId) > maxJobId) goto L7;
        return minJobId + userId;
    L7:
        throw new RuntimeException("No job IDs available in the given range");
    }
}
