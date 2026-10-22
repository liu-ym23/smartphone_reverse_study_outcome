package com.bytedance.android.livesdk.chatroom.replay.hdr;

import com.bytedance.android.live.core.log.ALogger;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f108740a;

    public b(c r100) {
        this.f108740a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        ALogger.d("VSHDRWidget", "onAnimationStop");
        this.f108740a.f108741a.invoke();
    }
}
