package db;

import bb.b;
import cb.u;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.DownloadBlock;
import java.util.List;
import kotlin.jvm.internal.g;
import ya.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f8431a;

    /* renamed from: b, reason: collision with root package name */
    public final f f8432b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8433c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8434d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f8435e;

    public a(stepos.support.v7.app.palette.b bVar, u fetchListener, boolean z, int i10) {
        g.f(fetchListener, "fetchListener");
        this.f8431a = bVar;
        this.f8432b = fetchListener;
        this.f8433c = z;
        this.f8434d = i10;
    }

    public final DownloadInfo a() {
        return ((za.g) this.f8431a.h).f14303a.e0();
    }

    public final void b(Download download) {
        g.f(download, "download");
        if (this.f8435e) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) download;
        downloadInfo.setStatus(Status.f8192j);
        this.f8431a.m(downloadInfo);
        this.f8432b.onCompleted(download);
    }

    public final void c(DownloadInfo download, DownloadBlock downloadBlock, int i10) {
        g.f(download, "download");
        g.f(downloadBlock, "downloadBlock");
        if (this.f8435e) {
            return;
        }
        this.f8432b.onDownloadBlockUpdated(download, downloadBlock, i10);
    }

    public final void d(DownloadInfo download, Error error, Exception exc) {
        g.f(download, "download");
        if (this.f8435e) {
            return;
        }
        int autoRetryMaxAttempts = this.f8434d;
        if (autoRetryMaxAttempts == -1) {
            autoRetryMaxAttempts = download.getAutoRetryMaxAttempts();
        }
        if (this.f8433c && download.getError() == Error.f8161n) {
            download.setStatus(Status.f8190d);
            download.setError(gb.b.f9100d);
            this.f8431a.m(download);
            this.f8432b.onQueued(download, true);
            return;
        }
        if (download.getAutoRetryAttempts() >= autoRetryMaxAttempts) {
            download.setStatus(Status.f8194l);
            this.f8431a.m(download);
            this.f8432b.onError(download, error, exc);
        } else {
            download.setAutoRetryAttempts(download.getAutoRetryAttempts() + 1);
            download.setStatus(Status.f8190d);
            download.setError(gb.b.f9100d);
            this.f8431a.m(download);
            this.f8432b.onQueued(download, true);
        }
    }

    public final void e(DownloadInfo download, long j10, long j11) {
        g.f(download, "download");
        if (this.f8435e) {
            return;
        }
        this.f8432b.onProgress(download, j10, j11);
    }

    public final void f(DownloadInfo download, List list, int i10) {
        g.f(download, "download");
        if (this.f8435e) {
            return;
        }
        download.setStatus(Status.f8191e);
        this.f8431a.m(download);
        this.f8432b.onStarted(download, list, i10);
    }

    public final void g(DownloadInfo download) {
        g.f(download, "download");
        if (this.f8435e) {
            return;
        }
        download.setStatus(Status.f8191e);
        ((za.g) this.f8431a.h).i0(download);
    }
}
