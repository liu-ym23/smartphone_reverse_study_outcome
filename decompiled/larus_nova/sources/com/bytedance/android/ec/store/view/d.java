package com.bytedance.android.ec.store.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.bytedance.android.ec.core.utils.s0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFlowLightMarqueeView f48929a;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f48930a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        public a(d r100) {
            this.f48930a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f48930a.f48929a.f48770s = false;
            s0.a(new t());
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f48930a.f48929a.f48770s = false;
            s0.a(new t());
        }
    }

    public d(ECShopFlowLightMarqueeView r100) {
        this.f48929a = r100;
    }

    public final void a() {
        AnimatorSet r100 = new AnimatorSet();
        r100.playSequentially(new Animator[]{ECShopFlowLightMarqueeView.a(this.f48929a), ECShopFlowLightMarqueeView.c(this.f48929a), ECShopFlowLightMarqueeView.b(this.f48929a)});
        ECShopFlowLightMarqueeView.b(this.f48929a).addListener(new a(this));
        r100.start();
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
