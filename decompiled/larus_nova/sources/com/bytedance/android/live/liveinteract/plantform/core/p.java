package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f76309a;

    public p(long r100) {
        this.f76309a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        long r101 = System.currentTimeMillis() - this.f76309a;
        InteractLinkFullLinkMonitor.w("live_end", r101, (Throwable) r100);
    }
}
