package com.bytedance.android.window.shop.home.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f188663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f188664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f188665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f188666d;

    public z0(a1 r100, float r101, long r102, int r103) {
        this.f188663a = r100;
        this.f188664b = r101;
        this.f188665c = r102;
        this.f188666d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r100 = this.f188663a.f188493d.getProgress();     // Catch: Throwable -> L10
        float r101 = this.f188664b;     // Catch: Throwable -> L10
        if (r100 == r101) goto L13;
        a1 r102 = this.f188663a;     // Catch: Throwable -> L10
        long r103 = this.f188665c;     // Catch: Throwable -> L10
        int r104 = this.f188666d - 1;     // Catch: Throwable -> L10
        LottieAnimationView r105 = r102.f188493d;     // Catch: Throwable -> L10
        if (r105 == null) goto L17;
        if (r104 <= 0) goto L18;
        r105.setProgress(r101);     // Catch: Throwable -> L10
        r102.f188493d.postDelayed(new z0(r102, r101, r103, r104), r103);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
