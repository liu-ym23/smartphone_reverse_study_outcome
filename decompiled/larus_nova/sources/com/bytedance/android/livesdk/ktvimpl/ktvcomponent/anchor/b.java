package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f144002a;

    public b(long r100) {
        this.f144002a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAnchorLogicWidget: fetchKtvComponentSetting, failure, logId=" + ke2.a.c(r101));
        mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.APIGetKtvComponentSetting, System.currentTimeMillis() - this.f144002a, r101);
    }
}
