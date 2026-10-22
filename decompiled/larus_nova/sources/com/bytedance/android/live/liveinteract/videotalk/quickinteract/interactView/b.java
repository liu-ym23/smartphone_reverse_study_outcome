package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a f79600a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f79601a;

        public a(b r100) {
            this.f79601a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r100 = this.f79601a.f79600a;     // Catch: Throwable -> L4
            r100.f79588o.a(r100.f79579f.f79609d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public b(com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r100) {
        this.f79600a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r101 = this.f79600a;
        r101.f79582i = null;
        r101.f79585l = false;
        r101.f79583j = 0;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r102 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
        if (r102 == null) goto L5;
        r102.F6();
    L5:
        this.f79600a.f79574a.post(new a(this));
    }
}
