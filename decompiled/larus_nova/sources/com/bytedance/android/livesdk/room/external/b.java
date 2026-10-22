package com.bytedance.android.livesdk.room.external;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f157638a;

    public b(String r100) {
        this.f157638a = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        if (r100 == null) goto L7;
        String r101 = r100.getTargetFilePath();
        if (r101 == null) goto L7;
        FileUtils.unZipFolder(r101, this.f157638a);
        File r102 = d.f157640a;
        d.f157640a = new PolarisFileWrapper(this.f157638a + "/FZMoDengTiJF.ttf");
    L7:
        File r103 = d.f157640a;
        d.f157641b = false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        File r102 = d.f157640a;
        d.f157641b = false;
    }
}
