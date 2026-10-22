package com.bytedance.common.wschannel.channel.impl.ok.policy;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class RetryTimesPolicy extends RetryIntervalPolicy {
    public static final int DEFAULT_MAX_RETRY_TIME = 4;
    private int mCurrRetryTime;
    private final int mMaxRetryTime;

    public RetryTimesPolicy(Context r2) {
        this(r2, 4);
    }

    RetryTimesPolicy(Context r1, int r2) {
        super(r1);
        if (r2 >= 0) goto L5;
        r2 = 4;
    L5:
        this.mMaxRetryTime = r2;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryIntervalPolicy
    public long getNextRetryInterval() {
        if (this.mCurrRetryTime >= this.mMaxRetryTime) goto L5;
        long r0 = super.getNextRetryInterval();
    L7:
        if (r0 == (-1)) goto L9;
        this.mCurrRetryTime++;
    L9:
        return r0;
    L5:
        r0 = -1;
        goto L7
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.mMaxRetryTime + ", mCurrRetryTime=" + this.mCurrRetryTime + '}';
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryIntervalPolicy, com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        super.reset();
        this.mCurrRetryTime = 0;
    }
}
