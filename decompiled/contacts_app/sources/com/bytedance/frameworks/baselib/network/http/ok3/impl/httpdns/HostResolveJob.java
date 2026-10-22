package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime;
    private String mHost;
    public IHttpDnsCallback mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(HostResolveJob r1) {
        return compareTo2(r1);
    }

    public HostResolveJob(String r1, IHttpDnsCallback r2, boolean r3) {
        this.mHost = r1;
        this.mHttpDnsCallback = r2;
        this.mCreatedTime = System.currentTimeMillis();
        this.mIsLocalDnsExpired = r3;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HostResolveJob r4) {
        long r0 = r4.mCreatedTime;
        long r3 = this.mCreatedTime;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 >= r3) goto L9;
        return -1;
    L9:
        return 1;
    }

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }
}
