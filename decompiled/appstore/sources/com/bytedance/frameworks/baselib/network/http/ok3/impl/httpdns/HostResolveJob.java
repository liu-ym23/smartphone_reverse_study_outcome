package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime;
    private String mHost;
    public IHttpDnsCallback mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    public HostResolveJob(String r10, IHttpDnsCallback r11, boolean r12) {
        this.mHost = r10;
        this.mHttpDnsCallback = r11;
        this.mCreatedTime = System.currentTimeMillis();
        this.mIsLocalDnsExpired = r12;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(HostResolveJob r10) {
        return compareTo2(r10);
    }

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HostResolveJob r10) {
        long r11 = r10.mCreatedTime;
        long r12 = this.mCreatedTime;
        if (r11 != r12) goto L7;
        return 0;
    L7:
        if (r11 >= r12) goto L9;
        return -1;
    L9:
        return 1;
    }
}
