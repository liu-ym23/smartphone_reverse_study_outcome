package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f52706a = null;

    static {
        f52706a = new f0();
    }

    public f0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("UpdateDownloadStatus", "error: " + ((Throwable) r100));
    }
}
