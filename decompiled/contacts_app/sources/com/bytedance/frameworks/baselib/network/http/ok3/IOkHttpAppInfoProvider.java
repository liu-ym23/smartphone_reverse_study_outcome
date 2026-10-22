package com.bytedance.frameworks.baselib.network.http.ok3;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IOkHttpAppInfoProvider {
    List<String> getAbSdkVersion();

    int getAid();

    String getHttpDnsDomain();

    String[] getHttpDnsDomainHardCodeIps();

    String[] getHttpDnsPreloadDomains();

    void sendAppMonitorEvent(String r1, String r2);
}
