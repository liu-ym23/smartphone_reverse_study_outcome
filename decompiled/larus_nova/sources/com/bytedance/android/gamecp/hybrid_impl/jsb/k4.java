package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.network.preload.PreloadManager;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes44.dex */
public final class k4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreloadManager.b f57524a;

    public k4(l4 r100) {
        this.f57524a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        yr.c.b("PreloadManager", "error : " + r101);
        if ((r101 instanceof TimeoutException) == false) goto L5;
        this.f57524a.T0();
        return;
    L5:
        this.f57524a.onError(-2);
    }
}
