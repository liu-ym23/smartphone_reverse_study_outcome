package com.bytedance.common.wschannel.channel.impl.ok.policy;

import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public interface RetryPolicy {
    public static final long CANCEL = -1;

    long getRandomInterval();

    long getRetryIntervalWithResponse(Response r1);

    void reset();
}
