package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadNetworkService {

    public static class DefaultDownloadNetworkService implements IDownloadNetworkService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
        public IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, String r4, List<HttpHeader> r5, int r6, boolean r7, DownloadInfo r8) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
        public IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, List<HttpHeader> r4) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        public DefaultDownloadNetworkService() {
        }
    }

    IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, String r4, List<HttpHeader> r5, int r6, boolean r7, DownloadInfo r8);

    IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, List<HttpHeader> r4);
}
