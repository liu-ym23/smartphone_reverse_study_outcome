package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;

/* JADX INFO: loaded from: classes9.dex */
public final class u implements IDownloadStartCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f131755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f131756b;

    public u(w r100, String r101) {
        this.f131755a = r100;
        this.f131756b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback
    public final void onStart(int r100) {
        this.f131755a.f131817a.put(this.f131756b, Integer.valueOf(r100));
    }
}
