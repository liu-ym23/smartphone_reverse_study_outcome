package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadActionHelper f52718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52719b;

    public i(DownloadActionHelper r100, p r101) {
        this.f52718a = r100;
        this.f52719b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DownloadActionHelper r101 = this.f52718a;
        p r102 = this.f52719b;
        com.bytedance.android.gamecp.business.api.response.e r103 = (com.bytedance.android.gamecp.business.api.response.e) ((com.bytedance.android.gamecp.base.network.response.i) r100).data;
        DownloadActionHelper.a(r101, r102, r103.result, r103.status);
    }
}
