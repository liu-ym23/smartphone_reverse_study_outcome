package com.bytedance.ai.resource;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0711a f37303a;

    public c(b r100) {
        this.f37303a = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        a.InterfaceC0711a r101 = this.f37303a;
        if (r100 == null) goto L5;
        r100.getDownloadProcess();
    L5:
        if (r100 == null) goto L7;
        r100.getUrl();
    L7:
        r101.a();
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getUrl();
        if (r101 == null) goto L5;
    L6:
        this.f37303a.onSuccess();
        com.bytedance.ai.utils.g.f37637a.i("AIDownloadManager", "download successes, url = ".concat(r101));
        return;
    L5:
        r101 = "";
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        BaseException r103 = r100.getFailedException();
    L6:
        a.InterfaceC0711a r104 = this.f37303a;
        if (r103 == null) goto L9;
        r103.getErrorMessage();
    L9:
        if (r100 == null) goto L11;
        r100.getUrl();
    L11:
        r104.onFailed();
        com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r106 = new StringBuilder("Failed to download , status=");
        if (r100 == null) goto L14;
        Integer r107 = Integer.valueOf(r100.getStatus());
    L15:
        r106.append(r107);
        r106.append(", code=");
        if (r103 == null) goto L18;
        Integer r108 = Integer.valueOf(r103.getErrorCode());
    L19:
        r106.append(r108);
        r106.append(", msg=");
        if (r103 == null) goto L22;
        r102 = r103.getErrorMessage();
    L22:
        r106.append(r102);
        r105.w("AIDownloadManager", r106.toString());
        return;
    L18:
        r108 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L5:
        r103 = null;
        goto L6
    }
}
