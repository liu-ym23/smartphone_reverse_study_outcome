package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadIdGeneratorService implements IDownloadIdGeneratorService {
    private IDownloadIdGenerator mDownloadIdGenerator;

    public DownloadIdGeneratorService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public void setDownloadIdGenerator(IDownloadIdGenerator r3) {
        this.mDownloadIdGenerator = (IDownloadIdGenerator) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadIdGenerator.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public boolean isDefaultIdGenerator() {
        if (this.mDownloadIdGenerator != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public int generate(String r2, String r3) {
        IDownloadIdGenerator r0 = this.mDownloadIdGenerator;
        if (r0 == null) goto L7;
        return r0.generate(r2, r3);
    L7:
        return generateImpl(r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public int generate(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        String r0 = r3.getTaskKey();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = r3.getUrl();
    L9:
        return generate(r0, r3.getSavePath());
    }

    private int generateImpl(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (DownloadFileUtils.isMediaUri(r3) == false) goto L10;
        r3 = DownloadFileUtils.getContentUriString(r3);
    L10:
        String r1 = DownloadUtils.md5Hex(r2 + "_" + r3);
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return 0;
    L14:
        return r1.hashCode();
    }
}
