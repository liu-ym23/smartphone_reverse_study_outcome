package com.bytedance.android.live.ktv.common.music.download;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f70077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k.c f70078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f70079c;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        k.b r101 = (k.b) this.f70077a.get();
        if (r101 == null) goto L6;
        k.c r102 = this.f70078b;
        r101.a(r102.f70074a, r102.f70076c, this.f70079c.element);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        super.onFailed(r100, r101);
        k.b r102 = (k.b) this.f70077a.get();
        if (r102 == null) goto L9;
        long r103 = this.f70078b.f70074a;
        r101.getErrorCode();
        String r104 = r101.getErrorMessage();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r102.onFailed(r104, this.f70079c.element);
        return;
    }

    public l(WeakReference r100, k.c r101, Ref.IntRef r102) {
        this.f70077a = r100;
        this.f70078b = r101;
        this.f70079c = r102;
    }
}
