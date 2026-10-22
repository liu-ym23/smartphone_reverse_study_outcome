package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f184837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f184838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f184839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f184840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f184841e;

    public final void a(Integer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Downloader.getInstance(this.f184841e).removeSubThreadListener(r100.intValue(), this);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        super.onCanceled(r100);
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getId());
    L6:
        a(r101);
        dm.a.a("ISVDownloadManager").b("download canceled, cdnUrl: " + this.f184840d, null);
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPause(DownloadInfo r100) {
        super.onPause(r100);
        dm.a.a("ISVDownloadManager").b("download onPause, cdnUrl: " + this.f184840d, null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        if (this.f184837a.exists() == false) goto L7;
        Function1 r101 = this.f184838b;
        if (r101 == null) goto L10;
        Unit r102 = (Unit) r101.invoke(r100);
    L10:
        if (r100 == null) goto L12;
        Integer r103 = Integer.valueOf(r100.getId());
    L13:
        a(r103);
        return;
    L12:
        r103 = null;
        goto L13
    L7:
        Function1 r104 = this.f184839c;
        if (r104 == null) goto L10;
        Unit r105 = (Unit) r104.invoke(new Throwable("downloader callback success, but file not exists"));
        goto L10
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        Function1 r102 = this.f184839c;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(r101);
    L6:
        if (r100 == null) goto L8;
        Integer r104 = Integer.valueOf(r100.getId());
    L9:
        a(r104);
        dm.a.b r105 = dm.a.a("ISVDownloadManager");
        StringBuilder r106 = new StringBuilder("download onFailed,  ");
        if (r101 == null) goto L12;
        String r107 = r101.getMessage();
    L13:
        r106.append(r107);
        r106.append(", cdnUrl: ");
        r106.append(this.f184840d);
        r105.b(r106.toString(), null);
        return;
    L12:
        r107 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public a(PolarisFileWrapper r100, Function1 r101, Function1 r102, String r103, Context r104) {
        this.f184837a = r100;
        this.f184838b = r101;
        this.f184839c = r102;
        this.f184840d = r103;
        this.f184841e = r104;
    }
}
