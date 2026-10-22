package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadMonitorHelperService {

    public static class DefaultDownloadMonitorHelperService implements IDownloadMonitorHelperService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorDownloadApp(DownloadInfo r1, String r2, int r3) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSend(DownloadTask r1, BaseException r2, int r3) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSendWithTaskMonitor(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4) {
            IDownloadMonitorDepend r0 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r1, IDownloadMonitorDepend.class, "com.obric.aiagent.plugin");
        }

        public DefaultDownloadMonitorHelperService() {
        }
    }

    void monitorDownloadApp(DownloadInfo r1, String r2, int r3);

    void monitorSend(DownloadTask r1, BaseException r2, int r3);

    void monitorSendWithTaskMonitor(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4);
}
