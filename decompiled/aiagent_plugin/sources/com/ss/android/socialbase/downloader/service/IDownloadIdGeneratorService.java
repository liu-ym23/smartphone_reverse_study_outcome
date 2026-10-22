package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadIdGeneratorService extends IDownloadIdGenerator {

    public static class DefaultDownloadIdGeneratorService implements IDownloadIdGeneratorService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public int generate(DownloadInfo r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public int generate(String r1, String r2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public boolean isDefaultIdGenerator() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public void setDownloadIdGenerator(IDownloadIdGenerator r2) {
            IDownloadIdGenerator r1 = (IDownloadIdGenerator) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadIdGenerator.class, "com.obric.aiagent.plugin");
        }

        public DefaultDownloadIdGeneratorService() {
        }
    }

    int generate(DownloadInfo r1);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    boolean isDefaultIdGenerator();

    void setDownloadIdGenerator(IDownloadIdGenerator r1);
}
