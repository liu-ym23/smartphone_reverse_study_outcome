package com.bytedance.android.gamecp.business.download;

import android.os.SystemClock;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadActionHelper f52795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52796b;

    public k(DownloadActionHelper r100, p r101) {
        this.f52795a = r100;
        this.f52796b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        DownloadActionHelper r102 = this.f52795a;
        r102.f52315e = false;
        r102.h(this.f52796b, 1040, 0L);
        DownloadActionHelper r103 = this.f52795a;
        r103.f52316f = SystemClock.uptimeMillis();
    }
}
