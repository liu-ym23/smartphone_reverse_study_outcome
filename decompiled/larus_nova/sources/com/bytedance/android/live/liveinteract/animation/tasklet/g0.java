package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebPAnimationTasklet f71192a;

    public g0(WebPAnimationTasklet r100) {
        this.f71192a = r100;
    }

    public final void a() {
        WebPAnimationTasklet.b(this.f71192a).setController(null);
        WebPAnimationTasklet.b(this.f71192a).setVisibility(8);
        FrameLayout r100 = this.f71192a.f71155d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L5:
        r100.removeView(WebPAnimationTasklet.b(this.f71192a));
        WebPAnimationTasklet r101 = this.f71192a;
        r101.f71161j.a(WebPAnimationTasklet.b(r101));
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
