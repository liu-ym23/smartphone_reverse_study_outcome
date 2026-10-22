package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends com.bytedance.android.shopping.utils.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailLargeImageVH f168320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f168321b;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f168321b);
        this.f168320a.f168290b.setInputStream(new PolarisFileInputStreamWrapper(r101));
    }

    public h(AnchorV4DetailLargeImageVH r100, String r101) {
        this.f168320a = r100;
        this.f168321b = r101;
    }
}
