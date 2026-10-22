package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpDnsDepend {
    String getAppId();

    Context getContext();

    String[] getHardCodeIps();

    String getHttpDnsDomain();

    String[] getPreloadDomains();
}
