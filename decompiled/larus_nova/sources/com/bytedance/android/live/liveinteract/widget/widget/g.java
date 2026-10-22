package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.b f81065a;

    public g(f.b r100) {
        this.f81065a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super.onAnimationFrame(r100, r101);
        if (r101 != (r100.getFrameCount() - 1)) goto L11;
        HSImageView r102 = (HSImageView) this.f81065a.f81064a.a(R.id.ttlive_animationView);
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        HSImageView r103 = (HSImageView) this.f81065a.f81064a.a(R.id.ttlive_animationView);
        if (r103 == null) goto L12;
        r103.setController(null);
        return;
    L12:
        return;
    }
}
