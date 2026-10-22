package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes44.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f52940a;

    public u(p r100) {
        this.f52940a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        long r102 = System.currentTimeMillis();
        AtomicBoolean r103 = DownloadListManager.f52326a;
        if ((r102 - DownloadListManager.f52332g) > 1000) goto L5;
    L7:
        DownloadListManager.f52332g = r102;
        return;
    L5:
        if ((r101.intValue() - DownloadListManager.f52331f) < 1) goto L7;
        DownloadListManager.f52331f = r101.intValue();
        DownloadListManager.f(this.f52940a);
        goto L7
    }
}
