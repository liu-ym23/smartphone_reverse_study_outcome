package com.stepos.core.ota.downloader;

import com.tonyodev.fetch2.Download;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7581a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fetch2DownloadEngine f7582b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f7583c;

    public /* synthetic */ d(Fetch2DownloadEngine fetch2DownloadEngine, Download download, int i10) {
        this.f7581a = i10;
        this.f7582b = fetch2DownloadEngine;
        this.f7583c = download;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7581a) {
            case 0:
                return Fetch2DownloadEngine$bridgeListener$1.onWaitingNetwork$lambda$2(this.f7582b, this.f7583c, (DownloadListener) obj);
            case 1:
                return Fetch2DownloadEngine$bridgeListener$1.onStarted$lambda$3(this.f7582b, this.f7583c, (DownloadListener) obj);
            case 2:
                return Fetch2DownloadEngine$bridgeListener$1.onCompleted$lambda$6(this.f7582b, this.f7583c, (DownloadListener) obj);
            default:
                return Fetch2DownloadEngine$bridgeListener$1.onDeleted$lambda$12(this.f7582b, this.f7583c, (DownloadListener) obj);
        }
    }
}
