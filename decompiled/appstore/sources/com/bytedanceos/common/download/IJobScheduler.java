package com.bytedanceos.common.download;

/* JADX INFO: loaded from: classes2.dex */
public interface IJobScheduler {
    void addAdsReportScheduler(long r10);

    void addUploadInstalledAppsScheduler();

    void downloadNext();
}
