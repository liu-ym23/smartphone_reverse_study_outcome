package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f69527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f69528b;

    public h(long r100, Function1 r101) {
        this.f69527a = r100;
        this.f69528b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.d.b(LinkMonitorData.ApiGetHotWords, System.currentTimeMillis() - this.f69527a, r101.logId);
        this.f69528b.invoke(r101);
    }
}
