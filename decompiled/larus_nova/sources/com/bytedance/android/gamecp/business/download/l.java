package com.bytedance.android.gamecp.business.download;

import android.os.SystemClock;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadActionHelper f52801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52802b;

    public l(DownloadActionHelper r100, p r101) {
        this.f52801a = r100;
        this.f52802b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f52801a.f52313c = false;
        long r100 = SystemClock.uptimeMillis();
        DownloadActionHelper r101 = this.f52801a;
        long r102 = r100 - r101.f52316f;
        p r103 = this.f52802b;
        if (r101.f52315e == false) goto L5;
        int r104 = 1041;
    L6:
        r101.h(r103, r104, Long.valueOf(r102));
        return;
    L5:
        r104 = 1042;
        goto L6
    }
}
