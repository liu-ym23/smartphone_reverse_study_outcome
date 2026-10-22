package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f0 extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f70976a;

    public f0(g0 r100) {
        this.f70976a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        ALogger.i("interact_emoji", "receiver animation stop");
        HSImageView r101 = this.f70976a.f70977a.f71388h;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r101);
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (r101 < (r100.getFrameCount() - 1)) goto L6;
        r100.stop();
        return;
    }
}
