package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f69539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f69540b;

    public n(long r100, Function1 r101) {
        this.f69539a = r100;
        this.f69540b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.d.b(LinkMonitorData.ApiGetSongList, System.currentTimeMillis() - this.f69539a, r101.logId);
        this.f69540b.invoke(r101);
    }
}
