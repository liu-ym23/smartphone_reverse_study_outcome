package com.bytedance.common.wschannel.channel.impl.ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
class WsPolicy {
    private int mIndex;
    private RetryPolicy mRetryPolicy;
    private String mTargetUrl;
    private final List<String> mUrls;

    WsPolicy(List<String> r3, RetryPolicy r4) {
        this.mIndex = 0;
        ArrayList r0 = new ArrayList();
        this.mUrls = r0;
        if (r3 == null) goto L5;
        r0.addAll(r3);
    L5:
        Logger.d(OkChannelImpl.TAG, "urls : " + r0);
        this.mRetryPolicy = r4;
        reset();
    }

    synchronized Pair<String, Long> getRetryUrlAndInterval(Response r6) {
        monitor-enter(this);
        String r0 = getUrl();     // Catch: Throwable -> L11
        long r1 = this.mRetryPolicy.getRetryIntervalWithResponse(r6);     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L8;
        this.mRetryPolicy.reset();     // Catch: Throwable -> L11
        r0 = getNextUrl();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r1 = this.mRetryPolicy.getRandomInterval();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r7 = new Pair(r0, Long.valueOf(r1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized String getNextUrl() {
        monitor-enter(this);
        int r0 = this.mIndex + 1;     // Catch: Throwable -> L11
        this.mIndex = r0;     // Catch: Throwable -> L11
        if (this.mUrls.size() <= r0) goto L9;
        String r1 = this.mUrls.get(r0);     // Catch: Throwable -> L11
        this.mTargetUrl = r1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void reset() {
        monitor-enter(this);
        this.mRetryPolicy.reset();     // Catch: Throwable -> L6
        this.mTargetUrl = null;     // Catch: Throwable -> L6
        this.mIndex = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getUrl() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (StringUtils.isEmpty(this.mTargetUrl) == false) goto L8;
        int r0 = this.mUrls.size();     // Catch: Throwable -> L11
        int r1 = this.mIndex;     // Catch: Throwable -> L11
        if (r0 <= r1) goto L8;
        this.mTargetUrl = this.mUrls.get(r1);     // Catch: Throwable -> L11
    L8:
        String r2 = this.mTargetUrl;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }
}
