package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.base.core.service.depend.r;
import com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f56188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f56189b;

    public o(LiveHostGameCP.C100361 r100, int r101) {
        this.f56188a = r100;
        this.f56189b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
        r r102 = this.f56188a;
        if (r102 == null) goto L6;
        r102.onStatusChanged(this.f56189b);
        return;
    }
}
