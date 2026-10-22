package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import android.view.animation.Animation;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractAudienceGuestInviteDialog f73649a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public a(InteractAudienceGuestInviteDialog r100) {
        this.f73649a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        InteractAudienceGuestInviteDialog r101 = this.f73649a;
        Animation r102 = r101.f73638g;
        if (r102 == null) goto L8;
        HSImageView r103 = (HSImageView) r101.S90(R.id.head);
        if (r103 == null) goto L9;
        r103.startAnimation(r102);
        return;
    L9:
        return;
    }
}
