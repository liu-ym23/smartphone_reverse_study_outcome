package com.bytedance.android.live.liveinteract.banner;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerWidget f71644a;

    public b(BannerWidget r100) {
        this.f71644a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("BannerWidget", "getActivityLinks failed", (Throwable) r100);
        BannerWidget.a r101 = this.f71644a.f71640h;
        if (r101 == null) goto L6;
        r101.b(false, null);
        return;
    }
}
