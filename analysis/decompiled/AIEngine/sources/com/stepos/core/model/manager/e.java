package com.stepos.core.model.manager;

import com.stepos.core.ota.downloader.DownloadListener;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine$bridgeListener$1;
import com.tonyodev.fetch2.Download;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7446a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7447b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f7448c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f7449d;

    public /* synthetic */ e(int i10, String str, String str2, boolean z) {
        this.f7446a = i10;
        this.f7447b = str;
        this.f7448c = z;
        this.f7449d = str2;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f7446a) {
            case 0:
                return ModelCacheImpl.acquire$lambda$20$lambda$19((String) this.f7447b, this.f7448c, (String) this.f7449d, (p6.g) obj);
            case 1:
                return ModelCacheImpl.acquire$lambda$20$lambda$13$lambda$12((String) this.f7447b, this.f7448c, (String) this.f7449d, (p6.g) obj);
            default:
                return Fetch2DownloadEngine$bridgeListener$1.onQueued$lambda$1((Fetch2DownloadEngine) this.f7447b, (Download) this.f7449d, this.f7448c, (DownloadListener) obj);
        }
    }

    public /* synthetic */ e(Fetch2DownloadEngine fetch2DownloadEngine, Download download, boolean z) {
        this.f7446a = 2;
        this.f7447b = fetch2DownloadEngine;
        this.f7449d = download;
        this.f7448c = z;
    }
}
