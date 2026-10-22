package com.bytedance.android.livesdk.ktvimpl.base.view;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f143654a;

    public e(KtvGroupListDialogFragment r100, long r101) {
        this.f143654a = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        String r102 = "getKtvGroupUser error " + r101.getMessage();
        ALogger.i(bb0.b.b(), r102 + ", invoke class :KtvGroupListDialogFragment");
        mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.ApiGetLinkmicGroupUser, System.currentTimeMillis() - this.f143654a, r101);
    }
}
