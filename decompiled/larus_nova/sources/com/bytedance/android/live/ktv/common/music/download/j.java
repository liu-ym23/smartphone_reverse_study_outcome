package com.bytedance.android.live.ktv.common.music.download;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ub0.c f70068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f70069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i.a f70070c;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        ub0.c r101 = this.f70068a;
        long r102 = r101.f549325b;
        String r103 = r101.f549324a;
        long r104 = System.currentTimeMillis() - this.f70069b;
        mb0.c r105 = mb0.d.f512759a;
        Intrinsics.checkNotNullParameter(r103, "url");
        mb0.c r106 = mb0.d.f512759a;
        if (r106 == null) goto L5;
        r106.g(r102, r103, r104);
    L5:
        this.f70070c.b(this.f70068a);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        super.onFailed(r100, r101);
        ub0.c r102 = this.f70068a;
        long r103 = r102.f549325b;
        String r104 = r102.f549324a;
        int r105 = r101.getErrorCode();
        String r106 = r101.getErrorMessage();
        mb0.c r107 = mb0.d.f512759a;
        Intrinsics.checkNotNullParameter(r104, "url");
        Intrinsics.checkNotNullParameter(r106, "errorMsg");
        mb0.c r108 = mb0.d.f512759a;
        if (r108 == null) goto L5;
        r108.c(r103, r104, r105, r106);
    L5:
        i.a r109 = this.f70070c;
        long r110 = this.f70068a.f549325b;
        int r111 = r101.getErrorCode();
        String r112 = r101.getErrorMessage();
        if (r112 != null) goto L8;
        r112 = "";
    L8:
        r109.a(r110, r111, r112);
    }

    public j(ub0.c r100, long r101, i.a r102) {
        this.f70068a = r100;
        this.f70069b = r101;
        this.f70070c = r102;
    }
}
