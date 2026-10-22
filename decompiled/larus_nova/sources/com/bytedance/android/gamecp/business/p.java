package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.base.core.service.depend.r;
import com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f56193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f56194b;

    public p(int r100, LiveHostGameCP.C100361 r101) {
        this.f56193a = r100;
        this.f56194b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("GameCPService", "setDownloadPlayerRankStatus curStatus: " + this.f56193a + ", error: " + ((Throwable) r100));
        r r101 = this.f56194b;
        if (r101 == null) goto L6;
        r101.onStatusChanged(-1);
        return;
    }
}
