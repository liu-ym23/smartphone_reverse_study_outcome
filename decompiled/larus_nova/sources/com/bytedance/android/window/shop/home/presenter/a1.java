package com.bytedance.android.window.shop.home.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f188490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f188491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<Boolean, Boolean> f188492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieAnimationView f188493d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a1 f188494a;

        public a(a1 r100) {
            this.f188494a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a1 r100 = this.f188494a;     // Catch: Throwable -> L6
            r100.f188491b = true;     // Catch: Throwable -> L6
            Pair<Boolean, Boolean> r101 = r100.f188492c;     // Catch: Throwable -> L6
            r100.f188492c = null;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r100.a(r101.getFirst().booleanValue(), r101.getSecond().booleanValue());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public a1(LottieAnimationView r100) {
        this.f188493d = r100;
        this.f188490a = -1.0f;
    }

    public final void a(boolean r110, boolean r111) {
        if (this.f188491b == true) goto L13;
        Pair<Boolean, Boolean> r100 = this.f188492c;
        if (r100 != null) goto L7;
    L8:
        this.f188492c = new Pair(Boolean.valueOf(r110), Boolean.valueOf(r111));
    L9:
        LottieAnimationView r112 = this.f188493d;
        if (r112 == null) goto L32;
        r112.post(new a(this));
        return;
    L32:
        return;
    L7:
        if (r100.getFirst().booleanValue() == r110) goto L9;
    L13:
        if (r110 == false) goto L15;
        float r101 = 1.0f;
    L17:
        if (this.f188490a != r101) goto L19;
        return;
    L19:
        this.f188490a = r101;
        if (r110 == false) goto L28;
        if (r111 == false) goto L25;
        LottieAnimationView r113 = this.f188493d;
        if (r113 == null) goto L33;
        r113.playAnimation();
        return;
    L33:
        return;
    L25:
        LottieAnimationView r114 = this.f188493d;
        if (r114 == null) goto L35;
        r114.setProgress(r101);
        this.f188493d.postDelayed(new z0(this, r101, 500, 5), 500);
        return;
    L35:
        return;
    L28:
        LottieAnimationView r115 = this.f188493d;
        if (r115 == null) goto L37;
        r115.setProgress(r101);
        this.f188493d.postDelayed(new z0(this, r101, 500, 5), 500);
        return;
    L37:
        return;
    L15:
        r101 = 0.0f;
        goto L17
    }
}
