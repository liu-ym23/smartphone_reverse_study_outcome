package com.bytedance.android.gamecp.business.download;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52957a;

    public w(int r100) {
        this.f52957a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("UpdateDownloadStatus", "status: " + this.f52957a + ", error: " + ((Throwable) r100));
    }
}
