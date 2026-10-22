package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f92170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f92171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f92172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AnimatedDrawable2 f92173d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f92174a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f92174a.f92171b.f92181a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r100) {
            this.f92174a = r100;
        }
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        this.f92171b.f92181a.d();
        f r101 = this.f92171b.f92182b;
        r101.sendMessageDelayed(r101.obtainMessage(1, new a(this)), ((Number) o.f92184b.getValue(null, o.f92183a[0])).longValue());
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        if (r101 >= this.f92170a) goto L5;
    L6:
        this.f92173d.stop();
    L7:
        this.f92170a = r101;
        return;
    L5:
        if (r101 < (this.f92172c - 1)) goto L7;
        goto L6
    }

    public l(n r100, int r101, AnimatedDrawable2 r102) {
        this.f92171b = r100;
        this.f92172c = r101;
        this.f92173d = r102;
        this.f92170a = -1;
    }
}
