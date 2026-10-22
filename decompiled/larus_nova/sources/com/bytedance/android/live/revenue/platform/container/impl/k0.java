package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f91303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.platform.aio.channel.b f91304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f91305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f91306d;

    public k0(h0 r100, AbstractChannelClient.a r101, String r102, String r103) {
        this.f91303a = r100;
        this.f91304b = r101;
        this.f91305c = r102;
        this.f91306d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Pair<View, String> r102 = this.f91303a.f91273e.invoke();
        View r103 = r102.component1();
        String r104 = r102.component2();
        int r105 = d.f91211a;
        d.d(r103, r104, this.f91304b.getChannelId(), this.f91305c, this.f91306d, r101);
        jy0.b.c("RevenueJsMethodServer", "write err " + this.f91305c + ", methodId: " + this.f91306d + tb2.c.DEFAULT_TEXT + r101, null, 4);
    }
}
