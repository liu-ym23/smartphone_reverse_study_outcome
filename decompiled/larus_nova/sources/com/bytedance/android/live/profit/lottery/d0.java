package com.bytedance.android.live.profit.lottery;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;

/* JADX INFO: loaded from: classes47.dex */
public final class d0<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f88058a;

    public d0(com.bytedance.android.live.revenue.common.g r100) {
        this.f88058a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Throwable r102 = (Throwable) r101;
        if (((v.a) r100) == null) goto L5;
        this.f88058a.b(VideoEventOneOutSync.END_TYPE_FINISH);
        return;
    L5:
        this.f88058a.c(r102);
    }
}
