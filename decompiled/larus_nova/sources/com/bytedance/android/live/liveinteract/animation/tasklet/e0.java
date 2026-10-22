package com.bytedance.android.live.liveinteract.animation.tasklet;

import com.bytedance.android.live.core.log.ALogger;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e0 extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f71181a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f71182a;

        public a(e0 r100) {
            this.f71182a = r100;
        }

        public final void a() {
            WebPAnimationTasklet r100 = this.f71182a.f71181a.f71189a;
            if (r100.f71158g == true) goto L6;
            WebPAnimationTasklet.c(r100);
            ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStop#" + this.f71182a.f71181a.f71189a.hashCode() + " cause timeout.");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e0(f0 r100) {
        this.f71181a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStart#" + this.f71181a.f71189a.hashCode());
        WebPAnimationTasklet r101 = this.f71181a.f71189a;
        Function2<d, Boolean, Unit> r102 = r101.f71162k;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r101, Boolean.TRUE);
    L5:
        WebPAnimationTasklet.b(this.f71181a.f71189a).postDelayed(new a(this), 10000);
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        WebPAnimationTasklet r101 = this.f71181a.f71189a;
        Function2<d, Boolean, Unit> r102 = r101.f71162k;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r101, Boolean.FALSE);
    L5:
        WebPAnimationTasklet.c(this.f71181a.f71189a);
        ALogger.d("InteractAnimation.WebPAnimationTasklet", "onAnimationStop#" + this.f71181a.f71189a.hashCode());
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (r101 < (r100.getFrameCount() - 1)) goto L6;
        r100.stop();
        return;
    }
}
