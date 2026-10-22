package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f76308a;

    public o(long r100) {
        this.f76308a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        InteractLinkFullLinkMonitor.x("live_end", System.currentTimeMillis() - this.f76308a, ((com.bytedance.android.live.network.response.e) r100).logId);
    }
}
