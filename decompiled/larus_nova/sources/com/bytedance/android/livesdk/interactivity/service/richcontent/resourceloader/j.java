package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieListener;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements LottieListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob2.e f140984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140985b;

    public j(ob2.e r100, hk6.d r101) {
        this.f140984a = r100;
        this.f140985b = r101;
    }

    @Override // com.airbnb.lottie.LottieListener
    public final void onResult(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("LiveLottieResourceLoader, load lottie resource failed " + this.f140984a, r101);
        hk6.b.a.C6158a.a(this.f140985b, null, r101, 1);
    }
}
