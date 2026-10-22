package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMonitorHelperService implements IDownloadMonitorHelperService {
    public DownloadMonitorHelperService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSend(DownloadTask r1, BaseException r2, int r3) {
        DownloadMonitorHelper.monitorSend(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSendWithTaskMonitor(IDownloadMonitorDepend r2, DownloadInfo r3, BaseException r4, int r5) {
        DownloadMonitorHelper.monitorSendWithTaskMonitor((IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorDownloadApp(DownloadInfo r1, String r2, int r3) {
        DownloadMonitorHelper.monitorDownloadApp(r1, r2, r3);
    }
}
