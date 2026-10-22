package com.bytedance.android.live.liveinteract.animation.tasklet;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f71163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71164b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f71165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnimatedDrawable2 f71166b;

        public a(a0 r100, AnimatedDrawable2 r101) {
            this.f71165a = r100;
            this.f71166b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a0 r100 = this.f71165a;     // Catch: Throwable -> L4
            z r101 = r100.f71163a;     // Catch: Throwable -> L4
            HSImageView r102 = r100.f71164b;     // Catch: Throwable -> L4
            AnimatedDrawable2 r103 = this.f71166b;     // Catch: Throwable -> L4
            int r104 = z.f71265i;     // Catch: Throwable -> L4
            r101.b(r102, r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        z r101 = this.f71163a;
        r101.getClass();
        StringBuilder r102 = new StringBuilder("onAnimationStart.Tasklet:");
        r102.append(r101.hashCode());
        r102.append(",drawable:");
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        r102.append(r103);
        ALogger.d("InteractAnimation.SenderSeatTasklet", r102.toString());
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        this.f71164b.post(new a(this, r100));
    }

    public a0(z r100, HSImageView r101) {
        this.f71163a = r100;
        this.f71164b = r101;
    }
}
