package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f72721a;

    public f(e r100) {
        this.f72721a = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        super.onCanceled(r100);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        ALogger.i("KtvDigitAvatar", "download image success");
        if (r100 == null) goto L8;
        String r101 = r100.getTargetFilePath();
        if (r101 == null) goto L9;
        new PolarisFileWrapper(r101);
        this.f72721a.getClass();
        this.f72721a.getClass();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        ALogger.e("KtvDigitAvatar", "download image fail", r101);
    }
}
