package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f52701a = null;

    static {
        f52701a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("UpdateDownloadStatus", "error: " + ((Throwable) r100));
    }
}
