package com.bytedance.android.live.liveinteract;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f71631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animatable f71632b;

    public b(int r100, Animatable r101) {
        this.f71631a = r100;
        this.f71632b = r101;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super.onAnimationFrame(r100, r101);
        if (r101 != (this.f71631a - 1)) goto L6;
        this.f71632b.stop();
        return;
    }
}
