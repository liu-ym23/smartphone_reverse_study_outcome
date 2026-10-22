package com.ss.android.socialbase.downloader.core.module.pcdn;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNRetryPolicy {
    private int mCurrentRetryCount;
    private int mMaxRetryCount;

    public PCDNRetryPolicy(int r1) {
        this.mMaxRetryCount = r1;
    }

    public boolean canRetry(boolean r3) {
        int r0 = this.mCurrentRetryCount;
        if (r0 < this.mMaxRetryCount) goto L7;
        return false;
    L7:
        if (r3 == false) goto L9;
        this.mCurrentRetryCount = r0 + 1;
    L9:
        return true;
    }

    public boolean isRetry() {
        if (this.mCurrentRetryCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
