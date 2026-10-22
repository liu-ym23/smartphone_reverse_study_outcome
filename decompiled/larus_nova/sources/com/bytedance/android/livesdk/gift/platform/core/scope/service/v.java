package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class v extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f131808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f131809b;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        if (r100 == null) goto L6;
        this.f131808a.a(this.f131809b, r100.getSavePath() + r100.getName());
        return;
    }

    public v(z3.a r100, String r101) {
        this.f131808a = r100;
        this.f131809b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        q r102 = this.f131808a;
        if (r101 == null) goto L6;
        String r103 = r101.getMessage();
        if (r103 == null) goto L6;
    L7:
        r102.error(r103);
        return;
    L6:
        r103 = "no error message";
        goto L7
    }
}
