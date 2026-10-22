package com.bytedance.android.shopping.buynow.controller;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.bytedance.android.shopping.anchorv4.helper.a0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f170854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f170855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f170856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window f170857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f170858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f170859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f170860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f170861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f170862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f170863j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f170864a;

        public a(q r100) {
            this.f170864a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f170864a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.f170861h == true) goto L5;
        return;
    L5:
        if (this.f170854a == false) goto L15;
        View r100 = this.f170859f;
        if (r100 == null) goto L9;
        r100.setVisibility(4);
    L9:
        this.f170855b = false;
        this.f170854a = false;
        View r101 = this.f170860g;
        if (r101 == null) goto L12;
        r101.setVisibility(0);
    L12:
        Handler r102 = new Handler(Looper.getMainLooper());
        this.f170856c = r102;
        r102.postDelayed(new a(this), this.f170862i);
        return;
    }

    public final void b() {
        if (this.f170861h == true) goto L5;
        return;
    L5:
        if (this.f170855b == true) goto L24;
        View r100 = this.f170860g;
        if (r100 == null) goto L9;
        r100.setVisibility(8);
    L9:
        View r101 = this.f170859f;
        if (r101 == null) goto L12;
        r101.setVisibility(0);
    L12:
        this.f170855b = true;
        Window r102 = this.f170857d;
        if (r102 == null) goto L15;
        r102.addFlags(2);
    L15:
        float r103 = ul.g.a(this.f170858e);
        Window r104 = this.f170857d;
        if (r104 == null) goto L18;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, r103});
        r105.setDuration(390);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new r(r104));
        r105.start();
    L18:
        TranslateAnimation r106 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r106.setDuration(390);
        r106.setInterpolator(new a0());
        View r107 = this.f170859f;
        if (r107 == null) goto L21;
        r107.startAnimation(r106);
    L21:
        this.f170863j.invoke();
        return;
    }

    public q(Window r100, View r101, View r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r103, "panelShowCallback");
        this.f170857d = r100;
        this.f170858e = 0.8f;
        this.f170859f = r101;
        this.f170860g = r102;
        this.f170861h = false;
        this.f170862i = 1500;
        this.f170863j = r103;
        this.f170854a = true;
        this.f170855b = true;
    }
}
