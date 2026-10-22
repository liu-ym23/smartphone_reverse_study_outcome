package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f72235a;

    public l(m.a r100) {
        this.f72235a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        this.f72235a.f72333a.setVisibility(8);
    }
}
