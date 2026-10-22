package com.stepos.core.ota.downloader;

import com.tonyodev.fetch2.Download;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7578a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fetch2DownloadEngine f7579b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f7580c;

    public /* synthetic */ c(Fetch2DownloadEngine fetch2DownloadEngine, Download download, int i10) {
        this.f7578a = i10;
        this.f7579b = fetch2DownloadEngine;
        this.f7580c = download;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7578a) {
            case 0:
                return Fetch2DownloadEngine$bridgeListener$1.onDownloadBlockUpdated$lambda$4(this.f7579b, this.f7580c, (DownloadListener) obj);
            case 1:
                return Fetch2DownloadEngine$bridgeListener$1.onPaused$lambda$8(this.f7579b, this.f7580c, (DownloadListener) obj);
            case 2:
                return Fetch2DownloadEngine$bridgeListener$1.onAdded$lambda$0(this.f7579b, this.f7580c, (DownloadListener) obj);
            case 3:
                return Fetch2DownloadEngine$bridgeListener$1.onCancelled$lambda$10(this.f7579b, this.f7580c, (DownloadListener) obj);
            case 4:
                return Fetch2DownloadEngine$bridgeListener$1.onRemoved$lambda$11(this.f7579b, this.f7580c, (DownloadListener) obj);
            default:
                return Fetch2DownloadEngine$bridgeListener$1.onResumed$lambda$9(this.f7579b, this.f7580c, (DownloadListener) obj);
        }
    }
}
