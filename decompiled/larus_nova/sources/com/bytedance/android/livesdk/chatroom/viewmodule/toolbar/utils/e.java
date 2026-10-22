package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f116802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f116803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f116804c;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        d.a r101 = this.f116802a;
        if (r101 == null) goto L11;
        String r102 = this.f116803b;
        if (r100 == null) goto L8;
        String r103 = r100.getTargetFilePath();
        if (r103 == null) goto L8;
    L9:
        r101.a(r102, r103);
        return;
    L8:
        r103 = this.f116804c;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        d.a r102 = this.f116802a;
        if (r102 == null) goto L11;
        String r103 = this.f116803b;
        if (r100 == null) goto L8;
        String r104 = r100.getTargetFilePath();
        if (r104 == null) goto L8;
    L9:
        r102.onFail(r103, r104);
        return;
    L8:
        r104 = this.f116804c;
        goto L9
    }

    public e(d.a r100, String r101, String r102) {
        this.f116802a = r100;
        this.f116803b = r101;
        this.f116804c = r102;
    }
}
