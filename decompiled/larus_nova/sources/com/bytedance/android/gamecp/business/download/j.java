package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadActionHelper f52789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52790b;

    public j(DownloadActionHelper r100, p r101) {
        this.f52789a = r100;
        this.f52790b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("checkSharkResult", "error: " + ((Throwable) r100));
        DownloadActionHelper r101 = this.f52789a;
        p r102 = this.f52790b;
        DownloadActionHelper.a(r101, r102, "pass", Long.valueOf(r102.f52880w0));
    }
}
